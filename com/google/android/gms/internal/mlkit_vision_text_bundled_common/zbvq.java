package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
final class zbvq implements zbvx {
    private final zbvm zba;
    private final zbwl zbb;
    private final boolean zbc;
    private final zbtq zbd;

    private zbvq(zbwl zbwlVar, zbtq zbtqVar, zbvm zbvmVar) {
        this.zbb = zbwlVar;
        this.zbc = zbvmVar instanceof zbub;
        this.zbd = zbtqVar;
        this.zba = zbvmVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zbvq zbc(zbwl zbwlVar, zbtq zbtqVar, zbvm zbvmVar) {
        return new zbvq(zbwlVar, zbtqVar, zbvmVar);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbvx
    public final int zba(Object obj) {
        int zbb = ((zbuf) obj).zbc.zbb();
        return this.zbc ? zbb + ((zbub) obj).zbb.zbc() : zbb;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbvx
    public final int zbb(Object obj) {
        int hashCode = ((zbuf) obj).zbc.hashCode();
        return this.zbc ? (hashCode * 53) + ((zbub) obj).zbb.zba.hashCode() : hashCode;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbvx
    public final Object zbe() {
        zbvm zbvmVar = this.zba;
        return zbvmVar instanceof zbuf ? ((zbuf) zbvmVar).zbt() : zbvmVar.zbJ().zbl();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbvx
    public final void zbf(Object obj) {
        this.zbb.zbb(obj);
        this.zbd.zba(obj);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbvx
    public final void zbg(Object obj, Object obj2) {
        zbvz.zbp(this.zbb, obj, obj2);
        if (this.zbc) {
            zbvz.zbo(this.zbd, obj, obj2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00bb A[EDGE_INSN: B:24:0x00bb->B:25:0x00bb BREAK  A[LOOP:1: B:10:0x0065->B:18:0x0065], SYNTHETIC] */
    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbvx
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zbh(Object obj, byte[] bArr, int i, int i2, zbsq zbsqVar) throws IOException {
        zbuf zbufVar = (zbuf) obj;
        zbwm zbwmVar = zbufVar.zbc;
        if (zbwmVar == zbwm.zbc()) {
            zbwmVar = zbwm.zbf();
            zbufVar.zbc = zbwmVar;
        }
        zbtu zbg = ((zbub) obj).zbg();
        zbud zbudVar = null;
        while (i < i2) {
            int zbk = zbsr.zbk(bArr, i, zbsqVar);
            int i3 = zbsqVar.zba;
            if (i3 == 11) {
                int i4 = 0;
                zbtc zbtcVar = null;
                while (zbk < i2) {
                    zbk = zbsr.zbk(bArr, zbk, zbsqVar);
                    int i5 = zbsqVar.zba;
                    int i6 = i5 >>> 3;
                    int i7 = i5 & 7;
                    if (i6 != 2) {
                        if (i6 == 3) {
                            if (zbudVar != null) {
                                zbk = zbsr.zbe(zbvu.zba().zbb(zbudVar.zba.getClass()), bArr, zbk, i2, zbsqVar);
                                zbg.zbj(zbudVar.zbb, zbsqVar.zbc);
                            } else if (i7 == 2) {
                                zbk = zbsr.zba(bArr, zbk, zbsqVar);
                                zbtcVar = (zbtc) zbsqVar.zbc;
                            }
                        }
                        if (i5 != 12) {
                            break;
                        } else {
                            zbk = zbsr.zbq(i5, bArr, zbk, i2, zbsqVar);
                        }
                    } else if (i7 == 0) {
                        zbk = zbsr.zbk(bArr, zbk, zbsqVar);
                        i4 = zbsqVar.zba;
                        zbudVar = zbsqVar.zbd.zbc(this.zba, i4);
                    } else if (i5 != 12) {
                    }
                }
                if (zbtcVar != null) {
                    zbwmVar.zbj((i4 << 3) | 2, zbtcVar);
                }
                i = zbk;
            } else if ((i3 & 7) == 2) {
                zbud zbc = zbsqVar.zbd.zbc(this.zba, i3 >>> 3);
                if (zbc != null) {
                    i = zbsr.zbe(zbvu.zba().zbb(zbc.zba.getClass()), bArr, zbk, i2, zbsqVar);
                    zbg.zbj(zbc.zbb, zbsqVar.zbc);
                } else {
                    i = zbsr.zbj(i3, bArr, zbk, i2, zbwmVar, zbsqVar);
                }
                zbudVar = zbc;
            } else {
                i = zbsr.zbq(i3, bArr, zbk, i2, zbsqVar);
            }
        }
        if (i != i2) {
            throw new zbuq("Failed to parse the message.");
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbvx
    public final void zbi(Object obj, zbwy zbwyVar) throws IOException {
        Iterator zbg = ((zbub) obj).zbb.zbg();
        while (zbg.hasNext()) {
            Map.Entry entry = (Map.Entry) zbg.next();
            zbtt zbttVar = (zbtt) entry.getKey();
            if (zbttVar.zbe() != zbwx.MESSAGE) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            }
            zbttVar.zbg();
            zbttVar.zbf();
            if (entry instanceof zbut) {
                zbttVar.zba();
                zbwyVar.zbx(32149011, ((zbut) entry).zba().zbb());
            } else {
                zbttVar.zba();
                zbwyVar.zbx(32149011, entry.getValue());
            }
        }
        ((zbuf) obj).zbc.zbk(zbwyVar);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbvx
    public final boolean zbj(Object obj, Object obj2) {
        if (!((zbuf) obj).zbc.equals(((zbuf) obj2).zbc)) {
            return false;
        }
        if (this.zbc) {
            return ((zbub) obj).zbb.equals(((zbub) obj2).zbb);
        }
        return true;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbvx
    public final boolean zbk(Object obj) {
        return ((zbub) obj).zbb.zbm();
    }
}
