package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzkn;
import com.google.android.gms.internal.measurement.zzko;
import java.io.IOException;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement-base@@22.4.0 */
/* loaded from: classes3.dex */
public abstract class zzko<MessageType extends zzko<MessageType, BuilderType>, BuilderType extends zzkn<MessageType, BuilderType>> implements zznh {
    protected int zza = 0;

    /* JADX INFO: Access modifiers changed from: protected */
    public static void zzcc(Iterable iterable, List list) {
        zzkn.zzaW(iterable, list);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int zzca(zzns zznsVar) {
        throw null;
    }

    @Override // com.google.android.gms.internal.measurement.zznh
    public final zzld zzcb() {
        try {
            int zzcf = zzcf();
            zzld zzldVar = zzld.zzb;
            byte[] bArr = new byte[zzcf];
            int i = zzlk.zzb;
            zzlh zzlhVar = new zzlh(bArr, 0, zzcf);
            zzcB(zzlhVar);
            zzlhVar.zzB();
            return new zzlb(bArr);
        } catch (IOException e) {
            throw new RuntimeException("Serializing " + getClass().getName() + " to a ByteString threw an IOException (should never happen).", e);
        }
    }

    public final byte[] zzcd() {
        try {
            int zzcf = zzcf();
            byte[] bArr = new byte[zzcf];
            int i = zzlk.zzb;
            zzlh zzlhVar = new zzlh(bArr, 0, zzcf);
            zzcB(zzlhVar);
            zzlhVar.zzB();
            return bArr;
        } catch (IOException e) {
            throw new RuntimeException("Serializing " + getClass().getName() + " to a byte array threw an IOException (should never happen).", e);
        }
    }
}
