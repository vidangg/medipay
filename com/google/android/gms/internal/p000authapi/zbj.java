package com.google.android.gms.internal.p000authapi;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.auth.api.identity.AuthorizationRequest;

/* compiled from: com.google.android.gms:play-services-auth@@21.2.0 */
/* loaded from: classes3.dex */
public final class zbj extends zba implements IInterface {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zbj(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.auth.api.identity.internal.IAuthorizationService");
    }

    public final void zbc(zbi zbiVar, AuthorizationRequest authorizationRequest) throws RemoteException {
        Parcel zba = zba();
        zbc.zbd(zba, zbiVar);
        zbc.zbc(zba, authorizationRequest);
        zbb(1, zba);
    }
}
