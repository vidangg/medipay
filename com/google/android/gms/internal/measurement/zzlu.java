package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-base@@22.4.0 */
/* loaded from: classes3.dex */
final class zzlu {
    private static final zzlu zzb = new zzlu(true);
    final zzoa zza = new zznv();
    private boolean zzc;
    private boolean zzd;

    private zzlu() {
    }

    static int zza(zzop zzopVar, int i, Object obj) {
        zzlk.zzz(i << 3);
        if (zzop.GROUP == null) {
            zznh zznhVar = (zznh) obj;
            byte[] bArr = zzmk.zzb;
            if (zznhVar instanceof zzkp) {
                throw null;
            }
        }
        zzoq zzoqVar = zzoq.INT;
        throw null;
    }

    public static int zzb(zzlt zzltVar, Object obj) {
        zzop zzb2 = zzltVar.zzb();
        int zza = zzltVar.zza();
        if (zzltVar.zze()) {
            List list = (List) obj;
            int size = list.size();
            if (!zzltVar.zzd()) {
                int i = 0;
                for (int i2 = 0; i2 < size; i2++) {
                    i += zza(zzb2, zza, list.get(i2));
                }
                return i;
            }
            if (list.isEmpty()) {
                return 0;
            }
            if (size > 0) {
                list.get(0);
                zzop zzopVar = zzop.DOUBLE;
                zzoq zzoqVar = zzoq.INT;
                throw null;
            }
            return zzlk.zzz(zza << 3) + zzlk.zzz(0);
        }
        return zza(zzb2, zza, obj);
    }

    public static zzlu zzd() {
        return zzb;
    }

    private static boolean zzi(Map.Entry entry) {
        zzlt zzltVar = (zzlt) entry.getKey();
        if (zzltVar.zzc() != zzoq.MESSAGE) {
            return true;
        }
        if (zzltVar.zze()) {
            List list = (List) entry.getValue();
            int size = list.size();
            for (int i = 0; i < size; i++) {
                if (!zzj(list.get(i))) {
                    return false;
                }
            }
            return true;
        }
        return zzj(entry.getValue());
    }

    private static boolean zzj(Object obj) {
        if (obj instanceof zzni) {
            return ((zzni) obj).zzcD();
        }
        if (obj instanceof zzmr) {
            return true;
        }
        throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
    }

    private static final int zzk(Map.Entry entry) {
        int i;
        int zzz;
        int zzz2;
        int zzcf;
        int zzz3;
        zzlt zzltVar = (zzlt) entry.getKey();
        Object value = entry.getValue();
        if (zzltVar.zzc() != zzoq.MESSAGE || zzltVar.zze() || zzltVar.zzd()) {
            return zzb(zzltVar, value);
        }
        if (value instanceof zzmr) {
            int zza = ((zzlt) entry.getKey()).zza();
            int zzz4 = zzlk.zzz(8);
            i = zzz4 + zzz4;
            zzz = zzlk.zzz(16) + zzlk.zzz(zza);
            zzz2 = zzlk.zzz(24);
            zzcf = ((zzmr) value).zza();
            zzz3 = zzlk.zzz(zzcf);
        } else {
            int zza2 = ((zzlt) entry.getKey()).zza();
            int zzz5 = zzlk.zzz(8);
            i = zzz5 + zzz5;
            zzz = zzlk.zzz(16) + zzlk.zzz(zza2);
            zzz2 = zzlk.zzz(24);
            zzcf = ((zznh) value).zzcf();
            zzz3 = zzlk.zzz(zzcf);
        }
        return i + zzz + zzz2 + zzz3 + zzcf;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0015. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final void zzl(zzlt zzltVar, Object obj) {
        boolean z;
        zzltVar.zzb();
        byte[] bArr = zzmk.zzb;
        obj.getClass();
        zzop zzopVar = zzop.DOUBLE;
        zzoq zzoqVar = zzoq.INT;
        switch (r0.zza()) {
            case INT:
                z = obj instanceof Integer;
                if (z) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzltVar.zza()), zzltVar.zzb().zza(), obj.getClass().getName()));
            case LONG:
                z = obj instanceof Long;
                if (z) {
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzltVar.zza()), zzltVar.zzb().zza(), obj.getClass().getName()));
            case FLOAT:
                z = obj instanceof Float;
                if (z) {
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzltVar.zza()), zzltVar.zzb().zza(), obj.getClass().getName()));
            case DOUBLE:
                z = obj instanceof Double;
                if (z) {
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzltVar.zza()), zzltVar.zzb().zza(), obj.getClass().getName()));
            case BOOLEAN:
                z = obj instanceof Boolean;
                if (z) {
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzltVar.zza()), zzltVar.zzb().zza(), obj.getClass().getName()));
            case STRING:
                z = obj instanceof String;
                if (z) {
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzltVar.zza()), zzltVar.zzb().zza(), obj.getClass().getName()));
            case BYTE_STRING:
                if ((obj instanceof zzld) || (obj instanceof byte[])) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzltVar.zza()), zzltVar.zzb().zza(), obj.getClass().getName()));
            case ENUM:
                if ((obj instanceof Integer) || (obj instanceof zzmf)) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzltVar.zza()), zzltVar.zzb().zza(), obj.getClass().getName()));
            case MESSAGE:
                if ((obj instanceof zznh) || (obj instanceof zzmr)) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzltVar.zza()), zzltVar.zzb().zza(), obj.getClass().getName()));
            default:
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzltVar.zza()), zzltVar.zzb().zza(), obj.getClass().getName()));
        }
    }

    public final /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
        zzlu zzluVar = new zzlu();
        zzoa zzoaVar = this.zza;
        int zzc = zzoaVar.zzc();
        for (int i = 0; i < zzc; i++) {
            Map.Entry zzg = zzoaVar.zzg(i);
            zzluVar.zzg((zzlt) ((zznw) zzg).zza(), zzg.getValue());
        }
        for (Map.Entry entry : zzoaVar.zzd()) {
            zzluVar.zzg((zzlt) entry.getKey(), entry.getValue());
        }
        zzluVar.zzd = this.zzd;
        return zzluVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzlu) {
            return this.zza.equals(((zzlu) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final int zzc() {
        zzoa zzoaVar = this.zza;
        int zzc = zzoaVar.zzc();
        int i = 0;
        for (int i2 = 0; i2 < zzc; i2++) {
            i += zzk(zzoaVar.zzg(i2));
        }
        Iterator it = zzoaVar.zzd().iterator();
        while (it.hasNext()) {
            i += zzk((Map.Entry) it.next());
        }
        return i;
    }

    public final Iterator zze() {
        zzoa zzoaVar = this.zza;
        if (zzoaVar.isEmpty()) {
            return Collections.emptyIterator();
        }
        if (this.zzd) {
            return new zzmp(zzoaVar.entrySet().iterator());
        }
        return zzoaVar.entrySet().iterator();
    }

    public final void zzf() {
        if (this.zzc) {
            return;
        }
        zzoa zzoaVar = this.zza;
        int zzc = zzoaVar.zzc();
        for (int i = 0; i < zzc; i++) {
            Object value = zzoaVar.zzg(i).getValue();
            if (value instanceof zzmd) {
                ((zzmd) value).zzcr();
            }
        }
        Iterator it = zzoaVar.zzd().iterator();
        while (it.hasNext()) {
            Object value2 = ((Map.Entry) it.next()).getValue();
            if (value2 instanceof zzmd) {
                ((zzmd) value2).zzcr();
            }
        }
        zzoaVar.zza();
        this.zzc = true;
    }

    public final void zzg(zzlt zzltVar, Object obj) {
        if (zzltVar.zze()) {
            if (!(obj instanceof List)) {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
            List list = (List) obj;
            int size = list.size();
            ArrayList arrayList = new ArrayList(size);
            for (int i = 0; i < size; i++) {
                Object obj2 = list.get(i);
                zzl(zzltVar, obj2);
                arrayList.add(obj2);
            }
            obj = arrayList;
        } else {
            zzl(zzltVar, obj);
        }
        if (obj instanceof zzmr) {
            this.zzd = true;
        }
        this.zza.put(zzltVar, obj);
    }

    public final boolean zzh() {
        zzoa zzoaVar = this.zza;
        int zzc = zzoaVar.zzc();
        for (int i = 0; i < zzc; i++) {
            if (!zzi(zzoaVar.zzg(i))) {
                return false;
            }
        }
        Iterator it = zzoaVar.zzd().iterator();
        while (it.hasNext()) {
            if (!zzi((Map.Entry) it.next())) {
                return false;
            }
        }
        return true;
    }

    private zzlu(boolean z) {
        zzf();
        zzf();
    }
}
