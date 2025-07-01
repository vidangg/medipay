package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-base@@22.4.0 */
/* loaded from: classes3.dex */
final class zzmz implements zznt {
    private static final zznf zza = new zzmx();
    private final zznf zzb;

    public zzmz() {
        zznf zznfVar = zza;
        int i = zznp.zza;
        zzmy zzmyVar = new zzmy(zzly.zza(), zznfVar);
        byte[] bArr = zzmk.zzb;
        this.zzb = zzmyVar;
    }

    @Override // com.google.android.gms.internal.measurement.zznt
    public final zzns zza(Class cls) {
        int i = zznu.zza;
        if (!zzmd.class.isAssignableFrom(cls)) {
            int i2 = zznp.zza;
        }
        zzne zzb = this.zzb.zzb(cls);
        if (!zzb.zzb()) {
            int i3 = zznp.zza;
            return zznk.zzl(cls, zzb, zznn.zza(), zzmv.zza(), zznu.zzm(), zzb.zzc() + (-1) != 1 ? zzls.zza() : null, zznd.zza());
        }
        int i4 = zznp.zza;
        return zznl.zzc(zznu.zzm(), zzls.zza(), zzb.zza());
    }
}
