package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.database.ContentObserver;
import android.util.Log;
import androidx.core.content.PermissionChecker;
import com.google.common.base.Preconditions;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.4.0 */
/* loaded from: classes3.dex */
public final class zzju implements zzjr {
    private static zzju zza;
    private final Context zzb;
    private final ContentObserver zzc;
    private boolean zzd;

    private zzju() {
        this.zzd = false;
        this.zzb = null;
        this.zzc = null;
    }

    private zzju(Context context) {
        this.zzd = false;
        this.zzb = context;
        this.zzc = new zzjt(this, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzju zza(Context context) {
        zzju zzjuVar;
        synchronized (zzju.class) {
            if (zza == null) {
                zza = PermissionChecker.checkSelfPermission(context, "com.google.android.providers.gsf.permission.READ_GSERVICES") == 0 ? new zzju(context) : new zzju();
            }
            zzju zzjuVar2 = zza;
            if (zzjuVar2 != null && zzjuVar2.zzc != null && !zzjuVar2.zzd) {
                try {
                    context.getContentResolver().registerContentObserver(zzjc.zza, true, zza.zzc);
                    ((zzju) Preconditions.checkNotNull(zza)).zzd = true;
                } catch (SecurityException e) {
                    Log.e("GservicesLoader", "Unable to register Gservices content observer", e);
                }
            }
            zzjuVar = (zzju) Preconditions.checkNotNull(zza);
        }
        return zzjuVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized void zze() {
        Context context;
        synchronized (zzju.class) {
            zzju zzjuVar = zza;
            if (zzjuVar != null && (context = zzjuVar.zzb) != null && zzjuVar.zzc != null && zzjuVar.zzd) {
                context.getContentResolver().unregisterContentObserver(zza.zzc);
            }
            zza = null;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzjr
    /* renamed from: zzd, reason: merged with bridge method [inline-methods] */
    public final String zzb(final String str) {
        Context context = this.zzb;
        if (context != null && !zzji.zza(context)) {
            try {
                return (String) zzjp.zza(new zzjq() { // from class: com.google.android.gms.internal.measurement.zzjs
                    @Override // com.google.android.gms.internal.measurement.zzjq
                    public final Object zza() {
                        String zza2;
                        zza2 = zzjb.zza(((Context) Preconditions.checkNotNull(zzju.this.zzb)).getContentResolver(), str, null);
                        return zza2;
                    }
                });
            } catch (IllegalStateException | NullPointerException | SecurityException e) {
                Log.e("GservicesLoader", "Unable to read GServices for: ".concat(str), e);
            }
        }
        return null;
    }
}
