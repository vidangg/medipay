package io.flutter.plugins.camera.types;

/* loaded from: classes4.dex */
public enum ExposureMode {
    auto("auto"),
    locked("locked");

    private final String strValue;

    ExposureMode(String str) {
        this.strValue = str;
    }

    public static ExposureMode getValueForString(String str) {
        for (ExposureMode exposureMode : values()) {
            if (exposureMode.strValue.equals(str)) {
                return exposureMode;
            }
        }
        return null;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.strValue;
    }
}
