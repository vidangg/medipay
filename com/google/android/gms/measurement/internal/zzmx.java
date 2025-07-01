package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.4.0 */
/* loaded from: classes3.dex */
public final class zzmx extends zzgq {
    final /* synthetic */ AtomicReference zza;
    final /* synthetic */ zzny zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzmx(zzny zznyVar, AtomicReference atomicReference) {
        this.zza = atomicReference;
        this.zzb = zznyVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzgr
    public final void zze(zzpe zzpeVar) {
        AtomicReference atomicReference = this.zza;
        synchronized (atomicReference) {
            this.zzb.zzu.zzaW().zzj().zzb("[sgtm] Got upload batches from service. count", Integer.valueOf(zzpeVar.zza.size()));
            atomicReference.set(zzpeVar);
            atomicReference.notifyAll();
        }
    }
}
