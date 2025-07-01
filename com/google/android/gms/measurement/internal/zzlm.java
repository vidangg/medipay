package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.4.0 */
/* loaded from: classes3.dex */
public final class zzlm implements Runnable {
    final /* synthetic */ AtomicReference zza;
    final /* synthetic */ zzlw zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzlm(zzlw zzlwVar, AtomicReference atomicReference) {
        this.zza = atomicReference;
        this.zzb = zzlwVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AtomicReference atomicReference = this.zza;
        synchronized (atomicReference) {
            try {
                zzlw zzlwVar = this.zzb;
                atomicReference.set(Long.valueOf(zzlwVar.zzu.zzf().zzk(zzlwVar.zzu.zzh().zzm(), zzgi.zzab)));
            } finally {
                this.zza.notify();
            }
        }
    }
}
