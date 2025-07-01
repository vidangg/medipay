package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
public final class zbaid extends zbuf implements zbvn {
    private static final zbaid zbb;
    private float zbd;
    private float zbe;

    static {
        zbaid zbaidVar = new zbaid();
        zbb = zbaidVar;
        zbuf.zbD(zbaid.class, zbaidVar);
    }

    private zbaid() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zbA(zbb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0001\u0002\u0001", new Object[]{"zbd", "zbe"});
        }
        if (i2 == 3) {
            return new zbaid();
        }
        zbaib zbaibVar = null;
        if (i2 == 4) {
            return new zbaic(zbaibVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zbb;
    }
}
