package vn.ai.faceauth.sdk.presentation.presentation.opencv;

import androidx.camera.video.AudioStats;
import paua.btj;

/* loaded from: classes4.dex */
public class Point {
    public double x;
    public double y;

    public Point() {
        this(AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE);
    }

    public Point(double d, double d2) {
        this.x = d;
        this.y = d2;
    }

    public Point(double[] dArr) {
        this();
        set(dArr);
    }

    public Point clone() {
        return new Point(this.x, this.y);
    }

    public double dot(Point point) {
        return (this.y * point.y) + (this.x * point.x);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Point)) {
            return false;
        }
        Point point = (Point) obj;
        return this.x == point.x && this.y == point.y;
    }

    public int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.x);
        int i = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
        long doubleToLongBits2 = Double.doubleToLongBits(this.y);
        return ((i + 31) * 31) + ((int) ((doubleToLongBits2 >>> 32) ^ doubleToLongBits2));
    }

    public void set(double[] dArr) {
        double d = AudioStats.AUDIO_AMPLITUDE_NONE;
        if (dArr != null) {
            this.x = dArr.length > 0 ? dArr[0] : 0.0d;
            if (dArr.length > 1) {
                d = dArr[1];
            }
        } else {
            this.x = AudioStats.AUDIO_AMPLITUDE_NONE;
        }
        this.y = d;
    }

    public String toString() {
        return btj.tzend(6) + this.x + btj.tzend(7) + this.y + btj.tzend(8);
    }
}
