package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
final class zbvd implements zbvy {
    private static final zbvk zba = new zbvb();
    private final zbvk zbb;

    public zbvd() {
        zbvk zbvkVar = zba;
        int i = zbvu.zba;
        zbvc zbvcVar = new zbvc(zbty.zba(), zbvkVar);
        byte[] bArr = zbuo.zbb;
        this.zbb = zbvcVar;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbvy
    public final zbvx zba(Class cls) {
        int i = zbvz.zba;
        if (!zbuf.class.isAssignableFrom(cls)) {
            int i2 = zbvu.zba;
        }
        zbvj zbb = this.zbb.zbb(cls);
        if (!zbb.zbb()) {
            int i3 = zbvu.zba;
            return zbvp.zbl(cls, zbb, zbvt.zba(), zbuz.zba(), zbvz.zbm(), zbb.zbc() + (-1) != 1 ? zbts.zba() : null, zbvi.zba());
        }
        int i4 = zbvu.zba;
        return zbvq.zbc(zbvz.zbm(), zbts.zba(), zbb.zba());
    }
}
