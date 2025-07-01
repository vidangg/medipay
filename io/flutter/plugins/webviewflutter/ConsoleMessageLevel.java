package io.flutter.plugins.webviewflutter;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: AndroidWebkitLibrary.g.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\rB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lio/flutter/plugins/webviewflutter/ConsoleMessageLevel;", "", "raw", "", "(Ljava/lang/String;II)V", "getRaw", "()I", "DEBUG", "ERROR", "LOG", "TIP", "WARNING", "UNKNOWN", "Companion", "webview_flutter_android_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes4.dex */
public final class ConsoleMessageLevel {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ConsoleMessageLevel[] $VALUES;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private final int raw;
    public static final ConsoleMessageLevel DEBUG = new ConsoleMessageLevel("DEBUG", 0, 0);
    public static final ConsoleMessageLevel ERROR = new ConsoleMessageLevel("ERROR", 1, 1);
    public static final ConsoleMessageLevel LOG = new ConsoleMessageLevel("LOG", 2, 2);
    public static final ConsoleMessageLevel TIP = new ConsoleMessageLevel("TIP", 3, 3);
    public static final ConsoleMessageLevel WARNING = new ConsoleMessageLevel("WARNING", 4, 4);
    public static final ConsoleMessageLevel UNKNOWN = new ConsoleMessageLevel("UNKNOWN", 5, 5);

    private static final /* synthetic */ ConsoleMessageLevel[] $values() {
        return new ConsoleMessageLevel[]{DEBUG, ERROR, LOG, TIP, WARNING, UNKNOWN};
    }

    public static EnumEntries<ConsoleMessageLevel> getEntries() {
        return $ENTRIES;
    }

    public static ConsoleMessageLevel valueOf(String str) {
        return (ConsoleMessageLevel) Enum.valueOf(ConsoleMessageLevel.class, str);
    }

    public static ConsoleMessageLevel[] values() {
        return (ConsoleMessageLevel[]) $VALUES.clone();
    }

    private ConsoleMessageLevel(String str, int i, int i2) {
        this.raw = i2;
    }

    public final int getRaw() {
        return this.raw;
    }

    static {
        ConsoleMessageLevel[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
        INSTANCE = new Companion(null);
    }

    /* compiled from: AndroidWebkitLibrary.g.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lio/flutter/plugins/webviewflutter/ConsoleMessageLevel$Companion;", "", "()V", "ofRaw", "Lio/flutter/plugins/webviewflutter/ConsoleMessageLevel;", "raw", "", "webview_flutter_android_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ConsoleMessageLevel ofRaw(int raw) {
            for (ConsoleMessageLevel consoleMessageLevel : ConsoleMessageLevel.values()) {
                if (consoleMessageLevel.getRaw() == raw) {
                    return consoleMessageLevel;
                }
            }
            return null;
        }
    }
}
