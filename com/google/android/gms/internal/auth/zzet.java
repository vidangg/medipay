package com.google.android.gms.internal.auth;

import com.google.android.gms.internal.auth.zzet;
import com.google.android.gms.internal.auth.zzev;

/* compiled from: com.google.android.gms:play-services-auth-base@@18.0.10 */
/* loaded from: classes3.dex */
public class zzet<MessageType extends zzev<MessageType, BuilderType>, BuilderType extends zzet<MessageType, BuilderType>> extends zzdp<MessageType, BuilderType> {
    protected zzev zza;
    private final zzev zzb;

    /* JADX INFO: Access modifiers changed from: protected */
    public zzet(MessageType messagetype) {
        this.zzb = messagetype;
        if (!messagetype.zzm()) {
            this.zza = messagetype.zzc();
            return;
        }
        throw new IllegalArgumentException("Default instance must be immutable.");
    }

    @Override // com.google.android.gms.internal.auth.zzdp
    /* renamed from: zzb, reason: merged with bridge method [inline-methods] */
    public final zzet clone() {
        zzet zzetVar = (zzet) this.zzb.zzn(5, null, null);
        zzetVar.zza = zzd();
        return zzetVar;
    }

    @Override // com.google.android.gms.internal.auth.zzfw
    /* renamed from: zzc, reason: merged with bridge method [inline-methods] */
    public MessageType zzd() {
        if (!this.zza.zzm()) {
            return (MessageType) this.zza;
        }
        this.zza.zzi();
        return (MessageType) this.zza;
    }

    @Override // com.google.android.gms.internal.auth.zzfy
    public final /* bridge */ /* synthetic */ zzfx zze() {
        throw null;
    }
}
