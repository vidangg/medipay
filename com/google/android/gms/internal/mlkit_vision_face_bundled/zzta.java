package com.google.android.gms.internal.mlkit_vision_face_bundled;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.mlkit:face-detection@@16.1.7 */
/* loaded from: classes3.dex */
public abstract class zzta extends zzb implements zztb {
    public zzta() {
        super("com.google.mlkit.vision.face.aidls.IFaceDetectorCreator");
    }

    public static zztb asInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.mlkit.vision.face.aidls.IFaceDetectorCreator");
        return queryLocalInterface instanceof zztb ? (zztb) queryLocalInterface : new zzsz(iBinder);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzb
    protected final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i != 1) {
            return false;
        }
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
        zzst zzstVar = (zzst) zzc.zza(parcel, zzst.CREATOR);
        zzc.zzb(parcel);
        zzsy newFaceDetector = newFaceDetector(asInterface, zzstVar);
        parcel2.writeNoException();
        if (newFaceDetector == null) {
            parcel2.writeStrongBinder(null);
        } else {
            parcel2.writeStrongBinder(newFaceDetector.asBinder());
        }
        return true;
    }
}
