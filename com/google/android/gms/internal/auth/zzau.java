package com.google.android.gms.internal.auth;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-auth-base@@18.0.10 */
/* loaded from: classes3.dex */
public final class zzau extends zza implements IInterface {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzau(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.auth.api.accounttransfer.internal.IAccountTransferService");
    }

    public final void zzd(zzat zzatVar, zzaq zzaqVar) throws RemoteException {
        Parcel zza = zza();
        zzc.zzd(zza, zzatVar);
        zzc.zzc(zza, zzaqVar);
        zzc(7, zza);
    }

    public final void zze(zzat zzatVar, zzbb zzbbVar) throws RemoteException {
        Parcel zza = zza();
        zzc.zzd(zza, zzatVar);
        zzc.zzc(zza, zzbbVar);
        zzc(8, zza);
    }

    public final void zzf(zzat zzatVar, zzav zzavVar) throws RemoteException {
        Parcel zza = zza();
        zzc.zzd(zza, zzatVar);
        zzc.zzc(zza, zzavVar);
        zzc(9, zza);
    }

    public final void zzg(zzat zzatVar, zzax zzaxVar) throws RemoteException {
        Parcel zza = zza();
        zzc.zzd(zza, zzatVar);
        zzc.zzc(zza, zzaxVar);
        zzc(6, zza);
    }

    public final void zzh(zzat zzatVar, zzaz zzazVar) throws RemoteException {
        Parcel zza = zza();
        zzc.zzd(zza, zzatVar);
        zzc.zzc(zza, zzazVar);
        zzc(5, zza);
    }
}
