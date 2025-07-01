package com.google.android.gms.internal.measurement;

import android.os.IBinder;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-measurement-base@@22.4.0 */
/* loaded from: classes3.dex */
public final class zzcz extends zzbm implements zzdb {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcz(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.api.internal.IDynamiteUploadBatchesCallback");
    }

    @Override // com.google.android.gms.internal.measurement.zzdb
    public final void zze() throws RemoteException {
        zzd(2, zza());
    }
}
