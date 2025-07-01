package org.apache.commons.io.output;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public class ByteArrayOutputStream extends OutputStream {
    private static final byte[] EMPTY_BYTE_ARRAY = new byte[0];
    private List buffers;
    private int count;
    private byte[] currentBuffer;
    private int currentBufferIndex;
    private int filledBufferSum;

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
    }

    public ByteArrayOutputStream() {
        this(1024);
    }

    public ByteArrayOutputStream(int i) {
        this.buffers = new ArrayList();
        if (i < 0) {
            throw new IllegalArgumentException(new StringBuffer("Negative initial size: ").append(i).toString());
        }
        needNewBuffer(i);
    }

    private byte[] getBuffer(int i) {
        return (byte[]) this.buffers.get(i);
    }

    private void needNewBuffer(int i) {
        if (this.currentBufferIndex < this.buffers.size() - 1) {
            this.filledBufferSum += this.currentBuffer.length;
            int i2 = this.currentBufferIndex + 1;
            this.currentBufferIndex = i2;
            this.currentBuffer = getBuffer(i2);
            return;
        }
        byte[] bArr = this.currentBuffer;
        if (bArr == null) {
            this.filledBufferSum = 0;
        } else {
            i = Math.max(bArr.length << 1, i - this.filledBufferSum);
            this.filledBufferSum += this.currentBuffer.length;
        }
        this.currentBufferIndex++;
        byte[] bArr2 = new byte[i];
        this.currentBuffer = bArr2;
        this.buffers.add(bArr2);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) {
        int i3;
        if (i < 0 || i > bArr.length || i2 < 0 || (i3 = i + i2) > bArr.length || i3 < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (i2 == 0) {
            return;
        }
        synchronized (this) {
            int i4 = this.count;
            int i5 = i4 + i2;
            int i6 = i4 - this.filledBufferSum;
            while (i2 > 0) {
                int min = Math.min(i2, this.currentBuffer.length - i6);
                System.arraycopy(bArr, i3 - i2, this.currentBuffer, i6, min);
                i2 -= min;
                if (i2 > 0) {
                    needNewBuffer(i5);
                    i6 = 0;
                }
            }
            this.count = i5;
        }
    }

    @Override // java.io.OutputStream
    public synchronized void write(int i) {
        int i2 = this.count;
        int i3 = i2 - this.filledBufferSum;
        if (i3 == this.currentBuffer.length) {
            needNewBuffer(i2 + 1);
            i3 = 0;
        }
        this.currentBuffer[i3] = (byte) i;
        this.count++;
    }

    public synchronized int size() {
        return this.count;
    }

    public synchronized void reset() {
        this.count = 0;
        this.filledBufferSum = 0;
        this.currentBufferIndex = 0;
        this.currentBuffer = getBuffer(0);
    }

    public synchronized void writeTo(OutputStream outputStream) throws IOException {
        int i = this.count;
        for (int i2 = 0; i2 < this.buffers.size(); i2++) {
            byte[] buffer = getBuffer(i2);
            int min = Math.min(buffer.length, i);
            outputStream.write(buffer, 0, min);
            i -= min;
            if (i == 0) {
                break;
            }
        }
    }

    public synchronized byte[] toByteArray() {
        int i = this.count;
        if (i == 0) {
            return EMPTY_BYTE_ARRAY;
        }
        byte[] bArr = new byte[i];
        int i2 = 0;
        for (int i3 = 0; i3 < this.buffers.size(); i3++) {
            byte[] buffer = getBuffer(i3);
            int min = Math.min(buffer.length, i);
            System.arraycopy(buffer, 0, bArr, i2, min);
            i2 += min;
            i -= min;
            if (i == 0) {
                break;
            }
        }
        return bArr;
    }

    public String toString() {
        return new String(toByteArray());
    }

    public String toString(String str) throws UnsupportedEncodingException {
        return new String(toByteArray(), str);
    }
}
