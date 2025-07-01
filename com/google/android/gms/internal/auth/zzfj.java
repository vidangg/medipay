package com.google.android.gms.internal.auth;

/* compiled from: com.google.android.gms:play-services-auth-base@@18.0.10 */
/* loaded from: classes3.dex */
final class zzfj extends zzfl {
    private zzfj() {
        super(null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzfj(zzfi zzfiVar) {
        super(null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.auth.zzfl
    public final void zza(Object obj, long j) {
        ((zzez) zzhj.zzf(obj, j)).zzb();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.auth.zzfl
    public final void zzb(Object obj, Object obj2, long j) {
        zzez zzezVar = (zzez) zzhj.zzf(obj, j);
        zzez zzezVar2 = (zzez) zzhj.zzf(obj2, j);
        int size = zzezVar.size();
        int size2 = zzezVar2.size();
        if (size > 0 && size2 > 0) {
            if (!zzezVar.zzc()) {
                zzezVar = zzezVar.zzd(size2 + size);
            }
            zzezVar.addAll(zzezVar2);
        }
        if (size > 0) {
            zzezVar2 = zzezVar;
        }
        zzhj.zzp(obj, j, zzezVar2);
    }
}
