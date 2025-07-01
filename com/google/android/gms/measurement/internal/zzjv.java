package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.4.0 */
/* loaded from: classes3.dex */
public enum zzjv {
    STORAGE(zzjw.AD_STORAGE, zzjw.ANALYTICS_STORAGE),
    DMA(zzjw.AD_USER_DATA);

    private final zzjw[] zzd;

    zzjv(zzjw... zzjwVarArr) {
        this.zzd = zzjwVarArr;
    }

    public final zzjw[] zzb() {
        return this.zzd;
    }
}
