package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

import java.util.Map;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
final class zbut implements Map.Entry {
    private final Map.Entry zba;

    @Override // java.util.Map.Entry
    public final Object getKey() {
        return this.zba.getKey();
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        if (((zbuv) this.zba.getValue()) == null) {
            return null;
        }
        throw null;
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        if (!(obj instanceof zbvm)) {
            throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
        }
        return ((zbuv) this.zba.getValue()).zbc((zbvm) obj);
    }

    public final zbuv zba() {
        return (zbuv) this.zba.getValue();
    }
}
