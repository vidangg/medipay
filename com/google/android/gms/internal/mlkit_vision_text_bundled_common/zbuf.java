package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbtz;
import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
public abstract class zbuf<MessageType extends zbuf<MessageType, BuilderType>, BuilderType extends zbtz<MessageType, BuilderType>> extends zbsj<MessageType, BuilderType> {
    private static final Map zbb = new ConcurrentHashMap();
    private int zbd = -1;
    protected zbwm zbc = zbwm.zbc();

    /* JADX INFO: Access modifiers changed from: protected */
    public static Object zbA(zbvm zbvmVar, String str, Object[] objArr) {
        return new zbvw(zbvmVar, str, objArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void zbD(Class cls, zbuf zbufVar) {
        zbufVar.zbC();
        zbb.put(cls, zbufVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static final boolean zbF(zbuf zbufVar, boolean z) {
        byte byteValue = ((Byte) zbufVar.zbb(1, null, null)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        boolean zbk = zbvu.zba().zbb(zbufVar.getClass()).zbk(zbufVar);
        if (z) {
            zbufVar.zbb(2, true != zbk ? null : zbufVar, null);
        }
        return zbk;
    }

    private final int zbc(zbvx zbvxVar) {
        return zbvu.zba().zbb(getClass()).zba(this);
    }

    private static zbuf zbe(zbuf zbufVar, byte[] bArr, int i, int i2, zbtp zbtpVar) throws zbuq {
        if (i2 == 0) {
            return zbufVar;
        }
        zbuf zbt = zbufVar.zbt();
        try {
            zbvx zbb2 = zbvu.zba().zbb(zbt.getClass());
            zbb2.zbh(zbt, bArr, 0, i2, new zbsq(zbtpVar));
            zbb2.zbf(zbt);
            return zbt;
        } catch (zbuq e) {
            throw e;
        } catch (zbwk e2) {
            throw e2.zba();
        } catch (IOException e3) {
            if (e3.getCause() instanceof zbuq) {
                throw ((zbuq) e3.getCause());
            }
            throw new zbuq(e3);
        } catch (IndexOutOfBoundsException unused) {
            throw new zbuq("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
    }

    public static zbud zbr(zbvm zbvmVar, Object obj, zbvm zbvmVar2, zbui zbuiVar, int i, zbww zbwwVar, Class cls) {
        return new zbud(zbvmVar, obj, zbvmVar2, new zbuc(null, 32149011, zbwwVar, false, false), cls);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zbuf zbs(Class cls) {
        Map map = zbb;
        zbuf zbufVar = (zbuf) map.get(cls);
        if (zbufVar == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                zbufVar = (zbuf) map.get(cls);
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException("Class initialization cannot fail.", e);
            }
        }
        if (zbufVar == null) {
            zbufVar = (zbuf) ((zbuf) zbws.zbe(cls)).zbb(6, null, null);
            if (zbufVar == null) {
                throw new IllegalStateException();
            }
            map.put(cls, zbufVar);
        }
        return zbufVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static zbuf zbu(zbuf zbufVar, byte[] bArr, zbtp zbtpVar) throws zbuq {
        zbuf zbe = zbe(zbufVar, bArr, 0, bArr.length, zbtpVar);
        if (zbe == null || zbF(zbe, true)) {
            return zbe;
        }
        throw new zbwk(zbe).zba();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static zbuk zbv() {
        return zbtw.zbf();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static zbul zbw() {
        return zbug.zbf();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static zbum zbx() {
        return zbva.zbf();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static zbun zby() {
        return zbvv.zbe();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object zbz(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e);
        } catch (InvocationTargetException e2) {
            Throwable cause = e2.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            if (cause instanceof Error) {
                throw ((Error) cause);
            }
            throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return zbvu.zba().zbb(getClass()).zbj(this, (zbuf) obj);
    }

    public final int hashCode() {
        if (zbG()) {
            return zbn();
        }
        int i = this.zba;
        if (i != 0) {
            return i;
        }
        int zbn = zbn();
        this.zba = zbn;
        return zbn;
    }

    public final String toString() {
        return zbvo.zba(this, super.toString());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zbB() {
        zbvu.zba().zbb(getClass()).zbf(this);
        zbC();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zbC() {
        this.zbd &= Integer.MAX_VALUE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zbE(int i) {
        this.zbd = (this.zbd & Integer.MIN_VALUE) | Integer.MAX_VALUE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zbG() {
        return (this.zbd & Integer.MIN_VALUE) != 0;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbvm
    public final /* synthetic */ zbvl zbJ() {
        return (zbtz) zbb(5, null, null);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbvm
    public final /* synthetic */ zbvl zbK() {
        zbtz zbtzVar = (zbtz) zbb(5, null, null);
        zbtzVar.zbh(this);
        return zbtzVar;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbvm
    public final void zbL(zbtk zbtkVar) throws IOException {
        zbvu.zba().zbb(getClass()).zbi(this, zbtl.zba(zbtkVar));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract Object zbb(int i, Object obj, Object obj2);

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbsj
    final int zbj(zbvx zbvxVar) {
        if (zbG()) {
            int zba = zbvxVar.zba(this);
            if (zba >= 0) {
                return zba;
            }
            throw new IllegalStateException("serialized size must be non-negative, was " + zba);
        }
        int i = this.zbd & Integer.MAX_VALUE;
        if (i != Integer.MAX_VALUE) {
            return i;
        }
        int zba2 = zbvxVar.zba(this);
        if (zba2 >= 0) {
            this.zbd = (this.zbd & Integer.MIN_VALUE) | zba2;
            return zba2;
        }
        throw new IllegalStateException("serialized size must be non-negative, was " + zba2);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbvn
    public final /* synthetic */ zbvm zbm() {
        return (zbuf) zbb(6, null, null);
    }

    final int zbn() {
        return zbvu.zba().zbb(getClass()).zbb(this);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbvn
    public final boolean zbp() {
        return zbF(this, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final zbtz zbq() {
        return (zbtz) zbb(5, null, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zbuf zbt() {
        return (zbuf) zbb(4, null, null);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbvm
    public final int zbo() {
        int i;
        if (zbG()) {
            i = zbc(null);
            if (i < 0) {
                throw new IllegalStateException("serialized size must be non-negative, was " + i);
            }
        } else {
            i = this.zbd & Integer.MAX_VALUE;
            if (i == Integer.MAX_VALUE) {
                i = zbc(null);
                if (i >= 0) {
                    this.zbd = (this.zbd & Integer.MIN_VALUE) | i;
                } else {
                    throw new IllegalStateException("serialized size must be non-negative, was " + i);
                }
            }
        }
        return i;
    }
}
