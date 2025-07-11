package com.google.android.gms.internal.clearcut;

import android.content.Context;
import android.os.UserManager;

/* loaded from: classes3.dex */
public class zzaa {
    private static volatile UserManager zzdc;
    private static volatile boolean zzdd = !zzf();

    private zzaa() {
    }

    public static boolean zze(Context context) {
        return zzf() && !zzf(context);
    }

    private static boolean zzf() {
        return true;
    }

    private static boolean zzf(Context context) {
        boolean z = zzdd;
        if (!z) {
            UserManager userManager = zzdc;
            if (userManager == null) {
                synchronized (zzaa.class) {
                    userManager = zzdc;
                    if (userManager == null) {
                        UserManager userManager2 = (UserManager) context.getSystemService(UserManager.class);
                        zzdc = userManager2;
                        if (userManager2 == null) {
                            zzdd = true;
                            return true;
                        }
                        userManager = userManager2;
                    }
                }
            }
            z = userManager.isUserUnlocked();
            zzdd = z;
            if (z) {
                zzdc = null;
            }
        }
        return z;
    }
}
