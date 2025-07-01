package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.4.0 */
/* loaded from: classes3.dex */
public final class zzay implements Runnable {
    final /* synthetic */ zzjs zza;
    final /* synthetic */ zzaz zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzay(zzaz zzazVar, zzjs zzjsVar) {
        this.zza = zzjsVar;
        this.zzb = zzazVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzjs zzjsVar = this.zza;
        zzjsVar.zzaV();
        if (zzaf.zza()) {
            zzjsVar.zzaX().zzq(this);
            return;
        }
        zzaz zzazVar = this.zzb;
        boolean zze = zzazVar.zze();
        zzazVar.zzd = 0L;
        if (zze) {
            zzazVar.zzc();
        }
    }
}
