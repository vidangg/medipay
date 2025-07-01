package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
public final class zbvw implements zbvj {
    private final zbvm zba;
    private final String zbb;
    private final Object[] zbc;
    private final int zbd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zbvw(zbvm zbvmVar, String str, Object[] objArr) {
        this.zba = zbvmVar;
        this.zbb = str;
        this.zbc = objArr;
        char charAt = str.charAt(0);
        if (charAt < 55296) {
            this.zbd = charAt;
            return;
        }
        int i = charAt & 8191;
        int i2 = 1;
        int i3 = 13;
        while (true) {
            int i4 = i2 + 1;
            char charAt2 = str.charAt(i2);
            if (charAt2 < 55296) {
                this.zbd = i | (charAt2 << i3);
                return;
            } else {
                i |= (charAt2 & 8191) << i3;
                i3 += 13;
                i2 = i4;
            }
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbvj
    public final zbvm zba() {
        return this.zba;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbvj
    public final boolean zbb() {
        return (this.zbd & 2) == 2;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbvj
    public final int zbc() {
        int i = this.zbd;
        if ((i & 1) != 0) {
            return 1;
        }
        return (i & 4) == 4 ? 3 : 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String zbd() {
        return this.zbb;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Object[] zbe() {
        return this.zbc;
    }
}
