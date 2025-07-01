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

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement@@22.4.0 */
/* loaded from: classes3.dex */
public final class zzhi implements Runnable {
    final /* synthetic */ zzhk zza;
    private final URL zzb;
    private final byte[] zzc;
    private final zzhg zzd;
    private final String zze;
    private final Map zzf;

    public zzhi(zzhk zzhkVar, String str, URL url, byte[] bArr, Map map, zzhg zzhgVar) {
        this.zza = zzhkVar;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(url);
        Preconditions.checkNotNull(zzhgVar);
        this.zzb = url;
        this.zzc = bArr;
        this.zzd = zzhgVar;
        this.zze = str;
        this.zzf = map;
    }

    /* JADX WARN: Not initialized variable reg: 11, insn: 0x00f6: MOVE (r8 I:??[OBJECT, ARRAY]) = (r11 I:??[OBJECT, ARRAY]), block:B:77:0x00f5 */
    /* JADX WARN: Not initialized variable reg: 11, insn: 0x00fa: MOVE (r10 I:??[OBJECT, ARRAY]) = (r11 I:??[OBJECT, ARRAY]), block:B:74:0x00f9 */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x015a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x011b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void run() {
        int i;
        HttpURLConnection httpURLConnection;
        Map map;
        IOException iOException;
        int i2;
        Map map2;
        zzhh zzhhVar;
        zzil zzilVar;
        URLConnection openConnection;
        int responseCode;
        Map map3;
        Map map4;
        InputStream inputStream;
        zzhk zzhkVar = this.zza;
        zzhkVar.zzaY();
        OutputStream outputStream = null;
        try {
            URL url = this.zzb;
            int i3 = com.google.android.gms.internal.measurement.zzcm.zzb;
            openConnection = url.openConnection();
        } catch (IOException e) {
            iOException = e;
            i2 = 0;
            httpURLConnection = null;
            map2 = null;
        } catch (Throwable th) {
            th = th;
            i = 0;
            httpURLConnection = null;
            map = null;
        }
        if (!(openConnection instanceof HttpURLConnection)) {
            throw new IOException("Failed to obtain HTTP connection");
        }
        httpURLConnection = (HttpURLConnection) openConnection;
        httpURLConnection.setDefaultUseCaches(false);
        zzio zzioVar = zzhkVar.zzu;
        zzioVar.zzf();
        httpURLConnection.setConnectTimeout(60000);
        zzioVar.zzf();
        httpURLConnection.setReadTimeout(61000);
        httpURLConnection.setInstanceFollowRedirects(false);
        httpURLConnection.setDoInput(true);
        try {
            Map map5 = this.zzf;
            if (map5 != null) {
                for (Map.Entry entry : map5.entrySet()) {
                    httpURLConnection.addRequestProperty((String) entry.getKey(), (String) entry.getValue());
                }
            }
            byte[] bArr = this.zzc;
            if (bArr != null) {
                byte[] zzB = zzhkVar.zzg.zzA().zzB(bArr);
                zzhc zzj = zzioVar.zzaW().zzj();
                int length = zzB.length;
                zzj.zzb("Uploading data. size", Integer.valueOf(length));
                httpURLConnection.setDoOutput(true);
                httpURLConnection.addRequestProperty("Content-Encoding", "gzip");
                httpURLConnection.setFixedLengthStreamingMode(length);
                httpURLConnection.connect();
                OutputStream outputStream2 = httpURLConnection.getOutputStream();
                try {
                    outputStream2.write(zzB);
                    outputStream2.close();
                } catch (IOException e2) {
                    iOException = e2;
                    i2 = 0;
                    map2 = null;
                    outputStream = outputStream2;
                    if (outputStream != null) {
                    }
                    if (httpURLConnection != null) {
                    }
                    zzhk zzhkVar2 = this.zza;
                    String str = this.zze;
                    zzhg zzhgVar = this.zzd;
                    zzilVar = zzhkVar2.zzu.zzaX();
                    zzhhVar = new zzhh(str, zzhgVar, i2, iOException, null, map2, null);
                    zzilVar.zzq(zzhhVar);
                } catch (Throwable th2) {
                    th = th2;
                    map = null;
                    outputStream = outputStream2;
                    i = 0;
                    if (outputStream != null) {
                    }
                    if (httpURLConnection != null) {
                    }
                    this.zza.zzu.zzaX().zzq(new zzhh(this.zze, this.zzd, i, null, null, map, null));
                    throw th;
                }
            }
            responseCode = httpURLConnection.getResponseCode();
        } catch (IOException e3) {
            iOException = e3;
            i2 = 0;
            map2 = null;
        } catch (Throwable th3) {
            th = th3;
            i = 0;
        }
        try {
            try {
                Map<String, List<String>> headerFields = httpURLConnection.getHeaderFields();
                try {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    inputStream = httpURLConnection.getInputStream();
                    try {
                        byte[] bArr2 = new byte[1024];
                        while (true) {
                            int read = inputStream.read(bArr2);
                            if (read <= 0) {
                                break;
                            } else {
                                byteArrayOutputStream.write(bArr2, 0, read);
                            }
                        }
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        zzhk zzhkVar3 = this.zza;
                        String str2 = this.zze;
                        zzhg zzhgVar2 = this.zzd;
                        zzilVar = zzhkVar3.zzu.zzaX();
                        zzhhVar = new zzhh(str2, zzhgVar2, responseCode, null, byteArray, headerFields, null);
                    } catch (Throwable th4) {
                        th = th4;
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        throw th;
                    }
                } catch (Throwable th5) {
                    th = th5;
                    inputStream = null;
                }
            } catch (IOException e4) {
                e = e4;
                i2 = responseCode;
                map2 = map4;
                iOException = e;
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (IOException e5) {
                        this.zza.zzu.zzaW().zze().zzc("Error closing HTTP compressed POST connection output stream. appId", zzhe.zzn(this.zze), e5);
                    }
                }
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                zzhk zzhkVar22 = this.zza;
                String str3 = this.zze;
                zzhg zzhgVar3 = this.zzd;
                zzilVar = zzhkVar22.zzu.zzaX();
                zzhhVar = new zzhh(str3, zzhgVar3, i2, iOException, null, map2, null);
                zzilVar.zzq(zzhhVar);
            } catch (Throwable th6) {
                th = th6;
                i = responseCode;
                map = map3;
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (IOException e6) {
                        this.zza.zzu.zzaW().zze().zzc("Error closing HTTP compressed POST connection output stream. appId", zzhe.zzn(this.zze), e6);
                    }
                }
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                this.zza.zzu.zzaX().zzq(new zzhh(this.zze, this.zzd, i, null, null, map, null));
                throw th;
            }
        } catch (IOException e7) {
            e = e7;
            map2 = null;
            i2 = responseCode;
            iOException = e;
            if (outputStream != null) {
            }
            if (httpURLConnection != null) {
            }
            zzhk zzhkVar222 = this.zza;
            String str32 = this.zze;
            zzhg zzhgVar32 = this.zzd;
            zzilVar = zzhkVar222.zzu.zzaX();
            zzhhVar = new zzhh(str32, zzhgVar32, i2, iOException, null, map2, null);
            zzilVar.zzq(zzhhVar);
        } catch (Throwable th7) {
            th = th7;
            i = responseCode;
            map = null;
            if (outputStream != null) {
            }
            if (httpURLConnection != null) {
            }
            this.zza.zzu.zzaX().zzq(new zzhh(this.zze, this.zzd, i, null, null, map, null));
            throw th;
        }
        zzilVar.zzq(zzhhVar);
    }
}
