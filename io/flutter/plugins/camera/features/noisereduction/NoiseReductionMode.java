package io.flutter.plugins.camera.features.noisereduction;

import kotlinx.coroutines.DebugKt;

/* loaded from: classes4.dex */
public enum NoiseReductionMode {
    off(DebugKt.DEBUG_PROPERTY_VALUE_OFF),
    fast("fast"),
    highQuality("highQuality"),
    minimal("minimal"),
    zeroShutterLag("zeroShutterLag");

    private final String strValue;

    NoiseReductionMode(String str) {
        this.strValue = str;
    }

    public static NoiseReductionMode getValueForString(String str) {
        for (NoiseReductionMode noiseReductionMode : values()) {
            if (noiseReductionMode.strValue.equals(str)) {
                return noiseReductionMode;
            }
        }
        return null;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.strValue;
    }
}
