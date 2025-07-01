package com.google.android.gms.internal.common;

/* compiled from: com.google.android.gms:play-services-basement@@18.5.0 */
/* loaded from: classes3.dex */
final class zzai extends zzad {
    private final zzak zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzai(zzak zzakVar, int i) {
        super(zzakVar.size(), i);
        this.zza = zzakVar;
    }

    @Override // com.google.android.gms.internal.common.zzad
    protected final Object zza(int i) {
        return this.zza.get(i);
    }
}
