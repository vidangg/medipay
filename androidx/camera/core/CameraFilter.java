package androidx.camera.core;

import androidx.camera.core.impl.Identifier;
import java.util.List;

/* loaded from: classes.dex */
public interface CameraFilter {
    public static final Identifier DEFAULT_ID = Identifier.create(new Object());

    List<CameraInfo> filter(List<CameraInfo> list);

    default Identifier getIdentifier() {
        return DEFAULT_ID;
    }
}
