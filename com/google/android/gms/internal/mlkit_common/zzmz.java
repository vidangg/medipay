package com.google.android.gms.internal.mlkit_common;

/* compiled from: com.google.mlkit:common@@18.11.0 */
/* loaded from: classes3.dex */
public final class zzmz {
    private zznl zza;
    private Long zzb;
    private zzmu zzc;
    private Long zzd;
    private zzna zze;
    private Long zzf;

    public static /* bridge */ /* synthetic */ zzmu zza(zzmz zzmzVar) {
        return zzmzVar.zzc;
    }

    public static /* bridge */ /* synthetic */ zzna zzh(zzmz zzmzVar) {
        return zzmzVar.zze;
    }

    public static /* bridge */ /* synthetic */ zznl zzj(zzmz zzmzVar) {
        return zzmzVar.zza;
    }

    public static /* bridge */ /* synthetic */ Long zzk(zzmz zzmzVar) {
        return zzmzVar.zzf;
    }

    public static /* bridge */ /* synthetic */ Long zzl(zzmz zzmzVar) {
        return zzmzVar.zzd;
    }

    public static /* bridge */ /* synthetic */ Long zzm(zzmz zzmzVar) {
        return zzmzVar.zzb;
    }

    public final zzmz zzb(Long l) {
        this.zzf = l;
        return this;
    }

    public final zzmz zzc(zzna zznaVar) {
        this.zze = zznaVar;
        return this;
    }

    public final zzmz zzd(zzmu zzmuVar) {
        this.zzc = zzmuVar;
        return this;
    }

    public final zzmz zze(Long l) {
        this.zzd = Long.valueOf(l.longValue() & Long.MAX_VALUE);
        return this;
    }

    public final zzmz zzf(zznl zznlVar) {
        this.zza = zznlVar;
        return this;
    }

    public final zzmz zzg(Long l) {
        this.zzb = Long.valueOf(l.longValue() & Long.MAX_VALUE);
        return this;
    }

    public final zznc zzi() {
        return new zznc(this, null);
    }
}
