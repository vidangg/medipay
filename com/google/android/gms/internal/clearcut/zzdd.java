package com.google.android.gms.internal.clearcut;

import com.google.android.gms.internal.clearcut.zzcg;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class zzdd implements zzeg {
    private static final zzdn zzlz = new zzde();
    private final zzdn zzly;

    public zzdd() {
        this(new zzdf(zzcf.zzay(), zzby()));
    }

    private zzdd(zzdn zzdnVar) {
        this.zzly = (zzdn) zzci.zza(zzdnVar, "messageInfoFactory");
    }

    private static boolean zza(zzdm zzdmVar) {
        return zzdmVar.zzcf() == zzcg.zzg.zzkl;
    }

    private static zzdn zzby() {
        try {
            return (zzdn) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", null).invoke(null, null);
        } catch (Exception unused) {
            return zzlz;
        }
    }

    @Override // com.google.android.gms.internal.clearcut.zzeg
    public final <T> zzef<T> zzd(Class<T> cls) {
        zzeh.zzf((Class<?>) cls);
        zzdm zzb = this.zzly.zzb(cls);
        if (zzb.zzcg()) {
            return zzcg.class.isAssignableFrom(cls) ? zzdu.zza(zzeh.zzdo(), zzbx.zzap(), zzb.zzch()) : zzdu.zza(zzeh.zzdm(), zzbx.zzaq(), zzb.zzch());
        }
        if (!zzcg.class.isAssignableFrom(cls)) {
            boolean zza = zza(zzb);
            zzdw zzcj = zzdy.zzcj();
            zzcy zzbv = zzcy.zzbv();
            return zza ? zzds.zza(cls, zzb, zzcj, zzbv, zzeh.zzdm(), zzbx.zzaq(), zzdl.zzcc()) : zzds.zza(cls, zzb, zzcj, zzbv, zzeh.zzdn(), (zzbu<?>) null, zzdl.zzcc());
        }
        boolean zza2 = zza(zzb);
        zzdw zzck = zzdy.zzck();
        zzcy zzbw = zzcy.zzbw();
        zzex<?, ?> zzdo = zzeh.zzdo();
        return zza2 ? zzds.zza(cls, zzb, zzck, zzbw, zzdo, zzbx.zzap(), zzdl.zzcd()) : zzds.zza(cls, zzb, zzck, zzbw, zzdo, (zzbu<?>) null, zzdl.zzcd());
    }
}
