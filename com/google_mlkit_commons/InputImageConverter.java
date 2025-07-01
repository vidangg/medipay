package com.google_mlkit_commons;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import androidx.constraintlayout.motion.widget.Key;
import androidx.media3.exoplayer.rtsp.SessionDescription;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.google.mlkit.vision.common.InputImage;
import io.flutter.plugin.common.MethodChannel;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes4.dex */
public class InputImageConverter {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    public static InputImage getInputImageFromData(Map<String, Object> map, Context context, MethodChannel.Result result) {
        String str = (String) map.get(SessionDescription.ATTR_TYPE);
        if (str != null && str.equals("file")) {
            try {
                return InputImage.fromFilePath(context, Uri.fromFile(new File((String) map.get("path"))));
            } catch (IOException e) {
                Log.e("ImageError", "Getting Image failed");
                Log.e("ImageError", e.toString());
                result.error("InputImageConverterError", e.toString(), null);
                return null;
            }
        }
        if (str != null && str.equals("bytes")) {
            try {
                Map map2 = (Map) map.get(TtmlNode.TAG_METADATA);
                return InputImage.fromByteArray((byte[]) Objects.requireNonNull(map.get("bytes")), Double.valueOf(Objects.requireNonNull(map2.get("width")).toString()).intValue(), Double.valueOf(Objects.requireNonNull(map2.get("height")).toString()).intValue(), Integer.parseInt(Objects.requireNonNull(map2.get(Key.ROTATION)).toString()), Integer.parseInt(Objects.requireNonNull(map2.get("image_format")).toString()));
            } catch (Exception e2) {
                Log.e("ImageError", "Getting Image failed");
                Log.e("ImageError", e2.toString());
                result.error("InputImageConverterError", e2.toString(), null);
                return null;
            }
        }
        result.error("InputImageConverterError", "Invalid Input Image", null);
        return null;
    }
}
