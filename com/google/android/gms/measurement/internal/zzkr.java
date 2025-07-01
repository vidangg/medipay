package com.google.android.gms.measurement.internal;

import java.util.Objects;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.4.0 */
/* loaded from: classes3.dex */
public final class zzkr extends zzaz {
    final /* synthetic */ zzlw zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzkr(zzlw zzlwVar, zzjs zzjsVar) {
        super(zzjsVar);
        this.zza = zzlwVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzaz
    public final void zzc() {
        final zzlw zzq = this.zza.zzu.zzq();
        Objects.requireNonNull(zzq);
        new Thread(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzkq
            @Override // java.lang.Runnable
            public final void run() {
                zzlw.this.zzL();
            }
        }).start();
    }
}
