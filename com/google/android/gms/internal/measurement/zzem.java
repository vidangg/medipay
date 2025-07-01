package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@22.4.0 */
/* loaded from: classes3.dex */
public final class zzem extends zzeu {
    final /* synthetic */ zzcs zza;
    final /* synthetic */ int zzb;
    final /* synthetic */ zzff zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzem(zzff zzffVar, zzcs zzcsVar, int i) {
        super(zzffVar, true);
        this.zza = zzcsVar;
        this.zzb = i;
        this.zzc = zzffVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzeu
    final void zza() throws RemoteException {
        zzcv zzcvVar;
        zzcvVar = this.zzc.zzj;
        ((zzcv) Preconditions.checkNotNull(zzcvVar)).getTestFlag(this.zza, this.zzb);
    }

    @Override // com.google.android.gms.internal.measurement.zzeu
    protected final void zzb() {
        this.zza.zze(null);
    }
}
