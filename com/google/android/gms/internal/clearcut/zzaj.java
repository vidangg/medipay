package com.google.android.gms.internal.clearcut;

import android.content.SharedPreferences;
import android.util.Log;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class zzaj extends zzae<Boolean> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaj(zzao zzaoVar, String str, Boolean bool) {
        super(zzaoVar, str, bool, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.internal.clearcut.zzae
    /* renamed from: zzb, reason: merged with bridge method [inline-methods] */
    public final Boolean zza(SharedPreferences sharedPreferences) {
        try {
            return Boolean.valueOf(sharedPreferences.getBoolean(this.zzds, false));
        } catch (ClassCastException e) {
            String valueOf = String.valueOf(this.zzds);
            Log.e("PhenotypeFlag", valueOf.length() != 0 ? "Invalid boolean value in SharedPreferences for ".concat(valueOf) : new String("Invalid boolean value in SharedPreferences for "), e);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.clearcut.zzae
    public final /* synthetic */ Boolean zzb(String str) {
        if (zzy.zzcr.matcher(str).matches()) {
            return true;
        }
        if (zzy.zzcs.matcher(str).matches()) {
            return false;
        }
        String str2 = this.zzds;
        StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 28 + String.valueOf(str).length());
        sb.append("Invalid boolean value for ");
        sb.append(str2);
        sb.append(": ");
        sb.append(str);
        Log.e("PhenotypeFlag", sb.toString());
        return null;
    }
}
