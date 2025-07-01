package org.apache.commons.io;

import java.io.File;
import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.util.Collection;
import java.util.Vector;

/* loaded from: classes4.dex */
public class FileCleaningTracker {
    Thread reaper;
    ReferenceQueue q = new ReferenceQueue();
    final Collection trackers = new Vector();
    volatile boolean exitWhenFinished = false;

    public void track(File file, Object obj) {
        track(file, obj, (FileDeleteStrategy) null);
    }

    public void track(File file, Object obj, FileDeleteStrategy fileDeleteStrategy) {
        if (file == null) {
            throw new NullPointerException("The file must not be null");
        }
        addTracker(file.getPath(), obj, fileDeleteStrategy);
    }

    public void track(String str, Object obj) {
        track(str, obj, (FileDeleteStrategy) null);
    }

    public void track(String str, Object obj, FileDeleteStrategy fileDeleteStrategy) {
        if (str == null) {
            throw new NullPointerException("The path must not be null");
        }
        addTracker(str, obj, fileDeleteStrategy);
    }

    private synchronized void addTracker(String str, Object obj, FileDeleteStrategy fileDeleteStrategy) {
        if (this.exitWhenFinished) {
            throw new IllegalStateException("No new trackers can be added once exitWhenFinished() is called");
        }
        if (this.reaper == null) {
            Reaper reaper = new Reaper(this);
            this.reaper = reaper;
            reaper.start();
        }
        this.trackers.add(new Tracker(str, fileDeleteStrategy, obj, this.q));
    }

    public int getTrackCount() {
        return this.trackers.size();
    }

    public synchronized void exitWhenFinished() {
        this.exitWhenFinished = true;
        Thread thread = this.reaper;
        if (thread != null) {
            synchronized (thread) {
                this.reaper.interrupt();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public final class Reaper extends Thread {
        private final /* synthetic */ FileCleaningTracker this$0;

        Reaper(FileCleaningTracker fileCleaningTracker) {
            super("File Reaper");
            this.this$0 = fileCleaningTracker;
            setPriority(10);
            setDaemon(true);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            while (true) {
                if (this.this$0.exitWhenFinished && this.this$0.trackers.size() <= 0) {
                    return;
                }
                try {
                    Tracker tracker = (Tracker) this.this$0.q.remove();
                    if (tracker != null) {
                        tracker.delete();
                        tracker.clear();
                        this.this$0.trackers.remove(tracker);
                    }
                } catch (Exception unused) {
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static final class Tracker extends PhantomReference {
        private final FileDeleteStrategy deleteStrategy;
        private final String path;

        Tracker(String str, FileDeleteStrategy fileDeleteStrategy, Object obj, ReferenceQueue referenceQueue) {
            super(obj, referenceQueue);
            this.path = str;
            this.deleteStrategy = fileDeleteStrategy == null ? FileDeleteStrategy.NORMAL : fileDeleteStrategy;
        }

        public boolean delete() {
            return this.deleteStrategy.deleteQuietly(new File(this.path));
        }
    }
}
