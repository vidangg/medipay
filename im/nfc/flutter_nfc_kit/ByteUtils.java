package im.nfc.flutter_nfc_kit;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.common.base.Ascii;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* compiled from: ByteUtils.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u0005\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00040\b2\u0006\u0010\n\u001a\u00020\u0001J\n\u0010\u000b\u001a\u00020\t*\u00020\u0004J\n\u0010\f\u001a\u00020\u0004*\u00020\rJ\n\u0010\f\u001a\u00020\u0004*\u00020\tR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lim/nfc/flutter_nfc_kit/ByteUtils;", "", "()V", "HEX_CHARS", "", "HEX_CHARS_ARRAY", "", "canonicalizeData", "Lkotlin/Pair;", "", "data", "hexToBytes", "toHexString", "", "flutter_nfc_kit_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes4.dex */
public final class ByteUtils {
    private static final String HEX_CHARS = "0123456789ABCDEF";
    private static final char[] HEX_CHARS_ARRAY;
    public static final ByteUtils INSTANCE = new ByteUtils();

    private ByteUtils() {
    }

    static {
        char[] charArray = HEX_CHARS.toCharArray();
        Intrinsics.checkNotNullExpressionValue(charArray, "this as java.lang.String).toCharArray()");
        HEX_CHARS_ARRAY = charArray;
    }

    public final byte[] hexToBytes(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        if (str.length() % 2 == 1) {
            throw new IllegalArgumentException();
        }
        byte[] bArr = new byte[str.length() / 2];
        String upperCase = str.toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(Locale.ROOT)");
        IntProgression step = RangesKt.step(RangesKt.until(0, str.length()), 2);
        int first = step.getFirst();
        int last = step.getLast();
        int step2 = step.getStep();
        if ((step2 > 0 && first <= last) || (step2 < 0 && last <= first)) {
            while (true) {
                int indexOf$default = StringsKt.indexOf$default((CharSequence) HEX_CHARS, upperCase.charAt(first), 0, false, 6, (Object) null);
                int indexOf$default2 = StringsKt.indexOf$default((CharSequence) HEX_CHARS, upperCase.charAt(first + 1), 0, false, 6, (Object) null);
                if (indexOf$default != -1 && indexOf$default2 != -1) {
                    bArr[first >> 1] = (byte) (indexOf$default2 | (indexOf$default << 4));
                    if (first == last) {
                        break;
                    }
                    first += step2;
                } else {
                    break;
                }
            }
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        return bArr;
    }

    public final String toHexString(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b : bArr) {
            stringBuffer.append(INSTANCE.toHexString(b));
        }
        String stringBuffer2 = stringBuffer.toString();
        Intrinsics.checkNotNullExpressionValue(stringBuffer2, "toString(...)");
        return stringBuffer2;
    }

    public final String toHexString(byte b) {
        int i = (b & 240) >>> 4;
        int i2 = b & Ascii.SI;
        StringBuilder sb = new StringBuilder();
        char[] cArr = HEX_CHARS_ARRAY;
        sb.append(cArr[i]);
        sb.append(cArr[i2]);
        return sb.toString();
    }

    public final Pair<byte[], String> canonicalizeData(Object data) {
        Intrinsics.checkNotNullParameter(data, "data");
        return new Pair<>(data instanceof String ? hexToBytes((String) data) : (byte[]) data, data instanceof byte[] ? toHexString((byte[]) data) : (String) data);
    }
}
