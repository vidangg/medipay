package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.StrictMode;
import com.google.android.gms.common.ConnectionResult;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-basement@@18.5.0 */
/* loaded from: classes3.dex */
final class zzp implements ServiceConnection, zzt {
    final /* synthetic */ zzs zza;
    private final Map zzb = new HashMap();
    private int zzc = 2;
    private boolean zzd;
    private IBinder zze;
    private final zzo zzf;
    private ComponentName zzg;

    public zzp(zzs zzsVar, zzo zzoVar) {
        this.zza = zzsVar;
        this.zzf = zzoVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ ConnectionResult zzd(zzp zzpVar, String str, Executor executor) {
        ConnectionResult connectionResult;
        try {
            Intent zzb = zzpVar.zzf.zzb(zzs.zze(zzpVar.zza));
            zzpVar.zzc = 3;
            StrictMode.VmPolicy zza = com.google.android.gms.common.util.zzc.zza();
            try {
                zzs zzsVar = zzpVar.zza;
                boolean zza2 = zzs.zzg(zzsVar).zza(zzs.zze(zzsVar), str, zzb, zzpVar, 4225, executor);
                zzpVar.zzd = zza2;
                if (zza2) {
                    zzs.zzf(zzpVar.zza).sendMessageDelayed(zzs.zzf(zzpVar.zza).obtainMessage(1, zzpVar.zzf), zzs.zzd(zzpVar.zza));
                    connectionResult = ConnectionResult.RESULT_SUCCESS;
                } else {
                    zzpVar.zzc = 2;
                    try {
                        zzs zzsVar2 = zzpVar.zza;
                        zzs.zzg(zzsVar2).unbindService(zzs.zze(zzsVar2), zzpVar);
                    } catch (IllegalArgumentException unused) {
                    }
                    connectionResult = new ConnectionResult(16);
                }
                return connectionResult;
            } finally {
                StrictMode.setVmPolicy(zza);
            }
        } catch (zzaj e) {
            return e.zza;
        }
    }

    @Override // android.content.ServiceConnection
    public final void onBindingDied(ComponentName componentName) {
        onServiceDisconnected(componentName);
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        synchronized (zzs.zzh(this.zza)) {
            zzs.zzf(this.zza).removeMessages(1, this.zzf);
            this.zze = iBinder;
            this.zzg = componentName;
            Iterator it = this.zzb.values().iterator();
            while (it.hasNext()) {
                ((ServiceConnection) it.next()).onServiceConnected(componentName, iBinder);
            }
            this.zzc = 1;
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        synchronized (zzs.zzh(this.zza)) {
            zzs.zzf(this.zza).removeMessages(1, this.zzf);
            this.zze = null;
            this.zzg = componentName;
            Iterator it = this.zzb.values().iterator();
            while (it.hasNext()) {
                ((ServiceConnection) it.next()).onServiceDisconnected(componentName);
            }
            this.zzc = 2;
        }
    }

    public final int zza() {
        return this.zzc;
    }

    public final ComponentName zzb() {
        return this.zzg;
    }

    public final IBinder zzc() {
        return this.zze;
    }

    public final void zze(ServiceConnection serviceConnection, ServiceConnection serviceConnection2, String str) {
        this.zzb.put(serviceConnection, serviceConnection2);
    }

    public final void zzf(ServiceConnection serviceConnection, String str) {
        this.zzb.remove(serviceConnection);
    }

    public final void zzg(String str) {
        zzs.zzf(this.zza).removeMessages(1, this.zzf);
        zzs zzsVar = this.zza;
        zzs.zzg(zzsVar).unbindService(zzs.zze(zzsVar), this);
        this.zzd = false;
        this.zzc = 2;
    }

    public final boolean zzh(ServiceConnection serviceConnection) {
        return this.zzb.containsKey(serviceConnection);
    }

    public final boolean zzi() {
        return this.zzb.isEmpty();
    }

    public final boolean zzj() {
        return this.zzd;
    }
}
