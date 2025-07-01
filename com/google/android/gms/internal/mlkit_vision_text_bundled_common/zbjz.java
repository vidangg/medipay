package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

import java.util.Iterator;
import java.util.NoSuchElementException;
import javax.annotation.CheckForNull;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
abstract class zbjz implements Iterator {

    @CheckForNull
    private Object zba;
    private int zbb = 2;

    @Override // java.util.Iterator
    public final Object next() {
        if (hasNext()) {
            this.zbb = 2;
            Object obj = this.zba;
            this.zba = null;
            return obj;
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }

    @CheckForNull
    protected abstract Object zba();

    /* JADX INFO: Access modifiers changed from: protected */
    @CheckForNull
    public final Object zbb() {
        this.zbb = 3;
        return null;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        int i = this.zbb;
        if (i == 4) {
            throw new IllegalStateException();
        }
        int i2 = i - 1;
        if (i == 0) {
            throw null;
        }
        if (i2 == 0) {
            return true;
        }
        if (i2 != 2) {
            this.zbb = 4;
            this.zba = zba();
            if (this.zbb != 3) {
                this.zbb = 1;
                return true;
            }
        }
        return false;
    }
}
