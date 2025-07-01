package com.google.android.gms.internal.clearcut;

import android.content.SharedPreferences;
import android.util.Base64;
import android.util.Log;
import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [T] */
/* loaded from: classes3.dex */
public final class zzal<T> extends zzae<T> {
    private final Object lock;
    private String zzec;
    private T zzed;
    private final /* synthetic */ zzan zzee;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzal(zzao zzaoVar, String str, Object obj, zzan zzanVar) {
        super(zzaoVar, str, obj, null);
        this.zzee = zzanVar;
        this.lock = new Object();
    }

    @Override // com.google.android.gms.internal.clearcut.zzae
    protected final T zza(SharedPreferences sharedPreferences) {
        try {
            return zzb(sharedPreferences.getString(this.zzds, ""));
        } catch (ClassCastException e) {
            String valueOf = String.valueOf(this.zzds);
            Log.e("PhenotypeFlag", valueOf.length() != 0 ? "Invalid byte[] value in SharedPreferences for ".concat(valueOf) : new String("Invalid byte[] value in SharedPreferences for "), e);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.clearcut.zzae
    public final T zzb(String str) {
        T t;
        try {
            synchronized (this.lock) {
                if (!str.equals(this.zzec)) {
                    T t2 = (T) this.zzee.zzb(Base64.decode(str, 3));
                    this.zzec = str;
                    this.zzed = t2;
                }
                t = this.zzed;
            }
            return t;
        } catch (IOException | IllegalArgumentException unused) {
            String str2 = this.zzds;
            StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 27 + String.valueOf(str).length());
            sb.append("Invalid byte[] value for ");
            sb.append(str2);
            sb.append(": ");
            sb.append(str);
            Log.e("PhenotypeFlag", sb.toString());
            return null;
        }
    }
}
