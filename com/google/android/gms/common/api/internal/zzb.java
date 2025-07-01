package com.google.android.gms.common.api.internal;

import android.os.Bundle;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-basement@@18.5.0 */
/* loaded from: classes3.dex */
public final class zzb implements Runnable {
    final /* synthetic */ LifecycleCallback zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ zzc zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzb(zzc zzcVar, LifecycleCallback lifecycleCallback, String str) {
        this.zza = lifecycleCallback;
        this.zzb = str;
        this.zzc = zzcVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        Bundle bundle;
        Bundle bundle2;
        Bundle bundle3;
        zzc zzcVar = this.zzc;
        i = zzcVar.zzb;
        if (i > 0) {
            LifecycleCallback lifecycleCallback = this.zza;
            bundle = zzcVar.zzc;
            if (bundle != null) {
                String str = this.zzb;
                bundle3 = zzcVar.zzc;
                bundle2 = bundle3.getBundle(str);
            } else {
                bundle2 = null;
            }
            lifecycleCallback.onCreate(bundle2);
        }
        i2 = this.zzc.zzb;
        if (i2 >= 2) {
            this.zza.onStart();
        }
        i3 = this.zzc.zzb;
        if (i3 >= 3) {
            this.zza.onResume();
        }
        i4 = this.zzc.zzb;
        if (i4 >= 4) {
            this.zza.onStop();
        }
        i5 = this.zzc.zzb;
        if (i5 >= 5) {
            this.zza.onDestroy();
        }
    }
}
