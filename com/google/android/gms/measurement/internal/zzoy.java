package com.google.android.gms.measurement.internal;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.PersistableBundle;
import androidx.core.app.NotificationCompat;

/* compiled from: com.google.android.gms:play-services-measurement@@22.4.0 */
/* loaded from: classes3.dex */
public final class zzoy extends zzpg {
    private final AlarmManager zza;
    private zzaz zzb;
    private Integer zzc;

    /* JADX INFO: Access modifiers changed from: protected */
    public zzoy(zzpv zzpvVar) {
        super(zzpvVar);
        this.zza = (AlarmManager) this.zzu.zzaT().getSystemService(NotificationCompat.CATEGORY_ALARM);
    }

    private final int zzf() {
        if (this.zzc == null) {
            this.zzc = Integer.valueOf("measurement".concat(String.valueOf(this.zzu.zzaT().getPackageName())).hashCode());
        }
        return this.zzc.intValue();
    }

    private final PendingIntent zzh() {
        Context zzaT = this.zzu.zzaT();
        return PendingIntent.getBroadcast(zzaT, 0, new Intent().setClassName(zzaT, "com.google.android.gms.measurement.AppMeasurementReceiver").setAction("com.google.android.gms.measurement.UPLOAD"), com.google.android.gms.internal.measurement.zzcj.zza);
    }

    private final zzaz zzi() {
        if (this.zzb == null) {
            this.zzb = new zzox(this, this.zzg.zzt());
        }
        return this.zzb;
    }

    private final void zzj() {
        JobScheduler jobScheduler = (JobScheduler) this.zzu.zzaT().getSystemService("jobscheduler");
        if (jobScheduler != null) {
            jobScheduler.cancel(zzf());
        }
    }

    public final void zza() {
        zzav();
        this.zzu.zzaW().zzj().zza("Unscheduling upload");
        AlarmManager alarmManager = this.zza;
        if (alarmManager != null) {
            alarmManager.cancel(zzh());
        }
        zzi().zzb();
        zzj();
    }

    @Override // com.google.android.gms.measurement.internal.zzpg
    protected final boolean zzb() {
        AlarmManager alarmManager = this.zza;
        if (alarmManager != null) {
            alarmManager.cancel(zzh());
        }
        zzj();
        return false;
    }

    public final void zzd(long j) {
        zzav();
        zzio zzioVar = this.zzu;
        zzioVar.zzaV();
        Context zzaT = zzioVar.zzaT();
        if (!zzqf.zzar(zzaT)) {
            zzioVar.zzaW().zzd().zza("Receiver not registered/enabled");
        }
        if (!zzqf.zzat(zzaT, false)) {
            zzioVar.zzaW().zzd().zza("Service not registered/enabled");
        }
        zza();
        zzioVar.zzaW().zzj().zzb("Scheduling upload, millis", Long.valueOf(j));
        zzioVar.zzaU().elapsedRealtime();
        zzioVar.zzf();
        if (j < Math.max(0L, ((Long) zzgi.zzK.zza(null)).longValue()) && !zzi().zze()) {
            zzi().zzd(j);
        }
        zzioVar.zzaV();
        Context zzaT2 = zzioVar.zzaT();
        ComponentName componentName = new ComponentName(zzaT2, "com.google.android.gms.measurement.AppMeasurementJobService");
        int zzf = zzf();
        PersistableBundle persistableBundle = new PersistableBundle();
        persistableBundle.putString("action", "com.google.android.gms.measurement.UPLOAD");
        com.google.android.gms.internal.measurement.zzck.zza(zzaT2, new JobInfo.Builder(zzf, componentName).setMinimumLatency(j).setOverrideDeadline(j + j).setExtras(persistableBundle).build(), "com.google.android.gms", "UploadAlarm");
    }
}
