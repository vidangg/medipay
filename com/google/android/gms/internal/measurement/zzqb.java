package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.4.0 */
/* loaded from: classes3.dex */
public final class zzqb implements zzqa {
    public static final zzki zza;

    static {
        zzkf zza2 = new zzkf(zzjx.zza("com.google.android.gms.measurement")).zzb().zza();
        zza2.zzd("measurement.id.upload_controller_wait_initialization", 0L);
        zza = zza2.zzf("measurement.upload_controller.wait_initialization", false);
    }

    @Override // com.google.android.gms.internal.measurement.zzqa
    public final boolean zza() {
        return ((Boolean) zza.zzb()).booleanValue();
    }
}
