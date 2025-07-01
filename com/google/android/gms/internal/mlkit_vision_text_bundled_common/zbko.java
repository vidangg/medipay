package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
public final class zbko {
    private final zbkm zba;

    private zbko(zbkm zbkmVar) {
        int i = zbkc.zbb;
        this.zba = zbkmVar;
    }

    public static zbko zba(String str) {
        return new zbko(new zbkm("#vk "));
    }

    public final List zbb(CharSequence charSequence) {
        charSequence.getClass();
        zbkl zbklVar = new zbkl(this.zba, this, charSequence);
        ArrayList arrayList = new ArrayList();
        while (zbklVar.hasNext()) {
            arrayList.add((String) zbklVar.next());
        }
        return Collections.unmodifiableList(arrayList);
    }
}
