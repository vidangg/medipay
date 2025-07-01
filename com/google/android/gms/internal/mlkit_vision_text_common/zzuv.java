package com.google.android.gms.internal.mlkit_vision_text_common;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition-common@@19.1.0 */
/* loaded from: classes3.dex */
public final class zzuv extends zza implements IInterface {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzuv(IBinder iBinder) {
        super(iBinder, "com.google.mlkit.vision.text.aidls.ITextRecognizer");
    }

    public final zzvf zzd(IObjectWrapper iObjectWrapper, zzuq zzuqVar) throws RemoteException {
        Parcel zza = zza();
        zzc.zzb(zza, iObjectWrapper);
        zzc.zza(zza, zzuqVar);
        Parcel zzb = zzb(3, zza);
        zzvf createFromParcel = zzb.readInt() == 0 ? null : zzvf.CREATOR.createFromParcel(zzb);
        zzb.recycle();
        return createFromParcel;
    }

    public final void zze() throws RemoteException {
        zzc(1, zza());
    }

    public final void zzf() throws RemoteException {
        zzc(2, zza());
    }
}
