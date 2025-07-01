package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

import java.io.Serializable;
import java.util.AbstractSequentialList;
import java.util.List;
import java.util.ListIterator;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
final class zblb extends AbstractSequentialList implements Serializable {
    final List zba;
    final zbkf zbb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zblb(List list, zbkf zbkfVar) {
        list.getClass();
        this.zba = list;
        this.zbb = zbkfVar;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean isEmpty() {
        return this.zba.isEmpty();
    }

    @Override // java.util.AbstractSequentialList, java.util.AbstractList, java.util.List
    public final ListIterator listIterator(int i) {
        return new zbla(this, this.zba.listIterator(i));
    }

    @Override // java.util.AbstractList
    protected final void removeRange(int i, int i2) {
        this.zba.subList(i, i2).clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zba.size();
    }
}
