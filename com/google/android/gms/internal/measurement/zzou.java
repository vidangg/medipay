package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.4.0 */
/* loaded from: classes3.dex */
public final class zzou implements zzot {
    public static final zzki zza;

    static {
        zzkf zza2 = new zzkf(zzjx.zza("com.google.android.gms.measurement")).zzb().zza();
        zza = zza2.zzf("measurement.service.ad_impression.convert_value_to_double", true);
        zza2.zzf("measurement.service.separate_public_internal_event_blacklisting", true);
        zza2.zzf("measurement.service.ad_impression", true);
    }

    @Override // com.google.android.gms.internal.measurement.zzot
    public final boolean zza() {
        return ((Boolean) zza.zzb()).booleanValue();
    }
}
