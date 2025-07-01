package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
final class zbtl implements zbwy {
    private final zbtk zba;

    private zbtl(zbtk zbtkVar) {
        byte[] bArr = zbuo.zbb;
        this.zba = zbtkVar;
        zbtkVar.zba = this;
    }

    public static zbtl zba(zbtk zbtkVar) {
        zbtl zbtlVar = zbtkVar.zba;
        return zbtlVar != null ? zbtlVar : new zbtl(zbtkVar);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbwy
    public final void zbA(int i, long j) throws IOException {
        this.zba.zbj(i, j);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbwy
    public final void zbC(int i, int i2) throws IOException {
        this.zba.zbv(i, (i2 >> 31) ^ (i2 + i2));
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbwy
    public final void zbE(int i, long j) throws IOException {
        this.zba.zbx(i, (j >> 63) ^ (j + j));
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbwy
    @Deprecated
    public final void zbG(int i) throws IOException {
        this.zba.zbu(i, 3);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbwy
    public final void zbH(int i, String str) throws IOException {
        this.zba.zbs(i, str);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbwy
    public final void zbJ(int i, int i2) throws IOException {
        this.zba.zbv(i, i2);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbwy
    public final void zbL(int i, long j) throws IOException {
        this.zba.zbx(i, j);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbwy
    public final void zbb(int i, boolean z) throws IOException {
        this.zba.zbd(i, z);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbwy
    public final void zbd(int i, zbtc zbtcVar) throws IOException {
        this.zba.zbf(i, zbtcVar);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbwy
    public final void zbe(int i, List list) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            this.zba.zbf(i, (zbtc) list.get(i2));
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbwy
    public final void zbf(int i, double d) throws IOException {
        this.zba.zbj(i, Double.doubleToRawLongBits(d));
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbwy
    @Deprecated
    public final void zbh(int i) throws IOException {
        this.zba.zbu(i, 4);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbwy
    public final void zbi(int i, int i2) throws IOException {
        this.zba.zbl(i, i2);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbwy
    public final void zbk(int i, int i2) throws IOException {
        this.zba.zbh(i, i2);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbwy
    public final void zbm(int i, long j) throws IOException {
        this.zba.zbj(i, j);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbwy
    public final void zbo(int i, float f) throws IOException {
        this.zba.zbh(i, Float.floatToRawIntBits(f));
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbwy
    public final void zbq(int i, Object obj, zbvx zbvxVar) throws IOException {
        zbtk zbtkVar = this.zba;
        zbtkVar.zbu(i, 3);
        zbvxVar.zbi((zbvm) obj, zbtkVar.zba);
        zbtkVar.zbu(i, 4);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbwy
    public final void zbr(int i, int i2) throws IOException {
        this.zba.zbl(i, i2);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbwy
    public final void zbt(int i, long j) throws IOException {
        this.zba.zbx(i, j);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbwy
    public final void zbv(int i, zbve zbveVar, Map map) throws IOException {
        for (Map.Entry entry : map.entrySet()) {
            this.zba.zbu(i, 2);
            this.zba.zbw(zbvf.zbb(zbveVar, entry.getKey(), entry.getValue()));
            zbvf.zbe(this.zba, zbveVar, entry.getKey(), entry.getValue());
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbwy
    public final void zbw(int i, Object obj, zbvx zbvxVar) throws IOException {
        this.zba.zbo(i, (zbvm) obj, zbvxVar);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbwy
    public final void zbx(int i, Object obj) throws IOException {
        if (obj instanceof zbtc) {
            this.zba.zbr(i, (zbtc) obj);
        } else {
            this.zba.zbq(i, (zbvm) obj);
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbwy
    public final void zby(int i, int i2) throws IOException {
        this.zba.zbh(i, i2);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbwy
    public final void zbI(int i, List list) throws IOException {
        int i2 = 0;
        if (!(list instanceof zbux)) {
            while (i2 < list.size()) {
                this.zba.zbs(i, (String) list.get(i2));
                i2++;
            }
            return;
        }
        zbux zbuxVar = (zbux) list;
        while (i2 < list.size()) {
            Object zba = zbuxVar.zba();
            if (zba instanceof String) {
                this.zba.zbs(i, (String) zba);
            } else {
                this.zba.zbf(i, (zbtc) zba);
            }
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbwy
    public final void zbK(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zbug)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zba.zbv(i, ((Integer) list.get(i2)).intValue());
                    i2++;
                }
                return;
            }
            this.zba.zbu(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zbtk.zbD(((Integer) list.get(i4)).intValue());
            }
            this.zba.zbw(i3);
            while (i2 < list.size()) {
                this.zba.zbw(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        zbug zbugVar = (zbug) list;
        if (!z) {
            while (i2 < zbugVar.size()) {
                this.zba.zbv(i, zbugVar.zbe(i2));
                i2++;
            }
            return;
        }
        this.zba.zbu(i, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < zbugVar.size(); i6++) {
            i5 += zbtk.zbD(zbugVar.zbe(i6));
        }
        this.zba.zbw(i5);
        while (i2 < zbugVar.size()) {
            this.zba.zbw(zbugVar.zbe(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbwy
    public final void zbM(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zbva)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zba.zbx(i, ((Long) list.get(i2)).longValue());
                    i2++;
                }
                return;
            }
            this.zba.zbu(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zbtk.zbE(((Long) list.get(i4)).longValue());
            }
            this.zba.zbw(i3);
            while (i2 < list.size()) {
                this.zba.zby(((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        zbva zbvaVar = (zbva) list;
        if (!z) {
            while (i2 < zbvaVar.size()) {
                this.zba.zbx(i, zbvaVar.zbe(i2));
                i2++;
            }
            return;
        }
        this.zba.zbu(i, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < zbvaVar.size(); i6++) {
            i5 += zbtk.zbE(zbvaVar.zbe(i6));
        }
        this.zba.zbw(i5);
        while (i2 < zbvaVar.size()) {
            this.zba.zby(zbvaVar.zbe(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbwy
    public final void zbl(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zbug)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zba.zbh(i, ((Integer) list.get(i2)).intValue());
                    i2++;
                }
                return;
            }
            this.zba.zbu(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                ((Integer) list.get(i4)).intValue();
                i3 += 4;
            }
            this.zba.zbw(i3);
            while (i2 < list.size()) {
                this.zba.zbi(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        zbug zbugVar = (zbug) list;
        if (!z) {
            while (i2 < zbugVar.size()) {
                this.zba.zbh(i, zbugVar.zbe(i2));
                i2++;
            }
            return;
        }
        this.zba.zbu(i, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < zbugVar.size(); i6++) {
            zbugVar.zbe(i6);
            i5 += 4;
        }
        this.zba.zbw(i5);
        while (i2 < zbugVar.size()) {
            this.zba.zbi(zbugVar.zbe(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbwy
    public final void zbn(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zbva)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zba.zbj(i, ((Long) list.get(i2)).longValue());
                    i2++;
                }
                return;
            }
            this.zba.zbu(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                ((Long) list.get(i4)).longValue();
                i3 += 8;
            }
            this.zba.zbw(i3);
            while (i2 < list.size()) {
                this.zba.zbk(((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        zbva zbvaVar = (zbva) list;
        if (!z) {
            while (i2 < zbvaVar.size()) {
                this.zba.zbj(i, zbvaVar.zbe(i2));
                i2++;
            }
            return;
        }
        this.zba.zbu(i, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < zbvaVar.size(); i6++) {
            zbvaVar.zbe(i6);
            i5 += 8;
        }
        this.zba.zbw(i5);
        while (i2 < zbvaVar.size()) {
            this.zba.zbk(zbvaVar.zbe(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbwy
    public final void zbc(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zbss)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zba.zbd(i, ((Boolean) list.get(i2)).booleanValue());
                    i2++;
                }
                return;
            }
            this.zba.zbu(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                ((Boolean) list.get(i4)).booleanValue();
                i3++;
            }
            this.zba.zbw(i3);
            while (i2 < list.size()) {
                this.zba.zbb(((Boolean) list.get(i2)).booleanValue() ? (byte) 1 : (byte) 0);
                i2++;
            }
            return;
        }
        zbss zbssVar = (zbss) list;
        if (!z) {
            while (i2 < zbssVar.size()) {
                this.zba.zbd(i, zbssVar.zbf(i2));
                i2++;
            }
            return;
        }
        this.zba.zbu(i, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < zbssVar.size(); i6++) {
            zbssVar.zbf(i6);
            i5++;
        }
        this.zba.zbw(i5);
        while (i2 < zbssVar.size()) {
            this.zba.zbb(zbssVar.zbf(i2) ? (byte) 1 : (byte) 0);
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbwy
    public final void zbs(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zbug)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zba.zbl(i, ((Integer) list.get(i2)).intValue());
                    i2++;
                }
                return;
            }
            this.zba.zbu(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zbtk.zbE(((Integer) list.get(i4)).intValue());
            }
            this.zba.zbw(i3);
            while (i2 < list.size()) {
                this.zba.zbm(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        zbug zbugVar = (zbug) list;
        if (!z) {
            while (i2 < zbugVar.size()) {
                this.zba.zbl(i, zbugVar.zbe(i2));
                i2++;
            }
            return;
        }
        this.zba.zbu(i, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < zbugVar.size(); i6++) {
            i5 += zbtk.zbE(zbugVar.zbe(i6));
        }
        this.zba.zbw(i5);
        while (i2 < zbugVar.size()) {
            this.zba.zbm(zbugVar.zbe(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbwy
    public final void zbB(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zbva)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zba.zbj(i, ((Long) list.get(i2)).longValue());
                    i2++;
                }
                return;
            }
            this.zba.zbu(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                ((Long) list.get(i4)).longValue();
                i3 += 8;
            }
            this.zba.zbw(i3);
            while (i2 < list.size()) {
                this.zba.zbk(((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        zbva zbvaVar = (zbva) list;
        if (!z) {
            while (i2 < zbvaVar.size()) {
                this.zba.zbj(i, zbvaVar.zbe(i2));
                i2++;
            }
            return;
        }
        this.zba.zbu(i, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < zbvaVar.size(); i6++) {
            zbvaVar.zbe(i6);
            i5 += 8;
        }
        this.zba.zbw(i5);
        while (i2 < zbvaVar.size()) {
            this.zba.zbk(zbvaVar.zbe(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbwy
    public final void zbg(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zbtm)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zba.zbj(i, Double.doubleToRawLongBits(((Double) list.get(i2)).doubleValue()));
                    i2++;
                }
                return;
            }
            this.zba.zbu(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                ((Double) list.get(i4)).doubleValue();
                i3 += 8;
            }
            this.zba.zbw(i3);
            while (i2 < list.size()) {
                this.zba.zbk(Double.doubleToRawLongBits(((Double) list.get(i2)).doubleValue()));
                i2++;
            }
            return;
        }
        zbtm zbtmVar = (zbtm) list;
        if (!z) {
            while (i2 < zbtmVar.size()) {
                this.zba.zbj(i, Double.doubleToRawLongBits(zbtmVar.zbe(i2)));
                i2++;
            }
            return;
        }
        this.zba.zbu(i, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < zbtmVar.size(); i6++) {
            zbtmVar.zbe(i6);
            i5 += 8;
        }
        this.zba.zbw(i5);
        while (i2 < zbtmVar.size()) {
            this.zba.zbk(Double.doubleToRawLongBits(zbtmVar.zbe(i2)));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbwy
    public final void zbp(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zbtw)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zba.zbh(i, Float.floatToRawIntBits(((Float) list.get(i2)).floatValue()));
                    i2++;
                }
                return;
            }
            this.zba.zbu(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                ((Float) list.get(i4)).floatValue();
                i3 += 4;
            }
            this.zba.zbw(i3);
            while (i2 < list.size()) {
                this.zba.zbi(Float.floatToRawIntBits(((Float) list.get(i2)).floatValue()));
                i2++;
            }
            return;
        }
        zbtw zbtwVar = (zbtw) list;
        if (!z) {
            while (i2 < zbtwVar.size()) {
                this.zba.zbh(i, Float.floatToRawIntBits(zbtwVar.zbe(i2)));
                i2++;
            }
            return;
        }
        this.zba.zbu(i, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < zbtwVar.size(); i6++) {
            zbtwVar.zbe(i6);
            i5 += 4;
        }
        this.zba.zbw(i5);
        while (i2 < zbtwVar.size()) {
            this.zba.zbi(Float.floatToRawIntBits(zbtwVar.zbe(i2)));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbwy
    public final void zbz(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zbug)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zba.zbh(i, ((Integer) list.get(i2)).intValue());
                    i2++;
                }
                return;
            }
            this.zba.zbu(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                ((Integer) list.get(i4)).intValue();
                i3 += 4;
            }
            this.zba.zbw(i3);
            while (i2 < list.size()) {
                this.zba.zbi(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        zbug zbugVar = (zbug) list;
        if (!z) {
            while (i2 < zbugVar.size()) {
                this.zba.zbh(i, zbugVar.zbe(i2));
                i2++;
            }
            return;
        }
        this.zba.zbu(i, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < zbugVar.size(); i6++) {
            zbugVar.zbe(i6);
            i5 += 4;
        }
        this.zba.zbw(i5);
        while (i2 < zbugVar.size()) {
            this.zba.zbi(zbugVar.zbe(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbwy
    public final void zbD(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zbug)) {
            if (!z) {
                while (i2 < list.size()) {
                    zbtk zbtkVar = this.zba;
                    int intValue = ((Integer) list.get(i2)).intValue();
                    zbtkVar.zbv(i, (intValue >> 31) ^ (intValue + intValue));
                    i2++;
                }
                return;
            }
            this.zba.zbu(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                int intValue2 = ((Integer) list.get(i4)).intValue();
                i3 += zbtk.zbD((intValue2 >> 31) ^ (intValue2 + intValue2));
            }
            this.zba.zbw(i3);
            while (i2 < list.size()) {
                zbtk zbtkVar2 = this.zba;
                int intValue3 = ((Integer) list.get(i2)).intValue();
                zbtkVar2.zbw((intValue3 >> 31) ^ (intValue3 + intValue3));
                i2++;
            }
            return;
        }
        zbug zbugVar = (zbug) list;
        if (!z) {
            while (i2 < zbugVar.size()) {
                zbtk zbtkVar3 = this.zba;
                int zbe = zbugVar.zbe(i2);
                zbtkVar3.zbv(i, (zbe >> 31) ^ (zbe + zbe));
                i2++;
            }
            return;
        }
        this.zba.zbu(i, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < zbugVar.size(); i6++) {
            int zbe2 = zbugVar.zbe(i6);
            i5 += zbtk.zbD((zbe2 >> 31) ^ (zbe2 + zbe2));
        }
        this.zba.zbw(i5);
        while (i2 < zbugVar.size()) {
            zbtk zbtkVar4 = this.zba;
            int zbe3 = zbugVar.zbe(i2);
            zbtkVar4.zbw((zbe3 >> 31) ^ (zbe3 + zbe3));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbwy
    public final void zbF(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zbva)) {
            if (!z) {
                while (i2 < list.size()) {
                    zbtk zbtkVar = this.zba;
                    long longValue = ((Long) list.get(i2)).longValue();
                    zbtkVar.zbx(i, (longValue >> 63) ^ (longValue + longValue));
                    i2++;
                }
                return;
            }
            this.zba.zbu(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                long longValue2 = ((Long) list.get(i4)).longValue();
                i3 += zbtk.zbE((longValue2 >> 63) ^ (longValue2 + longValue2));
            }
            this.zba.zbw(i3);
            while (i2 < list.size()) {
                zbtk zbtkVar2 = this.zba;
                long longValue3 = ((Long) list.get(i2)).longValue();
                zbtkVar2.zby((longValue3 >> 63) ^ (longValue3 + longValue3));
                i2++;
            }
            return;
        }
        zbva zbvaVar = (zbva) list;
        if (!z) {
            while (i2 < zbvaVar.size()) {
                zbtk zbtkVar3 = this.zba;
                long zbe = zbvaVar.zbe(i2);
                zbtkVar3.zbx(i, (zbe >> 63) ^ (zbe + zbe));
                i2++;
            }
            return;
        }
        this.zba.zbu(i, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < zbvaVar.size(); i6++) {
            long zbe2 = zbvaVar.zbe(i6);
            i5 += zbtk.zbE((zbe2 >> 63) ^ (zbe2 + zbe2));
        }
        this.zba.zbw(i5);
        while (i2 < zbvaVar.size()) {
            zbtk zbtkVar4 = this.zba;
            long zbe3 = zbvaVar.zbe(i2);
            zbtkVar4.zby((zbe3 >> 63) ^ (zbe3 + zbe3));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbwy
    public final void zbj(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zbug)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zba.zbl(i, ((Integer) list.get(i2)).intValue());
                    i2++;
                }
                return;
            }
            this.zba.zbu(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zbtk.zbE(((Integer) list.get(i4)).intValue());
            }
            this.zba.zbw(i3);
            while (i2 < list.size()) {
                this.zba.zbm(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        zbug zbugVar = (zbug) list;
        if (!z) {
            while (i2 < zbugVar.size()) {
                this.zba.zbl(i, zbugVar.zbe(i2));
                i2++;
            }
            return;
        }
        this.zba.zbu(i, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < zbugVar.size(); i6++) {
            i5 += zbtk.zbE(zbugVar.zbe(i6));
        }
        this.zba.zbw(i5);
        while (i2 < zbugVar.size()) {
            this.zba.zbm(zbugVar.zbe(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbwy
    public final void zbu(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zbva)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zba.zbx(i, ((Long) list.get(i2)).longValue());
                    i2++;
                }
                return;
            }
            this.zba.zbu(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zbtk.zbE(((Long) list.get(i4)).longValue());
            }
            this.zba.zbw(i3);
            while (i2 < list.size()) {
                this.zba.zby(((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        zbva zbvaVar = (zbva) list;
        if (!z) {
            while (i2 < zbvaVar.size()) {
                this.zba.zbx(i, zbvaVar.zbe(i2));
                i2++;
            }
            return;
        }
        this.zba.zbu(i, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < zbvaVar.size(); i6++) {
            i5 += zbtk.zbE(zbvaVar.zbe(i6));
        }
        this.zba.zbw(i5);
        while (i2 < zbvaVar.size()) {
            this.zba.zby(zbvaVar.zbe(i2));
            i2++;
        }
    }
}
