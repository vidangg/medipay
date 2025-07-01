package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.4.0 */
/* loaded from: classes3.dex */
public final class zzmo extends zzg {
    protected zzmh zza;
    private volatile zzmh zzb;
    private volatile zzmh zzc;
    private final Map zzd;
    private com.google.android.gms.internal.measurement.zzdj zze;
    private volatile boolean zzf;
    private volatile zzmh zzg;
    private zzmh zzh;
    private boolean zzi;
    private final Object zzj;

    public zzmo(zzio zzioVar) {
        super(zzioVar);
        this.zzj = new Object();
        this.zzd = new ConcurrentHashMap();
    }

    private final void zzA(String str, zzmh zzmhVar, boolean z) {
        zzmh zzmhVar2;
        zzmh zzmhVar3 = this.zzb == null ? this.zzc : this.zzb;
        if (zzmhVar.zzb == null) {
            zzmhVar2 = new zzmh(zzmhVar.zza, str != null ? zzl(str, "Activity") : null, zzmhVar.zzc, zzmhVar.zze, zzmhVar.zzf);
        } else {
            zzmhVar2 = zzmhVar;
        }
        this.zzc = this.zzb;
        this.zzb = zzmhVar2;
        zzio zzioVar = this.zzu;
        zzioVar.zzaX().zzq(new zzmj(this, zzmhVar2, zzmhVar3, zzioVar.zzaU().elapsedRealtime(), z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00d1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zzB(zzmh zzmhVar, zzmh zzmhVar2, long j, boolean z, Bundle bundle) {
        boolean z2;
        long j2;
        long j3;
        zzg();
        boolean z3 = false;
        if (zzmhVar2 != null) {
            if (zzmhVar2.zzc == zzmhVar.zzc && Objects.equals(zzmhVar2.zzb, zzmhVar.zzb) && Objects.equals(zzmhVar2.zza, zzmhVar.zza)) {
                z2 = false;
                if (z && this.zza != null) {
                    z3 = true;
                }
                if (z2) {
                    Bundle bundle2 = bundle != null ? new Bundle(bundle) : new Bundle();
                    zzqf.zzN(zzmhVar, bundle2, true);
                    if (zzmhVar2 != null) {
                        String str = zzmhVar2.zza;
                        if (str != null) {
                            bundle2.putString("_pn", str);
                        }
                        String str2 = zzmhVar2.zzb;
                        if (str2 != null) {
                            bundle2.putString("_pc", str2);
                        }
                        bundle2.putLong("_pi", zzmhVar2.zzc);
                    }
                    if (z3) {
                        zzon zzonVar = this.zzu.zzv().zzb;
                        long j4 = j - zzonVar.zzb;
                        zzonVar.zzb = j;
                        if (j4 > 0) {
                            this.zzu.zzw().zzL(bundle2, j4);
                        }
                    }
                    zzio zzioVar = this.zzu;
                    if (!zzioVar.zzf().zzz()) {
                        bundle2.putLong("_mst", 1L);
                    }
                    boolean z4 = zzmhVar.zze;
                    String str3 = true != z4 ? "auto" : "app";
                    long currentTimeMillis = zzioVar.zzaU().currentTimeMillis();
                    if (z4) {
                        j2 = currentTimeMillis;
                        long j5 = zzmhVar.zzf;
                        if (j5 != 0) {
                            j3 = j5;
                            this.zzu.zzq().zzS(str3, "_vs", j3, bundle2);
                        }
                    } else {
                        j2 = currentTimeMillis;
                    }
                    j3 = j2;
                    this.zzu.zzq().zzS(str3, "_vs", j3, bundle2);
                }
                if (z3) {
                    zzC(this.zza, true, j);
                }
                this.zza = zzmhVar;
                if (zzmhVar.zze) {
                    this.zzh = zzmhVar;
                }
                this.zzu.zzu().zzS(zzmhVar);
            }
        }
        z2 = true;
        if (z) {
            z3 = true;
        }
        if (z2) {
        }
        if (z3) {
        }
        this.zza = zzmhVar;
        if (zzmhVar.zze) {
        }
        this.zzu.zzu().zzS(zzmhVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzC(zzmh zzmhVar, boolean z, long j) {
        zzio zzioVar = this.zzu;
        zzio zzioVar2 = this.zzu;
        zzioVar2.zzd().zzf(zzioVar.zzaU().elapsedRealtime());
        if (!zzioVar2.zzv().zzb.zzd(zzmhVar != null && zzmhVar.zzd, z, j) || zzmhVar == null) {
            return;
        }
        zzmhVar.zzd = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ void zzq(zzmo zzmoVar, Bundle bundle, zzmh zzmhVar, zzmh zzmhVar2, long j) {
        bundle.remove(FirebaseAnalytics.Param.SCREEN_NAME);
        bundle.remove(FirebaseAnalytics.Param.SCREEN_CLASS);
        zzmoVar.zzB(zzmhVar, zzmhVar2, j, true, zzmoVar.zzu.zzw().zzA(null, FirebaseAnalytics.Event.SCREEN_VIEW, bundle, null, false));
    }

    private final zzmh zzz(com.google.android.gms.internal.measurement.zzdj zzdjVar) {
        Preconditions.checkNotNull(zzdjVar);
        Integer valueOf = Integer.valueOf(zzdjVar.zza);
        Map map = this.zzd;
        zzmh zzmhVar = (zzmh) map.get(valueOf);
        if (zzmhVar == null) {
            zzmh zzmhVar2 = new zzmh(null, zzl(zzdjVar.zzb, "Activity"), this.zzu.zzw().zzs());
            map.put(valueOf, zzmhVar2);
            zzmhVar = zzmhVar2;
        }
        return this.zzg != null ? this.zzg : zzmhVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzg
    protected final boolean zzf() {
        return false;
    }

    public final zzmh zzi() {
        return this.zzb;
    }

    public final zzmh zzj(boolean z) {
        zza();
        zzg();
        if (!z) {
            return this.zza;
        }
        zzmh zzmhVar = this.zza;
        return zzmhVar != null ? zzmhVar : this.zzh;
    }

    final String zzl(String str, String str2) {
        String str3;
        if (str == null) {
            return "Activity";
        }
        String[] split = str.split("\\.");
        int length = split.length;
        if (length > 0) {
            str3 = split[length - 1];
        } else {
            str3 = "";
        }
        zzio zzioVar = this.zzu;
        return str3.length() > zzioVar.zzf().zzc(null, false) ? str3.substring(0, zzioVar.zzf().zzc(null, false)) : str3;
    }

    public final void zzs(com.google.android.gms.internal.measurement.zzdj zzdjVar, Bundle bundle) {
        Bundle bundle2;
        if (!this.zzu.zzf().zzz() || bundle == null || (bundle2 = bundle.getBundle("com.google.app_measurement.screen_service")) == null) {
            return;
        }
        this.zzd.put(Integer.valueOf(zzdjVar.zza), new zzmh(bundle2.getString("name"), bundle2.getString("referrer_name"), bundle2.getLong(TtmlNode.ATTR_ID)));
    }

    public final void zzt(com.google.android.gms.internal.measurement.zzdj zzdjVar) {
        synchronized (this.zzj) {
            if (Objects.equals(this.zze, zzdjVar)) {
                this.zze = null;
            }
        }
        if (this.zzu.zzf().zzz()) {
            this.zzd.remove(Integer.valueOf(zzdjVar.zza));
        }
    }

    public final void zzu(com.google.android.gms.internal.measurement.zzdj zzdjVar) {
        synchronized (this.zzj) {
            this.zzi = false;
            this.zzf = true;
        }
        zzio zzioVar = this.zzu;
        long elapsedRealtime = zzioVar.zzaU().elapsedRealtime();
        if (!zzioVar.zzf().zzz()) {
            this.zzb = null;
            zzioVar.zzaX().zzq(new zzml(this, elapsedRealtime));
        } else {
            zzmh zzz = zzz(zzdjVar);
            this.zzc = this.zzb;
            this.zzb = null;
            zzioVar.zzaX().zzq(new zzmm(this, zzz, elapsedRealtime));
        }
    }

    public final void zzv(com.google.android.gms.internal.measurement.zzdj zzdjVar) {
        Object obj = this.zzj;
        synchronized (obj) {
            this.zzi = true;
            if (!Objects.equals(zzdjVar, this.zze)) {
                synchronized (obj) {
                    this.zze = zzdjVar;
                    this.zzf = false;
                    zzio zzioVar = this.zzu;
                    if (zzioVar.zzf().zzz()) {
                        this.zzg = null;
                        zzioVar.zzaX().zzq(new zzmn(this));
                    }
                }
            }
        }
        zzio zzioVar2 = this.zzu;
        if (!zzioVar2.zzf().zzz()) {
            this.zzb = this.zzg;
            zzioVar2.zzaX().zzq(new zzmk(this));
            return;
        }
        zzA(zzdjVar.zzb, zzz(zzdjVar), false);
        zzd zzd = this.zzu.zzd();
        zzio zzioVar3 = zzd.zzu;
        zzioVar3.zzaX().zzq(new zzc(zzd, zzioVar3.zzaU().elapsedRealtime()));
    }

    public final void zzw(com.google.android.gms.internal.measurement.zzdj zzdjVar, Bundle bundle) {
        zzmh zzmhVar;
        if (!this.zzu.zzf().zzz() || bundle == null || (zzmhVar = (zzmh) this.zzd.get(Integer.valueOf(zzdjVar.zza))) == null) {
            return;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putLong(TtmlNode.ATTR_ID, zzmhVar.zzc);
        bundle2.putString("name", zzmhVar.zza);
        bundle2.putString("referrer_name", zzmhVar.zzb);
        bundle.putBundle("com.google.app_measurement.screen_service", bundle2);
    }

    @Deprecated
    public final void zzx(com.google.android.gms.internal.measurement.zzdj zzdjVar, String str, String str2) {
        zzio zzioVar = this.zzu;
        if (!zzioVar.zzf().zzz()) {
            zzioVar.zzaW().zzl().zza("setCurrentScreen cannot be called while screen reporting is disabled.");
            return;
        }
        zzmh zzmhVar = this.zzb;
        if (zzmhVar == null) {
            zzioVar.zzaW().zzl().zza("setCurrentScreen cannot be called while no activity active");
            return;
        }
        Map map = this.zzd;
        Integer valueOf = Integer.valueOf(zzdjVar.zza);
        if (map.get(valueOf) == null) {
            zzioVar.zzaW().zzl().zza("setCurrentScreen must be called with an activity in the activity lifecycle");
            return;
        }
        if (str2 == null) {
            str2 = zzl(zzdjVar.zzb, "Activity");
        }
        String str3 = zzmhVar.zzb;
        String str4 = zzmhVar.zza;
        boolean equals = Objects.equals(str3, str2);
        boolean equals2 = Objects.equals(str4, str);
        if (!equals || !equals2) {
            if (str == null || (str.length() > 0 && str.length() <= zzioVar.zzf().zzc(null, false))) {
                if (str2 == null || (str2.length() > 0 && str2.length() <= zzioVar.zzf().zzc(null, false))) {
                    zzioVar.zzaW().zzj().zzc("Setting current screen to name, class", str == null ? "null" : str, str2);
                    zzmh zzmhVar2 = new zzmh(str, str2, zzioVar.zzw().zzs());
                    map.put(valueOf, zzmhVar2);
                    zzA(zzdjVar.zzb, zzmhVar2, true);
                    return;
                }
                zzioVar.zzaW().zzl().zzb("Invalid class name length in setCurrentScreen. Length", Integer.valueOf(str2.length()));
                return;
            }
            zzioVar.zzaW().zzl().zzb("Invalid screen name length in setCurrentScreen. Length", Integer.valueOf(str.length()));
            return;
        }
        zzioVar.zzaW().zzl().zza("setCurrentScreen cannot be called with the same class and name");
    }

    public final void zzy(Bundle bundle, long j) {
        String str;
        synchronized (this.zzj) {
            if (!this.zzi) {
                this.zzu.zzaW().zzl().zza("Cannot log screen view event when the app is in the background.");
                return;
            }
            String string = bundle.getString(FirebaseAnalytics.Param.SCREEN_NAME);
            if (string == null || (string.length() > 0 && string.length() <= this.zzu.zzf().zzc(null, false))) {
                String string2 = bundle.getString(FirebaseAnalytics.Param.SCREEN_CLASS);
                if (string2 == null || (string2.length() > 0 && string2.length() <= this.zzu.zzf().zzc(null, false))) {
                    if (string2 == null) {
                        com.google.android.gms.internal.measurement.zzdj zzdjVar = this.zze;
                        if (zzdjVar != null) {
                            str = zzl(zzdjVar.zzb, "Activity");
                        } else {
                            str = "Activity";
                        }
                        string2 = str;
                    }
                    zzmh zzmhVar = this.zzb;
                    if (this.zzf && zzmhVar != null) {
                        this.zzf = false;
                        boolean equals = Objects.equals(zzmhVar.zzb, string2);
                        boolean equals2 = Objects.equals(zzmhVar.zza, string);
                        if (equals && equals2) {
                            this.zzu.zzaW().zzl().zza("Ignoring call to log screen view event with duplicate parameters.");
                            return;
                        }
                    }
                    zzio zzioVar = this.zzu;
                    zzioVar.zzaW().zzj().zzc("Logging screen view with name, class", string == null ? "null" : string, string2 == null ? "null" : string2);
                    zzmh zzmhVar2 = this.zzb == null ? this.zzc : this.zzb;
                    zzmh zzmhVar3 = new zzmh(string, string2, zzioVar.zzw().zzs(), true, j);
                    this.zzb = zzmhVar3;
                    this.zzc = zzmhVar2;
                    this.zzg = zzmhVar3;
                    zzioVar.zzaX().zzq(new zzmi(this, bundle, zzmhVar3, zzmhVar2, zzioVar.zzaU().elapsedRealtime()));
                    return;
                }
                this.zzu.zzaW().zzl().zzb("Invalid screen class length for screen view. Length", Integer.valueOf(string2.length()));
                return;
            }
            this.zzu.zzaW().zzl().zzb("Invalid screen name length for screen view. Length", Integer.valueOf(string.length()));
        }
    }
}
