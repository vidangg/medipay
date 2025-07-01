package io.flutter.plugins.webviewflutter;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: AndroidWebkitLibrary.g.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u0000 \u000e2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000eB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000f"}, d2 = {"Lio/flutter/plugins/webviewflutter/SslErrorType;", "", "raw", "", "(Ljava/lang/String;II)V", "getRaw", "()I", "DATE_INVALID", "EXPIRED", "ID_MISMATCH", "INVALID", "NOT_YET_VALID", "UNTRUSTED", "UNKNOWN", "Companion", "webview_flutter_android_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes4.dex */
public final class SslErrorType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ SslErrorType[] $VALUES;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private final int raw;
    public static final SslErrorType DATE_INVALID = new SslErrorType("DATE_INVALID", 0, 0);
    public static final SslErrorType EXPIRED = new SslErrorType("EXPIRED", 1, 1);
    public static final SslErrorType ID_MISMATCH = new SslErrorType("ID_MISMATCH", 2, 2);
    public static final SslErrorType INVALID = new SslErrorType("INVALID", 3, 3);
    public static final SslErrorType NOT_YET_VALID = new SslErrorType("NOT_YET_VALID", 4, 4);
    public static final SslErrorType UNTRUSTED = new SslErrorType("UNTRUSTED", 5, 5);
    public static final SslErrorType UNKNOWN = new SslErrorType("UNKNOWN", 6, 6);

    private static final /* synthetic */ SslErrorType[] $values() {
        return new SslErrorType[]{DATE_INVALID, EXPIRED, ID_MISMATCH, INVALID, NOT_YET_VALID, UNTRUSTED, UNKNOWN};
    }

    public static EnumEntries<SslErrorType> getEntries() {
        return $ENTRIES;
    }

    public static SslErrorType valueOf(String str) {
        return (SslErrorType) Enum.valueOf(SslErrorType.class, str);
    }

    public static SslErrorType[] values() {
        return (SslErrorType[]) $VALUES.clone();
    }

    private SslErrorType(String str, int i, int i2) {
        this.raw = i2;
    }

    public final int getRaw() {
        return this.raw;
    }

    static {
        SslErrorType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
        INSTANCE = new Companion(null);
    }

    /* compiled from: AndroidWebkitLibrary.g.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lio/flutter/plugins/webviewflutter/SslErrorType$Companion;", "", "()V", "ofRaw", "Lio/flutter/plugins/webviewflutter/SslErrorType;", "raw", "", "webview_flutter_android_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final SslErrorType ofRaw(int raw) {
            for (SslErrorType sslErrorType : SslErrorType.values()) {
                if (sslErrorType.getRaw() == raw) {
                    return sslErrorType;
                }
            }
            return null;
        }
    }
}
