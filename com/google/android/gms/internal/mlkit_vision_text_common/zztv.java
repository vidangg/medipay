package com.google.android.gms.internal.mlkit_vision_text_common;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition-common@@19.1.0 */
/* loaded from: classes3.dex */
public final class zztv implements zzts {
    final List zza;

    public zztv(Context context, zztu zztuVar) {
        ArrayList arrayList = new ArrayList();
        this.zza = arrayList;
        if (zztuVar.zzc()) {
            arrayList.add(new zzuk(context, zztuVar));
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_common.zzts
    public final void zza(zztr zztrVar) {
        Iterator it = this.zza.iterator();
        while (it.hasNext()) {
            ((zzts) it.next()).zza(zztrVar);
        }
    }
}
