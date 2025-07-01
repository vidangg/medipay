package com.google.android.gms.internal.mlkit_vision_face_bundled;

import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.mlkit:face-detection@@16.1.7 */
/* loaded from: classes3.dex */
public abstract class zzus extends zzuw implements zzvx {
    protected zzum zzb = zzum.zzd();

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzum zzb() {
        if (this.zzb.zzk()) {
            this.zzb = this.zzb.clone();
        }
        return this.zzb;
    }

    public final Object zzd(zzuf zzufVar) {
        zzuu zzuuVar = (zzuu) zzufVar;
        if (zzuuVar.zza == ((zzuw) zzf(6, null, null))) {
            Object zze = this.zzb.zze(zzuuVar.zzd);
            if (zze == null) {
                return zzuuVar.zzb;
            }
            if (zzuuVar.zzd.zzb.zza() != zzxh.ENUM) {
                return zze;
            }
            ArrayList arrayList = new ArrayList();
            for (Object obj : (List) zze) {
                if (zzuuVar.zzd.zzb.zza() != zzxh.ENUM) {
                    arrayList.add(obj);
                } else {
                    ((Integer) obj).intValue();
                    throw null;
                }
            }
            return arrayList;
        }
        throw new IllegalArgumentException("This extension is for a different message type.  Please make sure that you are not suppressing any generics type warnings.");
    }
}
