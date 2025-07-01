package com.google.android.gms.internal.measurement;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@22.4.0 */
/* loaded from: classes3.dex */
public final class zzit extends zzmd implements zzni {
    private static final zzit zzb;
    private int zzd;
    private String zze = "";
    private zzmj zzf = zzcn();

    static {
        zzit zzitVar = new zzit();
        zzb = zzitVar;
        zzmd.zzct(zzit.class, zzitVar);
    }

    private zzit() {
    }

    public final String zzb() {
        return this.zze;
    }

    public final List zzc() {
        return this.zzf;
    }

    @Override // com.google.android.gms.internal.measurement.zzmd
    public final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzcq(zzb, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001ဈ\u0000\u0002\u001b", new Object[]{"zzd", "zze", "zzf", zziz.class});
        }
        if (i2 == 3) {
            return new zzit();
        }
        if (i2 == 4) {
            return new zzis(null);
        }
        if (i2 == 5) {
            return zzb;
        }
        throw null;
    }
}
