package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
public interface zbod extends IInterface {
    zboa newTextRecognizer(IObjectWrapper iObjectWrapper) throws RemoteException;

    zboa newTextRecognizerWithOptions(IObjectWrapper iObjectWrapper, zbom zbomVar) throws RemoteException;
}
