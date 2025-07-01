package com.google.android.gms.measurement.internal;

import android.app.BroadcastOptions;
import android.content.ComponentName;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.camera.video.AudioStats;
import androidx.collection.ArrayMap;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.CollectionUtils;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.measurement.zzqr;
import com.google.android.gms.internal.measurement.zzra;
import com.google.android.gms.internal.measurement.zzrd;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.common.net.HttpHeaders;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.Constants;
import com.google.mlkit.common.MlKitException;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.zip.GZIPInputStream;

/* compiled from: com.google.android.gms:play-services-measurement@@22.4.0 */
/* loaded from: classes3.dex */
public final class zzpv implements zzjs {
    private static volatile zzpv zzb;
    private List zzA;
    private long zzB;
    private final Map zzC;
    private final Map zzD;
    private final Map zzE;
    private zzmh zzG;
    private String zzH;
    private zzaz zzI;
    private long zzJ;
    long zza;
    private final zzif zzc;
    private final zzhk zzd;
    private zzaw zze;
    private zzhm zzf;
    private zzoy zzg;
    private zzae zzh;
    private final zzqa zzi;
    private zzmc zzj;
    private zzoa zzk;
    private final zzpi zzl;
    private zzhw zzm;
    private final zzio zzn;
    private boolean zzp;
    private List zzq;
    private int zzs;
    private int zzt;
    private boolean zzu;
    private boolean zzv;
    private boolean zzw;
    private FileLock zzx;
    private FileChannel zzy;
    private List zzz;
    private final AtomicBoolean zzo = new AtomicBoolean(false);
    private final Deque zzr = new LinkedList();
    private final Map zzF = new HashMap();
    private final zzqe zzK = new zzpq(this);

    zzpv(zzpw zzpwVar, zzio zzioVar) {
        Preconditions.checkNotNull(zzpwVar);
        this.zzn = zzio.zzp(zzpwVar.zza, null, null);
        this.zzB = -1L;
        this.zzl = new zzpi(this);
        zzqa zzqaVar = new zzqa(this);
        zzqaVar.zzaw();
        this.zzi = zzqaVar;
        zzhk zzhkVar = new zzhk(this);
        zzhkVar.zzaw();
        this.zzd = zzhkVar;
        zzif zzifVar = new zzif(this);
        zzifVar.zzaw();
        this.zzc = zzifVar;
        this.zzC = new HashMap();
        this.zzD = new HashMap();
        this.zzE = new HashMap();
        zzaX().zzq(new zzpk(this, zzpwVar));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ void zzH(zzpv zzpvVar, zzpw zzpwVar) {
        zzpvVar.zzaX().zzg();
        zzpvVar.zzm = new zzhw(zzpvVar);
        zzaw zzawVar = new zzaw(zzpvVar);
        zzawVar.zzaw();
        zzpvVar.zze = zzawVar;
        zzpvVar.zzi().zzu((zzal) Preconditions.checkNotNull(zzpvVar.zzc));
        zzoa zzoaVar = new zzoa(zzpvVar);
        zzoaVar.zzaw();
        zzpvVar.zzk = zzoaVar;
        zzae zzaeVar = new zzae(zzpvVar);
        zzaeVar.zzaw();
        zzpvVar.zzh = zzaeVar;
        zzmc zzmcVar = new zzmc(zzpvVar);
        zzmcVar.zzaw();
        zzpvVar.zzj = zzmcVar;
        zzoy zzoyVar = new zzoy(zzpvVar);
        zzoyVar.zzaw();
        zzpvVar.zzg = zzoyVar;
        zzpvVar.zzf = new zzhm(zzpvVar);
        if (zzpvVar.zzs != zzpvVar.zzt) {
            zzpvVar.zzaW().zze().zzc("Not all upload components initialized", Integer.valueOf(zzpvVar.zzs), Integer.valueOf(zzpvVar.zzt));
        }
        zzpvVar.zzo.set(true);
        zzpvVar.zzaW().zzj().zza("UploadController is now fully initialized");
    }

    static final void zzaA(com.google.android.gms.internal.measurement.zzhl zzhlVar, int i, String str) {
        List zzp = zzhlVar.zzp();
        for (int i2 = 0; i2 < zzp.size(); i2++) {
            if ("_err".equals(((com.google.android.gms.internal.measurement.zzhq) zzp.get(i2)).zzg())) {
                return;
            }
        }
        com.google.android.gms.internal.measurement.zzhp zze = com.google.android.gms.internal.measurement.zzhq.zze();
        zze.zzj("_err");
        long j = i;
        Long.valueOf(j).getClass();
        zze.zzi(j);
        com.google.android.gms.internal.measurement.zzhq zzhqVar = (com.google.android.gms.internal.measurement.zzhq) zze.zzba();
        com.google.android.gms.internal.measurement.zzhp zze2 = com.google.android.gms.internal.measurement.zzhq.zze();
        zze2.zzj("_ev");
        zze2.zzk(str);
        com.google.android.gms.internal.measurement.zzhq zzhqVar2 = (com.google.android.gms.internal.measurement.zzhq) zze2.zzba();
        zzhlVar.zzf(zzhqVar);
        zzhlVar.zzf(zzhqVar2);
    }

    static final void zzaB(com.google.android.gms.internal.measurement.zzhl zzhlVar, String str) {
        List zzp = zzhlVar.zzp();
        for (int i = 0; i < zzp.size(); i++) {
            if (str.equals(((com.google.android.gms.internal.measurement.zzhq) zzp.get(i)).zzg())) {
                zzhlVar.zzh(i);
                return;
            }
        }
    }

    private final int zzaC(String str, zzao zzaoVar) {
        zzju zzf;
        zzif zzifVar = this.zzc;
        if (zzifVar.zzi(str) == null) {
            zzaoVar.zzd(zzjw.AD_PERSONALIZATION, zzan.FAILSAFE);
            return 1;
        }
        zzh zzl = zzj().zzl(str);
        if (zzl == null || zze.zza(zzl.zzK()).zzb() != zzju.POLICY || (zzf = zzifVar.zzf(str, zzjw.AD_PERSONALIZATION)) == zzju.UNINITIALIZED) {
            zzaoVar.zzd(zzjw.AD_PERSONALIZATION, zzan.REMOTE_DEFAULT);
            return zzifVar.zzu(str, zzjw.AD_PERSONALIZATION) ? 0 : 1;
        }
        zzaoVar.zzd(zzjw.AD_PERSONALIZATION, zzan.REMOTE_ENFORCED_DEFAULT);
        return zzf == zzju.GRANTED ? 0 : 1;
    }

    private final zzr zzaD(String str) {
        zzh zzl = zzj().zzl(str);
        if (zzl == null || TextUtils.isEmpty(zzl.zzF())) {
            zzaW().zzd().zzb("No app data available; dropping", str);
            return null;
        }
        Boolean zzaF = zzaF(zzl);
        if (zzaF == null || zzaF.booleanValue()) {
            return new zzr(str, zzl.zzH(), zzl.zzF(), zzl.zze(), zzl.zzE(), zzl.zzq(), zzl.zzn(), (String) null, zzl.zzaJ(), false, zzl.zzG(), 0L, 0, zzl.zzaI(), false, zzl.zzA(), zzl.zzx(), zzl.zzo(), zzl.zzN(), (String) null, zzu(str).zzq(), "", (String) null, zzl.zzaL(), zzl.zzw(), zzu(str).zzb(), zzm(str).zzj(), zzl.zza(), zzl.zzf(), zzl.zzM(), zzl.zzK(), 0L, zzl.zzb());
        }
        zzaW().zze().zzb("App version does not match; dropping. appId", zzhe.zzn(str));
        return null;
    }

    private final zzaz zzaE() {
        if (this.zzI == null) {
            this.zzI = new zzpn(this, this.zzn);
        }
        return this.zzI;
    }

    private final Boolean zzaF(zzh zzhVar) {
        try {
            if (zzhVar.zze() == -2147483648L) {
                String str = Wrappers.packageManager(this.zzn.zzaT()).getPackageInfo(zzhVar.zzC(), 0).versionName;
                String zzF = zzhVar.zzF();
                if (zzF != null && zzF.equals(str)) {
                    return true;
                }
            } else {
                if (zzhVar.zze() == Wrappers.packageManager(this.zzn.zzaT()).getPackageInfo(zzhVar.zzC(), 0).versionCode) {
                    return true;
                }
            }
            return false;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    private static String zzaG(Map map, String str) {
        if (map == null) {
            return null;
        }
        for (Map.Entry entry : map.entrySet()) {
            if (str.equalsIgnoreCase((String) entry.getKey())) {
                if (((List) entry.getValue()).isEmpty()) {
                    return null;
                }
                return (String) ((List) entry.getValue()).get(0);
            }
        }
        return null;
    }

    private final void zzaH() {
        zzaX().zzg();
        if (this.zzu || this.zzv || this.zzw) {
            zzaW().zzj().zzd("Not stopping services. fetch, network, upload", Boolean.valueOf(this.zzu), Boolean.valueOf(this.zzv), Boolean.valueOf(this.zzw));
            return;
        }
        zzaW().zzj().zza("Stopping uploading service(s)");
        List list = this.zzq;
        if (list == null) {
            return;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
        ((List) Preconditions.checkNotNull(this.zzq)).clear();
    }

    private final void zzaI(com.google.android.gms.internal.measurement.zzhw zzhwVar, long j, boolean z) {
        String str;
        zzqd zzqdVar;
        Object obj;
        if (true != z) {
            str = "_lte";
        } else {
            str = "_se";
        }
        zzqd zzy = zzj().zzy(zzhwVar.zzaF(), str);
        if (zzy == null || (obj = zzy.zze) == null) {
            zzqdVar = new zzqd(zzhwVar.zzaF(), "auto", str, zzaU().currentTimeMillis(), Long.valueOf(j));
        } else {
            zzqdVar = new zzqd(zzhwVar.zzaF(), "auto", str, zzaU().currentTimeMillis(), Long.valueOf(((Long) obj).longValue() + j));
        }
        com.google.android.gms.internal.measurement.zzin zze = com.google.android.gms.internal.measurement.zzio.zze();
        zze.zzf(str);
        zze.zzg(zzaU().currentTimeMillis());
        Object obj2 = zzqdVar.zze;
        zze.zze(((Long) obj2).longValue());
        com.google.android.gms.internal.measurement.zzio zzioVar = (com.google.android.gms.internal.measurement.zzio) zze.zzba();
        int zza = zzqa.zza(zzhwVar, str);
        if (zza < 0) {
            zzhwVar.zzp(zzioVar);
        } else {
            zzhwVar.zzaC(zza, zzioVar);
        }
        if (j > 0) {
            zzj().zzai(zzqdVar);
            zzaW().zzj().zzc("Updated engagement user property. scope, value", true != z ? "lifetime" : "session-scoped", obj2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzaJ() {
        zzaX().zzg();
        if (this.zzr.isEmpty() || zzaE().zze()) {
            return;
        }
        long max = Math.max(0L, ((Integer) zzgi.zzaA.zza(null)).intValue() - (zzaU().elapsedRealtime() - this.zzJ));
        zzaW().zzj().zzb("Scheduling notify next app runnable, delay in ms", Long.valueOf(max));
        zzaE().zzd(max);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zzaK(Context context, Intent intent) {
        BroadcastOptions makeBasic;
        BroadcastOptions shareIdentityEnabled;
        Bundle bundle;
        if (Build.VERSION.SDK_INT < 34) {
            context.sendBroadcast(intent);
            return;
        }
        makeBasic = BroadcastOptions.makeBasic();
        shareIdentityEnabled = makeBasic.setShareIdentityEnabled(true);
        bundle = shareIdentityEnabled.toBundle();
        context.sendBroadcast(intent, null, bundle);
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x01a9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void zzaL() {
        long max;
        long j;
        zzaX().zzg();
        zzM();
        if (this.zza > 0) {
            long abs = 3600000 - Math.abs(zzaU().elapsedRealtime() - this.zza);
            if (abs > 0) {
                zzaW().zzj().zzb("Upload has been suspended. Will update scheduling later in approximately ms", Long.valueOf(abs));
                zzq().zzc();
                zzx().zza();
                return;
            }
            this.zza = 0L;
        }
        if (!this.zzn.zzM() || !zzaN()) {
            zzaW().zzj().zza("Nothing to upload or uploading impossible");
            zzq().zzc();
            zzx().zza();
            return;
        }
        long currentTimeMillis = zzaU().currentTimeMillis();
        zzi();
        long max2 = Math.max(0L, ((Long) zzgi.zzN.zza(null)).longValue());
        boolean z = true;
        if (!zzj().zzac() && !zzj().zzab()) {
            z = false;
        }
        if (z) {
            String zzo = zzi().zzo();
            if (TextUtils.isEmpty(zzo) || ".none.".equals(zzo)) {
                zzi();
                max = Math.max(0L, ((Long) zzgi.zzH.zza(null)).longValue());
            } else {
                zzi();
                max = Math.max(0L, ((Long) zzgi.zzI.zza(null)).longValue());
            }
        } else {
            zzi();
            max = Math.max(0L, ((Long) zzgi.zzG.zza(null)).longValue());
        }
        long zza = this.zzk.zzd.zza();
        long zza2 = this.zzk.zze.zza();
        boolean z2 = z;
        long max3 = Math.max(zzj().zzf(), zzj().zzh());
        if (max3 != 0) {
            long abs2 = currentTimeMillis - Math.abs(max3 - currentTimeMillis);
            long abs3 = currentTimeMillis - Math.abs(zza - currentTimeMillis);
            long abs4 = currentTimeMillis - Math.abs(zza2 - currentTimeMillis);
            j = abs2 + max2;
            long max4 = Math.max(abs3, abs4);
            if (z2 && max4 > 0) {
                j = Math.min(abs2, max4) + max;
            }
            if (!zzA().zzz(max4, max)) {
                j = max4 + max;
            }
            if (abs4 != 0 && abs4 >= abs2) {
                int i = 0;
                while (true) {
                    zzi();
                    if (i >= Math.min(20, Math.max(0, ((Integer) zzgi.zzP.zza(null)).intValue()))) {
                        break;
                    }
                    zzi();
                    j += Math.max(0L, ((Long) zzgi.zzO.zza(null)).longValue()) * (1 << i);
                    if (j > abs4) {
                        break;
                    } else {
                        i++;
                    }
                }
            }
            if (j != 0) {
                zzaW().zzj().zza("Next upload time is 0");
                zzq().zzc();
                zzx().zza();
                return;
            }
            if (zzp().zzd()) {
                long zza3 = this.zzk.zzc.zza();
                zzi();
                long max5 = Math.max(0L, ((Long) zzgi.zzE.zza(null)).longValue());
                if (!zzA().zzz(zza3, max5)) {
                    j = Math.max(j, zza3 + max5);
                }
                zzq().zzc();
                long currentTimeMillis2 = j - zzaU().currentTimeMillis();
                if (currentTimeMillis2 <= 0) {
                    zzi();
                    currentTimeMillis2 = Math.max(0L, ((Long) zzgi.zzJ.zza(null)).longValue());
                    this.zzk.zzd.zzb(zzaU().currentTimeMillis());
                }
                zzaW().zzj().zzb("Upload scheduled in approximately ms", Long.valueOf(currentTimeMillis2));
                zzx().zzd(currentTimeMillis2);
                return;
            }
            zzaW().zzj().zza("No network");
            zzq().zzb();
            zzx().zza();
            return;
        }
        j = 0;
        if (j != 0) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:335:0x0d57, code lost:
    
        if (r10 > (com.google.android.gms.measurement.internal.zzam.zzI() + r8)) goto L430;
     */
    /* JADX WARN: Removed duplicated region for block: B:116:0x03f0 A[Catch: all -> 0x0e85, TryCatch #2 {all -> 0x0e85, blocks: (B:3:0x000f, B:6:0x0027, B:9:0x002f, B:10:0x0043, B:13:0x0059, B:16:0x007f, B:18:0x00b4, B:21:0x00c5, B:23:0x00cf, B:26:0x068c, B:27:0x00ff, B:29:0x0111, B:32:0x0121, B:34:0x0127, B:36:0x0165, B:38:0x0173, B:41:0x0193, B:43:0x0199, B:45:0x01a9, B:47:0x01b7, B:49:0x01c7, B:51:0x01d4, B:56:0x01d7, B:59:0x01ed, B:65:0x0220, B:68:0x022a, B:70:0x0238, B:72:0x0286, B:73:0x0256, B:75:0x0264, B:83:0x0297, B:85:0x02c3, B:86:0x02ed, B:88:0x0324, B:89:0x032b, B:92:0x0337, B:94:0x036e, B:95:0x0389, B:97:0x038f, B:99:0x039d, B:101:0x03b1, B:102:0x03a6, B:110:0x03b8, B:113:0x03bf, B:114:0x03d7, B:116:0x03f0, B:117:0x03fc, B:120:0x0406, B:124:0x0429, B:125:0x0418, B:134:0x04a8, B:136:0x04b4, B:139:0x04c5, B:141:0x04d6, B:143:0x04e2, B:145:0x0555, B:147:0x055b, B:148:0x0567, B:150:0x056d, B:152:0x057d, B:154:0x0587, B:155:0x059a, B:157:0x05a0, B:158:0x05bb, B:160:0x05c1, B:162:0x05df, B:164:0x05ea, B:166:0x0611, B:167:0x05f0, B:169:0x05fe, B:173:0x061c, B:174:0x0636, B:176:0x063c, B:179:0x064f, B:184:0x065c, B:185:0x0660, B:187:0x0666, B:189:0x0676, B:196:0x04ff, B:198:0x050f, B:201:0x0522, B:203:0x0533, B:205:0x053f, B:207:0x0431, B:209:0x043d, B:211:0x0449, B:215:0x048e, B:216:0x0466, B:219:0x0478, B:221:0x047e, B:223:0x0488, B:230:0x012d, B:232:0x0138, B:234:0x0144, B:236:0x014a, B:239:0x0155, B:245:0x06a4, B:247:0x06b2, B:249:0x06bb, B:251:0x06eb, B:252:0x06c3, B:254:0x06cc, B:256:0x06d2, B:258:0x06de, B:260:0x06e6, B:267:0x06ee, B:268:0x06fa, B:271:0x0702, B:274:0x0714, B:275:0x071f, B:277:0x0727, B:278:0x074c, B:280:0x0766, B:281:0x077b, B:283:0x0795, B:284:0x07aa, B:285:0x07b8, B:287:0x07be, B:289:0x07ce, B:290:0x07d5, B:292:0x07e1, B:294:0x07e8, B:297:0x07eb, B:299:0x082d, B:301:0x0833, B:302:0x085a, B:304:0x0862, B:305:0x086b, B:307:0x0871, B:308:0x0877, B:310:0x088c, B:312:0x089c, B:314:0x08ac, B:316:0x08b4, B:317:0x08b7, B:401:0x0929, B:403:0x0942, B:405:0x0958, B:407:0x095d, B:409:0x0961, B:411:0x0965, B:413:0x096f, B:414:0x0975, B:416:0x0979, B:418:0x097f, B:419:0x098d, B:420:0x0996, B:492:0x09bb, B:496:0x09c2, B:507:0x0841, B:509:0x0847, B:511:0x084d, B:512:0x07a7, B:513:0x0778, B:514:0x072c, B:516:0x0732), top: B:2:0x000f, inners: #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:136:0x04b4 A[Catch: all -> 0x0e85, TryCatch #2 {all -> 0x0e85, blocks: (B:3:0x000f, B:6:0x0027, B:9:0x002f, B:10:0x0043, B:13:0x0059, B:16:0x007f, B:18:0x00b4, B:21:0x00c5, B:23:0x00cf, B:26:0x068c, B:27:0x00ff, B:29:0x0111, B:32:0x0121, B:34:0x0127, B:36:0x0165, B:38:0x0173, B:41:0x0193, B:43:0x0199, B:45:0x01a9, B:47:0x01b7, B:49:0x01c7, B:51:0x01d4, B:56:0x01d7, B:59:0x01ed, B:65:0x0220, B:68:0x022a, B:70:0x0238, B:72:0x0286, B:73:0x0256, B:75:0x0264, B:83:0x0297, B:85:0x02c3, B:86:0x02ed, B:88:0x0324, B:89:0x032b, B:92:0x0337, B:94:0x036e, B:95:0x0389, B:97:0x038f, B:99:0x039d, B:101:0x03b1, B:102:0x03a6, B:110:0x03b8, B:113:0x03bf, B:114:0x03d7, B:116:0x03f0, B:117:0x03fc, B:120:0x0406, B:124:0x0429, B:125:0x0418, B:134:0x04a8, B:136:0x04b4, B:139:0x04c5, B:141:0x04d6, B:143:0x04e2, B:145:0x0555, B:147:0x055b, B:148:0x0567, B:150:0x056d, B:152:0x057d, B:154:0x0587, B:155:0x059a, B:157:0x05a0, B:158:0x05bb, B:160:0x05c1, B:162:0x05df, B:164:0x05ea, B:166:0x0611, B:167:0x05f0, B:169:0x05fe, B:173:0x061c, B:174:0x0636, B:176:0x063c, B:179:0x064f, B:184:0x065c, B:185:0x0660, B:187:0x0666, B:189:0x0676, B:196:0x04ff, B:198:0x050f, B:201:0x0522, B:203:0x0533, B:205:0x053f, B:207:0x0431, B:209:0x043d, B:211:0x0449, B:215:0x048e, B:216:0x0466, B:219:0x0478, B:221:0x047e, B:223:0x0488, B:230:0x012d, B:232:0x0138, B:234:0x0144, B:236:0x014a, B:239:0x0155, B:245:0x06a4, B:247:0x06b2, B:249:0x06bb, B:251:0x06eb, B:252:0x06c3, B:254:0x06cc, B:256:0x06d2, B:258:0x06de, B:260:0x06e6, B:267:0x06ee, B:268:0x06fa, B:271:0x0702, B:274:0x0714, B:275:0x071f, B:277:0x0727, B:278:0x074c, B:280:0x0766, B:281:0x077b, B:283:0x0795, B:284:0x07aa, B:285:0x07b8, B:287:0x07be, B:289:0x07ce, B:290:0x07d5, B:292:0x07e1, B:294:0x07e8, B:297:0x07eb, B:299:0x082d, B:301:0x0833, B:302:0x085a, B:304:0x0862, B:305:0x086b, B:307:0x0871, B:308:0x0877, B:310:0x088c, B:312:0x089c, B:314:0x08ac, B:316:0x08b4, B:317:0x08b7, B:401:0x0929, B:403:0x0942, B:405:0x0958, B:407:0x095d, B:409:0x0961, B:411:0x0965, B:413:0x096f, B:414:0x0975, B:416:0x0979, B:418:0x097f, B:419:0x098d, B:420:0x0996, B:492:0x09bb, B:496:0x09c2, B:507:0x0841, B:509:0x0847, B:511:0x084d, B:512:0x07a7, B:513:0x0778, B:514:0x072c, B:516:0x0732), top: B:2:0x000f, inners: #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:147:0x055b A[Catch: all -> 0x0e85, TryCatch #2 {all -> 0x0e85, blocks: (B:3:0x000f, B:6:0x0027, B:9:0x002f, B:10:0x0043, B:13:0x0059, B:16:0x007f, B:18:0x00b4, B:21:0x00c5, B:23:0x00cf, B:26:0x068c, B:27:0x00ff, B:29:0x0111, B:32:0x0121, B:34:0x0127, B:36:0x0165, B:38:0x0173, B:41:0x0193, B:43:0x0199, B:45:0x01a9, B:47:0x01b7, B:49:0x01c7, B:51:0x01d4, B:56:0x01d7, B:59:0x01ed, B:65:0x0220, B:68:0x022a, B:70:0x0238, B:72:0x0286, B:73:0x0256, B:75:0x0264, B:83:0x0297, B:85:0x02c3, B:86:0x02ed, B:88:0x0324, B:89:0x032b, B:92:0x0337, B:94:0x036e, B:95:0x0389, B:97:0x038f, B:99:0x039d, B:101:0x03b1, B:102:0x03a6, B:110:0x03b8, B:113:0x03bf, B:114:0x03d7, B:116:0x03f0, B:117:0x03fc, B:120:0x0406, B:124:0x0429, B:125:0x0418, B:134:0x04a8, B:136:0x04b4, B:139:0x04c5, B:141:0x04d6, B:143:0x04e2, B:145:0x0555, B:147:0x055b, B:148:0x0567, B:150:0x056d, B:152:0x057d, B:154:0x0587, B:155:0x059a, B:157:0x05a0, B:158:0x05bb, B:160:0x05c1, B:162:0x05df, B:164:0x05ea, B:166:0x0611, B:167:0x05f0, B:169:0x05fe, B:173:0x061c, B:174:0x0636, B:176:0x063c, B:179:0x064f, B:184:0x065c, B:185:0x0660, B:187:0x0666, B:189:0x0676, B:196:0x04ff, B:198:0x050f, B:201:0x0522, B:203:0x0533, B:205:0x053f, B:207:0x0431, B:209:0x043d, B:211:0x0449, B:215:0x048e, B:216:0x0466, B:219:0x0478, B:221:0x047e, B:223:0x0488, B:230:0x012d, B:232:0x0138, B:234:0x0144, B:236:0x014a, B:239:0x0155, B:245:0x06a4, B:247:0x06b2, B:249:0x06bb, B:251:0x06eb, B:252:0x06c3, B:254:0x06cc, B:256:0x06d2, B:258:0x06de, B:260:0x06e6, B:267:0x06ee, B:268:0x06fa, B:271:0x0702, B:274:0x0714, B:275:0x071f, B:277:0x0727, B:278:0x074c, B:280:0x0766, B:281:0x077b, B:283:0x0795, B:284:0x07aa, B:285:0x07b8, B:287:0x07be, B:289:0x07ce, B:290:0x07d5, B:292:0x07e1, B:294:0x07e8, B:297:0x07eb, B:299:0x082d, B:301:0x0833, B:302:0x085a, B:304:0x0862, B:305:0x086b, B:307:0x0871, B:308:0x0877, B:310:0x088c, B:312:0x089c, B:314:0x08ac, B:316:0x08b4, B:317:0x08b7, B:401:0x0929, B:403:0x0942, B:405:0x0958, B:407:0x095d, B:409:0x0961, B:411:0x0965, B:413:0x096f, B:414:0x0975, B:416:0x0979, B:418:0x097f, B:419:0x098d, B:420:0x0996, B:492:0x09bb, B:496:0x09c2, B:507:0x0841, B:509:0x0847, B:511:0x084d, B:512:0x07a7, B:513:0x0778, B:514:0x072c, B:516:0x0732), top: B:2:0x000f, inners: #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:191:0x0670  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x04ff A[Catch: all -> 0x0e85, TryCatch #2 {all -> 0x0e85, blocks: (B:3:0x000f, B:6:0x0027, B:9:0x002f, B:10:0x0043, B:13:0x0059, B:16:0x007f, B:18:0x00b4, B:21:0x00c5, B:23:0x00cf, B:26:0x068c, B:27:0x00ff, B:29:0x0111, B:32:0x0121, B:34:0x0127, B:36:0x0165, B:38:0x0173, B:41:0x0193, B:43:0x0199, B:45:0x01a9, B:47:0x01b7, B:49:0x01c7, B:51:0x01d4, B:56:0x01d7, B:59:0x01ed, B:65:0x0220, B:68:0x022a, B:70:0x0238, B:72:0x0286, B:73:0x0256, B:75:0x0264, B:83:0x0297, B:85:0x02c3, B:86:0x02ed, B:88:0x0324, B:89:0x032b, B:92:0x0337, B:94:0x036e, B:95:0x0389, B:97:0x038f, B:99:0x039d, B:101:0x03b1, B:102:0x03a6, B:110:0x03b8, B:113:0x03bf, B:114:0x03d7, B:116:0x03f0, B:117:0x03fc, B:120:0x0406, B:124:0x0429, B:125:0x0418, B:134:0x04a8, B:136:0x04b4, B:139:0x04c5, B:141:0x04d6, B:143:0x04e2, B:145:0x0555, B:147:0x055b, B:148:0x0567, B:150:0x056d, B:152:0x057d, B:154:0x0587, B:155:0x059a, B:157:0x05a0, B:158:0x05bb, B:160:0x05c1, B:162:0x05df, B:164:0x05ea, B:166:0x0611, B:167:0x05f0, B:169:0x05fe, B:173:0x061c, B:174:0x0636, B:176:0x063c, B:179:0x064f, B:184:0x065c, B:185:0x0660, B:187:0x0666, B:189:0x0676, B:196:0x04ff, B:198:0x050f, B:201:0x0522, B:203:0x0533, B:205:0x053f, B:207:0x0431, B:209:0x043d, B:211:0x0449, B:215:0x048e, B:216:0x0466, B:219:0x0478, B:221:0x047e, B:223:0x0488, B:230:0x012d, B:232:0x0138, B:234:0x0144, B:236:0x014a, B:239:0x0155, B:245:0x06a4, B:247:0x06b2, B:249:0x06bb, B:251:0x06eb, B:252:0x06c3, B:254:0x06cc, B:256:0x06d2, B:258:0x06de, B:260:0x06e6, B:267:0x06ee, B:268:0x06fa, B:271:0x0702, B:274:0x0714, B:275:0x071f, B:277:0x0727, B:278:0x074c, B:280:0x0766, B:281:0x077b, B:283:0x0795, B:284:0x07aa, B:285:0x07b8, B:287:0x07be, B:289:0x07ce, B:290:0x07d5, B:292:0x07e1, B:294:0x07e8, B:297:0x07eb, B:299:0x082d, B:301:0x0833, B:302:0x085a, B:304:0x0862, B:305:0x086b, B:307:0x0871, B:308:0x0877, B:310:0x088c, B:312:0x089c, B:314:0x08ac, B:316:0x08b4, B:317:0x08b7, B:401:0x0929, B:403:0x0942, B:405:0x0958, B:407:0x095d, B:409:0x0961, B:411:0x0965, B:413:0x096f, B:414:0x0975, B:416:0x0979, B:418:0x097f, B:419:0x098d, B:420:0x0996, B:492:0x09bb, B:496:0x09c2, B:507:0x0841, B:509:0x0847, B:511:0x084d, B:512:0x07a7, B:513:0x0778, B:514:0x072c, B:516:0x0732), top: B:2:0x000f, inners: #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:334:0x0d49 A[Catch: all -> 0x0e83, TryCatch #1 {all -> 0x0e83, blocks: (B:326:0x0cbd, B:328:0x0cd2, B:331:0x0cd9, B:332:0x0d0a, B:334:0x0d49, B:336:0x0d7a, B:338:0x0d7e, B:339:0x0d88, B:341:0x0dcb, B:343:0x0dd8, B:345:0x0de9, B:347:0x0e35, B:349:0x0e46, B:350:0x0e65, B:357:0x0e52, B:360:0x0e01, B:363:0x0e1a, B:364:0x0d59, B:365:0x0ce1, B:367:0x0ced, B:368:0x0cf3, B:519:0x0e72), top: B:4:0x0025, inners: #0, #3, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:341:0x0dcb A[Catch: all -> 0x0e83, TRY_LEAVE, TryCatch #1 {all -> 0x0e83, blocks: (B:326:0x0cbd, B:328:0x0cd2, B:331:0x0cd9, B:332:0x0d0a, B:334:0x0d49, B:336:0x0d7a, B:338:0x0d7e, B:339:0x0d88, B:341:0x0dcb, B:343:0x0dd8, B:345:0x0de9, B:347:0x0e35, B:349:0x0e46, B:350:0x0e65, B:357:0x0e52, B:360:0x0e01, B:363:0x0e1a, B:364:0x0d59, B:365:0x0ce1, B:367:0x0ced, B:368:0x0cf3, B:519:0x0e72), top: B:4:0x0025, inners: #0, #3, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:345:0x0de9 A[Catch: SQLiteException -> 0x0dff, all -> 0x0e83, TRY_LEAVE, TryCatch #4 {SQLiteException -> 0x0dff, blocks: (B:343:0x0dd8, B:345:0x0de9), top: B:342:0x0dd8, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:431:0x09f6 A[Catch: all -> 0x0e6e, TryCatch #6 {all -> 0x0e6e, blocks: (B:395:0x08f8, B:396:0x090b, B:398:0x0911, B:424:0x0bd9, B:426:0x09a5, B:429:0x09d6, B:431:0x09f6, B:432:0x09fe, B:434:0x0a04, B:438:0x0a16, B:443:0x0a3e, B:444:0x0a61, B:446:0x0a6d, B:448:0x0a83, B:449:0x0ac2, B:452:0x0ad8, B:454:0x0ae1, B:456:0x0aef, B:458:0x0af3, B:460:0x0af7, B:462:0x0afb, B:463:0x0b07, B:464:0x0b0d, B:466:0x0b13, B:468:0x0b2e, B:469:0x0b33, B:470:0x0bd6, B:472:0x0b4d, B:474:0x0b53, B:477:0x0b77, B:479:0x0b9e, B:480:0x0baa, B:483:0x0bbc, B:485:0x0bc6, B:486:0x0b5e, B:490:0x0a2a, B:498:0x0be7, B:500:0x0bf6, B:501:0x0bfc, B:502:0x0c04, B:504:0x0c0a, B:320:0x0c24, B:322:0x0c34, B:323:0x0cb5, B:375:0x0c4c, B:377:0x0c52, B:379:0x0c5c, B:380:0x0c63, B:385:0x0c73, B:386:0x0c7a, B:388:0x0ca6, B:389:0x0cad, B:390:0x0caa, B:391:0x0c77, B:393:0x0c60), top: B:394:0x08f8 }] */
    /* JADX WARN: Removed duplicated region for block: B:443:0x0a3e A[Catch: all -> 0x0e6e, TryCatch #6 {all -> 0x0e6e, blocks: (B:395:0x08f8, B:396:0x090b, B:398:0x0911, B:424:0x0bd9, B:426:0x09a5, B:429:0x09d6, B:431:0x09f6, B:432:0x09fe, B:434:0x0a04, B:438:0x0a16, B:443:0x0a3e, B:444:0x0a61, B:446:0x0a6d, B:448:0x0a83, B:449:0x0ac2, B:452:0x0ad8, B:454:0x0ae1, B:456:0x0aef, B:458:0x0af3, B:460:0x0af7, B:462:0x0afb, B:463:0x0b07, B:464:0x0b0d, B:466:0x0b13, B:468:0x0b2e, B:469:0x0b33, B:470:0x0bd6, B:472:0x0b4d, B:474:0x0b53, B:477:0x0b77, B:479:0x0b9e, B:480:0x0baa, B:483:0x0bbc, B:485:0x0bc6, B:486:0x0b5e, B:490:0x0a2a, B:498:0x0be7, B:500:0x0bf6, B:501:0x0bfc, B:502:0x0c04, B:504:0x0c0a, B:320:0x0c24, B:322:0x0c34, B:323:0x0cb5, B:375:0x0c4c, B:377:0x0c52, B:379:0x0c5c, B:380:0x0c63, B:385:0x0c73, B:386:0x0c7a, B:388:0x0ca6, B:389:0x0cad, B:390:0x0caa, B:391:0x0c77, B:393:0x0c60), top: B:394:0x08f8 }] */
    /* JADX WARN: Removed duplicated region for block: B:444:0x0a61 A[Catch: all -> 0x0e6e, TryCatch #6 {all -> 0x0e6e, blocks: (B:395:0x08f8, B:396:0x090b, B:398:0x0911, B:424:0x0bd9, B:426:0x09a5, B:429:0x09d6, B:431:0x09f6, B:432:0x09fe, B:434:0x0a04, B:438:0x0a16, B:443:0x0a3e, B:444:0x0a61, B:446:0x0a6d, B:448:0x0a83, B:449:0x0ac2, B:452:0x0ad8, B:454:0x0ae1, B:456:0x0aef, B:458:0x0af3, B:460:0x0af7, B:462:0x0afb, B:463:0x0b07, B:464:0x0b0d, B:466:0x0b13, B:468:0x0b2e, B:469:0x0b33, B:470:0x0bd6, B:472:0x0b4d, B:474:0x0b53, B:477:0x0b77, B:479:0x0b9e, B:480:0x0baa, B:483:0x0bbc, B:485:0x0bc6, B:486:0x0b5e, B:490:0x0a2a, B:498:0x0be7, B:500:0x0bf6, B:501:0x0bfc, B:502:0x0c04, B:504:0x0c0a, B:320:0x0c24, B:322:0x0c34, B:323:0x0cb5, B:375:0x0c4c, B:377:0x0c52, B:379:0x0c5c, B:380:0x0c63, B:385:0x0c73, B:386:0x0c7a, B:388:0x0ca6, B:389:0x0cad, B:390:0x0caa, B:391:0x0c77, B:393:0x0c60), top: B:394:0x08f8 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean zzaM(String str, long j) {
        boolean z;
        int i;
        int i2;
        com.google.android.gms.internal.measurement.zzhw zzhwVar;
        boolean z2;
        zzpr zzprVar;
        long parseLong;
        int zzc;
        long j2;
        zzpr zzprVar2;
        SecureRandom secureRandom;
        int i3;
        HashMap hashMap;
        long zzt;
        HashMap hashMap2;
        int i4;
        com.google.android.gms.internal.measurement.zzhw zzhwVar2;
        zzaw zzj;
        com.google.android.gms.internal.measurement.zzhx zzhxVar;
        long currentTimeMillis;
        long zzo;
        ContentValues contentValues;
        String str2;
        String str3;
        int i5;
        com.google.android.gms.internal.measurement.zzhw zzhwVar3;
        boolean z3;
        String str4;
        int i6;
        com.google.android.gms.internal.measurement.zzhw zzhwVar4;
        int i7;
        int i8;
        int i9;
        int i10;
        String str5;
        int i11;
        int i12;
        int i13;
        int i14;
        com.google.android.gms.internal.measurement.zzhw zzhwVar5;
        int i15;
        String str6;
        zzpv zzpvVar = this;
        String str7 = FirebaseAnalytics.Event.PURCHASE;
        String str8 = "_ai";
        String str9 = FirebaseAnalytics.Param.ITEMS;
        zzj().zzH();
        try {
            zzpr zzprVar3 = new zzpr(zzpvVar, null);
            zzj().zzat(str, j, zzpvVar.zzB, zzprVar3);
            List list = zzprVar3.zzc;
            try {
                if (list != null && !list.isEmpty()) {
                    com.google.android.gms.internal.measurement.zzhw zzhwVar6 = (com.google.android.gms.internal.measurement.zzhw) zzprVar3.zza.zzch();
                    zzhwVar6.zzu();
                    com.google.android.gms.internal.measurement.zzhl zzhlVar = null;
                    com.google.android.gms.internal.measurement.zzhl zzhlVar2 = null;
                    int i16 = -1;
                    int i17 = 0;
                    int i18 = 0;
                    boolean z4 = false;
                    int i19 = 0;
                    int i20 = -1;
                    while (true) {
                        i = i19;
                        i2 = i18;
                        com.google.android.gms.internal.measurement.zzhl zzhlVar3 = zzhlVar;
                        int i21 = i20;
                        if (i17 >= zzprVar3.zzc.size()) {
                            break;
                        }
                        com.google.android.gms.internal.measurement.zzhl zzhlVar4 = (com.google.android.gms.internal.measurement.zzhl) ((com.google.android.gms.internal.measurement.zzhm) zzprVar3.zzc.get(i17)).zzch();
                        int i22 = i17;
                        if (zzr().zzx(zzprVar3.zza.zzF(), zzhlVar4.zzo())) {
                            zzaW().zzk().zzc("Dropping blocked raw event. appId", zzhe.zzn(zzprVar3.zza.zzF()), zzpvVar.zzn.zzj().zzd(zzhlVar4.zzo()));
                            if (!zzr().zzt(zzprVar3.zza.zzF()) && !zzr().zzy(zzprVar3.zza.zzF()) && !"_err".equals(zzhlVar4.zzo())) {
                                zzB().zzR(zzpvVar.zzK, zzprVar3.zza.zzF(), 11, "_ev", zzhlVar4.zzo(), 0);
                            }
                            i19 = i;
                            str3 = str7;
                            str4 = str8;
                            i12 = i16;
                            z3 = z4;
                            i18 = i2;
                            zzhlVar = zzhlVar3;
                            i20 = i21;
                            i11 = i22;
                            str5 = str9;
                            zzhwVar4 = zzhwVar6;
                        } else {
                            com.google.android.gms.internal.measurement.zzoy.zzb();
                            String str10 = str9;
                            if (zzi().zzx(null, zzgi.zzbf)) {
                                String zzo2 = zzhlVar4.zzo();
                                str2 = "_et";
                                if (zzo2.equals(str7) || zzo2.equals("_iap") || zzo2.equals("ecommerce_purchase")) {
                                    com.google.android.gms.internal.measurement.zzhp zze = com.google.android.gms.internal.measurement.zzhq.zze();
                                    zze.zzj("_cbs");
                                    if (!z4) {
                                        String zzF = zzprVar3.zza.zzF();
                                        if (zzpvVar.zzaO(zzF, str7) && zzpvVar.zzaO(zzF, "_iap") && zzpvVar.zzaO(zzF, "ecommerce_purchase")) {
                                            str6 = "new_buyer";
                                            zze.zzk(str6);
                                            zzhlVar4.zzf((com.google.android.gms.internal.measurement.zzhq) zze.zzba());
                                            z4 = true;
                                        }
                                    }
                                    str6 = "returning_buyer";
                                    zze.zzk(str6);
                                    zzhlVar4.zzf((com.google.android.gms.internal.measurement.zzhq) zze.zzba());
                                    z4 = true;
                                }
                            } else {
                                str2 = "_et";
                            }
                            if (zzhlVar4.zzo().equals(zzjy.zza(str8))) {
                                zzhlVar4.zzi(str8);
                                zzaW().zzj().zza("Renaming ad_impression to _ai");
                                if (Log.isLoggable(zzaW().zzr(), 5)) {
                                    for (int i23 = 0; i23 < zzhlVar4.zza(); i23++) {
                                        if (FirebaseAnalytics.Param.AD_PLATFORM.equals(zzhlVar4.zzn(i23).zzg()) && !zzhlVar4.zzn(i23).zzh().isEmpty() && "admob".equalsIgnoreCase(zzhlVar4.zzn(i23).zzh())) {
                                            zzaW().zzl().zza("AdMob ad impression logged from app. Potentially duplicative.");
                                        }
                                    }
                                }
                            }
                            boolean zzw = zzr().zzw(zzprVar3.zza.zzF(), zzhlVar4.zzo());
                            if (zzw) {
                                str3 = str7;
                            } else {
                                zzA();
                                String zzo3 = zzhlVar4.zzo();
                                Preconditions.checkNotEmpty(zzo3);
                                str3 = str7;
                                if (zzo3.hashCode() != 95027 || !zzo3.equals("_ui")) {
                                    i6 = i;
                                    str4 = str8;
                                    zzhwVar3 = zzhwVar6;
                                    i5 = i16;
                                    z3 = z4;
                                    zzw = false;
                                    if (zzw) {
                                        ArrayList arrayList = new ArrayList(zzhlVar4.zzp());
                                        int i24 = -1;
                                        int i25 = -1;
                                        for (int i26 = 0; i26 < arrayList.size(); i26++) {
                                            if ("value".equals(((com.google.android.gms.internal.measurement.zzhq) arrayList.get(i26)).zzg())) {
                                                i24 = i26;
                                            } else if (FirebaseAnalytics.Param.CURRENCY.equals(((com.google.android.gms.internal.measurement.zzhq) arrayList.get(i26)).zzg())) {
                                                i25 = i26;
                                            }
                                        }
                                        if (i24 != -1) {
                                            if (((com.google.android.gms.internal.measurement.zzhq) arrayList.get(i24)).zzw() || ((com.google.android.gms.internal.measurement.zzhq) arrayList.get(i24)).zzu()) {
                                                if (i25 != -1) {
                                                    String zzh = ((com.google.android.gms.internal.measurement.zzhq) arrayList.get(i25)).zzh();
                                                    if (zzh.length() == 3) {
                                                        int i27 = 0;
                                                        while (i27 < zzh.length()) {
                                                            int codePointAt = zzh.codePointAt(i27);
                                                            if (Character.isLetter(codePointAt)) {
                                                                i27 += Character.charCount(codePointAt);
                                                            }
                                                        }
                                                    }
                                                }
                                                zzaW().zzl().zza("Value parameter discarded. You must also supply a 3-letter ISO_4217 currency code in the currency parameter.");
                                                zzhlVar4.zzh(i24);
                                                zzaB(zzhlVar4, "_c");
                                                zzaA(zzhlVar4, 19, FirebaseAnalytics.Param.CURRENCY);
                                                break;
                                            }
                                            zzaW().zzl().zza("Value must be specified with a numeric type.");
                                            zzhlVar4.zzh(i24);
                                            zzaB(zzhlVar4, "_c");
                                            zzaA(zzhlVar4, 18, "value");
                                        }
                                        if ("_e".equals(zzhlVar4.zzo())) {
                                            zzA();
                                            if (zzqa.zzG((com.google.android.gms.internal.measurement.zzhm) zzhlVar4.zzba(), "_fr") == null) {
                                                if (zzhlVar2 != null && Math.abs(zzhlVar2.zzc() - zzhlVar4.zzc()) <= 1000) {
                                                    com.google.android.gms.internal.measurement.zzhl zzhlVar5 = (com.google.android.gms.internal.measurement.zzhl) zzhlVar2.clone();
                                                    if (zzpvVar.zzaP(zzhlVar4, zzhlVar5)) {
                                                        zzhwVar4 = zzhwVar3;
                                                        int i28 = i5;
                                                        zzhwVar4.zzad(i28, zzhlVar5);
                                                        i8 = i28;
                                                        i20 = i21;
                                                        zzhlVar = null;
                                                        zzhlVar2 = null;
                                                        if (zzhlVar4.zza() == 0) {
                                                            zzA();
                                                            Bundle zzF2 = zzqa.zzF(zzhlVar4.zzp());
                                                            int i29 = 0;
                                                            while (i29 < zzhlVar4.zza()) {
                                                                com.google.android.gms.internal.measurement.zzhq zzn = zzhlVar4.zzn(i29);
                                                                String str11 = str10;
                                                                if (!zzn.zzg().equals(str11) || zzn.zzi().isEmpty()) {
                                                                    i13 = i8;
                                                                    i14 = i6;
                                                                    if (!zzn.zzg().equals(str11)) {
                                                                        zzpvVar.zzaw(zzhlVar4.zzo(), (com.google.android.gms.internal.measurement.zzhp) zzn.zzch(), zzF2, zzprVar3.zza.zzF());
                                                                    }
                                                                } else {
                                                                    String zzF3 = zzprVar3.zza.zzF();
                                                                    List zzi = zzn.zzi();
                                                                    Bundle[] bundleArr = new Bundle[zzi.size()];
                                                                    i13 = i8;
                                                                    int i30 = 0;
                                                                    while (i30 < zzi.size()) {
                                                                        com.google.android.gms.internal.measurement.zzhq zzhqVar = (com.google.android.gms.internal.measurement.zzhq) zzi.get(i30);
                                                                        zzA();
                                                                        List list2 = zzi;
                                                                        Bundle zzF4 = zzqa.zzF(zzhqVar.zzi());
                                                                        Iterator it = zzhqVar.zzi().iterator();
                                                                        while (it.hasNext()) {
                                                                            zzpvVar.zzaw(zzhlVar4.zzo(), (com.google.android.gms.internal.measurement.zzhp) ((com.google.android.gms.internal.measurement.zzhq) it.next()).zzch(), zzF4, zzF3);
                                                                            it = it;
                                                                            i6 = i6;
                                                                        }
                                                                        bundleArr[i30] = zzF4;
                                                                        i30++;
                                                                        zzi = list2;
                                                                        i6 = i6;
                                                                    }
                                                                    i14 = i6;
                                                                    zzF2.putParcelableArray(str11, bundleArr);
                                                                }
                                                                i29++;
                                                                i8 = i13;
                                                                str10 = str11;
                                                                i6 = i14;
                                                            }
                                                            i9 = i8;
                                                            i10 = i6;
                                                            str5 = str10;
                                                            zzhlVar4.zzg();
                                                            zzqa zzA = zzA();
                                                            ArrayList arrayList2 = new ArrayList();
                                                            for (String str12 : zzF2.keySet()) {
                                                                com.google.android.gms.internal.measurement.zzhp zze2 = com.google.android.gms.internal.measurement.zzhq.zze();
                                                                zze2.zzj(str12);
                                                                Object obj = zzF2.get(str12);
                                                                if (obj != null) {
                                                                    zzA.zzw(zze2, obj);
                                                                    arrayList2.add((com.google.android.gms.internal.measurement.zzhq) zze2.zzba());
                                                                }
                                                            }
                                                            Iterator it2 = arrayList2.iterator();
                                                            while (it2.hasNext()) {
                                                                zzhlVar4.zzf((com.google.android.gms.internal.measurement.zzhq) it2.next());
                                                            }
                                                        } else {
                                                            i9 = i8;
                                                            i10 = i6;
                                                            str5 = str10;
                                                        }
                                                        i11 = i22;
                                                        zzprVar3.zzc.set(i11, (com.google.android.gms.internal.measurement.zzhm) zzhlVar4.zzba());
                                                        zzhwVar4.zzn(zzhlVar4);
                                                        i18 = i2 + 1;
                                                        i12 = i9;
                                                        i19 = i10;
                                                    }
                                                }
                                                zzhwVar4 = zzhwVar3;
                                                zzhlVar = zzhlVar4;
                                                i8 = i5;
                                                i20 = i2;
                                                if (zzhlVar4.zza() == 0) {
                                                }
                                                i11 = i22;
                                                zzprVar3.zzc.set(i11, (com.google.android.gms.internal.measurement.zzhm) zzhlVar4.zzba());
                                                zzhwVar4.zzn(zzhlVar4);
                                                i18 = i2 + 1;
                                                i12 = i9;
                                                i19 = i10;
                                            } else {
                                                zzhwVar4 = zzhwVar3;
                                                i7 = i5;
                                                i20 = i21;
                                                i8 = i7;
                                                zzhlVar = zzhlVar3;
                                                if (zzhlVar4.zza() == 0) {
                                                }
                                                i11 = i22;
                                                zzprVar3.zzc.set(i11, (com.google.android.gms.internal.measurement.zzhm) zzhlVar4.zzba());
                                                zzhwVar4.zzn(zzhlVar4);
                                                i18 = i2 + 1;
                                                i12 = i9;
                                                i19 = i10;
                                            }
                                        } else {
                                            zzhwVar4 = zzhwVar3;
                                            i7 = i5;
                                            if ("_vs".equals(zzhlVar4.zzo())) {
                                                zzA();
                                                if (zzqa.zzG((com.google.android.gms.internal.measurement.zzhm) zzhlVar4.zzba(), str2) == null) {
                                                    if (zzhlVar3 != null && Math.abs(zzhlVar3.zzc() - zzhlVar4.zzc()) <= 1000) {
                                                        com.google.android.gms.internal.measurement.zzhl zzhlVar6 = (com.google.android.gms.internal.measurement.zzhl) zzhlVar3.clone();
                                                        if (zzpvVar.zzaP(zzhlVar6, zzhlVar4)) {
                                                            zzhwVar4.zzad(i21, zzhlVar6);
                                                            i20 = i21;
                                                            i8 = i7;
                                                            zzhlVar = null;
                                                            zzhlVar2 = null;
                                                            if (zzhlVar4.zza() == 0) {
                                                            }
                                                            i11 = i22;
                                                            zzprVar3.zzc.set(i11, (com.google.android.gms.internal.measurement.zzhm) zzhlVar4.zzba());
                                                            zzhwVar4.zzn(zzhlVar4);
                                                            i18 = i2 + 1;
                                                            i12 = i9;
                                                            i19 = i10;
                                                        }
                                                    }
                                                    i20 = i21;
                                                    zzhlVar2 = zzhlVar4;
                                                    i8 = i2;
                                                    zzhlVar = zzhlVar3;
                                                    if (zzhlVar4.zza() == 0) {
                                                    }
                                                    i11 = i22;
                                                    zzprVar3.zzc.set(i11, (com.google.android.gms.internal.measurement.zzhm) zzhlVar4.zzba());
                                                    zzhwVar4.zzn(zzhlVar4);
                                                    i18 = i2 + 1;
                                                    i12 = i9;
                                                    i19 = i10;
                                                }
                                            }
                                            i20 = i21;
                                            i8 = i7;
                                            zzhlVar = zzhlVar3;
                                            if (zzhlVar4.zza() == 0) {
                                            }
                                            i11 = i22;
                                            zzprVar3.zzc.set(i11, (com.google.android.gms.internal.measurement.zzhm) zzhlVar4.zzba());
                                            zzhwVar4.zzn(zzhlVar4);
                                            i18 = i2 + 1;
                                            i12 = i9;
                                            i19 = i10;
                                        }
                                    }
                                    if ("_e".equals(zzhlVar4.zzo())) {
                                    }
                                }
                            }
                            str4 = str8;
                            int i31 = 0;
                            boolean z5 = false;
                            boolean z6 = false;
                            while (true) {
                                z3 = z4;
                                if (i31 >= zzhlVar4.zza()) {
                                    break;
                                }
                                if ("_c".equals(zzhlVar4.zzn(i31).zzg())) {
                                    com.google.android.gms.internal.measurement.zzhp zzhpVar = (com.google.android.gms.internal.measurement.zzhp) zzhlVar4.zzn(i31).zzch();
                                    zzhpVar.zzi(1L);
                                    zzhlVar4.zzk(i31, (com.google.android.gms.internal.measurement.zzhq) zzhpVar.zzba());
                                    zzhwVar5 = zzhwVar6;
                                    i15 = i16;
                                    z5 = true;
                                } else if ("_r".equals(zzhlVar4.zzn(i31).zzg())) {
                                    com.google.android.gms.internal.measurement.zzhp zzhpVar2 = (com.google.android.gms.internal.measurement.zzhp) zzhlVar4.zzn(i31).zzch();
                                    zzhwVar5 = zzhwVar6;
                                    i15 = i16;
                                    zzhpVar2.zzi(1L);
                                    zzhlVar4.zzk(i31, (com.google.android.gms.internal.measurement.zzhq) zzhpVar2.zzba());
                                    z6 = true;
                                } else {
                                    zzhwVar5 = zzhwVar6;
                                    i15 = i16;
                                }
                                i31++;
                                z4 = z3;
                                zzhwVar6 = zzhwVar5;
                                i16 = i15;
                            }
                            zzhwVar3 = zzhwVar6;
                            i5 = i16;
                            if (!z5 && zzw) {
                                zzaW().zzj().zzb("Marking event as conversion", zzpvVar.zzn.zzj().zzd(zzhlVar4.zzo()));
                                com.google.android.gms.internal.measurement.zzhp zze3 = com.google.android.gms.internal.measurement.zzhq.zze();
                                zze3.zzj("_c");
                                zze3.zzi(1L);
                                zzhlVar4.zze(zze3);
                            }
                            if (!z6) {
                                zzaW().zzj().zzb("Marking event as real-time", zzpvVar.zzn.zzj().zzd(zzhlVar4.zzo()));
                                com.google.android.gms.internal.measurement.zzhp zze4 = com.google.android.gms.internal.measurement.zzhq.zze();
                                zze4.zzj("_r");
                                zze4.zzi(1L);
                                zzhlVar4.zze(zze4);
                            }
                            if (zzj().zzo(zza(), zzprVar3.zza.zzF(), false, false, false, false, true, false, false).zze > zzi().zzh(zzprVar3.zza.zzF(), zzgi.zzo)) {
                                zzaB(zzhlVar4, "_r");
                                i6 = i;
                            } else {
                                i6 = 1;
                            }
                            if (zzqf.zzaq(zzhlVar4.zzo()) && zzw && zzj().zzo(zza(), zzprVar3.zza.zzF(), false, false, true, false, false, false, false).zzc > zzi().zzh(zzprVar3.zza.zzF(), zzgi.zzn)) {
                                zzaW().zzk().zzb("Too many conversions. Not logging as conversion. appId", zzhe.zzn(zzprVar3.zza.zzF()));
                                boolean z7 = false;
                                int i32 = -1;
                                com.google.android.gms.internal.measurement.zzhp zzhpVar3 = null;
                                for (int i33 = 0; i33 < zzhlVar4.zza(); i33++) {
                                    com.google.android.gms.internal.measurement.zzhq zzn2 = zzhlVar4.zzn(i33);
                                    if ("_c".equals(zzn2.zzg())) {
                                        zzhpVar3 = (com.google.android.gms.internal.measurement.zzhp) zzn2.zzch();
                                        i32 = i33;
                                    } else if ("_err".equals(zzn2.zzg())) {
                                        z7 = true;
                                    }
                                }
                                if (z7) {
                                    if (zzhpVar3 != null) {
                                        zzhlVar4.zzh(i32);
                                    } else {
                                        zzhpVar3 = null;
                                    }
                                }
                                if (zzhpVar3 != null) {
                                    com.google.android.gms.internal.measurement.zzhp zzhpVar4 = (com.google.android.gms.internal.measurement.zzhp) zzhpVar3.clone();
                                    zzhpVar4.zzj("_err");
                                    zzhpVar4.zzi(10L);
                                    zzhlVar4.zzk(i32, (com.google.android.gms.internal.measurement.zzhq) zzhpVar4.zzba());
                                } else {
                                    zzaW().zze().zzb("Did not find conversion parameter. appId", zzhe.zzn(zzprVar3.zza.zzF()));
                                }
                            }
                            if (zzw) {
                            }
                            if ("_e".equals(zzhlVar4.zzo())) {
                            }
                        }
                        i17 = i11 + 1;
                        i16 = i12;
                        zzhwVar6 = zzhwVar4;
                        str9 = str5;
                        str7 = str3;
                        str8 = str4;
                        z4 = z3;
                    }
                    com.google.android.gms.internal.measurement.zzhw zzhwVar7 = zzhwVar6;
                    long j3 = 0;
                    long j4 = 0;
                    int i34 = i2;
                    int i35 = 0;
                    while (i35 < i34) {
                        com.google.android.gms.internal.measurement.zzhm zzh2 = zzhwVar7.zzh(i35);
                        if ("_e".equals(zzh2.zzh())) {
                            zzA();
                            if (zzqa.zzG(zzh2, "_fr") != null) {
                                zzhwVar7.zzD(i35);
                                i34--;
                                i35--;
                                i35++;
                            }
                        }
                        zzA();
                        com.google.android.gms.internal.measurement.zzhq zzG = zzqa.zzG(zzh2, "_et");
                        if (zzG != null) {
                            Long valueOf = zzG.zzw() ? Long.valueOf(zzG.zzd()) : null;
                            if (valueOf != null && valueOf.longValue() > 0) {
                                j4 += valueOf.longValue();
                            }
                        }
                        i35++;
                    }
                    zzpvVar.zzaI(zzhwVar7, j4, false);
                    Iterator it3 = zzhwVar7.zzaM().iterator();
                    while (true) {
                        if (!it3.hasNext()) {
                            break;
                        }
                        if ("_s".equals(((com.google.android.gms.internal.measurement.zzhm) it3.next()).zzh())) {
                            zzj().zzP(zzhwVar7.zzaF(), "_se");
                            break;
                        }
                    }
                    if (zzqa.zza(zzhwVar7, "_sid") >= 0) {
                        zzpvVar.zzaI(zzhwVar7, j4, true);
                    } else {
                        int zza = zzqa.zza(zzhwVar7, "_se");
                        if (zza >= 0) {
                            zzhwVar7.zzE(zza);
                            zzaW().zze().zzb("Session engagement user property is in the bundle without session ID. appId", zzhe.zzn(zzprVar3.zza.zzF()));
                        }
                    }
                    String zzF5 = zzprVar3.zza.zzF();
                    zzaX().zzg();
                    zzM();
                    zzh zzl = zzj().zzl(zzF5);
                    if (zzl == null) {
                        zzaW().zze().zzb("Cannot fix consent fields without appInfo. appId", zzhe.zzn(zzF5));
                    } else {
                        zzpvVar.zzQ(zzl, zzhwVar7);
                    }
                    String zzF6 = zzprVar3.zza.zzF();
                    zzaX().zzg();
                    zzM();
                    zzh zzl2 = zzj().zzl(zzF6);
                    if (zzl2 == null) {
                        zzaW().zzk().zzb("Cannot populate ad_campaign_info without appInfo. appId", zzhe.zzn(zzF6));
                    } else {
                        zzpvVar.zzaa(zzl2, zzhwVar7);
                    }
                    zzhwVar7.zzax(Long.MAX_VALUE);
                    zzhwVar7.zzab(Long.MIN_VALUE);
                    for (int i36 = 0; i36 < zzhwVar7.zzc(); i36++) {
                        com.google.android.gms.internal.measurement.zzhm zzh3 = zzhwVar7.zzh(i36);
                        if (zzh3.zzd() < zzhwVar7.zzf()) {
                            zzhwVar7.zzax(zzh3.zzd());
                        }
                        if (zzh3.zzd() > zzhwVar7.zze()) {
                            zzhwVar7.zzab(zzh3.zzd());
                        }
                    }
                    zzhwVar7.zzB();
                    zzjx zzjxVar = zzjx.zza;
                    zzjx zzl3 = zzpvVar.zzu(zzprVar3.zza.zzF()).zzl(zzjx.zzk(zzprVar3.zza.zzK(), 100));
                    zzjx zzt2 = zzj().zzt(zzprVar3.zza.zzF());
                    zzj().zzW(zzprVar3.zza.zzF(), zzl3);
                    zzjw zzjwVar = zzjw.ANALYTICS_STORAGE;
                    if (zzl3.zzr(zzjwVar) || !zzt2.zzr(zzjwVar)) {
                        if (zzl3.zzr(zzjwVar) && !zzt2.zzr(zzjwVar)) {
                            zzj().zzQ(zzprVar3.zza.zzF());
                        }
                    } else {
                        zzj().zzI(zzprVar3.zza.zzF());
                    }
                    zzjw zzjwVar2 = zzjw.AD_STORAGE;
                    if (!zzl3.zzr(zzjwVar2)) {
                        zzhwVar7.zzz();
                        zzhwVar7.zzw();
                        zzhwVar7.zzt();
                    }
                    if (!zzl3.zzr(zzjwVar)) {
                        zzhwVar7.zzq();
                        zzhwVar7.zzA();
                    }
                    zzqr.zzb();
                    if (zzi().zzx(zzprVar3.zza.zzF(), zzgi.zzaV) && zzB().zzab(zzprVar3.zza.zzF()) && zzpvVar.zzu(zzprVar3.zza.zzF()).zzr(zzjwVar2) && zzprVar3.zza.zzbt()) {
                        zzpvVar.zzR(zzhwVar7, zzprVar3);
                    }
                    zzhwVar7.zzr();
                    zzhwVar7.zzi(zzh().zza(zzhwVar7.zzaF(), zzhwVar7.zzaM(), zzhwVar7.zzaN(), Long.valueOf(zzhwVar7.zzf()), Long.valueOf(zzhwVar7.zze()), !zzl3.zzr(zzjwVar)));
                    if (zzi().zzB(zzprVar3.zza.zzF())) {
                        try {
                            HashMap hashMap3 = new HashMap();
                            ArrayList arrayList3 = new ArrayList();
                            SecureRandom zzJ = zzB().zzJ();
                            int i37 = 0;
                            while (i37 < zzhwVar7.zzc()) {
                                com.google.android.gms.internal.measurement.zzhl zzhlVar7 = (com.google.android.gms.internal.measurement.zzhl) zzhwVar7.zzh(i37).zzch();
                                if (zzhlVar7.zzo().equals("_ep")) {
                                    zzA();
                                    String str13 = (String) zzqa.zzH((com.google.android.gms.internal.measurement.zzhm) zzhlVar7.zzba(), "_en");
                                    zzbd zzbdVar = (zzbd) hashMap3.get(str13);
                                    if (zzbdVar == null && (zzbdVar = zzj().zzs(zzprVar3.zza.zzF(), (String) Preconditions.checkNotNull(str13))) != null) {
                                        hashMap3.put(str13, zzbdVar);
                                    }
                                    if (zzbdVar != null && zzbdVar.zzi == null) {
                                        Long l = zzbdVar.zzj;
                                        if (l != null && l.longValue() > 1) {
                                            zzA();
                                            zzqa.zzD(zzhlVar7, "_sr", l);
                                        }
                                        Boolean bool = zzbdVar.zzk;
                                        if (bool != null && bool.booleanValue()) {
                                            zzA();
                                            zzqa.zzD(zzhlVar7, "_efs", 1L);
                                        }
                                        arrayList3.add((com.google.android.gms.internal.measurement.zzhm) zzhlVar7.zzba());
                                    }
                                    zzhwVar7.zzad(i37, zzhlVar7);
                                    zzhwVar2 = zzhwVar7;
                                    zzprVar2 = zzprVar3;
                                } else {
                                    zzif zzr = zzr();
                                    String zzF7 = zzprVar3.zza.zzF();
                                    String zza2 = zzr.zza(zzF7, "measurement.account.time_zone_offset_minutes");
                                    if (!TextUtils.isEmpty(zza2)) {
                                        try {
                                            parseLong = Long.parseLong(zza2);
                                        } catch (NumberFormatException e) {
                                            zzr.zzu.zzaW().zzk().zzc("Unable to parse timezone offset. appId", zzhe.zzn(zzF7), e);
                                        }
                                        long zzt3 = zzB().zzt(zzhlVar7.zzc(), parseLong);
                                        com.google.android.gms.internal.measurement.zzhm zzhmVar = (com.google.android.gms.internal.measurement.zzhm) zzhlVar7.zzba();
                                        Long l2 = 1L;
                                        if (!TextUtils.isEmpty("_dbg")) {
                                            Iterator it4 = zzhmVar.zzi().iterator();
                                            while (true) {
                                                if (!it4.hasNext()) {
                                                    break;
                                                }
                                                com.google.android.gms.internal.measurement.zzhq zzhqVar2 = (com.google.android.gms.internal.measurement.zzhq) it4.next();
                                                Iterator it5 = it4;
                                                if (!"_dbg".equals(zzhqVar2.zzg())) {
                                                    it4 = it5;
                                                } else if (l2.equals(Long.valueOf(zzhqVar2.zzd()))) {
                                                    zzc = 1;
                                                }
                                            }
                                        }
                                        zzc = zzr().zzc(zzprVar3.zza.zzF(), zzhlVar7.zzo());
                                        if (zzc > 0) {
                                            zzaW().zzk().zzc("Sample rate must be positive. event, rate", zzhlVar7.zzo(), Integer.valueOf(zzc));
                                            arrayList3.add((com.google.android.gms.internal.measurement.zzhm) zzhlVar7.zzba());
                                            zzhwVar7.zzad(i37, zzhlVar7);
                                            zzhwVar2 = zzhwVar7;
                                            zzprVar2 = zzprVar3;
                                        } else {
                                            zzbd zzbdVar2 = (zzbd) hashMap3.get(zzhlVar7.zzo());
                                            if (zzbdVar2 == null) {
                                                j2 = parseLong;
                                                zzbdVar2 = zzj().zzs(zzprVar3.zza.zzF(), zzhlVar7.zzo());
                                                if (zzbdVar2 == null) {
                                                    zzaW().zzk().zzc("Event being bundled has no eventAggregate. appId, eventName", zzprVar3.zza.zzF(), zzhlVar7.zzo());
                                                    zzbdVar2 = new zzbd(zzprVar3.zza.zzF(), zzhlVar7.zzo(), 1L, 1L, 1L, zzhlVar7.zzc(), 0L, null, null, null, null);
                                                }
                                            } else {
                                                j2 = parseLong;
                                            }
                                            zzA();
                                            Long l3 = (Long) zzqa.zzH((com.google.android.gms.internal.measurement.zzhm) zzhlVar7.zzba(), "_eid");
                                            boolean z8 = l3 != null;
                                            Boolean valueOf2 = Boolean.valueOf(z8);
                                            zzprVar2 = zzprVar3;
                                            if (zzc == 1) {
                                                arrayList3.add((com.google.android.gms.internal.measurement.zzhm) zzhlVar7.zzba());
                                                valueOf2.getClass();
                                                if (z8 && (zzbdVar2.zzi != null || zzbdVar2.zzj != null || zzbdVar2.zzk != null)) {
                                                    hashMap3.put(zzhlVar7.zzo(), zzbdVar2.zza(null, null, null));
                                                }
                                                zzhwVar7.zzad(i37, zzhlVar7);
                                                zzhwVar2 = zzhwVar7;
                                            } else {
                                                if (zzJ.nextInt(zzc) == 0) {
                                                    zzA();
                                                    com.google.android.gms.internal.measurement.zzhw zzhwVar8 = zzhwVar7;
                                                    Long valueOf3 = Long.valueOf(zzc);
                                                    zzqa.zzD(zzhlVar7, "_sr", valueOf3);
                                                    arrayList3.add((com.google.android.gms.internal.measurement.zzhm) zzhlVar7.zzba());
                                                    valueOf2.getClass();
                                                    if (z8) {
                                                        zzbdVar2 = zzbdVar2.zza(null, valueOf3, null);
                                                    }
                                                    hashMap3.put(zzhlVar7.zzo(), zzbdVar2.zzb(zzhlVar7.zzc(), zzt3));
                                                    hashMap2 = hashMap3;
                                                    secureRandom = zzJ;
                                                    i4 = i37;
                                                    zzhwVar2 = zzhwVar8;
                                                } else {
                                                    com.google.android.gms.internal.measurement.zzhw zzhwVar9 = zzhwVar7;
                                                    Long l4 = zzbdVar2.zzh;
                                                    if (l4 != null) {
                                                        zzt = l4.longValue();
                                                        hashMap = hashMap3;
                                                        secureRandom = zzJ;
                                                        i3 = i37;
                                                    } else {
                                                        secureRandom = zzJ;
                                                        i3 = i37;
                                                        hashMap = hashMap3;
                                                        zzt = zzB().zzt(zzhlVar7.zzb(), j2);
                                                    }
                                                    if (zzt != zzt3) {
                                                        zzA();
                                                        zzqa.zzD(zzhlVar7, "_efs", 1L);
                                                        zzA();
                                                        Long valueOf4 = Long.valueOf(zzc);
                                                        zzqa.zzD(zzhlVar7, "_sr", valueOf4);
                                                        arrayList3.add((com.google.android.gms.internal.measurement.zzhm) zzhlVar7.zzba());
                                                        valueOf2.getClass();
                                                        if (z8) {
                                                            zzbdVar2 = zzbdVar2.zza(null, valueOf4, true);
                                                        }
                                                        hashMap2 = hashMap;
                                                        hashMap2.put(zzhlVar7.zzo(), zzbdVar2.zzb(zzhlVar7.zzc(), zzt3));
                                                    } else {
                                                        hashMap2 = hashMap;
                                                        valueOf2.getClass();
                                                        if (z8) {
                                                            hashMap2.put(zzhlVar7.zzo(), zzbdVar2.zza(l3, null, null));
                                                        }
                                                    }
                                                    i4 = i3;
                                                    zzhwVar2 = zzhwVar9;
                                                }
                                                zzhwVar2.zzad(i4, zzhlVar7);
                                                i37 = i4 + 1;
                                                zzJ = secureRandom;
                                                zzhwVar7 = zzhwVar2;
                                                hashMap3 = hashMap2;
                                                zzprVar3 = zzprVar2;
                                                j3 = 0;
                                                zzpvVar = this;
                                            }
                                        }
                                    }
                                    parseLong = j3;
                                    long zzt32 = zzB().zzt(zzhlVar7.zzc(), parseLong);
                                    com.google.android.gms.internal.measurement.zzhm zzhmVar2 = (com.google.android.gms.internal.measurement.zzhm) zzhlVar7.zzba();
                                    Long l22 = 1L;
                                    if (!TextUtils.isEmpty("_dbg")) {
                                    }
                                    zzc = zzr().zzc(zzprVar3.zza.zzF(), zzhlVar7.zzo());
                                    if (zzc > 0) {
                                    }
                                }
                                hashMap2 = hashMap3;
                                secureRandom = zzJ;
                                i4 = i37;
                                i37 = i4 + 1;
                                zzJ = secureRandom;
                                zzhwVar7 = zzhwVar2;
                                hashMap3 = hashMap2;
                                zzprVar3 = zzprVar2;
                                j3 = 0;
                                zzpvVar = this;
                            }
                            zzhwVar = zzhwVar7;
                            zzpr zzprVar4 = zzprVar3;
                            HashMap hashMap4 = hashMap3;
                            z2 = true;
                            if (arrayList3.size() < zzhwVar.zzc()) {
                                zzhwVar.zzu();
                                zzhwVar.zzj(arrayList3);
                            }
                            Iterator it6 = hashMap4.entrySet().iterator();
                            while (it6.hasNext()) {
                                zzj().zzV((zzbd) ((Map.Entry) it6.next()).getValue());
                            }
                            zzprVar = zzprVar4;
                        } catch (Throwable th) {
                            th = th;
                            Throwable th2 = th;
                            zzj().zzL();
                            throw th2;
                        }
                    } else {
                        zzhwVar = zzhwVar7;
                        z2 = true;
                        zzprVar = zzprVar3;
                    }
                    String zzF8 = zzprVar.zza.zzF();
                    zzh zzl4 = zzj().zzl(zzF8);
                    if (zzl4 == null) {
                        zzaW().zze().zzb("Bundling raw events w/o app info. appId", zzhe.zzn(zzprVar.zza.zzF()));
                    } else if (zzhwVar.zzc() > 0) {
                        long zzs = zzl4.zzs();
                        if (zzs != 0) {
                            zzhwVar.zzap(zzs);
                        } else {
                            zzhwVar.zzx();
                        }
                        long zzu = zzl4.zzu();
                        if (zzu != 0) {
                            zzs = zzu;
                        }
                        if (zzs != 0) {
                            zzhwVar.zzaq(zzs);
                        } else {
                            zzhwVar.zzy();
                        }
                        zzl4.zzQ(zzhwVar.zzc());
                        zzhwVar.zzV((int) zzl4.zzr());
                        zzhwVar.zzP((int) zzl4.zzt());
                        zzl4.zzau(zzhwVar.zzf());
                        zzl4.zzas(zzhwVar.zze());
                        String zzB = zzl4.zzB();
                        if (zzB != null) {
                            zzhwVar.zzaj(zzB);
                        } else {
                            zzhwVar.zzv();
                        }
                        zzj().zzT(zzl4, false, false);
                    }
                    if (zzhwVar.zzc() > 0) {
                        this.zzn.zzaV();
                        com.google.android.gms.internal.measurement.zzgo zzj2 = zzr().zzj(zzprVar.zza.zzF());
                        try {
                            try {
                                if (zzj2 != null && zzj2.zzw()) {
                                    zzhwVar.zzR(zzj2.zzc());
                                    zzj = zzj();
                                    zzhxVar = (com.google.android.gms.internal.measurement.zzhx) zzhwVar.zzba();
                                    zzj.zzg();
                                    zzj.zzav();
                                    Preconditions.checkNotNull(zzhxVar);
                                    Preconditions.checkNotEmpty(zzhxVar.zzF());
                                    Preconditions.checkState(zzhxVar.zzbK());
                                    zzj.zzO();
                                    zzio zzioVar = zzj.zzu;
                                    currentTimeMillis = zzioVar.zzaU().currentTimeMillis();
                                    zzo = zzhxVar.zzo();
                                    zzioVar.zzf();
                                    if (zzo >= currentTimeMillis - zzam.zzI()) {
                                        long zzo4 = zzhxVar.zzo();
                                        zzioVar.zzf();
                                    }
                                    zzioVar.zzaW().zzk().zzd("Storing bundle outside of the max uploading time span. appId, now, timestamp", zzhe.zzn(zzhxVar.zzF()), Long.valueOf(currentTimeMillis), Long.valueOf(zzhxVar.zzo()));
                                    byte[] zzB2 = zzj.zzg.zzA().zzB(zzhxVar.zzcd());
                                    zzio zzioVar2 = zzj.zzu;
                                    zzioVar2.zzaW().zzj().zzb("Saving bundle, size", Integer.valueOf(zzB2.length));
                                    contentValues = new ContentValues();
                                    contentValues.put("app_id", zzhxVar.zzF());
                                    contentValues.put("bundle_end_timestamp", Long.valueOf(zzhxVar.zzo()));
                                    contentValues.put("data", zzB2);
                                    contentValues.put("has_realtime", Integer.valueOf(i));
                                    if (zzhxVar.zzbR()) {
                                        contentValues.put("retry_count", Integer.valueOf(zzhxVar.zzg()));
                                    }
                                    if (zzj.zzj().insert("queue", null, contentValues) == -1) {
                                        zzioVar2.zzaW().zze().zzb("Failed to insert bundle (got -1). appId", zzhe.zzn(zzhxVar.zzF()));
                                    }
                                }
                                if (zzj.zzj().insert("queue", null, contentValues) == -1) {
                                }
                            } catch (SQLiteException e2) {
                                zzj.zzu.zzaW().zze().zzc("Error storing bundle. appId", zzhe.zzn(zzhxVar.zzF()), e2);
                            }
                            byte[] zzB22 = zzj.zzg.zzA().zzB(zzhxVar.zzcd());
                            zzio zzioVar22 = zzj.zzu;
                            zzioVar22.zzaW().zzj().zzb("Saving bundle, size", Integer.valueOf(zzB22.length));
                            contentValues = new ContentValues();
                            contentValues.put("app_id", zzhxVar.zzF());
                            contentValues.put("bundle_end_timestamp", Long.valueOf(zzhxVar.zzo()));
                            contentValues.put("data", zzB22);
                            contentValues.put("has_realtime", Integer.valueOf(i));
                            if (zzhxVar.zzbR()) {
                            }
                        } catch (IOException e3) {
                            zzj.zzu.zzaW().zze().zzc("Data loss. Failed to serialize bundle. appId", zzhe.zzn(zzhxVar.zzF()), e3);
                        }
                        if (zzprVar.zza.zzP().isEmpty()) {
                            zzhwVar.zzR(-1L);
                        } else {
                            zzaW().zzk().zzb("Did not find measurement config or missing version info. appId", zzhe.zzn(zzprVar.zza.zzF()));
                        }
                        zzj = zzj();
                        zzhxVar = (com.google.android.gms.internal.measurement.zzhx) zzhwVar.zzba();
                        zzj.zzg();
                        zzj.zzav();
                        Preconditions.checkNotNull(zzhxVar);
                        Preconditions.checkNotEmpty(zzhxVar.zzF());
                        Preconditions.checkState(zzhxVar.zzbK());
                        zzj.zzO();
                        zzio zzioVar3 = zzj.zzu;
                        currentTimeMillis = zzioVar3.zzaU().currentTimeMillis();
                        zzo = zzhxVar.zzo();
                        zzioVar3.zzf();
                        if (zzo >= currentTimeMillis - zzam.zzI()) {
                        }
                        zzioVar3.zzaW().zzk().zzd("Storing bundle outside of the max uploading time span. appId, now, timestamp", zzhe.zzn(zzhxVar.zzF()), Long.valueOf(currentTimeMillis), Long.valueOf(zzhxVar.zzo()));
                    }
                    zzj().zzJ(zzprVar.zzb);
                    zzaw zzj3 = zzj();
                    try {
                        zzj3.zzj().execSQL("delete from raw_events_metadata where app_id=? and metadata_fingerprint not in (select distinct metadata_fingerprint from raw_events where app_id=?)", new String[]{zzF8, zzF8});
                    } catch (SQLiteException e4) {
                        zzj3.zzu.zzaW().zze().zzc("Failed to remove unused event metadata. appId", zzhe.zzn(zzF8), e4);
                    }
                    zzj().zzS();
                    z = z2;
                    zzj().zzL();
                    return z;
                }
                z = false;
                zzj().zzS();
                zzj().zzL();
                return z;
            } catch (Throwable th3) {
                th = th3;
                Throwable th22 = th;
                zzj().zzL();
                throw th22;
            }
        } catch (Throwable th4) {
            th = th4;
        }
    }

    private final boolean zzaN() {
        zzaX().zzg();
        zzM();
        return zzj().zzaa() || !TextUtils.isEmpty(zzj().zzA());
    }

    private final boolean zzaO(String str, String str2) {
        zzbd zzs = zzj().zzs(str, str2);
        return zzs == null || zzs.zzc < 1;
    }

    private final boolean zzaP(com.google.android.gms.internal.measurement.zzhl zzhlVar, com.google.android.gms.internal.measurement.zzhl zzhlVar2) {
        Preconditions.checkArgument("_e".equals(zzhlVar.zzo()));
        zzA();
        com.google.android.gms.internal.measurement.zzhq zzG = zzqa.zzG((com.google.android.gms.internal.measurement.zzhm) zzhlVar.zzba(), "_sc");
        String zzh = zzG == null ? null : zzG.zzh();
        zzA();
        com.google.android.gms.internal.measurement.zzhq zzG2 = zzqa.zzG((com.google.android.gms.internal.measurement.zzhm) zzhlVar2.zzba(), "_pc");
        String zzh2 = zzG2 != null ? zzG2.zzh() : null;
        if (zzh2 == null || !zzh2.equals(zzh)) {
            return false;
        }
        Preconditions.checkArgument("_e".equals(zzhlVar.zzo()));
        zzA();
        com.google.android.gms.internal.measurement.zzhq zzG3 = zzqa.zzG((com.google.android.gms.internal.measurement.zzhm) zzhlVar.zzba(), "_et");
        if (zzG3 == null || !zzG3.zzw() || zzG3.zzd() <= 0) {
            return true;
        }
        long zzd = zzG3.zzd();
        zzA();
        com.google.android.gms.internal.measurement.zzhq zzG4 = zzqa.zzG((com.google.android.gms.internal.measurement.zzhm) zzhlVar2.zzba(), "_et");
        if (zzG4 != null && zzG4.zzd() > 0) {
            zzd += zzG4.zzd();
        }
        zzA();
        zzqa.zzD(zzhlVar2, "_et", Long.valueOf(zzd));
        zzA();
        zzqa.zzD(zzhlVar, "_fr", 1L);
        return true;
    }

    private static final boolean zzaQ(zzr zzrVar) {
        return (TextUtils.isEmpty(zzrVar.zzb) && TextUtils.isEmpty(zzrVar.zzp)) ? false : true;
    }

    private static final zzpg zzaR(zzpg zzpgVar) {
        if (zzpgVar != null) {
            if (zzpgVar.zzax()) {
                return zzpgVar;
            }
            throw new IllegalStateException("Component not initialized: ".concat(String.valueOf(String.valueOf(zzpgVar.getClass()))));
        }
        throw new IllegalStateException("Upload Component not created");
    }

    private static final Boolean zzaS(zzr zzrVar) {
        Boolean bool = zzrVar.zzq;
        String str = zzrVar.zzE;
        if (!TextUtils.isEmpty(str)) {
            zzju zzb2 = zze.zza(str).zzb();
            zzju zzjuVar = zzju.UNINITIALIZED;
            int ordinal = zzb2.ordinal();
            if (ordinal == 0 || ordinal == 1) {
                return null;
            }
            if (ordinal == 2) {
                return true;
            }
            if (ordinal == 3) {
                return false;
            }
        }
        return bool;
    }

    public static zzpv zzz(Context context) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(context.getApplicationContext());
        if (zzb == null) {
            synchronized (zzpv.class) {
                if (zzb == null) {
                    zzb = new zzpv((zzpw) Preconditions.checkNotNull(new zzpw(context)), null);
                }
            }
        }
        return zzb;
    }

    public final zzqa zzA() {
        zzqa zzqaVar = this.zzi;
        zzaR(zzqaVar);
        return zzqaVar;
    }

    public final zzqf zzB() {
        return ((zzio) Preconditions.checkNotNull(this.zzn)).zzw();
    }

    final String zzC(zzjx zzjxVar) {
        if (!zzjxVar.zzr(zzjw.ANALYTICS_STORAGE)) {
            return null;
        }
        byte[] bArr = new byte[16];
        zzB().zzJ().nextBytes(bArr);
        return String.format(Locale.US, "%032x", new BigInteger(1, bArr));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String zzD(zzr zzrVar) {
        try {
            return (String) zzaX().zzf(new zzpo(this, zzrVar)).get(30000L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            zzaW().zze().zzc("Failed to get app instance id. appId", zzhe.zzn(zzrVar.zza), e);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00e9, code lost:
    
        if (r2.moveToFirst() != false) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00eb, code lost:
    
        r3 = r2.getString(0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00ef, code lost:
    
        if (r3 != null) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00f1, code lost:
    
        r3 = "";
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00f3, code lost:
    
        r1.add(new com.google.android.gms.measurement.internal.zzov(r3, r2.getLong(1), r2.getInt(2)));
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0109, code lost:
    
        if (r2.moveToNext() != false) goto L54;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final List zzF(zzr zzrVar, Bundle bundle) {
        List arrayList;
        Cursor cursor;
        zzaX().zzg();
        zzqr.zzb();
        zzam zzi = zzi();
        String str = zzrVar.zza;
        if (!zzi.zzx(str, zzgi.zzaV) || str == null) {
            return new ArrayList();
        }
        if (bundle != null) {
            int[] intArray = bundle.getIntArray("uriSources");
            long[] longArray = bundle.getLongArray("uriTimestamps");
            if (intArray != null) {
                if (longArray == null || longArray.length != intArray.length) {
                    zzaW().zze().zza("Uri sources and timestamps do not match");
                } else {
                    for (int i = 0; i < intArray.length; i++) {
                        zzaw zzj = zzj();
                        int i2 = intArray[i];
                        long j = longArray[i];
                        Preconditions.checkNotEmpty(str);
                        zzj.zzg();
                        zzj.zzav();
                        try {
                            int delete = zzj.zzj().delete("trigger_uris", "app_id=? and source=? and timestamp_millis<=?", new String[]{str, String.valueOf(i2), String.valueOf(j)});
                            zzj.zzu.zzaW().zzj().zzd("Pruned " + delete + " trigger URIs. appId, source, timestamp", str, Integer.valueOf(i2), Long.valueOf(j));
                        } catch (SQLiteException e) {
                            zzj.zzu.zzaW().zze().zzc("Error pruning trigger URIs. appId", zzhe.zzn(str), e);
                        }
                    }
                }
            }
        }
        zzaw zzj2 = zzj();
        String str2 = zzrVar.zza;
        Preconditions.checkNotEmpty(str2);
        zzj2.zzg();
        zzj2.zzav();
        arrayList = new ArrayList();
        cursor = null;
        try {
            try {
                cursor = zzj2.zzj().query("trigger_uris", new String[]{"trigger_uri", "timestamp_millis", "source"}, "app_id=?", new String[]{str2}, null, null, "rowid", null);
            } catch (SQLiteException e2) {
                zzj2.zzu.zzaW().zze().zzc("Error querying trigger uris. appId", zzhe.zzn(str2), e2);
                arrayList = Collections.emptyList();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
        if (cursor != null) {
            cursor.close();
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzK(Runnable runnable) {
        zzaX().zzg();
        if (this.zzq == null) {
            this.zzq = new ArrayList();
        }
        this.zzq.add(runnable);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzL() {
        zzaX().zzg();
        zzM();
        if (this.zzp) {
            return;
        }
        this.zzp = true;
        if (zzaz()) {
            FileChannel fileChannel = this.zzy;
            zzaX().zzg();
            int i = 0;
            if (fileChannel == null || !fileChannel.isOpen()) {
                zzaW().zze().zza("Bad channel to read from");
            } else {
                ByteBuffer allocate = ByteBuffer.allocate(4);
                try {
                    fileChannel.position(0L);
                    int read = fileChannel.read(allocate);
                    if (read == 4) {
                        allocate.flip();
                        i = allocate.getInt();
                    } else if (read != -1) {
                        zzaW().zzk().zzb("Unexpected data length. Bytes read", Integer.valueOf(read));
                    }
                } catch (IOException e) {
                    zzaW().zze().zzb("Failed to read from channel", e);
                }
            }
            int zzi = this.zzn.zzh().zzi();
            zzaX().zzg();
            if (i > zzi) {
                zzaW().zze().zzc("Panic: can't downgrade version. Previous, current version", Integer.valueOf(i), Integer.valueOf(zzi));
                return;
            }
            if (i < zzi) {
                FileChannel fileChannel2 = this.zzy;
                zzaX().zzg();
                if (fileChannel2 == null || !fileChannel2.isOpen()) {
                    zzaW().zze().zza("Bad channel to read from");
                } else {
                    ByteBuffer allocate2 = ByteBuffer.allocate(4);
                    allocate2.putInt(zzi);
                    allocate2.flip();
                    try {
                        fileChannel2.truncate(0L);
                        fileChannel2.write(allocate2);
                        fileChannel2.force(true);
                        if (fileChannel2.size() != 4) {
                            zzaW().zze().zzb("Error writing to channel. Bytes written", Long.valueOf(fileChannel2.size()));
                        }
                        zzaW().zzj().zzc("Storage version upgraded. Previous, current version", Integer.valueOf(i), Integer.valueOf(zzi));
                        return;
                    } catch (IOException e2) {
                        zzaW().zze().zzb("Failed to write to channel", e2);
                    }
                }
                zzaW().zze().zzc("Storage version upgrade failed. Previous, current version", Integer.valueOf(i), Integer.valueOf(zzi));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzM() {
        if (!this.zzo.get()) {
            throw new IllegalStateException("UploadController is not initialized");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzN(String str, com.google.android.gms.internal.measurement.zzhw zzhwVar) {
        int zza;
        int indexOf;
        Set zzo = zzr().zzo(str);
        if (zzo != null) {
            zzhwVar.zzl(zzo);
        }
        if (zzr().zzB(str)) {
            zzhwVar.zzs();
        }
        if (zzr().zzE(str)) {
            String zzaK = zzhwVar.zzaK();
            if (!TextUtils.isEmpty(zzaK) && (indexOf = zzaK.indexOf(".")) != -1) {
                zzhwVar.zzam(zzaK.substring(0, indexOf));
            }
        }
        if (zzr().zzF(str) && (zza = zzqa.zza(zzhwVar, "_id")) != -1) {
            zzhwVar.zzE(zza);
        }
        if (zzr().zzD(str)) {
            zzhwVar.zzt();
        }
        if (zzr().zzA(str)) {
            zzhwVar.zzq();
            if (zzu(str).zzr(zzjw.ANALYTICS_STORAGE)) {
                Map map = this.zzE;
                zzps zzpsVar = (zzps) map.get(str);
                if (zzpsVar == null || zzpsVar.zzb + zzi().zzk(str, zzgi.zzaj) < zzaU().elapsedRealtime()) {
                    zzpsVar = new zzps(this);
                    map.put(str, zzpsVar);
                }
                zzhwVar.zzac(zzpsVar.zza);
            }
        }
        if (zzr().zzC(str)) {
            zzhwVar.zzA();
        }
    }

    final void zzO(zzh zzhVar) {
        zzaX().zzg();
        if (!TextUtils.isEmpty(zzhVar.zzH()) || !TextUtils.isEmpty(zzhVar.zzA())) {
            String str = (String) Preconditions.checkNotNull(zzhVar.zzC());
            zzaW().zzj().zzb("Fetching remote configuration", str);
            com.google.android.gms.internal.measurement.zzgo zzj = zzr().zzj(str);
            String zzl = zzr().zzl(str);
            ArrayMap arrayMap = null;
            if (zzj != null) {
                if (!TextUtils.isEmpty(zzl)) {
                    ArrayMap arrayMap2 = new ArrayMap();
                    arrayMap2.put(HttpHeaders.IF_MODIFIED_SINCE, zzl);
                    arrayMap = arrayMap2;
                }
                String zzk = zzr().zzk(str);
                if (!TextUtils.isEmpty(zzk)) {
                    if (arrayMap == null) {
                        arrayMap = new ArrayMap();
                    }
                    arrayMap.put(HttpHeaders.IF_NONE_MATCH, zzk);
                }
            }
            this.zzu = true;
            zzp().zza(zzhVar, arrayMap, new zzhg() { // from class: com.google.android.gms.measurement.internal.zzpj
                @Override // com.google.android.gms.measurement.internal.zzhg
                public final void zza(String str2, int i, Throwable th, byte[] bArr, Map map) {
                    zzpv.this.zzW(str2, i, th, bArr, map);
                }
            });
            return;
        }
        zzW((String) Preconditions.checkNotNull(zzhVar.zzC()), MlKitException.CODE_SCANNER_TASK_IN_PROGRESS, null, null, null);
    }

    final void zzP(zzr zzrVar, long j) {
        zzh zzl = zzj().zzl((String) Preconditions.checkNotNull(zzrVar.zza));
        if (zzl != null && zzB().zzaw(zzrVar.zzb, zzl.zzH(), zzrVar.zzp, zzl.zzA())) {
            zzaW().zzk().zzb("New GMP App Id passed in. Removing cached database data. appId", zzhe.zzn(zzl.zzC()));
            zzaw zzj = zzj();
            String zzC = zzl.zzC();
            zzj.zzav();
            zzj.zzg();
            Preconditions.checkNotEmpty(zzC);
            try {
                SQLiteDatabase zzj2 = zzj.zzj();
                String[] strArr = {zzC};
                int delete = zzj2.delete("events", "app_id=?", strArr) + zzj2.delete("user_attributes", "app_id=?", strArr) + zzj2.delete("conditional_properties", "app_id=?", strArr) + zzj2.delete("apps", "app_id=?", strArr) + zzj2.delete("raw_events", "app_id=?", strArr) + zzj2.delete("raw_events_metadata", "app_id=?", strArr) + zzj2.delete("event_filters", "app_id=?", strArr) + zzj2.delete("property_filters", "app_id=?", strArr) + zzj2.delete("audience_filter_values", "app_id=?", strArr) + zzj2.delete("consent_settings", "app_id=?", strArr) + zzj2.delete("default_event_params", "app_id=?", strArr) + zzj2.delete("trigger_uris", "app_id=?", strArr);
                if (delete > 0) {
                    zzj.zzu.zzaW().zzj().zzc("Deleted application data. app, records", zzC, Integer.valueOf(delete));
                }
            } catch (SQLiteException e) {
                zzj.zzu.zzaW().zze().zzc("Error deleting application data. appId, error", zzhe.zzn(zzC), e);
            }
            zzl = null;
        }
        if (zzl != null) {
            boolean z = (zzl.zze() == -2147483648L || zzl.zze() == zzrVar.zzj) ? false : true;
            String zzF = zzl.zzF();
            if (z || ((zzl.zze() != -2147483648L || zzF == null || zzF.equals(zzrVar.zzc)) ? false : true)) {
                Bundle bundle = new Bundle();
                bundle.putString("_pv", zzF);
                zzbh zzbhVar = new zzbh("_au", new zzbf(bundle), "auto", j);
                if (zzi().zzx(null, zzgi.zzbm)) {
                    zzU(zzbhVar, zzrVar);
                } else {
                    zzS(zzbhVar, zzrVar);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzQ(zzh zzhVar, com.google.android.gms.internal.measurement.zzhw zzhwVar) {
        com.google.android.gms.internal.measurement.zzio zzioVar;
        zzaX().zzg();
        zzM();
        zzao zzb2 = zzao.zzb(zzhwVar.zzaH());
        String zzC = zzhVar.zzC();
        zzaX().zzg();
        zzM();
        zzjx zzu = zzu(zzC);
        zzju zzjuVar = zzju.UNINITIALIZED;
        int ordinal = zzu.zze().ordinal();
        if (ordinal == 1) {
            zzb2.zzd(zzjw.AD_STORAGE, zzan.REMOTE_ENFORCED_DEFAULT);
        } else if (ordinal == 2 || ordinal == 3) {
            zzb2.zzc(zzjw.AD_STORAGE, zzu.zzb());
        } else {
            zzb2.zzd(zzjw.AD_STORAGE, zzan.FAILSAFE);
        }
        int ordinal2 = zzu.zzf().ordinal();
        if (ordinal2 == 1) {
            zzb2.zzd(zzjw.ANALYTICS_STORAGE, zzan.REMOTE_ENFORCED_DEFAULT);
        } else if (ordinal2 == 2 || ordinal2 == 3) {
            zzb2.zzc(zzjw.ANALYTICS_STORAGE, zzu.zzb());
        } else {
            zzb2.zzd(zzjw.ANALYTICS_STORAGE, zzan.FAILSAFE);
        }
        String zzC2 = zzhVar.zzC();
        zzaX().zzg();
        zzM();
        zzba zzl = zzl(zzC2, zzm(zzC2), zzu(zzC2), zzb2);
        zzhwVar.zzak(((Boolean) Preconditions.checkNotNull(zzl.zzh())).booleanValue());
        if (!TextUtils.isEmpty(zzl.zzi())) {
            zzhwVar.zzU(zzl.zzi());
        }
        zzaX().zzg();
        zzM();
        Iterator it = zzhwVar.zzaN().iterator();
        while (true) {
            if (it.hasNext()) {
                zzioVar = (com.google.android.gms.internal.measurement.zzio) it.next();
                if ("_npa".equals(zzioVar.zzg())) {
                    break;
                }
            } else {
                zzioVar = null;
                break;
            }
        }
        if (zzioVar != null) {
            zzjw zzjwVar = zzjw.AD_PERSONALIZATION;
            if (zzb2.zza(zzjwVar) == zzan.UNSET) {
                zzqd zzy = zzj().zzy(zzhVar.zzC(), "_npa");
                if (zzy != null) {
                    String str = zzy.zzb;
                    if ("tcf".equals(str)) {
                        zzb2.zzd(zzjwVar, zzan.TCF);
                    } else if ("app".equals(str)) {
                        zzb2.zzd(zzjwVar, zzan.API);
                    } else {
                        zzb2.zzd(zzjwVar, zzan.MANIFEST);
                    }
                } else {
                    Boolean zzx = zzhVar.zzx();
                    if (zzx != null && ((!zzx.booleanValue() || zzioVar.zzc() == 1) && (zzx.booleanValue() || zzioVar.zzc() == 0))) {
                        zzb2.zzd(zzjwVar, zzan.MANIFEST);
                    } else {
                        zzb2.zzd(zzjwVar, zzan.API);
                    }
                }
            }
        } else {
            int zzaC = zzaC(zzhVar.zzC(), zzb2);
            com.google.android.gms.internal.measurement.zzin zze = com.google.android.gms.internal.measurement.zzio.zze();
            zze.zzf("_npa");
            zze.zzg(zzaU().currentTimeMillis());
            zze.zze(zzaC);
            zzhwVar.zzp((com.google.android.gms.internal.measurement.zzio) zze.zzba());
            zzaW().zzj().zzc("Setting user property", "non_personalized_ads(_npa)", Integer.valueOf(zzaC));
        }
        zzhwVar.zzS(zzb2.toString());
        boolean zzv = this.zzc.zzv(zzhVar.zzC());
        List zzaM = zzhwVar.zzaM();
        int i = 0;
        for (int i2 = 0; i2 < zzaM.size(); i2++) {
            if ("_tcf".equals(((com.google.android.gms.internal.measurement.zzhm) zzaM.get(i2)).zzh())) {
                com.google.android.gms.internal.measurement.zzhl zzhlVar = (com.google.android.gms.internal.measurement.zzhl) ((com.google.android.gms.internal.measurement.zzhm) zzaM.get(i2)).zzch();
                List zzp = zzhlVar.zzp();
                int i3 = 0;
                while (true) {
                    if (i3 >= zzp.size()) {
                        break;
                    }
                    if ("_tcfd".equals(((com.google.android.gms.internal.measurement.zzhq) zzp.get(i3)).zzg())) {
                        String zzh = ((com.google.android.gms.internal.measurement.zzhq) zzp.get(i3)).zzh();
                        if (zzv && zzh.length() > 4) {
                            char[] charArray = zzh.toCharArray();
                            int i4 = 1;
                            while (true) {
                                if (i4 >= 64) {
                                    break;
                                }
                                if (charArray[4] == "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-_".charAt(i4)) {
                                    i = i4;
                                    break;
                                }
                                i4++;
                            }
                            charArray[4] = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-_".charAt(i | 1);
                            zzh = String.valueOf(charArray);
                        }
                        com.google.android.gms.internal.measurement.zzhp zze2 = com.google.android.gms.internal.measurement.zzhq.zze();
                        zze2.zzj("_tcfd");
                        zze2.zzk(zzh);
                        zzhlVar.zzj(i3, zze2);
                    } else {
                        i3++;
                    }
                }
                zzhwVar.zzad(i2, zzhlVar);
                return;
            }
        }
    }

    final void zzR(com.google.android.gms.internal.measurement.zzhw zzhwVar, zzpr zzprVar) {
        for (int i = 0; i < zzhwVar.zzc(); i++) {
            com.google.android.gms.internal.measurement.zzhl zzhlVar = (com.google.android.gms.internal.measurement.zzhl) zzhwVar.zzh(i).zzch();
            Iterator it = zzhlVar.zzp().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                if ("_c".equals(((com.google.android.gms.internal.measurement.zzhq) it.next()).zzg())) {
                    if (zzprVar.zza.zza() >= zzi().zzh(zzprVar.zza.zzF(), zzgi.zzak)) {
                        int zzh = zzi().zzh(zzprVar.zza.zzF(), zzgi.zzax);
                        String str = null;
                        if (zzh <= 0) {
                            if (zzi().zzx(zzprVar.zza.zzF(), zzgi.zzaX)) {
                                str = zzB().zzF();
                                com.google.android.gms.internal.measurement.zzhp zze = com.google.android.gms.internal.measurement.zzhq.zze();
                                zze.zzj("_tu");
                                zze.zzk(str);
                                zzhlVar.zzf((com.google.android.gms.internal.measurement.zzhq) zze.zzba());
                            }
                            com.google.android.gms.internal.measurement.zzhp zze2 = com.google.android.gms.internal.measurement.zzhq.zze();
                            zze2.zzj("_tr");
                            zze2.zzi(1L);
                            zzhlVar.zzf((com.google.android.gms.internal.measurement.zzhq) zze2.zzba());
                            zzov zzl = zzA().zzl(zzprVar.zza.zzF(), zzhwVar, zzhlVar, str);
                            if (zzl != null) {
                                zzaW().zzj().zzc("Generated trigger URI. appId, uri", zzprVar.zza.zzF(), zzl.zza);
                                zzj().zzad(zzprVar.zza.zzF(), zzl);
                                Deque deque = this.zzr;
                                if (!deque.contains(zzprVar.zza.zzF())) {
                                    deque.add(zzprVar.zza.zzF());
                                }
                            }
                        } else if (zzj().zzo(zza(), zzprVar.zza.zzF(), false, false, false, false, false, false, true).zzg > zzh) {
                            com.google.android.gms.internal.measurement.zzhp zze3 = com.google.android.gms.internal.measurement.zzhq.zze();
                            zze3.zzj("_tnr");
                            zze3.zzi(1L);
                            zzhlVar.zzf((com.google.android.gms.internal.measurement.zzhq) zze3.zzba());
                        } else {
                            if (zzi().zzx(zzprVar.zza.zzF(), zzgi.zzaX)) {
                                str = zzB().zzF();
                                com.google.android.gms.internal.measurement.zzhp zze4 = com.google.android.gms.internal.measurement.zzhq.zze();
                                zze4.zzj("_tu");
                                zze4.zzk(str);
                                zzhlVar.zzf((com.google.android.gms.internal.measurement.zzhq) zze4.zzba());
                            }
                            com.google.android.gms.internal.measurement.zzhp zze5 = com.google.android.gms.internal.measurement.zzhq.zze();
                            zze5.zzj("_tr");
                            zze5.zzi(1L);
                            zzhlVar.zzf((com.google.android.gms.internal.measurement.zzhq) zze5.zzba());
                            zzov zzl2 = zzA().zzl(zzprVar.zza.zzF(), zzhwVar, zzhlVar, str);
                            if (zzl2 != null) {
                                zzaW().zzj().zzc("Generated trigger URI. appId, uri", zzprVar.zza.zzF(), zzl2.zza);
                                zzj().zzad(zzprVar.zza.zzF(), zzl2);
                                Deque deque2 = this.zzr;
                                if (!deque2.contains(zzprVar.zza.zzF())) {
                                    deque2.add(zzprVar.zza.zzF());
                                }
                            }
                        }
                    }
                    zzhwVar.zzae(i, (com.google.android.gms.internal.measurement.zzhm) zzhlVar.zzba());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzS(zzbh zzbhVar, zzr zzrVar) {
        zzbh zzbhVar2;
        List<zzai> zzC;
        List<zzai> zzC2;
        List<zzai> zzC3;
        String str;
        Preconditions.checkNotNull(zzrVar);
        String str2 = zzrVar.zza;
        Preconditions.checkNotEmpty(str2);
        zzaX().zzg();
        zzM();
        long j = zzbhVar.zzd;
        zzhf zzb2 = zzhf.zzb(zzbhVar);
        zzaX().zzg();
        zzqf.zzN((this.zzG == null || (str = this.zzH) == null || !str.equals(str2)) ? null : this.zzG, zzb2.zzd, false);
        zzbh zza = zzb2.zza();
        zzA();
        if (zzqa.zzE(zza, zzrVar)) {
            if (!zzrVar.zzh) {
                zzg(zzrVar);
                return;
            }
            List list = zzrVar.zzs;
            if (list != null) {
                String str3 = zza.zza;
                if (list.contains(str3)) {
                    Bundle zzc = zza.zzb.zzc();
                    zzc.putLong("ga_safelisted", 1L);
                    zzbhVar2 = new zzbh(str3, new zzbf(zzc), zza.zzc, zza.zzd);
                } else {
                    zzaW().zzd().zzd("Dropping non-safelisted event. appId, event name, origin", str2, zza.zza, zza.zzc);
                    return;
                }
            } else {
                zzbhVar2 = zza;
            }
            zzj().zzH();
            try {
                zzra.zzb();
                if (zzi().zzx(null, zzgi.zzbi) && "_s".equals(zzbhVar2.zza) && !zzj().zzZ(str2, "_s") && zzbhVar2.zzb.zze("_sid").longValue() != 0) {
                    if (!zzj().zzZ(str2, "_f") && !zzj().zzZ(str2, "_v")) {
                        zzj().zzG(str2, Long.valueOf(zzaU().currentTimeMillis() - 15000), "_sid", zzf(str2, zzbhVar2));
                    }
                    zzj().zzG(str2, null, "_sid", zzf(str2, zzbhVar2));
                }
                zzaw zzj = zzj();
                Preconditions.checkNotEmpty(str2);
                zzj.zzg();
                zzj.zzav();
                if (j < 0) {
                    zzj.zzu.zzaW().zzk().zzc("Invalid time querying timed out conditional properties", zzhe.zzn(str2), Long.valueOf(j));
                    zzC = Collections.emptyList();
                } else {
                    zzC = zzj.zzC("active=0 and app_id=? and abs(? - creation_timestamp) > trigger_timeout", new String[]{str2, String.valueOf(j)});
                }
                for (zzai zzaiVar : zzC) {
                    if (zzaiVar != null) {
                        zzaW().zzj().zzd("User property timed out", zzaiVar.zza, this.zzn.zzj().zzf(zzaiVar.zzc.zzb), zzaiVar.zzc.zza());
                        zzbh zzbhVar3 = zzaiVar.zzg;
                        if (zzbhVar3 != null) {
                            zzax(new zzbh(zzbhVar3, j), zzrVar);
                        }
                        zzj().zza(str2, zzaiVar.zzc.zzb);
                    }
                }
                zzaw zzj2 = zzj();
                Preconditions.checkNotEmpty(str2);
                zzj2.zzg();
                zzj2.zzav();
                if (j < 0) {
                    zzj2.zzu.zzaW().zzk().zzc("Invalid time querying expired conditional properties", zzhe.zzn(str2), Long.valueOf(j));
                    zzC2 = Collections.emptyList();
                } else {
                    zzC2 = zzj2.zzC("active<>0 and app_id=? and abs(? - triggered_timestamp) > time_to_live", new String[]{str2, String.valueOf(j)});
                }
                ArrayList arrayList = new ArrayList(zzC2.size());
                for (zzai zzaiVar2 : zzC2) {
                    if (zzaiVar2 != null) {
                        zzaW().zzj().zzd("User property expired", zzaiVar2.zza, this.zzn.zzj().zzf(zzaiVar2.zzc.zzb), zzaiVar2.zzc.zza());
                        zzj().zzP(str2, zzaiVar2.zzc.zzb);
                        zzbh zzbhVar4 = zzaiVar2.zzk;
                        if (zzbhVar4 != null) {
                            arrayList.add(zzbhVar4);
                        }
                        zzj().zza(str2, zzaiVar2.zzc.zzb);
                    }
                }
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    zzax(new zzbh((zzbh) it.next(), j), zzrVar);
                }
                zzaw zzj3 = zzj();
                String str4 = zzbhVar2.zza;
                Preconditions.checkNotEmpty(str2);
                Preconditions.checkNotEmpty(str4);
                zzj3.zzg();
                zzj3.zzav();
                if (j < 0) {
                    zzio zzioVar = zzj3.zzu;
                    zzioVar.zzaW().zzk().zzd("Invalid time querying triggered conditional properties", zzhe.zzn(str2), zzioVar.zzj().zzd(str4), Long.valueOf(j));
                    zzC3 = Collections.emptyList();
                } else {
                    zzC3 = zzj3.zzC("active=0 and app_id=? and trigger_event_name=? and abs(? - creation_timestamp) <= trigger_timeout", new String[]{str2, str4, String.valueOf(j)});
                }
                ArrayList arrayList2 = new ArrayList(zzC3.size());
                for (zzai zzaiVar3 : zzC3) {
                    if (zzaiVar3 != null) {
                        zzqb zzqbVar = zzaiVar3.zzc;
                        zzqd zzqdVar = new zzqd((String) Preconditions.checkNotNull(zzaiVar3.zza), zzaiVar3.zzb, zzqbVar.zzb, j, Preconditions.checkNotNull(zzqbVar.zza()));
                        if (zzj().zzai(zzqdVar)) {
                            zzaW().zzj().zzd("User property triggered", zzaiVar3.zza, this.zzn.zzj().zzf(zzqdVar.zzc), zzqdVar.zze);
                        } else {
                            zzaW().zze().zzd("Too many active user properties, ignoring", zzhe.zzn(zzaiVar3.zza), this.zzn.zzj().zzf(zzqdVar.zzc), zzqdVar.zze);
                        }
                        zzbh zzbhVar5 = zzaiVar3.zzi;
                        if (zzbhVar5 != null) {
                            arrayList2.add(zzbhVar5);
                        }
                        zzaiVar3.zzc = new zzqb(zzqdVar);
                        zzaiVar3.zze = true;
                        zzj().zzah(zzaiVar3);
                    }
                }
                zzax(zzbhVar2, zzrVar);
                Iterator it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    zzax(new zzbh((zzbh) it2.next(), j), zzrVar);
                }
                zzj().zzS();
            } finally {
                zzj().zzL();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzT(zzbh zzbhVar, String str) {
        zzh zzl = zzj().zzl(str);
        if (zzl == null || TextUtils.isEmpty(zzl.zzF())) {
            zzaW().zzd().zzb("No app data available; dropping event", str);
            return;
        }
        Boolean zzaF = zzaF(zzl);
        if (zzaF == null) {
            if (!"_ui".equals(zzbhVar.zza)) {
                zzaW().zzk().zzb("Could not find package. appId", zzhe.zzn(str));
            }
        } else if (!zzaF.booleanValue()) {
            zzaW().zze().zzb("App version does not match; dropping event. appId", zzhe.zzn(str));
            return;
        }
        zzU(zzbhVar, new zzr(str, zzl.zzH(), zzl.zzF(), zzl.zze(), zzl.zzE(), zzl.zzq(), zzl.zzn(), (String) null, zzl.zzaJ(), false, zzl.zzG(), 0L, 0, zzl.zzaI(), false, zzl.zzA(), zzl.zzx(), zzl.zzo(), zzl.zzN(), (String) null, zzu(str).zzq(), "", (String) null, zzl.zzaL(), zzl.zzw(), zzu(str).zzb(), zzm(str).zzj(), zzl.zza(), zzl.zzf(), zzl.zzM(), zzl.zzK(), 0L, zzl.zzb()));
    }

    final void zzU(zzbh zzbhVar, zzr zzrVar) {
        String str = zzrVar.zza;
        Preconditions.checkNotEmpty(str);
        zzhf zzb2 = zzhf.zzb(zzbhVar);
        zzB().zzO(zzb2.zzd, zzj().zzk(str));
        zzB().zzQ(zzb2, zzi().zzf(str));
        zzbh zza = zzb2.zza();
        if (Constants.ScionAnalytics.EVENT_FIREBASE_CAMPAIGN.equals(zza.zza)) {
            zzbf zzbfVar = zza.zzb;
            if ("referrer API v2".equals(zzbfVar.zzg("_cis"))) {
                String zzg = zzbfVar.zzg("gclid");
                if (!TextUtils.isEmpty(zzg)) {
                    zzas(new zzqb("_lgclid", zza.zzd, zzg, "auto"), zzrVar);
                }
            }
        }
        zzS(zza, zzrVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzV() {
        this.zzt++;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0047 A[Catch: all -> 0x016b, TryCatch #1 {all -> 0x016b, blocks: (B:5:0x002b, B:13:0x0047, B:14:0x0157, B:24:0x0061, B:28:0x00b1, B:29:0x00a2, B:30:0x00b6, B:34:0x00c8, B:35:0x00e1, B:37:0x00f5, B:38:0x0114, B:40:0x011e, B:42:0x0124, B:43:0x0128, B:45:0x0134, B:47:0x013e, B:49:0x014c, B:50:0x0154, B:51:0x0103, B:52:0x00d0, B:54:0x00da), top: B:4:0x002b, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00f5 A[Catch: all -> 0x016b, TryCatch #1 {all -> 0x016b, blocks: (B:5:0x002b, B:13:0x0047, B:14:0x0157, B:24:0x0061, B:28:0x00b1, B:29:0x00a2, B:30:0x00b6, B:34:0x00c8, B:35:0x00e1, B:37:0x00f5, B:38:0x0114, B:40:0x011e, B:42:0x0124, B:43:0x0128, B:45:0x0134, B:47:0x013e, B:49:0x014c, B:50:0x0154, B:51:0x0103, B:52:0x00d0, B:54:0x00da), top: B:4:0x002b, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0103 A[Catch: all -> 0x016b, TryCatch #1 {all -> 0x016b, blocks: (B:5:0x002b, B:13:0x0047, B:14:0x0157, B:24:0x0061, B:28:0x00b1, B:29:0x00a2, B:30:0x00b6, B:34:0x00c8, B:35:0x00e1, B:37:0x00f5, B:38:0x0114, B:40:0x011e, B:42:0x0124, B:43:0x0128, B:45:0x0134, B:47:0x013e, B:49:0x014c, B:50:0x0154, B:51:0x0103, B:52:0x00d0, B:54:0x00da), top: B:4:0x002b, outer: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zzW(String str, int i, Throwable th, byte[] bArr, Map map) {
        boolean z;
        zzaX().zzg();
        zzM();
        Preconditions.checkNotEmpty(str);
        if (bArr == null) {
            try {
                bArr = new byte[0];
            } finally {
                this.zzu = false;
                zzaH();
            }
        }
        zzhc zzj = zzaW().zzj();
        Integer valueOf = Integer.valueOf(bArr.length);
        zzj.zzb("onConfigFetched. Response size", valueOf);
        zzj().zzH();
        try {
            zzh zzl = zzj().zzl(str);
            if (i != 200 && i != 204) {
                if (i == 304) {
                    i = 304;
                }
                z = false;
                if (zzl == null) {
                    zzaW().zzk().zzb("App does not exist in onConfigFetched. appId", zzhe.zzn(str));
                } else {
                    if (!z && i != 404) {
                        zzl.zzam(zzaU().currentTimeMillis());
                        zzj().zzT(zzl, false, false);
                        zzaW().zzj().zzc("Fetching config failed. code, error", Integer.valueOf(i), th);
                        zzr().zzq(str);
                        this.zzk.zze.zzb(zzaU().currentTimeMillis());
                        if (i == 503 || i == 429) {
                            this.zzk.zzc.zzb(zzaU().currentTimeMillis());
                        }
                        zzaL();
                    }
                    String zzaG = zzaG(map, HttpHeaders.LAST_MODIFIED);
                    String zzaG2 = zzaG(map, HttpHeaders.ETAG);
                    if (i != 404 && i != 304) {
                        zzr().zzz(str, bArr, zzaG, zzaG2);
                        zzl.zzab(zzaU().currentTimeMillis());
                        zzj().zzT(zzl, false, false);
                        if (i != 404) {
                            zzaW().zzl().zzb("Config not found. Using empty config. appId", str);
                        } else {
                            zzaW().zzj().zzc("Successfully fetched config. Got network response. code, size", Integer.valueOf(i), valueOf);
                        }
                        if (zzp().zzd() || !zzaN()) {
                            if (zzi().zzx(null, zzgi.zzaM) || !zzp().zzd() || !zzj().zzY(zzl.zzC())) {
                                zzaL();
                            } else {
                                zzav(zzl.zzC());
                            }
                        } else {
                            zzat();
                        }
                    }
                    if (zzr().zzj(str) == null) {
                        zzr().zzz(str, null, null, null);
                    }
                    zzl.zzab(zzaU().currentTimeMillis());
                    zzj().zzT(zzl, false, false);
                    if (i != 404) {
                    }
                    if (zzp().zzd()) {
                    }
                    if (zzi().zzx(null, zzgi.zzaM)) {
                    }
                    zzaL();
                }
                zzj().zzS();
            }
            if (th == null) {
                z = true;
                if (zzl == null) {
                }
                zzj().zzS();
            }
            z = false;
            if (zzl == null) {
            }
            zzj().zzS();
        } finally {
            zzj().zzL();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzX(boolean z) {
        zzaL();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0031, code lost:
    
        if (r23 != null) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zzY(boolean z, int i, Throwable th, byte[] bArr, String str, List list) {
        byte[] bArr2;
        long j;
        zzaw zzj;
        long longValue;
        int i2 = i;
        zzaX().zzg();
        zzM();
        if (bArr == null) {
            try {
                bArr2 = new byte[0];
            } finally {
                this.zzv = false;
                zzaH();
            }
        } else {
            bArr2 = bArr;
        }
        List<Long> list2 = (List) Preconditions.checkNotNull(this.zzz);
        this.zzz = null;
        try {
            if (z) {
                if (i2 != 200) {
                    if (i2 == 204) {
                        i2 = 204;
                    }
                    String str2 = new String(bArr2, StandardCharsets.UTF_8);
                    zzaW().zzl().zzd("Network upload failed. Will retry later. code, error", Integer.valueOf(i2), th, str2.substring(0, Math.min(32, str2.length())));
                    this.zzk.zze.zzb(zzaU().currentTimeMillis());
                    if (i2 == 503 || i2 == 429) {
                        this.zzk.zzc.zzb(zzaU().currentTimeMillis());
                    }
                    zzj().zzM(list2);
                    zzaL();
                    return;
                }
            }
            long j2 = -1;
            if (!zzi().zzx(null, zzgi.zzaM)) {
                j = -1;
            } else if (zzi().zzx(null, zzgi.zzaP)) {
                HashMap hashMap = new HashMap();
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    Pair pair = (Pair) it.next();
                    com.google.android.gms.internal.measurement.zzhv zzhvVar = (com.google.android.gms.internal.measurement.zzhv) pair.first;
                    zzph zzphVar = (zzph) pair.second;
                    if (zzphVar.zza() != zzmf.SGTM_CLIENT) {
                        long j3 = j2;
                        long zzd = zzj().zzd(str, zzhvVar, zzphVar.zzc(), zzphVar.zzd(), zzphVar.zza(), null);
                        if (zzphVar.zza() == zzmf.GOOGLE_SIGNAL_PENDING && zzd != j3 && !zzhvVar.zzf().isEmpty()) {
                            hashMap.put(zzhvVar.zzf(), Long.valueOf(zzd));
                        }
                        j2 = j3;
                    }
                }
                j = j2;
                Iterator it2 = list.iterator();
                while (it2.hasNext()) {
                    Pair pair2 = (Pair) it2.next();
                    com.google.android.gms.internal.measurement.zzhv zzhvVar2 = (com.google.android.gms.internal.measurement.zzhv) pair2.first;
                    zzph zzphVar2 = (zzph) pair2.second;
                    if (zzphVar2.zza() == zzmf.SGTM_CLIENT) {
                        zzj().zzd(str, zzhvVar2, zzphVar2.zzc(), zzphVar2.zzd(), zzphVar2.zza(), (Long) hashMap.get(zzhvVar2.zzf()));
                    }
                }
            } else {
                j = -1;
                Iterator it3 = list.iterator();
                while (it3.hasNext()) {
                    Pair pair3 = (Pair) it3.next();
                    com.google.android.gms.internal.measurement.zzhv zzhvVar3 = (com.google.android.gms.internal.measurement.zzhv) pair3.first;
                    zzph zzphVar3 = (zzph) pair3.second;
                    zzj().zzd(str, zzhvVar3, zzphVar3.zzc(), zzphVar3.zzd(), zzphVar3.zza(), null);
                }
            }
            for (Long l : list2) {
                try {
                    zzj = zzj();
                    longValue = l.longValue();
                    zzj.zzg();
                    zzj.zzav();
                } catch (SQLiteException e) {
                    List list3 = this.zzA;
                    if (list3 == null || !list3.contains(l)) {
                        throw e;
                    }
                }
                try {
                    if (zzj.zzj().delete("queue", "rowid=?", new String[]{String.valueOf(longValue)}) != 1) {
                        throw new SQLiteException("Deleted fewer rows from queue than expected");
                        break;
                    }
                } catch (SQLiteException e2) {
                    zzj.zzu.zzaW().zze().zzb("Failed to delete a bundle in a queue table", e2);
                    throw e2;
                    break;
                }
            }
            zzj().zzS();
            zzj().zzL();
            this.zzA = null;
            if (!zzi().zzx(null, zzgi.zzaM) || !zzp().zzd() || !zzj().zzY(str)) {
                if (!zzp().zzd() || !zzaN()) {
                    this.zzB = j;
                    zzaL();
                } else {
                    zzat();
                }
            } else {
                zzav(str);
            }
            this.zza = 0L;
            return;
        } catch (Throwable th2) {
            zzj().zzL();
            throw th2;
        }
        zzhc zzj2 = zzaW().zzj();
        Integer valueOf = Integer.valueOf(i2);
        zzj2.zzc("Network upload successful with code, uploadAttempted", valueOf, Boolean.valueOf(z));
        if (z) {
            try {
                this.zzk.zzd.zzb(zzaU().currentTimeMillis());
            } catch (SQLiteException e3) {
                zzaW().zze().zzb("Database error while trying to delete uploaded bundles", e3);
                this.zza = zzaU().elapsedRealtime();
                zzaW().zzj().zzb("Disable upload, time", Long.valueOf(this.zza));
            }
        }
        this.zzk.zze.zzb(0L);
        zzaL();
        if (z) {
            zzaW().zzj().zzc("Successful upload. Got network response. code, size", valueOf, Integer.valueOf(bArr2.length));
        } else {
            zzaW().zzj().zza("Purged empty bundles");
        }
        zzj().zzH();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x008c  */
    /* JADX WARN: Type inference failed for: r7v9, types: [java.lang.String] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zzZ(String str, int i, Throwable th, byte[] bArr, zzpz zzpzVar) {
        zzaX().zzg();
        zzM();
        if (bArr == null) {
            try {
                bArr = new byte[0];
            } catch (Throwable th2) {
                this.zzv = false;
                zzaH();
                throw th2;
            }
        }
        if (i != 200) {
            if (i == 204) {
                i = 204;
            }
            String str2 = new String(bArr, StandardCharsets.UTF_8);
            ?? substring = str2.substring(0, Math.min(32, str2.length()));
            zzhc zzl = zzaW().zzl();
            Integer valueOf = Integer.valueOf(i);
            if (th == null) {
                th = substring;
            }
            zzl.zzd("Network upload failed. Will retry later. appId, status, error", str, valueOf, th);
            zzj().zzN(Long.valueOf(zzpzVar.zzc()));
            zzaL();
            this.zzv = false;
            zzaH();
        }
        if (th == null) {
            zzj().zzK(Long.valueOf(zzpzVar.zzc()));
            zzaW().zzj().zzc("Successfully uploaded batch from upload queue. appId, status", str, Integer.valueOf(i));
            if (!zzi().zzx(null, zzgi.zzaM) || !zzp().zzd() || !zzj().zzY(str)) {
                zzaL();
            } else {
                zzav(str);
            }
            this.zzv = false;
            zzaH();
        }
        String str22 = new String(bArr, StandardCharsets.UTF_8);
        ?? substring2 = str22.substring(0, Math.min(32, str22.length()));
        zzhc zzl2 = zzaW().zzl();
        Integer valueOf2 = Integer.valueOf(i);
        if (th == null) {
        }
        zzl2.zzd("Network upload failed. Will retry later. appId, status, error", str, valueOf2, th);
        zzj().zzN(Long.valueOf(zzpzVar.zzc()));
        zzaL();
        this.zzv = false;
        zzaH();
    }

    final long zza() {
        long currentTimeMillis = zzaU().currentTimeMillis();
        zzoa zzoaVar = this.zzk;
        zzoaVar.zzav();
        zzoaVar.zzg();
        zzhp zzhpVar = zzoaVar.zzf;
        long zza = zzhpVar.zza();
        if (zza == 0) {
            zza = zzoaVar.zzu.zzw().zzJ().nextInt(86400000) + 1;
            zzhpVar.zzb(zza);
        }
        return ((((currentTimeMillis + zza) / 1000) / 60) / 60) / 24;
    }

    @Override // com.google.android.gms.measurement.internal.zzjs
    public final Context zzaT() {
        return this.zzn.zzaT();
    }

    @Override // com.google.android.gms.measurement.internal.zzjs
    public final Clock zzaU() {
        return ((zzio) Preconditions.checkNotNull(this.zzn)).zzaU();
    }

    @Override // com.google.android.gms.measurement.internal.zzjs
    public final zzaf zzaV() {
        return this.zzn.zzaV();
    }

    @Override // com.google.android.gms.measurement.internal.zzjs
    public final zzhe zzaW() {
        return ((zzio) Preconditions.checkNotNull(this.zzn)).zzaW();
    }

    @Override // com.google.android.gms.measurement.internal.zzjs
    public final zzil zzaX() {
        return ((zzio) Preconditions.checkNotNull(this.zzn)).zzaX();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzaa(zzh zzhVar, com.google.android.gms.internal.measurement.zzhw zzhwVar) {
        zzaX().zzg();
        zzM();
        com.google.android.gms.internal.measurement.zzhb zzc = com.google.android.gms.internal.measurement.zzhc.zzc();
        byte[] zzaN = zzhVar.zzaN();
        if (zzaN != null) {
            try {
                zzc = (com.google.android.gms.internal.measurement.zzhb) zzqa.zzp(zzc, zzaN);
            } catch (com.google.android.gms.internal.measurement.zzmm unused) {
                zzaW().zzk().zzb("Failed to parse locally stored ad campaign info. appId", zzhe.zzn(zzhVar.zzC()));
            }
        }
        for (com.google.android.gms.internal.measurement.zzhm zzhmVar : zzhwVar.zzaM()) {
            if (zzhmVar.zzh().equals(Constants.ScionAnalytics.EVENT_FIREBASE_CAMPAIGN)) {
                String str = (String) zzqa.zzI(zzhmVar, "gclid", "");
                String str2 = (String) zzqa.zzI(zzhmVar, "gbraid", "");
                String str3 = (String) zzqa.zzI(zzhmVar, "gad_source", "");
                if (!str.isEmpty() || !str2.isEmpty()) {
                    long longValue = ((Long) zzqa.zzI(zzhmVar, "click_timestamp", 0L)).longValue();
                    if (longValue <= 0) {
                        longValue = zzhmVar.zzd();
                    }
                    if ("referrer API v2".equals(zzqa.zzH(zzhmVar, "_cis"))) {
                        if (longValue > zzc.zzb()) {
                            if (str.isEmpty()) {
                                zzc.zzh();
                            } else {
                                zzc.zzp(str);
                            }
                            if (str2.isEmpty()) {
                                zzc.zzg();
                            } else {
                                zzc.zzo(str2);
                            }
                            if (str3.isEmpty()) {
                                zzc.zzf();
                            } else {
                                zzc.zzn(str3);
                            }
                            zzc.zzm(longValue);
                        }
                    } else if (longValue > zzc.zza()) {
                        if (str.isEmpty()) {
                            zzc.zze();
                        } else {
                            zzc.zzk(str);
                        }
                        if (str2.isEmpty()) {
                            zzc.zzd();
                        } else {
                            zzc.zzj(str2);
                        }
                        if (str3.isEmpty()) {
                            zzc.zzc();
                        } else {
                            zzc.zzi(str3);
                        }
                        zzc.zzl(longValue);
                    }
                }
            }
        }
        if (!((com.google.android.gms.internal.measurement.zzhc) zzc.zzba()).equals(com.google.android.gms.internal.measurement.zzhc.zze())) {
            zzhwVar.zzF((com.google.android.gms.internal.measurement.zzhc) zzc.zzba());
        }
        zzhVar.zzR(((com.google.android.gms.internal.measurement.zzhc) zzc.zzba()).zzcd());
        if (zzhVar.zzaK()) {
            zzj().zzT(zzhVar, false, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzab(zzr zzrVar) {
        zzaX().zzg();
        zzM();
        Preconditions.checkNotNull(zzrVar);
        String str = zzrVar.zza;
        Preconditions.checkNotEmpty(str);
        int i = 0;
        if (zzi().zzx(null, zzgi.zzay)) {
            long currentTimeMillis = zzaU().currentTimeMillis();
            int zzh = zzi().zzh(null, zzgi.zzah);
            zzi();
            long zzF = currentTimeMillis - zzam.zzF();
            while (i < zzh && zzaM(null, zzF)) {
                i++;
            }
        } else {
            zzi();
            long zzH = zzam.zzH();
            while (i < zzH && zzaM(str, 0L)) {
                i++;
            }
        }
        if (zzi().zzx(null, zzgi.zzaz)) {
            zzaX().zzg();
            zzaJ();
        }
        if (zzi().zzx(null, zzgi.zzaQ) && this.zzl.zzd(str, com.google.android.gms.internal.measurement.zzih.zzb(zzrVar.zzG))) {
            zzaW().zzj().zzb("[sgtm] Going background, trigger client side upload. appId", str);
            zzau(str, zzaU().currentTimeMillis());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:140:0x00c4, code lost:
    
        if (true == r11.booleanValue()) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:141:0x00c6, code lost:
    
        r17 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:142:0x00cb, code lost:
    
        r4 = true;
        r3 = new com.google.android.gms.measurement.internal.zzqb("_npa", r13, java.lang.Long.valueOf(r17), "auto");
     */
    /* JADX WARN: Code restructure failed: missing block: B:143:0x00d8, code lost:
    
        if (r10 == null) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:145:0x00e2, code lost:
    
        if (r10.zze.equals(r3.zzd) != false) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:146:0x00e4, code lost:
    
        zzas(r3, r26);
     */
    /* JADX WARN: Code restructure failed: missing block: B:147:0x00c9, code lost:
    
        r17 = 1;
     */
    /* JADX WARN: Removed duplicated region for block: B:133:0x03e4 A[Catch: all -> 0x0414, TryCatch #1 {all -> 0x0414, blocks: (B:25:0x009c, B:27:0x00ad, B:31:0x00ee, B:33:0x00fb, B:34:0x0104, B:36:0x0109, B:38:0x0122, B:41:0x0137, B:43:0x0160, B:46:0x0168, B:48:0x0177, B:49:0x0256, B:51:0x0284, B:52:0x0287, B:54:0x02af, B:58:0x037a, B:59:0x037d, B:60:0x0405, B:65:0x02c4, B:67:0x02e7, B:69:0x02ef, B:71:0x02f7, B:75:0x030a, B:77:0x031b, B:80:0x0327, B:82:0x0338, B:93:0x0349, B:84:0x035d, B:86:0x0363, B:87:0x036b, B:89:0x0371, B:95:0x0313, B:100:0x02d3, B:101:0x0188, B:103:0x01b1, B:104:0x01c0, B:106:0x01c7, B:108:0x01cd, B:110:0x01d7, B:112:0x01e1, B:114:0x01e7, B:116:0x01ed, B:118:0x01f2, B:121:0x0210, B:125:0x0215, B:126:0x0229, B:127:0x0237, B:128:0x0245, B:129:0x0395, B:131:0x03ca, B:132:0x03cd, B:133:0x03e4, B:135:0x03ea, B:136:0x0115, B:137:0x0101, B:139:0x00bc, B:142:0x00cb, B:144:0x00da, B:146:0x00e4, B:150:0x00eb), top: B:24:0x009c, inners: #0, #2, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0115 A[Catch: all -> 0x0414, TryCatch #1 {all -> 0x0414, blocks: (B:25:0x009c, B:27:0x00ad, B:31:0x00ee, B:33:0x00fb, B:34:0x0104, B:36:0x0109, B:38:0x0122, B:41:0x0137, B:43:0x0160, B:46:0x0168, B:48:0x0177, B:49:0x0256, B:51:0x0284, B:52:0x0287, B:54:0x02af, B:58:0x037a, B:59:0x037d, B:60:0x0405, B:65:0x02c4, B:67:0x02e7, B:69:0x02ef, B:71:0x02f7, B:75:0x030a, B:77:0x031b, B:80:0x0327, B:82:0x0338, B:93:0x0349, B:84:0x035d, B:86:0x0363, B:87:0x036b, B:89:0x0371, B:95:0x0313, B:100:0x02d3, B:101:0x0188, B:103:0x01b1, B:104:0x01c0, B:106:0x01c7, B:108:0x01cd, B:110:0x01d7, B:112:0x01e1, B:114:0x01e7, B:116:0x01ed, B:118:0x01f2, B:121:0x0210, B:125:0x0215, B:126:0x0229, B:127:0x0237, B:128:0x0245, B:129:0x0395, B:131:0x03ca, B:132:0x03cd, B:133:0x03e4, B:135:0x03ea, B:136:0x0115, B:137:0x0101, B:139:0x00bc, B:142:0x00cb, B:144:0x00da, B:146:0x00e4, B:150:0x00eb), top: B:24:0x009c, inners: #0, #2, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0101 A[Catch: all -> 0x0414, TryCatch #1 {all -> 0x0414, blocks: (B:25:0x009c, B:27:0x00ad, B:31:0x00ee, B:33:0x00fb, B:34:0x0104, B:36:0x0109, B:38:0x0122, B:41:0x0137, B:43:0x0160, B:46:0x0168, B:48:0x0177, B:49:0x0256, B:51:0x0284, B:52:0x0287, B:54:0x02af, B:58:0x037a, B:59:0x037d, B:60:0x0405, B:65:0x02c4, B:67:0x02e7, B:69:0x02ef, B:71:0x02f7, B:75:0x030a, B:77:0x031b, B:80:0x0327, B:82:0x0338, B:93:0x0349, B:84:0x035d, B:86:0x0363, B:87:0x036b, B:89:0x0371, B:95:0x0313, B:100:0x02d3, B:101:0x0188, B:103:0x01b1, B:104:0x01c0, B:106:0x01c7, B:108:0x01cd, B:110:0x01d7, B:112:0x01e1, B:114:0x01e7, B:116:0x01ed, B:118:0x01f2, B:121:0x0210, B:125:0x0215, B:126:0x0229, B:127:0x0237, B:128:0x0245, B:129:0x0395, B:131:0x03ca, B:132:0x03cd, B:133:0x03e4, B:135:0x03ea, B:136:0x0115, B:137:0x0101, B:139:0x00bc, B:142:0x00cb, B:144:0x00da, B:146:0x00e4, B:150:0x00eb), top: B:24:0x009c, inners: #0, #2, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00fb A[Catch: all -> 0x0414, TryCatch #1 {all -> 0x0414, blocks: (B:25:0x009c, B:27:0x00ad, B:31:0x00ee, B:33:0x00fb, B:34:0x0104, B:36:0x0109, B:38:0x0122, B:41:0x0137, B:43:0x0160, B:46:0x0168, B:48:0x0177, B:49:0x0256, B:51:0x0284, B:52:0x0287, B:54:0x02af, B:58:0x037a, B:59:0x037d, B:60:0x0405, B:65:0x02c4, B:67:0x02e7, B:69:0x02ef, B:71:0x02f7, B:75:0x030a, B:77:0x031b, B:80:0x0327, B:82:0x0338, B:93:0x0349, B:84:0x035d, B:86:0x0363, B:87:0x036b, B:89:0x0371, B:95:0x0313, B:100:0x02d3, B:101:0x0188, B:103:0x01b1, B:104:0x01c0, B:106:0x01c7, B:108:0x01cd, B:110:0x01d7, B:112:0x01e1, B:114:0x01e7, B:116:0x01ed, B:118:0x01f2, B:121:0x0210, B:125:0x0215, B:126:0x0229, B:127:0x0237, B:128:0x0245, B:129:0x0395, B:131:0x03ca, B:132:0x03cd, B:133:0x03e4, B:135:0x03ea, B:136:0x0115, B:137:0x0101, B:139:0x00bc, B:142:0x00cb, B:144:0x00da, B:146:0x00e4, B:150:0x00eb), top: B:24:0x009c, inners: #0, #2, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0109 A[Catch: all -> 0x0414, TryCatch #1 {all -> 0x0414, blocks: (B:25:0x009c, B:27:0x00ad, B:31:0x00ee, B:33:0x00fb, B:34:0x0104, B:36:0x0109, B:38:0x0122, B:41:0x0137, B:43:0x0160, B:46:0x0168, B:48:0x0177, B:49:0x0256, B:51:0x0284, B:52:0x0287, B:54:0x02af, B:58:0x037a, B:59:0x037d, B:60:0x0405, B:65:0x02c4, B:67:0x02e7, B:69:0x02ef, B:71:0x02f7, B:75:0x030a, B:77:0x031b, B:80:0x0327, B:82:0x0338, B:93:0x0349, B:84:0x035d, B:86:0x0363, B:87:0x036b, B:89:0x0371, B:95:0x0313, B:100:0x02d3, B:101:0x0188, B:103:0x01b1, B:104:0x01c0, B:106:0x01c7, B:108:0x01cd, B:110:0x01d7, B:112:0x01e1, B:114:0x01e7, B:116:0x01ed, B:118:0x01f2, B:121:0x0210, B:125:0x0215, B:126:0x0229, B:127:0x0237, B:128:0x0245, B:129:0x0395, B:131:0x03ca, B:132:0x03cd, B:133:0x03e4, B:135:0x03ea, B:136:0x0115, B:137:0x0101, B:139:0x00bc, B:142:0x00cb, B:144:0x00da, B:146:0x00e4, B:150:0x00eb), top: B:24:0x009c, inners: #0, #2, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0122 A[Catch: all -> 0x0414, TRY_LEAVE, TryCatch #1 {all -> 0x0414, blocks: (B:25:0x009c, B:27:0x00ad, B:31:0x00ee, B:33:0x00fb, B:34:0x0104, B:36:0x0109, B:38:0x0122, B:41:0x0137, B:43:0x0160, B:46:0x0168, B:48:0x0177, B:49:0x0256, B:51:0x0284, B:52:0x0287, B:54:0x02af, B:58:0x037a, B:59:0x037d, B:60:0x0405, B:65:0x02c4, B:67:0x02e7, B:69:0x02ef, B:71:0x02f7, B:75:0x030a, B:77:0x031b, B:80:0x0327, B:82:0x0338, B:93:0x0349, B:84:0x035d, B:86:0x0363, B:87:0x036b, B:89:0x0371, B:95:0x0313, B:100:0x02d3, B:101:0x0188, B:103:0x01b1, B:104:0x01c0, B:106:0x01c7, B:108:0x01cd, B:110:0x01d7, B:112:0x01e1, B:114:0x01e7, B:116:0x01ed, B:118:0x01f2, B:121:0x0210, B:125:0x0215, B:126:0x0229, B:127:0x0237, B:128:0x0245, B:129:0x0395, B:131:0x03ca, B:132:0x03cd, B:133:0x03e4, B:135:0x03ea, B:136:0x0115, B:137:0x0101, B:139:0x00bc, B:142:0x00cb, B:144:0x00da, B:146:0x00e4, B:150:0x00eb), top: B:24:0x009c, inners: #0, #2, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0284 A[Catch: all -> 0x0414, TryCatch #1 {all -> 0x0414, blocks: (B:25:0x009c, B:27:0x00ad, B:31:0x00ee, B:33:0x00fb, B:34:0x0104, B:36:0x0109, B:38:0x0122, B:41:0x0137, B:43:0x0160, B:46:0x0168, B:48:0x0177, B:49:0x0256, B:51:0x0284, B:52:0x0287, B:54:0x02af, B:58:0x037a, B:59:0x037d, B:60:0x0405, B:65:0x02c4, B:67:0x02e7, B:69:0x02ef, B:71:0x02f7, B:75:0x030a, B:77:0x031b, B:80:0x0327, B:82:0x0338, B:93:0x0349, B:84:0x035d, B:86:0x0363, B:87:0x036b, B:89:0x0371, B:95:0x0313, B:100:0x02d3, B:101:0x0188, B:103:0x01b1, B:104:0x01c0, B:106:0x01c7, B:108:0x01cd, B:110:0x01d7, B:112:0x01e1, B:114:0x01e7, B:116:0x01ed, B:118:0x01f2, B:121:0x0210, B:125:0x0215, B:126:0x0229, B:127:0x0237, B:128:0x0245, B:129:0x0395, B:131:0x03ca, B:132:0x03cd, B:133:0x03e4, B:135:0x03ea, B:136:0x0115, B:137:0x0101, B:139:0x00bc, B:142:0x00cb, B:144:0x00da, B:146:0x00e4, B:150:0x00eb), top: B:24:0x009c, inners: #0, #2, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x02af A[Catch: all -> 0x0414, TRY_LEAVE, TryCatch #1 {all -> 0x0414, blocks: (B:25:0x009c, B:27:0x00ad, B:31:0x00ee, B:33:0x00fb, B:34:0x0104, B:36:0x0109, B:38:0x0122, B:41:0x0137, B:43:0x0160, B:46:0x0168, B:48:0x0177, B:49:0x0256, B:51:0x0284, B:52:0x0287, B:54:0x02af, B:58:0x037a, B:59:0x037d, B:60:0x0405, B:65:0x02c4, B:67:0x02e7, B:69:0x02ef, B:71:0x02f7, B:75:0x030a, B:77:0x031b, B:80:0x0327, B:82:0x0338, B:93:0x0349, B:84:0x035d, B:86:0x0363, B:87:0x036b, B:89:0x0371, B:95:0x0313, B:100:0x02d3, B:101:0x0188, B:103:0x01b1, B:104:0x01c0, B:106:0x01c7, B:108:0x01cd, B:110:0x01d7, B:112:0x01e1, B:114:0x01e7, B:116:0x01ed, B:118:0x01f2, B:121:0x0210, B:125:0x0215, B:126:0x0229, B:127:0x0237, B:128:0x0245, B:129:0x0395, B:131:0x03ca, B:132:0x03cd, B:133:0x03e4, B:135:0x03ea, B:136:0x0115, B:137:0x0101, B:139:0x00bc, B:142:0x00cb, B:144:0x00da, B:146:0x00e4, B:150:0x00eb), top: B:24:0x009c, inners: #0, #2, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x037a A[Catch: all -> 0x0414, TryCatch #1 {all -> 0x0414, blocks: (B:25:0x009c, B:27:0x00ad, B:31:0x00ee, B:33:0x00fb, B:34:0x0104, B:36:0x0109, B:38:0x0122, B:41:0x0137, B:43:0x0160, B:46:0x0168, B:48:0x0177, B:49:0x0256, B:51:0x0284, B:52:0x0287, B:54:0x02af, B:58:0x037a, B:59:0x037d, B:60:0x0405, B:65:0x02c4, B:67:0x02e7, B:69:0x02ef, B:71:0x02f7, B:75:0x030a, B:77:0x031b, B:80:0x0327, B:82:0x0338, B:93:0x0349, B:84:0x035d, B:86:0x0363, B:87:0x036b, B:89:0x0371, B:95:0x0313, B:100:0x02d3, B:101:0x0188, B:103:0x01b1, B:104:0x01c0, B:106:0x01c7, B:108:0x01cd, B:110:0x01d7, B:112:0x01e1, B:114:0x01e7, B:116:0x01ed, B:118:0x01f2, B:121:0x0210, B:125:0x0215, B:126:0x0229, B:127:0x0237, B:128:0x0245, B:129:0x0395, B:131:0x03ca, B:132:0x03cd, B:133:0x03e4, B:135:0x03ea, B:136:0x0115, B:137:0x0101, B:139:0x00bc, B:142:0x00cb, B:144:0x00da, B:146:0x00e4, B:150:0x00eb), top: B:24:0x009c, inners: #0, #2, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x02c4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zzac(zzr zzrVar) {
        boolean z;
        zzbd zzs;
        boolean z2;
        long j;
        long zze;
        zzio zzioVar;
        PackageInfo packageInfo;
        ApplicationInfo applicationInfo;
        ApplicationInfo applicationInfo2;
        long j2;
        boolean z3;
        zzaX().zzg();
        zzM();
        Preconditions.checkNotNull(zzrVar);
        String str = zzrVar.zza;
        Preconditions.checkNotEmpty(str);
        if (zzaQ(zzrVar)) {
            zzh zzl = zzj().zzl(str);
            if (zzl != null && TextUtils.isEmpty(zzl.zzH()) && !TextUtils.isEmpty(zzrVar.zzb)) {
                zzl.zzab(0L);
                zzj().zzT(zzl, false, false);
                zzr().zzr(str);
            }
            if (!zzrVar.zzh) {
                zzg(zzrVar);
                return;
            }
            long j3 = zzrVar.zzl;
            if (j3 == 0) {
                j3 = zzaU().currentTimeMillis();
            }
            this.zzn.zzg().zzg();
            int i = zzrVar.zzm;
            if (i != 0 && i != 1) {
                zzaW().zzk().zzc("Incorrect app type, assuming installed app. appId, appType", zzhe.zzn(str), Integer.valueOf(i));
                i = 0;
            }
            zzj().zzH();
            try {
                zzqd zzy = zzj().zzy(str, "_npa");
                Boolean zzaS = zzaS(zzrVar);
                if (zzy != null && !"auto".equals(zzy.zzb)) {
                    z = true;
                    if (!zzi().zzx(null, zzgi.zzbl)) {
                        zzP(zzrVar, zzrVar.zzF);
                    } else {
                        zzP(zzrVar, j3);
                    }
                    zzg(zzrVar);
                    if (i == 0) {
                        zzs = zzj().zzs(str, "_v");
                        z2 = z;
                    } else {
                        zzs = zzj().zzs(str, "_f");
                        z2 = false;
                    }
                    if (zzs != null) {
                        long j4 = ((j3 / 3600000) + 1) * 3600000;
                        if (z2) {
                            long j5 = j3;
                            zzas(new zzqb("_fvt", j5, Long.valueOf(j4), "auto"), zzrVar);
                            zzaX().zzg();
                            zzM();
                            Bundle bundle = new Bundle();
                            bundle.putLong("_c", 1L);
                            bundle.putLong("_r", 1L);
                            bundle.putLong("_et", 1L);
                            if (zzrVar.zzo) {
                                bundle.putLong("_dac", 1L);
                            }
                            zzU(new zzbh("_v", new zzbf(bundle), "auto", j5), zzrVar);
                        } else {
                            zzas(new zzqb("_fot", j3, Long.valueOf(j4), "auto"), zzrVar);
                            zzaX().zzg();
                            zzhw zzhwVar = (zzhw) Preconditions.checkNotNull(this.zzm);
                            if (str != null && !str.isEmpty()) {
                                zzio zzioVar2 = zzhwVar.zza;
                                zzioVar2.zzaX().zzg();
                                if (!zzhwVar.zza()) {
                                    zzioVar2.zzaW().zzi().zza("Install Referrer Reporter is not available");
                                    j = j3;
                                } else {
                                    zzhv zzhvVar = new zzhv(zzhwVar, str);
                                    zzioVar2.zzaX().zzg();
                                    j = j3;
                                    Intent intent = new Intent("com.google.android.finsky.BIND_GET_INSTALL_REFERRER_SERVICE");
                                    intent.setComponent(new ComponentName("com.android.vending", "com.google.android.finsky.externalreferrer.GetInstallReferrerService"));
                                    PackageManager packageManager = zzioVar2.zzaT().getPackageManager();
                                    if (packageManager == null) {
                                        zzioVar2.zzaW().zzm().zza("Failed to obtain Package Manager to verify binding conditions for Install Referrer");
                                    } else {
                                        List<ResolveInfo> queryIntentServices = packageManager.queryIntentServices(intent, 0);
                                        if (queryIntentServices == null || queryIntentServices.isEmpty()) {
                                            zzioVar2.zzaW().zzi().zza("Play Service for fetching Install Referrer is unavailable on device");
                                        } else {
                                            ResolveInfo resolveInfo = queryIntentServices.get(0);
                                            if (resolveInfo.serviceInfo != null) {
                                                String str2 = resolveInfo.serviceInfo.packageName;
                                                if (resolveInfo.serviceInfo.name == null || !"com.android.vending".equals(str2) || !zzhwVar.zza()) {
                                                    zzioVar2.zzaW().zzk().zza("Play Store version 8.3.73 or higher required for Install Referrer");
                                                } else {
                                                    try {
                                                        zzioVar2.zzaW().zzj().zzb("Install Referrer Service is", ConnectionTracker.getInstance().bindService(zzioVar2.zzaT(), new Intent(intent), zzhvVar, 1) ? "available" : "not available");
                                                    } catch (RuntimeException e) {
                                                        zzhwVar.zza.zzaW().zze().zzb("Exception occurred while binding to Install Referrer Service", e.getMessage());
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                                zzaX().zzg();
                                zzM();
                                Bundle bundle2 = new Bundle();
                                bundle2.putLong("_c", 1L);
                                bundle2.putLong("_r", 1L);
                                bundle2.putLong("_uwa", 0L);
                                bundle2.putLong("_pfo", 0L);
                                bundle2.putLong("_sys", 0L);
                                bundle2.putLong("_sysu", 0L);
                                bundle2.putLong("_et", 1L);
                                if (zzrVar.zzo) {
                                    bundle2.putLong("_dac", 1L);
                                }
                                String str3 = (String) Preconditions.checkNotNull(zzrVar.zza);
                                zzaw zzj = zzj();
                                Preconditions.checkNotEmpty(str3);
                                zzj.zzg();
                                zzj.zzav();
                                zze = zzj.zze(str3, "first_open_count");
                                zzioVar = this.zzn;
                                if (zzioVar.zzaT().getPackageManager() == null) {
                                    try {
                                        packageInfo = Wrappers.packageManager(zzioVar.zzaT()).getPackageInfo(str3, 0);
                                    } catch (PackageManager.NameNotFoundException e2) {
                                        zzaW().zze().zzc("Package info is null, first open report might be inaccurate. appId", zzhe.zzn(str3), e2);
                                        packageInfo = null;
                                    }
                                    if (packageInfo == null || packageInfo.firstInstallTime == 0) {
                                        applicationInfo = null;
                                    } else {
                                        if (packageInfo.firstInstallTime != packageInfo.lastUpdateTime) {
                                            applicationInfo = null;
                                            if (!zzi().zzx(null, zzgi.zzaH)) {
                                                bundle2.putLong("_uwa", 1L);
                                            } else if (zze == 0) {
                                                bundle2.putLong("_uwa", 1L);
                                                zze = 0;
                                            }
                                            z3 = false;
                                        } else {
                                            applicationInfo = null;
                                            z3 = true;
                                        }
                                        zzas(new zzqb("_fi", j, Long.valueOf(true != z3 ? 0L : 1L), "auto"), zzrVar);
                                    }
                                    try {
                                        applicationInfo2 = Wrappers.packageManager(this.zzn.zzaT()).getApplicationInfo(str3, 0);
                                    } catch (PackageManager.NameNotFoundException e3) {
                                        zzaW().zze().zzc("Application info is null, first open report might be inaccurate. appId", zzhe.zzn(str3), e3);
                                        applicationInfo2 = applicationInfo;
                                    }
                                    if (applicationInfo2 != null) {
                                        if ((applicationInfo2.flags & 1) != 0) {
                                            j2 = 1;
                                            bundle2.putLong("_sys", 1L);
                                        } else {
                                            j2 = 1;
                                        }
                                        if ((applicationInfo2.flags & 128) != 0) {
                                            bundle2.putLong("_sysu", j2);
                                        }
                                    }
                                } else {
                                    zzaW().zze().zzb("PackageManager is null, first open report might be inaccurate. appId", zzhe.zzn(str3));
                                }
                                if (zze >= 0) {
                                    bundle2.putLong("_pfo", zze);
                                }
                                zzU(new zzbh("_f", new zzbf(bundle2), "auto", j), zzrVar);
                            }
                            j = j3;
                            zzhwVar.zza.zzaW().zzm().zza("Install Referrer Reporter was called with invalid app package name");
                            zzaX().zzg();
                            zzM();
                            Bundle bundle22 = new Bundle();
                            bundle22.putLong("_c", 1L);
                            bundle22.putLong("_r", 1L);
                            bundle22.putLong("_uwa", 0L);
                            bundle22.putLong("_pfo", 0L);
                            bundle22.putLong("_sys", 0L);
                            bundle22.putLong("_sysu", 0L);
                            bundle22.putLong("_et", 1L);
                            if (zzrVar.zzo) {
                            }
                            String str32 = (String) Preconditions.checkNotNull(zzrVar.zza);
                            zzaw zzj2 = zzj();
                            Preconditions.checkNotEmpty(str32);
                            zzj2.zzg();
                            zzj2.zzav();
                            zze = zzj2.zze(str32, "first_open_count");
                            zzioVar = this.zzn;
                            if (zzioVar.zzaT().getPackageManager() == null) {
                            }
                            if (zze >= 0) {
                            }
                            zzU(new zzbh("_f", new zzbf(bundle22), "auto", j), zzrVar);
                        }
                    } else {
                        long j6 = j3;
                        if (zzrVar.zzi) {
                            zzU(new zzbh("_cd", new zzbf(new Bundle()), "auto", j6), zzrVar);
                        }
                    }
                    zzj().zzS();
                }
                z = true;
                if (zzy != null) {
                    zzag("_npa", zzrVar);
                }
                if (!zzi().zzx(null, zzgi.zzbl)) {
                }
                zzg(zzrVar);
                if (i == 0) {
                }
                if (zzs != null) {
                }
                zzj().zzS();
            } finally {
                zzj().zzL();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzad() {
        this.zzs++;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzae(zzai zzaiVar) {
        zzr zzaD = zzaD((String) Preconditions.checkNotNull(zzaiVar.zza));
        if (zzaD != null) {
            zzaf(zzaiVar, zzaD);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzaf(zzai zzaiVar, zzr zzrVar) {
        Preconditions.checkNotNull(zzaiVar);
        Preconditions.checkNotEmpty(zzaiVar.zza);
        Preconditions.checkNotNull(zzaiVar.zzc);
        Preconditions.checkNotEmpty(zzaiVar.zzc.zzb);
        zzaX().zzg();
        zzM();
        if (zzaQ(zzrVar)) {
            if (!zzrVar.zzh) {
                zzg(zzrVar);
                return;
            }
            zzj().zzH();
            try {
                zzg(zzrVar);
                String str = (String) Preconditions.checkNotNull(zzaiVar.zza);
                zzai zzm = zzj().zzm(str, zzaiVar.zzc.zzb);
                if (zzm != null) {
                    zzaW().zzd().zzc("Removing conditional user property", zzaiVar.zza, this.zzn.zzj().zzf(zzaiVar.zzc.zzb));
                    zzj().zza(str, zzaiVar.zzc.zzb);
                    if (zzm.zze) {
                        zzj().zzP(str, zzaiVar.zzc.zzb);
                    }
                    zzbh zzbhVar = zzaiVar.zzk;
                    if (zzbhVar != null) {
                        zzbf zzbfVar = zzbhVar.zzb;
                        zzax((zzbh) Preconditions.checkNotNull(zzB().zzC(str, ((zzbh) Preconditions.checkNotNull(zzbhVar)).zza, zzbfVar != null ? zzbfVar.zzc() : null, zzm.zzb, zzbhVar.zzd, true, true)), zzrVar);
                    }
                } else {
                    zzaW().zzk().zzc("Conditional user property doesn't exist", zzhe.zzn(zzaiVar.zza), this.zzn.zzj().zzf(zzaiVar.zzc.zzb));
                }
                zzj().zzS();
            } finally {
                zzj().zzL();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzag(String str, zzr zzrVar) {
        zzaX().zzg();
        zzM();
        if (zzaQ(zzrVar)) {
            if (!zzrVar.zzh) {
                zzg(zzrVar);
                return;
            }
            Boolean zzaS = zzaS(zzrVar);
            if (!"_npa".equals(str) || zzaS == null) {
                zzhc zzd = zzaW().zzd();
                zzio zzioVar = this.zzn;
                zzd.zzb("Removing user property", zzioVar.zzj().zzf(str));
                zzj().zzH();
                try {
                    zzg(zzrVar);
                    if ("_id".equals(str)) {
                        zzj().zzP((String) Preconditions.checkNotNull(zzrVar.zza), "_lair");
                    }
                    zzj().zzP((String) Preconditions.checkNotNull(zzrVar.zza), str);
                    zzj().zzS();
                    zzaW().zzd().zzb("User property removed", zzioVar.zzj().zzf(str));
                    return;
                } finally {
                    zzj().zzL();
                }
            }
            zzaW().zzd().zza("Falling back to manifest metadata value for ad personalization");
            zzas(new zzqb("_npa", zzaU().currentTimeMillis(), Long.valueOf(true != zzaS.booleanValue() ? 0L : 1L), "auto"), zzrVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzah(zzr zzrVar) {
        if (this.zzz != null) {
            ArrayList arrayList = new ArrayList();
            this.zzA = arrayList;
            arrayList.addAll(this.zzz);
        }
        zzaw zzj = zzj();
        String str = (String) Preconditions.checkNotNull(zzrVar.zza);
        Preconditions.checkNotEmpty(str);
        zzj.zzg();
        zzj.zzav();
        try {
            SQLiteDatabase zzj2 = zzj.zzj();
            String[] strArr = {str};
            int delete = zzj2.delete("apps", "app_id=?", strArr) + zzj2.delete("events", "app_id=?", strArr) + zzj2.delete("events_snapshot", "app_id=?", strArr) + zzj2.delete("user_attributes", "app_id=?", strArr) + zzj2.delete("conditional_properties", "app_id=?", strArr) + zzj2.delete("raw_events", "app_id=?", strArr) + zzj2.delete("raw_events_metadata", "app_id=?", strArr) + zzj2.delete("queue", "app_id=?", strArr) + zzj2.delete("audience_filter_values", "app_id=?", strArr) + zzj2.delete("main_event_params", "app_id=?", strArr) + zzj2.delete("default_event_params", "app_id=?", strArr) + zzj2.delete("trigger_uris", "app_id=?", strArr) + zzj2.delete("upload_queue", "app_id=?", strArr);
            if (delete > 0) {
                zzj.zzu.zzaW().zzj().zzc("Reset analytics data. app, records", str, Integer.valueOf(delete));
            }
        } catch (SQLiteException e) {
            zzj.zzu.zzaW().zze().zzc("Error resetting analytics data. appId, error", zzhe.zzn(str), e);
        }
        if (zzrVar.zzh) {
            zzac(zzrVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzai(zzr zzrVar) {
        zzaX().zzg();
        zzM();
        String str = zzrVar.zza;
        Preconditions.checkNotEmpty(str);
        zzba zze = zzba.zze(zzrVar.zzA);
        zzaW().zzj().zzc("Setting DMA consent for package", str, zze);
        zzaX().zzg();
        zzM();
        zzju zzf = zzba.zzc(zzd(str), 100).zzf();
        this.zzD.put(str, zze);
        zzj().zzU(str, zze);
        zzju zzf2 = zzba.zzc(zzd(str), 100).zzf();
        zzaX().zzg();
        zzM();
        boolean z = zzf == zzju.DENIED && zzf2 == zzju.GRANTED;
        boolean z2 = zzf == zzju.GRANTED && zzf2 == zzju.DENIED;
        if (z || z2) {
            zzaW().zzj().zzb("Generated _dcu event for", str);
            Bundle bundle = new Bundle();
            if (zzj().zzo(zza(), str, false, false, false, false, false, false, false).zzf < zzi().zzh(str, zzgi.zzal)) {
                bundle.putLong("_r", 1L);
                zzaW().zzj().zzc("_dcu realtime event count", str, Long.valueOf(zzj().zzo(zza(), str, false, false, false, false, false, true, false).zzf));
            }
            this.zzK.zza(str, "_dcu", bundle);
        }
    }

    public final void zzaj(String str, zzmh zzmhVar) {
        zzaX().zzg();
        String str2 = this.zzH;
        if (str2 == null || str2.equals(str) || zzmhVar != null) {
            this.zzH = str;
            this.zzG = zzmhVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzak(zzr zzrVar) {
        zzaX().zzg();
        zzM();
        String str = zzrVar.zza;
        Preconditions.checkNotEmpty(str);
        zzjx zzk = zzjx.zzk(zzrVar.zzu, zzrVar.zzz);
        zzu(str);
        zzaW().zzj().zzc("Setting storage consent for package", str, zzk);
        zzaq(str, zzk);
    }

    final void zzal(List list) {
        Preconditions.checkArgument(!list.isEmpty());
        if (this.zzz != null) {
            zzaW().zze().zza("Set uploading progress before finishing the previous upload");
        } else {
            this.zzz = new ArrayList(list);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzam() {
        zzaX().zzg();
        zzj().zzO();
        zzaw zzj = zzj();
        zzj.zzg();
        zzj.zzav();
        if (zzj.zzae() && ((Long) zzgi.zzau.zza(null)).longValue() != 0) {
            SQLiteDatabase zzj2 = zzj.zzj();
            zzio zzioVar = zzj.zzu;
            int delete = zzj2.delete("trigger_uris", "abs(timestamp_millis - ?) > cast(? as integer)", new String[]{String.valueOf(zzioVar.zzaU().currentTimeMillis()), String.valueOf(zzgi.zzau.zza(null))});
            if (delete > 0) {
                zzioVar.zzaW().zzj().zzb("Deleted stale trigger uris. rowsDeleted", Integer.valueOf(delete));
            }
        }
        if (this.zzk.zzd.zza() == 0) {
            this.zzk.zzd.zzb(zzaU().currentTimeMillis());
        }
        zzaL();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzan(zzai zzaiVar) {
        zzr zzaD = zzaD((String) Preconditions.checkNotNull(zzaiVar.zza));
        if (zzaD != null) {
            zzao(zzaiVar, zzaD);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzao(zzai zzaiVar, zzr zzrVar) {
        Preconditions.checkNotNull(zzaiVar);
        Preconditions.checkNotEmpty(zzaiVar.zza);
        Preconditions.checkNotNull(zzaiVar.zzb);
        Preconditions.checkNotNull(zzaiVar.zzc);
        Preconditions.checkNotEmpty(zzaiVar.zzc.zzb);
        zzaX().zzg();
        zzM();
        if (zzaQ(zzrVar)) {
            if (!zzrVar.zzh) {
                zzg(zzrVar);
                return;
            }
            zzai zzaiVar2 = new zzai(zzaiVar);
            boolean z = false;
            zzaiVar2.zze = false;
            zzj().zzH();
            try {
                zzai zzm = zzj().zzm((String) Preconditions.checkNotNull(zzaiVar2.zza), zzaiVar2.zzc.zzb);
                if (zzm != null && !zzm.zzb.equals(zzaiVar2.zzb)) {
                    zzaW().zzk().zzd("Updating a conditional user property with different origin. name, origin, origin (from DB)", this.zzn.zzj().zzf(zzaiVar2.zzc.zzb), zzaiVar2.zzb, zzm.zzb);
                }
                if (zzm == null || !zzm.zze) {
                    if (TextUtils.isEmpty(zzaiVar2.zzf)) {
                        zzqb zzqbVar = zzaiVar2.zzc;
                        zzaiVar2.zzc = new zzqb(zzqbVar.zzb, zzaiVar2.zzd, zzqbVar.zza(), zzaiVar2.zzc.zzf);
                        zzaiVar2.zze = true;
                        z = true;
                    }
                } else {
                    zzaiVar2.zzb = zzm.zzb;
                    zzaiVar2.zzd = zzm.zzd;
                    zzaiVar2.zzh = zzm.zzh;
                    zzaiVar2.zzf = zzm.zzf;
                    zzaiVar2.zzi = zzm.zzi;
                    zzaiVar2.zze = true;
                    zzqb zzqbVar2 = zzaiVar2.zzc;
                    zzaiVar2.zzc = new zzqb(zzqbVar2.zzb, zzm.zzc.zzc, zzqbVar2.zza(), zzm.zzc.zzf);
                }
                if (zzaiVar2.zze) {
                    zzqb zzqbVar3 = zzaiVar2.zzc;
                    zzqd zzqdVar = new zzqd((String) Preconditions.checkNotNull(zzaiVar2.zza), zzaiVar2.zzb, zzqbVar3.zzb, zzqbVar3.zzc, Preconditions.checkNotNull(zzqbVar3.zza()));
                    if (zzj().zzai(zzqdVar)) {
                        zzaW().zzd().zzd("User property updated immediately", zzaiVar2.zza, this.zzn.zzj().zzf(zzqdVar.zzc), zzqdVar.zze);
                    } else {
                        zzaW().zze().zzd("(2)Too many active user properties, ignoring", zzhe.zzn(zzaiVar2.zza), this.zzn.zzj().zzf(zzqdVar.zzc), zzqdVar.zze);
                    }
                    if (z && zzaiVar2.zzi != null) {
                        zzax(new zzbh(zzaiVar2.zzi, zzaiVar2.zzd), zzrVar);
                    }
                }
                if (zzj().zzah(zzaiVar2)) {
                    zzaW().zzd().zzd("Conditional property added", zzaiVar2.zza, this.zzn.zzj().zzf(zzaiVar2.zzc.zzb), zzaiVar2.zzc.zza());
                } else {
                    zzaW().zze().zzd("Too many conditional properties, ignoring", zzhe.zzn(zzaiVar2.zza), this.zzn.zzj().zzf(zzaiVar2.zzc.zzb), zzaiVar2.zzc.zza());
                }
                zzj().zzS();
            } finally {
                zzj().zzL();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzap(String str, zzag zzagVar) {
        zzam zzi = zzi();
        zzgg zzggVar = zzgi.zzaP;
        if (zzi.zzx(null, zzggVar)) {
            zzaX().zzg();
            zzM();
            zzaw zzj = zzj();
            long j = zzagVar.zza;
            zzpz zzx = zzj.zzx(j);
            if (zzx == null) {
                zzaW().zzk().zzc("[sgtm] Queued batch doesn't exist. appId, rowId", str, Long.valueOf(j));
                return;
            }
            String zzh = zzx.zzh();
            if (zzagVar.zzb == zzme.SUCCESS.zza()) {
                Map map = this.zzF;
                if (map.containsKey(zzh)) {
                    map.remove(zzh);
                }
                zzaw zzj2 = zzj();
                Long valueOf = Long.valueOf(j);
                zzj2.zzK(valueOf);
                zzaW().zzj().zzc("[sgtm] queued batch deleted after successful client upload. appId, rowId", str, valueOf);
                long j2 = zzagVar.zzc;
                if (j2 > 0) {
                    zzaw zzj3 = zzj();
                    zzio zzioVar = zzj3.zzu;
                    if (zzioVar.zzf().zzx(null, zzggVar)) {
                        zzj3.zzg();
                        zzj3.zzav();
                        Long valueOf2 = Long.valueOf(j2);
                        Preconditions.checkNotNull(valueOf2);
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("upload_type", Integer.valueOf(zzmf.GOOGLE_SIGNAL.zza()));
                        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, Long.valueOf(zzioVar.zzaU().currentTimeMillis()));
                        try {
                            if (zzj3.zzj().update("upload_queue", contentValues, "rowid=? AND app_id=? AND upload_type=?", new String[]{String.valueOf(j2), str, String.valueOf(zzmf.GOOGLE_SIGNAL_PENDING.zza())}) != 1) {
                                zzioVar.zzaW().zzk().zzc("Google Signal pending batch not updated. appId, rowId", str, valueOf2);
                            }
                        } catch (SQLiteException e) {
                            zzj3.zzu.zzaW().zze().zzd("Failed to update google Signal pending batch. appid, rowId", str, Long.valueOf(j2), e);
                            throw e;
                        }
                    }
                    zzaW().zzj().zzc("[sgtm] queued Google Signal batch updated. appId, signalRowId", str, Long.valueOf(zzagVar.zzc));
                    zzav(str);
                    return;
                }
                return;
            }
            if (zzagVar.zzb == zzme.BACKOFF.zza()) {
                Map map2 = this.zzF;
                zzpt zzptVar = (zzpt) map2.get(zzh);
                if (zzptVar == null) {
                    zzptVar = new zzpt(this);
                    map2.put(zzh, zzptVar);
                } else {
                    zzptVar.zzb();
                }
                zzaW().zzj().zzd("[sgtm] Putting sGTM server in backoff mode. appId, destination, nextRetryInSeconds", str, zzh, Long.valueOf((zzpt.zza(zzptVar) - zzaU().currentTimeMillis()) / 1000));
            }
            zzaw zzj4 = zzj();
            Long valueOf3 = Long.valueOf(zzagVar.zza);
            zzj4.zzN(valueOf3);
            zzaW().zzj().zzc("[sgtm] increased batch retry count after failed client upload. appId, rowId", str, valueOf3);
        }
    }

    final void zzaq(String str, zzjx zzjxVar) {
        zzaX().zzg();
        zzM();
        this.zzC.put(str, zzjxVar);
        zzj().zzX(str, zzjxVar);
    }

    final void zzar(String str, boolean z, Long l, Long l2) {
        zzh zzl = zzj().zzl(str);
        if (zzl != null) {
            zzl.zzaF(z);
            zzl.zzaG(l);
            zzl.zzaH(l2);
            if (zzl.zzaK()) {
                zzj().zzT(zzl, false, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzas(zzqb zzqbVar, zzr zzrVar) {
        String str;
        zzqd zzy;
        long j;
        zzaX().zzg();
        zzM();
        if (zzaQ(zzrVar)) {
            if (!zzrVar.zzh) {
                zzg(zzrVar);
                return;
            }
            zzqf zzB = zzB();
            String str2 = zzqbVar.zzb;
            int zzj = zzB.zzj(str2);
            if (zzj != 0) {
                zzqf zzB2 = zzB();
                zzi();
                zzB().zzR(this.zzK, zzrVar.zza, zzj, "_ev", zzB2.zzG(str2, 24, true), str2 != null ? str2.length() : 0);
                return;
            }
            int zzd = zzB().zzd(str2, zzqbVar.zza());
            if (zzd != 0) {
                zzqf zzB3 = zzB();
                zzi();
                String zzG = zzB3.zzG(str2, 24, true);
                Object zza = zzqbVar.zza();
                zzB().zzR(this.zzK, zzrVar.zza, zzd, "_ev", zzG, (zza == null || !((zza instanceof String) || (zza instanceof CharSequence))) ? 0 : zza.toString().length());
                return;
            }
            Object zzE = zzB().zzE(str2, zzqbVar.zza());
            if (zzE != null) {
                if (!"_sid".equals(str2)) {
                    str = "_sid";
                } else {
                    long j2 = zzqbVar.zzc;
                    String str3 = zzqbVar.zzf;
                    String str4 = (String) Preconditions.checkNotNull(zzrVar.zza);
                    zzqd zzy2 = zzj().zzy(str4, "_sno");
                    if (zzy2 != null) {
                        Object obj = zzy2.zze;
                        if (obj instanceof Long) {
                            j = ((Long) obj).longValue();
                            str = "_sid";
                            zzas(new zzqb("_sno", j2, Long.valueOf(j + 1), str3), zzrVar);
                        }
                    }
                    if (zzy2 != null) {
                        zzaW().zzk().zzb("Retrieved last session number from database does not contain a valid (long) value", zzy2.zze);
                    }
                    zzbd zzs = zzj().zzs(str4, "_s");
                    if (zzs == null) {
                        str = "_sid";
                        j = 0;
                    } else {
                        zzhc zzj2 = zzaW().zzj();
                        str = "_sid";
                        long j3 = zzs.zzc;
                        zzj2.zzb("Backfill the session number. Last used session number", Long.valueOf(j3));
                        j = j3;
                    }
                    zzas(new zzqb("_sno", j2, Long.valueOf(j + 1), str3), zzrVar);
                }
                String str5 = zzrVar.zza;
                zzqd zzqdVar = new zzqd((String) Preconditions.checkNotNull(str5), (String) Preconditions.checkNotNull(zzqbVar.zzf), str2, zzqbVar.zzc, zzE);
                zzhc zzj3 = zzaW().zzj();
                zzio zzioVar = this.zzn;
                String str6 = zzqdVar.zzc;
                zzj3.zzc("Setting user property", zzioVar.zzj().zzf(str6), zzE);
                zzj().zzH();
                try {
                    if ("_id".equals(str6) && (zzy = zzj().zzy(str5, "_id")) != null && !zzqdVar.zze.equals(zzy.zze)) {
                        zzj().zzP(str5, "_lair");
                    }
                    zzg(zzrVar);
                    boolean zzai = zzj().zzai(zzqdVar);
                    if (str.equals(str2)) {
                        long zzd2 = zzA().zzd(zzrVar.zzw);
                        zzh zzl = zzj().zzl(str5);
                        if (zzl != null) {
                            zzl.zzaB(zzd2);
                            if (zzl.zzaK()) {
                                zzj().zzT(zzl, false, false);
                            }
                        }
                    }
                    zzj().zzS();
                    if (!zzai) {
                        zzaW().zze().zzc("Too many unique user properties are set. Ignoring user property", zzioVar.zzj().zzf(str6), zzqdVar.zze);
                        zzB().zzR(this.zzK, str5, 9, null, null, 0);
                    }
                } finally {
                    zzj().zzL();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0128, code lost:
    
        r11.zzB = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0110, code lost:
    
        if (r7 != null) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0125, code lost:
    
        if (r7 == null) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0171, code lost:
    
        if (r1 != 0) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0173, code lost:
    
        r1.close();
        r3 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0198, code lost:
    
        r1 = android.text.TextUtils.isEmpty(r7);
        r1 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x019c, code lost:
    
        if (r1 != false) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x019e, code lost:
    
        r1 = zzj().zzl(r7);
        r1 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x01a6, code lost:
    
        if (r1 == null) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x01a8, code lost:
    
        zzO(r1);
        r1 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x017b, code lost:
    
        if (r1 != 0) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0195, code lost:
    
        if (r1 != 0) goto L56;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v0, types: [com.google.android.gms.measurement.internal.zzpv] */
    /* JADX WARN: Type inference failed for: r1v12, types: [long] */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v19 */
    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r1v27, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r1v40 */
    /* JADX WARN: Type inference failed for: r1v41 */
    /* JADX WARN: Type inference failed for: r1v42 */
    /* JADX WARN: Type inference failed for: r3v8, types: [com.google.android.gms.measurement.internal.zzhc] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:74:0x0195 -> B:60:0x0173). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:74:0x0195 -> B:61:0x0198). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zzat() {
        zzaw zzj;
        long zzF;
        SQLiteException e;
        zzaw zzawVar;
        Cursor cursor;
        zzaX().zzg();
        zzM();
        this.zzw = true;
        try {
            zzio zzioVar = this.zzn;
            zzioVar.zzaV();
            Boolean zzl = zzioVar.zzu().zzl();
            if (zzl == null) {
                zzaW().zzk().zza("Upload data called on the client side before use of service was decided");
            } else if (zzl.booleanValue()) {
                zzaW().zze().zza("Upload called in the client side when service should be used");
            } else if (this.zza <= 0) {
                zzaX().zzg();
                if (this.zzz != null) {
                    zzaW().zzj().zza("Uploading requested multiple times");
                } else if (!zzp().zzd()) {
                    zzaW().zzj().zza("Network not connected, ignoring upload request");
                    zzaL();
                } else {
                    ?? currentTimeMillis = zzaU().currentTimeMillis();
                    Cursor cursor2 = null;
                    r7 = null;
                    Cursor cursor3 = null;
                    r7 = null;
                    r7 = null;
                    r7 = null;
                    String str = null;
                    int zzh = zzi().zzh(null, zzgi.zzah);
                    zzi();
                    long zzF2 = currentTimeMillis - zzam.zzF();
                    for (int i = 0; i < zzh && zzaM(null, zzF2); i++) {
                    }
                    zzqr.zzb();
                    zzaX().zzg();
                    zzaJ();
                    long zza = this.zzk.zzd.zza();
                    if (zza != 0) {
                        zzaW().zzd().zzb("Uploading events. Elapsed time since last upload attempt (ms)", Long.valueOf(Math.abs(currentTimeMillis - zza)));
                    }
                    String zzA = zzj().zzA();
                    long j = -1;
                    if (TextUtils.isEmpty(zzA)) {
                        try {
                            this.zzB = -1L;
                            zzj = zzj();
                            zzi();
                            zzF = currentTimeMillis - zzam.zzF();
                            zzj.zzg();
                            zzj.zzav();
                        } catch (Throwable th) {
                            th = th;
                            cursor2 = currentTimeMillis;
                        }
                        try {
                            currentTimeMillis = zzj.zzj().rawQuery("select app_id from apps where app_id in (select distinct app_id from raw_events) and config_fetched_time < ? order by failed_config_fetch_time limit 1;", new String[]{String.valueOf(zzF)});
                            try {
                                if (!currentTimeMillis.moveToFirst()) {
                                    zzj.zzu.zzaW().zzj().zza("No expired configs for apps with pending events");
                                    cursor = currentTimeMillis;
                                    zzawVar = zzj;
                                    zzj = zzj;
                                } else {
                                    str = currentTimeMillis.getString(0);
                                    cursor = currentTimeMillis;
                                    zzawVar = zzj;
                                    zzj = zzj;
                                }
                            } catch (SQLiteException e2) {
                                e = e2;
                                ?? zze = zzj.zzu.zzaW().zze();
                                zze.zzb("Error selecting expired configs", e);
                                cursor = currentTimeMillis;
                                zzawVar = zze;
                                zzj = zze;
                            }
                        } catch (SQLiteException e3) {
                            e = e3;
                            currentTimeMillis = 0;
                            ?? zze2 = zzj.zzu.zzaW().zze();
                            zze2.zzb("Error selecting expired configs", e);
                            cursor = currentTimeMillis;
                            zzawVar = zze2;
                            zzj = zze2;
                        } catch (Throwable th2) {
                            th = th2;
                            if (cursor2 != null) {
                                cursor2.close();
                            }
                            throw th;
                        }
                    } else {
                        if (this.zzB == -1) {
                            zzaw zzj2 = zzj();
                            try {
                                try {
                                    cursor3 = zzj2.zzj().rawQuery("select rowid from raw_events order by rowid desc limit 1;", null);
                                    if (cursor3.moveToFirst()) {
                                        j = cursor3.getLong(0);
                                    }
                                } catch (SQLiteException e4) {
                                    zzj2.zzu.zzaW().zze().zzb("Error querying raw events", e4);
                                }
                            } finally {
                                if (cursor3 != null) {
                                    cursor3.close();
                                }
                            }
                        }
                        zzau(zzA, currentTimeMillis);
                    }
                }
            } else {
                zzaL();
            }
        } finally {
            this.zzw = false;
            zzaH();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x006b, code lost:
    
        if (r11 != null) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x006d, code lost:
    
        r11.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:224:0x01cc, code lost:
    
        r11.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:288:0x01f0, code lost:
    
        if (r11 == null) goto L89;
     */
    /* JADX WARN: Not initialized variable reg: 11, insn: 0x06d7: MOVE (r10 I:??[OBJECT, ARRAY]) = (r11 I:??[OBJECT, ARRAY]), block:B:291:0x06d7 */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0699  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x06a2  */
    /* JADX WARN: Removed duplicated region for block: B:293:0x06da  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x03ca  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0404 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    final void zzau(String str, long j) {
        Cursor cursor;
        Cursor cursor2;
        Cursor cursor3;
        List emptyList;
        String str2;
        long j2;
        zzph zzphVar;
        int i;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        com.google.android.gms.internal.measurement.zzim zzb2;
        String str3;
        byte[] blob;
        zzqa zzA;
        long j3;
        long j4;
        int zzh = zzi().zzh(str, zzgi.zzg);
        int i2 = 0;
        int max = Math.max(0, zzi().zzh(str, zzgi.zzh));
        zzaw zzj = zzj();
        zzj.zzg();
        zzj.zzav();
        int i3 = 1;
        Preconditions.checkArgument(zzh > 0);
        Preconditions.checkArgument(max > 0);
        Preconditions.checkNotEmpty(str);
        try {
            try {
                cursor2 = zzj.zzj().query("queue", new String[]{"rowid", "data", "retry_count"}, "app_id=?", new String[]{str}, null, null, "rowid", String.valueOf(zzh));
                try {
                    if (!cursor2.moveToFirst()) {
                        emptyList = Collections.emptyList();
                    } else {
                        ArrayList arrayList = new ArrayList();
                        int i4 = 0;
                        while (true) {
                            long j5 = cursor2.getLong(i2);
                            try {
                                blob = cursor2.getBlob(i3);
                                zzA = zzj.zzg.zzA();
                            } catch (IOException e) {
                                zzj.zzu.zzaW().zze().zzc("Failed to unzip queued bundle. appId", zzhe.zzn(str), e);
                            }
                            try {
                                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(blob);
                                GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
                                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                                byte[] bArr = new byte[1024];
                                while (true) {
                                    int read = gZIPInputStream.read(bArr);
                                    if (read <= 0) {
                                        break;
                                    } else {
                                        byteArrayOutputStream.write(bArr, 0, read);
                                    }
                                }
                                gZIPInputStream.close();
                                byteArrayInputStream.close();
                                byte[] byteArray = byteArrayOutputStream.toByteArray();
                                if (!arrayList.isEmpty() && byteArray.length + i4 > max) {
                                    break;
                                }
                                try {
                                    com.google.android.gms.internal.measurement.zzhw zzhwVar = (com.google.android.gms.internal.measurement.zzhw) zzqa.zzp(com.google.android.gms.internal.measurement.zzhx.zzz(), byteArray);
                                    if (!arrayList.isEmpty()) {
                                        com.google.android.gms.internal.measurement.zzhx zzhxVar = (com.google.android.gms.internal.measurement.zzhx) ((Pair) arrayList.get(0)).first;
                                        com.google.android.gms.internal.measurement.zzhx zzhxVar2 = (com.google.android.gms.internal.measurement.zzhx) zzhwVar.zzba();
                                        if (!zzhxVar.zzK().equals(zzhxVar2.zzK()) || !zzhxVar.zzJ().equals(zzhxVar2.zzJ()) || zzhxVar.zzbu() != zzhxVar2.zzbu() || !zzhxVar.zzL().equals(zzhxVar2.zzL())) {
                                            break;
                                        }
                                        Iterator it = zzhxVar.zzY().iterator();
                                        while (true) {
                                            j3 = -1;
                                            if (!it.hasNext()) {
                                                j4 = -1;
                                                break;
                                            }
                                            com.google.android.gms.internal.measurement.zzio zzioVar = (com.google.android.gms.internal.measurement.zzio) it.next();
                                            if ("_npa".equals(zzioVar.zzg())) {
                                                j4 = zzioVar.zzc();
                                                break;
                                            }
                                        }
                                        Iterator it2 = zzhxVar2.zzY().iterator();
                                        while (true) {
                                            if (!it2.hasNext()) {
                                                break;
                                            }
                                            com.google.android.gms.internal.measurement.zzio zzioVar2 = (com.google.android.gms.internal.measurement.zzio) it2.next();
                                            if ("_npa".equals(zzioVar2.zzg())) {
                                                j3 = zzioVar2.zzc();
                                                break;
                                            }
                                        }
                                        if (j4 != j3) {
                                            break;
                                        }
                                    }
                                    if (!cursor2.isNull(2)) {
                                        zzhwVar.zzat(cursor2.getInt(2));
                                    }
                                    i4 += byteArray.length;
                                    arrayList.add(Pair.create((com.google.android.gms.internal.measurement.zzhx) zzhwVar.zzba(), Long.valueOf(j5)));
                                } catch (IOException e2) {
                                    zzj.zzu.zzaW().zze().zzc("Failed to merge queued bundle. appId", zzhe.zzn(str), e2);
                                }
                                if (!cursor2.moveToNext() || i4 > max) {
                                    break;
                                }
                                i2 = 0;
                                i3 = 1;
                            } catch (IOException e3) {
                                zzA.zzu.zzaW().zze().zzb("Failed to ungzip content", e3);
                                throw e3;
                                break;
                            }
                        }
                        emptyList = arrayList;
                    }
                } catch (SQLiteException e4) {
                    e = e4;
                    zzj.zzu.zzaW().zze().zzc("Error querying bundles. appId", zzhe.zzn(str), e);
                    emptyList = Collections.emptyList();
                }
            } catch (Throwable th) {
                th = th;
                cursor = cursor3;
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        } catch (SQLiteException e5) {
            e = e5;
            cursor2 = null;
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
            if (cursor != null) {
            }
            throw th;
        }
        if (emptyList.isEmpty()) {
            return;
        }
        if (zzu(str).zzr(zzjw.AD_STORAGE)) {
            Iterator it3 = emptyList.iterator();
            while (true) {
                if (!it3.hasNext()) {
                    str3 = null;
                    break;
                }
                com.google.android.gms.internal.measurement.zzhx zzhxVar3 = (com.google.android.gms.internal.measurement.zzhx) ((Pair) it3.next()).first;
                if (!zzhxVar3.zzT().isEmpty()) {
                    str3 = zzhxVar3.zzT();
                    break;
                }
            }
            if (str3 != null) {
                int i5 = 0;
                while (true) {
                    if (i5 >= emptyList.size()) {
                        break;
                    }
                    com.google.android.gms.internal.measurement.zzhx zzhxVar4 = (com.google.android.gms.internal.measurement.zzhx) ((Pair) emptyList.get(i5)).first;
                    if (!zzhxVar4.zzT().isEmpty() && !zzhxVar4.zzT().equals(str3)) {
                        emptyList = emptyList.subList(0, i5);
                        break;
                    }
                    i5++;
                }
            }
        }
        com.google.android.gms.internal.measurement.zzht zzb3 = com.google.android.gms.internal.measurement.zzhv.zzb();
        int size = emptyList.size();
        List arrayList2 = new ArrayList(emptyList.size());
        boolean z5 = zzi().zzy(str) && zzu(str).zzr(zzjw.AD_STORAGE);
        boolean zzr = zzu(str).zzr(zzjw.AD_STORAGE);
        boolean zzr2 = zzu(str).zzr(zzjw.ANALYTICS_STORAGE);
        zzrd.zzb();
        boolean zzx = zzi().zzx(str, zzgi.zzaL);
        zzpi zzpiVar = this.zzl;
        zzph zza = zzpiVar.zza(str);
        int i6 = 0;
        while (i6 < size) {
            com.google.android.gms.internal.measurement.zzhw zzhwVar2 = (com.google.android.gms.internal.measurement.zzhw) ((com.google.android.gms.internal.measurement.zzhx) ((Pair) emptyList.get(i6)).first).zzch();
            arrayList2.add((Long) ((Pair) emptyList.get(i6)).second);
            zzi().zzj();
            zzhwVar2.zzaB(119002L);
            zzhwVar2.zzaA(j);
            List list = emptyList;
            this.zzn.zzaV();
            int i7 = size;
            zzhwVar2.zzau(false);
            if (!z5) {
                zzhwVar2.zzt();
            }
            if (!zzr) {
                zzhwVar2.zzz();
                zzhwVar2.zzw();
            }
            if (!zzr2) {
                zzhwVar2.zzq();
            }
            zzN(str, zzhwVar2);
            if (!zzx) {
                zzhwVar2.zzA();
            }
            if (!zzr2) {
                zzhwVar2.zzr();
            }
            String zzaL = zzhwVar2.zzaL();
            if (TextUtils.isEmpty(zzaL)) {
                i = i7;
            } else {
                i = i7;
                if (!zzaL.equals("00000000-0000-0000-0000-000000000000")) {
                    z = z5;
                    z2 = zzr;
                    z3 = zzr2;
                    z4 = zzx;
                    if (zzhwVar2.zzc() != 0) {
                        if (zzi().zzx(str, zzgi.zzaB)) {
                            zzhwVar2.zzQ(zzA().zzf(((com.google.android.gms.internal.measurement.zzhx) zzhwVar2.zzba()).zzcd()));
                        }
                        if (zzi().zzx(null, zzgi.zzaP) && (zzb2 = zza.zzb()) != null) {
                            zzhwVar2.zzaw(zzb2);
                        }
                        zzb3.zzc(zzhwVar2);
                    }
                    i6++;
                    emptyList = list;
                    size = i;
                    z5 = z;
                    zzr = z2;
                    zzx = z4;
                    zzr2 = z3;
                }
            }
            ArrayList arrayList3 = new ArrayList(zzhwVar2.zzaM());
            Iterator it4 = arrayList3.iterator();
            z = z5;
            z2 = zzr;
            Long l = null;
            Long l2 = null;
            boolean z6 = false;
            boolean z7 = false;
            while (it4.hasNext()) {
                boolean z8 = zzr2;
                com.google.android.gms.internal.measurement.zzhm zzhmVar = (com.google.android.gms.internal.measurement.zzhm) it4.next();
                boolean z9 = zzx;
                if ("_fx".equals(zzhmVar.zzh())) {
                    it4.remove();
                    zzx = z9;
                    zzr2 = z8;
                    z6 = true;
                } else if ("_f".equals(zzhmVar.zzh())) {
                    zzA();
                    com.google.android.gms.internal.measurement.zzhq zzG = zzqa.zzG(zzhmVar, "_pfo");
                    if (zzG != null) {
                        l = Long.valueOf(zzG.zzd());
                    }
                    zzA();
                    com.google.android.gms.internal.measurement.zzhq zzG2 = zzqa.zzG(zzhmVar, "_uwa");
                    if (zzG2 != null) {
                        l2 = Long.valueOf(zzG2.zzd());
                    }
                    zzx = z9;
                    zzr2 = z8;
                } else {
                    zzx = z9;
                    zzr2 = z8;
                }
                z7 = true;
            }
            z3 = zzr2;
            z4 = zzx;
            if (z6) {
                zzhwVar2.zzu();
                zzhwVar2.zzj(arrayList3);
            }
            if (z7) {
                zzar(zzhwVar2.zzaF(), true, l, l2);
            }
            if (zzhwVar2.zzc() != 0) {
            }
            i6++;
            emptyList = list;
            size = i;
            z5 = z;
            zzr = z2;
            zzx = z4;
            zzr2 = z3;
        }
        if (zzb3.zza() == 0) {
            zzal(arrayList2);
            zzY(false, MlKitException.CODE_SCANNER_TASK_IN_PROGRESS, null, null, str, Collections.emptyList());
            return;
        }
        com.google.android.gms.internal.measurement.zzhv zzhvVar = (com.google.android.gms.internal.measurement.zzhv) zzb3.zzba();
        List arrayList4 = new ArrayList();
        boolean z10 = zzi().zzx(null, zzgi.zzaP) && zza.zza() == zzmf.SGTM_CLIENT;
        if (zza.zza() != zzmf.SGTM) {
            if (!z10) {
                j2 = j;
                if (zzi().zzx(null, zzgi.zzaO) || zzp().zzd()) {
                    Object zzq = !Log.isLoggable(zzaW().zzr(), 2) ? zzA().zzq(zzhvVar) : null;
                    zzA();
                    byte[] zzcd = zzhvVar.zzcd();
                    zzal(arrayList2);
                    this.zzk.zze.zzb(j2);
                    zzaW().zzj().zzd("Uploading data. app, uncompressed size, data", str, Integer.valueOf(zzcd.length), zzq);
                    this.zzv = true;
                    zzp().zzc(str, zza, zzhvVar, new zzpl(this, str, arrayList4));
                }
                return;
            }
            z10 = true;
        }
        Iterator it5 = ((com.google.android.gms.internal.measurement.zzhv) zzb3.zzba()).zzh().iterator();
        while (true) {
            if (it5.hasNext()) {
                if (((com.google.android.gms.internal.measurement.zzhx) it5.next()).zzbI()) {
                    str2 = UUID.randomUUID().toString();
                    break;
                }
            } else {
                str2 = null;
                break;
            }
        }
        com.google.android.gms.internal.measurement.zzhv zzhvVar2 = (com.google.android.gms.internal.measurement.zzhv) zzb3.zzba();
        zzaX().zzg();
        zzM();
        com.google.android.gms.internal.measurement.zzht zzc = com.google.android.gms.internal.measurement.zzhv.zzc(zzhvVar2);
        if (!TextUtils.isEmpty(str2)) {
            zzc.zzf(str2);
        }
        String zzm = zzr().zzm(str);
        if (!TextUtils.isEmpty(zzm)) {
            zzc.zzg(zzm);
        }
        ArrayList arrayList5 = new ArrayList();
        Iterator it6 = zzhvVar2.zzh().iterator();
        while (it6.hasNext()) {
            com.google.android.gms.internal.measurement.zzhw zzA2 = com.google.android.gms.internal.measurement.zzhx.zzA((com.google.android.gms.internal.measurement.zzhx) it6.next());
            zzA2.zzt();
            arrayList5.add((com.google.android.gms.internal.measurement.zzhx) zzA2.zzba());
        }
        zzc.zzd();
        zzc.zzb(arrayList5);
        zzam zzi = zzi();
        zzgg zzggVar = zzgi.zzaN;
        if (zzi.zzx(null, zzggVar)) {
            zzaW().zzj().zzb("[sgtm] Processed MeasurementBatch for sGTM with sgtmJoinId: ", TextUtils.isEmpty(str2) ? "null" : zzc.zzi());
        } else {
            zzaW().zzj().zza("[sgtm] Processed MeasurementBatch for sGTM.");
        }
        com.google.android.gms.internal.measurement.zzhv zzhvVar3 = (com.google.android.gms.internal.measurement.zzhv) zzc.zzba();
        if (!TextUtils.isEmpty(str2) && zzi().zzx(null, zzggVar)) {
            com.google.android.gms.internal.measurement.zzhv zzhvVar4 = (com.google.android.gms.internal.measurement.zzhv) zzb3.zzba();
            zzaX().zzg();
            zzM();
            com.google.android.gms.internal.measurement.zzht zzb4 = com.google.android.gms.internal.measurement.zzhv.zzb();
            zzaW().zzj().zzb("[sgtm] Processing Google Signal, sgtmJoinId:", str2);
            zzb4.zzf(str2);
            for (com.google.android.gms.internal.measurement.zzhx zzhxVar5 : zzhvVar4.zzh()) {
                com.google.android.gms.internal.measurement.zzhw zzz = com.google.android.gms.internal.measurement.zzhx.zzz();
                zzz.zzY(zzhxVar5.zzN());
                zzz.zzV(zzhxVar5.zzd());
                zzb4.zzc(zzz);
            }
            com.google.android.gms.internal.measurement.zzhv zzhvVar5 = (com.google.android.gms.internal.measurement.zzhv) zzb4.zzba();
            String zzm2 = zzpiVar.zzg.zzr().zzm(str);
            if (!TextUtils.isEmpty(zzm2)) {
                Uri parse = Uri.parse((String) zzgi.zzr.zza(null));
                Uri.Builder buildUpon = parse.buildUpon();
                buildUpon.authority(zzm2 + "." + parse.getAuthority());
                zzphVar = new zzph(buildUpon.build().toString(), Collections.emptyMap(), z10 ? zzmf.GOOGLE_SIGNAL_PENDING : zzmf.GOOGLE_SIGNAL, null);
            } else {
                zzphVar = new zzph((String) zzgi.zzr.zza(null), Collections.emptyMap(), z10 ? zzmf.GOOGLE_SIGNAL_PENDING : zzmf.GOOGLE_SIGNAL, null);
            }
            arrayList4.add(Pair.create(zzhvVar5, zzphVar));
        }
        if (z10) {
            com.google.android.gms.internal.measurement.zzht zzhtVar = (com.google.android.gms.internal.measurement.zzht) zzhvVar3.zzch();
            for (int i8 = 0; i8 < zzhvVar3.zza(); i8++) {
                com.google.android.gms.internal.measurement.zzhw zzhwVar3 = (com.google.android.gms.internal.measurement.zzhw) zzhvVar3.zze(i8).zzch();
                zzhwVar3.zzC();
                zzhwVar3.zzO(j);
                zzhtVar.zze(i8, zzhwVar3);
            }
            arrayList4.add(Pair.create((com.google.android.gms.internal.measurement.zzhv) zzhtVar.zzba(), zza));
            zzal(arrayList2);
            zzY(false, MlKitException.CODE_SCANNER_TASK_IN_PROGRESS, null, null, str, arrayList4);
            if (zzay(str, zza.zzc())) {
                zzaW().zzj().zzb("[sgtm] Sending sgtm batches available notification to app", str);
                Intent intent = new Intent();
                intent.setAction("com.google.android.gms.measurement.BATCHES_AVAILABLE");
                intent.setPackage(str);
                zzaK(this.zzn.zzaT(), intent);
                return;
            }
            return;
        }
        j2 = j;
        zzhvVar = zzhvVar3;
        if (zzi().zzx(null, zzgi.zzaO)) {
        }
        if (!Log.isLoggable(zzaW().zzr(), 2)) {
        }
        zzA();
        byte[] zzcd2 = zzhvVar.zzcd();
        zzal(arrayList2);
        this.zzk.zze.zzb(j2);
        zzaW().zzj().zzd("Uploading data. app, uncompressed size, data", str, Integer.valueOf(zzcd2.length), zzq);
        this.zzv = true;
        zzp().zzc(str, zza, zzhvVar, new zzpl(this, str, arrayList4));
    }

    final void zzav(String str) {
        com.google.android.gms.internal.measurement.zzhv zzg;
        zzaX().zzg();
        zzM();
        this.zzw = true;
        try {
            zzio zzioVar = this.zzn;
            zzioVar.zzaV();
            Boolean zzl = zzioVar.zzu().zzl();
            if (zzl == null) {
                zzaW().zzk().zza("Upload data called on the client side before use of service was decided");
            } else if (zzl.booleanValue()) {
                zzaW().zze().zza("Upload called in the client side when service should be used");
            } else if (this.zza > 0) {
                zzaL();
            } else if (!zzp().zzd()) {
                zzaW().zzj().zza("Network not connected, ignoring upload request");
                zzaL();
            } else if (!zzj().zzY(str)) {
                zzaW().zzj().zzb("[sgtm] Upload queue has no batches for appId", str);
            } else {
                zzpz zzw = zzj().zzw(str);
                if (zzw != null && (zzg = zzw.zzg()) != null) {
                    zzaW().zzj().zzd("[sgtm] Uploading data from upload queue. appId, type, url", str, zzw.zzd(), zzw.zzh());
                    byte[] zzcd = zzg.zzcd();
                    if (Log.isLoggable(zzaW().zzr(), 2)) {
                        zzaW().zzj().zzd("[sgtm] Uploading data from upload queue. appId, uncompressed size, data", str, Integer.valueOf(zzcd.length), zzA().zzq(zzg));
                    }
                    this.zzv = true;
                    zzp().zzc(str, zzw.zzf(), zzg, new zzpm(this, str, zzw));
                }
            }
        } finally {
            this.zzw = false;
            zzaH();
        }
    }

    final void zzaw(String str, com.google.android.gms.internal.measurement.zzhp zzhpVar, Bundle bundle, String str2) {
        int zzd;
        List listOf = CollectionUtils.listOf((Object[]) new String[]{"_o", "_sn", "_sc", "_si"});
        if (zzqf.zzap(zzhpVar.zzl()) || zzqf.zzap(str)) {
            zzd = zzi().zzd(str2, true);
        } else {
            zzd = zzi().zzc(str2, true);
        }
        long j = zzd;
        long codePointCount = zzhpVar.zzm().codePointCount(0, zzhpVar.zzm().length());
        zzqf zzB = zzB();
        String zzl = zzhpVar.zzl();
        zzi();
        String zzG = zzB.zzG(zzl, 40, true);
        if (codePointCount <= j || listOf.contains(zzhpVar.zzl())) {
            return;
        }
        if ("_ev".equals(zzhpVar.zzl())) {
            bundle.putString("_ev", zzB().zzG(zzhpVar.zzm(), zzi().zzd(str2, true), true));
            return;
        }
        zzaW().zzl().zzc("Param value is too long; discarded. Name, value length", zzG, Long.valueOf(codePointCount));
        if (bundle.getLong("_err") == 0) {
            bundle.putLong("_err", 4L);
            if (bundle.getString("_ev") == null) {
                bundle.putString("_ev", zzG);
                bundle.putLong("_el", codePointCount);
            }
        }
        bundle.remove(zzhpVar.zzl());
    }

    /* JADX WARN: Can't wrap try/catch for region: R(15:376|(10:381|382|383|(1:385)|58|(0)(0)|61|(0)(0)|67|68)|386|387|388|389|382|383|(0)|58|(0)(0)|61|(0)(0)|67|68) */
    /* JADX WARN: Can't wrap try/catch for region: R(57:69|(2:71|(3:73|(1:75)|76))|77|(2:79|(3:81|(1:83)|84))|85|86|(1:88)(1:348)|89|(2:93|(1:95))|96|(2:106|107)|110|(6:111|112|113|114|115|116)|117|(1:119)|120|(2:122|(1:126)(1:125))(1:340)|127|(1:129)|130|(1:132)|133|(1:135)|136|(1:138)|139|(1:141)|142|(1:144)|145|(2:147|(1:149))|150|(1:339)(6:154|(1:158)|159|(1:161)(1:338)|162|(1:164)(15:309|(1:311)(1:337)|312|(1:314)(1:336)|315|(1:317)(1:335)|318|(1:320)(1:334)|321|(1:323)(1:333)|324|(1:326)(1:332)|327|(1:329)(1:331)|330))|165|(1:167)|168|(1:170)(1:308)|(4:175|(4:178|(3:180|181|(3:183|184|(3:186|187|189)(1:298))(1:300))(1:305)|299|176)|306|190)|307|(1:193)|194|(1:196)|197|(13:(2:201|(4:203|(1:205)|206|(29:214|(1:216)(1:296)|217|(1:219)|220|221|(2:223|(1:225))|226|(3:228|(1:230)|231)(1:295)|232|(1:236)|237|(1:239)|240|(4:243|(2:249|250)|251|241)|255|256|257|258|259|(2:260|(2:262|(1:264)(1:279))(3:280|281|(1:286)(1:285)))|265|266|267|268|(1:270)(2:275|276)|271|272|273)))|257|258|259|(3:260|(0)(0)|279)|265|266|267|268|(0)(0)|271|272|273)|297|221|(0)|226|(0)(0)|232|(2:234|236)|237|(0)|240|(1:241)|255|256) */
    /* JADX WARN: Code restructure failed: missing block: B:191:0x0802, code lost:
    
        if (r7.isEmpty() == false) goto L266;
     */
    /* JADX WARN: Code restructure failed: missing block: B:292:0x0b79, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:294:0x0b7b, code lost:
    
        zzaW().zze().zzc("Data loss. Failed to insert raw event metadata. appId", com.google.android.gms.measurement.internal.zzhe.zzn(r3.zzaF()), r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:391:0x0297, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:393:0x0299, code lost:
    
        r8.zzu.zzaW().zze().zzc("Error pruning currencies. appId", com.google.android.gms.measurement.internal.zzhe.zzn(r15), r0);
     */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0528 A[Catch: all -> 0x0bc1, TryCatch #3 {all -> 0x0bc1, blocks: (B:42:0x0157, B:45:0x0166, B:47:0x016e, B:51:0x0178, B:58:0x0302, B:61:0x0339, B:63:0x037c, B:65:0x0383, B:66:0x039a, B:71:0x03a7, B:73:0x03bf, B:75:0x03c6, B:76:0x03dd, B:79:0x0401, B:83:0x0424, B:84:0x043b, B:85:0x0444, B:88:0x0463, B:89:0x047c, B:91:0x0484, B:93:0x0490, B:95:0x0496, B:96:0x049d, B:98:0x04aa, B:100:0x04b2, B:102:0x04ba, B:104:0x04c2, B:107:0x04c6, B:110:0x04d2, B:112:0x04df, B:115:0x0504, B:119:0x0528, B:120:0x053d, B:122:0x0569, B:125:0x0580, B:126:0x05bc, B:127:0x05e4, B:129:0x061c, B:130:0x061f, B:132:0x0627, B:133:0x062a, B:135:0x0632, B:136:0x0635, B:138:0x063d, B:139:0x0640, B:141:0x0649, B:142:0x064d, B:144:0x065a, B:145:0x065d, B:147:0x0684, B:149:0x068c, B:150:0x068f, B:152:0x069e, B:154:0x06a8, B:158:0x06bf, B:162:0x06cc, B:165:0x0743, B:167:0x074b, B:168:0x074e, B:170:0x0774, B:172:0x077f, B:175:0x0787, B:176:0x07a1, B:178:0x07a7, B:181:0x07bb, B:184:0x07c7, B:187:0x07d4, B:303:0x07ee, B:190:0x07fe, B:193:0x0807, B:194:0x080a, B:196:0x0817, B:197:0x081c, B:199:0x083a, B:201:0x083e, B:203:0x084e, B:205:0x0859, B:206:0x0864, B:208:0x086e, B:210:0x087a, B:212:0x0884, B:214:0x088a, B:216:0x089a, B:217:0x08ae, B:219:0x08b4, B:220:0x08bd, B:221:0x08ce, B:223:0x090a, B:225:0x0914, B:226:0x0917, B:228:0x0921, B:230:0x093e, B:231:0x0949, B:232:0x0981, B:234:0x0989, B:236:0x0993, B:237:0x09a0, B:239:0x09aa, B:240:0x09b7, B:241:0x09c0, B:243:0x09c6, B:245:0x0a02, B:247:0x0a0c, B:249:0x0a1e, B:256:0x0a24, B:258:0x0a68, B:259:0x0a73, B:260:0x0a7e, B:262:0x0a84, B:266:0x0ad2, B:268:0x0b1d, B:270:0x0b2e, B:271:0x0b90, B:276:0x0b44, B:278:0x0b48, B:281:0x0a94, B:283:0x0abe, B:290:0x0b61, B:291:0x0b78, B:294:0x0b7b, B:308:0x0779, B:309:0x06d7, B:312:0x06e3, B:315:0x06f1, B:318:0x06ff, B:321:0x070d, B:324:0x071b, B:327:0x0727, B:330:0x0734, B:340:0x05d8, B:344:0x0510, B:349:0x0316, B:350:0x031d, B:352:0x0323, B:355:0x0333, B:360:0x0195, B:362:0x019f, B:364:0x01b4, B:369:0x01d4, B:372:0x020a, B:374:0x0210, B:376:0x021e, B:378:0x0232, B:381:0x0239, B:383:0x02c5, B:385:0x02cf, B:386:0x0265, B:388:0x0285, B:389:0x02ac, B:393:0x0299, B:395:0x01e0, B:397:0x01fe), top: B:41:0x0157, inners: #0, #1, #2, #8 }] */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0569 A[Catch: all -> 0x0bc1, TryCatch #3 {all -> 0x0bc1, blocks: (B:42:0x0157, B:45:0x0166, B:47:0x016e, B:51:0x0178, B:58:0x0302, B:61:0x0339, B:63:0x037c, B:65:0x0383, B:66:0x039a, B:71:0x03a7, B:73:0x03bf, B:75:0x03c6, B:76:0x03dd, B:79:0x0401, B:83:0x0424, B:84:0x043b, B:85:0x0444, B:88:0x0463, B:89:0x047c, B:91:0x0484, B:93:0x0490, B:95:0x0496, B:96:0x049d, B:98:0x04aa, B:100:0x04b2, B:102:0x04ba, B:104:0x04c2, B:107:0x04c6, B:110:0x04d2, B:112:0x04df, B:115:0x0504, B:119:0x0528, B:120:0x053d, B:122:0x0569, B:125:0x0580, B:126:0x05bc, B:127:0x05e4, B:129:0x061c, B:130:0x061f, B:132:0x0627, B:133:0x062a, B:135:0x0632, B:136:0x0635, B:138:0x063d, B:139:0x0640, B:141:0x0649, B:142:0x064d, B:144:0x065a, B:145:0x065d, B:147:0x0684, B:149:0x068c, B:150:0x068f, B:152:0x069e, B:154:0x06a8, B:158:0x06bf, B:162:0x06cc, B:165:0x0743, B:167:0x074b, B:168:0x074e, B:170:0x0774, B:172:0x077f, B:175:0x0787, B:176:0x07a1, B:178:0x07a7, B:181:0x07bb, B:184:0x07c7, B:187:0x07d4, B:303:0x07ee, B:190:0x07fe, B:193:0x0807, B:194:0x080a, B:196:0x0817, B:197:0x081c, B:199:0x083a, B:201:0x083e, B:203:0x084e, B:205:0x0859, B:206:0x0864, B:208:0x086e, B:210:0x087a, B:212:0x0884, B:214:0x088a, B:216:0x089a, B:217:0x08ae, B:219:0x08b4, B:220:0x08bd, B:221:0x08ce, B:223:0x090a, B:225:0x0914, B:226:0x0917, B:228:0x0921, B:230:0x093e, B:231:0x0949, B:232:0x0981, B:234:0x0989, B:236:0x0993, B:237:0x09a0, B:239:0x09aa, B:240:0x09b7, B:241:0x09c0, B:243:0x09c6, B:245:0x0a02, B:247:0x0a0c, B:249:0x0a1e, B:256:0x0a24, B:258:0x0a68, B:259:0x0a73, B:260:0x0a7e, B:262:0x0a84, B:266:0x0ad2, B:268:0x0b1d, B:270:0x0b2e, B:271:0x0b90, B:276:0x0b44, B:278:0x0b48, B:281:0x0a94, B:283:0x0abe, B:290:0x0b61, B:291:0x0b78, B:294:0x0b7b, B:308:0x0779, B:309:0x06d7, B:312:0x06e3, B:315:0x06f1, B:318:0x06ff, B:321:0x070d, B:324:0x071b, B:327:0x0727, B:330:0x0734, B:340:0x05d8, B:344:0x0510, B:349:0x0316, B:350:0x031d, B:352:0x0323, B:355:0x0333, B:360:0x0195, B:362:0x019f, B:364:0x01b4, B:369:0x01d4, B:372:0x020a, B:374:0x0210, B:376:0x021e, B:378:0x0232, B:381:0x0239, B:383:0x02c5, B:385:0x02cf, B:386:0x0265, B:388:0x0285, B:389:0x02ac, B:393:0x0299, B:395:0x01e0, B:397:0x01fe), top: B:41:0x0157, inners: #0, #1, #2, #8 }] */
    /* JADX WARN: Removed duplicated region for block: B:129:0x061c A[Catch: all -> 0x0bc1, TryCatch #3 {all -> 0x0bc1, blocks: (B:42:0x0157, B:45:0x0166, B:47:0x016e, B:51:0x0178, B:58:0x0302, B:61:0x0339, B:63:0x037c, B:65:0x0383, B:66:0x039a, B:71:0x03a7, B:73:0x03bf, B:75:0x03c6, B:76:0x03dd, B:79:0x0401, B:83:0x0424, B:84:0x043b, B:85:0x0444, B:88:0x0463, B:89:0x047c, B:91:0x0484, B:93:0x0490, B:95:0x0496, B:96:0x049d, B:98:0x04aa, B:100:0x04b2, B:102:0x04ba, B:104:0x04c2, B:107:0x04c6, B:110:0x04d2, B:112:0x04df, B:115:0x0504, B:119:0x0528, B:120:0x053d, B:122:0x0569, B:125:0x0580, B:126:0x05bc, B:127:0x05e4, B:129:0x061c, B:130:0x061f, B:132:0x0627, B:133:0x062a, B:135:0x0632, B:136:0x0635, B:138:0x063d, B:139:0x0640, B:141:0x0649, B:142:0x064d, B:144:0x065a, B:145:0x065d, B:147:0x0684, B:149:0x068c, B:150:0x068f, B:152:0x069e, B:154:0x06a8, B:158:0x06bf, B:162:0x06cc, B:165:0x0743, B:167:0x074b, B:168:0x074e, B:170:0x0774, B:172:0x077f, B:175:0x0787, B:176:0x07a1, B:178:0x07a7, B:181:0x07bb, B:184:0x07c7, B:187:0x07d4, B:303:0x07ee, B:190:0x07fe, B:193:0x0807, B:194:0x080a, B:196:0x0817, B:197:0x081c, B:199:0x083a, B:201:0x083e, B:203:0x084e, B:205:0x0859, B:206:0x0864, B:208:0x086e, B:210:0x087a, B:212:0x0884, B:214:0x088a, B:216:0x089a, B:217:0x08ae, B:219:0x08b4, B:220:0x08bd, B:221:0x08ce, B:223:0x090a, B:225:0x0914, B:226:0x0917, B:228:0x0921, B:230:0x093e, B:231:0x0949, B:232:0x0981, B:234:0x0989, B:236:0x0993, B:237:0x09a0, B:239:0x09aa, B:240:0x09b7, B:241:0x09c0, B:243:0x09c6, B:245:0x0a02, B:247:0x0a0c, B:249:0x0a1e, B:256:0x0a24, B:258:0x0a68, B:259:0x0a73, B:260:0x0a7e, B:262:0x0a84, B:266:0x0ad2, B:268:0x0b1d, B:270:0x0b2e, B:271:0x0b90, B:276:0x0b44, B:278:0x0b48, B:281:0x0a94, B:283:0x0abe, B:290:0x0b61, B:291:0x0b78, B:294:0x0b7b, B:308:0x0779, B:309:0x06d7, B:312:0x06e3, B:315:0x06f1, B:318:0x06ff, B:321:0x070d, B:324:0x071b, B:327:0x0727, B:330:0x0734, B:340:0x05d8, B:344:0x0510, B:349:0x0316, B:350:0x031d, B:352:0x0323, B:355:0x0333, B:360:0x0195, B:362:0x019f, B:364:0x01b4, B:369:0x01d4, B:372:0x020a, B:374:0x0210, B:376:0x021e, B:378:0x0232, B:381:0x0239, B:383:0x02c5, B:385:0x02cf, B:386:0x0265, B:388:0x0285, B:389:0x02ac, B:393:0x0299, B:395:0x01e0, B:397:0x01fe), top: B:41:0x0157, inners: #0, #1, #2, #8 }] */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0627 A[Catch: all -> 0x0bc1, TryCatch #3 {all -> 0x0bc1, blocks: (B:42:0x0157, B:45:0x0166, B:47:0x016e, B:51:0x0178, B:58:0x0302, B:61:0x0339, B:63:0x037c, B:65:0x0383, B:66:0x039a, B:71:0x03a7, B:73:0x03bf, B:75:0x03c6, B:76:0x03dd, B:79:0x0401, B:83:0x0424, B:84:0x043b, B:85:0x0444, B:88:0x0463, B:89:0x047c, B:91:0x0484, B:93:0x0490, B:95:0x0496, B:96:0x049d, B:98:0x04aa, B:100:0x04b2, B:102:0x04ba, B:104:0x04c2, B:107:0x04c6, B:110:0x04d2, B:112:0x04df, B:115:0x0504, B:119:0x0528, B:120:0x053d, B:122:0x0569, B:125:0x0580, B:126:0x05bc, B:127:0x05e4, B:129:0x061c, B:130:0x061f, B:132:0x0627, B:133:0x062a, B:135:0x0632, B:136:0x0635, B:138:0x063d, B:139:0x0640, B:141:0x0649, B:142:0x064d, B:144:0x065a, B:145:0x065d, B:147:0x0684, B:149:0x068c, B:150:0x068f, B:152:0x069e, B:154:0x06a8, B:158:0x06bf, B:162:0x06cc, B:165:0x0743, B:167:0x074b, B:168:0x074e, B:170:0x0774, B:172:0x077f, B:175:0x0787, B:176:0x07a1, B:178:0x07a7, B:181:0x07bb, B:184:0x07c7, B:187:0x07d4, B:303:0x07ee, B:190:0x07fe, B:193:0x0807, B:194:0x080a, B:196:0x0817, B:197:0x081c, B:199:0x083a, B:201:0x083e, B:203:0x084e, B:205:0x0859, B:206:0x0864, B:208:0x086e, B:210:0x087a, B:212:0x0884, B:214:0x088a, B:216:0x089a, B:217:0x08ae, B:219:0x08b4, B:220:0x08bd, B:221:0x08ce, B:223:0x090a, B:225:0x0914, B:226:0x0917, B:228:0x0921, B:230:0x093e, B:231:0x0949, B:232:0x0981, B:234:0x0989, B:236:0x0993, B:237:0x09a0, B:239:0x09aa, B:240:0x09b7, B:241:0x09c0, B:243:0x09c6, B:245:0x0a02, B:247:0x0a0c, B:249:0x0a1e, B:256:0x0a24, B:258:0x0a68, B:259:0x0a73, B:260:0x0a7e, B:262:0x0a84, B:266:0x0ad2, B:268:0x0b1d, B:270:0x0b2e, B:271:0x0b90, B:276:0x0b44, B:278:0x0b48, B:281:0x0a94, B:283:0x0abe, B:290:0x0b61, B:291:0x0b78, B:294:0x0b7b, B:308:0x0779, B:309:0x06d7, B:312:0x06e3, B:315:0x06f1, B:318:0x06ff, B:321:0x070d, B:324:0x071b, B:327:0x0727, B:330:0x0734, B:340:0x05d8, B:344:0x0510, B:349:0x0316, B:350:0x031d, B:352:0x0323, B:355:0x0333, B:360:0x0195, B:362:0x019f, B:364:0x01b4, B:369:0x01d4, B:372:0x020a, B:374:0x0210, B:376:0x021e, B:378:0x0232, B:381:0x0239, B:383:0x02c5, B:385:0x02cf, B:386:0x0265, B:388:0x0285, B:389:0x02ac, B:393:0x0299, B:395:0x01e0, B:397:0x01fe), top: B:41:0x0157, inners: #0, #1, #2, #8 }] */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0632 A[Catch: all -> 0x0bc1, TryCatch #3 {all -> 0x0bc1, blocks: (B:42:0x0157, B:45:0x0166, B:47:0x016e, B:51:0x0178, B:58:0x0302, B:61:0x0339, B:63:0x037c, B:65:0x0383, B:66:0x039a, B:71:0x03a7, B:73:0x03bf, B:75:0x03c6, B:76:0x03dd, B:79:0x0401, B:83:0x0424, B:84:0x043b, B:85:0x0444, B:88:0x0463, B:89:0x047c, B:91:0x0484, B:93:0x0490, B:95:0x0496, B:96:0x049d, B:98:0x04aa, B:100:0x04b2, B:102:0x04ba, B:104:0x04c2, B:107:0x04c6, B:110:0x04d2, B:112:0x04df, B:115:0x0504, B:119:0x0528, B:120:0x053d, B:122:0x0569, B:125:0x0580, B:126:0x05bc, B:127:0x05e4, B:129:0x061c, B:130:0x061f, B:132:0x0627, B:133:0x062a, B:135:0x0632, B:136:0x0635, B:138:0x063d, B:139:0x0640, B:141:0x0649, B:142:0x064d, B:144:0x065a, B:145:0x065d, B:147:0x0684, B:149:0x068c, B:150:0x068f, B:152:0x069e, B:154:0x06a8, B:158:0x06bf, B:162:0x06cc, B:165:0x0743, B:167:0x074b, B:168:0x074e, B:170:0x0774, B:172:0x077f, B:175:0x0787, B:176:0x07a1, B:178:0x07a7, B:181:0x07bb, B:184:0x07c7, B:187:0x07d4, B:303:0x07ee, B:190:0x07fe, B:193:0x0807, B:194:0x080a, B:196:0x0817, B:197:0x081c, B:199:0x083a, B:201:0x083e, B:203:0x084e, B:205:0x0859, B:206:0x0864, B:208:0x086e, B:210:0x087a, B:212:0x0884, B:214:0x088a, B:216:0x089a, B:217:0x08ae, B:219:0x08b4, B:220:0x08bd, B:221:0x08ce, B:223:0x090a, B:225:0x0914, B:226:0x0917, B:228:0x0921, B:230:0x093e, B:231:0x0949, B:232:0x0981, B:234:0x0989, B:236:0x0993, B:237:0x09a0, B:239:0x09aa, B:240:0x09b7, B:241:0x09c0, B:243:0x09c6, B:245:0x0a02, B:247:0x0a0c, B:249:0x0a1e, B:256:0x0a24, B:258:0x0a68, B:259:0x0a73, B:260:0x0a7e, B:262:0x0a84, B:266:0x0ad2, B:268:0x0b1d, B:270:0x0b2e, B:271:0x0b90, B:276:0x0b44, B:278:0x0b48, B:281:0x0a94, B:283:0x0abe, B:290:0x0b61, B:291:0x0b78, B:294:0x0b7b, B:308:0x0779, B:309:0x06d7, B:312:0x06e3, B:315:0x06f1, B:318:0x06ff, B:321:0x070d, B:324:0x071b, B:327:0x0727, B:330:0x0734, B:340:0x05d8, B:344:0x0510, B:349:0x0316, B:350:0x031d, B:352:0x0323, B:355:0x0333, B:360:0x0195, B:362:0x019f, B:364:0x01b4, B:369:0x01d4, B:372:0x020a, B:374:0x0210, B:376:0x021e, B:378:0x0232, B:381:0x0239, B:383:0x02c5, B:385:0x02cf, B:386:0x0265, B:388:0x0285, B:389:0x02ac, B:393:0x0299, B:395:0x01e0, B:397:0x01fe), top: B:41:0x0157, inners: #0, #1, #2, #8 }] */
    /* JADX WARN: Removed duplicated region for block: B:138:0x063d A[Catch: all -> 0x0bc1, TryCatch #3 {all -> 0x0bc1, blocks: (B:42:0x0157, B:45:0x0166, B:47:0x016e, B:51:0x0178, B:58:0x0302, B:61:0x0339, B:63:0x037c, B:65:0x0383, B:66:0x039a, B:71:0x03a7, B:73:0x03bf, B:75:0x03c6, B:76:0x03dd, B:79:0x0401, B:83:0x0424, B:84:0x043b, B:85:0x0444, B:88:0x0463, B:89:0x047c, B:91:0x0484, B:93:0x0490, B:95:0x0496, B:96:0x049d, B:98:0x04aa, B:100:0x04b2, B:102:0x04ba, B:104:0x04c2, B:107:0x04c6, B:110:0x04d2, B:112:0x04df, B:115:0x0504, B:119:0x0528, B:120:0x053d, B:122:0x0569, B:125:0x0580, B:126:0x05bc, B:127:0x05e4, B:129:0x061c, B:130:0x061f, B:132:0x0627, B:133:0x062a, B:135:0x0632, B:136:0x0635, B:138:0x063d, B:139:0x0640, B:141:0x0649, B:142:0x064d, B:144:0x065a, B:145:0x065d, B:147:0x0684, B:149:0x068c, B:150:0x068f, B:152:0x069e, B:154:0x06a8, B:158:0x06bf, B:162:0x06cc, B:165:0x0743, B:167:0x074b, B:168:0x074e, B:170:0x0774, B:172:0x077f, B:175:0x0787, B:176:0x07a1, B:178:0x07a7, B:181:0x07bb, B:184:0x07c7, B:187:0x07d4, B:303:0x07ee, B:190:0x07fe, B:193:0x0807, B:194:0x080a, B:196:0x0817, B:197:0x081c, B:199:0x083a, B:201:0x083e, B:203:0x084e, B:205:0x0859, B:206:0x0864, B:208:0x086e, B:210:0x087a, B:212:0x0884, B:214:0x088a, B:216:0x089a, B:217:0x08ae, B:219:0x08b4, B:220:0x08bd, B:221:0x08ce, B:223:0x090a, B:225:0x0914, B:226:0x0917, B:228:0x0921, B:230:0x093e, B:231:0x0949, B:232:0x0981, B:234:0x0989, B:236:0x0993, B:237:0x09a0, B:239:0x09aa, B:240:0x09b7, B:241:0x09c0, B:243:0x09c6, B:245:0x0a02, B:247:0x0a0c, B:249:0x0a1e, B:256:0x0a24, B:258:0x0a68, B:259:0x0a73, B:260:0x0a7e, B:262:0x0a84, B:266:0x0ad2, B:268:0x0b1d, B:270:0x0b2e, B:271:0x0b90, B:276:0x0b44, B:278:0x0b48, B:281:0x0a94, B:283:0x0abe, B:290:0x0b61, B:291:0x0b78, B:294:0x0b7b, B:308:0x0779, B:309:0x06d7, B:312:0x06e3, B:315:0x06f1, B:318:0x06ff, B:321:0x070d, B:324:0x071b, B:327:0x0727, B:330:0x0734, B:340:0x05d8, B:344:0x0510, B:349:0x0316, B:350:0x031d, B:352:0x0323, B:355:0x0333, B:360:0x0195, B:362:0x019f, B:364:0x01b4, B:369:0x01d4, B:372:0x020a, B:374:0x0210, B:376:0x021e, B:378:0x0232, B:381:0x0239, B:383:0x02c5, B:385:0x02cf, B:386:0x0265, B:388:0x0285, B:389:0x02ac, B:393:0x0299, B:395:0x01e0, B:397:0x01fe), top: B:41:0x0157, inners: #0, #1, #2, #8 }] */
    /* JADX WARN: Removed duplicated region for block: B:141:0x0649 A[Catch: all -> 0x0bc1, TryCatch #3 {all -> 0x0bc1, blocks: (B:42:0x0157, B:45:0x0166, B:47:0x016e, B:51:0x0178, B:58:0x0302, B:61:0x0339, B:63:0x037c, B:65:0x0383, B:66:0x039a, B:71:0x03a7, B:73:0x03bf, B:75:0x03c6, B:76:0x03dd, B:79:0x0401, B:83:0x0424, B:84:0x043b, B:85:0x0444, B:88:0x0463, B:89:0x047c, B:91:0x0484, B:93:0x0490, B:95:0x0496, B:96:0x049d, B:98:0x04aa, B:100:0x04b2, B:102:0x04ba, B:104:0x04c2, B:107:0x04c6, B:110:0x04d2, B:112:0x04df, B:115:0x0504, B:119:0x0528, B:120:0x053d, B:122:0x0569, B:125:0x0580, B:126:0x05bc, B:127:0x05e4, B:129:0x061c, B:130:0x061f, B:132:0x0627, B:133:0x062a, B:135:0x0632, B:136:0x0635, B:138:0x063d, B:139:0x0640, B:141:0x0649, B:142:0x064d, B:144:0x065a, B:145:0x065d, B:147:0x0684, B:149:0x068c, B:150:0x068f, B:152:0x069e, B:154:0x06a8, B:158:0x06bf, B:162:0x06cc, B:165:0x0743, B:167:0x074b, B:168:0x074e, B:170:0x0774, B:172:0x077f, B:175:0x0787, B:176:0x07a1, B:178:0x07a7, B:181:0x07bb, B:184:0x07c7, B:187:0x07d4, B:303:0x07ee, B:190:0x07fe, B:193:0x0807, B:194:0x080a, B:196:0x0817, B:197:0x081c, B:199:0x083a, B:201:0x083e, B:203:0x084e, B:205:0x0859, B:206:0x0864, B:208:0x086e, B:210:0x087a, B:212:0x0884, B:214:0x088a, B:216:0x089a, B:217:0x08ae, B:219:0x08b4, B:220:0x08bd, B:221:0x08ce, B:223:0x090a, B:225:0x0914, B:226:0x0917, B:228:0x0921, B:230:0x093e, B:231:0x0949, B:232:0x0981, B:234:0x0989, B:236:0x0993, B:237:0x09a0, B:239:0x09aa, B:240:0x09b7, B:241:0x09c0, B:243:0x09c6, B:245:0x0a02, B:247:0x0a0c, B:249:0x0a1e, B:256:0x0a24, B:258:0x0a68, B:259:0x0a73, B:260:0x0a7e, B:262:0x0a84, B:266:0x0ad2, B:268:0x0b1d, B:270:0x0b2e, B:271:0x0b90, B:276:0x0b44, B:278:0x0b48, B:281:0x0a94, B:283:0x0abe, B:290:0x0b61, B:291:0x0b78, B:294:0x0b7b, B:308:0x0779, B:309:0x06d7, B:312:0x06e3, B:315:0x06f1, B:318:0x06ff, B:321:0x070d, B:324:0x071b, B:327:0x0727, B:330:0x0734, B:340:0x05d8, B:344:0x0510, B:349:0x0316, B:350:0x031d, B:352:0x0323, B:355:0x0333, B:360:0x0195, B:362:0x019f, B:364:0x01b4, B:369:0x01d4, B:372:0x020a, B:374:0x0210, B:376:0x021e, B:378:0x0232, B:381:0x0239, B:383:0x02c5, B:385:0x02cf, B:386:0x0265, B:388:0x0285, B:389:0x02ac, B:393:0x0299, B:395:0x01e0, B:397:0x01fe), top: B:41:0x0157, inners: #0, #1, #2, #8 }] */
    /* JADX WARN: Removed duplicated region for block: B:144:0x065a A[Catch: all -> 0x0bc1, TryCatch #3 {all -> 0x0bc1, blocks: (B:42:0x0157, B:45:0x0166, B:47:0x016e, B:51:0x0178, B:58:0x0302, B:61:0x0339, B:63:0x037c, B:65:0x0383, B:66:0x039a, B:71:0x03a7, B:73:0x03bf, B:75:0x03c6, B:76:0x03dd, B:79:0x0401, B:83:0x0424, B:84:0x043b, B:85:0x0444, B:88:0x0463, B:89:0x047c, B:91:0x0484, B:93:0x0490, B:95:0x0496, B:96:0x049d, B:98:0x04aa, B:100:0x04b2, B:102:0x04ba, B:104:0x04c2, B:107:0x04c6, B:110:0x04d2, B:112:0x04df, B:115:0x0504, B:119:0x0528, B:120:0x053d, B:122:0x0569, B:125:0x0580, B:126:0x05bc, B:127:0x05e4, B:129:0x061c, B:130:0x061f, B:132:0x0627, B:133:0x062a, B:135:0x0632, B:136:0x0635, B:138:0x063d, B:139:0x0640, B:141:0x0649, B:142:0x064d, B:144:0x065a, B:145:0x065d, B:147:0x0684, B:149:0x068c, B:150:0x068f, B:152:0x069e, B:154:0x06a8, B:158:0x06bf, B:162:0x06cc, B:165:0x0743, B:167:0x074b, B:168:0x074e, B:170:0x0774, B:172:0x077f, B:175:0x0787, B:176:0x07a1, B:178:0x07a7, B:181:0x07bb, B:184:0x07c7, B:187:0x07d4, B:303:0x07ee, B:190:0x07fe, B:193:0x0807, B:194:0x080a, B:196:0x0817, B:197:0x081c, B:199:0x083a, B:201:0x083e, B:203:0x084e, B:205:0x0859, B:206:0x0864, B:208:0x086e, B:210:0x087a, B:212:0x0884, B:214:0x088a, B:216:0x089a, B:217:0x08ae, B:219:0x08b4, B:220:0x08bd, B:221:0x08ce, B:223:0x090a, B:225:0x0914, B:226:0x0917, B:228:0x0921, B:230:0x093e, B:231:0x0949, B:232:0x0981, B:234:0x0989, B:236:0x0993, B:237:0x09a0, B:239:0x09aa, B:240:0x09b7, B:241:0x09c0, B:243:0x09c6, B:245:0x0a02, B:247:0x0a0c, B:249:0x0a1e, B:256:0x0a24, B:258:0x0a68, B:259:0x0a73, B:260:0x0a7e, B:262:0x0a84, B:266:0x0ad2, B:268:0x0b1d, B:270:0x0b2e, B:271:0x0b90, B:276:0x0b44, B:278:0x0b48, B:281:0x0a94, B:283:0x0abe, B:290:0x0b61, B:291:0x0b78, B:294:0x0b7b, B:308:0x0779, B:309:0x06d7, B:312:0x06e3, B:315:0x06f1, B:318:0x06ff, B:321:0x070d, B:324:0x071b, B:327:0x0727, B:330:0x0734, B:340:0x05d8, B:344:0x0510, B:349:0x0316, B:350:0x031d, B:352:0x0323, B:355:0x0333, B:360:0x0195, B:362:0x019f, B:364:0x01b4, B:369:0x01d4, B:372:0x020a, B:374:0x0210, B:376:0x021e, B:378:0x0232, B:381:0x0239, B:383:0x02c5, B:385:0x02cf, B:386:0x0265, B:388:0x0285, B:389:0x02ac, B:393:0x0299, B:395:0x01e0, B:397:0x01fe), top: B:41:0x0157, inners: #0, #1, #2, #8 }] */
    /* JADX WARN: Removed duplicated region for block: B:147:0x0684 A[Catch: all -> 0x0bc1, TryCatch #3 {all -> 0x0bc1, blocks: (B:42:0x0157, B:45:0x0166, B:47:0x016e, B:51:0x0178, B:58:0x0302, B:61:0x0339, B:63:0x037c, B:65:0x0383, B:66:0x039a, B:71:0x03a7, B:73:0x03bf, B:75:0x03c6, B:76:0x03dd, B:79:0x0401, B:83:0x0424, B:84:0x043b, B:85:0x0444, B:88:0x0463, B:89:0x047c, B:91:0x0484, B:93:0x0490, B:95:0x0496, B:96:0x049d, B:98:0x04aa, B:100:0x04b2, B:102:0x04ba, B:104:0x04c2, B:107:0x04c6, B:110:0x04d2, B:112:0x04df, B:115:0x0504, B:119:0x0528, B:120:0x053d, B:122:0x0569, B:125:0x0580, B:126:0x05bc, B:127:0x05e4, B:129:0x061c, B:130:0x061f, B:132:0x0627, B:133:0x062a, B:135:0x0632, B:136:0x0635, B:138:0x063d, B:139:0x0640, B:141:0x0649, B:142:0x064d, B:144:0x065a, B:145:0x065d, B:147:0x0684, B:149:0x068c, B:150:0x068f, B:152:0x069e, B:154:0x06a8, B:158:0x06bf, B:162:0x06cc, B:165:0x0743, B:167:0x074b, B:168:0x074e, B:170:0x0774, B:172:0x077f, B:175:0x0787, B:176:0x07a1, B:178:0x07a7, B:181:0x07bb, B:184:0x07c7, B:187:0x07d4, B:303:0x07ee, B:190:0x07fe, B:193:0x0807, B:194:0x080a, B:196:0x0817, B:197:0x081c, B:199:0x083a, B:201:0x083e, B:203:0x084e, B:205:0x0859, B:206:0x0864, B:208:0x086e, B:210:0x087a, B:212:0x0884, B:214:0x088a, B:216:0x089a, B:217:0x08ae, B:219:0x08b4, B:220:0x08bd, B:221:0x08ce, B:223:0x090a, B:225:0x0914, B:226:0x0917, B:228:0x0921, B:230:0x093e, B:231:0x0949, B:232:0x0981, B:234:0x0989, B:236:0x0993, B:237:0x09a0, B:239:0x09aa, B:240:0x09b7, B:241:0x09c0, B:243:0x09c6, B:245:0x0a02, B:247:0x0a0c, B:249:0x0a1e, B:256:0x0a24, B:258:0x0a68, B:259:0x0a73, B:260:0x0a7e, B:262:0x0a84, B:266:0x0ad2, B:268:0x0b1d, B:270:0x0b2e, B:271:0x0b90, B:276:0x0b44, B:278:0x0b48, B:281:0x0a94, B:283:0x0abe, B:290:0x0b61, B:291:0x0b78, B:294:0x0b7b, B:308:0x0779, B:309:0x06d7, B:312:0x06e3, B:315:0x06f1, B:318:0x06ff, B:321:0x070d, B:324:0x071b, B:327:0x0727, B:330:0x0734, B:340:0x05d8, B:344:0x0510, B:349:0x0316, B:350:0x031d, B:352:0x0323, B:355:0x0333, B:360:0x0195, B:362:0x019f, B:364:0x01b4, B:369:0x01d4, B:372:0x020a, B:374:0x0210, B:376:0x021e, B:378:0x0232, B:381:0x0239, B:383:0x02c5, B:385:0x02cf, B:386:0x0265, B:388:0x0285, B:389:0x02ac, B:393:0x0299, B:395:0x01e0, B:397:0x01fe), top: B:41:0x0157, inners: #0, #1, #2, #8 }] */
    /* JADX WARN: Removed duplicated region for block: B:167:0x074b A[Catch: all -> 0x0bc1, TryCatch #3 {all -> 0x0bc1, blocks: (B:42:0x0157, B:45:0x0166, B:47:0x016e, B:51:0x0178, B:58:0x0302, B:61:0x0339, B:63:0x037c, B:65:0x0383, B:66:0x039a, B:71:0x03a7, B:73:0x03bf, B:75:0x03c6, B:76:0x03dd, B:79:0x0401, B:83:0x0424, B:84:0x043b, B:85:0x0444, B:88:0x0463, B:89:0x047c, B:91:0x0484, B:93:0x0490, B:95:0x0496, B:96:0x049d, B:98:0x04aa, B:100:0x04b2, B:102:0x04ba, B:104:0x04c2, B:107:0x04c6, B:110:0x04d2, B:112:0x04df, B:115:0x0504, B:119:0x0528, B:120:0x053d, B:122:0x0569, B:125:0x0580, B:126:0x05bc, B:127:0x05e4, B:129:0x061c, B:130:0x061f, B:132:0x0627, B:133:0x062a, B:135:0x0632, B:136:0x0635, B:138:0x063d, B:139:0x0640, B:141:0x0649, B:142:0x064d, B:144:0x065a, B:145:0x065d, B:147:0x0684, B:149:0x068c, B:150:0x068f, B:152:0x069e, B:154:0x06a8, B:158:0x06bf, B:162:0x06cc, B:165:0x0743, B:167:0x074b, B:168:0x074e, B:170:0x0774, B:172:0x077f, B:175:0x0787, B:176:0x07a1, B:178:0x07a7, B:181:0x07bb, B:184:0x07c7, B:187:0x07d4, B:303:0x07ee, B:190:0x07fe, B:193:0x0807, B:194:0x080a, B:196:0x0817, B:197:0x081c, B:199:0x083a, B:201:0x083e, B:203:0x084e, B:205:0x0859, B:206:0x0864, B:208:0x086e, B:210:0x087a, B:212:0x0884, B:214:0x088a, B:216:0x089a, B:217:0x08ae, B:219:0x08b4, B:220:0x08bd, B:221:0x08ce, B:223:0x090a, B:225:0x0914, B:226:0x0917, B:228:0x0921, B:230:0x093e, B:231:0x0949, B:232:0x0981, B:234:0x0989, B:236:0x0993, B:237:0x09a0, B:239:0x09aa, B:240:0x09b7, B:241:0x09c0, B:243:0x09c6, B:245:0x0a02, B:247:0x0a0c, B:249:0x0a1e, B:256:0x0a24, B:258:0x0a68, B:259:0x0a73, B:260:0x0a7e, B:262:0x0a84, B:266:0x0ad2, B:268:0x0b1d, B:270:0x0b2e, B:271:0x0b90, B:276:0x0b44, B:278:0x0b48, B:281:0x0a94, B:283:0x0abe, B:290:0x0b61, B:291:0x0b78, B:294:0x0b7b, B:308:0x0779, B:309:0x06d7, B:312:0x06e3, B:315:0x06f1, B:318:0x06ff, B:321:0x070d, B:324:0x071b, B:327:0x0727, B:330:0x0734, B:340:0x05d8, B:344:0x0510, B:349:0x0316, B:350:0x031d, B:352:0x0323, B:355:0x0333, B:360:0x0195, B:362:0x019f, B:364:0x01b4, B:369:0x01d4, B:372:0x020a, B:374:0x0210, B:376:0x021e, B:378:0x0232, B:381:0x0239, B:383:0x02c5, B:385:0x02cf, B:386:0x0265, B:388:0x0285, B:389:0x02ac, B:393:0x0299, B:395:0x01e0, B:397:0x01fe), top: B:41:0x0157, inners: #0, #1, #2, #8 }] */
    /* JADX WARN: Removed duplicated region for block: B:170:0x0774 A[Catch: all -> 0x0bc1, TryCatch #3 {all -> 0x0bc1, blocks: (B:42:0x0157, B:45:0x0166, B:47:0x016e, B:51:0x0178, B:58:0x0302, B:61:0x0339, B:63:0x037c, B:65:0x0383, B:66:0x039a, B:71:0x03a7, B:73:0x03bf, B:75:0x03c6, B:76:0x03dd, B:79:0x0401, B:83:0x0424, B:84:0x043b, B:85:0x0444, B:88:0x0463, B:89:0x047c, B:91:0x0484, B:93:0x0490, B:95:0x0496, B:96:0x049d, B:98:0x04aa, B:100:0x04b2, B:102:0x04ba, B:104:0x04c2, B:107:0x04c6, B:110:0x04d2, B:112:0x04df, B:115:0x0504, B:119:0x0528, B:120:0x053d, B:122:0x0569, B:125:0x0580, B:126:0x05bc, B:127:0x05e4, B:129:0x061c, B:130:0x061f, B:132:0x0627, B:133:0x062a, B:135:0x0632, B:136:0x0635, B:138:0x063d, B:139:0x0640, B:141:0x0649, B:142:0x064d, B:144:0x065a, B:145:0x065d, B:147:0x0684, B:149:0x068c, B:150:0x068f, B:152:0x069e, B:154:0x06a8, B:158:0x06bf, B:162:0x06cc, B:165:0x0743, B:167:0x074b, B:168:0x074e, B:170:0x0774, B:172:0x077f, B:175:0x0787, B:176:0x07a1, B:178:0x07a7, B:181:0x07bb, B:184:0x07c7, B:187:0x07d4, B:303:0x07ee, B:190:0x07fe, B:193:0x0807, B:194:0x080a, B:196:0x0817, B:197:0x081c, B:199:0x083a, B:201:0x083e, B:203:0x084e, B:205:0x0859, B:206:0x0864, B:208:0x086e, B:210:0x087a, B:212:0x0884, B:214:0x088a, B:216:0x089a, B:217:0x08ae, B:219:0x08b4, B:220:0x08bd, B:221:0x08ce, B:223:0x090a, B:225:0x0914, B:226:0x0917, B:228:0x0921, B:230:0x093e, B:231:0x0949, B:232:0x0981, B:234:0x0989, B:236:0x0993, B:237:0x09a0, B:239:0x09aa, B:240:0x09b7, B:241:0x09c0, B:243:0x09c6, B:245:0x0a02, B:247:0x0a0c, B:249:0x0a1e, B:256:0x0a24, B:258:0x0a68, B:259:0x0a73, B:260:0x0a7e, B:262:0x0a84, B:266:0x0ad2, B:268:0x0b1d, B:270:0x0b2e, B:271:0x0b90, B:276:0x0b44, B:278:0x0b48, B:281:0x0a94, B:283:0x0abe, B:290:0x0b61, B:291:0x0b78, B:294:0x0b7b, B:308:0x0779, B:309:0x06d7, B:312:0x06e3, B:315:0x06f1, B:318:0x06ff, B:321:0x070d, B:324:0x071b, B:327:0x0727, B:330:0x0734, B:340:0x05d8, B:344:0x0510, B:349:0x0316, B:350:0x031d, B:352:0x0323, B:355:0x0333, B:360:0x0195, B:362:0x019f, B:364:0x01b4, B:369:0x01d4, B:372:0x020a, B:374:0x0210, B:376:0x021e, B:378:0x0232, B:381:0x0239, B:383:0x02c5, B:385:0x02cf, B:386:0x0265, B:388:0x0285, B:389:0x02ac, B:393:0x0299, B:395:0x01e0, B:397:0x01fe), top: B:41:0x0157, inners: #0, #1, #2, #8 }] */
    /* JADX WARN: Removed duplicated region for block: B:178:0x07a7 A[Catch: all -> 0x0bc1, TRY_LEAVE, TryCatch #3 {all -> 0x0bc1, blocks: (B:42:0x0157, B:45:0x0166, B:47:0x016e, B:51:0x0178, B:58:0x0302, B:61:0x0339, B:63:0x037c, B:65:0x0383, B:66:0x039a, B:71:0x03a7, B:73:0x03bf, B:75:0x03c6, B:76:0x03dd, B:79:0x0401, B:83:0x0424, B:84:0x043b, B:85:0x0444, B:88:0x0463, B:89:0x047c, B:91:0x0484, B:93:0x0490, B:95:0x0496, B:96:0x049d, B:98:0x04aa, B:100:0x04b2, B:102:0x04ba, B:104:0x04c2, B:107:0x04c6, B:110:0x04d2, B:112:0x04df, B:115:0x0504, B:119:0x0528, B:120:0x053d, B:122:0x0569, B:125:0x0580, B:126:0x05bc, B:127:0x05e4, B:129:0x061c, B:130:0x061f, B:132:0x0627, B:133:0x062a, B:135:0x0632, B:136:0x0635, B:138:0x063d, B:139:0x0640, B:141:0x0649, B:142:0x064d, B:144:0x065a, B:145:0x065d, B:147:0x0684, B:149:0x068c, B:150:0x068f, B:152:0x069e, B:154:0x06a8, B:158:0x06bf, B:162:0x06cc, B:165:0x0743, B:167:0x074b, B:168:0x074e, B:170:0x0774, B:172:0x077f, B:175:0x0787, B:176:0x07a1, B:178:0x07a7, B:181:0x07bb, B:184:0x07c7, B:187:0x07d4, B:303:0x07ee, B:190:0x07fe, B:193:0x0807, B:194:0x080a, B:196:0x0817, B:197:0x081c, B:199:0x083a, B:201:0x083e, B:203:0x084e, B:205:0x0859, B:206:0x0864, B:208:0x086e, B:210:0x087a, B:212:0x0884, B:214:0x088a, B:216:0x089a, B:217:0x08ae, B:219:0x08b4, B:220:0x08bd, B:221:0x08ce, B:223:0x090a, B:225:0x0914, B:226:0x0917, B:228:0x0921, B:230:0x093e, B:231:0x0949, B:232:0x0981, B:234:0x0989, B:236:0x0993, B:237:0x09a0, B:239:0x09aa, B:240:0x09b7, B:241:0x09c0, B:243:0x09c6, B:245:0x0a02, B:247:0x0a0c, B:249:0x0a1e, B:256:0x0a24, B:258:0x0a68, B:259:0x0a73, B:260:0x0a7e, B:262:0x0a84, B:266:0x0ad2, B:268:0x0b1d, B:270:0x0b2e, B:271:0x0b90, B:276:0x0b44, B:278:0x0b48, B:281:0x0a94, B:283:0x0abe, B:290:0x0b61, B:291:0x0b78, B:294:0x0b7b, B:308:0x0779, B:309:0x06d7, B:312:0x06e3, B:315:0x06f1, B:318:0x06ff, B:321:0x070d, B:324:0x071b, B:327:0x0727, B:330:0x0734, B:340:0x05d8, B:344:0x0510, B:349:0x0316, B:350:0x031d, B:352:0x0323, B:355:0x0333, B:360:0x0195, B:362:0x019f, B:364:0x01b4, B:369:0x01d4, B:372:0x020a, B:374:0x0210, B:376:0x021e, B:378:0x0232, B:381:0x0239, B:383:0x02c5, B:385:0x02cf, B:386:0x0265, B:388:0x0285, B:389:0x02ac, B:393:0x0299, B:395:0x01e0, B:397:0x01fe), top: B:41:0x0157, inners: #0, #1, #2, #8 }] */
    /* JADX WARN: Removed duplicated region for block: B:193:0x0807 A[Catch: all -> 0x0bc1, TryCatch #3 {all -> 0x0bc1, blocks: (B:42:0x0157, B:45:0x0166, B:47:0x016e, B:51:0x0178, B:58:0x0302, B:61:0x0339, B:63:0x037c, B:65:0x0383, B:66:0x039a, B:71:0x03a7, B:73:0x03bf, B:75:0x03c6, B:76:0x03dd, B:79:0x0401, B:83:0x0424, B:84:0x043b, B:85:0x0444, B:88:0x0463, B:89:0x047c, B:91:0x0484, B:93:0x0490, B:95:0x0496, B:96:0x049d, B:98:0x04aa, B:100:0x04b2, B:102:0x04ba, B:104:0x04c2, B:107:0x04c6, B:110:0x04d2, B:112:0x04df, B:115:0x0504, B:119:0x0528, B:120:0x053d, B:122:0x0569, B:125:0x0580, B:126:0x05bc, B:127:0x05e4, B:129:0x061c, B:130:0x061f, B:132:0x0627, B:133:0x062a, B:135:0x0632, B:136:0x0635, B:138:0x063d, B:139:0x0640, B:141:0x0649, B:142:0x064d, B:144:0x065a, B:145:0x065d, B:147:0x0684, B:149:0x068c, B:150:0x068f, B:152:0x069e, B:154:0x06a8, B:158:0x06bf, B:162:0x06cc, B:165:0x0743, B:167:0x074b, B:168:0x074e, B:170:0x0774, B:172:0x077f, B:175:0x0787, B:176:0x07a1, B:178:0x07a7, B:181:0x07bb, B:184:0x07c7, B:187:0x07d4, B:303:0x07ee, B:190:0x07fe, B:193:0x0807, B:194:0x080a, B:196:0x0817, B:197:0x081c, B:199:0x083a, B:201:0x083e, B:203:0x084e, B:205:0x0859, B:206:0x0864, B:208:0x086e, B:210:0x087a, B:212:0x0884, B:214:0x088a, B:216:0x089a, B:217:0x08ae, B:219:0x08b4, B:220:0x08bd, B:221:0x08ce, B:223:0x090a, B:225:0x0914, B:226:0x0917, B:228:0x0921, B:230:0x093e, B:231:0x0949, B:232:0x0981, B:234:0x0989, B:236:0x0993, B:237:0x09a0, B:239:0x09aa, B:240:0x09b7, B:241:0x09c0, B:243:0x09c6, B:245:0x0a02, B:247:0x0a0c, B:249:0x0a1e, B:256:0x0a24, B:258:0x0a68, B:259:0x0a73, B:260:0x0a7e, B:262:0x0a84, B:266:0x0ad2, B:268:0x0b1d, B:270:0x0b2e, B:271:0x0b90, B:276:0x0b44, B:278:0x0b48, B:281:0x0a94, B:283:0x0abe, B:290:0x0b61, B:291:0x0b78, B:294:0x0b7b, B:308:0x0779, B:309:0x06d7, B:312:0x06e3, B:315:0x06f1, B:318:0x06ff, B:321:0x070d, B:324:0x071b, B:327:0x0727, B:330:0x0734, B:340:0x05d8, B:344:0x0510, B:349:0x0316, B:350:0x031d, B:352:0x0323, B:355:0x0333, B:360:0x0195, B:362:0x019f, B:364:0x01b4, B:369:0x01d4, B:372:0x020a, B:374:0x0210, B:376:0x021e, B:378:0x0232, B:381:0x0239, B:383:0x02c5, B:385:0x02cf, B:386:0x0265, B:388:0x0285, B:389:0x02ac, B:393:0x0299, B:395:0x01e0, B:397:0x01fe), top: B:41:0x0157, inners: #0, #1, #2, #8 }] */
    /* JADX WARN: Removed duplicated region for block: B:196:0x0817 A[Catch: all -> 0x0bc1, TryCatch #3 {all -> 0x0bc1, blocks: (B:42:0x0157, B:45:0x0166, B:47:0x016e, B:51:0x0178, B:58:0x0302, B:61:0x0339, B:63:0x037c, B:65:0x0383, B:66:0x039a, B:71:0x03a7, B:73:0x03bf, B:75:0x03c6, B:76:0x03dd, B:79:0x0401, B:83:0x0424, B:84:0x043b, B:85:0x0444, B:88:0x0463, B:89:0x047c, B:91:0x0484, B:93:0x0490, B:95:0x0496, B:96:0x049d, B:98:0x04aa, B:100:0x04b2, B:102:0x04ba, B:104:0x04c2, B:107:0x04c6, B:110:0x04d2, B:112:0x04df, B:115:0x0504, B:119:0x0528, B:120:0x053d, B:122:0x0569, B:125:0x0580, B:126:0x05bc, B:127:0x05e4, B:129:0x061c, B:130:0x061f, B:132:0x0627, B:133:0x062a, B:135:0x0632, B:136:0x0635, B:138:0x063d, B:139:0x0640, B:141:0x0649, B:142:0x064d, B:144:0x065a, B:145:0x065d, B:147:0x0684, B:149:0x068c, B:150:0x068f, B:152:0x069e, B:154:0x06a8, B:158:0x06bf, B:162:0x06cc, B:165:0x0743, B:167:0x074b, B:168:0x074e, B:170:0x0774, B:172:0x077f, B:175:0x0787, B:176:0x07a1, B:178:0x07a7, B:181:0x07bb, B:184:0x07c7, B:187:0x07d4, B:303:0x07ee, B:190:0x07fe, B:193:0x0807, B:194:0x080a, B:196:0x0817, B:197:0x081c, B:199:0x083a, B:201:0x083e, B:203:0x084e, B:205:0x0859, B:206:0x0864, B:208:0x086e, B:210:0x087a, B:212:0x0884, B:214:0x088a, B:216:0x089a, B:217:0x08ae, B:219:0x08b4, B:220:0x08bd, B:221:0x08ce, B:223:0x090a, B:225:0x0914, B:226:0x0917, B:228:0x0921, B:230:0x093e, B:231:0x0949, B:232:0x0981, B:234:0x0989, B:236:0x0993, B:237:0x09a0, B:239:0x09aa, B:240:0x09b7, B:241:0x09c0, B:243:0x09c6, B:245:0x0a02, B:247:0x0a0c, B:249:0x0a1e, B:256:0x0a24, B:258:0x0a68, B:259:0x0a73, B:260:0x0a7e, B:262:0x0a84, B:266:0x0ad2, B:268:0x0b1d, B:270:0x0b2e, B:271:0x0b90, B:276:0x0b44, B:278:0x0b48, B:281:0x0a94, B:283:0x0abe, B:290:0x0b61, B:291:0x0b78, B:294:0x0b7b, B:308:0x0779, B:309:0x06d7, B:312:0x06e3, B:315:0x06f1, B:318:0x06ff, B:321:0x070d, B:324:0x071b, B:327:0x0727, B:330:0x0734, B:340:0x05d8, B:344:0x0510, B:349:0x0316, B:350:0x031d, B:352:0x0323, B:355:0x0333, B:360:0x0195, B:362:0x019f, B:364:0x01b4, B:369:0x01d4, B:372:0x020a, B:374:0x0210, B:376:0x021e, B:378:0x0232, B:381:0x0239, B:383:0x02c5, B:385:0x02cf, B:386:0x0265, B:388:0x0285, B:389:0x02ac, B:393:0x0299, B:395:0x01e0, B:397:0x01fe), top: B:41:0x0157, inners: #0, #1, #2, #8 }] */
    /* JADX WARN: Removed duplicated region for block: B:203:0x084e A[Catch: all -> 0x0bc1, TryCatch #3 {all -> 0x0bc1, blocks: (B:42:0x0157, B:45:0x0166, B:47:0x016e, B:51:0x0178, B:58:0x0302, B:61:0x0339, B:63:0x037c, B:65:0x0383, B:66:0x039a, B:71:0x03a7, B:73:0x03bf, B:75:0x03c6, B:76:0x03dd, B:79:0x0401, B:83:0x0424, B:84:0x043b, B:85:0x0444, B:88:0x0463, B:89:0x047c, B:91:0x0484, B:93:0x0490, B:95:0x0496, B:96:0x049d, B:98:0x04aa, B:100:0x04b2, B:102:0x04ba, B:104:0x04c2, B:107:0x04c6, B:110:0x04d2, B:112:0x04df, B:115:0x0504, B:119:0x0528, B:120:0x053d, B:122:0x0569, B:125:0x0580, B:126:0x05bc, B:127:0x05e4, B:129:0x061c, B:130:0x061f, B:132:0x0627, B:133:0x062a, B:135:0x0632, B:136:0x0635, B:138:0x063d, B:139:0x0640, B:141:0x0649, B:142:0x064d, B:144:0x065a, B:145:0x065d, B:147:0x0684, B:149:0x068c, B:150:0x068f, B:152:0x069e, B:154:0x06a8, B:158:0x06bf, B:162:0x06cc, B:165:0x0743, B:167:0x074b, B:168:0x074e, B:170:0x0774, B:172:0x077f, B:175:0x0787, B:176:0x07a1, B:178:0x07a7, B:181:0x07bb, B:184:0x07c7, B:187:0x07d4, B:303:0x07ee, B:190:0x07fe, B:193:0x0807, B:194:0x080a, B:196:0x0817, B:197:0x081c, B:199:0x083a, B:201:0x083e, B:203:0x084e, B:205:0x0859, B:206:0x0864, B:208:0x086e, B:210:0x087a, B:212:0x0884, B:214:0x088a, B:216:0x089a, B:217:0x08ae, B:219:0x08b4, B:220:0x08bd, B:221:0x08ce, B:223:0x090a, B:225:0x0914, B:226:0x0917, B:228:0x0921, B:230:0x093e, B:231:0x0949, B:232:0x0981, B:234:0x0989, B:236:0x0993, B:237:0x09a0, B:239:0x09aa, B:240:0x09b7, B:241:0x09c0, B:243:0x09c6, B:245:0x0a02, B:247:0x0a0c, B:249:0x0a1e, B:256:0x0a24, B:258:0x0a68, B:259:0x0a73, B:260:0x0a7e, B:262:0x0a84, B:266:0x0ad2, B:268:0x0b1d, B:270:0x0b2e, B:271:0x0b90, B:276:0x0b44, B:278:0x0b48, B:281:0x0a94, B:283:0x0abe, B:290:0x0b61, B:291:0x0b78, B:294:0x0b7b, B:308:0x0779, B:309:0x06d7, B:312:0x06e3, B:315:0x06f1, B:318:0x06ff, B:321:0x070d, B:324:0x071b, B:327:0x0727, B:330:0x0734, B:340:0x05d8, B:344:0x0510, B:349:0x0316, B:350:0x031d, B:352:0x0323, B:355:0x0333, B:360:0x0195, B:362:0x019f, B:364:0x01b4, B:369:0x01d4, B:372:0x020a, B:374:0x0210, B:376:0x021e, B:378:0x0232, B:381:0x0239, B:383:0x02c5, B:385:0x02cf, B:386:0x0265, B:388:0x0285, B:389:0x02ac, B:393:0x0299, B:395:0x01e0, B:397:0x01fe), top: B:41:0x0157, inners: #0, #1, #2, #8 }] */
    /* JADX WARN: Removed duplicated region for block: B:223:0x090a A[Catch: all -> 0x0bc1, TryCatch #3 {all -> 0x0bc1, blocks: (B:42:0x0157, B:45:0x0166, B:47:0x016e, B:51:0x0178, B:58:0x0302, B:61:0x0339, B:63:0x037c, B:65:0x0383, B:66:0x039a, B:71:0x03a7, B:73:0x03bf, B:75:0x03c6, B:76:0x03dd, B:79:0x0401, B:83:0x0424, B:84:0x043b, B:85:0x0444, B:88:0x0463, B:89:0x047c, B:91:0x0484, B:93:0x0490, B:95:0x0496, B:96:0x049d, B:98:0x04aa, B:100:0x04b2, B:102:0x04ba, B:104:0x04c2, B:107:0x04c6, B:110:0x04d2, B:112:0x04df, B:115:0x0504, B:119:0x0528, B:120:0x053d, B:122:0x0569, B:125:0x0580, B:126:0x05bc, B:127:0x05e4, B:129:0x061c, B:130:0x061f, B:132:0x0627, B:133:0x062a, B:135:0x0632, B:136:0x0635, B:138:0x063d, B:139:0x0640, B:141:0x0649, B:142:0x064d, B:144:0x065a, B:145:0x065d, B:147:0x0684, B:149:0x068c, B:150:0x068f, B:152:0x069e, B:154:0x06a8, B:158:0x06bf, B:162:0x06cc, B:165:0x0743, B:167:0x074b, B:168:0x074e, B:170:0x0774, B:172:0x077f, B:175:0x0787, B:176:0x07a1, B:178:0x07a7, B:181:0x07bb, B:184:0x07c7, B:187:0x07d4, B:303:0x07ee, B:190:0x07fe, B:193:0x0807, B:194:0x080a, B:196:0x0817, B:197:0x081c, B:199:0x083a, B:201:0x083e, B:203:0x084e, B:205:0x0859, B:206:0x0864, B:208:0x086e, B:210:0x087a, B:212:0x0884, B:214:0x088a, B:216:0x089a, B:217:0x08ae, B:219:0x08b4, B:220:0x08bd, B:221:0x08ce, B:223:0x090a, B:225:0x0914, B:226:0x0917, B:228:0x0921, B:230:0x093e, B:231:0x0949, B:232:0x0981, B:234:0x0989, B:236:0x0993, B:237:0x09a0, B:239:0x09aa, B:240:0x09b7, B:241:0x09c0, B:243:0x09c6, B:245:0x0a02, B:247:0x0a0c, B:249:0x0a1e, B:256:0x0a24, B:258:0x0a68, B:259:0x0a73, B:260:0x0a7e, B:262:0x0a84, B:266:0x0ad2, B:268:0x0b1d, B:270:0x0b2e, B:271:0x0b90, B:276:0x0b44, B:278:0x0b48, B:281:0x0a94, B:283:0x0abe, B:290:0x0b61, B:291:0x0b78, B:294:0x0b7b, B:308:0x0779, B:309:0x06d7, B:312:0x06e3, B:315:0x06f1, B:318:0x06ff, B:321:0x070d, B:324:0x071b, B:327:0x0727, B:330:0x0734, B:340:0x05d8, B:344:0x0510, B:349:0x0316, B:350:0x031d, B:352:0x0323, B:355:0x0333, B:360:0x0195, B:362:0x019f, B:364:0x01b4, B:369:0x01d4, B:372:0x020a, B:374:0x0210, B:376:0x021e, B:378:0x0232, B:381:0x0239, B:383:0x02c5, B:385:0x02cf, B:386:0x0265, B:388:0x0285, B:389:0x02ac, B:393:0x0299, B:395:0x01e0, B:397:0x01fe), top: B:41:0x0157, inners: #0, #1, #2, #8 }] */
    /* JADX WARN: Removed duplicated region for block: B:228:0x0921 A[Catch: all -> 0x0bc1, TryCatch #3 {all -> 0x0bc1, blocks: (B:42:0x0157, B:45:0x0166, B:47:0x016e, B:51:0x0178, B:58:0x0302, B:61:0x0339, B:63:0x037c, B:65:0x0383, B:66:0x039a, B:71:0x03a7, B:73:0x03bf, B:75:0x03c6, B:76:0x03dd, B:79:0x0401, B:83:0x0424, B:84:0x043b, B:85:0x0444, B:88:0x0463, B:89:0x047c, B:91:0x0484, B:93:0x0490, B:95:0x0496, B:96:0x049d, B:98:0x04aa, B:100:0x04b2, B:102:0x04ba, B:104:0x04c2, B:107:0x04c6, B:110:0x04d2, B:112:0x04df, B:115:0x0504, B:119:0x0528, B:120:0x053d, B:122:0x0569, B:125:0x0580, B:126:0x05bc, B:127:0x05e4, B:129:0x061c, B:130:0x061f, B:132:0x0627, B:133:0x062a, B:135:0x0632, B:136:0x0635, B:138:0x063d, B:139:0x0640, B:141:0x0649, B:142:0x064d, B:144:0x065a, B:145:0x065d, B:147:0x0684, B:149:0x068c, B:150:0x068f, B:152:0x069e, B:154:0x06a8, B:158:0x06bf, B:162:0x06cc, B:165:0x0743, B:167:0x074b, B:168:0x074e, B:170:0x0774, B:172:0x077f, B:175:0x0787, B:176:0x07a1, B:178:0x07a7, B:181:0x07bb, B:184:0x07c7, B:187:0x07d4, B:303:0x07ee, B:190:0x07fe, B:193:0x0807, B:194:0x080a, B:196:0x0817, B:197:0x081c, B:199:0x083a, B:201:0x083e, B:203:0x084e, B:205:0x0859, B:206:0x0864, B:208:0x086e, B:210:0x087a, B:212:0x0884, B:214:0x088a, B:216:0x089a, B:217:0x08ae, B:219:0x08b4, B:220:0x08bd, B:221:0x08ce, B:223:0x090a, B:225:0x0914, B:226:0x0917, B:228:0x0921, B:230:0x093e, B:231:0x0949, B:232:0x0981, B:234:0x0989, B:236:0x0993, B:237:0x09a0, B:239:0x09aa, B:240:0x09b7, B:241:0x09c0, B:243:0x09c6, B:245:0x0a02, B:247:0x0a0c, B:249:0x0a1e, B:256:0x0a24, B:258:0x0a68, B:259:0x0a73, B:260:0x0a7e, B:262:0x0a84, B:266:0x0ad2, B:268:0x0b1d, B:270:0x0b2e, B:271:0x0b90, B:276:0x0b44, B:278:0x0b48, B:281:0x0a94, B:283:0x0abe, B:290:0x0b61, B:291:0x0b78, B:294:0x0b7b, B:308:0x0779, B:309:0x06d7, B:312:0x06e3, B:315:0x06f1, B:318:0x06ff, B:321:0x070d, B:324:0x071b, B:327:0x0727, B:330:0x0734, B:340:0x05d8, B:344:0x0510, B:349:0x0316, B:350:0x031d, B:352:0x0323, B:355:0x0333, B:360:0x0195, B:362:0x019f, B:364:0x01b4, B:369:0x01d4, B:372:0x020a, B:374:0x0210, B:376:0x021e, B:378:0x0232, B:381:0x0239, B:383:0x02c5, B:385:0x02cf, B:386:0x0265, B:388:0x0285, B:389:0x02ac, B:393:0x0299, B:395:0x01e0, B:397:0x01fe), top: B:41:0x0157, inners: #0, #1, #2, #8 }] */
    /* JADX WARN: Removed duplicated region for block: B:234:0x0989 A[Catch: all -> 0x0bc1, TryCatch #3 {all -> 0x0bc1, blocks: (B:42:0x0157, B:45:0x0166, B:47:0x016e, B:51:0x0178, B:58:0x0302, B:61:0x0339, B:63:0x037c, B:65:0x0383, B:66:0x039a, B:71:0x03a7, B:73:0x03bf, B:75:0x03c6, B:76:0x03dd, B:79:0x0401, B:83:0x0424, B:84:0x043b, B:85:0x0444, B:88:0x0463, B:89:0x047c, B:91:0x0484, B:93:0x0490, B:95:0x0496, B:96:0x049d, B:98:0x04aa, B:100:0x04b2, B:102:0x04ba, B:104:0x04c2, B:107:0x04c6, B:110:0x04d2, B:112:0x04df, B:115:0x0504, B:119:0x0528, B:120:0x053d, B:122:0x0569, B:125:0x0580, B:126:0x05bc, B:127:0x05e4, B:129:0x061c, B:130:0x061f, B:132:0x0627, B:133:0x062a, B:135:0x0632, B:136:0x0635, B:138:0x063d, B:139:0x0640, B:141:0x0649, B:142:0x064d, B:144:0x065a, B:145:0x065d, B:147:0x0684, B:149:0x068c, B:150:0x068f, B:152:0x069e, B:154:0x06a8, B:158:0x06bf, B:162:0x06cc, B:165:0x0743, B:167:0x074b, B:168:0x074e, B:170:0x0774, B:172:0x077f, B:175:0x0787, B:176:0x07a1, B:178:0x07a7, B:181:0x07bb, B:184:0x07c7, B:187:0x07d4, B:303:0x07ee, B:190:0x07fe, B:193:0x0807, B:194:0x080a, B:196:0x0817, B:197:0x081c, B:199:0x083a, B:201:0x083e, B:203:0x084e, B:205:0x0859, B:206:0x0864, B:208:0x086e, B:210:0x087a, B:212:0x0884, B:214:0x088a, B:216:0x089a, B:217:0x08ae, B:219:0x08b4, B:220:0x08bd, B:221:0x08ce, B:223:0x090a, B:225:0x0914, B:226:0x0917, B:228:0x0921, B:230:0x093e, B:231:0x0949, B:232:0x0981, B:234:0x0989, B:236:0x0993, B:237:0x09a0, B:239:0x09aa, B:240:0x09b7, B:241:0x09c0, B:243:0x09c6, B:245:0x0a02, B:247:0x0a0c, B:249:0x0a1e, B:256:0x0a24, B:258:0x0a68, B:259:0x0a73, B:260:0x0a7e, B:262:0x0a84, B:266:0x0ad2, B:268:0x0b1d, B:270:0x0b2e, B:271:0x0b90, B:276:0x0b44, B:278:0x0b48, B:281:0x0a94, B:283:0x0abe, B:290:0x0b61, B:291:0x0b78, B:294:0x0b7b, B:308:0x0779, B:309:0x06d7, B:312:0x06e3, B:315:0x06f1, B:318:0x06ff, B:321:0x070d, B:324:0x071b, B:327:0x0727, B:330:0x0734, B:340:0x05d8, B:344:0x0510, B:349:0x0316, B:350:0x031d, B:352:0x0323, B:355:0x0333, B:360:0x0195, B:362:0x019f, B:364:0x01b4, B:369:0x01d4, B:372:0x020a, B:374:0x0210, B:376:0x021e, B:378:0x0232, B:381:0x0239, B:383:0x02c5, B:385:0x02cf, B:386:0x0265, B:388:0x0285, B:389:0x02ac, B:393:0x0299, B:395:0x01e0, B:397:0x01fe), top: B:41:0x0157, inners: #0, #1, #2, #8 }] */
    /* JADX WARN: Removed duplicated region for block: B:239:0x09aa A[Catch: all -> 0x0bc1, TryCatch #3 {all -> 0x0bc1, blocks: (B:42:0x0157, B:45:0x0166, B:47:0x016e, B:51:0x0178, B:58:0x0302, B:61:0x0339, B:63:0x037c, B:65:0x0383, B:66:0x039a, B:71:0x03a7, B:73:0x03bf, B:75:0x03c6, B:76:0x03dd, B:79:0x0401, B:83:0x0424, B:84:0x043b, B:85:0x0444, B:88:0x0463, B:89:0x047c, B:91:0x0484, B:93:0x0490, B:95:0x0496, B:96:0x049d, B:98:0x04aa, B:100:0x04b2, B:102:0x04ba, B:104:0x04c2, B:107:0x04c6, B:110:0x04d2, B:112:0x04df, B:115:0x0504, B:119:0x0528, B:120:0x053d, B:122:0x0569, B:125:0x0580, B:126:0x05bc, B:127:0x05e4, B:129:0x061c, B:130:0x061f, B:132:0x0627, B:133:0x062a, B:135:0x0632, B:136:0x0635, B:138:0x063d, B:139:0x0640, B:141:0x0649, B:142:0x064d, B:144:0x065a, B:145:0x065d, B:147:0x0684, B:149:0x068c, B:150:0x068f, B:152:0x069e, B:154:0x06a8, B:158:0x06bf, B:162:0x06cc, B:165:0x0743, B:167:0x074b, B:168:0x074e, B:170:0x0774, B:172:0x077f, B:175:0x0787, B:176:0x07a1, B:178:0x07a7, B:181:0x07bb, B:184:0x07c7, B:187:0x07d4, B:303:0x07ee, B:190:0x07fe, B:193:0x0807, B:194:0x080a, B:196:0x0817, B:197:0x081c, B:199:0x083a, B:201:0x083e, B:203:0x084e, B:205:0x0859, B:206:0x0864, B:208:0x086e, B:210:0x087a, B:212:0x0884, B:214:0x088a, B:216:0x089a, B:217:0x08ae, B:219:0x08b4, B:220:0x08bd, B:221:0x08ce, B:223:0x090a, B:225:0x0914, B:226:0x0917, B:228:0x0921, B:230:0x093e, B:231:0x0949, B:232:0x0981, B:234:0x0989, B:236:0x0993, B:237:0x09a0, B:239:0x09aa, B:240:0x09b7, B:241:0x09c0, B:243:0x09c6, B:245:0x0a02, B:247:0x0a0c, B:249:0x0a1e, B:256:0x0a24, B:258:0x0a68, B:259:0x0a73, B:260:0x0a7e, B:262:0x0a84, B:266:0x0ad2, B:268:0x0b1d, B:270:0x0b2e, B:271:0x0b90, B:276:0x0b44, B:278:0x0b48, B:281:0x0a94, B:283:0x0abe, B:290:0x0b61, B:291:0x0b78, B:294:0x0b7b, B:308:0x0779, B:309:0x06d7, B:312:0x06e3, B:315:0x06f1, B:318:0x06ff, B:321:0x070d, B:324:0x071b, B:327:0x0727, B:330:0x0734, B:340:0x05d8, B:344:0x0510, B:349:0x0316, B:350:0x031d, B:352:0x0323, B:355:0x0333, B:360:0x0195, B:362:0x019f, B:364:0x01b4, B:369:0x01d4, B:372:0x020a, B:374:0x0210, B:376:0x021e, B:378:0x0232, B:381:0x0239, B:383:0x02c5, B:385:0x02cf, B:386:0x0265, B:388:0x0285, B:389:0x02ac, B:393:0x0299, B:395:0x01e0, B:397:0x01fe), top: B:41:0x0157, inners: #0, #1, #2, #8 }] */
    /* JADX WARN: Removed duplicated region for block: B:243:0x09c6 A[Catch: all -> 0x0bc1, TryCatch #3 {all -> 0x0bc1, blocks: (B:42:0x0157, B:45:0x0166, B:47:0x016e, B:51:0x0178, B:58:0x0302, B:61:0x0339, B:63:0x037c, B:65:0x0383, B:66:0x039a, B:71:0x03a7, B:73:0x03bf, B:75:0x03c6, B:76:0x03dd, B:79:0x0401, B:83:0x0424, B:84:0x043b, B:85:0x0444, B:88:0x0463, B:89:0x047c, B:91:0x0484, B:93:0x0490, B:95:0x0496, B:96:0x049d, B:98:0x04aa, B:100:0x04b2, B:102:0x04ba, B:104:0x04c2, B:107:0x04c6, B:110:0x04d2, B:112:0x04df, B:115:0x0504, B:119:0x0528, B:120:0x053d, B:122:0x0569, B:125:0x0580, B:126:0x05bc, B:127:0x05e4, B:129:0x061c, B:130:0x061f, B:132:0x0627, B:133:0x062a, B:135:0x0632, B:136:0x0635, B:138:0x063d, B:139:0x0640, B:141:0x0649, B:142:0x064d, B:144:0x065a, B:145:0x065d, B:147:0x0684, B:149:0x068c, B:150:0x068f, B:152:0x069e, B:154:0x06a8, B:158:0x06bf, B:162:0x06cc, B:165:0x0743, B:167:0x074b, B:168:0x074e, B:170:0x0774, B:172:0x077f, B:175:0x0787, B:176:0x07a1, B:178:0x07a7, B:181:0x07bb, B:184:0x07c7, B:187:0x07d4, B:303:0x07ee, B:190:0x07fe, B:193:0x0807, B:194:0x080a, B:196:0x0817, B:197:0x081c, B:199:0x083a, B:201:0x083e, B:203:0x084e, B:205:0x0859, B:206:0x0864, B:208:0x086e, B:210:0x087a, B:212:0x0884, B:214:0x088a, B:216:0x089a, B:217:0x08ae, B:219:0x08b4, B:220:0x08bd, B:221:0x08ce, B:223:0x090a, B:225:0x0914, B:226:0x0917, B:228:0x0921, B:230:0x093e, B:231:0x0949, B:232:0x0981, B:234:0x0989, B:236:0x0993, B:237:0x09a0, B:239:0x09aa, B:240:0x09b7, B:241:0x09c0, B:243:0x09c6, B:245:0x0a02, B:247:0x0a0c, B:249:0x0a1e, B:256:0x0a24, B:258:0x0a68, B:259:0x0a73, B:260:0x0a7e, B:262:0x0a84, B:266:0x0ad2, B:268:0x0b1d, B:270:0x0b2e, B:271:0x0b90, B:276:0x0b44, B:278:0x0b48, B:281:0x0a94, B:283:0x0abe, B:290:0x0b61, B:291:0x0b78, B:294:0x0b7b, B:308:0x0779, B:309:0x06d7, B:312:0x06e3, B:315:0x06f1, B:318:0x06ff, B:321:0x070d, B:324:0x071b, B:327:0x0727, B:330:0x0734, B:340:0x05d8, B:344:0x0510, B:349:0x0316, B:350:0x031d, B:352:0x0323, B:355:0x0333, B:360:0x0195, B:362:0x019f, B:364:0x01b4, B:369:0x01d4, B:372:0x020a, B:374:0x0210, B:376:0x021e, B:378:0x0232, B:381:0x0239, B:383:0x02c5, B:385:0x02cf, B:386:0x0265, B:388:0x0285, B:389:0x02ac, B:393:0x0299, B:395:0x01e0, B:397:0x01fe), top: B:41:0x0157, inners: #0, #1, #2, #8 }] */
    /* JADX WARN: Removed duplicated region for block: B:262:0x0a84 A[Catch: all -> 0x0bc1, TryCatch #3 {all -> 0x0bc1, blocks: (B:42:0x0157, B:45:0x0166, B:47:0x016e, B:51:0x0178, B:58:0x0302, B:61:0x0339, B:63:0x037c, B:65:0x0383, B:66:0x039a, B:71:0x03a7, B:73:0x03bf, B:75:0x03c6, B:76:0x03dd, B:79:0x0401, B:83:0x0424, B:84:0x043b, B:85:0x0444, B:88:0x0463, B:89:0x047c, B:91:0x0484, B:93:0x0490, B:95:0x0496, B:96:0x049d, B:98:0x04aa, B:100:0x04b2, B:102:0x04ba, B:104:0x04c2, B:107:0x04c6, B:110:0x04d2, B:112:0x04df, B:115:0x0504, B:119:0x0528, B:120:0x053d, B:122:0x0569, B:125:0x0580, B:126:0x05bc, B:127:0x05e4, B:129:0x061c, B:130:0x061f, B:132:0x0627, B:133:0x062a, B:135:0x0632, B:136:0x0635, B:138:0x063d, B:139:0x0640, B:141:0x0649, B:142:0x064d, B:144:0x065a, B:145:0x065d, B:147:0x0684, B:149:0x068c, B:150:0x068f, B:152:0x069e, B:154:0x06a8, B:158:0x06bf, B:162:0x06cc, B:165:0x0743, B:167:0x074b, B:168:0x074e, B:170:0x0774, B:172:0x077f, B:175:0x0787, B:176:0x07a1, B:178:0x07a7, B:181:0x07bb, B:184:0x07c7, B:187:0x07d4, B:303:0x07ee, B:190:0x07fe, B:193:0x0807, B:194:0x080a, B:196:0x0817, B:197:0x081c, B:199:0x083a, B:201:0x083e, B:203:0x084e, B:205:0x0859, B:206:0x0864, B:208:0x086e, B:210:0x087a, B:212:0x0884, B:214:0x088a, B:216:0x089a, B:217:0x08ae, B:219:0x08b4, B:220:0x08bd, B:221:0x08ce, B:223:0x090a, B:225:0x0914, B:226:0x0917, B:228:0x0921, B:230:0x093e, B:231:0x0949, B:232:0x0981, B:234:0x0989, B:236:0x0993, B:237:0x09a0, B:239:0x09aa, B:240:0x09b7, B:241:0x09c0, B:243:0x09c6, B:245:0x0a02, B:247:0x0a0c, B:249:0x0a1e, B:256:0x0a24, B:258:0x0a68, B:259:0x0a73, B:260:0x0a7e, B:262:0x0a84, B:266:0x0ad2, B:268:0x0b1d, B:270:0x0b2e, B:271:0x0b90, B:276:0x0b44, B:278:0x0b48, B:281:0x0a94, B:283:0x0abe, B:290:0x0b61, B:291:0x0b78, B:294:0x0b7b, B:308:0x0779, B:309:0x06d7, B:312:0x06e3, B:315:0x06f1, B:318:0x06ff, B:321:0x070d, B:324:0x071b, B:327:0x0727, B:330:0x0734, B:340:0x05d8, B:344:0x0510, B:349:0x0316, B:350:0x031d, B:352:0x0323, B:355:0x0333, B:360:0x0195, B:362:0x019f, B:364:0x01b4, B:369:0x01d4, B:372:0x020a, B:374:0x0210, B:376:0x021e, B:378:0x0232, B:381:0x0239, B:383:0x02c5, B:385:0x02cf, B:386:0x0265, B:388:0x0285, B:389:0x02ac, B:393:0x0299, B:395:0x01e0, B:397:0x01fe), top: B:41:0x0157, inners: #0, #1, #2, #8 }] */
    /* JADX WARN: Removed duplicated region for block: B:270:0x0b2e A[Catch: SQLiteException -> 0x0b47, all -> 0x0bc1, TRY_LEAVE, TryCatch #2 {SQLiteException -> 0x0b47, blocks: (B:268:0x0b1d, B:270:0x0b2e), top: B:267:0x0b1d, outer: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:275:0x0b42  */
    /* JADX WARN: Removed duplicated region for block: B:280:0x0a94 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:295:0x0980  */
    /* JADX WARN: Removed duplicated region for block: B:308:0x0779 A[Catch: all -> 0x0bc1, TryCatch #3 {all -> 0x0bc1, blocks: (B:42:0x0157, B:45:0x0166, B:47:0x016e, B:51:0x0178, B:58:0x0302, B:61:0x0339, B:63:0x037c, B:65:0x0383, B:66:0x039a, B:71:0x03a7, B:73:0x03bf, B:75:0x03c6, B:76:0x03dd, B:79:0x0401, B:83:0x0424, B:84:0x043b, B:85:0x0444, B:88:0x0463, B:89:0x047c, B:91:0x0484, B:93:0x0490, B:95:0x0496, B:96:0x049d, B:98:0x04aa, B:100:0x04b2, B:102:0x04ba, B:104:0x04c2, B:107:0x04c6, B:110:0x04d2, B:112:0x04df, B:115:0x0504, B:119:0x0528, B:120:0x053d, B:122:0x0569, B:125:0x0580, B:126:0x05bc, B:127:0x05e4, B:129:0x061c, B:130:0x061f, B:132:0x0627, B:133:0x062a, B:135:0x0632, B:136:0x0635, B:138:0x063d, B:139:0x0640, B:141:0x0649, B:142:0x064d, B:144:0x065a, B:145:0x065d, B:147:0x0684, B:149:0x068c, B:150:0x068f, B:152:0x069e, B:154:0x06a8, B:158:0x06bf, B:162:0x06cc, B:165:0x0743, B:167:0x074b, B:168:0x074e, B:170:0x0774, B:172:0x077f, B:175:0x0787, B:176:0x07a1, B:178:0x07a7, B:181:0x07bb, B:184:0x07c7, B:187:0x07d4, B:303:0x07ee, B:190:0x07fe, B:193:0x0807, B:194:0x080a, B:196:0x0817, B:197:0x081c, B:199:0x083a, B:201:0x083e, B:203:0x084e, B:205:0x0859, B:206:0x0864, B:208:0x086e, B:210:0x087a, B:212:0x0884, B:214:0x088a, B:216:0x089a, B:217:0x08ae, B:219:0x08b4, B:220:0x08bd, B:221:0x08ce, B:223:0x090a, B:225:0x0914, B:226:0x0917, B:228:0x0921, B:230:0x093e, B:231:0x0949, B:232:0x0981, B:234:0x0989, B:236:0x0993, B:237:0x09a0, B:239:0x09aa, B:240:0x09b7, B:241:0x09c0, B:243:0x09c6, B:245:0x0a02, B:247:0x0a0c, B:249:0x0a1e, B:256:0x0a24, B:258:0x0a68, B:259:0x0a73, B:260:0x0a7e, B:262:0x0a84, B:266:0x0ad2, B:268:0x0b1d, B:270:0x0b2e, B:271:0x0b90, B:276:0x0b44, B:278:0x0b48, B:281:0x0a94, B:283:0x0abe, B:290:0x0b61, B:291:0x0b78, B:294:0x0b7b, B:308:0x0779, B:309:0x06d7, B:312:0x06e3, B:315:0x06f1, B:318:0x06ff, B:321:0x070d, B:324:0x071b, B:327:0x0727, B:330:0x0734, B:340:0x05d8, B:344:0x0510, B:349:0x0316, B:350:0x031d, B:352:0x0323, B:355:0x0333, B:360:0x0195, B:362:0x019f, B:364:0x01b4, B:369:0x01d4, B:372:0x020a, B:374:0x0210, B:376:0x021e, B:378:0x0232, B:381:0x0239, B:383:0x02c5, B:385:0x02cf, B:386:0x0265, B:388:0x0285, B:389:0x02ac, B:393:0x0299, B:395:0x01e0, B:397:0x01fe), top: B:41:0x0157, inners: #0, #1, #2, #8 }] */
    /* JADX WARN: Removed duplicated region for block: B:340:0x05d8 A[Catch: all -> 0x0bc1, TryCatch #3 {all -> 0x0bc1, blocks: (B:42:0x0157, B:45:0x0166, B:47:0x016e, B:51:0x0178, B:58:0x0302, B:61:0x0339, B:63:0x037c, B:65:0x0383, B:66:0x039a, B:71:0x03a7, B:73:0x03bf, B:75:0x03c6, B:76:0x03dd, B:79:0x0401, B:83:0x0424, B:84:0x043b, B:85:0x0444, B:88:0x0463, B:89:0x047c, B:91:0x0484, B:93:0x0490, B:95:0x0496, B:96:0x049d, B:98:0x04aa, B:100:0x04b2, B:102:0x04ba, B:104:0x04c2, B:107:0x04c6, B:110:0x04d2, B:112:0x04df, B:115:0x0504, B:119:0x0528, B:120:0x053d, B:122:0x0569, B:125:0x0580, B:126:0x05bc, B:127:0x05e4, B:129:0x061c, B:130:0x061f, B:132:0x0627, B:133:0x062a, B:135:0x0632, B:136:0x0635, B:138:0x063d, B:139:0x0640, B:141:0x0649, B:142:0x064d, B:144:0x065a, B:145:0x065d, B:147:0x0684, B:149:0x068c, B:150:0x068f, B:152:0x069e, B:154:0x06a8, B:158:0x06bf, B:162:0x06cc, B:165:0x0743, B:167:0x074b, B:168:0x074e, B:170:0x0774, B:172:0x077f, B:175:0x0787, B:176:0x07a1, B:178:0x07a7, B:181:0x07bb, B:184:0x07c7, B:187:0x07d4, B:303:0x07ee, B:190:0x07fe, B:193:0x0807, B:194:0x080a, B:196:0x0817, B:197:0x081c, B:199:0x083a, B:201:0x083e, B:203:0x084e, B:205:0x0859, B:206:0x0864, B:208:0x086e, B:210:0x087a, B:212:0x0884, B:214:0x088a, B:216:0x089a, B:217:0x08ae, B:219:0x08b4, B:220:0x08bd, B:221:0x08ce, B:223:0x090a, B:225:0x0914, B:226:0x0917, B:228:0x0921, B:230:0x093e, B:231:0x0949, B:232:0x0981, B:234:0x0989, B:236:0x0993, B:237:0x09a0, B:239:0x09aa, B:240:0x09b7, B:241:0x09c0, B:243:0x09c6, B:245:0x0a02, B:247:0x0a0c, B:249:0x0a1e, B:256:0x0a24, B:258:0x0a68, B:259:0x0a73, B:260:0x0a7e, B:262:0x0a84, B:266:0x0ad2, B:268:0x0b1d, B:270:0x0b2e, B:271:0x0b90, B:276:0x0b44, B:278:0x0b48, B:281:0x0a94, B:283:0x0abe, B:290:0x0b61, B:291:0x0b78, B:294:0x0b7b, B:308:0x0779, B:309:0x06d7, B:312:0x06e3, B:315:0x06f1, B:318:0x06ff, B:321:0x070d, B:324:0x071b, B:327:0x0727, B:330:0x0734, B:340:0x05d8, B:344:0x0510, B:349:0x0316, B:350:0x031d, B:352:0x0323, B:355:0x0333, B:360:0x0195, B:362:0x019f, B:364:0x01b4, B:369:0x01d4, B:372:0x020a, B:374:0x0210, B:376:0x021e, B:378:0x0232, B:381:0x0239, B:383:0x02c5, B:385:0x02cf, B:386:0x0265, B:388:0x0285, B:389:0x02ac, B:393:0x0299, B:395:0x01e0, B:397:0x01fe), top: B:41:0x0157, inners: #0, #1, #2, #8 }] */
    /* JADX WARN: Removed duplicated region for block: B:349:0x0316 A[Catch: all -> 0x0bc1, TryCatch #3 {all -> 0x0bc1, blocks: (B:42:0x0157, B:45:0x0166, B:47:0x016e, B:51:0x0178, B:58:0x0302, B:61:0x0339, B:63:0x037c, B:65:0x0383, B:66:0x039a, B:71:0x03a7, B:73:0x03bf, B:75:0x03c6, B:76:0x03dd, B:79:0x0401, B:83:0x0424, B:84:0x043b, B:85:0x0444, B:88:0x0463, B:89:0x047c, B:91:0x0484, B:93:0x0490, B:95:0x0496, B:96:0x049d, B:98:0x04aa, B:100:0x04b2, B:102:0x04ba, B:104:0x04c2, B:107:0x04c6, B:110:0x04d2, B:112:0x04df, B:115:0x0504, B:119:0x0528, B:120:0x053d, B:122:0x0569, B:125:0x0580, B:126:0x05bc, B:127:0x05e4, B:129:0x061c, B:130:0x061f, B:132:0x0627, B:133:0x062a, B:135:0x0632, B:136:0x0635, B:138:0x063d, B:139:0x0640, B:141:0x0649, B:142:0x064d, B:144:0x065a, B:145:0x065d, B:147:0x0684, B:149:0x068c, B:150:0x068f, B:152:0x069e, B:154:0x06a8, B:158:0x06bf, B:162:0x06cc, B:165:0x0743, B:167:0x074b, B:168:0x074e, B:170:0x0774, B:172:0x077f, B:175:0x0787, B:176:0x07a1, B:178:0x07a7, B:181:0x07bb, B:184:0x07c7, B:187:0x07d4, B:303:0x07ee, B:190:0x07fe, B:193:0x0807, B:194:0x080a, B:196:0x0817, B:197:0x081c, B:199:0x083a, B:201:0x083e, B:203:0x084e, B:205:0x0859, B:206:0x0864, B:208:0x086e, B:210:0x087a, B:212:0x0884, B:214:0x088a, B:216:0x089a, B:217:0x08ae, B:219:0x08b4, B:220:0x08bd, B:221:0x08ce, B:223:0x090a, B:225:0x0914, B:226:0x0917, B:228:0x0921, B:230:0x093e, B:231:0x0949, B:232:0x0981, B:234:0x0989, B:236:0x0993, B:237:0x09a0, B:239:0x09aa, B:240:0x09b7, B:241:0x09c0, B:243:0x09c6, B:245:0x0a02, B:247:0x0a0c, B:249:0x0a1e, B:256:0x0a24, B:258:0x0a68, B:259:0x0a73, B:260:0x0a7e, B:262:0x0a84, B:266:0x0ad2, B:268:0x0b1d, B:270:0x0b2e, B:271:0x0b90, B:276:0x0b44, B:278:0x0b48, B:281:0x0a94, B:283:0x0abe, B:290:0x0b61, B:291:0x0b78, B:294:0x0b7b, B:308:0x0779, B:309:0x06d7, B:312:0x06e3, B:315:0x06f1, B:318:0x06ff, B:321:0x070d, B:324:0x071b, B:327:0x0727, B:330:0x0734, B:340:0x05d8, B:344:0x0510, B:349:0x0316, B:350:0x031d, B:352:0x0323, B:355:0x0333, B:360:0x0195, B:362:0x019f, B:364:0x01b4, B:369:0x01d4, B:372:0x020a, B:374:0x0210, B:376:0x021e, B:378:0x0232, B:381:0x0239, B:383:0x02c5, B:385:0x02cf, B:386:0x0265, B:388:0x0285, B:389:0x02ac, B:393:0x0299, B:395:0x01e0, B:397:0x01fe), top: B:41:0x0157, inners: #0, #1, #2, #8 }] */
    /* JADX WARN: Removed duplicated region for block: B:362:0x019f A[Catch: all -> 0x0bc1, TryCatch #3 {all -> 0x0bc1, blocks: (B:42:0x0157, B:45:0x0166, B:47:0x016e, B:51:0x0178, B:58:0x0302, B:61:0x0339, B:63:0x037c, B:65:0x0383, B:66:0x039a, B:71:0x03a7, B:73:0x03bf, B:75:0x03c6, B:76:0x03dd, B:79:0x0401, B:83:0x0424, B:84:0x043b, B:85:0x0444, B:88:0x0463, B:89:0x047c, B:91:0x0484, B:93:0x0490, B:95:0x0496, B:96:0x049d, B:98:0x04aa, B:100:0x04b2, B:102:0x04ba, B:104:0x04c2, B:107:0x04c6, B:110:0x04d2, B:112:0x04df, B:115:0x0504, B:119:0x0528, B:120:0x053d, B:122:0x0569, B:125:0x0580, B:126:0x05bc, B:127:0x05e4, B:129:0x061c, B:130:0x061f, B:132:0x0627, B:133:0x062a, B:135:0x0632, B:136:0x0635, B:138:0x063d, B:139:0x0640, B:141:0x0649, B:142:0x064d, B:144:0x065a, B:145:0x065d, B:147:0x0684, B:149:0x068c, B:150:0x068f, B:152:0x069e, B:154:0x06a8, B:158:0x06bf, B:162:0x06cc, B:165:0x0743, B:167:0x074b, B:168:0x074e, B:170:0x0774, B:172:0x077f, B:175:0x0787, B:176:0x07a1, B:178:0x07a7, B:181:0x07bb, B:184:0x07c7, B:187:0x07d4, B:303:0x07ee, B:190:0x07fe, B:193:0x0807, B:194:0x080a, B:196:0x0817, B:197:0x081c, B:199:0x083a, B:201:0x083e, B:203:0x084e, B:205:0x0859, B:206:0x0864, B:208:0x086e, B:210:0x087a, B:212:0x0884, B:214:0x088a, B:216:0x089a, B:217:0x08ae, B:219:0x08b4, B:220:0x08bd, B:221:0x08ce, B:223:0x090a, B:225:0x0914, B:226:0x0917, B:228:0x0921, B:230:0x093e, B:231:0x0949, B:232:0x0981, B:234:0x0989, B:236:0x0993, B:237:0x09a0, B:239:0x09aa, B:240:0x09b7, B:241:0x09c0, B:243:0x09c6, B:245:0x0a02, B:247:0x0a0c, B:249:0x0a1e, B:256:0x0a24, B:258:0x0a68, B:259:0x0a73, B:260:0x0a7e, B:262:0x0a84, B:266:0x0ad2, B:268:0x0b1d, B:270:0x0b2e, B:271:0x0b90, B:276:0x0b44, B:278:0x0b48, B:281:0x0a94, B:283:0x0abe, B:290:0x0b61, B:291:0x0b78, B:294:0x0b7b, B:308:0x0779, B:309:0x06d7, B:312:0x06e3, B:315:0x06f1, B:318:0x06ff, B:321:0x070d, B:324:0x071b, B:327:0x0727, B:330:0x0734, B:340:0x05d8, B:344:0x0510, B:349:0x0316, B:350:0x031d, B:352:0x0323, B:355:0x0333, B:360:0x0195, B:362:0x019f, B:364:0x01b4, B:369:0x01d4, B:372:0x020a, B:374:0x0210, B:376:0x021e, B:378:0x0232, B:381:0x0239, B:383:0x02c5, B:385:0x02cf, B:386:0x0265, B:388:0x0285, B:389:0x02ac, B:393:0x0299, B:395:0x01e0, B:397:0x01fe), top: B:41:0x0157, inners: #0, #1, #2, #8 }] */
    /* JADX WARN: Removed duplicated region for block: B:374:0x0210 A[Catch: all -> 0x0bc1, TryCatch #3 {all -> 0x0bc1, blocks: (B:42:0x0157, B:45:0x0166, B:47:0x016e, B:51:0x0178, B:58:0x0302, B:61:0x0339, B:63:0x037c, B:65:0x0383, B:66:0x039a, B:71:0x03a7, B:73:0x03bf, B:75:0x03c6, B:76:0x03dd, B:79:0x0401, B:83:0x0424, B:84:0x043b, B:85:0x0444, B:88:0x0463, B:89:0x047c, B:91:0x0484, B:93:0x0490, B:95:0x0496, B:96:0x049d, B:98:0x04aa, B:100:0x04b2, B:102:0x04ba, B:104:0x04c2, B:107:0x04c6, B:110:0x04d2, B:112:0x04df, B:115:0x0504, B:119:0x0528, B:120:0x053d, B:122:0x0569, B:125:0x0580, B:126:0x05bc, B:127:0x05e4, B:129:0x061c, B:130:0x061f, B:132:0x0627, B:133:0x062a, B:135:0x0632, B:136:0x0635, B:138:0x063d, B:139:0x0640, B:141:0x0649, B:142:0x064d, B:144:0x065a, B:145:0x065d, B:147:0x0684, B:149:0x068c, B:150:0x068f, B:152:0x069e, B:154:0x06a8, B:158:0x06bf, B:162:0x06cc, B:165:0x0743, B:167:0x074b, B:168:0x074e, B:170:0x0774, B:172:0x077f, B:175:0x0787, B:176:0x07a1, B:178:0x07a7, B:181:0x07bb, B:184:0x07c7, B:187:0x07d4, B:303:0x07ee, B:190:0x07fe, B:193:0x0807, B:194:0x080a, B:196:0x0817, B:197:0x081c, B:199:0x083a, B:201:0x083e, B:203:0x084e, B:205:0x0859, B:206:0x0864, B:208:0x086e, B:210:0x087a, B:212:0x0884, B:214:0x088a, B:216:0x089a, B:217:0x08ae, B:219:0x08b4, B:220:0x08bd, B:221:0x08ce, B:223:0x090a, B:225:0x0914, B:226:0x0917, B:228:0x0921, B:230:0x093e, B:231:0x0949, B:232:0x0981, B:234:0x0989, B:236:0x0993, B:237:0x09a0, B:239:0x09aa, B:240:0x09b7, B:241:0x09c0, B:243:0x09c6, B:245:0x0a02, B:247:0x0a0c, B:249:0x0a1e, B:256:0x0a24, B:258:0x0a68, B:259:0x0a73, B:260:0x0a7e, B:262:0x0a84, B:266:0x0ad2, B:268:0x0b1d, B:270:0x0b2e, B:271:0x0b90, B:276:0x0b44, B:278:0x0b48, B:281:0x0a94, B:283:0x0abe, B:290:0x0b61, B:291:0x0b78, B:294:0x0b7b, B:308:0x0779, B:309:0x06d7, B:312:0x06e3, B:315:0x06f1, B:318:0x06ff, B:321:0x070d, B:324:0x071b, B:327:0x0727, B:330:0x0734, B:340:0x05d8, B:344:0x0510, B:349:0x0316, B:350:0x031d, B:352:0x0323, B:355:0x0333, B:360:0x0195, B:362:0x019f, B:364:0x01b4, B:369:0x01d4, B:372:0x020a, B:374:0x0210, B:376:0x021e, B:378:0x0232, B:381:0x0239, B:383:0x02c5, B:385:0x02cf, B:386:0x0265, B:388:0x0285, B:389:0x02ac, B:393:0x0299, B:395:0x01e0, B:397:0x01fe), top: B:41:0x0157, inners: #0, #1, #2, #8 }] */
    /* JADX WARN: Removed duplicated region for block: B:385:0x02cf A[Catch: all -> 0x0bc1, TryCatch #3 {all -> 0x0bc1, blocks: (B:42:0x0157, B:45:0x0166, B:47:0x016e, B:51:0x0178, B:58:0x0302, B:61:0x0339, B:63:0x037c, B:65:0x0383, B:66:0x039a, B:71:0x03a7, B:73:0x03bf, B:75:0x03c6, B:76:0x03dd, B:79:0x0401, B:83:0x0424, B:84:0x043b, B:85:0x0444, B:88:0x0463, B:89:0x047c, B:91:0x0484, B:93:0x0490, B:95:0x0496, B:96:0x049d, B:98:0x04aa, B:100:0x04b2, B:102:0x04ba, B:104:0x04c2, B:107:0x04c6, B:110:0x04d2, B:112:0x04df, B:115:0x0504, B:119:0x0528, B:120:0x053d, B:122:0x0569, B:125:0x0580, B:126:0x05bc, B:127:0x05e4, B:129:0x061c, B:130:0x061f, B:132:0x0627, B:133:0x062a, B:135:0x0632, B:136:0x0635, B:138:0x063d, B:139:0x0640, B:141:0x0649, B:142:0x064d, B:144:0x065a, B:145:0x065d, B:147:0x0684, B:149:0x068c, B:150:0x068f, B:152:0x069e, B:154:0x06a8, B:158:0x06bf, B:162:0x06cc, B:165:0x0743, B:167:0x074b, B:168:0x074e, B:170:0x0774, B:172:0x077f, B:175:0x0787, B:176:0x07a1, B:178:0x07a7, B:181:0x07bb, B:184:0x07c7, B:187:0x07d4, B:303:0x07ee, B:190:0x07fe, B:193:0x0807, B:194:0x080a, B:196:0x0817, B:197:0x081c, B:199:0x083a, B:201:0x083e, B:203:0x084e, B:205:0x0859, B:206:0x0864, B:208:0x086e, B:210:0x087a, B:212:0x0884, B:214:0x088a, B:216:0x089a, B:217:0x08ae, B:219:0x08b4, B:220:0x08bd, B:221:0x08ce, B:223:0x090a, B:225:0x0914, B:226:0x0917, B:228:0x0921, B:230:0x093e, B:231:0x0949, B:232:0x0981, B:234:0x0989, B:236:0x0993, B:237:0x09a0, B:239:0x09aa, B:240:0x09b7, B:241:0x09c0, B:243:0x09c6, B:245:0x0a02, B:247:0x0a0c, B:249:0x0a1e, B:256:0x0a24, B:258:0x0a68, B:259:0x0a73, B:260:0x0a7e, B:262:0x0a84, B:266:0x0ad2, B:268:0x0b1d, B:270:0x0b2e, B:271:0x0b90, B:276:0x0b44, B:278:0x0b48, B:281:0x0a94, B:283:0x0abe, B:290:0x0b61, B:291:0x0b78, B:294:0x0b7b, B:308:0x0779, B:309:0x06d7, B:312:0x06e3, B:315:0x06f1, B:318:0x06ff, B:321:0x070d, B:324:0x071b, B:327:0x0727, B:330:0x0734, B:340:0x05d8, B:344:0x0510, B:349:0x0316, B:350:0x031d, B:352:0x0323, B:355:0x0333, B:360:0x0195, B:362:0x019f, B:364:0x01b4, B:369:0x01d4, B:372:0x020a, B:374:0x0210, B:376:0x021e, B:378:0x0232, B:381:0x0239, B:383:0x02c5, B:385:0x02cf, B:386:0x0265, B:388:0x0285, B:389:0x02ac, B:393:0x0299, B:395:0x01e0, B:397:0x01fe), top: B:41:0x0157, inners: #0, #1, #2, #8 }] */
    /* JADX WARN: Removed duplicated region for block: B:397:0x01fe A[Catch: all -> 0x0bc1, TryCatch #3 {all -> 0x0bc1, blocks: (B:42:0x0157, B:45:0x0166, B:47:0x016e, B:51:0x0178, B:58:0x0302, B:61:0x0339, B:63:0x037c, B:65:0x0383, B:66:0x039a, B:71:0x03a7, B:73:0x03bf, B:75:0x03c6, B:76:0x03dd, B:79:0x0401, B:83:0x0424, B:84:0x043b, B:85:0x0444, B:88:0x0463, B:89:0x047c, B:91:0x0484, B:93:0x0490, B:95:0x0496, B:96:0x049d, B:98:0x04aa, B:100:0x04b2, B:102:0x04ba, B:104:0x04c2, B:107:0x04c6, B:110:0x04d2, B:112:0x04df, B:115:0x0504, B:119:0x0528, B:120:0x053d, B:122:0x0569, B:125:0x0580, B:126:0x05bc, B:127:0x05e4, B:129:0x061c, B:130:0x061f, B:132:0x0627, B:133:0x062a, B:135:0x0632, B:136:0x0635, B:138:0x063d, B:139:0x0640, B:141:0x0649, B:142:0x064d, B:144:0x065a, B:145:0x065d, B:147:0x0684, B:149:0x068c, B:150:0x068f, B:152:0x069e, B:154:0x06a8, B:158:0x06bf, B:162:0x06cc, B:165:0x0743, B:167:0x074b, B:168:0x074e, B:170:0x0774, B:172:0x077f, B:175:0x0787, B:176:0x07a1, B:178:0x07a7, B:181:0x07bb, B:184:0x07c7, B:187:0x07d4, B:303:0x07ee, B:190:0x07fe, B:193:0x0807, B:194:0x080a, B:196:0x0817, B:197:0x081c, B:199:0x083a, B:201:0x083e, B:203:0x084e, B:205:0x0859, B:206:0x0864, B:208:0x086e, B:210:0x087a, B:212:0x0884, B:214:0x088a, B:216:0x089a, B:217:0x08ae, B:219:0x08b4, B:220:0x08bd, B:221:0x08ce, B:223:0x090a, B:225:0x0914, B:226:0x0917, B:228:0x0921, B:230:0x093e, B:231:0x0949, B:232:0x0981, B:234:0x0989, B:236:0x0993, B:237:0x09a0, B:239:0x09aa, B:240:0x09b7, B:241:0x09c0, B:243:0x09c6, B:245:0x0a02, B:247:0x0a0c, B:249:0x0a1e, B:256:0x0a24, B:258:0x0a68, B:259:0x0a73, B:260:0x0a7e, B:262:0x0a84, B:266:0x0ad2, B:268:0x0b1d, B:270:0x0b2e, B:271:0x0b90, B:276:0x0b44, B:278:0x0b48, B:281:0x0a94, B:283:0x0abe, B:290:0x0b61, B:291:0x0b78, B:294:0x0b7b, B:308:0x0779, B:309:0x06d7, B:312:0x06e3, B:315:0x06f1, B:318:0x06ff, B:321:0x070d, B:324:0x071b, B:327:0x0727, B:330:0x0734, B:340:0x05d8, B:344:0x0510, B:349:0x0316, B:350:0x031d, B:352:0x0323, B:355:0x0333, B:360:0x0195, B:362:0x019f, B:364:0x01b4, B:369:0x01d4, B:372:0x020a, B:374:0x0210, B:376:0x021e, B:378:0x0232, B:381:0x0239, B:383:0x02c5, B:385:0x02cf, B:386:0x0265, B:388:0x0285, B:389:0x02ac, B:393:0x0299, B:395:0x01e0, B:397:0x01fe), top: B:41:0x0157, inners: #0, #1, #2, #8 }] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0184  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0313  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x037c A[Catch: all -> 0x0bc1, TryCatch #3 {all -> 0x0bc1, blocks: (B:42:0x0157, B:45:0x0166, B:47:0x016e, B:51:0x0178, B:58:0x0302, B:61:0x0339, B:63:0x037c, B:65:0x0383, B:66:0x039a, B:71:0x03a7, B:73:0x03bf, B:75:0x03c6, B:76:0x03dd, B:79:0x0401, B:83:0x0424, B:84:0x043b, B:85:0x0444, B:88:0x0463, B:89:0x047c, B:91:0x0484, B:93:0x0490, B:95:0x0496, B:96:0x049d, B:98:0x04aa, B:100:0x04b2, B:102:0x04ba, B:104:0x04c2, B:107:0x04c6, B:110:0x04d2, B:112:0x04df, B:115:0x0504, B:119:0x0528, B:120:0x053d, B:122:0x0569, B:125:0x0580, B:126:0x05bc, B:127:0x05e4, B:129:0x061c, B:130:0x061f, B:132:0x0627, B:133:0x062a, B:135:0x0632, B:136:0x0635, B:138:0x063d, B:139:0x0640, B:141:0x0649, B:142:0x064d, B:144:0x065a, B:145:0x065d, B:147:0x0684, B:149:0x068c, B:150:0x068f, B:152:0x069e, B:154:0x06a8, B:158:0x06bf, B:162:0x06cc, B:165:0x0743, B:167:0x074b, B:168:0x074e, B:170:0x0774, B:172:0x077f, B:175:0x0787, B:176:0x07a1, B:178:0x07a7, B:181:0x07bb, B:184:0x07c7, B:187:0x07d4, B:303:0x07ee, B:190:0x07fe, B:193:0x0807, B:194:0x080a, B:196:0x0817, B:197:0x081c, B:199:0x083a, B:201:0x083e, B:203:0x084e, B:205:0x0859, B:206:0x0864, B:208:0x086e, B:210:0x087a, B:212:0x0884, B:214:0x088a, B:216:0x089a, B:217:0x08ae, B:219:0x08b4, B:220:0x08bd, B:221:0x08ce, B:223:0x090a, B:225:0x0914, B:226:0x0917, B:228:0x0921, B:230:0x093e, B:231:0x0949, B:232:0x0981, B:234:0x0989, B:236:0x0993, B:237:0x09a0, B:239:0x09aa, B:240:0x09b7, B:241:0x09c0, B:243:0x09c6, B:245:0x0a02, B:247:0x0a0c, B:249:0x0a1e, B:256:0x0a24, B:258:0x0a68, B:259:0x0a73, B:260:0x0a7e, B:262:0x0a84, B:266:0x0ad2, B:268:0x0b1d, B:270:0x0b2e, B:271:0x0b90, B:276:0x0b44, B:278:0x0b48, B:281:0x0a94, B:283:0x0abe, B:290:0x0b61, B:291:0x0b78, B:294:0x0b7b, B:308:0x0779, B:309:0x06d7, B:312:0x06e3, B:315:0x06f1, B:318:0x06ff, B:321:0x070d, B:324:0x071b, B:327:0x0727, B:330:0x0734, B:340:0x05d8, B:344:0x0510, B:349:0x0316, B:350:0x031d, B:352:0x0323, B:355:0x0333, B:360:0x0195, B:362:0x019f, B:364:0x01b4, B:369:0x01d4, B:372:0x020a, B:374:0x0210, B:376:0x021e, B:378:0x0232, B:381:0x0239, B:383:0x02c5, B:385:0x02cf, B:386:0x0265, B:388:0x0285, B:389:0x02ac, B:393:0x0299, B:395:0x01e0, B:397:0x01fe), top: B:41:0x0157, inners: #0, #1, #2, #8 }] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x03a3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    final void zzax(zzbh zzbhVar, zzr zzrVar) {
        boolean z;
        String zzg;
        String str;
        String str2;
        long longValue;
        String str3;
        String str4;
        zzbh zzbhVar2;
        String str5;
        zzqd zzqdVar;
        zzqd zzqdVar2;
        zzbf zzbfVar;
        long j;
        long zzH;
        String str6;
        long j2;
        zzbc zzbcVar;
        String str7;
        zzbd zzs;
        zzbd zzc;
        String str8;
        com.google.android.gms.internal.measurement.zzhw zzz;
        String str9;
        String str10;
        String str11;
        long j3;
        String str12;
        long j4;
        Map emptyMap;
        ArrayList arrayList;
        String str13;
        zzjx zzl;
        zzjw zzjwVar;
        zzjx zzjxVar;
        zzjw zzjwVar2;
        String str14;
        zzio zzioVar;
        zzh zzl2;
        int i;
        List zzE;
        int i2;
        zzaw zzj;
        com.google.android.gms.internal.measurement.zzhx zzhxVar;
        zzaw zzj2;
        zzbe zzbeVar;
        int i3;
        ContentValues contentValues;
        Pair zzd;
        zzh zzl3;
        String str15;
        Object obj;
        zzqd zzy;
        Preconditions.checkNotNull(zzrVar);
        String str16 = zzrVar.zza;
        Preconditions.checkNotEmpty(str16);
        long nanoTime = System.nanoTime();
        zzaX().zzg();
        zzM();
        zzA();
        if (zzqa.zzE(zzbhVar, zzrVar)) {
            if (!zzrVar.zzh) {
                zzg(zzrVar);
                return;
            }
            zzif zzr = zzr();
            String str17 = zzbhVar.zza;
            if (zzr.zzx(str16, str17)) {
                zzaW().zzk().zzc("Dropping blocked event. appId", zzhe.zzn(str16), this.zzn.zzj().zzd(str17));
                if (!zzr().zzt(str16) && !zzr().zzy(str16)) {
                    if ("_err".equals(str17)) {
                        return;
                    }
                    zzB().zzR(this.zzK, str16, 11, "_ev", str17, 0);
                    return;
                }
                zzh zzl4 = zzj().zzl(str16);
                if (zzl4 != null) {
                    long abs = Math.abs(zzaU().currentTimeMillis() - Math.max(zzl4.zzp(), zzl4.zzg()));
                    zzi();
                    if (abs > ((Long) zzgi.zzM.zza(null)).longValue()) {
                        zzaW().zzd().zza("Fetching config for blocked app");
                        zzO(zzl4);
                        return;
                    }
                    return;
                }
                return;
            }
            zzhf zzb2 = zzhf.zzb(zzbhVar);
            zzB().zzQ(zzb2, zzi().zzf(str16));
            int zzi = zzi().zzi(str16, zzgi.zzaf, 10, 35);
            Bundle bundle = zzb2.zzd;
            for (String str18 : new TreeSet(bundle.keySet())) {
                if (FirebaseAnalytics.Param.ITEMS.equals(str18)) {
                    zzB().zzP(bundle.getParcelableArray(str18), zzi);
                }
            }
            zzbh zza = zzb2.zza();
            if (Log.isLoggable(zzaW().zzr(), 2)) {
                zzaW().zzj().zzb("Logging event", this.zzn.zzj().zzc(zza));
            }
            zzj().zzH();
            try {
                zzg(zzrVar);
                String str19 = zza.zza;
                if (!"ecommerce_purchase".equals(str19) && !FirebaseAnalytics.Event.PURCHASE.equals(str19) && !FirebaseAnalytics.Event.REFUND.equals(str19)) {
                    z = false;
                    if (!"_iap".equals(str19)) {
                        if (!z) {
                            str3 = "value";
                            str = "app_id";
                            str2 = "_fx";
                            str4 = "raw_events";
                            zzbhVar2 = zza;
                            str5 = "_err";
                            String str20 = zzbhVar2.zza;
                            boolean zzaq = zzqf.zzaq(str20);
                            boolean equals = str5.equals(str20);
                            zzB();
                            zzbfVar = zzbhVar2.zzb;
                            if (zzbfVar == null) {
                                j = 0;
                            } else {
                                zzbe zzbeVar2 = new zzbe(zzbfVar);
                                j = 0;
                                while (zzbeVar2.hasNext()) {
                                    String next = zzbeVar2.next();
                                    String str21 = next;
                                    if (zzbfVar.zzf(next) instanceof Parcelable[]) {
                                        j += ((Parcelable[]) r11).length;
                                    }
                                }
                            }
                            zzbh zzbhVar3 = zzbhVar2;
                            zzas zzp = zzj().zzp(zza(), str16, j + 1, true, zzaq, false, equals, false, false, false);
                            long j5 = zzp.zzb;
                            zzi();
                            zzH = j5 - zzam.zzH();
                            if (zzH > 0) {
                                if (zzH % 1000 == 1) {
                                    zzaW().zze().zzc("Data loss. Too many events logged. appId, count", zzhe.zzn(str16), Long.valueOf(zzp.zzb));
                                }
                                zzj().zzS();
                            } else {
                                if (zzaq) {
                                    long j6 = zzp.zza;
                                    zzi();
                                    long intValue = j6 - ((Integer) zzgi.zzm.zza(null)).intValue();
                                    if (intValue > 0) {
                                        if (intValue % 1000 == 1) {
                                            zzaW().zze().zzc("Data loss. Too many public events logged. appId, count", zzhe.zzn(str16), Long.valueOf(zzp.zza));
                                        }
                                        zzB().zzR(this.zzK, str16, 16, "_ev", zzbhVar3.zza, 0);
                                        zzj().zzS();
                                    }
                                }
                                if (equals) {
                                    long max = zzp.zzd - Math.max(0, Math.min(1000000, zzi().zzh(zzrVar.zza, zzgi.zzl)));
                                    if (max > 0) {
                                        if (max == 1) {
                                            zzaW().zze().zzc("Too many error events logged. appId, count", zzhe.zzn(str16), Long.valueOf(zzp.zzd));
                                        }
                                        zzj().zzS();
                                    }
                                }
                                Bundle zzc2 = zzbfVar.zzc();
                                zzqf zzB = zzB();
                                String str22 = zzbhVar3.zzc;
                                zzB.zzS(zzc2, "_o", str22);
                                if (zzB().zzak(str16, zzrVar.zzD)) {
                                    zzB().zzS(zzc2, "_dbg", 1L);
                                    zzB().zzS(zzc2, "_r", 1L);
                                }
                                if ("_s".equals(str20) && (zzy = zzj().zzy(zzrVar.zza, "_sno")) != null) {
                                    Object obj2 = zzy.zze;
                                    if (obj2 instanceof Long) {
                                        zzB().zzS(zzc2, "_sno", obj2);
                                    }
                                }
                                if (zzi().zzx(null, zzgi.zzbg) && Objects.equals(str22, "am") && Objects.equals(str20, "_ai") && (obj = zzc2.get((str15 = str3))) != null && (obj instanceof String)) {
                                    try {
                                        double parseDouble = Double.parseDouble((String) obj);
                                        zzc2.remove(str15);
                                        zzc2.putDouble(str15, parseDouble);
                                    } catch (NumberFormatException unused) {
                                    }
                                }
                                zzaw zzj3 = zzj();
                                Preconditions.checkNotEmpty(str16);
                                zzj3.zzg();
                                zzj3.zzav();
                                try {
                                    str6 = str4;
                                    try {
                                        j2 = zzj3.zzj().delete(str6, "rowid in (select rowid from raw_events where app_id=? order by rowid desc limit -1 offset ?)", new String[]{str16, String.valueOf(Math.max(0, Math.min(1000000, zzj3.zzu.zzf().zzh(str16, zzgi.zzp))))});
                                    } catch (SQLiteException e) {
                                        e = e;
                                        zzj3.zzu.zzaW().zze().zzc("Error deleting over the limit events. appId", zzhe.zzn(str16), e);
                                        j2 = 0;
                                        if (j2 > 0) {
                                        }
                                        zzio zzioVar2 = this.zzn;
                                        str7 = str6;
                                        zzbcVar = new zzbc(zzioVar2, zzbhVar3.zzc, str16, zzbhVar3.zza, zzbhVar3.zzd, 0L, zzc2);
                                        zzaw zzj4 = zzj();
                                        String str23 = zzbcVar.zzb;
                                        zzs = zzj4.zzs(str16, str23);
                                        if (zzs == null) {
                                        }
                                        zzj().zzV(zzc);
                                        zzaX().zzg();
                                        zzM();
                                        Preconditions.checkNotNull(zzbcVar);
                                        Preconditions.checkNotNull(zzrVar);
                                        String str24 = zzbcVar.zza;
                                        Preconditions.checkNotEmpty(str24);
                                        str8 = zzrVar.zza;
                                        Preconditions.checkArgument(str24.equals(str8));
                                        zzz = com.google.android.gms.internal.measurement.zzhx.zzz();
                                        boolean z2 = true;
                                        zzz.zzar(1);
                                        zzz.zzan("android");
                                        if (!TextUtils.isEmpty(str8)) {
                                        }
                                        str9 = zzrVar.zzd;
                                        if (!TextUtils.isEmpty(str9)) {
                                        }
                                        str10 = zzrVar.zzc;
                                        if (!TextUtils.isEmpty(str10)) {
                                        }
                                        str11 = zzrVar.zzw;
                                        if (!TextUtils.isEmpty(str11)) {
                                        }
                                        j3 = zzrVar.zzj;
                                        if (j3 != -2147483648L) {
                                        }
                                        zzz.zzai(zzrVar.zze);
                                        str12 = zzrVar.zzb;
                                        if (!TextUtils.isEmpty(str12)) {
                                        }
                                        zzjx zzl5 = zzu((String) Preconditions.checkNotNull(str8)).zzl(zzjx.zzk(zzrVar.zzu, 100));
                                        zzz.zzT(zzl5.zzp());
                                        if (zzz.zzaJ().isEmpty()) {
                                        }
                                        zzqr.zzb();
                                        if (!zzi().zzx(str8, zzgi.zzaV)) {
                                        }
                                        j4 = zzrVar.zzf;
                                        if (j4 != 0) {
                                        }
                                        zzz.zzZ(zzrVar.zzr);
                                        zzqa zzA = zzA();
                                        com.google.android.gms.internal.measurement.zzjm zza2 = com.google.android.gms.internal.measurement.zzjm.zza(zzA.zzg.zzn.zzaT().getContentResolver(), com.google.android.gms.internal.measurement.zzjx.zza("com.google.android.gms.measurement"), new Runnable() { // from class: com.google.android.gms.measurement.internal.zzbj
                                            @Override // java.lang.Runnable
                                            public final void run() {
                                                com.google.android.gms.internal.measurement.zzki.zzc();
                                            }
                                        });
                                        if (zza2 != null) {
                                        }
                                        if (emptyMap != null) {
                                            arrayList = new ArrayList();
                                            int intValue2 = ((Integer) zzgi.zzae.zza(null)).intValue();
                                            while (r6.hasNext()) {
                                            }
                                        }
                                        arrayList = null;
                                        if (arrayList != null) {
                                        }
                                        if (zzi().zzx(null, zzgi.zzbk)) {
                                        }
                                        str13 = zzrVar.zza;
                                        zzl = zzu((String) Preconditions.checkNotNull(str13)).zzl(zzjx.zzk(zzrVar.zzu, 100));
                                        zzjwVar = zzjw.AD_STORAGE;
                                        if (zzl.zzr(zzjwVar)) {
                                            zzd = this.zzk.zzd(str13, zzl);
                                            if (!TextUtils.isEmpty((CharSequence) zzd.first)) {
                                            }
                                        }
                                        zzjxVar = zzl;
                                        zzjwVar2 = zzjwVar;
                                        str14 = "_r";
                                        zzioVar = this.zzn;
                                        zzioVar.zzg().zzv();
                                        zzz.zzX(Build.MODEL);
                                        zzioVar.zzg().zzv();
                                        zzz.zzam(Build.VERSION.RELEASE);
                                        zzz.zzaz((int) zzioVar.zzg().zza());
                                        zzz.zzaD(zzioVar.zzg().zzb());
                                        zzz.zzay(zzrVar.zzy);
                                        if (zzioVar.zzJ()) {
                                        }
                                        zzl2 = zzj().zzl(str13);
                                        if (zzl2 == null) {
                                        }
                                        if (zzjxVar.zzr(zzjw.ANALYTICS_STORAGE)) {
                                        }
                                        if (!TextUtils.isEmpty(zzl2.zzG())) {
                                        }
                                        zzE = zzj().zzE(str13);
                                        while (i2 < zzE.size()) {
                                        }
                                        zzj = zzj();
                                        zzhxVar = (com.google.android.gms.internal.measurement.zzhx) zzz.zzba();
                                        zzj.zzg();
                                        zzj.zzav();
                                        Preconditions.checkNotNull(zzhxVar);
                                        Preconditions.checkNotEmpty(zzhxVar.zzF());
                                        byte[] zzcd = zzhxVar.zzcd();
                                        long zzf = zzj.zzg.zzA().zzf(zzcd);
                                        ContentValues contentValues2 = new ContentValues();
                                        String str25 = str;
                                        contentValues2.put(str25, zzhxVar.zzF());
                                        contentValues2.put("metadata_fingerprint", Long.valueOf(zzf));
                                        contentValues2.put(TtmlNode.TAG_METADATA, zzcd);
                                        zzj.zzj().insertWithOnConflict("raw_events_metadata", null, contentValues2, 4);
                                        zzj2 = zzj();
                                        zzbeVar = new zzbe(zzbcVar.zzf);
                                        while (true) {
                                            if (zzbeVar.hasNext()) {
                                            }
                                        }
                                        i3 = 1;
                                        zzj2.zzg();
                                        zzj2.zzav();
                                        Preconditions.checkNotNull(zzbcVar);
                                        String str26 = zzbcVar.zza;
                                        Preconditions.checkNotEmpty(str26);
                                        byte[] zzcd2 = zzj2.zzg.zzA().zzm(zzbcVar).zzcd();
                                        contentValues = new ContentValues();
                                        contentValues.put(str25, str26);
                                        contentValues.put("name", zzbcVar.zzb);
                                        contentValues.put("timestamp", Long.valueOf(zzbcVar.zzd));
                                        contentValues.put("metadata_fingerprint", Long.valueOf(zzf));
                                        contentValues.put("data", zzcd2);
                                        contentValues.put("realtime", Integer.valueOf(i3));
                                        try {
                                            if (zzj2.zzj().insert(str7, null, contentValues) == -1) {
                                            }
                                        } catch (SQLiteException e2) {
                                            zzj2.zzu.zzaW().zze().zzc("Error storing raw event. appId", zzhe.zzn(zzbcVar.zza), e2);
                                        }
                                        zzj().zzS();
                                        zzj().zzL();
                                        zzaL();
                                        zzaW().zzj().zzb("Background event processing time, ms", Long.valueOf(((System.nanoTime() - nanoTime) + 500000) / 1000000));
                                        return;
                                    }
                                } catch (SQLiteException e3) {
                                    e = e3;
                                    str6 = str4;
                                }
                                if (j2 > 0) {
                                    zzaW().zzk().zzc("Data lost. Too many events stored on disk, deleted. appId", zzhe.zzn(str16), Long.valueOf(j2));
                                }
                                zzio zzioVar22 = this.zzn;
                                str7 = str6;
                                zzbcVar = new zzbc(zzioVar22, zzbhVar3.zzc, str16, zzbhVar3.zza, zzbhVar3.zzd, 0L, zzc2);
                                zzaw zzj42 = zzj();
                                String str232 = zzbcVar.zzb;
                                zzs = zzj42.zzs(str16, str232);
                                if (zzs == null) {
                                    zzbcVar = zzbcVar.zza(zzioVar22, zzs.zzf);
                                    zzc = zzs.zzc(zzbcVar.zzd);
                                } else if (zzj().zzi(str16) < zzi().zzb(str16) || !zzaq) {
                                    zzc = new zzbd(str16, str232, 0L, 0L, 0L, zzbcVar.zzd, 0L, null, null, null, null);
                                } else {
                                    zzaW().zze().zzd("Too many event names used, ignoring event. appId, name, supported count", zzhe.zzn(str16), zzioVar22.zzj().zzd(str232), Integer.valueOf(zzi().zzb(str16)));
                                    zzB().zzR(this.zzK, str16, 8, null, null, 0);
                                }
                                zzj().zzV(zzc);
                                zzaX().zzg();
                                zzM();
                                Preconditions.checkNotNull(zzbcVar);
                                Preconditions.checkNotNull(zzrVar);
                                String str242 = zzbcVar.zza;
                                Preconditions.checkNotEmpty(str242);
                                str8 = zzrVar.zza;
                                Preconditions.checkArgument(str242.equals(str8));
                                zzz = com.google.android.gms.internal.measurement.zzhx.zzz();
                                boolean z22 = true;
                                zzz.zzar(1);
                                zzz.zzan("android");
                                if (!TextUtils.isEmpty(str8)) {
                                    zzz.zzI(str8);
                                }
                                str9 = zzrVar.zzd;
                                if (!TextUtils.isEmpty(str9)) {
                                    zzz.zzK(str9);
                                }
                                str10 = zzrVar.zzc;
                                if (!TextUtils.isEmpty(str10)) {
                                    zzz.zzL(str10);
                                }
                                str11 = zzrVar.zzw;
                                if (!TextUtils.isEmpty(str11)) {
                                    zzz.zzav(str11);
                                }
                                j3 = zzrVar.zzj;
                                if (j3 != -2147483648L) {
                                    zzz.zzM((int) j3);
                                }
                                zzz.zzai(zzrVar.zze);
                                str12 = zzrVar.zzb;
                                if (!TextUtils.isEmpty(str12)) {
                                    zzz.zzah(str12);
                                }
                                zzjx zzl52 = zzu((String) Preconditions.checkNotNull(str8)).zzl(zzjx.zzk(zzrVar.zzu, 100));
                                zzz.zzT(zzl52.zzp());
                                if (zzz.zzaJ().isEmpty()) {
                                    String str27 = zzrVar.zzp;
                                    if (!TextUtils.isEmpty(str27)) {
                                        zzz.zzH(str27);
                                    }
                                }
                                zzqr.zzb();
                                if (!zzi().zzx(str8, zzgi.zzaV) && zzB().zzab(str8)) {
                                    zzz.zzG(zzrVar.zzB);
                                    long j7 = zzrVar.zzC;
                                    if (!zzl52.zzr(zzjw.AD_STORAGE) && j7 != 0) {
                                        j7 = (j7 & (-2)) | 32;
                                    }
                                    zzz.zzaa(j7 == 1);
                                    if (j7 != 0) {
                                        com.google.android.gms.internal.measurement.zzhf zza3 = com.google.android.gms.internal.measurement.zzhg.zza();
                                        if ((j7 & 1) == 0) {
                                            z22 = false;
                                        }
                                        zza3.zzc(z22);
                                        zza3.zze((j7 & 2) != 0);
                                        zza3.zzf((j7 & 4) != 0);
                                        zza3.zzg((j7 & 8) != 0);
                                        zza3.zzb((j7 & 16) != 0);
                                        zza3.zza((j7 & 32) != 0);
                                        zza3.zzd((64 & j7) != 0);
                                        zzz.zzN((com.google.android.gms.internal.measurement.zzhg) zza3.zzba());
                                    }
                                }
                                j4 = zzrVar.zzf;
                                if (j4 != 0) {
                                    zzz.zzW(j4);
                                }
                                zzz.zzZ(zzrVar.zzr);
                                zzqa zzA2 = zzA();
                                com.google.android.gms.internal.measurement.zzjm zza22 = com.google.android.gms.internal.measurement.zzjm.zza(zzA2.zzg.zzn.zzaT().getContentResolver(), com.google.android.gms.internal.measurement.zzjx.zza("com.google.android.gms.measurement"), new Runnable() { // from class: com.google.android.gms.measurement.internal.zzbj
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        com.google.android.gms.internal.measurement.zzki.zzc();
                                    }
                                });
                                emptyMap = zza22 != null ? Collections.emptyMap() : zza22.zzd();
                                if (emptyMap != null && !emptyMap.isEmpty()) {
                                    arrayList = new ArrayList();
                                    int intValue22 = ((Integer) zzgi.zzae.zza(null)).intValue();
                                    for (Map.Entry entry : emptyMap.entrySet()) {
                                        if (((String) entry.getKey()).startsWith("measurement.id.")) {
                                            try {
                                                int parseInt = Integer.parseInt((String) entry.getValue());
                                                if (parseInt != 0) {
                                                    arrayList.add(Integer.valueOf(parseInt));
                                                    if (arrayList.size() >= intValue22) {
                                                        zzA2.zzu.zzaW().zzk().zzb("Too many experiment IDs. Number of IDs", Integer.valueOf(arrayList.size()));
                                                        break;
                                                    }
                                                    continue;
                                                } else {
                                                    continue;
                                                }
                                            } catch (NumberFormatException e4) {
                                                zzA2.zzu.zzaW().zzk().zzb("Experiment ID NumberFormatException", e4);
                                            }
                                        }
                                    }
                                }
                                arrayList = null;
                                if (arrayList != null) {
                                    zzz.zzk(arrayList);
                                }
                                if (zzi().zzx(null, zzgi.zzbk)) {
                                    zzz.zzaf("");
                                }
                                str13 = zzrVar.zza;
                                zzl = zzu((String) Preconditions.checkNotNull(str13)).zzl(zzjx.zzk(zzrVar.zzu, 100));
                                zzjwVar = zzjw.AD_STORAGE;
                                try {
                                    if (zzl.zzr(zzjwVar) && zzrVar.zzn) {
                                        zzd = this.zzk.zzd(str13, zzl);
                                        if (!TextUtils.isEmpty((CharSequence) zzd.first)) {
                                            zzz.zzas((String) zzd.first);
                                            if (zzd.second != null) {
                                                zzz.zzal(((Boolean) zzd.second).booleanValue());
                                            }
                                            String str28 = str2;
                                            if (!zzbcVar.zzb.equals(str28) && !((String) zzd.first).equals("00000000-0000-0000-0000-000000000000") && (zzl3 = zzj().zzl(str13)) != null && zzl3.zzaM()) {
                                                zzar(str13, false, null, null);
                                                Bundle bundle2 = new Bundle();
                                                Long zzy2 = zzl3.zzy();
                                                if (zzy2 != null) {
                                                    long longValue2 = zzy2.longValue();
                                                    zzjxVar = zzl;
                                                    zzjwVar2 = zzjwVar;
                                                    bundle2.putLong("_pfo", Math.max(0L, longValue2));
                                                } else {
                                                    zzjxVar = zzl;
                                                    zzjwVar2 = zzjwVar;
                                                }
                                                Long zzz2 = zzl3.zzz();
                                                if (zzz2 != null) {
                                                    bundle2.putLong("_uwa", zzz2.longValue());
                                                }
                                                str14 = "_r";
                                                bundle2.putLong(str14, 1L);
                                                this.zzK.zza(str13, str28, bundle2);
                                                zzioVar = this.zzn;
                                                zzioVar.zzg().zzv();
                                                zzz.zzX(Build.MODEL);
                                                zzioVar.zzg().zzv();
                                                zzz.zzam(Build.VERSION.RELEASE);
                                                zzz.zzaz((int) zzioVar.zzg().zza());
                                                zzz.zzaD(zzioVar.zzg().zzb());
                                                zzz.zzay(zzrVar.zzy);
                                                if (zzioVar.zzJ()) {
                                                    zzz.zzaF();
                                                    if (!TextUtils.isEmpty(null)) {
                                                        zzz.zzY(null);
                                                    }
                                                }
                                                zzl2 = zzj().zzl(str13);
                                                if (zzl2 == null) {
                                                    zzl2 = new zzh(zzioVar, str13);
                                                    zzl2.zzV(zzC(zzjxVar));
                                                    zzl2.zzan(zzrVar.zzk);
                                                    zzl2.zzao(zzrVar.zzb);
                                                    if (zzjxVar.zzr(zzjwVar2)) {
                                                        zzl2.zzax(this.zzk.zzf(str13, zzrVar.zzn));
                                                    }
                                                    zzl2.zzat(0L);
                                                    zzl2.zzau(0L);
                                                    zzl2.zzas(0L);
                                                    zzl2.zzX(zzrVar.zzc);
                                                    zzl2.zzY(zzrVar.zzj);
                                                    zzl2.zzW(zzrVar.zzd);
                                                    zzl2.zzap(zzrVar.zze);
                                                    zzl2.zzaj(zzrVar.zzf);
                                                    zzl2.zzav(zzrVar.zzh);
                                                    zzl2.zzal(zzrVar.zzr);
                                                    i = 0;
                                                    zzj().zzT(zzl2, false, false);
                                                } else {
                                                    i = 0;
                                                }
                                                if (zzjxVar.zzr(zzjw.ANALYTICS_STORAGE) && !TextUtils.isEmpty(zzl2.zzD())) {
                                                    zzz.zzJ((String) Preconditions.checkNotNull(zzl2.zzD()));
                                                }
                                                if (!TextUtils.isEmpty(zzl2.zzG())) {
                                                    zzz.zzag((String) Preconditions.checkNotNull(zzl2.zzG()));
                                                }
                                                zzE = zzj().zzE(str13);
                                                for (i2 = i; i2 < zzE.size(); i2++) {
                                                    com.google.android.gms.internal.measurement.zzin zze = com.google.android.gms.internal.measurement.zzio.zze();
                                                    zze.zzf(((zzqd) zzE.get(i2)).zzc);
                                                    zze.zzg(((zzqd) zzE.get(i2)).zzd);
                                                    zzA().zzx(zze, ((zzqd) zzE.get(i2)).zze);
                                                    zzz.zzo(zze);
                                                    if ("_sid".equals(((zzqd) zzE.get(i2)).zzc) && zzl2.zzv() != 0 && zzA().zzd(zzrVar.zzw) != zzl2.zzv()) {
                                                        zzz.zzA();
                                                    }
                                                }
                                                zzj = zzj();
                                                zzhxVar = (com.google.android.gms.internal.measurement.zzhx) zzz.zzba();
                                                zzj.zzg();
                                                zzj.zzav();
                                                Preconditions.checkNotNull(zzhxVar);
                                                Preconditions.checkNotEmpty(zzhxVar.zzF());
                                                byte[] zzcd3 = zzhxVar.zzcd();
                                                long zzf2 = zzj.zzg.zzA().zzf(zzcd3);
                                                ContentValues contentValues22 = new ContentValues();
                                                String str252 = str;
                                                contentValues22.put(str252, zzhxVar.zzF());
                                                contentValues22.put("metadata_fingerprint", Long.valueOf(zzf2));
                                                contentValues22.put(TtmlNode.TAG_METADATA, zzcd3);
                                                zzj.zzj().insertWithOnConflict("raw_events_metadata", null, contentValues22, 4);
                                                zzj2 = zzj();
                                                zzbeVar = new zzbe(zzbcVar.zzf);
                                                while (true) {
                                                    if (zzbeVar.hasNext()) {
                                                        String next2 = zzbeVar.next();
                                                        String str29 = next2;
                                                        if (str14.equals(next2)) {
                                                            break;
                                                        }
                                                    } else {
                                                        zzif zzr2 = zzr();
                                                        String str30 = zzbcVar.zza;
                                                        boolean zzw = zzr2.zzw(str30, zzbcVar.zzb);
                                                        zzas zzo = zzj().zzo(zza(), str30, false, false, false, false, false, false, false);
                                                        if (!zzw || zzo.zze >= zzi().zzh(str30, zzgi.zzo)) {
                                                            i3 = 0;
                                                        }
                                                    }
                                                }
                                                i3 = 1;
                                                zzj2.zzg();
                                                zzj2.zzav();
                                                Preconditions.checkNotNull(zzbcVar);
                                                String str262 = zzbcVar.zza;
                                                Preconditions.checkNotEmpty(str262);
                                                byte[] zzcd22 = zzj2.zzg.zzA().zzm(zzbcVar).zzcd();
                                                contentValues = new ContentValues();
                                                contentValues.put(str252, str262);
                                                contentValues.put("name", zzbcVar.zzb);
                                                contentValues.put("timestamp", Long.valueOf(zzbcVar.zzd));
                                                contentValues.put("metadata_fingerprint", Long.valueOf(zzf2));
                                                contentValues.put("data", zzcd22);
                                                contentValues.put("realtime", Integer.valueOf(i3));
                                                if (zzj2.zzj().insert(str7, null, contentValues) == -1) {
                                                    zzj2.zzu.zzaW().zze().zzb("Failed to insert raw event (got -1). appId", zzhe.zzn(str262));
                                                } else {
                                                    this.zza = 0L;
                                                }
                                                zzj().zzS();
                                                zzj().zzL();
                                                zzaL();
                                                zzaW().zzj().zzb("Background event processing time, ms", Long.valueOf(((System.nanoTime() - nanoTime) + 500000) / 1000000));
                                                return;
                                            }
                                        }
                                    }
                                    zzj.zzj().insertWithOnConflict("raw_events_metadata", null, contentValues22, 4);
                                    zzj2 = zzj();
                                    zzbeVar = new zzbe(zzbcVar.zzf);
                                    while (true) {
                                        if (zzbeVar.hasNext()) {
                                        }
                                    }
                                    i3 = 1;
                                    zzj2.zzg();
                                    zzj2.zzav();
                                    Preconditions.checkNotNull(zzbcVar);
                                    String str2622 = zzbcVar.zza;
                                    Preconditions.checkNotEmpty(str2622);
                                    byte[] zzcd222 = zzj2.zzg.zzA().zzm(zzbcVar).zzcd();
                                    contentValues = new ContentValues();
                                    contentValues.put(str252, str2622);
                                    contentValues.put("name", zzbcVar.zzb);
                                    contentValues.put("timestamp", Long.valueOf(zzbcVar.zzd));
                                    contentValues.put("metadata_fingerprint", Long.valueOf(zzf2));
                                    contentValues.put("data", zzcd222);
                                    contentValues.put("realtime", Integer.valueOf(i3));
                                    if (zzj2.zzj().insert(str7, null, contentValues) == -1) {
                                    }
                                    zzj().zzS();
                                    zzj().zzL();
                                    zzaL();
                                    zzaW().zzj().zzb("Background event processing time, ms", Long.valueOf(((System.nanoTime() - nanoTime) + 500000) / 1000000));
                                    return;
                                } catch (SQLiteException e5) {
                                    zzj.zzu.zzaW().zze().zzc("Error storing raw event metadata. appId", zzhe.zzn(zzhxVar.zzF()), e5);
                                    throw e5;
                                }
                                zzjxVar = zzl;
                                zzjwVar2 = zzjwVar;
                                str14 = "_r";
                                zzioVar = this.zzn;
                                zzioVar.zzg().zzv();
                                zzz.zzX(Build.MODEL);
                                zzioVar.zzg().zzv();
                                zzz.zzam(Build.VERSION.RELEASE);
                                zzz.zzaz((int) zzioVar.zzg().zza());
                                zzz.zzaD(zzioVar.zzg().zzb());
                                zzz.zzay(zzrVar.zzy);
                                if (zzioVar.zzJ()) {
                                }
                                zzl2 = zzj().zzl(str13);
                                if (zzl2 == null) {
                                }
                                if (zzjxVar.zzr(zzjw.ANALYTICS_STORAGE)) {
                                    zzz.zzJ((String) Preconditions.checkNotNull(zzl2.zzD()));
                                }
                                if (!TextUtils.isEmpty(zzl2.zzG())) {
                                }
                                zzE = zzj().zzE(str13);
                                while (i2 < zzE.size()) {
                                }
                                zzj = zzj();
                                zzhxVar = (com.google.android.gms.internal.measurement.zzhx) zzz.zzba();
                                zzj.zzg();
                                zzj.zzav();
                                Preconditions.checkNotNull(zzhxVar);
                                Preconditions.checkNotEmpty(zzhxVar.zzF());
                                byte[] zzcd32 = zzhxVar.zzcd();
                                long zzf22 = zzj.zzg.zzA().zzf(zzcd32);
                                ContentValues contentValues222 = new ContentValues();
                                String str2522 = str;
                                contentValues222.put(str2522, zzhxVar.zzF());
                                contentValues222.put("metadata_fingerprint", Long.valueOf(zzf22));
                                contentValues222.put(TtmlNode.TAG_METADATA, zzcd32);
                            }
                        }
                        z = true;
                    }
                    zzbf zzbfVar2 = zza.zzb;
                    zzg = zzbfVar2.zzg(FirebaseAnalytics.Param.CURRENCY);
                    if (z) {
                        str = "app_id";
                        str2 = "_fx";
                        longValue = zzbfVar2.zze("value").longValue();
                    } else {
                        double doubleValue = zzbfVar2.zzd("value").doubleValue() * 1000000.0d;
                        if (doubleValue == AudioStats.AUDIO_AMPLITUDE_NONE) {
                            str = "app_id";
                            str2 = "_fx";
                            doubleValue = zzbfVar2.zze("value").longValue() * 1000000.0d;
                        } else {
                            str = "app_id";
                            str2 = "_fx";
                        }
                        if (doubleValue > 9.223372036854776E18d || doubleValue < -9.223372036854776E18d) {
                            zzaW().zzk().zzc("Data lost. Currency value is too big. appId", zzhe.zzn(str16), Double.valueOf(doubleValue));
                            zzj().zzS();
                        } else {
                            longValue = Math.round(doubleValue);
                            if (FirebaseAnalytics.Event.REFUND.equals(str19)) {
                                longValue = -longValue;
                            }
                        }
                    }
                    if (!TextUtils.isEmpty(zzg)) {
                        String upperCase = zzg.toUpperCase(Locale.US);
                        if (upperCase.matches("[A-Z]{3}")) {
                            String concat = "_ltv_".concat(String.valueOf(upperCase));
                            zzqd zzy3 = zzj().zzy(str16, concat);
                            if (zzy3 != null && (zzy3.zze instanceof Long)) {
                                str4 = "raw_events";
                                zzbhVar2 = zza;
                                str3 = "value";
                                str5 = "_err";
                                zzqdVar = new zzqd(str16, zza.zzc, concat, zzaU().currentTimeMillis(), Long.valueOf(((Long) zzy3.zze).longValue() + longValue));
                                zzqdVar2 = zzqdVar;
                                if (!zzj().zzai(zzqdVar2)) {
                                    zzaW().zze().zzd("Too many unique user properties are set. Ignoring user property. appId", zzhe.zzn(str16), this.zzn.zzj().zzf(zzqdVar2.zzc), zzqdVar2.zze);
                                    zzB().zzR(this.zzK, str16, 9, null, null, 0);
                                }
                                String str202 = zzbhVar2.zza;
                                boolean zzaq2 = zzqf.zzaq(str202);
                                boolean equals2 = str5.equals(str202);
                                zzB();
                                zzbfVar = zzbhVar2.zzb;
                                if (zzbfVar == null) {
                                }
                                zzbh zzbhVar32 = zzbhVar2;
                                zzas zzp2 = zzj().zzp(zza(), str16, j + 1, true, zzaq2, false, equals2, false, false, false);
                                long j52 = zzp2.zzb;
                                zzi();
                                zzH = j52 - zzam.zzH();
                                if (zzH > 0) {
                                }
                            }
                            str3 = "value";
                            str4 = "raw_events";
                            zzbhVar2 = zza;
                            str5 = "_err";
                            zzaw zzj5 = zzj();
                            int zzh = zzi().zzh(str16, zzgi.zzS) - 1;
                            Preconditions.checkNotEmpty(str16);
                            zzj5.zzg();
                            zzj5.zzav();
                            zzj5.zzj().execSQL("delete from user_attributes where app_id=? and name in (select name from user_attributes where app_id=? and name like '!_ltv!_%' escape '!'order by set_timestamp desc limit ?,10);", new String[]{str16, str16, String.valueOf(zzh)});
                            zzqdVar = new zzqd(str16, zzbhVar2.zzc, concat, zzaU().currentTimeMillis(), Long.valueOf(longValue));
                            zzqdVar2 = zzqdVar;
                            if (!zzj().zzai(zzqdVar2)) {
                            }
                            String str2022 = zzbhVar2.zza;
                            boolean zzaq22 = zzqf.zzaq(str2022);
                            boolean equals22 = str5.equals(str2022);
                            zzB();
                            zzbfVar = zzbhVar2.zzb;
                            if (zzbfVar == null) {
                            }
                            zzbh zzbhVar322 = zzbhVar2;
                            zzas zzp22 = zzj().zzp(zza(), str16, j + 1, true, zzaq22, false, equals22, false, false, false);
                            long j522 = zzp22.zzb;
                            zzi();
                            zzH = j522 - zzam.zzH();
                            if (zzH > 0) {
                            }
                        }
                    }
                    str3 = "value";
                    str4 = "raw_events";
                    zzbhVar2 = zza;
                    str5 = "_err";
                    String str20222 = zzbhVar2.zza;
                    boolean zzaq222 = zzqf.zzaq(str20222);
                    boolean equals222 = str5.equals(str20222);
                    zzB();
                    zzbfVar = zzbhVar2.zzb;
                    if (zzbfVar == null) {
                    }
                    zzbh zzbhVar3222 = zzbhVar2;
                    zzas zzp222 = zzj().zzp(zza(), str16, j + 1, true, zzaq222, false, equals222, false, false, false);
                    long j5222 = zzp222.zzb;
                    zzi();
                    zzH = j5222 - zzam.zzH();
                    if (zzH > 0) {
                    }
                }
                z = true;
                if (!"_iap".equals(str19)) {
                }
                zzbf zzbfVar22 = zza.zzb;
                zzg = zzbfVar22.zzg(FirebaseAnalytics.Param.CURRENCY);
                if (z) {
                }
                if (!TextUtils.isEmpty(zzg)) {
                }
                str3 = "value";
                str4 = "raw_events";
                zzbhVar2 = zza;
                str5 = "_err";
                String str202222 = zzbhVar2.zza;
                boolean zzaq2222 = zzqf.zzaq(str202222);
                boolean equals2222 = str5.equals(str202222);
                zzB();
                zzbfVar = zzbhVar2.zzb;
                if (zzbfVar == null) {
                }
                zzbh zzbhVar32222 = zzbhVar2;
                zzas zzp2222 = zzj().zzp(zza(), str16, j + 1, true, zzaq2222, false, equals2222, false, false, false);
                long j52222 = zzp2222.zzb;
                zzi();
                zzH = j52222 - zzam.zzH();
                if (zzH > 0) {
                }
            } finally {
                zzj().zzL();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzay(String str, String str2) {
        zzh zzl = zzj().zzl(str);
        if (zzl == null || !zzB().zzak(str, zzl.zzM())) {
            zzpt zzptVar = (zzpt) this.zzF.get(str2);
            if (zzptVar == null) {
                return true;
            }
            return zzptVar.zzc();
        }
        this.zzF.remove(str2);
        return true;
    }

    final boolean zzaz() {
        zzaX().zzg();
        FileLock fileLock = this.zzx;
        if (fileLock == null || !fileLock.isValid()) {
            this.zze.zzu.zzf();
            File filesDir = this.zzn.zzaT().getFilesDir();
            com.google.android.gms.internal.measurement.zzbx.zza();
            int i = com.google.android.gms.internal.measurement.zzcc.zzb;
            try {
                FileChannel channel = new RandomAccessFile(new File(new File(filesDir, "google_app_measurement.db").getPath()), "rw").getChannel();
                this.zzy = channel;
                FileLock tryLock = channel.tryLock();
                this.zzx = tryLock;
                if (tryLock != null) {
                    zzaW().zzj().zza("Storage concurrent access okay");
                    return true;
                }
                zzaW().zze().zza("Storage concurrent data access panic");
                return false;
            } catch (FileNotFoundException e) {
                zzaW().zze().zzb("Failed to acquire storage lock", e);
                return false;
            } catch (IOException e2) {
                zzaW().zze().zzb("Failed to access storage lock file", e2);
                return false;
            } catch (OverlappingFileLockException e3) {
                zzaW().zzk().zzb("Storage lock already acquired", e3);
                return false;
            }
        }
        zzaW().zzj().zza("Storage concurrent access okay");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public final Bundle zzd(String str) {
        int i;
        String str2;
        zzaX().zzg();
        zzM();
        if (zzr().zzi(str) == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        zzjx zzu = zzu(str);
        bundle.putAll(zzu.zzc());
        bundle.putAll(zzl(str, zzm(str), zzu, new zzao()).zzb());
        zzqd zzy = zzj().zzy(str, "_npa");
        if (zzy != null) {
            i = zzy.zze.equals(1L);
        } else {
            i = zzaC(str, new zzao());
        }
        if (1 != i) {
            str2 = "granted";
        } else {
            str2 = "denied";
        }
        bundle.putString("ad_personalization", str2);
        return bundle;
    }

    final Bundle zzf(String str, zzbh zzbhVar) {
        Bundle bundle = new Bundle();
        bundle.putLong("_sid", zzbhVar.zzb.zze("_sid").longValue());
        zzqd zzy = zzj().zzy(str, "_sno");
        if (zzy != null) {
            Object obj = zzy.zze;
            if (obj instanceof Long) {
                bundle.putLong("_sno", ((Long) obj).longValue());
            }
        }
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x01ed, code lost:
    
        if (r11 != false) goto L80;
     */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x01e2  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x01ed  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x01f0  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x019c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final zzh zzg(zzr zzrVar) {
        String str;
        boolean z;
        String str2;
        long j;
        String str3;
        String str4;
        String str5;
        zzaX().zzg();
        zzM();
        Preconditions.checkNotNull(zzrVar);
        String str6 = zzrVar.zza;
        Preconditions.checkNotEmpty(str6);
        String str7 = zzrVar.zzv;
        zzpu zzpuVar = null;
        if (!str7.isEmpty()) {
            this.zzE.put(str6, new zzps(this, str7));
        }
        zzh zzl = zzj().zzl(str6);
        zzjx zzl2 = zzu(str6).zzl(zzjx.zzk(zzrVar.zzu, 100));
        zzjw zzjwVar = zzjw.AD_STORAGE;
        if (zzl2.zzr(zzjwVar)) {
            str = this.zzk.zzf(str6, zzrVar.zzn);
        } else {
            str = "";
        }
        boolean z2 = true;
        if (zzl == null) {
            zzh zzhVar = new zzh(this.zzn, str6);
            if (zzl2.zzr(zzjw.ANALYTICS_STORAGE)) {
                zzhVar.zzV(zzC(zzl2));
            }
            if (zzl2.zzr(zzjwVar)) {
                zzhVar.zzax(str);
            }
            zzl = zzhVar;
        } else if (!zzl2.zzr(zzjwVar) || str == null || str.equals(zzl.zzJ())) {
            if (TextUtils.isEmpty(zzl.zzD()) && zzl2.zzr(zzjw.ANALYTICS_STORAGE)) {
                zzl.zzV(zzC(zzl2));
            }
        } else {
            boolean isEmpty = TextUtils.isEmpty(zzl.zzJ());
            zzl.zzax(str);
            if (!zzrVar.zzn || "00000000-0000-0000-0000-000000000000".equals(this.zzk.zzd(str6, zzl2).first) || isEmpty) {
                if (TextUtils.isEmpty(zzl.zzD()) && zzl2.zzr(zzjw.ANALYTICS_STORAGE)) {
                    zzl.zzV(zzC(zzl2));
                }
            } else {
                if (zzl2.zzr(zzjw.ANALYTICS_STORAGE)) {
                    zzl.zzV(zzC(zzl2));
                    z = false;
                } else {
                    z = true;
                }
                if (zzj().zzy(str6, "_id") != null && zzj().zzy(str6, "_lair") == null) {
                    zzj().zzai(new zzqd(str6, "auto", "_lair", zzaU().currentTimeMillis(), 1L));
                }
                zzl.zzao(zzrVar.zzb);
                zzl.zzS(zzrVar.zzp);
                str2 = zzrVar.zzk;
                if (!TextUtils.isEmpty(str2)) {
                    zzl.zzan(str2);
                }
                j = zzrVar.zze;
                if (j != 0) {
                    zzl.zzap(j);
                }
                str3 = zzrVar.zzc;
                if (!TextUtils.isEmpty(str3)) {
                    zzl.zzX(str3);
                }
                zzl.zzY(zzrVar.zzj);
                str4 = zzrVar.zzd;
                if (str4 != null) {
                    zzl.zzW(str4);
                }
                zzl.zzaj(zzrVar.zzf);
                zzl.zzav(zzrVar.zzh);
                str5 = zzrVar.zzg;
                if (!TextUtils.isEmpty(str5)) {
                    zzl.zzaq(str5);
                }
                zzl.zzU(zzrVar.zzn);
                zzl.zzaw(zzrVar.zzq);
                zzl.zzal(zzrVar.zzr);
                zzl.zzaA(zzrVar.zzw);
                com.google.android.gms.internal.measurement.zzpn.zzb();
                if (zzi().zzx(null, zzgi.zzaK)) {
                    com.google.android.gms.internal.measurement.zzpn.zzb();
                    if (zzi().zzx(null, zzgi.zzaJ)) {
                        zzl.zzay(null);
                    }
                } else {
                    zzl.zzay(zzrVar.zzs);
                }
                zzl.zzaD(zzrVar.zzx);
                zzl.zzaC(zzrVar.zzD);
                zzqr.zzb();
                if (zzi().zzx(null, zzgi.zzaV)) {
                    zzl.zzT(zzrVar.zzB);
                }
                zzl.zzaE(zzrVar.zzy);
                zzl.zzaz(zzrVar.zzE);
                if (zzi().zzx(null, zzgi.zzaP)) {
                    zzl.zzaa(zzrVar.zzG);
                }
                if (!zzl.zzaK()) {
                    z2 = z;
                }
                zzj().zzT(zzl, z2, false);
                return zzl;
            }
        }
        z = false;
        zzl.zzao(zzrVar.zzb);
        zzl.zzS(zzrVar.zzp);
        str2 = zzrVar.zzk;
        if (!TextUtils.isEmpty(str2)) {
        }
        j = zzrVar.zze;
        if (j != 0) {
        }
        str3 = zzrVar.zzc;
        if (!TextUtils.isEmpty(str3)) {
        }
        zzl.zzY(zzrVar.zzj);
        str4 = zzrVar.zzd;
        if (str4 != null) {
        }
        zzl.zzaj(zzrVar.zzf);
        zzl.zzav(zzrVar.zzh);
        str5 = zzrVar.zzg;
        if (!TextUtils.isEmpty(str5)) {
        }
        zzl.zzU(zzrVar.zzn);
        zzl.zzaw(zzrVar.zzq);
        zzl.zzal(zzrVar.zzr);
        zzl.zzaA(zzrVar.zzw);
        com.google.android.gms.internal.measurement.zzpn.zzb();
        if (zzi().zzx(null, zzgi.zzaK)) {
        }
        zzl.zzaD(zzrVar.zzx);
        zzl.zzaC(zzrVar.zzD);
        zzqr.zzb();
        if (zzi().zzx(null, zzgi.zzaV)) {
        }
        zzl.zzaE(zzrVar.zzy);
        zzl.zzaz(zzrVar.zzE);
        if (zzi().zzx(null, zzgi.zzaP)) {
        }
        if (!zzl.zzaK()) {
        }
        zzj().zzT(zzl, z2, false);
        return zzl;
    }

    public final zzae zzh() {
        zzae zzaeVar = this.zzh;
        zzaR(zzaeVar);
        return zzaeVar;
    }

    public final zzam zzi() {
        return ((zzio) Preconditions.checkNotNull(this.zzn)).zzf();
    }

    public final zzaw zzj() {
        zzaw zzawVar = this.zze;
        zzaR(zzawVar);
        return zzawVar;
    }

    final zzba zzl(String str, zzba zzbaVar, zzjx zzjxVar, zzao zzaoVar) {
        zzju zzjuVar;
        zzju zzf;
        int i = 90;
        if (zzr().zzi(str) == null) {
            if (zzbaVar.zzf() == zzju.DENIED) {
                i = zzbaVar.zza();
                zzaoVar.zzc(zzjw.AD_USER_DATA, i);
            } else {
                zzaoVar.zzd(zzjw.AD_USER_DATA, zzan.FAILSAFE);
            }
            return new zzba((Boolean) false, i, (Boolean) true, "-");
        }
        zzju zzf2 = zzbaVar.zzf();
        if (zzf2 == zzju.GRANTED || zzf2 == (zzjuVar = zzju.DENIED)) {
            i = zzbaVar.zza();
            zzaoVar.zzc(zzjw.AD_USER_DATA, i);
        } else if (zzf2 != zzju.POLICY || (zzf = this.zzc.zzf(str, zzjw.AD_USER_DATA)) == zzju.UNINITIALIZED) {
            zzif zzifVar = this.zzc;
            zzjw zzh = zzifVar.zzh(str, zzjw.AD_USER_DATA);
            zzju zze = zzjxVar.zze();
            zzju zzjuVar2 = zzju.GRANTED;
            boolean z = zze == zzjuVar2 || zze == zzjuVar;
            if (zzh != zzjw.AD_STORAGE || !z) {
                zzjw zzjwVar = zzjw.AD_USER_DATA;
                zzaoVar.zzd(zzjwVar, zzan.REMOTE_DEFAULT);
                zzf2 = true != zzifVar.zzu(str, zzjwVar) ? zzjuVar : zzjuVar2;
            } else {
                zzaoVar.zzd(zzjw.AD_USER_DATA, zzan.REMOTE_DELEGATION);
                zzf2 = zze;
            }
        } else {
            zzaoVar.zzd(zzjw.AD_USER_DATA, zzan.REMOTE_ENFORCED_DEFAULT);
            zzf2 = zzf;
        }
        boolean zzv = this.zzc.zzv(str);
        SortedSet zzp = zzr().zzp(str);
        if (zzf2 == zzju.DENIED || zzp.isEmpty()) {
            return new zzba((Boolean) false, i, Boolean.valueOf(zzv), "-");
        }
        return new zzba((Boolean) true, i, Boolean.valueOf(zzv), zzv ? TextUtils.join("", zzp) : "");
    }

    final zzba zzm(String str) {
        zzaX().zzg();
        zzM();
        Map map = this.zzD;
        zzba zzbaVar = (zzba) map.get(str);
        if (zzbaVar != null) {
            return zzbaVar;
        }
        zzba zzq = zzj().zzq(str);
        map.put(str, zzq);
        return zzq;
    }

    public final zzgx zzo() {
        return this.zzn.zzj();
    }

    public final zzhk zzp() {
        zzhk zzhkVar = this.zzd;
        zzaR(zzhkVar);
        return zzhkVar;
    }

    public final zzhm zzq() {
        zzhm zzhmVar = this.zzf;
        if (zzhmVar != null) {
            return zzhmVar;
        }
        throw new IllegalStateException("Network broadcast receiver not created");
    }

    public final zzif zzr() {
        zzif zzifVar = this.zzc;
        zzaR(zzifVar);
        return zzifVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzio zzt() {
        return this.zzn;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzjx zzu(String str) {
        zzjx zzjxVar = zzjx.zza;
        zzaX().zzg();
        zzM();
        zzjx zzjxVar2 = (zzjx) this.zzC.get(str);
        if (zzjxVar2 == null) {
            zzjxVar2 = zzj().zzu(str);
            if (zzjxVar2 == null) {
                zzjxVar2 = zzjx.zza;
            }
            zzaq(str, zzjxVar2);
        }
        return zzjxVar2;
    }

    public final zzmc zzv() {
        zzmc zzmcVar = this.zzj;
        zzaR(zzmcVar);
        return zzmcVar;
    }

    public final zzoa zzw() {
        return this.zzk;
    }

    public final zzoy zzx() {
        zzoy zzoyVar = this.zzg;
        zzaR(zzoyVar);
        return zzoyVar;
    }

    public final zzpi zzy() {
        return this.zzl;
    }
}
