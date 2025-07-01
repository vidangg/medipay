package com.google.android.odml.image;

import java.nio.ByteBuffer;

/* compiled from: com.google.android.odml:image@@1.0.0-beta1 */
/* loaded from: classes3.dex */
final class zzf implements zzg {
    private final ByteBuffer zza;
    private final ImageProperties zzb;

    public zzf(ByteBuffer byteBuffer, int i) {
        this.zza = byteBuffer;
        zzb zzbVar = new zzb();
        zzbVar.zzb(2);
        zzbVar.zza(i);
        this.zzb = zzbVar.zzc();
    }

    public final ByteBuffer zza() {
        return this.zza;
    }

    @Override // com.google.android.odml.image.zzg
    public final ImageProperties zzb() {
        return this.zzb;
    }

    @Override // com.google.android.odml.image.zzg
    public final void zzc() {
    }
}
