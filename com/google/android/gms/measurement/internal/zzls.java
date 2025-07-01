package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.4.0 */
/* loaded from: classes3.dex */
public final class zzls implements Runnable {
    final /* synthetic */ zzjx zza;
    final /* synthetic */ long zzb;
    final /* synthetic */ boolean zzc;
    final /* synthetic */ zzlw zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzls(zzlw zzlwVar, zzjx zzjxVar, long j, boolean z) {
        this.zza = zzjxVar;
        this.zzb = j;
        this.zzc = z;
        this.zzd = zzlwVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzlw zzlwVar = this.zzd;
        zzjx zzjxVar = this.zza;
        zzlwVar.zzaj(zzjxVar);
        zzlw.zzD(zzlwVar, zzjxVar, this.zzb, false, this.zzc);
    }
}
