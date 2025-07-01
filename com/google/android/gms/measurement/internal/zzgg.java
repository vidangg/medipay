package com.google.android.gms.measurement.internal;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.4.0 */
/* loaded from: classes3.dex */
public final class zzgg {
    private static final Object zza = new Object();
    private final String zzb;
    private final zzge zzc;
    private final Object zzd;
    private final Object zze = new Object();
    private volatile Object zzf = null;
    private volatile Object zzg = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzgg(String str, Object obj, Object obj2, zzge zzgeVar, zzgh zzghVar) {
        this.zzb = str;
        this.zzd = obj;
        this.zzc = zzgeVar;
    }

    public final Object zza(Object obj) {
        List<zzgg> list;
        synchronized (this.zze) {
        }
        if (obj != null) {
            return obj;
        }
        if (zzgf.zza == null) {
            return this.zzd;
        }
        synchronized (zza) {
            if (zzaf.zza()) {
                return this.zzg == null ? this.zzd : this.zzg;
            }
            try {
                list = zzgi.zzbs;
                for (zzgg zzggVar : list) {
                    if (!zzaf.zza()) {
                        Object obj2 = null;
                        try {
                            zzge zzgeVar = zzggVar.zzc;
                            if (zzgeVar != null) {
                                obj2 = zzgeVar.zza();
                            }
                        } catch (IllegalStateException unused) {
                        }
                        synchronized (zza) {
                            zzggVar.zzg = obj2;
                        }
                    } else {
                        throw new IllegalStateException("Refreshing flag cache must be done on a worker thread.");
                    }
                }
            } catch (SecurityException unused2) {
            }
            zzge zzgeVar2 = this.zzc;
            if (zzgeVar2 != null) {
                try {
                    return zzgeVar2.zza();
                } catch (IllegalStateException | SecurityException unused3) {
                }
            }
            return this.zzd;
        }
    }

    public final String zzb() {
        return this.zzb;
    }
}
