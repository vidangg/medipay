package com.google.android.gms.internal.fido;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-fido@@20.0.1 */
/* loaded from: classes3.dex */
public abstract class zzf extends zzb implements zzg {
    public zzf() {
        super("com.google.android.gms.fido.fido2.api.ICredentialListCallback");
    }

    @Override // com.google.android.gms.internal.fido.zzb
    protected final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 1) {
            ArrayList zzb = zzc.zzb(parcel);
            zzc.zzc(parcel);
            zzb(zzb);
        } else {
            if (i != 2) {
                return false;
            }
            Status status = (Status) zzc.zza(parcel, Status.CREATOR);
            zzc.zzc(parcel);
            zzc(status);
        }
        parcel2.writeNoException();
        return true;
    }
}
