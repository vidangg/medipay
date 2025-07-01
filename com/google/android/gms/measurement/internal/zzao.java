package com.google.android.gms.measurement.internal;

import androidx.media3.extractor.metadata.icy.IcyHeaders;
import java.util.EnumMap;

/* compiled from: com.google.android.gms:play-services-measurement@@22.4.0 */
/* loaded from: classes3.dex */
final class zzao {
    private final EnumMap zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzao() {
        this.zza = new EnumMap(zzjw.class);
    }

    public static zzao zzb(String str) {
        EnumMap enumMap = new EnumMap(zzjw.class);
        if (str.length() >= zzjw.values().length) {
            int i = 0;
            if (str.charAt(0) == '1') {
                zzjw[] values = zzjw.values();
                int length = values.length;
                int i2 = 1;
                while (i < length) {
                    enumMap.put((EnumMap) values[i], (zzjw) zzan.zzb(str.charAt(i2)));
                    i++;
                    i2++;
                }
                return new zzao(enumMap);
            }
        }
        return new zzao();
    }

    public final String toString() {
        char c;
        StringBuilder sb = new StringBuilder(IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE);
        for (zzjw zzjwVar : zzjw.values()) {
            zzan zzanVar = (zzan) this.zza.get(zzjwVar);
            if (zzanVar == null) {
                zzanVar = zzan.UNSET;
            }
            c = zzanVar.zzl;
            sb.append(c);
        }
        return sb.toString();
    }

    public final zzan zza(zzjw zzjwVar) {
        zzan zzanVar = (zzan) this.zza.get(zzjwVar);
        return zzanVar == null ? zzan.UNSET : zzanVar;
    }

    public final void zzc(zzjw zzjwVar, int i) {
        zzan zzanVar = zzan.UNSET;
        if (i != -30) {
            if (i != -20) {
                if (i == -10) {
                    zzanVar = zzan.MANIFEST;
                } else if (i != 0) {
                    if (i == 30) {
                        zzanVar = zzan.INITIALIZATION;
                    }
                }
            }
            zzanVar = zzan.API;
        } else {
            zzanVar = zzan.TCF;
        }
        this.zza.put((EnumMap) zzjwVar, (zzjw) zzanVar);
    }

    public final void zzd(zzjw zzjwVar, zzan zzanVar) {
        this.zza.put((EnumMap) zzjwVar, (zzjw) zzanVar);
    }

    private zzao(EnumMap enumMap) {
        EnumMap enumMap2 = new EnumMap(zzjw.class);
        this.zza = enumMap2;
        enumMap2.putAll(enumMap);
    }
}
