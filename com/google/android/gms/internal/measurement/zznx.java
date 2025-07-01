package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-base@@22.4.0 */
/* loaded from: classes3.dex */
final class zznx implements Iterator {
    final /* synthetic */ zzoa zza;
    private int zzb = -1;
    private boolean zzc;
    private Iterator zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zznx(zzoa zzoaVar, zznz zznzVar) {
        this.zza = zzoaVar;
    }

    private final Iterator zza() {
        Map map;
        if (this.zzd == null) {
            map = this.zza.zzc;
            this.zzd = map.entrySet().iterator();
        }
        return this.zzd;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        int i;
        Map map;
        int i2 = this.zzb + 1;
        zzoa zzoaVar = this.zza;
        i = zzoaVar.zzb;
        if (i2 < i) {
            return true;
        }
        map = zzoaVar.zzc;
        return !map.isEmpty() && zza().hasNext();
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        int i;
        Object[] objArr;
        this.zzc = true;
        int i2 = this.zzb + 1;
        this.zzb = i2;
        zzoa zzoaVar = this.zza;
        i = zzoaVar.zzb;
        if (i2 >= i) {
            return (Map.Entry) zza().next();
        }
        objArr = zzoaVar.zza;
        return (zznw) objArr[i2];
    }

    @Override // java.util.Iterator
    public final void remove() {
        int i;
        if (!this.zzc) {
            throw new IllegalStateException("remove() was called before next()");
        }
        this.zzc = false;
        zzoa zzoaVar = this.zza;
        zzoaVar.zzo();
        int i2 = this.zzb;
        i = zzoaVar.zzb;
        if (i2 < i) {
            this.zzb = i2 - 1;
            zzoaVar.zzm(i2);
        } else {
            zza().remove();
        }
    }
}
