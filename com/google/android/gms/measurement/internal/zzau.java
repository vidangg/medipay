package com.google.android.gms.measurement.internal;

import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import com.google.android.gms.common.internal.Preconditions;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@22.4.0 */
/* loaded from: classes3.dex */
public final class zzau {
    final /* synthetic */ zzaw zza;
    private final String zzb;
    private long zzc;

    public zzau(zzaw zzawVar, String str) {
        this.zza = zzawVar;
        Preconditions.checkNotEmpty(str);
        this.zzb = str;
        this.zzc = -1L;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x00d1 A[DONT_GENERATE] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final List zza() {
        List arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            try {
                cursor = this.zza.zzj().query("raw_events", new String[]{"rowid", "name", "timestamp", "metadata_fingerprint", "data", "realtime"}, "app_id = ? and rowid > ?", new String[]{this.zzb, String.valueOf(this.zzc)}, null, null, "rowid", "1000");
            } catch (SQLiteException e) {
                this.zza.zzu.zzaW().zze().zzc("Data loss. Error querying raw events batch. appId", zzhe.zzn(this.zzb), e);
            }
            if (!cursor.moveToFirst()) {
                arrayList = Collections.emptyList();
                return arrayList;
            }
            do {
                long j = cursor.getLong(0);
                long j2 = cursor.getLong(3);
                boolean z = cursor.getLong(5) == 1;
                byte[] blob = cursor.getBlob(4);
                if (j > this.zzc) {
                    this.zzc = j;
                }
                try {
                    com.google.android.gms.internal.measurement.zzhl zzhlVar = (com.google.android.gms.internal.measurement.zzhl) zzqa.zzp(com.google.android.gms.internal.measurement.zzhm.zze(), blob);
                    String string = cursor.getString(1);
                    if (string == null) {
                        string = "";
                    }
                    zzhlVar.zzi(string);
                    zzhlVar.zzm(cursor.getLong(2));
                    arrayList.add(new zzat(j, j2, z, (com.google.android.gms.internal.measurement.zzhm) zzhlVar.zzba()));
                } catch (IOException e2) {
                    this.zza.zzu.zzaW().zze().zzc("Data loss. Failed to merge raw event. appId", zzhe.zzn(this.zzb), e2);
                }
            } while (cursor.moveToNext());
            return arrayList;
        } finally {
            if (0 != 0) {
                cursor.close();
            }
        }
    }

    public zzau(zzaw zzawVar, String str, long j) {
        long zzaz;
        this.zza = zzawVar;
        Preconditions.checkNotEmpty(str);
        this.zzb = str;
        zzaz = zzawVar.zzaz("select rowid from raw_events where app_id = ? and timestamp < ? order by rowid desc limit 1", new String[]{str, String.valueOf(j)}, -1L);
        this.zzc = zzaz;
    }
}
