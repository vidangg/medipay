package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.4.0 */
/* loaded from: classes3.dex */
public final class zzhs extends zzmd implements zzni {
    private static final zzhs zzb;
    private int zzd;
    private String zze = "";
    private String zzf = "";
    private zzhe zzg;

    static {
        zzhs zzhsVar = new zzhs();
        zzb = zzhsVar;
        zzmd.zzct(zzhs.class, zzhsVar);
    }

    private zzhs() {
    }

    @Override // com.google.android.gms.internal.measurement.zzmd
    public final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzcq(zzb, "\u0004\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဉ\u0002", new Object[]{"zzd", "zze", "zzf", "zzg"});
        }
        if (i2 == 3) {
            return new zzhs();
        }
        if (i2 == 4) {
            return new zzhr(null);
        }
        if (i2 == 5) {
            return zzb;
        }
        throw null;
    }
}
