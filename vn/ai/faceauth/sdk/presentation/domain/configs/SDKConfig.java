package vn.ai.faceauth.sdk.presentation.domain.configs;

import android.graphics.Color;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.ViewCompat;
import androidx.media3.extractor.text.ttml.TtmlNode;
import androidx.media3.extractor.ts.TsExtractor;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import paua.btj;
import vn.ai.faceauth.sdk.presentation.presentation.utils.UtilsKt;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b.\b\u0086\b\u0018\u00002\u00020\u0001B'\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007B?\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u000bBO\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u000eBg\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0006\u0010\u0012\u001a\u00020\u0010\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0013Bw\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0006\u0010\u0012\u001a\u00020\u0010\u0012\u0006\u0010\u0014\u001a\u00020\u0003\u0012\u0006\u0010\u0015\u001a\u00020\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0017B\u0087\u0001\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0006\u0010\u0012\u001a\u00020\u0010\u0012\u0006\u0010\u0014\u001a\u00020\u0003\u0012\u0006\u0010\u0018\u001a\u00020\u0016\u0012\u0006\u0010\u0015\u001a\u00020\u0016\u0012\u0006\u0010\u0019\u001a\u00020\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u001aB\u009f\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0016\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0016\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0016\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0016\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u001cJ\t\u0010.\u001a\u00020\u0003HÆ\u0003J\t\u0010/\u001a\u00020\u0010HÆ\u0003J\t\u00100\u001a\u00020\u0010HÆ\u0003J\t\u00101\u001a\u00020\u0003HÆ\u0003J\t\u00102\u001a\u00020\u0016HÆ\u0003J\t\u00103\u001a\u00020\u0016HÆ\u0003J\t\u00104\u001a\u00020\u0016HÆ\u0003J\t\u00105\u001a\u00020\u0016HÆ\u0003J\t\u00106\u001a\u00020\u0003HÆ\u0003J\t\u00107\u001a\u00020\u0003HÆ\u0003J\t\u00108\u001a\u00020\u0003HÆ\u0003J\t\u00109\u001a\u00020\u0003HÆ\u0003J\t\u0010:\u001a\u00020\u0003HÆ\u0003J\t\u0010;\u001a\u00020\u0003HÆ\u0003J\t\u0010<\u001a\u00020\u0003HÆ\u0003J\t\u0010=\u001a\u00020\u0003HÆ\u0003J\t\u0010>\u001a\u00020\u0010HÆ\u0003J³\u0001\u0010?\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u00102\b\b\u0002\u0010\u0014\u001a\u00020\u00032\b\b\u0002\u0010\u0018\u001a\u00020\u00162\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0019\u001a\u00020\u00162\b\b\u0002\u0010\u001b\u001a\u00020\u00162\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010@\u001a\u00020\u00102\b\u0010A\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010B\u001a\u00020\u0016HÖ\u0001J\t\u0010C\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u001b\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010 R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010 R\u0011\u0010\u0014\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010 R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010$R\u0011\u0010\u0011\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010$R\u0011\u0010\u0012\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010$R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b%\u0010 R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010 R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b'\u0010 R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b(\u0010 R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b)\u0010 R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b*\u0010 R\u0011\u0010\u0015\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u001eR\u0011\u0010\u0019\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u001eR\u0011\u0010\u0018\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u001e¨\u0006D"}, d2 = {"Lvn/ai/faceauth/sdk/presentation/domain/configs/SDKConfig;", "", "primaryColor", "", "secondaryColor", TtmlNode.ATTR_TTS_BACKGROUND_COLOR, "nonce", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "errorColor", "closeColor", "textColor", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "ovalColor", "textButtonColor", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "isAutoProcess", "", "isCancelable", "isShowGuideScreen", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZZLjava/lang/String;)V", "fontName", "textSize", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZZLjava/lang/String;ILjava/lang/String;)V", "textSizeTitle", "textSizeButton", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZZLjava/lang/String;IIILjava/lang/String;)V", "apiTimeout", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZZLjava/lang/String;IIIILjava/lang/String;)V", "getApiTimeout", "()I", "getBackgroundColor", "()Ljava/lang/String;", "getCloseColor", "getErrorColor", "getFontName", "()Z", "getNonce", "getOvalColor", "getPrimaryColor", "getSecondaryColor", "getTextButtonColor", "getTextColor", "getTextSize", "getTextSizeButton", "getTextSizeTitle", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "authenSDK_release"}, k = 1, mv = {1, 6, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes4.dex */
public final /* data */ class SDKConfig {
    private final int apiTimeout;
    private final String backgroundColor;
    private final String closeColor;
    private final String errorColor;
    private final String fontName;
    private final boolean isAutoProcess;
    private final boolean isCancelable;
    private final boolean isShowGuideScreen;
    private final String nonce;
    private final String ovalColor;
    private final String primaryColor;
    private final String secondaryColor;
    private final String textButtonColor;
    private final String textColor;
    private final int textSize;
    private final int textSizeButton;
    private final int textSizeTitle;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public SDKConfig(String str, String str2, String str3, String str4) {
        this(str, str2, str, r8, r9, r10, r0, str3, false, true, false, "", 22, 16, 18, 90, str4);
        String format;
        String format2;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        Object[] copyOf = Arrays.copyOf(new Object[]{16711680}, 1);
        String tzend = btj.tzend(171);
        String format3 = String.format(tzend, copyOf);
        StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
        String format4 = String.format(tzend, Arrays.copyOf(new Object[]{0}, 1));
        boolean isColorDark = UtilsKt.isColorDark(Color.parseColor(str3));
        Integer valueOf = Integer.valueOf(ViewCompat.MEASURED_SIZE_MASK);
        if (isColorDark) {
            StringCompanionObject stringCompanionObject3 = StringCompanionObject.INSTANCE;
            format = String.format(tzend, Arrays.copyOf(new Object[]{valueOf}, 1));
        } else {
            StringCompanionObject stringCompanionObject4 = StringCompanionObject.INSTANCE;
            format = String.format(tzend, Arrays.copyOf(new Object[]{0}, 1));
        }
        String str5 = format;
        if (UtilsKt.isColorDark(Color.parseColor(str))) {
            StringCompanionObject stringCompanionObject5 = StringCompanionObject.INSTANCE;
            format2 = String.format(tzend, Arrays.copyOf(new Object[]{valueOf}, 1));
        } else {
            StringCompanionObject stringCompanionObject6 = StringCompanionObject.INSTANCE;
            format2 = String.format(tzend, Arrays.copyOf(new Object[]{0}, 1));
        }
    }

    public SDKConfig(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        this(str, str2, str, str3, str4, str5, Integer.toHexString(-1), str6, false, true, false, "", 22, 16, 18, 90, str7);
    }

    public SDKConfig(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        this(str, str2, str3, str4, str5, str6, str7, str8, false, true, false, "", 22, 16, 18, 90, str9);
    }

    public SDKConfig(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, boolean z2, boolean z3, String str9) {
        this(str, str2, str3, str4, str5, str6, str7, str8, z, z2, z3, "", 22, 16, 18, 90, str9);
    }

    public SDKConfig(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, boolean z2, boolean z3, String str9, int i, int i2, int i3, int i4, String str10) {
        this.primaryColor = str;
        this.secondaryColor = str2;
        this.ovalColor = str3;
        this.errorColor = str4;
        this.closeColor = str5;
        this.textColor = str6;
        this.textButtonColor = str7;
        this.backgroundColor = str8;
        this.isAutoProcess = z;
        this.isCancelable = z2;
        this.isShowGuideScreen = z3;
        this.fontName = str9;
        this.textSizeTitle = i;
        this.textSize = i2;
        this.textSizeButton = i3;
        this.apiTimeout = i4;
        this.nonce = str10;
    }

    public /* synthetic */ SDKConfig(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, boolean z2, boolean z3, String str9, int i, int i2, int i3, int i4, String str10, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, str4, str5, str6, str7, str8, (i5 & 256) != 0 ? false : z, (i5 & 512) != 0 ? true : z2, (i5 & 1024) != 0 ? false : z3, (i5 & 2048) != 0 ? "" : str9, (i5 & 4096) != 0 ? 22 : i, (i5 & 8192) != 0 ? 16 : i2, (i5 & 16384) != 0 ? 18 : i3, (32768 & i5) != 0 ? 90 : i4, (i5 & 65536) != 0 ? "" : str10);
    }

    public SDKConfig(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, boolean z2, boolean z3, String str9, int i, int i2, int i3, String str10) {
        this(str, str2, str3, str4, str5, str6, str7, str8, z, z2, z3, str9, i, i2, i3, 90, str10);
    }

    public SDKConfig(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, boolean z2, boolean z3, String str9, int i, String str10) {
        this(str, str2, str3, str4, str5, str6, str7, str8, z, z2, z3, str9, i + 6, i, i + 2, 90, str10);
    }

    /* renamed from: component1, reason: from getter */
    public final String getPrimaryColor() {
        return this.primaryColor;
    }

    /* renamed from: component10, reason: from getter */
    public final boolean getIsCancelable() {
        return this.isCancelable;
    }

    /* renamed from: component11, reason: from getter */
    public final boolean getIsShowGuideScreen() {
        return this.isShowGuideScreen;
    }

    /* renamed from: component12, reason: from getter */
    public final String getFontName() {
        return this.fontName;
    }

    /* renamed from: component13, reason: from getter */
    public final int getTextSizeTitle() {
        return this.textSizeTitle;
    }

    /* renamed from: component14, reason: from getter */
    public final int getTextSize() {
        return this.textSize;
    }

    /* renamed from: component15, reason: from getter */
    public final int getTextSizeButton() {
        return this.textSizeButton;
    }

    /* renamed from: component16, reason: from getter */
    public final int getApiTimeout() {
        return this.apiTimeout;
    }

    /* renamed from: component17, reason: from getter */
    public final String getNonce() {
        return this.nonce;
    }

    /* renamed from: component2, reason: from getter */
    public final String getSecondaryColor() {
        return this.secondaryColor;
    }

    /* renamed from: component3, reason: from getter */
    public final String getOvalColor() {
        return this.ovalColor;
    }

    /* renamed from: component4, reason: from getter */
    public final String getErrorColor() {
        return this.errorColor;
    }

    /* renamed from: component5, reason: from getter */
    public final String getCloseColor() {
        return this.closeColor;
    }

    /* renamed from: component6, reason: from getter */
    public final String getTextColor() {
        return this.textColor;
    }

    /* renamed from: component7, reason: from getter */
    public final String getTextButtonColor() {
        return this.textButtonColor;
    }

    /* renamed from: component8, reason: from getter */
    public final String getBackgroundColor() {
        return this.backgroundColor;
    }

    /* renamed from: component9, reason: from getter */
    public final boolean getIsAutoProcess() {
        return this.isAutoProcess;
    }

    public final SDKConfig copy(String primaryColor, String secondaryColor, String ovalColor, String errorColor, String closeColor, String textColor, String textButtonColor, String backgroundColor, boolean isAutoProcess, boolean isCancelable, boolean isShowGuideScreen, String fontName, int textSizeTitle, int textSize, int textSizeButton, int apiTimeout, String nonce) {
        return new SDKConfig(primaryColor, secondaryColor, ovalColor, errorColor, closeColor, textColor, textButtonColor, backgroundColor, isAutoProcess, isCancelable, isShowGuideScreen, fontName, textSizeTitle, textSize, textSizeButton, apiTimeout, nonce);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SDKConfig)) {
            return false;
        }
        SDKConfig sDKConfig = (SDKConfig) other;
        return Intrinsics.areEqual(this.primaryColor, sDKConfig.primaryColor) && Intrinsics.areEqual(this.secondaryColor, sDKConfig.secondaryColor) && Intrinsics.areEqual(this.ovalColor, sDKConfig.ovalColor) && Intrinsics.areEqual(this.errorColor, sDKConfig.errorColor) && Intrinsics.areEqual(this.closeColor, sDKConfig.closeColor) && Intrinsics.areEqual(this.textColor, sDKConfig.textColor) && Intrinsics.areEqual(this.textButtonColor, sDKConfig.textButtonColor) && Intrinsics.areEqual(this.backgroundColor, sDKConfig.backgroundColor) && this.isAutoProcess == sDKConfig.isAutoProcess && this.isCancelable == sDKConfig.isCancelable && this.isShowGuideScreen == sDKConfig.isShowGuideScreen && Intrinsics.areEqual(this.fontName, sDKConfig.fontName) && this.textSizeTitle == sDKConfig.textSizeTitle && this.textSize == sDKConfig.textSize && this.textSizeButton == sDKConfig.textSizeButton && this.apiTimeout == sDKConfig.apiTimeout && Intrinsics.areEqual(this.nonce, sDKConfig.nonce);
    }

    public final int getApiTimeout() {
        return this.apiTimeout;
    }

    public final String getBackgroundColor() {
        return this.backgroundColor;
    }

    public final String getCloseColor() {
        return this.closeColor;
    }

    public final String getErrorColor() {
        return this.errorColor;
    }

    public final String getFontName() {
        return this.fontName;
    }

    public final String getNonce() {
        return this.nonce;
    }

    public final String getOvalColor() {
        return this.ovalColor;
    }

    public final String getPrimaryColor() {
        return this.primaryColor;
    }

    public final String getSecondaryColor() {
        return this.secondaryColor;
    }

    public final String getTextButtonColor() {
        return this.textButtonColor;
    }

    public final String getTextColor() {
        return this.textColor;
    }

    public final int getTextSize() {
        return this.textSize;
    }

    public final int getTextSizeButton() {
        return this.textSizeButton;
    }

    public final int getTextSizeTitle() {
        return this.textSizeTitle;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = this.primaryColor.hashCode();
        int hashCode2 = this.secondaryColor.hashCode();
        int hashCode3 = this.ovalColor.hashCode();
        int hashCode4 = this.errorColor.hashCode();
        int hashCode5 = this.closeColor.hashCode();
        int hashCode6 = this.textColor.hashCode();
        int hashCode7 = this.textButtonColor.hashCode();
        int hashCode8 = this.backgroundColor.hashCode();
        boolean z = this.isAutoProcess;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        boolean z2 = this.isCancelable;
        int i2 = z2;
        if (z2 != 0) {
            i2 = 1;
        }
        boolean z3 = this.isShowGuideScreen;
        int i3 = z3 ? 1 : z3 ? 1 : 0;
        int hashCode9 = this.fontName.hashCode();
        int i4 = this.textSizeTitle;
        return this.nonce.hashCode() + ((this.apiTimeout + ((this.textSizeButton + ((this.textSize + ((i4 + ((hashCode9 + ((((((((hashCode8 + ((hashCode7 + ((hashCode6 + ((hashCode5 + ((hashCode4 + ((hashCode3 + ((hashCode2 + (hashCode * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31) + i) * 31) + i2) * 31) + i3) * 31)) * 31)) * 31)) * 31)) * 31)) * 31);
    }

    public final boolean isAutoProcess() {
        return this.isAutoProcess;
    }

    public final boolean isCancelable() {
        return this.isCancelable;
    }

    public final boolean isShowGuideScreen() {
        return this.isShowGuideScreen;
    }

    public String toString() {
        return btj.tzend(TsExtractor.TS_STREAM_TYPE_AC4) + this.primaryColor + btj.tzend(173) + this.secondaryColor + btj.tzend(174) + this.ovalColor + btj.tzend(175) + this.errorColor + btj.tzend(176) + this.closeColor + btj.tzend(177) + this.textColor + btj.tzend(178) + this.textButtonColor + btj.tzend(179) + this.backgroundColor + btj.tzend(180) + this.isAutoProcess + btj.tzend(181) + this.isCancelable + btj.tzend(182) + this.isShowGuideScreen + btj.tzend(183) + this.fontName + btj.tzend(184) + this.textSizeTitle + btj.tzend(185) + this.textSize + btj.tzend(186) + this.textSizeButton + btj.tzend(187) + this.apiTimeout + btj.tzend(TsExtractor.TS_PACKET_SIZE) + this.nonce + ')';
    }
}
