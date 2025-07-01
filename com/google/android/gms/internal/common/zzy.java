package com.google.android.gms.internal.common;

import java.io.IOException;
import java.util.Iterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-basement@@18.5.0 */
/* loaded from: classes3.dex */
public final class zzy implements Iterable {
    final /* synthetic */ CharSequence zza;
    final /* synthetic */ zzaa zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzy(zzaa zzaaVar, CharSequence charSequence) {
        this.zza = charSequence;
        this.zzb = zzaaVar;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        Iterator zzh;
        zzh = this.zzb.zzh(this.zza);
        return zzh;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        Iterator it = iterator();
        try {
            if (it.hasNext()) {
                sb.append(zzt.zza(it.next(), ", "));
                while (it.hasNext()) {
                    sb.append((CharSequence) ", ");
                    sb.append(zzt.zza(it.next(), ", "));
                }
            }
            sb.append(']');
            return sb.toString();
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }
}
