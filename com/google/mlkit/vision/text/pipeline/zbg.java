package com.google.mlkit.vision.text.pipeline;

import androidx.media3.common.C;
import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbaaw;
import java.util.Iterator;
import java.util.List;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes4.dex */
final class zbg {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static String zba(List list) {
        Iterator it = list.iterator();
        float f = 0.0f;
        String str = C.LANGUAGE_UNDETERMINED;
        while (it.hasNext()) {
            zbaaw zbaawVar = (zbaaw) it.next();
            if (f < zbaawVar.zbc()) {
                f = zbaawVar.zbc();
                str = zbaawVar.zbf();
            }
        }
        return str;
    }
}
