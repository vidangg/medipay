package com.google.android.gms.internal.measurement;

import sun.misc.Unsafe;

/* compiled from: com.google.android.gms:play-services-measurement-base@@22.4.0 */
/* loaded from: classes3.dex */
final class zzoi extends zzok {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzoi(Unsafe unsafe) {
        super(unsafe);
    }

    @Override // com.google.android.gms.internal.measurement.zzok
    public final double zza(Object obj, long j) {
        return Double.longBitsToDouble(this.zza.getLong(obj, j));
    }

    @Override // com.google.android.gms.internal.measurement.zzok
    public final float zzb(Object obj, long j) {
        return Float.intBitsToFloat(this.zza.getInt(obj, j));
    }

    @Override // com.google.android.gms.internal.measurement.zzok
    public final void zzc(Object obj, long j, boolean z) {
        if (zzol.zzb) {
            zzol.zzD(obj, j, r3 ? (byte) 1 : (byte) 0);
        } else {
            zzol.zzE(obj, j, r3 ? (byte) 1 : (byte) 0);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzok
    public final void zzd(Object obj, long j, byte b) {
        if (zzol.zzb) {
            zzol.zzD(obj, j, b);
        } else {
            zzol.zzE(obj, j, b);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzok
    public final void zze(Object obj, long j, double d) {
        this.zza.putLong(obj, j, Double.doubleToLongBits(d));
    }

    @Override // com.google.android.gms.internal.measurement.zzok
    public final void zzf(Object obj, long j, float f) {
        this.zza.putInt(obj, j, Float.floatToIntBits(f));
    }

    @Override // com.google.android.gms.internal.measurement.zzok
    public final boolean zzg(Object obj, long j) {
        if (zzol.zzb) {
            return zzol.zzt(obj, j);
        }
        return zzol.zzu(obj, j);
    }
}
