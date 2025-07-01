package com.google.android.gms.internal.mlkit_vision_face_bundled;

import com.google.android.gms.internal.mlkit_vision_face_bundled.zzuq;
import com.google.android.gms.internal.mlkit_vision_face_bundled.zzuw;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: com.google.mlkit:face-detection@@16.1.7 */
/* loaded from: classes3.dex */
public abstract class zzuw<MessageType extends zzuw<MessageType, BuilderType>, BuilderType extends zzuq<MessageType, BuilderType>> extends zztf<MessageType, BuilderType> {
    private static final Map zzb = new ConcurrentHashMap();
    private int zzd = -1;
    protected zzww zzc = zzww.zzc();

    /* JADX INFO: Access modifiers changed from: protected */
    public static zzvb zzA() {
        return zzwf.zze();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object zzB(Method method, Object obj, Object... objArr) {
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

    /* JADX INFO: Access modifiers changed from: protected */
    public static Object zzC(zzvw zzvwVar, String str, Object[] objArr) {
        return new zzwg(zzvwVar, str, objArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void zzF(Class cls, zzuw zzuwVar) {
        zzuwVar.zzE();
        zzb.put(cls, zzuwVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static final boolean zzH(zzuw zzuwVar, boolean z) {
        byte byteValue = ((Byte) zzuwVar.zzf(1, null, null)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        boolean zzk = zzwe.zza().zzb(zzuwVar.getClass()).zzk(zzuwVar);
        if (z) {
            zzuwVar.zzf(2, true != zzk ? null : zzuwVar, null);
        }
        return zzk;
    }

    private final int zzb(zzwh zzwhVar) {
        return zzwe.zza().zzb(getClass()).zza(this);
    }

    private static zzuw zzd(zzuw zzuwVar, byte[] bArr, int i, int i2, zzuh zzuhVar) throws zzve {
        if (i2 == 0) {
            return zzuwVar;
        }
        zzuw zzy = zzuwVar.zzy();
        try {
            zzwh zzb2 = zzwe.zza().zzb(zzy.getClass());
            zzb2.zzh(zzy, bArr, 0, i2, new zztj(zzuhVar));
            zzb2.zzf(zzy);
            return zzy;
        } catch (zzve e) {
            throw e;
        } catch (zzwu e2) {
            throw e2.zza();
        } catch (IOException e3) {
            if (e3.getCause() instanceof zzve) {
                throw ((zzve) e3.getCause());
            }
            throw new zzve(e3);
        } catch (IndexOutOfBoundsException unused) {
            throw new zzve("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
    }

    public static zzuu zzw(zzvw zzvwVar, zzvw zzvwVar2, zzuz zzuzVar, int i, zzxg zzxgVar, boolean z, Class cls) {
        return new zzuu(zzvwVar, Collections.emptyList(), zzvwVar2, new zzut(null, 202056002, zzxgVar, true, false), cls);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzuw zzx(Class cls) {
        Map map = zzb;
        zzuw zzuwVar = (zzuw) map.get(cls);
        if (zzuwVar == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                zzuwVar = (zzuw) map.get(cls);
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException("Class initialization cannot fail.", e);
            }
        }
        if (zzuwVar == null) {
            zzuwVar = (zzuw) ((zzuw) zzxc.zze(cls)).zzf(6, null, null);
            if (zzuwVar == null) {
                throw new IllegalStateException();
            }
            map.put(cls, zzuwVar);
        }
        return zzuwVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static zzuw zzz(zzuw zzuwVar, byte[] bArr, zzuh zzuhVar) throws zzve {
        zzuw zzd = zzd(zzuwVar, bArr, 0, bArr.length, zzuhVar);
        if (zzd == null || zzH(zzd, true)) {
            return zzd;
        }
        throw new zzwu(zzd).zza();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return zzwe.zza().zzb(getClass()).zzj(this, (zzuw) obj);
    }

    public final int hashCode() {
        if (zzI()) {
            return zzs();
        }
        int i = this.zza;
        if (i != 0) {
            return i;
        }
        int zzs = zzs();
        this.zza = zzs;
        return zzs;
    }

    public final String toString() {
        return zzvy.zza(this, super.toString());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzD() {
        zzwe.zza().zzb(getClass()).zzf(this);
        zzE();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzE() {
        this.zzd &= Integer.MAX_VALUE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzG(int i) {
        this.zzd = (this.zzd & Integer.MIN_VALUE) | Integer.MAX_VALUE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzI() {
        return (this.zzd & Integer.MIN_VALUE) != 0;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzvw
    public final /* synthetic */ zzvv zzK() {
        return (zzuq) zzf(5, null, null);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzvw
    public final void zzL(zzuc zzucVar) throws IOException {
        zzwe.zza().zzb(getClass()).zzi(this, zzud.zza(zzucVar));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract Object zzf(int i, Object obj, Object obj2);

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zztf
    final int zzp(zzwh zzwhVar) {
        if (zzI()) {
            int zza = zzwhVar.zza(this);
            if (zza >= 0) {
                return zza;
            }
            throw new IllegalStateException("serialized size must be non-negative, was " + zza);
        }
        int i = this.zzd & Integer.MAX_VALUE;
        if (i != Integer.MAX_VALUE) {
            return i;
        }
        int zza2 = zzwhVar.zza(this);
        if (zza2 >= 0) {
            this.zzd = (this.zzd & Integer.MIN_VALUE) | zza2;
            return zza2;
        }
        throw new IllegalStateException("serialized size must be non-negative, was " + zza2);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzvx
    public final /* synthetic */ zzvw zzq() {
        return (zzuw) zzf(6, null, null);
    }

    final int zzs() {
        return zzwe.zza().zzb(getClass()).zzb(this);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzvx
    public final boolean zzt() {
        return zzH(this, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final zzuq zzv() {
        return (zzuq) zzf(5, null, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzuw zzy() {
        return (zzuw) zzf(4, null, null);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzvw
    public final int zzu() {
        int i;
        if (zzI()) {
            i = zzb(null);
            if (i < 0) {
                throw new IllegalStateException("serialized size must be non-negative, was " + i);
            }
        } else {
            i = this.zzd & Integer.MAX_VALUE;
            if (i == Integer.MAX_VALUE) {
                i = zzb(null);
                if (i >= 0) {
                    this.zzd = (this.zzd & Integer.MIN_VALUE) | i;
                } else {
                    throw new IllegalStateException("serialized size must be non-negative, was " + i);
                }
            }
        }
        return i;
    }
}
