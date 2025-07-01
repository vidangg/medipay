package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
public abstract class zbnz extends zbb implements zboa {
    public zbnz() {
        super("com.google.mlkit.vision.text.aidls.ITextRecognizer");
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbb
    protected final boolean zba(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 1) {
            zbc();
            parcel2.writeNoException();
        } else if (i == 2) {
            zbd();
            parcel2.writeNoException();
        } else if (i == 3) {
            IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
            zbnx zbnxVar = (zbnx) zbc.zba(parcel, zbnx.CREATOR);
            zbc.zbb(parcel);
            zbok zbb = zbb(asInterface, zbnxVar);
            parcel2.writeNoException();
            parcel2.writeInt(1);
            zbb.writeToParcel(parcel2, 1);
        } else {
            if (i != 4) {
                return false;
            }
            IObjectWrapper asInterface2 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
            zbnx zbnxVar2 = (zbnx) zbc.zba(parcel, zbnx.CREATOR);
            zbc.zbb(parcel);
            zbf[] zbe = zbe(asInterface2, zbnxVar2);
            parcel2.writeNoException();
            parcel2.writeTypedArray(zbe, 1);
        }
        return true;
    }
}
