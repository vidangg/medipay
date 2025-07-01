package com.google.android.gms.internal.measurement;

import androidx.camera.video.AudioStats;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-measurement@@22.4.0 */
/* loaded from: classes3.dex */
public final class zzc {
    final zzf zza;
    zzg zzb;
    final zzab zzc;
    private final zzz zzd;

    public zzc() {
        zzf zzfVar = new zzf();
        this.zza = zzfVar;
        this.zzb = zzfVar.zzb.zza();
        this.zzc = new zzab();
        this.zzd = new zzz();
        zzfVar.zzd.zza("internal.registerCallback", new Callable() { // from class: com.google.android.gms.internal.measurement.zza
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return zzc.zzb(zzc.this);
            }
        });
        zzfVar.zzd.zza("internal.eventLogger", new Callable() { // from class: com.google.android.gms.internal.measurement.zzb
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return new zzk(zzc.this.zzc);
            }
        });
    }

    public static /* synthetic */ zzai zzb(zzc zzcVar) {
        return new zzv(zzcVar.zzd);
    }

    public final zzab zza() {
        return this.zzc;
    }

    public final void zzc(zziv zzivVar) throws zzd {
        zzai zzaiVar;
        try {
            zzf zzfVar = this.zza;
            this.zzb = zzfVar.zzb.zza();
            if (zzfVar.zza(this.zzb, (zziz[]) zzivVar.zzc().toArray(new zziz[0])) instanceof zzag) {
                throw new IllegalStateException("Program loading failed");
            }
            for (zzit zzitVar : zzivVar.zza().zzd()) {
                List zzc = zzitVar.zzc();
                String zzb = zzitVar.zzb();
                Iterator it = zzc.iterator();
                while (it.hasNext()) {
                    zzap zza = zzfVar.zza(this.zzb, (zziz) it.next());
                    if (zza instanceof zzam) {
                        zzg zzgVar = this.zzb;
                        if (zzgVar.zzh(zzb)) {
                            zzap zzd = zzgVar.zzd(zzb);
                            if (zzd instanceof zzai) {
                                zzaiVar = (zzai) zzd;
                            } else {
                                throw new IllegalStateException("Invalid function name: ".concat(String.valueOf(zzb)));
                            }
                        } else {
                            zzaiVar = null;
                        }
                        if (zzaiVar != null) {
                            zzaiVar.zza(this.zzb, Collections.singletonList(zza));
                        } else {
                            throw new IllegalStateException("Rule function is undefined: ".concat(String.valueOf(zzb)));
                        }
                    } else {
                        throw new IllegalArgumentException("Invalid rule definition");
                    }
                }
            }
        } catch (Throwable th) {
            throw new zzd(th);
        }
    }

    public final void zzd(String str, Callable callable) {
        this.zza.zzd.zza(str, callable);
    }

    public final boolean zze(zzaa zzaaVar) throws zzd {
        try {
            zzab zzabVar = this.zzc;
            zzabVar.zzd(zzaaVar);
            this.zza.zzc.zzg("runtime.counter", new zzah(Double.valueOf(AudioStats.AUDIO_AMPLITUDE_NONE)));
            this.zzd.zzb(this.zzb.zza(), zzabVar);
            if (zzg()) {
                return true;
            }
            return zzf();
        } catch (Throwable th) {
            throw new zzd(th);
        }
    }

    public final boolean zzf() {
        return !this.zzc.zzc().isEmpty();
    }

    public final boolean zzg() {
        zzab zzabVar = this.zzc;
        return !zzabVar.zzb().equals(zzabVar.zza());
    }
}
