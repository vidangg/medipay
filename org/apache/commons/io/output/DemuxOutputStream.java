package org.apache.commons.io.output;

import java.io.IOException;
import java.io.OutputStream;

/* loaded from: classes4.dex */
public class DemuxOutputStream extends OutputStream {
    private InheritableThreadLocal m_streams = new InheritableThreadLocal();

    public OutputStream bindStream(OutputStream outputStream) {
        OutputStream stream = getStream();
        this.m_streams.set(outputStream);
        return stream;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        OutputStream stream = getStream();
        if (stream != null) {
            stream.close();
        }
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        OutputStream stream = getStream();
        if (stream != null) {
            stream.flush();
        }
    }

    @Override // java.io.OutputStream
    public void write(int i) throws IOException {
        OutputStream stream = getStream();
        if (stream != null) {
            stream.write(i);
        }
    }

    private OutputStream getStream() {
        return (OutputStream) this.m_streams.get();
    }
}
