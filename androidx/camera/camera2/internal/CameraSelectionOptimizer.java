package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraCharacteristics;
import androidx.camera.camera2.internal.compat.CameraAccessExceptionCompat;
import androidx.camera.camera2.internal.compat.CameraManagerCompat;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.CameraUnavailableException;
import androidx.camera.core.InitializationException;
import androidx.camera.core.impl.CameraInfoInternal;
import androidx.media3.exoplayer.rtsp.SessionDescription;
import androidx.media3.extractor.metadata.icy.IcyHeaders;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
class CameraSelectionOptimizer {
    private CameraSelectionOptimizer() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List<String> getSelectedAvailableCameraIds(Camera2CameraFactory camera2CameraFactory, CameraSelector cameraSelector) throws InitializationException {
        String str;
        try {
            ArrayList arrayList = new ArrayList();
            List<String> asList = Arrays.asList(camera2CameraFactory.getCameraManager().getCameraIdList());
            if (cameraSelector == null) {
                Iterator it = asList.iterator();
                while (it.hasNext()) {
                    arrayList.add((String) it.next());
                }
                return arrayList;
            }
            try {
                str = decideSkippedCameraIdByHeuristic(camera2CameraFactory.getCameraManager(), cameraSelector.getLensFacing(), asList);
            } catch (IllegalStateException unused) {
                str = null;
            }
            ArrayList arrayList2 = new ArrayList();
            for (String str2 : asList) {
                if (!str2.equals(str)) {
                    arrayList2.add(camera2CameraFactory.getCameraInfo(str2));
                }
            }
            Iterator<CameraInfo> it2 = cameraSelector.filter(arrayList2).iterator();
            while (it2.hasNext()) {
                arrayList.add(((CameraInfoInternal) it2.next()).getCameraId());
            }
            return arrayList;
        } catch (CameraAccessExceptionCompat e) {
            throw new InitializationException(CameraUnavailableExceptionHelper.createFrom(e));
        } catch (CameraUnavailableException e2) {
            throw new InitializationException(e2);
        }
    }

    private static String decideSkippedCameraIdByHeuristic(CameraManagerCompat cameraManagerCompat, Integer num, List<String> list) throws CameraAccessExceptionCompat {
        if (num == null || !list.contains(SessionDescription.SUPPORTED_SDP_VERSION) || !list.contains(IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE)) {
            return null;
        }
        if (num.intValue() == 1) {
            if (((Integer) cameraManagerCompat.getCameraCharacteristicsCompat(SessionDescription.SUPPORTED_SDP_VERSION).get(CameraCharacteristics.LENS_FACING)).intValue() == 1) {
                return IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE;
            }
            return null;
        }
        if (num.intValue() == 0 && ((Integer) cameraManagerCompat.getCameraCharacteristicsCompat(IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE).get(CameraCharacteristics.LENS_FACING)).intValue() == 0) {
            return SessionDescription.SUPPORTED_SDP_VERSION;
        }
        return null;
    }
}
