package com.google.android.gms.internal.mlkit_vision_face_bundled;

import com.google.android.gms.internal.mlkit_vision_face_bundled.zzuq;
import com.google.android.gms.internal.mlkit_vision_face_bundled.zzuw;

/* compiled from: com.google.mlkit:face-detection@@16.1.7 */
/* loaded from: classes3.dex */
public class zzuq<MessageType extends zzuw<MessageType, BuilderType>, BuilderType extends zzuq<MessageType, BuilderType>> extends zzte<MessageType, BuilderType> {
    protected zzuw zza;
    private final zzuw zzb;

    /* JADX INFO: Access modifiers changed from: protected */
    public zzuq(MessageType messagetype) {
        this.zzb = messagetype;
        if (!messagetype.zzI()) {
            this.zza = messagetype.zzy();
            return;
        }
        throw new IllegalArgumentException("Default instance must be immutable.");
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzte
    /* renamed from: zzm, reason: merged with bridge method [inline-methods] */
    public final zzuq clone() {
        zzuq zzuqVar = (zzuq) this.zzb.zzf(5, null, null);
        zzuqVar.zza = zzp();
        return zzuqVar;
    }

    public final MessageType zzn() {
        MessageType zzp = zzp();
        if (zzuw.zzH(zzp, true)) {
            return zzp;
        }
        throw new zzwu(zzp);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzvv
    /* renamed from: zzo, reason: merged with bridge method [inline-methods] */
    public MessageType zzp() {
        if (!this.zza.zzI()) {
            return (MessageType) this.zza;
        }
        this.zza.zzD();
        return (MessageType) this.zza;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzvx
    public final /* bridge */ /* synthetic */ zzvw zzq() {
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzr() {
        if (this.zza.zzI()) {
            return;
        }
        zzs();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void zzs() {
        zzuw zzy = this.zzb.zzy();
        zzwe.zza().zzb(zzy.getClass()).zzg(zzy, this.zza);
        this.zza = zzy;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzvx
    public final boolean zzt() {
        return zzuw.zzH(this.zza, false);
    }
}
