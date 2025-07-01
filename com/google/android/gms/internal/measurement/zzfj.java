package com.google.android.gms.internal.measurement;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@22.4.0 */
/* loaded from: classes3.dex */
public final class zzfj extends zzmd implements zzni {
    private static final zzfj zzb;
    private int zzd;
    private int zze;
    private String zzf = "";
    private zzmj zzg = zzcn();
    private boolean zzh;
    private zzfp zzi;
    private boolean zzj;
    private boolean zzk;
    private boolean zzl;

    static {
        zzfj zzfjVar = new zzfj();
        zzb = zzfjVar;
        zzmd.zzct(zzfj.class, zzfjVar);
    }

    private zzfj() {
    }

    public static zzfi zzc() {
        return (zzfi) zzb.zzcg();
    }

    public static /* synthetic */ void zzi(zzfj zzfjVar, String str) {
        zzfjVar.zzd |= 2;
        zzfjVar.zzf = str;
    }

    public static /* synthetic */ void zzj(zzfj zzfjVar, int i, zzfl zzflVar) {
        zzflVar.getClass();
        zzmj zzmjVar = zzfjVar.zzg;
        if (!zzmjVar.zzc()) {
            zzfjVar.zzg = zzmd.zzco(zzmjVar);
        }
        zzfjVar.zzg.set(i, zzflVar);
    }

    public final int zza() {
        return this.zzg.size();
    }

    public final int zzb() {
        return this.zze;
    }

    public final zzfl zze(int i) {
        return (zzfl) this.zzg.get(i);
    }

    public final zzfp zzf() {
        zzfp zzfpVar = this.zzi;
        return zzfpVar == null ? zzfp.zzb() : zzfpVar;
    }

    public final String zzg() {
        return this.zzf;
    }

    public final List zzh() {
        return this.zzg;
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
            return zzcq(zzb, "\u0004\b\u0000\u0001\u0001\b\b\u0000\u0001\u0000\u0001င\u0000\u0002ဈ\u0001\u0003\u001b\u0004ဇ\u0002\u0005ဉ\u0003\u0006ဇ\u0004\u0007ဇ\u0005\bဇ\u0006", new Object[]{"zzd", "zze", "zzf", "zzg", zzfl.class, "zzh", "zzi", "zzj", "zzk", "zzl"});
        }
        if (i2 == 3) {
            return new zzfj();
        }
        if (i2 == 4) {
            return new zzfi(null);
        }
        if (i2 == 5) {
            return zzb;
        }
        throw null;
    }

    public final boolean zzm() {
        return this.zzk;
    }

    public final boolean zzn() {
        return this.zzl;
    }

    public final boolean zzo() {
        return (this.zzd & 8) != 0;
    }

    public final boolean zzp() {
        return (this.zzd & 1) != 0;
    }

    public final boolean zzq() {
        return (this.zzd & 64) != 0;
    }
}
