package com.google.android.gms.measurement.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.google.android.gms.common.internal.Preconditions;
import dev.fluttercommunity.plus.connectivity.ConnectivityBroadcastReceiver;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement@@22.4.0 */
/* loaded from: classes3.dex */
public final class zzhm extends BroadcastReceiver {
    private final zzpv zza;
    private boolean zzb;
    private boolean zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzhm(zzpv zzpvVar) {
        Preconditions.checkNotNull(zzpvVar);
        this.zza = zzpvVar;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        zzpv zzpvVar = this.zza;
        zzpvVar.zzM();
        String action = intent.getAction();
        zzpvVar.zzaW().zzj().zzb("NetworkBroadcastReceiver received action", action);
        if (!ConnectivityBroadcastReceiver.CONNECTIVITY_ACTION.equals(action)) {
            zzpvVar.zzaW().zzk().zzb("NetworkBroadcastReceiver received unknown action", action);
            return;
        }
        boolean zzd = zzpvVar.zzp().zzd();
        if (this.zzc != zzd) {
            this.zzc = zzd;
            zzpvVar.zzaX().zzq(new zzhl(this, zzd));
        }
    }

    public final void zzb() {
        zzpv zzpvVar = this.zza;
        zzpvVar.zzM();
        zzpvVar.zzaX().zzg();
        if (this.zzb) {
            return;
        }
        zzpvVar.zzaT().registerReceiver(this, new IntentFilter(ConnectivityBroadcastReceiver.CONNECTIVITY_ACTION));
        this.zzc = zzpvVar.zzp().zzd();
        zzpvVar.zzaW().zzj().zzb("Registering connectivity change receiver. Network connected", Boolean.valueOf(this.zzc));
        this.zzb = true;
    }

    public final void zzc() {
        zzpv zzpvVar = this.zza;
        zzpvVar.zzM();
        zzpvVar.zzaX().zzg();
        zzpvVar.zzaX().zzg();
        if (this.zzb) {
            zzpvVar.zzaW().zzj().zza("Unregistering connectivity change receiver");
            this.zzb = false;
            this.zzc = false;
            try {
                zzpvVar.zzaT().unregisterReceiver(this);
            } catch (IllegalArgumentException e) {
                this.zza.zzaW().zze().zzb("Failed to unregister the network broadcast receiver", e);
            }
        }
    }
}
