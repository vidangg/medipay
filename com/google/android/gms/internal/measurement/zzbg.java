package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement@@22.4.0 */
/* loaded from: classes3.dex */
final class zzbg implements zzbf {
    private final zzg zza;
    private final String zzb;

    public zzbg(zzg zzgVar, String str) {
        this.zza = zzgVar;
        this.zzb = str;
    }

    @Override // com.google.android.gms.internal.measurement.zzbf
    public final zzg zza(zzap zzapVar) {
        zzg zzgVar = this.zza;
        zzgVar.zze(this.zzb, zzapVar);
        return zzgVar;
    }
}
