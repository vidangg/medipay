package androidx.camera.core;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes.dex */
public class MirrorMode {
    public static final int MIRROR_MODE_OFF = 0;
    public static final int MIRROR_MODE_ON = 1;
    public static final int MIRROR_MODE_ON_FRONT_ONLY = 2;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface Mirror {
    }

    private MirrorMode() {
    }
}
