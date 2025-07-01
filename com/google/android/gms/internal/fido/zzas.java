package com.google.android.gms.internal.fido;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import javax.annotation.CheckForNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-fido@@20.0.1 */
/* loaded from: classes3.dex */
public final class zzas extends zzat {
    final transient int zza;
    final transient int zzb;
    final /* synthetic */ zzat zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzas(zzat zzatVar, int i, int i2) {
        this.zzc = zzatVar;
        this.zza = i;
        this.zzb = i2;
    }

    @Override // java.util.List
    public final Object get(int i) {
        zzam.zza(i, this.zzb, FirebaseAnalytics.Param.INDEX);
        return this.zzc.get(i + this.zza);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.fido.zzat, java.util.List
    public final /* bridge */ /* synthetic */ List subList(int i, int i2) {
        return subList(i, i2);
    }

    @Override // com.google.android.gms.internal.fido.zzaq
    final int zzb() {
        return this.zzc.zzc() + this.zza + this.zzb;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.fido.zzaq
    public final int zzc() {
        return this.zzc.zzc() + this.zza;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.fido.zzaq
    @CheckForNull
    public final Object[] zze() {
        return this.zzc.zze();
    }

    @Override // com.google.android.gms.internal.fido.zzat
    /* renamed from: zzf */
    public final zzat subList(int i, int i2) {
        zzam.zze(i, i2, this.zzb);
        zzat zzatVar = this.zzc;
        int i3 = this.zza;
        return zzatVar.subList(i + i3, i2 + i3);
    }
}
