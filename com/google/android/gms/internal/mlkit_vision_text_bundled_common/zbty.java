package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
public final class zbty implements zbvk {
    private static final zbty zba = new zbty();

    private zbty() {
    }

    public static zbty zba() {
        return zba;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbvk
    public final zbvj zbb(Class cls) {
        if (!zbuf.class.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Unsupported message type: ".concat(String.valueOf(cls.getName())));
        }
        try {
            return (zbvj) zbuf.zbs(cls.asSubclass(zbuf.class)).zbb(3, null, null);
        } catch (Exception e) {
            throw new RuntimeException("Unable to get message info for ".concat(String.valueOf(cls.getName())), e);
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbvk
    public final boolean zbc(Class cls) {
        return zbuf.class.isAssignableFrom(cls);
    }
}
