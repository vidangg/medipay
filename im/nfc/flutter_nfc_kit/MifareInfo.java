package im.nfc.flutter_nfc_kit;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.media3.exoplayer.rtsp.SessionDescription;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MifareUtils.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\b\u0018\u0000 !2\u00020\u0001:\u0001!B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJB\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u001bJ\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001J\t\u0010 \u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\nR\u0011\u0010\u0011\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u0006\""}, d2 = {"Lim/nfc/flutter_nfc_kit/MifareInfo;", "", SessionDescription.ATTR_TYPE, "", "size", "blockSize", "blockCount", "sectorCount", "(IIIILjava/lang/Integer;)V", "getBlockCount", "()I", "getBlockSize", "getSectorCount", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getSize", "getType", "typeStr", "", "getTypeStr", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "component5", "copy", "(IIIILjava/lang/Integer;)Lim/nfc/flutter_nfc_kit/MifareInfo;", "equals", "", "other", "hashCode", "toString", "Companion", "flutter_nfc_kit_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes4.dex */
public final /* data */ class MifareInfo {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final int blockCount;
    private final int blockSize;
    private final Integer sectorCount;
    private final int size;
    private final int type;

    public static /* synthetic */ MifareInfo copy$default(MifareInfo mifareInfo, int i, int i2, int i3, int i4, Integer num, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = mifareInfo.type;
        }
        if ((i5 & 2) != 0) {
            i2 = mifareInfo.size;
        }
        int i6 = i2;
        if ((i5 & 4) != 0) {
            i3 = mifareInfo.blockSize;
        }
        int i7 = i3;
        if ((i5 & 8) != 0) {
            i4 = mifareInfo.blockCount;
        }
        int i8 = i4;
        if ((i5 & 16) != 0) {
            num = mifareInfo.sectorCount;
        }
        return mifareInfo.copy(i, i6, i7, i8, num);
    }

    /* renamed from: component1, reason: from getter */
    public final int getType() {
        return this.type;
    }

    /* renamed from: component2, reason: from getter */
    public final int getSize() {
        return this.size;
    }

    /* renamed from: component3, reason: from getter */
    public final int getBlockSize() {
        return this.blockSize;
    }

    /* renamed from: component4, reason: from getter */
    public final int getBlockCount() {
        return this.blockCount;
    }

    /* renamed from: component5, reason: from getter */
    public final Integer getSectorCount() {
        return this.sectorCount;
    }

    public final MifareInfo copy(int type, int size, int blockSize, int blockCount, Integer sectorCount) {
        return new MifareInfo(type, size, blockSize, blockCount, sectorCount);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MifareInfo)) {
            return false;
        }
        MifareInfo mifareInfo = (MifareInfo) other;
        return this.type == mifareInfo.type && this.size == mifareInfo.size && this.blockSize == mifareInfo.blockSize && this.blockCount == mifareInfo.blockCount && Intrinsics.areEqual(this.sectorCount, mifareInfo.sectorCount);
    }

    public int hashCode() {
        int hashCode = ((((((Integer.hashCode(this.type) * 31) + Integer.hashCode(this.size)) * 31) + Integer.hashCode(this.blockSize)) * 31) + Integer.hashCode(this.blockCount)) * 31;
        Integer num = this.sectorCount;
        return hashCode + (num == null ? 0 : num.hashCode());
    }

    public String toString() {
        return "MifareInfo(type=" + this.type + ", size=" + this.size + ", blockSize=" + this.blockSize + ", blockCount=" + this.blockCount + ", sectorCount=" + this.sectorCount + ')';
    }

    public MifareInfo(int i, int i2, int i3, int i4, Integer num) {
        this.type = i;
        this.size = i2;
        this.blockSize = i3;
        this.blockCount = i4;
        this.sectorCount = num;
    }

    public final int getType() {
        return this.type;
    }

    public final int getSize() {
        return this.size;
    }

    public final int getBlockSize() {
        return this.blockSize;
    }

    public final int getBlockCount() {
        return this.blockCount;
    }

    public final Integer getSectorCount() {
        return this.sectorCount;
    }

    public final String getTypeStr() {
        if (this.sectorCount == null) {
            int i = this.type;
            if (i == 1) {
                return "ultralight";
            }
            if (i == 2) {
                return "ultralight_c";
            }
            return "ultralight_unknown";
        }
        int i2 = this.type;
        if (i2 == 0) {
            return "classic";
        }
        if (i2 == 1) {
            return "plus";
        }
        if (i2 == 2) {
            return "pro";
        }
        return "classic_unknown";
    }

    /* compiled from: MifareUtils.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006H\u0002¨\u0006\t"}, d2 = {"Lim/nfc/flutter_nfc_kit/MifareInfo$Companion;", "", "()V", "fromUltralight", "Lim/nfc/flutter_nfc_kit/MifareInfo;", SessionDescription.ATTR_TYPE, "", "ultralightPageCount", "ultralightSize", "flutter_nfc_kit_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final int ultralightPageCount(int type) {
            if (type != 1) {
                return type != 2 ? -1 : 44;
            }
            return 16;
        }

        private Companion() {
        }

        private final int ultralightSize(int type) {
            if (type == 1 || type == 2) {
                return ultralightPageCount(type) * 4;
            }
            return -1;
        }

        public final MifareInfo fromUltralight(int type) {
            return new MifareInfo(type, ultralightSize(type), 4, ultralightPageCount(type), null);
        }
    }
}
