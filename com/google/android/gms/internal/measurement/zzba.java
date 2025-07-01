package com.google.android.gms.internal.measurement;

import java.util.Arrays;
import java.util.Comparator;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement@@22.4.0 */
/* loaded from: classes3.dex */
public final class zzba implements Comparator {
    final /* synthetic */ zzai zza;
    final /* synthetic */ zzg zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzba(zzai zzaiVar, zzg zzgVar) {
        this.zza = zzaiVar;
        this.zzb = zzgVar;
    }

    @Override // java.util.Comparator
    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        zzap zzapVar = (zzap) obj;
        zzap zzapVar2 = (zzap) obj2;
        if (zzapVar instanceof zzau) {
            return !(zzapVar2 instanceof zzau) ? 1 : 0;
        }
        if (zzapVar2 instanceof zzau) {
            return -1;
        }
        zzai zzaiVar = this.zza;
        if (zzaiVar == null) {
            return zzapVar.zzi().compareTo(zzapVar2.zzi());
        }
        return (int) zzh.zza(zzaiVar.zza(this.zzb, Arrays.asList(zzapVar, zzapVar2)).zzh().doubleValue());
    }
}
