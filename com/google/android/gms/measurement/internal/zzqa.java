package com.google.android.gms.measurement.internal;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.media3.exoplayer.rtsp.SessionDescription;
import androidx.media3.extractor.metadata.icy.IcyHeaders;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.internal.measurement.zzqr;
import com.google.android.gms.internal.measurement.zzrd;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.zip.GZIPOutputStream;
import org.apache.commons.io.IOUtils;

/* compiled from: com.google.android.gms:play-services-measurement@@22.4.0 */
/* loaded from: classes3.dex */
public final class zzqa extends zzpg {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzqa(zzpv zzpvVar) {
        super(zzpvVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean zzA(String str) {
        return str != null && str.matches("([+-])?([0-9]+\\.?[0-9]*|[0-9]*\\.?[0-9]+)") && str.length() <= 310;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Bundle[] zzC(List list) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            com.google.android.gms.internal.measurement.zzhq zzhqVar = (com.google.android.gms.internal.measurement.zzhq) it.next();
            if (zzhqVar != null) {
                Bundle bundle = new Bundle();
                for (com.google.android.gms.internal.measurement.zzhq zzhqVar2 : zzhqVar.zzi()) {
                    if (zzhqVar2.zzy()) {
                        bundle.putString(zzhqVar2.zzg(), zzhqVar2.zzh());
                    } else if (zzhqVar2.zzw()) {
                        bundle.putLong(zzhqVar2.zzg(), zzhqVar2.zzd());
                    } else if (zzhqVar2.zzu()) {
                        bundle.putDouble(zzhqVar2.zzg(), zzhqVar2.zza());
                    }
                }
                if (!bundle.isEmpty()) {
                    arrayList.add(bundle);
                }
            }
        }
        return (Bundle[]) arrayList.toArray(new Bundle[arrayList.size()]);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void zzD(com.google.android.gms.internal.measurement.zzhl zzhlVar, String str, Object obj) {
        List zzp = zzhlVar.zzp();
        int i = 0;
        while (true) {
            if (i >= zzp.size()) {
                i = -1;
                break;
            } else if (str.equals(((com.google.android.gms.internal.measurement.zzhq) zzp.get(i)).zzg())) {
                break;
            } else {
                i++;
            }
        }
        com.google.android.gms.internal.measurement.zzhp zze = com.google.android.gms.internal.measurement.zzhq.zze();
        zze.zzj(str);
        zze.zzi(((Long) obj).longValue());
        if (i >= 0) {
            zzhlVar.zzj(i, zze);
        } else {
            zzhlVar.zze(zze);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final boolean zzE(zzbh zzbhVar, zzr zzrVar) {
        Preconditions.checkNotNull(zzbhVar);
        Preconditions.checkNotNull(zzrVar);
        return (TextUtils.isEmpty(zzrVar.zzb) && TextUtils.isEmpty(zzrVar.zzp)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Bundle zzF(List list) {
        Bundle bundle = new Bundle();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            com.google.android.gms.internal.measurement.zzhq zzhqVar = (com.google.android.gms.internal.measurement.zzhq) it.next();
            String zzg = zzhqVar.zzg();
            if (zzhqVar.zzu()) {
                bundle.putDouble(zzg, zzhqVar.zza());
            } else if (zzhqVar.zzv()) {
                bundle.putFloat(zzg, zzhqVar.zzb());
            } else if (zzhqVar.zzy()) {
                bundle.putString(zzg, zzhqVar.zzh());
            } else if (zzhqVar.zzw()) {
                bundle.putLong(zzg, zzhqVar.zzd());
            }
        }
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final com.google.android.gms.internal.measurement.zzhq zzG(com.google.android.gms.internal.measurement.zzhm zzhmVar, String str) {
        for (com.google.android.gms.internal.measurement.zzhq zzhqVar : zzhmVar.zzi()) {
            if (zzhqVar.zzg().equals(str)) {
                return zzhqVar;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Object zzH(com.google.android.gms.internal.measurement.zzhm zzhmVar, String str) {
        com.google.android.gms.internal.measurement.zzhq zzG = zzG(zzhmVar, str);
        if (zzG == null) {
            return null;
        }
        if (zzG.zzy()) {
            return zzG.zzh();
        }
        if (zzG.zzw()) {
            return Long.valueOf(zzG.zzd());
        }
        if (zzG.zzu()) {
            return Double.valueOf(zzG.zza());
        }
        if (zzG.zzc() > 0) {
            return zzC(zzG.zzi());
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Object zzI(com.google.android.gms.internal.measurement.zzhm zzhmVar, String str, Object obj) {
        Object zzH = zzH(zzhmVar, str);
        return zzH == null ? obj : zzH;
    }

    private final void zzJ(StringBuilder sb, int i, List list) {
        if (list == null) {
            return;
        }
        int i2 = i + 1;
        Iterator it = list.iterator();
        while (it.hasNext()) {
            com.google.android.gms.internal.measurement.zzhq zzhqVar = (com.google.android.gms.internal.measurement.zzhq) it.next();
            if (zzhqVar != null) {
                zzL(sb, i2);
                sb.append("param {\n");
                zzQ(sb, i2, "name", zzhqVar.zzx() ? this.zzu.zzj().zze(zzhqVar.zzg()) : null);
                zzQ(sb, i2, "string_value", zzhqVar.zzy() ? zzhqVar.zzh() : null);
                zzQ(sb, i2, "int_value", zzhqVar.zzw() ? Long.valueOf(zzhqVar.zzd()) : null);
                zzQ(sb, i2, "double_value", zzhqVar.zzu() ? Double.valueOf(zzhqVar.zza()) : null);
                if (zzhqVar.zzc() > 0) {
                    zzJ(sb, i2, zzhqVar.zzi());
                }
                zzL(sb, i2);
                sb.append("}\n");
            }
        }
    }

    private final void zzK(StringBuilder sb, int i, com.google.android.gms.internal.measurement.zzfl zzflVar) {
        String str;
        if (zzflVar == null) {
            return;
        }
        zzL(sb, i);
        sb.append("filter {\n");
        if (zzflVar.zzh()) {
            zzQ(sb, i, "complement", Boolean.valueOf(zzflVar.zzg()));
        }
        if (zzflVar.zzj()) {
            zzQ(sb, i, "param_name", this.zzu.zzj().zze(zzflVar.zze()));
        }
        if (zzflVar.zzk()) {
            int i2 = i + 1;
            com.google.android.gms.internal.measurement.zzfv zzd = zzflVar.zzd();
            if (zzd != null) {
                zzL(sb, i2);
                sb.append("string_filter {\n");
                if (zzd.zzi()) {
                    switch (zzd.zzj()) {
                        case 1:
                            str = "UNKNOWN_MATCH_TYPE";
                            break;
                        case 2:
                            str = "REGEXP";
                            break;
                        case 3:
                            str = "BEGINS_WITH";
                            break;
                        case 4:
                            str = "ENDS_WITH";
                            break;
                        case 5:
                            str = "PARTIAL";
                            break;
                        case 6:
                            str = "EXACT";
                            break;
                        default:
                            str = "IN_LIST";
                            break;
                    }
                    zzQ(sb, i2, "match_type", str);
                }
                if (zzd.zzh()) {
                    zzQ(sb, i2, "expression", zzd.zzd());
                }
                if (zzd.zzg()) {
                    zzQ(sb, i2, "case_sensitive", Boolean.valueOf(zzd.zzf()));
                }
                if (zzd.zza() > 0) {
                    zzL(sb, i + 2);
                    sb.append("expression_list {\n");
                    for (String str2 : zzd.zze()) {
                        zzL(sb, i + 3);
                        sb.append(str2);
                        sb.append(IOUtils.LINE_SEPARATOR_UNIX);
                    }
                    sb.append("}\n");
                }
                zzL(sb, i2);
                sb.append("}\n");
            }
        }
        if (zzflVar.zzi()) {
            zzR(sb, i + 1, "number_filter", zzflVar.zzc());
        }
        zzL(sb, i);
        sb.append("}\n");
    }

    private static final void zzL(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            sb.append("  ");
        }
    }

    private static final void zzM(Uri.Builder builder, String str, String str2, Set set) {
        if (set.contains(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        builder.appendQueryParameter(str, str2);
    }

    private static final String zzN(boolean z, boolean z2, boolean z3) {
        StringBuilder sb = new StringBuilder();
        if (z) {
            sb.append("Dynamic ");
        }
        if (z2) {
            sb.append("Sequence ");
        }
        if (z3) {
            sb.append("Session-Scoped ");
        }
        return sb.toString();
    }

    private static final void zzO(Uri.Builder builder, String[] strArr, Bundle bundle, Set set) {
        for (String str : strArr) {
            String[] split = str.split(",");
            String str2 = split[0];
            String str3 = split[split.length - 1];
            String string = bundle.getString(str2);
            if (string != null) {
                zzM(builder, str3, string, set);
            }
        }
    }

    private static final void zzP(StringBuilder sb, int i, String str, com.google.android.gms.internal.measurement.zzic zzicVar) {
        if (zzicVar == null) {
            return;
        }
        zzL(sb, 3);
        sb.append(str);
        sb.append(" {\n");
        if (zzicVar.zzb() != 0) {
            zzL(sb, 4);
            sb.append("results: ");
            int i2 = 0;
            for (Long l : zzicVar.zzi()) {
                int i3 = i2 + 1;
                if (i2 != 0) {
                    sb.append(", ");
                }
                sb.append(l);
                i2 = i3;
            }
            sb.append('\n');
        }
        if (zzicVar.zzd() != 0) {
            zzL(sb, 4);
            sb.append("status: ");
            int i4 = 0;
            for (Long l2 : zzicVar.zzk()) {
                int i5 = i4 + 1;
                if (i4 != 0) {
                    sb.append(", ");
                }
                sb.append(l2);
                i4 = i5;
            }
            sb.append('\n');
        }
        if (zzicVar.zza() != 0) {
            zzL(sb, 4);
            sb.append("dynamic_filter_timestamps: {");
            int i6 = 0;
            for (com.google.android.gms.internal.measurement.zzhk zzhkVar : zzicVar.zzh()) {
                int i7 = i6 + 1;
                if (i6 != 0) {
                    sb.append(", ");
                }
                sb.append(zzhkVar.zzh() ? Integer.valueOf(zzhkVar.zza()) : null);
                sb.append(":");
                sb.append(zzhkVar.zzg() ? Long.valueOf(zzhkVar.zzb()) : null);
                i6 = i7;
            }
            sb.append("}\n");
        }
        if (zzicVar.zzc() != 0) {
            zzL(sb, 4);
            sb.append("sequence_filter_timestamps: {");
            int i8 = 0;
            for (com.google.android.gms.internal.measurement.zzie zzieVar : zzicVar.zzj()) {
                int i9 = i8 + 1;
                if (i8 != 0) {
                    sb.append(", ");
                }
                sb.append(zzieVar.zzi() ? Integer.valueOf(zzieVar.zzb()) : null);
                sb.append(": [");
                Iterator it = zzieVar.zzf().iterator();
                int i10 = 0;
                while (it.hasNext()) {
                    long longValue = ((Long) it.next()).longValue();
                    int i11 = i10 + 1;
                    if (i10 != 0) {
                        sb.append(", ");
                    }
                    sb.append(longValue);
                    i10 = i11;
                }
                sb.append("]");
                i8 = i9;
            }
            sb.append("}\n");
        }
        zzL(sb, 3);
        sb.append("}\n");
    }

    private static final void zzQ(StringBuilder sb, int i, String str, Object obj) {
        if (obj == null) {
            return;
        }
        zzL(sb, i + 1);
        sb.append(str);
        sb.append(": ");
        sb.append(obj);
        sb.append('\n');
    }

    private static final void zzR(StringBuilder sb, int i, String str, com.google.android.gms.internal.measurement.zzfp zzfpVar) {
        String str2;
        if (zzfpVar == null) {
            return;
        }
        zzL(sb, i);
        sb.append(str);
        sb.append(" {\n");
        if (zzfpVar.zzg()) {
            int zzm = zzfpVar.zzm();
            if (zzm == 1) {
                str2 = "UNKNOWN_COMPARISON_TYPE";
            } else if (zzm == 2) {
                str2 = "LESS_THAN";
            } else if (zzm != 3) {
                str2 = zzm != 4 ? "BETWEEN" : "EQUAL";
            } else {
                str2 = "GREATER_THAN";
            }
            zzQ(sb, i, "comparison_type", str2);
        }
        if (zzfpVar.zzi()) {
            zzQ(sb, i, "match_as_float", Boolean.valueOf(zzfpVar.zzf()));
        }
        if (zzfpVar.zzh()) {
            zzQ(sb, i, "comparison_value", zzfpVar.zzc());
        }
        if (zzfpVar.zzk()) {
            zzQ(sb, i, "min_comparison_value", zzfpVar.zze());
        }
        if (zzfpVar.zzj()) {
            zzQ(sb, i, "max_comparison_value", zzfpVar.zzd());
        }
        zzL(sb, i);
        sb.append("}\n");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zza(com.google.android.gms.internal.measurement.zzhw zzhwVar, String str) {
        for (int i = 0; i < zzhwVar.zzd(); i++) {
            if (str.equals(zzhwVar.zzaE(i).zzg())) {
                return i;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static com.google.android.gms.internal.measurement.zzng zzp(com.google.android.gms.internal.measurement.zzng zzngVar, byte[] bArr) throws com.google.android.gms.internal.measurement.zzmm {
        com.google.android.gms.internal.measurement.zzlp zza = com.google.android.gms.internal.measurement.zzlp.zza();
        if (zza != null) {
            return zzngVar.zzaV(bArr, zza);
        }
        return zzngVar.zzaU(bArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List zzu(BitSet bitSet) {
        int length = (bitSet.length() + 63) / 64;
        ArrayList arrayList = new ArrayList(length);
        for (int i = 0; i < length; i++) {
            long j = 0;
            for (int i2 = 0; i2 < 64; i2++) {
                int i3 = (i * 64) + i2;
                if (i3 >= bitSet.length()) {
                    break;
                }
                if (bitSet.get(i3)) {
                    j |= 1 << i2;
                }
            }
            arrayList.add(Long.valueOf(j));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean zzy(List list, int i) {
        if (i < list.size() * 64) {
            return ((1 << (i % 64)) & ((Long) list.get(i / 64)).longValue()) != 0;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final byte[] zzB(byte[] bArr) throws IOException {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.close();
            byteArrayOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            this.zzu.zzaW().zze().zzb("Failed to gzip content", e);
            throw e;
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzpg
    protected final boolean zzb() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final long zzd(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0L;
        }
        return zzf(str.getBytes(Charset.forName("UTF-8")));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final long zzf(byte[] bArr) {
        Preconditions.checkNotNull(bArr);
        zzio zzioVar = this.zzu;
        zzioVar.zzw().zzg();
        MessageDigest zzI = zzqf.zzI();
        if (zzI == null) {
            zzioVar.zzaW().zze().zza("Failed to get MD5");
            return 0L;
        }
        return zzqf.zzr(zzI.digest(bArr));
    }

    final Bundle zzh(Map map, boolean z) {
        Bundle bundle = new Bundle();
        for (String str : map.keySet()) {
            Object obj = map.get(str);
            if (obj == null) {
                bundle.putString(str, null);
            } else if (obj instanceof Long) {
                bundle.putLong(str, ((Long) obj).longValue());
            } else if (obj instanceof Double) {
                bundle.putDouble(str, ((Double) obj).doubleValue());
            } else if (!(obj instanceof ArrayList)) {
                bundle.putString(str, obj.toString());
            } else if (z) {
                ArrayList arrayList = (ArrayList) obj;
                ArrayList arrayList2 = new ArrayList();
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    arrayList2.add(zzh((Map) arrayList.get(i), false));
                }
                bundle.putParcelableArray(str, (Parcelable[]) arrayList2.toArray(new Parcelable[0]));
            }
        }
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Parcelable zzi(byte[] bArr, Parcelable.Creator creator) {
        Parcelable parcelable = null;
        if (bArr == null) {
            return null;
        }
        Parcel obtain = Parcel.obtain();
        try {
            try {
                obtain.unmarshall(bArr, 0, bArr.length);
                obtain.setDataPosition(0);
                parcelable = (Parcelable) creator.createFromParcel(obtain);
            } catch (SafeParcelReader.ParseException unused) {
                this.zzu.zzaW().zze().zza("Failed to load parcelable from buffer");
            }
            return parcelable;
        } finally {
            obtain.recycle();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzbh zzj(com.google.android.gms.internal.measurement.zzaa zzaaVar) {
        String str;
        Object obj;
        Bundle zzh = zzh(zzaaVar.zzf(), true);
        if (zzh.containsKey("_o") && (obj = zzh.get("_o")) != null) {
            str = obj.toString();
        } else {
            str = "app";
        }
        String str2 = str;
        String zzb = zzjy.zzb(zzaaVar.zze());
        if (zzb == null) {
            zzb = zzaaVar.zze();
        }
        return new zzbh(zzb, new zzbf(zzh), str2, zzaaVar.zza());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzov zzl(String str, com.google.android.gms.internal.measurement.zzhw zzhwVar, com.google.android.gms.internal.measurement.zzhl zzhlVar, String str2) {
        int indexOf;
        zzqr.zzb();
        zzio zzioVar = this.zzu;
        if (!zzioVar.zzf().zzx(str, zzgi.zzaV)) {
            return null;
        }
        long currentTimeMillis = zzioVar.zzaU().currentTimeMillis();
        String[] split = zzioVar.zzf().zzr(str, zzgi.zzat).split(",");
        HashSet hashSet = new HashSet(split.length);
        for (String str3 : split) {
            if (!hashSet.add(Objects.requireNonNull(str3))) {
                Objects.toString(str3);
                throw new IllegalArgumentException("duplicate element: ".concat(String.valueOf(str3)));
            }
        }
        Set unmodifiableSet = Collections.unmodifiableSet(hashSet);
        zzpv zzpvVar = this.zzg;
        zzpi zzy = zzpvVar.zzy();
        String zzm = zzy.zzg.zzr().zzm(str);
        Uri.Builder builder = new Uri.Builder();
        zzio zzioVar2 = zzy.zzu;
        builder.scheme(zzioVar2.zzf().zzr(str, zzgi.zzam));
        if (TextUtils.isEmpty(zzm)) {
            builder.authority(zzioVar2.zzf().zzr(str, zzgi.zzan));
        } else {
            builder.authority(zzm + "." + zzioVar2.zzf().zzr(str, zzgi.zzan));
        }
        builder.path(zzioVar2.zzf().zzr(str, zzgi.zzao));
        zzM(builder, "gmp_app_id", zzhwVar.zzaJ(), unmodifiableSet);
        zzioVar.zzf().zzj();
        zzM(builder, "gmp_version", String.valueOf(119002L), unmodifiableSet);
        String zzaG = zzhwVar.zzaG();
        zzam zzf = zzioVar.zzf();
        zzgg zzggVar = zzgi.zzaY;
        if (zzf.zzx(str, zzggVar) && zzpvVar.zzr().zzA(str)) {
            zzaG = "";
        }
        zzM(builder, "app_instance_id", zzaG, unmodifiableSet);
        zzM(builder, "rdid", zzhwVar.zzaL(), unmodifiableSet);
        zzM(builder, "bundle_id", zzhwVar.zzaF(), unmodifiableSet);
        String zzo = zzhlVar.zzo();
        String zza = zzjy.zza(zzo);
        if (true != TextUtils.isEmpty(zza)) {
            zzo = zza;
        }
        zzM(builder, "app_event_name", zzo, unmodifiableSet);
        zzM(builder, "app_version", String.valueOf(zzhwVar.zzb()), unmodifiableSet);
        String zzaK = zzhwVar.zzaK();
        if (zzioVar.zzf().zzx(str, zzggVar) && zzpvVar.zzr().zzE(str) && !TextUtils.isEmpty(zzaK) && (indexOf = zzaK.indexOf(".")) != -1) {
            zzaK = zzaK.substring(0, indexOf);
        }
        zzM(builder, "os_version", zzaK, unmodifiableSet);
        zzM(builder, "timestamp", String.valueOf(zzhlVar.zzc()), unmodifiableSet);
        boolean zzaP = zzhwVar.zzaP();
        String str4 = IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE;
        if (zzaP) {
            zzM(builder, "lat", IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE, unmodifiableSet);
        }
        zzM(builder, "privacy_sandbox_version", String.valueOf(zzhwVar.zza()), unmodifiableSet);
        zzM(builder, "trigger_uri_source", IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE, unmodifiableSet);
        zzM(builder, "trigger_uri_timestamp", String.valueOf(currentTimeMillis), unmodifiableSet);
        zzM(builder, "request_uuid", str2, unmodifiableSet);
        List<com.google.android.gms.internal.measurement.zzhq> zzp = zzhlVar.zzp();
        Bundle bundle = new Bundle();
        for (com.google.android.gms.internal.measurement.zzhq zzhqVar : zzp) {
            String zzg = zzhqVar.zzg();
            if (zzhqVar.zzu()) {
                bundle.putString(zzg, String.valueOf(zzhqVar.zza()));
            } else if (zzhqVar.zzv()) {
                bundle.putString(zzg, String.valueOf(zzhqVar.zzb()));
            } else if (zzhqVar.zzy()) {
                bundle.putString(zzg, zzhqVar.zzh());
            } else if (zzhqVar.zzw()) {
                bundle.putString(zzg, String.valueOf(zzhqVar.zzd()));
            }
        }
        zzO(builder, zzioVar.zzf().zzr(str, zzgi.zzas).split("\\|"), bundle, unmodifiableSet);
        List<com.google.android.gms.internal.measurement.zzio> zzaN = zzhwVar.zzaN();
        Bundle bundle2 = new Bundle();
        for (com.google.android.gms.internal.measurement.zzio zzioVar3 : zzaN) {
            String zzg2 = zzioVar3.zzg();
            if (zzioVar3.zzr()) {
                bundle2.putString(zzg2, String.valueOf(zzioVar3.zza()));
            } else if (zzioVar3.zzs()) {
                bundle2.putString(zzg2, String.valueOf(zzioVar3.zzb()));
            } else if (zzioVar3.zzv()) {
                bundle2.putString(zzg2, zzioVar3.zzh());
            } else if (zzioVar3.zzt()) {
                bundle2.putString(zzg2, String.valueOf(zzioVar3.zzc()));
            }
        }
        zzO(builder, zzioVar.zzf().zzr(str, zzgi.zzar).split("\\|"), bundle2, unmodifiableSet);
        if (true != zzhwVar.zzaO()) {
            str4 = SessionDescription.SUPPORTED_SDP_VERSION;
        }
        zzM(builder, "dma", str4, unmodifiableSet);
        if (!zzhwVar.zzaI().isEmpty()) {
            zzM(builder, "dma_cps", zzhwVar.zzaI(), unmodifiableSet);
        }
        if (zzhwVar.zzaQ()) {
            com.google.android.gms.internal.measurement.zzhc zzg3 = zzhwVar.zzg();
            if (!zzg3.zzh().isEmpty()) {
                zzM(builder, "dl_gclid", zzg3.zzh(), unmodifiableSet);
            }
            if (!zzg3.zzg().isEmpty()) {
                zzM(builder, "dl_gbraid", zzg3.zzg(), unmodifiableSet);
            }
            if (!zzg3.zzf().isEmpty()) {
                zzM(builder, "dl_gs", zzg3.zzf(), unmodifiableSet);
            }
            if (zzg3.zza() > 0) {
                zzM(builder, "dl_ss_ts", String.valueOf(zzg3.zza()), unmodifiableSet);
            }
            if (!zzg3.zzk().isEmpty()) {
                zzM(builder, "mr_gclid", zzg3.zzk(), unmodifiableSet);
            }
            if (!zzg3.zzj().isEmpty()) {
                zzM(builder, "mr_gbraid", zzg3.zzj(), unmodifiableSet);
            }
            if (!zzg3.zzi().isEmpty()) {
                zzM(builder, "mr_gs", zzg3.zzi(), unmodifiableSet);
            }
            if (zzg3.zzb() > 0) {
                zzM(builder, "mr_click_ts", String.valueOf(zzg3.zzb()), unmodifiableSet);
            }
        }
        return new zzov(builder.build().toString(), currentTimeMillis, 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final com.google.android.gms.internal.measurement.zzhm zzm(zzbc zzbcVar) {
        com.google.android.gms.internal.measurement.zzhl zze = com.google.android.gms.internal.measurement.zzhm.zze();
        zze.zzl(zzbcVar.zze);
        zzbf zzbfVar = zzbcVar.zzf;
        zzbe zzbeVar = new zzbe(zzbfVar);
        while (zzbeVar.hasNext()) {
            String next = zzbeVar.next();
            com.google.android.gms.internal.measurement.zzhp zze2 = com.google.android.gms.internal.measurement.zzhq.zze();
            zze2.zzj(next);
            Object zzf = zzbfVar.zzf(next);
            Preconditions.checkNotNull(zzf);
            zzw(zze2, zzf);
            zze.zze(zze2);
        }
        String str = zzbcVar.zzc;
        if (!TextUtils.isEmpty(str) && zzbfVar.zzf("_o") == null) {
            com.google.android.gms.internal.measurement.zzhp zze3 = com.google.android.gms.internal.measurement.zzhq.zze();
            zze3.zzj("_o");
            zze3.zzk(str);
            zze.zzf((com.google.android.gms.internal.measurement.zzhq) zze3.zzba());
        }
        return (com.google.android.gms.internal.measurement.zzhm) zze.zzba();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String zzq(com.google.android.gms.internal.measurement.zzhv zzhvVar) {
        com.google.android.gms.internal.measurement.zzhg zzx;
        if (zzhvVar == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("\nbatch {\n");
        if (zzhvVar.zzq()) {
            zzQ(sb, 0, "upload_subdomain", zzhvVar.zzg());
        }
        if (zzhvVar.zzp()) {
            zzQ(sb, 0, "sgtm_join_id", zzhvVar.zzf());
        }
        for (com.google.android.gms.internal.measurement.zzhx zzhxVar : zzhvVar.zzh()) {
            if (zzhxVar != null) {
                zzL(sb, 1);
                sb.append("bundle {\n");
                if (zzhxVar.zzbQ()) {
                    zzQ(sb, 1, "protocol_version", Integer.valueOf(zzhxVar.zzf()));
                }
                zzrd.zzb();
                zzio zzioVar = this.zzu;
                if (zzioVar.zzf().zzx(zzhxVar.zzF(), zzgi.zzaL) && zzhxVar.zzbT()) {
                    zzQ(sb, 1, "session_stitching_token", zzhxVar.zzU());
                }
                zzQ(sb, 1, "platform", zzhxVar.zzS());
                if (zzhxVar.zzbL()) {
                    zzQ(sb, 1, "gmp_version", Long.valueOf(zzhxVar.zzp()));
                }
                if (zzhxVar.zzbZ()) {
                    zzQ(sb, 1, "uploading_gmp_version", Long.valueOf(zzhxVar.zzv()));
                }
                if (zzhxVar.zzbJ()) {
                    zzQ(sb, 1, "dynamite_version", Long.valueOf(zzhxVar.zzn()));
                }
                if (zzhxVar.zzbC()) {
                    zzQ(sb, 1, "config_version", Long.valueOf(zzhxVar.zzk()));
                }
                zzQ(sb, 1, "gmp_app_id", zzhxVar.zzP());
                zzQ(sb, 1, "admob_app_id", zzhxVar.zzE());
                zzQ(sb, 1, "app_id", zzhxVar.zzF());
                zzQ(sb, 1, "app_version", zzhxVar.zzI());
                if (zzhxVar.zzby()) {
                    zzQ(sb, 1, "app_version_major", Integer.valueOf(zzhxVar.zzb()));
                }
                zzQ(sb, 1, "firebase_instance_id", zzhxVar.zzO());
                if (zzhxVar.zzbH()) {
                    zzQ(sb, 1, "dev_cert_hash", Long.valueOf(zzhxVar.zzm()));
                }
                zzQ(sb, 1, "app_store", zzhxVar.zzH());
                if (zzhxVar.zzbY()) {
                    zzQ(sb, 1, "upload_timestamp_millis", Long.valueOf(zzhxVar.zzu()));
                }
                if (zzhxVar.zzbV()) {
                    zzQ(sb, 1, "start_timestamp_millis", Long.valueOf(zzhxVar.zzs()));
                }
                if (zzhxVar.zzbK()) {
                    zzQ(sb, 1, "end_timestamp_millis", Long.valueOf(zzhxVar.zzo()));
                }
                if (zzhxVar.zzbP()) {
                    zzQ(sb, 1, "previous_bundle_start_timestamp_millis", Long.valueOf(zzhxVar.zzr()));
                }
                if (zzhxVar.zzbO()) {
                    zzQ(sb, 1, "previous_bundle_end_timestamp_millis", Long.valueOf(zzhxVar.zzq()));
                }
                zzQ(sb, 1, "app_instance_id", zzhxVar.zzG());
                zzQ(sb, 1, "resettable_device_id", zzhxVar.zzT());
                zzQ(sb, 1, "ds_id", zzhxVar.zzN());
                if (zzhxVar.zzbN()) {
                    zzQ(sb, 1, "limited_ad_tracking", Boolean.valueOf(zzhxVar.zzbv()));
                }
                zzQ(sb, 1, "os_version", zzhxVar.zzR());
                zzQ(sb, 1, "device_model", zzhxVar.zzM());
                zzQ(sb, 1, "user_default_language", zzhxVar.zzV());
                if (zzhxVar.zzbX()) {
                    zzQ(sb, 1, "time_zone_offset_minutes", Integer.valueOf(zzhxVar.zzh()));
                }
                if (zzhxVar.zzbB()) {
                    zzQ(sb, 1, "bundle_sequential_index", Integer.valueOf(zzhxVar.zzc()));
                }
                if (zzhxVar.zzbG()) {
                    zzQ(sb, 1, "delivery_index", Integer.valueOf(zzhxVar.zzd()));
                }
                if (zzhxVar.zzbS()) {
                    zzQ(sb, 1, "service_upload", Boolean.valueOf(zzhxVar.zzbw()));
                }
                zzQ(sb, 1, "health_monitor", zzhxVar.zzQ());
                if (zzhxVar.zzbR()) {
                    zzQ(sb, 1, "retry_counter", Integer.valueOf(zzhxVar.zzg()));
                }
                if (zzhxVar.zzbE()) {
                    zzQ(sb, 1, "consent_signals", zzhxVar.zzK());
                }
                if (zzhxVar.zzbM()) {
                    zzQ(sb, 1, "is_dma_region", Boolean.valueOf(zzhxVar.zzbu()));
                }
                if (zzhxVar.zzbF()) {
                    zzQ(sb, 1, "core_platform_services", zzhxVar.zzL());
                }
                if (zzhxVar.zzbD()) {
                    zzQ(sb, 1, "consent_diagnostics", zzhxVar.zzJ());
                }
                if (zzhxVar.zzbW()) {
                    zzQ(sb, 1, "target_os_version", Long.valueOf(zzhxVar.zzt()));
                }
                zzqr.zzb();
                if (zzioVar.zzf().zzx(zzhxVar.zzF(), zzgi.zzaV)) {
                    zzQ(sb, 1, "ad_services_version", Integer.valueOf(zzhxVar.zza()));
                    if (zzhxVar.zzbz() && (zzx = zzhxVar.zzx()) != null) {
                        zzL(sb, 2);
                        sb.append("attribution_eligibility_status {\n");
                        zzQ(sb, 2, "eligible", Boolean.valueOf(zzx.zzn()));
                        zzQ(sb, 2, "no_access_adservices_attribution_permission", Boolean.valueOf(zzx.zzp()));
                        zzQ(sb, 2, "pre_r", Boolean.valueOf(zzx.zzq()));
                        zzQ(sb, 2, "r_extensions_too_old", Boolean.valueOf(zzx.zzr()));
                        zzQ(sb, 2, "adservices_extension_too_old", Boolean.valueOf(zzx.zzm()));
                        zzQ(sb, 2, "ad_storage_not_allowed", Boolean.valueOf(zzx.zzk()));
                        zzQ(sb, 2, "measurement_manager_disabled", Boolean.valueOf(zzx.zzo()));
                        zzL(sb, 2);
                        sb.append("}\n");
                    }
                }
                if (zzhxVar.zzbx()) {
                    com.google.android.gms.internal.measurement.zzhc zzw = zzhxVar.zzw();
                    zzL(sb, 2);
                    sb.append("ad_campaign_info {\n");
                    if (zzw.zzC()) {
                        zzQ(sb, 2, "deep_link_gclid", zzw.zzh());
                    }
                    if (zzw.zzB()) {
                        zzQ(sb, 2, "deep_link_gbraid", zzw.zzg());
                    }
                    if (zzw.zzA()) {
                        zzQ(sb, 2, "deep_link_gad_source", zzw.zzf());
                    }
                    if (zzw.zzD()) {
                        zzQ(sb, 2, "deep_link_session_millis", Long.valueOf(zzw.zza()));
                    }
                    if (zzw.zzH()) {
                        zzQ(sb, 2, "market_referrer_gclid", zzw.zzk());
                    }
                    if (zzw.zzG()) {
                        zzQ(sb, 2, "market_referrer_gbraid", zzw.zzj());
                    }
                    if (zzw.zzF()) {
                        zzQ(sb, 2, "market_referrer_gad_source", zzw.zzi());
                    }
                    if (zzw.zzE()) {
                        zzQ(sb, 2, "market_referrer_click_millis", Long.valueOf(zzw.zzb()));
                    }
                    zzL(sb, 2);
                    sb.append("}\n");
                }
                if (zzhxVar.zzbA()) {
                    zzQ(sb, 1, "batching_timestamp_millis", Long.valueOf(zzhxVar.zzj()));
                }
                if (zzhxVar.zzbU()) {
                    com.google.android.gms.internal.measurement.zzim zzC = zzhxVar.zzC();
                    zzL(sb, 2);
                    sb.append("sgtm_diagnostics {\n");
                    int zzg = zzC.zzg();
                    zzQ(sb, 2, "upload_type", zzg != 1 ? zzg != 2 ? zzg != 3 ? zzg != 4 ? "SDK_SERVICE_UPLOAD" : "PACKAGE_SERVICE_UPLOAD" : "SDK_CLIENT_UPLOAD" : "GA_UPLOAD" : "UPLOAD_TYPE_UNKNOWN");
                    zzQ(sb, 2, "client_upload_eligibility", zzC.zzb().name());
                    int zzf = zzC.zzf();
                    zzQ(sb, 2, "service_upload_eligibility", zzf != 1 ? zzf != 2 ? zzf != 3 ? zzf != 4 ? zzf != 5 ? "NON_PLAY_MISSING_SGTM_SERVER_URL" : "MISSING_SGTM_PROXY_INFO" : "MISSING_SGTM_SETTINGS" : "NOT_IN_ROLLOUT" : "SERVICE_UPLOAD_ELIGIBLE" : "SERVICE_UPLOAD_ELIGIBILITY_UNKNOWN");
                    zzL(sb, 2);
                    sb.append("}\n");
                }
                List<com.google.android.gms.internal.measurement.zzio> zzY = zzhxVar.zzY();
                if (zzY != null) {
                    for (com.google.android.gms.internal.measurement.zzio zzioVar2 : zzY) {
                        if (zzioVar2 != null) {
                            zzL(sb, 2);
                            sb.append("user_property {\n");
                            zzQ(sb, 2, "set_timestamp_millis", zzioVar2.zzu() ? Long.valueOf(zzioVar2.zzd()) : null);
                            zzQ(sb, 2, "name", zzioVar.zzj().zzf(zzioVar2.zzg()));
                            zzQ(sb, 2, "string_value", zzioVar2.zzh());
                            zzQ(sb, 2, "int_value", zzioVar2.zzt() ? Long.valueOf(zzioVar2.zzc()) : null);
                            zzQ(sb, 2, "double_value", zzioVar2.zzr() ? Double.valueOf(zzioVar2.zza()) : null);
                            zzL(sb, 2);
                            sb.append("}\n");
                        }
                    }
                }
                List<com.google.android.gms.internal.measurement.zzhi> zzW = zzhxVar.zzW();
                if (zzW != null) {
                    for (com.google.android.gms.internal.measurement.zzhi zzhiVar : zzW) {
                        if (zzhiVar != null) {
                            zzL(sb, 2);
                            sb.append("audience_membership {\n");
                            if (zzhiVar.zzk()) {
                                zzQ(sb, 2, "audience_id", Integer.valueOf(zzhiVar.zza()));
                            }
                            if (zzhiVar.zzm()) {
                                zzQ(sb, 2, "new_audience", Boolean.valueOf(zzhiVar.zzj()));
                            }
                            zzP(sb, 2, "current_data", zzhiVar.zzd());
                            if (zzhiVar.zzn()) {
                                zzP(sb, 2, "previous_data", zzhiVar.zze());
                            }
                            zzL(sb, 2);
                            sb.append("}\n");
                        }
                    }
                }
                List<com.google.android.gms.internal.measurement.zzhm> zzX = zzhxVar.zzX();
                if (zzX != null) {
                    for (com.google.android.gms.internal.measurement.zzhm zzhmVar : zzX) {
                        if (zzhmVar != null) {
                            zzL(sb, 2);
                            sb.append("event {\n");
                            zzQ(sb, 2, "name", zzioVar.zzj().zzd(zzhmVar.zzh()));
                            if (zzhmVar.zzu()) {
                                zzQ(sb, 2, "timestamp_millis", Long.valueOf(zzhmVar.zzd()));
                            }
                            if (zzhmVar.zzt()) {
                                zzQ(sb, 2, "previous_timestamp_millis", Long.valueOf(zzhmVar.zzc()));
                            }
                            if (zzhmVar.zzs()) {
                                zzQ(sb, 2, "count", Integer.valueOf(zzhmVar.zza()));
                            }
                            if (zzhmVar.zzb() != 0) {
                                zzJ(sb, 2, zzhmVar.zzi());
                            }
                            zzL(sb, 2);
                            sb.append("}\n");
                        }
                    }
                }
                zzL(sb, 1);
                sb.append("}\n");
            }
        }
        sb.append("} // End-of-batch\n");
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String zzr(com.google.android.gms.internal.measurement.zzfj zzfjVar) {
        if (zzfjVar == null) {
            return "null";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("\nevent_filter {\n");
        if (zzfjVar.zzp()) {
            zzQ(sb, 0, "filter_id", Integer.valueOf(zzfjVar.zzb()));
        }
        zzQ(sb, 0, "event_name", this.zzu.zzj().zzd(zzfjVar.zzg()));
        String zzN = zzN(zzfjVar.zzk(), zzfjVar.zzm(), zzfjVar.zzn());
        if (!zzN.isEmpty()) {
            zzQ(sb, 0, "filter_type", zzN);
        }
        if (zzfjVar.zzo()) {
            zzR(sb, 1, "event_count_filter", zzfjVar.zzf());
        }
        if (zzfjVar.zza() > 0) {
            sb.append("  filters {\n");
            Iterator it = zzfjVar.zzh().iterator();
            while (it.hasNext()) {
                zzK(sb, 2, (com.google.android.gms.internal.measurement.zzfl) it.next());
            }
        }
        zzL(sb, 1);
        sb.append("}\n}\n");
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String zzs(com.google.android.gms.internal.measurement.zzfr zzfrVar) {
        if (zzfrVar == null) {
            return "null";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("\nproperty_filter {\n");
        if (zzfrVar.zzj()) {
            zzQ(sb, 0, "filter_id", Integer.valueOf(zzfrVar.zza()));
        }
        zzQ(sb, 0, "property_name", this.zzu.zzj().zzf(zzfrVar.zze()));
        String zzN = zzN(zzfrVar.zzg(), zzfrVar.zzh(), zzfrVar.zzi());
        if (!zzN.isEmpty()) {
            zzQ(sb, 0, "filter_type", zzN);
        }
        zzK(sb, 1, zzfrVar.zzb());
        sb.append("}\n");
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final List zzt(List list, List list2) {
        int i;
        ArrayList arrayList = new ArrayList(list);
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            Integer num = (Integer) it.next();
            if (num.intValue() < 0) {
                this.zzu.zzaW().zzk().zzb("Ignoring negative bit index to be cleared", num);
            } else {
                int intValue = num.intValue() / 64;
                if (intValue >= arrayList.size()) {
                    this.zzu.zzaW().zzk().zzc("Ignoring bit index greater than bitSet size", num, Integer.valueOf(arrayList.size()));
                } else {
                    arrayList.set(intValue, Long.valueOf(((Long) arrayList.get(intValue)).longValue() & (~(1 << (num.intValue() % 64)))));
                }
            }
        }
        int size = arrayList.size();
        int size2 = arrayList.size() - 1;
        while (true) {
            int i2 = size2;
            i = size;
            size = i2;
            if (size < 0 || ((Long) arrayList.get(size)).longValue() != 0) {
                break;
            }
            size2 = size - 1;
        }
        return arrayList.subList(0, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0032, code lost:
    
        r5 = new java.util.ArrayList();
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0038, code lost:
    
        if (r4 == false) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x003a, code lost:
    
        r3 = (android.os.Parcelable[]) r3;
        r4 = r3.length;
        r7 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x003e, code lost:
    
        if (r7 >= r4) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0040, code lost:
    
        r8 = r3[r7];
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0044, code lost:
    
        if ((r8 instanceof android.os.Bundle) == false) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0046, code lost:
    
        r5.add(zzv((android.os.Bundle) r8, false));
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x004f, code lost:
    
        r7 = r7 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0080, code lost:
    
        r0.put(r2, r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0054, code lost:
    
        if ((r3 instanceof java.util.ArrayList) == false) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0056, code lost:
    
        r3 = (java.util.ArrayList) r3;
        r4 = r3.size();
        r7 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x005d, code lost:
    
        if (r7 >= r4) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x005f, code lost:
    
        r8 = r3.get(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0065, code lost:
    
        if ((r8 instanceof android.os.Bundle) == false) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0067, code lost:
    
        r5.add(zzv((android.os.Bundle) r8, false));
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0070, code lost:
    
        r7 = r7 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0075, code lost:
    
        if ((r3 instanceof android.os.Bundle) == false) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0077, code lost:
    
        r5.add(zzv((android.os.Bundle) r3, false));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Map zzv(Bundle bundle, boolean z) {
        HashMap hashMap = new HashMap();
        Iterator<String> it = bundle.keySet().iterator();
        while (it.hasNext()) {
            String next = it.next();
            Object obj = bundle.get(next);
            boolean z2 = obj instanceof Parcelable[];
            if (!z2 && !(obj instanceof ArrayList) && !(obj instanceof Bundle)) {
                if (obj != null) {
                    hashMap.put(next, obj);
                }
            }
        }
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzw(com.google.android.gms.internal.measurement.zzhp zzhpVar, Object obj) {
        Preconditions.checkNotNull(obj);
        zzhpVar.zzg();
        zzhpVar.zze();
        zzhpVar.zzd();
        zzhpVar.zzf();
        if (obj instanceof String) {
            zzhpVar.zzk((String) obj);
            return;
        }
        if (obj instanceof Long) {
            zzhpVar.zzi(((Long) obj).longValue());
            return;
        }
        if (obj instanceof Double) {
            zzhpVar.zzh(((Double) obj).doubleValue());
            return;
        }
        if (!(obj instanceof Bundle[])) {
            this.zzu.zzaW().zze().zzb("Ignoring invalid (type) event param value", obj);
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (Bundle bundle : (Bundle[]) obj) {
            if (bundle != null) {
                com.google.android.gms.internal.measurement.zzhp zze = com.google.android.gms.internal.measurement.zzhq.zze();
                for (String str : bundle.keySet()) {
                    com.google.android.gms.internal.measurement.zzhp zze2 = com.google.android.gms.internal.measurement.zzhq.zze();
                    zze2.zzj(str);
                    Object obj2 = bundle.get(str);
                    if (obj2 instanceof Long) {
                        zze2.zzi(((Long) obj2).longValue());
                    } else if (obj2 instanceof String) {
                        zze2.zzk((String) obj2);
                    } else if (obj2 instanceof Double) {
                        zze2.zzh(((Double) obj2).doubleValue());
                    }
                    zze.zzc(zze2);
                }
                if (zze.zza() > 0) {
                    arrayList.add((com.google.android.gms.internal.measurement.zzhq) zze.zzba());
                }
            }
        }
        zzhpVar.zzb(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzx(com.google.android.gms.internal.measurement.zzin zzinVar, Object obj) {
        Preconditions.checkNotNull(obj);
        zzinVar.zzc();
        zzinVar.zzb();
        zzinVar.zza();
        if (obj instanceof String) {
            zzinVar.zzh((String) obj);
            return;
        }
        if (obj instanceof Long) {
            zzinVar.zze(((Long) obj).longValue());
        } else if (!(obj instanceof Double)) {
            this.zzu.zzaW().zze().zzb("Ignoring invalid (type) user attribute value", obj);
        } else {
            zzinVar.zzd(((Double) obj).doubleValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzz(long j, long j2) {
        return j == 0 || j2 <= 0 || Math.abs(this.zzu.zzaU().currentTimeMillis() - j) > j2;
    }
}
