package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbtz;
import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
public class zbtz<MessageType extends zbuf<MessageType, BuilderType>, BuilderType extends zbtz<MessageType, BuilderType>> extends zbsi<MessageType, BuilderType> {
    protected zbuf zba;
    private final zbuf zbb;

    /* JADX INFO: Access modifiers changed from: protected */
    public zbtz(MessageType messagetype) {
        this.zbb = messagetype;
        if (!messagetype.zbG()) {
            this.zba = messagetype.zbt();
            return;
        }
        throw new IllegalArgumentException("Default instance must be immutable.");
    }

    private static void zba(Object obj, Object obj2) {
        zbvu.zba().zbb(obj.getClass()).zbg(obj, obj2);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbsi
    /* renamed from: zbg, reason: merged with bridge method [inline-methods] */
    public final zbtz clone() {
        zbtz zbtzVar = (zbtz) this.zbb.zbb(5, null, null);
        zbtzVar.zba = zbl();
        return zbtzVar;
    }

    public final zbtz zbh(zbuf zbufVar) {
        if (!this.zbb.equals(zbufVar)) {
            if (!this.zba.zbG()) {
                zbo();
            }
            zba(this.zba, zbufVar);
        }
        return this;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbvl
    /* renamed from: zbi, reason: merged with bridge method [inline-methods] */
    public final MessageType zbk() {
        MessageType zbl = zbl();
        if (zbuf.zbF(zbl, true)) {
            return zbl;
        }
        throw new zbwk(zbl);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbvl
    /* renamed from: zbj, reason: merged with bridge method [inline-methods] */
    public MessageType zbl() {
        if (!this.zba.zbG()) {
            return (MessageType) this.zba;
        }
        this.zba.zbB();
        return (MessageType) this.zba;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbvn
    public final /* bridge */ /* synthetic */ zbvm zbm() {
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zbn() {
        if (this.zba.zbG()) {
            return;
        }
        zbo();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void zbo() {
        zbuf zbt = this.zbb.zbt();
        zba(zbt, this.zba);
        this.zba = zbt;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbvn
    public final boolean zbp() {
        return zbuf.zbF(this.zba, false);
    }
}
