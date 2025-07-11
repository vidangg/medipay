package com.google.android.gms.internal.vision;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
/* loaded from: classes3.dex */
public class zzeh<K, V> extends zzdn<K, V> implements Serializable {
    private final transient zzef<K, ? extends zzeb<V>> zza;
    private final transient int zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzeh(zzef<K, ? extends zzeb<V>> zzefVar, int i) {
        this.zza = zzefVar;
        this.zzb = i;
    }

    @Override // com.google.android.gms.internal.vision.zzdo
    public final boolean zza(@NullableDecl Object obj) {
        return obj != null && super.zza(obj);
    }

    @Override // com.google.android.gms.internal.vision.zzdo
    final Map<K, Collection<V>> zzb() {
        throw new AssertionError("should never be called");
    }

    @Override // com.google.android.gms.internal.vision.zzdo
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    @Override // com.google.android.gms.internal.vision.zzdo
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.google.android.gms.internal.vision.zzdo
    public /* bridge */ /* synthetic */ boolean equals(@NullableDecl Object obj) {
        return super.equals(obj);
    }

    @Override // com.google.android.gms.internal.vision.zzdo, com.google.android.gms.internal.vision.zzen
    public final /* synthetic */ Map zza() {
        return this.zza;
    }
}
