package com.google.android.material.color;

import androidx.camera.video.AudioStats;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class ViewingConditions {
    public static final ViewingConditions DEFAULT = make(ColorUtils.whitePointD65(), (float) ((ColorUtils.yFromLstar(50.0f) * 63.66197723675813d) / 100.0d), 50.0f, 2.0f, false);
    private final float aw;
    private final float c;
    private final float fl;
    private final float flRoot;
    private final float n;
    private final float nbb;
    private final float nc;
    private final float ncb;
    private final float[] rgbD;
    private final float z;

    public float getAw() {
        return this.aw;
    }

    public float getN() {
        return this.n;
    }

    public float getNbb() {
        return this.nbb;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float getNcb() {
        return this.ncb;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float getC() {
        return this.c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float getNc() {
        return this.nc;
    }

    public float[] getRgbD() {
        return this.rgbD;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float getFl() {
        return this.fl;
    }

    public float getFlRoot() {
        return this.flRoot;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float getZ() {
        return this.z;
    }

    static ViewingConditions make(float[] fArr, float f, float f2, float f3, boolean z) {
        float lerp;
        float[][] fArr2 = Cam16.XYZ_TO_CAM16RGB;
        float f4 = fArr[0];
        float[] fArr3 = fArr2[0];
        float f5 = fArr3[0] * f4;
        float f6 = fArr[1];
        float f7 = f5 + (fArr3[1] * f6);
        float f8 = fArr[2];
        float f9 = f7 + (fArr3[2] * f8);
        float[] fArr4 = fArr2[1];
        float f10 = (fArr4[0] * f4) + (fArr4[1] * f6) + (fArr4[2] * f8);
        float[] fArr5 = fArr2[2];
        float f11 = (f4 * fArr5[0]) + (f6 * fArr5[1]) + (f8 * fArr5[2]);
        float f12 = (f3 / 10.0f) + 0.8f;
        if (f12 >= 0.9d) {
            lerp = MathUtils.lerp(0.59f, 0.69f, (f12 - 0.9f) * 10.0f);
        } else {
            lerp = MathUtils.lerp(0.525f, 0.59f, (f12 - 0.8f) * 10.0f);
        }
        float f13 = lerp;
        float exp = z ? 1.0f : (1.0f - (((float) Math.exp(((-f) - 42.0f) / 92.0f)) * 0.2777778f)) * f12;
        double d = exp;
        if (d > 1.0d) {
            exp = 1.0f;
        } else if (d < AudioStats.AUDIO_AMPLITUDE_NONE) {
            exp = 0.0f;
        }
        float[] fArr6 = {(((100.0f / f9) * exp) + 1.0f) - exp, (((100.0f / f10) * exp) + 1.0f) - exp, (((100.0f / f11) * exp) + 1.0f) - exp};
        float f14 = 1.0f / ((5.0f * f) + 1.0f);
        float f15 = f14 * f14 * f14 * f14;
        float f16 = 1.0f - f15;
        float cbrt = (f15 * f) + (0.1f * f16 * f16 * ((float) Math.cbrt(f * 5.0d)));
        float yFromLstar = ColorUtils.yFromLstar(f2) / fArr[1];
        double d2 = yFromLstar;
        float sqrt = ((float) Math.sqrt(d2)) + 1.48f;
        float pow = 0.725f / ((float) Math.pow(d2, 0.2d));
        float[] fArr7 = {(float) Math.pow(((fArr6[0] * cbrt) * f9) / 100.0d, 0.42d), (float) Math.pow(((fArr6[1] * cbrt) * f10) / 100.0d, 0.42d), (float) Math.pow(((fArr6[2] * cbrt) * f11) / 100.0d, 0.42d)};
        float f17 = fArr7[0];
        float f18 = (f17 * 400.0f) / (f17 + 27.13f);
        float f19 = fArr7[1];
        float f20 = (f19 * 400.0f) / (f19 + 27.13f);
        float f21 = fArr7[2];
        float[] fArr8 = {f18, f20, (400.0f * f21) / (f21 + 27.13f)};
        return new ViewingConditions(yFromLstar, ((fArr8[0] * 2.0f) + fArr8[1] + (fArr8[2] * 0.05f)) * pow, pow, pow, f13, f12, fArr6, cbrt, (float) Math.pow(cbrt, 0.25d), sqrt);
    }

    private ViewingConditions(float f, float f2, float f3, float f4, float f5, float f6, float[] fArr, float f7, float f8, float f9) {
        this.n = f;
        this.aw = f2;
        this.nbb = f3;
        this.ncb = f4;
        this.c = f5;
        this.nc = f6;
        this.rgbD = fArr;
        this.fl = f7;
        this.flRoot = f8;
        this.z = f9;
    }
}
