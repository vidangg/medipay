package io.flutter.plugins.firebase.messaging;

import android.app.Service;
import android.app.job.JobInfo;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobServiceEngine;
import android.app.job.JobWorkItem;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.PowerManager;
import android.util.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public abstract class JobIntentService extends Service {
    static final boolean DEBUG = false;
    static final String TAG = "JobIntentService";
    WorkEnqueuer mCompatWorkEnqueuer;
    CommandProcessor mCurProcessor;
    CompatJobEngine mJobImpl;
    static final Object sLock = new Object();
    static final HashMap<ComponentNameWithWakeful, WorkEnqueuer> sClassWorkEnqueuer = new HashMap<>();
    boolean mStopped = false;
    boolean mDestroyed = false;
    final ArrayList<CompatWorkItem> mCompatQueue = new ArrayList<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public interface CompatJobEngine {
        IBinder compatGetBinder();

        GenericWorkItem dequeueWork();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public interface GenericWorkItem {
        void complete();

        Intent getIntent();
    }

    protected abstract void onHandleWork(Intent intent);

    public boolean onStopCurrentWork() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class ComponentNameWithWakeful {
        private ComponentName componentName;
        private boolean useWakefulService;

        ComponentNameWithWakeful(ComponentName componentName, boolean z) {
            this.componentName = componentName;
            this.useWakefulService = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static abstract class WorkEnqueuer {
        final ComponentName mComponentName;
        boolean mHasJobId;
        int mJobId;

        abstract void enqueueWork(Intent intent);

        public void serviceProcessingFinished() {
        }

        public void serviceProcessingStarted() {
        }

        public void serviceStartReceived() {
        }

        WorkEnqueuer(ComponentName componentName) {
            this.mComponentName = componentName;
        }

        void ensureJobId(int i) {
            if (!this.mHasJobId) {
                this.mHasJobId = true;
                this.mJobId = i;
            } else {
                if (this.mJobId == i) {
                    return;
                }
                throw new IllegalArgumentException("Given job ID " + i + " is different than previous " + this.mJobId);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static final class CompatWorkEnqueuer extends WorkEnqueuer {
        private final Context mContext;
        private final PowerManager.WakeLock mLaunchWakeLock;
        boolean mLaunchingService;
        private final PowerManager.WakeLock mRunWakeLock;
        boolean mServiceProcessing;

        CompatWorkEnqueuer(Context context, ComponentName componentName) {
            super(componentName);
            this.mContext = context.getApplicationContext();
            PowerManager powerManager = (PowerManager) context.getSystemService("power");
            PowerManager.WakeLock newWakeLock = powerManager.newWakeLock(1, componentName.getClassName() + ":launch");
            this.mLaunchWakeLock = newWakeLock;
            newWakeLock.setReferenceCounted(false);
            PowerManager.WakeLock newWakeLock2 = powerManager.newWakeLock(1, componentName.getClassName() + ":run");
            this.mRunWakeLock = newWakeLock2;
            newWakeLock2.setReferenceCounted(false);
        }

        @Override // io.flutter.plugins.firebase.messaging.JobIntentService.WorkEnqueuer
        void enqueueWork(Intent intent) {
            Intent intent2 = new Intent(intent);
            intent2.setComponent(this.mComponentName);
            if (this.mContext.startService(intent2) != null) {
                synchronized (this) {
                    if (!this.mLaunchingService) {
                        this.mLaunchingService = true;
                        if (!this.mServiceProcessing) {
                            this.mLaunchWakeLock.acquire(60000L);
                        }
                    }
                }
            }
        }

        @Override // io.flutter.plugins.firebase.messaging.JobIntentService.WorkEnqueuer
        public void serviceStartReceived() {
            synchronized (this) {
                this.mLaunchingService = false;
            }
        }

        @Override // io.flutter.plugins.firebase.messaging.JobIntentService.WorkEnqueuer
        public void serviceProcessingStarted() {
            synchronized (this) {
                if (!this.mServiceProcessing) {
                    this.mServiceProcessing = true;
                    this.mRunWakeLock.acquire(600000L);
                    this.mLaunchWakeLock.release();
                }
            }
        }

        @Override // io.flutter.plugins.firebase.messaging.JobIntentService.WorkEnqueuer
        public void serviceProcessingFinished() {
            synchronized (this) {
                if (this.mServiceProcessing) {
                    if (this.mLaunchingService) {
                        this.mLaunchWakeLock.acquire(60000L);
                    }
                    this.mServiceProcessing = false;
                    this.mRunWakeLock.release();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    static final class JobServiceEngineImpl extends JobServiceEngine implements CompatJobEngine {
        static final boolean DEBUG = false;
        static final String TAG = "JobServiceEngineImpl";
        final Object mLock;
        JobParameters mParams;
        final JobIntentService mService;

        /* loaded from: classes4.dex */
        final class WrapperWorkItem implements GenericWorkItem {
            final JobWorkItem mJobWork;

            WrapperWorkItem(JobWorkItem jobWorkItem) {
                this.mJobWork = jobWorkItem;
            }

            @Override // io.flutter.plugins.firebase.messaging.JobIntentService.GenericWorkItem
            public Intent getIntent() {
                return this.mJobWork.getIntent();
            }

            @Override // io.flutter.plugins.firebase.messaging.JobIntentService.GenericWorkItem
            public void complete() {
                synchronized (JobServiceEngineImpl.this.mLock) {
                    if (JobServiceEngineImpl.this.mParams != null) {
                        try {
                            JobServiceEngineImpl.this.mParams.completeWork(this.mJobWork);
                        } catch (IllegalArgumentException e) {
                            Log.e(JobServiceEngineImpl.TAG, "IllegalArgumentException: Failed to run mParams.completeWork(mJobWork)!", e);
                        } catch (SecurityException e2) {
                            Log.e(JobServiceEngineImpl.TAG, "SecurityException: Failed to run mParams.completeWork(mJobWork)!", e2);
                        }
                    }
                }
            }
        }

        JobServiceEngineImpl(JobIntentService jobIntentService) {
            super(jobIntentService);
            this.mLock = new Object();
            this.mService = jobIntentService;
        }

        @Override // io.flutter.plugins.firebase.messaging.JobIntentService.CompatJobEngine
        public IBinder compatGetBinder() {
            return getBinder();
        }

        @Override // android.app.job.JobServiceEngine
        public boolean onStartJob(JobParameters jobParameters) {
            this.mParams = jobParameters;
            this.mService.ensureProcessorRunningLocked(false);
            return true;
        }

        @Override // android.app.job.JobServiceEngine
        public boolean onStopJob(JobParameters jobParameters) {
            boolean doStopCurrentWork = this.mService.doStopCurrentWork();
            synchronized (this.mLock) {
                this.mParams = null;
            }
            return doStopCurrentWork;
        }

        @Override // io.flutter.plugins.firebase.messaging.JobIntentService.CompatJobEngine
        public GenericWorkItem dequeueWork() {
            synchronized (this.mLock) {
                JobParameters jobParameters = this.mParams;
                if (jobParameters == null) {
                    return null;
                }
                try {
                    JobWorkItem dequeueWork = jobParameters.dequeueWork();
                    if (dequeueWork == null) {
                        return null;
                    }
                    dequeueWork.getIntent().setExtrasClassLoader(this.mService.getClassLoader());
                    return new WrapperWorkItem(dequeueWork);
                } catch (SecurityException e) {
                    Log.e(TAG, "Failed to run mParams.dequeueWork()!", e);
                    return null;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static final class JobWorkEnqueuer extends WorkEnqueuer {
        private final JobInfo mJobInfo;
        private final JobScheduler mJobScheduler;

        JobWorkEnqueuer(Context context, ComponentName componentName, int i) {
            super(componentName);
            ensureJobId(i);
            this.mJobInfo = new JobInfo.Builder(i, this.mComponentName).setOverrideDeadline(0L).build();
            this.mJobScheduler = (JobScheduler) context.getApplicationContext().getSystemService("jobscheduler");
        }

        @Override // io.flutter.plugins.firebase.messaging.JobIntentService.WorkEnqueuer
        void enqueueWork(Intent intent) {
            this.mJobScheduler.enqueue(this.mJobInfo, new JobWorkItem(intent));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public final class CompatWorkItem implements GenericWorkItem {
        final Intent mIntent;
        final int mStartId;

        CompatWorkItem(Intent intent, int i) {
            this.mIntent = intent;
            this.mStartId = i;
        }

        @Override // io.flutter.plugins.firebase.messaging.JobIntentService.GenericWorkItem
        public Intent getIntent() {
            return this.mIntent;
        }

        @Override // io.flutter.plugins.firebase.messaging.JobIntentService.GenericWorkItem
        public void complete() {
            JobIntentService.this.stopSelf(this.mStartId);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public final class CommandProcessor {
        private final Executor executor = Executors.newSingleThreadExecutor();
        private final Handler handler = new Handler(Looper.getMainLooper());

        CommandProcessor() {
        }

        public void execute() {
            this.executor.execute(new Runnable() { // from class: io.flutter.plugins.firebase.messaging.JobIntentService.CommandProcessor.1
                @Override // java.lang.Runnable
                public void run() {
                    while (true) {
                        GenericWorkItem dequeueWork = JobIntentService.this.dequeueWork();
                        if (dequeueWork != null) {
                            JobIntentService.this.onHandleWork(dequeueWork.getIntent());
                            dequeueWork.complete();
                        } else {
                            CommandProcessor.this.handler.post(new Runnable() { // from class: io.flutter.plugins.firebase.messaging.JobIntentService.CommandProcessor.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    JobIntentService.this.processorFinished();
                                }
                            });
                            return;
                        }
                    }
                }
            });
        }

        public void cancel() {
            JobIntentService.this.processorFinished();
        }
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.mJobImpl = new JobServiceEngineImpl(this);
        this.mCompatWorkEnqueuer = null;
        this.mCompatWorkEnqueuer = getWorkEnqueuer(this, new ComponentName(this, getClass()), false, 0, true);
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        this.mCompatWorkEnqueuer.serviceStartReceived();
        synchronized (this.mCompatQueue) {
            ArrayList<CompatWorkItem> arrayList = this.mCompatQueue;
            if (intent == null) {
                intent = new Intent();
            }
            arrayList.add(new CompatWorkItem(intent, i2));
            ensureProcessorRunningLocked(true);
        }
        return 3;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        CompatJobEngine compatJobEngine = this.mJobImpl;
        if (compatJobEngine != null) {
            return compatJobEngine.compatGetBinder();
        }
        return null;
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        doStopCurrentWork();
        synchronized (this.mCompatQueue) {
            this.mDestroyed = true;
            this.mCompatWorkEnqueuer.serviceProcessingFinished();
        }
    }

    public static void enqueueWork(Context context, Class cls, int i, Intent intent, boolean z) {
        enqueueWork(context, new ComponentName(context, (Class<?>) cls), i, intent, z);
    }

    public static void enqueueWork(Context context, ComponentName componentName, int i, Intent intent, boolean z) {
        if (intent == null) {
            throw new IllegalArgumentException("work must not be null");
        }
        synchronized (sLock) {
            WorkEnqueuer workEnqueuer = getWorkEnqueuer(context, componentName, true, i, z);
            workEnqueuer.ensureJobId(i);
            try {
                workEnqueuer.enqueueWork(intent);
            } catch (IllegalStateException e) {
                if (z) {
                    getWorkEnqueuer(context, componentName, true, i, false).enqueueWork(intent);
                } else {
                    throw e;
                }
            }
        }
    }

    static WorkEnqueuer getWorkEnqueuer(Context context, ComponentName componentName, boolean z, int i, boolean z2) {
        WorkEnqueuer compatWorkEnqueuer;
        ComponentNameWithWakeful componentNameWithWakeful = new ComponentNameWithWakeful(componentName, z2);
        HashMap<ComponentNameWithWakeful, WorkEnqueuer> hashMap = sClassWorkEnqueuer;
        WorkEnqueuer workEnqueuer = hashMap.get(componentNameWithWakeful);
        if (workEnqueuer != null) {
            return workEnqueuer;
        }
        if (z2) {
            compatWorkEnqueuer = new CompatWorkEnqueuer(context, componentName);
        } else {
            if (!z) {
                throw new IllegalArgumentException("Can't be here without a job id");
            }
            compatWorkEnqueuer = new JobWorkEnqueuer(context, componentName, i);
        }
        WorkEnqueuer workEnqueuer2 = compatWorkEnqueuer;
        hashMap.put(componentNameWithWakeful, workEnqueuer2);
        return workEnqueuer2;
    }

    public boolean isStopped() {
        return this.mStopped;
    }

    boolean doStopCurrentWork() {
        CommandProcessor commandProcessor = this.mCurProcessor;
        if (commandProcessor != null) {
            commandProcessor.cancel();
        }
        this.mStopped = true;
        return onStopCurrentWork();
    }

    void ensureProcessorRunningLocked(boolean z) {
        if (this.mCurProcessor == null) {
            this.mCurProcessor = new CommandProcessor();
            WorkEnqueuer workEnqueuer = this.mCompatWorkEnqueuer;
            if (workEnqueuer != null && z) {
                workEnqueuer.serviceProcessingStarted();
            }
            this.mCurProcessor.execute();
        }
    }

    void processorFinished() {
        ArrayList<CompatWorkItem> arrayList = this.mCompatQueue;
        if (arrayList != null) {
            synchronized (arrayList) {
                this.mCurProcessor = null;
                ArrayList<CompatWorkItem> arrayList2 = this.mCompatQueue;
                if (arrayList2 != null && arrayList2.size() > 0) {
                    ensureProcessorRunningLocked(false);
                } else if (!this.mDestroyed) {
                    this.mCompatWorkEnqueuer.serviceProcessingFinished();
                }
            }
        }
    }

    GenericWorkItem dequeueWork() {
        GenericWorkItem dequeueWork;
        CompatJobEngine compatJobEngine = this.mJobImpl;
        if (compatJobEngine != null && (dequeueWork = compatJobEngine.dequeueWork()) != null) {
            return dequeueWork;
        }
        synchronized (this.mCompatQueue) {
            if (this.mCompatQueue.size() > 0) {
                return this.mCompatQueue.remove(0);
            }
            return null;
        }
    }
}
