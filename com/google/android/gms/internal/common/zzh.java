package com.google.android.gms.internal.common;

import android.os.Handler;
import android.os.Looper;

/* compiled from: com.google.android.gms:play-services-basement@@18.5.0 */
/* loaded from: classes3.dex */
public class zzh extends Handler {
    private final Looper zza;

    public zzh() {
        this.zza = Looper.getMainLooper();
    }

    public zzh(Looper looper) {
        super(looper);
        this.zza = Looper.getMainLooper();
    }

    public zzh(Looper looper, Handler.Callback callback) {
        super(looper, callback);
        this.zza = Looper.getMainLooper();
    }
}
