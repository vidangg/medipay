package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@22.4.0 */
/* loaded from: classes3.dex */
public final class zzdu extends zzeu {
    final /* synthetic */ String zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ Context zzc;
    final /* synthetic */ Bundle zzd;
    final /* synthetic */ zzff zze;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzdu(zzff zzffVar, String str, String str2, Context context, Bundle bundle) {
        super(zzffVar, true);
        this.zza = str;
        this.zzb = str2;
        this.zzc = context;
        this.zzd = bundle;
        this.zze = zzffVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzeu
    public final void zza() {
        boolean zzX;
        String str;
        String str2;
        String str3;
        zzcv zzcvVar;
        zzcv zzcvVar2;
        String str4;
        String str5;
        try {
            zzff zzffVar = this.zze;
            String str6 = this.zza;
            String str7 = this.zzb;
            zzX = zzffVar.zzX(str6, str7);
            if (zzX) {
                str5 = zzffVar.zzd;
                str2 = str6;
                str3 = str7;
                str = str5;
            } else {
                str = null;
                str2 = null;
                str3 = null;
            }
            Context context = this.zzc;
            Preconditions.checkNotNull(context);
            zzffVar.zzj = zzffVar.zzf(context, true);
            zzcvVar = zzffVar.zzj;
            if (zzcvVar != null) {
                int localVersion = DynamiteModule.getLocalVersion(context, ModuleDescriptor.MODULE_ID);
                zzdh zzdhVar = new zzdh(119002L, Math.max(localVersion, r0), DynamiteModule.getRemoteVersion(context, ModuleDescriptor.MODULE_ID) < localVersion, str, str2, str3, this.zzd, com.google.android.gms.measurement.internal.zzig.zza(context));
                zzcvVar2 = zzffVar.zzj;
                ((zzcv) Preconditions.checkNotNull(zzcvVar2)).initialize(ObjectWrapper.wrap(context), zzdhVar, this.zzh);
                return;
            }
            str4 = zzffVar.zzd;
            Log.w(str4, "Failed to connect to measurement client.");
        } catch (Exception e) {
            this.zze.zzU(e, true, false);
        }
    }
}
