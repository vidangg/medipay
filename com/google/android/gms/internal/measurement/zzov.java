package com.google.android.gms.internal.measurement;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import org.checkerframework.dataflow.qual.SideEffectFree;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.4.0 */
/* loaded from: classes3.dex */
public final class zzov implements Supplier {
    private static final zzov zza = new zzov();
    private final Supplier zzb = Suppliers.ofInstance(new zzox());

    @SideEffectFree
    public static boolean zzb() {
        return zza.get().zza();
    }

    @SideEffectFree
    public static boolean zzc() {
        return zza.get().zzb();
    }

    @Override // com.google.common.base.Supplier
    /* renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzow get() {
        return (zzow) this.zzb.get();
    }
}
