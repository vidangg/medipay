package com.google.firebase.analytics;

import android.os.Bundle;
import com.google.android.gms.internal.measurement.zzff;
import com.google.android.gms.measurement.internal.zzkb;
import com.google.android.gms.measurement.internal.zzkc;
import com.google.android.gms.measurement.internal.zzlx;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-api@@22.4.0 */
/* loaded from: classes4.dex */
final class zzd implements zzlx {
    final /* synthetic */ zzff zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzd(zzff zzffVar) {
        this.zza = zzffVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzlx
    public final int zza(String str) {
        return this.zza.zza(str);
    }

    @Override // com.google.android.gms.measurement.internal.zzlx
    public final long zzb() {
        return this.zza.zzb();
    }

    @Override // com.google.android.gms.measurement.internal.zzlx
    public final Object zzg(int i) {
        return this.zza.zzi(i);
    }

    @Override // com.google.android.gms.measurement.internal.zzlx
    public final String zzh() {
        return this.zza.zzm();
    }

    @Override // com.google.android.gms.measurement.internal.zzlx
    public final String zzi() {
        return this.zza.zzn();
    }

    @Override // com.google.android.gms.measurement.internal.zzlx
    public final String zzj() {
        return this.zza.zzo();
    }

    @Override // com.google.android.gms.measurement.internal.zzlx
    public final String zzk() {
        return this.zza.zzp();
    }

    @Override // com.google.android.gms.measurement.internal.zzlx
    public final List zzm(String str, String str2) {
        return this.zza.zzq(str, str2);
    }

    @Override // com.google.android.gms.measurement.internal.zzlx
    public final Map zzo(String str, String str2, boolean z) {
        return this.zza.zzr(str, str2, z);
    }

    @Override // com.google.android.gms.measurement.internal.zzlx
    public final void zzp(String str) {
        this.zza.zzv(str);
    }

    @Override // com.google.android.gms.measurement.internal.zzlx
    public final void zzq(String str, String str2, Bundle bundle) {
        this.zza.zzw(str, str2, bundle);
    }

    @Override // com.google.android.gms.measurement.internal.zzlx
    public final void zzr(String str) {
        this.zza.zzx(str);
    }

    @Override // com.google.android.gms.measurement.internal.zzlx
    public final void zzs(String str, String str2, Bundle bundle) {
        this.zza.zzz(str, str2, bundle);
    }

    @Override // com.google.android.gms.measurement.internal.zzlx
    public final void zzt(String str, String str2, Bundle bundle, long j) {
        this.zza.zzA(str, str2, bundle, j);
    }

    @Override // com.google.android.gms.measurement.internal.zzlx
    public final void zzu(zzkc zzkcVar) {
        this.zza.zzC(zzkcVar);
    }

    @Override // com.google.android.gms.measurement.internal.zzlx
    public final void zzv(Bundle bundle) {
        this.zza.zzF(bundle);
    }

    @Override // com.google.android.gms.measurement.internal.zzlx
    public final void zzw(zzkb zzkbVar) {
        this.zza.zzK(zzkbVar);
    }

    @Override // com.google.android.gms.measurement.internal.zzlx
    public final void zzx(zzkc zzkcVar) {
        this.zza.zzQ(zzkcVar);
    }
}
