package com.google.mlkit.vision.text.internal;

import com.google.android.gms.internal.mlkit_vision_text_common.zzot;
import com.google.android.gms.internal.mlkit_vision_text_common.zzou;
import com.google.android.gms.internal.mlkit_vision_text_common.zzov;
import com.google.android.gms.internal.mlkit_vision_text_common.zzow;
import com.google.android.gms.internal.mlkit_vision_text_common.zzru;
import com.google.android.gms.internal.mlkit_vision_text_common.zzsb;
import com.google.android.gms.internal.mlkit_vision_text_common.zztr;
import com.google.android.gms.internal.mlkit_vision_text_common.zzub;
import com.google.android.gms.internal.mlkit_vision_text_common.zzuc;
import com.google.android.gms.internal.mlkit_vision_text_common.zzuf;

/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition-common@@19.1.0 */
/* loaded from: classes4.dex */
public final class LoggingUtils {
    private LoggingUtils() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzsb zza(int i) {
        switch (i) {
            case 1:
                return zzsb.LATIN;
            case 2:
                return zzsb.LATIN_AND_CHINESE;
            case 3:
                return zzsb.LATIN_AND_DEVANAGARI;
            case 4:
                return zzsb.LATIN_AND_JAPANESE;
            case 5:
                return zzsb.LATIN_AND_KOREAN;
            case 6:
                return zzsb.CREDIT_CARD;
            case 7:
                return zzsb.DOCUMENT;
            case 8:
                return zzsb.PIXEL_AI;
            default:
                return zzsb.TYPE_UNKNOWN;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zzb(zzuc zzucVar, final boolean z, final zzou zzouVar) {
        zzucVar.zzf(new zzub() { // from class: com.google.mlkit.vision.text.internal.zzl
            @Override // com.google.android.gms.internal.mlkit_vision_text_common.zzub
            public final zztr zza() {
                zzow zzowVar = new zzow();
                zzot zzotVar = z ? zzot.TYPE_THICK : zzot.TYPE_THIN;
                zzou zzouVar2 = zzouVar;
                zzowVar.zze(zzotVar);
                zzru zzruVar = new zzru();
                zzruVar.zzb(zzouVar2);
                zzowVar.zzg(zzruVar.zzc());
                return zzuf.zzf(zzowVar);
            }
        }, zzov.ON_DEVICE_TEXT_LOAD);
    }
}
