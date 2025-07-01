package com.google.android.gms.internal.mlkit_vision_text_common;

import com.google.android.gms.common.internal.Objects;

/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition-common@@19.1.0 */
/* loaded from: classes3.dex */
public final class zzod {
    private final zzob zza;
    private final Integer zzb;
    private final Integer zzc;
    private final Boolean zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzod(zzoa zzoaVar, zzoc zzocVar) {
        zzob zzobVar;
        Integer num;
        zzobVar = zzoaVar.zza;
        this.zza = zzobVar;
        num = zzoaVar.zzb;
        this.zzb = num;
        this.zzc = null;
        this.zzd = null;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzod)) {
            return false;
        }
        zzod zzodVar = (zzod) obj;
        if (Objects.equal(this.zza, zzodVar.zza) && Objects.equal(this.zzb, zzodVar.zzb)) {
            Integer num = zzodVar.zzc;
            if (Objects.equal(null, null)) {
                Boolean bool = zzodVar.zzd;
                if (Objects.equal(null, null)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza, this.zzb, null, null);
    }

    public final zzob zza() {
        return this.zza;
    }

    public final Integer zzb() {
        return this.zzb;
    }
}
