package com.google.android.gms.flags;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* loaded from: classes3.dex */
public final class zze extends com.google.android.gms.internal.flags.zza implements zzc {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zze(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.flags.IFlagProvider");
    }

    @Override // com.google.android.gms.flags.zzc
    public final void init(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.flags.zzc.zza(zza, iObjectWrapper);
        zzb(1, zza);
    }

    @Override // com.google.android.gms.flags.zzc
    public final boolean getBooleanFlagValue(String str, boolean z, int i) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        com.google.android.gms.internal.flags.zzc.writeBoolean(zza, z);
        zza.writeInt(i);
        Parcel zza2 = zza(2, zza);
        boolean zza3 = com.google.android.gms.internal.flags.zzc.zza(zza2);
        zza2.recycle();
        return zza3;
    }

    @Override // com.google.android.gms.flags.zzc
    public final int getIntFlagValue(String str, int i, int i2) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeInt(i);
        zza.writeInt(i2);
        Parcel zza2 = zza(3, zza);
        int readInt = zza2.readInt();
        zza2.recycle();
        return readInt;
    }

    @Override // com.google.android.gms.flags.zzc
    public final long getLongFlagValue(String str, long j, int i) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeLong(j);
        zza.writeInt(i);
        Parcel zza2 = zza(4, zza);
        long readLong = zza2.readLong();
        zza2.recycle();
        return readLong;
    }

    @Override // com.google.android.gms.flags.zzc
    public final String getStringFlagValue(String str, String str2, int i) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        zza.writeInt(i);
        Parcel zza2 = zza(5, zza);
        String readString = zza2.readString();
        zza2.recycle();
        return readString;
    }
}
