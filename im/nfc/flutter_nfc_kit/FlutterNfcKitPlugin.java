package im.nfc.flutter_nfc_kit;

import android.app.Activity;
import android.nfc.FormatException;
import android.nfc.NdefMessage;
import android.nfc.NdefRecord;
import android.nfc.NfcAdapter;
import android.nfc.Tag;
import android.nfc.tech.IsoDep;
import android.nfc.tech.MifareClassic;
import android.nfc.tech.MifareUltralight;
import android.nfc.tech.Ndef;
import android.nfc.tech.NfcA;
import android.nfc.tech.NfcB;
import android.nfc.tech.NfcF;
import android.nfc.tech.NfcV;
import android.nfc.tech.TagTechnology;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import androidx.core.os.EnvironmentCompat;
import androidx.media3.exoplayer.rtsp.SessionDescription;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tekartik.sqflite.Constant;
import im.nfc.flutter_nfc_kit.FlutterNfcKitPlugin;
import io.flutter.Log;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.activity.ActivityAware;
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import io.flutter.plugin.common.EventChannel;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Timer;
import java.util.TimerTask;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: FlutterNfcKitPlugin.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u0000 \u001c2\u00020\u00012\u00020\u00022\u00020\u0003:\u0002\u001c\u001dB\u0005¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0006H\u0016J\b\u0010\u0012\u001a\u00020\u0006H\u0016J\u0010\u0010\u0013\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0010H\u0016J\u0018\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u0015\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\rH\u0016J(\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001aH\u0002¨\u0006\u001e"}, d2 = {"Lim/nfc/flutter_nfc_kit/FlutterNfcKitPlugin;", "Lio/flutter/embedding/engine/plugins/FlutterPlugin;", "Lio/flutter/plugin/common/MethodChannel$MethodCallHandler;", "Lio/flutter/embedding/engine/plugins/activity/ActivityAware;", "()V", "handleMethodCall", "", NotificationCompat.CATEGORY_CALL, "Lio/flutter/plugin/common/MethodCall;", Constant.PARAM_RESULT, "Lio/flutter/plugin/common/MethodChannel$Result;", "onAttachedToActivity", "binding", "Lio/flutter/embedding/engine/plugins/activity/ActivityPluginBinding;", "onAttachedToEngine", "flutterPluginBinding", "Lio/flutter/embedding/engine/plugins/FlutterPlugin$FlutterPluginBinding;", "onDetachedFromActivity", "onDetachedFromActivityForConfigChanges", "onDetachedFromEngine", "onMethodCall", "onReattachedToActivityForConfigChanges", "pollTag", "nfcAdapter", "Landroid/nfc/NfcAdapter;", "timeout", "", "technologies", "Companion", "MethodResultWrapper", "flutter_nfc_kit_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes4.dex */
public final class FlutterNfcKitPlugin implements FlutterPlugin, MethodChannel.MethodCallHandler, ActivityAware {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = FlutterNfcKitPlugin.class.getName();
    private static WeakReference<Activity> activity = new WeakReference<>(null);
    private static EventChannel eventChannel;
    private static EventChannel.EventSink eventSink;
    private static MethodChannel methodChannel;
    private static MifareInfo mifareInfo;
    private static Ndef ndefTechnology;
    private static Handler nfcHandler;
    private static HandlerThread nfcHandlerThread;
    private static TimerTask pollingTimeoutTask;
    private static TagTechnology tagTechnology;

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public void onDetachedFromActivityForConfigChanges() {
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public void onReattachedToActivityForConfigChanges(ActivityPluginBinding binding) {
        Intrinsics.checkNotNullParameter(binding, "binding");
    }

    /* compiled from: FlutterNfcKitPlugin.kt */
    @Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eJ\u0010\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J&\u0010 \u001a\u00020\u001c2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u00042\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u001c0%H\u0002J#\u0010&\u001a\u00020'*\u00020\u001a2\u0006\u0010(\u001a\u00020'2\b\u0010)\u001a\u0004\u0018\u00010*H\u0002¢\u0006\u0002\u0010+R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Lim/nfc/flutter_nfc_kit/FlutterNfcKitPlugin$Companion;", "", "()V", "TAG", "", "kotlin.jvm.PlatformType", "activity", "Ljava/lang/ref/WeakReference;", "Landroid/app/Activity;", "eventChannel", "Lio/flutter/plugin/common/EventChannel;", "eventSink", "Lio/flutter/plugin/common/EventChannel$EventSink;", "methodChannel", "Lio/flutter/plugin/common/MethodChannel;", "mifareInfo", "Lim/nfc/flutter_nfc_kit/MifareInfo;", "ndefTechnology", "Landroid/nfc/tech/Ndef;", "nfcHandler", "Landroid/os/Handler;", "nfcHandlerThread", "Landroid/os/HandlerThread;", "pollingTimeoutTask", "Ljava/util/TimerTask;", "tagTechnology", "Landroid/nfc/tech/TagTechnology;", "handleTag", "", "tag", "Landroid/nfc/Tag;", "parseTag", "runOnNfcThread", Constant.PARAM_RESULT, "Lio/flutter/plugin/common/MethodChannel$Result;", "desc", "fn", "Lkotlin/Function0;", "transceive", "", "data", "timeout", "", "(Landroid/nfc/tech/TagTechnology;[BLjava/lang/Integer;)[B", "flutter_nfc_kit_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final void handleTag(Tag tag) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            final String parseTag = parseTag(tag);
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: im.nfc.flutter_nfc_kit.FlutterNfcKitPlugin$Companion$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    FlutterNfcKitPlugin.Companion.handleTag$lambda$0(parseTag);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void handleTag$lambda$0(String result) {
            Intrinsics.checkNotNullParameter(result, "$result");
            EventChannel.EventSink eventSink = FlutterNfcKitPlugin.eventSink;
            if (eventSink != null) {
                eventSink.success(result);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final byte[] transceive(TagTechnology tagTechnology, byte[] bArr, Integer num) {
            if (num != null) {
                try {
                    tagTechnology.getClass().getMethod("setTimeout", Integer.TYPE).invoke(tagTechnology, num);
                } catch (Throwable unused) {
                }
            }
            Object invoke = tagTechnology.getClass().getMethod("transceive", byte[].class).invoke(tagTechnology, bArr);
            Intrinsics.checkNotNull(invoke, "null cannot be cast to non-null type kotlin.ByteArray");
            return (byte[]) invoke;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void runOnNfcThread(final MethodChannel.Result result, final String desc, final Function0<Unit> fn) {
            Runnable runnable = new Runnable() { // from class: im.nfc.flutter_nfc_kit.FlutterNfcKitPlugin$Companion$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    FlutterNfcKitPlugin.Companion.runOnNfcThread$lambda$1(Function0.this, desc, result);
                }
            };
            Handler handler = FlutterNfcKitPlugin.nfcHandler;
            if (handler == null) {
                Intrinsics.throwUninitializedPropertyAccessException("nfcHandler");
                handler = null;
            }
            if (handler.post(runnable)) {
                return;
            }
            result.error("500", "Failed to post job to NFC Handler thread.", null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void runOnNfcThread$lambda$1(Function0 fn, String desc, MethodChannel.Result result) {
            Intrinsics.checkNotNullParameter(fn, "$fn");
            Intrinsics.checkNotNullParameter(desc, "$desc");
            Intrinsics.checkNotNullParameter(result, "$result");
            try {
                fn.invoke();
            } catch (Exception e) {
                Log.e(FlutterNfcKitPlugin.TAG, desc + " error", e);
                String localizedMessage = e.getLocalizedMessage();
                if (e instanceof IOException) {
                    result.error("500", "Communication error", localizedMessage);
                    return;
                }
                if (e instanceof SecurityException) {
                    result.error("503", "Tag already removed", localizedMessage);
                    return;
                }
                if (e instanceof FormatException) {
                    result.error("400", "NDEF format error", localizedMessage);
                    return;
                }
                if (e instanceof InvocationTargetException) {
                    result.error("500", "Communication error", localizedMessage);
                    return;
                }
                if (e instanceof IllegalArgumentException) {
                    result.error("400", "Command format error", localizedMessage);
                } else if (e instanceof NoSuchMethodException) {
                    result.error("405", "Transceive not supported for this type of card", localizedMessage);
                } else {
                    result.error("500", "Unhandled error", localizedMessage);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Removed duplicated region for block: B:12:0x032f  */
        /* JADX WARN: Removed duplicated region for block: B:16:0x025d  */
        /* JADX WARN: Removed duplicated region for block: B:9:0x023e  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final String parseTag(Tag tag) {
            Object obj;
            String str;
            String str2;
            String str3;
            String str4;
            String str5;
            String str6;
            String str7;
            String str8;
            String str9;
            String[] techList;
            int i;
            boolean z;
            boolean z2;
            boolean z3;
            String str10;
            ByteUtils byteUtils = ByteUtils.INSTANCE;
            byte[] id = tag.getId();
            Intrinsics.checkNotNullExpressionValue(id, "getId(...)");
            String hexString = byteUtils.toHexString(id);
            String[] techList2 = tag.getTechList();
            Intrinsics.checkNotNullExpressionValue(techList2, "getTechList(...)");
            boolean contains = ArraysKt.contains(techList2, NfcA.class.getName());
            String str11 = EnvironmentCompat.MEDIA_UNKNOWN;
            String str12 = "";
            if (contains) {
                NfcA nfcA = NfcA.get(tag);
                ByteUtils byteUtils2 = ByteUtils.INSTANCE;
                byte[] atqa = nfcA.getAtqa();
                Intrinsics.checkNotNullExpressionValue(atqa, "getAtqa(...)");
                String hexString2 = byteUtils2.toHexString(atqa);
                String hexString3 = ByteUtils.INSTANCE.toHexString(new byte[]{(byte) nfcA.getSak()});
                FlutterNfcKitPlugin.tagTechnology = nfcA;
                String[] techList3 = tag.getTechList();
                Intrinsics.checkNotNullExpressionValue(techList3, "getTechList(...)");
                if (ArraysKt.contains(techList3, IsoDep.class.getName())) {
                    IsoDep isoDep = IsoDep.get(tag);
                    FlutterNfcKitPlugin.tagTechnology = isoDep;
                    ByteUtils byteUtils3 = ByteUtils.INSTANCE;
                    byte[] historicalBytes = isoDep.getHistoricalBytes();
                    Intrinsics.checkNotNullExpressionValue(historicalBytes, "getHistoricalBytes(...)");
                    str = byteUtils3.toHexString(historicalBytes);
                    obj = "ISO 14443-4 (Type A)";
                    str5 = "";
                    str7 = str5;
                    str9 = str7;
                    str6 = hexString2;
                    str8 = hexString3;
                    str11 = "iso7816";
                    str2 = str9;
                    str3 = str2;
                } else {
                    String[] techList4 = tag.getTechList();
                    Intrinsics.checkNotNullExpressionValue(techList4, "getTechList(...)");
                    if (ArraysKt.contains(techList4, MifareClassic.class.getName())) {
                        MifareClassic mifareClassic = MifareClassic.get(tag);
                        Companion companion = FlutterNfcKitPlugin.INSTANCE;
                        FlutterNfcKitPlugin.tagTechnology = mifareClassic;
                        Companion companion2 = FlutterNfcKitPlugin.INSTANCE;
                        FlutterNfcKitPlugin.mifareInfo = new MifareInfo(mifareClassic.getType(), mifareClassic.getSize(), 16, mifareClassic.getBlockCount(), Integer.valueOf(mifareClassic.getSectorCount()));
                        str10 = "mifare_classic";
                    } else {
                        String[] techList5 = tag.getTechList();
                        Intrinsics.checkNotNullExpressionValue(techList5, "getTechList(...)");
                        if (ArraysKt.contains(techList5, MifareUltralight.class.getName())) {
                            MifareUltralight mifareUltralight = MifareUltralight.get(tag);
                            Companion companion3 = FlutterNfcKitPlugin.INSTANCE;
                            FlutterNfcKitPlugin.tagTechnology = mifareUltralight;
                            Companion companion4 = FlutterNfcKitPlugin.INSTANCE;
                            FlutterNfcKitPlugin.mifareInfo = MifareInfo.INSTANCE.fromUltralight(mifareUltralight.getType());
                            str10 = "mifare_ultralight";
                        }
                        obj = "ISO 14443-3 (Type A)";
                        str = "";
                        str2 = str;
                        str5 = str2;
                        str7 = str5;
                        str9 = str7;
                        str6 = hexString2;
                        str8 = hexString3;
                        str3 = str9;
                    }
                    str11 = str10;
                    obj = "ISO 14443-3 (Type A)";
                    str = "";
                    str2 = str;
                    str5 = str2;
                    str7 = str5;
                    str9 = str7;
                    str6 = hexString2;
                    str8 = hexString3;
                    str3 = str9;
                }
            } else {
                String[] techList6 = tag.getTechList();
                Intrinsics.checkNotNullExpressionValue(techList6, "getTechList(...)");
                if (ArraysKt.contains(techList6, NfcB.class.getName())) {
                    NfcB nfcB = NfcB.get(tag);
                    ByteUtils byteUtils4 = ByteUtils.INSTANCE;
                    byte[] protocolInfo = nfcB.getProtocolInfo();
                    Intrinsics.checkNotNullExpressionValue(protocolInfo, "getProtocolInfo(...)");
                    String hexString4 = byteUtils4.toHexString(protocolInfo);
                    ByteUtils byteUtils5 = ByteUtils.INSTANCE;
                    byte[] applicationData = nfcB.getApplicationData();
                    Intrinsics.checkNotNullExpressionValue(applicationData, "getApplicationData(...)");
                    String hexString5 = byteUtils5.toHexString(applicationData);
                    String[] techList7 = tag.getTechList();
                    Intrinsics.checkNotNullExpressionValue(techList7, "getTechList(...)");
                    if (!ArraysKt.contains(techList7, IsoDep.class.getName())) {
                        FlutterNfcKitPlugin.tagTechnology = nfcB;
                        obj = "ISO 14443-3 (Type B)";
                        str = "";
                        str2 = str;
                        str5 = str2;
                        str6 = str5;
                        str8 = str6;
                        str7 = hexString4;
                        str9 = hexString5;
                        str3 = str8;
                    } else {
                        IsoDep isoDep2 = IsoDep.get(tag);
                        FlutterNfcKitPlugin.tagTechnology = isoDep2;
                        ByteUtils byteUtils6 = ByteUtils.INSTANCE;
                        byte[] hiLayerResponse = isoDep2.getHiLayerResponse();
                        Intrinsics.checkNotNullExpressionValue(hiLayerResponse, "getHiLayerResponse(...)");
                        String hexString6 = byteUtils6.toHexString(hiLayerResponse);
                        obj = "ISO 14443-4 (Type B)";
                        str5 = "";
                        str6 = str5;
                        str8 = str6;
                        str7 = hexString4;
                        str9 = hexString5;
                        str11 = "iso7816";
                        str3 = str8;
                        str4 = str3;
                        str2 = hexString6;
                        str = str4;
                    }
                } else {
                    String[] techList8 = tag.getTechList();
                    Intrinsics.checkNotNullExpressionValue(techList8, "getTechList(...)");
                    if (ArraysKt.contains(techList8, NfcF.class.getName())) {
                        NfcF nfcF = NfcF.get(tag);
                        ByteUtils byteUtils7 = ByteUtils.INSTANCE;
                        byte[] manufacturer = nfcF.getManufacturer();
                        Intrinsics.checkNotNullExpressionValue(manufacturer, "getManufacturer(...)");
                        String hexString7 = byteUtils7.toHexString(manufacturer);
                        ByteUtils byteUtils8 = ByteUtils.INSTANCE;
                        byte[] systemCode = nfcF.getSystemCode();
                        Intrinsics.checkNotNullExpressionValue(systemCode, "getSystemCode(...)");
                        String hexString8 = byteUtils8.toHexString(systemCode);
                        FlutterNfcKitPlugin.tagTechnology = nfcF;
                        obj = "ISO 18092 (FeliCa)";
                        str5 = hexString8;
                        str = "";
                        str4 = str;
                        str6 = str4;
                        str7 = str6;
                        str8 = str7;
                        str9 = str8;
                        str11 = "iso18092";
                        str3 = hexString7;
                        str2 = str9;
                    } else {
                        String[] techList9 = tag.getTechList();
                        Intrinsics.checkNotNullExpressionValue(techList9, "getTechList(...)");
                        if (ArraysKt.contains(techList9, NfcV.class.getName())) {
                            NfcV nfcV = NfcV.get(tag);
                            String hexString9 = ByteUtils.INSTANCE.toHexString(nfcV.getDsfId());
                            FlutterNfcKitPlugin.tagTechnology = nfcV;
                            str4 = hexString9;
                            obj = "ISO 15693";
                            str2 = "";
                            str3 = str2;
                            str5 = str3;
                            str6 = str5;
                            str7 = str6;
                            str8 = str7;
                            str9 = str8;
                            str11 = "iso15693";
                            str = str9;
                        } else {
                            obj = EnvironmentCompat.MEDIA_UNKNOWN;
                            str = "";
                            str2 = str;
                            str3 = str2;
                            str4 = str3;
                            str5 = str4;
                            str6 = str5;
                            str7 = str6;
                            str8 = str7;
                            str9 = str8;
                        }
                    }
                }
                techList = tag.getTechList();
                Intrinsics.checkNotNullExpressionValue(techList, "getTechList(...)");
                if (ArraysKt.contains(techList, Ndef.class.getName())) {
                    i = 0;
                    z = false;
                    z2 = false;
                    z3 = false;
                } else {
                    Ndef ndef = Ndef.get(tag);
                    FlutterNfcKitPlugin.ndefTechnology = ndef;
                    str12 = ndef.getType();
                    Intrinsics.checkNotNullExpressionValue(str12, "getType(...)");
                    z = ndef.isWritable();
                    z2 = ndef.canMakeReadOnly();
                    i = ndef.getMaxSize();
                    z3 = true;
                }
                JSONObject jSONObject = new JSONObject(MapsKt.mapOf(TuplesKt.to(SessionDescription.ATTR_TYPE, str11), TuplesKt.to(TtmlNode.ATTR_ID, hexString), TuplesKt.to("standard", obj), TuplesKt.to("atqa", str6), TuplesKt.to("sak", str8), TuplesKt.to("historicalBytes", str), TuplesKt.to("protocolInfo", str7), TuplesKt.to("applicationData", str9), TuplesKt.to("hiLayerResponse", str2), TuplesKt.to("manufacturer", str3), TuplesKt.to("systemCode", str5), TuplesKt.to("dsfId", str4), TuplesKt.to("ndefAvailable", Boolean.valueOf(z3)), TuplesKt.to("ndefType", str12), TuplesKt.to("ndefWritable", Boolean.valueOf(z)), TuplesKt.to("ndefCanMakeReadOnly", Boolean.valueOf(z2)), TuplesKt.to("ndefCapacity", Integer.valueOf(i))));
                if (FlutterNfcKitPlugin.mifareInfo != null) {
                    MifareInfo mifareInfo = FlutterNfcKitPlugin.mifareInfo;
                    Intrinsics.checkNotNull(mifareInfo);
                    jSONObject.put("mifareInfo", new JSONObject(MapsKt.mapOf(TuplesKt.to(SessionDescription.ATTR_TYPE, mifareInfo.getTypeStr()), TuplesKt.to("size", Integer.valueOf(mifareInfo.getSize())), TuplesKt.to("blockSize", Integer.valueOf(mifareInfo.getBlockSize())), TuplesKt.to("blockCount", Integer.valueOf(mifareInfo.getBlockCount())), TuplesKt.to("sectorCount", mifareInfo.getSectorCount()))));
                }
                String jSONObject2 = jSONObject.toString();
                Intrinsics.checkNotNullExpressionValue(jSONObject2, "toString(...)");
                return jSONObject2;
            }
            str4 = str3;
            techList = tag.getTechList();
            Intrinsics.checkNotNullExpressionValue(techList, "getTechList(...)");
            if (ArraysKt.contains(techList, Ndef.class.getName())) {
            }
            JSONObject jSONObject3 = new JSONObject(MapsKt.mapOf(TuplesKt.to(SessionDescription.ATTR_TYPE, str11), TuplesKt.to(TtmlNode.ATTR_ID, hexString), TuplesKt.to("standard", obj), TuplesKt.to("atqa", str6), TuplesKt.to("sak", str8), TuplesKt.to("historicalBytes", str), TuplesKt.to("protocolInfo", str7), TuplesKt.to("applicationData", str9), TuplesKt.to("hiLayerResponse", str2), TuplesKt.to("manufacturer", str3), TuplesKt.to("systemCode", str5), TuplesKt.to("dsfId", str4), TuplesKt.to("ndefAvailable", Boolean.valueOf(z3)), TuplesKt.to("ndefType", str12), TuplesKt.to("ndefWritable", Boolean.valueOf(z)), TuplesKt.to("ndefCanMakeReadOnly", Boolean.valueOf(z2)), TuplesKt.to("ndefCapacity", Integer.valueOf(i))));
            if (FlutterNfcKitPlugin.mifareInfo != null) {
            }
            String jSONObject22 = jSONObject3.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject22, "toString(...)");
            return jSONObject22;
        }
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        Intrinsics.checkNotNullParameter(flutterPluginBinding, "flutterPluginBinding");
        HandlerThread handlerThread = new HandlerThread("NfcHandlerThread");
        nfcHandlerThread = handlerThread;
        handlerThread.start();
        HandlerThread handlerThread2 = nfcHandlerThread;
        if (handlerThread2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nfcHandlerThread");
            handlerThread2 = null;
        }
        nfcHandler = new Handler(handlerThread2.getLooper());
        MethodChannel methodChannel2 = new MethodChannel(flutterPluginBinding.getBinaryMessenger(), "flutter_nfc_kit/method");
        methodChannel = methodChannel2;
        methodChannel2.setMethodCallHandler(this);
        EventChannel eventChannel2 = new EventChannel(flutterPluginBinding.getBinaryMessenger(), "flutter_nfc_kit/event");
        eventChannel = eventChannel2;
        eventChannel2.setStreamHandler(new EventChannel.StreamHandler() { // from class: im.nfc.flutter_nfc_kit.FlutterNfcKitPlugin$onAttachedToEngine$1
            @Override // io.flutter.plugin.common.EventChannel.StreamHandler
            public void onCancel(Object arguments) {
            }

            @Override // io.flutter.plugin.common.EventChannel.StreamHandler
            public void onListen(Object arguments, EventChannel.EventSink events) {
                if (events != null) {
                    FlutterNfcKitPlugin.Companion companion = FlutterNfcKitPlugin.INSTANCE;
                    FlutterNfcKitPlugin.eventSink = events;
                }
            }
        });
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding binding) {
        Intrinsics.checkNotNullParameter(binding, "binding");
        MethodChannel methodChannel2 = methodChannel;
        HandlerThread handlerThread = null;
        if (methodChannel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("methodChannel");
            methodChannel2 = null;
        }
        methodChannel2.setMethodCallHandler(null);
        EventChannel eventChannel2 = eventChannel;
        if (eventChannel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("eventChannel");
            eventChannel2 = null;
        }
        eventChannel2.setStreamHandler(null);
        HandlerThread handlerThread2 = nfcHandlerThread;
        if (handlerThread2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nfcHandlerThread");
        } else {
            handlerThread = handlerThread2;
        }
        handlerThread.quitSafely();
    }

    @Override // io.flutter.plugin.common.MethodChannel.MethodCallHandler
    public void onMethodCall(MethodCall call, MethodChannel.Result result) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(result, "result");
        handleMethodCall(call, new MethodResultWrapper(result));
    }

    private final void handleMethodCall(final MethodCall call, final MethodChannel.Result result) {
        Object obj;
        String str;
        MifareInfo mifareInfo2;
        MifareInfo mifareInfo3;
        if (activity.get() == null) {
            result.error("500", "Cannot call method when not attached to activity", null);
            return;
        }
        final NfcAdapter defaultAdapter = NfcAdapter.getDefaultAdapter(activity.get());
        if ((defaultAdapter == null || !defaultAdapter.isEnabled()) && !Intrinsics.areEqual(call.method, "getNFCAvailability")) {
            result.error("404", "NFC not available", null);
            return;
        }
        Function0<Boolean> function0 = new Function0<Boolean>() { // from class: im.nfc.flutter_nfc_kit.FlutterNfcKitPlugin$handleMethodCall$ensureNDEF$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                Ndef ndef;
                boolean z;
                TagTechnology tagTechnology2;
                ndef = FlutterNfcKitPlugin.ndefTechnology;
                if (ndef == null) {
                    tagTechnology2 = FlutterNfcKitPlugin.tagTechnology;
                    if (tagTechnology2 == null) {
                        MethodChannel.Result.this.error("406", "No tag polled", null);
                    } else {
                        MethodChannel.Result.this.error("405", "NDEF not supported on current tag", null);
                    }
                    z = false;
                } else {
                    z = true;
                }
                return Boolean.valueOf(z);
            }
        };
        final FlutterNfcKitPlugin$handleMethodCall$switchTechnology$1 flutterNfcKitPlugin$handleMethodCall$switchTechnology$1 = new Function2<TagTechnology, TagTechnology, Unit>() { // from class: im.nfc.flutter_nfc_kit.FlutterNfcKitPlugin$handleMethodCall$switchTechnology$1
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(TagTechnology tagTechnology2, TagTechnology tagTechnology3) {
                invoke2(tagTechnology2, tagTechnology3);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(TagTechnology target, TagTechnology tagTechnology2) {
                Intrinsics.checkNotNullParameter(target, "target");
                if (target.isConnected()) {
                    return;
                }
                if (tagTechnology2 != null && tagTechnology2.isConnected()) {
                    tagTechnology2.close();
                }
                target.connect();
            }
        };
        String str2 = call.method;
        if (str2 != null) {
            switch (str2.hashCode()) {
                case -1730146418:
                    if (str2.equals("transceive")) {
                        final TagTechnology tagTechnology2 = tagTechnology;
                        final Object argument = call.argument("data");
                        if (argument == null || !((argument instanceof String) || (argument instanceof byte[]))) {
                            result.error("400", "Bad argument", null);
                            return;
                        }
                        if (tagTechnology2 == null) {
                            result.error("406", "No tag polled", null);
                            return;
                        }
                        Pair<byte[], String> canonicalizeData = ByteUtils.INSTANCE.canonicalizeData(argument);
                        final byte[] component1 = canonicalizeData.component1();
                        String component2 = canonicalizeData.component2();
                        INSTANCE.runOnNfcThread(result, "Transceive: " + component2, new Function0<Unit>() { // from class: im.nfc.flutter_nfc_kit.FlutterNfcKitPlugin$handleMethodCall$3
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Unit invoke() {
                                invoke2();
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2() {
                                Ndef ndef;
                                byte[] transceive;
                                Function2<TagTechnology, TagTechnology, Unit> function2 = flutterNfcKitPlugin$handleMethodCall$switchTechnology$1;
                                TagTechnology tagTechnology3 = tagTechnology2;
                                ndef = FlutterNfcKitPlugin.ndefTechnology;
                                function2.invoke(tagTechnology3, ndef);
                                transceive = FlutterNfcKitPlugin.INSTANCE.transceive(tagTechnology2, component1, (Integer) call.argument("timeout"));
                                if (argument instanceof String) {
                                    result.success(ByteUtils.INSTANCE.toHexString(transceive));
                                } else {
                                    result.success(transceive);
                                }
                            }
                        });
                        return;
                    }
                    return;
                case -1406546634:
                    if (str2.equals("writeNDEF") && function0.invoke().booleanValue()) {
                        final Ndef ndef = ndefTechnology;
                        Intrinsics.checkNotNull(ndef);
                        if (ndef.isWritable()) {
                            INSTANCE.runOnNfcThread(result, "Write NDEF", new Function0<Unit>() { // from class: im.nfc.flutter_nfc_kit.FlutterNfcKitPlugin$handleMethodCall$5
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(0);
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public /* bridge */ /* synthetic */ Unit invoke() {
                                    invoke2();
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2() {
                                    TagTechnology tagTechnology3;
                                    short s;
                                    Function2<TagTechnology, TagTechnology, Unit> function2 = flutterNfcKitPlugin$handleMethodCall$switchTechnology$1;
                                    Ndef ndef2 = ndef;
                                    tagTechnology3 = FlutterNfcKitPlugin.tagTechnology;
                                    function2.invoke(ndef2, tagTechnology3);
                                    Object argument2 = call.argument("data");
                                    Intrinsics.checkNotNull(argument2);
                                    JSONArray jSONArray = new JSONArray((String) argument2);
                                    int length = jSONArray.length();
                                    NdefRecord[] ndefRecordArr = new NdefRecord[length];
                                    for (int i = 0; i < length; i++) {
                                        Object obj2 = jSONArray.get(i);
                                        Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type org.json.JSONObject");
                                        JSONObject jSONObject = (JSONObject) obj2;
                                        String string = jSONObject.getString("typeNameFormat");
                                        if (string != null) {
                                            switch (string.hashCode()) {
                                                case -2034996822:
                                                    if (string.equals("nfcWellKnown")) {
                                                        s = 1;
                                                        break;
                                                    }
                                                    break;
                                                case -1844222469:
                                                    if (string.equals("unchanged")) {
                                                        s = 6;
                                                        break;
                                                    }
                                                    break;
                                                case -1283509131:
                                                    if (string.equals("absoluteURI")) {
                                                        s = 3;
                                                        break;
                                                    }
                                                    break;
                                                case 96634189:
                                                    if (string.equals("empty")) {
                                                        s = 0;
                                                        break;
                                                    }
                                                    break;
                                                case 103772132:
                                                    if (string.equals("media")) {
                                                        s = 2;
                                                        break;
                                                    }
                                                    break;
                                                case 1028822678:
                                                    if (string.equals("nfcExternal")) {
                                                        s = 4;
                                                        break;
                                                    }
                                                    break;
                                            }
                                        }
                                        s = 5;
                                        ByteUtils byteUtils = ByteUtils.INSTANCE;
                                        String string2 = jSONObject.getString(SessionDescription.ATTR_TYPE);
                                        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                                        byte[] hexToBytes = byteUtils.hexToBytes(string2);
                                        ByteUtils byteUtils2 = ByteUtils.INSTANCE;
                                        String string3 = jSONObject.getString("identifier");
                                        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
                                        byte[] hexToBytes2 = byteUtils2.hexToBytes(string3);
                                        ByteUtils byteUtils3 = ByteUtils.INSTANCE;
                                        String string4 = jSONObject.getString("payload");
                                        Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
                                        ndefRecordArr[i] = new NdefRecord(s, hexToBytes, hexToBytes2, byteUtils3.hexToBytes(string4));
                                    }
                                    ndef.writeNdefMessage(new NdefMessage(ndefRecordArr));
                                    result.success("");
                                }
                            });
                            return;
                        } else {
                            result.error("405", "Tag not writable", null);
                            return;
                        }
                    }
                    return;
                case -1274442605:
                    if (str2.equals("finish")) {
                        TimerTask timerTask = pollingTimeoutTask;
                        if (timerTask != null) {
                            timerTask.cancel();
                        }
                        INSTANCE.runOnNfcThread(result, "Close tag", new Function0<Unit>() { // from class: im.nfc.flutter_nfc_kit.FlutterNfcKitPlugin$handleMethodCall$2
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Unit invoke() {
                                invoke2();
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2() {
                                TagTechnology tagTechnology3;
                                Ndef ndef2;
                                WeakReference weakReference;
                                WeakReference weakReference2;
                                tagTechnology3 = FlutterNfcKitPlugin.tagTechnology;
                                if (tagTechnology3 != null && tagTechnology3.isConnected()) {
                                    tagTechnology3.close();
                                }
                                ndef2 = FlutterNfcKitPlugin.ndefTechnology;
                                if (ndef2 != null && ndef2.isConnected()) {
                                    ndef2.close();
                                }
                                weakReference = FlutterNfcKitPlugin.activity;
                                if (weakReference.get() != null) {
                                    NfcAdapter nfcAdapter = defaultAdapter;
                                    weakReference2 = FlutterNfcKitPlugin.activity;
                                    nfcAdapter.disableReaderMode((Activity) weakReference2.get());
                                }
                                result.success("");
                            }
                        });
                        return;
                    }
                    return;
                case -1140455273:
                    if (str2.equals("readBlock")) {
                        final TagTechnology tagTechnology3 = tagTechnology;
                        if (tagTechnology3 == null || mifareInfo == null) {
                            result.error("406", "No Mifare tag polled", null);
                            return;
                        }
                        Object argument2 = call.argument(FirebaseAnalytics.Param.INDEX);
                        Intrinsics.checkNotNull(argument2);
                        final int intValue = ((Number) argument2).intValue();
                        MifareInfo mifareInfo4 = mifareInfo;
                        Intrinsics.checkNotNull(mifareInfo4);
                        int blockCount = mifareInfo4.getBlockCount();
                        if (intValue >= 0 && intValue < blockCount) {
                            INSTANCE.runOnNfcThread(result, "Read block", new Function0<Unit>() { // from class: im.nfc.flutter_nfc_kit.FlutterNfcKitPlugin$handleMethodCall$8
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(0);
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public /* bridge */ /* synthetic */ Unit invoke() {
                                    invoke2();
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2() {
                                    Ndef ndef2;
                                    Function2<TagTechnology, TagTechnology, Unit> function2 = flutterNfcKitPlugin$handleMethodCall$switchTechnology$1;
                                    TagTechnology tagTechnology4 = tagTechnology3;
                                    ndef2 = FlutterNfcKitPlugin.ndefTechnology;
                                    function2.invoke(tagTechnology4, ndef2);
                                    MifareUtils.INSTANCE.readBlock(tagTechnology3, intValue, result);
                                }
                            });
                            return;
                        }
                        result.error("400", "Invalid block/page index " + intValue + ", should be in (0, " + blockCount + ')', null);
                        return;
                    }
                    return;
                case -867755155:
                    if (str2.equals("readNDEF") && function0.invoke().booleanValue()) {
                        final Ndef ndef2 = ndefTechnology;
                        Intrinsics.checkNotNull(ndef2);
                        INSTANCE.runOnNfcThread(result, "Read NDEF", new Function0<Unit>() { // from class: im.nfc.flutter_nfc_kit.FlutterNfcKitPlugin$handleMethodCall$4
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Unit invoke() {
                                invoke2();
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2() {
                                TagTechnology tagTechnology4;
                                NdefMessage ndefMessage;
                                String str3;
                                Function2<TagTechnology, TagTechnology, Unit> function2 = flutterNfcKitPlugin$handleMethodCall$switchTechnology$1;
                                Ndef ndef3 = ndef2;
                                tagTechnology4 = FlutterNfcKitPlugin.tagTechnology;
                                function2.invoke(ndef3, tagTechnology4);
                                Object argument3 = call.argument("cached");
                                Intrinsics.checkNotNull(argument3);
                                if (((Boolean) argument3).booleanValue()) {
                                    ndefMessage = ndef2.getCachedNdefMessage();
                                } else {
                                    ndefMessage = ndef2.getNdefMessage();
                                }
                                ArrayList arrayList = new ArrayList();
                                if (ndefMessage != null) {
                                    NdefRecord[] records = ndefMessage.getRecords();
                                    Intrinsics.checkNotNullExpressionValue(records, "getRecords(...)");
                                    for (NdefRecord ndefRecord : records) {
                                        Pair[] pairArr = new Pair[4];
                                        ByteUtils byteUtils = ByteUtils.INSTANCE;
                                        byte[] id = ndefRecord.getId();
                                        Intrinsics.checkNotNullExpressionValue(id, "getId(...)");
                                        pairArr[0] = TuplesKt.to("identifier", byteUtils.toHexString(id));
                                        ByteUtils byteUtils2 = ByteUtils.INSTANCE;
                                        byte[] payload = ndefRecord.getPayload();
                                        Intrinsics.checkNotNullExpressionValue(payload, "getPayload(...)");
                                        pairArr[1] = TuplesKt.to("payload", byteUtils2.toHexString(payload));
                                        ByteUtils byteUtils3 = ByteUtils.INSTANCE;
                                        byte[] type = ndefRecord.getType();
                                        Intrinsics.checkNotNullExpressionValue(type, "getType(...)");
                                        pairArr[2] = TuplesKt.to(SessionDescription.ATTR_TYPE, byteUtils3.toHexString(type));
                                        short tnf = ndefRecord.getTnf();
                                        if (tnf == 3) {
                                            str3 = "absoluteURI";
                                        } else if (tnf == 0) {
                                            str3 = "empty";
                                        } else if (tnf == 4) {
                                            str3 = "nfcExternal";
                                        } else if (tnf == 1) {
                                            str3 = "nfcWellKnown";
                                        } else if (tnf == 2) {
                                            str3 = "media";
                                        } else if (tnf == 6) {
                                            str3 = "unchanged";
                                        } else {
                                            str3 = EnvironmentCompat.MEDIA_UNKNOWN;
                                        }
                                        pairArr[3] = TuplesKt.to("typeNameFormat", str3);
                                        arrayList.add(MapsKt.mapOf(pairArr));
                                    }
                                }
                                result.success(new JSONArray((Collection) arrayList).toString());
                            }
                        });
                        return;
                    }
                    return;
                case -663121938:
                    if (str2.equals("writeBlock")) {
                        final TagTechnology tagTechnology4 = tagTechnology;
                        if (tagTechnology4 == null) {
                            obj = null;
                            str = "No Mifare tag polled";
                        } else {
                            if (mifareInfo != null) {
                                Object argument3 = call.argument(FirebaseAnalytics.Param.INDEX);
                                Intrinsics.checkNotNull(argument3);
                                final int intValue2 = ((Number) argument3).intValue();
                                MifareInfo mifareInfo5 = mifareInfo;
                                Intrinsics.checkNotNull(mifareInfo5);
                                int blockCount2 = mifareInfo5.getBlockCount();
                                if (intValue2 < 0 || intValue2 >= blockCount2) {
                                    result.error("400", "Invalid block/page index " + intValue2 + ", should be in (0, " + blockCount2 + ')', null);
                                    return;
                                }
                                Object argument4 = call.argument("data");
                                if (argument4 == null || !((argument4 instanceof String) || (argument4 instanceof byte[]))) {
                                    result.error("400", "Bad argument", null);
                                    return;
                                }
                                final byte[] component12 = ByteUtils.INSTANCE.canonicalizeData(argument4).component1();
                                int length = component12.length;
                                MifareInfo mifareInfo6 = mifareInfo;
                                Intrinsics.checkNotNull(mifareInfo6);
                                if (length == mifareInfo6.getBlockSize()) {
                                    INSTANCE.runOnNfcThread(result, "Write block", new Function0<Unit>() { // from class: im.nfc.flutter_nfc_kit.FlutterNfcKitPlugin$handleMethodCall$10
                                        /* JADX INFO: Access modifiers changed from: package-private */
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(0);
                                        }

                                        @Override // kotlin.jvm.functions.Function0
                                        public /* bridge */ /* synthetic */ Unit invoke() {
                                            invoke2();
                                            return Unit.INSTANCE;
                                        }

                                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                        public final void invoke2() {
                                            Ndef ndef3;
                                            Function2<TagTechnology, TagTechnology, Unit> function2 = flutterNfcKitPlugin$handleMethodCall$switchTechnology$1;
                                            TagTechnology tagTechnology5 = tagTechnology4;
                                            ndef3 = FlutterNfcKitPlugin.ndefTechnology;
                                            function2.invoke(tagTechnology5, ndef3);
                                            MifareUtils.INSTANCE.writeBlock(tagTechnology4, intValue2, component12, result);
                                        }
                                    });
                                    return;
                                }
                                StringBuilder sb = new StringBuilder("Invalid data size ");
                                sb.append(component12.length);
                                sb.append(", should be ");
                                MifareInfo mifareInfo7 = mifareInfo;
                                Intrinsics.checkNotNull(mifareInfo7);
                                sb.append(mifareInfo7.getBlockSize());
                                result.error("400", sb.toString(), null);
                                return;
                            }
                            str = "No Mifare tag polled";
                            obj = null;
                        }
                        result.error("406", str, obj);
                        return;
                    }
                    return;
                case -514485092:
                    if (str2.equals("readSector")) {
                        final TagTechnology tagTechnology5 = tagTechnology;
                        if (tagTechnology5 != null && (mifareInfo2 = mifareInfo) != null) {
                            Intrinsics.checkNotNull(mifareInfo2);
                            if (mifareInfo2.getSectorCount() != null) {
                                Object argument5 = call.argument(FirebaseAnalytics.Param.INDEX);
                                Intrinsics.checkNotNull(argument5);
                                final int intValue3 = ((Number) argument5).intValue();
                                MifareInfo mifareInfo8 = mifareInfo;
                                Intrinsics.checkNotNull(mifareInfo8);
                                Integer sectorCount = mifareInfo8.getSectorCount();
                                Intrinsics.checkNotNull(sectorCount);
                                int intValue4 = sectorCount.intValue();
                                if (intValue3 >= 0 && intValue3 < intValue4) {
                                    INSTANCE.runOnNfcThread(result, "Read sector", new Function0<Unit>() { // from class: im.nfc.flutter_nfc_kit.FlutterNfcKitPlugin$handleMethodCall$9
                                        /* JADX INFO: Access modifiers changed from: package-private */
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(0);
                                        }

                                        @Override // kotlin.jvm.functions.Function0
                                        public /* bridge */ /* synthetic */ Unit invoke() {
                                            invoke2();
                                            return Unit.INSTANCE;
                                        }

                                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                        public final void invoke2() {
                                            Ndef ndef3;
                                            TagTechnology tagTechnology6 = tagTechnology5;
                                            Intrinsics.checkNotNull(tagTechnology6, "null cannot be cast to non-null type android.nfc.tech.MifareClassic");
                                            Function2<TagTechnology, TagTechnology, Unit> function2 = flutterNfcKitPlugin$handleMethodCall$switchTechnology$1;
                                            TagTechnology tagTechnology7 = tagTechnology5;
                                            ndef3 = FlutterNfcKitPlugin.ndefTechnology;
                                            function2.invoke(tagTechnology7, ndef3);
                                            result.success(MifareUtils.INSTANCE.readSector((MifareClassic) tagTechnology6, intValue3));
                                        }
                                    });
                                    return;
                                }
                                result.error("400", "Invalid sector index " + intValue3 + ", should be in (0, " + intValue4 + ')', null);
                                return;
                            }
                        }
                        result.error("406", "No Mifare Classic tag polled", null);
                        return;
                    }
                    return;
                case -462243082:
                    if (str2.equals("setIosAlertMessage")) {
                        result.success("");
                        return;
                    }
                    return;
                case 3446719:
                    if (str2.equals("poll")) {
                        Object argument6 = call.argument("timeout");
                        Intrinsics.checkNotNull(argument6);
                        final int intValue5 = ((Number) argument6).intValue();
                        Object argument7 = call.argument("technologies");
                        Intrinsics.checkNotNull(argument7);
                        final int intValue6 = ((Number) argument7).intValue();
                        INSTANCE.runOnNfcThread(result, "Poll", new Function0<Unit>() { // from class: im.nfc.flutter_nfc_kit.FlutterNfcKitPlugin$handleMethodCall$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Unit invoke() {
                                invoke2();
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2() {
                                FlutterNfcKitPlugin flutterNfcKitPlugin = FlutterNfcKitPlugin.this;
                                NfcAdapter nfcAdapter = defaultAdapter;
                                Intrinsics.checkNotNullExpressionValue(nfcAdapter, "$nfcAdapter");
                                flutterNfcKitPlugin.pollTag(nfcAdapter, result, intValue5, intValue6);
                            }
                        });
                        return;
                    }
                    return;
                case 812955760:
                    if (str2.equals("getNFCAvailability")) {
                        if (defaultAdapter == null) {
                            result.success("not_supported");
                            return;
                        } else if (defaultAdapter.isEnabled()) {
                            result.success("available");
                            return;
                        } else {
                            result.success("disabled");
                            return;
                        }
                    }
                    return;
                case 1585068391:
                    if (str2.equals("makeNdefReadOnly") && function0.invoke().booleanValue()) {
                        final Ndef ndef3 = ndefTechnology;
                        Intrinsics.checkNotNull(ndef3);
                        if (ndef3.isWritable()) {
                            INSTANCE.runOnNfcThread(result, "Lock NDEF", new Function0<Unit>() { // from class: im.nfc.flutter_nfc_kit.FlutterNfcKitPlugin$handleMethodCall$6
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(0);
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public /* bridge */ /* synthetic */ Unit invoke() {
                                    invoke2();
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2() {
                                    TagTechnology tagTechnology6;
                                    Function2<TagTechnology, TagTechnology, Unit> function2 = flutterNfcKitPlugin$handleMethodCall$switchTechnology$1;
                                    Ndef ndef4 = ndef3;
                                    tagTechnology6 = FlutterNfcKitPlugin.tagTechnology;
                                    function2.invoke(ndef4, tagTechnology6);
                                    if (ndef3.makeReadOnly()) {
                                        result.success("");
                                    } else {
                                        result.error("500", "Failed to lock NDEF tag", null);
                                    }
                                }
                            });
                            return;
                        } else {
                            result.error("405", "Tag not writable", null);
                            return;
                        }
                    }
                    return;
                case 1641100955:
                    if (str2.equals("authenticateSector")) {
                        final TagTechnology tagTechnology6 = tagTechnology;
                        if (tagTechnology6 != null && (mifareInfo3 = mifareInfo) != null) {
                            Intrinsics.checkNotNull(mifareInfo3);
                            if (mifareInfo3.getSectorCount() != null) {
                                Object argument8 = call.argument(FirebaseAnalytics.Param.INDEX);
                                Intrinsics.checkNotNull(argument8);
                                final int intValue7 = ((Number) argument8).intValue();
                                MifareInfo mifareInfo9 = mifareInfo;
                                Intrinsics.checkNotNull(mifareInfo9);
                                Integer sectorCount2 = mifareInfo9.getSectorCount();
                                Intrinsics.checkNotNull(sectorCount2);
                                int intValue8 = sectorCount2.intValue();
                                if (intValue7 >= 0 && intValue7 < intValue8) {
                                    final Object argument9 = call.argument("keyA");
                                    final Object argument10 = call.argument("keyB");
                                    INSTANCE.runOnNfcThread(result, "Authenticate sector", new Function0<Unit>() { // from class: im.nfc.flutter_nfc_kit.FlutterNfcKitPlugin$handleMethodCall$7
                                        /* JADX INFO: Access modifiers changed from: package-private */
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(0);
                                        }

                                        @Override // kotlin.jvm.functions.Function0
                                        public /* bridge */ /* synthetic */ Unit invoke() {
                                            invoke2();
                                            return Unit.INSTANCE;
                                        }

                                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                        public final void invoke2() {
                                            Ndef ndef4;
                                            TagTechnology tagTechnology7 = tagTechnology6;
                                            Intrinsics.checkNotNull(tagTechnology7, "null cannot be cast to non-null type android.nfc.tech.MifareClassic");
                                            MifareClassic mifareClassic = (MifareClassic) tagTechnology7;
                                            Function2<TagTechnology, TagTechnology, Unit> function2 = flutterNfcKitPlugin$handleMethodCall$switchTechnology$1;
                                            TagTechnology tagTechnology8 = tagTechnology6;
                                            ndef4 = FlutterNfcKitPlugin.ndefTechnology;
                                            function2.invoke(tagTechnology8, ndef4);
                                            if (argument9 != null) {
                                                result.success(Boolean.valueOf(mifareClassic.authenticateSectorWithKeyA(intValue7, ByteUtils.INSTANCE.canonicalizeData(argument9).component1())));
                                            } else {
                                                if (argument10 != null) {
                                                    result.success(Boolean.valueOf(mifareClassic.authenticateSectorWithKeyB(intValue7, ByteUtils.INSTANCE.canonicalizeData(argument10).component1())));
                                                    return;
                                                }
                                                result.error("400", "No keys provided", null);
                                            }
                                        }
                                    });
                                    return;
                                } else {
                                    result.error("400", "Invalid sector index " + intValue7 + ", should be in (0, " + intValue8 + ')', null);
                                    return;
                                }
                            }
                        }
                        result.error("406", "No Mifare Classic tag polled", null);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public void onAttachedToActivity(ActivityPluginBinding binding) {
        Intrinsics.checkNotNullParameter(binding, "binding");
        activity = new WeakReference<>(binding.getActivity());
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public void onDetachedFromActivity() {
        TimerTask timerTask = pollingTimeoutTask;
        if (timerTask != null) {
            timerTask.cancel();
        }
        pollingTimeoutTask = null;
        tagTechnology = null;
        ndefTechnology = null;
        activity.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void pollTag(final NfcAdapter nfcAdapter, final MethodChannel.Result result, int timeout, int technologies) {
        Timer timer = new Timer();
        long j = timeout;
        TimerTask timerTask = new TimerTask() { // from class: im.nfc.flutter_nfc_kit.FlutterNfcKitPlugin$pollTag$$inlined$schedule$1
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                WeakReference weakReference;
                WeakReference weakReference2;
                try {
                    weakReference = FlutterNfcKitPlugin.activity;
                    if (weakReference.get() != null) {
                        NfcAdapter nfcAdapter2 = nfcAdapter;
                        weakReference2 = FlutterNfcKitPlugin.activity;
                        nfcAdapter2.disableReaderMode((Activity) weakReference2.get());
                    }
                } catch (Exception e) {
                    Log.w(FlutterNfcKitPlugin.TAG, "Cannot disable reader mode", e);
                }
                result.error("408", "Polling tag timeout", null);
            }
        };
        timer.schedule(timerTask, j);
        pollingTimeoutTask = timerTask;
        nfcAdapter.enableReaderMode(activity.get(), new NfcAdapter.ReaderCallback() { // from class: im.nfc.flutter_nfc_kit.FlutterNfcKitPlugin$$ExternalSyntheticLambda0
            @Override // android.nfc.NfcAdapter.ReaderCallback
            public final void onTagDiscovered(Tag tag) {
                FlutterNfcKitPlugin.pollTag$lambda$1(MethodChannel.Result.this, tag);
            }
        }, technologies, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void pollTag$lambda$1(MethodChannel.Result result, Tag tag) {
        Intrinsics.checkNotNullParameter(result, "$result");
        TimerTask timerTask = pollingTimeoutTask;
        if (timerTask != null) {
            timerTask.cancel();
        }
        Companion companion = INSTANCE;
        Intrinsics.checkNotNull(tag);
        result.success(companion.parseTag(tag));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: FlutterNfcKitPlugin.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0002\u0010\u0003J$\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u0016\u0010\u000e\u001a\u00020\b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\u0010H\u0002J\b\u0010\u0011\u001a\u00020\bH\u0016J\u0012\u0010\u0012\u001a\u00020\b2\b\u0010\u0002\u001a\u0004\u0018\u00010\rH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lim/nfc/flutter_nfc_kit/FlutterNfcKitPlugin$MethodResultWrapper;", "Lio/flutter/plugin/common/MethodChannel$Result;", Constant.PARAM_RESULT, "(Lio/flutter/plugin/common/MethodChannel$Result;)V", "hasError", "", "methodResult", "error", "", "errorCode", "", "errorMessage", "errorDetails", "", "ignoreIllegalState", "fn", "Lkotlin/Function0;", "notImplemented", FirebaseAnalytics.Param.SUCCESS, "Companion", "flutter_nfc_kit_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes4.dex */
    public static final class MethodResultWrapper implements MethodChannel.Result {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final Lazy<Handler> handler$delegate = LazyKt.lazy(new Function0<Handler>() { // from class: im.nfc.flutter_nfc_kit.FlutterNfcKitPlugin$MethodResultWrapper$Companion$handler$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Handler invoke() {
                return new Handler(Looper.getMainLooper());
            }
        });
        private boolean hasError;
        private final MethodChannel.Result methodResult;

        public MethodResultWrapper(MethodChannel.Result result) {
            Intrinsics.checkNotNullParameter(result, "result");
            this.methodResult = result;
        }

        /* compiled from: FlutterNfcKitPlugin.kt */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lim/nfc/flutter_nfc_kit/FlutterNfcKitPlugin$MethodResultWrapper$Companion;", "", "()V", "handler", "Landroid/os/Handler;", "getHandler", "()Landroid/os/Handler;", "handler$delegate", "Lkotlin/Lazy;", "flutter_nfc_kit_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
        /* loaded from: classes4.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final Handler getHandler() {
                return (Handler) MethodResultWrapper.handler$delegate.getValue();
            }
        }

        @Override // io.flutter.plugin.common.MethodChannel.Result
        public void success(final Object result) {
            INSTANCE.getHandler().post(new Runnable() { // from class: im.nfc.flutter_nfc_kit.FlutterNfcKitPlugin$MethodResultWrapper$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    FlutterNfcKitPlugin.MethodResultWrapper.success$lambda$0(FlutterNfcKitPlugin.MethodResultWrapper.this, result);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void success$lambda$0(final MethodResultWrapper this$0, final Object obj) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.ignoreIllegalState(new Function0<Unit>() { // from class: im.nfc.flutter_nfc_kit.FlutterNfcKitPlugin$MethodResultWrapper$success$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    MethodChannel.Result result;
                    result = FlutterNfcKitPlugin.MethodResultWrapper.this.methodResult;
                    result.success(obj);
                }
            });
        }

        @Override // io.flutter.plugin.common.MethodChannel.Result
        public void error(final String errorCode, final String errorMessage, final Object errorDetails) {
            Intrinsics.checkNotNullParameter(errorCode, "errorCode");
            INSTANCE.getHandler().post(new Runnable() { // from class: im.nfc.flutter_nfc_kit.FlutterNfcKitPlugin$MethodResultWrapper$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    FlutterNfcKitPlugin.MethodResultWrapper.error$lambda$1(FlutterNfcKitPlugin.MethodResultWrapper.this, errorCode, errorMessage, errorDetails);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void error$lambda$1(final MethodResultWrapper this$0, final String errorCode, final String str, final Object obj) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(errorCode, "$errorCode");
            this$0.ignoreIllegalState(new Function0<Unit>() { // from class: im.nfc.flutter_nfc_kit.FlutterNfcKitPlugin$MethodResultWrapper$error$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    MethodChannel.Result result;
                    result = FlutterNfcKitPlugin.MethodResultWrapper.this.methodResult;
                    result.error(errorCode, str, obj);
                }
            });
        }

        @Override // io.flutter.plugin.common.MethodChannel.Result
        public void notImplemented() {
            INSTANCE.getHandler().post(new Runnable() { // from class: im.nfc.flutter_nfc_kit.FlutterNfcKitPlugin$MethodResultWrapper$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    FlutterNfcKitPlugin.MethodResultWrapper.notImplemented$lambda$2(FlutterNfcKitPlugin.MethodResultWrapper.this);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void notImplemented$lambda$2(final MethodResultWrapper this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.ignoreIllegalState(new Function0<Unit>() { // from class: im.nfc.flutter_nfc_kit.FlutterNfcKitPlugin$MethodResultWrapper$notImplemented$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    MethodChannel.Result result;
                    result = FlutterNfcKitPlugin.MethodResultWrapper.this.methodResult;
                    result.notImplemented();
                }
            });
        }

        private final void ignoreIllegalState(Function0<Unit> fn) {
            try {
                if (this.hasError) {
                    return;
                }
                fn.invoke();
            } catch (IllegalStateException e) {
                this.hasError = true;
                Log.w(FlutterNfcKitPlugin.TAG, "Exception occurred when using MethodChannel.Result: " + e);
                Log.w(FlutterNfcKitPlugin.TAG, "Will ignore all following usage of object: " + this.methodResult);
            }
        }
    }
}
