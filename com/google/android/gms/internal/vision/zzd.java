package com.google.android.gms.internal.vision;

import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
/* loaded from: classes3.dex */
public class zzd {
    private static final ClassLoader zza = zzd.class.getClassLoader();

    private zzd() {
    }

    public static boolean zza(Parcel parcel) {
        return parcel.readInt() != 0;
    }

    public static void zza(Parcel parcel, boolean z) {
        parcel.writeInt(z ? 1 : 0);
    }

    public static <T extends Parcelable> T zza(Parcel parcel, Parcelable.Creator<T> creator) {
        if (parcel.readInt() == 0) {
            return null;
        }
        return creator.createFromParcel(parcel);
    }

    public static void zza(Parcel parcel, Parcelable parcelable) {
        if (parcelable == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcelable.writeToParcel(parcel, 0);
        }
    }

    public static void zza(Parcel parcel, IInterface iInterface) {
        if (iInterface == null) {
            parcel.writeStrongBinder(null);
        } else {
            parcel.writeStrongBinder(iInterface.asBinder());
        }
    }
}
