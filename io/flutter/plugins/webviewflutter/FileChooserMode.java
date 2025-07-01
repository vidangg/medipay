package io.flutter.plugins.webviewflutter;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: AndroidWebkitLibrary.g.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lio/flutter/plugins/webviewflutter/FileChooserMode;", "", "raw", "", "(Ljava/lang/String;II)V", "getRaw", "()I", "OPEN", "OPEN_MULTIPLE", "SAVE", "UNKNOWN", "Companion", "webview_flutter_android_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes4.dex */
public final class FileChooserMode {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ FileChooserMode[] $VALUES;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    public static final FileChooserMode OPEN = new FileChooserMode("OPEN", 0, 0);
    public static final FileChooserMode OPEN_MULTIPLE = new FileChooserMode("OPEN_MULTIPLE", 1, 1);
    public static final FileChooserMode SAVE = new FileChooserMode("SAVE", 2, 2);
    public static final FileChooserMode UNKNOWN = new FileChooserMode("UNKNOWN", 3, 3);
    private final int raw;

    private static final /* synthetic */ FileChooserMode[] $values() {
        return new FileChooserMode[]{OPEN, OPEN_MULTIPLE, SAVE, UNKNOWN};
    }

    public static EnumEntries<FileChooserMode> getEntries() {
        return $ENTRIES;
    }

    public static FileChooserMode valueOf(String str) {
        return (FileChooserMode) Enum.valueOf(FileChooserMode.class, str);
    }

    public static FileChooserMode[] values() {
        return (FileChooserMode[]) $VALUES.clone();
    }

    private FileChooserMode(String str, int i, int i2) {
        this.raw = i2;
    }

    public final int getRaw() {
        return this.raw;
    }

    static {
        FileChooserMode[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
        INSTANCE = new Companion(null);
    }

    /* compiled from: AndroidWebkitLibrary.g.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lio/flutter/plugins/webviewflutter/FileChooserMode$Companion;", "", "()V", "ofRaw", "Lio/flutter/plugins/webviewflutter/FileChooserMode;", "raw", "", "webview_flutter_android_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final FileChooserMode ofRaw(int raw) {
            for (FileChooserMode fileChooserMode : FileChooserMode.values()) {
                if (fileChooserMode.getRaw() == raw) {
                    return fileChooserMode;
                }
            }
            return null;
        }
    }
}
