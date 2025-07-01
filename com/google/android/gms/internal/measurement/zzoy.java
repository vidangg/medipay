package com.google.android.gms.internal.measurement;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import org.checkerframework.dataflow.qual.SideEffectFree;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.4.0 */
/* loaded from: classes3.dex */
public final class zzoy implements Supplier {
    private static final zzoy zza = new zzoy();
    private final Supplier zzb = Suppliers.ofInstance(new zzpa());

    @SideEffectFree
    public static boolean zzb() {
        zza.get().zza();
        return true;
    }

    @SideEffectFree
    public static boolean zzc() {
        return zza.get().zzb();
    }

    @Override // com.google.common.base.Supplier
    /* renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzoz get() {
        return (zzoz) this.zzb.get();
    }
}
