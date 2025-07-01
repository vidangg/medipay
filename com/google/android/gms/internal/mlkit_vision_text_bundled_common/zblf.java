package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

import java.util.ListIterator;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
abstract class zblf extends zble implements ListIterator {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zblf(ListIterator listIterator) {
        super(listIterator);
    }

    @Override // java.util.ListIterator
    public final void add(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return ((ListIterator) this.zbb).hasPrevious();
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return ((ListIterator) this.zbb).nextIndex();
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        return zba(((ListIterator) this.zbb).previous());
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return ((ListIterator) this.zbb).previousIndex();
    }

    @Override // java.util.ListIterator
    public final void set(Object obj) {
        throw new UnsupportedOperationException();
    }
}
