package com.google_mlkit_face_detection;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.mlkit.common.sdkinternal.OptionalModuleUtils;
import com.google.mlkit.vision.common.InputImage;
import com.google.mlkit.vision.face.Face;
import com.google.mlkit.vision.face.FaceContour;
import com.google.mlkit.vision.face.FaceDetection;
import com.google.mlkit.vision.face.FaceDetectorOptions;
import com.google_mlkit_commons.InputImageConverter;
import com.tekartik.sqflite.Constant;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class FaceDetector implements MethodChannel.MethodCallHandler {
    private static final String CLOSE = "vision#closeFaceDetector";
    private static final String START = "vision#startFaceDetector";
    private final Context context;
    private final Map<String, com.google.mlkit.vision.face.FaceDetector> instances = new HashMap();

    public FaceDetector(Context context) {
        this.context = context;
    }

    @Override // io.flutter.plugin.common.MethodChannel.MethodCallHandler
    public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        String str = methodCall.method;
        str.hashCode();
        if (str.equals(START)) {
            handleDetection(methodCall, result);
        } else if (str.equals(CLOSE)) {
            closeDetector(methodCall);
            result.success(null);
        } else {
            result.notImplemented();
        }
    }

    private void handleDetection(MethodCall methodCall, final MethodChannel.Result result) {
        InputImage inputImageFromData = InputImageConverter.getInputImageFromData((Map) methodCall.argument("imageData"), this.context, result);
        if (inputImageFromData == null) {
            return;
        }
        String str = (String) methodCall.argument(TtmlNode.ATTR_ID);
        com.google.mlkit.vision.face.FaceDetector faceDetector = this.instances.get(str);
        if (faceDetector == null) {
            Map<String, Object> map = (Map) methodCall.argument(Constant.METHOD_OPTIONS);
            if (map == null) {
                result.error("FaceDetectorError", "Invalid options", null);
                return;
            } else {
                faceDetector = FaceDetection.getClient(parseOptions(map));
                this.instances.put(str, faceDetector);
            }
        }
        faceDetector.process(inputImageFromData).addOnSuccessListener(new OnSuccessListener() { // from class: com.google_mlkit_face_detection.FaceDetector$$ExternalSyntheticLambda0
            @Override // com.google.android.gms.tasks.OnSuccessListener
            public final void onSuccess(Object obj) {
                FaceDetector.this.m712xc716e563(result, (List) obj);
            }
        }).addOnFailureListener(new OnFailureListener() { // from class: com.google_mlkit_face_detection.FaceDetector$$ExternalSyntheticLambda1
            @Override // com.google.android.gms.tasks.OnFailureListener
            public final void onFailure(Exception exc) {
                MethodChannel.Result.this.error("FaceDetectorError", exc.toString(), null);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$handleDetection$0$com-google_mlkit_face_detection-FaceDetector, reason: not valid java name */
    public /* synthetic */ void m712xc716e563(MethodChannel.Result result, List list) {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Face face = (Face) it.next();
            HashMap hashMap = new HashMap();
            HashMap hashMap2 = new HashMap();
            Rect boundingBox = face.getBoundingBox();
            hashMap2.put(TtmlNode.LEFT, Integer.valueOf(boundingBox.left));
            hashMap2.put("top", Integer.valueOf(boundingBox.top));
            hashMap2.put(TtmlNode.RIGHT, Integer.valueOf(boundingBox.right));
            hashMap2.put("bottom", Integer.valueOf(boundingBox.bottom));
            hashMap.put("rect", hashMap2);
            hashMap.put("headEulerAngleX", Float.valueOf(face.getHeadEulerAngleX()));
            hashMap.put("headEulerAngleY", Float.valueOf(face.getHeadEulerAngleY()));
            hashMap.put("headEulerAngleZ", Float.valueOf(face.getHeadEulerAngleZ()));
            if (face.getSmilingProbability() != null) {
                hashMap.put("smilingProbability", face.getSmilingProbability());
            }
            if (face.getLeftEyeOpenProbability() != null) {
                hashMap.put("leftEyeOpenProbability", face.getLeftEyeOpenProbability());
            }
            if (face.getRightEyeOpenProbability() != null) {
                hashMap.put("rightEyeOpenProbability", face.getRightEyeOpenProbability());
            }
            if (face.getTrackingId() != null) {
                hashMap.put("trackingId", face.getTrackingId());
            }
            hashMap.put("landmarks", getLandmarkData(face));
            hashMap.put("contours", getContourData(face));
            arrayList.add(hashMap);
        }
        result.success(arrayList);
    }

    private FaceDetectorOptions parseOptions(Map<String, Object> map) {
        int i = 2;
        int i2 = ((Boolean) map.get("enableClassification")).booleanValue() ? 2 : 1;
        int i3 = ((Boolean) map.get("enableLandmarks")).booleanValue() ? 2 : 1;
        int i4 = ((Boolean) map.get("enableContours")).booleanValue() ? 2 : 1;
        String str = (String) map.get("mode");
        str.hashCode();
        if (!str.equals("accurate")) {
            if (!str.equals("fast")) {
                throw new IllegalArgumentException("Not a mode:" + map.get("mode"));
            }
            i = 1;
        }
        FaceDetectorOptions.Builder performanceMode = new FaceDetectorOptions.Builder().setClassificationMode(i2).setLandmarkMode(i3).setContourMode(i4).setMinFaceSize((float) ((Double) map.get("minFaceSize")).doubleValue()).setPerformanceMode(i);
        if (((Boolean) map.get("enableTracking")).booleanValue()) {
            performanceMode.enableTracking();
        }
        return performanceMode.build();
    }

    private Map<String, double[]> getLandmarkData(Face face) {
        HashMap hashMap = new HashMap();
        hashMap.put("bottomMouth", landmarkPosition(face, 0));
        hashMap.put("rightMouth", landmarkPosition(face, 11));
        hashMap.put("leftMouth", landmarkPosition(face, 5));
        hashMap.put("rightEye", landmarkPosition(face, 10));
        hashMap.put("leftEye", landmarkPosition(face, 4));
        hashMap.put("rightEar", landmarkPosition(face, 9));
        hashMap.put("leftEar", landmarkPosition(face, 3));
        hashMap.put("rightCheek", landmarkPosition(face, 7));
        hashMap.put("leftCheek", landmarkPosition(face, 1));
        hashMap.put("noseBase", landmarkPosition(face, 6));
        return hashMap;
    }

    private Map<String, List<double[]>> getContourData(Face face) {
        HashMap hashMap = new HashMap();
        hashMap.put(OptionalModuleUtils.FACE, contourPosition(face, 1));
        hashMap.put("leftEyebrowTop", contourPosition(face, 2));
        hashMap.put("leftEyebrowBottom", contourPosition(face, 3));
        hashMap.put("rightEyebrowTop", contourPosition(face, 4));
        hashMap.put("rightEyebrowBottom", contourPosition(face, 5));
        hashMap.put("leftEye", contourPosition(face, 6));
        hashMap.put("rightEye", contourPosition(face, 7));
        hashMap.put("upperLipTop", contourPosition(face, 8));
        hashMap.put("upperLipBottom", contourPosition(face, 9));
        hashMap.put("lowerLipTop", contourPosition(face, 10));
        hashMap.put("lowerLipBottom", contourPosition(face, 11));
        hashMap.put("noseBridge", contourPosition(face, 12));
        hashMap.put("noseBottom", contourPosition(face, 13));
        hashMap.put("leftCheek", contourPosition(face, 14));
        hashMap.put("rightCheek", contourPosition(face, 15));
        return hashMap;
    }

    private double[] landmarkPosition(Face face, int i) {
        if (face.getLandmark(i) != null) {
            return new double[]{r5.getPosition().x, r5.getPosition().y};
        }
        return null;
    }

    private List<double[]> contourPosition(Face face, int i) {
        FaceContour contour = face.getContour(i);
        if (contour == null) {
            return null;
        }
        List<PointF> points = contour.getPoints();
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < points.size(); i2++) {
            arrayList.add(new double[]{points.get(i2).x, points.get(i2).y});
        }
        return arrayList;
    }

    private void closeDetector(MethodCall methodCall) {
        String str = (String) methodCall.argument(TtmlNode.ATTR_ID);
        com.google.mlkit.vision.face.FaceDetector faceDetector = this.instances.get(str);
        if (faceDetector == null) {
            return;
        }
        faceDetector.close();
        this.instances.remove(str);
    }
}
