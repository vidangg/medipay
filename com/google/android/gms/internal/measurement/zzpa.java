package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.4.0 */
/* loaded from: classes3.dex */
public final class zzpa implements zzoz {
    public static final zzki zza;

    static {
        zzkf zza2 = new zzkf(zzjx.zza("com.google.android.gms.measurement")).zzb().zza();
        zza = zza2.zzf("measurement.chimera.parameter.service", false);
        zza2.zzd("measurement.id.chimera_parameter_service", 0L);
    }

    @Override // com.google.android.gms.internal.measurement.zzoz
    public final boolean zza() {
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.zzoz
    public final boolean zzb() {
        return ((Boolean) zza.zzb()).booleanValue();
    }
}
