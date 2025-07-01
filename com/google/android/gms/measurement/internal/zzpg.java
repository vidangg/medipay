package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement@@22.4.0 */
/* loaded from: classes3.dex */
public abstract class zzpg extends zzoz {
    private boolean zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzpg(zzpv zzpvVar) {
        super(zzpvVar);
        this.zzg.zzad();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzav() {
        if (!zzax()) {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void zzaw() {
        if (this.zza) {
            throw new IllegalStateException("Can't initialize twice");
        }
        zzb();
        this.zzg.zzV();
        this.zza = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzax() {
        return this.zza;
    }

    protected abstract boolean zzb();
}
