package com.google.android.gms.internal.mlkit_vision_common;

import java.util.Set;
import javax.annotation.CheckForNull;

/* compiled from: com.google.mlkit:vision-common@@17.3.0 */
/* loaded from: classes3.dex */
public abstract class zzs extends zzl implements Set {

    @CheckForNull
    private transient zzp zza;

    @Override // java.util.Collection, java.util.Set
    public final boolean equals(@CheckForNull Object obj) {
        if (obj == this || obj == this) {
            return true;
        }
        if (obj instanceof Set) {
            Set set = (Set) obj;
            try {
                if (size() == set.size()) {
                    if (containsAll(set)) {
                        return true;
                    }
                }
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    @Override // java.util.Collection, java.util.Set
    public final int hashCode() {
        return zzaa.zza(this);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzl, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    /* renamed from: zzd */
    public abstract zzab iterator();

    public final zzp zzf() {
        zzp zzpVar = this.zza;
        if (zzpVar != null) {
            return zzpVar;
        }
        zzp zzg = zzg();
        this.zza = zzg;
        return zzg;
    }

    zzp zzg() {
        return zzp.zzg(toArray());
    }
}
