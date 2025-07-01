package com.google.android.gms.measurement.internal;

import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.common.internal.Preconditions;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement@@22.4.0 */
/* loaded from: classes3.dex */
public final class zzz {
    final /* synthetic */ zzae zza;
    private com.google.android.gms.internal.measurement.zzhm zzb;
    private Long zzc;
    private long zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzz(zzae zzaeVar, zzad zzadVar) {
        this.zza = zzaeVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00d5, code lost:
    
        if (r4 == null) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x00ee, code lost:
    
        if (r4 == null) goto L41;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01d8  */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r7v5, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r7v6 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final com.google.android.gms.internal.measurement.zzhm zza(String str, com.google.android.gms.internal.measurement.zzhm zzhmVar) {
        Cursor cursor;
        Pair pair;
        String zzh = zzhmVar.zzh();
        List zzi = zzhmVar.zzi();
        zzae zzaeVar = this.zza;
        zzpv zzpvVar = zzaeVar.zzg;
        zzpvVar.zzA();
        Long l = (Long) zzqa.zzH(zzhmVar, "_eid");
        if (l != null) {
            if (zzh.equals("_ep")) {
                Preconditions.checkNotNull(l);
                zzpvVar.zzA();
                String str2 = (String) zzqa.zzH(zzhmVar, "_en");
                ?? r7 = 0;
                if (TextUtils.isEmpty(str2)) {
                    zzaeVar.zzu.zzaW().zzh().zzb("Extra parameter without an event name. eventId", l);
                    return null;
                }
                if (this.zzb == null || this.zzc == null || l.longValue() != this.zzc.longValue()) {
                    zzaw zzj = zzpvVar.zzj();
                    zzj.zzg();
                    zzj.zzav();
                    try {
                        try {
                            cursor = zzj.zzj().rawQuery("select main_event, children_to_process from main_event_params where app_id=? and event_id=?", new String[]{str, l.toString()});
                            try {
                            } catch (SQLiteException e) {
                                e = e;
                                zzj.zzu.zzaW().zze().zzb("Error selecting main event", e);
                            }
                        } catch (Throwable th) {
                            th = th;
                            r7 = zzpvVar;
                            if (r7 != 0) {
                                r7.close();
                            }
                            throw th;
                        }
                    } catch (SQLiteException e2) {
                        e = e2;
                        cursor = null;
                    } catch (Throwable th2) {
                        th = th2;
                        if (r7 != 0) {
                        }
                        throw th;
                    }
                    if (cursor.moveToFirst()) {
                        try {
                            pair = Pair.create((com.google.android.gms.internal.measurement.zzhm) ((com.google.android.gms.internal.measurement.zzhl) zzqa.zzp(com.google.android.gms.internal.measurement.zzhm.zze(), cursor.getBlob(0))).zzba(), Long.valueOf(cursor.getLong(1)));
                            if (cursor != null) {
                                cursor.close();
                            }
                        } catch (IOException e3) {
                            zzj.zzu.zzaW().zze().zzd("Failed to merge main event. appId, eventId", zzhe.zzn(str), l, e3);
                        }
                        if (pair != null) {
                        }
                        this.zza.zzu.zzaW().zzh().zzc("Extra parameter without existing main event. eventName, eventId", str2, l);
                        return null;
                    }
                    zzj.zzu.zzaW().zzj().zza("Main event not found");
                    if (cursor != null) {
                        cursor.close();
                    }
                    pair = null;
                    if (pair != null || pair.first == null) {
                        this.zza.zzu.zzaW().zzh().zzc("Extra parameter without existing main event. eventName, eventId", str2, l);
                        return null;
                    }
                    this.zzb = (com.google.android.gms.internal.measurement.zzhm) pair.first;
                    this.zzd = ((Long) pair.second).longValue();
                    this.zza.zzg.zzA();
                    this.zzc = (Long) zzqa.zzH(this.zzb, "_eid");
                }
                long j = this.zzd - 1;
                this.zzd = j;
                if (j <= 0) {
                    zzaw zzj2 = this.zza.zzg.zzj();
                    zzj2.zzg();
                    zzj2.zzu.zzaW().zzj().zzb("Clearing complex main event info. appId", str);
                    try {
                        zzj2.zzj().execSQL("delete from main_event_params where app_id=?", new String[]{str});
                    } catch (SQLiteException e4) {
                        zzj2.zzu.zzaW().zze().zzb("Error clearing complex main event", e4);
                    }
                } else {
                    this.zza.zzg.zzj().zzaf(str, l, this.zzd, this.zzb);
                }
                ArrayList arrayList = new ArrayList();
                for (com.google.android.gms.internal.measurement.zzhq zzhqVar : this.zzb.zzi()) {
                    this.zza.zzg.zzA();
                    if (zzqa.zzG(zzhmVar, zzhqVar.zzg()) == null) {
                        arrayList.add(zzhqVar);
                    }
                }
                if (arrayList.isEmpty()) {
                    this.zza.zzu.zzaW().zzh().zzb("No unique parameters in main event. eventName", str2);
                } else {
                    arrayList.addAll(zzi);
                    zzi = arrayList;
                }
                zzh = str2;
            } else {
                this.zzc = l;
                this.zzb = zzhmVar;
                zzpvVar.zzA();
                long longValue = ((Long) zzqa.zzI(zzhmVar, "_epc", 0L)).longValue();
                this.zzd = longValue;
                if (longValue <= 0) {
                    zzaeVar.zzu.zzaW().zzh().zzb("Complex event with zero extra param count. eventName", zzh);
                } else {
                    zzpvVar.zzj().zzaf(str, (Long) Preconditions.checkNotNull(l), this.zzd, zzhmVar);
                }
            }
        }
        com.google.android.gms.internal.measurement.zzhl zzhlVar = (com.google.android.gms.internal.measurement.zzhl) zzhmVar.zzch();
        zzhlVar.zzi(zzh);
        zzhlVar.zzg();
        zzhlVar.zzd(zzi);
        return (com.google.android.gms.internal.measurement.zzhm) zzhlVar.zzba();
    }
}
