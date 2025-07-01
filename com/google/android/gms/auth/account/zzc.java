package com.google.android.gms.auth.account;

import android.accounts.Account;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-auth-base@@18.0.10 */
/* loaded from: classes3.dex */
public final class zzc extends com.google.android.gms.internal.auth.zza implements zze {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzc(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.auth.account.IWorkAccountService");
    }

    @Override // com.google.android.gms.auth.account.zze
    public final void zzd(zzb zzbVar, String str) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.auth.zzc.zzd(zza, zzbVar);
        zza.writeString(str);
        zzc(2, zza);
    }

    @Override // com.google.android.gms.auth.account.zze
    public final void zze(zzb zzbVar, Account account) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.auth.zzc.zzd(zza, zzbVar);
        com.google.android.gms.internal.auth.zzc.zzc(zza, account);
        zzc(3, zza);
    }

    @Override // com.google.android.gms.auth.account.zze
    public final void zzf(boolean z) throws RemoteException {
        Parcel zza = zza();
        int i = com.google.android.gms.internal.auth.zzc.zza;
        zza.writeInt(z ? 1 : 0);
        zzc(1, zza);
    }
}
