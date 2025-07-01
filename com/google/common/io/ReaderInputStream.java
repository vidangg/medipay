package com.google.common.io;

import com.google.common.base.Preconditions;
import com.google.common.primitives.UnsignedBytes;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import java.nio.charset.CodingErrorAction;
import java.util.Arrays;

@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
final class ReaderInputStream extends InputStream {
    private ByteBuffer byteBuffer;
    private CharBuffer charBuffer;
    private boolean doneFlushing;
    private boolean draining;
    private final CharsetEncoder encoder;
    private boolean endOfInput;
    private final Reader reader;
    private final byte[] singleByte;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ReaderInputStream(Reader reader, Charset charset, int bufferSize) {
        this(reader, charset.newEncoder().onMalformedInput(CodingErrorAction.REPLACE).onUnmappableCharacter(CodingErrorAction.REPLACE), bufferSize);
    }

    ReaderInputStream(Reader reader, CharsetEncoder encoder, int bufferSize) {
        this.singleByte = new byte[1];
        this.reader = (Reader) Preconditions.checkNotNull(reader);
        this.encoder = (CharsetEncoder) Preconditions.checkNotNull(encoder);
        Preconditions.checkArgument(bufferSize > 0, "bufferSize must be positive: %s", bufferSize);
        encoder.reset();
        CharBuffer allocate = CharBuffer.allocate(bufferSize);
        this.charBuffer = allocate;
        Java8Compatibility.flip(allocate);
        this.byteBuffer = ByteBuffer.allocate(bufferSize);
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.reader.close();
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (read(this.singleByte) == 1) {
            return UnsignedBytes.toInt(this.singleByte[0]);
        }
        return -1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0029, code lost:
    
        if (r2 <= 0) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x002c, code lost:
    
        return -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:?, code lost:
    
        return r2;
     */
    @Override // java.io.InputStream
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int read(byte[] b, int off, int len) throws IOException {
        CoderResult encode;
        Preconditions.checkPositionIndexes(off, off + len, b.length);
        if (len == 0) {
            return 0;
        }
        boolean z = this.endOfInput;
        int i = 0;
        while (true) {
            if (this.draining) {
                i += drain(b, off + i, len - i);
                if (i == len || this.doneFlushing) {
                    break;
                }
                this.draining = false;
                Java8Compatibility.clear(this.byteBuffer);
            }
            while (true) {
                if (this.doneFlushing) {
                    encode = CoderResult.UNDERFLOW;
                } else if (z) {
                    encode = this.encoder.flush(this.byteBuffer);
                } else {
                    encode = this.encoder.encode(this.charBuffer, this.byteBuffer, this.endOfInput);
                }
                if (encode.isOverflow()) {
                    startDraining(true);
                    break;
                }
                if (encode.isUnderflow()) {
                    if (z) {
                        this.doneFlushing = true;
                        startDraining(false);
                        break;
                    }
                    if (this.endOfInput) {
                        z = true;
                    } else {
                        readMoreChars();
                    }
                } else if (encode.isError()) {
                    encode.throwException();
                    return 0;
                }
            }
        }
    }

    private static CharBuffer grow(CharBuffer buf) {
        CharBuffer wrap = CharBuffer.wrap(Arrays.copyOf(buf.array(), buf.capacity() * 2));
        Java8Compatibility.position(wrap, buf.position());
        Java8Compatibility.limit(wrap, buf.limit());
        return wrap;
    }

    private void readMoreChars() throws IOException {
        if (availableCapacity(this.charBuffer) == 0) {
            if (this.charBuffer.position() > 0) {
                Java8Compatibility.flip(this.charBuffer.compact());
            } else {
                this.charBuffer = grow(this.charBuffer);
            }
        }
        int limit = this.charBuffer.limit();
        int read = this.reader.read(this.charBuffer.array(), limit, availableCapacity(this.charBuffer));
        if (read == -1) {
            this.endOfInput = true;
        } else {
            Java8Compatibility.limit(this.charBuffer, limit + read);
        }
    }

    private static int availableCapacity(Buffer buffer) {
        return buffer.capacity() - buffer.limit();
    }

    private void startDraining(boolean overflow) {
        Java8Compatibility.flip(this.byteBuffer);
        if (overflow && this.byteBuffer.remaining() == 0) {
            this.byteBuffer = ByteBuffer.allocate(this.byteBuffer.capacity() * 2);
        } else {
            this.draining = true;
        }
    }

    private int drain(byte[] b, int off, int len) {
        int min = Math.min(len, this.byteBuffer.remaining());
        this.byteBuffer.get(b, off, min);
        return min;
    }
}
