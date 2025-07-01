package androidx.camera.camera2.internal.compat;

import android.hardware.camera2.params.StreamConfigurationMap;
import android.util.Size;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class StreamConfigurationMapCompatApi23Impl extends StreamConfigurationMapCompatBaseImpl {
    /* JADX INFO: Access modifiers changed from: package-private */
    public StreamConfigurationMapCompatApi23Impl(StreamConfigurationMap streamConfigurationMap) {
        super(streamConfigurationMap);
    }

    @Override // androidx.camera.camera2.internal.compat.StreamConfigurationMapCompatBaseImpl, androidx.camera.camera2.internal.compat.StreamConfigurationMapCompat.StreamConfigurationMapCompatImpl
    public Size[] getOutputSizes(int i) {
        return this.mStreamConfigurationMap.getOutputSizes(i);
    }
}
