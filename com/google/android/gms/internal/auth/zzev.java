package com.google.android.gms.internal.auth;

import com.google.android.gms.internal.auth.zzet;
import com.google.android.gms.internal.auth.zzev;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: com.google.android.gms:play-services-auth-base@@18.0.10 */
/* loaded from: classes3.dex */
public abstract class zzev<MessageType extends zzev<MessageType, BuilderType>, BuilderType extends zzet<MessageType, BuilderType>> extends zzdq<MessageType, BuilderType> {
    private static final Map zzb = new ConcurrentHashMap();
    private int zzd = -1;
    protected zzha zzc = zzha.zza();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzev zzb(Class cls) {
        Map map = zzb;
        zzev zzevVar = (zzev) map.get(cls);
        if (zzevVar == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                zzevVar = (zzev) map.get(cls);
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException("Class initialization cannot fail.", e);
            }
        }
        if (zzevVar == null) {
            zzevVar = (zzev) ((zzev) zzhj.zze(cls)).zzn(6, null, null);
            if (zzevVar == null) {
                throw new IllegalStateException();
            }
            map.put(cls, zzevVar);
        }
        return zzevVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x003c, code lost:
    
        if (r2 != false) goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static zzev zzd(zzev zzevVar, byte[] bArr) throws zzfb {
        zzev zzo = zzo(zzevVar, bArr, 0, bArr.length, zzel.zza);
        if (zzo != null) {
            boolean booleanValue = Boolean.TRUE.booleanValue();
            byte byteValue = ((Byte) zzo.zzn(1, null, null)).byteValue();
            if (byteValue != 1) {
                if (byteValue != 0) {
                    boolean zzi = zzgf.zza().zzb(zzo.getClass()).zzi(zzo);
                    if (booleanValue) {
                        zzo.zzn(2, true != zzi ? null : zzo, null);
                    }
                }
                zzfb zza = new zzgy(zzo).zza();
                zza.zze(zzo);
                throw zza;
            }
        }
        return zzo;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static zzez zzf() {
        return zzgg.zze();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object zzg(Method method, Object obj, Object... objArr) {
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
    public static Object zzh(zzfx zzfxVar, String str, Object[] objArr) {
        return new zzgh(zzfxVar, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001a", objArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void zzk(Class cls, zzev zzevVar) {
        zzevVar.zzj();
        zzb.put(cls, zzevVar);
    }

    private static zzev zzo(zzev zzevVar, byte[] bArr, int i, int i2, zzel zzelVar) throws zzfb {
        zzev zzc = zzevVar.zzc();
        try {
            zzgi zzb2 = zzgf.zza().zzb(zzc.getClass());
            zzb2.zzg(zzc, bArr, 0, i2, new zzdt(zzelVar));
            zzb2.zze(zzc);
            return zzc;
        } catch (zzfb e) {
            e.zze(zzc);
            throw e;
        } catch (zzgy e2) {
            zzfb zza = e2.zza();
            zza.zze(zzc);
            throw zza;
        } catch (IOException e3) {
            if (e3.getCause() instanceof zzfb) {
                throw ((zzfb) e3.getCause());
            }
            zzfb zzfbVar = new zzfb(e3);
            zzfbVar.zze(zzc);
            throw zzfbVar;
        } catch (IndexOutOfBoundsException unused) {
            zzfb zzf = zzfb.zzf();
            zzf.zze(zzc);
            throw zzf;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return zzgf.zza().zzb(getClass()).zzh(this, (zzev) obj);
    }

    public final int hashCode() {
        if (zzm()) {
            return zza();
        }
        int i = this.zza;
        if (i != 0) {
            return i;
        }
        int zza = zza();
        this.zza = zza;
        return zza;
    }

    public final String toString() {
        return zzfz.zza(this, super.toString());
    }

    final int zza() {
        return zzgf.zza().zzb(getClass()).zza(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzev zzc() {
        return (zzev) zzn(4, null, null);
    }

    @Override // com.google.android.gms.internal.auth.zzfy
    public final /* synthetic */ zzfx zze() {
        return (zzev) zzn(6, null, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzi() {
        zzgf.zza().zzb(getClass()).zze(this);
        zzj();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzj() {
        this.zzd &= Integer.MAX_VALUE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzl(int i) {
        this.zzd = (this.zzd & Integer.MIN_VALUE) | Integer.MAX_VALUE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzm() {
        return (this.zzd & Integer.MIN_VALUE) != 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract Object zzn(int i, Object obj, Object obj2);
}
