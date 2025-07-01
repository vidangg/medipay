package com.google.android.gms.internal.fido;

import java.util.Arrays;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-fido@@20.0.1 */
/* loaded from: classes3.dex */
public final class zzaj {
    private final String zza;
    private final zzah zzb;
    private zzah zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzaj(String str, zzai zzaiVar) {
        zzah zzahVar = new zzah(null);
        this.zzb = zzahVar;
        this.zzc = zzahVar;
        str.getClass();
        this.zza = str;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(32);
        sb.append(this.zza);
        sb.append('{');
        zzah zzahVar = this.zzb.zzc;
        String str = "";
        while (zzahVar != null) {
            Object obj = zzahVar.zzb;
            boolean z = zzahVar instanceof zzaf;
            sb.append(str);
            String str2 = zzahVar.zza;
            if (str2 != null) {
                sb.append(str2);
                sb.append('=');
            }
            if (obj == null || !obj.getClass().isArray()) {
                sb.append(obj);
            } else {
                sb.append((CharSequence) Arrays.deepToString(new Object[]{obj}), 1, r2.length() - 1);
            }
            zzahVar = zzahVar.zzc;
            str = ", ";
        }
        sb.append('}');
        return sb.toString();
    }

    public final zzaj zza(String str, int i) {
        String valueOf = String.valueOf(i);
        zzaf zzafVar = new zzaf(null);
        this.zzc.zzc = zzafVar;
        this.zzc = zzafVar;
        zzafVar.zzb = valueOf;
        zzafVar.zza = "errorCode";
        return this;
    }

    public final zzaj zzb(String str, @CheckForNull Object obj) {
        zzah zzahVar = new zzah(null);
        this.zzc.zzc = zzahVar;
        this.zzc = zzahVar;
        zzahVar.zzb = obj;
        zzahVar.zza = str;
        return this;
    }
}
