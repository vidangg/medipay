package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.4.0 */
/* loaded from: classes3.dex */
public final class zzhg extends zzmd implements zzni {
    private static final zzhg zzb;
    private int zzd;
    private boolean zze;
    private boolean zzf;
    private boolean zzg;
    private boolean zzh;
    private boolean zzi;
    private boolean zzj;
    private boolean zzk;

    static {
        zzhg zzhgVar = new zzhg();
        zzb = zzhgVar;
        zzmd.zzct(zzhg.class, zzhgVar);
    }

    private zzhg() {
    }

    public static zzhf zza() {
        return (zzhf) zzb.zzcg();
    }

    public static zzhg zzc() {
        return zzb;
    }

    public static /* synthetic */ void zzd(zzhg zzhgVar, boolean z) {
        zzhgVar.zzd |= 32;
        zzhgVar.zzj = z;
    }

    public static /* synthetic */ void zze(zzhg zzhgVar, boolean z) {
        zzhgVar.zzd |= 16;
        zzhgVar.zzi = z;
    }

    public static /* synthetic */ void zzf(zzhg zzhgVar, boolean z) {
        zzhgVar.zzd |= 1;
        zzhgVar.zze = z;
    }

    public static /* synthetic */ void zzg(zzhg zzhgVar, boolean z) {
        zzhgVar.zzd |= 64;
        zzhgVar.zzk = z;
    }

    public static /* synthetic */ void zzh(zzhg zzhgVar, boolean z) {
        zzhgVar.zzd |= 2;
        zzhgVar.zzf = z;
    }

    public static /* synthetic */ void zzi(zzhg zzhgVar, boolean z) {
        zzhgVar.zzd |= 4;
        zzhgVar.zzg = z;
    }

    public static /* synthetic */ void zzj(zzhg zzhgVar, boolean z) {
        zzhgVar.zzd |= 8;
        zzhgVar.zzh = z;
    }

    public final boolean zzk() {
        return this.zzj;
    }

    @Override // com.google.android.gms.internal.measurement.zzmd
    public final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzcq(zzb, "\u0004\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0000\u0000\u0001ဇ\u0000\u0002ဇ\u0001\u0003ဇ\u0002\u0004ဇ\u0003\u0005ဇ\u0004\u0006ဇ\u0005\u0007ဇ\u0006", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk"});
        }
        if (i2 == 3) {
            return new zzhg();
        }
        if (i2 == 4) {
            return new zzhf(null);
        }
        if (i2 == 5) {
            return zzb;
        }
        throw null;
    }

    public final boolean zzm() {
        return this.zzi;
    }

    public final boolean zzn() {
        return this.zze;
    }

    public final boolean zzo() {
        return this.zzk;
    }

    public final boolean zzp() {
        return this.zzf;
    }

    public final boolean zzq() {
        return this.zzg;
    }

    public final boolean zzr() {
        return this.zzh;
    }
}
