package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.stats.ConnectionTracker;
import java.util.HashMap;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-basement@@18.5.0 */
/* loaded from: classes3.dex */
public final class zzs extends GmsClientSupervisor {
    private final HashMap zzb = new HashMap();
    private final Context zzc;
    private volatile Handler zzd;
    private final zzq zze;
    private final ConnectionTracker zzf;
    private final long zzg;
    private final long zzh;
    private volatile Executor zzi;

    public zzs(Context context, Looper looper, Executor executor) {
        zzq zzqVar = new zzq(this, null);
        this.zze = zzqVar;
        this.zzc = context.getApplicationContext();
        this.zzd = new com.google.android.gms.internal.common.zzh(looper, zzqVar);
        this.zzf = ConnectionTracker.getInstance();
        this.zzg = 5000L;
        this.zzh = 300000L;
        this.zzi = executor;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.GmsClientSupervisor
    public final ConnectionResult zza(zzo zzoVar, ServiceConnection serviceConnection, String str, Executor executor) {
        ConnectionResult connectionResult;
        Preconditions.checkNotNull(serviceConnection, "ServiceConnection must not be null");
        synchronized (this.zzb) {
            zzp zzpVar = (zzp) this.zzb.get(zzoVar);
            if (executor == null) {
                executor = this.zzi;
            }
            if (zzpVar == null) {
                zzpVar = new zzp(this, zzoVar);
                zzpVar.zze(serviceConnection, serviceConnection, str);
                connectionResult = zzp.zzd(zzpVar, str, executor);
                this.zzb.put(zzoVar, zzpVar);
            } else {
                this.zzd.removeMessages(0, zzoVar);
                if (zzpVar.zzh(serviceConnection)) {
                    throw new IllegalStateException("Trying to bind a GmsServiceConnection that was already connected before.  config=" + zzoVar.toString());
                }
                zzpVar.zze(serviceConnection, serviceConnection, str);
                int zza = zzpVar.zza();
                if (zza == 1) {
                    serviceConnection.onServiceConnected(zzpVar.zzb(), zzpVar.zzc());
                } else if (zza == 2) {
                    connectionResult = zzp.zzd(zzpVar, str, executor);
                }
                connectionResult = null;
            }
            if (zzpVar.zzj()) {
                return ConnectionResult.RESULT_SUCCESS;
            }
            if (connectionResult == null) {
                connectionResult = new ConnectionResult(-1);
            }
            return connectionResult;
        }
    }

    @Override // com.google.android.gms.common.internal.GmsClientSupervisor
    protected final void zzb(zzo zzoVar, ServiceConnection serviceConnection, String str) {
        Preconditions.checkNotNull(serviceConnection, "ServiceConnection must not be null");
        synchronized (this.zzb) {
            zzp zzpVar = (zzp) this.zzb.get(zzoVar);
            if (zzpVar == null) {
                throw new IllegalStateException("Nonexistent connection status for service config: " + zzoVar.toString());
            }
            if (!zzpVar.zzh(serviceConnection)) {
                throw new IllegalStateException("Trying to unbind a GmsServiceConnection  that was not bound before.  config=" + zzoVar.toString());
            }
            zzpVar.zzf(serviceConnection, str);
            if (zzpVar.zzi()) {
                this.zzd.sendMessageDelayed(this.zzd.obtainMessage(0, zzoVar), this.zzg);
            }
        }
    }

    public final void zzi(Executor executor) {
        synchronized (this.zzb) {
            this.zzi = executor;
        }
    }

    public final void zzj(Looper looper) {
        synchronized (this.zzb) {
            this.zzd = new com.google.android.gms.internal.common.zzh(looper, this.zze);
        }
    }
}
