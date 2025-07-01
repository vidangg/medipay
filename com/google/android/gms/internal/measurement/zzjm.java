package com.google.android.gms.internal.measurement;

import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.os.RemoteException;
import android.os.StrictMode;
import android.util.Log;
import androidx.collection.ArrayMap;
import com.google.common.base.Preconditions;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.4.0 */
/* loaded from: classes3.dex */
public final class zzjm implements zzjr {
    private final ContentResolver zzc;
    private final Uri zzd;
    private final Runnable zze;
    private final ContentObserver zzf;
    private volatile Map zzh;
    private static final Map zzb = new ArrayMap();
    public static final String[] zza = {"key", "value"};
    private final Object zzg = new Object();
    private final List zzi = new ArrayList();

    private zzjm(ContentResolver contentResolver, Uri uri, Runnable runnable) {
        Preconditions.checkNotNull(contentResolver);
        Preconditions.checkNotNull(uri);
        this.zzc = contentResolver;
        this.zzd = uri;
        this.zze = runnable;
        this.zzf = new zzjl(this, null);
    }

    public static zzjm zza(ContentResolver contentResolver, Uri uri, Runnable runnable) {
        zzjm zzjmVar;
        synchronized (zzjm.class) {
            Map map = zzb;
            zzjmVar = (zzjm) map.get(uri);
            if (zzjmVar == null) {
                try {
                    zzjm zzjmVar2 = new zzjm(contentResolver, uri, runnable);
                    try {
                        contentResolver.registerContentObserver(uri, false, zzjmVar2.zzf);
                        map.put(uri, zzjmVar2);
                    } catch (SecurityException unused) {
                    }
                    zzjmVar = zzjmVar2;
                } catch (SecurityException unused2) {
                }
            }
        }
        return zzjmVar;
    }

    public static /* synthetic */ Map zzc(zzjm zzjmVar) {
        Map emptyMap;
        Cursor query;
        Map emptyMap2;
        ContentResolver contentResolver = zzjmVar.zzc;
        Uri uri = zzjmVar.zzd;
        ContentProviderClient acquireUnstableContentProviderClient = contentResolver.acquireUnstableContentProviderClient(uri);
        try {
            if (acquireUnstableContentProviderClient == null) {
                Log.w("ConfigurationContentLdr", "Unable to acquire ContentProviderClient, using default values");
                return Collections.emptyMap();
            }
            try {
                query = acquireUnstableContentProviderClient.query(uri, zza, null, null, null);
            } catch (RemoteException e) {
                Log.w("ConfigurationContentLdr", "ContentProvider query failed, using default values", e);
                emptyMap = Collections.emptyMap();
            }
            try {
                if (query == null) {
                    Log.w("ConfigurationContentLdr", "ContentProvider query returned null cursor, using default values");
                    emptyMap = Collections.emptyMap();
                    acquireUnstableContentProviderClient.release();
                    return emptyMap;
                }
                int count = query.getCount();
                if (count == 0) {
                    emptyMap2 = Collections.emptyMap();
                } else {
                    Map arrayMap = count <= 256 ? new ArrayMap(count) : new HashMap(count, 1.0f);
                    while (query.moveToNext()) {
                        arrayMap.put(query.getString(0), query.getString(1));
                    }
                    if (query.isAfterLast()) {
                        query.close();
                        acquireUnstableContentProviderClient.release();
                        return arrayMap;
                    }
                    Log.w("ConfigurationContentLdr", "Cursor read incomplete (ContentProvider dead?), using default values");
                    emptyMap2 = Collections.emptyMap();
                }
                query.close();
                acquireUnstableContentProviderClient.release();
                return emptyMap2;
            } catch (Throwable th) {
                if (query != null) {
                    try {
                        query.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        } catch (Throwable th3) {
            acquireUnstableContentProviderClient.release();
            throw th3;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized void zze() {
        synchronized (zzjm.class) {
            Map map = zzb;
            for (zzjm zzjmVar : map.values()) {
                zzjmVar.zzc.unregisterContentObserver(zzjmVar.zzf);
            }
            map.clear();
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzjr
    public final /* bridge */ /* synthetic */ Object zzb(String str) {
        return (String) zzd().get(str);
    }

    public final Map zzd() {
        Map emptyMap;
        Map map = this.zzh;
        if (map == null) {
            synchronized (this.zzg) {
                map = this.zzh;
                if (map == null) {
                    StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
                    try {
                        try {
                            emptyMap = (Map) zzjp.zza(new zzjq() { // from class: com.google.android.gms.internal.measurement.zzjk
                                @Override // com.google.android.gms.internal.measurement.zzjq
                                public final Object zza() {
                                    return zzjm.zzc(zzjm.this);
                                }
                            });
                        } finally {
                            StrictMode.setThreadPolicy(allowThreadDiskReads);
                        }
                    } catch (SQLiteException | IllegalStateException | SecurityException e) {
                        Log.w("ConfigurationContentLdr", "Unable to query ContentProvider, using default values", e);
                        emptyMap = Collections.emptyMap();
                    }
                    this.zzh = emptyMap;
                    map = emptyMap;
                }
            }
        }
        return map != null ? map : Collections.emptyMap();
    }

    public final void zzf() {
        synchronized (this.zzg) {
            this.zzh = null;
            this.zze.run();
        }
        synchronized (this) {
            Iterator it = this.zzi.iterator();
            while (it.hasNext()) {
                ((zzjn) it.next()).zza();
            }
        }
    }
}
