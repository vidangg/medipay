package com.google.android.gms.internal.vision;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
/* loaded from: classes3.dex */
final class zzcv<T> extends zzcy<T> {
    static final zzcv<Object> zza = new zzcv<>();

    private zzcv() {
    }

    public final boolean equals(@NullableDecl Object obj) {
        return obj == this;
    }

    public final int hashCode() {
        return 2040732332;
    }

    @Override // com.google.android.gms.internal.vision.zzcy
    public final boolean zza() {
        return false;
    }

    @Override // com.google.android.gms.internal.vision.zzcy
    public final T zzb() {
        throw new IllegalStateException("Optional.get() cannot be called on an absent value");
    }

    public final String toString() {
        return "Optional.absent()";
    }
}
