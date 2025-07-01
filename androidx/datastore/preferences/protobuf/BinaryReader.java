package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.InvalidProtocolBufferException;
import androidx.datastore.preferences.protobuf.MapEntryLite;
import androidx.datastore.preferences.protobuf.WireFormat;
import com.google.common.base.Ascii;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Map;

@CheckReturnValue
/* loaded from: classes.dex */
abstract class BinaryReader implements Reader {
    private static final int FIXED32_MULTIPLE_MASK = 3;
    private static final int FIXED64_MULTIPLE_MASK = 7;

    public abstract int getTotalBytesRead();

    @Override // androidx.datastore.preferences.protobuf.Reader
    public boolean shouldDiscardUnknownFields() {
        return false;
    }

    /* synthetic */ BinaryReader(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static BinaryReader newInstance(ByteBuffer buffer, boolean bufferIsImmutable) {
        if (buffer.hasArray()) {
            return new SafeHeapReader(buffer, bufferIsImmutable);
        }
        throw new IllegalArgumentException("Direct buffers not yet supported");
    }

    private BinaryReader() {
    }

    /* loaded from: classes.dex */
    private static final class SafeHeapReader extends BinaryReader {
        private final byte[] buffer;
        private final boolean bufferIsImmutable;
        private int endGroupTag;
        private final int initialPos;
        private int limit;
        private int pos;
        private int tag;

        public SafeHeapReader(ByteBuffer bytebuf, boolean bufferIsImmutable) {
            super(null);
            this.bufferIsImmutable = bufferIsImmutable;
            this.buffer = bytebuf.array();
            int arrayOffset = bytebuf.arrayOffset() + bytebuf.position();
            this.pos = arrayOffset;
            this.initialPos = arrayOffset;
            this.limit = bytebuf.arrayOffset() + bytebuf.limit();
        }

        private boolean isAtEnd() {
            return this.pos == this.limit;
        }

        @Override // androidx.datastore.preferences.protobuf.BinaryReader
        public int getTotalBytesRead() {
            return this.pos - this.initialPos;
        }

        @Override // androidx.datastore.preferences.protobuf.Reader
        public int getFieldNumber() throws IOException {
            if (isAtEnd()) {
                return Integer.MAX_VALUE;
            }
            int readVarint32 = readVarint32();
            this.tag = readVarint32;
            if (readVarint32 == this.endGroupTag) {
                return Integer.MAX_VALUE;
            }
            return WireFormat.getTagFieldNumber(readVarint32);
        }

        @Override // androidx.datastore.preferences.protobuf.Reader
        public int getTag() {
            return this.tag;
        }

        @Override // androidx.datastore.preferences.protobuf.Reader
        public boolean skipField() throws IOException {
            int i;
            if (isAtEnd() || (i = this.tag) == this.endGroupTag) {
                return false;
            }
            int tagWireType = WireFormat.getTagWireType(i);
            if (tagWireType == 0) {
                skipVarint();
                return true;
            }
            if (tagWireType == 1) {
                skipBytes(8);
                return true;
            }
            if (tagWireType == 2) {
                skipBytes(readVarint32());
                return true;
            }
            if (tagWireType == 3) {
                skipGroup();
                return true;
            }
            if (tagWireType == 5) {
                skipBytes(4);
                return true;
            }
            throw InvalidProtocolBufferException.invalidWireType();
        }

        @Override // androidx.datastore.preferences.protobuf.Reader
        public double readDouble() throws IOException {
            requireWireType(1);
            return Double.longBitsToDouble(readLittleEndian64());
        }

        @Override // androidx.datastore.preferences.protobuf.Reader
        public float readFloat() throws IOException {
            requireWireType(5);
            return Float.intBitsToFloat(readLittleEndian32());
        }

        @Override // androidx.datastore.preferences.protobuf.Reader
        public long readUInt64() throws IOException {
            requireWireType(0);
            return readVarint64();
        }

        @Override // androidx.datastore.preferences.protobuf.Reader
        public long readInt64() throws IOException {
            requireWireType(0);
            return readVarint64();
        }

        @Override // androidx.datastore.preferences.protobuf.Reader
        public int readInt32() throws IOException {
            requireWireType(0);
            return readVarint32();
        }

        @Override // androidx.datastore.preferences.protobuf.Reader
        public long readFixed64() throws IOException {
            requireWireType(1);
            return readLittleEndian64();
        }

        @Override // androidx.datastore.preferences.protobuf.Reader
        public int readFixed32() throws IOException {
            requireWireType(5);
            return readLittleEndian32();
        }

        @Override // androidx.datastore.preferences.protobuf.Reader
        public boolean readBool() throws IOException {
            requireWireType(0);
            return readVarint32() != 0;
        }

        @Override // androidx.datastore.preferences.protobuf.Reader
        public String readString() throws IOException {
            return readStringInternal(false);
        }

        @Override // androidx.datastore.preferences.protobuf.Reader
        public String readStringRequireUtf8() throws IOException {
            return readStringInternal(true);
        }

        public String readStringInternal(boolean requireUtf8) throws IOException {
            requireWireType(2);
            int readVarint32 = readVarint32();
            if (readVarint32 == 0) {
                return "";
            }
            requireBytes(readVarint32);
            if (requireUtf8) {
                byte[] bArr = this.buffer;
                int i = this.pos;
                if (!Utf8.isValidUtf8(bArr, i, i + readVarint32)) {
                    throw InvalidProtocolBufferException.invalidUtf8();
                }
            }
            String str = new String(this.buffer, this.pos, readVarint32, Internal.UTF_8);
            this.pos += readVarint32;
            return str;
        }

        @Override // androidx.datastore.preferences.protobuf.Reader
        public <T> T readMessage(Class<T> cls, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            requireWireType(2);
            return (T) readMessage(Protobuf.getInstance().schemaFor((Class) cls), extensionRegistryLite);
        }

        @Override // androidx.datastore.preferences.protobuf.Reader
        public <T> T readMessageBySchemaWithCheck(Schema<T> schema, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            requireWireType(2);
            return (T) readMessage(schema, extensionRegistryLite);
        }

        private <T> T readMessage(Schema<T> schema, ExtensionRegistryLite extensionRegistry) throws IOException {
            T newInstance = schema.newInstance();
            mergeMessageField(newInstance, schema, extensionRegistry);
            schema.makeImmutable(newInstance);
            return newInstance;
        }

        @Override // androidx.datastore.preferences.protobuf.Reader
        public <T> void mergeMessageField(T target, Schema<T> schema, ExtensionRegistryLite extensionRegistry) throws IOException {
            int readVarint32 = readVarint32();
            requireBytes(readVarint32);
            int i = this.limit;
            int i2 = this.pos + readVarint32;
            this.limit = i2;
            try {
                schema.mergeFrom(target, this, extensionRegistry);
                if (this.pos == i2) {
                } else {
                    throw InvalidProtocolBufferException.parseFailure();
                }
            } finally {
                this.limit = i;
            }
        }

        @Override // androidx.datastore.preferences.protobuf.Reader
        @Deprecated
        public <T> T readGroup(Class<T> cls, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            requireWireType(3);
            return (T) readGroup(Protobuf.getInstance().schemaFor((Class) cls), extensionRegistryLite);
        }

        @Override // androidx.datastore.preferences.protobuf.Reader
        @Deprecated
        public <T> T readGroupBySchemaWithCheck(Schema<T> schema, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            requireWireType(3);
            return (T) readGroup(schema, extensionRegistryLite);
        }

        private <T> T readGroup(Schema<T> schema, ExtensionRegistryLite extensionRegistry) throws IOException {
            T newInstance = schema.newInstance();
            mergeGroupField(newInstance, schema, extensionRegistry);
            schema.makeImmutable(newInstance);
            return newInstance;
        }

        @Override // androidx.datastore.preferences.protobuf.Reader
        public <T> void mergeGroupField(T target, Schema<T> schema, ExtensionRegistryLite extensionRegistry) throws IOException {
            int i = this.endGroupTag;
            this.endGroupTag = WireFormat.makeTag(WireFormat.getTagFieldNumber(this.tag), 4);
            try {
                schema.mergeFrom(target, this, extensionRegistry);
                if (this.tag == this.endGroupTag) {
                } else {
                    throw InvalidProtocolBufferException.parseFailure();
                }
            } finally {
                this.endGroupTag = i;
            }
        }

        @Override // androidx.datastore.preferences.protobuf.Reader
        public ByteString readBytes() throws IOException {
            ByteString copyFrom;
            requireWireType(2);
            int readVarint32 = readVarint32();
            if (readVarint32 == 0) {
                return ByteString.EMPTY;
            }
            requireBytes(readVarint32);
            if (this.bufferIsImmutable) {
                copyFrom = ByteString.wrap(this.buffer, this.pos, readVarint32);
            } else {
                copyFrom = ByteString.copyFrom(this.buffer, this.pos, readVarint32);
            }
            this.pos += readVarint32;
            return copyFrom;
        }

        @Override // androidx.datastore.preferences.protobuf.Reader
        public int readUInt32() throws IOException {
            requireWireType(0);
            return readVarint32();
        }

        @Override // androidx.datastore.preferences.protobuf.Reader
        public int readEnum() throws IOException {
            requireWireType(0);
            return readVarint32();
        }

        @Override // androidx.datastore.preferences.protobuf.Reader
        public int readSFixed32() throws IOException {
            requireWireType(5);
            return readLittleEndian32();
        }

        @Override // androidx.datastore.preferences.protobuf.Reader
        public long readSFixed64() throws IOException {
            requireWireType(1);
            return readLittleEndian64();
        }

        @Override // androidx.datastore.preferences.protobuf.Reader
        public int readSInt32() throws IOException {
            requireWireType(0);
            return CodedInputStream.decodeZigZag32(readVarint32());
        }

        @Override // androidx.datastore.preferences.protobuf.Reader
        public long readSInt64() throws IOException {
            requireWireType(0);
            return CodedInputStream.decodeZigZag64(readVarint64());
        }

        @Override // androidx.datastore.preferences.protobuf.Reader
        public void readDoubleList(List<Double> target) throws IOException {
            int i;
            int i2;
            if (target instanceof DoubleArrayList) {
                DoubleArrayList doubleArrayList = (DoubleArrayList) target;
                int tagWireType = WireFormat.getTagWireType(this.tag);
                if (tagWireType != 1) {
                    if (tagWireType == 2) {
                        int readVarint32 = readVarint32();
                        verifyPackedFixed64Length(readVarint32);
                        int i3 = this.pos + readVarint32;
                        while (this.pos < i3) {
                            doubleArrayList.addDouble(Double.longBitsToDouble(readLittleEndian64_NoCheck()));
                        }
                        return;
                    }
                    throw InvalidProtocolBufferException.invalidWireType();
                }
                do {
                    doubleArrayList.addDouble(readDouble());
                    if (isAtEnd()) {
                        return;
                    } else {
                        i2 = this.pos;
                    }
                } while (readVarint32() == this.tag);
                this.pos = i2;
                return;
            }
            int tagWireType2 = WireFormat.getTagWireType(this.tag);
            if (tagWireType2 != 1) {
                if (tagWireType2 == 2) {
                    int readVarint322 = readVarint32();
                    verifyPackedFixed64Length(readVarint322);
                    int i4 = this.pos + readVarint322;
                    while (this.pos < i4) {
                        target.add(Double.valueOf(Double.longBitsToDouble(readLittleEndian64_NoCheck())));
                    }
                    return;
                }
                throw InvalidProtocolBufferException.invalidWireType();
            }
            do {
                target.add(Double.valueOf(readDouble()));
                if (isAtEnd()) {
                    return;
                } else {
                    i = this.pos;
                }
            } while (readVarint32() == this.tag);
            this.pos = i;
        }

        @Override // androidx.datastore.preferences.protobuf.Reader
        public void readFloatList(List<Float> target) throws IOException {
            int i;
            int i2;
            if (target instanceof FloatArrayList) {
                FloatArrayList floatArrayList = (FloatArrayList) target;
                int tagWireType = WireFormat.getTagWireType(this.tag);
                if (tagWireType == 2) {
                    int readVarint32 = readVarint32();
                    verifyPackedFixed32Length(readVarint32);
                    int i3 = this.pos + readVarint32;
                    while (this.pos < i3) {
                        floatArrayList.addFloat(Float.intBitsToFloat(readLittleEndian32_NoCheck()));
                    }
                    return;
                }
                if (tagWireType != 5) {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
                do {
                    floatArrayList.addFloat(readFloat());
                    if (isAtEnd()) {
                        return;
                    } else {
                        i2 = this.pos;
                    }
                } while (readVarint32() == this.tag);
                this.pos = i2;
                return;
            }
            int tagWireType2 = WireFormat.getTagWireType(this.tag);
            if (tagWireType2 == 2) {
                int readVarint322 = readVarint32();
                verifyPackedFixed32Length(readVarint322);
                int i4 = this.pos + readVarint322;
                while (this.pos < i4) {
                    target.add(Float.valueOf(Float.intBitsToFloat(readLittleEndian32_NoCheck())));
                }
                return;
            }
            if (tagWireType2 != 5) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            do {
                target.add(Float.valueOf(readFloat()));
                if (isAtEnd()) {
                    return;
                } else {
                    i = this.pos;
                }
            } while (readVarint32() == this.tag);
            this.pos = i;
        }

        @Override // androidx.datastore.preferences.protobuf.Reader
        public void readUInt64List(List<Long> target) throws IOException {
            int i;
            int i2;
            if (target instanceof LongArrayList) {
                LongArrayList longArrayList = (LongArrayList) target;
                int tagWireType = WireFormat.getTagWireType(this.tag);
                if (tagWireType != 0) {
                    if (tagWireType == 2) {
                        int readVarint32 = this.pos + readVarint32();
                        while (this.pos < readVarint32) {
                            longArrayList.addLong(readVarint64());
                        }
                        requirePosition(readVarint32);
                        return;
                    }
                    throw InvalidProtocolBufferException.invalidWireType();
                }
                do {
                    longArrayList.addLong(readUInt64());
                    if (isAtEnd()) {
                        return;
                    } else {
                        i2 = this.pos;
                    }
                } while (readVarint32() == this.tag);
                this.pos = i2;
                return;
            }
            int tagWireType2 = WireFormat.getTagWireType(this.tag);
            if (tagWireType2 != 0) {
                if (tagWireType2 == 2) {
                    int readVarint322 = this.pos + readVarint32();
                    while (this.pos < readVarint322) {
                        target.add(Long.valueOf(readVarint64()));
                    }
                    requirePosition(readVarint322);
                    return;
                }
                throw InvalidProtocolBufferException.invalidWireType();
            }
            do {
                target.add(Long.valueOf(readUInt64()));
                if (isAtEnd()) {
                    return;
                } else {
                    i = this.pos;
                }
            } while (readVarint32() == this.tag);
            this.pos = i;
        }

        @Override // androidx.datastore.preferences.protobuf.Reader
        public void readInt64List(List<Long> target) throws IOException {
            int i;
            int i2;
            if (target instanceof LongArrayList) {
                LongArrayList longArrayList = (LongArrayList) target;
                int tagWireType = WireFormat.getTagWireType(this.tag);
                if (tagWireType != 0) {
                    if (tagWireType == 2) {
                        int readVarint32 = this.pos + readVarint32();
                        while (this.pos < readVarint32) {
                            longArrayList.addLong(readVarint64());
                        }
                        requirePosition(readVarint32);
                        return;
                    }
                    throw InvalidProtocolBufferException.invalidWireType();
                }
                do {
                    longArrayList.addLong(readInt64());
                    if (isAtEnd()) {
                        return;
                    } else {
                        i2 = this.pos;
                    }
                } while (readVarint32() == this.tag);
                this.pos = i2;
                return;
            }
            int tagWireType2 = WireFormat.getTagWireType(this.tag);
            if (tagWireType2 != 0) {
                if (tagWireType2 == 2) {
                    int readVarint322 = this.pos + readVarint32();
                    while (this.pos < readVarint322) {
                        target.add(Long.valueOf(readVarint64()));
                    }
                    requirePosition(readVarint322);
                    return;
                }
                throw InvalidProtocolBufferException.invalidWireType();
            }
            do {
                target.add(Long.valueOf(readInt64()));
                if (isAtEnd()) {
                    return;
                } else {
                    i = this.pos;
                }
            } while (readVarint32() == this.tag);
            this.pos = i;
        }

        @Override // androidx.datastore.preferences.protobuf.Reader
        public void readInt32List(List<Integer> target) throws IOException {
            int i;
            int i2;
            if (target instanceof IntArrayList) {
                IntArrayList intArrayList = (IntArrayList) target;
                int tagWireType = WireFormat.getTagWireType(this.tag);
                if (tagWireType != 0) {
                    if (tagWireType == 2) {
                        int readVarint32 = this.pos + readVarint32();
                        while (this.pos < readVarint32) {
                            intArrayList.addInt(readVarint32());
                        }
                        requirePosition(readVarint32);
                        return;
                    }
                    throw InvalidProtocolBufferException.invalidWireType();
                }
                do {
                    intArrayList.addInt(readInt32());
                    if (isAtEnd()) {
                        return;
                    } else {
                        i2 = this.pos;
                    }
                } while (readVarint32() == this.tag);
                this.pos = i2;
                return;
            }
            int tagWireType2 = WireFormat.getTagWireType(this.tag);
            if (tagWireType2 != 0) {
                if (tagWireType2 == 2) {
                    int readVarint322 = this.pos + readVarint32();
                    while (this.pos < readVarint322) {
                        target.add(Integer.valueOf(readVarint32()));
                    }
                    requirePosition(readVarint322);
                    return;
                }
                throw InvalidProtocolBufferException.invalidWireType();
            }
            do {
                target.add(Integer.valueOf(readInt32()));
                if (isAtEnd()) {
                    return;
                } else {
                    i = this.pos;
                }
            } while (readVarint32() == this.tag);
            this.pos = i;
        }

        @Override // androidx.datastore.preferences.protobuf.Reader
        public void readFixed64List(List<Long> target) throws IOException {
            int i;
            int i2;
            if (target instanceof LongArrayList) {
                LongArrayList longArrayList = (LongArrayList) target;
                int tagWireType = WireFormat.getTagWireType(this.tag);
                if (tagWireType != 1) {
                    if (tagWireType == 2) {
                        int readVarint32 = readVarint32();
                        verifyPackedFixed64Length(readVarint32);
                        int i3 = this.pos + readVarint32;
                        while (this.pos < i3) {
                            longArrayList.addLong(readLittleEndian64_NoCheck());
                        }
                        return;
                    }
                    throw InvalidProtocolBufferException.invalidWireType();
                }
                do {
                    longArrayList.addLong(readFixed64());
                    if (isAtEnd()) {
                        return;
                    } else {
                        i2 = this.pos;
                    }
                } while (readVarint32() == this.tag);
                this.pos = i2;
                return;
            }
            int tagWireType2 = WireFormat.getTagWireType(this.tag);
            if (tagWireType2 != 1) {
                if (tagWireType2 == 2) {
                    int readVarint322 = readVarint32();
                    verifyPackedFixed64Length(readVarint322);
                    int i4 = this.pos + readVarint322;
                    while (this.pos < i4) {
                        target.add(Long.valueOf(readLittleEndian64_NoCheck()));
                    }
                    return;
                }
                throw InvalidProtocolBufferException.invalidWireType();
            }
            do {
                target.add(Long.valueOf(readFixed64()));
                if (isAtEnd()) {
                    return;
                } else {
                    i = this.pos;
                }
            } while (readVarint32() == this.tag);
            this.pos = i;
        }

        @Override // androidx.datastore.preferences.protobuf.Reader
        public void readFixed32List(List<Integer> target) throws IOException {
            int i;
            int i2;
            if (target instanceof IntArrayList) {
                IntArrayList intArrayList = (IntArrayList) target;
                int tagWireType = WireFormat.getTagWireType(this.tag);
                if (tagWireType == 2) {
                    int readVarint32 = readVarint32();
                    verifyPackedFixed32Length(readVarint32);
                    int i3 = this.pos + readVarint32;
                    while (this.pos < i3) {
                        intArrayList.addInt(readLittleEndian32_NoCheck());
                    }
                    return;
                }
                if (tagWireType != 5) {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
                do {
                    intArrayList.addInt(readFixed32());
                    if (isAtEnd()) {
                        return;
                    } else {
                        i2 = this.pos;
                    }
                } while (readVarint32() == this.tag);
                this.pos = i2;
                return;
            }
            int tagWireType2 = WireFormat.getTagWireType(this.tag);
            if (tagWireType2 == 2) {
                int readVarint322 = readVarint32();
                verifyPackedFixed32Length(readVarint322);
                int i4 = this.pos + readVarint322;
                while (this.pos < i4) {
                    target.add(Integer.valueOf(readLittleEndian32_NoCheck()));
                }
                return;
            }
            if (tagWireType2 != 5) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            do {
                target.add(Integer.valueOf(readFixed32()));
                if (isAtEnd()) {
                    return;
                } else {
                    i = this.pos;
                }
            } while (readVarint32() == this.tag);
            this.pos = i;
        }

        @Override // androidx.datastore.preferences.protobuf.Reader
        public void readBoolList(List<Boolean> target) throws IOException {
            int i;
            int i2;
            if (target instanceof BooleanArrayList) {
                BooleanArrayList booleanArrayList = (BooleanArrayList) target;
                int tagWireType = WireFormat.getTagWireType(this.tag);
                if (tagWireType != 0) {
                    if (tagWireType == 2) {
                        int readVarint32 = this.pos + readVarint32();
                        while (this.pos < readVarint32) {
                            booleanArrayList.addBoolean(readVarint32() != 0);
                        }
                        requirePosition(readVarint32);
                        return;
                    }
                    throw InvalidProtocolBufferException.invalidWireType();
                }
                do {
                    booleanArrayList.addBoolean(readBool());
                    if (isAtEnd()) {
                        return;
                    } else {
                        i2 = this.pos;
                    }
                } while (readVarint32() == this.tag);
                this.pos = i2;
                return;
            }
            int tagWireType2 = WireFormat.getTagWireType(this.tag);
            if (tagWireType2 != 0) {
                if (tagWireType2 == 2) {
                    int readVarint322 = this.pos + readVarint32();
                    while (this.pos < readVarint322) {
                        target.add(Boolean.valueOf(readVarint32() != 0));
                    }
                    requirePosition(readVarint322);
                    return;
                }
                throw InvalidProtocolBufferException.invalidWireType();
            }
            do {
                target.add(Boolean.valueOf(readBool()));
                if (isAtEnd()) {
                    return;
                } else {
                    i = this.pos;
                }
            } while (readVarint32() == this.tag);
            this.pos = i;
        }

        @Override // androidx.datastore.preferences.protobuf.Reader
        public void readStringList(List<String> target) throws IOException {
            readStringListInternal(target, false);
        }

        @Override // androidx.datastore.preferences.protobuf.Reader
        public void readStringListRequireUtf8(List<String> target) throws IOException {
            readStringListInternal(target, true);
        }

        public void readStringListInternal(List<String> target, boolean requireUtf8) throws IOException {
            int i;
            int i2;
            if (WireFormat.getTagWireType(this.tag) != 2) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            if ((target instanceof LazyStringList) && !requireUtf8) {
                LazyStringList lazyStringList = (LazyStringList) target;
                do {
                    lazyStringList.add(readBytes());
                    if (isAtEnd()) {
                        return;
                    } else {
                        i2 = this.pos;
                    }
                } while (readVarint32() == this.tag);
                this.pos = i2;
                return;
            }
            do {
                target.add(readStringInternal(requireUtf8));
                if (isAtEnd()) {
                    return;
                } else {
                    i = this.pos;
                }
            } while (readVarint32() == this.tag);
            this.pos = i;
        }

        @Override // androidx.datastore.preferences.protobuf.Reader
        public <T> void readMessageList(List<T> target, Class<T> targetType, ExtensionRegistryLite extensionRegistry) throws IOException {
            readMessageList(target, Protobuf.getInstance().schemaFor((Class) targetType), extensionRegistry);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.datastore.preferences.protobuf.Reader
        public <T> void readMessageList(List<T> target, Schema<T> schema, ExtensionRegistryLite extensionRegistry) throws IOException {
            int i;
            if (WireFormat.getTagWireType(this.tag) != 2) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            int i2 = this.tag;
            do {
                target.add(readMessage(schema, extensionRegistry));
                if (isAtEnd()) {
                    return;
                } else {
                    i = this.pos;
                }
            } while (readVarint32() == i2);
            this.pos = i;
        }

        @Override // androidx.datastore.preferences.protobuf.Reader
        @Deprecated
        public <T> void readGroupList(List<T> target, Class<T> targetType, ExtensionRegistryLite extensionRegistry) throws IOException {
            readGroupList(target, Protobuf.getInstance().schemaFor((Class) targetType), extensionRegistry);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.datastore.preferences.protobuf.Reader
        @Deprecated
        public <T> void readGroupList(List<T> target, Schema<T> schema, ExtensionRegistryLite extensionRegistry) throws IOException {
            int i;
            if (WireFormat.getTagWireType(this.tag) != 3) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            int i2 = this.tag;
            do {
                target.add(readGroup(schema, extensionRegistry));
                if (isAtEnd()) {
                    return;
                } else {
                    i = this.pos;
                }
            } while (readVarint32() == i2);
            this.pos = i;
        }

        @Override // androidx.datastore.preferences.protobuf.Reader
        public void readBytesList(List<ByteString> target) throws IOException {
            int i;
            if (WireFormat.getTagWireType(this.tag) != 2) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            do {
                target.add(readBytes());
                if (isAtEnd()) {
                    return;
                } else {
                    i = this.pos;
                }
            } while (readVarint32() == this.tag);
            this.pos = i;
        }

        @Override // androidx.datastore.preferences.protobuf.Reader
        public void readUInt32List(List<Integer> target) throws IOException {
            int i;
            int i2;
            if (target instanceof IntArrayList) {
                IntArrayList intArrayList = (IntArrayList) target;
                int tagWireType = WireFormat.getTagWireType(this.tag);
                if (tagWireType != 0) {
                    if (tagWireType == 2) {
                        int readVarint32 = this.pos + readVarint32();
                        while (this.pos < readVarint32) {
                            intArrayList.addInt(readVarint32());
                        }
                        return;
                    }
                    throw InvalidProtocolBufferException.invalidWireType();
                }
                do {
                    intArrayList.addInt(readUInt32());
                    if (isAtEnd()) {
                        return;
                    } else {
                        i2 = this.pos;
                    }
                } while (readVarint32() == this.tag);
                this.pos = i2;
                return;
            }
            int tagWireType2 = WireFormat.getTagWireType(this.tag);
            if (tagWireType2 != 0) {
                if (tagWireType2 == 2) {
                    int readVarint322 = this.pos + readVarint32();
                    while (this.pos < readVarint322) {
                        target.add(Integer.valueOf(readVarint32()));
                    }
                    return;
                }
                throw InvalidProtocolBufferException.invalidWireType();
            }
            do {
                target.add(Integer.valueOf(readUInt32()));
                if (isAtEnd()) {
                    return;
                } else {
                    i = this.pos;
                }
            } while (readVarint32() == this.tag);
            this.pos = i;
        }

        @Override // androidx.datastore.preferences.protobuf.Reader
        public void readEnumList(List<Integer> target) throws IOException {
            int i;
            int i2;
            if (target instanceof IntArrayList) {
                IntArrayList intArrayList = (IntArrayList) target;
                int tagWireType = WireFormat.getTagWireType(this.tag);
                if (tagWireType != 0) {
                    if (tagWireType == 2) {
                        int readVarint32 = this.pos + readVarint32();
                        while (this.pos < readVarint32) {
                            intArrayList.addInt(readVarint32());
                        }
                        return;
                    }
                    throw InvalidProtocolBufferException.invalidWireType();
                }
                do {
                    intArrayList.addInt(readEnum());
                    if (isAtEnd()) {
                        return;
                    } else {
                        i2 = this.pos;
                    }
                } while (readVarint32() == this.tag);
                this.pos = i2;
                return;
            }
            int tagWireType2 = WireFormat.getTagWireType(this.tag);
            if (tagWireType2 != 0) {
                if (tagWireType2 == 2) {
                    int readVarint322 = this.pos + readVarint32();
                    while (this.pos < readVarint322) {
                        target.add(Integer.valueOf(readVarint32()));
                    }
                    return;
                }
                throw InvalidProtocolBufferException.invalidWireType();
            }
            do {
                target.add(Integer.valueOf(readEnum()));
                if (isAtEnd()) {
                    return;
                } else {
                    i = this.pos;
                }
            } while (readVarint32() == this.tag);
            this.pos = i;
        }

        @Override // androidx.datastore.preferences.protobuf.Reader
        public void readSFixed32List(List<Integer> target) throws IOException {
            int i;
            int i2;
            if (target instanceof IntArrayList) {
                IntArrayList intArrayList = (IntArrayList) target;
                int tagWireType = WireFormat.getTagWireType(this.tag);
                if (tagWireType == 2) {
                    int readVarint32 = readVarint32();
                    verifyPackedFixed32Length(readVarint32);
                    int i3 = this.pos + readVarint32;
                    while (this.pos < i3) {
                        intArrayList.addInt(readLittleEndian32_NoCheck());
                    }
                    return;
                }
                if (tagWireType != 5) {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
                do {
                    intArrayList.addInt(readSFixed32());
                    if (isAtEnd()) {
                        return;
                    } else {
                        i2 = this.pos;
                    }
                } while (readVarint32() == this.tag);
                this.pos = i2;
                return;
            }
            int tagWireType2 = WireFormat.getTagWireType(this.tag);
            if (tagWireType2 == 2) {
                int readVarint322 = readVarint32();
                verifyPackedFixed32Length(readVarint322);
                int i4 = this.pos + readVarint322;
                while (this.pos < i4) {
                    target.add(Integer.valueOf(readLittleEndian32_NoCheck()));
                }
                return;
            }
            if (tagWireType2 != 5) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            do {
                target.add(Integer.valueOf(readSFixed32()));
                if (isAtEnd()) {
                    return;
                } else {
                    i = this.pos;
                }
            } while (readVarint32() == this.tag);
            this.pos = i;
        }

        @Override // androidx.datastore.preferences.protobuf.Reader
        public void readSFixed64List(List<Long> target) throws IOException {
            int i;
            int i2;
            if (target instanceof LongArrayList) {
                LongArrayList longArrayList = (LongArrayList) target;
                int tagWireType = WireFormat.getTagWireType(this.tag);
                if (tagWireType != 1) {
                    if (tagWireType == 2) {
                        int readVarint32 = readVarint32();
                        verifyPackedFixed64Length(readVarint32);
                        int i3 = this.pos + readVarint32;
                        while (this.pos < i3) {
                            longArrayList.addLong(readLittleEndian64_NoCheck());
                        }
                        return;
                    }
                    throw InvalidProtocolBufferException.invalidWireType();
                }
                do {
                    longArrayList.addLong(readSFixed64());
                    if (isAtEnd()) {
                        return;
                    } else {
                        i2 = this.pos;
                    }
                } while (readVarint32() == this.tag);
                this.pos = i2;
                return;
            }
            int tagWireType2 = WireFormat.getTagWireType(this.tag);
            if (tagWireType2 != 1) {
                if (tagWireType2 == 2) {
                    int readVarint322 = readVarint32();
                    verifyPackedFixed64Length(readVarint322);
                    int i4 = this.pos + readVarint322;
                    while (this.pos < i4) {
                        target.add(Long.valueOf(readLittleEndian64_NoCheck()));
                    }
                    return;
                }
                throw InvalidProtocolBufferException.invalidWireType();
            }
            do {
                target.add(Long.valueOf(readSFixed64()));
                if (isAtEnd()) {
                    return;
                } else {
                    i = this.pos;
                }
            } while (readVarint32() == this.tag);
            this.pos = i;
        }

        @Override // androidx.datastore.preferences.protobuf.Reader
        public void readSInt32List(List<Integer> target) throws IOException {
            int i;
            int i2;
            if (target instanceof IntArrayList) {
                IntArrayList intArrayList = (IntArrayList) target;
                int tagWireType = WireFormat.getTagWireType(this.tag);
                if (tagWireType != 0) {
                    if (tagWireType == 2) {
                        int readVarint32 = this.pos + readVarint32();
                        while (this.pos < readVarint32) {
                            intArrayList.addInt(CodedInputStream.decodeZigZag32(readVarint32()));
                        }
                        return;
                    }
                    throw InvalidProtocolBufferException.invalidWireType();
                }
                do {
                    intArrayList.addInt(readSInt32());
                    if (isAtEnd()) {
                        return;
                    } else {
                        i2 = this.pos;
                    }
                } while (readVarint32() == this.tag);
                this.pos = i2;
                return;
            }
            int tagWireType2 = WireFormat.getTagWireType(this.tag);
            if (tagWireType2 != 0) {
                if (tagWireType2 == 2) {
                    int readVarint322 = this.pos + readVarint32();
                    while (this.pos < readVarint322) {
                        target.add(Integer.valueOf(CodedInputStream.decodeZigZag32(readVarint32())));
                    }
                    return;
                }
                throw InvalidProtocolBufferException.invalidWireType();
            }
            do {
                target.add(Integer.valueOf(readSInt32()));
                if (isAtEnd()) {
                    return;
                } else {
                    i = this.pos;
                }
            } while (readVarint32() == this.tag);
            this.pos = i;
        }

        @Override // androidx.datastore.preferences.protobuf.Reader
        public void readSInt64List(List<Long> target) throws IOException {
            int i;
            int i2;
            if (target instanceof LongArrayList) {
                LongArrayList longArrayList = (LongArrayList) target;
                int tagWireType = WireFormat.getTagWireType(this.tag);
                if (tagWireType != 0) {
                    if (tagWireType == 2) {
                        int readVarint32 = this.pos + readVarint32();
                        while (this.pos < readVarint32) {
                            longArrayList.addLong(CodedInputStream.decodeZigZag64(readVarint64()));
                        }
                        return;
                    }
                    throw InvalidProtocolBufferException.invalidWireType();
                }
                do {
                    longArrayList.addLong(readSInt64());
                    if (isAtEnd()) {
                        return;
                    } else {
                        i2 = this.pos;
                    }
                } while (readVarint32() == this.tag);
                this.pos = i2;
                return;
            }
            int tagWireType2 = WireFormat.getTagWireType(this.tag);
            if (tagWireType2 != 0) {
                if (tagWireType2 == 2) {
                    int readVarint322 = this.pos + readVarint32();
                    while (this.pos < readVarint322) {
                        target.add(Long.valueOf(CodedInputStream.decodeZigZag64(readVarint64())));
                    }
                    return;
                }
                throw InvalidProtocolBufferException.invalidWireType();
            }
            do {
                target.add(Long.valueOf(readSInt64()));
                if (isAtEnd()) {
                    return;
                } else {
                    i = this.pos;
                }
            } while (readVarint32() == this.tag);
            this.pos = i;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.datastore.preferences.protobuf.Reader
        public <K, V> void readMap(Map<K, V> target, MapEntryLite.Metadata<K, V> metadata, ExtensionRegistryLite extensionRegistry) throws IOException {
            requireWireType(2);
            int readVarint32 = readVarint32();
            requireBytes(readVarint32);
            int i = this.limit;
            this.limit = this.pos + readVarint32;
            try {
                Object obj = metadata.defaultKey;
                Object obj2 = metadata.defaultValue;
                while (true) {
                    int fieldNumber = getFieldNumber();
                    if (fieldNumber == Integer.MAX_VALUE) {
                        target.put(obj, obj2);
                        return;
                    }
                    if (fieldNumber == 1) {
                        obj = readField(metadata.keyType, null, null);
                    } else if (fieldNumber == 2) {
                        obj2 = readField(metadata.valueType, metadata.defaultValue.getClass(), extensionRegistry);
                    } else {
                        try {
                            if (!skipField()) {
                                throw new InvalidProtocolBufferException("Unable to parse map entry.");
                                break;
                            }
                        } catch (InvalidProtocolBufferException.InvalidWireTypeException unused) {
                            if (!skipField()) {
                                throw new InvalidProtocolBufferException("Unable to parse map entry.");
                            }
                        }
                    }
                }
            } finally {
                this.limit = i;
            }
        }

        private Object readField(WireFormat.FieldType fieldType, Class<?> messageType, ExtensionRegistryLite extensionRegistry) throws IOException {
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[fieldType.ordinal()]) {
                case 1:
                    return Boolean.valueOf(readBool());
                case 2:
                    return readBytes();
                case 3:
                    return Double.valueOf(readDouble());
                case 4:
                    return Integer.valueOf(readEnum());
                case 5:
                    return Integer.valueOf(readFixed32());
                case 6:
                    return Long.valueOf(readFixed64());
                case 7:
                    return Float.valueOf(readFloat());
                case 8:
                    return Integer.valueOf(readInt32());
                case 9:
                    return Long.valueOf(readInt64());
                case 10:
                    return readMessage(messageType, extensionRegistry);
                case 11:
                    return Integer.valueOf(readSFixed32());
                case 12:
                    return Long.valueOf(readSFixed64());
                case 13:
                    return Integer.valueOf(readSInt32());
                case 14:
                    return Long.valueOf(readSInt64());
                case 15:
                    return readStringRequireUtf8();
                case 16:
                    return Integer.valueOf(readUInt32());
                case 17:
                    return Long.valueOf(readUInt64());
                default:
                    throw new RuntimeException("unsupported field type.");
            }
        }

        private int readVarint32() throws IOException {
            int i;
            int i2 = this.pos;
            int i3 = this.limit;
            if (i3 == i2) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            byte[] bArr = this.buffer;
            int i4 = i2 + 1;
            byte b = bArr[i2];
            if (b >= 0) {
                this.pos = i4;
                return b;
            }
            if (i3 - i4 < 9) {
                return (int) readVarint64SlowPath();
            }
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
                                            if (bArr[i7] < 0) {
                                                throw InvalidProtocolBufferException.malformedVarint();
                                            }
                                            i5 = i12;
                                            i = i11;
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

        public long readVarint64() throws IOException {
            long j;
            long j2;
            long j3;
            int i = this.pos;
            int i2 = this.limit;
            if (i2 == i) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            byte[] bArr = this.buffer;
            int i3 = i + 1;
            byte b = bArr[i];
            if (b >= 0) {
                this.pos = i3;
                return b;
            }
            if (i2 - i3 < 9) {
                return readVarint64SlowPath();
            }
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
                                            if (bArr[i4] < 0) {
                                                throw InvalidProtocolBufferException.malformedVarint();
                                            }
                                            i4 = i11;
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

        private long readVarint64SlowPath() throws IOException {
            long j = 0;
            for (int i = 0; i < 64; i += 7) {
                j |= (r3 & Byte.MAX_VALUE) << i;
                if ((readByte() & 128) == 0) {
                    return j;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        private byte readByte() throws IOException {
            int i = this.pos;
            if (i == this.limit) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            byte[] bArr = this.buffer;
            this.pos = i + 1;
            return bArr[i];
        }

        private int readLittleEndian32() throws IOException {
            requireBytes(4);
            return readLittleEndian32_NoCheck();
        }

        private long readLittleEndian64() throws IOException {
            requireBytes(8);
            return readLittleEndian64_NoCheck();
        }

        private int readLittleEndian32_NoCheck() {
            int i = this.pos;
            byte[] bArr = this.buffer;
            this.pos = i + 4;
            return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
        }

        private long readLittleEndian64_NoCheck() {
            int i = this.pos;
            byte[] bArr = this.buffer;
            this.pos = i + 8;
            return ((bArr[i + 7] & 255) << 56) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16) | ((bArr[i + 3] & 255) << 24) | ((bArr[i + 4] & 255) << 32) | ((bArr[i + 5] & 255) << 40) | ((bArr[i + 6] & 255) << 48);
        }

        private void skipVarint() throws IOException {
            int i = this.limit;
            int i2 = this.pos;
            if (i - i2 >= 10) {
                byte[] bArr = this.buffer;
                int i3 = 0;
                while (i3 < 10) {
                    int i4 = i2 + 1;
                    if (bArr[i2] >= 0) {
                        this.pos = i4;
                        return;
                    } else {
                        i3++;
                        i2 = i4;
                    }
                }
            }
            skipVarintSlowPath();
        }

        private void skipVarintSlowPath() throws IOException {
            for (int i = 0; i < 10; i++) {
                if (readByte() >= 0) {
                    return;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        private void skipBytes(final int size) throws IOException {
            requireBytes(size);
            this.pos += size;
        }

        private void skipGroup() throws IOException {
            int i = this.endGroupTag;
            this.endGroupTag = WireFormat.makeTag(WireFormat.getTagFieldNumber(this.tag), 4);
            while (getFieldNumber() != Integer.MAX_VALUE && skipField()) {
            }
            if (this.tag != this.endGroupTag) {
                throw InvalidProtocolBufferException.parseFailure();
            }
            this.endGroupTag = i;
        }

        private void requireBytes(int size) throws IOException {
            if (size < 0 || size > this.limit - this.pos) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
        }

        private void requireWireType(int requiredWireType) throws IOException {
            if (WireFormat.getTagWireType(this.tag) != requiredWireType) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
        }

        private void verifyPackedFixed64Length(int bytes) throws IOException {
            requireBytes(bytes);
            if ((bytes & 7) != 0) {
                throw InvalidProtocolBufferException.parseFailure();
            }
        }

        private void verifyPackedFixed32Length(int bytes) throws IOException {
            requireBytes(bytes);
            if ((bytes & 3) != 0) {
                throw InvalidProtocolBufferException.parseFailure();
            }
        }

        private void requirePosition(int expectedPosition) throws IOException {
            if (this.pos != expectedPosition) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: androidx.datastore.preferences.protobuf.BinaryReader$1, reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$WireFormat$FieldType;

        static {
            int[] iArr = new int[WireFormat.FieldType.values().length];
            $SwitchMap$com$google$protobuf$WireFormat$FieldType = iArr;
            try {
                iArr[WireFormat.FieldType.BOOL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.BYTES.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.DOUBLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.ENUM.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FIXED32.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FIXED64.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FLOAT.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.INT32.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.INT64.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.MESSAGE.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SFIXED32.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SFIXED64.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SINT32.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SINT64.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.STRING.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.UINT32.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.UINT64.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
        }
    }
}
