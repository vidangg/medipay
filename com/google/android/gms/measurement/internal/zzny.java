package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.stats.ConnectionTracker;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.4.0 */
/* loaded from: classes3.dex */
public final class zzny extends zzg {
    private final zznx zza;
    private zzgl zzb;
    private volatile Boolean zzc;
    private final zzaz zzd;
    private ScheduledExecutorService zze;
    private final zzou zzf;
    private final List zzg;
    private final zzaz zzh;

    /* JADX INFO: Access modifiers changed from: protected */
    public zzny(zzio zzioVar) {
        super(zzioVar);
        this.zzg = new ArrayList();
        this.zzf = new zzou(zzioVar.zzaU());
        this.zza = new zznx(this);
        this.zzd = new zzne(this, zzioVar);
        this.zzh = new zzni(this, zzioVar);
    }

    private final zzr zzae(boolean z) {
        Pair zza;
        zzio zzioVar = this.zzu;
        zzioVar.zzaV();
        zzgs zzh = this.zzu.zzh();
        String str = null;
        if (z) {
            zzio zzioVar2 = zzioVar.zzaW().zzu;
            if (zzioVar2.zzm().zzb != null && (zza = zzioVar2.zzm().zzb.zza()) != null && zza != zzht.zza) {
                str = String.valueOf(zza.second) + ":" + ((String) zza.first);
            }
        }
        return zzh.zzk(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzaf() {
        zzg();
        zzhc zzj = this.zzu.zzaW().zzj();
        List list = this.zzg;
        zzj.zzb("Processing queued up service tasks", Integer.valueOf(list.size()));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            try {
                ((Runnable) it.next()).run();
            } catch (RuntimeException e) {
                this.zzu.zzaW().zze().zzb("Task exception while flushing queue", e);
            }
        }
        this.zzg.clear();
        this.zzh.zzb();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzag() {
        zzg();
        this.zzf.zzb();
        this.zzu.zzf();
        this.zzd.zzd(((Long) zzgi.zzX.zza(null)).longValue());
    }

    private final void zzah(Runnable runnable) throws IllegalStateException {
        zzg();
        if (zzaa()) {
            runnable.run();
            return;
        }
        List list = this.zzg;
        long size = list.size();
        zzio zzioVar = this.zzu;
        zzioVar.zzf();
        if (size >= 1000) {
            zzioVar.zzaW().zze().zza("Discarding data. Max runnable queue size reached");
            return;
        }
        list.add(runnable);
        this.zzh.zzd(60000L);
        zzB();
    }

    private final boolean zzai() {
        this.zzu.zzaV();
        return true;
    }

    public static /* synthetic */ void zzp(zzny zznyVar) {
        zzgl zzglVar = zznyVar.zzb;
        if (zzglVar == null) {
            zznyVar.zzu.zzaW().zze().zza("Failed to send storage consent settings to service");
            return;
        }
        try {
            zzr zzae = zznyVar.zzae(false);
            Preconditions.checkNotNull(zzae);
            zzglVar.zzA(zzae);
            zznyVar.zzag();
        } catch (RemoteException e) {
            zznyVar.zzu.zzaW().zze().zzb("Failed to send storage consent settings to the service", e);
        }
    }

    public static /* synthetic */ void zzq(zzny zznyVar, AtomicReference atomicReference, zzr zzrVar, zzpc zzpcVar) {
        zzgl zzglVar;
        synchronized (atomicReference) {
            try {
                zzglVar = zznyVar.zzb;
            } catch (RemoteException e) {
                zznyVar.zzu.zzaW().zze().zzb("[sgtm] Failed to get upload batches; remote exception", e);
                atomicReference.notifyAll();
            }
            if (zzglVar == null) {
                zznyVar.zzu.zzaW().zze().zza("[sgtm] Failed to get upload batches; not connected to service");
                return;
            }
            Preconditions.checkNotNull(zzrVar);
            zzglVar.zzo(zzrVar, zzpcVar, new zzmx(zznyVar, atomicReference));
            zznyVar.zzag();
        }
    }

    public static /* synthetic */ void zzr(zzny zznyVar, AtomicReference atomicReference, zzr zzrVar, Bundle bundle) {
        zzgl zzglVar;
        synchronized (atomicReference) {
            try {
                zzglVar = zznyVar.zzb;
            } catch (RemoteException e) {
                zznyVar.zzu.zzaW().zze().zzb("Failed to request trigger URIs; remote exception", e);
                atomicReference.notifyAll();
            }
            if (zzglVar == null) {
                zznyVar.zzu.zzaW().zze().zza("Failed to request trigger URIs; not connected to service");
                return;
            }
            Preconditions.checkNotNull(zzrVar);
            zzglVar.zzr(zzrVar, bundle, new zzmw(zznyVar, atomicReference));
            zznyVar.zzag();
        }
    }

    public static /* synthetic */ void zzs(zzny zznyVar, zzr zzrVar, zzag zzagVar) {
        zzgl zzglVar = zznyVar.zzb;
        if (zzglVar == null) {
            zznyVar.zzu.zzaW().zze().zza("[sgtm] Discarding data. Failed to update batch upload status.");
            return;
        }
        try {
            zzglVar.zzC(zzrVar, zzagVar);
            zznyVar.zzag();
        } catch (RemoteException e) {
            zznyVar.zzu.zzaW().zze().zzc("[sgtm] Failed to update batch upload status, rowId, exception", Long.valueOf(zzagVar.zza), e);
        }
    }

    public static /* synthetic */ void zzt(zzny zznyVar) {
        zzgl zzglVar = zznyVar.zzb;
        if (zzglVar == null) {
            zznyVar.zzu.zzaW().zze().zza("Failed to send Dma consent settings to service");
            return;
        }
        try {
            zzr zzae = zznyVar.zzae(false);
            Preconditions.checkNotNull(zzae);
            zzglVar.zzy(zzae);
            zznyVar.zzag();
        } catch (RemoteException e) {
            zznyVar.zzu.zzaW().zze().zzb("Failed to send Dma consent settings to the service", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ void zzx(zzny zznyVar, ComponentName componentName) {
        zznyVar.zzg();
        if (zznyVar.zzb != null) {
            zznyVar.zzb = null;
            zznyVar.zzu.zzaW().zzj().zzb("Disconnected from device MeasurementService", componentName);
            zznyVar.zzg();
            zznyVar.zzB();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzA() {
        zzg();
        zza();
        zzr zzae = zzae(true);
        zzai();
        this.zzu.zzf().zzx(null, zzgi.zzbl);
        this.zzu.zzi().zzk();
        zzah(new zznc(this, zzae, true));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzB() {
        zzg();
        zza();
        if (zzaa()) {
            return;
        }
        if (!zzad()) {
            zzio zzioVar = this.zzu;
            if (zzioVar.zzf().zzC()) {
                return;
            }
            zzioVar.zzaV();
            List<ResolveInfo> queryIntentServices = zzioVar.zzaT().getPackageManager().queryIntentServices(new Intent().setClassName(zzioVar.zzaT(), "com.google.android.gms.measurement.AppMeasurementService"), 65536);
            if (queryIntentServices == null || queryIntentServices.isEmpty()) {
                zzioVar.zzaW().zze().zza("Unable to use remote or local measurement implementation. Please register the AppMeasurementService service in the app manifest");
                return;
            }
            Intent intent = new Intent("com.google.android.gms.measurement.START");
            Context zzaT = zzioVar.zzaT();
            zzioVar.zzaV();
            intent.setComponent(new ComponentName(zzaT, "com.google.android.gms.measurement.AppMeasurementService"));
            this.zza.zzb(intent);
            return;
        }
        this.zza.zzc();
    }

    public final void zzC() {
        zzg();
        zza();
        zznx zznxVar = this.zza;
        zznxVar.zzd();
        try {
            ConnectionTracker.getInstance().unbindService(this.zzu.zzaT(), zznxVar);
        } catch (IllegalArgumentException | IllegalStateException unused) {
        }
        this.zzb = null;
    }

    public final void zzD(com.google.android.gms.internal.measurement.zzcy zzcyVar) {
        zzg();
        zza();
        zzah(new zznb(this, zzae(false), zzcyVar));
    }

    public final void zzE(AtomicReference atomicReference) {
        zzg();
        zza();
        zzah(new zzna(this, atomicReference, zzae(false)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzF(com.google.android.gms.internal.measurement.zzcy zzcyVar, String str, String str2) {
        zzg();
        zza();
        zzah(new zzno(this, str, str2, zzae(false), zzcyVar));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzG(AtomicReference atomicReference, String str, String str2, String str3) {
        zzg();
        zza();
        zzah(new zznn(this, atomicReference, null, str2, str3, zzae(false)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzH(final AtomicReference atomicReference, final Bundle bundle) {
        zzg();
        zza();
        final zzr zzae = zzae(false);
        zzah(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzms
            @Override // java.lang.Runnable
            public final void run() {
                zzny.zzr(zzny.this, atomicReference, zzae, bundle);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzI(final AtomicReference atomicReference, final zzpc zzpcVar) {
        zzg();
        zza();
        final zzr zzae = zzae(false);
        zzah(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzmt
            @Override // java.lang.Runnable
            public final void run() {
                zzny.zzq(zzny.this, atomicReference, zzae, zzpcVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzJ(AtomicReference atomicReference, boolean z) {
        zzg();
        zza();
        zzah(new zzmv(this, atomicReference, zzae(false), z));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzK(com.google.android.gms.internal.measurement.zzcy zzcyVar, String str, String str2, boolean z) {
        zzg();
        zza();
        zzah(new zzmu(this, str, str2, zzae(false), z, zzcyVar));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzL(AtomicReference atomicReference, String str, String str2, String str3, boolean z) {
        zzg();
        zza();
        zzah(new zznp(this, atomicReference, null, str2, str3, zzae(false), z));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzM(zzbh zzbhVar, String str) {
        Preconditions.checkNotNull(zzbhVar);
        zzg();
        zza();
        zzai();
        zzah(new zznl(this, true, zzae(true), this.zzu.zzi().zzp(zzbhVar), zzbhVar, str));
    }

    public final void zzN(com.google.android.gms.internal.measurement.zzcy zzcyVar, zzbh zzbhVar, String str) {
        zzg();
        zza();
        zzio zzioVar = this.zzu;
        if (zzioVar.zzw().zzp(GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE) != 0) {
            zzioVar.zzaW().zzk().zza("Not bundling data. Service unavailable or out of date");
            zzioVar.zzw().zzW(zzcyVar, new byte[0]);
        } else {
            zzah(new zznh(this, zzbhVar, str, zzcyVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzO() {
        zzg();
        zza();
        zzr zzae = zzae(false);
        zzai();
        this.zzu.zzi().zzj();
        zzah(new zzmz(this, zzae));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x01aa  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zzP(zzgl zzglVar, AbstractSafeParcelable abstractSafeParcelable, zzr zzrVar) {
        int i;
        String str;
        long j;
        long j2;
        zzio zzioVar;
        long currentTimeMillis;
        long j3;
        zzg();
        zza();
        zzai();
        zzio zzioVar2 = this.zzu;
        zzioVar2.zzf();
        zzr zzrVar2 = zzrVar;
        int i2 = 100;
        int i3 = 0;
        for (int i4 = 100; i3 < 1001 && i2 == i4; i4 = 100) {
            zzio zzioVar3 = this.zzu;
            ArrayList arrayList = new ArrayList();
            List zzi = zzioVar3.zzi().zzi(i4);
            if (zzi != null) {
                arrayList.addAll(zzi);
                i2 = zzi.size();
            } else {
                i2 = 0;
            }
            if (abstractSafeParcelable != null && i2 < i4) {
                arrayList.add(new zzgu(abstractSafeParcelable, zzrVar2.zzc, zzrVar2.zzj));
            }
            String str2 = null;
            boolean zzx = zzioVar2.zzf().zzx(null, zzgi.zzaU);
            int size = arrayList.size();
            int i5 = 0;
            while (i5 < size) {
                zzgu zzguVar = (zzgu) arrayList.get(i5);
                AbstractSafeParcelable abstractSafeParcelable2 = zzguVar.zza;
                if (zzioVar2.zzf().zzx(str2, zzgi.zzbl)) {
                    String str3 = zzguVar.zzb;
                    if (!TextUtils.isEmpty(str3)) {
                        i = i5;
                        zzrVar2 = new zzr(zzrVar2.zza, zzrVar2.zzb, str3, zzguVar.zzc, zzrVar2.zzd, zzrVar2.zze, zzrVar2.zzf, zzrVar2.zzg, zzrVar2.zzh, zzrVar2.zzi, zzrVar2.zzk, zzrVar2.zzl, zzrVar2.zzm, zzrVar2.zzn, zzrVar2.zzo, zzrVar2.zzp, zzrVar2.zzq, zzrVar2.zzr, zzrVar2.zzs, zzrVar2.zzt, zzrVar2.zzu, zzrVar2.zzv, zzrVar2.zzw, zzrVar2.zzx, zzrVar2.zzy, zzrVar2.zzz, zzrVar2.zzA, zzrVar2.zzB, zzrVar2.zzC, zzrVar2.zzD, zzrVar2.zzE, zzrVar2.zzF, zzrVar2.zzG);
                        zzr zzrVar3 = zzrVar2;
                        if (!(abstractSafeParcelable2 instanceof zzbh)) {
                            if (zzx) {
                                try {
                                    zzioVar = this.zzu;
                                    currentTimeMillis = zzioVar.zzaU().currentTimeMillis();
                                } catch (RemoteException e) {
                                    e = e;
                                    j = 0;
                                    j2 = 0;
                                }
                                try {
                                    j3 = currentTimeMillis;
                                    j2 = zzioVar.zzaU().elapsedRealtime();
                                } catch (RemoteException e2) {
                                    e = e2;
                                    j2 = 0;
                                    j = currentTimeMillis;
                                    this.zzu.zzaW().zze().zzb("Failed to send event to the service", e);
                                    if (zzx) {
                                        zzio zzioVar4 = this.zzu;
                                        zzha.zza(zzioVar4).zzc(36301, 13, j, zzioVar4.zzaU().currentTimeMillis(), (int) (zzioVar4.zzaU().elapsedRealtime() - j2));
                                    }
                                    str = null;
                                    i5 = i + 1;
                                    zzrVar2 = zzrVar3;
                                    str2 = str;
                                }
                            } else {
                                j3 = 0;
                                j2 = 0;
                            }
                            try {
                                zzglVar.zzp((zzbh) abstractSafeParcelable2, zzrVar3);
                                if (zzx) {
                                    zzioVar2.zzaW().zzj().zza("Logging telemetry for logEvent from database");
                                    zzio zzioVar5 = this.zzu;
                                    zzha.zza(zzioVar5).zzc(36301, 0, j3, zzioVar5.zzaU().currentTimeMillis(), (int) (zzioVar5.zzaU().elapsedRealtime() - j2));
                                }
                            } catch (RemoteException e3) {
                                e = e3;
                                j = j3;
                                this.zzu.zzaW().zze().zzb("Failed to send event to the service", e);
                                if (zzx && j != 0) {
                                    zzio zzioVar42 = this.zzu;
                                    zzha.zza(zzioVar42).zzc(36301, 13, j, zzioVar42.zzaU().currentTimeMillis(), (int) (zzioVar42.zzaU().elapsedRealtime() - j2));
                                }
                                str = null;
                                i5 = i + 1;
                                zzrVar2 = zzrVar3;
                                str2 = str;
                            }
                        } else if (abstractSafeParcelable2 instanceof zzqb) {
                            try {
                                zzglVar.zzB((zzqb) abstractSafeParcelable2, zzrVar3);
                            } catch (RemoteException e4) {
                                this.zzu.zzaW().zze().zzb("Failed to send user property to the service", e4);
                            }
                        } else if (abstractSafeParcelable2 instanceof zzai) {
                            try {
                                zzglVar.zzt((zzai) abstractSafeParcelable2, zzrVar3);
                            } catch (RemoteException e5) {
                                this.zzu.zzaW().zze().zzb("Failed to send conditional user property to the service", e5);
                            }
                        } else {
                            zzio zzioVar6 = this.zzu;
                            str = null;
                            if (!zzioVar6.zzf().zzx(null, zzgi.zzbl) || !(abstractSafeParcelable2 instanceof zzbf)) {
                                zzioVar6.zzaW().zze().zza("Discarding data. Unrecognized parcel type.");
                            } else {
                                try {
                                    zzglVar.zzx(((zzbf) abstractSafeParcelable2).zzc(), zzrVar3);
                                } catch (RemoteException e6) {
                                    this.zzu.zzaW().zze().zzb("Failed to send default event parameters to the service", e6);
                                }
                            }
                            i5 = i + 1;
                            zzrVar2 = zzrVar3;
                            str2 = str;
                        }
                        str = null;
                        i5 = i + 1;
                        zzrVar2 = zzrVar3;
                        str2 = str;
                    }
                }
                i = i5;
                zzr zzrVar32 = zzrVar2;
                if (!(abstractSafeParcelable2 instanceof zzbh)) {
                }
                str = null;
                i5 = i + 1;
                zzrVar2 = zzrVar32;
                str2 = str;
            }
            i3++;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzQ(zzai zzaiVar) {
        Preconditions.checkNotNull(zzaiVar);
        zzg();
        zza();
        this.zzu.zzaV();
        zzah(new zznm(this, true, zzae(true), this.zzu.zzi().zzn(zzaiVar), new zzai(zzaiVar), zzaiVar));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzR(boolean z) {
        zzg();
        zza();
        if (zzab()) {
            zzah(new zznk(this, zzae(false)));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzS(zzmh zzmhVar) {
        zzg();
        zza();
        zzah(new zznf(this, zzmhVar));
    }

    public final void zzT(Bundle bundle) {
        zzg();
        zza();
        zzbf zzbfVar = new zzbf(bundle);
        zzai();
        zzah(new zzng(this, true, zzae(false), this.zzu.zzf().zzx(null, zzgi.zzbl) && this.zzu.zzi().zzo(zzbfVar), zzbfVar, bundle));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzU() {
        zzg();
        zza();
        zzah(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzmq
            @Override // java.lang.Runnable
            public final void run() {
                zzny.zzt(zzny.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzV() {
        zzg();
        zza();
        zzah(new zznj(this, zzae(true)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzW(zzgl zzglVar) {
        zzg();
        Preconditions.checkNotNull(zzglVar);
        this.zzb = zzglVar;
        zzag();
        zzaf();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzX(boolean z) {
        zzg();
        zza();
        zzah(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzmp
            @Override // java.lang.Runnable
            public final void run() {
                zzny.zzp(zzny.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzY(zzqb zzqbVar) {
        zzg();
        zza();
        zzai();
        zzah(new zzmy(this, zzae(true), this.zzu.zzi().zzq(zzqbVar), zzqbVar));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzZ(final zzag zzagVar) {
        zzg();
        zza();
        final zzr zzae = zzae(true);
        Preconditions.checkNotNull(zzae);
        zzah(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzmr
            @Override // java.lang.Runnable
            public final void run() {
                zzny.zzs(zzny.this, zzae, zzagVar);
            }
        });
    }

    public final boolean zzaa() {
        zzg();
        zza();
        return this.zzb != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzab() {
        zzg();
        zza();
        return !zzad() || this.zzu.zzw().zzm() >= ((Integer) zzgi.zzaI.zza(null)).intValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzac() {
        zzg();
        zza();
        return !zzad() || this.zzu.zzw().zzm() >= 241200;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0113  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean zzad() {
        zzg();
        zza();
        if (this.zzc == null) {
            zzg();
            zza();
            zzio zzioVar = this.zzu;
            zzht zzm = zzioVar.zzm();
            zzm.zzg();
            boolean z = false;
            Boolean valueOf = !zzm.zzb().contains("use_service") ? null : Boolean.valueOf(zzm.zzb().getBoolean("use_service", false));
            if (valueOf == null || !valueOf.booleanValue()) {
                zzioVar.zzaV();
                if (this.zzu.zzh().zzh() != 1) {
                    zzioVar.zzaW().zzj().zza("Checking service availability");
                    int zzp = zzioVar.zzw().zzp(GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE);
                    if (zzp == 0) {
                        zzioVar.zzaW().zzj().zza("Service available");
                    } else {
                        if (zzp == 1) {
                            zzioVar.zzaW().zzj().zza("Service missing");
                        } else if (zzp != 2) {
                            if (zzp == 3) {
                                zzioVar.zzaW().zzk().zza("Service disabled");
                            } else if (zzp == 9) {
                                zzioVar.zzaW().zzk().zza("Service invalid");
                            } else if (zzp != 18) {
                                zzioVar.zzaW().zzk().zzb("Unexpected service status", Integer.valueOf(zzp));
                            } else {
                                zzioVar.zzaW().zzk().zza("Service updating");
                            }
                            r2 = false;
                        } else {
                            zzioVar.zzaW().zzd().zza("Service container out of date");
                            if (zzioVar.zzw().zzm() >= 17443) {
                                z = valueOf == null;
                                r2 = false;
                            }
                        }
                        if (z && zzioVar.zzf().zzC()) {
                            zzioVar.zzaW().zze().zza("No way to upload. Consider using the full version of Analytics");
                        } else if (r2) {
                            zzht zzm2 = zzioVar.zzm();
                            zzm2.zzg();
                            SharedPreferences.Editor edit = zzm2.zzb().edit();
                            edit.putBoolean("use_service", z);
                            edit.apply();
                        }
                        r2 = z;
                    }
                }
                z = true;
                if (z) {
                }
                if (r2) {
                }
                r2 = z;
            }
            this.zzc = Boolean.valueOf(r2);
        }
        return this.zzc.booleanValue();
    }

    @Override // com.google.android.gms.measurement.internal.zzg
    protected final boolean zzf() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final zzap zzh() {
        zzg();
        zza();
        zzgl zzglVar = this.zzb;
        if (zzglVar == null) {
            zzB();
            this.zzu.zzaW().zzd().zza("Failed to get consents; not connected to service yet.");
            return null;
        }
        zzr zzae = zzae(false);
        Preconditions.checkNotNull(zzae);
        try {
            zzap zze = zzglVar.zze(zzae);
            zzag();
            return zze;
        } catch (RemoteException e) {
            this.zzu.zzaW().zze().zzb("Failed to get consents; remote exception", e);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Boolean zzl() {
        return this.zzc;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzz() {
        zzg();
        zza();
        zzah(new zznd(this, zzae(true)));
    }
}
