package com.google.android.gms.internal.mlkit_vision_text_common;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition-common@@19.1.0 */
/* loaded from: classes3.dex */
public final class zzi extends zza implements zzk {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzi(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.vision.text.internal.client.INativeTextRecognizerCreator");
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_common.zzk
    public final zzh zzd(IObjectWrapper iObjectWrapper, zzp zzpVar) throws RemoteException {
        zzh zzhVar;
        Parcel zza = zza();
        zzc.zzb(zza, iObjectWrapper);
        zzc.zza(zza, zzpVar);
        Parcel zzb = zzb(1, zza);
        IBinder readStrongBinder = zzb.readStrongBinder();
        if (readStrongBinder == null) {
            zzhVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.vision.text.internal.client.INativeTextRecognizer");
            zzhVar = queryLocalInterface instanceof zzh ? (zzh) queryLocalInterface : new zzh(readStrongBinder);
        }
        zzb.recycle();
        return zzhVar;
    }
}
