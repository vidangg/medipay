package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.4.0 */
/* loaded from: classes3.dex */
public abstract class zzjr extends zzjq {
    private boolean zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzjr(zzio zzioVar) {
        super(zzioVar);
        this.zzu.zzE();
    }

    protected void zzaZ() {
    }

    protected abstract boolean zzc();

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzv() {
        if (!zzy()) {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void zzw() {
        if (this.zza) {
            throw new IllegalStateException("Can't initialize twice");
        }
        if (zzc()) {
            return;
        }
        this.zzu.zzD();
        this.zza = true;
    }

    public final void zzx() {
        if (this.zza) {
            throw new IllegalStateException("Can't initialize twice");
        }
        zzaZ();
        this.zzu.zzD();
        this.zza = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzy() {
        return this.zza;
    }
}
