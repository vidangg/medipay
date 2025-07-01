package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.StrictMode;
import android.util.Log;
import androidx.collection.SimpleArrayMap;
import com.google.common.base.Optional;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.4.0 */
/* loaded from: classes3.dex */
public final class zzjv {
    private static volatile Optional zza;

    private zzjv() {
    }

    /* JADX WARN: Can't wrap try/catch for region: R(12:(2:12|13)|25|26|27|28|29|30|(1:32)(1:78)|33|(9:35|36|37|38|39|(2:40|(3:42|(3:57|58|59)(7:44|45|(2:47|(1:50))|51|(1:53)|54|55)|56)(1:60))|61|62|63)(1:77)|64|13) */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x006d, code lost:
    
        r3 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x006e, code lost:
    
        android.util.Log.e("HermeticFileOverrides", "no data dir", r3);
        r3 = com.google.common.base.Optional.absent();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Optional zza(Context context) {
        StrictMode.ThreadPolicy allowThreadDiskReads;
        Optional absent;
        Optional optional = zza;
        if (optional == null) {
            synchronized (zzjv.class) {
                optional = zza;
                if (optional == null) {
                    String str = Build.TYPE;
                    String str2 = Build.TAGS;
                    int i = zzjx.zza;
                    try {
                        if ((!str.equals("eng") && !str.equals("userdebug")) || (!str2.contains("dev-keys") && !str2.contains("test-keys"))) {
                            absent = Optional.absent();
                            zza = absent;
                            optional = absent;
                        }
                        StrictMode.allowThreadDiskWrites();
                        File file = new File(context.getDir("phenotype_hermetic", 0), "overrides.txt");
                        Optional absent2 = file.exists() ? Optional.of(file) : Optional.absent();
                        if (absent2.isPresent()) {
                            File file2 = (File) absent2.get();
                            try {
                                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file2)));
                                try {
                                    SimpleArrayMap simpleArrayMap = new SimpleArrayMap();
                                    HashMap hashMap = new HashMap();
                                    while (true) {
                                        String readLine = bufferedReader.readLine();
                                        if (readLine == null) {
                                            break;
                                        }
                                        String[] split = readLine.split(" ", 3);
                                        if (split.length != 3) {
                                            Log.e("HermeticFileOverrides", "Invalid: " + readLine);
                                        } else {
                                            String str3 = new String(split[0]);
                                            String decode = Uri.decode(new String(split[1]));
                                            String str4 = (String) hashMap.get(split[2]);
                                            if (str4 == null) {
                                                String str5 = new String(split[2]);
                                                str4 = Uri.decode(str5);
                                                if (str4.length() < 1024 || str4 == str5) {
                                                    hashMap.put(str5, str4);
                                                }
                                            }
                                            SimpleArrayMap simpleArrayMap2 = (SimpleArrayMap) simpleArrayMap.get(str3);
                                            if (simpleArrayMap2 == null) {
                                                simpleArrayMap2 = new SimpleArrayMap();
                                                simpleArrayMap.put(str3, simpleArrayMap2);
                                            }
                                            simpleArrayMap2.put(decode, str4);
                                        }
                                    }
                                    Log.w("HermeticFileOverrides", "Parsed " + file2.toString() + " for Android package " + context.getPackageName());
                                    zzjo zzjoVar = new zzjo(simpleArrayMap);
                                    bufferedReader.close();
                                    absent = Optional.of(zzjoVar);
                                } catch (Throwable th) {
                                    try {
                                        bufferedReader.close();
                                    } catch (Throwable th2) {
                                        th.addSuppressed(th2);
                                    }
                                    throw th;
                                }
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                        } else {
                            absent = Optional.absent();
                        }
                        zza = absent;
                        optional = absent;
                    } finally {
                        StrictMode.setThreadPolicy(allowThreadDiskReads);
                    }
                    if (zzji.zzc() && !context.isDeviceProtectedStorage()) {
                        context = context.createDeviceProtectedStorageContext();
                    }
                    allowThreadDiskReads = StrictMode.allowThreadDiskReads();
                }
            }
        }
        return optional;
    }
}
