package com.google.android.gms.internal.clearcut;

import androidx.appcompat.app.AppCompatDelegate;
import java.io.IOException;

/* loaded from: classes3.dex */
public final class zzft extends IOException {
    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public zzft(int i, int i2) {
        super(r0.toString());
        StringBuilder sb = new StringBuilder(AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR);
        sb.append("CodedOutputStream was writing to a flat byte array and ran out of space (pos ");
        sb.append(i);
        sb.append(" limit ");
        sb.append(i2);
        sb.append(").");
    }
}
