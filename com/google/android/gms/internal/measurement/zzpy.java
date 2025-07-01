package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.4.0 */
/* loaded from: classes3.dex */
public final class zzpy implements zzpx {
    public static final zzki zza;

    static {
        zzkf zza2 = new zzkf(zzjx.zza("com.google.android.gms.measurement")).zzb().zza();
        zza2.zzd("measurement.id.prune_ees_config", 0L);
        zza = zza2.zzf("measurement.fix_high_memory.prune_ees_config", false);
    }

    @Override // com.google.android.gms.internal.measurement.zzpx
    public final boolean zza() {
        return ((Boolean) zza.zzb()).booleanValue();
    }
}
