package com.google.android.gms.internal.mlkit_vision_face;

/* compiled from: com.google.android.gms:play-services-mlkit-face-detection@@17.1.0 */
/* loaded from: classes3.dex */
public final class zzdk {
    private zzdn zza;
    private Integer zzb;
    private zzjv zzc;

    public final zzdk zza(Integer num) {
        this.zzb = Integer.valueOf(num.intValue() & Integer.MAX_VALUE);
        return this;
    }

    public final zzdk zzb(zzjv zzjvVar) {
        this.zzc = zzjvVar;
        return this;
    }

    public final zzdk zzc(zzdn zzdnVar) {
        this.zza = zzdnVar;
        return this;
    }

    public final zzdp zze() {
        return new zzdp(this, null);
    }
}
