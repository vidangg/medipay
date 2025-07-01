package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
public enum zbww {
    DOUBLE(zbwx.DOUBLE, 1),
    FLOAT(zbwx.FLOAT, 5),
    INT64(zbwx.LONG, 0),
    UINT64(zbwx.LONG, 0),
    INT32(zbwx.INT, 0),
    FIXED64(zbwx.LONG, 1),
    FIXED32(zbwx.INT, 5),
    BOOL(zbwx.BOOLEAN, 0),
    STRING(zbwx.STRING, 2),
    GROUP(zbwx.MESSAGE, 3),
    MESSAGE(zbwx.MESSAGE, 2),
    BYTES(zbwx.BYTE_STRING, 2),
    UINT32(zbwx.INT, 0),
    ENUM(zbwx.ENUM, 0),
    SFIXED32(zbwx.INT, 5),
    SFIXED64(zbwx.LONG, 1),
    SINT32(zbwx.INT, 0),
    SINT64(zbwx.LONG, 0);

    private final zbwx zbt;
    private final int zbu;

    zbww(zbwx zbwxVar, int i) {
        this.zbt = zbwxVar;
        this.zbu = i;
    }

    public final int zba() {
        return this.zbu;
    }

    public final zbwx zbb() {
        return this.zbt;
    }
}
