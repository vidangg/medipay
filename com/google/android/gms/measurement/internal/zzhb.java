package com.google.android.gms.measurement.internal;

import android.util.Log;
import androidx.exifinterface.media.ExifInterface;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.4.0 */
/* loaded from: classes3.dex */
public final class zzhb implements Runnable {
    final /* synthetic */ int zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ Object zzc;
    final /* synthetic */ Object zzd;
    final /* synthetic */ Object zze;
    final /* synthetic */ zzhe zzf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzhb(zzhe zzheVar, int i, String str, Object obj, Object obj2, Object obj3) {
        this.zza = i;
        this.zzb = str;
        this.zzc = obj;
        this.zzd = obj2;
        this.zze = obj3;
        this.zzf = zzheVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        char c;
        long j;
        char c2;
        long j2;
        zzhe zzheVar = this.zzf;
        zzht zzm = zzheVar.zzu.zzm();
        if (zzm.zzy()) {
            c = zzheVar.zza;
            if (c == 0) {
                zzio zzioVar = zzheVar.zzu;
                if (zzioVar.zzf().zzD()) {
                    zzioVar.zzaV();
                    zzheVar.zza = 'C';
                } else {
                    zzioVar.zzaV();
                    zzheVar.zza = 'c';
                }
            }
            j = zzheVar.zzb;
            if (j < 0) {
                zzheVar.zzu.zzf().zzj();
                zzheVar.zzb = 119002L;
            }
            char charAt = "01VDIWEA?".charAt(this.zza);
            c2 = zzheVar.zza;
            j2 = zzheVar.zzb;
            String str = this.zzb;
            String str2 = ExifInterface.GPS_MEASUREMENT_2D + charAt + c2 + j2 + ":" + zzhe.zzo(true, str, this.zzc, this.zzd, this.zze);
            if (str2.length() > 1024) {
                str2 = str.substring(0, 1024);
            }
            zzhq zzhqVar = zzm.zzb;
            if (zzhqVar != null) {
                zzhqVar.zzb(str2, 1L);
                return;
            }
            return;
        }
        Log.println(6, zzheVar.zzr(), "Persisted config not initialized. Not logging error/warn");
    }
}
