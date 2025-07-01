package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
public final class zbvu {
    public static final /* synthetic */ int zba = 0;
    private static final zbvu zbb = new zbvu();
    private final ConcurrentMap zbd = new ConcurrentHashMap();
    private final zbvy zbc = new zbvd();

    private zbvu() {
    }

    public static zbvu zba() {
        return zbb;
    }

    public final zbvx zbb(Class cls) {
        zbuo.zbc(cls, "messageType");
        zbvx zbvxVar = (zbvx) this.zbd.get(cls);
        if (zbvxVar == null) {
            zbvxVar = this.zbc.zba(cls);
            zbuo.zbc(cls, "messageType");
            zbvx zbvxVar2 = (zbvx) this.zbd.putIfAbsent(cls, zbvxVar);
            if (zbvxVar2 != null) {
                return zbvxVar2;
            }
        }
        return zbvxVar;
    }
}
