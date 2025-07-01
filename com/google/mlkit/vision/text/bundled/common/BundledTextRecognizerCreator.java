package com.google.mlkit.vision.text.bundled.common;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zboc;
import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbom;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes4.dex */
public class BundledTextRecognizerCreator extends zboc {
    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbod
    public zba newTextRecognizer(IObjectWrapper iObjectWrapper) throws RemoteException {
        throw new RemoteException("Please use newTextRecognizerWithOptions instead.");
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbod
    public zba newTextRecognizerWithOptions(IObjectWrapper iObjectWrapper, zbom zbomVar) {
        return new zba((Context) Preconditions.checkNotNull((Context) ObjectWrapper.unwrap(iObjectWrapper)), zbomVar.zba(), zbomVar.zbc(), zbomVar.zbb(), zbomVar.zbd());
    }
}
