package com.google.android.gms.internal.measurement;

import androidx.camera.video.AudioStats;
import java.util.Iterator;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@22.4.0 */
/* loaded from: classes3.dex */
public final class zzaf implements zzap {
    private final boolean zza;

    public zzaf(Boolean bool) {
        this.zza = bool == null ? false : bool.booleanValue();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof zzaf) && this.zza == ((zzaf) obj).zza;
    }

    public final int hashCode() {
        return Boolean.valueOf(this.zza).hashCode();
    }

    public final String toString() {
        return String.valueOf(this.zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzap
    public final zzap zzcz(String str, zzg zzgVar, List list) {
        if ("toString".equals(str)) {
            return new zzat(Boolean.toString(this.zza));
        }
        throw new IllegalArgumentException(String.format("%s.%s is not a function.", Boolean.toString(this.zza), str));
    }

    @Override // com.google.android.gms.internal.measurement.zzap
    public final zzap zzd() {
        return new zzaf(Boolean.valueOf(this.zza));
    }

    @Override // com.google.android.gms.internal.measurement.zzap
    public final Boolean zzg() {
        return Boolean.valueOf(this.zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzap
    public final Double zzh() {
        return Double.valueOf(true != this.zza ? AudioStats.AUDIO_AMPLITUDE_NONE : 1.0d);
    }

    @Override // com.google.android.gms.internal.measurement.zzap
    public final String zzi() {
        return Boolean.toString(this.zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzap
    public final Iterator zzl() {
        return null;
    }
}
