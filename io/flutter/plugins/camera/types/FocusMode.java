package io.flutter.plugins.camera.types;

/* loaded from: classes4.dex */
public enum FocusMode {
    auto("auto"),
    locked("locked");

    private final String strValue;

    FocusMode(String str) {
        this.strValue = str;
    }

    public static FocusMode getValueForString(String str) {
        for (FocusMode focusMode : values()) {
            if (focusMode.strValue.equals(str)) {
                return focusMode;
            }
        }
        return null;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.strValue;
    }
}
