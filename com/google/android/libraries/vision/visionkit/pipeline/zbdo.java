package com.google.android.libraries.vision.visionkit.pipeline;

import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbafq;
import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbals;
import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbfi;
import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbfo;
import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbfx;
import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbgi;
import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbhr;
import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbij;
import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbix;
import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbja;
import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbjx;
import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zblu;
import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbma;
import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbub;
import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf;
import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbun;
import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbvn;
import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbxd;
import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbzy;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
public final class zbdo extends zbub implements zbvn {
    private static final zbdo zbd;
    private zbbt zbA;
    private zbbi zbB;
    private zbcw zbC;
    private zbdw zbD;
    private boolean zbI;
    private int zbL;
    private int zbM;
    private zbxd zbN;
    private boolean zbO;
    private boolean zbR;
    private zbdj zbS;
    private boolean zbT;
    private zbzy zbU;
    private zbzy zbV;
    private com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbaf zbW;
    private com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbbe zbX;
    private com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbbh zbY;
    private zbfx zbZ;
    private com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbfc zbaa;
    private zbfo zbab;
    private com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbew zbac;
    private com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbcf zbad;
    private zbfi zbae;
    private int zbaf;
    private boolean zbag;
    private int zbah;
    private boolean zbai;
    private zbma zbal;
    private boolean zban;
    private int zbe;
    private int zbf;
    private zbaa zbi;
    private zbgi zbl;
    private zbaz zbo;
    private zbhr zbr;
    private zbel zbs;
    private zbbp zbt;
    private zbr zbu;
    private zbdz zbv;
    private zbec zbw;
    private com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbaz zbx;
    private boolean zby;
    private zbjx zbz;
    private byte zbao = 2;
    private zbun zbg = zby();
    private zbun zbh = zby();
    private zbun zbj = zby();
    private zbun zbk = zby();
    private zbun zbm = zby();
    private zbun zbn = zby();
    private zbun zbp = zby();
    private zbun zbq = zby();
    private zbun zbE = zbuf.zby();
    private zbun zbF = zby();
    private zbun zbG = zby();
    private zbun zbH = zbuf.zby();
    private String zbJ = "";
    private int zbK = 1;
    private String zbP = "";
    private String zbQ = "";
    private String zbaj = "";
    private int zbak = 1;
    private String zbam = "";

    static {
        zbdo zbdoVar = new zbdo();
        zbd = zbdoVar;
        zbuf.zbD(zbdo.class, zbdoVar);
    }

    private zbdo() {
    }

    public static zbdl zba() {
        return (zbdl) zbd.zbq();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zbd(zbdo zbdoVar, com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbbe zbbeVar) {
        zbbeVar.getClass();
        zbdoVar.zbX = zbbeVar;
        zbdoVar.zbe |= Integer.MIN_VALUE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zbe(zbdo zbdoVar, zbix zbixVar) {
        zbixVar.getClass();
        zbun zbunVar = zbdoVar.zbh;
        if (!zbunVar.zbc()) {
            int size = zbunVar.size();
            zbdoVar.zbh = zbunVar.zbd(size == 0 ? 10 : size + size);
        }
        zbdoVar.zbh.add(zbixVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zbf(zbdo zbdoVar, zbcw zbcwVar) {
        zbcwVar.getClass();
        zbdoVar.zbC = zbcwVar;
        zbdoVar.zbe |= 16384;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zbao);
        }
        if (i2 == 2) {
            return zbA(zbd, "\u0001<\u0000\u0002\u0001I<\u0000\f\u000b\u0001\u001b\u0002Л\u0003ဉ\u0001\u0005\u001b\u0006Л\u0007ဇ\u0010\bဉ\u000f\nဉ\u000b\u000bဉ\f\fဉ\r\u000fဉ\u001f\u0010ᐉ\u0002\u0013\u001b\u0014ᐉ\u0003\u0015\u001a\u0016ဉ!\u0017ဉ\u001a\u0018ဉ\u000e\u001aᐉ\u0004\u001b\u001b\u001cဉ\u0005\u001dဉ\u0006\u001eဉ \u001f\u001b ဈ\u0011!\u001a\"ဉ\"$ဇ\u001b%ᐉ\u0007&ᐉ\b'ဉ\u0015)ဉ\u001e*\u001b+ဉ#,ဉ$-᠌\u0014.ဇ\n/ဉ&1ဉ%3᠌'4ဇ\u00165ᐉ\u001c6င\u00127င\u00138ဈ\u00179ဈ\u0018<ဇ(=ဇ\u0019>ဉ\u0000?\u001b@᠌)Aᐉ\tBင,Cဉ-Dဈ+Eဇ*FЛGဈ.Hᐉ\u001dIဇ/", new Object[]{"zbe", "zbf", "zbg", zbix.class, "zbk", zbafq.class, "zbl", "zbm", zbij.class, "zbn", zbam.class, "zbI", "zbD", "zbz", "zbA", "zbB", "zbX", "zbo", "zbp", zbja.class, "zbr", "zbE", "zbZ", "zbS", "zbC", "zbs", "zbj", zbn.class, "zbt", "zbu", "zbY", "zbF", zbeu.class, "zbJ", "zbH", "zbaa", "zbT", "zbv", "zbw", "zbN", "zbW", "zbh", zbix.class, "zbab", "zbac", "zbM", zba.zba, "zby", "zbae", "zbad", "zbaf", zbdn.zba, "zbO", "zbU", "zbK", "zbL", "zbP", "zbQ", "zbag", "zbR", "zbi", "zbq", zbals.class, "zbah", zbdm.zba, "zbx", "zbak", "zbal", "zbaj", "zbai", "zbG", zblu.class, "zbam", "zbV", "zban"});
        }
        if (i2 == 3) {
            return new zbdo();
        }
        zbdk zbdkVar = null;
        if (i2 == 4) {
            return new zbdl(zbdkVar);
        }
        if (i2 == 5) {
            return zbd;
        }
        this.zbao = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
