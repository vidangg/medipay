package com.google.android.gms.internal.measurement;

import androidx.camera.video.AudioStats;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement@@22.4.0 */
/* loaded from: classes3.dex */
public final class zzx extends zzai {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzx(zzy zzyVar, String str) {
        super("getVersion");
    }

    @Override // com.google.android.gms.internal.measurement.zzai
    public final zzap zza(zzg zzgVar, List list) {
        return new zzah(Double.valueOf(AudioStats.AUDIO_AMPLITUDE_NONE));
    }
}
