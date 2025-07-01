package com.google.android.gms.internal.measurement;

import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@22.4.0 */
/* loaded from: classes3.dex */
public final class zzgn extends zzlz implements zzni {
    private zzgn() {
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzgn(zzgz zzgzVar) {
        super(zzgo.zzg());
    }

    public final int zza() {
        return ((zzgo) this.zza).zzb();
    }

    public final zzgm zzb(int i) {
        return ((zzgo) this.zza).zze(i);
    }

    public final zzgn zzc() {
        zzbe();
        zzgo.zzq((zzgo) this.zza);
        return this;
    }

    public final zzgn zzd() {
        zzbe();
        zzgo.zzr((zzgo) this.zza);
        return this;
    }

    public final zzgn zze(int i, zzgl zzglVar) {
        zzbe();
        zzgo.zzs((zzgo) this.zza, i, (zzgm) zzglVar.zzba());
        return this;
    }

    public final String zzf() {
        return ((zzgo) this.zza).zzk();
    }

    public final List zzg() {
        return Collections.unmodifiableList(((zzgo) this.zza).zzm());
    }

    public final List zzh() {
        return Collections.unmodifiableList(((zzgo) this.zza).zzn());
    }
}
