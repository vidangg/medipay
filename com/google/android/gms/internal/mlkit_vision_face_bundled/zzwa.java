package com.google.android.gms.internal.mlkit_vision_face_bundled;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.mlkit:face-detection@@16.1.7 */
/* loaded from: classes3.dex */
final class zzwa implements zzwh {
    private final zzvw zza;
    private final zzwv zzb;
    private final boolean zzc;
    private final zzui zzd;

    private zzwa(zzwv zzwvVar, zzui zzuiVar, zzvw zzvwVar) {
        this.zzb = zzwvVar;
        this.zzc = zzvwVar instanceof zzus;
        this.zzd = zzuiVar;
        this.zza = zzvwVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzwa zzc(zzwv zzwvVar, zzui zzuiVar, zzvw zzvwVar) {
        return new zzwa(zzwvVar, zzuiVar, zzvwVar);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzwh
    public final int zza(Object obj) {
        int zzb = ((zzuw) obj).zzc.zzb();
        return this.zzc ? zzb + ((zzus) obj).zzb.zzb() : zzb;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzwh
    public final int zzb(Object obj) {
        int hashCode = ((zzuw) obj).zzc.hashCode();
        return this.zzc ? (hashCode * 53) + ((zzus) obj).zzb.zza.hashCode() : hashCode;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzwh
    public final Object zze() {
        zzvw zzvwVar = this.zza;
        return zzvwVar instanceof zzuw ? ((zzuw) zzvwVar).zzy() : zzvwVar.zzK().zzp();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzwh
    public final void zzf(Object obj) {
        this.zzb.zza(obj);
        this.zzd.zza(obj);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzwh
    public final void zzg(Object obj, Object obj2) {
        zzwj.zzp(this.zzb, obj, obj2);
        if (this.zzc) {
            zzwj.zzo(this.zzd, obj, obj2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00bb A[EDGE_INSN: B:24:0x00bb->B:25:0x00bb BREAK  A[LOOP:1: B:10:0x0065->B:18:0x0065], SYNTHETIC] */
    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzwh
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zzh(Object obj, byte[] bArr, int i, int i2, zztj zztjVar) throws IOException {
        zzuw zzuwVar = (zzuw) obj;
        zzww zzwwVar = zzuwVar.zzc;
        if (zzwwVar == zzww.zzc()) {
            zzwwVar = zzww.zzf();
            zzuwVar.zzc = zzwwVar;
        }
        zzum zzb = ((zzus) obj).zzb();
        zzuu zzuuVar = null;
        while (i < i2) {
            int zzj = zztk.zzj(bArr, i, zztjVar);
            int i3 = zztjVar.zza;
            if (i3 == 11) {
                int i4 = 0;
                zztu zztuVar = null;
                while (zzj < i2) {
                    zzj = zztk.zzj(bArr, zzj, zztjVar);
                    int i5 = zztjVar.zza;
                    int i6 = i5 >>> 3;
                    int i7 = i5 & 7;
                    if (i6 != 2) {
                        if (i6 == 3) {
                            if (zzuuVar != null) {
                                zzj = zztk.zze(zzwe.zza().zzb(zzuuVar.zzc.getClass()), bArr, zzj, i2, zztjVar);
                                zzb.zzj(zzuuVar.zzd, zztjVar.zzc);
                            } else if (i7 == 2) {
                                zzj = zztk.zza(bArr, zzj, zztjVar);
                                zztuVar = (zztu) zztjVar.zzc;
                            }
                        }
                        if (i5 != 12) {
                            break;
                        } else {
                            zzj = zztk.zzp(i5, bArr, zzj, i2, zztjVar);
                        }
                    } else if (i7 == 0) {
                        zzj = zztk.zzj(bArr, zzj, zztjVar);
                        i4 = zztjVar.zza;
                        zzuuVar = zztjVar.zzd.zzb(this.zza, i4);
                    } else if (i5 != 12) {
                    }
                }
                if (zztuVar != null) {
                    zzwwVar.zzj((i4 << 3) | 2, zztuVar);
                }
                i = zzj;
            } else if ((i3 & 7) == 2) {
                zzuu zzb2 = zztjVar.zzd.zzb(this.zza, i3 >>> 3);
                if (zzb2 != null) {
                    i = zztk.zze(zzwe.zza().zzb(zzb2.zzc.getClass()), bArr, zzj, i2, zztjVar);
                    zzb.zzj(zzb2.zzd, zztjVar.zzc);
                } else {
                    i = zztk.zzi(i3, bArr, zzj, i2, zzwwVar, zztjVar);
                }
                zzuuVar = zzb2;
            } else {
                i = zztk.zzp(i3, bArr, zzj, i2, zztjVar);
            }
        }
        if (i != i2) {
            throw new zzve("Failed to parse the message.");
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzwh
    public final void zzi(Object obj, zzxi zzxiVar) throws IOException {
        Iterator zzf = ((zzus) obj).zzb.zzf();
        if (!zzf.hasNext()) {
            ((zzuw) obj).zzc.zzk(zzxiVar);
            return;
        }
        zzul zzulVar = (zzul) ((Map.Entry) zzf.next()).getKey();
        if (zzulVar.zzc() == zzxh.MESSAGE) {
            zzulVar.zze();
        }
        throw new IllegalStateException("Found invalid MessageSet item.");
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzwh
    public final boolean zzj(Object obj, Object obj2) {
        if (!((zzuw) obj).zzc.equals(((zzuw) obj2).zzc)) {
            return false;
        }
        if (this.zzc) {
            return ((zzus) obj).zzb.equals(((zzus) obj2).zzb);
        }
        return true;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzwh
    public final boolean zzk(Object obj) {
        return ((zzus) obj).zzb.zzl();
    }
}
