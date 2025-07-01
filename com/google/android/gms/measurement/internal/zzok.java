package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.4.0 */
/* loaded from: classes3.dex */
public final class zzok implements Runnable {
    final long zza;
    final long zzb;
    final /* synthetic */ zzol zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzok(zzol zzolVar, long j, long j2) {
        this.zzc = zzolVar;
        this.zza = j;
        this.zzb = j2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzc.zza.zzu.zzaX().zzq(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzoj
            @Override // java.lang.Runnable
            public final void run() {
                zzok zzokVar = zzok.this;
                zzop zzopVar = zzokVar.zzc.zza;
                long j = zzokVar.zza;
                long j2 = zzokVar.zzb;
                zzopVar.zzg();
                zzio zzioVar = zzopVar.zzu;
                zzioVar.zzaW().zzd().zza("Application going to the background");
                zzioVar.zzm().zzn.zza(true);
                zzopVar.zzm(true);
                if (!zzioVar.zzf().zzz()) {
                    zzon zzonVar = zzopVar.zzb;
                    zzonVar.zzd(false, false, j2);
                    zzonVar.zzb(j2);
                }
                zzioVar.zzaW().zzi().zzb("Application backgrounded at: timestamp_millis", Long.valueOf(j));
                zzio zzioVar2 = zzopVar.zzu;
                zzlw zzq = zzioVar2.zzq();
                zzq.zzg();
                zzio zzioVar3 = zzq.zzu;
                zzq.zza();
                zzny zzu = zzioVar3.zzu();
                zzu.zzg();
                zzu.zza();
                if (!zzu.zzad() || zzu.zzu.zzw().zzm() >= 242600) {
                    zzioVar3.zzu().zzz();
                }
                if (zzioVar.zzf().zzx(null, zzgi.zzaS)) {
                    long zzk = zzioVar.zzw().zzak(zzioVar.zzaT().getPackageName(), zzioVar.zzf().zzs()) ? 1000L : zzioVar.zzf().zzk(zzioVar.zzaT().getPackageName(), zzgi.zzD);
                    zzioVar.zzaW().zzj().zzb("[sgtm] Scheduling batch upload with minimum latency in millis", Long.valueOf(zzk));
                    zzioVar2.zzs().zzj(zzk);
                }
            }
        });
    }
}
