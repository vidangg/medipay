package com.google.android.gms.internal.vision;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: Add missing generic type declarations: [V, K] */
/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
/* loaded from: classes3.dex */
final class zzlj<K, V> implements Iterator<Map.Entry<K, V>> {
    private int zza;
    private Iterator<Map.Entry<K, V>> zzb;
    private final /* synthetic */ zzlh zzc;

    private zzlj(zzlh zzlhVar) {
        List list;
        this.zzc = zzlhVar;
        list = zzlhVar.zzb;
        this.zza = list.size();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        List list;
        int i = this.zza;
        if (i > 0) {
            list = this.zzc.zzb;
            if (i <= list.size()) {
                return true;
            }
        }
        return zza().hasNext();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }

    private final Iterator<Map.Entry<K, V>> zza() {
        Map map;
        if (this.zzb == null) {
            map = this.zzc.zzf;
            this.zzb = map.entrySet().iterator();
        }
        return this.zzb;
    }

    @Override // java.util.Iterator
    public final /* synthetic */ Object next() {
        List list;
        if (zza().hasNext()) {
            return zza().next();
        }
        list = this.zzc.zzb;
        int i = this.zza - 1;
        this.zza = i;
        return (Map.Entry) list.get(i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzlj(zzlh zzlhVar, zzlg zzlgVar) {
        this(zzlhVar);
    }
}
