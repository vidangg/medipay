package com.google.android.gms.internal.fido;

import java.io.IOException;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-fido@@20.0.1 */
/* loaded from: classes3.dex */
final class zzbd extends zzbe {
    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public zzbd(String str, String str2, @CheckForNull Character ch) {
        super(r0, ch);
        char[] cArr;
        zzbb zzbbVar = new zzbb(str, str2.toCharArray());
        cArr = zzbbVar.zzf;
        zzam.zzc(cArr.length == 64);
    }

    @Override // com.google.android.gms.internal.fido.zzbe, com.google.android.gms.internal.fido.zzbf
    final void zza(Appendable appendable, byte[] bArr, int i, int i2) throws IOException {
        int i3 = 0;
        zzam.zze(0, i2, bArr.length);
        for (int i4 = i2; i4 >= 3; i4 -= 3) {
            int i5 = bArr[i3] & 255;
            int i6 = ((bArr[i3 + 1] & 255) << 8) | (i5 << 16) | (bArr[i3 + 2] & 255);
            appendable.append(this.zzb.zza(i6 >>> 18));
            appendable.append(this.zzb.zza((i6 >>> 12) & 63));
            appendable.append(this.zzb.zza((i6 >>> 6) & 63));
            appendable.append(this.zzb.zza(i6 & 63));
            i3 += 3;
        }
        if (i3 < i2) {
            zzc(appendable, bArr, i3, i2 - i3);
        }
    }
}
