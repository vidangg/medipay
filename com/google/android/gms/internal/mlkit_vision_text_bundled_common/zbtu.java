package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
final class zbtu {
    private static final zbtu zbb = new zbtu(true);
    final zbwh zba = new zbwa();
    private boolean zbc;
    private boolean zbd;

    private zbtu() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x001a. Please report as an issue. */
    public static int zba(zbww zbwwVar, int i, Object obj) {
        int zbd;
        int zbD;
        int zbD2 = zbtk.zbD(i << 3);
        if (zbwwVar == zbww.GROUP) {
            zbuo.zbd((zbvm) obj);
            zbD2 += zbD2;
        }
        zbwx zbwxVar = zbwx.INT;
        int i2 = 4;
        switch (zbwwVar) {
            case DOUBLE:
                ((Double) obj).doubleValue();
                i2 = 8;
                return zbD2 + i2;
            case FLOAT:
                ((Float) obj).floatValue();
                return zbD2 + i2;
            case INT64:
                i2 = zbtk.zbE(((Long) obj).longValue());
                return zbD2 + i2;
            case UINT64:
                i2 = zbtk.zbE(((Long) obj).longValue());
                return zbD2 + i2;
            case INT32:
                i2 = zbtk.zbE(((Integer) obj).intValue());
                return zbD2 + i2;
            case FIXED64:
                ((Long) obj).longValue();
                i2 = 8;
                return zbD2 + i2;
            case FIXED32:
                ((Integer) obj).intValue();
                return zbD2 + i2;
            case BOOL:
                ((Boolean) obj).booleanValue();
                i2 = 1;
                return zbD2 + i2;
            case STRING:
                if (obj instanceof zbtc) {
                    zbd = ((zbtc) obj).zbd();
                    zbD = zbtk.zbD(zbd);
                    i2 = zbD + zbd;
                    return zbD2 + i2;
                }
                i2 = zbtk.zbC((String) obj);
                return zbD2 + i2;
            case GROUP:
                i2 = ((zbvm) obj).zbo();
                return zbD2 + i2;
            case MESSAGE:
                if (obj instanceof zbuv) {
                    zbd = ((zbuv) obj).zba();
                    zbD = zbtk.zbD(zbd);
                    i2 = zbD + zbd;
                    return zbD2 + i2;
                }
                i2 = zbtk.zbA((zbvm) obj);
                return zbD2 + i2;
            case BYTES:
                if (obj instanceof zbtc) {
                    zbd = ((zbtc) obj).zbd();
                    zbD = zbtk.zbD(zbd);
                } else {
                    zbd = ((byte[]) obj).length;
                    zbD = zbtk.zbD(zbd);
                }
                i2 = zbD + zbd;
                return zbD2 + i2;
            case UINT32:
                i2 = zbtk.zbD(((Integer) obj).intValue());
                return zbD2 + i2;
            case ENUM:
                if (obj instanceof zbuh) {
                    i2 = zbtk.zbE(((zbuh) obj).zba());
                } else {
                    i2 = zbtk.zbE(((Integer) obj).intValue());
                }
                return zbD2 + i2;
            case SFIXED32:
                ((Integer) obj).intValue();
                return zbD2 + i2;
            case SFIXED64:
                ((Long) obj).longValue();
                i2 = 8;
                return zbD2 + i2;
            case SINT32:
                int intValue = ((Integer) obj).intValue();
                i2 = zbtk.zbD((intValue >> 31) ^ (intValue + intValue));
                return zbD2 + i2;
            case SINT64:
                long longValue = ((Long) obj).longValue();
                i2 = zbtk.zbE((longValue >> 63) ^ (longValue + longValue));
                return zbD2 + i2;
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    public static int zbb(zbtt zbttVar, Object obj) {
        zbww zbd = zbttVar.zbd();
        zbttVar.zba();
        zbttVar.zbg();
        return zba(zbd, 32149011, obj);
    }

    public static zbtu zbe() {
        return zbb;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zbk(zbtk zbtkVar, zbww zbwwVar, int i, Object obj) throws IOException {
        if (zbwwVar != zbww.GROUP) {
            zbtkVar.zbu(i, zbwwVar.zba());
            zbwx zbwxVar = zbwx.INT;
            switch (zbwwVar) {
                case DOUBLE:
                    zbtkVar.zbk(Double.doubleToRawLongBits(((Double) obj).doubleValue()));
                    return;
                case FLOAT:
                    zbtkVar.zbi(Float.floatToRawIntBits(((Float) obj).floatValue()));
                    return;
                case INT64:
                    zbtkVar.zby(((Long) obj).longValue());
                    return;
                case UINT64:
                    zbtkVar.zby(((Long) obj).longValue());
                    return;
                case INT32:
                    zbtkVar.zbm(((Integer) obj).intValue());
                    return;
                case FIXED64:
                    zbtkVar.zbk(((Long) obj).longValue());
                    return;
                case FIXED32:
                    zbtkVar.zbi(((Integer) obj).intValue());
                    return;
                case BOOL:
                    zbtkVar.zbb(((Boolean) obj).booleanValue() ? (byte) 1 : (byte) 0);
                    return;
                case STRING:
                    if (obj instanceof zbtc) {
                        zbtkVar.zbg((zbtc) obj);
                        return;
                    } else {
                        zbtkVar.zbt((String) obj);
                        return;
                    }
                case GROUP:
                    ((zbvm) obj).zbL(zbtkVar);
                    return;
                case MESSAGE:
                    zbtkVar.zbp((zbvm) obj);
                    return;
                case BYTES:
                    if (obj instanceof zbtc) {
                        zbtkVar.zbg((zbtc) obj);
                        return;
                    } else {
                        byte[] bArr = (byte[]) obj;
                        zbtkVar.zbe(bArr, 0, bArr.length);
                        return;
                    }
                case UINT32:
                    zbtkVar.zbw(((Integer) obj).intValue());
                    return;
                case ENUM:
                    if (obj instanceof zbuh) {
                        zbtkVar.zbm(((zbuh) obj).zba());
                        return;
                    } else {
                        zbtkVar.zbm(((Integer) obj).intValue());
                        return;
                    }
                case SFIXED32:
                    zbtkVar.zbi(((Integer) obj).intValue());
                    return;
                case SFIXED64:
                    zbtkVar.zbk(((Long) obj).longValue());
                    return;
                case SINT32:
                    int intValue = ((Integer) obj).intValue();
                    zbtkVar.zbw((intValue >> 31) ^ (intValue + intValue));
                    return;
                case SINT64:
                    long longValue = ((Long) obj).longValue();
                    zbtkVar.zby((longValue >> 63) ^ (longValue + longValue));
                    return;
                default:
                    return;
            }
        }
        zbvm zbvmVar = (zbvm) obj;
        zbuo.zbd(zbvmVar);
        zbtkVar.zbu(i, 3);
        zbvmVar.zbL(zbtkVar);
        zbtkVar.zbu(i, 4);
    }

    private static Object zbn(Object obj) {
        if (obj instanceof zbvr) {
            return ((zbvr) obj).zbc();
        }
        if (!(obj instanceof byte[])) {
            return obj;
        }
        byte[] bArr = (byte[]) obj;
        int length = bArr.length;
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 0, bArr2, 0, length);
        return bArr2;
    }

    private final void zbo(Map.Entry entry) {
        zbvm zbk;
        zbtt zbttVar = (zbtt) entry.getKey();
        Object value = entry.getValue();
        boolean z = value instanceof zbuv;
        zbttVar.zbg();
        if (zbttVar.zbe() != zbwx.MESSAGE) {
            if (z) {
                throw new IllegalStateException("Lazy fields must be message-valued");
            }
            this.zba.put(zbttVar, zbn(value));
            return;
        }
        Object zbf = zbf(zbttVar);
        if (zbf == null) {
            this.zba.put(zbttVar, zbn(value));
            if (z) {
                this.zbd = true;
                return;
            }
            return;
        }
        if (!z) {
            if (zbf instanceof zbvr) {
                zbk = zbttVar.zbc((zbvr) zbf, (zbvr) value);
            } else {
                zbk = zbttVar.zbb(((zbvm) zbf).zbK(), (zbvm) value).zbk();
            }
            this.zba.put(zbttVar, zbk);
            return;
        }
        throw null;
    }

    private static boolean zbp(Map.Entry entry) {
        zbtt zbttVar = (zbtt) entry.getKey();
        if (zbttVar.zbe() != zbwx.MESSAGE) {
            return true;
        }
        zbttVar.zbg();
        Object value = entry.getValue();
        if (value instanceof zbvn) {
            return ((zbvn) value).zbp();
        }
        if (value instanceof zbuv) {
            return true;
        }
        throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
    }

    private static final int zbq(Map.Entry entry) {
        int i;
        int zbD;
        int zbD2;
        zbtt zbttVar = (zbtt) entry.getKey();
        Object value = entry.getValue();
        if (zbttVar.zbe() != zbwx.MESSAGE) {
            return zbb(zbttVar, value);
        }
        zbttVar.zbg();
        zbttVar.zbf();
        if (value instanceof zbuv) {
            ((zbtt) entry.getKey()).zba();
            int zbD3 = zbtk.zbD(8);
            i = zbD3 + zbD3;
            zbD = zbtk.zbD(16) + zbtk.zbD(32149011);
            int zbD4 = zbtk.zbD(24);
            int zba = ((zbuv) value).zba();
            zbD2 = zbD4 + zbtk.zbD(zba) + zba;
        } else {
            ((zbtt) entry.getKey()).zba();
            int zbD5 = zbtk.zbD(8);
            i = zbD5 + zbD5;
            zbD = zbtk.zbD(16) + zbtk.zbD(32149011);
            zbD2 = zbtk.zbD(24) + zbtk.zbA((zbvm) value);
        }
        return i + zbD + zbD2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zbtu) {
            return this.zba.equals(((zbtu) obj).zba);
        }
        return false;
    }

    public final int hashCode() {
        return this.zba.hashCode();
    }

    public final int zbc() {
        int zbc = this.zba.zbc();
        int i = 0;
        for (int i2 = 0; i2 < zbc; i2++) {
            i += zbq(this.zba.zbg(i2));
        }
        Iterator it = this.zba.zbd().iterator();
        while (it.hasNext()) {
            i += zbq((Map.Entry) it.next());
        }
        return i;
    }

    /* renamed from: zbd, reason: merged with bridge method [inline-methods] */
    public final zbtu clone() {
        zbtu zbtuVar = new zbtu();
        int zbc = this.zba.zbc();
        for (int i = 0; i < zbc; i++) {
            Map.Entry zbg = this.zba.zbg(i);
            zbtuVar.zbj((zbtt) ((zbwb) zbg).zba(), zbg.getValue());
        }
        for (Map.Entry entry : this.zba.zbd()) {
            zbtuVar.zbj((zbtt) entry.getKey(), entry.getValue());
        }
        zbtuVar.zbd = this.zbd;
        return zbtuVar;
    }

    public final Object zbf(zbtt zbttVar) {
        Object obj = this.zba.get(zbttVar);
        if (!(obj instanceof zbuv)) {
            return obj;
        }
        throw null;
    }

    public final Iterator zbg() {
        if (this.zba.isEmpty()) {
            return Collections.emptyIterator();
        }
        if (this.zbd) {
            return new zbuu(this.zba.entrySet().iterator());
        }
        return this.zba.entrySet().iterator();
    }

    public final void zbh() {
        if (this.zbc) {
            return;
        }
        int zbc = this.zba.zbc();
        for (int i = 0; i < zbc; i++) {
            Map.Entry zbg = this.zba.zbg(i);
            if (zbg.getValue() instanceof zbuf) {
                ((zbuf) zbg.getValue()).zbB();
            }
        }
        this.zba.zba();
        this.zbc = true;
    }

    public final void zbi(zbtu zbtuVar) {
        int zbc = zbtuVar.zba.zbc();
        for (int i = 0; i < zbc; i++) {
            zbo(zbtuVar.zba.zbg(i));
        }
        Iterator it = zbtuVar.zba.zbd().iterator();
        while (it.hasNext()) {
            zbo((Map.Entry) it.next());
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x002b, code lost:
    
        if ((r4 instanceof com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuh) == false) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0034, code lost:
    
        if ((r4 instanceof byte[]) == false) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0048, code lost:
    
        if (r0 == false) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0022, code lost:
    
        if ((r4 instanceof com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuv) == false) goto L32;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0018. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:9:0x004e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zbj(zbtt zbttVar, Object obj) {
        boolean z;
        zbttVar.zbg();
        zbttVar.zbd();
        byte[] bArr = zbuo.zbb;
        obj.getClass();
        zbww zbwwVar = zbww.DOUBLE;
        zbwx zbwxVar = zbwx.INT;
        switch (r0.zbb()) {
            case INT:
                z = obj instanceof Integer;
                break;
            case LONG:
                z = obj instanceof Long;
                break;
            case FLOAT:
                z = obj instanceof Float;
                break;
            case DOUBLE:
                z = obj instanceof Double;
                break;
            case BOOLEAN:
                z = obj instanceof Boolean;
                break;
            case STRING:
                z = obj instanceof String;
                break;
            case BYTE_STRING:
                if (!(obj instanceof zbtc)) {
                    break;
                }
                if (obj instanceof zbuv) {
                    this.zbd = true;
                }
                this.zba.put(zbttVar, obj);
                return;
            case ENUM:
                if (!(obj instanceof Integer)) {
                    break;
                }
                if (obj instanceof zbuv) {
                }
                this.zba.put(zbttVar, obj);
                return;
            case MESSAGE:
                if (!(obj instanceof zbvm)) {
                    break;
                }
                if (obj instanceof zbuv) {
                }
                this.zba.put(zbttVar, obj);
                return;
            default:
                zbttVar.zba();
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", 32149011, zbttVar.zbd().zbb(), obj.getClass().getName()));
        }
    }

    public final boolean zbl() {
        return this.zbc;
    }

    public final boolean zbm() {
        int zbc = this.zba.zbc();
        for (int i = 0; i < zbc; i++) {
            if (!zbp(this.zba.zbg(i))) {
                return false;
            }
        }
        Iterator it = this.zba.zbd().iterator();
        while (it.hasNext()) {
            if (!zbp((Map.Entry) it.next())) {
                return false;
            }
        }
        return true;
    }

    private zbtu(boolean z) {
        zbh();
        zbh();
    }
}
