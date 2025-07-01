package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.4.0 */
/* loaded from: classes3.dex */
public final class zzhr {
    final /* synthetic */ zzht zza;
    private final String zzb;
    private boolean zzc;
    private String zzd;

    public zzhr(zzht zzhtVar, String str, String str2) {
        this.zza = zzhtVar;
        Preconditions.checkNotEmpty(str);
        this.zzb = str;
    }

    public final String zza() {
        if (!this.zzc) {
            this.zzc = true;
            zzht zzhtVar = this.zza;
            this.zzd = zzhtVar.zzb().getString(this.zzb, null);
        }
        return this.zzd;
    }

    public final void zzb(String str) {
        SharedPreferences.Editor edit = this.zza.zzb().edit();
        edit.putString(this.zzb, str);
        edit.apply();
        this.zzd = str;
    }
}
