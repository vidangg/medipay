package com.google_mlkit_text_recognition;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.mlkit.vision.common.InputImage;
import com.google.mlkit.vision.text.Text;
import com.google.mlkit.vision.text.TextRecognition;
import com.google.mlkit.vision.text.chinese.ChineseTextRecognizerOptions;
import com.google.mlkit.vision.text.devanagari.DevanagariTextRecognizerOptions;
import com.google.mlkit.vision.text.japanese.JapaneseTextRecognizerOptions;
import com.google.mlkit.vision.text.korean.KoreanTextRecognizerOptions;
import com.google.mlkit.vision.text.latin.TextRecognizerOptions;
import com.google_mlkit_commons.InputImageConverter;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes4.dex */
public class TextRecognizer implements MethodChannel.MethodCallHandler {
    private static final String CLOSE = "vision#closeTextRecognizer";
    private static final String START = "vision#startTextRecognizer";
    private final Context context;
    private final Map<String, com.google.mlkit.vision.text.TextRecognizer> instances = new HashMap();

    public TextRecognizer(Context context) {
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

    private com.google.mlkit.vision.text.TextRecognizer initialize(MethodCall methodCall) {
        Integer num = (Integer) methodCall.argument("script");
        if (num == null) {
            return null;
        }
        int intValue = num.intValue();
        if (intValue == 0) {
            return TextRecognition.getClient(TextRecognizerOptions.DEFAULT_OPTIONS);
        }
        if (intValue == 1) {
            return TextRecognition.getClient(new ChineseTextRecognizerOptions.Builder().build());
        }
        if (intValue == 2) {
            return TextRecognition.getClient(new DevanagariTextRecognizerOptions.Builder().build());
        }
        if (intValue == 3) {
            return TextRecognition.getClient(new JapaneseTextRecognizerOptions.Builder().build());
        }
        if (intValue != 4) {
            return null;
        }
        return TextRecognition.getClient(new KoreanTextRecognizerOptions.Builder().build());
    }

    private void handleDetection(MethodCall methodCall, final MethodChannel.Result result) {
        InputImage inputImageFromData;
        Map map = (Map) methodCall.argument("imageData");
        if (map == null || (inputImageFromData = InputImageConverter.getInputImageFromData(map, this.context, result)) == null) {
            return;
        }
        String str = (String) methodCall.argument(TtmlNode.ATTR_ID);
        com.google.mlkit.vision.text.TextRecognizer textRecognizer = this.instances.get(str);
        if (textRecognizer == null) {
            textRecognizer = initialize(methodCall);
            this.instances.put(str, textRecognizer);
        }
        if (textRecognizer == null) {
            result.error("TextRecognizerError", "TextRecognizer is not initialized", null);
        } else {
            textRecognizer.process(inputImageFromData).addOnSuccessListener(new OnSuccessListener() { // from class: com.google_mlkit_text_recognition.TextRecognizer$$ExternalSyntheticLambda0
                @Override // com.google.android.gms.tasks.OnSuccessListener
                public final void onSuccess(Object obj) {
                    TextRecognizer.this.m713x2311d08f(result, (Text) obj);
                }
            }).addOnFailureListener(new OnFailureListener() { // from class: com.google_mlkit_text_recognition.TextRecognizer$$ExternalSyntheticLambda1
                @Override // com.google.android.gms.tasks.OnFailureListener
                public final void onFailure(Exception exc) {
                    MethodChannel.Result.this.error("TextRecognizerError", exc.toString(), null);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$handleDetection$0$com-google_mlkit_text_recognition-TextRecognizer, reason: not valid java name */
    public /* synthetic */ void m713x2311d08f(MethodChannel.Result result, Text text) {
        HashMap hashMap = new HashMap();
        hashMap.put("text", text.getText());
        ArrayList arrayList = new ArrayList();
        Iterator<Text.TextBlock> it = text.getTextBlocks().iterator();
        while (it.hasNext()) {
            Text.TextBlock next = it.next();
            HashMap hashMap2 = new HashMap();
            addData(hashMap2, next.getText(), next.getBoundingBox(), next.getCornerPoints(), next.getRecognizedLanguage(), null, null);
            ArrayList arrayList2 = new ArrayList();
            for (Text.Line line : next.getLines()) {
                HashMap hashMap3 = new HashMap();
                addData(hashMap3, line.getText(), line.getBoundingBox(), line.getCornerPoints(), line.getRecognizedLanguage(), Float.valueOf(line.getConfidence()), Float.valueOf(line.getAngle()));
                ArrayList arrayList3 = new ArrayList();
                for (Text.Element element : line.getElements()) {
                    HashMap hashMap4 = new HashMap();
                    addData(hashMap4, element.getText(), element.getBoundingBox(), element.getCornerPoints(), element.getRecognizedLanguage(), Float.valueOf(element.getConfidence()), Float.valueOf(element.getAngle()));
                    ArrayList arrayList4 = new ArrayList();
                    for (Text.Symbol symbol : element.getSymbols()) {
                        HashMap hashMap5 = new HashMap();
                        addData(hashMap5, symbol.getText(), symbol.getBoundingBox(), symbol.getCornerPoints(), symbol.getRecognizedLanguage(), Float.valueOf(symbol.getConfidence()), Float.valueOf(symbol.getAngle()));
                        arrayList4.add(hashMap5);
                        it = it;
                    }
                    hashMap4.put("symbols", arrayList4);
                    arrayList3.add(hashMap4);
                    it = it;
                }
                hashMap3.put("elements", arrayList3);
                arrayList2.add(hashMap3);
                it = it;
            }
            hashMap2.put("lines", arrayList2);
            arrayList.add(hashMap2);
            it = it;
        }
        hashMap.put("blocks", arrayList);
        result.success(hashMap);
    }

    private void addData(Map<String, Object> map, String str, Rect rect, Point[] pointArr, String str2, Float f, Float f2) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(str2);
        ArrayList arrayList2 = new ArrayList();
        addPoints(pointArr, arrayList2);
        map.put("points", arrayList2);
        map.put("rect", getBoundingPoints(rect));
        map.put("recognizedLanguages", arrayList);
        map.put("text", str);
        map.put("confidence", f);
        map.put("angle", f2);
    }

    private void addPoints(Point[] pointArr, List<Map<String, Integer>> list) {
        for (Point point : pointArr) {
            HashMap hashMap = new HashMap();
            hashMap.put("x", Integer.valueOf(point.x));
            hashMap.put("y", Integer.valueOf(point.y));
            list.add(hashMap);
        }
    }

    private Map<String, Integer> getBoundingPoints(Rect rect) {
        HashMap hashMap = new HashMap();
        hashMap.put(TtmlNode.LEFT, Integer.valueOf(rect.left));
        hashMap.put(TtmlNode.RIGHT, Integer.valueOf(rect.right));
        hashMap.put("top", Integer.valueOf(rect.top));
        hashMap.put("bottom", Integer.valueOf(rect.bottom));
        return hashMap;
    }

    private void closeDetector(MethodCall methodCall) {
        String str = (String) methodCall.argument(TtmlNode.ATTR_ID);
        com.google.mlkit.vision.text.TextRecognizer textRecognizer = this.instances.get(str);
        if (textRecognizer == null) {
            return;
        }
        textRecognizer.close();
        this.instances.remove(str);
    }
}
