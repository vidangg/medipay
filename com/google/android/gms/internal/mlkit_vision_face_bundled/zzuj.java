package com.google.android.gms.internal.mlkit_vision_face_bundled;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.mlkit:face-detection@@16.1.7 */
/* loaded from: classes3.dex */
final class zzuj extends zzui {
    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzui
    public final void zza(Object obj) {
        ((zzus) obj).zzb.zzh();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzui
    public final void zzb(zzxi zzxiVar, Map.Entry entry) throws IOException {
        zzxg zzxgVar = zzxg.DOUBLE;
        switch (r0.zzb) {
            case DOUBLE:
                zzwj.zzs(202056002, (List) entry.getValue(), zzxiVar, false);
                return;
            case FLOAT:
                zzwj.zzw(202056002, (List) entry.getValue(), zzxiVar, false);
                return;
            case INT64:
                zzwj.zzz(202056002, (List) entry.getValue(), zzxiVar, false);
                return;
            case UINT64:
                zzwj.zzH(202056002, (List) entry.getValue(), zzxiVar, false);
                return;
            case INT32:
                zzwj.zzy(202056002, (List) entry.getValue(), zzxiVar, false);
                return;
            case FIXED64:
                zzwj.zzv(202056002, (List) entry.getValue(), zzxiVar, false);
                return;
            case FIXED32:
                zzwj.zzu(202056002, (List) entry.getValue(), zzxiVar, false);
                return;
            case BOOL:
                zzwj.zzq(202056002, (List) entry.getValue(), zzxiVar, false);
                return;
            case STRING:
                zzwj.zzF(202056002, (List) entry.getValue(), zzxiVar);
                return;
            case GROUP:
                List list = (List) entry.getValue();
                if (list == null || list.isEmpty()) {
                    return;
                }
                zzwj.zzx(202056002, (List) entry.getValue(), zzxiVar, zzwe.zza().zzb(list.get(0).getClass()));
                return;
            case MESSAGE:
                List list2 = (List) entry.getValue();
                if (list2 == null || list2.isEmpty()) {
                    return;
                }
                zzwj.zzA(202056002, (List) entry.getValue(), zzxiVar, zzwe.zza().zzb(list2.get(0).getClass()));
                return;
            case BYTES:
                zzwj.zzr(202056002, (List) entry.getValue(), zzxiVar);
                return;
            case UINT32:
                zzwj.zzG(202056002, (List) entry.getValue(), zzxiVar, false);
                return;
            case ENUM:
                zzwj.zzy(202056002, (List) entry.getValue(), zzxiVar, false);
                return;
            case SFIXED32:
                zzwj.zzB(202056002, (List) entry.getValue(), zzxiVar, false);
                return;
            case SFIXED64:
                zzwj.zzC(202056002, (List) entry.getValue(), zzxiVar, false);
                return;
            case SINT32:
                zzwj.zzD(202056002, (List) entry.getValue(), zzxiVar, false);
                return;
            case SINT64:
                zzwj.zzE(202056002, (List) entry.getValue(), zzxiVar, false);
                return;
            default:
                return;
        }
    }
}
