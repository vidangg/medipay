package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzjb;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
/* loaded from: classes3.dex */
public class zzio {
    private static volatile boolean zza = false;
    private static boolean zzb = true;
    private static volatile zzio zzc;
    private static volatile zzio zzd;
    private static final zzio zze = new zzio(true);
    private final Map<zza, zzjb.zze<?, ?>> zzf;

    public static zzio zza() {
        return new zzio();
    }

    public static zzio zzb() {
        zzio zzioVar = zzc;
        if (zzioVar == null) {
            synchronized (zzio.class) {
                zzioVar = zzc;
                if (zzioVar == null) {
                    zzioVar = zze;
                    zzc = zzioVar;
                }
            }
        }
        return zzioVar;
    }

    /* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
    /* loaded from: classes3.dex */
    private static final class zza {
        private final Object zza;
        private final int zzb;

        zza(Object obj, int i) {
            this.zza = obj;
            this.zzb = i;
        }

        public final int hashCode() {
            return (System.identityHashCode(this.zza) * 65535) + this.zzb;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof zza)) {
                return false;
            }
            zza zzaVar = (zza) obj;
            return this.zza == zzaVar.zza && this.zzb == zzaVar.zzb;
        }
    }

    public static zzio zzc() {
        zzio zzioVar = zzd;
        if (zzioVar != null) {
            return zzioVar;
        }
        synchronized (zzio.class) {
            zzio zzioVar2 = zzd;
            if (zzioVar2 != null) {
                return zzioVar2;
            }
            zzio zza2 = zziz.zza(zzio.class);
            zzd = zza2;
            return zza2;
        }
    }

    public final <ContainingType extends zzkk> zzjb.zze<ContainingType, ?> zza(ContainingType containingtype, int i) {
        return (zzjb.zze) this.zzf.get(new zza(containingtype, i));
    }

    public final void zza(zzjb.zze<?, ?> zzeVar) {
        this.zzf.put(new zza(zzeVar.zza, zzeVar.zzd.zzb), zzeVar);
    }

    zzio() {
        this.zzf = new HashMap();
    }

    private zzio(boolean z) {
        this.zzf = Collections.emptyMap();
    }
}
