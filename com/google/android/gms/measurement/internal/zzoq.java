package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.media3.exoplayer.rtsp.SessionDescription;
import androidx.media3.extractor.metadata.icy.IcyHeaders;
import com.google.android.gms.common.internal.Preconditions;
import com.google.common.collect.ImmutableList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.4.0 */
/* loaded from: classes3.dex */
public final class zzoq {
    private final Map zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzoq(Map map) {
        HashMap hashMap = new HashMap();
        this.zza = hashMap;
        hashMap.putAll(map);
    }

    private final int zzf() {
        try {
            String str = (String) this.zza.get("PolicyVersion");
            if (TextUtils.isEmpty(str)) {
                return -1;
            }
            return Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    private final Bundle zzg() {
        int zzf;
        Map map = this.zza;
        if (IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE.equals(map.get("GoogleConsent")) && (zzf = zzf()) >= 0) {
            String str = (String) map.get("PurposeConsents");
            if (!TextUtils.isEmpty(str)) {
                Bundle bundle = new Bundle();
                if (str.length() > 0) {
                    bundle.putString(zzjw.AD_STORAGE.zze, str.charAt(0) == '1' ? "granted" : "denied");
                }
                if (str.length() > 3) {
                    bundle.putString(zzjw.AD_PERSONALIZATION.zze, (str.charAt(2) == '1' && str.charAt(3) == '1') ? "granted" : "denied");
                }
                if (str.length() > 6 && zzf >= 4) {
                    bundle.putString(zzjw.AD_USER_DATA.zze, (str.charAt(0) == '1' && str.charAt(6) == '1') ? "granted" : "denied");
                }
                return bundle;
            }
        }
        return Bundle.EMPTY;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzoq) {
            return zze().equalsIgnoreCase(((zzoq) obj).zze());
        }
        return false;
    }

    public final int hashCode() {
        return zze().hashCode();
    }

    public final String toString() {
        return zze();
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0062, code lost:
    
        if (r0.get("Version") != null) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0068, code lost:
    
        return zzg();
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x006d, code lost:
    
        if (zzf() >= 0) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0071, code lost:
    
        r1 = new android.os.Bundle();
        r2 = com.google.android.gms.measurement.internal.zzjw.AD_STORAGE.zze;
        r6 = "denied";
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0089, code lost:
    
        if (true == java.util.Objects.equals(r0.get("AuthorizePurpose1"), androidx.media3.extractor.metadata.icy.IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE)) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x008b, code lost:
    
        r4 = "denied";
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x008e, code lost:
    
        r1.putString(r2, r4);
        r2 = com.google.android.gms.measurement.internal.zzjw.AD_PERSONALIZATION.zze;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x009f, code lost:
    
        if (java.util.Objects.equals(r0.get("AuthorizePurpose3"), androidx.media3.extractor.metadata.icy.IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE) == false) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x00ab, code lost:
    
        if (java.util.Objects.equals(r0.get("AuthorizePurpose4"), androidx.media3.extractor.metadata.icy.IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE) == false) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x00ad, code lost:
    
        r4 = "granted";
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x00b0, code lost:
    
        r1.putString(r2, r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x00b8, code lost:
    
        if (zzf() < 4) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00ba, code lost:
    
        r2 = com.google.android.gms.measurement.internal.zzjw.AD_USER_DATA.zze;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00c6, code lost:
    
        if (java.util.Objects.equals(r0.get("AuthorizePurpose1"), androidx.media3.extractor.metadata.icy.IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE) == false) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00d2, code lost:
    
        if (java.util.Objects.equals(r0.get("AuthorizePurpose7"), androidx.media3.extractor.metadata.icy.IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE) == false) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00d4, code lost:
    
        r6 = "granted";
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00d5, code lost:
    
        r1.putString(r2, r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00d8, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00af, code lost:
    
        r4 = "denied";
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x008d, code lost:
    
        r4 = "granted";
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00dd, code lost:
    
        return zzg();
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x004c, code lost:
    
        if (androidx.media3.extractor.metadata.icy.IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE.equals(r2.get("EnableAdvertiserConsentMode")) != false) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0029, code lost:
    
        if (androidx.media3.extractor.metadata.icy.IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE.equals(r2.get("EnableAdvertiserConsentMode")) != false) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0058, code lost:
    
        if (((java.lang.Boolean) r0.zza(null)).booleanValue() == false) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x005a, code lost:
    
        r0 = r9.zza;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Bundle zza() {
        zzgg zzggVar = zzgi.zzbj;
        if (((Boolean) zzggVar.zza(null)).booleanValue()) {
            Map map = this.zza;
            if (IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE.equals(map.get("gdprApplies"))) {
            }
            return Bundle.EMPTY;
        }
        Map map2 = this.zza;
        if (IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE.equals(map2.get("GoogleConsent"))) {
            if (IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE.equals(map2.get("gdprApplies"))) {
            }
        }
        return Bundle.EMPTY;
    }

    public final String zzb() {
        String str = (String) this.zza.get("PurposeDiagnostics");
        return TextUtils.isEmpty(str) ? "200000" : str;
    }

    public final String zzc(zzoq zzoqVar) {
        Map map = zzoqVar.zza;
        boolean isEmpty = map.isEmpty();
        String str = IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE;
        String str2 = (isEmpty || ((String) map.get("Version")) != null) ? SessionDescription.SUPPORTED_SDP_VERSION : IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE;
        Bundle zza = zza();
        Bundle zza2 = zzoqVar.zza();
        if (zza.size() == zza2.size() && Objects.equals(zza.getString("ad_storage"), zza2.getString("ad_storage")) && Objects.equals(zza.getString("ad_personalization"), zza2.getString("ad_personalization")) && Objects.equals(zza.getString("ad_user_data"), zza2.getString("ad_user_data"))) {
            str = SessionDescription.SUPPORTED_SDP_VERSION;
        }
        return str2.concat(str);
    }

    public final String zzd() {
        StringBuilder sb = new StringBuilder(IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE);
        int i = -1;
        try {
            String str = (String) this.zza.get("CmpSdkID");
            if (!TextUtils.isEmpty(str)) {
                i = Integer.parseInt(str);
            }
        } catch (NumberFormatException unused) {
        }
        if (i < 0 || i > 4095) {
            sb.append("00");
        } else {
            sb.append("0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-_".charAt(i >> 6));
            sb.append("0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-_".charAt(i & 63));
        }
        int zzf = zzf();
        if (zzf < 0 || zzf > 63) {
            sb.append(SessionDescription.SUPPORTED_SDP_VERSION);
        } else {
            sb.append("0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-_".charAt(zzf));
        }
        Preconditions.checkArgument(true);
        Map map = this.zza;
        int i2 = true != IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE.equals(map.get("gdprApplies")) ? 0 : 2;
        boolean equals = IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE.equals(map.get("EnableAdvertiserConsentMode"));
        int i3 = i2 | 4;
        if (equals) {
            i3 = i2 | 12;
        }
        sb.append("0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-_".charAt(i3));
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public final String zze() {
        StringBuilder sb = new StringBuilder();
        ImmutableList immutableList = zzot.zza;
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            String str = (String) immutableList.get(i);
            Map map = this.zza;
            if (map.containsKey(str)) {
                if (sb.length() > 0) {
                    sb.append(";");
                }
                sb.append(str);
                sb.append("=");
                sb.append((String) map.get(str));
            }
        }
        return sb.toString();
    }
}
