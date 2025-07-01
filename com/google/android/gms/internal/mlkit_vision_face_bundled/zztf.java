package com.google.android.gms.internal.mlkit_vision_face_bundled;

import com.google.android.gms.internal.mlkit_vision_face_bundled.zzte;
import com.google.android.gms.internal.mlkit_vision_face_bundled.zztf;
import java.io.IOException;

/* compiled from: com.google.mlkit:face-detection@@16.1.7 */
/* loaded from: classes3.dex */
public abstract class zztf<MessageType extends zztf<MessageType, BuilderType>, BuilderType extends zzte<MessageType, BuilderType>> implements zzvw {
    protected int zza = 0;

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzvw
    public final zztu zzM() {
        try {
            int zzu = zzu();
            zztu zztuVar = zztu.zzb;
            byte[] bArr = new byte[zzu];
            zztz zztzVar = new zztz(bArr, 0, zzu);
            zzL(zztzVar);
            zztzVar.zzB();
            return new zztt(bArr);
        } catch (IOException e) {
            throw new RuntimeException("Serializing " + getClass().getName() + " to a ByteString threw an IOException (should never happen).", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int zzp(zzwh zzwhVar) {
        throw null;
    }

    public final byte[] zzr() {
        try {
            int zzu = zzu();
            byte[] bArr = new byte[zzu];
            zztz zztzVar = new zztz(bArr, 0, zzu);
            zzL(zztzVar);
            zztzVar.zzB();
            return bArr;
        } catch (IOException e) {
            throw new RuntimeException("Serializing " + getClass().getName() + " to a byte array threw an IOException (should never happen).", e);
        }
    }
}
