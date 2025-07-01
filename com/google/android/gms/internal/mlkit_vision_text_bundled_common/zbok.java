package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.List;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
public final class zbok extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zbok> CREATOR = new zbol();
    private final String zba;
    private final List zbb;

    public zbok(String str, List list) {
        this.zba = str;
        this.zbb = list;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        String str = this.zba;
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, str, false);
        SafeParcelWriter.writeTypedList(parcel, 2, this.zbb, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
