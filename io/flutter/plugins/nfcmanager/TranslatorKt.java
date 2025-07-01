package io.flutter.plugins.nfcmanager;

import android.nfc.NdefMessage;
import android.nfc.NdefRecord;
import android.nfc.Tag;
import android.nfc.tech.IsoDep;
import android.nfc.tech.MifareClassic;
import android.nfc.tech.MifareUltralight;
import android.nfc.tech.Ndef;
import android.nfc.tech.NfcA;
import android.nfc.tech.NfcB;
import android.nfc.tech.NfcF;
import android.nfc.tech.NfcV;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.media3.exoplayer.rtsp.SessionDescription;
import com.tekartik.sqflite.Constant;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: Translator.kt */
@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0007\u001a\u001c\u0010\u0005\u001a\u00020\u00062\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\t0\b\u001a\u001c\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\t0\b2\u0006\u0010\u0007\u001a\u00020\u0006\u001a\u001c\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\t0\b2\u0006\u0010\u0007\u001a\u00020\f¨\u0006\r"}, d2 = {"getFlags", "", Constant.METHOD_OPTIONS, "", "", "getNdefMessage", "Landroid/nfc/NdefMessage;", "arg", "", "", "getNdefMessageMap", "getTagMap", "Landroid/nfc/Tag;", "nfc_manager_release"}, k = 2, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes4.dex */
public final class TranslatorKt {
    public static /* synthetic */ int getFlags$default(List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = CollectionsKt.emptyList();
        }
        return getFlags(list);
    }

    public static final int getFlags(List<String> options) {
        Intrinsics.checkNotNullParameter(options, "options");
        int i = options.contains("iso14443") ? 3 : 0;
        if (options.contains("iso15693")) {
            i |= 8;
        }
        return options.contains("iso18092") ? i | 4 : i;
    }

    public static final Map<String, Object> getTagMap(Tag arg) {
        Map mapOf;
        Map<String, Object> ndefMessageMap;
        Intrinsics.checkNotNullParameter(arg, "arg");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        String[] techList = arg.getTechList();
        Intrinsics.checkNotNullExpressionValue(techList, "getTechList(...)");
        for (String str : techList) {
            Intrinsics.checkNotNull(str);
            Locale ROOT = Locale.ROOT;
            Intrinsics.checkNotNullExpressionValue(ROOT, "ROOT");
            String lowerCase = str.toLowerCase(ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            Object last = CollectionsKt.last((List<? extends Object>) StringsKt.split$default((CharSequence) lowerCase, new String[]{"."}, false, 0, 6, (Object) null));
            if (Intrinsics.areEqual(str, NfcA.class.getName())) {
                NfcA nfcA = NfcA.get(arg);
                mapOf = MapsKt.mapOf(TuplesKt.to("identifier", arg.getId()), TuplesKt.to("atqa", nfcA.getAtqa()), TuplesKt.to("maxTransceiveLength", Integer.valueOf(nfcA.getMaxTransceiveLength())), TuplesKt.to("sak", Short.valueOf(nfcA.getSak())), TuplesKt.to("timeout", Integer.valueOf(nfcA.getTimeout())));
            } else if (Intrinsics.areEqual(str, NfcB.class.getName())) {
                NfcB nfcB = NfcB.get(arg);
                mapOf = MapsKt.mapOf(TuplesKt.to("identifier", arg.getId()), TuplesKt.to("applicationData", nfcB.getApplicationData()), TuplesKt.to("maxTransceiveLength", Integer.valueOf(nfcB.getMaxTransceiveLength())), TuplesKt.to("protocolInfo", nfcB.getProtocolInfo()));
            } else if (Intrinsics.areEqual(str, NfcF.class.getName())) {
                NfcF nfcF = NfcF.get(arg);
                mapOf = MapsKt.mapOf(TuplesKt.to("identifier", arg.getId()), TuplesKt.to("manufacturer", nfcF.getManufacturer()), TuplesKt.to("maxTransceiveLength", Integer.valueOf(nfcF.getMaxTransceiveLength())), TuplesKt.to("systemCode", nfcF.getSystemCode()), TuplesKt.to("timeout", Integer.valueOf(nfcF.getTimeout())));
            } else if (Intrinsics.areEqual(str, NfcV.class.getName())) {
                NfcV nfcV = NfcV.get(arg);
                mapOf = MapsKt.mapOf(TuplesKt.to("identifier", arg.getId()), TuplesKt.to("dsfId", Byte.valueOf(nfcV.getDsfId())), TuplesKt.to("responseFlags", Byte.valueOf(nfcV.getResponseFlags())), TuplesKt.to("maxTransceiveLength", Integer.valueOf(nfcV.getMaxTransceiveLength())));
            } else if (Intrinsics.areEqual(str, IsoDep.class.getName())) {
                IsoDep isoDep = IsoDep.get(arg);
                mapOf = MapsKt.mapOf(TuplesKt.to("identifier", arg.getId()), TuplesKt.to("hiLayerResponse", isoDep.getHiLayerResponse()), TuplesKt.to("historicalBytes", isoDep.getHistoricalBytes()), TuplesKt.to("isExtendedLengthApduSupported", Boolean.valueOf(isoDep.isExtendedLengthApduSupported())), TuplesKt.to("maxTransceiveLength", Integer.valueOf(isoDep.getMaxTransceiveLength())), TuplesKt.to("timeout", Integer.valueOf(isoDep.getTimeout())));
            } else if (Intrinsics.areEqual(str, MifareClassic.class.getName())) {
                MifareClassic mifareClassic = MifareClassic.get(arg);
                mapOf = MapsKt.mapOf(TuplesKt.to("identifier", arg.getId()), TuplesKt.to("blockCount", Integer.valueOf(mifareClassic.getBlockCount())), TuplesKt.to("maxTransceiveLength", Integer.valueOf(mifareClassic.getMaxTransceiveLength())), TuplesKt.to("sectorCount", Integer.valueOf(mifareClassic.getSectorCount())), TuplesKt.to("size", Integer.valueOf(mifareClassic.getSize())), TuplesKt.to("timeout", Integer.valueOf(mifareClassic.getTimeout())), TuplesKt.to(SessionDescription.ATTR_TYPE, Integer.valueOf(mifareClassic.getType())));
            } else if (Intrinsics.areEqual(str, MifareUltralight.class.getName())) {
                MifareUltralight mifareUltralight = MifareUltralight.get(arg);
                mapOf = MapsKt.mapOf(TuplesKt.to("identifier", arg.getId()), TuplesKt.to("maxTransceiveLength", Integer.valueOf(mifareUltralight.getMaxTransceiveLength())), TuplesKt.to("timeout", Integer.valueOf(mifareUltralight.getTimeout())), TuplesKt.to(SessionDescription.ATTR_TYPE, Integer.valueOf(mifareUltralight.getType())));
            } else if (Intrinsics.areEqual(str, Ndef.class.getName())) {
                Ndef ndef = Ndef.get(arg);
                Pair[] pairArr = new Pair[6];
                pairArr[0] = TuplesKt.to("identifier", arg.getId());
                pairArr[1] = TuplesKt.to("isWritable", Boolean.valueOf(ndef.isWritable()));
                pairArr[2] = TuplesKt.to("maxSize", Integer.valueOf(ndef.getMaxSize()));
                pairArr[3] = TuplesKt.to("canMakeReadOnly", Boolean.valueOf(ndef.canMakeReadOnly()));
                if (ndef.getCachedNdefMessage() == null) {
                    ndefMessageMap = null;
                } else {
                    NdefMessage cachedNdefMessage = ndef.getCachedNdefMessage();
                    Intrinsics.checkNotNullExpressionValue(cachedNdefMessage, "getCachedNdefMessage(...)");
                    ndefMessageMap = getNdefMessageMap(cachedNdefMessage);
                }
                pairArr[4] = TuplesKt.to("cachedMessage", ndefMessageMap);
                pairArr[5] = TuplesKt.to(SessionDescription.ATTR_TYPE, ndef.getType());
                mapOf = MapsKt.mapOf(pairArr);
            } else {
                mapOf = MapsKt.mapOf(TuplesKt.to("identifier", arg.getId()));
            }
            linkedHashMap.put(last, mapOf);
        }
        return linkedHashMap;
    }

    public static final NdefMessage getNdefMessage(Map<String, ? extends Object> arg) {
        Intrinsics.checkNotNullParameter(arg, "arg");
        Object obj = arg.get("records");
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.List<*>");
        ArrayList arrayList = new ArrayList();
        for (Object obj2 : (List) obj) {
            if (obj2 instanceof Map) {
                arrayList.add(obj2);
            }
        }
        ArrayList<Map> arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
        for (Map map : arrayList2) {
            Object obj3 = map.get("typeNameFormat");
            Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type kotlin.Int");
            short intValue = (short) ((Integer) obj3).intValue();
            Object obj4 = map.get(SessionDescription.ATTR_TYPE);
            Intrinsics.checkNotNull(obj4, "null cannot be cast to non-null type kotlin.ByteArray");
            byte[] bArr = (byte[]) obj4;
            Object obj5 = map.get("identifier");
            byte[] bArr2 = obj5 instanceof byte[] ? (byte[]) obj5 : null;
            Object obj6 = map.get("payload");
            Intrinsics.checkNotNull(obj6, "null cannot be cast to non-null type kotlin.ByteArray");
            arrayList3.add(new NdefRecord(intValue, bArr, bArr2, (byte[]) obj6));
        }
        return new NdefMessage((NdefRecord[]) arrayList3.toArray(new NdefRecord[0]));
    }

    public static final Map<String, Object> getNdefMessageMap(NdefMessage arg) {
        Intrinsics.checkNotNullParameter(arg, "arg");
        NdefRecord[] records = arg.getRecords();
        Intrinsics.checkNotNullExpressionValue(records, "getRecords(...)");
        NdefRecord[] ndefRecordArr = records;
        ArrayList arrayList = new ArrayList(ndefRecordArr.length);
        for (NdefRecord ndefRecord : ndefRecordArr) {
            arrayList.add(MapsKt.mapOf(TuplesKt.to("typeNameFormat", Short.valueOf(ndefRecord.getTnf())), TuplesKt.to(SessionDescription.ATTR_TYPE, ndefRecord.getType()), TuplesKt.to("identifier", ndefRecord.getId()), TuplesKt.to("payload", ndefRecord.getPayload())));
        }
        return MapsKt.mapOf(TuplesKt.to("records", CollectionsKt.toList(arrayList)));
    }
}
