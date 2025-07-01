package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import androidx.media3.exoplayer.rtsp.SessionDescription;
import androidx.media3.extractor.metadata.icy.IcyHeaders;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.4.0 */
/* loaded from: classes3.dex */
public final class zzot {
    static final ImmutableList zza = ImmutableList.of("Version", "GoogleConsent", "VendorConsent", "VendorLegitimateInterest", "gdprApplies", "EnableAdvertiserConsentMode", "PolicyVersion", "PurposeConsents", "PurposeOneTreatment", "Purpose1", "Purpose3", "Purpose4", "Purpose7", "CmpSdkID", "PublisherCC", "PublisherRestrictions1", "PublisherRestrictions3", "PublisherRestrictions4", "PublisherRestrictions7", "AuthorizePurpose1", "AuthorizePurpose3", "AuthorizePurpose4", "AuthorizePurpose7", "PurposeDiagnostics");
    public static final /* synthetic */ int zzb = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zza(SharedPreferences sharedPreferences, String str) {
        try {
            return sharedPreferences.getInt(str, -1);
        } catch (ClassCastException unused) {
            return -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String zzb(SharedPreferences sharedPreferences, String str) {
        try {
            return sharedPreferences.getString(str, "");
        } catch (ClassCastException unused) {
            return "";
        }
    }

    public static final Map zzc(ImmutableMap immutableMap, ImmutableMap immutableMap2, ImmutableSet immutableSet, char[] cArr, int i, int i2, int i3, int i4, int i5, String str, String str2, String str3, boolean z, boolean z2) {
        int zza2;
        int zza3;
        int zza4;
        int zza5;
        com.google.android.gms.internal.measurement.zzkl zzklVar = com.google.android.gms.internal.measurement.zzkl.IAB_TCF_PURPOSE_STORE_AND_ACCESS_INFORMATION_ON_A_DEVICE;
        com.google.android.gms.internal.measurement.zzkm zzkmVar = (com.google.android.gms.internal.measurement.zzkm) immutableMap2.get(zzklVar);
        com.google.android.gms.internal.measurement.zzkl zzklVar2 = com.google.android.gms.internal.measurement.zzkl.IAB_TCF_PURPOSE_CREATE_A_PERSONALISED_ADS_PROFILE;
        com.google.android.gms.internal.measurement.zzkm zzkmVar2 = (com.google.android.gms.internal.measurement.zzkm) immutableMap2.get(zzklVar2);
        com.google.android.gms.internal.measurement.zzkl zzklVar3 = com.google.android.gms.internal.measurement.zzkl.IAB_TCF_PURPOSE_SELECT_PERSONALISED_ADS;
        com.google.android.gms.internal.measurement.zzkm zzkmVar3 = (com.google.android.gms.internal.measurement.zzkm) immutableMap2.get(zzklVar3);
        com.google.android.gms.internal.measurement.zzkl zzklVar4 = com.google.android.gms.internal.measurement.zzkl.IAB_TCF_PURPOSE_MEASURE_AD_PERFORMANCE;
        com.google.android.gms.internal.measurement.zzkm zzkmVar4 = (com.google.android.gms.internal.measurement.zzkm) immutableMap2.get(zzklVar4);
        ImmutableMap.Builder put = ImmutableMap.builder().put("Version", ExifInterface.GPS_MEASUREMENT_2D);
        String str4 = SessionDescription.SUPPORTED_SDP_VERSION;
        ImmutableMap.Builder put2 = put.put("VendorConsent", true != z ? SessionDescription.SUPPORTED_SDP_VERSION : IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE).put("VendorLegitimateInterest", true != z2 ? SessionDescription.SUPPORTED_SDP_VERSION : IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE).put("gdprApplies", i3 != 1 ? SessionDescription.SUPPORTED_SDP_VERSION : IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE).put("EnableAdvertiserConsentMode", i2 != 1 ? SessionDescription.SUPPORTED_SDP_VERSION : IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE).put("PolicyVersion", String.valueOf(i4)).put("CmpSdkID", String.valueOf(i)).put("PurposeOneTreatment", i5 != 1 ? SessionDescription.SUPPORTED_SDP_VERSION : IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE).put("PublisherCC", str);
        if (zzkmVar != null) {
            zza2 = zzkmVar.zza();
        } else {
            zza2 = com.google.android.gms.internal.measurement.zzkm.PURPOSE_RESTRICTION_UNDEFINED.zza();
        }
        ImmutableMap.Builder put3 = put2.put("PublisherRestrictions1", String.valueOf(zza2));
        if (zzkmVar2 != null) {
            zza3 = zzkmVar2.zza();
        } else {
            zza3 = com.google.android.gms.internal.measurement.zzkm.PURPOSE_RESTRICTION_UNDEFINED.zza();
        }
        ImmutableMap.Builder put4 = put3.put("PublisherRestrictions3", String.valueOf(zza3));
        if (zzkmVar3 != null) {
            zza4 = zzkmVar3.zza();
        } else {
            zza4 = com.google.android.gms.internal.measurement.zzkm.PURPOSE_RESTRICTION_UNDEFINED.zza();
        }
        ImmutableMap.Builder put5 = put4.put("PublisherRestrictions4", String.valueOf(zza4));
        if (zzkmVar4 != null) {
            zza5 = zzkmVar4.zza();
        } else {
            zza5 = com.google.android.gms.internal.measurement.zzkm.PURPOSE_RESTRICTION_UNDEFINED.zza();
        }
        ImmutableMap.Builder putAll = put5.put("PublisherRestrictions7", String.valueOf(zza5)).putAll(ImmutableMap.of("Purpose1", zzg(zzklVar, immutableMap, immutableMap2, immutableSet, cArr, i, i2, i3, i4, i5, str, str2, str3, z, z2), "Purpose3", zzg(zzklVar2, immutableMap, immutableMap2, immutableSet, cArr, i, i2, i3, i4, i5, str, str2, str3, z, z2), "Purpose4", zzg(zzklVar3, immutableMap, immutableMap2, immutableSet, cArr, i, i2, i3, i4, i5, str, str2, str3, z, z2), "Purpose7", zzg(zzklVar4, immutableMap, immutableMap2, immutableSet, cArr, i, i2, i3, i4, i5, str, str2, str3, z, z2)));
        Object obj = true != zzd(zzklVar, immutableMap, immutableMap2, immutableSet, cArr, i, i2, i3, i4, i5, str, str2, str3, z, z2) ? SessionDescription.SUPPORTED_SDP_VERSION : IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE;
        Object obj2 = true != zzd(zzklVar2, immutableMap, immutableMap2, immutableSet, cArr, i, i2, i3, i4, i5, str, str2, str3, z, z2) ? SessionDescription.SUPPORTED_SDP_VERSION : IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE;
        Object obj3 = true != zzd(zzklVar3, immutableMap, immutableMap2, immutableSet, cArr, i, i2, i3, i4, i5, str, str2, str3, z, z2) ? SessionDescription.SUPPORTED_SDP_VERSION : IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE;
        if (true == zzd(zzklVar4, immutableMap, immutableMap2, immutableSet, cArr, i, i2, i3, i4, i5, str, str2, str3, z, z2)) {
            str4 = IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE;
        }
        return putAll.putAll(ImmutableMap.of("AuthorizePurpose1", (String) obj, "AuthorizePurpose3", (String) obj2, "AuthorizePurpose4", (String) obj3, "AuthorizePurpose7", str4, "PurposeDiagnostics", new String(cArr))).buildOrThrow();
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01d1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static final boolean zzd(com.google.android.gms.internal.measurement.zzkl zzklVar, ImmutableMap immutableMap, ImmutableMap immutableMap2, ImmutableSet immutableSet, char[] cArr, int i, int i2, int i3, int i4, int i5, String str, String str2, String str3, boolean z, boolean z2) {
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        char c;
        ImmutableMap immutableMap3;
        int i12;
        zzos zzosVar;
        int ordinal;
        char c2;
        char c3;
        int zze = zze(zzklVar, immutableMap, immutableMap2, immutableSet, cArr, i, i2, i3, i4, i5, str, str2, str3, z, z2);
        if (zze > 0) {
            i7 = i3;
            i6 = i2;
            if (i7 == 1) {
                if (i6 == 1) {
                    i9 = 1;
                    i8 = 1;
                    if (zzf(zzklVar, immutableMap, immutableMap2, immutableSet, cArr, i, i9, i8, i4, i5, str, str2, str3, z, z2) != com.google.android.gms.internal.measurement.zzkm.PURPOSE_RESTRICTION_NOT_ALLOWED) {
                        c3 = '3';
                        c2 = '2';
                    } else {
                        if (zzklVar == com.google.android.gms.internal.measurement.zzkl.IAB_TCF_PURPOSE_STORE_AND_ACCESS_INFORMATION_ON_A_DEVICE) {
                            i10 = i5;
                            i11 = 1;
                            if (i10 == 1) {
                                if (immutableSet.contains(str)) {
                                    if (zze > 0 && cArr[zze] != '2') {
                                        cArr[zze] = '1';
                                    }
                                    return true;
                                }
                                c = '2';
                                immutableMap3 = immutableMap;
                                i12 = 1;
                                if (immutableMap3.containsKey(zzklVar) && (zzosVar = (zzos) immutableMap3.get(zzklVar)) != null) {
                                    ordinal = zzosVar.ordinal();
                                    if (ordinal != 0) {
                                        c2 = c;
                                        if (zzf(zzklVar, immutableMap, immutableMap2, immutableSet, cArr, i, i9, i8, i4, i12, str, str2, str3, z, z2) != com.google.android.gms.internal.measurement.zzkm.PURPOSE_RESTRICTION_REQUIRE_LEGITIMATE_INTEREST) {
                                            return zzh(zzklVar, immutableMap, immutableMap2, immutableSet, cArr, i, i9, i8, i4, i12, str, str2, str3, z, z2);
                                        }
                                    } else if (ordinal == i11) {
                                        c2 = c;
                                        if (zzf(zzklVar, immutableMap, immutableMap2, immutableSet, cArr, i, i9, i8, i4, i12, str, str2, str3, z, z2) != com.google.android.gms.internal.measurement.zzkm.PURPOSE_RESTRICTION_REQUIRE_CONSENT) {
                                            return zzi(zzklVar, immutableMap, immutableMap2, immutableSet, cArr, i, i9, i8, i4, i12, str, str2, str3, z, z2);
                                        }
                                    } else {
                                        if (ordinal == 2) {
                                            if (zzf(zzklVar, immutableMap, immutableMap2, immutableSet, cArr, i, i9, i8, i4, i12, str, str2, str3, z, z2) == com.google.android.gms.internal.measurement.zzkm.PURPOSE_RESTRICTION_REQUIRE_LEGITIMATE_INTEREST) {
                                                return zzi(zzklVar, immutableMap, immutableMap2, immutableSet, cArr, i, i9, i8, i4, i12, str, str2, str3, z, z2);
                                            }
                                            return zzh(zzklVar, immutableMap, immutableMap2, immutableSet, cArr, i, i9, i8, i4, i12, str, str2, str3, z, z2);
                                        }
                                        if (ordinal == 3) {
                                            if (zzf(zzklVar, immutableMap, immutableMap2, immutableSet, cArr, i, i9, i8, i4, i12, str, str2, str3, z, z2) == com.google.android.gms.internal.measurement.zzkm.PURPOSE_RESTRICTION_REQUIRE_CONSENT) {
                                                return zzh(zzklVar, immutableMap, immutableMap2, immutableSet, cArr, i, i9, i8, i4, i12, str, str2, str3, z, z2);
                                            }
                                            return zzi(zzklVar, immutableMap, immutableMap2, immutableSet, cArr, i, i9, i8, i4, i12, str, str2, str3, z, z2);
                                        }
                                    }
                                    c3 = '8';
                                }
                                c3 = '0';
                                c2 = c;
                            }
                        } else {
                            i10 = i5;
                            i11 = 1;
                        }
                        c = '2';
                        immutableMap3 = immutableMap;
                        i12 = i10;
                        if (immutableMap3.containsKey(zzklVar)) {
                            ordinal = zzosVar.ordinal();
                            if (ordinal != 0) {
                            }
                            c3 = '8';
                        }
                        c3 = '0';
                        c2 = c;
                    }
                    if (zze <= 0 && cArr[zze] != c2) {
                        cArr[zze] = c3;
                        return false;
                    }
                }
                i7 = 1;
            }
            cArr[zze] = '2';
        } else {
            i6 = i2;
            i7 = i3;
        }
        i8 = i7;
        i9 = i6;
        if (zzf(zzklVar, immutableMap, immutableMap2, immutableSet, cArr, i, i9, i8, i4, i5, str, str2, str3, z, z2) != com.google.android.gms.internal.measurement.zzkm.PURPOSE_RESTRICTION_NOT_ALLOWED) {
        }
        return zze <= 0 ? false : false;
    }

    private static final int zze(com.google.android.gms.internal.measurement.zzkl zzklVar, ImmutableMap immutableMap, ImmutableMap immutableMap2, ImmutableSet immutableSet, char[] cArr, int i, int i2, int i3, int i4, int i5, String str, String str2, String str3, boolean z, boolean z2) {
        if (zzklVar == com.google.android.gms.internal.measurement.zzkl.IAB_TCF_PURPOSE_STORE_AND_ACCESS_INFORMATION_ON_A_DEVICE) {
            return 1;
        }
        if (zzklVar == com.google.android.gms.internal.measurement.zzkl.IAB_TCF_PURPOSE_CREATE_A_PERSONALISED_ADS_PROFILE) {
            return 2;
        }
        if (zzklVar == com.google.android.gms.internal.measurement.zzkl.IAB_TCF_PURPOSE_SELECT_PERSONALISED_ADS) {
            return 3;
        }
        return zzklVar == com.google.android.gms.internal.measurement.zzkl.IAB_TCF_PURPOSE_MEASURE_AD_PERFORMANCE ? 4 : -1;
    }

    private static final com.google.android.gms.internal.measurement.zzkm zzf(com.google.android.gms.internal.measurement.zzkl zzklVar, ImmutableMap immutableMap, ImmutableMap immutableMap2, ImmutableSet immutableSet, char[] cArr, int i, int i2, int i3, int i4, int i5, String str, String str2, String str3, boolean z, boolean z2) {
        return (com.google.android.gms.internal.measurement.zzkm) immutableMap2.getOrDefault(zzklVar, com.google.android.gms.internal.measurement.zzkm.PURPOSE_RESTRICTION_UNDEFINED);
    }

    private static final String zzg(com.google.android.gms.internal.measurement.zzkl zzklVar, ImmutableMap immutableMap, ImmutableMap immutableMap2, ImmutableSet immutableSet, char[] cArr, int i, int i2, int i3, int i4, int i5, String str, String str2, String str3, boolean z, boolean z2) {
        boolean isEmpty = TextUtils.isEmpty(str2);
        String str4 = SessionDescription.SUPPORTED_SDP_VERSION;
        String valueOf = (isEmpty || str2.length() < zzklVar.zza()) ? SessionDescription.SUPPORTED_SDP_VERSION : String.valueOf(str2.charAt(zzklVar.zza() - 1));
        if (!TextUtils.isEmpty(str3) && str3.length() >= zzklVar.zza()) {
            str4 = String.valueOf(str3.charAt(zzklVar.zza() - 1));
        }
        return String.valueOf(valueOf).concat(String.valueOf(str4));
    }

    private static final boolean zzh(com.google.android.gms.internal.measurement.zzkl zzklVar, ImmutableMap immutableMap, ImmutableMap immutableMap2, ImmutableSet immutableSet, char[] cArr, int i, int i2, int i3, int i4, int i5, String str, String str2, String str3, boolean z, boolean z2) {
        char c;
        int zze = zze(zzklVar, immutableMap, immutableMap2, immutableSet, cArr, i, i2, i3, i4, i5, str, str2, str3, z, z2);
        if (!z) {
            c = '4';
        } else {
            if (str2.length() >= zzklVar.zza()) {
                char charAt = str2.charAt(zzklVar.zza() - 1);
                boolean z3 = charAt == '1';
                if (zze > 0 && cArr[zze] != '2') {
                    cArr[zze] = charAt != '1' ? '6' : '1';
                }
                return z3;
            }
            c = '0';
        }
        if (zze > 0 && cArr[zze] != '2') {
            cArr[zze] = c;
        }
        return false;
    }

    private static final boolean zzi(com.google.android.gms.internal.measurement.zzkl zzklVar, ImmutableMap immutableMap, ImmutableMap immutableMap2, ImmutableSet immutableSet, char[] cArr, int i, int i2, int i3, int i4, int i5, String str, String str2, String str3, boolean z, boolean z2) {
        char c;
        int zze = zze(zzklVar, immutableMap, immutableMap2, immutableSet, cArr, i, i2, i3, i4, i5, str, str2, str3, z, z2);
        if (!z2) {
            c = '5';
        } else {
            if (str3.length() >= zzklVar.zza()) {
                char charAt = str3.charAt(zzklVar.zza() - 1);
                boolean z3 = charAt == '1';
                if (zze > 0 && cArr[zze] != '2') {
                    cArr[zze] = charAt != '1' ? '7' : '1';
                }
                return z3;
            }
            c = '0';
        }
        if (zze > 0 && cArr[zze] != '2') {
            cArr[zze] = c;
        }
        return false;
    }
}
