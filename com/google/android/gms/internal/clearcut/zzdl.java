package com.google.android.gms.internal.clearcut;

/* loaded from: classes3.dex */
final class zzdl {
    private static final zzdj zzmf = zzce();
    private static final zzdj zzmg = new zzdk();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzdj zzcc() {
        return zzmf;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzdj zzcd() {
        return zzmg;
    }

    private static zzdj zzce() {
        try {
            return (zzdj) Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor(null).newInstance(null);
        } catch (Exception unused) {
            return null;
        }
    }
}
