package com.google.android.gms.internal.mlkit_vision_text_common;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition-common@@19.1.0 */
/* loaded from: classes3.dex */
public final class zzuw extends zza implements zzuy {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzuw(IBinder iBinder) {
        super(iBinder, "com.google.mlkit.vision.text.aidls.ITextRecognizerCreator");
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_common.zzuy
    public final zzuv zzd(IObjectWrapper iObjectWrapper) throws RemoteException {
        zzuv zzuvVar;
        Parcel zza = zza();
        zzc.zzb(zza, iObjectWrapper);
        Parcel zzb = zzb(1, zza);
        IBinder readStrongBinder = zzb.readStrongBinder();
        if (readStrongBinder == null) {
            zzuvVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.mlkit.vision.text.aidls.ITextRecognizer");
            zzuvVar = queryLocalInterface instanceof zzuv ? (zzuv) queryLocalInterface : new zzuv(readStrongBinder);
        }
        zzb.recycle();
        return zzuvVar;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_common.zzuy
    public final zzuv zze(IObjectWrapper iObjectWrapper, zzvh zzvhVar) throws RemoteException {
        zzuv zzuvVar;
        Parcel zza = zza();
        zzc.zzb(zza, iObjectWrapper);
        zzc.zza(zza, zzvhVar);
        Parcel zzb = zzb(2, zza);
        IBinder readStrongBinder = zzb.readStrongBinder();
        if (readStrongBinder == null) {
            zzuvVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.mlkit.vision.text.aidls.ITextRecognizer");
            zzuvVar = queryLocalInterface instanceof zzuv ? (zzuv) queryLocalInterface : new zzuv(readStrongBinder);
        }
        zzb.recycle();
        return zzuvVar;
    }
}
