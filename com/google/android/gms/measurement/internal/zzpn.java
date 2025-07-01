package com.google.android.gms.measurement.internal;

import android.content.Intent;
import java.util.Deque;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement@@22.4.0 */
/* loaded from: classes3.dex */
public final class zzpn extends zzaz {
    final /* synthetic */ zzpv zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzpn(zzpv zzpvVar, zzjs zzjsVar) {
        super(zzjsVar);
        this.zza = zzpvVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzaz
    public final void zzc() {
        Deque deque;
        zzpv zzpvVar = this.zza;
        zzpvVar.zzaX().zzg();
        deque = zzpvVar.zzr;
        String str = (String) deque.pollFirst();
        if (str != null) {
            zzpvVar.zzJ = zzpvVar.zzaU().elapsedRealtime();
            zzpvVar.zzaW().zzj().zzb("Sending trigger URI notification to app", str);
            Intent intent = new Intent();
            intent.setAction("com.google.android.gms.measurement.TRIGGERS_AVAILABLE");
            intent.setPackage(str);
            zzpv.zzaK(zzpvVar.zzaT(), intent);
        }
        zzpvVar.zzaJ();
    }
}
