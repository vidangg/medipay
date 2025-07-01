package vn.ai.faceauth.sdk.presentation.presentation.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Typeface;
import android.text.Html;
import android.widget.Button;
import android.widget.TextView;
import androidx.camera.video.AudioStats;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.media3.extractor.text.ttml.TtmlNode;
import kotlin.Metadata;
import kotlin.ranges.IntProgression;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import paua.btj;
import vn.ai.faceauth.sdk.domain.model.Rect;

@Metadata(d1 = {"\u0000P\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\u001a \u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u001a\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n\u001a\u000e\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\r\u001a\u0016\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0001\u001a\u0012\u0010\u0010\u001a\u00020\u0011*\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u0001\u001a\u0012\u0010\u0013\u001a\u00020\u0011*\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0001\u001a\u001c\u0010\u0015\u001a\u00020\u0011*\u00020\u00122\u0006\u0010\u0004\u001a\u00020\u00012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u001a\n\u0010\u0016\u001a\u00020\u0017*\u00020\u0018\u001a\u001c\u0010\u0019\u001a\u00020\u0011*\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u00012\u0006\u0010\u001c\u001a\u00020\u001d\u001a\u001c\u0010\u0019\u001a\u00020\u0011*\u00020\u00122\b\b\u0002\u0010\u001b\u001a\u00020\u00012\u0006\u0010\u001c\u001a\u00020\u001d¨\u0006\u001e"}, d2 = {"getTextByKey", "", "context", "Landroid/content/Context;", "keyLang", "jsStringKey", "Lorg/json/JSONObject;", "isBitmapBlurryOptimized", "", "bitmap", "Landroid/graphics/Bitmap;", "isColorDark", "color", "", "isStringKeyExists", "key", "bindHtmlByKey", "", "Landroid/widget/TextView;", "bindHtmlToString", TypedValues.Custom.S_STRING, "setTextByKey", "toDomainRect", "Lvn/ai/faceauth/sdk/domain/model/Rect;", "Landroid/graphics/Rect;", "updateFont", "Landroid/widget/Button;", "fontName", TtmlNode.ATTR_TTS_FONT_SIZE, "", "authenSDK_release"}, k = 2, mv = {1, 6, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes4.dex */
public final class UtilsKt {
    public static final void bindHtmlByKey(TextView textView, String str) {
        try {
            Context context = textView.getContext();
            textView.setText(Html.fromHtml(context.getString(context.getResources().getIdentifier(str, btj.tzend(572), context.getPackageName())), 0));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static final void bindHtmlToString(TextView textView, String str) {
        try {
            textView.setText(Html.fromHtml(str, 0));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static final String getTextByKey(Context context, String str, JSONObject jSONObject) {
        if (jSONObject != null && isStringKeyExists(context, str) && jSONObject.optString(str, "").length() > 0) {
            return jSONObject.getString(str);
        }
        return context.getString(context.getResources().getIdentifier(str, btj.tzend(573), context.getPackageName()));
    }

    public static final boolean isBitmapBlurryOptimized(Bitmap bitmap) {
        int i;
        boolean z = true;
        z = true;
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, (int) (bitmap.getWidth() * 0.25f), (int) (bitmap.getHeight() * 0.25f), true);
        int width = createScaledBitmap.getWidth();
        int height = createScaledBitmap.getHeight();
        int[] iArr = new int[width * height];
        createScaledBitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        int i2 = 2;
        IntProgression step = RangesKt.step(RangesKt.until(1, height - 1), 2);
        int first = step.getFirst();
        int last = step.getLast();
        int step2 = step.getStep();
        double d = AudioStats.AUDIO_AMPLITUDE_NONE;
        if ((step2 > 0 && first <= last) || (step2 < 0 && last <= first)) {
            i = 0;
            while (true) {
                IntProgression step3 = RangesKt.step(RangesKt.until(z ? 1 : 0, width - 1), i2);
                int first2 = step3.getFirst();
                int last2 = step3.getLast();
                int step4 = step3.getStep();
                if ((step4 > 0 && first2 <= last2) || (step4 < 0 && last2 <= first2)) {
                    while (true) {
                        int i3 = iArr[((first - 1) * width) + first2];
                        int i4 = iArr[((first + 1) * width) + first2];
                        int i5 = first * width;
                        double d2 = (iArr[(first2 + 1) + i5] & 255) - (iArr[(first2 - 1) + i5] & 255);
                        double d3 = (i4 & 255) - (i3 & 255);
                        Double.isNaN(d2);
                        Double.isNaN(d2);
                        Double.isNaN(d3);
                        Double.isNaN(d3);
                        d += Math.sqrt((d3 * d3) + (d2 * d2));
                        z = true;
                        i++;
                        if (first2 == last2) {
                            break;
                        }
                        first2 += step4;
                    }
                }
                if (first == last) {
                    break;
                }
                first += step2;
                i2 = 2;
            }
        } else {
            i = 0;
        }
        double d4 = i;
        Double.isNaN(d4);
        if (d / d4 < 15.0d) {
            return z;
        }
        return false;
    }

    public static final boolean isColorDark(int i) {
        double d = 1;
        double red = Color.red(i);
        Double.isNaN(red);
        double green = Color.green(i);
        Double.isNaN(green);
        double blue = Color.blue(i);
        Double.isNaN(blue);
        double d2 = 255;
        Double.isNaN(d2);
        Double.isNaN(d);
        return d - (((blue * 0.114d) + ((green * 0.587d) + (red * 0.299d))) / d2) >= 0.5d;
    }

    public static final boolean isStringKeyExists(Context context, String str) {
        return context.getResources().getIdentifier(str, btj.tzend(574), context.getPackageName()) != 0;
    }

    public static final void setTextByKey(TextView textView, String str, JSONObject jSONObject) {
        if (jSONObject == null || !isStringKeyExists(textView.getContext(), str) || jSONObject.optString(str, "").length() <= 0) {
            bindHtmlByKey(textView, str);
        } else {
            bindHtmlToString(textView, jSONObject.optString(str, ""));
        }
    }

    public static final Rect toDomainRect(android.graphics.Rect rect) {
        return new Rect(rect.left, rect.top, rect.right, rect.bottom);
    }

    public static final void updateFont(Button button, String str, float f) {
        String tzend = btj.tzend(575);
        if (f > 0.0f) {
            button.setTextSize(2, f);
        }
        if (str.length() == 0 || StringsKt.isBlank(str)) {
            return;
        }
        try {
            Typeface typeface = button.getTypeface();
            button.setTypeface(Typeface.createFromAsset(button.getContext().getAssets(), tzend + str), typeface.getStyle());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static final void updateFont(TextView textView, String str, float f) {
        String tzend = btj.tzend(576);
        if (f > 0.0f) {
            textView.setTextSize(2, f);
        }
        if (str.length() == 0 || StringsKt.isBlank(str)) {
            return;
        }
        try {
            Typeface typeface = textView.getTypeface();
            textView.setTypeface(Typeface.createFromAsset(textView.getContext().getAssets(), tzend + str), typeface.getStyle());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static /* synthetic */ void updateFont$default(Button button, String str, float f, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "";
        }
        updateFont(button, str, f);
    }

    public static /* synthetic */ void updateFont$default(TextView textView, String str, float f, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "";
        }
        updateFont(textView, str, f);
    }
}
