package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.MessageLite;
import com.google.common.base.Ascii;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlinx.coroutines.scheduling.WorkQueueKt;

/* loaded from: classes.dex */
public abstract class CodedInputStream {
    private static final int DEFAULT_BUFFER_SIZE = 4096;
    private static final int DEFAULT_SIZE_LIMIT = Integer.MAX_VALUE;
    private static volatile int defaultRecursionLimit = 100;
    int recursionDepth;
    int recursionLimit;
    private boolean shouldDiscardUnknownFields;
    int sizeLimit;
    CodedInputStreamReader wrapper;

    public static int decodeZigZag32(final int n) {
        return (-(n & 1)) ^ (n >>> 1);
    }

    public static long decodeZigZag64(final long n) {
        return (-(n & 1)) ^ (n >>> 1);
    }

    public abstract void checkLastTagWas(final int value) throws InvalidProtocolBufferException;

    public abstract void enableAliasing(boolean enabled);

    public abstract int getBytesUntilLimit();

    public abstract int getLastTag();

    public abstract int getTotalBytesRead();

    public abstract boolean isAtEnd() throws IOException;

    public abstract void popLimit(final int oldLimit);

    public abstract int pushLimit(int byteLimit) throws InvalidProtocolBufferException;

    public abstract boolean readBool() throws IOException;

    public abstract byte[] readByteArray() throws IOException;

    public abstract ByteBuffer readByteBuffer() throws IOException;

    public abstract ByteString readBytes() throws IOException;

    public abstract double readDouble() throws IOException;

    public abstract int readEnum() throws IOException;

    public abstract int readFixed32() throws IOException;

    public abstract long readFixed64() throws IOException;

    public abstract float readFloat() throws IOException;

    public abstract <T extends MessageLite> T readGroup(final int fieldNumber, final Parser<T> parser, final ExtensionRegistryLite extensionRegistry) throws IOException;

    public abstract void readGroup(final int fieldNumber, final MessageLite.Builder builder, final ExtensionRegistryLite extensionRegistry) throws IOException;

    public abstract int readInt32() throws IOException;

    public abstract long readInt64() throws IOException;

    public abstract <T extends MessageLite> T readMessage(final Parser<T> parser, final ExtensionRegistryLite extensionRegistry) throws IOException;

    public abstract void readMessage(final MessageLite.Builder builder, final ExtensionRegistryLite extensionRegistry) throws IOException;

    public abstract byte readRawByte() throws IOException;

    public abstract byte[] readRawBytes(final int size) throws IOException;

    public abstract int readRawLittleEndian32() throws IOException;

    public abstract long readRawLittleEndian64() throws IOException;

    public abstract int readRawVarint32() throws IOException;

    public abstract long readRawVarint64() throws IOException;

    abstract long readRawVarint64SlowPath() throws IOException;

    public abstract int readSFixed32() throws IOException;

    public abstract long readSFixed64() throws IOException;

    public abstract int readSInt32() throws IOException;

    public abstract long readSInt64() throws IOException;

    public abstract String readString() throws IOException;

    public abstract String readStringRequireUtf8() throws IOException;

    public abstract int readTag() throws IOException;

    public abstract int readUInt32() throws IOException;

    public abstract long readUInt64() throws IOException;

    @Deprecated
    public abstract void readUnknownGroup(final int fieldNumber, final MessageLite.Builder builder) throws IOException;

    public abstract void resetSizeCounter();

    public abstract boolean skipField(final int tag) throws IOException;

    @Deprecated
    public abstract boolean skipField(final int tag, final CodedOutputStream output) throws IOException;

    public abstract void skipRawBytes(final int size) throws IOException;

    public static CodedInputStream newInstance(final InputStream input) {
        return newInstance(input, 4096);
    }

    public static CodedInputStream newInstance(final InputStream input, int bufferSize) {
        if (bufferSize <= 0) {
            throw new IllegalArgumentException("bufferSize must be > 0");
        }
        if (input == null) {
            return newInstance(Internal.EMPTY_BYTE_ARRAY);
        }
        return new StreamDecoder(input, bufferSize);
    }

    public static CodedInputStream newInstance(final Iterable<ByteBuffer> input) {
        if (!UnsafeDirectNioDecoder.isSupported()) {
            return newInstance(new IterableByteBufferInputStream(input));
        }
        return newInstance(input, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static CodedInputStream newInstance(final Iterable<ByteBuffer> bufs, final boolean bufferIsImmutable) {
        int i = 0;
        int i2 = 0;
        for (ByteBuffer byteBuffer : bufs) {
            i2 += byteBuffer.remaining();
            if (byteBuffer.hasArray()) {
                i |= 1;
            } else {
                i = byteBuffer.isDirect() ? i | 2 : i | 4;
            }
        }
        if (i == 2) {
            return new IterableDirectByteBufferDecoder(bufs, i2, bufferIsImmutable);
        }
        return newInstance(new IterableByteBufferInputStream(bufs));
    }

    public static CodedInputStream newInstance(final byte[] buf) {
        return newInstance(buf, 0, buf.length);
    }

    public static CodedInputStream newInstance(final byte[] buf, final int off, final int len) {
        return newInstance(buf, off, len, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static CodedInputStream newInstance(final byte[] buf, final int off, final int len, final boolean bufferIsImmutable) {
        ArrayDecoder arrayDecoder = new ArrayDecoder(buf, off, len, bufferIsImmutable);
        try {
            arrayDecoder.pushLimit(len);
            return arrayDecoder;
        } catch (InvalidProtocolBufferException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static CodedInputStream newInstance(ByteBuffer buf) {
        return newInstance(buf, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static CodedInputStream newInstance(ByteBuffer buf, boolean bufferIsImmutable) {
        if (buf.hasArray()) {
            return newInstance(buf.array(), buf.arrayOffset() + buf.position(), buf.remaining(), bufferIsImmutable);
        }
        if (buf.isDirect() && UnsafeDirectNioDecoder.isSupported()) {
            return new UnsafeDirectNioDecoder(buf, bufferIsImmutable);
        }
        int remaining = buf.remaining();
        byte[] bArr = new byte[remaining];
        buf.duplicate().get(bArr);
        return newInstance(bArr, 0, remaining, true);
    }

    public void checkRecursionLimit() throws InvalidProtocolBufferException {
        if (this.recursionDepth >= this.recursionLimit) {
            throw InvalidProtocolBufferException.recursionLimitExceeded();
        }
    }

    private CodedInputStream() {
        this.recursionLimit = defaultRecursionLimit;
        this.sizeLimit = Integer.MAX_VALUE;
        this.shouldDiscardUnknownFields = false;
    }

    public void skipMessage() throws IOException {
        int readTag;
        do {
            readTag = readTag();
            if (readTag == 0) {
                return;
            }
            checkRecursionLimit();
            this.recursionDepth++;
            this.recursionDepth--;
        } while (skipField(readTag));
    }

    public void skipMessage(CodedOutputStream output) throws IOException {
        int readTag;
        do {
            readTag = readTag();
            if (readTag == 0) {
                return;
            }
            checkRecursionLimit();
            this.recursionDepth++;
            this.recursionDepth--;
        } while (skipField(readTag, output));
    }

    public final int setRecursionLimit(final int limit) {
        if (limit < 0) {
            throw new IllegalArgumentException("Recursion limit cannot be negative: " + limit);
        }
        int i = this.recursionLimit;
        this.recursionLimit = limit;
        return i;
    }

    public final int setSizeLimit(final int limit) {
        if (limit < 0) {
            throw new IllegalArgumentException("Size limit cannot be negative: " + limit);
        }
        int i = this.sizeLimit;
        this.sizeLimit = limit;
        return i;
    }

    final void discardUnknownFields() {
        this.shouldDiscardUnknownFields = true;
    }

    final void unsetDiscardUnknownFields() {
        this.shouldDiscardUnknownFields = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean shouldDiscardUnknownFields() {
        return this.shouldDiscardUnknownFields;
    }

    public static int readRawVarint32(final int firstByte, final InputStream input) throws IOException {
        if ((firstByte & 128) == 0) {
            return firstByte;
        }
        int i = firstByte & WorkQueueKt.MASK;
        int i2 = 7;
        while (i2 < 32) {
            int read = input.read();
            if (read == -1) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            i |= (read & WorkQueueKt.MASK) << i2;
            if ((read & 128) == 0) {
                return i;
            }
            i2 += 7;
        }
        while (i2 < 64) {
            int read2 = input.read();
            if (read2 == -1) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            if ((read2 & 128) == 0) {
                return i;
            }
            i2 += 7;
        }
        throw InvalidProtocolBufferException.malformedVarint();
    }

    static int readRawVarint32(final InputStream input) throws IOException {
        int read = input.read();
        if (read == -1) {
            throw InvalidProtocolBufferException.truncatedMessage();
        }
        return readRawVarint32(read, input);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class ArrayDecoder extends CodedInputStream {
        private final byte[] buffer;
        private int bufferSizeAfterLimit;
        private int currentLimit;
        private boolean enableAliasing;
        private final boolean immutable;
        private int lastTag;
        private int limit;
        private int pos;
        private int startPos;

        private ArrayDecoder(final byte[] buffer, final int offset, final int len, boolean immutable) {
            super();
            this.currentLimit = Integer.MAX_VALUE;
            this.buffer = buffer;
            this.limit = len + offset;
            this.pos = offset;
            this.startPos = offset;
            this.immutable = immutable;
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public int readTag() throws IOException {
            if (isAtEnd()) {
                this.lastTag = 0;
                return 0;
            }
            int readRawVarint32 = readRawVarint32();
            this.lastTag = readRawVarint32;
            if (WireFormat.getTagFieldNumber(readRawVarint32) == 0) {
                throw InvalidProtocolBufferException.invalidTag();
            }
            return this.lastTag;
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public void checkLastTagWas(final int value) throws InvalidProtocolBufferException {
            if (this.lastTag != value) {
                throw InvalidProtocolBufferException.invalidEndTag();
            }
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public int getLastTag() {
            return this.lastTag;
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public boolean skipField(final int tag) throws IOException {
            int tagWireType = WireFormat.getTagWireType(tag);
            if (tagWireType == 0) {
                skipRawVarint();
                return true;
            }
            if (tagWireType == 1) {
                skipRawBytes(8);
                return true;
            }
            if (tagWireType == 2) {
                skipRawBytes(readRawVarint32());
                return true;
            }
            if (tagWireType == 3) {
                skipMessage();
                checkLastTagWas(WireFormat.makeTag(WireFormat.getTagFieldNumber(tag), 4));
                return true;
            }
            if (tagWireType == 4) {
                return false;
            }
            if (tagWireType == 5) {
                skipRawBytes(4);
                return true;
            }
            throw InvalidProtocolBufferException.invalidWireType();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public boolean skipField(final int tag, final CodedOutputStream output) throws IOException {
            int tagWireType = WireFormat.getTagWireType(tag);
            if (tagWireType == 0) {
                long readInt64 = readInt64();
                output.writeUInt32NoTag(tag);
                output.writeUInt64NoTag(readInt64);
                return true;
            }
            if (tagWireType == 1) {
                long readRawLittleEndian64 = readRawLittleEndian64();
                output.writeUInt32NoTag(tag);
                output.writeFixed64NoTag(readRawLittleEndian64);
                return true;
            }
            if (tagWireType == 2) {
                ByteString readBytes = readBytes();
                output.writeUInt32NoTag(tag);
                output.writeBytesNoTag(readBytes);
                return true;
            }
            if (tagWireType == 3) {
                output.writeUInt32NoTag(tag);
                skipMessage(output);
                int makeTag = WireFormat.makeTag(WireFormat.getTagFieldNumber(tag), 4);
                checkLastTagWas(makeTag);
                output.writeUInt32NoTag(makeTag);
                return true;
            }
            if (tagWireType == 4) {
                return false;
            }
            if (tagWireType == 5) {
                int readRawLittleEndian32 = readRawLittleEndian32();
                output.writeUInt32NoTag(tag);
                output.writeFixed32NoTag(readRawLittleEndian32);
                return true;
            }
            throw InvalidProtocolBufferException.invalidWireType();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public double readDouble() throws IOException {
            return Double.longBitsToDouble(readRawLittleEndian64());
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public float readFloat() throws IOException {
            return Float.intBitsToFloat(readRawLittleEndian32());
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public long readUInt64() throws IOException {
            return readRawVarint64();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public long readInt64() throws IOException {
            return readRawVarint64();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public int readInt32() throws IOException {
            return readRawVarint32();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public long readFixed64() throws IOException {
            return readRawLittleEndian64();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public int readFixed32() throws IOException {
            return readRawLittleEndian32();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public boolean readBool() throws IOException {
            return readRawVarint64() != 0;
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public String readString() throws IOException {
            int readRawVarint32 = readRawVarint32();
            if (readRawVarint32 > 0) {
                int i = this.limit;
                int i2 = this.pos;
                if (readRawVarint32 <= i - i2) {
                    String str = new String(this.buffer, i2, readRawVarint32, Internal.UTF_8);
                    this.pos += readRawVarint32;
                    return str;
                }
            }
            if (readRawVarint32 == 0) {
                return "";
            }
            if (readRawVarint32 < 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public String readStringRequireUtf8() throws IOException {
            int readRawVarint32 = readRawVarint32();
            if (readRawVarint32 > 0) {
                int i = this.limit;
                int i2 = this.pos;
                if (readRawVarint32 <= i - i2) {
                    String decodeUtf8 = Utf8.decodeUtf8(this.buffer, i2, readRawVarint32);
                    this.pos += readRawVarint32;
                    return decodeUtf8;
                }
            }
            if (readRawVarint32 == 0) {
                return "";
            }
            if (readRawVarint32 <= 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public void readGroup(final int fieldNumber, final MessageLite.Builder builder, final ExtensionRegistryLite extensionRegistry) throws IOException {
            checkRecursionLimit();
            this.recursionDepth++;
            builder.mergeFrom(this, extensionRegistry);
            checkLastTagWas(WireFormat.makeTag(fieldNumber, 4));
            this.recursionDepth--;
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public <T extends MessageLite> T readGroup(final int fieldNumber, final Parser<T> parser, final ExtensionRegistryLite extensionRegistry) throws IOException {
            checkRecursionLimit();
            this.recursionDepth++;
            T parsePartialFrom = parser.parsePartialFrom(this, extensionRegistry);
            checkLastTagWas(WireFormat.makeTag(fieldNumber, 4));
            this.recursionDepth--;
            return parsePartialFrom;
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        @Deprecated
        public void readUnknownGroup(final int fieldNumber, final MessageLite.Builder builder) throws IOException {
            readGroup(fieldNumber, builder, ExtensionRegistryLite.getEmptyRegistry());
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public void readMessage(final MessageLite.Builder builder, final ExtensionRegistryLite extensionRegistry) throws IOException {
            int readRawVarint32 = readRawVarint32();
            checkRecursionLimit();
            int pushLimit = pushLimit(readRawVarint32);
            this.recursionDepth++;
            builder.mergeFrom(this, extensionRegistry);
            checkLastTagWas(0);
            this.recursionDepth--;
            if (getBytesUntilLimit() != 0) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            popLimit(pushLimit);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public <T extends MessageLite> T readMessage(final Parser<T> parser, final ExtensionRegistryLite extensionRegistry) throws IOException {
            int readRawVarint32 = readRawVarint32();
            checkRecursionLimit();
            int pushLimit = pushLimit(readRawVarint32);
            this.recursionDepth++;
            T parsePartialFrom = parser.parsePartialFrom(this, extensionRegistry);
            checkLastTagWas(0);
            this.recursionDepth--;
            if (getBytesUntilLimit() != 0) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            popLimit(pushLimit);
            return parsePartialFrom;
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public ByteString readBytes() throws IOException {
            ByteString copyFrom;
            int readRawVarint32 = readRawVarint32();
            if (readRawVarint32 > 0) {
                int i = this.limit;
                int i2 = this.pos;
                if (readRawVarint32 <= i - i2) {
                    if (this.immutable && this.enableAliasing) {
                        copyFrom = ByteString.wrap(this.buffer, i2, readRawVarint32);
                    } else {
                        copyFrom = ByteString.copyFrom(this.buffer, i2, readRawVarint32);
                    }
                    this.pos += readRawVarint32;
                    return copyFrom;
                }
            }
            if (readRawVarint32 == 0) {
                return ByteString.EMPTY;
            }
            return ByteString.wrap(readRawBytes(readRawVarint32));
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public byte[] readByteArray() throws IOException {
            return readRawBytes(readRawVarint32());
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public ByteBuffer readByteBuffer() throws IOException {
            ByteBuffer wrap;
            int readRawVarint32 = readRawVarint32();
            if (readRawVarint32 > 0) {
                int i = this.limit;
                int i2 = this.pos;
                if (readRawVarint32 <= i - i2) {
                    if (!this.immutable && this.enableAliasing) {
                        wrap = ByteBuffer.wrap(this.buffer, i2, readRawVarint32).slice();
                    } else {
                        wrap = ByteBuffer.wrap(Arrays.copyOfRange(this.buffer, i2, i2 + readRawVarint32));
                    }
                    this.pos += readRawVarint32;
                    return wrap;
                }
            }
            if (readRawVarint32 == 0) {
                return Internal.EMPTY_BYTE_BUFFER;
            }
            if (readRawVarint32 < 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public int readUInt32() throws IOException {
            return readRawVarint32();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public int readEnum() throws IOException {
            return readRawVarint32();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public int readSFixed32() throws IOException {
            return readRawLittleEndian32();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public long readSFixed64() throws IOException {
            return readRawLittleEndian64();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public int readSInt32() throws IOException {
            return decodeZigZag32(readRawVarint32());
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public long readSInt64() throws IOException {
            return decodeZigZag64(readRawVarint64());
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public int readRawVarint32() throws IOException {
            int i;
            int i2 = this.pos;
            int i3 = this.limit;
            if (i3 != i2) {
                byte[] bArr = this.buffer;
                int i4 = i2 + 1;
                byte b = bArr[i2];
                if (b >= 0) {
                    this.pos = i4;
                    return b;
                }
                if (i3 - i4 >= 9) {
                    int i5 = i2 + 2;
                    int i6 = (bArr[i4] << 7) ^ b;
                    if (i6 < 0) {
                        i = i6 ^ (-128);
                    } else {
                        int i7 = i2 + 3;
                        int i8 = (bArr[i5] << Ascii.SO) ^ i6;
                        if (i8 >= 0) {
                            i = i8 ^ 16256;
                        } else {
                            int i9 = i2 + 4;
                            int i10 = i8 ^ (bArr[i7] << Ascii.NAK);
                            if (i10 < 0) {
                                i = (-2080896) ^ i10;
                            } else {
                                i7 = i2 + 5;
                                byte b2 = bArr[i9];
                                int i11 = (i10 ^ (b2 << Ascii.FS)) ^ 266354560;
                                if (b2 < 0) {
                                    i9 = i2 + 6;
                                    if (bArr[i7] < 0) {
                                        i7 = i2 + 7;
                                        if (bArr[i9] < 0) {
                                            i9 = i2 + 8;
                                            if (bArr[i7] < 0) {
                                                i7 = i2 + 9;
                                                if (bArr[i9] < 0) {
                                                    int i12 = i2 + 10;
                                                    if (bArr[i7] >= 0) {
                                                        i5 = i12;
                                                        i = i11;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    i = i11;
                                }
                                i = i11;
                            }
                            i5 = i9;
                        }
                        i5 = i7;
                    }
                    this.pos = i5;
                    return i;
                }
            }
            return (int) readRawVarint64SlowPath();
        }

        private void skipRawVarint() throws IOException {
            if (this.limit - this.pos >= 10) {
                skipRawVarintFastPath();
            } else {
                skipRawVarintSlowPath();
            }
        }

        private void skipRawVarintFastPath() throws IOException {
            for (int i = 0; i < 10; i++) {
                byte[] bArr = this.buffer;
                int i2 = this.pos;
                this.pos = i2 + 1;
                if (bArr[i2] >= 0) {
                    return;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        private void skipRawVarintSlowPath() throws IOException {
            for (int i = 0; i < 10; i++) {
                if (readRawByte() >= 0) {
                    return;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public long readRawVarint64() throws IOException {
            long j;
            long j2;
            long j3;
            int i = this.pos;
            int i2 = this.limit;
            if (i2 != i) {
                byte[] bArr = this.buffer;
                int i3 = i + 1;
                byte b = bArr[i];
                if (b >= 0) {
                    this.pos = i3;
                    return b;
                }
                if (i2 - i3 >= 9) {
                    int i4 = i + 2;
                    int i5 = (bArr[i3] << 7) ^ b;
                    if (i5 < 0) {
                        j = i5 ^ (-128);
                    } else {
                        int i6 = i + 3;
                        int i7 = (bArr[i4] << Ascii.SO) ^ i5;
                        if (i7 >= 0) {
                            j = i7 ^ 16256;
                            i4 = i6;
                        } else {
                            int i8 = i + 4;
                            int i9 = i7 ^ (bArr[i6] << Ascii.NAK);
                            if (i9 < 0) {
                                long j4 = (-2080896) ^ i9;
                                i4 = i8;
                                j = j4;
                            } else {
                                long j5 = i9;
                                i4 = i + 5;
                                long j6 = j5 ^ (bArr[i8] << 28);
                                if (j6 >= 0) {
                                    j3 = 266354560;
                                } else {
                                    int i10 = i + 6;
                                    long j7 = j6 ^ (bArr[i4] << 35);
                                    if (j7 < 0) {
                                        j2 = -34093383808L;
                                    } else {
                                        i4 = i + 7;
                                        j6 = j7 ^ (bArr[i10] << 42);
                                        if (j6 >= 0) {
                                            j3 = 4363953127296L;
                                        } else {
                                            i10 = i + 8;
                                            j7 = j6 ^ (bArr[i4] << 49);
                                            if (j7 < 0) {
                                                j2 = -558586000294016L;
                                            } else {
                                                i4 = i + 9;
                                                long j8 = (j7 ^ (bArr[i10] << 56)) ^ 71499008037633920L;
                                                if (j8 < 0) {
                                                    int i11 = i + 10;
                                                    if (bArr[i4] >= 0) {
                                                        i4 = i11;
                                                    }
                                                }
                                                j = j8;
                                            }
                                        }
                                    }
                                    j = j7 ^ j2;
                                    i4 = i10;
                                }
                                j = j6 ^ j3;
                            }
                        }
                    }
                    this.pos = i4;
                    return j;
                }
            }
            return readRawVarint64SlowPath();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        long readRawVarint64SlowPath() throws IOException {
            long j = 0;
            for (int i = 0; i < 64; i += 7) {
                j |= (r3 & Byte.MAX_VALUE) << i;
                if ((readRawByte() & 128) == 0) {
                    return j;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public int readRawLittleEndian32() throws IOException {
            int i = this.pos;
            if (this.limit - i < 4) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            byte[] bArr = this.buffer;
            this.pos = i + 4;
            return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public long readRawLittleEndian64() throws IOException {
            int i = this.pos;
            if (this.limit - i < 8) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            byte[] bArr = this.buffer;
            this.pos = i + 8;
            return ((bArr[i + 7] & 255) << 56) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16) | ((bArr[i + 3] & 255) << 24) | ((bArr[i + 4] & 255) << 32) | ((bArr[i + 5] & 255) << 40) | ((bArr[i + 6] & 255) << 48);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public void enableAliasing(boolean enabled) {
            this.enableAliasing = enabled;
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public void resetSizeCounter() {
            this.startPos = this.pos;
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public int pushLimit(int byteLimit) throws InvalidProtocolBufferException {
            if (byteLimit < 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            int totalBytesRead = byteLimit + getTotalBytesRead();
            if (totalBytesRead < 0) {
                throw InvalidProtocolBufferException.parseFailure();
            }
            int i = this.currentLimit;
            if (totalBytesRead > i) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            this.currentLimit = totalBytesRead;
            recomputeBufferSizeAfterLimit();
            return i;
        }

        private void recomputeBufferSizeAfterLimit() {
            int i = this.limit + this.bufferSizeAfterLimit;
            this.limit = i;
            int i2 = i - this.startPos;
            int i3 = this.currentLimit;
            if (i2 > i3) {
                int i4 = i2 - i3;
                this.bufferSizeAfterLimit = i4;
                this.limit = i - i4;
                return;
            }
            this.bufferSizeAfterLimit = 0;
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public void popLimit(final int oldLimit) {
            this.currentLimit = oldLimit;
            recomputeBufferSizeAfterLimit();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public int getBytesUntilLimit() {
            int i = this.currentLimit;
            if (i == Integer.MAX_VALUE) {
                return -1;
            }
            return i - getTotalBytesRead();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public boolean isAtEnd() throws IOException {
            return this.pos == this.limit;
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public int getTotalBytesRead() {
            return this.pos - this.startPos;
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public byte readRawByte() throws IOException {
            int i = this.pos;
            if (i == this.limit) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            byte[] bArr = this.buffer;
            this.pos = i + 1;
            return bArr[i];
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public byte[] readRawBytes(final int length) throws IOException {
            if (length > 0) {
                int i = this.limit;
                int i2 = this.pos;
                if (length <= i - i2) {
                    int i3 = length + i2;
                    this.pos = i3;
                    return Arrays.copyOfRange(this.buffer, i2, i3);
                }
            }
            if (length > 0) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            if (length == 0) {
                return Internal.EMPTY_BYTE_ARRAY;
            }
            throw InvalidProtocolBufferException.negativeSize();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public void skipRawBytes(final int length) throws IOException {
            if (length >= 0) {
                int i = this.limit;
                int i2 = this.pos;
                if (length <= i - i2) {
                    this.pos = i2 + length;
                    return;
                }
            }
            if (length < 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class UnsafeDirectNioDecoder extends CodedInputStream {
        private final long address;
        private final ByteBuffer buffer;
        private int bufferSizeAfterLimit;
        private int currentLimit;
        private boolean enableAliasing;
        private final boolean immutable;
        private int lastTag;
        private long limit;
        private long pos;
        private long startPos;

        static boolean isSupported() {
            return UnsafeUtil.hasUnsafeByteBufferOperations();
        }

        private UnsafeDirectNioDecoder(ByteBuffer buffer, boolean immutable) {
            super();
            this.currentLimit = Integer.MAX_VALUE;
            this.buffer = buffer;
            long addressOffset = UnsafeUtil.addressOffset(buffer);
            this.address = addressOffset;
            this.limit = buffer.limit() + addressOffset;
            long position = addressOffset + buffer.position();
            this.pos = position;
            this.startPos = position;
            this.immutable = immutable;
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public int readTag() throws IOException {
            if (isAtEnd()) {
                this.lastTag = 0;
                return 0;
            }
            int readRawVarint32 = readRawVarint32();
            this.lastTag = readRawVarint32;
            if (WireFormat.getTagFieldNumber(readRawVarint32) == 0) {
                throw InvalidProtocolBufferException.invalidTag();
            }
            return this.lastTag;
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public void checkLastTagWas(final int value) throws InvalidProtocolBufferException {
            if (this.lastTag != value) {
                throw InvalidProtocolBufferException.invalidEndTag();
            }
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public int getLastTag() {
            return this.lastTag;
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public boolean skipField(final int tag) throws IOException {
            int tagWireType = WireFormat.getTagWireType(tag);
            if (tagWireType == 0) {
                skipRawVarint();
                return true;
            }
            if (tagWireType == 1) {
                skipRawBytes(8);
                return true;
            }
            if (tagWireType == 2) {
                skipRawBytes(readRawVarint32());
                return true;
            }
            if (tagWireType == 3) {
                skipMessage();
                checkLastTagWas(WireFormat.makeTag(WireFormat.getTagFieldNumber(tag), 4));
                return true;
            }
            if (tagWireType == 4) {
                return false;
            }
            if (tagWireType == 5) {
                skipRawBytes(4);
                return true;
            }
            throw InvalidProtocolBufferException.invalidWireType();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public boolean skipField(final int tag, final CodedOutputStream output) throws IOException {
            int tagWireType = WireFormat.getTagWireType(tag);
            if (tagWireType == 0) {
                long readInt64 = readInt64();
                output.writeUInt32NoTag(tag);
                output.writeUInt64NoTag(readInt64);
                return true;
            }
            if (tagWireType == 1) {
                long readRawLittleEndian64 = readRawLittleEndian64();
                output.writeUInt32NoTag(tag);
                output.writeFixed64NoTag(readRawLittleEndian64);
                return true;
            }
            if (tagWireType == 2) {
                ByteString readBytes = readBytes();
                output.writeUInt32NoTag(tag);
                output.writeBytesNoTag(readBytes);
                return true;
            }
            if (tagWireType == 3) {
                output.writeUInt32NoTag(tag);
                skipMessage(output);
                int makeTag = WireFormat.makeTag(WireFormat.getTagFieldNumber(tag), 4);
                checkLastTagWas(makeTag);
                output.writeUInt32NoTag(makeTag);
                return true;
            }
            if (tagWireType == 4) {
                return false;
            }
            if (tagWireType == 5) {
                int readRawLittleEndian32 = readRawLittleEndian32();
                output.writeUInt32NoTag(tag);
                output.writeFixed32NoTag(readRawLittleEndian32);
                return true;
            }
            throw InvalidProtocolBufferException.invalidWireType();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public double readDouble() throws IOException {
            return Double.longBitsToDouble(readRawLittleEndian64());
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public float readFloat() throws IOException {
            return Float.intBitsToFloat(readRawLittleEndian32());
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public long readUInt64() throws IOException {
            return readRawVarint64();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public long readInt64() throws IOException {
            return readRawVarint64();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public int readInt32() throws IOException {
            return readRawVarint32();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public long readFixed64() throws IOException {
            return readRawLittleEndian64();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public int readFixed32() throws IOException {
            return readRawLittleEndian32();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public boolean readBool() throws IOException {
            return readRawVarint64() != 0;
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public String readString() throws IOException {
            int readRawVarint32 = readRawVarint32();
            if (readRawVarint32 <= 0 || readRawVarint32 > remaining()) {
                if (readRawVarint32 == 0) {
                    return "";
                }
                if (readRawVarint32 < 0) {
                    throw InvalidProtocolBufferException.negativeSize();
                }
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            byte[] bArr = new byte[readRawVarint32];
            long j = readRawVarint32;
            UnsafeUtil.copyMemory(this.pos, bArr, 0L, j);
            String str = new String(bArr, Internal.UTF_8);
            this.pos += j;
            return str;
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public String readStringRequireUtf8() throws IOException {
            int readRawVarint32 = readRawVarint32();
            if (readRawVarint32 > 0 && readRawVarint32 <= remaining()) {
                String decodeUtf8 = Utf8.decodeUtf8(this.buffer, bufferPos(this.pos), readRawVarint32);
                this.pos += readRawVarint32;
                return decodeUtf8;
            }
            if (readRawVarint32 == 0) {
                return "";
            }
            if (readRawVarint32 <= 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public void readGroup(final int fieldNumber, final MessageLite.Builder builder, final ExtensionRegistryLite extensionRegistry) throws IOException {
            checkRecursionLimit();
            this.recursionDepth++;
            builder.mergeFrom(this, extensionRegistry);
            checkLastTagWas(WireFormat.makeTag(fieldNumber, 4));
            this.recursionDepth--;
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public <T extends MessageLite> T readGroup(final int fieldNumber, final Parser<T> parser, final ExtensionRegistryLite extensionRegistry) throws IOException {
            checkRecursionLimit();
            this.recursionDepth++;
            T parsePartialFrom = parser.parsePartialFrom(this, extensionRegistry);
            checkLastTagWas(WireFormat.makeTag(fieldNumber, 4));
            this.recursionDepth--;
            return parsePartialFrom;
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        @Deprecated
        public void readUnknownGroup(final int fieldNumber, final MessageLite.Builder builder) throws IOException {
            readGroup(fieldNumber, builder, ExtensionRegistryLite.getEmptyRegistry());
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public void readMessage(final MessageLite.Builder builder, final ExtensionRegistryLite extensionRegistry) throws IOException {
            int readRawVarint32 = readRawVarint32();
            checkRecursionLimit();
            int pushLimit = pushLimit(readRawVarint32);
            this.recursionDepth++;
            builder.mergeFrom(this, extensionRegistry);
            checkLastTagWas(0);
            this.recursionDepth--;
            if (getBytesUntilLimit() != 0) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            popLimit(pushLimit);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public <T extends MessageLite> T readMessage(final Parser<T> parser, final ExtensionRegistryLite extensionRegistry) throws IOException {
            int readRawVarint32 = readRawVarint32();
            checkRecursionLimit();
            int pushLimit = pushLimit(readRawVarint32);
            this.recursionDepth++;
            T parsePartialFrom = parser.parsePartialFrom(this, extensionRegistry);
            checkLastTagWas(0);
            this.recursionDepth--;
            if (getBytesUntilLimit() != 0) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            popLimit(pushLimit);
            return parsePartialFrom;
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public ByteString readBytes() throws IOException {
            int readRawVarint32 = readRawVarint32();
            if (readRawVarint32 <= 0 || readRawVarint32 > remaining()) {
                if (readRawVarint32 == 0) {
                    return ByteString.EMPTY;
                }
                if (readRawVarint32 < 0) {
                    throw InvalidProtocolBufferException.negativeSize();
                }
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            if (this.immutable && this.enableAliasing) {
                long j = this.pos;
                long j2 = readRawVarint32;
                ByteBuffer slice = slice(j, j + j2);
                this.pos += j2;
                return ByteString.wrap(slice);
            }
            byte[] bArr = new byte[readRawVarint32];
            long j3 = readRawVarint32;
            UnsafeUtil.copyMemory(this.pos, bArr, 0L, j3);
            this.pos += j3;
            return ByteString.wrap(bArr);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public byte[] readByteArray() throws IOException {
            return readRawBytes(readRawVarint32());
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public ByteBuffer readByteBuffer() throws IOException {
            int readRawVarint32 = readRawVarint32();
            if (readRawVarint32 <= 0 || readRawVarint32 > remaining()) {
                if (readRawVarint32 == 0) {
                    return Internal.EMPTY_BYTE_BUFFER;
                }
                if (readRawVarint32 < 0) {
                    throw InvalidProtocolBufferException.negativeSize();
                }
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            if (!this.immutable && this.enableAliasing) {
                long j = this.pos;
                long j2 = readRawVarint32;
                ByteBuffer slice = slice(j, j + j2);
                this.pos += j2;
                return slice;
            }
            byte[] bArr = new byte[readRawVarint32];
            long j3 = readRawVarint32;
            UnsafeUtil.copyMemory(this.pos, bArr, 0L, j3);
            this.pos += j3;
            return ByteBuffer.wrap(bArr);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public int readUInt32() throws IOException {
            return readRawVarint32();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public int readEnum() throws IOException {
            return readRawVarint32();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public int readSFixed32() throws IOException {
            return readRawLittleEndian32();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public long readSFixed64() throws IOException {
            return readRawLittleEndian64();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public int readSInt32() throws IOException {
            return decodeZigZag32(readRawVarint32());
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public long readSInt64() throws IOException {
            return decodeZigZag64(readRawVarint64());
        }

        /* JADX WARN: Code restructure failed: missing block: B:33:0x008c, code lost:
        
            if (androidx.datastore.preferences.protobuf.UnsafeUtil.getByte(r3) < 0) goto L34;
         */
        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public int readRawVarint32() throws IOException {
            int i;
            long j = this.pos;
            if (this.limit != j) {
                long j2 = 1 + j;
                byte b = UnsafeUtil.getByte(j);
                if (b >= 0) {
                    this.pos = j2;
                    return b;
                }
                if (this.limit - j2 >= 9) {
                    long j3 = 2 + j;
                    int i2 = (UnsafeUtil.getByte(j2) << 7) ^ b;
                    if (i2 < 0) {
                        i = i2 ^ (-128);
                    } else {
                        long j4 = 3 + j;
                        int i3 = i2 ^ (UnsafeUtil.getByte(j3) << Ascii.SO);
                        if (i3 >= 0) {
                            i = i3 ^ 16256;
                        } else {
                            j3 = 4 + j;
                            int i4 = i3 ^ (UnsafeUtil.getByte(j4) << Ascii.NAK);
                            if (i4 < 0) {
                                i = (-2080896) ^ i4;
                            } else {
                                j4 = 5 + j;
                                byte b2 = UnsafeUtil.getByte(j3);
                                int i5 = (i4 ^ (b2 << Ascii.FS)) ^ 266354560;
                                if (b2 < 0) {
                                    j3 = 6 + j;
                                    if (UnsafeUtil.getByte(j4) < 0) {
                                        j4 = 7 + j;
                                        if (UnsafeUtil.getByte(j3) < 0) {
                                            j3 = 8 + j;
                                            if (UnsafeUtil.getByte(j4) < 0) {
                                                j4 = j + 9;
                                                if (UnsafeUtil.getByte(j3) < 0) {
                                                    j3 = 10 + j;
                                                }
                                            }
                                        }
                                    }
                                    i = i5;
                                }
                                i = i5;
                            }
                        }
                        j3 = j4;
                    }
                    this.pos = j3;
                    return i;
                }
            }
            return (int) readRawVarint64SlowPath();
        }

        private void skipRawVarint() throws IOException {
            if (remaining() >= 10) {
                skipRawVarintFastPath();
            } else {
                skipRawVarintSlowPath();
            }
        }

        private void skipRawVarintFastPath() throws IOException {
            for (int i = 0; i < 10; i++) {
                long j = this.pos;
                this.pos = 1 + j;
                if (UnsafeUtil.getByte(j) >= 0) {
                    return;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        private void skipRawVarintSlowPath() throws IOException {
            for (int i = 0; i < 10; i++) {
                if (readRawByte() >= 0) {
                    return;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public long readRawVarint64() throws IOException {
            long j;
            long j2;
            long j3;
            int i;
            long j4 = this.pos;
            if (this.limit != j4) {
                long j5 = 1 + j4;
                byte b = UnsafeUtil.getByte(j4);
                if (b >= 0) {
                    this.pos = j5;
                    return b;
                }
                if (this.limit - j5 >= 9) {
                    long j6 = 2 + j4;
                    int i2 = (UnsafeUtil.getByte(j5) << 7) ^ b;
                    if (i2 >= 0) {
                        long j7 = 3 + j4;
                        int i3 = i2 ^ (UnsafeUtil.getByte(j6) << Ascii.SO);
                        if (i3 >= 0) {
                            j = i3 ^ 16256;
                            j6 = j7;
                        } else {
                            j6 = 4 + j4;
                            int i4 = i3 ^ (UnsafeUtil.getByte(j7) << Ascii.NAK);
                            if (i4 < 0) {
                                i = (-2080896) ^ i4;
                            } else {
                                long j8 = 5 + j4;
                                long j9 = i4 ^ (UnsafeUtil.getByte(j6) << 28);
                                if (j9 >= 0) {
                                    j3 = 266354560;
                                } else {
                                    long j10 = 6 + j4;
                                    long j11 = j9 ^ (UnsafeUtil.getByte(j8) << 35);
                                    if (j11 < 0) {
                                        j2 = -34093383808L;
                                    } else {
                                        j8 = 7 + j4;
                                        j9 = j11 ^ (UnsafeUtil.getByte(j10) << 42);
                                        if (j9 >= 0) {
                                            j3 = 4363953127296L;
                                        } else {
                                            j10 = 8 + j4;
                                            j11 = j9 ^ (UnsafeUtil.getByte(j8) << 49);
                                            if (j11 < 0) {
                                                j2 = -558586000294016L;
                                            } else {
                                                long j12 = j4 + 9;
                                                long j13 = (j11 ^ (UnsafeUtil.getByte(j10) << 56)) ^ 71499008037633920L;
                                                if (j13 < 0) {
                                                    long j14 = j4 + 10;
                                                    if (UnsafeUtil.getByte(j12) >= 0) {
                                                        j6 = j14;
                                                        j = j13;
                                                    }
                                                } else {
                                                    j = j13;
                                                    j6 = j12;
                                                }
                                            }
                                        }
                                    }
                                    j = j2 ^ j11;
                                    j6 = j10;
                                }
                                j = j3 ^ j9;
                                j6 = j8;
                            }
                        }
                        this.pos = j6;
                        return j;
                    }
                    i = i2 ^ (-128);
                    j = i;
                    this.pos = j6;
                    return j;
                }
            }
            return readRawVarint64SlowPath();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        long readRawVarint64SlowPath() throws IOException {
            long j = 0;
            for (int i = 0; i < 64; i += 7) {
                j |= (r3 & Byte.MAX_VALUE) << i;
                if ((readRawByte() & 128) == 0) {
                    return j;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public int readRawLittleEndian32() throws IOException {
            long j = this.pos;
            if (this.limit - j < 4) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            this.pos = 4 + j;
            return ((UnsafeUtil.getByte(j + 3) & 255) << 24) | (UnsafeUtil.getByte(j) & 255) | ((UnsafeUtil.getByte(1 + j) & 255) << 8) | ((UnsafeUtil.getByte(2 + j) & 255) << 16);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public long readRawLittleEndian64() throws IOException {
            long j = this.pos;
            if (this.limit - j < 8) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            this.pos = 8 + j;
            return ((UnsafeUtil.getByte(j + 7) & 255) << 56) | (UnsafeUtil.getByte(j) & 255) | ((UnsafeUtil.getByte(1 + j) & 255) << 8) | ((UnsafeUtil.getByte(2 + j) & 255) << 16) | ((UnsafeUtil.getByte(3 + j) & 255) << 24) | ((UnsafeUtil.getByte(4 + j) & 255) << 32) | ((UnsafeUtil.getByte(5 + j) & 255) << 40) | ((UnsafeUtil.getByte(6 + j) & 255) << 48);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public void enableAliasing(boolean enabled) {
            this.enableAliasing = enabled;
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public void resetSizeCounter() {
            this.startPos = this.pos;
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public int pushLimit(int byteLimit) throws InvalidProtocolBufferException {
            if (byteLimit < 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            int totalBytesRead = byteLimit + getTotalBytesRead();
            int i = this.currentLimit;
            if (totalBytesRead > i) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            this.currentLimit = totalBytesRead;
            recomputeBufferSizeAfterLimit();
            return i;
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public void popLimit(final int oldLimit) {
            this.currentLimit = oldLimit;
            recomputeBufferSizeAfterLimit();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public int getBytesUntilLimit() {
            int i = this.currentLimit;
            if (i == Integer.MAX_VALUE) {
                return -1;
            }
            return i - getTotalBytesRead();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public boolean isAtEnd() throws IOException {
            return this.pos == this.limit;
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public int getTotalBytesRead() {
            return (int) (this.pos - this.startPos);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public byte readRawByte() throws IOException {
            long j = this.pos;
            if (j == this.limit) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            this.pos = 1 + j;
            return UnsafeUtil.getByte(j);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public byte[] readRawBytes(final int length) throws IOException {
            if (length < 0 || length > remaining()) {
                if (length > 0) {
                    throw InvalidProtocolBufferException.truncatedMessage();
                }
                if (length == 0) {
                    return Internal.EMPTY_BYTE_ARRAY;
                }
                throw InvalidProtocolBufferException.negativeSize();
            }
            byte[] bArr = new byte[length];
            long j = this.pos;
            long j2 = length;
            slice(j, j + j2).get(bArr);
            this.pos += j2;
            return bArr;
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public void skipRawBytes(final int length) throws IOException {
            if (length >= 0 && length <= remaining()) {
                this.pos += length;
            } else {
                if (length < 0) {
                    throw InvalidProtocolBufferException.negativeSize();
                }
                throw InvalidProtocolBufferException.truncatedMessage();
            }
        }

        private void recomputeBufferSizeAfterLimit() {
            long j = this.limit + this.bufferSizeAfterLimit;
            this.limit = j;
            int i = (int) (j - this.startPos);
            int i2 = this.currentLimit;
            if (i > i2) {
                int i3 = i - i2;
                this.bufferSizeAfterLimit = i3;
                this.limit = j - i3;
                return;
            }
            this.bufferSizeAfterLimit = 0;
        }

        private int remaining() {
            return (int) (this.limit - this.pos);
        }

        private int bufferPos(long pos) {
            return (int) (pos - this.address);
        }

        private ByteBuffer slice(long begin, long end) throws IOException {
            int position = this.buffer.position();
            int limit = this.buffer.limit();
            ByteBuffer byteBuffer = this.buffer;
            try {
                try {
                    byteBuffer.position(bufferPos(begin));
                    byteBuffer.limit(bufferPos(end));
                    return this.buffer.slice();
                } catch (IllegalArgumentException e) {
                    InvalidProtocolBufferException truncatedMessage = InvalidProtocolBufferException.truncatedMessage();
                    truncatedMessage.initCause(e);
                    throw truncatedMessage;
                }
            } finally {
                byteBuffer.position(position);
                byteBuffer.limit(limit);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class StreamDecoder extends CodedInputStream {
        private final byte[] buffer;
        private int bufferSize;
        private int bufferSizeAfterLimit;
        private int currentLimit;
        private final InputStream input;
        private int lastTag;
        private int pos;
        private RefillCallback refillCallback;
        private int totalBytesRetired;

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public interface RefillCallback {
            void onRefill();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public void enableAliasing(boolean enabled) {
        }

        private StreamDecoder(final InputStream input, int bufferSize) {
            super();
            this.currentLimit = Integer.MAX_VALUE;
            this.refillCallback = null;
            Internal.checkNotNull(input, "input");
            this.input = input;
            this.buffer = new byte[bufferSize];
            this.bufferSize = 0;
            this.pos = 0;
            this.totalBytesRetired = 0;
        }

        private static int read(InputStream input, byte[] data, int offset, int length) throws IOException {
            try {
                return input.read(data, offset, length);
            } catch (InvalidProtocolBufferException e) {
                e.setThrownFromInputStream();
                throw e;
            }
        }

        private static long skip(InputStream input, long length) throws IOException {
            try {
                return input.skip(length);
            } catch (InvalidProtocolBufferException e) {
                e.setThrownFromInputStream();
                throw e;
            }
        }

        private static int available(InputStream input) throws IOException {
            try {
                return input.available();
            } catch (InvalidProtocolBufferException e) {
                e.setThrownFromInputStream();
                throw e;
            }
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public int readTag() throws IOException {
            if (isAtEnd()) {
                this.lastTag = 0;
                return 0;
            }
            int readRawVarint32 = readRawVarint32();
            this.lastTag = readRawVarint32;
            if (WireFormat.getTagFieldNumber(readRawVarint32) == 0) {
                throw InvalidProtocolBufferException.invalidTag();
            }
            return this.lastTag;
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public void checkLastTagWas(final int value) throws InvalidProtocolBufferException {
            if (this.lastTag != value) {
                throw InvalidProtocolBufferException.invalidEndTag();
            }
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public int getLastTag() {
            return this.lastTag;
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public boolean skipField(final int tag) throws IOException {
            int tagWireType = WireFormat.getTagWireType(tag);
            if (tagWireType == 0) {
                skipRawVarint();
                return true;
            }
            if (tagWireType == 1) {
                skipRawBytes(8);
                return true;
            }
            if (tagWireType == 2) {
                skipRawBytes(readRawVarint32());
                return true;
            }
            if (tagWireType == 3) {
                skipMessage();
                checkLastTagWas(WireFormat.makeTag(WireFormat.getTagFieldNumber(tag), 4));
                return true;
            }
            if (tagWireType == 4) {
                return false;
            }
            if (tagWireType == 5) {
                skipRawBytes(4);
                return true;
            }
            throw InvalidProtocolBufferException.invalidWireType();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public boolean skipField(final int tag, final CodedOutputStream output) throws IOException {
            int tagWireType = WireFormat.getTagWireType(tag);
            if (tagWireType == 0) {
                long readInt64 = readInt64();
                output.writeUInt32NoTag(tag);
                output.writeUInt64NoTag(readInt64);
                return true;
            }
            if (tagWireType == 1) {
                long readRawLittleEndian64 = readRawLittleEndian64();
                output.writeUInt32NoTag(tag);
                output.writeFixed64NoTag(readRawLittleEndian64);
                return true;
            }
            if (tagWireType == 2) {
                ByteString readBytes = readBytes();
                output.writeUInt32NoTag(tag);
                output.writeBytesNoTag(readBytes);
                return true;
            }
            if (tagWireType == 3) {
                output.writeUInt32NoTag(tag);
                skipMessage(output);
                int makeTag = WireFormat.makeTag(WireFormat.getTagFieldNumber(tag), 4);
                checkLastTagWas(makeTag);
                output.writeUInt32NoTag(makeTag);
                return true;
            }
            if (tagWireType == 4) {
                return false;
            }
            if (tagWireType == 5) {
                int readRawLittleEndian32 = readRawLittleEndian32();
                output.writeUInt32NoTag(tag);
                output.writeFixed32NoTag(readRawLittleEndian32);
                return true;
            }
            throw InvalidProtocolBufferException.invalidWireType();
        }

        /* loaded from: classes.dex */
        private class SkippedDataSink implements RefillCallback {
            private ByteArrayOutputStream byteArrayStream;
            private int lastPos;

            private SkippedDataSink() {
                this.lastPos = StreamDecoder.this.pos;
            }

            @Override // androidx.datastore.preferences.protobuf.CodedInputStream.StreamDecoder.RefillCallback
            public void onRefill() {
                if (this.byteArrayStream == null) {
                    this.byteArrayStream = new ByteArrayOutputStream();
                }
                this.byteArrayStream.write(StreamDecoder.this.buffer, this.lastPos, StreamDecoder.this.pos - this.lastPos);
                this.lastPos = 0;
            }

            ByteBuffer getSkippedData() {
                ByteArrayOutputStream byteArrayOutputStream = this.byteArrayStream;
                if (byteArrayOutputStream == null) {
                    return ByteBuffer.wrap(StreamDecoder.this.buffer, this.lastPos, StreamDecoder.this.pos - this.lastPos);
                }
                byteArrayOutputStream.write(StreamDecoder.this.buffer, this.lastPos, StreamDecoder.this.pos);
                return ByteBuffer.wrap(this.byteArrayStream.toByteArray());
            }
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public double readDouble() throws IOException {
            return Double.longBitsToDouble(readRawLittleEndian64());
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public float readFloat() throws IOException {
            return Float.intBitsToFloat(readRawLittleEndian32());
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public long readUInt64() throws IOException {
            return readRawVarint64();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public long readInt64() throws IOException {
            return readRawVarint64();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public int readInt32() throws IOException {
            return readRawVarint32();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public long readFixed64() throws IOException {
            return readRawLittleEndian64();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public int readFixed32() throws IOException {
            return readRawLittleEndian32();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public boolean readBool() throws IOException {
            return readRawVarint64() != 0;
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public String readString() throws IOException {
            int readRawVarint32 = readRawVarint32();
            if (readRawVarint32 > 0) {
                int i = this.bufferSize;
                int i2 = this.pos;
                if (readRawVarint32 <= i - i2) {
                    String str = new String(this.buffer, i2, readRawVarint32, Internal.UTF_8);
                    this.pos += readRawVarint32;
                    return str;
                }
            }
            if (readRawVarint32 == 0) {
                return "";
            }
            if (readRawVarint32 < 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            if (readRawVarint32 <= this.bufferSize) {
                refillBuffer(readRawVarint32);
                String str2 = new String(this.buffer, this.pos, readRawVarint32, Internal.UTF_8);
                this.pos += readRawVarint32;
                return str2;
            }
            return new String(readRawBytesSlowPath(readRawVarint32, false), Internal.UTF_8);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public String readStringRequireUtf8() throws IOException {
            byte[] readRawBytesSlowPath;
            int readRawVarint32 = readRawVarint32();
            int i = this.pos;
            int i2 = this.bufferSize;
            if (readRawVarint32 <= i2 - i && readRawVarint32 > 0) {
                readRawBytesSlowPath = this.buffer;
                this.pos = i + readRawVarint32;
            } else {
                if (readRawVarint32 == 0) {
                    return "";
                }
                if (readRawVarint32 < 0) {
                    throw InvalidProtocolBufferException.negativeSize();
                }
                i = 0;
                if (readRawVarint32 <= i2) {
                    refillBuffer(readRawVarint32);
                    readRawBytesSlowPath = this.buffer;
                    this.pos = readRawVarint32;
                } else {
                    readRawBytesSlowPath = readRawBytesSlowPath(readRawVarint32, false);
                }
            }
            return Utf8.decodeUtf8(readRawBytesSlowPath, i, readRawVarint32);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public void readGroup(final int fieldNumber, final MessageLite.Builder builder, final ExtensionRegistryLite extensionRegistry) throws IOException {
            checkRecursionLimit();
            this.recursionDepth++;
            builder.mergeFrom(this, extensionRegistry);
            checkLastTagWas(WireFormat.makeTag(fieldNumber, 4));
            this.recursionDepth--;
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public <T extends MessageLite> T readGroup(final int fieldNumber, final Parser<T> parser, final ExtensionRegistryLite extensionRegistry) throws IOException {
            checkRecursionLimit();
            this.recursionDepth++;
            T parsePartialFrom = parser.parsePartialFrom(this, extensionRegistry);
            checkLastTagWas(WireFormat.makeTag(fieldNumber, 4));
            this.recursionDepth--;
            return parsePartialFrom;
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        @Deprecated
        public void readUnknownGroup(final int fieldNumber, final MessageLite.Builder builder) throws IOException {
            readGroup(fieldNumber, builder, ExtensionRegistryLite.getEmptyRegistry());
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public void readMessage(final MessageLite.Builder builder, final ExtensionRegistryLite extensionRegistry) throws IOException {
            int readRawVarint32 = readRawVarint32();
            checkRecursionLimit();
            int pushLimit = pushLimit(readRawVarint32);
            this.recursionDepth++;
            builder.mergeFrom(this, extensionRegistry);
            checkLastTagWas(0);
            this.recursionDepth--;
            if (getBytesUntilLimit() != 0) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            popLimit(pushLimit);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public <T extends MessageLite> T readMessage(final Parser<T> parser, final ExtensionRegistryLite extensionRegistry) throws IOException {
            int readRawVarint32 = readRawVarint32();
            checkRecursionLimit();
            int pushLimit = pushLimit(readRawVarint32);
            this.recursionDepth++;
            T parsePartialFrom = parser.parsePartialFrom(this, extensionRegistry);
            checkLastTagWas(0);
            this.recursionDepth--;
            if (getBytesUntilLimit() != 0) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            popLimit(pushLimit);
            return parsePartialFrom;
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public ByteString readBytes() throws IOException {
            int readRawVarint32 = readRawVarint32();
            int i = this.bufferSize;
            int i2 = this.pos;
            if (readRawVarint32 <= i - i2 && readRawVarint32 > 0) {
                ByteString copyFrom = ByteString.copyFrom(this.buffer, i2, readRawVarint32);
                this.pos += readRawVarint32;
                return copyFrom;
            }
            if (readRawVarint32 == 0) {
                return ByteString.EMPTY;
            }
            if (readRawVarint32 < 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            return readBytesSlowPath(readRawVarint32);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public byte[] readByteArray() throws IOException {
            int readRawVarint32 = readRawVarint32();
            int i = this.bufferSize;
            int i2 = this.pos;
            if (readRawVarint32 > i - i2 || readRawVarint32 <= 0) {
                if (readRawVarint32 < 0) {
                    throw InvalidProtocolBufferException.negativeSize();
                }
                return readRawBytesSlowPath(readRawVarint32, false);
            }
            byte[] copyOfRange = Arrays.copyOfRange(this.buffer, i2, i2 + readRawVarint32);
            this.pos += readRawVarint32;
            return copyOfRange;
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public ByteBuffer readByteBuffer() throws IOException {
            int readRawVarint32 = readRawVarint32();
            int i = this.bufferSize;
            int i2 = this.pos;
            if (readRawVarint32 <= i - i2 && readRawVarint32 > 0) {
                ByteBuffer wrap = ByteBuffer.wrap(Arrays.copyOfRange(this.buffer, i2, i2 + readRawVarint32));
                this.pos += readRawVarint32;
                return wrap;
            }
            if (readRawVarint32 == 0) {
                return Internal.EMPTY_BYTE_BUFFER;
            }
            if (readRawVarint32 < 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            return ByteBuffer.wrap(readRawBytesSlowPath(readRawVarint32, true));
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public int readUInt32() throws IOException {
            return readRawVarint32();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public int readEnum() throws IOException {
            return readRawVarint32();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public int readSFixed32() throws IOException {
            return readRawLittleEndian32();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public long readSFixed64() throws IOException {
            return readRawLittleEndian64();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public int readSInt32() throws IOException {
            return decodeZigZag32(readRawVarint32());
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public long readSInt64() throws IOException {
            return decodeZigZag64(readRawVarint64());
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public int readRawVarint32() throws IOException {
            int i;
            int i2 = this.pos;
            int i3 = this.bufferSize;
            if (i3 != i2) {
                byte[] bArr = this.buffer;
                int i4 = i2 + 1;
                byte b = bArr[i2];
                if (b >= 0) {
                    this.pos = i4;
                    return b;
                }
                if (i3 - i4 >= 9) {
                    int i5 = i2 + 2;
                    int i6 = (bArr[i4] << 7) ^ b;
                    if (i6 < 0) {
                        i = i6 ^ (-128);
                    } else {
                        int i7 = i2 + 3;
                        int i8 = (bArr[i5] << Ascii.SO) ^ i6;
                        if (i8 >= 0) {
                            i = i8 ^ 16256;
                        } else {
                            int i9 = i2 + 4;
                            int i10 = i8 ^ (bArr[i7] << Ascii.NAK);
                            if (i10 < 0) {
                                i = (-2080896) ^ i10;
                            } else {
                                i7 = i2 + 5;
                                byte b2 = bArr[i9];
                                int i11 = (i10 ^ (b2 << Ascii.FS)) ^ 266354560;
                                if (b2 < 0) {
                                    i9 = i2 + 6;
                                    if (bArr[i7] < 0) {
                                        i7 = i2 + 7;
                                        if (bArr[i9] < 0) {
                                            i9 = i2 + 8;
                                            if (bArr[i7] < 0) {
                                                i7 = i2 + 9;
                                                if (bArr[i9] < 0) {
                                                    int i12 = i2 + 10;
                                                    if (bArr[i7] >= 0) {
                                                        i5 = i12;
                                                        i = i11;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    i = i11;
                                }
                                i = i11;
                            }
                            i5 = i9;
                        }
                        i5 = i7;
                    }
                    this.pos = i5;
                    return i;
                }
            }
            return (int) readRawVarint64SlowPath();
        }

        private void skipRawVarint() throws IOException {
            if (this.bufferSize - this.pos >= 10) {
                skipRawVarintFastPath();
            } else {
                skipRawVarintSlowPath();
            }
        }

        private void skipRawVarintFastPath() throws IOException {
            for (int i = 0; i < 10; i++) {
                byte[] bArr = this.buffer;
                int i2 = this.pos;
                this.pos = i2 + 1;
                if (bArr[i2] >= 0) {
                    return;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        private void skipRawVarintSlowPath() throws IOException {
            for (int i = 0; i < 10; i++) {
                if (readRawByte() >= 0) {
                    return;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public long readRawVarint64() throws IOException {
            long j;
            long j2;
            long j3;
            int i = this.pos;
            int i2 = this.bufferSize;
            if (i2 != i) {
                byte[] bArr = this.buffer;
                int i3 = i + 1;
                byte b = bArr[i];
                if (b >= 0) {
                    this.pos = i3;
                    return b;
                }
                if (i2 - i3 >= 9) {
                    int i4 = i + 2;
                    int i5 = (bArr[i3] << 7) ^ b;
                    if (i5 < 0) {
                        j = i5 ^ (-128);
                    } else {
                        int i6 = i + 3;
                        int i7 = (bArr[i4] << Ascii.SO) ^ i5;
                        if (i7 >= 0) {
                            j = i7 ^ 16256;
                            i4 = i6;
                        } else {
                            int i8 = i + 4;
                            int i9 = i7 ^ (bArr[i6] << Ascii.NAK);
                            if (i9 < 0) {
                                long j4 = (-2080896) ^ i9;
                                i4 = i8;
                                j = j4;
                            } else {
                                long j5 = i9;
                                i4 = i + 5;
                                long j6 = j5 ^ (bArr[i8] << 28);
                                if (j6 >= 0) {
                                    j3 = 266354560;
                                } else {
                                    int i10 = i + 6;
                                    long j7 = j6 ^ (bArr[i4] << 35);
                                    if (j7 < 0) {
                                        j2 = -34093383808L;
                                    } else {
                                        i4 = i + 7;
                                        j6 = j7 ^ (bArr[i10] << 42);
                                        if (j6 >= 0) {
                                            j3 = 4363953127296L;
                                        } else {
                                            i10 = i + 8;
                                            j7 = j6 ^ (bArr[i4] << 49);
                                            if (j7 < 0) {
                                                j2 = -558586000294016L;
                                            } else {
                                                i4 = i + 9;
                                                long j8 = (j7 ^ (bArr[i10] << 56)) ^ 71499008037633920L;
                                                if (j8 < 0) {
                                                    int i11 = i + 10;
                                                    if (bArr[i4] >= 0) {
                                                        i4 = i11;
                                                    }
                                                }
                                                j = j8;
                                            }
                                        }
                                    }
                                    j = j7 ^ j2;
                                    i4 = i10;
                                }
                                j = j6 ^ j3;
                            }
                        }
                    }
                    this.pos = i4;
                    return j;
                }
            }
            return readRawVarint64SlowPath();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        long readRawVarint64SlowPath() throws IOException {
            long j = 0;
            for (int i = 0; i < 64; i += 7) {
                j |= (r3 & Byte.MAX_VALUE) << i;
                if ((readRawByte() & 128) == 0) {
                    return j;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public int readRawLittleEndian32() throws IOException {
            int i = this.pos;
            if (this.bufferSize - i < 4) {
                refillBuffer(4);
                i = this.pos;
            }
            byte[] bArr = this.buffer;
            this.pos = i + 4;
            return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public long readRawLittleEndian64() throws IOException {
            int i = this.pos;
            if (this.bufferSize - i < 8) {
                refillBuffer(8);
                i = this.pos;
            }
            byte[] bArr = this.buffer;
            this.pos = i + 8;
            return ((bArr[i + 7] & 255) << 56) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16) | ((bArr[i + 3] & 255) << 24) | ((bArr[i + 4] & 255) << 32) | ((bArr[i + 5] & 255) << 40) | ((bArr[i + 6] & 255) << 48);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public void resetSizeCounter() {
            this.totalBytesRetired = -this.pos;
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public int pushLimit(int byteLimit) throws InvalidProtocolBufferException {
            if (byteLimit < 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            int i = byteLimit + this.totalBytesRetired + this.pos;
            if (i < 0) {
                throw InvalidProtocolBufferException.parseFailure();
            }
            int i2 = this.currentLimit;
            if (i > i2) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            this.currentLimit = i;
            recomputeBufferSizeAfterLimit();
            return i2;
        }

        private void recomputeBufferSizeAfterLimit() {
            int i = this.bufferSize + this.bufferSizeAfterLimit;
            this.bufferSize = i;
            int i2 = this.totalBytesRetired + i;
            int i3 = this.currentLimit;
            if (i2 > i3) {
                int i4 = i2 - i3;
                this.bufferSizeAfterLimit = i4;
                this.bufferSize = i - i4;
                return;
            }
            this.bufferSizeAfterLimit = 0;
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public void popLimit(final int oldLimit) {
            this.currentLimit = oldLimit;
            recomputeBufferSizeAfterLimit();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public int getBytesUntilLimit() {
            int i = this.currentLimit;
            if (i == Integer.MAX_VALUE) {
                return -1;
            }
            return i - (this.totalBytesRetired + this.pos);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public boolean isAtEnd() throws IOException {
            return this.pos == this.bufferSize && !tryRefillBuffer(1);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public int getTotalBytesRead() {
            return this.totalBytesRetired + this.pos;
        }

        private void refillBuffer(int n) throws IOException {
            if (tryRefillBuffer(n)) {
                return;
            }
            if (n > (this.sizeLimit - this.totalBytesRetired) - this.pos) {
                throw InvalidProtocolBufferException.sizeLimitExceeded();
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        private boolean tryRefillBuffer(int n) throws IOException {
            if (this.pos + n <= this.bufferSize) {
                throw new IllegalStateException("refillBuffer() called when " + n + " bytes were already available in buffer");
            }
            int i = this.sizeLimit;
            int i2 = this.totalBytesRetired;
            int i3 = this.pos;
            if (n > (i - i2) - i3 || i2 + i3 + n > this.currentLimit) {
                return false;
            }
            RefillCallback refillCallback = this.refillCallback;
            if (refillCallback != null) {
                refillCallback.onRefill();
            }
            int i4 = this.pos;
            if (i4 > 0) {
                int i5 = this.bufferSize;
                if (i5 > i4) {
                    byte[] bArr = this.buffer;
                    System.arraycopy(bArr, i4, bArr, 0, i5 - i4);
                }
                this.totalBytesRetired += i4;
                this.bufferSize -= i4;
                this.pos = 0;
            }
            InputStream inputStream = this.input;
            byte[] bArr2 = this.buffer;
            int i6 = this.bufferSize;
            int read = read(inputStream, bArr2, i6, Math.min(bArr2.length - i6, (this.sizeLimit - this.totalBytesRetired) - this.bufferSize));
            if (read == 0 || read < -1 || read > this.buffer.length) {
                throw new IllegalStateException(this.input.getClass() + "#read(byte[]) returned invalid result: " + read + "\nThe InputStream implementation is buggy.");
            }
            if (read <= 0) {
                return false;
            }
            this.bufferSize += read;
            recomputeBufferSizeAfterLimit();
            if (this.bufferSize >= n) {
                return true;
            }
            return tryRefillBuffer(n);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public byte readRawByte() throws IOException {
            if (this.pos == this.bufferSize) {
                refillBuffer(1);
            }
            byte[] bArr = this.buffer;
            int i = this.pos;
            this.pos = i + 1;
            return bArr[i];
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public byte[] readRawBytes(final int size) throws IOException {
            int i = this.pos;
            if (size <= this.bufferSize - i && size > 0) {
                int i2 = size + i;
                this.pos = i2;
                return Arrays.copyOfRange(this.buffer, i, i2);
            }
            return readRawBytesSlowPath(size, false);
        }

        private byte[] readRawBytesSlowPath(final int size, boolean ensureNoLeakedReferences) throws IOException {
            byte[] readRawBytesSlowPathOneChunk = readRawBytesSlowPathOneChunk(size);
            if (readRawBytesSlowPathOneChunk != null) {
                return ensureNoLeakedReferences ? (byte[]) readRawBytesSlowPathOneChunk.clone() : readRawBytesSlowPathOneChunk;
            }
            int i = this.pos;
            int i2 = this.bufferSize;
            int i3 = i2 - i;
            this.totalBytesRetired += i2;
            this.pos = 0;
            this.bufferSize = 0;
            List<byte[]> readRawBytesSlowPathRemainingChunks = readRawBytesSlowPathRemainingChunks(size - i3);
            byte[] bArr = new byte[size];
            System.arraycopy(this.buffer, i, bArr, 0, i3);
            for (byte[] bArr2 : readRawBytesSlowPathRemainingChunks) {
                System.arraycopy(bArr2, 0, bArr, i3, bArr2.length);
                i3 += bArr2.length;
            }
            return bArr;
        }

        private byte[] readRawBytesSlowPathOneChunk(final int size) throws IOException {
            if (size == 0) {
                return Internal.EMPTY_BYTE_ARRAY;
            }
            if (size < 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            int i = this.totalBytesRetired + this.pos + size;
            if (i - this.sizeLimit > 0) {
                throw InvalidProtocolBufferException.sizeLimitExceeded();
            }
            int i2 = this.currentLimit;
            if (i > i2) {
                skipRawBytes((i2 - this.totalBytesRetired) - this.pos);
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            int i3 = this.bufferSize - this.pos;
            int i4 = size - i3;
            if (i4 >= 4096 && i4 > available(this.input)) {
                return null;
            }
            byte[] bArr = new byte[size];
            System.arraycopy(this.buffer, this.pos, bArr, 0, i3);
            this.totalBytesRetired += this.bufferSize;
            this.pos = 0;
            this.bufferSize = 0;
            while (i3 < size) {
                int read = read(this.input, bArr, i3, size - i3);
                if (read == -1) {
                    throw InvalidProtocolBufferException.truncatedMessage();
                }
                this.totalBytesRetired += read;
                i3 += read;
            }
            return bArr;
        }

        private List<byte[]> readRawBytesSlowPathRemainingChunks(int sizeLeft) throws IOException {
            ArrayList arrayList = new ArrayList();
            while (sizeLeft > 0) {
                int min = Math.min(sizeLeft, 4096);
                byte[] bArr = new byte[min];
                int i = 0;
                while (i < min) {
                    int read = this.input.read(bArr, i, min - i);
                    if (read == -1) {
                        throw InvalidProtocolBufferException.truncatedMessage();
                    }
                    this.totalBytesRetired += read;
                    i += read;
                }
                sizeLeft -= min;
                arrayList.add(bArr);
            }
            return arrayList;
        }

        private ByteString readBytesSlowPath(final int size) throws IOException {
            byte[] readRawBytesSlowPathOneChunk = readRawBytesSlowPathOneChunk(size);
            if (readRawBytesSlowPathOneChunk != null) {
                return ByteString.copyFrom(readRawBytesSlowPathOneChunk);
            }
            int i = this.pos;
            int i2 = this.bufferSize;
            int i3 = i2 - i;
            this.totalBytesRetired += i2;
            this.pos = 0;
            this.bufferSize = 0;
            List<byte[]> readRawBytesSlowPathRemainingChunks = readRawBytesSlowPathRemainingChunks(size - i3);
            byte[] bArr = new byte[size];
            System.arraycopy(this.buffer, i, bArr, 0, i3);
            for (byte[] bArr2 : readRawBytesSlowPathRemainingChunks) {
                System.arraycopy(bArr2, 0, bArr, i3, bArr2.length);
                i3 += bArr2.length;
            }
            return ByteString.wrap(bArr);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public void skipRawBytes(final int size) throws IOException {
            int i = this.bufferSize;
            int i2 = this.pos;
            if (size <= i - i2 && size >= 0) {
                this.pos = i2 + size;
            } else {
                skipRawBytesSlowPath(size);
            }
        }

        private void skipRawBytesSlowPath(final int size) throws IOException {
            if (size < 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            int i = this.totalBytesRetired;
            int i2 = this.pos;
            int i3 = i + i2 + size;
            int i4 = this.currentLimit;
            if (i3 > i4) {
                skipRawBytes((i4 - i) - i2);
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            int i5 = 0;
            if (this.refillCallback == null) {
                this.totalBytesRetired = i + i2;
                int i6 = this.bufferSize - i2;
                this.bufferSize = 0;
                this.pos = 0;
                i5 = i6;
                while (i5 < size) {
                    try {
                        long j = size - i5;
                        long skip = skip(this.input, j);
                        if (skip < 0 || skip > j) {
                            throw new IllegalStateException(this.input.getClass() + "#skip returned invalid result: " + skip + "\nThe InputStream implementation is buggy.");
                        }
                        if (skip == 0) {
                            break;
                        } else {
                            i5 += (int) skip;
                        }
                    } finally {
                        this.totalBytesRetired += i5;
                        recomputeBufferSizeAfterLimit();
                    }
                }
            }
            if (i5 >= size) {
                return;
            }
            int i7 = this.bufferSize;
            int i8 = i7 - this.pos;
            this.pos = i7;
            refillBuffer(1);
            while (true) {
                int i9 = size - i8;
                int i10 = this.bufferSize;
                if (i9 > i10) {
                    i8 += i10;
                    this.pos = i10;
                    refillBuffer(1);
                } else {
                    this.pos = i9;
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class IterableDirectByteBufferDecoder extends CodedInputStream {
        private int bufferSizeAfterCurrentLimit;
        private long currentAddress;
        private ByteBuffer currentByteBuffer;
        private long currentByteBufferLimit;
        private long currentByteBufferPos;
        private long currentByteBufferStartPos;
        private int currentLimit;
        private boolean enableAliasing;
        private final boolean immutable;
        private final Iterable<ByteBuffer> input;
        private final Iterator<ByteBuffer> iterator;
        private int lastTag;
        private int startOffset;
        private int totalBufferSize;
        private int totalBytesRead;

        private IterableDirectByteBufferDecoder(Iterable<ByteBuffer> inputBufs, int size, boolean immutableFlag) {
            super();
            this.currentLimit = Integer.MAX_VALUE;
            this.totalBufferSize = size;
            this.input = inputBufs;
            this.iterator = inputBufs.iterator();
            this.immutable = immutableFlag;
            this.totalBytesRead = 0;
            this.startOffset = 0;
            if (size == 0) {
                this.currentByteBuffer = Internal.EMPTY_BYTE_BUFFER;
                this.currentByteBufferPos = 0L;
                this.currentByteBufferStartPos = 0L;
                this.currentByteBufferLimit = 0L;
                this.currentAddress = 0L;
                return;
            }
            tryGetNextByteBuffer();
        }

        private void getNextByteBuffer() throws InvalidProtocolBufferException {
            if (!this.iterator.hasNext()) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            tryGetNextByteBuffer();
        }

        private void tryGetNextByteBuffer() {
            ByteBuffer next = this.iterator.next();
            this.currentByteBuffer = next;
            this.totalBytesRead += (int) (this.currentByteBufferPos - this.currentByteBufferStartPos);
            long position = next.position();
            this.currentByteBufferPos = position;
            this.currentByteBufferStartPos = position;
            this.currentByteBufferLimit = this.currentByteBuffer.limit();
            long addressOffset = UnsafeUtil.addressOffset(this.currentByteBuffer);
            this.currentAddress = addressOffset;
            this.currentByteBufferPos += addressOffset;
            this.currentByteBufferStartPos += addressOffset;
            this.currentByteBufferLimit += addressOffset;
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public int readTag() throws IOException {
            if (isAtEnd()) {
                this.lastTag = 0;
                return 0;
            }
            int readRawVarint32 = readRawVarint32();
            this.lastTag = readRawVarint32;
            if (WireFormat.getTagFieldNumber(readRawVarint32) == 0) {
                throw InvalidProtocolBufferException.invalidTag();
            }
            return this.lastTag;
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public void checkLastTagWas(final int value) throws InvalidProtocolBufferException {
            if (this.lastTag != value) {
                throw InvalidProtocolBufferException.invalidEndTag();
            }
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public int getLastTag() {
            return this.lastTag;
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public boolean skipField(final int tag) throws IOException {
            int tagWireType = WireFormat.getTagWireType(tag);
            if (tagWireType == 0) {
                skipRawVarint();
                return true;
            }
            if (tagWireType == 1) {
                skipRawBytes(8);
                return true;
            }
            if (tagWireType == 2) {
                skipRawBytes(readRawVarint32());
                return true;
            }
            if (tagWireType == 3) {
                skipMessage();
                checkLastTagWas(WireFormat.makeTag(WireFormat.getTagFieldNumber(tag), 4));
                return true;
            }
            if (tagWireType == 4) {
                return false;
            }
            if (tagWireType == 5) {
                skipRawBytes(4);
                return true;
            }
            throw InvalidProtocolBufferException.invalidWireType();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public boolean skipField(final int tag, final CodedOutputStream output) throws IOException {
            int tagWireType = WireFormat.getTagWireType(tag);
            if (tagWireType == 0) {
                long readInt64 = readInt64();
                output.writeUInt32NoTag(tag);
                output.writeUInt64NoTag(readInt64);
                return true;
            }
            if (tagWireType == 1) {
                long readRawLittleEndian64 = readRawLittleEndian64();
                output.writeUInt32NoTag(tag);
                output.writeFixed64NoTag(readRawLittleEndian64);
                return true;
            }
            if (tagWireType == 2) {
                ByteString readBytes = readBytes();
                output.writeUInt32NoTag(tag);
                output.writeBytesNoTag(readBytes);
                return true;
            }
            if (tagWireType == 3) {
                output.writeUInt32NoTag(tag);
                skipMessage(output);
                int makeTag = WireFormat.makeTag(WireFormat.getTagFieldNumber(tag), 4);
                checkLastTagWas(makeTag);
                output.writeUInt32NoTag(makeTag);
                return true;
            }
            if (tagWireType == 4) {
                return false;
            }
            if (tagWireType == 5) {
                int readRawLittleEndian32 = readRawLittleEndian32();
                output.writeUInt32NoTag(tag);
                output.writeFixed32NoTag(readRawLittleEndian32);
                return true;
            }
            throw InvalidProtocolBufferException.invalidWireType();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public double readDouble() throws IOException {
            return Double.longBitsToDouble(readRawLittleEndian64());
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public float readFloat() throws IOException {
            return Float.intBitsToFloat(readRawLittleEndian32());
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public long readUInt64() throws IOException {
            return readRawVarint64();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public long readInt64() throws IOException {
            return readRawVarint64();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public int readInt32() throws IOException {
            return readRawVarint32();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public long readFixed64() throws IOException {
            return readRawLittleEndian64();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public int readFixed32() throws IOException {
            return readRawLittleEndian32();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public boolean readBool() throws IOException {
            return readRawVarint64() != 0;
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public String readString() throws IOException {
            int readRawVarint32 = readRawVarint32();
            if (readRawVarint32 > 0) {
                long j = readRawVarint32;
                long j2 = this.currentByteBufferLimit;
                long j3 = this.currentByteBufferPos;
                if (j <= j2 - j3) {
                    byte[] bArr = new byte[readRawVarint32];
                    UnsafeUtil.copyMemory(j3, bArr, 0L, j);
                    String str = new String(bArr, Internal.UTF_8);
                    this.currentByteBufferPos += j;
                    return str;
                }
            }
            if (readRawVarint32 > 0 && readRawVarint32 <= remaining()) {
                byte[] bArr2 = new byte[readRawVarint32];
                readRawBytesTo(bArr2, 0, readRawVarint32);
                return new String(bArr2, Internal.UTF_8);
            }
            if (readRawVarint32 == 0) {
                return "";
            }
            if (readRawVarint32 < 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public String readStringRequireUtf8() throws IOException {
            int readRawVarint32 = readRawVarint32();
            if (readRawVarint32 > 0) {
                long j = readRawVarint32;
                long j2 = this.currentByteBufferLimit;
                long j3 = this.currentByteBufferPos;
                if (j <= j2 - j3) {
                    String decodeUtf8 = Utf8.decodeUtf8(this.currentByteBuffer, (int) (j3 - this.currentByteBufferStartPos), readRawVarint32);
                    this.currentByteBufferPos += j;
                    return decodeUtf8;
                }
            }
            if (readRawVarint32 >= 0 && readRawVarint32 <= remaining()) {
                byte[] bArr = new byte[readRawVarint32];
                readRawBytesTo(bArr, 0, readRawVarint32);
                return Utf8.decodeUtf8(bArr, 0, readRawVarint32);
            }
            if (readRawVarint32 == 0) {
                return "";
            }
            if (readRawVarint32 <= 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public void readGroup(final int fieldNumber, final MessageLite.Builder builder, final ExtensionRegistryLite extensionRegistry) throws IOException {
            checkRecursionLimit();
            this.recursionDepth++;
            builder.mergeFrom(this, extensionRegistry);
            checkLastTagWas(WireFormat.makeTag(fieldNumber, 4));
            this.recursionDepth--;
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public <T extends MessageLite> T readGroup(final int fieldNumber, final Parser<T> parser, final ExtensionRegistryLite extensionRegistry) throws IOException {
            checkRecursionLimit();
            this.recursionDepth++;
            T parsePartialFrom = parser.parsePartialFrom(this, extensionRegistry);
            checkLastTagWas(WireFormat.makeTag(fieldNumber, 4));
            this.recursionDepth--;
            return parsePartialFrom;
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        @Deprecated
        public void readUnknownGroup(final int fieldNumber, final MessageLite.Builder builder) throws IOException {
            readGroup(fieldNumber, builder, ExtensionRegistryLite.getEmptyRegistry());
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public void readMessage(final MessageLite.Builder builder, final ExtensionRegistryLite extensionRegistry) throws IOException {
            int readRawVarint32 = readRawVarint32();
            checkRecursionLimit();
            int pushLimit = pushLimit(readRawVarint32);
            this.recursionDepth++;
            builder.mergeFrom(this, extensionRegistry);
            checkLastTagWas(0);
            this.recursionDepth--;
            if (getBytesUntilLimit() != 0) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            popLimit(pushLimit);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public <T extends MessageLite> T readMessage(final Parser<T> parser, final ExtensionRegistryLite extensionRegistry) throws IOException {
            int readRawVarint32 = readRawVarint32();
            checkRecursionLimit();
            int pushLimit = pushLimit(readRawVarint32);
            this.recursionDepth++;
            T parsePartialFrom = parser.parsePartialFrom(this, extensionRegistry);
            checkLastTagWas(0);
            this.recursionDepth--;
            if (getBytesUntilLimit() != 0) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            popLimit(pushLimit);
            return parsePartialFrom;
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public ByteString readBytes() throws IOException {
            int readRawVarint32 = readRawVarint32();
            if (readRawVarint32 > 0) {
                long j = readRawVarint32;
                long j2 = this.currentByteBufferLimit;
                long j3 = this.currentByteBufferPos;
                if (j <= j2 - j3) {
                    if (this.immutable && this.enableAliasing) {
                        int i = (int) (j3 - this.currentAddress);
                        ByteString wrap = ByteString.wrap(slice(i, readRawVarint32 + i));
                        this.currentByteBufferPos += j;
                        return wrap;
                    }
                    byte[] bArr = new byte[readRawVarint32];
                    UnsafeUtil.copyMemory(j3, bArr, 0L, j);
                    this.currentByteBufferPos += j;
                    return ByteString.wrap(bArr);
                }
            }
            if (readRawVarint32 <= 0 || readRawVarint32 > remaining()) {
                if (readRawVarint32 == 0) {
                    return ByteString.EMPTY;
                }
                if (readRawVarint32 < 0) {
                    throw InvalidProtocolBufferException.negativeSize();
                }
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            if (this.immutable && this.enableAliasing) {
                ArrayList arrayList = new ArrayList();
                while (readRawVarint32 > 0) {
                    if (currentRemaining() == 0) {
                        getNextByteBuffer();
                    }
                    int min = Math.min(readRawVarint32, (int) currentRemaining());
                    int i2 = (int) (this.currentByteBufferPos - this.currentAddress);
                    arrayList.add(ByteString.wrap(slice(i2, i2 + min)));
                    readRawVarint32 -= min;
                    this.currentByteBufferPos += min;
                }
                return ByteString.copyFrom(arrayList);
            }
            byte[] bArr2 = new byte[readRawVarint32];
            readRawBytesTo(bArr2, 0, readRawVarint32);
            return ByteString.wrap(bArr2);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public byte[] readByteArray() throws IOException {
            return readRawBytes(readRawVarint32());
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public ByteBuffer readByteBuffer() throws IOException {
            int readRawVarint32 = readRawVarint32();
            if (readRawVarint32 > 0) {
                long j = readRawVarint32;
                if (j <= currentRemaining()) {
                    if (!this.immutable && this.enableAliasing) {
                        long j2 = this.currentByteBufferPos + j;
                        this.currentByteBufferPos = j2;
                        long j3 = this.currentAddress;
                        return slice((int) ((j2 - j3) - j), (int) (j2 - j3));
                    }
                    byte[] bArr = new byte[readRawVarint32];
                    UnsafeUtil.copyMemory(this.currentByteBufferPos, bArr, 0L, j);
                    this.currentByteBufferPos += j;
                    return ByteBuffer.wrap(bArr);
                }
            }
            if (readRawVarint32 > 0 && readRawVarint32 <= remaining()) {
                byte[] bArr2 = new byte[readRawVarint32];
                readRawBytesTo(bArr2, 0, readRawVarint32);
                return ByteBuffer.wrap(bArr2);
            }
            if (readRawVarint32 == 0) {
                return Internal.EMPTY_BYTE_BUFFER;
            }
            if (readRawVarint32 < 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public int readUInt32() throws IOException {
            return readRawVarint32();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public int readEnum() throws IOException {
            return readRawVarint32();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public int readSFixed32() throws IOException {
            return readRawLittleEndian32();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public long readSFixed64() throws IOException {
            return readRawLittleEndian64();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public int readSInt32() throws IOException {
            return decodeZigZag32(readRawVarint32());
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public long readSInt64() throws IOException {
            return decodeZigZag64(readRawVarint64());
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public int readRawVarint32() throws IOException {
            int i;
            long j = this.currentByteBufferPos;
            if (this.currentByteBufferLimit != j) {
                long j2 = j + 1;
                byte b = UnsafeUtil.getByte(j);
                if (b >= 0) {
                    this.currentByteBufferPos++;
                    return b;
                }
                if (this.currentByteBufferLimit - this.currentByteBufferPos >= 10) {
                    long j3 = 2 + j;
                    int i2 = (UnsafeUtil.getByte(j2) << 7) ^ b;
                    if (i2 < 0) {
                        i = i2 ^ (-128);
                    } else {
                        long j4 = 3 + j;
                        int i3 = (UnsafeUtil.getByte(j3) << Ascii.SO) ^ i2;
                        if (i3 >= 0) {
                            i = i3 ^ 16256;
                        } else {
                            long j5 = 4 + j;
                            int i4 = i3 ^ (UnsafeUtil.getByte(j4) << Ascii.NAK);
                            if (i4 < 0) {
                                i = (-2080896) ^ i4;
                            } else {
                                j4 = 5 + j;
                                byte b2 = UnsafeUtil.getByte(j5);
                                int i5 = (i4 ^ (b2 << Ascii.FS)) ^ 266354560;
                                if (b2 < 0) {
                                    j5 = 6 + j;
                                    if (UnsafeUtil.getByte(j4) < 0) {
                                        j4 = 7 + j;
                                        if (UnsafeUtil.getByte(j5) < 0) {
                                            j5 = 8 + j;
                                            if (UnsafeUtil.getByte(j4) < 0) {
                                                j4 = 9 + j;
                                                if (UnsafeUtil.getByte(j5) < 0) {
                                                    long j6 = j + 10;
                                                    if (UnsafeUtil.getByte(j4) >= 0) {
                                                        i = i5;
                                                        j3 = j6;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    i = i5;
                                }
                                i = i5;
                            }
                            j3 = j5;
                        }
                        j3 = j4;
                    }
                    this.currentByteBufferPos = j3;
                    return i;
                }
            }
            return (int) readRawVarint64SlowPath();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public long readRawVarint64() throws IOException {
            long j;
            long j2;
            long j3;
            long j4 = this.currentByteBufferPos;
            if (this.currentByteBufferLimit != j4) {
                long j5 = j4 + 1;
                byte b = UnsafeUtil.getByte(j4);
                if (b >= 0) {
                    this.currentByteBufferPos++;
                    return b;
                }
                if (this.currentByteBufferLimit - this.currentByteBufferPos >= 10) {
                    long j6 = 2 + j4;
                    int i = (UnsafeUtil.getByte(j5) << 7) ^ b;
                    if (i < 0) {
                        j = i ^ (-128);
                    } else {
                        long j7 = 3 + j4;
                        int i2 = (UnsafeUtil.getByte(j6) << Ascii.SO) ^ i;
                        if (i2 >= 0) {
                            j = i2 ^ 16256;
                            j6 = j7;
                        } else {
                            long j8 = 4 + j4;
                            int i3 = i2 ^ (UnsafeUtil.getByte(j7) << Ascii.NAK);
                            if (i3 < 0) {
                                j = (-2080896) ^ i3;
                                j6 = j8;
                            } else {
                                long j9 = 5 + j4;
                                long j10 = (UnsafeUtil.getByte(j8) << 28) ^ i3;
                                if (j10 >= 0) {
                                    j3 = 266354560;
                                } else {
                                    long j11 = 6 + j4;
                                    long j12 = j10 ^ (UnsafeUtil.getByte(j9) << 35);
                                    if (j12 < 0) {
                                        j2 = -34093383808L;
                                    } else {
                                        j9 = 7 + j4;
                                        j10 = j12 ^ (UnsafeUtil.getByte(j11) << 42);
                                        if (j10 >= 0) {
                                            j3 = 4363953127296L;
                                        } else {
                                            j11 = 8 + j4;
                                            j12 = j10 ^ (UnsafeUtil.getByte(j9) << 49);
                                            if (j12 < 0) {
                                                j2 = -558586000294016L;
                                            } else {
                                                j9 = 9 + j4;
                                                long j13 = (j12 ^ (UnsafeUtil.getByte(j11) << 56)) ^ 71499008037633920L;
                                                if (j13 < 0) {
                                                    long j14 = j4 + 10;
                                                    if (UnsafeUtil.getByte(j9) >= 0) {
                                                        j = j13;
                                                        j6 = j14;
                                                    }
                                                } else {
                                                    j = j13;
                                                    j6 = j9;
                                                }
                                            }
                                        }
                                    }
                                    j = j2 ^ j12;
                                    j6 = j11;
                                }
                                j = j3 ^ j10;
                                j6 = j9;
                            }
                        }
                    }
                    this.currentByteBufferPos = j6;
                    return j;
                }
            }
            return readRawVarint64SlowPath();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        long readRawVarint64SlowPath() throws IOException {
            long j = 0;
            for (int i = 0; i < 64; i += 7) {
                j |= (r3 & Byte.MAX_VALUE) << i;
                if ((readRawByte() & 128) == 0) {
                    return j;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public int readRawLittleEndian32() throws IOException {
            if (currentRemaining() >= 4) {
                long j = this.currentByteBufferPos;
                this.currentByteBufferPos = 4 + j;
                return ((UnsafeUtil.getByte(j + 3) & 255) << 24) | (UnsafeUtil.getByte(j) & 255) | ((UnsafeUtil.getByte(1 + j) & 255) << 8) | ((UnsafeUtil.getByte(2 + j) & 255) << 16);
            }
            return (readRawByte() & 255) | ((readRawByte() & 255) << 8) | ((readRawByte() & 255) << 16) | ((readRawByte() & 255) << 24);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public long readRawLittleEndian64() throws IOException {
            long readRawByte;
            byte readRawByte2;
            if (currentRemaining() >= 8) {
                long j = this.currentByteBufferPos;
                this.currentByteBufferPos = 8 + j;
                readRawByte = (UnsafeUtil.getByte(j) & 255) | ((UnsafeUtil.getByte(1 + j) & 255) << 8) | ((UnsafeUtil.getByte(2 + j) & 255) << 16) | ((UnsafeUtil.getByte(3 + j) & 255) << 24) | ((UnsafeUtil.getByte(4 + j) & 255) << 32) | ((UnsafeUtil.getByte(5 + j) & 255) << 40) | ((UnsafeUtil.getByte(6 + j) & 255) << 48);
                readRawByte2 = UnsafeUtil.getByte(j + 7);
            } else {
                readRawByte = (readRawByte() & 255) | ((readRawByte() & 255) << 8) | ((readRawByte() & 255) << 16) | ((readRawByte() & 255) << 24) | ((readRawByte() & 255) << 32) | ((readRawByte() & 255) << 40) | ((readRawByte() & 255) << 48);
                readRawByte2 = readRawByte();
            }
            return ((readRawByte2 & 255) << 56) | readRawByte;
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public void enableAliasing(boolean enabled) {
            this.enableAliasing = enabled;
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public void resetSizeCounter() {
            this.startOffset = (int) ((this.totalBytesRead + this.currentByteBufferPos) - this.currentByteBufferStartPos);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public int pushLimit(int byteLimit) throws InvalidProtocolBufferException {
            if (byteLimit < 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            int totalBytesRead = byteLimit + getTotalBytesRead();
            int i = this.currentLimit;
            if (totalBytesRead > i) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            this.currentLimit = totalBytesRead;
            recomputeBufferSizeAfterLimit();
            return i;
        }

        private void recomputeBufferSizeAfterLimit() {
            int i = this.totalBufferSize + this.bufferSizeAfterCurrentLimit;
            this.totalBufferSize = i;
            int i2 = i - this.startOffset;
            int i3 = this.currentLimit;
            if (i2 > i3) {
                int i4 = i2 - i3;
                this.bufferSizeAfterCurrentLimit = i4;
                this.totalBufferSize = i - i4;
                return;
            }
            this.bufferSizeAfterCurrentLimit = 0;
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public void popLimit(final int oldLimit) {
            this.currentLimit = oldLimit;
            recomputeBufferSizeAfterLimit();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public int getBytesUntilLimit() {
            int i = this.currentLimit;
            if (i == Integer.MAX_VALUE) {
                return -1;
            }
            return i - getTotalBytesRead();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public boolean isAtEnd() throws IOException {
            return (((long) this.totalBytesRead) + this.currentByteBufferPos) - this.currentByteBufferStartPos == ((long) this.totalBufferSize);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public int getTotalBytesRead() {
            return (int) (((this.totalBytesRead - this.startOffset) + this.currentByteBufferPos) - this.currentByteBufferStartPos);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public byte readRawByte() throws IOException {
            if (currentRemaining() == 0) {
                getNextByteBuffer();
            }
            long j = this.currentByteBufferPos;
            this.currentByteBufferPos = 1 + j;
            return UnsafeUtil.getByte(j);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public byte[] readRawBytes(final int length) throws IOException {
            if (length >= 0) {
                long j = length;
                if (j <= currentRemaining()) {
                    byte[] bArr = new byte[length];
                    UnsafeUtil.copyMemory(this.currentByteBufferPos, bArr, 0L, j);
                    this.currentByteBufferPos += j;
                    return bArr;
                }
            }
            if (length >= 0 && length <= remaining()) {
                byte[] bArr2 = new byte[length];
                readRawBytesTo(bArr2, 0, length);
                return bArr2;
            }
            if (length > 0) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            if (length == 0) {
                return Internal.EMPTY_BYTE_ARRAY;
            }
            throw InvalidProtocolBufferException.negativeSize();
        }

        private void readRawBytesTo(byte[] bytes, int offset, final int length) throws IOException {
            if (length < 0 || length > remaining()) {
                if (length > 0) {
                    throw InvalidProtocolBufferException.truncatedMessage();
                }
                if (length != 0) {
                    throw InvalidProtocolBufferException.negativeSize();
                }
                return;
            }
            int i = length;
            while (i > 0) {
                if (currentRemaining() == 0) {
                    getNextByteBuffer();
                }
                int min = Math.min(i, (int) currentRemaining());
                long j = min;
                UnsafeUtil.copyMemory(this.currentByteBufferPos, bytes, (length - i) + offset, j);
                i -= min;
                this.currentByteBufferPos += j;
            }
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public void skipRawBytes(final int length) throws IOException {
            if (length < 0 || length > ((this.totalBufferSize - this.totalBytesRead) - this.currentByteBufferPos) + this.currentByteBufferStartPos) {
                if (length < 0) {
                    throw InvalidProtocolBufferException.negativeSize();
                }
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            while (length > 0) {
                if (currentRemaining() == 0) {
                    getNextByteBuffer();
                }
                int min = Math.min(length, (int) currentRemaining());
                length -= min;
                this.currentByteBufferPos += min;
            }
        }

        private void skipRawVarint() throws IOException {
            for (int i = 0; i < 10; i++) {
                if (readRawByte() >= 0) {
                    return;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        private int remaining() {
            return (int) (((this.totalBufferSize - this.totalBytesRead) - this.currentByteBufferPos) + this.currentByteBufferStartPos);
        }

        private long currentRemaining() {
            return this.currentByteBufferLimit - this.currentByteBufferPos;
        }

        private ByteBuffer slice(int begin, int end) throws IOException {
            int position = this.currentByteBuffer.position();
            int limit = this.currentByteBuffer.limit();
            ByteBuffer byteBuffer = this.currentByteBuffer;
            try {
                try {
                    byteBuffer.position(begin);
                    byteBuffer.limit(end);
                    return this.currentByteBuffer.slice();
                } catch (IllegalArgumentException unused) {
                    throw InvalidProtocolBufferException.truncatedMessage();
                }
            } finally {
                byteBuffer.position(position);
                byteBuffer.limit(limit);
            }
        }
    }
}
