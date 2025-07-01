package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.Intent;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement@@22.4.0 */
/* loaded from: classes3.dex */
public final class zzhx {
    private final zza zza;

    /* compiled from: com.google.android.gms:play-services-measurement@@22.4.0 */
    /* loaded from: classes3.dex */
    public interface zza {
        void doStartService(Context context, Intent intent);
    }

    public zzhx(zza zzaVar) {
        Preconditions.checkNotNull(zzaVar);
        this.zza = zzaVar;
    }

    public final void zza(Context context, Intent intent) {
        zzio zzp = zzio.zzp(context, null, null);
        zzhe zzaW = zzp.zzaW();
        if (intent == null) {
            zzaW.zzk().zza("Receiver called with null intent");
            return;
        }
        zzp.zzaV();
        String action = intent.getAction();
        zzaW.zzj().zzb("Local receiver got", action);
        if ("com.google.android.gms.measurement.UPLOAD".equals(action)) {
            Intent className = new Intent().setClassName(context, "com.google.android.gms.measurement.AppMeasurementService");
            className.setAction("com.google.android.gms.measurement.UPLOAD");
            zzaW.zzj().zza("Starting wakeful intent.");
            this.zza.doStartService(context, className);
            return;
        }
        if ("com.android.vending.INSTALL_REFERRER".equals(action)) {
            zzaW.zzk().zza("Install Referrer Broadcasts are deprecated");
        }
    }
}
