package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

/* compiled from: com.google.android.gms:play-services-measurement@@22.4.0 */
/* loaded from: classes3.dex */
public final class zzhv implements ServiceConnection {
    final /* synthetic */ zzhw zza;
    private final String zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzhv(zzhw zzhwVar, String str) {
        this.zza = zzhwVar;
        this.zzb = str;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (iBinder != null) {
            try {
                com.google.android.gms.internal.measurement.zzbr zzb = com.google.android.gms.internal.measurement.zzbq.zzb(iBinder);
                if (zzb == null) {
                    this.zza.zza.zzaW().zzk().zza("Install Referrer Service implementation was not found");
                    return;
                }
                zzio zzioVar = this.zza.zza;
                zzioVar.zzaW().zzj().zza("Install Referrer Service connected");
                zzioVar.zzaX().zzq(new zzhu(this, zzb, this));
                return;
            } catch (RuntimeException e) {
                this.zza.zza.zzaW().zzk().zzb("Exception occurred while calling Install Referrer API", e);
                return;
            }
        }
        this.zza.zza.zzaW().zzk().zza("Install Referrer connection returned with null binder");
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        this.zza.zza.zzaW().zzj().zza("Install Referrer Service disconnected");
    }
}
