package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
public enum zbtv {
    DOUBLE(0, 1, zbur.DOUBLE),
    FLOAT(1, 1, zbur.FLOAT),
    INT64(2, 1, zbur.LONG),
    UINT64(3, 1, zbur.LONG),
    INT32(4, 1, zbur.INT),
    FIXED64(5, 1, zbur.LONG),
    FIXED32(6, 1, zbur.INT),
    BOOL(7, 1, zbur.BOOLEAN),
    STRING(8, 1, zbur.STRING),
    MESSAGE(9, 1, zbur.MESSAGE),
    BYTES(10, 1, zbur.BYTE_STRING),
    UINT32(11, 1, zbur.INT),
    ENUM(12, 1, zbur.ENUM),
    SFIXED32(13, 1, zbur.INT),
    SFIXED64(14, 1, zbur.LONG),
    SINT32(15, 1, zbur.INT),
    SINT64(16, 1, zbur.LONG),
    GROUP(17, 1, zbur.MESSAGE),
    DOUBLE_LIST(18, 2, zbur.DOUBLE),
    FLOAT_LIST(19, 2, zbur.FLOAT),
    INT64_LIST(20, 2, zbur.LONG),
    UINT64_LIST(21, 2, zbur.LONG),
    INT32_LIST(22, 2, zbur.INT),
    FIXED64_LIST(23, 2, zbur.LONG),
    FIXED32_LIST(24, 2, zbur.INT),
    BOOL_LIST(25, 2, zbur.BOOLEAN),
    STRING_LIST(26, 2, zbur.STRING),
    MESSAGE_LIST(27, 2, zbur.MESSAGE),
    BYTES_LIST(28, 2, zbur.BYTE_STRING),
    UINT32_LIST(29, 2, zbur.INT),
    ENUM_LIST(30, 2, zbur.ENUM),
    SFIXED32_LIST(31, 2, zbur.INT),
    SFIXED64_LIST(32, 2, zbur.LONG),
    SINT32_LIST(33, 2, zbur.INT),
    SINT64_LIST(34, 2, zbur.LONG),
    DOUBLE_LIST_PACKED(35, 3, zbur.DOUBLE),
    FLOAT_LIST_PACKED(36, 3, zbur.FLOAT),
    INT64_LIST_PACKED(37, 3, zbur.LONG),
    UINT64_LIST_PACKED(38, 3, zbur.LONG),
    INT32_LIST_PACKED(39, 3, zbur.INT),
    FIXED64_LIST_PACKED(40, 3, zbur.LONG),
    FIXED32_LIST_PACKED(41, 3, zbur.INT),
    BOOL_LIST_PACKED(42, 3, zbur.BOOLEAN),
    UINT32_LIST_PACKED(43, 3, zbur.INT),
    ENUM_LIST_PACKED(44, 3, zbur.ENUM),
    SFIXED32_LIST_PACKED(45, 3, zbur.INT),
    SFIXED64_LIST_PACKED(46, 3, zbur.LONG),
    SINT32_LIST_PACKED(47, 3, zbur.INT),
    SINT64_LIST_PACKED(48, 3, zbur.LONG),
    GROUP_LIST(49, 2, zbur.MESSAGE),
    MAP(50, 4, zbur.VOID);

    private static final zbtv[] zbZ;
    private final int zbab;

    static {
        zbtv[] values = values();
        zbZ = new zbtv[values.length];
        for (zbtv zbtvVar : values) {
            zbZ[zbtvVar.zbab] = zbtvVar;
        }
    }

    zbtv(int i, int i2, zbur zburVar) {
        this.zbab = i;
        int i3 = i2 - 1;
        if (i3 == 1) {
            zburVar.zba();
        } else if (i3 == 3) {
            zburVar.zba();
        }
        if (i2 == 1) {
            zbur zburVar2 = zbur.VOID;
            zburVar.ordinal();
        }
    }

    public final int zba() {
        return this.zbab;
    }
}
