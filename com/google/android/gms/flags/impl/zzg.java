package com.google.android.gms.flags.impl;

import android.content.SharedPreferences;
import java.util.concurrent.Callable;

/* loaded from: classes3.dex */
final class zzg implements Callable<Long> {
    private final /* synthetic */ SharedPreferences zzo;
    private final /* synthetic */ String zzp;
    private final /* synthetic */ Long zzs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzg(SharedPreferences sharedPreferences, String str, Long l) {
        this.zzo = sharedPreferences;
        this.zzp = str;
        this.zzs = l;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ Long call() throws Exception {
        return Long.valueOf(this.zzo.getLong(this.zzp, this.zzs.longValue()));
    }
}
