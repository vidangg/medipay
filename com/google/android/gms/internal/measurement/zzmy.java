package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-base@@22.4.0 */
/* loaded from: classes3.dex */
final class zzmy implements zznf {
    private final zznf[] zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzmy(zznf... zznfVarArr) {
        this.zza = zznfVarArr;
    }

    @Override // com.google.android.gms.internal.measurement.zznf
    public final zzne zzb(Class cls) {
        for (int i = 0; i < 2; i++) {
            zznf zznfVar = this.zza[i];
            if (zznfVar.zzc(cls)) {
                return zznfVar.zzb(cls);
            }
        }
        throw new UnsupportedOperationException("No factory is available for message type: ".concat(String.valueOf(cls.getName())));
    }

    @Override // com.google.android.gms.internal.measurement.zznf
    public final boolean zzc(Class cls) {
        for (int i = 0; i < 2; i++) {
            if (this.zza[i].zzc(cls)) {
                return true;
            }
        }
        return false;
    }
}
