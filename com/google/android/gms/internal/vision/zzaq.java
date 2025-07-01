package com.google.android.gms.internal.vision;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Pattern;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
/* loaded from: classes3.dex */
public class zzaq {
    private static HashMap<String, String> zzf;
    private static Object zzk;
    private static boolean zzl;
    public static final Uri zza = Uri.parse("content://com.google.android.gsf.gservices");
    private static final Uri zzc = Uri.parse("content://com.google.android.gsf.gservices/prefix");
    public static final Pattern zzb = Pattern.compile("^(1|true|t|on|yes|y)$", 2);
    private static final Pattern zzd = Pattern.compile("^(0|false|f|off|no|n)$", 2);
    private static final AtomicBoolean zze = new AtomicBoolean();
    private static final HashMap<String, Boolean> zzg = new HashMap<>();
    private static final HashMap<String, Integer> zzh = new HashMap<>();
    private static final HashMap<String, Long> zzi = new HashMap<>();
    private static final HashMap<String, Float> zzj = new HashMap<>();
    private static String[] zzm = new String[0];

    public static String zza(ContentResolver contentResolver, String str, String str2) {
        synchronized (zzaq.class) {
            if (zzf == null) {
                zze.set(false);
                zzf = new HashMap<>();
                zzk = new Object();
                zzl = false;
                contentResolver.registerContentObserver(zza, true, new zzat(null));
            } else if (zze.getAndSet(false)) {
                zzf.clear();
                zzg.clear();
                zzh.clear();
                zzi.clear();
                zzj.clear();
                zzk = new Object();
                zzl = false;
            }
            Object obj = zzk;
            if (zzf.containsKey(str)) {
                String str3 = zzf.get(str);
                return str3 != null ? str3 : null;
            }
            for (String str4 : zzm) {
                if (str.startsWith(str4)) {
                    if (!zzl || zzf.isEmpty()) {
                        zzf.putAll(zza(contentResolver, zzm));
                        zzl = true;
                        if (zzf.containsKey(str)) {
                            String str5 = zzf.get(str);
                            return str5 != null ? str5 : null;
                        }
                    }
                    return null;
                }
            }
            Cursor query = contentResolver.query(zza, null, null, new String[]{str}, null);
            if (query == null) {
                return null;
            }
            try {
                if (!query.moveToFirst()) {
                    zza(obj, str, (String) null);
                    if (query != null) {
                        query.close();
                    }
                    return null;
                }
                String string = query.getString(1);
                if (string != null && string.equals(null)) {
                    string = null;
                }
                zza(obj, str, string);
                String str6 = string != null ? string : null;
                if (query != null) {
                    query.close();
                }
                return str6;
            } finally {
                if (query != null) {
                    query.close();
                }
            }
        }
    }

    private static void zza(Object obj, String str, String str2) {
        synchronized (zzaq.class) {
            if (obj == zzk) {
                zzf.put(str, str2);
            }
        }
    }

    private static Map<String, String> zza(ContentResolver contentResolver, String... strArr) {
        Cursor query = contentResolver.query(zzc, null, null, strArr, null);
        TreeMap treeMap = new TreeMap();
        if (query == null) {
            return treeMap;
        }
        while (query.moveToNext()) {
            try {
                treeMap.put(query.getString(0), query.getString(1));
            } finally {
                query.close();
            }
        }
        return treeMap;
    }
}
