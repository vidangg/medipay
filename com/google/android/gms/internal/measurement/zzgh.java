package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement@@22.4.0 */
/* loaded from: classes3.dex */
public final class zzgh extends zzmd implements zzni {
    private static final zzgh zzb;
    private int zzd;
    private String zze = "";
    private String zzf = "";

    static {
        zzgh zzghVar = new zzgh();
        zzb = zzghVar;
        zzmd.zzct(zzgh.class, zzghVar);
    }

    private zzgh() {
    }

    public final String zzb() {
        return this.zze;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.zzmd
    public final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzcq(zzb, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001", new Object[]{"zzd", "zze", "zzf"});
        }
        if (i2 == 3) {
            return new zzgh();
        }
        zzgz zzgzVar = null;
        if (i2 == 4) {
            return new zzgg(zzgzVar);
        }
        if (i2 == 5) {
            return zzb;
        }
        throw null;
    }
}
