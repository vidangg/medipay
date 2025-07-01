package io.flutter.plugins.webviewflutter;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.media3.common.C;
import io.flutter.plugins.webviewflutter.WebViewProxyApi;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.WeakHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* compiled from: AndroidWebkitLibrary.g.kt */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0012\u0018\u0000 .2\u00020\u0001:\u0002./B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00012\u0006\u0010 \u001a\u00020\u0006J\u000e\u0010!\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u0001J\u0018\u0010\"\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00012\u0006\u0010 \u001a\u00020\u0006H\u0002J\u0006\u0010#\u001a\u00020\u001eJ\u0010\u0010$\u001a\u00020\u000f2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001J\u0017\u0010%\u001a\u0004\u0018\u00010\u00062\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010&J\u001b\u0010'\u001a\u0004\u0018\u0001H(\"\u0004\b\u0000\u0010(2\u0006\u0010 \u001a\u00020\u0006¢\u0006\u0002\u0010)J\u0006\u0010\u000e\u001a\u00020\u000fJ\b\u0010*\u001a\u00020\u001eH\u0002J\b\u0010+\u001a\u00020\u001eH\u0002J\u001b\u0010,\u001a\u0004\u0018\u0001H(\"\u0004\b\u0000\u0010(2\u0006\u0010 \u001a\u00020\u0006¢\u0006\u0002\u0010)J\u0006\u0010-\u001a\u00020\u001eR$\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00060\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00010\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\u0017\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0018j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0001`\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R6\u0010\u001a\u001a*\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u001b0\u0018j\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u001b`\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R6\u0010\u001c\u001a*\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u001b\u0012\u0004\u0012\u00020\u00060\u0018j\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u001b\u0012\u0004\u0012\u00020\u0006`\u0019X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Lio/flutter/plugins/webviewflutter/AndroidWebkitLibraryPigeonInstanceManager;", "", "finalizationListener", "Lio/flutter/plugins/webviewflutter/AndroidWebkitLibraryPigeonInstanceManager$PigeonFinalizationListener;", "(Lio/flutter/plugins/webviewflutter/AndroidWebkitLibraryPigeonInstanceManager$PigeonFinalizationListener;)V", "value", "", "clearFinalizedWeakReferencesInterval", "getClearFinalizedWeakReferencesInterval", "()J", "setClearFinalizedWeakReferencesInterval", "(J)V", "handler", "Landroid/os/Handler;", "hasFinalizationListenerStopped", "", "identifiers", "Ljava/util/WeakHashMap;", "nextIdentifier", "referenceQueue", "Ljava/lang/ref/ReferenceQueue;", "releaseAllFinalizedInstancesRunnable", "Ljava/lang/Runnable;", "strongInstances", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "weakInstances", "Ljava/lang/ref/WeakReference;", "weakReferencesToIdentifiers", "addDartCreatedInstance", "", "instance", "identifier", "addHostCreatedInstance", "addInstance", "clear", "containsInstance", "getIdentifierForStrongReference", "(Ljava/lang/Object;)Ljava/lang/Long;", "getInstance", ExifInterface.GPS_DIRECTION_TRUE, "(J)Ljava/lang/Object;", "logWarningIfFinalizationListenerHasStopped", "releaseAllFinalizedInstances", "remove", "stopFinalizationListener", "Companion", "PigeonFinalizationListener", "webview_flutter_android_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes4.dex */
public final class AndroidWebkitLibraryPigeonInstanceManager {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final long minHostCreatedIdentifier = 65536;
    private static final String tag = "PigeonInstanceManager";
    private long clearFinalizedWeakReferencesInterval;
    private final PigeonFinalizationListener finalizationListener;
    private final Handler handler;
    private boolean hasFinalizationListenerStopped;
    private final WeakHashMap<Object, Long> identifiers;
    private long nextIdentifier;
    private final ReferenceQueue<Object> referenceQueue;
    private final Runnable releaseAllFinalizedInstancesRunnable;
    private final HashMap<Long, Object> strongInstances;
    private final HashMap<Long, WeakReference<Object>> weakInstances;
    private final HashMap<WeakReference<Object>, Long> weakReferencesToIdentifiers;

    /* compiled from: AndroidWebkitLibrary.g.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lio/flutter/plugins/webviewflutter/AndroidWebkitLibraryPigeonInstanceManager$PigeonFinalizationListener;", "", "onFinalize", "", "identifier", "", "webview_flutter_android_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes4.dex */
    public interface PigeonFinalizationListener {
        void onFinalize(long identifier);
    }

    public AndroidWebkitLibraryPigeonInstanceManager(PigeonFinalizationListener finalizationListener) {
        Intrinsics.checkNotNullParameter(finalizationListener, "finalizationListener");
        this.finalizationListener = finalizationListener;
        this.identifiers = new WeakHashMap<>();
        this.weakInstances = new HashMap<>();
        this.strongInstances = new HashMap<>();
        this.referenceQueue = new ReferenceQueue<>();
        this.weakReferencesToIdentifiers = new HashMap<>();
        Handler handler = new Handler(Looper.getMainLooper());
        this.handler = handler;
        Runnable runnable = new Runnable() { // from class: io.flutter.plugins.webviewflutter.AndroidWebkitLibraryPigeonInstanceManager$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                AndroidWebkitLibraryPigeonInstanceManager.releaseAllFinalizedInstancesRunnable$lambda$0(AndroidWebkitLibraryPigeonInstanceManager.this);
            }
        };
        this.releaseAllFinalizedInstancesRunnable = runnable;
        this.nextIdentifier = 65536L;
        this.clearFinalizedWeakReferencesInterval = C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS;
        handler.postDelayed(runnable, C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void releaseAllFinalizedInstancesRunnable$lambda$0(AndroidWebkitLibraryPigeonInstanceManager this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.releaseAllFinalizedInstances();
    }

    public final long getClearFinalizedWeakReferencesInterval() {
        return this.clearFinalizedWeakReferencesInterval;
    }

    public final void setClearFinalizedWeakReferencesInterval(long j) {
        this.handler.removeCallbacks(this.releaseAllFinalizedInstancesRunnable);
        this.clearFinalizedWeakReferencesInterval = j;
        releaseAllFinalizedInstances();
    }

    /* compiled from: AndroidWebkitLibrary.g.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lio/flutter/plugins/webviewflutter/AndroidWebkitLibraryPigeonInstanceManager$Companion;", "", "()V", "minHostCreatedIdentifier", "", "tag", "", "create", "Lio/flutter/plugins/webviewflutter/AndroidWebkitLibraryPigeonInstanceManager;", "finalizationListener", "Lio/flutter/plugins/webviewflutter/AndroidWebkitLibraryPigeonInstanceManager$PigeonFinalizationListener;", "webview_flutter_android_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final AndroidWebkitLibraryPigeonInstanceManager create(PigeonFinalizationListener finalizationListener) {
            Intrinsics.checkNotNullParameter(finalizationListener, "finalizationListener");
            return new AndroidWebkitLibraryPigeonInstanceManager(finalizationListener);
        }
    }

    public final <T> T remove(long identifier) {
        logWarningIfFinalizationListenerHasStopped();
        Object androidWebkitLibraryPigeonInstanceManager = getInstance(identifier);
        if (androidWebkitLibraryPigeonInstanceManager instanceof WebViewProxyApi.WebViewPlatformView) {
            ((WebViewProxyApi.WebViewPlatformView) androidWebkitLibraryPigeonInstanceManager).destroy();
        }
        return (T) this.strongInstances.remove(Long.valueOf(identifier));
    }

    public final Long getIdentifierForStrongReference(Object instance) {
        logWarningIfFinalizationListenerHasStopped();
        Long l = this.identifiers.get(instance);
        if (l != null) {
            HashMap<Long, Object> hashMap = this.strongInstances;
            Intrinsics.checkNotNull(instance);
            hashMap.put(l, instance);
        }
        return l;
    }

    public final void addDartCreatedInstance(Object instance, long identifier) {
        Intrinsics.checkNotNullParameter(instance, "instance");
        logWarningIfFinalizationListenerHasStopped();
        addInstance(instance, identifier);
    }

    public final long addHostCreatedInstance(Object instance) {
        Intrinsics.checkNotNullParameter(instance, "instance");
        logWarningIfFinalizationListenerHasStopped();
        if (!(!containsInstance(instance))) {
            throw new IllegalArgumentException(("Instance of " + instance.getClass() + " has already been added.").toString());
        }
        long j = this.nextIdentifier;
        this.nextIdentifier = 1 + j;
        addInstance(instance, j);
        return j;
    }

    public final <T> T getInstance(long identifier) {
        logWarningIfFinalizationListenerHasStopped();
        WeakReference<Object> weakReference = this.weakInstances.get(Long.valueOf(identifier));
        if (weakReference != null) {
            return (T) weakReference.get();
        }
        return null;
    }

    public final boolean containsInstance(Object instance) {
        logWarningIfFinalizationListenerHasStopped();
        return this.identifiers.containsKey(instance);
    }

    public final void stopFinalizationListener() {
        this.handler.removeCallbacks(this.releaseAllFinalizedInstancesRunnable);
        this.hasFinalizationListenerStopped = true;
    }

    public final void clear() {
        this.identifiers.clear();
        this.weakInstances.clear();
        this.strongInstances.clear();
        this.weakReferencesToIdentifiers.clear();
    }

    /* renamed from: hasFinalizationListenerStopped, reason: from getter */
    public final boolean getHasFinalizationListenerStopped() {
        return this.hasFinalizationListenerStopped;
    }

    private final void releaseAllFinalizedInstances() {
        if (getHasFinalizationListenerStopped()) {
            return;
        }
        while (true) {
            WeakReference weakReference = (WeakReference) this.referenceQueue.poll();
            if (weakReference != null) {
                Long l = (Long) TypeIntrinsics.asMutableMap(this.weakReferencesToIdentifiers).remove(weakReference);
                if (l != null) {
                    this.weakInstances.remove(l);
                    this.strongInstances.remove(l);
                    this.finalizationListener.onFinalize(l.longValue());
                }
            } else {
                this.handler.postDelayed(this.releaseAllFinalizedInstancesRunnable, this.clearFinalizedWeakReferencesInterval);
                return;
            }
        }
    }

    private final void addInstance(Object instance, long identifier) {
        if (identifier < 0) {
            throw new IllegalArgumentException(("Identifier must be >= 0: " + identifier).toString());
        }
        if (!(!this.weakInstances.containsKey(Long.valueOf(identifier)))) {
            throw new IllegalArgumentException(("Identifier has already been added: " + identifier).toString());
        }
        WeakReference<Object> weakReference = new WeakReference<>(instance, this.referenceQueue);
        this.identifiers.put(instance, Long.valueOf(identifier));
        this.weakInstances.put(Long.valueOf(identifier), weakReference);
        this.weakReferencesToIdentifiers.put(weakReference, Long.valueOf(identifier));
        this.strongInstances.put(Long.valueOf(identifier), instance);
    }

    private final void logWarningIfFinalizationListenerHasStopped() {
        if (getHasFinalizationListenerStopped()) {
            Log.w(tag, "The manager was used after calls to the PigeonFinalizationListener has been stopped.");
        }
    }
}
