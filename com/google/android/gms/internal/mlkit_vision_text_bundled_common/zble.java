package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

import java.util.Iterator;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
abstract class zble implements Iterator {
    final Iterator zbb;

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zbb.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        return zba(this.zbb.next());
    }

    @Override // java.util.Iterator
    public final void remove() {
        this.zbb.remove();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract Object zba(Object obj);

    /* JADX INFO: Access modifiers changed from: package-private */
    public zble(Iterator it) {
        it.getClass();
        this.zbb = it;
    }
}
