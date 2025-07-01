package im.nfc.flutter_nfc_kit;

import android.nfc.tech.MifareClassic;
import android.nfc.tech.MifareUltralight;
import android.nfc.tech.TagTechnology;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tekartik.sqflite.Constant;
import io.flutter.plugin.common.MethodChannel;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MifareUtils.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0006\u001a\u00020\u0007*\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u0012\u0010\r\u001a\u00020\u000e*\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\nJ\"\u0010\u0011\u001a\u00020\u0007*\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\fR\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lim/nfc/flutter_nfc_kit/MifareUtils;", "", "()V", "TAG", "", "kotlin.jvm.PlatformType", "readBlock", "", "Landroid/nfc/tech/TagTechnology;", TypedValues.CycleType.S_WAVE_OFFSET, "", Constant.PARAM_RESULT, "Lio/flutter/plugin/common/MethodChannel$Result;", "readSector", "", "Landroid/nfc/tech/MifareClassic;", FirebaseAnalytics.Param.INDEX, "writeBlock", "data", "flutter_nfc_kit_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes4.dex */
public final class MifareUtils {
    public static final MifareUtils INSTANCE = new MifareUtils();
    private static final String TAG = MifareUtils.class.getName();

    private MifareUtils() {
    }

    public final void readBlock(TagTechnology tagTechnology, int i, MethodChannel.Result result) {
        Intrinsics.checkNotNullParameter(tagTechnology, "<this>");
        Intrinsics.checkNotNullParameter(result, "result");
        if (tagTechnology instanceof MifareClassic) {
            result.success(((MifareClassic) tagTechnology).readBlock(i));
        } else if (tagTechnology instanceof MifareUltralight) {
            result.success(((MifareUltralight) tagTechnology).readPages(i));
        } else {
            result.error("405", "Cannot invoke read on non-Mifare card", null);
        }
    }

    public final void writeBlock(TagTechnology tagTechnology, int i, byte[] data, MethodChannel.Result result) {
        Intrinsics.checkNotNullParameter(tagTechnology, "<this>");
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(result, "result");
        if (tagTechnology instanceof MifareClassic) {
            ((MifareClassic) tagTechnology).writeBlock(i, data);
            result.success("");
        } else if (tagTechnology instanceof MifareUltralight) {
            ((MifareUltralight) tagTechnology).writePage(i, data);
            result.success("");
        } else {
            result.error("405", "Cannot invoke write on non-Mifare card", null);
        }
    }

    public final byte[] readSector(MifareClassic mifareClassic, int i) {
        Intrinsics.checkNotNullParameter(mifareClassic, "<this>");
        int sectorToBlock = mifareClassic.sectorToBlock(i);
        int blockCountInSector = mifareClassic.getBlockCountInSector(i) + sectorToBlock;
        byte[] bArr = new byte[0];
        while (sectorToBlock < blockCountInSector) {
            byte[] readBlock = mifareClassic.readBlock(sectorToBlock);
            Intrinsics.checkNotNullExpressionValue(readBlock, "readBlock(...)");
            bArr = ArraysKt.plus(bArr, readBlock);
            sectorToBlock++;
        }
        return bArr;
    }
}
