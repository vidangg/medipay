package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@22.4.0 */
/* loaded from: classes3.dex */
final class zzfc extends zzeu {
    final /* synthetic */ Activity zza;
    final /* synthetic */ zzcs zzb;
    final /* synthetic */ zzfe zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzfc(zzfe zzfeVar, Activity activity, zzcs zzcsVar) {
        super(zzfeVar.zza, true);
        this.zza = activity;
        this.zzb = zzcsVar;
        this.zzc = zzfeVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzeu
    final void zza() throws RemoteException {
        zzcv zzcvVar;
        zzcvVar = this.zzc.zza.zzj;
        ((zzcv) Preconditions.checkNotNull(zzcvVar)).onActivitySaveInstanceStateByScionActivityInfo(zzdj.zza(this.zza), this.zzb, this.zzi);
    }
}
