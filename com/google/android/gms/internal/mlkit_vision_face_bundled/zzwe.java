package com.google.android.gms.internal.mlkit_vision_face_bundled;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.mlkit:face-detection@@16.1.7 */
/* loaded from: classes3.dex */
public final class zzwe {
    public static final /* synthetic */ int zza = 0;
    private static final zzwe zzb = new zzwe();
    private final ConcurrentMap zzd = new ConcurrentHashMap();
    private final zzwi zzc = new zzvo();

    private zzwe() {
    }

    public static zzwe zza() {
        return zzb;
    }

    public final zzwh zzb(Class cls) {
        zzvc.zzc(cls, "messageType");
        zzwh zzwhVar = (zzwh) this.zzd.get(cls);
        if (zzwhVar == null) {
            zzwhVar = this.zzc.zza(cls);
            zzvc.zzc(cls, "messageType");
            zzwh zzwhVar2 = (zzwh) this.zzd.putIfAbsent(cls, zzwhVar);
            if (zzwhVar2 != null) {
                return zzwhVar2;
            }
        }
        return zzwhVar;
    }
}
