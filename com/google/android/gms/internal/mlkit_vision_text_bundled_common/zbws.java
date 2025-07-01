package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import libcore.io.Memory;
import sun.misc.Unsafe;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
final class zbws {
    static final long zba;
    static final boolean zbb;
    private static final Unsafe zbc;
    private static final Class zbd;
    private static final boolean zbe;
    private static final zbwr zbf;
    private static final boolean zbg;
    private static final boolean zbh;

    /* JADX WARN: Removed duplicated region for block: B:15:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x006a  */
    static {
        boolean z;
        zbwr zbwrVar;
        boolean z2;
        Field zbB;
        zbwr zbwrVar2;
        Unsafe zbg2 = zbg();
        zbc = zbg2;
        int i = zbsm.zba;
        zbd = Memory.class;
        boolean zbv = zbv(Long.TYPE);
        zbe = zbv;
        boolean zbv2 = zbv(Integer.TYPE);
        zbwr zbwrVar3 = null;
        if (zbg2 != null) {
            if (zbv) {
                zbwrVar3 = new zbwq(zbg2);
            } else if (zbv2) {
                zbwrVar3 = new zbwp(zbg2);
            }
        }
        zbf = zbwrVar3;
        if (zbwrVar3 != null) {
            try {
                Class<?> cls = zbwrVar3.zba.getClass();
                cls.getMethod("objectFieldOffset", Field.class);
                cls.getMethod("getLong", Object.class, Long.TYPE);
            } catch (Throwable th) {
                zbh(th);
            }
            if (zbB() != null) {
                z = true;
                zbg = z;
                zbwrVar = zbf;
                if (zbwrVar != null) {
                    try {
                        Class<?> cls2 = zbwrVar.zba.getClass();
                        cls2.getMethod("objectFieldOffset", Field.class);
                        cls2.getMethod("arrayBaseOffset", Class.class);
                        cls2.getMethod("arrayIndexScale", Class.class);
                        cls2.getMethod("getInt", Object.class, Long.TYPE);
                        cls2.getMethod("putInt", Object.class, Long.TYPE, Integer.TYPE);
                        cls2.getMethod("getLong", Object.class, Long.TYPE);
                        cls2.getMethod("putLong", Object.class, Long.TYPE, Long.TYPE);
                        cls2.getMethod("getObject", Object.class, Long.TYPE);
                        cls2.getMethod("putObject", Object.class, Long.TYPE, Object.class);
                        z2 = true;
                    } catch (Throwable th2) {
                        zbh(th2);
                    }
                    zbh = z2;
                    zba = zbz(byte[].class);
                    zbz(boolean[].class);
                    zbA(boolean[].class);
                    zbz(int[].class);
                    zbA(int[].class);
                    zbz(long[].class);
                    zbA(long[].class);
                    zbz(float[].class);
                    zbA(float[].class);
                    zbz(double[].class);
                    zbA(double[].class);
                    zbz(Object[].class);
                    zbA(Object[].class);
                    zbB = zbB();
                    if (zbB != null && (zbwrVar2 = zbf) != null) {
                        zbwrVar2.zba.objectFieldOffset(zbB);
                    }
                    zbb = ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN;
                }
                z2 = false;
                zbh = z2;
                zba = zbz(byte[].class);
                zbz(boolean[].class);
                zbA(boolean[].class);
                zbz(int[].class);
                zbA(int[].class);
                zbz(long[].class);
                zbA(long[].class);
                zbz(float[].class);
                zbA(float[].class);
                zbz(double[].class);
                zbA(double[].class);
                zbz(Object[].class);
                zbA(Object[].class);
                zbB = zbB();
                if (zbB != null) {
                    zbwrVar2.zba.objectFieldOffset(zbB);
                }
                zbb = ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN;
            }
        }
        z = false;
        zbg = z;
        zbwrVar = zbf;
        if (zbwrVar != null) {
        }
        z2 = false;
        zbh = z2;
        zba = zbz(byte[].class);
        zbz(boolean[].class);
        zbA(boolean[].class);
        zbz(int[].class);
        zbA(int[].class);
        zbz(long[].class);
        zbA(long[].class);
        zbz(float[].class);
        zbA(float[].class);
        zbz(double[].class);
        zbA(double[].class);
        zbz(Object[].class);
        zbA(Object[].class);
        zbB = zbB();
        if (zbB != null) {
        }
        zbb = ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN;
    }

    private zbws() {
    }

    private static int zbA(Class cls) {
        if (zbh) {
            return zbf.zba.arrayIndexScale(cls);
        }
        return -1;
    }

    private static Field zbB() {
        int i = zbsm.zba;
        Field zbC = zbC(Buffer.class, "effectiveDirectAddress");
        if (zbC != null) {
            return zbC;
        }
        Field zbC2 = zbC(Buffer.class, "address");
        if (zbC2 == null || zbC2.getType() != Long.TYPE) {
            return null;
        }
        return zbC2;
    }

    private static Field zbC(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zbD(Object obj, long j, byte b) {
        zbwr zbwrVar = zbf;
        long j2 = (-4) & j;
        int i = zbwrVar.zba.getInt(obj, j2);
        int i2 = ((~((int) j)) & 3) << 3;
        zbwrVar.zba.putInt(obj, j2, ((255 & b) << i2) | (i & (~(255 << i2))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zbE(Object obj, long j, byte b) {
        zbwr zbwrVar = zbf;
        long j2 = (-4) & j;
        int i = (((int) j) & 3) << 3;
        zbwrVar.zba.putInt(obj, j2, ((255 & b) << i) | (zbwrVar.zba.getInt(obj, j2) & (~(255 << i))));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static double zba(Object obj, long j) {
        return zbf.zba(obj, j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static float zbb(Object obj, long j) {
        return zbf.zbb(obj, j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zbc(Object obj, long j) {
        return zbf.zba.getInt(obj, j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long zbd(Object obj, long j) {
        return zbf.zba.getLong(obj, j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object zbe(Class cls) {
        try {
            return zbc.allocateInstance(cls);
        } catch (InstantiationException e) {
            throw new IllegalStateException(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object zbf(Object obj, long j) {
        return zbf.zba.getObject(obj, j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Unsafe zbg() {
        try {
            return (Unsafe) AccessController.doPrivileged(new zbwo());
        } catch (Throwable unused) {
            return null;
        }
    }

    static /* bridge */ /* synthetic */ void zbh(Throwable th) {
        Logger.getLogger(zbws.class.getName()).logp(Level.WARNING, "com.google.protobuf.UnsafeUtil", "logMissingMethod", "platform method missing - proto runtime falling back to safer methods: ".concat(th.toString()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zbm(Object obj, long j, boolean z) {
        zbf.zbc(obj, j, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zbn(byte[] bArr, long j, byte b) {
        zbf.zbd(bArr, zba + j, b);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zbo(Object obj, long j, double d) {
        zbf.zbe(obj, j, d);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zbp(Object obj, long j, float f) {
        zbf.zbf(obj, j, f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zbq(Object obj, long j, int i) {
        zbf.zba.putInt(obj, j, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zbr(Object obj, long j, long j2) {
        zbf.zba.putLong(obj, j, j2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zbs(Object obj, long j, Object obj2) {
        zbf.zba.putObject(obj, j, obj2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ boolean zbt(Object obj, long j) {
        return ((byte) ((zbf.zba.getInt(obj, (-4) & j) >>> ((int) (((~j) & 3) << 3))) & 255)) != 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ boolean zbu(Object obj, long j) {
        return ((byte) ((zbf.zba.getInt(obj, (-4) & j) >>> ((int) ((j & 3) << 3))) & 255)) != 0;
    }

    static boolean zbv(Class cls) {
        int i = zbsm.zba;
        try {
            Class cls2 = zbd;
            cls2.getMethod("peekLong", cls, Boolean.TYPE);
            cls2.getMethod("pokeLong", cls, Long.TYPE, Boolean.TYPE);
            cls2.getMethod("pokeInt", cls, Integer.TYPE, Boolean.TYPE);
            cls2.getMethod("peekInt", cls, Boolean.TYPE);
            cls2.getMethod("pokeByte", cls, Byte.TYPE);
            cls2.getMethod("peekByte", cls);
            cls2.getMethod("pokeByteArray", cls, byte[].class, Integer.TYPE, Integer.TYPE);
            cls2.getMethod("peekByteArray", cls, byte[].class, Integer.TYPE, Integer.TYPE);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean zbw(Object obj, long j) {
        return zbf.zbg(obj, j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean zbx() {
        return zbh;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean zby() {
        return zbg;
    }

    private static int zbz(Class cls) {
        if (zbh) {
            return zbf.zba.arrayBaseOffset(cls);
        }
        return -1;
    }
}
