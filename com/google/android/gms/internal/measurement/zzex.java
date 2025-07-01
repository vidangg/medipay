package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@22.4.0 */
/* loaded from: classes3.dex */
final class zzex extends zzeu {
    final /* synthetic */ Bundle zza;
    final /* synthetic */ Activity zzb;
    final /* synthetic */ zzfe zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzex(zzfe zzfeVar, Bundle bundle, Activity activity) {
        super(zzfeVar.zza, true);
        this.zza = bundle;
        this.zzb = activity;
        this.zzc = zzfeVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzeu
    final void zza() throws RemoteException {
        Bundle bundle;
        zzcv zzcvVar;
        Bundle bundle2 = this.zza;
        if (bundle2 != null) {
            bundle = new Bundle();
            if (bundle2.containsKey("com.google.app_measurement.screen_service")) {
                Object obj = bundle2.get("com.google.app_measurement.screen_service");
                if (obj instanceof Bundle) {
                    bundle.putBundle("com.google.app_measurement.screen_service", (Bundle) obj);
                }
            }
        } else {
            bundle = null;
        }
        zzcvVar = this.zzc.zza.zzj;
        zzcv zzcvVar2 = (zzcv) Preconditions.checkNotNull(zzcvVar);
        Activity activity = this.zzb;
        zzcvVar2.onActivityCreatedByScionActivityInfo(zzdj.zza(activity), bundle, this.zzi);
    }
}
