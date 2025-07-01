package io.flutter.plugins.sharedpreferences;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: MessagesAsync.g.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000b"}, d2 = {"Lio/flutter/plugins/sharedpreferences/StringListLookupResultType;", "", "raw", "", "(Ljava/lang/String;II)V", "getRaw", "()I", "PLATFORM_ENCODED", "JSON_ENCODED", "UNEXPECTED_STRING", "Companion", "shared_preferences_android_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes4.dex */
public final class StringListLookupResultType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ StringListLookupResultType[] $VALUES;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private final int raw;
    public static final StringListLookupResultType PLATFORM_ENCODED = new StringListLookupResultType("PLATFORM_ENCODED", 0, 0);
    public static final StringListLookupResultType JSON_ENCODED = new StringListLookupResultType("JSON_ENCODED", 1, 1);
    public static final StringListLookupResultType UNEXPECTED_STRING = new StringListLookupResultType("UNEXPECTED_STRING", 2, 2);

    private static final /* synthetic */ StringListLookupResultType[] $values() {
        return new StringListLookupResultType[]{PLATFORM_ENCODED, JSON_ENCODED, UNEXPECTED_STRING};
    }

    public static EnumEntries<StringListLookupResultType> getEntries() {
        return $ENTRIES;
    }

    public static StringListLookupResultType valueOf(String str) {
        return (StringListLookupResultType) Enum.valueOf(StringListLookupResultType.class, str);
    }

    public static StringListLookupResultType[] values() {
        return (StringListLookupResultType[]) $VALUES.clone();
    }

    private StringListLookupResultType(String str, int i, int i2) {
        this.raw = i2;
    }

    public final int getRaw() {
        return this.raw;
    }

    static {
        StringListLookupResultType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
        INSTANCE = new Companion(null);
    }

    /* compiled from: MessagesAsync.g.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lio/flutter/plugins/sharedpreferences/StringListLookupResultType$Companion;", "", "()V", "ofRaw", "Lio/flutter/plugins/sharedpreferences/StringListLookupResultType;", "raw", "", "shared_preferences_android_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final StringListLookupResultType ofRaw(int raw) {
            for (StringListLookupResultType stringListLookupResultType : StringListLookupResultType.values()) {
                if (stringListLookupResultType.getRaw() == raw) {
                    return stringListLookupResultType;
                }
            }
            return null;
        }
    }
}
