package com.google.android.gms.internal.auth;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-auth-base@@18.0.10 */
/* loaded from: classes3.dex */
public final class zzfp implements zzgj {
    private static final zzfv zza = new zzfn();
    private final zzfv zzb;

    public zzfp() {
        zzfv zzfvVar;
        zzfv[] zzfvVarArr = new zzfv[2];
        zzfvVarArr[0] = zzes.zza();
        try {
            zzfvVar = (zzfv) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", null).invoke(null, null);
        } catch (Exception unused) {
            zzfvVar = zza;
        }
        zzfvVarArr[1] = zzfvVar;
        zzfo zzfoVar = new zzfo(zzfvVarArr);
        byte[] bArr = zzfa.zzd;
        this.zzb = zzfoVar;
    }

    private static boolean zzb(zzfu zzfuVar) {
        return zzfuVar.zzc() + (-1) != 1;
    }

    @Override // com.google.android.gms.internal.auth.zzgj
    public final zzgi zza(Class cls) {
        zzgk.zze(cls);
        zzfu zzb = this.zzb.zzb(cls);
        if (!zzb.zzb()) {
            if (zzev.class.isAssignableFrom(cls)) {
                if (zzb(zzb)) {
                    return zzga.zzj(cls, zzb, zzgd.zzb(), zzfl.zzd(), zzgk.zzb(), zzeo.zzb(), zzft.zzb());
                }
                return zzga.zzj(cls, zzb, zzgd.zzb(), zzfl.zzd(), zzgk.zzb(), null, zzft.zzb());
            }
            if (zzb(zzb)) {
                return zzga.zzj(cls, zzb, zzgd.zza(), zzfl.zzc(), zzgk.zza(), zzeo.zza(), zzft.zza());
            }
            return zzga.zzj(cls, zzb, zzgd.zza(), zzfl.zzc(), zzgk.zza(), null, zzft.zza());
        }
        if (zzev.class.isAssignableFrom(cls)) {
            return zzgb.zzb(zzgk.zzb(), zzeo.zzb(), zzb.zza());
        }
        return zzgb.zzb(zzgk.zza(), zzeo.zza(), zzb.zza());
    }
}
