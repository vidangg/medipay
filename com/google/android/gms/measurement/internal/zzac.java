package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement@@22.4.0 */
/* loaded from: classes3.dex */
public final class zzac extends zzab {
    final /* synthetic */ zzae zza;
    private final com.google.android.gms.internal.measurement.zzfr zzh;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzac(zzae zzaeVar, String str, int i, com.google.android.gms.internal.measurement.zzfr zzfrVar) {
        super(str, i);
        this.zza = zzaeVar;
        this.zzh = zzfrVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.measurement.internal.zzab
    public final int zza() {
        return this.zzh.zza();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.measurement.internal.zzab
    public final boolean zzb() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.measurement.internal.zzab
    public final boolean zzc() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public final boolean zzd(Long l, Long l2, com.google.android.gms.internal.measurement.zzio zzioVar, boolean z) {
        com.google.android.gms.internal.measurement.zzpq.zzb();
        zzio zzioVar2 = this.zza.zzu;
        boolean zzx = zzioVar2.zzf().zzx(this.zzb, zzgi.zzaC);
        com.google.android.gms.internal.measurement.zzfr zzfrVar = this.zzh;
        boolean zzg = zzfrVar.zzg();
        boolean zzh = zzfrVar.zzh();
        boolean zzi = zzfrVar.zzi();
        Object[] objArr = zzg || zzh || zzi;
        Boolean bool = null;
        bool = null;
        bool = null;
        bool = null;
        bool = null;
        if (!z || objArr != false) {
            com.google.android.gms.internal.measurement.zzfl zzb = zzfrVar.zzb();
            boolean zzg2 = zzb.zzg();
            if (zzioVar.zzt()) {
                if (!zzb.zzi()) {
                    zzioVar2.zzaW().zzk().zzb("No number filter for long property. property", zzioVar2.zzj().zzf(zzioVar.zzg()));
                } else {
                    bool = zzj(zzh(zzioVar.zzc(), zzb.zzc()), zzg2);
                }
            } else if (zzioVar.zzr()) {
                if (!zzb.zzi()) {
                    zzioVar2.zzaW().zzk().zzb("No number filter for double property. property", zzioVar2.zzj().zzf(zzioVar.zzg()));
                } else {
                    bool = zzj(zzg(zzioVar.zza(), zzb.zzc()), zzg2);
                }
            } else if (zzioVar.zzv()) {
                if (!zzb.zzk()) {
                    if (!zzb.zzi()) {
                        zzioVar2.zzaW().zzk().zzb("No string or number filter defined. property", zzioVar2.zzj().zzf(zzioVar.zzg()));
                    } else if (zzqa.zzA(zzioVar.zzh())) {
                        bool = zzj(zzi(zzioVar.zzh(), zzb.zzc()), zzg2);
                    } else {
                        zzioVar2.zzaW().zzk().zzc("Invalid user property value for Numeric number filter. property, value", zzioVar2.zzj().zzf(zzioVar.zzg()), zzioVar.zzh());
                    }
                } else {
                    bool = zzj(zzf(zzioVar.zzh(), zzb.zzd(), zzioVar2.zzaW()), zzg2);
                }
            } else {
                zzioVar2.zzaW().zzk().zzb("User property has no value, property", zzioVar2.zzj().zzf(zzioVar.zzg()));
            }
            zzioVar2.zzaW().zzj().zzb("Property filter result", bool == null ? "null" : bool);
            if (bool == null) {
                return false;
            }
            this.zzd = true;
            if (zzi && !bool.booleanValue()) {
                return true;
            }
            if (!z || zzfrVar.zzg()) {
                this.zze = bool;
            }
            if (bool.booleanValue() && objArr != false && zzioVar.zzu()) {
                long zzd = zzioVar.zzd();
                if (l != null) {
                    zzd = l.longValue();
                }
                if (zzx && zzfrVar.zzg() && !zzfrVar.zzh() && l2 != null) {
                    zzd = l2.longValue();
                }
                if (zzfrVar.zzh()) {
                    this.zzg = Long.valueOf(zzd);
                } else {
                    this.zzf = Long.valueOf(zzd);
                }
            }
            return true;
        }
        zzioVar2.zzaW().zzj().zzc("Property filter already evaluated true and it is not associated with an enhanced audience. audience ID, filter ID", Integer.valueOf(this.zzc), zzfrVar.zzj() ? Integer.valueOf(zzfrVar.zza()) : null);
        return true;
    }
}
