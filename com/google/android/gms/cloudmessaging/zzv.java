package com.google.android.gms.cloudmessaging;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.common.util.concurrent.NamedThreadFactory;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-cloud-messaging@@17.2.0 */
/* loaded from: classes3.dex */
public final class zzv {
    private static zzv zza;
    private final Context zzb;
    private final ScheduledExecutorService zzc;
    private zzp zzd = new zzp(this, null);
    private int zze = 1;

    zzv(Context context, ScheduledExecutorService scheduledExecutorService) {
        this.zzc = scheduledExecutorService;
        this.zzb = context.getApplicationContext();
    }

    public static /* bridge */ /* synthetic */ Context zza(zzv zzvVar) {
        return zzvVar.zzb;
    }

    public static synchronized zzv zzb(Context context) {
        zzv zzvVar;
        synchronized (zzv.class) {
            if (zza == null) {
                com.google.android.gms.internal.cloudmessaging.zze.zza();
                zza = new zzv(context, Executors.unconfigurableScheduledExecutorService(Executors.newScheduledThreadPool(1, new NamedThreadFactory("MessengerIpcClient"))));
            }
            zzvVar = zza;
        }
        return zzvVar;
    }

    public static /* bridge */ /* synthetic */ ScheduledExecutorService zze(zzv zzvVar) {
        return zzvVar.zzc;
    }

    private final synchronized int zzf() {
        int i;
        i = this.zze;
        this.zze = i + 1;
        return i;
    }

    private final synchronized Task zzg(zzs zzsVar) {
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            Log.d("MessengerIpcClient", "Queueing ".concat(zzsVar.toString()));
        }
        if (!this.zzd.zzg(zzsVar)) {
            zzp zzpVar = new zzp(this, null);
            this.zzd = zzpVar;
            zzpVar.zzg(zzsVar);
        }
        return zzsVar.zzb.getTask();
    }

    public final Task zzc(int i, Bundle bundle) {
        return zzg(new zzr(zzf(), i, bundle));
    }

    public final Task zzd(int i, Bundle bundle) {
        return zzg(new zzu(zzf(), i, bundle));
    }
}
