package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.4.0 */
/* loaded from: classes3.dex */
public final class zzrl implements zzrk {
    public static final zzki zza;
    public static final zzki zzb;
    public static final zzki zzc;
    public static final zzki zzd;
    public static final zzki zze;
    public static final zzki zzf;
    public static final zzki zzg;
    public static final zzki zzh;

    static {
        zzkf zza2 = new zzkf(zzjx.zza("com.google.android.gms.measurement")).zzb().zza();
        zza = zza2.zzf("measurement.sgtm.client.scion_upload_action", true);
        zzb = zza2.zzf("measurement.sgtm.client.upload_on_backgrounded.dev", false);
        zzc = zza2.zzf("measurement.sgtm.google_signal.enable", true);
        zza2.zzf("measurement.sgtm.no_proxy.client", true);
        zzd = zza2.zzf("measurement.sgtm.no_proxy.client2", false);
        zze = zza2.zzf("measurement.sgtm.no_proxy.service", false);
        zza2.zzf("measurement.sgtm.preview_mode_enabled", true);
        zza2.zzf("measurement.sgtm.rollout_percentage_fix", true);
        zza2.zzf("measurement.sgtm.service", true);
        zzf = zza2.zzf("measurement.sgtm.service.batching_on_backgrounded", false);
        zzg = zza2.zzf("measurement.sgtm.upload_queue", true);
        zzh = zza2.zzf("measurement.sgtm.upload_on_uninstall", true);
        zza2.zzd("measurement.id.sgtm", 0L);
        zza2.zzd("measurement.id.sgtm_noproxy", 0L);
    }

    @Override // com.google.android.gms.internal.measurement.zzrk
    public final boolean zza() {
        return ((Boolean) zza.zzb()).booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzrk
    public final boolean zzb() {
        return ((Boolean) zzb.zzb()).booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzrk
    public final boolean zzc() {
        return ((Boolean) zzc.zzb()).booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzrk
    public final boolean zzd() {
        return ((Boolean) zzd.zzb()).booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzrk
    public final boolean zze() {
        return ((Boolean) zze.zzb()).booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzrk
    public final boolean zzf() {
        return ((Boolean) zzf.zzb()).booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzrk
    public final boolean zzg() {
        return ((Boolean) zzg.zzb()).booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzrk
    public final boolean zzh() {
        return ((Boolean) zzh.zzb()).booleanValue();
    }
}
