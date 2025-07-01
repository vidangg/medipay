package com.google.android.gms.common;

import android.content.Context;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.internal.base.zau;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-base@@18.4.0 */
/* loaded from: classes3.dex */
public final class zad extends zau {
    final /* synthetic */ GoogleApiAvailability zaa;
    private final Context zab;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zad(GoogleApiAvailability googleApiAvailability, Context context) {
        super(Looper.myLooper() == null ? Looper.getMainLooper() : Looper.myLooper());
        this.zaa = googleApiAvailability;
        this.zab = context.getApplicationContext();
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        if (message.what == 1) {
            GoogleApiAvailability googleApiAvailability = this.zaa;
            int isGooglePlayServicesAvailable = googleApiAvailability.isGooglePlayServicesAvailable(this.zab);
            if (googleApiAvailability.isUserResolvableError(isGooglePlayServicesAvailable)) {
                this.zaa.showErrorNotification(this.zab, isGooglePlayServicesAvailable);
                return;
            }
            return;
        }
        Log.w("GoogleApiAvailability", "Don't know how to handle this message: " + message.what);
    }
}
