package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.4.0 */
/* loaded from: classes3.dex */
public final class zzro implements zzrn {
    public static final zzki zza;

    static {
        zzkf zza2 = new zzkf(zzjx.zza("com.google.android.gms.measurement")).zzb().zza();
        zza = zza2.zzf("measurement.tcf.consent_fix", false);
        zza2.zzf("measurement.tcf.client", true);
        zza2.zzd("measurement.id.tcf", 0L);
    }

    @Override // com.google.android.gms.internal.measurement.zzrn
    public final boolean zza() {
        return ((Boolean) zza.zzb()).booleanValue();
    }
}
