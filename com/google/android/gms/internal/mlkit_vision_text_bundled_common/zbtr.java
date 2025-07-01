package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

import java.io.IOException;
import java.util.Map;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
final class zbtr extends zbtq {
    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbtq
    public final void zba(Object obj) {
        ((zbub) obj).zbb.zbh();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbtq
    public final void zbb(zbwy zbwyVar, Map.Entry entry) throws IOException {
        zbww zbwwVar = zbww.DOUBLE;
        switch (r0.zbb) {
            case DOUBLE:
                zbwyVar.zbf(32149011, ((Double) entry.getValue()).doubleValue());
                return;
            case FLOAT:
                zbwyVar.zbo(32149011, ((Float) entry.getValue()).floatValue());
                return;
            case INT64:
                zbwyVar.zbt(32149011, ((Long) entry.getValue()).longValue());
                return;
            case UINT64:
                zbwyVar.zbL(32149011, ((Long) entry.getValue()).longValue());
                return;
            case INT32:
                zbwyVar.zbr(32149011, ((Integer) entry.getValue()).intValue());
                return;
            case FIXED64:
                zbwyVar.zbm(32149011, ((Long) entry.getValue()).longValue());
                return;
            case FIXED32:
                zbwyVar.zbk(32149011, ((Integer) entry.getValue()).intValue());
                return;
            case BOOL:
                zbwyVar.zbb(32149011, ((Boolean) entry.getValue()).booleanValue());
                return;
            case STRING:
                zbwyVar.zbH(32149011, (String) entry.getValue());
                return;
            case GROUP:
                zbwyVar.zbq(32149011, entry.getValue(), zbvu.zba().zbb(entry.getValue().getClass()));
                return;
            case MESSAGE:
                zbwyVar.zbw(32149011, entry.getValue(), zbvu.zba().zbb(entry.getValue().getClass()));
                return;
            case BYTES:
                zbwyVar.zbd(32149011, (zbtc) entry.getValue());
                return;
            case UINT32:
                zbwyVar.zbJ(32149011, ((Integer) entry.getValue()).intValue());
                return;
            case ENUM:
                zbwyVar.zbr(32149011, ((Integer) entry.getValue()).intValue());
                return;
            case SFIXED32:
                zbwyVar.zby(32149011, ((Integer) entry.getValue()).intValue());
                return;
            case SFIXED64:
                zbwyVar.zbA(32149011, ((Long) entry.getValue()).longValue());
                return;
            case SINT32:
                zbwyVar.zbC(32149011, ((Integer) entry.getValue()).intValue());
                return;
            case SINT64:
                zbwyVar.zbE(32149011, ((Long) entry.getValue()).longValue());
                return;
            default:
                return;
        }
    }
}
