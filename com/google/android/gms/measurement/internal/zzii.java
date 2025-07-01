package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.lang.Thread;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.4.0 */
/* loaded from: classes3.dex */
public final class zzii implements Thread.UncaughtExceptionHandler {
    final /* synthetic */ zzil zza;
    private final String zzb;

    public zzii(zzil zzilVar, String str) {
        this.zza = zzilVar;
        Preconditions.checkNotNull(str);
        this.zzb = str;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final synchronized void uncaughtException(Thread thread, Throwable th) {
        this.zza.zzu.zzaW().zze().zzb(this.zzb, th);
    }
}
