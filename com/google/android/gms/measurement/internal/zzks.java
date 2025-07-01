package com.google.android.gms.measurement.internal;

import java.util.concurrent.Executor;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.4.0 */
/* loaded from: classes3.dex */
public final class zzks implements Executor {
    final /* synthetic */ zzlw zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzks(zzlw zzlwVar) {
        this.zza = zzlwVar;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        this.zza.zzu.zzaX().zzq(runnable);
    }
}
