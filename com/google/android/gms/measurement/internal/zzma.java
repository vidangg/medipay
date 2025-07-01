package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPOutputStream;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.4.0 */
/* loaded from: classes3.dex */
public final class zzma implements Runnable {
    final /* synthetic */ zzmb zza;
    private final URL zzb;
    private final byte[] zzc;
    private final zzly zzd;
    private final String zze;
    private final Map zzf;

    public zzma(zzmb zzmbVar, String str, URL url, byte[] bArr, Map map, zzly zzlyVar) {
        this.zza = zzmbVar;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(url);
        Preconditions.checkNotNull(zzlyVar);
        this.zzb = url;
        this.zzc = bArr;
        this.zzd = zzlyVar;
        this.zze = str;
        this.zzf = map;
    }

    private final void zzb(final int i, final Exception exc, final byte[] bArr, final Map map) {
        this.zza.zzu.zzaX().zzq(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzlz
            @Override // java.lang.Runnable
            public final void run() {
                r0.zzd.zza(zzma.this.zze, i, exc, bArr, map);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0171  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0155 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x012c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r5v21 */
    /* JADX WARN: Type inference failed for: r5v29 */
    /* JADX WARN: Type inference failed for: r5v30 */
    /* JADX WARN: Type inference failed for: r5v31 */
    /* JADX WARN: Type inference failed for: r5v32 */
    /* JADX WARN: Type inference failed for: r5v33 */
    /* JADX WARN: Type inference failed for: r5v34 */
    /* JADX WARN: Type inference failed for: r5v35 */
    /* JADX WARN: Type inference failed for: r5v4, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r5v6, types: [java.io.OutputStream] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void run() {
        HttpURLConnection httpURLConnection;
        Map map;
        Map map2;
        Map map3;
        Map map4;
        ?? r5;
        ?? r52;
        int responseCode;
        Object obj;
        Object obj2;
        InputStream inputStream;
        zzmb zzmbVar = this.zza;
        zzmbVar.zzaY();
        int i = 0;
        try {
            URL url = this.zzb;
            int i2 = com.google.android.gms.internal.measurement.zzcm.zzb;
            URLConnection openConnection = url.openConnection();
            if (!(openConnection instanceof HttpURLConnection)) {
                throw new IOException("Failed to obtain HTTP connection");
            }
            httpURLConnection = (HttpURLConnection) openConnection;
            httpURLConnection.setDefaultUseCaches(false);
            zzio zzioVar = zzmbVar.zzu;
            zzioVar.zzf();
            httpURLConnection.setConnectTimeout(60000);
            zzioVar.zzf();
            httpURLConnection.setReadTimeout(61000);
            httpURLConnection.setInstanceFollowRedirects(false);
            ?? r53 = 1;
            httpURLConnection.setDoInput(true);
            try {
                try {
                    Map map5 = this.zzf;
                    if (map5 != null) {
                        for (Map.Entry entry : map5.entrySet()) {
                            httpURLConnection.addRequestProperty((String) entry.getKey(), (String) entry.getValue());
                        }
                    }
                    byte[] bArr = this.zzc;
                    if (bArr != null) {
                        try {
                            zzioVar.zzaV();
                            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                            gZIPOutputStream.write(bArr);
                            gZIPOutputStream.close();
                            byteArrayOutputStream.close();
                            byte[] byteArray = byteArrayOutputStream.toByteArray();
                            zzhc zzj = this.zza.zzu.zzaW().zzj();
                            int length = byteArray.length;
                            zzj.zzb("Uploading data. size", Integer.valueOf(length));
                            httpURLConnection.setDoOutput(true);
                            httpURLConnection.addRequestProperty("Content-Encoding", "gzip");
                            httpURLConnection.setFixedLengthStreamingMode(length);
                            httpURLConnection.connect();
                            OutputStream outputStream = httpURLConnection.getOutputStream();
                            try {
                                outputStream.write(byteArray);
                                outputStream.close();
                                r53 = outputStream;
                            } catch (IOException e) {
                                e = e;
                                map3 = null;
                                r52 = outputStream;
                                if (r52 != 0) {
                                }
                                if (httpURLConnection != null) {
                                }
                                zzb(i, e, null, map3);
                            } catch (Throwable th) {
                                th = th;
                                map4 = null;
                                r5 = outputStream;
                                if (r5 != 0) {
                                }
                                if (httpURLConnection != null) {
                                }
                                zzb(i, null, null, map4);
                                throw th;
                            }
                        } catch (IOException e2) {
                            this.zza.zzu.zzaW().zze().zzb("Failed to gzip post request content", e2);
                            throw e2;
                        }
                    }
                    responseCode = httpURLConnection.getResponseCode();
                } catch (Throwable th2) {
                    th = th2;
                    map = null;
                    map4 = map;
                    r5 = map;
                    if (r5 != 0) {
                        try {
                            r5.close();
                        } catch (IOException e3) {
                            this.zza.zzu.zzaW().zze().zzc("Error closing HTTP compressed POST connection output stream. appId", zzhe.zzn(this.zze), e3);
                        }
                    }
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    zzb(i, null, null, map4);
                    throw th;
                }
            } catch (IOException e4) {
                e = e4;
                map2 = null;
                map3 = map2;
                r52 = map2;
                if (r52 != 0) {
                    try {
                        r52.close();
                    } catch (IOException e5) {
                        this.zza.zzu.zzaW().zze().zzc("Error closing HTTP compressed POST connection output stream. appId", zzhe.zzn(this.zze), e5);
                    }
                }
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                zzb(i, e, null, map3);
            }
            try {
                try {
                    Map<String, List<String>> headerFields = httpURLConnection.getHeaderFields();
                    try {
                        ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                        inputStream = httpURLConnection.getInputStream();
                        try {
                            byte[] bArr2 = new byte[1024];
                            while (true) {
                                int read = inputStream.read(bArr2);
                                if (read <= 0) {
                                    break;
                                } else {
                                    byteArrayOutputStream2.write(bArr2, 0, read);
                                }
                            }
                            byte[] byteArray2 = byteArrayOutputStream2.toByteArray();
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                            }
                            zzb(responseCode, null, byteArray2, headerFields);
                        } catch (Throwable th3) {
                            th = th3;
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            throw th;
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        inputStream = null;
                    }
                } catch (IOException e6) {
                    e = e6;
                    map3 = r53;
                    obj2 = null;
                    IOException iOException = e;
                    i = responseCode;
                    e = iOException;
                    r52 = obj2;
                    if (r52 != 0) {
                    }
                    if (httpURLConnection != null) {
                    }
                    zzb(i, e, null, map3);
                } catch (Throwable th5) {
                    th = th5;
                    map4 = r53;
                    obj = null;
                    Throwable th6 = th;
                    i = responseCode;
                    th = th6;
                    r5 = obj;
                    if (r5 != 0) {
                    }
                    if (httpURLConnection != null) {
                    }
                    zzb(i, null, null, map4);
                    throw th;
                }
            } catch (IOException e7) {
                e = e7;
                obj2 = null;
                map3 = null;
                IOException iOException2 = e;
                i = responseCode;
                e = iOException2;
                r52 = obj2;
                if (r52 != 0) {
                }
                if (httpURLConnection != null) {
                }
                zzb(i, e, null, map3);
            } catch (Throwable th7) {
                th = th7;
                obj = null;
                map4 = null;
                Throwable th62 = th;
                i = responseCode;
                th = th62;
                r5 = obj;
                if (r5 != 0) {
                }
                if (httpURLConnection != null) {
                }
                zzb(i, null, null, map4);
                throw th;
            }
        } catch (IOException e8) {
            e = e8;
            httpURLConnection = null;
            map2 = null;
        } catch (Throwable th8) {
            th = th8;
            httpURLConnection = null;
            map = null;
        }
    }
}
