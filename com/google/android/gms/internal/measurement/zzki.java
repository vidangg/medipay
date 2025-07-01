package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.net.Uri;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.4.0 */
/* loaded from: classes3.dex */
public abstract class zzki {
    public static final /* synthetic */ int zzc = 0;
    private static final Object zzd = new Object();

    @Nullable
    private static volatile zzkg zze = null;
    private static volatile boolean zzf = false;
    private static final AtomicInteger zzg;
    final zzkf zza;
    final String zzb;
    private Object zzh;
    private volatile int zzi = -1;
    private volatile Object zzj;
    private volatile boolean zzk;

    static {
        new AtomicReference();
        Preconditions.checkNotNull(new Object() { // from class: com.google.android.gms.internal.measurement.zzka
        }, "BuildInfo must be non-null");
        zzg = new AtomicInteger();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzki(zzkf zzkfVar, String str, Object obj, boolean z, zzkh zzkhVar) {
        if (zzkfVar.zza == null) {
            throw new IllegalArgumentException("Must pass a valid SharedPreferences file name or ContentProvider URI");
        }
        this.zza = zzkfVar;
        this.zzb = str;
        this.zzh = obj;
        this.zzk = false;
    }

    public static void zzc() {
        zzg.incrementAndGet();
    }

    public static void zzd(final Context context) {
        if (zze != null || context == null) {
            return;
        }
        Object obj = zzd;
        synchronized (obj) {
            if (zze == null) {
                synchronized (obj) {
                    zzkg zzkgVar = zze;
                    Context applicationContext = context.getApplicationContext();
                    if (applicationContext != null) {
                        context = applicationContext;
                    }
                    if (zzkgVar == null || zzkgVar.zza() != context) {
                        if (zzkgVar != null) {
                            zzjm.zze();
                            zzkk.zzd();
                            zzju.zze();
                        }
                        zze = new zzjj(context, Suppliers.memoize(new Supplier() { // from class: com.google.android.gms.internal.measurement.zzjz
                            @Override // com.google.common.base.Supplier
                            public final Object get() {
                                int i = zzki.zzc;
                                return zzjv.zza(context);
                            }
                        }));
                        zzg.incrementAndGet();
                    }
                }
            }
        }
    }

    @Nullable
    abstract Object zza(Object obj);

    /* JADX WARN: Removed duplicated region for block: B:15:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0058 A[Catch: all -> 0x00cf, TryCatch #0 {, blocks: (B:5:0x000b, B:7:0x000f, B:9:0x0018, B:11:0x001e, B:13:0x0034, B:16:0x004d, B:18:0x0058, B:20:0x0062, B:22:0x008b, B:24:0x0093, B:27:0x00ba, B:30:0x00c2, B:31:0x00c5, B:32:0x00c9, B:33:0x009c, B:35:0x00a0, B:37:0x00b0, B:39:0x00b6, B:43:0x0076, B:46:0x00cd), top: B:4:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x009c A[Catch: all -> 0x00cf, TryCatch #0 {, blocks: (B:5:0x000b, B:7:0x000f, B:9:0x0018, B:11:0x001e, B:13:0x0034, B:16:0x004d, B:18:0x0058, B:20:0x0062, B:22:0x008b, B:24:0x0093, B:27:0x00ba, B:30:0x00c2, B:31:0x00c5, B:32:0x00c9, B:33:0x009c, B:35:0x00a0, B:37:0x00b0, B:39:0x00b6, B:43:0x0076, B:46:0x00cd), top: B:4:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0076 A[Catch: all -> 0x00cf, TryCatch #0 {, blocks: (B:5:0x000b, B:7:0x000f, B:9:0x0018, B:11:0x001e, B:13:0x0034, B:16:0x004d, B:18:0x0058, B:20:0x0062, B:22:0x008b, B:24:0x0093, B:27:0x00ba, B:30:0x00c2, B:31:0x00c5, B:32:0x00c9, B:33:0x009c, B:35:0x00a0, B:37:0x00b0, B:39:0x00b6, B:43:0x0076, B:46:0x00cd), top: B:4:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x004c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object zzb() {
        String str;
        Uri uri;
        zzjr zza;
        Object zza2;
        String zzb;
        Object zzb2;
        int i = zzg.get();
        if (this.zzi < i) {
            synchronized (this) {
                if (this.zzi < i) {
                    zzkg zzkgVar = zze;
                    Optional absent = Optional.absent();
                    Object obj = null;
                    if (zzkgVar != null && zzkgVar.zzb() != null) {
                        absent = (Optional) ((Supplier) Preconditions.checkNotNull(zzkgVar.zzb())).get();
                        if (absent.isPresent()) {
                            zzjo zzjoVar = (zzjo) absent.get();
                            zzkf zzkfVar = this.zza;
                            str = zzjoVar.zza(zzkfVar.zza, null, zzkfVar.zzc, this.zzb);
                            Preconditions.checkState(zzkgVar == null, "Must call PhenotypeFlagInitializer.maybeInit() first");
                            zzkf zzkfVar2 = this.zza;
                            uri = zzkfVar2.zza;
                            if (uri == null) {
                                zza = zzjw.zza(zzkgVar.zza(), uri) ? zzjm.zza(zzkgVar.zza().getContentResolver(), uri, new Runnable() { // from class: com.google.android.gms.internal.measurement.zzjy
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        zzki.zzc();
                                    }
                                }) : null;
                            } else {
                                zza = zzkk.zza(zzkgVar.zza(), (String) Preconditions.checkNotNull(null), new Runnable() { // from class: com.google.android.gms.internal.measurement.zzjy
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        zzki.zzc();
                                    }
                                });
                            }
                            zza2 = (zza != null || (zzb2 = zza.zzb(this.zzb)) == null) ? null : zza(zzb2);
                            if (zza2 == null) {
                                if (!zzkfVar2.zzd && (zzb = zzju.zza(zzkgVar.zza()).zzb(this.zzb)) != null) {
                                    obj = zza(zzb);
                                }
                                zza2 = obj == null ? this.zzh : obj;
                            }
                            if (absent.isPresent()) {
                                zza2 = str == null ? this.zzh : zza(str);
                            }
                            this.zzj = zza2;
                            this.zzi = i;
                        }
                    }
                    str = null;
                    Preconditions.checkState(zzkgVar == null, "Must call PhenotypeFlagInitializer.maybeInit() first");
                    zzkf zzkfVar22 = this.zza;
                    uri = zzkfVar22.zza;
                    if (uri == null) {
                    }
                    if (zza != null) {
                    }
                    if (zza2 == null) {
                    }
                    if (absent.isPresent()) {
                    }
                    this.zzj = zza2;
                    this.zzi = i;
                }
            }
        }
        return this.zzj;
    }
}
