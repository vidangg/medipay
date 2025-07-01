package com.google.android.gms.internal.mlkit_vision_text_common;

import java.util.Objects;
import javax.annotation.CheckForNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition-common@@19.1.0 */
/* loaded from: classes3.dex */
public final class zzcj extends zzbm {
    final transient Object[] zza;

    private zzcj(@CheckForNull Object obj, Object[] objArr, int i) {
        this.zza = objArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzcj zzg(int i, Object[] objArr, zzbl zzblVar) {
        zzaq.zzb(Objects.requireNonNull(objArr[0]), Objects.requireNonNull(objArr[1]));
        return new zzcj(null, objArr, 1);
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x001d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001e A[RETURN] */
    @Override // com.google.android.gms.internal.mlkit_vision_text_common.zzbm, java.util.Map
    @CheckForNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object get(@CheckForNull Object obj) {
        Object requireNonNull;
        if (obj != null) {
            Object[] objArr = this.zza;
            if (Objects.requireNonNull(objArr[0]).equals(obj)) {
                requireNonNull = Objects.requireNonNull(objArr[1]);
                if (requireNonNull != null) {
                    return null;
                }
                return requireNonNull;
            }
        }
        requireNonNull = null;
        if (requireNonNull != null) {
        }
    }

    @Override // java.util.Map
    public final int size() {
        return 1;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_common.zzbm
    final zzbf zza() {
        return new zzci(this.zza, 1, 1);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_common.zzbm
    final zzbn zzd() {
        return new zzcg(this, this.zza, 0, 1);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_common.zzbm
    final zzbn zze() {
        return new zzch(this, new zzci(this.zza, 0, 1));
    }
}
