package com.google.android.gms.internal.auth;

/* compiled from: com.google.android.gms:play-services-auth-base@@18.0.10 */
/* loaded from: classes3.dex */
final class zzhb extends zzgz {
    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.auth.zzgz
    public final /* bridge */ /* synthetic */ Object zza(Object obj) {
        zzev zzevVar = (zzev) obj;
        zzha zzhaVar = zzevVar.zzc;
        if (zzhaVar != zzha.zza()) {
            return zzhaVar;
        }
        zzha zzd = zzha.zzd();
        zzevVar.zzc = zzd;
        return zzd;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.auth.zzgz
    public final /* synthetic */ Object zzb(Object obj) {
        return ((zzev) obj).zzc;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.auth.zzgz
    public final /* bridge */ /* synthetic */ Object zzc(Object obj, Object obj2) {
        if (zzha.zza().equals(obj2)) {
            return obj;
        }
        if (zzha.zza().equals(obj)) {
            return zzha.zzc((zzha) obj, (zzha) obj2);
        }
        ((zzha) obj).zzb((zzha) obj2);
        return obj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.auth.zzgz
    public final /* bridge */ /* synthetic */ void zzd(Object obj, int i, long j) {
        ((zzha) obj).zzh(i << 3, Long.valueOf(j));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.auth.zzgz
    public final void zze(Object obj) {
        ((zzev) obj).zzc.zzf();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.auth.zzgz
    public final /* synthetic */ void zzf(Object obj, Object obj2) {
        ((zzev) obj).zzc = (zzha) obj2;
    }
}
