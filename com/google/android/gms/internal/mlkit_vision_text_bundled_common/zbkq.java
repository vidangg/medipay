package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.NoSuchElementException;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
abstract class zbkq extends zblh {
    private final int zba;
    private int zbb;

    /* JADX INFO: Access modifiers changed from: protected */
    public zbkq(int i, int i2) {
        zbkj.zbb(i2, i, FirebaseAnalytics.Param.INDEX);
        this.zba = i;
        this.zbb = i2;
    }

    @Override // java.util.Iterator, java.util.ListIterator
    public final boolean hasNext() {
        return this.zbb < this.zba;
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.zbb > 0;
    }

    @Override // java.util.Iterator, java.util.ListIterator
    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int i = this.zbb;
        this.zbb = i + 1;
        return zba(i);
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.zbb;
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        if (!hasPrevious()) {
            throw new NoSuchElementException();
        }
        int i = this.zbb - 1;
        this.zbb = i;
        return zba(i);
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.zbb - 1;
    }

    protected abstract Object zba(int i);
}
