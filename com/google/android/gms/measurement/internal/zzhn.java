package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.4.0 */
/* loaded from: classes3.dex */
public final class zzhn {
    final /* synthetic */ zzht zza;
    private final String zzb;
    private final boolean zzc;
    private boolean zzd;
    private boolean zze;

    public zzhn(zzht zzhtVar, String str, boolean z) {
        this.zza = zzhtVar;
        Preconditions.checkNotEmpty(str);
        this.zzb = str;
        this.zzc = z;
    }

    public final void zza(boolean z) {
        SharedPreferences.Editor edit = this.zza.zzb().edit();
        edit.putBoolean(this.zzb, z);
        edit.apply();
        this.zze = z;
    }

    public final boolean zzb() {
        if (!this.zzd) {
            this.zzd = true;
            zzht zzhtVar = this.zza;
            this.zze = zzhtVar.zzb().getBoolean(this.zzb, this.zzc);
        }
        return this.zze;
    }
}
