package com.google.android.gms.internal.mlkit_vision_text_common;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition-common@@19.1.0 */
/* loaded from: classes3.dex */
final class zzac implements Iterator {
    final Iterator zza;

    @CheckForNull
    Collection zzb;
    final /* synthetic */ zzad zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzac(zzad zzadVar) {
        this.zzc = zzadVar;
        this.zza = zzadVar.zza.entrySet().iterator();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zza.hasNext();
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        Map.Entry entry = (Map.Entry) this.zza.next();
        this.zzb = (Collection) entry.getValue();
        Object key = entry.getKey();
        return new zzbg(key, this.zzc.zzb.zzb(key, (Collection) entry.getValue()));
    }

    @Override // java.util.Iterator
    public final void remove() {
        int i;
        zzx.zzd(this.zzb != null, "no calls to next() since the last call to remove()");
        this.zza.remove();
        zzal zzalVar = this.zzc.zzb;
        i = zzalVar.zzb;
        zzalVar.zzb = i - this.zzb.size();
        this.zzb.clear();
        this.zzb = null;
    }
}
