package com.google.android.gms.common.api;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: com.google.android.gms:play-services-basement@@18.5.0 */
/* loaded from: classes3.dex */
public final class zzb implements Parcelable.Creator {
    public static final ApiMetadata zza(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        ComplianceOptions complianceOptions = null;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            if (SafeParcelReader.getFieldId(readHeader) == 1) {
                complianceOptions = (ComplianceOptions) SafeParcelReader.createParcelable(parcel, readHeader, ComplianceOptions.CREATOR);
            } else {
                SafeParcelReader.skipUnknownField(parcel, readHeader);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new ApiMetadata(complianceOptions);
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zza(parcel);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new ApiMetadata[i];
    }
}
