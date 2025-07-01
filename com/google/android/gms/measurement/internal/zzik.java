package com.google.android.gms.measurement.internal;

import android.os.Process;
import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Semaphore;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.4.0 */
/* loaded from: classes3.dex */
public final class zzik extends Thread {
    final /* synthetic */ zzil zza;
    private final Object zzb;
    private final BlockingQueue zzc;
    private boolean zzd = false;

    public zzik(zzil zzilVar, String str, BlockingQueue blockingQueue) {
        this.zza = zzilVar;
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(blockingQueue);
        this.zzb = new Object();
        this.zzc = blockingQueue;
        setName(str);
    }

    private final void zzb() {
        Object obj;
        Semaphore semaphore;
        Object obj2;
        zzik zzikVar;
        zzik zzikVar2;
        zzil zzilVar = this.zza;
        obj = zzilVar.zzh;
        synchronized (obj) {
            if (!this.zzd) {
                semaphore = zzilVar.zzi;
                semaphore.release();
                obj2 = zzilVar.zzh;
                obj2.notifyAll();
                zzikVar = zzilVar.zzb;
                if (this == zzikVar) {
                    zzilVar.zzb = null;
                } else {
                    zzikVar2 = zzilVar.zzc;
                    if (this != zzikVar2) {
                        zzilVar.zzu.zzaW().zze().zza("Current scheduler thread is neither worker nor network");
                    } else {
                        zzilVar.zzc = null;
                    }
                }
                this.zzd = true;
            }
        }
    }

    private final void zzc(InterruptedException interruptedException) {
        this.zza.zzu.zzaW().zzk().zzb(String.valueOf(getName()).concat(" was interrupted"), interruptedException);
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        Object obj;
        Semaphore semaphore;
        boolean z = false;
        while (!z) {
            try {
                semaphore = this.zza.zzi;
                semaphore.acquire();
                z = true;
            } catch (InterruptedException e) {
                zzc(e);
            }
        }
        try {
            int threadPriority = Process.getThreadPriority(Process.myTid());
            while (true) {
                BlockingQueue blockingQueue = this.zzc;
                zzij zzijVar = (zzij) blockingQueue.poll();
                if (zzijVar != null) {
                    Process.setThreadPriority(true != zzijVar.zza ? 10 : threadPriority);
                    zzijVar.run();
                } else {
                    Object obj2 = this.zzb;
                    synchronized (obj2) {
                        if (blockingQueue.peek() == null) {
                            zzil.zzs(this.zza);
                            try {
                                obj2.wait(30000L);
                            } catch (InterruptedException e2) {
                                zzc(e2);
                            }
                        }
                    }
                    obj = this.zza.zzh;
                    synchronized (obj) {
                        if (this.zzc.peek() == null) {
                            zzb();
                            return;
                        }
                    }
                }
            }
        } finally {
            zzb();
        }
    }

    public final void zza() {
        Object obj = this.zzb;
        synchronized (obj) {
            obj.notifyAll();
        }
    }
}
