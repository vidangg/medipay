package com.google.android.gms.internal.auth;

import android.os.Binder;

/* compiled from: com.google.android.gms:play-services-auth-base@@18.0.10 */
/* loaded from: classes3.dex */
public final /* synthetic */ class zzcj {
    public static Object zza(zzck zzckVar) {
        try {
            return zzckVar.zza();
        } catch (SecurityException unused) {
            long clearCallingIdentity = Binder.clearCallingIdentity();
            try {
                return zzckVar.zza();
            } finally {
                Binder.restoreCallingIdentity(clearCallingIdentity);
            }
        }
    }
}
