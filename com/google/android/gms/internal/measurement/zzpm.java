package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.4.0 */
/* loaded from: classes3.dex */
public final class zzpm implements zzpl {
    public static final zzki zza;
    public static final zzki zzb;

    static {
        zzkf zza2 = new zzkf(zzjx.zza("com.google.android.gms.measurement")).zzb().zza();
        zza = zza2.zzf("measurement.set_default_event_parameters_propagate_clear.client.dev", false);
        zzb = zza2.zzf("measurement.set_default_event_parameters_propagate_clear.service", false);
        zza2.zzd("measurement.id.set_default_event_parameters_propagate_clear.experiment_id", 0L);
    }

    @Override // com.google.android.gms.internal.measurement.zzpl
    public final boolean zza() {
        return ((Boolean) zza.zzb()).booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzpl
    public final boolean zzb() {
        return ((Boolean) zzb.zzb()).booleanValue();
    }
}
