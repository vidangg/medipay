package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
public class zbua extends zbtz implements zbvn {
    /* JADX INFO: Access modifiers changed from: protected */
    public zbua(zbub zbubVar) {
        super(zbubVar);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbtz, com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbvl
    /* renamed from: zbd, reason: merged with bridge method [inline-methods] */
    public final zbub zbl() {
        if (!((zbub) this.zba).zbG()) {
            return (zbub) this.zba;
        }
        ((zbub) this.zba).zbb.zbh();
        return (zbub) super.zbl();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbtz
    public final void zbo() {
        super.zbo();
        if (((zbub) this.zba).zbb != zbtu.zbe()) {
            zbub zbubVar = (zbub) this.zba;
            zbubVar.zbb = zbubVar.zbb.clone();
        }
    }
}
