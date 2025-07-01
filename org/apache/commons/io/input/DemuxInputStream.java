package org.apache.commons.io.input;

import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes4.dex */
public class DemuxInputStream extends InputStream {
    private InheritableThreadLocal m_streams = new InheritableThreadLocal();

    public InputStream bindStream(InputStream inputStream) {
        InputStream stream = getStream();
        this.m_streams.set(inputStream);
        return stream;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        InputStream stream = getStream();
        if (stream != null) {
            stream.close();
        }
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        InputStream stream = getStream();
        if (stream != null) {
            return stream.read();
        }
        return -1;
    }

    private InputStream getStream() {
        return (InputStream) this.m_streams.get();
    }
}
