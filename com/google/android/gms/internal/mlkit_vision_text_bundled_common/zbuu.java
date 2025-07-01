package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
public final class zbuu implements Iterator {
    private final Iterator zba;

    public zbuu(Iterator it) {
        this.zba = it;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zba.hasNext();
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        Map.Entry entry = (Map.Entry) this.zba.next();
        return entry.getValue() instanceof zbuv ? new zbut(entry, null) : entry;
    }

    @Override // java.util.Iterator
    public final void remove() {
        this.zba.remove();
    }
}
