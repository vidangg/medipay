package com.google.android.gms.internal.clearcut;

import java.util.Map;

/* loaded from: classes3.dex */
final class zzct<K> implements Map.Entry<K, Object> {
    private Map.Entry<K, zzcr> zzll;

    private zzct(Map.Entry<K, zzcr> entry) {
        this.zzll = entry;
    }

    @Override // java.util.Map.Entry
    public final K getKey() {
        return this.zzll.getKey();
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        if (this.zzll.getValue() == null) {
            return null;
        }
        return zzcr.zzbr();
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        if (obj instanceof zzdo) {
            return this.zzll.getValue().zzi((zzdo) obj);
        }
        throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
    }

    public final zzcr zzbs() {
        return this.zzll.getValue();
    }
}
