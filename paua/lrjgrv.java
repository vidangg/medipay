package paua;

import android.util.Base64;
import java.io.ByteArrayOutputStream;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes4.dex */
public class lrjgrv {
    private byte[] yoba;

    public lrjgrv(List<String> list, String str) {
        String tzend = btj.tzend(156);
        if (list == null || list.isEmpty()) {
            throw new RuntimeException(tzend);
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] decode = Base64.decode(str, 2);
        if (str == null || decode.length < 32) {
            throw new RuntimeException(tzend);
        }
        try {
            byteArrayOutputStream.write(jtxsch(decode.length));
            byteArrayOutputStream.write(decode);
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                byte[] decode2 = Base64.decode(it.next(), 2);
                byteArrayOutputStream.write(jtxsch(decode2.length));
                byteArrayOutputStream.write(decode2);
            }
            this.yoba = byteArrayOutputStream.toByteArray();
        } catch (Exception unused) {
            throw new RuntimeException(tzend);
        }
    }

    public static byte[] jtxsch(int i) {
        byte[] bArr = new byte[4];
        for (int i2 = 3; i2 >= 0; i2--) {
            bArr[i2] = (byte) (i & 255);
            i >>= 8;
        }
        return bArr;
    }

    public byte[] mxwlt() {
        return btj.pnnbsc(this.yoba);
    }
}
