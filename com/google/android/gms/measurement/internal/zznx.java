package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import androidx.media3.extractor.ts.TsExtractor;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.stats.ConnectionTracker;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.4.0 */
/* loaded from: classes3.dex */
public final class zznx implements ServiceConnection, BaseGmsClient.BaseConnectionCallbacks, BaseGmsClient.BaseOnConnectionFailedListener {
    final /* synthetic */ zzny zza;
    private volatile boolean zzb;
    private volatile zzgy zzc;

    /* JADX INFO: Access modifiers changed from: protected */
    public zznx(zzny zznyVar) {
        this.zza = zznyVar;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnected(Bundle bundle) {
        this.zza.zzu.zzaX().zzn();
        synchronized (this) {
            try {
                Preconditions.checkNotNull(this.zzc);
                this.zza.zzu.zzaX().zzq(new zzns(this, (zzgl) this.zzc.getService()));
            } catch (DeadObjectException | IllegalStateException unused) {
                this.zzc = null;
                this.zzb = false;
            }
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener
    public final void onConnectionFailed(ConnectionResult connectionResult) {
        zzny zznyVar = this.zza;
        zznyVar.zzu.zzaX().zzn();
        zzhe zzl = zznyVar.zzu.zzl();
        if (zzl != null) {
            zzl.zzk().zzb("Service connection failed", connectionResult);
        }
        synchronized (this) {
            this.zzb = false;
            this.zzc = null;
        }
        this.zza.zzu.zzaX().zzq(new zznw(this, connectionResult));
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnectionSuspended(int i) {
        zzio zzioVar = this.zza.zzu;
        zzioVar.zzaX().zzn();
        zzioVar.zzaW().zzd().zza("Service connection suspended");
        zzioVar.zzaX().zzq(new zznt(this));
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        zznx zznxVar;
        zzgl zzgjVar;
        this.zza.zzu.zzaX().zzn();
        synchronized (this) {
            if (iBinder != null) {
                zzgl zzglVar = null;
                try {
                    String interfaceDescriptor = iBinder.getInterfaceDescriptor();
                    if ("com.google.android.gms.measurement.internal.IMeasurementService".equals(interfaceDescriptor)) {
                        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.measurement.internal.IMeasurementService");
                        if (queryLocalInterface instanceof zzgl) {
                            zzgjVar = (zzgl) queryLocalInterface;
                        } else {
                            zzgjVar = new zzgj(iBinder);
                        }
                        zzglVar = zzgjVar;
                        this.zza.zzu.zzaW().zzj().zza("Bound to IMeasurementService interface");
                    } else {
                        this.zza.zzu.zzaW().zze().zzb("Got binder with a wrong descriptor", interfaceDescriptor);
                    }
                } catch (RemoteException unused) {
                    this.zza.zzu.zzaW().zze().zza("Service connect failed to get IMeasurementService");
                }
                if (zzglVar == null) {
                    this.zzb = false;
                    try {
                        ConnectionTracker connectionTracker = ConnectionTracker.getInstance();
                        zzny zznyVar = this.zza;
                        Context zzaT = zznyVar.zzu.zzaT();
                        zznxVar = zznyVar.zza;
                        connectionTracker.unbindService(zzaT, zznxVar);
                    } catch (IllegalArgumentException unused2) {
                    }
                } else {
                    this.zza.zzu.zzaX().zzq(new zznq(this, zzglVar));
                }
                return;
            }
            this.zzb = false;
            this.zza.zzu.zzaW().zze().zza("Service connected with null binder");
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        zzio zzioVar = this.zza.zzu;
        zzioVar.zzaX().zzn();
        zzioVar.zzaW().zzd().zza("Service disconnected");
        zzioVar.zzaX().zzq(new zznr(this, componentName));
    }

    public final void zzb(Intent intent) {
        zznx zznxVar;
        zzny zznyVar = this.zza;
        zznyVar.zzg();
        Context zzaT = zznyVar.zzu.zzaT();
        ConnectionTracker connectionTracker = ConnectionTracker.getInstance();
        synchronized (this) {
            if (this.zzb) {
                this.zza.zzu.zzaW().zzj().zza("Connection attempt already in progress");
                return;
            }
            zzny zznyVar2 = this.zza;
            zznyVar2.zzu.zzaW().zzj().zza("Using local app measurement service");
            this.zzb = true;
            zznxVar = zznyVar2.zza;
            connectionTracker.bindService(zzaT, intent, zznxVar, TsExtractor.TS_STREAM_TYPE_AC3);
        }
    }

    public final void zzc() {
        zzny zznyVar = this.zza;
        zznyVar.zzg();
        Context zzaT = zznyVar.zzu.zzaT();
        synchronized (this) {
            if (this.zzb) {
                this.zza.zzu.zzaW().zzj().zza("Connection attempt already in progress");
                return;
            }
            if (this.zzc == null || (!this.zzc.isConnecting() && !this.zzc.isConnected())) {
                this.zzc = new zzgy(zzaT, Looper.getMainLooper(), this, this);
                this.zza.zzu.zzaW().zzj().zza("Connecting to remote service");
                this.zzb = true;
                Preconditions.checkNotNull(this.zzc);
                this.zzc.checkAvailabilityAndConnect();
                return;
            }
            this.zza.zzu.zzaW().zzj().zza("Already awaiting connection attempt");
        }
    }

    public final void zzd() {
        if (this.zzc != null && (this.zzc.isConnected() || this.zzc.isConnecting())) {
            this.zzc.disconnect();
        }
        this.zzc = null;
    }
}
