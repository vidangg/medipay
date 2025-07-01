package com.google.android.gms.vision.barcode;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.camera.video.AudioStats;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.vision.barcode.Barcode;

/* compiled from: com.google.android.gms:play-services-vision@@20.1.3 */
/* loaded from: classes3.dex */
public final class zzj implements Parcelable.Creator<Barcode.GeoPoint> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Barcode.GeoPoint[] newArray(int i) {
        return new Barcode.GeoPoint[i];
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Barcode.GeoPoint createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        double d = AudioStats.AUDIO_AMPLITUDE_NONE;
        double d2 = 0.0d;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            int fieldId = SafeParcelReader.getFieldId(readHeader);
            if (fieldId == 2) {
                d = SafeParcelReader.readDouble(parcel, readHeader);
            } else if (fieldId == 3) {
                d2 = SafeParcelReader.readDouble(parcel, readHeader);
            } else {
                SafeParcelReader.skipUnknownField(parcel, readHeader);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new Barcode.GeoPoint(d, d2);
    }
}
