package com.google.android.gms.internal.measurement;

import android.support.v4.media.session.PlaybackStateCompat;
import androidx.media3.common.C;
import androidx.media3.exoplayer.Renderer;
import androidx.media3.exoplayer.audio.SilenceSkippingAudioProcessor;
import androidx.webkit.ProxyConfig;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.4.0 */
/* loaded from: classes3.dex */
public final class zzpd implements zzpc {
    public static final zzki zzA;
    public static final zzki zzB;
    public static final zzki zzC;
    public static final zzki zzD;
    public static final zzki zzE;
    public static final zzki zzF;
    public static final zzki zzG;
    public static final zzki zzH;
    public static final zzki zzI;
    public static final zzki zzJ;
    public static final zzki zzK;
    public static final zzki zzL;
    public static final zzki zzM;
    public static final zzki zzN;
    public static final zzki zzO;
    public static final zzki zzP;
    public static final zzki zzQ;
    public static final zzki zzR;
    public static final zzki zzS;
    public static final zzki zzT;
    public static final zzki zzU;
    public static final zzki zzV;
    public static final zzki zzW;
    public static final zzki zzX;
    public static final zzki zzY;
    public static final zzki zzZ;
    public static final zzki zza;
    public static final zzki zzaa;
    public static final zzki zzab;
    public static final zzki zzac;
    public static final zzki zzad;
    public static final zzki zzae;
    public static final zzki zzaf;
    public static final zzki zzag;
    public static final zzki zzah;
    public static final zzki zzai;
    public static final zzki zzaj;
    public static final zzki zzak;
    public static final zzki zzal;
    public static final zzki zzam;
    public static final zzki zzan;
    public static final zzki zzao;
    public static final zzki zzap;
    public static final zzki zzaq;
    public static final zzki zzar;
    public static final zzki zzas;
    public static final zzki zzat;
    public static final zzki zzb;
    public static final zzki zzc;
    public static final zzki zzd;
    public static final zzki zze;
    public static final zzki zzf;
    public static final zzki zzg;
    public static final zzki zzh;
    public static final zzki zzi;
    public static final zzki zzj;
    public static final zzki zzk;
    public static final zzki zzl;
    public static final zzki zzm;
    public static final zzki zzn;
    public static final zzki zzo;
    public static final zzki zzp;
    public static final zzki zzq;
    public static final zzki zzr;
    public static final zzki zzs;
    public static final zzki zzt;
    public static final zzki zzu;
    public static final zzki zzv;
    public static final zzki zzw;
    public static final zzki zzx;
    public static final zzki zzy;
    public static final zzki zzz;

    static {
        zzkf zza2 = new zzkf(zzjx.zza("com.google.android.gms.measurement")).zzb().zza();
        zza = zza2.zzd("measurement.ad_id_cache_time", Renderer.DEFAULT_DURATION_TO_PROGRESS_US);
        zzb = zza2.zzd("measurement.app_uninstalled_additional_ad_id_cache_time", 3600000L);
        zzc = zza2.zzf("measurement.config.bundle_for_all_apps_on_backgrounded", true);
        zzd = zza2.zzd("measurement.max_bundles_per_iteration", 100L);
        zze = zza2.zzd("measurement.config.cache_time", 86400000L);
        zza2.zze("measurement.log_tag", "FA");
        zzf = zza2.zze("measurement.config.url_authority", "app-measurement.com");
        zzg = zza2.zze("measurement.config.url_scheme", ProxyConfig.MATCH_HTTPS);
        zzh = zza2.zzd("measurement.upload.debug_upload_interval", 1000L);
        zzi = zza2.zzd("measurement.session.engagement_interval", 3600000L);
        zzj = zza2.zze("measurement.rb.attribution.event_params", "value|currency");
        zzk = zza2.zzd("measurement.upload.google_signal_max_queue_time", 605000L);
        zzl = zza2.zze("measurement.sgtm.google_signal.url", "https://app-measurement.com/s/d");
        zzm = zza2.zzd("measurement.lifetimevalue.max_currency_tracked", 4L);
        zzn = zza2.zzd("measurement.dma_consent.max_daily_dcu_realtime_events", 1L);
        zzo = zza2.zzd("measurement.upload.max_event_parameter_value_length", 500L);
        zzp = zza2.zzd("measurement.store.max_stored_events_per_app", SilenceSkippingAudioProcessor.DEFAULT_MINIMUM_SILENCE_DURATION_US);
        zzq = zza2.zzd("measurement.experiment.max_ids", 50L);
        zzr = zza2.zzd("measurement.audience.filter_result_max_count", 200L);
        zzs = zza2.zzd("measurement.upload.max_item_scoped_custom_parameters", 27L);
        zzt = zza2.zzd("measurement.rb.max_trigger_registrations_per_day", 1000L);
        zzu = zza2.zzd("measurement.rb.attribution.max_trigger_uris_queried_at_once", 0L);
        zzv = zza2.zzd("measurement.rb.attribution.client.min_ad_services_version", 7L);
        zzw = zza2.zzd("measurement.alarm_manager.minimum_interval", 60000L);
        zzx = zza2.zzd("measurement.upload.minimum_delay", 500L);
        zzy = zza2.zzd("measurement.monitoring.sample_period_millis", 86400000L);
        zzz = zza2.zzd("measurement.rb.attribution.notify_app_delay_millis", C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS);
        zzA = zza2.zzf("measurement.config.notify_trigger_uris_on_backgrounded", true);
        zzB = zza2.zze("measurement.rb.attribution.app_allowlist", ProxyConfig.MATCH_ALL_SCHEMES);
        zzC = zza2.zzd("measurement.upload.realtime_upload_interval", Renderer.DEFAULT_DURATION_TO_PROGRESS_US);
        zzD = zza2.zzd("measurement.upload.refresh_blacklisted_config_interval", 604800000L);
        zza2.zzd("measurement.config.cache_time.service", 3600000L);
        zzE = zza2.zzd("measurement.service_client.idle_disconnect_millis", 5000L);
        zza2.zze("measurement.log_tag.service", "FA-SVC");
        zzF = zza2.zzd("measurement.service_client.reconnect_millis", 1000L);
        zza2.zze("measurement.sgtm.app_allowlist", ProxyConfig.MATCH_ALL_SCHEMES);
        zzG = zza2.zzd("measurement.sgtm.batch.retry_interval", 1800000L);
        zzH = zza2.zzd("measurement.sgtm.batch.retry_max_count", 10L);
        zzI = zza2.zzd("measurement.sgtm.batch.retry_max_wait", 21600000L);
        zzJ = zza2.zze("measurement.sgtm.service_upload_apps_list", "");
        zzK = zza2.zze("measurement.sgtm.upload.backoff_http_codes", "404,429,503,504");
        zzL = zza2.zzd("measurement.sgtm.upload.batches_retrieval_limit", 5L);
        zzM = zza2.zzd("measurement.sgtm.upload.max_queued_batches", 5000L);
        zzN = zza2.zzd("measurement.sgtm.upload.min_delay_after_background", 600000L);
        zzO = zza2.zzd("measurement.sgtm.upload.min_delay_after_broadcast", 1000L);
        zzP = zza2.zzd("measurement.sgtm.upload.min_delay_after_startup", 5000L);
        zzQ = zza2.zzd("measurement.sgtm.upload.retry_interval", 600000L);
        zzR = zza2.zzd("measurement.sgtm.upload.retry_max_wait", 21600000L);
        zzS = zza2.zzd("measurement.upload.stale_data_deletion_interval", 86400000L);
        zzT = zza2.zzd("measurement.rb.attribution.max_retry_delay_seconds", 16L);
        zzU = zza2.zzd("measurement.rb.attribution.client.min_time_after_boot_seconds", 90L);
        zzV = zza2.zze("measurement.rb.attribution.uri_authority", "google-analytics.com");
        zzW = zza2.zzd("measurement.rb.attribution.max_queue_time", 864000000L);
        zzX = zza2.zze("measurement.rb.attribution.uri_path", "privacy-sandbox/register-app-conversion");
        zzY = zza2.zze("measurement.rb.attribution.query_parameters_to_remove", "");
        zzZ = zza2.zze("measurement.rb.attribution.uri_scheme", ProxyConfig.MATCH_HTTPS);
        zzaa = zza2.zzd("measurement.sdk.attribution.cache.ttl", 604800000L);
        zzab = zza2.zzd("measurement.redaction.app_instance_id.ttl", 7200000L);
        zzac = zza2.zzd("measurement.upload.backoff_period", 43200000L);
        zzad = zza2.zzd("measurement.upload.initial_upload_delay_time", C.DEFAULT_SEEK_FORWARD_INCREMENT_MS);
        zzae = zza2.zzd("measurement.upload.interval", 3600000L);
        zzaf = zza2.zzd("measurement.upload.max_bundle_size", PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH);
        zzag = zza2.zzd("measurement.upload.max_bundles", 100L);
        zzah = zza2.zzd("measurement.upload.max_conversions_per_day", 500L);
        zzai = zza2.zzd("measurement.upload.max_error_events_per_day", 1000L);
        zzaj = zza2.zzd("measurement.upload.max_events_per_bundle", 1000L);
        zzak = zza2.zzd("measurement.upload.max_events_per_day", SilenceSkippingAudioProcessor.DEFAULT_MINIMUM_SILENCE_DURATION_US);
        zzal = zza2.zzd("measurement.upload.max_public_events_per_day", 50000L);
        zzam = zza2.zzd("measurement.upload.max_queue_time", 518400000L);
        zzan = zza2.zzd("measurement.upload.max_realtime_events_per_day", 10L);
        zzao = zza2.zzd("measurement.upload.max_batch_size", PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH);
        zzap = zza2.zzd("measurement.upload.retry_count", 6L);
        zzaq = zza2.zzd("measurement.upload.retry_time", 1800000L);
        zzar = zza2.zze("measurement.upload.url", "https://app-measurement.com/a");
        zzas = zza2.zzd("measurement.upload.window_interval", 3600000L);
        zzat = zza2.zze("measurement.rb.attribution.user_properties", "_npa,npa|_fot,fot");
    }

    @Override // com.google.android.gms.internal.measurement.zzpc
    public final long zzA() {
        return ((Long) zzH.zzb()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzpc
    public final long zzB() {
        return ((Long) zzI.zzb()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzpc
    public final long zzC() {
        return ((Long) zzL.zzb()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzpc
    public final long zzD() {
        return ((Long) zzM.zzb()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzpc
    public final long zzE() {
        return ((Long) zzN.zzb()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzpc
    public final long zzF() {
        return ((Long) zzO.zzb()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzpc
    public final long zzG() {
        return ((Long) zzP.zzb()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzpc
    public final long zzH() {
        return ((Long) zzQ.zzb()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzpc
    public final long zzI() {
        return ((Long) zzR.zzb()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzpc
    public final long zzJ() {
        return ((Long) zzS.zzb()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzpc
    public final long zzK() {
        return ((Long) zzT.zzb()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzpc
    public final long zzL() {
        return ((Long) zzU.zzb()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzpc
    public final long zzM() {
        return ((Long) zzW.zzb()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzpc
    public final long zzN() {
        return ((Long) zzaa.zzb()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzpc
    public final long zzO() {
        return ((Long) zzab.zzb()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzpc
    public final long zzP() {
        return ((Long) zzac.zzb()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzpc
    public final long zzQ() {
        return ((Long) zzad.zzb()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzpc
    public final long zzR() {
        return ((Long) zzae.zzb()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzpc
    public final long zzS() {
        return ((Long) zzaf.zzb()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzpc
    public final long zzT() {
        return ((Long) zzag.zzb()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzpc
    public final long zzU() {
        return ((Long) zzah.zzb()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzpc
    public final long zzV() {
        return ((Long) zzai.zzb()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzpc
    public final long zzW() {
        return ((Long) zzaj.zzb()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzpc
    public final long zzX() {
        return ((Long) zzak.zzb()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzpc
    public final long zzY() {
        return ((Long) zzal.zzb()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzpc
    public final long zzZ() {
        return ((Long) zzam.zzb()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzpc
    public final long zza() {
        return ((Long) zza.zzb()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzpc
    public final long zzaa() {
        return ((Long) zzan.zzb()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzpc
    public final long zzab() {
        return ((Long) zzao.zzb()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzpc
    public final long zzac() {
        return ((Long) zzap.zzb()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzpc
    public final long zzad() {
        return ((Long) zzaq.zzb()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzpc
    public final long zzae() {
        return ((Long) zzas.zzb()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzpc
    public final String zzaf() {
        return (String) zzf.zzb();
    }

    @Override // com.google.android.gms.internal.measurement.zzpc
    public final String zzag() {
        return (String) zzg.zzb();
    }

    @Override // com.google.android.gms.internal.measurement.zzpc
    public final String zzah() {
        return (String) zzj.zzb();
    }

    @Override // com.google.android.gms.internal.measurement.zzpc
    public final String zzai() {
        return (String) zzl.zzb();
    }

    @Override // com.google.android.gms.internal.measurement.zzpc
    public final String zzaj() {
        return (String) zzB.zzb();
    }

    @Override // com.google.android.gms.internal.measurement.zzpc
    public final String zzak() {
        return (String) zzJ.zzb();
    }

    @Override // com.google.android.gms.internal.measurement.zzpc
    public final String zzal() {
        return (String) zzK.zzb();
    }

    @Override // com.google.android.gms.internal.measurement.zzpc
    public final String zzam() {
        return (String) zzV.zzb();
    }

    @Override // com.google.android.gms.internal.measurement.zzpc
    public final String zzan() {
        return (String) zzX.zzb();
    }

    @Override // com.google.android.gms.internal.measurement.zzpc
    public final String zzao() {
        return (String) zzY.zzb();
    }

    @Override // com.google.android.gms.internal.measurement.zzpc
    public final String zzap() {
        return (String) zzZ.zzb();
    }

    @Override // com.google.android.gms.internal.measurement.zzpc
    public final String zzaq() {
        return (String) zzar.zzb();
    }

    @Override // com.google.android.gms.internal.measurement.zzpc
    public final String zzar() {
        return (String) zzat.zzb();
    }

    @Override // com.google.android.gms.internal.measurement.zzpc
    public final boolean zzas() {
        return ((Boolean) zzc.zzb()).booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzpc
    public final boolean zzat() {
        return ((Boolean) zzA.zzb()).booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzpc
    public final long zzb() {
        return ((Long) zzb.zzb()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzpc
    public final long zzc() {
        return ((Long) zzd.zzb()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzpc
    public final long zzd() {
        return ((Long) zze.zzb()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzpc
    public final long zze() {
        return ((Long) zzh.zzb()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzpc
    public final long zzf() {
        return ((Long) zzi.zzb()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzpc
    public final long zzg() {
        return ((Long) zzk.zzb()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzpc
    public final long zzh() {
        return ((Long) zzm.zzb()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzpc
    public final long zzi() {
        return ((Long) zzn.zzb()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzpc
    public final long zzj() {
        return ((Long) zzo.zzb()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzpc
    public final long zzk() {
        return ((Long) zzp.zzb()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzpc
    public final long zzl() {
        return ((Long) zzq.zzb()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzpc
    public final long zzm() {
        return ((Long) zzr.zzb()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzpc
    public final long zzn() {
        return ((Long) zzs.zzb()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzpc
    public final long zzo() {
        return ((Long) zzt.zzb()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzpc
    public final long zzp() {
        return ((Long) zzu.zzb()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzpc
    public final long zzq() {
        return ((Long) zzv.zzb()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzpc
    public final long zzr() {
        return ((Long) zzw.zzb()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzpc
    public final long zzs() {
        return ((Long) zzx.zzb()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzpc
    public final long zzt() {
        return ((Long) zzy.zzb()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzpc
    public final long zzu() {
        return ((Long) zzz.zzb()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzpc
    public final long zzv() {
        return ((Long) zzC.zzb()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzpc
    public final long zzw() {
        return ((Long) zzD.zzb()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzpc
    public final long zzx() {
        return ((Long) zzE.zzb()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzpc
    public final long zzy() {
        return ((Long) zzF.zzb()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzpc
    public final long zzz() {
        return ((Long) zzG.zzb()).longValue();
    }
}
