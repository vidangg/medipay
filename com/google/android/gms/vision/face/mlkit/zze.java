package com.google.android.gms.vision.face.mlkit;

import android.os.RemoteException;
import com.google.android.gms.common.util.PlatformVersion;

/* compiled from: com.google.mlkit:face-detection@@16.1.7 */
/* loaded from: classes3.dex */
final class zze {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static RemoteException zza(String str) {
        if (PlatformVersion.isAtLeastIceCreamSandwichMR1()) {
            return new RemoteException(str);
        }
        return new RemoteException();
    }
}
