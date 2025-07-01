package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
final class zbvc implements zbvk {
    private final zbvk[] zba;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zbvc(zbvk... zbvkVarArr) {
        this.zba = zbvkVarArr;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbvk
    public final zbvj zbb(Class cls) {
        for (int i = 0; i < 2; i++) {
            zbvk zbvkVar = this.zba[i];
            if (zbvkVar.zbc(cls)) {
                return zbvkVar.zbb(cls);
            }
        }
        throw new UnsupportedOperationException("No factory is available for message type: ".concat(String.valueOf(cls.getName())));
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbvk
    public final boolean zbc(Class cls) {
        for (int i = 0; i < 2; i++) {
            if (this.zba[i].zbc(cls)) {
                return true;
            }
        }
        return false;
    }
}
