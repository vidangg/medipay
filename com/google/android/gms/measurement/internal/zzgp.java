package com.google.android.gms.measurement.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.4.0 */
/* loaded from: classes3.dex */
public final class zzgp extends com.google.android.gms.internal.measurement.zzbm implements zzgr {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzgp(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.internal.IUploadBatchesCallback");
    }

    @Override // com.google.android.gms.measurement.internal.zzgr
    public final void zze(zzpe zzpeVar) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.measurement.zzbo.zzd(zza, zzpeVar);
        zzd(2, zza);
    }
}
