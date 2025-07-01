package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.4.0 */
/* loaded from: classes3.dex */
public final class zzpp implements zzpo {
    public static final zzki zza;
    public static final zzki zzb;

    static {
        zzkf zza2 = new zzkf(zzjx.zza("com.google.android.gms.measurement")).zzb().zza();
        zza2.zzf("measurement.collection.event_safelist", true);
        zza = zza2.zzf("measurement.service.store_null_safelist", true);
        zzb = zza2.zzf("measurement.service.store_safelist", true);
    }

    @Override // com.google.android.gms.internal.measurement.zzpo
    public final boolean zza() {
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.zzpo
    public final boolean zzb() {
        return ((Boolean) zza.zzb()).booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzpo
    public final boolean zzc() {
        return ((Boolean) zzb.zzb()).booleanValue();
    }
}
