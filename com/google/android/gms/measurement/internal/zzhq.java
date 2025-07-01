package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import android.util.Pair;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.4.0 */
/* loaded from: classes3.dex */
public final class zzhq {
    final String zza;
    final /* synthetic */ zzht zzb;
    private final String zzc;
    private final String zzd;
    private final long zze;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzhq(zzht zzhtVar, String str, long j, zzhs zzhsVar) {
        this.zzb = zzhtVar;
        Preconditions.checkNotEmpty("health_monitor");
        Preconditions.checkArgument(j > 0);
        this.zza = "health_monitor:start";
        this.zzc = "health_monitor:count";
        this.zzd = "health_monitor:value";
        this.zze = j;
    }

    private final long zzc() {
        return this.zzb.zzb().getLong(this.zza, 0L);
    }

    private final void zzd() {
        zzht zzhtVar = this.zzb;
        zzhtVar.zzg();
        long currentTimeMillis = zzhtVar.zzu.zzaU().currentTimeMillis();
        SharedPreferences.Editor edit = zzhtVar.zzb().edit();
        edit.remove(this.zzc);
        edit.remove(this.zzd);
        edit.putLong(this.zza, currentTimeMillis);
        edit.apply();
    }

    public final Pair zza() {
        long abs;
        zzht zzhtVar = this.zzb;
        zzhtVar.zzg();
        zzhtVar.zzg();
        long zzc = zzc();
        if (zzc == 0) {
            zzd();
            abs = 0;
        } else {
            abs = Math.abs(zzc - zzhtVar.zzu.zzaU().currentTimeMillis());
        }
        long j = this.zze;
        if (abs < j) {
            return null;
        }
        if (abs > j + j) {
            zzd();
            return null;
        }
        String string = zzhtVar.zzb().getString(this.zzd, null);
        long j2 = zzhtVar.zzb().getLong(this.zzc, 0L);
        zzd();
        if (string == null || j2 <= 0) {
            return zzht.zza;
        }
        return new Pair(string, Long.valueOf(j2));
    }

    public final void zzb(String str, long j) {
        zzht zzhtVar = this.zzb;
        zzhtVar.zzg();
        if (zzc() == 0) {
            zzd();
        }
        if (str == null) {
            str = "";
        }
        SharedPreferences zzb = zzhtVar.zzb();
        String str2 = this.zzc;
        long j2 = zzb.getLong(str2, 0L);
        if (j2 <= 0) {
            SharedPreferences.Editor edit = zzhtVar.zzb().edit();
            edit.putString(this.zzd, str);
            edit.putLong(str2, 1L);
            edit.apply();
            return;
        }
        long nextLong = zzhtVar.zzu.zzw().zzJ().nextLong() & Long.MAX_VALUE;
        long j3 = j2 + 1;
        long j4 = Long.MAX_VALUE / j3;
        SharedPreferences.Editor edit2 = zzhtVar.zzb().edit();
        if (nextLong < j4) {
            edit2.putString(this.zzd, str);
        }
        edit2.putLong(str2, j3);
        edit2.apply();
    }
}
