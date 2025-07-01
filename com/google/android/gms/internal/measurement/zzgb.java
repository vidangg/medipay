package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement@@22.4.0 */
/* loaded from: classes3.dex */
public final class zzgb extends zzmd implements zzni {
    private static final zzgb zzb;
    private int zzd;
    private int zze;
    private int zzf;

    static {
        zzgb zzgbVar = new zzgb();
        zzb = zzgbVar;
        zzmd.zzct(zzgb.class, zzgbVar);
    }

    private zzgb() {
    }

    public final int zzb() {
        int zza = zzgf.zza(this.zzf);
        if (zza == 0) {
            return 1;
        }
        return zza;
    }

    public final int zzc() {
        int zza = zzgf.zza(this.zze);
        if (zza == 0) {
            return 1;
        }
        return zza;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.zzmd
    public final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            zzmg zzmgVar = zzge.zza;
            return zzcq(zzb, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001᠌\u0000\u0002᠌\u0001", new Object[]{"zzd", "zze", zzmgVar, "zzf", zzmgVar});
        }
        if (i2 == 3) {
            return new zzgb();
        }
        zzgz zzgzVar = null;
        if (i2 == 4) {
            return new zzga(zzgzVar);
        }
        if (i2 == 5) {
            return zzb;
        }
        throw null;
    }
}
