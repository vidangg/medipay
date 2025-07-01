package com.google.android.gms.measurement.internal;

import android.content.Context;
import com.google.android.gms.common.internal.MethodInvocation;
import com.google.android.gms.common.internal.TelemetryData;
import com.google.android.gms.common.internal.TelemetryLogging;
import com.google.android.gms.common.internal.TelemetryLoggingClient;
import com.google.android.gms.common.internal.TelemetryLoggingOptions;
import com.google.android.gms.tasks.OnFailureListener;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.4.0 */
/* loaded from: classes3.dex */
public final class zzha {
    private static zzha zza;
    private final zzio zzb;
    private final TelemetryLoggingClient zzc;
    private final AtomicLong zzd = new AtomicLong(-1);

    private zzha(Context context, zzio zzioVar) {
        this.zzc = TelemetryLogging.getClient(context, TelemetryLoggingOptions.builder().setApi("measurement:api").build());
        this.zzb = zzioVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzha zza(zzio zzioVar) {
        if (zza == null) {
            zza = new zzha(zzioVar.zzaT(), zzioVar);
        }
        return zza;
    }

    public final synchronized void zzc(int i, int i2, long j, long j2, int i3) {
        final long elapsedRealtime = this.zzb.zzaU().elapsedRealtime();
        AtomicLong atomicLong = this.zzd;
        if (atomicLong.get() != -1 && elapsedRealtime - atomicLong.get() <= 1800000) {
            return;
        }
        this.zzc.log(new TelemetryData(0, Arrays.asList(new MethodInvocation(36301, i2, 0, j, j2, null, null, 0, i3)))).addOnFailureListener(new OnFailureListener() { // from class: com.google.android.gms.measurement.internal.zzgz
            @Override // com.google.android.gms.tasks.OnFailureListener
            public final void onFailure(Exception exc) {
                zzha.this.zzd.set(elapsedRealtime);
            }
        });
    }
}
