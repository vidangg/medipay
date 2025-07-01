package org.apache.commons.io.input;

import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes4.dex */
public class CountingInputStream extends ProxyInputStream {
    private long count;

    public CountingInputStream(InputStream inputStream) {
        super(inputStream);
    }

    @Override // org.apache.commons.io.input.ProxyInputStream, java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        int read = super.read(bArr);
        this.count += read >= 0 ? read : 0L;
        return read;
    }

    @Override // org.apache.commons.io.input.ProxyInputStream, java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        int read = super.read(bArr, i, i2);
        this.count += read >= 0 ? read : 0L;
        return read;
    }

    @Override // org.apache.commons.io.input.ProxyInputStream, java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        int read = super.read();
        this.count += read >= 0 ? 1L : 0L;
        return read;
    }

    @Override // org.apache.commons.io.input.ProxyInputStream, java.io.FilterInputStream, java.io.InputStream
    public long skip(long j) throws IOException {
        long skip = super.skip(j);
        this.count += skip;
        return skip;
    }

    public synchronized int getCount() {
        long byteCount;
        byteCount = getByteCount();
        if (byteCount > 2147483647L) {
            throw new ArithmeticException(new StringBuffer("The byte count ").append(byteCount).append(" is too large to be converted to an int").toString());
        }
        return (int) byteCount;
    }

    public synchronized int resetCount() {
        long resetByteCount;
        resetByteCount = resetByteCount();
        if (resetByteCount > 2147483647L) {
            throw new ArithmeticException(new StringBuffer("The byte count ").append(resetByteCount).append(" is too large to be converted to an int").toString());
        }
        return (int) resetByteCount;
    }

    public synchronized long getByteCount() {
        return this.count;
    }

    public synchronized long resetByteCount() {
        long j;
        j = this.count;
        this.count = 0L;
        return j;
    }
}
