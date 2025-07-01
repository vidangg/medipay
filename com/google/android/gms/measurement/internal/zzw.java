package com.google.android.gms.measurement.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.internal.measurement.zzqr;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.4.0 */
/* loaded from: classes3.dex */
public final class zzw extends BroadcastReceiver {
    private final zzio zza;

    public zzw(zzio zzioVar) {
        this.zza = zzioVar;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        char c;
        if (intent == null) {
            this.zza.zzaW().zzk().zza("App receiver called with null intent");
            return;
        }
        String action = intent.getAction();
        if (action == null) {
            this.zza.zzaW().zzk().zza("App receiver called with null action");
            return;
        }
        int hashCode = action.hashCode();
        if (hashCode != -1928239649) {
            if (hashCode == 1279883384 && action.equals("com.google.android.gms.measurement.BATCHES_AVAILABLE")) {
                c = 1;
            }
            c = 65535;
        } else {
            if (action.equals("com.google.android.gms.measurement.TRIGGERS_AVAILABLE")) {
                c = 0;
            }
            c = 65535;
        }
        if (c == 0) {
            final zzio zzioVar = this.zza;
            zzqr.zzb();
            if (zzioVar.zzf().zzx(null, zzgi.zzaW)) {
                zzioVar.zzaW().zzj().zza("App receiver notified triggers are available");
                zzioVar.zzaX().zzq(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzu
                    @Override // java.lang.Runnable
                    public final void run() {
                        zzio zzioVar2 = zzio.this;
                        if (!zzioVar2.zzw().zzan()) {
                            zzioVar2.zzaW().zzk().zza("registerTrigger called but app not eligible");
                            return;
                        }
                        zzioVar2.zzq().zzI();
                        final zzlw zzq = zzioVar2.zzq();
                        Objects.requireNonNull(zzq);
                        new Thread(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzt
                            @Override // java.lang.Runnable
                            public final void run() {
                                zzlw.this.zzL();
                            }
                        }).start();
                    }
                });
                return;
            }
            return;
        }
        if (c == 1) {
            zzio zzioVar2 = this.zza;
            if (zzioVar2.zzf().zzx(null, zzgi.zzaR)) {
                zzioVar2.zzaW().zzj().zza("[sgtm] App Receiver notified batches are available");
                zzioVar2.zzaX().zzq(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzv
                    @Override // java.lang.Runnable
                    public final void run() {
                        zzw.this.zza.zzs().zzj(((Long) zzgi.zzC.zza(null)).longValue());
                    }
                });
                return;
            }
            return;
        }
        this.zza.zzaW().zzk().zza("App receiver called with unknown action");
    }
}
