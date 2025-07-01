package com.google.android.gms.common;

import android.util.Log;
import javax.annotation.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-basement@@18.5.0 */
/* loaded from: classes3.dex */
public class zzw {
    private static final zzw zze = new zzw(true, 3, 1, null, null);
    final boolean zza;

    @Nullable
    final String zzb;

    @Nullable
    final Throwable zzc;
    final int zzd;

    private zzw(boolean z, int i, int i2, @Nullable String str, @Nullable Throwable th) {
        this.zza = z;
        this.zzd = i;
        this.zzb = str;
        this.zzc = th;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Deprecated
    public static zzw zzb() {
        return zze;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzw zzc(String str) {
        return new zzw(false, 1, 5, str, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzw zzd(String str, Throwable th) {
        return new zzw(false, 1, 5, str, th);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzw zzf(int i) {
        return new zzw(true, i, 1, null, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzw zzg(int i, int i2, String str, @Nullable Throwable th) {
        return new zzw(false, i, i2, str, th);
    }

    @Nullable
    String zza() {
        return this.zzb;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zze() {
        if (this.zza || !Log.isLoggable("GoogleCertificatesRslt", 3)) {
            return;
        }
        if (this.zzc != null) {
            Log.d("GoogleCertificatesRslt", zza(), this.zzc);
        } else {
            Log.d("GoogleCertificatesRslt", zza());
        }
    }
}
