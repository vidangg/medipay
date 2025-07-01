package com.google.android.gms.internal.mlkit_vision_face_bundled;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.mlkit:face-detection@@16.1.7 */
/* loaded from: classes3.dex */
final class zzum {
    private static final zzum zzb = new zzum(true);
    final zzwr zza = new zzwk();
    private boolean zzc;

    private zzum() {
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:13:0x003e. Please report as an issue. */
    public static int zza(zzul zzulVar, Object obj) {
        int zzd;
        int zzz;
        zzxg zzb2 = zzulVar.zzb();
        zzulVar.zza();
        zzulVar.zze();
        List list = (List) obj;
        int size = list.size();
        zzulVar.zzd();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            Object obj2 = list.get(i2);
            int zzz2 = zzuc.zzz(1616448016);
            if (zzb2 == zzxg.GROUP) {
                zzvw zzvwVar = (zzvw) obj2;
                byte[] bArr = zzvc.zzb;
                if (zzvwVar instanceof zztg) {
                    throw null;
                }
                zzz2 += zzz2;
            }
            zzxh zzxhVar = zzxh.INT;
            int i3 = 4;
            switch (zzb2) {
                case DOUBLE:
                    ((Double) obj2).doubleValue();
                    i3 = 8;
                    i += zzz2 + i3;
                case FLOAT:
                    ((Float) obj2).floatValue();
                    i += zzz2 + i3;
                case INT64:
                    i3 = zzuc.zzA(((Long) obj2).longValue());
                    i += zzz2 + i3;
                case UINT64:
                    i3 = zzuc.zzA(((Long) obj2).longValue());
                    i += zzz2 + i3;
                case INT32:
                    i3 = zzuc.zzA(((Integer) obj2).intValue());
                    i += zzz2 + i3;
                case FIXED64:
                    ((Long) obj2).longValue();
                    i3 = 8;
                    i += zzz2 + i3;
                case FIXED32:
                    ((Integer) obj2).intValue();
                    i += zzz2 + i3;
                case BOOL:
                    ((Boolean) obj2).booleanValue();
                    i3 = 1;
                    i += zzz2 + i3;
                case STRING:
                    if (obj2 instanceof zztu) {
                        zzd = ((zztu) obj2).zzd();
                        zzz = zzuc.zzz(zzd);
                        i3 = zzz + zzd;
                        i += zzz2 + i3;
                    } else {
                        i3 = zzuc.zzy((String) obj2);
                        i += zzz2 + i3;
                    }
                case GROUP:
                    i3 = ((zzvw) obj2).zzu();
                    i += zzz2 + i3;
                case MESSAGE:
                    if (obj2 instanceof zzvg) {
                        zzd = ((zzvg) obj2).zza();
                        zzz = zzuc.zzz(zzd);
                    } else {
                        zzd = ((zzvw) obj2).zzu();
                        zzz = zzuc.zzz(zzd);
                    }
                    i3 = zzz + zzd;
                    i += zzz2 + i3;
                case BYTES:
                    if (obj2 instanceof zztu) {
                        zzd = ((zztu) obj2).zzd();
                        zzz = zzuc.zzz(zzd);
                    } else {
                        zzd = ((byte[]) obj2).length;
                        zzz = zzuc.zzz(zzd);
                    }
                    i3 = zzz + zzd;
                    i += zzz2 + i3;
                case UINT32:
                    i3 = zzuc.zzz(((Integer) obj2).intValue());
                    i += zzz2 + i3;
                case ENUM:
                    if (obj2 instanceof zzuy) {
                        i3 = zzuc.zzA(((zzuy) obj2).zza());
                    } else {
                        i3 = zzuc.zzA(((Integer) obj2).intValue());
                    }
                    i += zzz2 + i3;
                case SFIXED32:
                    ((Integer) obj2).intValue();
                    i += zzz2 + i3;
                case SFIXED64:
                    ((Long) obj2).longValue();
                    i3 = 8;
                    i += zzz2 + i3;
                case SINT32:
                    int intValue = ((Integer) obj2).intValue();
                    i3 = zzuc.zzz((intValue >> 31) ^ (intValue + intValue));
                    i += zzz2 + i3;
                case SINT64:
                    long longValue = ((Long) obj2).longValue();
                    i3 = zzuc.zzA((longValue >> 63) ^ (longValue + longValue));
                    i += zzz2 + i3;
                default:
                    throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
            }
        }
        return i;
    }

    public static zzum zzd() {
        return zzb;
    }

    private final void zzm(Map.Entry entry) {
        zzul zzulVar = (zzul) entry.getKey();
        Object value = entry.getValue();
        boolean z = value instanceof zzvg;
        zzulVar.zze();
        if (z) {
            throw new IllegalStateException("Lazy fields can not be repeated");
        }
        Object zze = zze(zzulVar);
        List list = (List) value;
        int size = list.size();
        if (zze == null) {
            zze = new ArrayList(size);
        }
        List list2 = (List) zze;
        for (int i = 0; i < size; i++) {
            Object obj = list.get(i);
            if (obj instanceof zzwb) {
                obj = ((zzwb) obj).zzb();
            } else if (obj instanceof byte[]) {
                byte[] bArr = (byte[]) obj;
                int length = bArr.length;
                Object obj2 = new byte[length];
                System.arraycopy(bArr, 0, obj2, 0, length);
                obj = obj2;
            }
            list2.add(obj);
        }
        this.zza.put(zzulVar, zze);
    }

    private static boolean zzn(Map.Entry entry) {
        zzul zzulVar = (zzul) entry.getKey();
        if (zzulVar.zzc() != zzxh.MESSAGE) {
            return true;
        }
        zzulVar.zze();
        List list = (List) entry.getValue();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Object obj = list.get(i);
            if (obj instanceof zzvx) {
                if (!((zzvx) obj).zzt()) {
                    return false;
                }
            } else if (!(obj instanceof zzvg)) {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
        }
        return true;
    }

    private static final int zzo(Map.Entry entry) {
        zzul zzulVar = (zzul) entry.getKey();
        Object value = entry.getValue();
        if (zzulVar.zzc() == zzxh.MESSAGE) {
            zzulVar.zze();
        }
        return zza(zzulVar, value);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0015. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final void zzp(zzul zzulVar, Object obj) {
        boolean z;
        zzulVar.zzb();
        byte[] bArr = zzvc.zzb;
        obj.getClass();
        zzxg zzxgVar = zzxg.DOUBLE;
        zzxh zzxhVar = zzxh.INT;
        switch (r0.zza()) {
            case INT:
                z = obj instanceof Integer;
                if (z) {
                    return;
                }
                zzulVar.zza();
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", 202056002, zzulVar.zzb().zza(), obj.getClass().getName()));
            case LONG:
                z = obj instanceof Long;
                if (z) {
                }
                zzulVar.zza();
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", 202056002, zzulVar.zzb().zza(), obj.getClass().getName()));
            case FLOAT:
                z = obj instanceof Float;
                if (z) {
                }
                zzulVar.zza();
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", 202056002, zzulVar.zzb().zza(), obj.getClass().getName()));
            case DOUBLE:
                z = obj instanceof Double;
                if (z) {
                }
                zzulVar.zza();
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", 202056002, zzulVar.zzb().zza(), obj.getClass().getName()));
            case BOOLEAN:
                z = obj instanceof Boolean;
                if (z) {
                }
                zzulVar.zza();
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", 202056002, zzulVar.zzb().zza(), obj.getClass().getName()));
            case STRING:
                z = obj instanceof String;
                if (z) {
                }
                zzulVar.zza();
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", 202056002, zzulVar.zzb().zza(), obj.getClass().getName()));
            case BYTE_STRING:
                if ((obj instanceof zztu) || (obj instanceof byte[])) {
                    return;
                }
                zzulVar.zza();
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", 202056002, zzulVar.zzb().zza(), obj.getClass().getName()));
            case ENUM:
                if ((obj instanceof Integer) || (obj instanceof zzuy)) {
                    return;
                }
                zzulVar.zza();
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", 202056002, zzulVar.zzb().zza(), obj.getClass().getName()));
            case MESSAGE:
                if ((obj instanceof zzvw) || (obj instanceof zzvg)) {
                    return;
                }
                zzulVar.zza();
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", 202056002, zzulVar.zzb().zza(), obj.getClass().getName()));
            default:
                zzulVar.zza();
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", 202056002, zzulVar.zzb().zza(), obj.getClass().getName()));
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzum) {
            return this.zza.equals(((zzum) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final int zzb() {
        int zzc = this.zza.zzc();
        int i = 0;
        for (int i2 = 0; i2 < zzc; i2++) {
            i += zzo(this.zza.zzg(i2));
        }
        Iterator it = this.zza.zzd().iterator();
        while (it.hasNext()) {
            i += zzo((Map.Entry) it.next());
        }
        return i;
    }

    /* renamed from: zzc, reason: merged with bridge method [inline-methods] */
    public final zzum clone() {
        zzum zzumVar = new zzum();
        int zzc = this.zza.zzc();
        for (int i = 0; i < zzc; i++) {
            Map.Entry zzg = this.zza.zzg(i);
            zzumVar.zzj((zzul) ((zzwl) zzg).zza(), zzg.getValue());
        }
        for (Map.Entry entry : this.zza.zzd()) {
            zzumVar.zzj((zzul) entry.getKey(), entry.getValue());
        }
        return zzumVar;
    }

    public final Object zze(zzul zzulVar) {
        Object obj = this.zza.get(zzulVar);
        if (!(obj instanceof zzvg)) {
            return obj;
        }
        throw null;
    }

    public final Iterator zzf() {
        if (this.zza.isEmpty()) {
            return Collections.emptyIterator();
        }
        return this.zza.entrySet().iterator();
    }

    public final void zzg(zzul zzulVar, Object obj) {
        List list;
        zzp(zzulVar, obj);
        Object zze = zze(zzulVar);
        if (zze == null) {
            list = new ArrayList();
            this.zza.put(zzulVar, list);
        } else {
            list = (List) zze;
        }
        list.add(obj);
    }

    public final void zzh() {
        if (this.zzc) {
            return;
        }
        int zzc = this.zza.zzc();
        for (int i = 0; i < zzc; i++) {
            Map.Entry zzg = this.zza.zzg(i);
            if (zzg.getValue() instanceof zzuw) {
                ((zzuw) zzg.getValue()).zzD();
            }
        }
        this.zza.zza();
        this.zzc = true;
    }

    public final void zzi(zzum zzumVar) {
        int zzc = zzumVar.zza.zzc();
        for (int i = 0; i < zzc; i++) {
            zzm(zzumVar.zza.zzg(i));
        }
        Iterator it = zzumVar.zza.zzd().iterator();
        while (it.hasNext()) {
            zzm((Map.Entry) it.next());
        }
    }

    public final void zzj(zzul zzulVar, Object obj) {
        zzulVar.zze();
        if (!(obj instanceof List)) {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
        List list = (List) obj;
        int size = list.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            Object obj2 = list.get(i);
            zzp(zzulVar, obj2);
            arrayList.add(obj2);
        }
        this.zza.put(zzulVar, arrayList);
    }

    public final boolean zzk() {
        return this.zzc;
    }

    public final boolean zzl() {
        int zzc = this.zza.zzc();
        for (int i = 0; i < zzc; i++) {
            if (!zzn(this.zza.zzg(i))) {
                return false;
            }
        }
        Iterator it = this.zza.zzd().iterator();
        while (it.hasNext()) {
            if (!zzn((Map.Entry) it.next())) {
                return false;
            }
        }
        return true;
    }

    private zzum(boolean z) {
        zzh();
        zzh();
    }
}
