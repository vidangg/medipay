package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.AbstractMessageLite;
import androidx.datastore.preferences.protobuf.ArrayDecoders;
import androidx.datastore.preferences.protobuf.FieldSet;
import androidx.datastore.preferences.protobuf.GeneratedMessageLite;
import androidx.datastore.preferences.protobuf.GeneratedMessageLite.Builder;
import androidx.datastore.preferences.protobuf.Internal;
import androidx.datastore.preferences.protobuf.MessageLite;
import androidx.datastore.preferences.protobuf.WireFormat;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public abstract class GeneratedMessageLite<MessageType extends GeneratedMessageLite<MessageType, BuilderType>, BuilderType extends Builder<MessageType, BuilderType>> extends AbstractMessageLite<MessageType, BuilderType> {
    private static final int MEMOIZED_SERIALIZED_SIZE_MASK = Integer.MAX_VALUE;
    private static final int MUTABLE_FLAG_MASK = Integer.MIN_VALUE;
    static final int UNINITIALIZED_HASH_CODE = 0;
    static final int UNINITIALIZED_SERIALIZED_SIZE = Integer.MAX_VALUE;
    private static Map<Object, GeneratedMessageLite<?, ?>> defaultInstanceMap = new ConcurrentHashMap();
    private int memoizedSerializedSize = -1;
    protected UnknownFieldSetLite unknownFields = UnknownFieldSetLite.getDefaultInstance();

    /* loaded from: classes.dex */
    public interface ExtendableMessageOrBuilder<MessageType extends ExtendableMessage<MessageType, BuilderType>, BuilderType extends ExtendableBuilder<MessageType, BuilderType>> extends MessageLiteOrBuilder {
        <Type> Type getExtension(ExtensionLite<MessageType, Type> extension);

        <Type> Type getExtension(ExtensionLite<MessageType, List<Type>> extension, int index);

        <Type> int getExtensionCount(ExtensionLite<MessageType, List<Type>> extension);

        <Type> boolean hasExtension(ExtensionLite<MessageType, Type> extension);
    }

    /* loaded from: classes.dex */
    public enum MethodToInvoke {
        GET_MEMOIZED_IS_INITIALIZED,
        SET_MEMOIZED_IS_INITIALIZED,
        BUILD_MESSAGE_INFO,
        NEW_MUTABLE_INSTANCE,
        NEW_BUILDER,
        GET_DEFAULT_INSTANCE,
        GET_PARSER
    }

    protected abstract Object dynamicMethod(MethodToInvoke method, Object arg0, Object arg1);

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isMutable() {
        return (this.memoizedSerializedSize & Integer.MIN_VALUE) != 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void markImmutable() {
        this.memoizedSerializedSize &= Integer.MAX_VALUE;
    }

    int getMemoizedHashCode() {
        return this.memoizedHashCode;
    }

    void setMemoizedHashCode(int value) {
        this.memoizedHashCode = value;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void clearMemoizedHashCode() {
        this.memoizedHashCode = 0;
    }

    boolean hashCodeIsNotMemoized() {
        return getMemoizedHashCode() == 0;
    }

    @Override // androidx.datastore.preferences.protobuf.MessageLite
    public final Parser<MessageType> getParserForType() {
        return (Parser) dynamicMethod(MethodToInvoke.GET_PARSER);
    }

    @Override // androidx.datastore.preferences.protobuf.MessageLiteOrBuilder
    public final MessageType getDefaultInstanceForType() {
        return (MessageType) dynamicMethod(MethodToInvoke.GET_DEFAULT_INSTANCE);
    }

    @Override // androidx.datastore.preferences.protobuf.MessageLite
    public final BuilderType newBuilderForType() {
        return (BuilderType) dynamicMethod(MethodToInvoke.NEW_BUILDER);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MessageType newMutableInstance() {
        return (MessageType) dynamicMethod(MethodToInvoke.NEW_MUTABLE_INSTANCE);
    }

    public String toString() {
        return MessageLiteToString.toString(this, super.toString());
    }

    public int hashCode() {
        if (isMutable()) {
            return computeHashCode();
        }
        if (hashCodeIsNotMemoized()) {
            setMemoizedHashCode(computeHashCode());
        }
        return getMemoizedHashCode();
    }

    int computeHashCode() {
        return Protobuf.getInstance().schemaFor((Protobuf) this).hashCode(this);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other != null && getClass() == other.getClass()) {
            return Protobuf.getInstance().schemaFor((Protobuf) this).equals(this, (GeneratedMessageLite) other);
        }
        return false;
    }

    private void ensureUnknownFieldsInitialized() {
        if (this.unknownFields == UnknownFieldSetLite.getDefaultInstance()) {
            this.unknownFields = UnknownFieldSetLite.newInstance();
        }
    }

    protected boolean parseUnknownField(int tag, CodedInputStream input) throws IOException {
        if (WireFormat.getTagWireType(tag) == 4) {
            return false;
        }
        ensureUnknownFieldsInitialized();
        return this.unknownFields.mergeFieldFrom(tag, input);
    }

    protected void mergeVarintField(int tag, int value) {
        ensureUnknownFieldsInitialized();
        this.unknownFields.mergeVarintField(tag, value);
    }

    protected void mergeLengthDelimitedField(int fieldNumber, ByteString value) {
        ensureUnknownFieldsInitialized();
        this.unknownFields.mergeLengthDelimitedField(fieldNumber, value);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void makeImmutable() {
        Protobuf.getInstance().schemaFor((Protobuf) this).makeImmutable(this);
        markImmutable();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final <MessageType extends GeneratedMessageLite<MessageType, BuilderType>, BuilderType extends Builder<MessageType, BuilderType>> BuilderType createBuilder() {
        return (BuilderType) dynamicMethod(MethodToInvoke.NEW_BUILDER);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final <MessageType extends GeneratedMessageLite<MessageType, BuilderType>, BuilderType extends Builder<MessageType, BuilderType>> BuilderType createBuilder(MessageType messagetype) {
        return (BuilderType) createBuilder().mergeFrom(messagetype);
    }

    @Override // androidx.datastore.preferences.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        return isInitialized(this, true);
    }

    @Override // androidx.datastore.preferences.protobuf.MessageLite
    public final BuilderType toBuilder() {
        return (BuilderType) ((Builder) dynamicMethod(MethodToInvoke.NEW_BUILDER)).mergeFrom((Builder) this);
    }

    protected Object dynamicMethod(MethodToInvoke method, Object arg0) {
        return dynamicMethod(method, arg0, null);
    }

    protected Object dynamicMethod(MethodToInvoke method) {
        return dynamicMethod(method, null, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void clearMemoizedSerializedSize() {
        setMemoizedSerializedSize(Integer.MAX_VALUE);
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractMessageLite
    int getMemoizedSerializedSize() {
        return this.memoizedSerializedSize & Integer.MAX_VALUE;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractMessageLite
    void setMemoizedSerializedSize(int size) {
        if (size < 0) {
            throw new IllegalStateException("serialized size must be non-negative, was " + size);
        }
        this.memoizedSerializedSize = (size & Integer.MAX_VALUE) | (this.memoizedSerializedSize & Integer.MIN_VALUE);
    }

    @Override // androidx.datastore.preferences.protobuf.MessageLite
    public void writeTo(CodedOutputStream output) throws IOException {
        Protobuf.getInstance().schemaFor((Protobuf) this).writeTo(this, CodedOutputStreamWriter.forCodedOutput(output));
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractMessageLite
    int getSerializedSize(Schema schema) {
        if (isMutable()) {
            int computeSerializedSize = computeSerializedSize(schema);
            if (computeSerializedSize >= 0) {
                return computeSerializedSize;
            }
            throw new IllegalStateException("serialized size must be non-negative, was " + computeSerializedSize);
        }
        if (getMemoizedSerializedSize() != Integer.MAX_VALUE) {
            return getMemoizedSerializedSize();
        }
        int computeSerializedSize2 = computeSerializedSize(schema);
        setMemoizedSerializedSize(computeSerializedSize2);
        return computeSerializedSize2;
    }

    @Override // androidx.datastore.preferences.protobuf.MessageLite
    public int getSerializedSize() {
        return getSerializedSize(null);
    }

    private int computeSerializedSize(Schema<?> nullableSchema) {
        if (nullableSchema == null) {
            return Protobuf.getInstance().schemaFor((Protobuf) this).getSerializedSize(this);
        }
        return nullableSchema.getSerializedSize(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Object buildMessageInfo() throws Exception {
        return dynamicMethod(MethodToInvoke.BUILD_MESSAGE_INFO);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T extends GeneratedMessageLite<?, ?>> T getDefaultInstance(Class<T> cls) {
        GeneratedMessageLite<?, ?> generatedMessageLite = defaultInstanceMap.get(cls);
        if (generatedMessageLite == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                generatedMessageLite = defaultInstanceMap.get(cls);
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException("Class initialization cannot fail.", e);
            }
        }
        if (generatedMessageLite == null) {
            generatedMessageLite = (T) ((GeneratedMessageLite) UnsafeUtil.allocateInstance(cls)).getDefaultInstanceForType();
            if (generatedMessageLite == null) {
                throw new IllegalStateException();
            }
            defaultInstanceMap.put(cls, generatedMessageLite);
        }
        return (T) generatedMessageLite;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <T extends GeneratedMessageLite<?, ?>> void registerDefaultInstance(Class<T> clazz, T defaultInstance) {
        defaultInstance.markImmutable();
        defaultInstanceMap.put(clazz, defaultInstance);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static Object newMessageInfo(MessageLite defaultInstance, String info, Object[] objects) {
        return new RawMessageInfo(defaultInstance, info, objects);
    }

    protected final void mergeUnknownFields(UnknownFieldSetLite unknownFields) {
        this.unknownFields = UnknownFieldSetLite.mutableCopyOf(this.unknownFields, unknownFields);
    }

    /* loaded from: classes.dex */
    public static abstract class Builder<MessageType extends GeneratedMessageLite<MessageType, BuilderType>, BuilderType extends Builder<MessageType, BuilderType>> extends AbstractMessageLite.Builder<MessageType, BuilderType> {
        private final MessageType defaultInstance;
        protected MessageType instance;

        /* JADX INFO: Access modifiers changed from: protected */
        public Builder(MessageType defaultInstance) {
            this.defaultInstance = defaultInstance;
            if (defaultInstance.isMutable()) {
                throw new IllegalArgumentException("Default instance must be immutable.");
            }
            this.instance = newMutableInstance();
        }

        private MessageType newMutableInstance() {
            return (MessageType) this.defaultInstance.newMutableInstance();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public final void copyOnWrite() {
            if (this.instance.isMutable()) {
                return;
            }
            copyOnWriteInternal();
        }

        protected void copyOnWriteInternal() {
            MessageType newMutableInstance = newMutableInstance();
            mergeFromInstance(newMutableInstance, this.instance);
            this.instance = newMutableInstance;
        }

        @Override // androidx.datastore.preferences.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return GeneratedMessageLite.isInitialized(this.instance, false);
        }

        @Override // androidx.datastore.preferences.protobuf.MessageLite.Builder
        public final BuilderType clear() {
            if (this.defaultInstance.isMutable()) {
                throw new IllegalArgumentException("Default instance must be immutable.");
            }
            this.instance = newMutableInstance();
            return this;
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractMessageLite.Builder
        /* renamed from: clone, reason: merged with bridge method [inline-methods] */
        public BuilderType mo347clone() {
            BuilderType buildertype = (BuilderType) getDefaultInstanceForType().newBuilderForType();
            buildertype.instance = buildPartial();
            return buildertype;
        }

        @Override // androidx.datastore.preferences.protobuf.MessageLite.Builder
        public MessageType buildPartial() {
            if (!this.instance.isMutable()) {
                return this.instance;
            }
            this.instance.makeImmutable();
            return this.instance;
        }

        @Override // androidx.datastore.preferences.protobuf.MessageLite.Builder
        public final MessageType build() {
            MessageType buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw newUninitializedMessageException(buildPartial);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.datastore.preferences.protobuf.AbstractMessageLite.Builder
        public BuilderType internalMergeFrom(MessageType message) {
            return mergeFrom((Builder<MessageType, BuilderType>) message);
        }

        public BuilderType mergeFrom(MessageType message) {
            if (getDefaultInstanceForType().equals(message)) {
                return this;
            }
            copyOnWrite();
            mergeFromInstance(this.instance, message);
            return this;
        }

        private static <MessageType> void mergeFromInstance(MessageType dest, MessageType src) {
            Protobuf.getInstance().schemaFor((Protobuf) dest).mergeFrom(dest, src);
        }

        @Override // androidx.datastore.preferences.protobuf.MessageLiteOrBuilder
        public MessageType getDefaultInstanceForType() {
            return this.defaultInstance;
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractMessageLite.Builder, androidx.datastore.preferences.protobuf.MessageLite.Builder
        public BuilderType mergeFrom(byte[] input, int offset, int length, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            copyOnWrite();
            try {
                Protobuf.getInstance().schemaFor((Protobuf) this.instance).mergeFrom(this.instance, input, offset, offset + length, new ArrayDecoders.Registers(extensionRegistry));
                return this;
            } catch (InvalidProtocolBufferException e) {
                throw e;
            } catch (IOException e2) {
                throw new RuntimeException("Reading from byte array should not throw IOException.", e2);
            } catch (IndexOutOfBoundsException unused) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractMessageLite.Builder, androidx.datastore.preferences.protobuf.MessageLite.Builder
        public BuilderType mergeFrom(byte[] input, int offset, int length) throws InvalidProtocolBufferException {
            return mergeFrom(input, offset, length, ExtensionRegistryLite.getEmptyRegistry());
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractMessageLite.Builder, androidx.datastore.preferences.protobuf.MessageLite.Builder
        public BuilderType mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            copyOnWrite();
            try {
                Protobuf.getInstance().schemaFor((Protobuf) this.instance).mergeFrom(this.instance, CodedInputStreamReader.forCodedInput(input), extensionRegistry);
                return this;
            } catch (RuntimeException e) {
                if (e.getCause() instanceof IOException) {
                    throw ((IOException) e.getCause());
                }
                throw e;
            }
        }
    }

    /* loaded from: classes.dex */
    public static abstract class ExtendableMessage<MessageType extends ExtendableMessage<MessageType, BuilderType>, BuilderType extends ExtendableBuilder<MessageType, BuilderType>> extends GeneratedMessageLite<MessageType, BuilderType> implements ExtendableMessageOrBuilder<MessageType, BuilderType> {
        protected FieldSet<ExtensionDescriptor> extensions = FieldSet.emptySet();

        @Override // androidx.datastore.preferences.protobuf.GeneratedMessageLite, androidx.datastore.preferences.protobuf.MessageLiteOrBuilder
        public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
            return super.getDefaultInstanceForType();
        }

        @Override // androidx.datastore.preferences.protobuf.GeneratedMessageLite, androidx.datastore.preferences.protobuf.MessageLite
        public /* bridge */ /* synthetic */ MessageLite.Builder newBuilderForType() {
            return super.newBuilderForType();
        }

        @Override // androidx.datastore.preferences.protobuf.GeneratedMessageLite, androidx.datastore.preferences.protobuf.MessageLite
        public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
            return super.toBuilder();
        }

        protected final void mergeExtensionFields(final MessageType other) {
            if (this.extensions.isImmutable()) {
                this.extensions = this.extensions.m348clone();
            }
            this.extensions.mergeFrom(other.extensions);
        }

        protected <MessageType extends MessageLite> boolean parseUnknownField(MessageType defaultInstance, CodedInputStream input, ExtensionRegistryLite extensionRegistry, int tag) throws IOException {
            int tagFieldNumber = WireFormat.getTagFieldNumber(tag);
            return parseExtension(input, extensionRegistry, extensionRegistry.findLiteExtensionByNumber(defaultInstance, tagFieldNumber), tag, tagFieldNumber);
        }

        /* JADX WARN: Removed duplicated region for block: B:5:0x003a  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x003f  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private boolean parseExtension(CodedInputStream input, ExtensionRegistryLite extensionRegistry, GeneratedExtension<?, ?> extension, int tag, int fieldNumber) throws IOException {
            boolean z;
            boolean z2;
            Object build;
            MessageLite messageLite;
            int tagWireType = WireFormat.getTagWireType(tag);
            if (extension != null) {
                if (tagWireType == FieldSet.getWireFormatForFieldType(extension.descriptor.getLiteType(), false)) {
                    z2 = false;
                    z = false;
                } else if (extension.descriptor.isRepeated && extension.descriptor.type.isPackable() && tagWireType == FieldSet.getWireFormatForFieldType(extension.descriptor.getLiteType(), true)) {
                    z = true;
                    z2 = false;
                }
                if (!z2) {
                    return parseUnknownField(tag, input);
                }
                ensureExtensionsAreMutable();
                if (z) {
                    int pushLimit = input.pushLimit(input.readRawVarint32());
                    if (extension.descriptor.getLiteType() == WireFormat.FieldType.ENUM) {
                        while (input.getBytesUntilLimit() > 0) {
                            Object findValueByNumber = extension.descriptor.getEnumType().findValueByNumber(input.readEnum());
                            if (findValueByNumber == null) {
                                return true;
                            }
                            this.extensions.addRepeatedField(extension.descriptor, extension.singularToFieldSetType(findValueByNumber));
                        }
                    } else {
                        while (input.getBytesUntilLimit() > 0) {
                            this.extensions.addRepeatedField(extension.descriptor, FieldSet.readPrimitiveField(input, extension.descriptor.getLiteType(), false));
                        }
                    }
                    input.popLimit(pushLimit);
                } else {
                    int i = AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$JavaType[extension.descriptor.getLiteJavaType().ordinal()];
                    if (i == 1) {
                        MessageLite.Builder builder = (extension.descriptor.isRepeated() || (messageLite = (MessageLite) this.extensions.getField(extension.descriptor)) == null) ? null : messageLite.toBuilder();
                        if (builder == null) {
                            builder = extension.getMessageDefaultInstance().newBuilderForType();
                        }
                        if (extension.descriptor.getLiteType() == WireFormat.FieldType.GROUP) {
                            input.readGroup(extension.getNumber(), builder, extensionRegistry);
                        } else {
                            input.readMessage(builder, extensionRegistry);
                        }
                        build = builder.build();
                    } else if (i == 2) {
                        int readEnum = input.readEnum();
                        Object findValueByNumber2 = extension.descriptor.getEnumType().findValueByNumber(readEnum);
                        if (findValueByNumber2 == null) {
                            mergeVarintField(fieldNumber, readEnum);
                            return true;
                        }
                        build = findValueByNumber2;
                    } else {
                        build = FieldSet.readPrimitiveField(input, extension.descriptor.getLiteType(), false);
                    }
                    if (extension.descriptor.isRepeated()) {
                        this.extensions.addRepeatedField(extension.descriptor, extension.singularToFieldSetType(build));
                    } else {
                        this.extensions.setField(extension.descriptor, extension.singularToFieldSetType(build));
                    }
                }
                return true;
            }
            z2 = true;
            z = false;
            if (!z2) {
            }
        }

        protected <MessageType extends MessageLite> boolean parseUnknownFieldAsMessageSet(MessageType defaultInstance, CodedInputStream input, ExtensionRegistryLite extensionRegistry, int tag) throws IOException {
            if (tag == WireFormat.MESSAGE_SET_ITEM_TAG) {
                mergeMessageSetExtensionFromCodedStream(defaultInstance, input, extensionRegistry);
                return true;
            }
            if (WireFormat.getTagWireType(tag) == 2) {
                return parseUnknownField(defaultInstance, input, extensionRegistry, tag);
            }
            return input.skipField(tag);
        }

        private <MessageType extends MessageLite> void mergeMessageSetExtensionFromCodedStream(MessageType defaultInstance, CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            int i = 0;
            ByteString byteString = null;
            GeneratedExtension<?, ?> generatedExtension = null;
            while (true) {
                int readTag = input.readTag();
                if (readTag == 0) {
                    break;
                }
                if (readTag == WireFormat.MESSAGE_SET_TYPE_ID_TAG) {
                    i = input.readUInt32();
                    if (i != 0) {
                        generatedExtension = extensionRegistry.findLiteExtensionByNumber(defaultInstance, i);
                    }
                } else if (readTag == WireFormat.MESSAGE_SET_MESSAGE_TAG) {
                    if (i != 0 && generatedExtension != null) {
                        eagerlyMergeMessageSetExtension(input, generatedExtension, extensionRegistry, i);
                        byteString = null;
                    } else {
                        byteString = input.readBytes();
                    }
                } else if (!input.skipField(readTag)) {
                    break;
                }
            }
            input.checkLastTagWas(WireFormat.MESSAGE_SET_ITEM_END_TAG);
            if (byteString == null || i == 0) {
                return;
            }
            if (generatedExtension != null) {
                mergeMessageSetExtensionFromBytes(byteString, extensionRegistry, generatedExtension);
            } else if (byteString != null) {
                mergeLengthDelimitedField(i, byteString);
            }
        }

        private void eagerlyMergeMessageSetExtension(CodedInputStream input, GeneratedExtension<?, ?> extension, ExtensionRegistryLite extensionRegistry, int typeId) throws IOException {
            parseExtension(input, extensionRegistry, extension, WireFormat.makeTag(typeId, 2), typeId);
        }

        private void mergeMessageSetExtensionFromBytes(ByteString rawBytes, ExtensionRegistryLite extensionRegistry, GeneratedExtension<?, ?> extension) throws IOException {
            MessageLite messageLite = (MessageLite) this.extensions.getField(extension.descriptor);
            MessageLite.Builder builder = messageLite != null ? messageLite.toBuilder() : null;
            if (builder == null) {
                builder = extension.getMessageDefaultInstance().newBuilderForType();
            }
            builder.mergeFrom(rawBytes, extensionRegistry);
            ensureExtensionsAreMutable().setField(extension.descriptor, extension.singularToFieldSetType(builder.build()));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public FieldSet<ExtensionDescriptor> ensureExtensionsAreMutable() {
            if (this.extensions.isImmutable()) {
                this.extensions = this.extensions.m348clone();
            }
            return this.extensions;
        }

        private void verifyExtensionContainingType(final GeneratedExtension<MessageType, ?> extension) {
            if (extension.getContainingTypeDefaultInstance() != getDefaultInstanceForType()) {
                throw new IllegalArgumentException("This extension is for a different message type.  Please make sure that you are not suppressing any generics type warnings.");
            }
        }

        @Override // androidx.datastore.preferences.protobuf.GeneratedMessageLite.ExtendableMessageOrBuilder
        public final <Type> boolean hasExtension(final ExtensionLite<MessageType, Type> extension) {
            GeneratedExtension<MessageType, ?> checkIsLite = GeneratedMessageLite.checkIsLite(extension);
            verifyExtensionContainingType(checkIsLite);
            return this.extensions.hasField(checkIsLite.descriptor);
        }

        @Override // androidx.datastore.preferences.protobuf.GeneratedMessageLite.ExtendableMessageOrBuilder
        public final <Type> int getExtensionCount(final ExtensionLite<MessageType, List<Type>> extension) {
            GeneratedExtension<MessageType, ?> checkIsLite = GeneratedMessageLite.checkIsLite(extension);
            verifyExtensionContainingType(checkIsLite);
            return this.extensions.getRepeatedFieldCount(checkIsLite.descriptor);
        }

        @Override // androidx.datastore.preferences.protobuf.GeneratedMessageLite.ExtendableMessageOrBuilder
        public final <Type> Type getExtension(ExtensionLite<MessageType, Type> extensionLite) {
            GeneratedExtension<MessageType, ?> checkIsLite = GeneratedMessageLite.checkIsLite(extensionLite);
            verifyExtensionContainingType(checkIsLite);
            Object field = this.extensions.getField(checkIsLite.descriptor);
            if (field == null) {
                return checkIsLite.defaultValue;
            }
            return (Type) checkIsLite.fromFieldSetType(field);
        }

        @Override // androidx.datastore.preferences.protobuf.GeneratedMessageLite.ExtendableMessageOrBuilder
        public final <Type> Type getExtension(ExtensionLite<MessageType, List<Type>> extensionLite, int i) {
            GeneratedExtension<MessageType, ?> checkIsLite = GeneratedMessageLite.checkIsLite(extensionLite);
            verifyExtensionContainingType(checkIsLite);
            return (Type) checkIsLite.singularFromFieldSetType(this.extensions.getRepeatedField(checkIsLite.descriptor, i));
        }

        protected boolean extensionsAreInitialized() {
            return this.extensions.isInitialized();
        }

        /* loaded from: classes.dex */
        protected class ExtensionWriter {
            private final Iterator<Map.Entry<ExtensionDescriptor, Object>> iter;
            private final boolean messageSetWireFormat;
            private Map.Entry<ExtensionDescriptor, Object> next;

            /* synthetic */ ExtensionWriter(ExtendableMessage extendableMessage, boolean z, AnonymousClass1 anonymousClass1) {
                this(z);
            }

            private ExtensionWriter(boolean messageSetWireFormat) {
                Iterator<Map.Entry<ExtensionDescriptor, Object>> it = ExtendableMessage.this.extensions.iterator();
                this.iter = it;
                if (it.hasNext()) {
                    this.next = it.next();
                }
                this.messageSetWireFormat = messageSetWireFormat;
            }

            public void writeUntil(final int end, final CodedOutputStream output) throws IOException {
                while (true) {
                    Map.Entry<ExtensionDescriptor, Object> entry = this.next;
                    if (entry == null || entry.getKey().getNumber() >= end) {
                        return;
                    }
                    ExtensionDescriptor key = this.next.getKey();
                    if (this.messageSetWireFormat && key.getLiteJavaType() == WireFormat.JavaType.MESSAGE && !key.isRepeated()) {
                        output.writeMessageSetExtension(key.getNumber(), (MessageLite) this.next.getValue());
                    } else {
                        FieldSet.writeField(key, this.next.getValue(), output);
                    }
                    if (this.iter.hasNext()) {
                        this.next = this.iter.next();
                    } else {
                        this.next = null;
                    }
                }
            }
        }

        protected ExtendableMessage<MessageType, BuilderType>.ExtensionWriter newExtensionWriter() {
            return new ExtensionWriter(this, false, null);
        }

        protected ExtendableMessage<MessageType, BuilderType>.ExtensionWriter newMessageSetExtensionWriter() {
            return new ExtensionWriter(this, true, null);
        }

        protected int extensionsSerializedSize() {
            return this.extensions.getSerializedSize();
        }

        protected int extensionsSerializedSizeAsMessageSet() {
            return this.extensions.getMessageSetSerializedSize();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: androidx.datastore.preferences.protobuf.GeneratedMessageLite$1, reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$WireFormat$JavaType;

        static {
            int[] iArr = new int[WireFormat.JavaType.values().length];
            $SwitchMap$com$google$protobuf$WireFormat$JavaType = iArr;
            try {
                iArr[WireFormat.JavaType.MESSAGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$JavaType[WireFormat.JavaType.ENUM.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* loaded from: classes.dex */
    public static abstract class ExtendableBuilder<MessageType extends ExtendableMessage<MessageType, BuilderType>, BuilderType extends ExtendableBuilder<MessageType, BuilderType>> extends Builder<MessageType, BuilderType> implements ExtendableMessageOrBuilder<MessageType, BuilderType> {
        /* JADX INFO: Access modifiers changed from: protected */
        public ExtendableBuilder(MessageType defaultInstance) {
            super(defaultInstance);
        }

        void internalSetExtensionSet(FieldSet<ExtensionDescriptor> extensions) {
            copyOnWrite();
            ((ExtendableMessage) this.instance).extensions = extensions;
        }

        @Override // androidx.datastore.preferences.protobuf.GeneratedMessageLite.Builder
        protected void copyOnWriteInternal() {
            super.copyOnWriteInternal();
            if (((ExtendableMessage) this.instance).extensions != FieldSet.emptySet()) {
                ((ExtendableMessage) this.instance).extensions = ((ExtendableMessage) this.instance).extensions.m348clone();
            }
        }

        private FieldSet<ExtensionDescriptor> ensureExtensionsAreMutable() {
            FieldSet<ExtensionDescriptor> fieldSet = ((ExtendableMessage) this.instance).extensions;
            if (!fieldSet.isImmutable()) {
                return fieldSet;
            }
            FieldSet<ExtensionDescriptor> m348clone = fieldSet.m348clone();
            ((ExtendableMessage) this.instance).extensions = m348clone;
            return m348clone;
        }

        @Override // androidx.datastore.preferences.protobuf.GeneratedMessageLite.Builder, androidx.datastore.preferences.protobuf.MessageLite.Builder
        public final MessageType buildPartial() {
            if (!((ExtendableMessage) this.instance).isMutable()) {
                return (MessageType) this.instance;
            }
            ((ExtendableMessage) this.instance).extensions.makeImmutable();
            return (MessageType) super.buildPartial();
        }

        private void verifyExtensionContainingType(final GeneratedExtension<MessageType, ?> extension) {
            if (extension.getContainingTypeDefaultInstance() != getDefaultInstanceForType()) {
                throw new IllegalArgumentException("This extension is for a different message type.  Please make sure that you are not suppressing any generics type warnings.");
            }
        }

        @Override // androidx.datastore.preferences.protobuf.GeneratedMessageLite.ExtendableMessageOrBuilder
        public final <Type> boolean hasExtension(final ExtensionLite<MessageType, Type> extension) {
            return ((ExtendableMessage) this.instance).hasExtension(extension);
        }

        @Override // androidx.datastore.preferences.protobuf.GeneratedMessageLite.ExtendableMessageOrBuilder
        public final <Type> int getExtensionCount(final ExtensionLite<MessageType, List<Type>> extension) {
            return ((ExtendableMessage) this.instance).getExtensionCount(extension);
        }

        @Override // androidx.datastore.preferences.protobuf.GeneratedMessageLite.ExtendableMessageOrBuilder
        public final <Type> Type getExtension(ExtensionLite<MessageType, Type> extensionLite) {
            return (Type) ((ExtendableMessage) this.instance).getExtension(extensionLite);
        }

        @Override // androidx.datastore.preferences.protobuf.GeneratedMessageLite.ExtendableMessageOrBuilder
        public final <Type> Type getExtension(ExtensionLite<MessageType, List<Type>> extensionLite, int i) {
            return (Type) ((ExtendableMessage) this.instance).getExtension(extensionLite, i);
        }

        public final <Type> BuilderType setExtension(final ExtensionLite<MessageType, Type> extension, final Type value) {
            GeneratedExtension<MessageType, ?> checkIsLite = GeneratedMessageLite.checkIsLite(extension);
            verifyExtensionContainingType(checkIsLite);
            copyOnWrite();
            ensureExtensionsAreMutable().setField(checkIsLite.descriptor, checkIsLite.toFieldSetType(value));
            return this;
        }

        public final <Type> BuilderType setExtension(final ExtensionLite<MessageType, List<Type>> extension, final int index, final Type value) {
            GeneratedExtension<MessageType, ?> checkIsLite = GeneratedMessageLite.checkIsLite(extension);
            verifyExtensionContainingType(checkIsLite);
            copyOnWrite();
            ensureExtensionsAreMutable().setRepeatedField(checkIsLite.descriptor, index, checkIsLite.singularToFieldSetType(value));
            return this;
        }

        public final <Type> BuilderType addExtension(final ExtensionLite<MessageType, List<Type>> extension, final Type value) {
            GeneratedExtension<MessageType, ?> checkIsLite = GeneratedMessageLite.checkIsLite(extension);
            verifyExtensionContainingType(checkIsLite);
            copyOnWrite();
            ensureExtensionsAreMutable().addRepeatedField(checkIsLite.descriptor, checkIsLite.singularToFieldSetType(value));
            return this;
        }

        public final BuilderType clearExtension(final ExtensionLite<MessageType, ?> extension) {
            GeneratedExtension<MessageType, ?> checkIsLite = GeneratedMessageLite.checkIsLite(extension);
            verifyExtensionContainingType(checkIsLite);
            copyOnWrite();
            ensureExtensionsAreMutable().clearField(checkIsLite.descriptor);
            return this;
        }
    }

    public static <ContainingType extends MessageLite, Type> GeneratedExtension<ContainingType, Type> newSingularGeneratedExtension(final ContainingType containingTypeDefaultInstance, final Type defaultValue, final MessageLite messageDefaultInstance, final Internal.EnumLiteMap<?> enumTypeMap, final int number, final WireFormat.FieldType type, final Class singularType) {
        return new GeneratedExtension<>(containingTypeDefaultInstance, defaultValue, messageDefaultInstance, new ExtensionDescriptor(enumTypeMap, number, type, false, false), singularType);
    }

    public static <ContainingType extends MessageLite, Type> GeneratedExtension<ContainingType, Type> newRepeatedGeneratedExtension(final ContainingType containingTypeDefaultInstance, final MessageLite messageDefaultInstance, final Internal.EnumLiteMap<?> enumTypeMap, final int number, final WireFormat.FieldType type, final boolean isPacked, final Class singularType) {
        return new GeneratedExtension<>(containingTypeDefaultInstance, Collections.emptyList(), messageDefaultInstance, new ExtensionDescriptor(enumTypeMap, number, type, true, isPacked), singularType);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class ExtensionDescriptor implements FieldSet.FieldDescriptorLite<ExtensionDescriptor> {
        final Internal.EnumLiteMap<?> enumTypeMap;
        final boolean isPacked;
        final boolean isRepeated;
        final int number;
        final WireFormat.FieldType type;

        ExtensionDescriptor(final Internal.EnumLiteMap<?> enumTypeMap, final int number, final WireFormat.FieldType type, final boolean isRepeated, final boolean isPacked) {
            this.enumTypeMap = enumTypeMap;
            this.number = number;
            this.type = type;
            this.isRepeated = isRepeated;
            this.isPacked = isPacked;
        }

        @Override // androidx.datastore.preferences.protobuf.FieldSet.FieldDescriptorLite
        public int getNumber() {
            return this.number;
        }

        @Override // androidx.datastore.preferences.protobuf.FieldSet.FieldDescriptorLite
        public WireFormat.FieldType getLiteType() {
            return this.type;
        }

        @Override // androidx.datastore.preferences.protobuf.FieldSet.FieldDescriptorLite
        public WireFormat.JavaType getLiteJavaType() {
            return this.type.getJavaType();
        }

        @Override // androidx.datastore.preferences.protobuf.FieldSet.FieldDescriptorLite
        public boolean isRepeated() {
            return this.isRepeated;
        }

        @Override // androidx.datastore.preferences.protobuf.FieldSet.FieldDescriptorLite
        public boolean isPacked() {
            return this.isPacked;
        }

        @Override // androidx.datastore.preferences.protobuf.FieldSet.FieldDescriptorLite
        public Internal.EnumLiteMap<?> getEnumType() {
            return this.enumTypeMap;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.datastore.preferences.protobuf.FieldSet.FieldDescriptorLite
        public MessageLite.Builder internalMergeFrom(MessageLite.Builder to, MessageLite from) {
            return ((Builder) to).mergeFrom((Builder) from);
        }

        @Override // java.lang.Comparable
        public int compareTo(ExtensionDescriptor other) {
            return this.number - other.number;
        }
    }

    static java.lang.reflect.Method getMethodOrDie(Class clazz, String name, Class... params) {
        try {
            return clazz.getMethod(name, params);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException("Generated message class \"" + clazz.getName() + "\" missing method \"" + name + "\".", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object invokeOrDie(java.lang.reflect.Method method, Object object, Object... params) {
        try {
            return method.invoke(object, params);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e);
        } catch (InvocationTargetException e2) {
            Throwable cause = e2.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            if (cause instanceof Error) {
                throw ((Error) cause);
            }
            throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
        }
    }

    /* loaded from: classes.dex */
    public static class GeneratedExtension<ContainingType extends MessageLite, Type> extends ExtensionLite<ContainingType, Type> {
        final ContainingType containingTypeDefaultInstance;
        final Type defaultValue;
        final ExtensionDescriptor descriptor;
        final MessageLite messageDefaultInstance;

        GeneratedExtension(final ContainingType containingTypeDefaultInstance, final Type defaultValue, final MessageLite messageDefaultInstance, final ExtensionDescriptor descriptor, final Class singularType) {
            if (containingTypeDefaultInstance == null) {
                throw new IllegalArgumentException("Null containingTypeDefaultInstance");
            }
            if (descriptor.getLiteType() == WireFormat.FieldType.MESSAGE && messageDefaultInstance == null) {
                throw new IllegalArgumentException("Null messageDefaultInstance");
            }
            this.containingTypeDefaultInstance = containingTypeDefaultInstance;
            this.defaultValue = defaultValue;
            this.messageDefaultInstance = messageDefaultInstance;
            this.descriptor = descriptor;
        }

        public ContainingType getContainingTypeDefaultInstance() {
            return this.containingTypeDefaultInstance;
        }

        @Override // androidx.datastore.preferences.protobuf.ExtensionLite
        public int getNumber() {
            return this.descriptor.getNumber();
        }

        @Override // androidx.datastore.preferences.protobuf.ExtensionLite
        public MessageLite getMessageDefaultInstance() {
            return this.messageDefaultInstance;
        }

        Object fromFieldSetType(Object value) {
            if (this.descriptor.isRepeated()) {
                if (this.descriptor.getLiteJavaType() != WireFormat.JavaType.ENUM) {
                    return value;
                }
                ArrayList arrayList = new ArrayList();
                Iterator it = ((List) value).iterator();
                while (it.hasNext()) {
                    arrayList.add(singularFromFieldSetType(it.next()));
                }
                return arrayList;
            }
            return singularFromFieldSetType(value);
        }

        Object singularFromFieldSetType(Object value) {
            return this.descriptor.getLiteJavaType() == WireFormat.JavaType.ENUM ? this.descriptor.enumTypeMap.findValueByNumber(((Integer) value).intValue()) : value;
        }

        Object toFieldSetType(Object value) {
            if (this.descriptor.isRepeated()) {
                if (this.descriptor.getLiteJavaType() != WireFormat.JavaType.ENUM) {
                    return value;
                }
                ArrayList arrayList = new ArrayList();
                Iterator it = ((List) value).iterator();
                while (it.hasNext()) {
                    arrayList.add(singularToFieldSetType(it.next()));
                }
                return arrayList;
            }
            return singularToFieldSetType(value);
        }

        Object singularToFieldSetType(Object value) {
            return this.descriptor.getLiteJavaType() == WireFormat.JavaType.ENUM ? Integer.valueOf(((Internal.EnumLite) value).getNumber()) : value;
        }

        @Override // androidx.datastore.preferences.protobuf.ExtensionLite
        public WireFormat.FieldType getLiteType() {
            return this.descriptor.getLiteType();
        }

        @Override // androidx.datastore.preferences.protobuf.ExtensionLite
        public boolean isRepeated() {
            return this.descriptor.isRepeated;
        }

        @Override // androidx.datastore.preferences.protobuf.ExtensionLite
        public Type getDefaultValue() {
            return this.defaultValue;
        }
    }

    /* loaded from: classes.dex */
    protected static final class SerializedForm implements Serializable {
        private static final long serialVersionUID = 0;
        private final byte[] asBytes;
        private final Class<?> messageClass;
        private final String messageClassName;

        public static SerializedForm of(MessageLite message) {
            return new SerializedForm(message);
        }

        SerializedForm(MessageLite regularForm) {
            this.messageClass = regularForm.getClass();
            this.messageClassName = regularForm.getClass().getName();
            this.asBytes = regularForm.toByteArray();
        }

        protected Object readResolve() throws ObjectStreamException {
            try {
                java.lang.reflect.Field declaredField = resolveMessageClass().getDeclaredField("DEFAULT_INSTANCE");
                declaredField.setAccessible(true);
                return ((MessageLite) declaredField.get(null)).newBuilderForType().mergeFrom(this.asBytes).buildPartial();
            } catch (InvalidProtocolBufferException e) {
                throw new RuntimeException("Unable to understand proto buffer", e);
            } catch (ClassNotFoundException e2) {
                throw new RuntimeException("Unable to find proto buffer class: " + this.messageClassName, e2);
            } catch (IllegalAccessException e3) {
                throw new RuntimeException("Unable to call parsePartialFrom", e3);
            } catch (NoSuchFieldException e4) {
                throw new RuntimeException("Unable to find DEFAULT_INSTANCE in " + this.messageClassName, e4);
            } catch (SecurityException e5) {
                throw new RuntimeException("Unable to call DEFAULT_INSTANCE in " + this.messageClassName, e5);
            }
        }

        private Class<?> resolveMessageClass() throws ClassNotFoundException {
            Class<?> cls = this.messageClass;
            return cls != null ? cls : Class.forName(this.messageClassName);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <MessageType extends ExtendableMessage<MessageType, BuilderType>, BuilderType extends ExtendableBuilder<MessageType, BuilderType>, T> GeneratedExtension<MessageType, T> checkIsLite(ExtensionLite<MessageType, T> extension) {
        if (!extension.isLite()) {
            throw new IllegalArgumentException("Expected a lite extension.");
        }
        return (GeneratedExtension) extension;
    }

    protected static final <T extends GeneratedMessageLite<T, ?>> boolean isInitialized(T message, boolean shouldMemoize) {
        byte byteValue = ((Byte) message.dynamicMethod(MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        boolean isInitialized = Protobuf.getInstance().schemaFor((Protobuf) message).isInitialized(message);
        if (shouldMemoize) {
            message.dynamicMethod(MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED, isInitialized ? message : null);
        }
        return isInitialized;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static Internal.IntList emptyIntList() {
        return IntArrayList.emptyList();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Type inference failed for: r1v1, types: [androidx.datastore.preferences.protobuf.Internal$IntList] */
    public static Internal.IntList mutableCopy(Internal.IntList list) {
        int size = list.size();
        return list.mutableCopyWithCapacity2(size == 0 ? 10 : size * 2);
    }

    protected static Internal.LongList emptyLongList() {
        return LongArrayList.emptyList();
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [androidx.datastore.preferences.protobuf.Internal$LongList] */
    protected static Internal.LongList mutableCopy(Internal.LongList list) {
        int size = list.size();
        return list.mutableCopyWithCapacity2(size == 0 ? 10 : size * 2);
    }

    protected static Internal.FloatList emptyFloatList() {
        return FloatArrayList.emptyList();
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [androidx.datastore.preferences.protobuf.Internal$FloatList] */
    protected static Internal.FloatList mutableCopy(Internal.FloatList list) {
        int size = list.size();
        return list.mutableCopyWithCapacity2(size == 0 ? 10 : size * 2);
    }

    protected static Internal.DoubleList emptyDoubleList() {
        return DoubleArrayList.emptyList();
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [androidx.datastore.preferences.protobuf.Internal$DoubleList] */
    protected static Internal.DoubleList mutableCopy(Internal.DoubleList list) {
        int size = list.size();
        return list.mutableCopyWithCapacity2(size == 0 ? 10 : size * 2);
    }

    protected static Internal.BooleanList emptyBooleanList() {
        return BooleanArrayList.emptyList();
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [androidx.datastore.preferences.protobuf.Internal$BooleanList] */
    protected static Internal.BooleanList mutableCopy(Internal.BooleanList list) {
        int size = list.size();
        return list.mutableCopyWithCapacity2(size == 0 ? 10 : size * 2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <E> Internal.ProtobufList<E> emptyProtobufList() {
        return ProtobufArrayList.emptyList();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <E> Internal.ProtobufList<E> mutableCopy(Internal.ProtobufList<E> list) {
        int size = list.size();
        return list.mutableCopyWithCapacity2(size == 0 ? 10 : size * 2);
    }

    /* loaded from: classes.dex */
    protected static class DefaultInstanceBasedParser<T extends GeneratedMessageLite<T, ?>> extends AbstractParser<T> {
        private final T defaultInstance;

        public DefaultInstanceBasedParser(T defaultInstance) {
            this.defaultInstance = defaultInstance;
        }

        @Override // androidx.datastore.preferences.protobuf.Parser
        public T parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (T) GeneratedMessageLite.parsePartialFrom(this.defaultInstance, codedInputStream, extensionRegistryLite);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractParser, androidx.datastore.preferences.protobuf.Parser
        public T parsePartialFrom(byte[] bArr, int i, int i2, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (T) GeneratedMessageLite.parsePartialFrom(this.defaultInstance, bArr, i, i2, extensionRegistryLite);
        }
    }

    static <T extends GeneratedMessageLite<T, ?>> T parsePartialFrom(T t, CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        T t2 = (T) t.newMutableInstance();
        try {
            Schema schemaFor = Protobuf.getInstance().schemaFor((Protobuf) t2);
            schemaFor.mergeFrom(t2, CodedInputStreamReader.forCodedInput(codedInputStream), extensionRegistryLite);
            schemaFor.makeImmutable(t2);
            return t2;
        } catch (InvalidProtocolBufferException e) {
            e = e;
            if (e.getThrownFromInputStream()) {
                e = new InvalidProtocolBufferException((IOException) e);
            }
            throw e.setUnfinishedMessage(t2);
        } catch (UninitializedMessageException e2) {
            throw e2.asInvalidProtocolBufferException().setUnfinishedMessage(t2);
        } catch (IOException e3) {
            if (e3.getCause() instanceof InvalidProtocolBufferException) {
                throw ((InvalidProtocolBufferException) e3.getCause());
            }
            throw new InvalidProtocolBufferException(e3).setUnfinishedMessage(t2);
        } catch (RuntimeException e4) {
            if (e4.getCause() instanceof InvalidProtocolBufferException) {
                throw ((InvalidProtocolBufferException) e4.getCause());
            }
            throw e4;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <T extends GeneratedMessageLite<T, ?>> T parsePartialFrom(T t, byte[] bArr, int i, int i2, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        if (i2 == 0) {
            return t;
        }
        T t2 = (T) t.newMutableInstance();
        try {
            Schema schemaFor = Protobuf.getInstance().schemaFor((Protobuf) t2);
            schemaFor.mergeFrom(t2, bArr, i, i + i2, new ArrayDecoders.Registers(extensionRegistryLite));
            schemaFor.makeImmutable(t2);
            return t2;
        } catch (InvalidProtocolBufferException e) {
            e = e;
            if (e.getThrownFromInputStream()) {
                e = new InvalidProtocolBufferException((IOException) e);
            }
            throw e.setUnfinishedMessage(t2);
        } catch (UninitializedMessageException e2) {
            throw e2.asInvalidProtocolBufferException().setUnfinishedMessage(t2);
        } catch (IOException e3) {
            if (e3.getCause() instanceof InvalidProtocolBufferException) {
                throw ((InvalidProtocolBufferException) e3.getCause());
            }
            throw new InvalidProtocolBufferException(e3).setUnfinishedMessage(t2);
        } catch (IndexOutOfBoundsException unused) {
            throw InvalidProtocolBufferException.truncatedMessage().setUnfinishedMessage(t2);
        }
    }

    protected static <T extends GeneratedMessageLite<T, ?>> T parsePartialFrom(T t, CodedInputStream codedInputStream) throws InvalidProtocolBufferException {
        return (T) parsePartialFrom(t, codedInputStream, ExtensionRegistryLite.getEmptyRegistry());
    }

    private static <T extends GeneratedMessageLite<T, ?>> T checkMessageInitialized(T message) throws InvalidProtocolBufferException {
        if (message == null || message.isInitialized()) {
            return message;
        }
        throw message.newUninitializedMessageException().asInvalidProtocolBufferException().setUnfinishedMessage(message);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <T extends GeneratedMessageLite<T, ?>> T parseFrom(T t, ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (T) checkMessageInitialized(parseFrom(t, CodedInputStream.newInstance(byteBuffer), extensionRegistryLite));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <T extends GeneratedMessageLite<T, ?>> T parseFrom(T t, ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (T) parseFrom(t, byteBuffer, ExtensionRegistryLite.getEmptyRegistry());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <T extends GeneratedMessageLite<T, ?>> T parseFrom(T t, ByteString byteString) throws InvalidProtocolBufferException {
        return (T) checkMessageInitialized(parseFrom(t, byteString, ExtensionRegistryLite.getEmptyRegistry()));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <T extends GeneratedMessageLite<T, ?>> T parseFrom(T t, ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (T) checkMessageInitialized(parsePartialFrom(t, byteString, extensionRegistryLite));
    }

    private static <T extends GeneratedMessageLite<T, ?>> T parsePartialFrom(T t, ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        CodedInputStream newCodedInput = byteString.newCodedInput();
        T t2 = (T) parsePartialFrom(t, newCodedInput, extensionRegistryLite);
        try {
            newCodedInput.checkLastTagWas(0);
            return t2;
        } catch (InvalidProtocolBufferException e) {
            throw e.setUnfinishedMessage(t2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <T extends GeneratedMessageLite<T, ?>> T parseFrom(T t, byte[] bArr) throws InvalidProtocolBufferException {
        return (T) checkMessageInitialized(parsePartialFrom(t, bArr, 0, bArr.length, ExtensionRegistryLite.getEmptyRegistry()));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <T extends GeneratedMessageLite<T, ?>> T parseFrom(T t, byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (T) checkMessageInitialized(parsePartialFrom(t, bArr, 0, bArr.length, extensionRegistryLite));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <T extends GeneratedMessageLite<T, ?>> T parseFrom(T t, InputStream inputStream) throws InvalidProtocolBufferException {
        return (T) checkMessageInitialized(parsePartialFrom(t, CodedInputStream.newInstance(inputStream), ExtensionRegistryLite.getEmptyRegistry()));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <T extends GeneratedMessageLite<T, ?>> T parseFrom(T t, InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (T) checkMessageInitialized(parsePartialFrom(t, CodedInputStream.newInstance(inputStream), extensionRegistryLite));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <T extends GeneratedMessageLite<T, ?>> T parseFrom(T t, CodedInputStream codedInputStream) throws InvalidProtocolBufferException {
        return (T) parseFrom(t, codedInputStream, ExtensionRegistryLite.getEmptyRegistry());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <T extends GeneratedMessageLite<T, ?>> T parseFrom(T t, CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (T) checkMessageInitialized(parsePartialFrom(t, codedInputStream, extensionRegistryLite));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <T extends GeneratedMessageLite<T, ?>> T parseDelimitedFrom(T t, InputStream inputStream) throws InvalidProtocolBufferException {
        return (T) checkMessageInitialized(parsePartialDelimitedFrom(t, inputStream, ExtensionRegistryLite.getEmptyRegistry()));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <T extends GeneratedMessageLite<T, ?>> T parseDelimitedFrom(T t, InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (T) checkMessageInitialized(parsePartialDelimitedFrom(t, inputStream, extensionRegistryLite));
    }

    private static <T extends GeneratedMessageLite<T, ?>> T parsePartialDelimitedFrom(T t, InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        try {
            int read = inputStream.read();
            if (read == -1) {
                return null;
            }
            CodedInputStream newInstance = CodedInputStream.newInstance(new AbstractMessageLite.Builder.LimitedInputStream(inputStream, CodedInputStream.readRawVarint32(read, inputStream)));
            T t2 = (T) parsePartialFrom(t, newInstance, extensionRegistryLite);
            try {
                newInstance.checkLastTagWas(0);
                return t2;
            } catch (InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(t2);
            }
        } catch (InvalidProtocolBufferException e2) {
            if (e2.getThrownFromInputStream()) {
                throw new InvalidProtocolBufferException((IOException) e2);
            }
            throw e2;
        } catch (IOException e3) {
            throw new InvalidProtocolBufferException(e3);
        }
    }
}
