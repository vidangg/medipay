package com.google.android.gms.internal.common;

import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-basement@@18.5.0 */
/* loaded from: classes3.dex */
public final class zzah extends zzae {
    public zzah() {
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzah(int i) {
        super(4);
    }

    public final zzah zzb(Object obj) {
        super.zza(obj);
        return this;
    }

    public final zzah zzc(Iterator it) {
        while (it.hasNext()) {
            super.zza(it.next());
        }
        return this;
    }
}
