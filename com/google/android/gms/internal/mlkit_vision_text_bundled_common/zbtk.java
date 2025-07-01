package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
public abstract class zbtk extends zbst {
    private static final Logger zbb = Logger.getLogger(zbtk.class.getName());
    private static final boolean zbc = zbws.zbx();
    zbtl zba;

    private zbtk() {
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zbtk(zbtj zbtjVar) {
    }

    public static int zbA(zbvm zbvmVar) {
        int zbo = zbvmVar.zbo();
        return zbD(zbo) + zbo;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zbB(zbvm zbvmVar, zbvx zbvxVar) {
        int zbj = ((zbsj) zbvmVar).zbj(zbvxVar);
        return zbD(zbj) + zbj;
    }

    public static int zbC(String str) {
        int length;
        try {
            length = zbwv.zbc(str);
        } catch (zbwu unused) {
            length = str.getBytes(zbuo.zba).length;
        }
        return zbD(length) + length;
    }

    public static int zbD(int i) {
        return (352 - (Integer.numberOfLeadingZeros(i) * 9)) >>> 6;
    }

    public static int zbE(long j) {
        return (640 - (Long.numberOfLeadingZeros(j) * 9)) >>> 6;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Deprecated
    public static int zbz(int i, zbvm zbvmVar, zbvx zbvxVar) {
        int zbD = zbD(i << 3);
        return zbD + zbD + ((zbsj) zbvmVar).zbj(zbvxVar);
    }

    public final void zbF() {
        if (zba() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zbG(String str, zbwu zbwuVar) throws IOException {
        zbb.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) zbwuVar);
        byte[] bytes = str.getBytes(zbuo.zba);
        try {
            int length = bytes.length;
            zbw(length);
            zbn(bytes, 0, length);
        } catch (IndexOutOfBoundsException e) {
            throw new zbti(e);
        }
    }

    public abstract int zba();

    public abstract void zbb(byte b) throws IOException;

    public abstract void zbd(int i, boolean z) throws IOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void zbe(byte[] bArr, int i, int i2) throws IOException;

    public abstract void zbf(int i, zbtc zbtcVar) throws IOException;

    public abstract void zbg(zbtc zbtcVar) throws IOException;

    public abstract void zbh(int i, int i2) throws IOException;

    public abstract void zbi(int i) throws IOException;

    public abstract void zbj(int i, long j) throws IOException;

    public abstract void zbk(long j) throws IOException;

    public abstract void zbl(int i, int i2) throws IOException;

    public abstract void zbm(int i) throws IOException;

    public abstract void zbn(byte[] bArr, int i, int i2) throws IOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void zbo(int i, zbvm zbvmVar, zbvx zbvxVar) throws IOException;

    public abstract void zbp(zbvm zbvmVar) throws IOException;

    public abstract void zbq(int i, zbvm zbvmVar) throws IOException;

    public abstract void zbr(int i, zbtc zbtcVar) throws IOException;

    public abstract void zbs(int i, String str) throws IOException;

    public abstract void zbt(String str) throws IOException;

    public abstract void zbu(int i, int i2) throws IOException;

    public abstract void zbv(int i, int i2) throws IOException;

    public abstract void zbw(int i) throws IOException;

    public abstract void zbx(int i, long j) throws IOException;

    public abstract void zby(long j) throws IOException;
}
