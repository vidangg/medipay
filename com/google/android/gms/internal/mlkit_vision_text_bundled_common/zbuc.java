package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
public final class zbuc implements zbtt {
    final int zba = 32149011;
    final zbww zbb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zbuc(zbui zbuiVar, int i, zbww zbwwVar, boolean z, boolean z2) {
        this.zbb = zbwwVar;
    }

    @Override // java.lang.Comparable
    public final /* synthetic */ int compareTo(Object obj) {
        int i = ((zbuc) obj).zba;
        return 0;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbtt
    public final int zba() {
        return 32149011;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbtt
    public final zbvl zbb(zbvl zbvlVar, zbvm zbvmVar) {
        zbtz zbtzVar = (zbtz) zbvlVar;
        zbtzVar.zbh((zbuf) zbvmVar);
        return zbtzVar;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbtt
    public final zbvr zbc(zbvr zbvrVar, zbvr zbvrVar2) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbtt
    public final zbww zbd() {
        return this.zbb;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbtt
    public final zbwx zbe() {
        return this.zbb.zbb();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbtt
    public final boolean zbf() {
        return false;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbtt
    public final boolean zbg() {
        return false;
    }
}
