package com.google.android.gms.internal.measurement;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import org.checkerframework.dataflow.qual.SideEffectFree;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.4.0 */
/* loaded from: classes3.dex */
public final class zzpn implements Supplier {
    private static final zzpn zza = new zzpn();
    private final Supplier zzb = Suppliers.ofInstance(new zzpp());

    @SideEffectFree
    public static boolean zzb() {
        zza.get().zza();
        return true;
    }

    @SideEffectFree
    public static boolean zzc() {
        return zza.get().zzb();
    }

    @SideEffectFree
    public static boolean zzd() {
        return zza.get().zzc();
    }

    @Override // com.google.common.base.Supplier
    /* renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzpo get() {
        return (zzpo) this.zzb.get();
    }
}
