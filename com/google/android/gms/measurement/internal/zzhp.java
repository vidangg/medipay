package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.4.0 */
/* loaded from: classes3.dex */
public final class zzhp {
    final /* synthetic */ zzht zza;
    private final String zzb;
    private final long zzc;
    private boolean zzd;
    private long zze;

    public zzhp(zzht zzhtVar, String str, long j) {
        this.zza = zzhtVar;
        Preconditions.checkNotEmpty(str);
        this.zzb = str;
        this.zzc = j;
    }

    public final long zza() {
        if (!this.zzd) {
            this.zzd = true;
            zzht zzhtVar = this.zza;
            this.zze = zzhtVar.zzb().getLong(this.zzb, this.zzc);
        }
        return this.zze;
    }

    public final void zzb(long j) {
        SharedPreferences.Editor edit = this.zza.zzb().edit();
        edit.putLong(this.zzb, j);
        edit.apply();
        this.zze = j;
    }
}
