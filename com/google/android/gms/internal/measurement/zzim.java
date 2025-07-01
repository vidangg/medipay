package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.4.0 */
/* loaded from: classes3.dex */
public final class zzim extends zzmd implements zzni {
    private static final zzim zzb;
    private int zzd;
    private int zze;
    private int zzf;
    private int zzg;

    static {
        zzim zzimVar = new zzim();
        zzb = zzimVar;
        zzmd.zzct(zzim.class, zzimVar);
    }

    private zzim() {
    }

    public static zzif zza() {
        return (zzif) zzb.zzcg();
    }

    public static zzim zzd() {
        return zzb;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zze(zzim zzimVar, zzih zzihVar) {
        zzimVar.zzf = zzihVar.zza();
        zzimVar.zzd |= 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzh(zzim zzimVar, int i) {
        zzimVar.zzg = i - 1;
        zzimVar.zzd |= 4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzi(zzim zzimVar, int i) {
        zzimVar.zze = i - 1;
        zzimVar.zzd |= 1;
    }

    public final zzih zzb() {
        zzih zzb2 = zzih.zzb(this.zzf);
        return zzb2 == null ? zzih.CLIENT_UPLOAD_ELIGIBILITY_UNKNOWN : zzb2;
    }

    public final int zzf() {
        int zza = zzij.zza(this.zzg);
        if (zza == 0) {
            return 1;
        }
        return zza;
    }

    public final int zzg() {
        int zza = zzil.zza(this.zze);
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
            return zzcq(zzb, "\u0004\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001᠌\u0000\u0002᠌\u0001\u0003᠌\u0002", new Object[]{"zzd", "zze", zzik.zza, "zzf", zzig.zza, "zzg", zzii.zza});
        }
        if (i2 == 3) {
            return new zzim();
        }
        zzip zzipVar = null;
        if (i2 == 4) {
            return new zzif(zzipVar);
        }
        if (i2 == 5) {
            return zzb;
        }
        throw null;
    }
}
