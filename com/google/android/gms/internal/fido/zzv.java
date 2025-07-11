package com.google.android.gms.internal.fido;

import android.app.PendingIntent;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;

/* compiled from: com.google.android.gms:play-services-fido@@20.0.1 */
/* loaded from: classes3.dex */
public interface zzv extends IInterface {
    void zzb(Status status, PendingIntent pendingIntent) throws RemoteException;
}
