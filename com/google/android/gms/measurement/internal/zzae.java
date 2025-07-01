package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.util.Log;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.internal.Preconditions;
import java.io.IOException;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement@@22.4.0 */
/* loaded from: classes3.dex */
public final class zzae extends zzpg {
    private String zza;
    private Set zzb;
    private Map zzc;
    private Long zzd;
    private Long zze;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzae(zzpv zzpvVar) {
        super(zzpvVar);
    }

    private final zzy zzd(Integer num) {
        if (this.zzc.containsKey(num)) {
            return (zzy) this.zzc.get(num);
        }
        zzy zzyVar = new zzy(this, this.zza, null);
        this.zzc.put(num, zzyVar);
        return zzyVar;
    }

    private final boolean zzf(int i, int i2) {
        zzy zzyVar = (zzy) this.zzc.get(Integer.valueOf(i));
        if (zzyVar == null) {
            return false;
        }
        return zzy.zzb(zzyVar).get(i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Can't wrap try/catch for region: R(10:(6:19|20|21|22|23|(15:(7:25|26|27|28|(1:30)(3:504|(1:506)(1:508)|507)|31|(1:34)(1:33))|(1:36)|37|38|39|40|41|42|(3:44|(1:46)|47)(4:462|(6:463|464|465|466|467|(1:470)(1:469))|(1:472)|473)|48|(1:50)(6:293|(7:295|296|297|298|299|(1:447)|(3:301|(1:303)|304))(1:461)|313|(10:316|(3:320|(4:323|(5:325|326|(1:328)(1:332)|329|330)(1:333)|331|321)|334)|335|(3:339|(4:342|(3:347|348|349)|350|340)|353)|354|(3:356|(6:359|(2:361|(3:363|364|365))(1:368)|366|367|365|357)|369)|370|(3:379|(8:382|(1:384)|385|(1:387)|388|(3:390|391|392)(1:394)|393|380)|395)|396|314)|402|403)|51|(3:188|(4:191|(3:193|194|(8:196|197|(12:199|200|201|202|203|204|205|206|207|208|(4:210|(11:211|212|213|214|215|216|217|(3:219|220|221)(1:264)|222|223|(1:226)(1:225))|(1:228)|229)(2:270|271)|230)(1:289)|231|(4:234|(3:252|253|254)(6:236|237|(2:238|(2:240|(1:242)(2:243|244))(2:250|251))|(1:246)|247|248)|249|232)|255|256|257)(1:290))(1:291)|258|189)|292)|53|(7:55|(3:82|(6:85|(9:87|88|89|90|91|92|93|(3:(9:95|96|97|98|99|(1:101)(1:160)|102|103|(1:106)(1:105))|(1:108)|109)(2:167|168)|110)(1:184)|111|(2:112|(2:114|(3:150|151|152)(8:116|(2:117|(4:119|(3:121|(1:123)(1:146)|124)(1:147)|125|(1:1)(2:129|(1:131)(2:132|133)))(2:148|149))|140|(1:142)(1:144)|143|135|136|137))(0))|153|83)|185)|57|58|(9:61|62|63|64|65|66|(2:68|69)(1:71)|70|59)|79|80)(2:186|187))(1:512))|41|42|(0)(0)|48|(0)(0)|51|(0)|53|(0)(0)) */
    /* JADX WARN: Can't wrap try/catch for region: R(20:1|(2:2|(2:4|(2:6|7)(1:528))(2:529|530))|8|(3:10|11|12)|16|(6:19|20|21|22|23|(15:(7:25|26|27|28|(1:30)(3:504|(1:506)(1:508)|507)|31|(1:34)(1:33))|(1:36)|37|38|39|40|41|42|(3:44|(1:46)|47)(4:462|(6:463|464|465|466|467|(1:470)(1:469))|(1:472)|473)|48|(1:50)(6:293|(7:295|296|297|298|299|(1:447)|(3:301|(1:303)|304))(1:461)|313|(10:316|(3:320|(4:323|(5:325|326|(1:328)(1:332)|329|330)(1:333)|331|321)|334)|335|(3:339|(4:342|(3:347|348|349)|350|340)|353)|354|(3:356|(6:359|(2:361|(3:363|364|365))(1:368)|366|367|365|357)|369)|370|(3:379|(8:382|(1:384)|385|(1:387)|388|(3:390|391|392)(1:394)|393|380)|395)|396|314)|402|403)|51|(3:188|(4:191|(3:193|194|(8:196|197|(12:199|200|201|202|203|204|205|206|207|208|(4:210|(11:211|212|213|214|215|216|217|(3:219|220|221)(1:264)|222|223|(1:226)(1:225))|(1:228)|229)(2:270|271)|230)(1:289)|231|(4:234|(3:252|253|254)(6:236|237|(2:238|(2:240|(1:242)(2:243|244))(2:250|251))|(1:246)|247|248)|249|232)|255|256|257)(1:290))(1:291)|258|189)|292)|53|(7:55|(3:82|(6:85|(9:87|88|89|90|91|92|93|(3:(9:95|96|97|98|99|(1:101)(1:160)|102|103|(1:106)(1:105))|(1:108)|109)(2:167|168)|110)(1:184)|111|(2:112|(2:114|(3:150|151|152)(8:116|(2:117|(4:119|(3:121|(1:123)(1:146)|124)(1:147)|125|(1:1)(2:129|(1:131)(2:132|133)))(2:148|149))|140|(1:142)(1:144)|143|135|136|137))(0))|153|83)|185)|57|58|(9:61|62|63|64|65|66|(2:68|69)(1:71)|70|59)|79|80)(2:186|187))(1:512))|527|38|39|40|41|42|(0)(0)|48|(0)(0)|51|(0)|53|(0)(0)|(5:(0)|(0)|(0)|(0)|(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:134:0x09ab, code lost:
    
        if (r13 != false) goto L492;
     */
    /* JADX WARN: Code restructure failed: missing block: B:158:0x088d, code lost:
    
        if (r13 == null) goto L369;
     */
    /* JADX WARN: Code restructure failed: missing block: B:159:0x085f, code lost:
    
        r13.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:169:0x085d, code lost:
    
        if (r13 != null) goto L354;
     */
    /* JADX WARN: Code restructure failed: missing block: B:262:0x06e8, code lost:
    
        if (r5 != null) goto L275;
     */
    /* JADX WARN: Code restructure failed: missing block: B:263:0x06b0, code lost:
    
        r5.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:272:0x06ae, code lost:
    
        if (r5 != null) goto L275;
     */
    /* JADX WARN: Code restructure failed: missing block: B:307:0x02bd, code lost:
    
        if (r5 != null) goto L113;
     */
    /* JADX WARN: Code restructure failed: missing block: B:308:0x02bf, code lost:
    
        r5.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:309:0x02ef, code lost:
    
        com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r1);
        com.google.android.gms.common.internal.Preconditions.checkNotNull(r13);
        r1 = new androidx.collection.ArrayMap();
     */
    /* JADX WARN: Code restructure failed: missing block: B:310:0x02fe, code lost:
    
        if (r13.isEmpty() == false) goto L131;
     */
    /* JADX WARN: Code restructure failed: missing block: B:311:0x0300, code lost:
    
        r22 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:312:0x03f6, code lost:
    
        r0 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:404:0x0304, code lost:
    
        r3 = r13.keySet().iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:406:0x0310, code lost:
    
        if (r3.hasNext() == false) goto L542;
     */
    /* JADX WARN: Code restructure failed: missing block: B:407:0x0312, code lost:
    
        r4 = (java.lang.Integer) r3.next();
        r4.intValue();
        r5 = (com.google.android.gms.internal.measurement.zzic) r13.get(r4);
        r6 = (java.util.List) r0.get(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:408:0x0327, code lost:
    
        if (r6 == null) goto L544;
     */
    /* JADX WARN: Code restructure failed: missing block: B:410:0x032d, code lost:
    
        if (r6.isEmpty() == false) goto L139;
     */
    /* JADX WARN: Code restructure failed: missing block: B:411:0x0331, code lost:
    
        r7 = r30.zzg;
        r16 = r0;
        r17 = r3;
        r0 = r7.zzA().zzt(r5.zzi(), r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:412:0x0347, code lost:
    
        if (r0.isEmpty() != false) goto L541;
     */
    /* JADX WARN: Code restructure failed: missing block: B:414:0x03df, code lost:
    
        r0 = r16;
        r3 = r17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:418:0x0349, code lost:
    
        r3 = (com.google.android.gms.internal.measurement.zzib) r5.zzch();
        r3.zzf();
        r3.zzb(r0);
        r0 = r7.zzA().zzt(r5.zzk(), r6);
        r3.zzh();
        r3.zzd(r0);
        r0 = new java.util.ArrayList();
        r7 = r5.zzh().iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:420:0x0378, code lost:
    
        if (r7.hasNext() == false) goto L549;
     */
    /* JADX WARN: Code restructure failed: missing block: B:421:0x037a, code lost:
    
        r21 = r7;
        r7 = (com.google.android.gms.internal.measurement.zzhk) r7.next();
        r22 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:422:0x0392, code lost:
    
        if (r6.contains(java.lang.Integer.valueOf(r7.zza())) != false) goto L551;
     */
    /* JADX WARN: Code restructure failed: missing block: B:423:0x0394, code lost:
    
        r0.add(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:425:0x0397, code lost:
    
        r7 = r21;
        r8 = r22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:428:0x039c, code lost:
    
        r22 = r8;
        r3.zze();
        r3.zza(r0);
        r0 = new java.util.ArrayList();
        r5 = r5.zzj().iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:430:0x03b5, code lost:
    
        if (r5.hasNext() == false) goto L552;
     */
    /* JADX WARN: Code restructure failed: missing block: B:431:0x03b7, code lost:
    
        r7 = (com.google.android.gms.internal.measurement.zzie) r5.next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:432:0x03c9, code lost:
    
        if (r6.contains(java.lang.Integer.valueOf(r7.zzb())) != false) goto L555;
     */
    /* JADX WARN: Code restructure failed: missing block: B:434:0x03cb, code lost:
    
        r0.add(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:439:0x03cf, code lost:
    
        r3.zzg();
        r3.zzc(r0);
        r1.put(r4, (com.google.android.gms.internal.measurement.zzic) r3.zzba());
     */
    /* JADX WARN: Code restructure failed: missing block: B:440:0x03ee, code lost:
    
        r0 = r16;
        r3 = r17;
        r8 = r22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:443:0x03e5, code lost:
    
        r16 = r0;
        r17 = r3;
        r22 = r8;
        r1.put(r4, r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:448:0x02c7, code lost:
    
        if (r5 != null) goto L113;
     */
    /* JADX WARN: Code restructure failed: missing block: B:451:0x02ec, code lost:
    
        if (r5 == null) goto L128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:492:0x0220, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:493:0x0221, code lost:
    
        r18 = "audience_id";
     */
    /* JADX WARN: Code restructure failed: missing block: B:500:0x022a, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:501:0x022b, code lost:
    
        r18 = "audience_id";
        r19 = "data";
        r4 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:502:0x0226, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:503:0x0227, code lost:
    
        r5 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:513:0x014d, code lost:
    
        if (r5 != null) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:514:0x014f, code lost:
    
        r5.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:517:0x0171, code lost:
    
        if (r5 == null) goto L58;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:186:0x0a66  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x05b6  */
    /* JADX WARN: Removed duplicated region for block: B:293:0x025b  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x01ac A[Catch: SQLiteException -> 0x0220, all -> 0x0a6c, TRY_LEAVE, TryCatch #6 {SQLiteException -> 0x0220, blocks: (B:42:0x01a6, B:44:0x01ac, B:462:0x01bc, B:463:0x01c1, B:465:0x01cb, B:466:0x01db, B:482:0x01ea), top: B:41:0x01a6 }] */
    /* JADX WARN: Removed duplicated region for block: B:455:0x03fa  */
    /* JADX WARN: Removed duplicated region for block: B:462:0x01bc A[Catch: SQLiteException -> 0x0220, all -> 0x0a6c, TRY_ENTER, TryCatch #6 {SQLiteException -> 0x0220, blocks: (B:42:0x01a6, B:44:0x01ac, B:462:0x01bc, B:463:0x01c1, B:465:0x01cb, B:466:0x01db, B:482:0x01ea), top: B:41:0x01a6 }] */
    /* JADX WARN: Removed duplicated region for block: B:478:0x0249  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0253  */
    /* JADX WARN: Removed duplicated region for block: B:521:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0791  */
    /* JADX WARN: Type inference failed for: r0v189, types: [android.content.ContentValues] */
    /* JADX WARN: Type inference failed for: r13v1 */
    /* JADX WARN: Type inference failed for: r13v2, types: [java.util.Map, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r13v30 */
    /* JADX WARN: Type inference failed for: r13v33 */
    /* JADX WARN: Type inference failed for: r4v26, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARN: Type inference failed for: r5v49, types: [java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r5v5, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARN: Type inference failed for: r5v50 */
    /* JADX WARN: Type inference failed for: r5v51, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v8, types: [android.database.Cursor] */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 4 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final List zza(String str, List list, List list2, Long l, Long l2, boolean z) {
        int i;
        int i2;
        boolean z2;
        Cursor cursor;
        Map map;
        String str2;
        String str3;
        Cursor cursor2;
        ?? r13;
        String str4;
        ArrayMap arrayMap;
        String str5;
        String str6;
        String str7;
        String str8;
        List<com.google.android.gms.internal.measurement.zzfj> list3;
        String str9;
        Cursor cursor3;
        Iterator it;
        zzbd zzbdVar;
        String str10;
        Map map2;
        Cursor cursor4;
        List list4;
        Iterator it2;
        String str11;
        String str12;
        Map map3;
        String str13;
        com.google.android.gms.internal.measurement.zzfr zzfrVar;
        zzio zzioVar;
        Integer num;
        Cursor cursor5;
        Cursor cursor6;
        List list5;
        ArrayMap arrayMap2;
        Cursor cursor7;
        List list6;
        String str14 = "current_results";
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(list);
        Preconditions.checkNotNull(list2);
        this.zza = str;
        this.zzb = new HashSet();
        this.zzc = new ArrayMap();
        this.zzd = l;
        this.zze = l2;
        Iterator it3 = list.iterator();
        while (true) {
            i = 0;
            i2 = 1;
            if (!it3.hasNext()) {
                z2 = false;
                break;
            }
            if ("_s".equals(((com.google.android.gms.internal.measurement.zzhm) it3.next()).zzh())) {
                z2 = true;
                break;
            }
        }
        com.google.android.gms.internal.measurement.zzpq.zzb();
        zzio zzioVar2 = this.zzu;
        boolean zzx = zzioVar2.zzf().zzx(this.zza, zzgi.zzaE);
        com.google.android.gms.internal.measurement.zzpq.zzb();
        boolean zzx2 = zzioVar2.zzf().zzx(this.zza, zzgi.zzaD);
        if (z2) {
            zzaw zzj = this.zzg.zzj();
            String str15 = this.zza;
            zzj.zzav();
            zzj.zzg();
            Preconditions.checkNotEmpty(str15);
            ?? contentValues = new ContentValues();
            ?? r5 = 0;
            contentValues.put("current_session_count", r5);
            try {
                r5 = "events";
                zzj.zzj().update("events", contentValues, "app_id = ?", new String[]{str15});
                cursor = "events";
            } catch (SQLiteException e) {
                zzj.zzu.zzaW().zze().zzc("Error resetting session-scoped event counts. appId", zzhe.zzn(str15), e);
                cursor = r5;
            }
        }
        Map emptyMap = Collections.emptyMap();
        String str16 = "Failed to merge filter. appId";
        String str17 = "Database error querying filters. appId";
        String str18 = "data";
        String str19 = "audience_id";
        try {
            if (zzx2 && zzx) {
                zzaw zzj2 = this.zzg.zzj();
                String str20 = this.zza;
                Preconditions.checkNotEmpty(str20);
                ArrayMap arrayMap3 = new ArrayMap();
                try {
                    try {
                        cursor7 = zzj2.zzj().query("event_filters", new String[]{"audience_id", "data"}, "app_id=?", new String[]{str20}, null, null, null);
                        try {
                        } catch (SQLiteException e2) {
                            e = e2;
                            zzj2.zzu.zzaW().zze().zzc("Database error querying filters. appId", zzhe.zzn(str20), e);
                            emptyMap = Collections.emptyMap();
                        }
                    } catch (Throwable th) {
                        th = th;
                        if (cursor != null) {
                            cursor.close();
                        }
                        throw th;
                    }
                } catch (SQLiteException e3) {
                    e = e3;
                    cursor7 = null;
                } catch (Throwable th2) {
                    th = th2;
                    cursor = null;
                    if (cursor != null) {
                    }
                    throw th;
                }
                if (cursor7.moveToFirst()) {
                    while (true) {
                        try {
                            com.google.android.gms.internal.measurement.zzfj zzfjVar = (com.google.android.gms.internal.measurement.zzfj) ((com.google.android.gms.internal.measurement.zzfi) zzqa.zzp(com.google.android.gms.internal.measurement.zzfj.zzc(), cursor7.getBlob(i2))).zzba();
                            if (zzfjVar.zzo()) {
                                Integer valueOf = Integer.valueOf(cursor7.getInt(i));
                                List list7 = (List) arrayMap3.get(valueOf);
                                if (list7 == null) {
                                    list6 = new ArrayList();
                                    arrayMap3.put(valueOf, list6);
                                } else {
                                    list6 = list7;
                                }
                                list6.add(zzfjVar);
                            }
                        } catch (IOException e4) {
                            zzj2.zzu.zzaW().zze().zzc("Failed to merge filter. appId", zzhe.zzn(str20), e4);
                        }
                        if (!cursor7.moveToNext()) {
                            break;
                        }
                        i = 0;
                        i2 = 1;
                    }
                    if (cursor7 != null) {
                        cursor7.close();
                    }
                    map = arrayMap3;
                    zzaw zzj3 = this.zzg.zzj();
                    String str21 = this.zza;
                    zzj3.zzav();
                    zzj3.zzg();
                    Preconditions.checkNotEmpty(str21);
                    cursor2 = zzj3.zzj().query("audience_filter_values", new String[]{"audience_id", "current_results"}, "app_id=?", new String[]{str21}, null, null, null);
                    if (cursor2.moveToFirst()) {
                        Map emptyMap2 = Collections.emptyMap();
                        if (cursor2 != null) {
                            cursor2.close();
                        }
                        r13 = emptyMap2;
                        str2 = "audience_id";
                        str3 = "data";
                    } else {
                        ArrayMap arrayMap4 = new ArrayMap();
                        while (true) {
                            int i3 = cursor2.getInt(0);
                            try {
                                arrayMap4.put(Integer.valueOf(i3), (com.google.android.gms.internal.measurement.zzic) ((com.google.android.gms.internal.measurement.zzib) zzqa.zzp(com.google.android.gms.internal.measurement.zzic.zze(), cursor2.getBlob(1))).zzba());
                                arrayMap2 = arrayMap4;
                                str2 = str19;
                                str3 = str18;
                            } catch (IOException e5) {
                                arrayMap2 = arrayMap4;
                                str2 = str19;
                                try {
                                    str3 = str18;
                                    try {
                                        zzj3.zzu.zzaW().zze().zzd("Failed to merge filter results. appId, audienceId, error", zzhe.zzn(str21), Integer.valueOf(i3), e5);
                                    } catch (SQLiteException e6) {
                                        e = e6;
                                        zzj3.zzu.zzaW().zze().zzc("Database error querying filter results. appId", zzhe.zzn(str21), e);
                                        Map emptyMap3 = Collections.emptyMap();
                                        if (cursor2 != null) {
                                            cursor2.close();
                                        }
                                        r13 = emptyMap3;
                                        if (r13.isEmpty()) {
                                        }
                                        String str22 = "Skipping failed audience ID";
                                        if (!list.isEmpty()) {
                                        }
                                        String str23 = str14;
                                        if (!z) {
                                        }
                                    }
                                } catch (SQLiteException e7) {
                                    e = e7;
                                    str3 = str18;
                                    zzj3.zzu.zzaW().zze().zzc("Database error querying filter results. appId", zzhe.zzn(str21), e);
                                    Map emptyMap32 = Collections.emptyMap();
                                    if (cursor2 != null) {
                                    }
                                    r13 = emptyMap32;
                                    if (r13.isEmpty()) {
                                    }
                                    String str222 = "Skipping failed audience ID";
                                    if (!list.isEmpty()) {
                                    }
                                    String str232 = str14;
                                    if (!z) {
                                    }
                                }
                            }
                            if (!cursor2.moveToNext()) {
                                break;
                            }
                            arrayMap4 = arrayMap2;
                            str19 = str2;
                            str18 = str3;
                        }
                        if (cursor2 != null) {
                            cursor2.close();
                        }
                        r13 = arrayMap2;
                    }
                    if (r13.isEmpty()) {
                        HashSet<Integer> hashSet = new HashSet(r13.keySet());
                        if (z2) {
                            String str24 = this.zza;
                            zzaw zzj4 = this.zzg.zzj();
                            String str25 = this.zza;
                            zzj4.zzav();
                            zzj4.zzg();
                            Preconditions.checkNotEmpty(str25);
                            Map arrayMap5 = new ArrayMap();
                            ?? zzj5 = zzj4.zzj();
                            try {
                                try {
                                    cursor3 = zzj5.rawQuery("select audience_id, filter_id from event_filters where app_id = ? and session_scoped = 1 UNION select audience_id, filter_id from property_filters where app_id = ? and session_scoped = 1;", new String[]{str25, str25});
                                    try {
                                        if (!cursor3.moveToFirst()) {
                                            arrayMap5 = Collections.emptyMap();
                                        }
                                        do {
                                            Integer valueOf2 = Integer.valueOf(cursor3.getInt(0));
                                            List list8 = (List) arrayMap5.get(valueOf2);
                                            if (list8 == null) {
                                                list8 = new ArrayList();
                                                arrayMap5.put(valueOf2, list8);
                                            }
                                            list8.add(Integer.valueOf(cursor3.getInt(1)));
                                        } while (cursor3.moveToNext());
                                    } catch (SQLiteException e8) {
                                        e = e8;
                                        zzj4.zzu.zzaW().zze().zzc("Database error querying scoped filters. appId", zzhe.zzn(str25), e);
                                        arrayMap5 = Collections.emptyMap();
                                    }
                                } catch (Throwable th3) {
                                    th = th3;
                                    if (zzj5 != 0) {
                                        zzj5.close();
                                    }
                                    throw th;
                                }
                            } catch (SQLiteException e9) {
                                e = e9;
                                cursor3 = null;
                            } catch (Throwable th4) {
                                th = th4;
                                zzj5 = 0;
                                if (zzj5 != 0) {
                                }
                                throw th;
                            }
                        } else {
                            str4 = "Database error querying filters. appId";
                            arrayMap = r13;
                        }
                        Map map4 = r13;
                        for (Integer num2 : hashSet) {
                            num2.intValue();
                            com.google.android.gms.internal.measurement.zzic zzicVar = (com.google.android.gms.internal.measurement.zzic) arrayMap.get(num2);
                            BitSet bitSet = new BitSet();
                            BitSet bitSet2 = new BitSet();
                            ArrayMap arrayMap6 = new ArrayMap();
                            if (zzicVar != null && zzicVar.zza() != 0) {
                                for (com.google.android.gms.internal.measurement.zzhk zzhkVar : zzicVar.zzh()) {
                                    if (zzhkVar.zzh()) {
                                        arrayMap6.put(Integer.valueOf(zzhkVar.zza()), zzhkVar.zzg() ? Long.valueOf(zzhkVar.zzb()) : null);
                                    }
                                }
                            }
                            ArrayMap arrayMap7 = new ArrayMap();
                            if (zzicVar != null && zzicVar.zzc() != 0) {
                                Iterator it4 = zzicVar.zzj().iterator();
                                while (it4.hasNext()) {
                                    com.google.android.gms.internal.measurement.zzie zzieVar = (com.google.android.gms.internal.measurement.zzie) it4.next();
                                    if (zzieVar.zzi() && zzieVar.zza() > 0) {
                                        arrayMap7.put(Integer.valueOf(zzieVar.zzb()), Long.valueOf(zzieVar.zzc(zzieVar.zza() - 1)));
                                        arrayMap = arrayMap;
                                        it4 = it4;
                                    }
                                }
                            }
                            ArrayMap arrayMap8 = arrayMap;
                            if (zzicVar != null) {
                                int i4 = 0;
                                while (i4 < zzicVar.zzd() * 64) {
                                    if (zzqa.zzy(zzicVar.zzk(), i4)) {
                                        str9 = str16;
                                        this.zzu.zzaW().zzj().zzc("Filter already evaluated. audience ID, filter ID", num2, Integer.valueOf(i4));
                                        bitSet2.set(i4);
                                        if (zzqa.zzy(zzicVar.zzi(), i4)) {
                                            bitSet.set(i4);
                                            i4++;
                                            str16 = str9;
                                        }
                                    } else {
                                        str9 = str16;
                                    }
                                    arrayMap6.remove(Integer.valueOf(i4));
                                    i4++;
                                    str16 = str9;
                                }
                            }
                            String str26 = str16;
                            com.google.android.gms.internal.measurement.zzic zzicVar2 = (com.google.android.gms.internal.measurement.zzic) map4.get(num2);
                            if (zzx2 && zzx && (list3 = (List) map.get(num2)) != null && this.zze != null && this.zzd != null) {
                                for (com.google.android.gms.internal.measurement.zzfj zzfjVar2 : list3) {
                                    int zzb = zzfjVar2.zzb();
                                    long longValue = this.zze.longValue() / 1000;
                                    if (zzfjVar2.zzm()) {
                                        longValue = this.zzd.longValue() / 1000;
                                    }
                                    Integer valueOf3 = Integer.valueOf(zzb);
                                    if (arrayMap6.containsKey(valueOf3)) {
                                        arrayMap6.put(valueOf3, Long.valueOf(longValue));
                                    }
                                    if (arrayMap7.containsKey(valueOf3)) {
                                        arrayMap7.put(valueOf3, Long.valueOf(longValue));
                                    }
                                }
                            }
                            this.zzc.put(num2, new zzy(this, this.zza, zzicVar2, bitSet, bitSet2, arrayMap6, arrayMap7, null));
                            map4 = map4;
                            str16 = str26;
                            zzx = zzx;
                            map = map;
                            arrayMap = arrayMap8;
                            str2 = str2;
                        }
                        str5 = str16;
                        str6 = str2;
                        str7 = str3;
                        str8 = str4;
                    } else {
                        str8 = "Database error querying filters. appId";
                        str5 = "Failed to merge filter. appId";
                        str6 = str2;
                        str7 = str3;
                    }
                    String str2222 = "Skipping failed audience ID";
                    if (!list.isEmpty()) {
                        zzz zzzVar = new zzz(this, null);
                        ArrayMap arrayMap9 = new ArrayMap();
                        Iterator it5 = list.iterator();
                        while (it5.hasNext()) {
                            com.google.android.gms.internal.measurement.zzhm zzhmVar = (com.google.android.gms.internal.measurement.zzhm) it5.next();
                            com.google.android.gms.internal.measurement.zzhm zza = zzzVar.zza(this.zza, zzhmVar);
                            if (zza != null) {
                                zzpv zzpvVar = this.zzg;
                                zzbd zzr = zzpvVar.zzj().zzr(this.zza, zzhmVar, zza.zzh());
                                zzpvVar.zzj().zzV(zzr);
                                if (!z) {
                                    zzz zzzVar2 = zzzVar;
                                    long j = zzr.zzc;
                                    String zzh = zza.zzh();
                                    Map map5 = (Map) arrayMap9.get(zzh);
                                    if (map5 == null) {
                                        zzaw zzj6 = zzpvVar.zzj();
                                        String str27 = this.zza;
                                        zzj6.zzav();
                                        zzj6.zzg();
                                        Preconditions.checkNotEmpty(str27);
                                        Preconditions.checkNotEmpty(zzh);
                                        ArrayMap arrayMap10 = new ArrayMap();
                                        it = it5;
                                        str10 = str14;
                                        String str28 = str6;
                                        String str29 = str7;
                                        try {
                                            try {
                                                str7 = str29;
                                            } catch (Throwable th5) {
                                                th = th5;
                                                cursor4 = null;
                                            }
                                        } catch (SQLiteException e10) {
                                            e = e10;
                                            str7 = str29;
                                        }
                                        try {
                                            cursor4 = zzj6.zzj().query("event_filters", new String[]{str28, str29}, "app_id=? AND event_name=?", new String[]{str27, zzh}, null, null, null);
                                            try {
                                                try {
                                                    if (cursor4.moveToFirst()) {
                                                        str6 = str28;
                                                        while (true) {
                                                            try {
                                                                try {
                                                                    com.google.android.gms.internal.measurement.zzfj zzfjVar3 = (com.google.android.gms.internal.measurement.zzfj) ((com.google.android.gms.internal.measurement.zzfi) zzqa.zzp(com.google.android.gms.internal.measurement.zzfj.zzc(), cursor4.getBlob(1))).zzba();
                                                                    Integer valueOf4 = Integer.valueOf(cursor4.getInt(0));
                                                                    List list9 = (List) arrayMap10.get(valueOf4);
                                                                    if (list9 == null) {
                                                                        zzbdVar = zzr;
                                                                        try {
                                                                            list4 = new ArrayList();
                                                                            arrayMap10.put(valueOf4, list4);
                                                                        } catch (SQLiteException e11) {
                                                                            e = e11;
                                                                            zzj6.zzu.zzaW().zze().zzc(str8, zzhe.zzn(str27), e);
                                                                            map5 = Collections.emptyMap();
                                                                        }
                                                                    } else {
                                                                        zzbdVar = zzr;
                                                                        list4 = list9;
                                                                    }
                                                                    list4.add(zzfjVar3);
                                                                } catch (IOException e12) {
                                                                    zzbdVar = zzr;
                                                                    zzj6.zzu.zzaW().zze().zzc(str5, zzhe.zzn(str27), e12);
                                                                }
                                                                if (!cursor4.moveToNext()) {
                                                                    break;
                                                                }
                                                                zzr = zzbdVar;
                                                            } catch (SQLiteException e13) {
                                                                e = e13;
                                                                zzbdVar = zzr;
                                                            }
                                                        }
                                                        if (cursor4 != null) {
                                                            cursor4.close();
                                                        }
                                                        map5 = arrayMap10;
                                                    } else {
                                                        zzbdVar = zzr;
                                                        str6 = str28;
                                                        map5 = Collections.emptyMap();
                                                    }
                                                } catch (Throwable th6) {
                                                    th = th6;
                                                    if (cursor4 != null) {
                                                        cursor4.close();
                                                    }
                                                    throw th;
                                                }
                                            } catch (SQLiteException e14) {
                                                e = e14;
                                                zzbdVar = zzr;
                                                str6 = str28;
                                            }
                                        } catch (SQLiteException e15) {
                                            e = e15;
                                            zzbdVar = zzr;
                                            str6 = str28;
                                            cursor4 = null;
                                            zzj6.zzu.zzaW().zze().zzc(str8, zzhe.zzn(str27), e);
                                            map5 = Collections.emptyMap();
                                        }
                                        arrayMap9.put(zzh, map5);
                                    } else {
                                        it = it5;
                                        zzbdVar = zzr;
                                        str10 = str14;
                                    }
                                    for (Integer num3 : map5.keySet()) {
                                        int intValue = num3.intValue();
                                        if (this.zzb.contains(num3)) {
                                            this.zzu.zzaW().zzj().zzb("Skipping failed audience ID", num3);
                                        } else {
                                            Iterator it6 = ((List) map5.get(num3)).iterator();
                                            boolean z3 = true;
                                            while (true) {
                                                if (!it6.hasNext()) {
                                                    map2 = map5;
                                                    break;
                                                }
                                                com.google.android.gms.internal.measurement.zzfj zzfjVar4 = (com.google.android.gms.internal.measurement.zzfj) it6.next();
                                                zzaa zzaaVar = new zzaa(this, this.zza, intValue, zzfjVar4);
                                                map2 = map5;
                                                boolean zzd = zzaaVar.zzd(this.zzd, this.zze, zza, j, zzbdVar, zzf(intValue, zzfjVar4.zzb()));
                                                if (!zzd) {
                                                    this.zzb.add(num3);
                                                    z3 = zzd;
                                                    break;
                                                }
                                                zzd(num3).zzc(zzaaVar);
                                                z3 = zzd;
                                                map5 = map2;
                                            }
                                            if (!z3) {
                                                this.zzb.add(num3);
                                            }
                                            map5 = map2;
                                        }
                                    }
                                    zzzVar = zzzVar2;
                                    it5 = it;
                                    str14 = str10;
                                }
                            }
                        }
                    }
                    String str2322 = str14;
                    if (!z) {
                        return new ArrayList();
                    }
                    if (!list2.isEmpty()) {
                        ArrayMap arrayMap11 = new ArrayMap();
                        Iterator it7 = list2.iterator();
                        while (it7.hasNext()) {
                            com.google.android.gms.internal.measurement.zzio zzioVar3 = (com.google.android.gms.internal.measurement.zzio) it7.next();
                            String zzg = zzioVar3.zzg();
                            Map map6 = (Map) arrayMap11.get(zzg);
                            if (map6 == null) {
                                zzaw zzj7 = this.zzg.zzj();
                                String str30 = this.zza;
                                zzj7.zzav();
                                zzj7.zzg();
                                Preconditions.checkNotEmpty(str30);
                                Preconditions.checkNotEmpty(zzg);
                                ArrayMap arrayMap12 = new ArrayMap();
                                str11 = str6;
                                str12 = str7;
                                try {
                                    cursor6 = zzj7.zzj().query("property_filters", new String[]{str11, str12}, "app_id=? AND property_name=?", new String[]{str30, zzg}, null, null, null);
                                    try {
                                        try {
                                            if (cursor6.moveToFirst()) {
                                                while (true) {
                                                    try {
                                                        com.google.android.gms.internal.measurement.zzfr zzfrVar2 = (com.google.android.gms.internal.measurement.zzfr) ((com.google.android.gms.internal.measurement.zzfq) zzqa.zzp(com.google.android.gms.internal.measurement.zzfr.zzc(), cursor6.getBlob(1))).zzba();
                                                        Integer valueOf5 = Integer.valueOf(cursor6.getInt(0));
                                                        List list10 = (List) arrayMap12.get(valueOf5);
                                                        if (list10 == null) {
                                                            list5 = new ArrayList();
                                                            arrayMap12.put(valueOf5, list5);
                                                        } else {
                                                            list5 = list10;
                                                        }
                                                        list5.add(zzfrVar2);
                                                        it2 = it7;
                                                    } catch (IOException e16) {
                                                        it2 = it7;
                                                        try {
                                                            zzj7.zzu.zzaW().zze().zzc("Failed to merge filter", zzhe.zzn(str30), e16);
                                                        } catch (SQLiteException e17) {
                                                            e = e17;
                                                            zzj7.zzu.zzaW().zze().zzc(str8, zzhe.zzn(str30), e);
                                                            map6 = Collections.emptyMap();
                                                        }
                                                    }
                                                    if (!cursor6.moveToNext()) {
                                                        break;
                                                    }
                                                    it7 = it2;
                                                }
                                                if (cursor6 != null) {
                                                    cursor6.close();
                                                }
                                                map6 = arrayMap12;
                                            } else {
                                                it2 = it7;
                                                map6 = Collections.emptyMap();
                                            }
                                        } catch (SQLiteException e18) {
                                            e = e18;
                                            it2 = it7;
                                        }
                                    } catch (Throwable th7) {
                                        th = th7;
                                        cursor5 = cursor6;
                                        if (cursor5 != null) {
                                            cursor5.close();
                                        }
                                        throw th;
                                    }
                                } catch (SQLiteException e19) {
                                    e = e19;
                                    it2 = it7;
                                    cursor6 = null;
                                } catch (Throwable th8) {
                                    th = th8;
                                    cursor5 = null;
                                }
                                arrayMap11.put(zzg, map6);
                            } else {
                                it2 = it7;
                                str11 = str6;
                                str12 = str7;
                            }
                            Iterator it8 = map6.keySet().iterator();
                            while (true) {
                                if (it8.hasNext()) {
                                    Integer num4 = (Integer) it8.next();
                                    int intValue2 = num4.intValue();
                                    if (this.zzb.contains(num4)) {
                                        this.zzu.zzaW().zzj().zzb(str2222, num4);
                                        break;
                                    }
                                    Iterator it9 = ((List) map6.get(num4)).iterator();
                                    boolean z4 = true;
                                    while (true) {
                                        if (!it9.hasNext()) {
                                            map3 = map6;
                                            str13 = str2222;
                                            break;
                                        }
                                        zzfrVar = (com.google.android.gms.internal.measurement.zzfr) it9.next();
                                        zzioVar = this.zzu;
                                        if (Log.isLoggable(zzioVar.zzaW().zzr(), 2)) {
                                            zzhc zzj8 = zzioVar.zzaW().zzj();
                                            if (zzfrVar.zzj()) {
                                                num = Integer.valueOf(zzfrVar.zza());
                                                map3 = map6;
                                            } else {
                                                map3 = map6;
                                                num = null;
                                            }
                                            str13 = str2222;
                                            zzj8.zzd("Evaluating filter. audience, filter, property", num4, num, zzioVar.zzj().zzf(zzfrVar.zze()));
                                            zzioVar.zzaW().zzj().zzb("Filter definition", this.zzg.zzA().zzs(zzfrVar));
                                        } else {
                                            map3 = map6;
                                            str13 = str2222;
                                        }
                                        if (!zzfrVar.zzj() || zzfrVar.zza() > 256) {
                                            break;
                                        }
                                        zzac zzacVar = new zzac(this, this.zza, intValue2, zzfrVar);
                                        z4 = zzacVar.zzd(this.zzd, this.zze, zzioVar3, zzf(intValue2, zzfrVar.zza()));
                                        if (!z4) {
                                            this.zzb.add(num4);
                                            break;
                                        }
                                        zzd(num4).zzc(zzacVar);
                                        map6 = map3;
                                        str2222 = str13;
                                    }
                                    zzioVar.zzaW().zzk().zzc("Invalid property filter ID. appId, id", zzhe.zzn(this.zza), String.valueOf(zzfrVar.zzj() ? Integer.valueOf(zzfrVar.zza()) : null));
                                    this.zzb.add(num4);
                                    map6 = map3;
                                    str2222 = str13;
                                }
                            }
                            it7 = it2;
                            str7 = str12;
                            str6 = str11;
                        }
                    }
                    String str31 = str6;
                    ArrayList arrayList = new ArrayList();
                    Set<Integer> keySet = this.zzc.keySet();
                    keySet.removeAll(this.zzb);
                    for (Integer num5 : keySet) {
                        int intValue3 = num5.intValue();
                        zzy zzyVar = (zzy) this.zzc.get(num5);
                        Preconditions.checkNotNull(zzyVar);
                        com.google.android.gms.internal.measurement.zzhi zza2 = zzyVar.zza(intValue3);
                        arrayList.add(zza2);
                        zzaw zzj9 = this.zzg.zzj();
                        String str32 = this.zza;
                        com.google.android.gms.internal.measurement.zzic zzd2 = zza2.zzd();
                        zzj9.zzav();
                        zzj9.zzg();
                        Preconditions.checkNotEmpty(str32);
                        Preconditions.checkNotNull(zzd2);
                        byte[] zzcd = zzd2.zzcd();
                        ContentValues contentValues2 = new ContentValues();
                        contentValues2.put("app_id", str32);
                        contentValues2.put(str31, num5);
                        String str33 = str2322;
                        contentValues2.put(str33, zzcd);
                        try {
                            try {
                                if (zzj9.zzj().insertWithOnConflict("audience_filter_values", null, contentValues2, 5) == -1) {
                                    zzj9.zzu.zzaW().zze().zzb("Failed to insert filter results (got -1). appId", zzhe.zzn(str32));
                                }
                            } catch (SQLiteException e20) {
                                e = e20;
                                zzj9.zzu.zzaW().zze().zzc("Error storing filter results. appId", zzhe.zzn(str32), e);
                                str2322 = str33;
                            }
                        } catch (SQLiteException e21) {
                            e = e21;
                        }
                        str2322 = str33;
                    }
                    return arrayList;
                }
                emptyMap = Collections.emptyMap();
            }
            if (cursor2.moveToFirst()) {
            }
            if (r13.isEmpty()) {
            }
            String str22222 = "Skipping failed audience ID";
            if (!list.isEmpty()) {
            }
            String str23222 = str14;
            if (!z) {
            }
        } catch (Throwable th9) {
            th = th9;
            Cursor cursor8 = cursor2;
            if (cursor8 != null) {
                cursor8.close();
            }
            throw th;
        }
        map = emptyMap;
        zzaw zzj32 = this.zzg.zzj();
        String str212 = this.zza;
        zzj32.zzav();
        zzj32.zzg();
        Preconditions.checkNotEmpty(str212);
        cursor2 = zzj32.zzj().query("audience_filter_values", new String[]{"audience_id", "current_results"}, "app_id=?", new String[]{str212}, null, null, null);
    }

    @Override // com.google.android.gms.measurement.internal.zzpg
    protected final boolean zzb() {
        return false;
    }
}
