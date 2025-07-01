package com.google.android.gms.internal.mlkit_vision_face_bundled;

import java.util.Objects;
import javax.annotation.CheckForNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.mlkit:face-detection@@16.1.7 */
/* loaded from: classes3.dex */
public final class zzbd extends zzaw {
    final transient Object[] zza;

    private zzbd(@CheckForNull Object obj, Object[] objArr, int i) {
        this.zza = objArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzbd zzg(int i, Object[] objArr, zzav zzavVar) {
        zzan.zza(Objects.requireNonNull(objArr[0]), Objects.requireNonNull(objArr[1]));
        return new zzbd(null, objArr, 1);
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x001d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001e A[RETURN] */
    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzaw, java.util.Map
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

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzaw
    final zzaq zza() {
        return new zzbc(this.zza, 1, 1);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzaw
    final zzax zzd() {
        return new zzba(this, this.zza, 0, 1);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzaw
    final zzax zze() {
        return new zzbb(this, new zzbc(this.zza, 0, 1));
    }
}
