package com.google.android.gms.internal.clearcut;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: Add missing generic type declarations: [V, K] */
/* loaded from: classes3.dex */
final class zzeq<K, V> implements Iterator<Map.Entry<K, V>> {
    private int pos;
    private Iterator<Map.Entry<K, V>> zzor;
    private final /* synthetic */ zzei zzos;
    private boolean zzow;

    private zzeq(zzei zzeiVar) {
        this.zzos = zzeiVar;
        this.pos = -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzeq(zzei zzeiVar, zzej zzejVar) {
        this(zzeiVar);
    }

    private final Iterator<Map.Entry<K, V>> zzdw() {
        Map map;
        if (this.zzor == null) {
            map = this.zzos.zzon;
            this.zzor = map.entrySet().iterator();
        }
        return this.zzor;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        List list;
        Map map;
        int i = this.pos + 1;
        list = this.zzos.zzom;
        if (i >= list.size()) {
            map = this.zzos.zzon;
            if (map.isEmpty() || !zzdw().hasNext()) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Iterator
    public final /* synthetic */ Object next() {
        List list;
        Map.Entry<K, V> next;
        List list2;
        this.zzow = true;
        int i = this.pos + 1;
        this.pos = i;
        list = this.zzos.zzom;
        if (i < list.size()) {
            list2 = this.zzos.zzom;
            next = (Map.Entry<K, V>) list2.get(this.pos);
        } else {
            next = zzdw().next();
        }
        return next;
    }

    @Override // java.util.Iterator
    public final void remove() {
        List list;
        if (!this.zzow) {
            throw new IllegalStateException("remove() was called before next()");
        }
        this.zzow = false;
        this.zzos.zzdu();
        int i = this.pos;
        list = this.zzos.zzom;
        if (i >= list.size()) {
            zzdw().remove();
            return;
        }
        zzei zzeiVar = this.zzos;
        int i2 = this.pos;
        this.pos = i2 - 1;
        zzeiVar.zzal(i2);
    }
}
