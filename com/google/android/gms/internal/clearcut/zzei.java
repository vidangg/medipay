package com.google.android.gms.internal.clearcut;

import java.lang.Comparable;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class zzei<K extends Comparable<K>, V> extends AbstractMap<K, V> {
    private boolean zzgu;
    private final int zzol;
    private List<zzep> zzom;
    private Map<K, V> zzon;
    private volatile zzer zzoo;
    private Map<K, V> zzop;
    private volatile zzel zzoq;

    private zzei(int i) {
        this.zzol = i;
        this.zzom = Collections.emptyList();
        this.zzon = Collections.emptyMap();
        this.zzop = Collections.emptyMap();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzei(int i, zzej zzejVar) {
        this(i);
    }

    private final int zza(K k) {
        int i;
        int size = this.zzom.size();
        int i2 = size - 1;
        if (i2 >= 0) {
            int compareTo = k.compareTo((Comparable) this.zzom.get(i2).getKey());
            if (compareTo > 0) {
                i = size + 1;
                return -i;
            }
            if (compareTo == 0) {
                return i2;
            }
        }
        int i3 = 0;
        while (i3 <= i2) {
            int i4 = (i3 + i2) / 2;
            int compareTo2 = k.compareTo((Comparable) this.zzom.get(i4).getKey());
            if (compareTo2 < 0) {
                i2 = i4 - 1;
            } else {
                if (compareTo2 <= 0) {
                    return i4;
                }
                i3 = i4 + 1;
            }
        }
        i = i3 + 1;
        return -i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <FieldDescriptorType extends zzca<FieldDescriptorType>> zzei<FieldDescriptorType, Object> zzaj(int i) {
        return new zzej(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final V zzal(int i) {
        zzdu();
        V v = (V) this.zzom.remove(i).getValue();
        if (!this.zzon.isEmpty()) {
            Iterator<Map.Entry<K, V>> it = zzdv().entrySet().iterator();
            this.zzom.add(new zzep(this, it.next()));
            it.remove();
        }
        return v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzdu() {
        if (this.zzgu) {
            throw new UnsupportedOperationException();
        }
    }

    private final SortedMap<K, V> zzdv() {
        zzdu();
        if (this.zzon.isEmpty() && !(this.zzon instanceof TreeMap)) {
            TreeMap treeMap = new TreeMap();
            this.zzon = treeMap;
            this.zzop = treeMap.descendingMap();
        }
        return (SortedMap) this.zzon;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        zzdu();
        if (!this.zzom.isEmpty()) {
            this.zzom.clear();
        }
        if (this.zzon.isEmpty()) {
            return;
        }
        this.zzon.clear();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return zza((zzei<K, V>) comparable) >= 0 || this.zzon.containsKey(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        if (this.zzoo == null) {
            this.zzoo = new zzer(this, null);
        }
        return this.zzoo;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzei)) {
            return super.equals(obj);
        }
        zzei zzeiVar = (zzei) obj;
        int size = size();
        if (size != zzeiVar.size()) {
            return false;
        }
        int zzdr = zzdr();
        if (zzdr != zzeiVar.zzdr()) {
            return entrySet().equals(zzeiVar.entrySet());
        }
        for (int i = 0; i < zzdr; i++) {
            if (!zzak(i).equals(zzeiVar.zzak(i))) {
                return false;
            }
        }
        if (zzdr != size) {
            return this.zzon.equals(zzeiVar.zzon);
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int zza = zza((zzei<K, V>) comparable);
        return zza >= 0 ? (V) this.zzom.get(zza).getValue() : this.zzon.get(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int hashCode() {
        int zzdr = zzdr();
        int i = 0;
        for (int i2 = 0; i2 < zzdr; i2++) {
            i += this.zzom.get(i2).hashCode();
        }
        return this.zzon.size() > 0 ? i + this.zzon.hashCode() : i;
    }

    public final boolean isImmutable() {
        return this.zzgu;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public /* synthetic */ Object put(Object obj, Object obj2) {
        return zza((zzei<K, V>) obj, (Comparable) obj2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        zzdu();
        Comparable comparable = (Comparable) obj;
        int zza = zza((zzei<K, V>) comparable);
        if (zza >= 0) {
            return (V) zzal(zza);
        }
        if (this.zzon.isEmpty()) {
            return null;
        }
        return this.zzon.remove(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.zzom.size() + this.zzon.size();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final V zza(K k, V v) {
        zzdu();
        int zza = zza((zzei<K, V>) k);
        if (zza >= 0) {
            return (V) this.zzom.get(zza).setValue(v);
        }
        zzdu();
        if (this.zzom.isEmpty() && !(this.zzom instanceof ArrayList)) {
            this.zzom = new ArrayList(this.zzol);
        }
        int i = -(zza + 1);
        if (i >= this.zzol) {
            return zzdv().put(k, v);
        }
        int size = this.zzom.size();
        int i2 = this.zzol;
        if (size == i2) {
            zzep remove = this.zzom.remove(i2 - 1);
            zzdv().put((Comparable) remove.getKey(), remove.getValue());
        }
        this.zzom.add(i, new zzep(this, k, v));
        return null;
    }

    public final Map.Entry<K, V> zzak(int i) {
        return this.zzom.get(i);
    }

    public final int zzdr() {
        return this.zzom.size();
    }

    public final Iterable<Map.Entry<K, V>> zzds() {
        return this.zzon.isEmpty() ? zzem.zzdx() : this.zzon.entrySet();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Set<Map.Entry<K, V>> zzdt() {
        if (this.zzoq == null) {
            this.zzoq = new zzel(this, null);
        }
        return this.zzoq;
    }

    public void zzv() {
        if (this.zzgu) {
            return;
        }
        this.zzon = this.zzon.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(this.zzon);
        this.zzop = this.zzop.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(this.zzop);
        this.zzgu = true;
    }
}
