package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
public abstract class zboc extends zbb implements zbod {
    public zboc() {
        super("com.google.mlkit.vision.text.aidls.ITextRecognizerCreator");
    }

    public static zbod asInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.mlkit.vision.text.aidls.ITextRecognizerCreator");
        return queryLocalInterface instanceof zbod ? (zbod) queryLocalInterface : new zbob(iBinder);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbb
    protected final boolean zba(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 1) {
            IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
            zbc.zbb(parcel);
            zboa newTextRecognizer = newTextRecognizer(asInterface);
            parcel2.writeNoException();
            zbc.zbc(parcel2, newTextRecognizer);
        } else {
            if (i != 2) {
                return false;
            }
            IObjectWrapper asInterface2 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
            zbom zbomVar = (zbom) zbc.zba(parcel, zbom.CREATOR);
            zbc.zbb(parcel);
            zboa newTextRecognizerWithOptions = newTextRecognizerWithOptions(asInterface2, zbomVar);
            parcel2.writeNoException();
            zbc.zbc(parcel2, newTextRecognizerWithOptions);
        }
        return true;
    }
}
