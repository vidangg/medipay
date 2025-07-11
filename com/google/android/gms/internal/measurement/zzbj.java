package com.google.android.gms.internal.measurement;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@22.4.0 */
/* loaded from: classes3.dex */
public final class zzbj extends zzaw {
    @Override // com.google.android.gms.internal.measurement.zzaw
    public final zzap zza(String str, zzg zzgVar, List list) {
        if (str == null || str.isEmpty() || !zzgVar.zzh(str)) {
            throw new IllegalArgumentException(String.format("Command not found: %s", str));
        }
        zzap zzd = zzgVar.zzd(str);
        if (!(zzd instanceof zzai)) {
            throw new IllegalArgumentException(String.format("Function %s is not defined", str));
        }
        return ((zzai) zzd).zza(zzgVar, list);
    }
}
