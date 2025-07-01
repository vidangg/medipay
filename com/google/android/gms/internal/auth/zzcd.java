package com.google.android.gms.internal.auth;

import android.content.Context;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-auth-base@@18.0.10 */
/* loaded from: classes3.dex */
final class zzcd extends zzda {
    private final Context zza;
    private final zzdj zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcd(Context context, @Nullable zzdj zzdjVar) {
        this.zza = context;
        this.zzb = zzdjVar;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzda) {
            zzda zzdaVar = (zzda) obj;
            if (this.zza.equals(zzdaVar.zza()) && this.zzb.equals(zzdaVar.zzb())) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((this.zza.hashCode() ^ 1000003) * 1000003) ^ this.zzb.hashCode();
    }

    public final String toString() {
        return "FlagsContext{context=" + this.zza.toString() + ", hermeticFileOverrides=" + this.zzb.toString() + "}";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.auth.zzda
    public final Context zza() {
        return this.zza;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.auth.zzda
    @Nullable
    public final zzdj zzb() {
        return this.zzb;
    }
}
