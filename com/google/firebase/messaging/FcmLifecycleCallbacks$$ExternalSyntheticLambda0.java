package com.google.firebase.messaging;

import android.content.Intent;

/* compiled from: D8$$SyntheticClass */
/* loaded from: classes4.dex */
public final /* synthetic */ class FcmLifecycleCallbacks$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ FcmLifecycleCallbacks f$0;
    public final /* synthetic */ Intent f$1;

    public /* synthetic */ FcmLifecycleCallbacks$$ExternalSyntheticLambda0(FcmLifecycleCallbacks fcmLifecycleCallbacks, Intent intent) {
        this.f$0 = fcmLifecycleCallbacks;
        this.f$1 = intent;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f$0.m694xd8132052(this.f$1);
    }
}
