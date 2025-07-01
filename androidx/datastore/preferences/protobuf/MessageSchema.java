package androidx.datastore.preferences.protobuf;

import androidx.camera.video.AudioStats;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.text.HtmlCompat;
import androidx.datastore.preferences.protobuf.ArrayDecoders;
import androidx.datastore.preferences.protobuf.ByteString;
import androidx.datastore.preferences.protobuf.FieldSet;
import androidx.datastore.preferences.protobuf.Internal;
import androidx.datastore.preferences.protobuf.InvalidProtocolBufferException;
import androidx.datastore.preferences.protobuf.MapEntryLite;
import androidx.datastore.preferences.protobuf.WireFormat;
import androidx.datastore.preferences.protobuf.Writer;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
import sun.misc.Unsafe;

/* JADX INFO: Access modifiers changed from: package-private */
@CheckReturnValue
/* loaded from: classes.dex */
public final class MessageSchema<T> implements Schema<T> {
    private static final int CHECK_INITIALIZED_BIT = 1024;
    private static final int ENFORCE_UTF8_MASK = 536870912;
    private static final int FIELD_TYPE_MASK = 267386880;
    private static final int HAS_HAS_BIT = 4096;
    private static final int INTS_PER_FIELD = 3;
    private static final int LEGACY_ENUM_IS_CLOSED_BIT = 2048;
    private static final int LEGACY_ENUM_IS_CLOSED_MASK = Integer.MIN_VALUE;
    private static final int NO_PRESENCE_SENTINEL = 1048575;
    private static final int OFFSET_BITS = 20;
    private static final int OFFSET_MASK = 1048575;
    static final int ONEOF_TYPE_OFFSET = 51;
    private static final int REQUIRED_BIT = 256;
    private static final int REQUIRED_MASK = 268435456;
    private static final int UTF8_CHECK_BIT = 512;
    private final int[] buffer;
    private final int checkInitializedCount;
    private final MessageLite defaultInstance;
    private final ExtensionSchema<?> extensionSchema;
    private final boolean hasExtensions;
    private final int[] intArray;
    private final ListFieldSchema listFieldSchema;
    private final boolean lite;
    private final MapFieldSchema mapFieldSchema;
    private final int maxFieldNumber;
    private final int minFieldNumber;
    private final NewInstanceSchema newInstanceSchema;
    private final Object[] objects;
    private final int repeatedFieldOffsetStart;
    private final ProtoSyntax syntax;
    private final UnknownFieldSchema<?, ?> unknownFieldSchema;
    private final boolean useCachedSizeField;
    private static final int[] EMPTY_INT_ARRAY = new int[0];
    private static final Unsafe UNSAFE = UnsafeUtil.getUnsafe();

    private static boolean isEnforceUtf8(int value) {
        return (value & 536870912) != 0;
    }

    private static boolean isLegacyEnumIsClosed(int value) {
        return (value & Integer.MIN_VALUE) != 0;
    }

    private static boolean isRequired(int value) {
        return (value & 268435456) != 0;
    }

    private static long offset(int value) {
        return value & 1048575;
    }

    private static int type(int value) {
        return (value & FIELD_TYPE_MASK) >>> 20;
    }

    private MessageSchema(int[] buffer, Object[] objects, int minFieldNumber, int maxFieldNumber, MessageLite defaultInstance, ProtoSyntax syntax, boolean useCachedSizeField, int[] intArray, int checkInitialized, int mapFieldPositions, NewInstanceSchema newInstanceSchema, ListFieldSchema listFieldSchema, UnknownFieldSchema<?, ?> unknownFieldSchema, ExtensionSchema<?> extensionSchema, MapFieldSchema mapFieldSchema) {
        this.buffer = buffer;
        this.objects = objects;
        this.minFieldNumber = minFieldNumber;
        this.maxFieldNumber = maxFieldNumber;
        this.lite = defaultInstance instanceof GeneratedMessageLite;
        this.syntax = syntax;
        this.hasExtensions = extensionSchema != null && extensionSchema.hasExtensions(defaultInstance);
        this.useCachedSizeField = useCachedSizeField;
        this.intArray = intArray;
        this.checkInitializedCount = checkInitialized;
        this.repeatedFieldOffsetStart = mapFieldPositions;
        this.newInstanceSchema = newInstanceSchema;
        this.listFieldSchema = listFieldSchema;
        this.unknownFieldSchema = unknownFieldSchema;
        this.extensionSchema = extensionSchema;
        this.defaultInstance = defaultInstance;
        this.mapFieldSchema = mapFieldSchema;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> MessageSchema<T> newSchema(Class<T> messageClass, MessageInfo messageInfo, NewInstanceSchema newInstanceSchema, ListFieldSchema listFieldSchema, UnknownFieldSchema<?, ?> unknownFieldSchema, ExtensionSchema<?> extensionSchema, MapFieldSchema mapFieldSchema) {
        if (messageInfo instanceof RawMessageInfo) {
            return newSchemaForRawMessageInfo((RawMessageInfo) messageInfo, newInstanceSchema, listFieldSchema, unknownFieldSchema, extensionSchema, mapFieldSchema);
        }
        return newSchemaForMessageInfo((StructuralMessageInfo) messageInfo, newInstanceSchema, listFieldSchema, unknownFieldSchema, extensionSchema, mapFieldSchema);
    }

    /* JADX WARN: Removed duplicated region for block: B:63:0x0248  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0262  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0265  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x024b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static <T> MessageSchema<T> newSchemaForRawMessageInfo(RawMessageInfo messageInfo, NewInstanceSchema newInstanceSchema, ListFieldSchema listFieldSchema, UnknownFieldSchema<?, ?> unknownFieldSchema, ExtensionSchema<?> extensionSchema, MapFieldSchema mapFieldSchema) {
        int i;
        int charAt;
        int charAt2;
        int i2;
        int i3;
        int[] iArr;
        int i4;
        int i5;
        int i6;
        int i7;
        char charAt3;
        int i8;
        char charAt4;
        int i9;
        char charAt5;
        int i10;
        char charAt6;
        int i11;
        char charAt7;
        int i12;
        char charAt8;
        int i13;
        char charAt9;
        int i14;
        char charAt10;
        int i15;
        int i16;
        int i17;
        int i18;
        String str;
        int i19;
        int i20;
        int i21;
        int i22;
        int i23;
        java.lang.reflect.Field reflectField;
        int i24;
        char charAt11;
        int i25;
        int i26;
        Object obj;
        java.lang.reflect.Field reflectField2;
        Object obj2;
        java.lang.reflect.Field reflectField3;
        int i27;
        char charAt12;
        int i28;
        char charAt13;
        int i29;
        char charAt14;
        int i30;
        char charAt15;
        String stringInfo = messageInfo.getStringInfo();
        int length = stringInfo.length();
        char c = 55296;
        if (stringInfo.charAt(0) >= 55296) {
            int i31 = 1;
            while (true) {
                i = i31 + 1;
                if (stringInfo.charAt(i31) < 55296) {
                    break;
                }
                i31 = i;
            }
        } else {
            i = 1;
        }
        int i32 = i + 1;
        int charAt16 = stringInfo.charAt(i);
        if (charAt16 >= 55296) {
            int i33 = charAt16 & 8191;
            int i34 = 13;
            while (true) {
                i30 = i32 + 1;
                charAt15 = stringInfo.charAt(i32);
                if (charAt15 < 55296) {
                    break;
                }
                i33 |= (charAt15 & 8191) << i34;
                i34 += 13;
                i32 = i30;
            }
            charAt16 = i33 | (charAt15 << i34);
            i32 = i30;
        }
        if (charAt16 == 0) {
            charAt = 0;
            charAt2 = 0;
            i5 = 0;
            i6 = 0;
            i2 = 0;
            i4 = 0;
            iArr = EMPTY_INT_ARRAY;
            i3 = 0;
        } else {
            int i35 = i32 + 1;
            int charAt17 = stringInfo.charAt(i32);
            if (charAt17 >= 55296) {
                int i36 = charAt17 & 8191;
                int i37 = 13;
                while (true) {
                    i14 = i35 + 1;
                    charAt10 = stringInfo.charAt(i35);
                    if (charAt10 < 55296) {
                        break;
                    }
                    i36 |= (charAt10 & 8191) << i37;
                    i37 += 13;
                    i35 = i14;
                }
                charAt17 = i36 | (charAt10 << i37);
                i35 = i14;
            }
            int i38 = i35 + 1;
            int charAt18 = stringInfo.charAt(i35);
            if (charAt18 >= 55296) {
                int i39 = charAt18 & 8191;
                int i40 = 13;
                while (true) {
                    i13 = i38 + 1;
                    charAt9 = stringInfo.charAt(i38);
                    if (charAt9 < 55296) {
                        break;
                    }
                    i39 |= (charAt9 & 8191) << i40;
                    i40 += 13;
                    i38 = i13;
                }
                charAt18 = i39 | (charAt9 << i40);
                i38 = i13;
            }
            int i41 = i38 + 1;
            int charAt19 = stringInfo.charAt(i38);
            if (charAt19 >= 55296) {
                int i42 = charAt19 & 8191;
                int i43 = 13;
                while (true) {
                    i12 = i41 + 1;
                    charAt8 = stringInfo.charAt(i41);
                    if (charAt8 < 55296) {
                        break;
                    }
                    i42 |= (charAt8 & 8191) << i43;
                    i43 += 13;
                    i41 = i12;
                }
                charAt19 = i42 | (charAt8 << i43);
                i41 = i12;
            }
            int i44 = i41 + 1;
            int charAt20 = stringInfo.charAt(i41);
            if (charAt20 >= 55296) {
                int i45 = charAt20 & 8191;
                int i46 = 13;
                while (true) {
                    i11 = i44 + 1;
                    charAt7 = stringInfo.charAt(i44);
                    if (charAt7 < 55296) {
                        break;
                    }
                    i45 |= (charAt7 & 8191) << i46;
                    i46 += 13;
                    i44 = i11;
                }
                charAt20 = i45 | (charAt7 << i46);
                i44 = i11;
            }
            int i47 = i44 + 1;
            charAt = stringInfo.charAt(i44);
            if (charAt >= 55296) {
                int i48 = charAt & 8191;
                int i49 = 13;
                while (true) {
                    i10 = i47 + 1;
                    charAt6 = stringInfo.charAt(i47);
                    if (charAt6 < 55296) {
                        break;
                    }
                    i48 |= (charAt6 & 8191) << i49;
                    i49 += 13;
                    i47 = i10;
                }
                charAt = i48 | (charAt6 << i49);
                i47 = i10;
            }
            int i50 = i47 + 1;
            charAt2 = stringInfo.charAt(i47);
            if (charAt2 >= 55296) {
                int i51 = charAt2 & 8191;
                int i52 = 13;
                while (true) {
                    i9 = i50 + 1;
                    charAt5 = stringInfo.charAt(i50);
                    if (charAt5 < 55296) {
                        break;
                    }
                    i51 |= (charAt5 & 8191) << i52;
                    i52 += 13;
                    i50 = i9;
                }
                charAt2 = i51 | (charAt5 << i52);
                i50 = i9;
            }
            int i53 = i50 + 1;
            int charAt21 = stringInfo.charAt(i50);
            if (charAt21 >= 55296) {
                int i54 = charAt21 & 8191;
                int i55 = 13;
                while (true) {
                    i8 = i53 + 1;
                    charAt4 = stringInfo.charAt(i53);
                    if (charAt4 < 55296) {
                        break;
                    }
                    i54 |= (charAt4 & 8191) << i55;
                    i55 += 13;
                    i53 = i8;
                }
                charAt21 = i54 | (charAt4 << i55);
                i53 = i8;
            }
            int i56 = i53 + 1;
            int charAt22 = stringInfo.charAt(i53);
            if (charAt22 >= 55296) {
                int i57 = charAt22 & 8191;
                int i58 = 13;
                while (true) {
                    i7 = i56 + 1;
                    charAt3 = stringInfo.charAt(i56);
                    if (charAt3 < 55296) {
                        break;
                    }
                    i57 |= (charAt3 & 8191) << i58;
                    i58 += 13;
                    i56 = i7;
                }
                charAt22 = i57 | (charAt3 << i58);
                i56 = i7;
            }
            i2 = (charAt17 * 2) + charAt18;
            i3 = charAt17;
            iArr = new int[charAt22 + charAt2 + charAt21];
            i4 = charAt22;
            i32 = i56;
            i5 = charAt19;
            i6 = charAt20;
        }
        Unsafe unsafe = UNSAFE;
        Object[] objects = messageInfo.getObjects();
        Class<?> cls = messageInfo.getDefaultInstance().getClass();
        int[] iArr2 = new int[charAt * 3];
        Object[] objArr = new Object[charAt * 2];
        int i59 = i4 + charAt2;
        int i60 = i4;
        int i61 = i59;
        int i62 = 0;
        int i63 = 0;
        while (i32 < length) {
            int i64 = i32 + 1;
            int charAt23 = stringInfo.charAt(i32);
            if (charAt23 >= c) {
                int i65 = charAt23 & 8191;
                int i66 = i64;
                int i67 = 13;
                while (true) {
                    i29 = i66 + 1;
                    charAt14 = stringInfo.charAt(i66);
                    if (charAt14 < c) {
                        break;
                    }
                    i65 |= (charAt14 & 8191) << i67;
                    i67 += 13;
                    i66 = i29;
                }
                charAt23 = i65 | (charAt14 << i67);
                i15 = i29;
            } else {
                i15 = i64;
            }
            int i68 = i15 + 1;
            int charAt24 = stringInfo.charAt(i15);
            if (charAt24 >= c) {
                int i69 = charAt24 & 8191;
                int i70 = i68;
                int i71 = 13;
                while (true) {
                    i28 = i70 + 1;
                    charAt13 = stringInfo.charAt(i70);
                    if (charAt13 < c) {
                        break;
                    }
                    i69 |= (charAt13 & 8191) << i71;
                    i71 += 13;
                    i70 = i28;
                }
                charAt24 = i69 | (charAt13 << i71);
                i16 = i28;
            } else {
                i16 = i68;
            }
            int i72 = charAt24 & 255;
            int i73 = length;
            if ((charAt24 & 1024) != 0) {
                iArr[i62] = i63;
                i62++;
            }
            int i74 = i62;
            if (i72 >= 51) {
                int i75 = i16 + 1;
                int charAt25 = stringInfo.charAt(i16);
                char c2 = 55296;
                if (charAt25 >= 55296) {
                    int i76 = charAt25 & 8191;
                    int i77 = 13;
                    while (true) {
                        i27 = i75 + 1;
                        charAt12 = stringInfo.charAt(i75);
                        if (charAt12 < c2) {
                            break;
                        }
                        i76 |= (charAt12 & 8191) << i77;
                        i77 += 13;
                        i75 = i27;
                        c2 = 55296;
                    }
                    charAt25 = i76 | (charAt12 << i77);
                    i75 = i27;
                }
                int i78 = i72 - 51;
                int i79 = i75;
                if (i78 == 9 || i78 == 17) {
                    i26 = i2 + 1;
                    objArr[((i63 / 3) * 2) + 1] = objects[i2];
                } else {
                    if (i78 == 12 && (messageInfo.getSyntax().equals(ProtoSyntax.PROTO2) || (charAt24 & 2048) != 0)) {
                        i26 = i2 + 1;
                        objArr[((i63 / 3) * 2) + 1] = objects[i2];
                    }
                    int i80 = charAt25 * 2;
                    obj = objects[i80];
                    if (!(obj instanceof java.lang.reflect.Field)) {
                        reflectField2 = (java.lang.reflect.Field) obj;
                    } else {
                        reflectField2 = reflectField(cls, (String) obj);
                        objects[i80] = reflectField2;
                    }
                    i17 = i5;
                    i23 = (int) unsafe.objectFieldOffset(reflectField2);
                    int i81 = i80 + 1;
                    obj2 = objects[i81];
                    if (!(obj2 instanceof java.lang.reflect.Field)) {
                        reflectField3 = (java.lang.reflect.Field) obj2;
                    } else {
                        reflectField3 = reflectField(cls, (String) obj2);
                        objects[i81] = reflectField3;
                    }
                    i18 = i6;
                    i19 = i2;
                    i21 = i79;
                    str = stringInfo;
                    i20 = (int) unsafe.objectFieldOffset(reflectField3);
                    i22 = 0;
                }
                i2 = i26;
                int i802 = charAt25 * 2;
                obj = objects[i802];
                if (!(obj instanceof java.lang.reflect.Field)) {
                }
                i17 = i5;
                i23 = (int) unsafe.objectFieldOffset(reflectField2);
                int i812 = i802 + 1;
                obj2 = objects[i812];
                if (!(obj2 instanceof java.lang.reflect.Field)) {
                }
                i18 = i6;
                i19 = i2;
                i21 = i79;
                str = stringInfo;
                i20 = (int) unsafe.objectFieldOffset(reflectField3);
                i22 = 0;
            } else {
                i17 = i5;
                int i82 = i2 + 1;
                java.lang.reflect.Field reflectField4 = reflectField(cls, (String) objects[i2]);
                if (i72 == 9 || i72 == 17) {
                    i18 = i6;
                    objArr[((i63 / 3) * 2) + 1] = reflectField4.getType();
                } else {
                    if (i72 == 27 || i72 == 49) {
                        i18 = i6;
                        i25 = i2 + 2;
                        objArr[((i63 / 3) * 2) + 1] = objects[i82];
                    } else if (i72 == 12 || i72 == 30 || i72 == 44) {
                        i18 = i6;
                        if (messageInfo.getSyntax() == ProtoSyntax.PROTO2 || (charAt24 & 2048) != 0) {
                            i25 = i2 + 2;
                            objArr[((i63 / 3) * 2) + 1] = objects[i82];
                        }
                    } else {
                        if (i72 == 50) {
                            int i83 = i60 + 1;
                            iArr[i60] = i63;
                            int i84 = (i63 / 3) * 2;
                            int i85 = i2 + 2;
                            objArr[i84] = objects[i82];
                            if ((charAt24 & 2048) != 0) {
                                i82 = i2 + 3;
                                objArr[i84 + 1] = objects[i85];
                                i60 = i83;
                            } else {
                                i60 = i83;
                                i82 = i85;
                            }
                        }
                        i18 = i6;
                    }
                    i82 = i25;
                }
                int objectFieldOffset = (int) unsafe.objectFieldOffset(reflectField4);
                if ((charAt24 & 4096) == 0 || i72 > 17) {
                    str = stringInfo;
                    i19 = i82;
                    i20 = 1048575;
                    i21 = i16;
                    i22 = 0;
                } else {
                    i21 = i16 + 1;
                    int charAt26 = stringInfo.charAt(i16);
                    if (charAt26 >= 55296) {
                        int i86 = charAt26 & 8191;
                        int i87 = 13;
                        while (true) {
                            i24 = i21 + 1;
                            charAt11 = stringInfo.charAt(i21);
                            if (charAt11 < 55296) {
                                break;
                            }
                            i86 |= (charAt11 & 8191) << i87;
                            i87 += 13;
                            i21 = i24;
                        }
                        charAt26 = i86 | (charAt11 << i87);
                        i21 = i24;
                    }
                    int i88 = (i3 * 2) + (charAt26 / 32);
                    Object obj3 = objects[i88];
                    if (obj3 instanceof java.lang.reflect.Field) {
                        reflectField = (java.lang.reflect.Field) obj3;
                    } else {
                        reflectField = reflectField(cls, (String) obj3);
                        objects[i88] = reflectField;
                    }
                    str = stringInfo;
                    i19 = i82;
                    i20 = (int) unsafe.objectFieldOffset(reflectField);
                    i22 = charAt26 % 32;
                }
                if (i72 >= 18 && i72 <= 49) {
                    iArr[i61] = objectFieldOffset;
                    i61++;
                }
                i23 = objectFieldOffset;
            }
            int i89 = i63 + 1;
            iArr2[i63] = charAt23;
            int i90 = i63 + 2;
            int i91 = i3;
            iArr2[i89] = i23 | (i72 << 20) | ((charAt24 & 256) != 0 ? 268435456 : 0) | ((charAt24 & 512) != 0 ? 536870912 : 0) | ((charAt24 & 2048) != 0 ? Integer.MIN_VALUE : 0);
            i63 += 3;
            iArr2[i90] = i20 | (i22 << 20);
            i32 = i21;
            stringInfo = str;
            i2 = i19;
            length = i73;
            i6 = i18;
            i62 = i74;
            i3 = i91;
            i5 = i17;
            c = 55296;
        }
        return new MessageSchema<>(iArr2, objArr, i5, i6, messageInfo.getDefaultInstance(), messageInfo.getSyntax(), false, iArr, i4, i59, newInstanceSchema, listFieldSchema, unknownFieldSchema, extensionSchema, mapFieldSchema);
    }

    private static java.lang.reflect.Field reflectField(Class<?> messageClass, String fieldName) {
        try {
            return messageClass.getDeclaredField(fieldName);
        } catch (NoSuchFieldException unused) {
            java.lang.reflect.Field[] declaredFields = messageClass.getDeclaredFields();
            for (java.lang.reflect.Field field : declaredFields) {
                if (fieldName.equals(field.getName())) {
                    return field;
                }
            }
            throw new RuntimeException("Field " + fieldName + " for " + messageClass.getName() + " not found. Known fields are " + Arrays.toString(declaredFields));
        }
    }

    static <T> MessageSchema<T> newSchemaForMessageInfo(StructuralMessageInfo messageInfo, NewInstanceSchema newInstanceSchema, ListFieldSchema listFieldSchema, UnknownFieldSchema<?, ?> unknownFieldSchema, ExtensionSchema<?> extensionSchema, MapFieldSchema mapFieldSchema) {
        int fieldNumber;
        int fieldNumber2;
        int i;
        FieldInfo[] fields = messageInfo.getFields();
        if (fields.length == 0) {
            fieldNumber = 0;
            fieldNumber2 = 0;
        } else {
            fieldNumber = fields[0].getFieldNumber();
            fieldNumber2 = fields[fields.length - 1].getFieldNumber();
        }
        int length = fields.length;
        int[] iArr = new int[length * 3];
        Object[] objArr = new Object[length * 2];
        int i2 = 0;
        int i3 = 0;
        for (FieldInfo fieldInfo : fields) {
            if (fieldInfo.getType() == FieldType.MAP) {
                i2++;
            } else if (fieldInfo.getType().id() >= 18 && fieldInfo.getType().id() <= 49) {
                i3++;
            }
        }
        int[] iArr2 = i2 > 0 ? new int[i2] : null;
        int[] iArr3 = i3 > 0 ? new int[i3] : null;
        int[] checkInitialized = messageInfo.getCheckInitialized();
        if (checkInitialized == null) {
            checkInitialized = EMPTY_INT_ARRAY;
        }
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        while (i4 < fields.length) {
            FieldInfo fieldInfo2 = fields[i4];
            int fieldNumber3 = fieldInfo2.getFieldNumber();
            storeFieldData(fieldInfo2, iArr, i5, objArr);
            if (i6 < checkInitialized.length && checkInitialized[i6] == fieldNumber3) {
                checkInitialized[i6] = i5;
                i6++;
            }
            if (fieldInfo2.getType() == FieldType.MAP) {
                iArr2[i7] = i5;
                i7++;
            } else if (fieldInfo2.getType().id() >= 18 && fieldInfo2.getType().id() <= 49) {
                i = i5;
                iArr3[i8] = (int) UnsafeUtil.objectFieldOffset(fieldInfo2.getField());
                i8++;
                i4++;
                i5 = i + 3;
            }
            i = i5;
            i4++;
            i5 = i + 3;
        }
        if (iArr2 == null) {
            iArr2 = EMPTY_INT_ARRAY;
        }
        if (iArr3 == null) {
            iArr3 = EMPTY_INT_ARRAY;
        }
        int[] iArr4 = new int[checkInitialized.length + iArr2.length + iArr3.length];
        System.arraycopy(checkInitialized, 0, iArr4, 0, checkInitialized.length);
        System.arraycopy(iArr2, 0, iArr4, checkInitialized.length, iArr2.length);
        System.arraycopy(iArr3, 0, iArr4, checkInitialized.length + iArr2.length, iArr3.length);
        return new MessageSchema<>(iArr, objArr, fieldNumber, fieldNumber2, messageInfo.getDefaultInstance(), messageInfo.getSyntax(), true, iArr4, checkInitialized.length, checkInitialized.length + iArr2.length, newInstanceSchema, listFieldSchema, unknownFieldSchema, extensionSchema, mapFieldSchema);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x007a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void storeFieldData(FieldInfo fi, int[] buffer, int bufferIndex, Object[] objects) {
        int objectFieldOffset;
        int id;
        long objectFieldOffset2;
        int i;
        int i2;
        OneofInfo oneof = fi.getOneof();
        if (oneof != null) {
            id = fi.getType().id() + 51;
            objectFieldOffset = (int) UnsafeUtil.objectFieldOffset(oneof.getValueField());
            objectFieldOffset2 = UnsafeUtil.objectFieldOffset(oneof.getCaseField());
        } else {
            FieldType type = fi.getType();
            objectFieldOffset = (int) UnsafeUtil.objectFieldOffset(fi.getField());
            id = type.id();
            if (!type.isList() && !type.isMap()) {
                java.lang.reflect.Field presenceField = fi.getPresenceField();
                i = presenceField == null ? 1048575 : (int) UnsafeUtil.objectFieldOffset(presenceField);
                i2 = Integer.numberOfTrailingZeros(fi.getPresenceMask());
            } else if (fi.getCachedSizeField() == null) {
                i = 0;
                i2 = 0;
            } else {
                objectFieldOffset2 = UnsafeUtil.objectFieldOffset(fi.getCachedSizeField());
            }
            buffer[bufferIndex] = fi.getFieldNumber();
            buffer[bufferIndex + 1] = (fi.isRequired() ? 268435456 : 0) | (!fi.isEnforceUtf8() ? 536870912 : 0) | (id << 20) | objectFieldOffset;
            buffer[bufferIndex + 2] = i | (i2 << 20);
            Class<?> messageFieldClass = fi.getMessageFieldClass();
            if (fi.getMapDefaultEntry() != null) {
                if (messageFieldClass != null) {
                    objects[((bufferIndex / 3) * 2) + 1] = messageFieldClass;
                    return;
                } else {
                    if (fi.getEnumVerifier() != null) {
                        objects[((bufferIndex / 3) * 2) + 1] = fi.getEnumVerifier();
                        return;
                    }
                    return;
                }
            }
            int i3 = (bufferIndex / 3) * 2;
            objects[i3] = fi.getMapDefaultEntry();
            if (messageFieldClass != null) {
                objects[i3 + 1] = messageFieldClass;
                return;
            } else {
                if (fi.getEnumVerifier() != null) {
                    objects[i3 + 1] = fi.getEnumVerifier();
                    return;
                }
                return;
            }
        }
        i = (int) objectFieldOffset2;
        i2 = 0;
        buffer[bufferIndex] = fi.getFieldNumber();
        if (!fi.isEnforceUtf8()) {
        }
        buffer[bufferIndex + 1] = (fi.isRequired() ? 268435456 : 0) | (!fi.isEnforceUtf8() ? 536870912 : 0) | (id << 20) | objectFieldOffset;
        buffer[bufferIndex + 2] = i | (i2 << 20);
        Class<?> messageFieldClass2 = fi.getMessageFieldClass();
        if (fi.getMapDefaultEntry() != null) {
        }
    }

    @Override // androidx.datastore.preferences.protobuf.Schema
    public T newInstance() {
        return (T) this.newInstanceSchema.newInstance(this.defaultInstance);
    }

    @Override // androidx.datastore.preferences.protobuf.Schema
    public boolean equals(T message, T other) {
        int length = this.buffer.length;
        for (int i = 0; i < length; i += 3) {
            if (!equals(message, other, i)) {
                return false;
            }
        }
        if (!this.unknownFieldSchema.getFromMessage(message).equals(this.unknownFieldSchema.getFromMessage(other))) {
            return false;
        }
        if (this.hasExtensions) {
            return this.extensionSchema.getExtensions(message).equals(this.extensionSchema.getExtensions(other));
        }
        return true;
    }

    private boolean equals(T message, T other, int pos) {
        int typeAndOffsetAt = typeAndOffsetAt(pos);
        long offset = offset(typeAndOffsetAt);
        switch (type(typeAndOffsetAt)) {
            case 0:
                return arePresentForEquals(message, other, pos) && Double.doubleToLongBits(UnsafeUtil.getDouble(message, offset)) == Double.doubleToLongBits(UnsafeUtil.getDouble(other, offset));
            case 1:
                return arePresentForEquals(message, other, pos) && Float.floatToIntBits(UnsafeUtil.getFloat(message, offset)) == Float.floatToIntBits(UnsafeUtil.getFloat(other, offset));
            case 2:
                return arePresentForEquals(message, other, pos) && UnsafeUtil.getLong(message, offset) == UnsafeUtil.getLong(other, offset);
            case 3:
                return arePresentForEquals(message, other, pos) && UnsafeUtil.getLong(message, offset) == UnsafeUtil.getLong(other, offset);
            case 4:
                return arePresentForEquals(message, other, pos) && UnsafeUtil.getInt(message, offset) == UnsafeUtil.getInt(other, offset);
            case 5:
                return arePresentForEquals(message, other, pos) && UnsafeUtil.getLong(message, offset) == UnsafeUtil.getLong(other, offset);
            case 6:
                return arePresentForEquals(message, other, pos) && UnsafeUtil.getInt(message, offset) == UnsafeUtil.getInt(other, offset);
            case 7:
                return arePresentForEquals(message, other, pos) && UnsafeUtil.getBoolean(message, offset) == UnsafeUtil.getBoolean(other, offset);
            case 8:
                return arePresentForEquals(message, other, pos) && SchemaUtil.safeEquals(UnsafeUtil.getObject(message, offset), UnsafeUtil.getObject(other, offset));
            case 9:
                return arePresentForEquals(message, other, pos) && SchemaUtil.safeEquals(UnsafeUtil.getObject(message, offset), UnsafeUtil.getObject(other, offset));
            case 10:
                return arePresentForEquals(message, other, pos) && SchemaUtil.safeEquals(UnsafeUtil.getObject(message, offset), UnsafeUtil.getObject(other, offset));
            case 11:
                return arePresentForEquals(message, other, pos) && UnsafeUtil.getInt(message, offset) == UnsafeUtil.getInt(other, offset);
            case 12:
                return arePresentForEquals(message, other, pos) && UnsafeUtil.getInt(message, offset) == UnsafeUtil.getInt(other, offset);
            case 13:
                return arePresentForEquals(message, other, pos) && UnsafeUtil.getInt(message, offset) == UnsafeUtil.getInt(other, offset);
            case 14:
                return arePresentForEquals(message, other, pos) && UnsafeUtil.getLong(message, offset) == UnsafeUtil.getLong(other, offset);
            case 15:
                return arePresentForEquals(message, other, pos) && UnsafeUtil.getInt(message, offset) == UnsafeUtil.getInt(other, offset);
            case 16:
                return arePresentForEquals(message, other, pos) && UnsafeUtil.getLong(message, offset) == UnsafeUtil.getLong(other, offset);
            case 17:
                return arePresentForEquals(message, other, pos) && SchemaUtil.safeEquals(UnsafeUtil.getObject(message, offset), UnsafeUtil.getObject(other, offset));
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 46:
            case 47:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE /* 48 */:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_EDITOR_ABSOLUTEX /* 49 */:
                return SchemaUtil.safeEquals(UnsafeUtil.getObject(message, offset), UnsafeUtil.getObject(other, offset));
            case 50:
                return SchemaUtil.safeEquals(UnsafeUtil.getObject(message, offset), UnsafeUtil.getObject(other, offset));
            case 51:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_TOP_OF /* 52 */:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_BOTTOM_OF /* 53 */:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_MARGIN_BASELINE /* 54 */:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE /* 55 */:
            case 56:
            case 57:
            case 58:
            case 59:
            case LockFreeTaskQueueCore.FROZEN_SHIFT /* 60 */:
            case LockFreeTaskQueueCore.CLOSED_SHIFT /* 61 */:
            case 62:
            case HtmlCompat.FROM_HTML_MODE_COMPACT /* 63 */:
            case 64:
            case 65:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT /* 66 */:
            case 67:
            case 68:
                return isOneofCaseEqual(message, other, pos) && SchemaUtil.safeEquals(UnsafeUtil.getObject(message, offset), UnsafeUtil.getObject(other, offset));
            default:
                return true;
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:4:0x0019. Please report as an issue. */
    @Override // androidx.datastore.preferences.protobuf.Schema
    public int hashCode(T message) {
        int i;
        int hashLong;
        int length = this.buffer.length;
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3 += 3) {
            int typeAndOffsetAt = typeAndOffsetAt(i3);
            int numberAt = numberAt(i3);
            long offset = offset(typeAndOffsetAt);
            int i4 = 37;
            switch (type(typeAndOffsetAt)) {
                case 0:
                    i = i2 * 53;
                    hashLong = Internal.hashLong(Double.doubleToLongBits(UnsafeUtil.getDouble(message, offset)));
                    i2 = i + hashLong;
                    break;
                case 1:
                    i = i2 * 53;
                    hashLong = Float.floatToIntBits(UnsafeUtil.getFloat(message, offset));
                    i2 = i + hashLong;
                    break;
                case 2:
                    i = i2 * 53;
                    hashLong = Internal.hashLong(UnsafeUtil.getLong(message, offset));
                    i2 = i + hashLong;
                    break;
                case 3:
                    i = i2 * 53;
                    hashLong = Internal.hashLong(UnsafeUtil.getLong(message, offset));
                    i2 = i + hashLong;
                    break;
                case 4:
                    i = i2 * 53;
                    hashLong = UnsafeUtil.getInt(message, offset);
                    i2 = i + hashLong;
                    break;
                case 5:
                    i = i2 * 53;
                    hashLong = Internal.hashLong(UnsafeUtil.getLong(message, offset));
                    i2 = i + hashLong;
                    break;
                case 6:
                    i = i2 * 53;
                    hashLong = UnsafeUtil.getInt(message, offset);
                    i2 = i + hashLong;
                    break;
                case 7:
                    i = i2 * 53;
                    hashLong = Internal.hashBoolean(UnsafeUtil.getBoolean(message, offset));
                    i2 = i + hashLong;
                    break;
                case 8:
                    i = i2 * 53;
                    hashLong = ((String) UnsafeUtil.getObject(message, offset)).hashCode();
                    i2 = i + hashLong;
                    break;
                case 9:
                    Object object = UnsafeUtil.getObject(message, offset);
                    if (object != null) {
                        i4 = object.hashCode();
                    }
                    i2 = (i2 * 53) + i4;
                    break;
                case 10:
                    i = i2 * 53;
                    hashLong = UnsafeUtil.getObject(message, offset).hashCode();
                    i2 = i + hashLong;
                    break;
                case 11:
                    i = i2 * 53;
                    hashLong = UnsafeUtil.getInt(message, offset);
                    i2 = i + hashLong;
                    break;
                case 12:
                    i = i2 * 53;
                    hashLong = UnsafeUtil.getInt(message, offset);
                    i2 = i + hashLong;
                    break;
                case 13:
                    i = i2 * 53;
                    hashLong = UnsafeUtil.getInt(message, offset);
                    i2 = i + hashLong;
                    break;
                case 14:
                    i = i2 * 53;
                    hashLong = Internal.hashLong(UnsafeUtil.getLong(message, offset));
                    i2 = i + hashLong;
                    break;
                case 15:
                    i = i2 * 53;
                    hashLong = UnsafeUtil.getInt(message, offset);
                    i2 = i + hashLong;
                    break;
                case 16:
                    i = i2 * 53;
                    hashLong = Internal.hashLong(UnsafeUtil.getLong(message, offset));
                    i2 = i + hashLong;
                    break;
                case 17:
                    Object object2 = UnsafeUtil.getObject(message, offset);
                    if (object2 != null) {
                        i4 = object2.hashCode();
                    }
                    i2 = (i2 * 53) + i4;
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE /* 48 */:
                case ConstraintLayout.LayoutParams.Table.LAYOUT_EDITOR_ABSOLUTEX /* 49 */:
                    i = i2 * 53;
                    hashLong = UnsafeUtil.getObject(message, offset).hashCode();
                    i2 = i + hashLong;
                    break;
                case 50:
                    i = i2 * 53;
                    hashLong = UnsafeUtil.getObject(message, offset).hashCode();
                    i2 = i + hashLong;
                    break;
                case 51:
                    if (isOneofPresent(message, numberAt, i3)) {
                        i = i2 * 53;
                        hashLong = Internal.hashLong(Double.doubleToLongBits(oneofDoubleAt(message, offset)));
                        i2 = i + hashLong;
                        break;
                    } else {
                        break;
                    }
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_TOP_OF /* 52 */:
                    if (isOneofPresent(message, numberAt, i3)) {
                        i = i2 * 53;
                        hashLong = Float.floatToIntBits(oneofFloatAt(message, offset));
                        i2 = i + hashLong;
                        break;
                    } else {
                        break;
                    }
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_BOTTOM_OF /* 53 */:
                    if (isOneofPresent(message, numberAt, i3)) {
                        i = i2 * 53;
                        hashLong = Internal.hashLong(oneofLongAt(message, offset));
                        i2 = i + hashLong;
                        break;
                    } else {
                        break;
                    }
                case ConstraintLayout.LayoutParams.Table.LAYOUT_MARGIN_BASELINE /* 54 */:
                    if (isOneofPresent(message, numberAt, i3)) {
                        i = i2 * 53;
                        hashLong = Internal.hashLong(oneofLongAt(message, offset));
                        i2 = i + hashLong;
                        break;
                    } else {
                        break;
                    }
                case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE /* 55 */:
                    if (isOneofPresent(message, numberAt, i3)) {
                        i = i2 * 53;
                        hashLong = oneofIntAt(message, offset);
                        i2 = i + hashLong;
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (isOneofPresent(message, numberAt, i3)) {
                        i = i2 * 53;
                        hashLong = Internal.hashLong(oneofLongAt(message, offset));
                        i2 = i + hashLong;
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (isOneofPresent(message, numberAt, i3)) {
                        i = i2 * 53;
                        hashLong = oneofIntAt(message, offset);
                        i2 = i + hashLong;
                        break;
                    } else {
                        break;
                    }
                case 58:
                    if (isOneofPresent(message, numberAt, i3)) {
                        i = i2 * 53;
                        hashLong = Internal.hashBoolean(oneofBooleanAt(message, offset));
                        i2 = i + hashLong;
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (isOneofPresent(message, numberAt, i3)) {
                        i = i2 * 53;
                        hashLong = ((String) UnsafeUtil.getObject(message, offset)).hashCode();
                        i2 = i + hashLong;
                        break;
                    } else {
                        break;
                    }
                case LockFreeTaskQueueCore.FROZEN_SHIFT /* 60 */:
                    if (isOneofPresent(message, numberAt, i3)) {
                        i = i2 * 53;
                        hashLong = UnsafeUtil.getObject(message, offset).hashCode();
                        i2 = i + hashLong;
                        break;
                    } else {
                        break;
                    }
                case LockFreeTaskQueueCore.CLOSED_SHIFT /* 61 */:
                    if (isOneofPresent(message, numberAt, i3)) {
                        i = i2 * 53;
                        hashLong = UnsafeUtil.getObject(message, offset).hashCode();
                        i2 = i + hashLong;
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (isOneofPresent(message, numberAt, i3)) {
                        i = i2 * 53;
                        hashLong = oneofIntAt(message, offset);
                        i2 = i + hashLong;
                        break;
                    } else {
                        break;
                    }
                case HtmlCompat.FROM_HTML_MODE_COMPACT /* 63 */:
                    if (isOneofPresent(message, numberAt, i3)) {
                        i = i2 * 53;
                        hashLong = oneofIntAt(message, offset);
                        i2 = i + hashLong;
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (isOneofPresent(message, numberAt, i3)) {
                        i = i2 * 53;
                        hashLong = oneofIntAt(message, offset);
                        i2 = i + hashLong;
                        break;
                    } else {
                        break;
                    }
                case 65:
                    if (isOneofPresent(message, numberAt, i3)) {
                        i = i2 * 53;
                        hashLong = Internal.hashLong(oneofLongAt(message, offset));
                        i2 = i + hashLong;
                        break;
                    } else {
                        break;
                    }
                case ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT /* 66 */:
                    if (isOneofPresent(message, numberAt, i3)) {
                        i = i2 * 53;
                        hashLong = oneofIntAt(message, offset);
                        i2 = i + hashLong;
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (isOneofPresent(message, numberAt, i3)) {
                        i = i2 * 53;
                        hashLong = Internal.hashLong(oneofLongAt(message, offset));
                        i2 = i + hashLong;
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (isOneofPresent(message, numberAt, i3)) {
                        i = i2 * 53;
                        hashLong = UnsafeUtil.getObject(message, offset).hashCode();
                        i2 = i + hashLong;
                        break;
                    } else {
                        break;
                    }
            }
        }
        int hashCode = (i2 * 53) + this.unknownFieldSchema.getFromMessage(message).hashCode();
        return this.hasExtensions ? (hashCode * 53) + this.extensionSchema.getExtensions(message).hashCode() : hashCode;
    }

    @Override // androidx.datastore.preferences.protobuf.Schema
    public void mergeFrom(T message, T other) {
        checkMutable(message);
        other.getClass();
        for (int i = 0; i < this.buffer.length; i += 3) {
            mergeSingleField(message, other, i);
        }
        SchemaUtil.mergeUnknownFields(this.unknownFieldSchema, message, other);
        if (this.hasExtensions) {
            SchemaUtil.mergeExtensions(this.extensionSchema, message, other);
        }
    }

    private void mergeSingleField(T message, T other, int pos) {
        int typeAndOffsetAt = typeAndOffsetAt(pos);
        long offset = offset(typeAndOffsetAt);
        int numberAt = numberAt(pos);
        switch (type(typeAndOffsetAt)) {
            case 0:
                if (isFieldPresent(other, pos)) {
                    UnsafeUtil.putDouble(message, offset, UnsafeUtil.getDouble(other, offset));
                    setFieldPresent(message, pos);
                    return;
                }
                return;
            case 1:
                if (isFieldPresent(other, pos)) {
                    UnsafeUtil.putFloat(message, offset, UnsafeUtil.getFloat(other, offset));
                    setFieldPresent(message, pos);
                    return;
                }
                return;
            case 2:
                if (isFieldPresent(other, pos)) {
                    UnsafeUtil.putLong(message, offset, UnsafeUtil.getLong(other, offset));
                    setFieldPresent(message, pos);
                    return;
                }
                return;
            case 3:
                if (isFieldPresent(other, pos)) {
                    UnsafeUtil.putLong(message, offset, UnsafeUtil.getLong(other, offset));
                    setFieldPresent(message, pos);
                    return;
                }
                return;
            case 4:
                if (isFieldPresent(other, pos)) {
                    UnsafeUtil.putInt(message, offset, UnsafeUtil.getInt(other, offset));
                    setFieldPresent(message, pos);
                    return;
                }
                return;
            case 5:
                if (isFieldPresent(other, pos)) {
                    UnsafeUtil.putLong(message, offset, UnsafeUtil.getLong(other, offset));
                    setFieldPresent(message, pos);
                    return;
                }
                return;
            case 6:
                if (isFieldPresent(other, pos)) {
                    UnsafeUtil.putInt(message, offset, UnsafeUtil.getInt(other, offset));
                    setFieldPresent(message, pos);
                    return;
                }
                return;
            case 7:
                if (isFieldPresent(other, pos)) {
                    UnsafeUtil.putBoolean(message, offset, UnsafeUtil.getBoolean(other, offset));
                    setFieldPresent(message, pos);
                    return;
                }
                return;
            case 8:
                if (isFieldPresent(other, pos)) {
                    UnsafeUtil.putObject(message, offset, UnsafeUtil.getObject(other, offset));
                    setFieldPresent(message, pos);
                    return;
                }
                return;
            case 9:
                mergeMessage(message, other, pos);
                return;
            case 10:
                if (isFieldPresent(other, pos)) {
                    UnsafeUtil.putObject(message, offset, UnsafeUtil.getObject(other, offset));
                    setFieldPresent(message, pos);
                    return;
                }
                return;
            case 11:
                if (isFieldPresent(other, pos)) {
                    UnsafeUtil.putInt(message, offset, UnsafeUtil.getInt(other, offset));
                    setFieldPresent(message, pos);
                    return;
                }
                return;
            case 12:
                if (isFieldPresent(other, pos)) {
                    UnsafeUtil.putInt(message, offset, UnsafeUtil.getInt(other, offset));
                    setFieldPresent(message, pos);
                    return;
                }
                return;
            case 13:
                if (isFieldPresent(other, pos)) {
                    UnsafeUtil.putInt(message, offset, UnsafeUtil.getInt(other, offset));
                    setFieldPresent(message, pos);
                    return;
                }
                return;
            case 14:
                if (isFieldPresent(other, pos)) {
                    UnsafeUtil.putLong(message, offset, UnsafeUtil.getLong(other, offset));
                    setFieldPresent(message, pos);
                    return;
                }
                return;
            case 15:
                if (isFieldPresent(other, pos)) {
                    UnsafeUtil.putInt(message, offset, UnsafeUtil.getInt(other, offset));
                    setFieldPresent(message, pos);
                    return;
                }
                return;
            case 16:
                if (isFieldPresent(other, pos)) {
                    UnsafeUtil.putLong(message, offset, UnsafeUtil.getLong(other, offset));
                    setFieldPresent(message, pos);
                    return;
                }
                return;
            case 17:
                mergeMessage(message, other, pos);
                return;
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 46:
            case 47:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE /* 48 */:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_EDITOR_ABSOLUTEX /* 49 */:
                this.listFieldSchema.mergeListsAt(message, other, offset);
                return;
            case 50:
                SchemaUtil.mergeMap(this.mapFieldSchema, message, other, offset);
                return;
            case 51:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_TOP_OF /* 52 */:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_BOTTOM_OF /* 53 */:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_MARGIN_BASELINE /* 54 */:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE /* 55 */:
            case 56:
            case 57:
            case 58:
            case 59:
                if (isOneofPresent(other, numberAt, pos)) {
                    UnsafeUtil.putObject(message, offset, UnsafeUtil.getObject(other, offset));
                    setOneofPresent(message, numberAt, pos);
                    return;
                }
                return;
            case LockFreeTaskQueueCore.FROZEN_SHIFT /* 60 */:
                mergeOneofMessage(message, other, pos);
                return;
            case LockFreeTaskQueueCore.CLOSED_SHIFT /* 61 */:
            case 62:
            case HtmlCompat.FROM_HTML_MODE_COMPACT /* 63 */:
            case 64:
            case 65:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT /* 66 */:
            case 67:
                if (isOneofPresent(other, numberAt, pos)) {
                    UnsafeUtil.putObject(message, offset, UnsafeUtil.getObject(other, offset));
                    setOneofPresent(message, numberAt, pos);
                    return;
                }
                return;
            case 68:
                mergeOneofMessage(message, other, pos);
                return;
            default:
                return;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void mergeMessage(T targetParent, T sourceParent, int pos) {
        if (isFieldPresent(sourceParent, pos)) {
            long offset = offset(typeAndOffsetAt(pos));
            Unsafe unsafe = UNSAFE;
            Object object = unsafe.getObject(sourceParent, offset);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + numberAt(pos) + " is present but null: " + sourceParent);
            }
            Schema messageFieldSchema = getMessageFieldSchema(pos);
            if (!isFieldPresent(targetParent, pos)) {
                if (!isMutable(object)) {
                    unsafe.putObject(targetParent, offset, object);
                } else {
                    Object newInstance = messageFieldSchema.newInstance();
                    messageFieldSchema.mergeFrom(newInstance, object);
                    unsafe.putObject(targetParent, offset, newInstance);
                }
                setFieldPresent(targetParent, pos);
                return;
            }
            Object object2 = unsafe.getObject(targetParent, offset);
            if (!isMutable(object2)) {
                Object newInstance2 = messageFieldSchema.newInstance();
                messageFieldSchema.mergeFrom(newInstance2, object2);
                unsafe.putObject(targetParent, offset, newInstance2);
                object2 = newInstance2;
            }
            messageFieldSchema.mergeFrom(object2, object);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void mergeOneofMessage(T targetParent, T sourceParent, int pos) {
        int numberAt = numberAt(pos);
        if (isOneofPresent(sourceParent, numberAt, pos)) {
            long offset = offset(typeAndOffsetAt(pos));
            Unsafe unsafe = UNSAFE;
            Object object = unsafe.getObject(sourceParent, offset);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + numberAt(pos) + " is present but null: " + sourceParent);
            }
            Schema messageFieldSchema = getMessageFieldSchema(pos);
            if (!isOneofPresent(targetParent, numberAt, pos)) {
                if (!isMutable(object)) {
                    unsafe.putObject(targetParent, offset, object);
                } else {
                    Object newInstance = messageFieldSchema.newInstance();
                    messageFieldSchema.mergeFrom(newInstance, object);
                    unsafe.putObject(targetParent, offset, newInstance);
                }
                setOneofPresent(targetParent, numberAt, pos);
                return;
            }
            Object object2 = unsafe.getObject(targetParent, offset);
            if (!isMutable(object2)) {
                Object newInstance2 = messageFieldSchema.newInstance();
                messageFieldSchema.mergeFrom(newInstance2, object2);
                unsafe.putObject(targetParent, offset, newInstance2);
                object2 = newInstance2;
            }
            messageFieldSchema.mergeFrom(object2, object);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:17:0x0061. Please report as an issue. */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r9v16 */
    @Override // androidx.datastore.preferences.protobuf.Schema
    public int getSerializedSize(T message) {
        int i;
        int i2;
        int i3;
        boolean z;
        int computeDoubleSize;
        int computeBoolSize;
        int computeSizeFixed64List;
        int computeSizeFixed64ListNoTag;
        int computeTagSize;
        int computeUInt32SizeNoTag;
        Unsafe unsafe = UNSAFE;
        ?? r9 = 0;
        int i4 = 1048575;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 1048575;
        while (i6 < this.buffer.length) {
            int typeAndOffsetAt = typeAndOffsetAt(i6);
            int type = type(typeAndOffsetAt);
            int numberAt = numberAt(i6);
            int i9 = this.buffer[i6 + 2];
            int i10 = i9 & i4;
            if (type <= 17) {
                if (i10 != i8) {
                    i5 = i10 == i4 ? r9 : unsafe.getInt(message, i10);
                    i8 = i10;
                }
                i = i8;
                i2 = i5;
                i3 = 1 << (i9 >>> 20);
            } else {
                i = i8;
                i2 = i5;
                i3 = r9;
            }
            long offset = offset(typeAndOffsetAt);
            if (type < FieldType.DOUBLE_LIST_PACKED.id() || type > FieldType.SINT64_LIST_PACKED.id()) {
                i10 = r9;
            }
            int i11 = i10;
            switch (type) {
                case 0:
                    z = r9;
                    if (!isFieldPresent(message, i6, i, i2, i3)) {
                        break;
                    } else {
                        computeDoubleSize = CodedOutputStream.computeDoubleSize(numberAt, AudioStats.AUDIO_AMPLITUDE_NONE);
                        i7 += computeDoubleSize;
                        break;
                    }
                case 1:
                    z = r9;
                    if (!isFieldPresent(message, i6, i, i2, i3)) {
                        break;
                    } else {
                        computeDoubleSize = CodedOutputStream.computeFloatSize(numberAt, 0.0f);
                        i7 += computeDoubleSize;
                        break;
                    }
                case 2:
                    z = r9;
                    if (!isFieldPresent(message, i6, i, i2, i3)) {
                        break;
                    } else {
                        computeDoubleSize = CodedOutputStream.computeInt64Size(numberAt, unsafe.getLong(message, offset));
                        i7 += computeDoubleSize;
                        break;
                    }
                case 3:
                    z = r9;
                    if (!isFieldPresent(message, i6, i, i2, i3)) {
                        break;
                    } else {
                        computeDoubleSize = CodedOutputStream.computeUInt64Size(numberAt, unsafe.getLong(message, offset));
                        i7 += computeDoubleSize;
                        break;
                    }
                case 4:
                    z = r9;
                    if (!isFieldPresent(message, i6, i, i2, i3)) {
                        break;
                    } else {
                        computeDoubleSize = CodedOutputStream.computeInt32Size(numberAt, unsafe.getInt(message, offset));
                        i7 += computeDoubleSize;
                        break;
                    }
                case 5:
                    z = r9;
                    if (!isFieldPresent(message, i6, i, i2, i3)) {
                        break;
                    } else {
                        computeDoubleSize = CodedOutputStream.computeFixed64Size(numberAt, 0L);
                        i7 += computeDoubleSize;
                        break;
                    }
                case 6:
                    if (isFieldPresent(message, i6, i, i2, i3)) {
                        z = false;
                        computeDoubleSize = CodedOutputStream.computeFixed32Size(numberAt, 0);
                        i7 += computeDoubleSize;
                        break;
                    }
                    z = false;
                    break;
                case 7:
                    if (isFieldPresent(message, i6, i, i2, i3)) {
                        computeBoolSize = CodedOutputStream.computeBoolSize(numberAt, true);
                        i7 += computeBoolSize;
                    }
                    z = false;
                    break;
                case 8:
                    if (isFieldPresent(message, i6, i, i2, i3)) {
                        Object object = unsafe.getObject(message, offset);
                        if (object instanceof ByteString) {
                            computeBoolSize = CodedOutputStream.computeBytesSize(numberAt, (ByteString) object);
                        } else {
                            computeBoolSize = CodedOutputStream.computeStringSize(numberAt, (String) object);
                        }
                        i7 += computeBoolSize;
                    }
                    z = false;
                    break;
                case 9:
                    if (isFieldPresent(message, i6, i, i2, i3)) {
                        computeBoolSize = SchemaUtil.computeSizeMessage(numberAt, unsafe.getObject(message, offset), getMessageFieldSchema(i6));
                        i7 += computeBoolSize;
                    }
                    z = false;
                    break;
                case 10:
                    if (isFieldPresent(message, i6, i, i2, i3)) {
                        computeBoolSize = CodedOutputStream.computeBytesSize(numberAt, (ByteString) unsafe.getObject(message, offset));
                        i7 += computeBoolSize;
                    }
                    z = false;
                    break;
                case 11:
                    if (isFieldPresent(message, i6, i, i2, i3)) {
                        computeBoolSize = CodedOutputStream.computeUInt32Size(numberAt, unsafe.getInt(message, offset));
                        i7 += computeBoolSize;
                    }
                    z = false;
                    break;
                case 12:
                    if (isFieldPresent(message, i6, i, i2, i3)) {
                        computeBoolSize = CodedOutputStream.computeEnumSize(numberAt, unsafe.getInt(message, offset));
                        i7 += computeBoolSize;
                    }
                    z = false;
                    break;
                case 13:
                    if (isFieldPresent(message, i6, i, i2, i3)) {
                        i7 += CodedOutputStream.computeSFixed32Size(numberAt, 0);
                    }
                    z = false;
                    break;
                case 14:
                    if (isFieldPresent(message, i6, i, i2, i3)) {
                        computeBoolSize = CodedOutputStream.computeSFixed64Size(numberAt, 0L);
                        i7 += computeBoolSize;
                    }
                    z = false;
                    break;
                case 15:
                    if (isFieldPresent(message, i6, i, i2, i3)) {
                        computeBoolSize = CodedOutputStream.computeSInt32Size(numberAt, unsafe.getInt(message, offset));
                        i7 += computeBoolSize;
                    }
                    z = false;
                    break;
                case 16:
                    if (isFieldPresent(message, i6, i, i2, i3)) {
                        computeBoolSize = CodedOutputStream.computeSInt64Size(numberAt, unsafe.getLong(message, offset));
                        i7 += computeBoolSize;
                    }
                    z = false;
                    break;
                case 17:
                    if (isFieldPresent(message, i6, i, i2, i3)) {
                        computeBoolSize = CodedOutputStream.computeGroupSize(numberAt, (MessageLite) unsafe.getObject(message, offset), getMessageFieldSchema(i6));
                        i7 += computeBoolSize;
                    }
                    z = false;
                    break;
                case 18:
                    computeSizeFixed64List = SchemaUtil.computeSizeFixed64List(numberAt, (List) unsafe.getObject(message, offset), r9);
                    i7 += computeSizeFixed64List;
                    z = r9;
                    break;
                case 19:
                    computeSizeFixed64List = SchemaUtil.computeSizeFixed32List(numberAt, (List) unsafe.getObject(message, offset), r9);
                    i7 += computeSizeFixed64List;
                    z = r9;
                    break;
                case 20:
                    computeSizeFixed64List = SchemaUtil.computeSizeInt64List(numberAt, (List) unsafe.getObject(message, offset), r9);
                    i7 += computeSizeFixed64List;
                    z = r9;
                    break;
                case 21:
                    computeSizeFixed64List = SchemaUtil.computeSizeUInt64List(numberAt, (List) unsafe.getObject(message, offset), r9);
                    i7 += computeSizeFixed64List;
                    z = r9;
                    break;
                case 22:
                    computeSizeFixed64List = SchemaUtil.computeSizeInt32List(numberAt, (List) unsafe.getObject(message, offset), r9);
                    i7 += computeSizeFixed64List;
                    z = r9;
                    break;
                case 23:
                    computeSizeFixed64List = SchemaUtil.computeSizeFixed64List(numberAt, (List) unsafe.getObject(message, offset), r9);
                    i7 += computeSizeFixed64List;
                    z = r9;
                    break;
                case 24:
                    computeSizeFixed64List = SchemaUtil.computeSizeFixed32List(numberAt, (List) unsafe.getObject(message, offset), r9);
                    i7 += computeSizeFixed64List;
                    z = r9;
                    break;
                case 25:
                    computeSizeFixed64List = SchemaUtil.computeSizeBoolList(numberAt, (List) unsafe.getObject(message, offset), r9);
                    i7 += computeSizeFixed64List;
                    z = r9;
                    break;
                case 26:
                    computeSizeFixed64List = SchemaUtil.computeSizeStringList(numberAt, (List) unsafe.getObject(message, offset));
                    i7 += computeSizeFixed64List;
                    z = r9;
                    break;
                case 27:
                    computeSizeFixed64List = SchemaUtil.computeSizeMessageList(numberAt, (List) unsafe.getObject(message, offset), getMessageFieldSchema(i6));
                    i7 += computeSizeFixed64List;
                    z = r9;
                    break;
                case 28:
                    computeSizeFixed64List = SchemaUtil.computeSizeByteStringList(numberAt, (List) unsafe.getObject(message, offset));
                    i7 += computeSizeFixed64List;
                    z = r9;
                    break;
                case 29:
                    computeSizeFixed64List = SchemaUtil.computeSizeUInt32List(numberAt, (List) unsafe.getObject(message, offset), r9);
                    i7 += computeSizeFixed64List;
                    z = r9;
                    break;
                case 30:
                    computeSizeFixed64List = SchemaUtil.computeSizeEnumList(numberAt, (List) unsafe.getObject(message, offset), r9);
                    i7 += computeSizeFixed64List;
                    z = r9;
                    break;
                case 31:
                    computeSizeFixed64List = SchemaUtil.computeSizeFixed32List(numberAt, (List) unsafe.getObject(message, offset), r9);
                    i7 += computeSizeFixed64List;
                    z = r9;
                    break;
                case 32:
                    computeSizeFixed64List = SchemaUtil.computeSizeFixed64List(numberAt, (List) unsafe.getObject(message, offset), r9);
                    i7 += computeSizeFixed64List;
                    z = r9;
                    break;
                case 33:
                    computeSizeFixed64List = SchemaUtil.computeSizeSInt32List(numberAt, (List) unsafe.getObject(message, offset), r9);
                    i7 += computeSizeFixed64List;
                    z = r9;
                    break;
                case 34:
                    computeSizeFixed64List = SchemaUtil.computeSizeSInt64List(numberAt, (List) unsafe.getObject(message, offset), r9);
                    i7 += computeSizeFixed64List;
                    z = r9;
                    break;
                case 35:
                    computeSizeFixed64ListNoTag = SchemaUtil.computeSizeFixed64ListNoTag((List) unsafe.getObject(message, offset));
                    if (computeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(message, i11, computeSizeFixed64ListNoTag);
                        }
                        computeTagSize = CodedOutputStream.computeTagSize(numberAt);
                        computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(computeSizeFixed64ListNoTag);
                        computeSizeFixed64List = computeTagSize + computeUInt32SizeNoTag + computeSizeFixed64ListNoTag;
                        i7 += computeSizeFixed64List;
                    }
                    z = r9;
                    break;
                case 36:
                    computeSizeFixed64ListNoTag = SchemaUtil.computeSizeFixed32ListNoTag((List) unsafe.getObject(message, offset));
                    if (computeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(message, i11, computeSizeFixed64ListNoTag);
                        }
                        computeTagSize = CodedOutputStream.computeTagSize(numberAt);
                        computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(computeSizeFixed64ListNoTag);
                        computeSizeFixed64List = computeTagSize + computeUInt32SizeNoTag + computeSizeFixed64ListNoTag;
                        i7 += computeSizeFixed64List;
                    }
                    z = r9;
                    break;
                case 37:
                    computeSizeFixed64ListNoTag = SchemaUtil.computeSizeInt64ListNoTag((List) unsafe.getObject(message, offset));
                    if (computeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(message, i11, computeSizeFixed64ListNoTag);
                        }
                        computeTagSize = CodedOutputStream.computeTagSize(numberAt);
                        computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(computeSizeFixed64ListNoTag);
                        computeSizeFixed64List = computeTagSize + computeUInt32SizeNoTag + computeSizeFixed64ListNoTag;
                        i7 += computeSizeFixed64List;
                    }
                    z = r9;
                    break;
                case 38:
                    computeSizeFixed64ListNoTag = SchemaUtil.computeSizeUInt64ListNoTag((List) unsafe.getObject(message, offset));
                    if (computeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(message, i11, computeSizeFixed64ListNoTag);
                        }
                        computeTagSize = CodedOutputStream.computeTagSize(numberAt);
                        computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(computeSizeFixed64ListNoTag);
                        computeSizeFixed64List = computeTagSize + computeUInt32SizeNoTag + computeSizeFixed64ListNoTag;
                        i7 += computeSizeFixed64List;
                    }
                    z = r9;
                    break;
                case 39:
                    computeSizeFixed64ListNoTag = SchemaUtil.computeSizeInt32ListNoTag((List) unsafe.getObject(message, offset));
                    if (computeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(message, i11, computeSizeFixed64ListNoTag);
                        }
                        computeTagSize = CodedOutputStream.computeTagSize(numberAt);
                        computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(computeSizeFixed64ListNoTag);
                        computeSizeFixed64List = computeTagSize + computeUInt32SizeNoTag + computeSizeFixed64ListNoTag;
                        i7 += computeSizeFixed64List;
                    }
                    z = r9;
                    break;
                case 40:
                    computeSizeFixed64ListNoTag = SchemaUtil.computeSizeFixed64ListNoTag((List) unsafe.getObject(message, offset));
                    if (computeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(message, i11, computeSizeFixed64ListNoTag);
                        }
                        computeTagSize = CodedOutputStream.computeTagSize(numberAt);
                        computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(computeSizeFixed64ListNoTag);
                        computeSizeFixed64List = computeTagSize + computeUInt32SizeNoTag + computeSizeFixed64ListNoTag;
                        i7 += computeSizeFixed64List;
                    }
                    z = r9;
                    break;
                case 41:
                    computeSizeFixed64ListNoTag = SchemaUtil.computeSizeFixed32ListNoTag((List) unsafe.getObject(message, offset));
                    if (computeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(message, i11, computeSizeFixed64ListNoTag);
                        }
                        computeTagSize = CodedOutputStream.computeTagSize(numberAt);
                        computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(computeSizeFixed64ListNoTag);
                        computeSizeFixed64List = computeTagSize + computeUInt32SizeNoTag + computeSizeFixed64ListNoTag;
                        i7 += computeSizeFixed64List;
                    }
                    z = r9;
                    break;
                case 42:
                    computeSizeFixed64ListNoTag = SchemaUtil.computeSizeBoolListNoTag((List) unsafe.getObject(message, offset));
                    if (computeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(message, i11, computeSizeFixed64ListNoTag);
                        }
                        computeTagSize = CodedOutputStream.computeTagSize(numberAt);
                        computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(computeSizeFixed64ListNoTag);
                        computeSizeFixed64List = computeTagSize + computeUInt32SizeNoTag + computeSizeFixed64ListNoTag;
                        i7 += computeSizeFixed64List;
                    }
                    z = r9;
                    break;
                case 43:
                    computeSizeFixed64ListNoTag = SchemaUtil.computeSizeUInt32ListNoTag((List) unsafe.getObject(message, offset));
                    if (computeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(message, i11, computeSizeFixed64ListNoTag);
                        }
                        computeTagSize = CodedOutputStream.computeTagSize(numberAt);
                        computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(computeSizeFixed64ListNoTag);
                        computeSizeFixed64List = computeTagSize + computeUInt32SizeNoTag + computeSizeFixed64ListNoTag;
                        i7 += computeSizeFixed64List;
                    }
                    z = r9;
                    break;
                case 44:
                    computeSizeFixed64ListNoTag = SchemaUtil.computeSizeEnumListNoTag((List) unsafe.getObject(message, offset));
                    if (computeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(message, i11, computeSizeFixed64ListNoTag);
                        }
                        computeTagSize = CodedOutputStream.computeTagSize(numberAt);
                        computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(computeSizeFixed64ListNoTag);
                        computeSizeFixed64List = computeTagSize + computeUInt32SizeNoTag + computeSizeFixed64ListNoTag;
                        i7 += computeSizeFixed64List;
                    }
                    z = r9;
                    break;
                case 45:
                    computeSizeFixed64ListNoTag = SchemaUtil.computeSizeFixed32ListNoTag((List) unsafe.getObject(message, offset));
                    if (computeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(message, i11, computeSizeFixed64ListNoTag);
                        }
                        computeTagSize = CodedOutputStream.computeTagSize(numberAt);
                        computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(computeSizeFixed64ListNoTag);
                        computeSizeFixed64List = computeTagSize + computeUInt32SizeNoTag + computeSizeFixed64ListNoTag;
                        i7 += computeSizeFixed64List;
                    }
                    z = r9;
                    break;
                case 46:
                    computeSizeFixed64ListNoTag = SchemaUtil.computeSizeFixed64ListNoTag((List) unsafe.getObject(message, offset));
                    if (computeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(message, i11, computeSizeFixed64ListNoTag);
                        }
                        computeTagSize = CodedOutputStream.computeTagSize(numberAt);
                        computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(computeSizeFixed64ListNoTag);
                        computeSizeFixed64List = computeTagSize + computeUInt32SizeNoTag + computeSizeFixed64ListNoTag;
                        i7 += computeSizeFixed64List;
                    }
                    z = r9;
                    break;
                case 47:
                    computeSizeFixed64ListNoTag = SchemaUtil.computeSizeSInt32ListNoTag((List) unsafe.getObject(message, offset));
                    if (computeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(message, i11, computeSizeFixed64ListNoTag);
                        }
                        computeTagSize = CodedOutputStream.computeTagSize(numberAt);
                        computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(computeSizeFixed64ListNoTag);
                        computeSizeFixed64List = computeTagSize + computeUInt32SizeNoTag + computeSizeFixed64ListNoTag;
                        i7 += computeSizeFixed64List;
                    }
                    z = r9;
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE /* 48 */:
                    computeSizeFixed64ListNoTag = SchemaUtil.computeSizeSInt64ListNoTag((List) unsafe.getObject(message, offset));
                    if (computeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(message, i11, computeSizeFixed64ListNoTag);
                        }
                        computeTagSize = CodedOutputStream.computeTagSize(numberAt);
                        computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(computeSizeFixed64ListNoTag);
                        computeSizeFixed64List = computeTagSize + computeUInt32SizeNoTag + computeSizeFixed64ListNoTag;
                        i7 += computeSizeFixed64List;
                    }
                    z = r9;
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_EDITOR_ABSOLUTEX /* 49 */:
                    computeSizeFixed64List = SchemaUtil.computeSizeGroupList(numberAt, (List) unsafe.getObject(message, offset), getMessageFieldSchema(i6));
                    i7 += computeSizeFixed64List;
                    z = r9;
                    break;
                case 50:
                    computeSizeFixed64List = this.mapFieldSchema.getSerializedSize(numberAt, unsafe.getObject(message, offset), getMapFieldDefaultEntry(i6));
                    i7 += computeSizeFixed64List;
                    z = r9;
                    break;
                case 51:
                    if (isOneofPresent(message, numberAt, i6)) {
                        computeSizeFixed64List = CodedOutputStream.computeDoubleSize(numberAt, AudioStats.AUDIO_AMPLITUDE_NONE);
                        i7 += computeSizeFixed64List;
                    }
                    z = r9;
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_TOP_OF /* 52 */:
                    if (isOneofPresent(message, numberAt, i6)) {
                        computeSizeFixed64List = CodedOutputStream.computeFloatSize(numberAt, 0.0f);
                        i7 += computeSizeFixed64List;
                    }
                    z = r9;
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_BOTTOM_OF /* 53 */:
                    if (isOneofPresent(message, numberAt, i6)) {
                        computeSizeFixed64List = CodedOutputStream.computeInt64Size(numberAt, oneofLongAt(message, offset));
                        i7 += computeSizeFixed64List;
                    }
                    z = r9;
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_MARGIN_BASELINE /* 54 */:
                    if (isOneofPresent(message, numberAt, i6)) {
                        computeSizeFixed64List = CodedOutputStream.computeUInt64Size(numberAt, oneofLongAt(message, offset));
                        i7 += computeSizeFixed64List;
                    }
                    z = r9;
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE /* 55 */:
                    if (isOneofPresent(message, numberAt, i6)) {
                        computeSizeFixed64List = CodedOutputStream.computeInt32Size(numberAt, oneofIntAt(message, offset));
                        i7 += computeSizeFixed64List;
                    }
                    z = r9;
                    break;
                case 56:
                    if (isOneofPresent(message, numberAt, i6)) {
                        computeSizeFixed64List = CodedOutputStream.computeFixed64Size(numberAt, 0L);
                        i7 += computeSizeFixed64List;
                    }
                    z = r9;
                    break;
                case 57:
                    if (isOneofPresent(message, numberAt, i6)) {
                        computeSizeFixed64List = CodedOutputStream.computeFixed32Size(numberAt, r9);
                        i7 += computeSizeFixed64List;
                    }
                    z = r9;
                    break;
                case 58:
                    if (isOneofPresent(message, numberAt, i6)) {
                        computeSizeFixed64List = CodedOutputStream.computeBoolSize(numberAt, true);
                        i7 += computeSizeFixed64List;
                    }
                    z = r9;
                    break;
                case 59:
                    if (isOneofPresent(message, numberAt, i6)) {
                        Object object2 = unsafe.getObject(message, offset);
                        if (object2 instanceof ByteString) {
                            computeSizeFixed64List = CodedOutputStream.computeBytesSize(numberAt, (ByteString) object2);
                        } else {
                            computeSizeFixed64List = CodedOutputStream.computeStringSize(numberAt, (String) object2);
                        }
                        i7 += computeSizeFixed64List;
                    }
                    z = r9;
                    break;
                case LockFreeTaskQueueCore.FROZEN_SHIFT /* 60 */:
                    if (isOneofPresent(message, numberAt, i6)) {
                        computeSizeFixed64List = SchemaUtil.computeSizeMessage(numberAt, unsafe.getObject(message, offset), getMessageFieldSchema(i6));
                        i7 += computeSizeFixed64List;
                    }
                    z = r9;
                    break;
                case LockFreeTaskQueueCore.CLOSED_SHIFT /* 61 */:
                    if (isOneofPresent(message, numberAt, i6)) {
                        computeSizeFixed64List = CodedOutputStream.computeBytesSize(numberAt, (ByteString) unsafe.getObject(message, offset));
                        i7 += computeSizeFixed64List;
                    }
                    z = r9;
                    break;
                case 62:
                    if (isOneofPresent(message, numberAt, i6)) {
                        computeSizeFixed64List = CodedOutputStream.computeUInt32Size(numberAt, oneofIntAt(message, offset));
                        i7 += computeSizeFixed64List;
                    }
                    z = r9;
                    break;
                case HtmlCompat.FROM_HTML_MODE_COMPACT /* 63 */:
                    if (isOneofPresent(message, numberAt, i6)) {
                        computeSizeFixed64List = CodedOutputStream.computeEnumSize(numberAt, oneofIntAt(message, offset));
                        i7 += computeSizeFixed64List;
                    }
                    z = r9;
                    break;
                case 64:
                    if (isOneofPresent(message, numberAt, i6)) {
                        computeSizeFixed64List = CodedOutputStream.computeSFixed32Size(numberAt, r9);
                        i7 += computeSizeFixed64List;
                    }
                    z = r9;
                    break;
                case 65:
                    if (isOneofPresent(message, numberAt, i6)) {
                        computeSizeFixed64List = CodedOutputStream.computeSFixed64Size(numberAt, 0L);
                        i7 += computeSizeFixed64List;
                    }
                    z = r9;
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT /* 66 */:
                    if (isOneofPresent(message, numberAt, i6)) {
                        computeSizeFixed64List = CodedOutputStream.computeSInt32Size(numberAt, oneofIntAt(message, offset));
                        i7 += computeSizeFixed64List;
                    }
                    z = r9;
                    break;
                case 67:
                    if (isOneofPresent(message, numberAt, i6)) {
                        computeSizeFixed64List = CodedOutputStream.computeSInt64Size(numberAt, oneofLongAt(message, offset));
                        i7 += computeSizeFixed64List;
                    }
                    z = r9;
                    break;
                case 68:
                    if (isOneofPresent(message, numberAt, i6)) {
                        computeSizeFixed64List = CodedOutputStream.computeGroupSize(numberAt, (MessageLite) unsafe.getObject(message, offset), getMessageFieldSchema(i6));
                        i7 += computeSizeFixed64List;
                    }
                    z = r9;
                    break;
                default:
                    z = r9;
                    break;
            }
            i6 += 3;
            i8 = i;
            r9 = z;
            i5 = i2;
            i4 = 1048575;
        }
        int unknownFieldsSerializedSize = i7 + getUnknownFieldsSerializedSize(this.unknownFieldSchema, message);
        return this.hasExtensions ? unknownFieldsSerializedSize + this.extensionSchema.getExtensions(message).getSerializedSize() : unknownFieldsSerializedSize;
    }

    private <UT, UB> int getUnknownFieldsSerializedSize(UnknownFieldSchema<UT, UB> schema, T message) {
        return schema.getSerializedSize(schema.getFromMessage(message));
    }

    @Override // androidx.datastore.preferences.protobuf.Schema
    public void writeTo(T message, Writer writer) throws IOException {
        if (writer.fieldOrder() == Writer.FieldOrder.DESCENDING) {
            writeFieldsInDescendingOrder(message, writer);
        } else {
            writeFieldsInAscendingOrder(message, writer);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:31:0x0094. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:221:0x0626  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0031  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void writeFieldsInAscendingOrder(T message, Writer writer) throws IOException {
        Map.Entry<?, ?> entry;
        Iterator<Map.Entry<?, Object>> it;
        int length;
        int i;
        int i2;
        Map.Entry<?, ?> entry2;
        int i3;
        int i4;
        Map.Entry<?, ?> entry3;
        boolean z;
        Map.Entry<?, ?> entry4;
        if (this.hasExtensions) {
            FieldSet<?> extensions = this.extensionSchema.getExtensions(message);
            if (!extensions.isEmpty()) {
                Iterator<Map.Entry<?, Object>> it2 = extensions.iterator();
                entry = (Map.Entry) it2.next();
                it = it2;
                length = this.buffer.length;
                Unsafe unsafe = UNSAFE;
                int i5 = 1048575;
                int i6 = 1048575;
                int i7 = 0;
                i = 0;
                while (i < length) {
                    int typeAndOffsetAt = typeAndOffsetAt(i);
                    int numberAt = numberAt(i);
                    int type = type(typeAndOffsetAt);
                    if (type <= 17) {
                        int i8 = this.buffer[i + 2];
                        int i9 = i8 & i5;
                        if (i9 != i6) {
                            if (i9 == i5) {
                                entry4 = entry;
                                i7 = 0;
                            } else {
                                entry4 = entry;
                                i7 = unsafe.getInt(message, i9);
                            }
                            i6 = i9;
                        } else {
                            entry4 = entry;
                        }
                        int i10 = 1 << (i8 >>> 20);
                        i2 = i6;
                        i3 = i10;
                        entry2 = entry4;
                    } else {
                        i2 = i6;
                        entry2 = entry;
                        i3 = 0;
                    }
                    int i11 = i7;
                    while (entry2 != null && this.extensionSchema.extensionNumber(entry2) <= numberAt) {
                        this.extensionSchema.serializeExtension(writer, entry2);
                        entry2 = it.hasNext() ? (Map.Entry) it.next() : null;
                    }
                    long offset = offset(typeAndOffsetAt);
                    switch (type) {
                        case 0:
                            i4 = length;
                            entry3 = entry2;
                            if (!isFieldPresent(message, i, i2, i11, i3)) {
                                break;
                            } else {
                                writer.writeDouble(numberAt, doubleAt(message, offset));
                                break;
                            }
                        case 1:
                            i4 = length;
                            entry3 = entry2;
                            if (!isFieldPresent(message, i, i2, i11, i3)) {
                                break;
                            } else {
                                writer.writeFloat(numberAt, floatAt(message, offset));
                                break;
                            }
                        case 2:
                            i4 = length;
                            entry3 = entry2;
                            if (!isFieldPresent(message, i, i2, i11, i3)) {
                                break;
                            } else {
                                writer.writeInt64(numberAt, unsafe.getLong(message, offset));
                                break;
                            }
                        case 3:
                            i4 = length;
                            entry3 = entry2;
                            if (!isFieldPresent(message, i, i2, i11, i3)) {
                                break;
                            } else {
                                writer.writeUInt64(numberAt, unsafe.getLong(message, offset));
                                break;
                            }
                        case 4:
                            i4 = length;
                            entry3 = entry2;
                            if (!isFieldPresent(message, i, i2, i11, i3)) {
                                break;
                            } else {
                                writer.writeInt32(numberAt, unsafe.getInt(message, offset));
                                break;
                            }
                        case 5:
                            i4 = length;
                            entry3 = entry2;
                            if (!isFieldPresent(message, i, i2, i11, i3)) {
                                break;
                            } else {
                                writer.writeFixed64(numberAt, unsafe.getLong(message, offset));
                                break;
                            }
                        case 6:
                            i4 = length;
                            entry3 = entry2;
                            if (!isFieldPresent(message, i, i2, i11, i3)) {
                                break;
                            } else {
                                writer.writeFixed32(numberAt, unsafe.getInt(message, offset));
                                break;
                            }
                        case 7:
                            i4 = length;
                            entry3 = entry2;
                            if (!isFieldPresent(message, i, i2, i11, i3)) {
                                break;
                            } else {
                                writer.writeBool(numberAt, booleanAt(message, offset));
                                break;
                            }
                        case 8:
                            i4 = length;
                            entry3 = entry2;
                            if (!isFieldPresent(message, i, i2, i11, i3)) {
                                break;
                            } else {
                                writeString(numberAt, unsafe.getObject(message, offset), writer);
                                break;
                            }
                        case 9:
                            i4 = length;
                            entry3 = entry2;
                            if (!isFieldPresent(message, i, i2, i11, i3)) {
                                break;
                            } else {
                                writer.writeMessage(numberAt, unsafe.getObject(message, offset), getMessageFieldSchema(i));
                                break;
                            }
                        case 10:
                            i4 = length;
                            entry3 = entry2;
                            if (!isFieldPresent(message, i, i2, i11, i3)) {
                                break;
                            } else {
                                writer.writeBytes(numberAt, (ByteString) unsafe.getObject(message, offset));
                                break;
                            }
                        case 11:
                            i4 = length;
                            entry3 = entry2;
                            if (!isFieldPresent(message, i, i2, i11, i3)) {
                                break;
                            } else {
                                writer.writeUInt32(numberAt, unsafe.getInt(message, offset));
                                break;
                            }
                        case 12:
                            i4 = length;
                            entry3 = entry2;
                            if (!isFieldPresent(message, i, i2, i11, i3)) {
                                break;
                            } else {
                                writer.writeEnum(numberAt, unsafe.getInt(message, offset));
                                break;
                            }
                        case 13:
                            i4 = length;
                            entry3 = entry2;
                            if (!isFieldPresent(message, i, i2, i11, i3)) {
                                break;
                            } else {
                                writer.writeSFixed32(numberAt, unsafe.getInt(message, offset));
                                break;
                            }
                        case 14:
                            i4 = length;
                            entry3 = entry2;
                            if (!isFieldPresent(message, i, i2, i11, i3)) {
                                break;
                            } else {
                                writer.writeSFixed64(numberAt, unsafe.getLong(message, offset));
                                break;
                            }
                        case 15:
                            i4 = length;
                            entry3 = entry2;
                            if (!isFieldPresent(message, i, i2, i11, i3)) {
                                break;
                            } else {
                                writer.writeSInt32(numberAt, unsafe.getInt(message, offset));
                                break;
                            }
                        case 16:
                            i4 = length;
                            entry3 = entry2;
                            if (!isFieldPresent(message, i, i2, i11, i3)) {
                                break;
                            } else {
                                writer.writeSInt64(numberAt, unsafe.getLong(message, offset));
                                break;
                            }
                        case 17:
                            entry3 = entry2;
                            i4 = length;
                            if (!isFieldPresent(message, i, i2, i11, i3)) {
                                break;
                            } else {
                                writer.writeGroup(numberAt, unsafe.getObject(message, offset), getMessageFieldSchema(i));
                                break;
                            }
                        case 18:
                            z = false;
                            SchemaUtil.writeDoubleList(numberAt(i), (List) unsafe.getObject(message, offset), writer, false);
                            i4 = length;
                            entry3 = entry2;
                            break;
                        case 19:
                            z = false;
                            SchemaUtil.writeFloatList(numberAt(i), (List) unsafe.getObject(message, offset), writer, false);
                            i4 = length;
                            entry3 = entry2;
                            break;
                        case 20:
                            z = false;
                            SchemaUtil.writeInt64List(numberAt(i), (List) unsafe.getObject(message, offset), writer, false);
                            i4 = length;
                            entry3 = entry2;
                            break;
                        case 21:
                            z = false;
                            SchemaUtil.writeUInt64List(numberAt(i), (List) unsafe.getObject(message, offset), writer, false);
                            i4 = length;
                            entry3 = entry2;
                            break;
                        case 22:
                            z = false;
                            SchemaUtil.writeInt32List(numberAt(i), (List) unsafe.getObject(message, offset), writer, false);
                            i4 = length;
                            entry3 = entry2;
                            break;
                        case 23:
                            z = false;
                            SchemaUtil.writeFixed64List(numberAt(i), (List) unsafe.getObject(message, offset), writer, false);
                            i4 = length;
                            entry3 = entry2;
                            break;
                        case 24:
                            z = false;
                            SchemaUtil.writeFixed32List(numberAt(i), (List) unsafe.getObject(message, offset), writer, false);
                            i4 = length;
                            entry3 = entry2;
                            break;
                        case 25:
                            z = false;
                            SchemaUtil.writeBoolList(numberAt(i), (List) unsafe.getObject(message, offset), writer, false);
                            i4 = length;
                            entry3 = entry2;
                            break;
                        case 26:
                            SchemaUtil.writeStringList(numberAt(i), (List) unsafe.getObject(message, offset), writer);
                            i4 = length;
                            entry3 = entry2;
                            break;
                        case 27:
                            SchemaUtil.writeMessageList(numberAt(i), (List) unsafe.getObject(message, offset), writer, getMessageFieldSchema(i));
                            i4 = length;
                            entry3 = entry2;
                            break;
                        case 28:
                            SchemaUtil.writeBytesList(numberAt(i), (List) unsafe.getObject(message, offset), writer);
                            i4 = length;
                            entry3 = entry2;
                            break;
                        case 29:
                            z = false;
                            SchemaUtil.writeUInt32List(numberAt(i), (List) unsafe.getObject(message, offset), writer, false);
                            i4 = length;
                            entry3 = entry2;
                            break;
                        case 30:
                            z = false;
                            SchemaUtil.writeEnumList(numberAt(i), (List) unsafe.getObject(message, offset), writer, false);
                            i4 = length;
                            entry3 = entry2;
                            break;
                        case 31:
                            z = false;
                            SchemaUtil.writeSFixed32List(numberAt(i), (List) unsafe.getObject(message, offset), writer, false);
                            i4 = length;
                            entry3 = entry2;
                            break;
                        case 32:
                            z = false;
                            SchemaUtil.writeSFixed64List(numberAt(i), (List) unsafe.getObject(message, offset), writer, false);
                            i4 = length;
                            entry3 = entry2;
                            break;
                        case 33:
                            z = false;
                            SchemaUtil.writeSInt32List(numberAt(i), (List) unsafe.getObject(message, offset), writer, false);
                            i4 = length;
                            entry3 = entry2;
                            break;
                        case 34:
                            z = false;
                            SchemaUtil.writeSInt64List(numberAt(i), (List) unsafe.getObject(message, offset), writer, false);
                            i4 = length;
                            entry3 = entry2;
                            break;
                        case 35:
                            SchemaUtil.writeDoubleList(numberAt(i), (List) unsafe.getObject(message, offset), writer, true);
                            i4 = length;
                            entry3 = entry2;
                            break;
                        case 36:
                            SchemaUtil.writeFloatList(numberAt(i), (List) unsafe.getObject(message, offset), writer, true);
                            i4 = length;
                            entry3 = entry2;
                            break;
                        case 37:
                            SchemaUtil.writeInt64List(numberAt(i), (List) unsafe.getObject(message, offset), writer, true);
                            i4 = length;
                            entry3 = entry2;
                            break;
                        case 38:
                            SchemaUtil.writeUInt64List(numberAt(i), (List) unsafe.getObject(message, offset), writer, true);
                            i4 = length;
                            entry3 = entry2;
                            break;
                        case 39:
                            SchemaUtil.writeInt32List(numberAt(i), (List) unsafe.getObject(message, offset), writer, true);
                            i4 = length;
                            entry3 = entry2;
                            break;
                        case 40:
                            SchemaUtil.writeFixed64List(numberAt(i), (List) unsafe.getObject(message, offset), writer, true);
                            i4 = length;
                            entry3 = entry2;
                            break;
                        case 41:
                            SchemaUtil.writeFixed32List(numberAt(i), (List) unsafe.getObject(message, offset), writer, true);
                            i4 = length;
                            entry3 = entry2;
                            break;
                        case 42:
                            SchemaUtil.writeBoolList(numberAt(i), (List) unsafe.getObject(message, offset), writer, true);
                            i4 = length;
                            entry3 = entry2;
                            break;
                        case 43:
                            SchemaUtil.writeUInt32List(numberAt(i), (List) unsafe.getObject(message, offset), writer, true);
                            i4 = length;
                            entry3 = entry2;
                            break;
                        case 44:
                            SchemaUtil.writeEnumList(numberAt(i), (List) unsafe.getObject(message, offset), writer, true);
                            i4 = length;
                            entry3 = entry2;
                            break;
                        case 45:
                            SchemaUtil.writeSFixed32List(numberAt(i), (List) unsafe.getObject(message, offset), writer, true);
                            i4 = length;
                            entry3 = entry2;
                            break;
                        case 46:
                            SchemaUtil.writeSFixed64List(numberAt(i), (List) unsafe.getObject(message, offset), writer, true);
                            i4 = length;
                            entry3 = entry2;
                            break;
                        case 47:
                            SchemaUtil.writeSInt32List(numberAt(i), (List) unsafe.getObject(message, offset), writer, true);
                            i4 = length;
                            entry3 = entry2;
                            break;
                        case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE /* 48 */:
                            SchemaUtil.writeSInt64List(numberAt(i), (List) unsafe.getObject(message, offset), writer, true);
                            i4 = length;
                            entry3 = entry2;
                            break;
                        case ConstraintLayout.LayoutParams.Table.LAYOUT_EDITOR_ABSOLUTEX /* 49 */:
                            SchemaUtil.writeGroupList(numberAt(i), (List) unsafe.getObject(message, offset), writer, getMessageFieldSchema(i));
                            i4 = length;
                            entry3 = entry2;
                            break;
                        case 50:
                            writeMapHelper(writer, numberAt, unsafe.getObject(message, offset), i);
                            i4 = length;
                            entry3 = entry2;
                            break;
                        case 51:
                            if (isOneofPresent(message, numberAt, i)) {
                                writer.writeDouble(numberAt, oneofDoubleAt(message, offset));
                            }
                            i4 = length;
                            entry3 = entry2;
                            break;
                        case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_TOP_OF /* 52 */:
                            if (isOneofPresent(message, numberAt, i)) {
                                writer.writeFloat(numberAt, oneofFloatAt(message, offset));
                            }
                            i4 = length;
                            entry3 = entry2;
                            break;
                        case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_BOTTOM_OF /* 53 */:
                            if (isOneofPresent(message, numberAt, i)) {
                                writer.writeInt64(numberAt, oneofLongAt(message, offset));
                            }
                            i4 = length;
                            entry3 = entry2;
                            break;
                        case ConstraintLayout.LayoutParams.Table.LAYOUT_MARGIN_BASELINE /* 54 */:
                            if (isOneofPresent(message, numberAt, i)) {
                                writer.writeUInt64(numberAt, oneofLongAt(message, offset));
                            }
                            i4 = length;
                            entry3 = entry2;
                            break;
                        case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE /* 55 */:
                            if (isOneofPresent(message, numberAt, i)) {
                                writer.writeInt32(numberAt, oneofIntAt(message, offset));
                            }
                            i4 = length;
                            entry3 = entry2;
                            break;
                        case 56:
                            if (isOneofPresent(message, numberAt, i)) {
                                writer.writeFixed64(numberAt, oneofLongAt(message, offset));
                            }
                            i4 = length;
                            entry3 = entry2;
                            break;
                        case 57:
                            if (isOneofPresent(message, numberAt, i)) {
                                writer.writeFixed32(numberAt, oneofIntAt(message, offset));
                            }
                            i4 = length;
                            entry3 = entry2;
                            break;
                        case 58:
                            if (isOneofPresent(message, numberAt, i)) {
                                writer.writeBool(numberAt, oneofBooleanAt(message, offset));
                            }
                            i4 = length;
                            entry3 = entry2;
                            break;
                        case 59:
                            if (isOneofPresent(message, numberAt, i)) {
                                writeString(numberAt, unsafe.getObject(message, offset), writer);
                            }
                            i4 = length;
                            entry3 = entry2;
                            break;
                        case LockFreeTaskQueueCore.FROZEN_SHIFT /* 60 */:
                            if (isOneofPresent(message, numberAt, i)) {
                                writer.writeMessage(numberAt, unsafe.getObject(message, offset), getMessageFieldSchema(i));
                            }
                            i4 = length;
                            entry3 = entry2;
                            break;
                        case LockFreeTaskQueueCore.CLOSED_SHIFT /* 61 */:
                            if (isOneofPresent(message, numberAt, i)) {
                                writer.writeBytes(numberAt, (ByteString) unsafe.getObject(message, offset));
                            }
                            i4 = length;
                            entry3 = entry2;
                            break;
                        case 62:
                            if (isOneofPresent(message, numberAt, i)) {
                                writer.writeUInt32(numberAt, oneofIntAt(message, offset));
                            }
                            i4 = length;
                            entry3 = entry2;
                            break;
                        case HtmlCompat.FROM_HTML_MODE_COMPACT /* 63 */:
                            if (isOneofPresent(message, numberAt, i)) {
                                writer.writeEnum(numberAt, oneofIntAt(message, offset));
                            }
                            i4 = length;
                            entry3 = entry2;
                            break;
                        case 64:
                            if (isOneofPresent(message, numberAt, i)) {
                                writer.writeSFixed32(numberAt, oneofIntAt(message, offset));
                            }
                            i4 = length;
                            entry3 = entry2;
                            break;
                        case 65:
                            if (isOneofPresent(message, numberAt, i)) {
                                writer.writeSFixed64(numberAt, oneofLongAt(message, offset));
                            }
                            i4 = length;
                            entry3 = entry2;
                            break;
                        case ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT /* 66 */:
                            if (isOneofPresent(message, numberAt, i)) {
                                writer.writeSInt32(numberAt, oneofIntAt(message, offset));
                            }
                            i4 = length;
                            entry3 = entry2;
                            break;
                        case 67:
                            if (isOneofPresent(message, numberAt, i)) {
                                writer.writeSInt64(numberAt, oneofLongAt(message, offset));
                            }
                            i4 = length;
                            entry3 = entry2;
                            break;
                        case 68:
                            if (isOneofPresent(message, numberAt, i)) {
                                writer.writeGroup(numberAt, unsafe.getObject(message, offset), getMessageFieldSchema(i));
                            }
                            i4 = length;
                            entry3 = entry2;
                            break;
                        default:
                            i4 = length;
                            entry3 = entry2;
                            break;
                    }
                    i += 3;
                    i6 = i2;
                    entry = entry3;
                    i7 = i11;
                    length = i4;
                    i5 = 1048575;
                }
                while (entry != null) {
                    this.extensionSchema.serializeExtension(writer, entry);
                    entry = it.hasNext() ? (Map.Entry) it.next() : null;
                }
                writeUnknownInMessageTo(this.unknownFieldSchema, message, writer);
            }
        }
        entry = null;
        it = null;
        length = this.buffer.length;
        Unsafe unsafe2 = UNSAFE;
        int i52 = 1048575;
        int i62 = 1048575;
        int i72 = 0;
        i = 0;
        while (i < length) {
        }
        while (entry != null) {
        }
        writeUnknownInMessageTo(this.unknownFieldSchema, message, writer);
    }

    /* JADX WARN: Removed duplicated region for block: B:275:0x058e  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void writeFieldsInDescendingOrder(T message, Writer writer) throws IOException {
        Iterator<Map.Entry<?, Object>> it;
        Map.Entry<?, ?> entry;
        int length;
        writeUnknownInMessageTo(this.unknownFieldSchema, message, writer);
        if (this.hasExtensions) {
            FieldSet<?> extensions = this.extensionSchema.getExtensions(message);
            if (!extensions.isEmpty()) {
                it = extensions.descendingIterator();
                entry = (Map.Entry) it.next();
                for (length = this.buffer.length - 3; length >= 0; length -= 3) {
                    int typeAndOffsetAt = typeAndOffsetAt(length);
                    int numberAt = numberAt(length);
                    while (entry != null && this.extensionSchema.extensionNumber(entry) > numberAt) {
                        this.extensionSchema.serializeExtension(writer, entry);
                        entry = it.hasNext() ? (Map.Entry) it.next() : null;
                    }
                    switch (type(typeAndOffsetAt)) {
                        case 0:
                            if (isFieldPresent(message, length)) {
                                writer.writeDouble(numberAt, doubleAt(message, offset(typeAndOffsetAt)));
                                break;
                            } else {
                                break;
                            }
                        case 1:
                            if (isFieldPresent(message, length)) {
                                writer.writeFloat(numberAt, floatAt(message, offset(typeAndOffsetAt)));
                                break;
                            } else {
                                break;
                            }
                        case 2:
                            if (isFieldPresent(message, length)) {
                                writer.writeInt64(numberAt, longAt(message, offset(typeAndOffsetAt)));
                                break;
                            } else {
                                break;
                            }
                        case 3:
                            if (isFieldPresent(message, length)) {
                                writer.writeUInt64(numberAt, longAt(message, offset(typeAndOffsetAt)));
                                break;
                            } else {
                                break;
                            }
                        case 4:
                            if (isFieldPresent(message, length)) {
                                writer.writeInt32(numberAt, intAt(message, offset(typeAndOffsetAt)));
                                break;
                            } else {
                                break;
                            }
                        case 5:
                            if (isFieldPresent(message, length)) {
                                writer.writeFixed64(numberAt, longAt(message, offset(typeAndOffsetAt)));
                                break;
                            } else {
                                break;
                            }
                        case 6:
                            if (isFieldPresent(message, length)) {
                                writer.writeFixed32(numberAt, intAt(message, offset(typeAndOffsetAt)));
                                break;
                            } else {
                                break;
                            }
                        case 7:
                            if (isFieldPresent(message, length)) {
                                writer.writeBool(numberAt, booleanAt(message, offset(typeAndOffsetAt)));
                                break;
                            } else {
                                break;
                            }
                        case 8:
                            if (isFieldPresent(message, length)) {
                                writeString(numberAt, UnsafeUtil.getObject(message, offset(typeAndOffsetAt)), writer);
                                break;
                            } else {
                                break;
                            }
                        case 9:
                            if (isFieldPresent(message, length)) {
                                writer.writeMessage(numberAt, UnsafeUtil.getObject(message, offset(typeAndOffsetAt)), getMessageFieldSchema(length));
                                break;
                            } else {
                                break;
                            }
                        case 10:
                            if (isFieldPresent(message, length)) {
                                writer.writeBytes(numberAt, (ByteString) UnsafeUtil.getObject(message, offset(typeAndOffsetAt)));
                                break;
                            } else {
                                break;
                            }
                        case 11:
                            if (isFieldPresent(message, length)) {
                                writer.writeUInt32(numberAt, intAt(message, offset(typeAndOffsetAt)));
                                break;
                            } else {
                                break;
                            }
                        case 12:
                            if (isFieldPresent(message, length)) {
                                writer.writeEnum(numberAt, intAt(message, offset(typeAndOffsetAt)));
                                break;
                            } else {
                                break;
                            }
                        case 13:
                            if (isFieldPresent(message, length)) {
                                writer.writeSFixed32(numberAt, intAt(message, offset(typeAndOffsetAt)));
                                break;
                            } else {
                                break;
                            }
                        case 14:
                            if (isFieldPresent(message, length)) {
                                writer.writeSFixed64(numberAt, longAt(message, offset(typeAndOffsetAt)));
                                break;
                            } else {
                                break;
                            }
                        case 15:
                            if (isFieldPresent(message, length)) {
                                writer.writeSInt32(numberAt, intAt(message, offset(typeAndOffsetAt)));
                                break;
                            } else {
                                break;
                            }
                        case 16:
                            if (isFieldPresent(message, length)) {
                                writer.writeSInt64(numberAt, longAt(message, offset(typeAndOffsetAt)));
                                break;
                            } else {
                                break;
                            }
                        case 17:
                            if (isFieldPresent(message, length)) {
                                writer.writeGroup(numberAt, UnsafeUtil.getObject(message, offset(typeAndOffsetAt)), getMessageFieldSchema(length));
                                break;
                            } else {
                                break;
                            }
                        case 18:
                            SchemaUtil.writeDoubleList(numberAt(length), (List) UnsafeUtil.getObject(message, offset(typeAndOffsetAt)), writer, false);
                            break;
                        case 19:
                            SchemaUtil.writeFloatList(numberAt(length), (List) UnsafeUtil.getObject(message, offset(typeAndOffsetAt)), writer, false);
                            break;
                        case 20:
                            SchemaUtil.writeInt64List(numberAt(length), (List) UnsafeUtil.getObject(message, offset(typeAndOffsetAt)), writer, false);
                            break;
                        case 21:
                            SchemaUtil.writeUInt64List(numberAt(length), (List) UnsafeUtil.getObject(message, offset(typeAndOffsetAt)), writer, false);
                            break;
                        case 22:
                            SchemaUtil.writeInt32List(numberAt(length), (List) UnsafeUtil.getObject(message, offset(typeAndOffsetAt)), writer, false);
                            break;
                        case 23:
                            SchemaUtil.writeFixed64List(numberAt(length), (List) UnsafeUtil.getObject(message, offset(typeAndOffsetAt)), writer, false);
                            break;
                        case 24:
                            SchemaUtil.writeFixed32List(numberAt(length), (List) UnsafeUtil.getObject(message, offset(typeAndOffsetAt)), writer, false);
                            break;
                        case 25:
                            SchemaUtil.writeBoolList(numberAt(length), (List) UnsafeUtil.getObject(message, offset(typeAndOffsetAt)), writer, false);
                            break;
                        case 26:
                            SchemaUtil.writeStringList(numberAt(length), (List) UnsafeUtil.getObject(message, offset(typeAndOffsetAt)), writer);
                            break;
                        case 27:
                            SchemaUtil.writeMessageList(numberAt(length), (List) UnsafeUtil.getObject(message, offset(typeAndOffsetAt)), writer, getMessageFieldSchema(length));
                            break;
                        case 28:
                            SchemaUtil.writeBytesList(numberAt(length), (List) UnsafeUtil.getObject(message, offset(typeAndOffsetAt)), writer);
                            break;
                        case 29:
                            SchemaUtil.writeUInt32List(numberAt(length), (List) UnsafeUtil.getObject(message, offset(typeAndOffsetAt)), writer, false);
                            break;
                        case 30:
                            SchemaUtil.writeEnumList(numberAt(length), (List) UnsafeUtil.getObject(message, offset(typeAndOffsetAt)), writer, false);
                            break;
                        case 31:
                            SchemaUtil.writeSFixed32List(numberAt(length), (List) UnsafeUtil.getObject(message, offset(typeAndOffsetAt)), writer, false);
                            break;
                        case 32:
                            SchemaUtil.writeSFixed64List(numberAt(length), (List) UnsafeUtil.getObject(message, offset(typeAndOffsetAt)), writer, false);
                            break;
                        case 33:
                            SchemaUtil.writeSInt32List(numberAt(length), (List) UnsafeUtil.getObject(message, offset(typeAndOffsetAt)), writer, false);
                            break;
                        case 34:
                            SchemaUtil.writeSInt64List(numberAt(length), (List) UnsafeUtil.getObject(message, offset(typeAndOffsetAt)), writer, false);
                            break;
                        case 35:
                            SchemaUtil.writeDoubleList(numberAt(length), (List) UnsafeUtil.getObject(message, offset(typeAndOffsetAt)), writer, true);
                            break;
                        case 36:
                            SchemaUtil.writeFloatList(numberAt(length), (List) UnsafeUtil.getObject(message, offset(typeAndOffsetAt)), writer, true);
                            break;
                        case 37:
                            SchemaUtil.writeInt64List(numberAt(length), (List) UnsafeUtil.getObject(message, offset(typeAndOffsetAt)), writer, true);
                            break;
                        case 38:
                            SchemaUtil.writeUInt64List(numberAt(length), (List) UnsafeUtil.getObject(message, offset(typeAndOffsetAt)), writer, true);
                            break;
                        case 39:
                            SchemaUtil.writeInt32List(numberAt(length), (List) UnsafeUtil.getObject(message, offset(typeAndOffsetAt)), writer, true);
                            break;
                        case 40:
                            SchemaUtil.writeFixed64List(numberAt(length), (List) UnsafeUtil.getObject(message, offset(typeAndOffsetAt)), writer, true);
                            break;
                        case 41:
                            SchemaUtil.writeFixed32List(numberAt(length), (List) UnsafeUtil.getObject(message, offset(typeAndOffsetAt)), writer, true);
                            break;
                        case 42:
                            SchemaUtil.writeBoolList(numberAt(length), (List) UnsafeUtil.getObject(message, offset(typeAndOffsetAt)), writer, true);
                            break;
                        case 43:
                            SchemaUtil.writeUInt32List(numberAt(length), (List) UnsafeUtil.getObject(message, offset(typeAndOffsetAt)), writer, true);
                            break;
                        case 44:
                            SchemaUtil.writeEnumList(numberAt(length), (List) UnsafeUtil.getObject(message, offset(typeAndOffsetAt)), writer, true);
                            break;
                        case 45:
                            SchemaUtil.writeSFixed32List(numberAt(length), (List) UnsafeUtil.getObject(message, offset(typeAndOffsetAt)), writer, true);
                            break;
                        case 46:
                            SchemaUtil.writeSFixed64List(numberAt(length), (List) UnsafeUtil.getObject(message, offset(typeAndOffsetAt)), writer, true);
                            break;
                        case 47:
                            SchemaUtil.writeSInt32List(numberAt(length), (List) UnsafeUtil.getObject(message, offset(typeAndOffsetAt)), writer, true);
                            break;
                        case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE /* 48 */:
                            SchemaUtil.writeSInt64List(numberAt(length), (List) UnsafeUtil.getObject(message, offset(typeAndOffsetAt)), writer, true);
                            break;
                        case ConstraintLayout.LayoutParams.Table.LAYOUT_EDITOR_ABSOLUTEX /* 49 */:
                            SchemaUtil.writeGroupList(numberAt(length), (List) UnsafeUtil.getObject(message, offset(typeAndOffsetAt)), writer, getMessageFieldSchema(length));
                            break;
                        case 50:
                            writeMapHelper(writer, numberAt, UnsafeUtil.getObject(message, offset(typeAndOffsetAt)), length);
                            break;
                        case 51:
                            if (isOneofPresent(message, numberAt, length)) {
                                writer.writeDouble(numberAt, oneofDoubleAt(message, offset(typeAndOffsetAt)));
                                break;
                            } else {
                                break;
                            }
                        case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_TOP_OF /* 52 */:
                            if (isOneofPresent(message, numberAt, length)) {
                                writer.writeFloat(numberAt, oneofFloatAt(message, offset(typeAndOffsetAt)));
                                break;
                            } else {
                                break;
                            }
                        case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_BOTTOM_OF /* 53 */:
                            if (isOneofPresent(message, numberAt, length)) {
                                writer.writeInt64(numberAt, oneofLongAt(message, offset(typeAndOffsetAt)));
                                break;
                            } else {
                                break;
                            }
                        case ConstraintLayout.LayoutParams.Table.LAYOUT_MARGIN_BASELINE /* 54 */:
                            if (isOneofPresent(message, numberAt, length)) {
                                writer.writeUInt64(numberAt, oneofLongAt(message, offset(typeAndOffsetAt)));
                                break;
                            } else {
                                break;
                            }
                        case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE /* 55 */:
                            if (isOneofPresent(message, numberAt, length)) {
                                writer.writeInt32(numberAt, oneofIntAt(message, offset(typeAndOffsetAt)));
                                break;
                            } else {
                                break;
                            }
                        case 56:
                            if (isOneofPresent(message, numberAt, length)) {
                                writer.writeFixed64(numberAt, oneofLongAt(message, offset(typeAndOffsetAt)));
                                break;
                            } else {
                                break;
                            }
                        case 57:
                            if (isOneofPresent(message, numberAt, length)) {
                                writer.writeFixed32(numberAt, oneofIntAt(message, offset(typeAndOffsetAt)));
                                break;
                            } else {
                                break;
                            }
                        case 58:
                            if (isOneofPresent(message, numberAt, length)) {
                                writer.writeBool(numberAt, oneofBooleanAt(message, offset(typeAndOffsetAt)));
                                break;
                            } else {
                                break;
                            }
                        case 59:
                            if (isOneofPresent(message, numberAt, length)) {
                                writeString(numberAt, UnsafeUtil.getObject(message, offset(typeAndOffsetAt)), writer);
                                break;
                            } else {
                                break;
                            }
                        case LockFreeTaskQueueCore.FROZEN_SHIFT /* 60 */:
                            if (isOneofPresent(message, numberAt, length)) {
                                writer.writeMessage(numberAt, UnsafeUtil.getObject(message, offset(typeAndOffsetAt)), getMessageFieldSchema(length));
                                break;
                            } else {
                                break;
                            }
                        case LockFreeTaskQueueCore.CLOSED_SHIFT /* 61 */:
                            if (isOneofPresent(message, numberAt, length)) {
                                writer.writeBytes(numberAt, (ByteString) UnsafeUtil.getObject(message, offset(typeAndOffsetAt)));
                                break;
                            } else {
                                break;
                            }
                        case 62:
                            if (isOneofPresent(message, numberAt, length)) {
                                writer.writeUInt32(numberAt, oneofIntAt(message, offset(typeAndOffsetAt)));
                                break;
                            } else {
                                break;
                            }
                        case HtmlCompat.FROM_HTML_MODE_COMPACT /* 63 */:
                            if (isOneofPresent(message, numberAt, length)) {
                                writer.writeEnum(numberAt, oneofIntAt(message, offset(typeAndOffsetAt)));
                                break;
                            } else {
                                break;
                            }
                        case 64:
                            if (isOneofPresent(message, numberAt, length)) {
                                writer.writeSFixed32(numberAt, oneofIntAt(message, offset(typeAndOffsetAt)));
                                break;
                            } else {
                                break;
                            }
                        case 65:
                            if (isOneofPresent(message, numberAt, length)) {
                                writer.writeSFixed64(numberAt, oneofLongAt(message, offset(typeAndOffsetAt)));
                                break;
                            } else {
                                break;
                            }
                        case ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT /* 66 */:
                            if (isOneofPresent(message, numberAt, length)) {
                                writer.writeSInt32(numberAt, oneofIntAt(message, offset(typeAndOffsetAt)));
                                break;
                            } else {
                                break;
                            }
                        case 67:
                            if (isOneofPresent(message, numberAt, length)) {
                                writer.writeSInt64(numberAt, oneofLongAt(message, offset(typeAndOffsetAt)));
                                break;
                            } else {
                                break;
                            }
                        case 68:
                            if (isOneofPresent(message, numberAt, length)) {
                                writer.writeGroup(numberAt, UnsafeUtil.getObject(message, offset(typeAndOffsetAt)), getMessageFieldSchema(length));
                                break;
                            } else {
                                break;
                            }
                    }
                }
                while (entry != null) {
                    this.extensionSchema.serializeExtension(writer, entry);
                    entry = it.hasNext() ? (Map.Entry) it.next() : null;
                }
            }
        }
        it = null;
        entry = null;
        while (length >= 0) {
        }
        while (entry != null) {
        }
    }

    private <K, V> void writeMapHelper(Writer writer, int number, Object mapField, int pos) throws IOException {
        if (mapField != null) {
            writer.writeMap(number, this.mapFieldSchema.forMapMetadata(getMapFieldDefaultEntry(pos)), this.mapFieldSchema.forMapData(mapField));
        }
    }

    private <UT, UB> void writeUnknownInMessageTo(UnknownFieldSchema<UT, UB> schema, T message, Writer writer) throws IOException {
        schema.writeTo(schema.getFromMessage(message), writer);
    }

    @Override // androidx.datastore.preferences.protobuf.Schema
    public void mergeFrom(T message, Reader reader, ExtensionRegistryLite extensionRegistry) throws IOException {
        extensionRegistry.getClass();
        checkMutable(message);
        mergeFromHelper(this.unknownFieldSchema, this.extensionSchema, message, reader, extensionRegistry);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:12:0x00bf. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0642 A[Catch: all -> 0x069a, TRY_LEAVE, TryCatch #9 {all -> 0x069a, blocks: (B:17:0x0613, B:35:0x063c, B:37:0x0642, B:50:0x066a, B:51:0x066f), top: B:16:0x0613 }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0668  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x06ab A[LOOP:4: B:65:0x06a7->B:67:0x06ab, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x06c0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private <UT, UB, ET extends FieldSet.FieldDescriptorLite<ET>> void mergeFromHelper(UnknownFieldSchema<UT, UB> unknownFieldSchema, ExtensionSchema<ET> extensionSchema, T message, Reader reader, ExtensionRegistryLite extensionRegistry) throws IOException {
        T t;
        UnknownFieldSchema unknownFieldSchema2;
        int i;
        Object obj;
        T t2;
        ExtensionRegistryLite extensionRegistryLite;
        Object obj2;
        UnknownFieldSchema unknownFieldSchema3 = unknownFieldSchema;
        T t3 = message;
        ExtensionRegistryLite extensionRegistryLite2 = extensionRegistry;
        Object obj3 = null;
        FieldSet<ET> fieldSet = null;
        while (true) {
            try {
                int fieldNumber = reader.getFieldNumber();
                int positionForFieldNumber = positionForFieldNumber(fieldNumber);
                if (positionForFieldNumber >= 0) {
                    t = t3;
                    try {
                        int typeAndOffsetAt = typeAndOffsetAt(positionForFieldNumber);
                        switch (type(typeAndOffsetAt)) {
                            case 0:
                                obj2 = obj3;
                                extensionRegistryLite = extensionRegistryLite2;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                UnsafeUtil.putDouble(t, offset(typeAndOffsetAt), reader.readDouble());
                                setFieldPresent(t, positionForFieldNumber);
                                obj3 = obj2;
                                extensionRegistryLite2 = extensionRegistryLite;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                t3 = t;
                                break;
                            case 1:
                                obj2 = obj3;
                                extensionRegistryLite = extensionRegistryLite2;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                UnsafeUtil.putFloat(t, offset(typeAndOffsetAt), reader.readFloat());
                                setFieldPresent(t, positionForFieldNumber);
                                obj3 = obj2;
                                extensionRegistryLite2 = extensionRegistryLite;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                t3 = t;
                                break;
                            case 2:
                                obj2 = obj3;
                                extensionRegistryLite = extensionRegistryLite2;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                UnsafeUtil.putLong(t, offset(typeAndOffsetAt), reader.readInt64());
                                setFieldPresent(t, positionForFieldNumber);
                                obj3 = obj2;
                                extensionRegistryLite2 = extensionRegistryLite;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                t3 = t;
                                break;
                            case 3:
                                obj2 = obj3;
                                extensionRegistryLite = extensionRegistryLite2;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                UnsafeUtil.putLong(t, offset(typeAndOffsetAt), reader.readUInt64());
                                setFieldPresent(t, positionForFieldNumber);
                                obj3 = obj2;
                                extensionRegistryLite2 = extensionRegistryLite;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                t3 = t;
                                break;
                            case 4:
                                obj2 = obj3;
                                extensionRegistryLite = extensionRegistryLite2;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                UnsafeUtil.putInt(t, offset(typeAndOffsetAt), reader.readInt32());
                                setFieldPresent(t, positionForFieldNumber);
                                obj3 = obj2;
                                extensionRegistryLite2 = extensionRegistryLite;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                t3 = t;
                                break;
                            case 5:
                                obj2 = obj3;
                                extensionRegistryLite = extensionRegistryLite2;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                UnsafeUtil.putLong(t, offset(typeAndOffsetAt), reader.readFixed64());
                                setFieldPresent(t, positionForFieldNumber);
                                obj3 = obj2;
                                extensionRegistryLite2 = extensionRegistryLite;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                t3 = t;
                                break;
                            case 6:
                                obj2 = obj3;
                                extensionRegistryLite = extensionRegistryLite2;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                UnsafeUtil.putInt(t, offset(typeAndOffsetAt), reader.readFixed32());
                                setFieldPresent(t, positionForFieldNumber);
                                obj3 = obj2;
                                extensionRegistryLite2 = extensionRegistryLite;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                t3 = t;
                                break;
                            case 7:
                                obj2 = obj3;
                                extensionRegistryLite = extensionRegistryLite2;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                UnsafeUtil.putBoolean(t, offset(typeAndOffsetAt), reader.readBool());
                                setFieldPresent(t, positionForFieldNumber);
                                obj3 = obj2;
                                extensionRegistryLite2 = extensionRegistryLite;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                t3 = t;
                                break;
                            case 8:
                                obj2 = obj3;
                                extensionRegistryLite = extensionRegistryLite2;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                readString(t, typeAndOffsetAt, reader);
                                setFieldPresent(t, positionForFieldNumber);
                                obj3 = obj2;
                                extensionRegistryLite2 = extensionRegistryLite;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                t3 = t;
                                break;
                            case 9:
                                obj2 = obj3;
                                extensionRegistryLite = extensionRegistryLite2;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                MessageLite messageLite = (MessageLite) mutableMessageFieldForMerge(t, positionForFieldNumber);
                                reader.mergeMessageField(messageLite, getMessageFieldSchema(positionForFieldNumber), extensionRegistryLite);
                                storeMessageField(t, positionForFieldNumber, messageLite);
                                obj3 = obj2;
                                extensionRegistryLite2 = extensionRegistryLite;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                t3 = t;
                                break;
                            case 10:
                                obj2 = obj3;
                                extensionRegistryLite = extensionRegistryLite2;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                UnsafeUtil.putObject(t, offset(typeAndOffsetAt), reader.readBytes());
                                setFieldPresent(t, positionForFieldNumber);
                                obj3 = obj2;
                                extensionRegistryLite2 = extensionRegistryLite;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                t3 = t;
                                break;
                            case 11:
                                obj2 = obj3;
                                extensionRegistryLite = extensionRegistryLite2;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                UnsafeUtil.putInt(t, offset(typeAndOffsetAt), reader.readUInt32());
                                setFieldPresent(t, positionForFieldNumber);
                                obj3 = obj2;
                                extensionRegistryLite2 = extensionRegistryLite;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                t3 = t;
                                break;
                            case 12:
                                obj2 = obj3;
                                extensionRegistryLite = extensionRegistryLite2;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                int readEnum = reader.readEnum();
                                Internal.EnumVerifier enumFieldVerifier = getEnumFieldVerifier(positionForFieldNumber);
                                if (enumFieldVerifier != null && !enumFieldVerifier.isInRange(readEnum)) {
                                    obj3 = SchemaUtil.storeUnknownEnum(t, fieldNumber, readEnum, obj2, unknownFieldSchema2);
                                    extensionRegistryLite2 = extensionRegistryLite;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    t3 = t;
                                    break;
                                }
                                UnsafeUtil.putInt(t, offset(typeAndOffsetAt), readEnum);
                                setFieldPresent(t, positionForFieldNumber);
                                obj3 = obj2;
                                extensionRegistryLite2 = extensionRegistryLite;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                t3 = t;
                                break;
                            case 13:
                                obj2 = obj3;
                                extensionRegistryLite = extensionRegistryLite2;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                UnsafeUtil.putInt(t, offset(typeAndOffsetAt), reader.readSFixed32());
                                setFieldPresent(t, positionForFieldNumber);
                                obj3 = obj2;
                                extensionRegistryLite2 = extensionRegistryLite;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                t3 = t;
                                break;
                            case 14:
                                obj2 = obj3;
                                extensionRegistryLite = extensionRegistryLite2;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                UnsafeUtil.putLong(t, offset(typeAndOffsetAt), reader.readSFixed64());
                                setFieldPresent(t, positionForFieldNumber);
                                obj3 = obj2;
                                extensionRegistryLite2 = extensionRegistryLite;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                t3 = t;
                                break;
                            case 15:
                                obj2 = obj3;
                                extensionRegistryLite = extensionRegistryLite2;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                UnsafeUtil.putInt(t, offset(typeAndOffsetAt), reader.readSInt32());
                                setFieldPresent(t, positionForFieldNumber);
                                obj3 = obj2;
                                extensionRegistryLite2 = extensionRegistryLite;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                t3 = t;
                                break;
                            case 16:
                                obj2 = obj3;
                                extensionRegistryLite = extensionRegistryLite2;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                UnsafeUtil.putLong(t, offset(typeAndOffsetAt), reader.readSInt64());
                                setFieldPresent(t, positionForFieldNumber);
                                obj3 = obj2;
                                extensionRegistryLite2 = extensionRegistryLite;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                t3 = t;
                                break;
                            case 17:
                                obj2 = obj3;
                                extensionRegistryLite = extensionRegistryLite2;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                MessageLite messageLite2 = (MessageLite) mutableMessageFieldForMerge(t, positionForFieldNumber);
                                reader.mergeGroupField(messageLite2, getMessageFieldSchema(positionForFieldNumber), extensionRegistryLite);
                                storeMessageField(t, positionForFieldNumber, messageLite2);
                                obj3 = obj2;
                                extensionRegistryLite2 = extensionRegistryLite;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                t3 = t;
                                break;
                            case 18:
                                obj2 = obj3;
                                extensionRegistryLite = extensionRegistryLite2;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                reader.readDoubleList(this.listFieldSchema.mutableListAt(t, offset(typeAndOffsetAt)));
                                obj3 = obj2;
                                extensionRegistryLite2 = extensionRegistryLite;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                t3 = t;
                                break;
                            case 19:
                                obj2 = obj3;
                                extensionRegistryLite = extensionRegistryLite2;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                reader.readFloatList(this.listFieldSchema.mutableListAt(t, offset(typeAndOffsetAt)));
                                obj3 = obj2;
                                extensionRegistryLite2 = extensionRegistryLite;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                t3 = t;
                                break;
                            case 20:
                                obj2 = obj3;
                                extensionRegistryLite = extensionRegistryLite2;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                reader.readInt64List(this.listFieldSchema.mutableListAt(t, offset(typeAndOffsetAt)));
                                obj3 = obj2;
                                extensionRegistryLite2 = extensionRegistryLite;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                t3 = t;
                                break;
                            case 21:
                                obj2 = obj3;
                                extensionRegistryLite = extensionRegistryLite2;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                reader.readUInt64List(this.listFieldSchema.mutableListAt(t, offset(typeAndOffsetAt)));
                                obj3 = obj2;
                                extensionRegistryLite2 = extensionRegistryLite;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                t3 = t;
                                break;
                            case 22:
                                obj2 = obj3;
                                extensionRegistryLite = extensionRegistryLite2;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                reader.readInt32List(this.listFieldSchema.mutableListAt(t, offset(typeAndOffsetAt)));
                                obj3 = obj2;
                                extensionRegistryLite2 = extensionRegistryLite;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                t3 = t;
                                break;
                            case 23:
                                obj2 = obj3;
                                extensionRegistryLite = extensionRegistryLite2;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                reader.readFixed64List(this.listFieldSchema.mutableListAt(t, offset(typeAndOffsetAt)));
                                obj3 = obj2;
                                extensionRegistryLite2 = extensionRegistryLite;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                t3 = t;
                                break;
                            case 24:
                                obj2 = obj3;
                                extensionRegistryLite = extensionRegistryLite2;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                reader.readFixed32List(this.listFieldSchema.mutableListAt(t, offset(typeAndOffsetAt)));
                                obj3 = obj2;
                                extensionRegistryLite2 = extensionRegistryLite;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                t3 = t;
                                break;
                            case 25:
                                obj2 = obj3;
                                extensionRegistryLite = extensionRegistryLite2;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                reader.readBoolList(this.listFieldSchema.mutableListAt(t, offset(typeAndOffsetAt)));
                                obj3 = obj2;
                                extensionRegistryLite2 = extensionRegistryLite;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                t3 = t;
                                break;
                            case 26:
                                obj2 = obj3;
                                extensionRegistryLite = extensionRegistryLite2;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                readStringList(t, typeAndOffsetAt, reader);
                                obj3 = obj2;
                                extensionRegistryLite2 = extensionRegistryLite;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                t3 = t;
                                break;
                            case 27:
                                obj2 = obj3;
                                extensionRegistryLite = extensionRegistryLite2;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                readMessageList(message, typeAndOffsetAt, reader, getMessageFieldSchema(positionForFieldNumber), extensionRegistry);
                                obj3 = obj2;
                                extensionRegistryLite2 = extensionRegistryLite;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                t3 = t;
                                break;
                            case 28:
                                obj2 = obj3;
                                extensionRegistryLite = extensionRegistryLite2;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                reader.readBytesList(this.listFieldSchema.mutableListAt(t, offset(typeAndOffsetAt)));
                                obj3 = obj2;
                                extensionRegistryLite2 = extensionRegistryLite;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                t3 = t;
                                break;
                            case 29:
                                obj2 = obj3;
                                extensionRegistryLite = extensionRegistryLite2;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                reader.readUInt32List(this.listFieldSchema.mutableListAt(t, offset(typeAndOffsetAt)));
                                obj3 = obj2;
                                extensionRegistryLite2 = extensionRegistryLite;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                t3 = t;
                                break;
                            case 30:
                                extensionRegistryLite = extensionRegistryLite2;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                List<Integer> mutableListAt = this.listFieldSchema.mutableListAt(t, offset(typeAndOffsetAt));
                                reader.readEnumList(mutableListAt);
                                obj3 = SchemaUtil.filterUnknownEnumList(message, fieldNumber, mutableListAt, getEnumFieldVerifier(positionForFieldNumber), obj3, unknownFieldSchema);
                                extensionRegistryLite2 = extensionRegistryLite;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                t3 = t;
                                break;
                            case 31:
                                obj2 = obj3;
                                extensionRegistryLite = extensionRegistryLite2;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                reader.readSFixed32List(this.listFieldSchema.mutableListAt(t, offset(typeAndOffsetAt)));
                                obj3 = obj2;
                                extensionRegistryLite2 = extensionRegistryLite;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                t3 = t;
                                break;
                            case 32:
                                obj2 = obj3;
                                extensionRegistryLite = extensionRegistryLite2;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                reader.readSFixed64List(this.listFieldSchema.mutableListAt(t, offset(typeAndOffsetAt)));
                                obj3 = obj2;
                                extensionRegistryLite2 = extensionRegistryLite;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                t3 = t;
                                break;
                            case 33:
                                obj2 = obj3;
                                extensionRegistryLite = extensionRegistryLite2;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                reader.readSInt32List(this.listFieldSchema.mutableListAt(t, offset(typeAndOffsetAt)));
                                obj3 = obj2;
                                extensionRegistryLite2 = extensionRegistryLite;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                t3 = t;
                                break;
                            case 34:
                                obj2 = obj3;
                                extensionRegistryLite = extensionRegistryLite2;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                reader.readSInt64List(this.listFieldSchema.mutableListAt(t, offset(typeAndOffsetAt)));
                                obj3 = obj2;
                                extensionRegistryLite2 = extensionRegistryLite;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                t3 = t;
                                break;
                            case 35:
                                obj2 = obj3;
                                extensionRegistryLite = extensionRegistryLite2;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                reader.readDoubleList(this.listFieldSchema.mutableListAt(t, offset(typeAndOffsetAt)));
                                obj3 = obj2;
                                extensionRegistryLite2 = extensionRegistryLite;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                t3 = t;
                                break;
                            case 36:
                                obj2 = obj3;
                                extensionRegistryLite = extensionRegistryLite2;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                reader.readFloatList(this.listFieldSchema.mutableListAt(t, offset(typeAndOffsetAt)));
                                obj3 = obj2;
                                extensionRegistryLite2 = extensionRegistryLite;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                t3 = t;
                                break;
                            case 37:
                                obj2 = obj3;
                                extensionRegistryLite = extensionRegistryLite2;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                reader.readInt64List(this.listFieldSchema.mutableListAt(t, offset(typeAndOffsetAt)));
                                obj3 = obj2;
                                extensionRegistryLite2 = extensionRegistryLite;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                t3 = t;
                                break;
                            case 38:
                                obj2 = obj3;
                                extensionRegistryLite = extensionRegistryLite2;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                reader.readUInt64List(this.listFieldSchema.mutableListAt(t, offset(typeAndOffsetAt)));
                                obj3 = obj2;
                                extensionRegistryLite2 = extensionRegistryLite;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                t3 = t;
                                break;
                            case 39:
                                obj2 = obj3;
                                extensionRegistryLite = extensionRegistryLite2;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                reader.readInt32List(this.listFieldSchema.mutableListAt(t, offset(typeAndOffsetAt)));
                                obj3 = obj2;
                                extensionRegistryLite2 = extensionRegistryLite;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                t3 = t;
                                break;
                            case 40:
                                obj2 = obj3;
                                extensionRegistryLite = extensionRegistryLite2;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                reader.readFixed64List(this.listFieldSchema.mutableListAt(t, offset(typeAndOffsetAt)));
                                obj3 = obj2;
                                extensionRegistryLite2 = extensionRegistryLite;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                t3 = t;
                                break;
                            case 41:
                                obj2 = obj3;
                                extensionRegistryLite = extensionRegistryLite2;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                reader.readFixed32List(this.listFieldSchema.mutableListAt(t, offset(typeAndOffsetAt)));
                                obj3 = obj2;
                                extensionRegistryLite2 = extensionRegistryLite;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                t3 = t;
                                break;
                            case 42:
                                obj2 = obj3;
                                extensionRegistryLite = extensionRegistryLite2;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                reader.readBoolList(this.listFieldSchema.mutableListAt(t, offset(typeAndOffsetAt)));
                                obj3 = obj2;
                                extensionRegistryLite2 = extensionRegistryLite;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                t3 = t;
                                break;
                            case 43:
                                obj2 = obj3;
                                extensionRegistryLite = extensionRegistryLite2;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                reader.readUInt32List(this.listFieldSchema.mutableListAt(t, offset(typeAndOffsetAt)));
                                obj3 = obj2;
                                extensionRegistryLite2 = extensionRegistryLite;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                t3 = t;
                                break;
                            case 44:
                                extensionRegistryLite = extensionRegistryLite2;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                List<Integer> mutableListAt2 = this.listFieldSchema.mutableListAt(t, offset(typeAndOffsetAt));
                                reader.readEnumList(mutableListAt2);
                                obj3 = SchemaUtil.filterUnknownEnumList(message, fieldNumber, mutableListAt2, getEnumFieldVerifier(positionForFieldNumber), obj3, unknownFieldSchema);
                                extensionRegistryLite2 = extensionRegistryLite;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                t3 = t;
                                break;
                            case 45:
                                obj2 = obj3;
                                extensionRegistryLite = extensionRegistryLite2;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                reader.readSFixed32List(this.listFieldSchema.mutableListAt(t, offset(typeAndOffsetAt)));
                                obj3 = obj2;
                                extensionRegistryLite2 = extensionRegistryLite;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                t3 = t;
                                break;
                            case 46:
                                obj2 = obj3;
                                extensionRegistryLite = extensionRegistryLite2;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                reader.readSFixed64List(this.listFieldSchema.mutableListAt(t, offset(typeAndOffsetAt)));
                                obj3 = obj2;
                                extensionRegistryLite2 = extensionRegistryLite;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                t3 = t;
                                break;
                            case 47:
                                obj2 = obj3;
                                extensionRegistryLite = extensionRegistryLite2;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                reader.readSInt32List(this.listFieldSchema.mutableListAt(t, offset(typeAndOffsetAt)));
                                obj3 = obj2;
                                extensionRegistryLite2 = extensionRegistryLite;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                t3 = t;
                                break;
                            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE /* 48 */:
                                obj2 = obj3;
                                extensionRegistryLite = extensionRegistryLite2;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                reader.readSInt64List(this.listFieldSchema.mutableListAt(t, offset(typeAndOffsetAt)));
                                obj3 = obj2;
                                extensionRegistryLite2 = extensionRegistryLite;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                t3 = t;
                                break;
                            case ConstraintLayout.LayoutParams.Table.LAYOUT_EDITOR_ABSOLUTEX /* 49 */:
                                obj2 = obj3;
                                extensionRegistryLite = extensionRegistryLite2;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                readGroupList(message, offset(typeAndOffsetAt), reader, getMessageFieldSchema(positionForFieldNumber), extensionRegistry);
                                obj3 = obj2;
                                extensionRegistryLite2 = extensionRegistryLite;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                t3 = t;
                                break;
                            case 50:
                                obj2 = obj3;
                                extensionRegistryLite = extensionRegistryLite2;
                                try {
                                    mergeMap(message, positionForFieldNumber, getMapFieldDefaultEntry(positionForFieldNumber), extensionRegistry, reader);
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    obj3 = obj2;
                                } catch (InvalidProtocolBufferException.InvalidWireTypeException unused) {
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    obj3 = obj2;
                                    if (unknownFieldSchema2.shouldDiscardUnknownFields(reader)) {
                                    }
                                    extensionRegistryLite2 = extensionRegistryLite;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    t3 = t;
                                } catch (Throwable th) {
                                    th = th;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    obj3 = obj2;
                                    obj = obj3;
                                    while (i < this.repeatedFieldOffsetStart) {
                                    }
                                    if (obj != null) {
                                    }
                                    throw th;
                                }
                                extensionRegistryLite2 = extensionRegistryLite;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                t3 = t;
                                break;
                            case 51:
                                UnsafeUtil.putObject(t, offset(typeAndOffsetAt), Double.valueOf(reader.readDouble()));
                                setOneofPresent(t, fieldNumber, positionForFieldNumber);
                                obj2 = obj3;
                                extensionRegistryLite = extensionRegistryLite2;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                obj3 = obj2;
                                extensionRegistryLite2 = extensionRegistryLite;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                t3 = t;
                                break;
                            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_TOP_OF /* 52 */:
                                UnsafeUtil.putObject(t, offset(typeAndOffsetAt), Float.valueOf(reader.readFloat()));
                                setOneofPresent(t, fieldNumber, positionForFieldNumber);
                                obj2 = obj3;
                                extensionRegistryLite = extensionRegistryLite2;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                obj3 = obj2;
                                extensionRegistryLite2 = extensionRegistryLite;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                t3 = t;
                                break;
                            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_BOTTOM_OF /* 53 */:
                                UnsafeUtil.putObject(t, offset(typeAndOffsetAt), Long.valueOf(reader.readInt64()));
                                setOneofPresent(t, fieldNumber, positionForFieldNumber);
                                obj2 = obj3;
                                extensionRegistryLite = extensionRegistryLite2;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                obj3 = obj2;
                                extensionRegistryLite2 = extensionRegistryLite;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                t3 = t;
                                break;
                            case ConstraintLayout.LayoutParams.Table.LAYOUT_MARGIN_BASELINE /* 54 */:
                                UnsafeUtil.putObject(t, offset(typeAndOffsetAt), Long.valueOf(reader.readUInt64()));
                                setOneofPresent(t, fieldNumber, positionForFieldNumber);
                                obj2 = obj3;
                                extensionRegistryLite = extensionRegistryLite2;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                obj3 = obj2;
                                extensionRegistryLite2 = extensionRegistryLite;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                t3 = t;
                                break;
                            case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE /* 55 */:
                                UnsafeUtil.putObject(t, offset(typeAndOffsetAt), Integer.valueOf(reader.readInt32()));
                                setOneofPresent(t, fieldNumber, positionForFieldNumber);
                                obj2 = obj3;
                                extensionRegistryLite = extensionRegistryLite2;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                obj3 = obj2;
                                extensionRegistryLite2 = extensionRegistryLite;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                t3 = t;
                                break;
                            case 56:
                                UnsafeUtil.putObject(t, offset(typeAndOffsetAt), Long.valueOf(reader.readFixed64()));
                                setOneofPresent(t, fieldNumber, positionForFieldNumber);
                                obj2 = obj3;
                                extensionRegistryLite = extensionRegistryLite2;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                obj3 = obj2;
                                extensionRegistryLite2 = extensionRegistryLite;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                t3 = t;
                                break;
                            case 57:
                                UnsafeUtil.putObject(t, offset(typeAndOffsetAt), Integer.valueOf(reader.readFixed32()));
                                setOneofPresent(t, fieldNumber, positionForFieldNumber);
                                obj2 = obj3;
                                extensionRegistryLite = extensionRegistryLite2;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                obj3 = obj2;
                                extensionRegistryLite2 = extensionRegistryLite;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                t3 = t;
                                break;
                            case 58:
                                UnsafeUtil.putObject(t, offset(typeAndOffsetAt), Boolean.valueOf(reader.readBool()));
                                setOneofPresent(t, fieldNumber, positionForFieldNumber);
                                obj2 = obj3;
                                extensionRegistryLite = extensionRegistryLite2;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                obj3 = obj2;
                                extensionRegistryLite2 = extensionRegistryLite;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                t3 = t;
                                break;
                            case 59:
                                readString(t, typeAndOffsetAt, reader);
                                setOneofPresent(t, fieldNumber, positionForFieldNumber);
                                obj2 = obj3;
                                extensionRegistryLite = extensionRegistryLite2;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                obj3 = obj2;
                                extensionRegistryLite2 = extensionRegistryLite;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                t3 = t;
                                break;
                            case LockFreeTaskQueueCore.FROZEN_SHIFT /* 60 */:
                                MessageLite messageLite3 = (MessageLite) mutableOneofMessageFieldForMerge(t, fieldNumber, positionForFieldNumber);
                                reader.mergeMessageField(messageLite3, getMessageFieldSchema(positionForFieldNumber), extensionRegistryLite2);
                                storeOneofMessageField(t, fieldNumber, positionForFieldNumber, messageLite3);
                                obj2 = obj3;
                                extensionRegistryLite = extensionRegistryLite2;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                obj3 = obj2;
                                extensionRegistryLite2 = extensionRegistryLite;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                t3 = t;
                                break;
                            case LockFreeTaskQueueCore.CLOSED_SHIFT /* 61 */:
                                UnsafeUtil.putObject(t, offset(typeAndOffsetAt), reader.readBytes());
                                setOneofPresent(t, fieldNumber, positionForFieldNumber);
                                obj2 = obj3;
                                extensionRegistryLite = extensionRegistryLite2;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                obj3 = obj2;
                                extensionRegistryLite2 = extensionRegistryLite;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                t3 = t;
                                break;
                            case 62:
                                UnsafeUtil.putObject(t, offset(typeAndOffsetAt), Integer.valueOf(reader.readUInt32()));
                                setOneofPresent(t, fieldNumber, positionForFieldNumber);
                                obj2 = obj3;
                                extensionRegistryLite = extensionRegistryLite2;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                obj3 = obj2;
                                extensionRegistryLite2 = extensionRegistryLite;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                t3 = t;
                                break;
                            case HtmlCompat.FROM_HTML_MODE_COMPACT /* 63 */:
                                int readEnum2 = reader.readEnum();
                                Internal.EnumVerifier enumFieldVerifier2 = getEnumFieldVerifier(positionForFieldNumber);
                                if (enumFieldVerifier2 != null && !enumFieldVerifier2.isInRange(readEnum2)) {
                                    obj3 = SchemaUtil.storeUnknownEnum(t, fieldNumber, readEnum2, obj3, unknownFieldSchema3);
                                    extensionRegistryLite = extensionRegistryLite2;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    extensionRegistryLite2 = extensionRegistryLite;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    t3 = t;
                                    break;
                                }
                                UnsafeUtil.putObject(t, offset(typeAndOffsetAt), Integer.valueOf(readEnum2));
                                setOneofPresent(t, fieldNumber, positionForFieldNumber);
                                obj2 = obj3;
                                extensionRegistryLite = extensionRegistryLite2;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                obj3 = obj2;
                                extensionRegistryLite2 = extensionRegistryLite;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                t3 = t;
                                break;
                            case 64:
                                UnsafeUtil.putObject(t, offset(typeAndOffsetAt), Integer.valueOf(reader.readSFixed32()));
                                setOneofPresent(t, fieldNumber, positionForFieldNumber);
                                obj2 = obj3;
                                extensionRegistryLite = extensionRegistryLite2;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                obj3 = obj2;
                                extensionRegistryLite2 = extensionRegistryLite;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                t3 = t;
                                break;
                            case 65:
                                UnsafeUtil.putObject(t, offset(typeAndOffsetAt), Long.valueOf(reader.readSFixed64()));
                                setOneofPresent(t, fieldNumber, positionForFieldNumber);
                                obj2 = obj3;
                                extensionRegistryLite = extensionRegistryLite2;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                obj3 = obj2;
                                extensionRegistryLite2 = extensionRegistryLite;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                t3 = t;
                                break;
                            case ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT /* 66 */:
                                UnsafeUtil.putObject(t, offset(typeAndOffsetAt), Integer.valueOf(reader.readSInt32()));
                                setOneofPresent(t, fieldNumber, positionForFieldNumber);
                                obj2 = obj3;
                                extensionRegistryLite = extensionRegistryLite2;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                obj3 = obj2;
                                extensionRegistryLite2 = extensionRegistryLite;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                t3 = t;
                                break;
                            case 67:
                                UnsafeUtil.putObject(t, offset(typeAndOffsetAt), Long.valueOf(reader.readSInt64()));
                                setOneofPresent(t, fieldNumber, positionForFieldNumber);
                                obj2 = obj3;
                                extensionRegistryLite = extensionRegistryLite2;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                obj3 = obj2;
                                extensionRegistryLite2 = extensionRegistryLite;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                t3 = t;
                                break;
                            case 68:
                                try {
                                    MessageLite messageLite4 = (MessageLite) mutableOneofMessageFieldForMerge(t, fieldNumber, positionForFieldNumber);
                                    reader.mergeGroupField(messageLite4, getMessageFieldSchema(positionForFieldNumber), extensionRegistryLite2);
                                    storeOneofMessageField(t, fieldNumber, positionForFieldNumber, messageLite4);
                                    obj2 = obj3;
                                    extensionRegistryLite = extensionRegistryLite2;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    obj3 = obj2;
                                } catch (InvalidProtocolBufferException.InvalidWireTypeException unused2) {
                                    extensionRegistryLite = extensionRegistryLite2;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    if (unknownFieldSchema2.shouldDiscardUnknownFields(reader)) {
                                    }
                                    extensionRegistryLite2 = extensionRegistryLite;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    t3 = t;
                                } catch (Throwable th2) {
                                    th = th2;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    obj = obj3;
                                    while (i < this.repeatedFieldOffsetStart) {
                                    }
                                    if (obj != null) {
                                    }
                                    throw th;
                                }
                                extensionRegistryLite2 = extensionRegistryLite;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                t3 = t;
                                break;
                            default:
                                obj2 = obj3;
                                extensionRegistryLite = extensionRegistryLite2;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                if (obj2 == null) {
                                    try {
                                        obj3 = unknownFieldSchema2.getBuilderFromMessage(t);
                                    } catch (InvalidProtocolBufferException.InvalidWireTypeException unused3) {
                                        obj3 = obj2;
                                        if (unknownFieldSchema2.shouldDiscardUnknownFields(reader)) {
                                        }
                                        extensionRegistryLite2 = extensionRegistryLite;
                                        unknownFieldSchema3 = unknownFieldSchema2;
                                        t3 = t;
                                    } catch (Throwable th3) {
                                        th = th3;
                                        obj3 = obj2;
                                        obj = obj3;
                                        while (i < this.repeatedFieldOffsetStart) {
                                        }
                                        if (obj != null) {
                                        }
                                        throw th;
                                    }
                                } else {
                                    obj3 = obj2;
                                }
                                try {
                                    try {
                                        if (!unknownFieldSchema2.mergeOneFieldFrom(obj3, reader, 0)) {
                                            Object obj4 = obj3;
                                            for (int i2 = this.checkInitializedCount; i2 < this.repeatedFieldOffsetStart; i2++) {
                                                obj4 = filterMapUnknownEnumValues(message, this.intArray[i2], obj4, unknownFieldSchema, message);
                                            }
                                            if (obj4 != null) {
                                                unknownFieldSchema2.setBuilderToMessage(t, obj4);
                                                return;
                                            }
                                            return;
                                        }
                                    } catch (InvalidProtocolBufferException.InvalidWireTypeException unused4) {
                                        if (unknownFieldSchema2.shouldDiscardUnknownFields(reader)) {
                                            if (obj3 == null) {
                                                obj3 = unknownFieldSchema2.getBuilderFromMessage(t);
                                            }
                                            if (!unknownFieldSchema2.mergeOneFieldFrom(obj3, reader, 0)) {
                                                Object obj5 = obj3;
                                                for (int i3 = this.checkInitializedCount; i3 < this.repeatedFieldOffsetStart; i3++) {
                                                    obj5 = filterMapUnknownEnumValues(message, this.intArray[i3], obj5, unknownFieldSchema, message);
                                                }
                                                if (obj5 != null) {
                                                    unknownFieldSchema2.setBuilderToMessage(t, obj5);
                                                    return;
                                                }
                                                return;
                                            }
                                        } else if (!reader.skipField()) {
                                            Object obj6 = obj3;
                                            for (int i4 = this.checkInitializedCount; i4 < this.repeatedFieldOffsetStart; i4++) {
                                                obj6 = filterMapUnknownEnumValues(message, this.intArray[i4], obj6, unknownFieldSchema, message);
                                            }
                                            if (obj6 != null) {
                                                unknownFieldSchema2.setBuilderToMessage(t, obj6);
                                                return;
                                            }
                                            return;
                                        }
                                        extensionRegistryLite2 = extensionRegistryLite;
                                        unknownFieldSchema3 = unknownFieldSchema2;
                                        t3 = t;
                                    }
                                    extensionRegistryLite2 = extensionRegistryLite;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    t3 = t;
                                } catch (Throwable th4) {
                                    th = th4;
                                    obj = obj3;
                                    while (i < this.repeatedFieldOffsetStart) {
                                    }
                                    if (obj != null) {
                                    }
                                    throw th;
                                }
                                break;
                        }
                    } catch (Throwable th5) {
                        th = th5;
                    }
                } else {
                    if (fieldNumber == Integer.MAX_VALUE) {
                        Object obj7 = obj3;
                        for (int i5 = this.checkInitializedCount; i5 < this.repeatedFieldOffsetStart; i5++) {
                            obj7 = filterMapUnknownEnumValues(message, this.intArray[i5], obj7, unknownFieldSchema, message);
                        }
                        if (obj7 != null) {
                            unknownFieldSchema3.setBuilderToMessage(t3, obj7);
                            return;
                        }
                        return;
                    }
                    try {
                        Object findExtensionByNumber = !this.hasExtensions ? null : extensionSchema.findExtensionByNumber(extensionRegistryLite2, this.defaultInstance, fieldNumber);
                        if (findExtensionByNumber != null) {
                            if (fieldSet == null) {
                                fieldSet = extensionSchema.getMutableExtensions(message);
                            }
                            FieldSet<ET> fieldSet2 = fieldSet;
                            t2 = t3;
                            try {
                                obj3 = extensionSchema.parseExtension(message, reader, findExtensionByNumber, extensionRegistry, fieldSet2, obj3, unknownFieldSchema);
                                fieldSet = fieldSet2;
                            } catch (Throwable th6) {
                                th = th6;
                                t = t2;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                obj = obj3;
                                for (i = this.checkInitializedCount; i < this.repeatedFieldOffsetStart; i++) {
                                    obj = filterMapUnknownEnumValues(message, this.intArray[i], obj, unknownFieldSchema, message);
                                }
                                if (obj != null) {
                                    unknownFieldSchema2.setBuilderToMessage(t, obj);
                                }
                                throw th;
                            }
                        } else {
                            t2 = t3;
                            if (!unknownFieldSchema3.shouldDiscardUnknownFields(reader)) {
                                if (obj3 == null) {
                                    obj3 = unknownFieldSchema3.getBuilderFromMessage(t2);
                                }
                                if (!unknownFieldSchema3.mergeOneFieldFrom(obj3, reader, 0)) {
                                }
                            } else if (!reader.skipField()) {
                            }
                        }
                        t3 = t2;
                    } catch (Throwable th7) {
                        th = th7;
                        t = t3;
                        unknownFieldSchema2 = unknownFieldSchema3;
                        obj = obj3;
                        while (i < this.repeatedFieldOffsetStart) {
                        }
                        if (obj != null) {
                        }
                        throw th;
                    }
                }
            } catch (Throwable th8) {
                th = th8;
            }
        }
        int i6 = this.checkInitializedCount;
        Object obj8 = obj3;
        while (i6 < this.repeatedFieldOffsetStart) {
            obj8 = filterMapUnknownEnumValues(message, this.intArray[i6], obj8, unknownFieldSchema, message);
            i6++;
            t2 = t2;
        }
        T t4 = t2;
        if (obj8 != null) {
            unknownFieldSchema3.setBuilderToMessage(t4, obj8);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static UnknownFieldSetLite getMutableUnknownFields(Object message) {
        GeneratedMessageLite generatedMessageLite = (GeneratedMessageLite) message;
        UnknownFieldSetLite unknownFieldSetLite = generatedMessageLite.unknownFields;
        if (unknownFieldSetLite != UnknownFieldSetLite.getDefaultInstance()) {
            return unknownFieldSetLite;
        }
        UnknownFieldSetLite newInstance = UnknownFieldSetLite.newInstance();
        generatedMessageLite.unknownFields = newInstance;
        return newInstance;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: androidx.datastore.preferences.protobuf.MessageSchema$1, reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$WireFormat$FieldType;

        static {
            int[] iArr = new int[WireFormat.FieldType.values().length];
            $SwitchMap$com$google$protobuf$WireFormat$FieldType = iArr;
            try {
                iArr[WireFormat.FieldType.BOOL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.BYTES.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.DOUBLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FIXED32.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SFIXED32.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FIXED64.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SFIXED64.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FLOAT.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.ENUM.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.INT32.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.UINT32.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.INT64.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.UINT64.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.MESSAGE.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SINT32.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SINT64.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.STRING.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0008. Please report as an issue. */
    private int decodeMapEntryValue(byte[] data, int position, int limit, WireFormat.FieldType fieldType, Class<?> messageType, ArrayDecoders.Registers registers) throws IOException {
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[fieldType.ordinal()]) {
            case 1:
                int decodeVarint64 = ArrayDecoders.decodeVarint64(data, position, registers);
                registers.object1 = Boolean.valueOf(registers.long1 != 0);
                return decodeVarint64;
            case 2:
                return ArrayDecoders.decodeBytes(data, position, registers);
            case 3:
                registers.object1 = Double.valueOf(ArrayDecoders.decodeDouble(data, position));
                return position + 8;
            case 4:
            case 5:
                registers.object1 = Integer.valueOf(ArrayDecoders.decodeFixed32(data, position));
                return position + 4;
            case 6:
            case 7:
                registers.object1 = Long.valueOf(ArrayDecoders.decodeFixed64(data, position));
                return position + 8;
            case 8:
                registers.object1 = Float.valueOf(ArrayDecoders.decodeFloat(data, position));
                return position + 4;
            case 9:
            case 10:
            case 11:
                int decodeVarint32 = ArrayDecoders.decodeVarint32(data, position, registers);
                registers.object1 = Integer.valueOf(registers.int1);
                return decodeVarint32;
            case 12:
            case 13:
                int decodeVarint642 = ArrayDecoders.decodeVarint64(data, position, registers);
                registers.object1 = Long.valueOf(registers.long1);
                return decodeVarint642;
            case 14:
                return ArrayDecoders.decodeMessageField(Protobuf.getInstance().schemaFor((Class) messageType), data, position, limit, registers);
            case 15:
                int decodeVarint322 = ArrayDecoders.decodeVarint32(data, position, registers);
                registers.object1 = Integer.valueOf(CodedInputStream.decodeZigZag32(registers.int1));
                return decodeVarint322;
            case 16:
                int decodeVarint643 = ArrayDecoders.decodeVarint64(data, position, registers);
                registers.object1 = Long.valueOf(CodedInputStream.decodeZigZag64(registers.long1));
                return decodeVarint643;
            case 17:
                return ArrayDecoders.decodeStringRequireUtf8(data, position, registers);
            default:
                throw new RuntimeException("unsupported field type.");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r19v0, types: [java.util.Map, java.util.Map<K, V>] */
    /* JADX WARN: Type inference failed for: r1v10, types: [int] */
    private <K, V> int decodeMapEntry(byte[] data, int position, int limit, MapEntryLite.Metadata<K, V> metadata, Map<K, V> target, ArrayDecoders.Registers registers) throws IOException {
        int i;
        int decodeVarint32 = ArrayDecoders.decodeVarint32(data, position, registers);
        int i2 = registers.int1;
        if (i2 < 0 || i2 > limit - decodeVarint32) {
            throw InvalidProtocolBufferException.truncatedMessage();
        }
        int i3 = decodeVarint32 + i2;
        Object obj = metadata.defaultKey;
        Object obj2 = metadata.defaultValue;
        while (decodeVarint32 < i3) {
            int i4 = decodeVarint32 + 1;
            byte b = data[decodeVarint32];
            if (b < 0) {
                i = ArrayDecoders.decodeVarint32(b, data, i4, registers);
                b = registers.int1;
            } else {
                i = i4;
            }
            int i5 = b >>> 3;
            int i6 = b & 7;
            if (i5 == 1) {
                if (i6 == metadata.keyType.getWireType()) {
                    decodeVarint32 = decodeMapEntryValue(data, i, limit, metadata.keyType, null, registers);
                    obj = registers.object1;
                } else {
                    decodeVarint32 = ArrayDecoders.skipField(b, data, i, limit, registers);
                }
            } else {
                if (i5 == 2 && i6 == metadata.valueType.getWireType()) {
                    decodeVarint32 = decodeMapEntryValue(data, i, limit, metadata.valueType, metadata.defaultValue.getClass(), registers);
                    obj2 = registers.object1;
                }
                decodeVarint32 = ArrayDecoders.skipField(b, data, i, limit, registers);
            }
        }
        if (decodeVarint32 != i3) {
            throw InvalidProtocolBufferException.parseFailure();
        }
        target.put(obj, obj2);
        return i3;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:9:0x002f. Please report as an issue. */
    private int parseRepeatedField(T message, byte[] data, int position, int limit, int tag, int number, int wireType, int bufferPosition, long typeAndOffset, int fieldType, long fieldOffset, ArrayDecoders.Registers registers) throws IOException {
        int decodeVarint32List;
        Unsafe unsafe = UNSAFE;
        Internal.ProtobufList protobufList = (Internal.ProtobufList) unsafe.getObject(message, fieldOffset);
        if (!protobufList.isModifiable()) {
            int size = protobufList.size();
            protobufList = protobufList.mutableCopyWithCapacity2(size == 0 ? 10 : size * 2);
            unsafe.putObject(message, fieldOffset, protobufList);
        }
        switch (fieldType) {
            case 18:
            case 35:
                if (wireType == 2) {
                    return ArrayDecoders.decodePackedDoubleList(data, position, protobufList, registers);
                }
                if (wireType == 1) {
                    return ArrayDecoders.decodeDoubleList(tag, data, position, limit, protobufList, registers);
                }
                return position;
            case 19:
            case 36:
                if (wireType == 2) {
                    return ArrayDecoders.decodePackedFloatList(data, position, protobufList, registers);
                }
                if (wireType == 5) {
                    return ArrayDecoders.decodeFloatList(tag, data, position, limit, protobufList, registers);
                }
                return position;
            case 20:
            case 21:
            case 37:
            case 38:
                if (wireType == 2) {
                    return ArrayDecoders.decodePackedVarint64List(data, position, protobufList, registers);
                }
                if (wireType == 0) {
                    return ArrayDecoders.decodeVarint64List(tag, data, position, limit, protobufList, registers);
                }
                return position;
            case 22:
            case 29:
            case 39:
            case 43:
                if (wireType == 2) {
                    return ArrayDecoders.decodePackedVarint32List(data, position, protobufList, registers);
                }
                if (wireType == 0) {
                    return ArrayDecoders.decodeVarint32List(tag, data, position, limit, protobufList, registers);
                }
                return position;
            case 23:
            case 32:
            case 40:
            case 46:
                if (wireType == 2) {
                    return ArrayDecoders.decodePackedFixed64List(data, position, protobufList, registers);
                }
                if (wireType == 1) {
                    return ArrayDecoders.decodeFixed64List(tag, data, position, limit, protobufList, registers);
                }
                return position;
            case 24:
            case 31:
            case 41:
            case 45:
                if (wireType == 2) {
                    return ArrayDecoders.decodePackedFixed32List(data, position, protobufList, registers);
                }
                if (wireType == 5) {
                    return ArrayDecoders.decodeFixed32List(tag, data, position, limit, protobufList, registers);
                }
                return position;
            case 25:
            case 42:
                if (wireType == 2) {
                    return ArrayDecoders.decodePackedBoolList(data, position, protobufList, registers);
                }
                if (wireType == 0) {
                    return ArrayDecoders.decodeBoolList(tag, data, position, limit, protobufList, registers);
                }
                return position;
            case 26:
                if (wireType == 2) {
                    if ((typeAndOffset & 536870912) == 0) {
                        return ArrayDecoders.decodeStringList(tag, data, position, limit, protobufList, registers);
                    }
                    return ArrayDecoders.decodeStringListRequireUtf8(tag, data, position, limit, protobufList, registers);
                }
                return position;
            case 27:
                if (wireType == 2) {
                    return ArrayDecoders.decodeMessageList(getMessageFieldSchema(bufferPosition), tag, data, position, limit, protobufList, registers);
                }
                return position;
            case 28:
                if (wireType == 2) {
                    return ArrayDecoders.decodeBytesList(tag, data, position, limit, protobufList, registers);
                }
                return position;
            case 30:
            case 44:
                if (wireType != 2) {
                    if (wireType == 0) {
                        decodeVarint32List = ArrayDecoders.decodeVarint32List(tag, data, position, limit, protobufList, registers);
                    }
                    return position;
                }
                decodeVarint32List = ArrayDecoders.decodePackedVarint32List(data, position, protobufList, registers);
                SchemaUtil.filterUnknownEnumList((Object) message, number, (List<Integer>) protobufList, getEnumFieldVerifier(bufferPosition), (Object) null, (UnknownFieldSchema<UT, Object>) this.unknownFieldSchema);
                return decodeVarint32List;
            case 33:
            case 47:
                if (wireType == 2) {
                    return ArrayDecoders.decodePackedSInt32List(data, position, protobufList, registers);
                }
                if (wireType == 0) {
                    return ArrayDecoders.decodeSInt32List(tag, data, position, limit, protobufList, registers);
                }
                return position;
            case 34:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE /* 48 */:
                if (wireType == 2) {
                    return ArrayDecoders.decodePackedSInt64List(data, position, protobufList, registers);
                }
                if (wireType == 0) {
                    return ArrayDecoders.decodeSInt64List(tag, data, position, limit, protobufList, registers);
                }
                return position;
            case ConstraintLayout.LayoutParams.Table.LAYOUT_EDITOR_ABSOLUTEX /* 49 */:
                if (wireType == 3) {
                    return ArrayDecoders.decodeGroupList(getMessageFieldSchema(bufferPosition), tag, data, position, limit, protobufList, registers);
                }
                return position;
            default:
                return position;
        }
    }

    private <K, V> int parseMapField(T message, byte[] data, int position, int limit, int bufferPosition, long fieldOffset, ArrayDecoders.Registers registers) throws IOException {
        Unsafe unsafe = UNSAFE;
        Object mapFieldDefaultEntry = getMapFieldDefaultEntry(bufferPosition);
        Object object = unsafe.getObject(message, fieldOffset);
        if (this.mapFieldSchema.isImmutable(object)) {
            Object newMapField = this.mapFieldSchema.newMapField(mapFieldDefaultEntry);
            this.mapFieldSchema.mergeFrom(newMapField, object);
            unsafe.putObject(message, fieldOffset, newMapField);
            object = newMapField;
        }
        return decodeMapEntry(data, position, limit, this.mapFieldSchema.forMapMetadata(mapFieldDefaultEntry), this.mapFieldSchema.forMutableMapData(object), registers);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0023. Please report as an issue. */
    private int parseOneofField(T message, byte[] data, int position, int limit, int tag, int number, int wireType, int typeAndOffset, int fieldType, long fieldOffset, int bufferPosition, ArrayDecoders.Registers registers) throws IOException {
        Unsafe unsafe = UNSAFE;
        long j = this.buffer[bufferPosition + 2] & 1048575;
        switch (fieldType) {
            case 51:
                if (wireType == 1) {
                    unsafe.putObject(message, fieldOffset, Double.valueOf(ArrayDecoders.decodeDouble(data, position)));
                    int i = position + 8;
                    unsafe.putInt(message, j, number);
                    return i;
                }
                return position;
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_TOP_OF /* 52 */:
                if (wireType == 5) {
                    unsafe.putObject(message, fieldOffset, Float.valueOf(ArrayDecoders.decodeFloat(data, position)));
                    int i2 = position + 4;
                    unsafe.putInt(message, j, number);
                    return i2;
                }
                return position;
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_BOTTOM_OF /* 53 */:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_MARGIN_BASELINE /* 54 */:
                if (wireType == 0) {
                    int decodeVarint64 = ArrayDecoders.decodeVarint64(data, position, registers);
                    unsafe.putObject(message, fieldOffset, Long.valueOf(registers.long1));
                    unsafe.putInt(message, j, number);
                    return decodeVarint64;
                }
                return position;
            case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE /* 55 */:
            case 62:
                if (wireType == 0) {
                    int decodeVarint32 = ArrayDecoders.decodeVarint32(data, position, registers);
                    unsafe.putObject(message, fieldOffset, Integer.valueOf(registers.int1));
                    unsafe.putInt(message, j, number);
                    return decodeVarint32;
                }
                return position;
            case 56:
            case 65:
                if (wireType == 1) {
                    unsafe.putObject(message, fieldOffset, Long.valueOf(ArrayDecoders.decodeFixed64(data, position)));
                    int i3 = position + 8;
                    unsafe.putInt(message, j, number);
                    return i3;
                }
                return position;
            case 57:
            case 64:
                if (wireType == 5) {
                    unsafe.putObject(message, fieldOffset, Integer.valueOf(ArrayDecoders.decodeFixed32(data, position)));
                    int i4 = position + 4;
                    unsafe.putInt(message, j, number);
                    return i4;
                }
                return position;
            case 58:
                if (wireType == 0) {
                    int decodeVarint642 = ArrayDecoders.decodeVarint64(data, position, registers);
                    unsafe.putObject(message, fieldOffset, Boolean.valueOf(registers.long1 != 0));
                    unsafe.putInt(message, j, number);
                    return decodeVarint642;
                }
                return position;
            case 59:
                if (wireType == 2) {
                    int decodeVarint322 = ArrayDecoders.decodeVarint32(data, position, registers);
                    int i5 = registers.int1;
                    if (i5 == 0) {
                        unsafe.putObject(message, fieldOffset, "");
                    } else {
                        if ((typeAndOffset & 536870912) != 0 && !Utf8.isValidUtf8(data, decodeVarint322, decodeVarint322 + i5)) {
                            throw InvalidProtocolBufferException.invalidUtf8();
                        }
                        unsafe.putObject(message, fieldOffset, new String(data, decodeVarint322, i5, Internal.UTF_8));
                        decodeVarint322 += i5;
                    }
                    unsafe.putInt(message, j, number);
                    return decodeVarint322;
                }
                return position;
            case LockFreeTaskQueueCore.FROZEN_SHIFT /* 60 */:
                if (wireType == 2) {
                    Object mutableOneofMessageFieldForMerge = mutableOneofMessageFieldForMerge(message, number, bufferPosition);
                    int mergeMessageField = ArrayDecoders.mergeMessageField(mutableOneofMessageFieldForMerge, getMessageFieldSchema(bufferPosition), data, position, limit, registers);
                    storeOneofMessageField(message, number, bufferPosition, mutableOneofMessageFieldForMerge);
                    return mergeMessageField;
                }
                return position;
            case LockFreeTaskQueueCore.CLOSED_SHIFT /* 61 */:
                if (wireType == 2) {
                    int decodeBytes = ArrayDecoders.decodeBytes(data, position, registers);
                    unsafe.putObject(message, fieldOffset, registers.object1);
                    unsafe.putInt(message, j, number);
                    return decodeBytes;
                }
                return position;
            case HtmlCompat.FROM_HTML_MODE_COMPACT /* 63 */:
                if (wireType == 0) {
                    int decodeVarint323 = ArrayDecoders.decodeVarint32(data, position, registers);
                    int i6 = registers.int1;
                    Internal.EnumVerifier enumFieldVerifier = getEnumFieldVerifier(bufferPosition);
                    if (enumFieldVerifier == null || enumFieldVerifier.isInRange(i6)) {
                        unsafe.putObject(message, fieldOffset, Integer.valueOf(i6));
                        unsafe.putInt(message, j, number);
                    } else {
                        getMutableUnknownFields(message).storeField(tag, Long.valueOf(i6));
                    }
                    return decodeVarint323;
                }
                return position;
            case ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT /* 66 */:
                if (wireType == 0) {
                    int decodeVarint324 = ArrayDecoders.decodeVarint32(data, position, registers);
                    unsafe.putObject(message, fieldOffset, Integer.valueOf(CodedInputStream.decodeZigZag32(registers.int1)));
                    unsafe.putInt(message, j, number);
                    return decodeVarint324;
                }
                return position;
            case 67:
                if (wireType == 0) {
                    int decodeVarint643 = ArrayDecoders.decodeVarint64(data, position, registers);
                    unsafe.putObject(message, fieldOffset, Long.valueOf(CodedInputStream.decodeZigZag64(registers.long1)));
                    unsafe.putInt(message, j, number);
                    return decodeVarint643;
                }
                return position;
            case 68:
                if (wireType == 3) {
                    Object mutableOneofMessageFieldForMerge2 = mutableOneofMessageFieldForMerge(message, number, bufferPosition);
                    int mergeGroupField = ArrayDecoders.mergeGroupField(mutableOneofMessageFieldForMerge2, getMessageFieldSchema(bufferPosition), data, position, limit, (tag & (-8)) | 4, registers);
                    storeOneofMessageField(message, number, bufferPosition, mutableOneofMessageFieldForMerge2);
                    return mergeGroupField;
                }
                return position;
            default:
                return position;
        }
    }

    private Schema getMessageFieldSchema(int pos) {
        int i = (pos / 3) * 2;
        Schema schema = (Schema) this.objects[i];
        if (schema != null) {
            return schema;
        }
        Schema<T> schemaFor = Protobuf.getInstance().schemaFor((Class) this.objects[i + 1]);
        this.objects[i] = schemaFor;
        return schemaFor;
    }

    private Object getMapFieldDefaultEntry(int pos) {
        return this.objects[(pos / 3) * 2];
    }

    private Internal.EnumVerifier getEnumFieldVerifier(int pos) {
        return (Internal.EnumVerifier) this.objects[((pos / 3) * 2) + 1];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Failed to find 'out' block for switch in B:101:0x0099. Please report as an issue. */
    public int parseMessage(T message, byte[] data, int position, int limit, int endDelimited, ArrayDecoders.Registers registers) throws IOException {
        Unsafe unsafe;
        int i;
        MessageSchema<T> messageSchema;
        int i2;
        int i3;
        int i4;
        int i5;
        T t;
        int i6;
        int positionForFieldNumber;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        byte[] bArr;
        int i13;
        int i14;
        char c;
        byte[] bArr2;
        int decodeVarint64;
        int i15;
        int i16;
        MessageSchema<T> messageSchema2 = this;
        T t2 = message;
        byte[] bArr3 = data;
        int i17 = limit;
        int i18 = endDelimited;
        ArrayDecoders.Registers registers2 = registers;
        checkMutable(message);
        Unsafe unsafe2 = UNSAFE;
        int i19 = position;
        int i20 = 0;
        int i21 = 0;
        int i22 = 0;
        int i23 = -1;
        int i24 = 1048575;
        while (true) {
            if (i19 < i17) {
                int i25 = i19 + 1;
                byte b = bArr3[i19];
                if (b < 0) {
                    int decodeVarint32 = ArrayDecoders.decodeVarint32(b, bArr3, i25, registers2);
                    i6 = registers2.int1;
                    i25 = decodeVarint32;
                } else {
                    i6 = b;
                }
                int i26 = i6 >>> 3;
                int i27 = i6 & 7;
                if (i26 > i23) {
                    positionForFieldNumber = messageSchema2.positionForFieldNumber(i26, i20 / 3);
                } else {
                    positionForFieldNumber = messageSchema2.positionForFieldNumber(i26);
                }
                int i28 = positionForFieldNumber;
                if (i28 == -1) {
                    i7 = i26;
                    i8 = i25;
                    i3 = i6;
                    i9 = i22;
                    i10 = i24;
                    unsafe = unsafe2;
                    i = i18;
                    i11 = 0;
                } else {
                    int i29 = messageSchema2.buffer[i28 + 1];
                    int type = type(i29);
                    long offset = offset(i29);
                    int i30 = i6;
                    if (type <= 17) {
                        int i31 = messageSchema2.buffer[i28 + 2];
                        int i32 = 1 << (i31 >>> 20);
                        int i33 = 1048575;
                        int i34 = i31 & 1048575;
                        if (i34 != i24) {
                            if (i24 != 1048575) {
                                unsafe2.putInt(t2, i24, i22);
                                i33 = 1048575;
                            }
                            i10 = i34;
                            i12 = i34 == i33 ? 0 : unsafe2.getInt(t2, i34);
                        } else {
                            i12 = i22;
                            i10 = i24;
                        }
                        switch (type) {
                            case 0:
                                bArr = data;
                                i7 = i26;
                                i13 = i28;
                                i14 = i30;
                                c = 65535;
                                if (i27 != 1) {
                                    i = endDelimited;
                                    i8 = i25;
                                    i11 = i13;
                                    unsafe = unsafe2;
                                    i9 = i12;
                                    i3 = i14;
                                    break;
                                } else {
                                    UnsafeUtil.putDouble(t2, offset, ArrayDecoders.decodeDouble(bArr, i25));
                                    i19 = i25 + 8;
                                    i22 = i12 | i32;
                                    i18 = endDelimited;
                                    i20 = i13;
                                    bArr3 = bArr;
                                    i21 = i14;
                                    i24 = i10;
                                    i23 = i7;
                                    i17 = limit;
                                }
                            case 1:
                                bArr = data;
                                i7 = i26;
                                i13 = i28;
                                i14 = i30;
                                c = 65535;
                                if (i27 != 5) {
                                    i = endDelimited;
                                    i8 = i25;
                                    i11 = i13;
                                    unsafe = unsafe2;
                                    i9 = i12;
                                    i3 = i14;
                                    break;
                                } else {
                                    UnsafeUtil.putFloat(t2, offset, ArrayDecoders.decodeFloat(bArr, i25));
                                    i19 = i25 + 4;
                                    i22 = i12 | i32;
                                    i18 = endDelimited;
                                    i20 = i13;
                                    bArr3 = bArr;
                                    i21 = i14;
                                    i24 = i10;
                                    i23 = i7;
                                    i17 = limit;
                                }
                            case 2:
                            case 3:
                                bArr2 = data;
                                i7 = i26;
                                i13 = i28;
                                i14 = i30;
                                c = 65535;
                                if (i27 != 0) {
                                    i = endDelimited;
                                    i8 = i25;
                                    i11 = i13;
                                    unsafe = unsafe2;
                                    i9 = i12;
                                    i3 = i14;
                                    break;
                                } else {
                                    decodeVarint64 = ArrayDecoders.decodeVarint64(bArr2, i25, registers2);
                                    unsafe2.putLong(message, offset, registers2.long1);
                                    i22 = i12 | i32;
                                    i18 = endDelimited;
                                    i20 = i13;
                                    bArr3 = bArr2;
                                    i19 = decodeVarint64;
                                    i21 = i14;
                                    i24 = i10;
                                    i23 = i7;
                                    i17 = limit;
                                }
                            case 4:
                            case 11:
                                bArr = data;
                                i7 = i26;
                                i13 = i28;
                                i14 = i30;
                                c = 65535;
                                if (i27 != 0) {
                                    i = endDelimited;
                                    i8 = i25;
                                    i11 = i13;
                                    unsafe = unsafe2;
                                    i9 = i12;
                                    i3 = i14;
                                    break;
                                } else {
                                    i19 = ArrayDecoders.decodeVarint32(bArr, i25, registers2);
                                    unsafe2.putInt(t2, offset, registers2.int1);
                                    i22 = i12 | i32;
                                    i18 = endDelimited;
                                    i20 = i13;
                                    bArr3 = bArr;
                                    i21 = i14;
                                    i24 = i10;
                                    i23 = i7;
                                    i17 = limit;
                                }
                            case 5:
                            case 14:
                                bArr = data;
                                i7 = i26;
                                i13 = i28;
                                i14 = i30;
                                c = 65535;
                                if (i27 != 1) {
                                    i = endDelimited;
                                    i8 = i25;
                                    i11 = i13;
                                    unsafe = unsafe2;
                                    i9 = i12;
                                    i3 = i14;
                                    break;
                                } else {
                                    unsafe2.putLong(message, offset, ArrayDecoders.decodeFixed64(bArr, i25));
                                    i19 = i25 + 8;
                                    i22 = i12 | i32;
                                    i18 = endDelimited;
                                    i20 = i13;
                                    bArr3 = bArr;
                                    i21 = i14;
                                    i24 = i10;
                                    i23 = i7;
                                    i17 = limit;
                                }
                            case 6:
                            case 13:
                                bArr = data;
                                i7 = i26;
                                i13 = i28;
                                i14 = i30;
                                c = 65535;
                                if (i27 != 5) {
                                    i = endDelimited;
                                    i8 = i25;
                                    i11 = i13;
                                    unsafe = unsafe2;
                                    i9 = i12;
                                    i3 = i14;
                                    break;
                                } else {
                                    unsafe2.putInt(t2, offset, ArrayDecoders.decodeFixed32(bArr, i25));
                                    i19 = i25 + 4;
                                    i22 = i12 | i32;
                                    i18 = endDelimited;
                                    i20 = i13;
                                    bArr3 = bArr;
                                    i21 = i14;
                                    i24 = i10;
                                    i23 = i7;
                                    i17 = limit;
                                }
                            case 7:
                                bArr = data;
                                i7 = i26;
                                i13 = i28;
                                i14 = i30;
                                c = 65535;
                                if (i27 != 0) {
                                    i = endDelimited;
                                    i8 = i25;
                                    i11 = i13;
                                    unsafe = unsafe2;
                                    i9 = i12;
                                    i3 = i14;
                                    break;
                                } else {
                                    i19 = ArrayDecoders.decodeVarint64(bArr, i25, registers2);
                                    UnsafeUtil.putBoolean(t2, offset, registers2.long1 != 0);
                                    i22 = i12 | i32;
                                    i18 = endDelimited;
                                    i20 = i13;
                                    bArr3 = bArr;
                                    i21 = i14;
                                    i24 = i10;
                                    i23 = i7;
                                    i17 = limit;
                                }
                            case 8:
                                bArr = data;
                                i7 = i26;
                                i13 = i28;
                                i14 = i30;
                                c = 65535;
                                if (i27 != 2) {
                                    i = endDelimited;
                                    i8 = i25;
                                    i11 = i13;
                                    unsafe = unsafe2;
                                    i9 = i12;
                                    i3 = i14;
                                    break;
                                } else {
                                    if (isEnforceUtf8(i29)) {
                                        i19 = ArrayDecoders.decodeStringRequireUtf8(bArr, i25, registers2);
                                    } else {
                                        i19 = ArrayDecoders.decodeString(bArr, i25, registers2);
                                    }
                                    unsafe2.putObject(t2, offset, registers2.object1);
                                    i22 = i12 | i32;
                                    i18 = endDelimited;
                                    i20 = i13;
                                    bArr3 = bArr;
                                    i21 = i14;
                                    i24 = i10;
                                    i23 = i7;
                                    i17 = limit;
                                }
                            case 9:
                                bArr = data;
                                i7 = i26;
                                i13 = i28;
                                i14 = i30;
                                c = 65535;
                                if (i27 != 2) {
                                    i = endDelimited;
                                    i8 = i25;
                                    i11 = i13;
                                    unsafe = unsafe2;
                                    i9 = i12;
                                    i3 = i14;
                                    break;
                                } else {
                                    Object mutableMessageFieldForMerge = messageSchema2.mutableMessageFieldForMerge(t2, i13);
                                    i19 = ArrayDecoders.mergeMessageField(mutableMessageFieldForMerge, messageSchema2.getMessageFieldSchema(i13), data, i25, limit, registers);
                                    messageSchema2.storeMessageField(t2, i13, mutableMessageFieldForMerge);
                                    i22 = i12 | i32;
                                    i18 = endDelimited;
                                    i20 = i13;
                                    bArr3 = bArr;
                                    i21 = i14;
                                    i24 = i10;
                                    i23 = i7;
                                    i17 = limit;
                                }
                            case 10:
                                bArr = data;
                                i7 = i26;
                                i13 = i28;
                                i14 = i30;
                                c = 65535;
                                if (i27 != 2) {
                                    i = endDelimited;
                                    i8 = i25;
                                    i11 = i13;
                                    unsafe = unsafe2;
                                    i9 = i12;
                                    i3 = i14;
                                    break;
                                } else {
                                    i19 = ArrayDecoders.decodeBytes(bArr, i25, registers2);
                                    unsafe2.putObject(t2, offset, registers2.object1);
                                    i22 = i12 | i32;
                                    i18 = endDelimited;
                                    i20 = i13;
                                    bArr3 = bArr;
                                    i21 = i14;
                                    i24 = i10;
                                    i23 = i7;
                                    i17 = limit;
                                }
                            case 12:
                                bArr = data;
                                i7 = i26;
                                i13 = i28;
                                i14 = i30;
                                c = 65535;
                                if (i27 != 0) {
                                    i = endDelimited;
                                    i8 = i25;
                                    i11 = i13;
                                    unsafe = unsafe2;
                                    i9 = i12;
                                    i3 = i14;
                                    break;
                                } else {
                                    i19 = ArrayDecoders.decodeVarint32(bArr, i25, registers2);
                                    int i35 = registers2.int1;
                                    Internal.EnumVerifier enumFieldVerifier = messageSchema2.getEnumFieldVerifier(i13);
                                    if (!isLegacyEnumIsClosed(i29) || enumFieldVerifier == null || enumFieldVerifier.isInRange(i35)) {
                                        unsafe2.putInt(t2, offset, i35);
                                        i22 = i12 | i32;
                                        i18 = endDelimited;
                                        i20 = i13;
                                        bArr3 = bArr;
                                        i21 = i14;
                                        i24 = i10;
                                        i23 = i7;
                                        i17 = limit;
                                    } else {
                                        getMutableUnknownFields(message).storeField(i14, Long.valueOf(i35));
                                        i18 = endDelimited;
                                        i20 = i13;
                                        i22 = i12;
                                        i21 = i14;
                                        i24 = i10;
                                        i23 = i7;
                                        i17 = limit;
                                        bArr3 = bArr;
                                    }
                                }
                                break;
                            case 15:
                                bArr = data;
                                i7 = i26;
                                i13 = i28;
                                i14 = i30;
                                c = 65535;
                                if (i27 != 0) {
                                    i = endDelimited;
                                    i8 = i25;
                                    i11 = i13;
                                    unsafe = unsafe2;
                                    i9 = i12;
                                    i3 = i14;
                                    break;
                                } else {
                                    i19 = ArrayDecoders.decodeVarint32(bArr, i25, registers2);
                                    unsafe2.putInt(t2, offset, CodedInputStream.decodeZigZag32(registers2.int1));
                                    i22 = i12 | i32;
                                    i18 = endDelimited;
                                    i20 = i13;
                                    bArr3 = bArr;
                                    i21 = i14;
                                    i24 = i10;
                                    i23 = i7;
                                    i17 = limit;
                                }
                            case 16:
                                i7 = i26;
                                i13 = i28;
                                i14 = i30;
                                c = 65535;
                                bArr2 = data;
                                if (i27 != 0) {
                                    i = endDelimited;
                                    i8 = i25;
                                    i11 = i13;
                                    unsafe = unsafe2;
                                    i9 = i12;
                                    i3 = i14;
                                    break;
                                } else {
                                    decodeVarint64 = ArrayDecoders.decodeVarint64(bArr2, i25, registers2);
                                    unsafe2.putLong(message, offset, CodedInputStream.decodeZigZag64(registers2.long1));
                                    i22 = i12 | i32;
                                    i18 = endDelimited;
                                    i20 = i13;
                                    bArr3 = bArr2;
                                    i19 = decodeVarint64;
                                    i21 = i14;
                                    i24 = i10;
                                    i23 = i7;
                                    i17 = limit;
                                }
                            case 17:
                                if (i27 != 3) {
                                    i7 = i26;
                                    i14 = i30;
                                    c = 65535;
                                    i13 = i28;
                                    i = endDelimited;
                                    i8 = i25;
                                    i11 = i13;
                                    unsafe = unsafe2;
                                    i9 = i12;
                                    i3 = i14;
                                    break;
                                } else {
                                    Object mutableMessageFieldForMerge2 = messageSchema2.mutableMessageFieldForMerge(t2, i28);
                                    i7 = i26;
                                    i14 = i30;
                                    i19 = ArrayDecoders.mergeGroupField(mutableMessageFieldForMerge2, messageSchema2.getMessageFieldSchema(i28), data, i25, limit, (i26 << 3) | 4, registers);
                                    messageSchema2.storeMessageField(t2, i28, mutableMessageFieldForMerge2);
                                    i22 = i12 | i32;
                                    bArr3 = data;
                                    i18 = endDelimited;
                                    i20 = i28;
                                    i21 = i14;
                                    i24 = i10;
                                    i23 = i7;
                                    i17 = limit;
                                }
                            default:
                                i7 = i26;
                                i13 = i28;
                                i14 = i30;
                                c = 65535;
                                i = endDelimited;
                                i8 = i25;
                                i11 = i13;
                                unsafe = unsafe2;
                                i9 = i12;
                                i3 = i14;
                                break;
                        }
                    } else {
                        i7 = i26;
                        int i36 = i24;
                        i9 = i22;
                        if (type != 27) {
                            i10 = i36;
                            if (type <= 49) {
                                int i37 = i25;
                                unsafe = unsafe2;
                                i11 = i28;
                                i16 = i30;
                                i19 = parseRepeatedField(message, data, i25, limit, i30, i7, i27, i28, i29, type, offset, registers);
                                if (i19 != i37) {
                                    messageSchema2 = this;
                                    t2 = message;
                                    bArr3 = data;
                                    i17 = limit;
                                    i18 = endDelimited;
                                    registers2 = registers;
                                    i21 = i16;
                                    i22 = i9;
                                    i20 = i11;
                                    i24 = i10;
                                    i23 = i7;
                                    unsafe2 = unsafe;
                                } else {
                                    i = endDelimited;
                                    i8 = i19;
                                    i3 = i16;
                                }
                            } else {
                                i15 = i25;
                                unsafe = unsafe2;
                                i11 = i28;
                                i16 = i30;
                                if (type != 50) {
                                    i19 = parseOneofField(message, data, i15, limit, i16, i7, i27, i29, type, offset, i11, registers);
                                    if (i19 != i15) {
                                        messageSchema2 = this;
                                        t2 = message;
                                        bArr3 = data;
                                        i17 = limit;
                                        i18 = endDelimited;
                                        registers2 = registers;
                                        i21 = i16;
                                        i22 = i9;
                                        i20 = i11;
                                        i24 = i10;
                                        i23 = i7;
                                        unsafe2 = unsafe;
                                    } else {
                                        i = endDelimited;
                                        i8 = i19;
                                        i3 = i16;
                                    }
                                } else if (i27 == 2) {
                                    i19 = parseMapField(message, data, i15, limit, i11, offset, registers);
                                    if (i19 != i15) {
                                        messageSchema2 = this;
                                        t2 = message;
                                        bArr3 = data;
                                        i17 = limit;
                                        i18 = endDelimited;
                                        registers2 = registers;
                                        i21 = i16;
                                        i22 = i9;
                                        i20 = i11;
                                        i24 = i10;
                                        i23 = i7;
                                        unsafe2 = unsafe;
                                    } else {
                                        i = endDelimited;
                                        i8 = i19;
                                        i3 = i16;
                                    }
                                }
                            }
                        } else if (i27 == 2) {
                            Internal.ProtobufList protobufList = (Internal.ProtobufList) unsafe2.getObject(t2, offset);
                            if (!protobufList.isModifiable()) {
                                int size = protobufList.size();
                                protobufList = protobufList.mutableCopyWithCapacity2(size == 0 ? 10 : size * 2);
                                unsafe2.putObject(t2, offset, protobufList);
                            }
                            i19 = ArrayDecoders.decodeMessageList(messageSchema2.getMessageFieldSchema(i28), i30, data, i25, limit, protobufList, registers);
                            i18 = endDelimited;
                            i20 = i28;
                            i21 = i30;
                            i22 = i9;
                            i24 = i36;
                            i23 = i7;
                            bArr3 = data;
                            i17 = limit;
                        } else {
                            i10 = i36;
                            i15 = i25;
                            unsafe = unsafe2;
                            i11 = i28;
                            i16 = i30;
                        }
                        i = endDelimited;
                        i8 = i15;
                        i3 = i16;
                    }
                }
                if (i3 != i || i == 0) {
                    if (this.hasExtensions && registers.extensionRegistry != ExtensionRegistryLite.getEmptyRegistry()) {
                        i19 = ArrayDecoders.decodeExtensionOrUnknownField(i3, data, i8, limit, message, this.defaultInstance, this.unknownFieldSchema, registers);
                    } else {
                        i19 = ArrayDecoders.decodeUnknownField(i3, data, i8, limit, getMutableUnknownFields(message), registers);
                    }
                    t2 = message;
                    bArr3 = data;
                    i17 = limit;
                    i21 = i3;
                    messageSchema2 = this;
                    registers2 = registers;
                    i22 = i9;
                    i20 = i11;
                    i24 = i10;
                    i23 = i7;
                    unsafe2 = unsafe;
                    i18 = i;
                } else {
                    i5 = 1048575;
                    messageSchema = this;
                    i2 = i8;
                    i22 = i9;
                    i4 = i10;
                }
            } else {
                int i38 = i24;
                unsafe = unsafe2;
                i = i18;
                messageSchema = messageSchema2;
                i2 = i19;
                i3 = i21;
                i4 = i38;
                i5 = 1048575;
            }
        }
        if (i4 != i5) {
            t = message;
            unsafe.putInt(t, i4, i22);
        } else {
            t = message;
        }
        UnknownFieldSetLite unknownFieldSetLite = null;
        for (int i39 = messageSchema.checkInitializedCount; i39 < messageSchema.repeatedFieldOffsetStart; i39++) {
            unknownFieldSetLite = (UnknownFieldSetLite) filterMapUnknownEnumValues(message, messageSchema.intArray[i39], unknownFieldSetLite, messageSchema.unknownFieldSchema, message);
        }
        if (unknownFieldSetLite != null) {
            messageSchema.unknownFieldSchema.setBuilderToMessage(t, unknownFieldSetLite);
        }
        if (i == 0) {
            if (i2 != limit) {
                throw InvalidProtocolBufferException.parseFailure();
            }
        } else if (i2 > limit || i3 != i) {
            throw InvalidProtocolBufferException.parseFailure();
        }
        return i2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private Object mutableMessageFieldForMerge(T message, int pos) {
        Schema messageFieldSchema = getMessageFieldSchema(pos);
        long offset = offset(typeAndOffsetAt(pos));
        if (!isFieldPresent(message, pos)) {
            return messageFieldSchema.newInstance();
        }
        Object object = UNSAFE.getObject(message, offset);
        if (isMutable(object)) {
            return object;
        }
        Object newInstance = messageFieldSchema.newInstance();
        if (object != null) {
            messageFieldSchema.mergeFrom(newInstance, object);
        }
        return newInstance;
    }

    private void storeMessageField(T message, int pos, Object field) {
        UNSAFE.putObject(message, offset(typeAndOffsetAt(pos)), field);
        setFieldPresent(message, pos);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private Object mutableOneofMessageFieldForMerge(T message, int fieldNumber, int pos) {
        Schema messageFieldSchema = getMessageFieldSchema(pos);
        if (!isOneofPresent(message, fieldNumber, pos)) {
            return messageFieldSchema.newInstance();
        }
        Object object = UNSAFE.getObject(message, offset(typeAndOffsetAt(pos)));
        if (isMutable(object)) {
            return object;
        }
        Object newInstance = messageFieldSchema.newInstance();
        if (object != null) {
            messageFieldSchema.mergeFrom(newInstance, object);
        }
        return newInstance;
    }

    private void storeOneofMessageField(T message, int fieldNumber, int pos, Object field) {
        UNSAFE.putObject(message, offset(typeAndOffsetAt(pos)), field);
        setOneofPresent(message, fieldNumber, pos);
    }

    @Override // androidx.datastore.preferences.protobuf.Schema
    public void mergeFrom(T message, byte[] data, int position, int limit, ArrayDecoders.Registers registers) throws IOException {
        parseMessage(message, data, position, limit, 0, registers);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.datastore.preferences.protobuf.Schema
    public void makeImmutable(T message) {
        if (isMutable(message)) {
            if (message instanceof GeneratedMessageLite) {
                GeneratedMessageLite generatedMessageLite = (GeneratedMessageLite) message;
                generatedMessageLite.clearMemoizedSerializedSize();
                generatedMessageLite.clearMemoizedHashCode();
                generatedMessageLite.markImmutable();
            }
            int length = this.buffer.length;
            for (int i = 0; i < length; i += 3) {
                int typeAndOffsetAt = typeAndOffsetAt(i);
                long offset = offset(typeAndOffsetAt);
                int type = type(typeAndOffsetAt);
                if (type != 9) {
                    if (type == 60 || type == 68) {
                        if (isOneofPresent(message, numberAt(i), i)) {
                            getMessageFieldSchema(i).makeImmutable(UNSAFE.getObject(message, offset));
                        }
                    } else {
                        switch (type) {
                            case 18:
                            case 19:
                            case 20:
                            case 21:
                            case 22:
                            case 23:
                            case 24:
                            case 25:
                            case 26:
                            case 27:
                            case 28:
                            case 29:
                            case 30:
                            case 31:
                            case 32:
                            case 33:
                            case 34:
                            case 35:
                            case 36:
                            case 37:
                            case 38:
                            case 39:
                            case 40:
                            case 41:
                            case 42:
                            case 43:
                            case 44:
                            case 45:
                            case 46:
                            case 47:
                            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE /* 48 */:
                            case ConstraintLayout.LayoutParams.Table.LAYOUT_EDITOR_ABSOLUTEX /* 49 */:
                                this.listFieldSchema.makeImmutableListAt(message, offset);
                                break;
                            case 50:
                                Unsafe unsafe = UNSAFE;
                                Object object = unsafe.getObject(message, offset);
                                if (object != null) {
                                    unsafe.putObject(message, offset, this.mapFieldSchema.toImmutable(object));
                                    break;
                                } else {
                                    break;
                                }
                        }
                    }
                }
                if (isFieldPresent(message, i)) {
                    getMessageFieldSchema(i).makeImmutable(UNSAFE.getObject(message, offset));
                }
            }
            this.unknownFieldSchema.makeImmutable(message);
            if (this.hasExtensions) {
                this.extensionSchema.makeImmutable(message);
            }
        }
    }

    private final <K, V> void mergeMap(Object message, int pos, Object mapDefaultEntry, ExtensionRegistryLite extensionRegistry, Reader reader) throws IOException {
        long offset = offset(typeAndOffsetAt(pos));
        Object object = UnsafeUtil.getObject(message, offset);
        if (object == null) {
            object = this.mapFieldSchema.newMapField(mapDefaultEntry);
            UnsafeUtil.putObject(message, offset, object);
        } else if (this.mapFieldSchema.isImmutable(object)) {
            Object newMapField = this.mapFieldSchema.newMapField(mapDefaultEntry);
            this.mapFieldSchema.mergeFrom(newMapField, object);
            UnsafeUtil.putObject(message, offset, newMapField);
            object = newMapField;
        }
        reader.readMap(this.mapFieldSchema.forMutableMapData(object), this.mapFieldSchema.forMapMetadata(mapDefaultEntry), extensionRegistry);
    }

    private <UT, UB> UB filterMapUnknownEnumValues(Object obj, int i, UB ub, UnknownFieldSchema<UT, UB> unknownFieldSchema, Object obj2) {
        Internal.EnumVerifier enumFieldVerifier;
        int numberAt = numberAt(i);
        Object object = UnsafeUtil.getObject(obj, offset(typeAndOffsetAt(i)));
        return (object == null || (enumFieldVerifier = getEnumFieldVerifier(i)) == null) ? ub : (UB) filterUnknownEnumMap(i, numberAt, this.mapFieldSchema.forMutableMapData(object), enumFieldVerifier, ub, unknownFieldSchema, obj2);
    }

    private <K, V, UT, UB> UB filterUnknownEnumMap(int i, int i2, Map<K, V> map, Internal.EnumVerifier enumVerifier, UB ub, UnknownFieldSchema<UT, UB> unknownFieldSchema, Object obj) {
        MapEntryLite.Metadata<?, ?> forMapMetadata = this.mapFieldSchema.forMapMetadata(getMapFieldDefaultEntry(i));
        Iterator<Map.Entry<K, V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<K, V> next = it.next();
            if (!enumVerifier.isInRange(((Integer) next.getValue()).intValue())) {
                if (ub == null) {
                    ub = unknownFieldSchema.getBuilderFromMessage(obj);
                }
                ByteString.CodedBuilder newCodedBuilder = ByteString.newCodedBuilder(MapEntryLite.computeSerializedSize(forMapMetadata, next.getKey(), next.getValue()));
                try {
                    MapEntryLite.writeTo(newCodedBuilder.getCodedOutput(), forMapMetadata, next.getKey(), next.getValue());
                    unknownFieldSchema.addLengthDelimited(ub, i2, newCodedBuilder.build());
                    it.remove();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return ub;
    }

    @Override // androidx.datastore.preferences.protobuf.Schema
    public final boolean isInitialized(T message) {
        int i;
        int i2;
        int i3 = 1048575;
        int i4 = 0;
        int i5 = 0;
        while (i5 < this.checkInitializedCount) {
            int i6 = this.intArray[i5];
            int numberAt = numberAt(i6);
            int typeAndOffsetAt = typeAndOffsetAt(i6);
            int i7 = this.buffer[i6 + 2];
            int i8 = i7 & 1048575;
            int i9 = 1 << (i7 >>> 20);
            if (i8 != i3) {
                if (i8 != 1048575) {
                    i4 = UNSAFE.getInt(message, i8);
                }
                i2 = i4;
                i = i8;
            } else {
                i = i3;
                i2 = i4;
            }
            if (isRequired(typeAndOffsetAt) && !isFieldPresent(message, i6, i, i2, i9)) {
                return false;
            }
            int type = type(typeAndOffsetAt);
            if (type == 9 || type == 17) {
                if (isFieldPresent(message, i6, i, i2, i9) && !isInitialized(message, typeAndOffsetAt, getMessageFieldSchema(i6))) {
                    return false;
                }
            } else {
                if (type != 27) {
                    if (type == 60 || type == 68) {
                        if (isOneofPresent(message, numberAt, i6) && !isInitialized(message, typeAndOffsetAt, getMessageFieldSchema(i6))) {
                            return false;
                        }
                    } else if (type != 49) {
                        if (type == 50 && !isMapInitialized(message, typeAndOffsetAt, i6)) {
                            return false;
                        }
                    }
                }
                if (!isListInitialized(message, typeAndOffsetAt, i6)) {
                    return false;
                }
            }
            i5++;
            i3 = i;
            i4 = i2;
        }
        return !this.hasExtensions || this.extensionSchema.getExtensions(message).isInitialized();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean isInitialized(Object message, int typeAndOffset, Schema schema) {
        return schema.isInitialized(UnsafeUtil.getObject(message, offset(typeAndOffset)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <N> boolean isListInitialized(Object message, int typeAndOffset, int pos) {
        List list = (List) UnsafeUtil.getObject(message, offset(typeAndOffset));
        if (list.isEmpty()) {
            return true;
        }
        Schema messageFieldSchema = getMessageFieldSchema(pos);
        for (int i = 0; i < list.size(); i++) {
            if (!messageFieldSchema.isInitialized(list.get(i))) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r5v8, types: [androidx.datastore.preferences.protobuf.Schema] */
    private boolean isMapInitialized(T t, int i, int i2) {
        Map<?, ?> forMapData = this.mapFieldSchema.forMapData(UnsafeUtil.getObject(t, offset(i)));
        if (forMapData.isEmpty()) {
            return true;
        }
        if (this.mapFieldSchema.forMapMetadata(getMapFieldDefaultEntry(i2)).valueType.getJavaType() != WireFormat.JavaType.MESSAGE) {
            return true;
        }
        ?? r5 = 0;
        for (Object obj : forMapData.values()) {
            r5 = r5;
            if (r5 == 0) {
                r5 = Protobuf.getInstance().schemaFor((Class) obj.getClass());
            }
            if (!r5.isInitialized(obj)) {
                return false;
            }
        }
        return true;
    }

    private void writeString(int fieldNumber, Object value, Writer writer) throws IOException {
        if (value instanceof String) {
            writer.writeString(fieldNumber, (String) value);
        } else {
            writer.writeBytes(fieldNumber, (ByteString) value);
        }
    }

    private void readString(Object message, int typeAndOffset, Reader reader) throws IOException {
        if (isEnforceUtf8(typeAndOffset)) {
            UnsafeUtil.putObject(message, offset(typeAndOffset), reader.readStringRequireUtf8());
        } else if (this.lite) {
            UnsafeUtil.putObject(message, offset(typeAndOffset), reader.readString());
        } else {
            UnsafeUtil.putObject(message, offset(typeAndOffset), reader.readBytes());
        }
    }

    private void readStringList(Object message, int typeAndOffset, Reader reader) throws IOException {
        if (isEnforceUtf8(typeAndOffset)) {
            reader.readStringListRequireUtf8(this.listFieldSchema.mutableListAt(message, offset(typeAndOffset)));
        } else {
            reader.readStringList(this.listFieldSchema.mutableListAt(message, offset(typeAndOffset)));
        }
    }

    private <E> void readMessageList(Object message, int typeAndOffset, Reader reader, Schema<E> schema, ExtensionRegistryLite extensionRegistry) throws IOException {
        reader.readMessageList(this.listFieldSchema.mutableListAt(message, offset(typeAndOffset)), schema, extensionRegistry);
    }

    private <E> void readGroupList(Object message, long offset, Reader reader, Schema<E> schema, ExtensionRegistryLite extensionRegistry) throws IOException {
        reader.readGroupList(this.listFieldSchema.mutableListAt(message, offset), schema, extensionRegistry);
    }

    private int numberAt(int pos) {
        return this.buffer[pos];
    }

    private int typeAndOffsetAt(int pos) {
        return this.buffer[pos + 1];
    }

    private int presenceMaskAndOffsetAt(int pos) {
        return this.buffer[pos + 2];
    }

    private static boolean isMutable(Object message) {
        if (message == null) {
            return false;
        }
        if (message instanceof GeneratedMessageLite) {
            return ((GeneratedMessageLite) message).isMutable();
        }
        return true;
    }

    private static void checkMutable(Object message) {
        if (isMutable(message)) {
            return;
        }
        throw new IllegalArgumentException("Mutating immutable message: " + message);
    }

    private static <T> double doubleAt(T message, long offset) {
        return UnsafeUtil.getDouble(message, offset);
    }

    private static <T> float floatAt(T message, long offset) {
        return UnsafeUtil.getFloat(message, offset);
    }

    private static <T> int intAt(T message, long offset) {
        return UnsafeUtil.getInt(message, offset);
    }

    private static <T> long longAt(T message, long offset) {
        return UnsafeUtil.getLong(message, offset);
    }

    private static <T> boolean booleanAt(T message, long offset) {
        return UnsafeUtil.getBoolean(message, offset);
    }

    private static <T> double oneofDoubleAt(T message, long offset) {
        return ((Double) UnsafeUtil.getObject(message, offset)).doubleValue();
    }

    private static <T> float oneofFloatAt(T message, long offset) {
        return ((Float) UnsafeUtil.getObject(message, offset)).floatValue();
    }

    private static <T> int oneofIntAt(T message, long offset) {
        return ((Integer) UnsafeUtil.getObject(message, offset)).intValue();
    }

    private static <T> long oneofLongAt(T message, long offset) {
        return ((Long) UnsafeUtil.getObject(message, offset)).longValue();
    }

    private static <T> boolean oneofBooleanAt(T message, long offset) {
        return ((Boolean) UnsafeUtil.getObject(message, offset)).booleanValue();
    }

    private boolean arePresentForEquals(T message, T other, int pos) {
        return isFieldPresent(message, pos) == isFieldPresent(other, pos);
    }

    private boolean isFieldPresent(T message, int pos, int presenceFieldOffset, int presenceField, int presenceMask) {
        if (presenceFieldOffset == 1048575) {
            return isFieldPresent(message, pos);
        }
        return (presenceField & presenceMask) != 0;
    }

    private boolean isFieldPresent(T message, int pos) {
        int presenceMaskAndOffsetAt = presenceMaskAndOffsetAt(pos);
        long j = 1048575 & presenceMaskAndOffsetAt;
        if (j != 1048575) {
            return (UnsafeUtil.getInt(message, j) & (1 << (presenceMaskAndOffsetAt >>> 20))) != 0;
        }
        int typeAndOffsetAt = typeAndOffsetAt(pos);
        long offset = offset(typeAndOffsetAt);
        switch (type(typeAndOffsetAt)) {
            case 0:
                return Double.doubleToRawLongBits(UnsafeUtil.getDouble(message, offset)) != 0;
            case 1:
                return Float.floatToRawIntBits(UnsafeUtil.getFloat(message, offset)) != 0;
            case 2:
                return UnsafeUtil.getLong(message, offset) != 0;
            case 3:
                return UnsafeUtil.getLong(message, offset) != 0;
            case 4:
                return UnsafeUtil.getInt(message, offset) != 0;
            case 5:
                return UnsafeUtil.getLong(message, offset) != 0;
            case 6:
                return UnsafeUtil.getInt(message, offset) != 0;
            case 7:
                return UnsafeUtil.getBoolean(message, offset);
            case 8:
                Object object = UnsafeUtil.getObject(message, offset);
                if (object instanceof String) {
                    return !((String) object).isEmpty();
                }
                if (object instanceof ByteString) {
                    return !ByteString.EMPTY.equals(object);
                }
                throw new IllegalArgumentException();
            case 9:
                return UnsafeUtil.getObject(message, offset) != null;
            case 10:
                return !ByteString.EMPTY.equals(UnsafeUtil.getObject(message, offset));
            case 11:
                return UnsafeUtil.getInt(message, offset) != 0;
            case 12:
                return UnsafeUtil.getInt(message, offset) != 0;
            case 13:
                return UnsafeUtil.getInt(message, offset) != 0;
            case 14:
                return UnsafeUtil.getLong(message, offset) != 0;
            case 15:
                return UnsafeUtil.getInt(message, offset) != 0;
            case 16:
                return UnsafeUtil.getLong(message, offset) != 0;
            case 17:
                return UnsafeUtil.getObject(message, offset) != null;
            default:
                throw new IllegalArgumentException();
        }
    }

    private void setFieldPresent(T message, int pos) {
        int presenceMaskAndOffsetAt = presenceMaskAndOffsetAt(pos);
        long j = 1048575 & presenceMaskAndOffsetAt;
        if (j == 1048575) {
            return;
        }
        UnsafeUtil.putInt(message, j, (1 << (presenceMaskAndOffsetAt >>> 20)) | UnsafeUtil.getInt(message, j));
    }

    private boolean isOneofPresent(T message, int fieldNumber, int pos) {
        return UnsafeUtil.getInt(message, (long) (presenceMaskAndOffsetAt(pos) & 1048575)) == fieldNumber;
    }

    private boolean isOneofCaseEqual(T message, T other, int pos) {
        long presenceMaskAndOffsetAt = presenceMaskAndOffsetAt(pos) & 1048575;
        return UnsafeUtil.getInt(message, presenceMaskAndOffsetAt) == UnsafeUtil.getInt(other, presenceMaskAndOffsetAt);
    }

    private void setOneofPresent(T message, int fieldNumber, int pos) {
        UnsafeUtil.putInt(message, presenceMaskAndOffsetAt(pos) & 1048575, fieldNumber);
    }

    private int positionForFieldNumber(final int number) {
        if (number < this.minFieldNumber || number > this.maxFieldNumber) {
            return -1;
        }
        return slowPositionForFieldNumber(number, 0);
    }

    private int positionForFieldNumber(final int number, final int min) {
        if (number < this.minFieldNumber || number > this.maxFieldNumber) {
            return -1;
        }
        return slowPositionForFieldNumber(number, min);
    }

    private int slowPositionForFieldNumber(final int number, int min) {
        int length = (this.buffer.length / 3) - 1;
        while (min <= length) {
            int i = (length + min) >>> 1;
            int i2 = i * 3;
            int numberAt = numberAt(i2);
            if (number == numberAt) {
                return i2;
            }
            if (number < numberAt) {
                length = i - 1;
            } else {
                min = i + 1;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getSchemaSize() {
        return this.buffer.length * 3;
    }
}
