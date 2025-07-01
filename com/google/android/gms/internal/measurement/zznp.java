package com.google.android.gms.internal.measurement;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-base@@22.4.0 */
/* loaded from: classes3.dex */
public final class zznp {
    public static final /* synthetic */ int zza = 0;
    private static final zznp zzb = new zznp();
    private final ConcurrentMap zzd = new ConcurrentHashMap();
    private final zznt zzc = new zzmz();

    private zznp() {
    }

    public static zznp zza() {
        return zzb;
    }

    public final zzns zzb(Class cls) {
        zzmk.zzc(cls, "messageType");
        ConcurrentMap concurrentMap = this.zzd;
        zzns zznsVar = (zzns) concurrentMap.get(cls);
        if (zznsVar == null) {
            zznsVar = this.zzc.zza(cls);
            zzmk.zzc(cls, "messageType");
            zzns zznsVar2 = (zzns) concurrentMap.putIfAbsent(cls, zznsVar);
            if (zznsVar2 != null) {
                return zznsVar2;
            }
        }
        return zznsVar;
    }
}
