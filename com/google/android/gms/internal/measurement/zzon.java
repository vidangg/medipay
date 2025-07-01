package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-base@@22.4.0 */
/* loaded from: classes3.dex */
final class zzon extends IllegalArgumentException {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzon(int i, int i2) {
        super("Unpaired surrogate at index " + i + " of " + i2);
    }
}
