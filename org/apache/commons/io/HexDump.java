package org.apache.commons.io;

import java.io.IOException;
import java.io.OutputStream;

/* loaded from: classes4.dex */
public class HexDump {
    public static final String EOL = System.getProperty("line.separator");
    private static final StringBuffer _lbuffer = new StringBuffer(8);
    private static final StringBuffer _cbuffer = new StringBuffer(2);
    private static final char[] _hexcodes = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    private static final int[] _shifts = {28, 24, 20, 16, 12, 8, 4, 0};

    public static void dump(byte[] bArr, long j, OutputStream outputStream, int i) throws IOException, ArrayIndexOutOfBoundsException, IllegalArgumentException {
        if (i < 0 || i >= bArr.length) {
            throw new ArrayIndexOutOfBoundsException(new StringBuffer("illegal index: ").append(i).append(" into array of length ").append(bArr.length).toString());
        }
        if (outputStream == null) {
            throw new IllegalArgumentException("cannot write to nullstream");
        }
        long j2 = j + i;
        StringBuffer stringBuffer = new StringBuffer(74);
        while (i < bArr.length) {
            int length = bArr.length - i;
            if (length > 16) {
                length = 16;
            }
            stringBuffer.append(dump(j2)).append(' ');
            for (int i2 = 0; i2 < 16; i2++) {
                if (i2 < length) {
                    stringBuffer.append(dump(bArr[i2 + i]));
                } else {
                    stringBuffer.append("  ");
                }
                stringBuffer.append(' ');
            }
            for (int i3 = 0; i3 < length; i3++) {
                byte b = bArr[i3 + i];
                if (b >= 32 && b < Byte.MAX_VALUE) {
                    stringBuffer.append((char) b);
                } else {
                    stringBuffer.append('.');
                }
            }
            stringBuffer.append(EOL);
            outputStream.write(stringBuffer.toString().getBytes());
            outputStream.flush();
            stringBuffer.setLength(0);
            j2 += length;
            i += 16;
        }
    }

    private static StringBuffer dump(long j) {
        _lbuffer.setLength(0);
        for (int i = 0; i < 8; i++) {
            _lbuffer.append(_hexcodes[((int) (j >> _shifts[i])) & 15]);
        }
        return _lbuffer;
    }

    private static StringBuffer dump(byte b) {
        _cbuffer.setLength(0);
        for (int i = 0; i < 2; i++) {
            _cbuffer.append(_hexcodes[(b >> _shifts[i + 6]) & 15]);
        }
        return _cbuffer;
    }
}
