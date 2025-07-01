package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.4.0 */
/* loaded from: classes3.dex */
public final class zznn implements Runnable {
    final /* synthetic */ AtomicReference zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ String zzc;
    final /* synthetic */ zzr zzd;
    final /* synthetic */ zzny zze;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zznn(zzny zznyVar, AtomicReference atomicReference, String str, String str2, String str3, zzr zzrVar) {
        this.zza = atomicReference;
        this.zzb = str2;
        this.zzc = str3;
        this.zzd = zzrVar;
        this.zze = zznyVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AtomicReference atomicReference;
        zzny zznyVar;
        zzgl zzglVar;
        AtomicReference atomicReference2 = this.zza;
        synchronized (atomicReference2) {
            try {
                try {
                    zznyVar = this.zze;
                    zzglVar = zznyVar.zzb;
                } catch (RemoteException e) {
                    this.zze.zzu.zzaW().zze().zzd("(legacy) Failed to get conditional properties; remote exception", null, this.zzb, e);
                    this.zza.set(Collections.emptyList());
                    atomicReference = this.zza;
                }
                if (zzglVar != null) {
                    if (!TextUtils.isEmpty(null)) {
                        atomicReference2.set(zzglVar.zzj(null, this.zzb, this.zzc));
                    } else {
                        zzr zzrVar = this.zzd;
                        Preconditions.checkNotNull(zzrVar);
                        atomicReference2.set(zzglVar.zzi(this.zzb, this.zzc, zzrVar));
                    }
                    zznyVar.zzag();
                    atomicReference = this.zza;
                    atomicReference.notify();
                    return;
                }
                zznyVar.zzu.zzaW().zze().zzd("(legacy) Failed to get conditional properties; not connected to service", null, this.zzb, this.zzc);
                atomicReference2.set(Collections.emptyList());
                atomicReference2.notify();
            } catch (Throwable th) {
                this.zza.notify();
                throw th;
            }
        }
    }
}
