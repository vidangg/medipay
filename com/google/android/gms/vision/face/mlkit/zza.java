package com.google.android.gms.vision.face.mlkit;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.PointF;
import android.graphics.Rect;
import android.media.Image;
import android.os.Build;
import android.os.RemoteException;
import android.os.SystemClock;
import android.util.Log;
import androidx.media3.extractor.ts.PsExtractor;
import com.google.android.gms.common.internal.GmsLogger;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.mlkit_vision_face_bundled.zzac;
import com.google.android.gms.internal.mlkit_vision_face_bundled.zzad;
import com.google.android.gms.internal.mlkit_vision_face_bundled.zzaf;
import com.google.android.gms.internal.mlkit_vision_face_bundled.zzag;
import com.google.android.gms.internal.mlkit_vision_face_bundled.zzah;
import com.google.android.gms.internal.mlkit_vision_face_bundled.zzg;
import com.google.android.gms.internal.mlkit_vision_face_bundled.zzh;
import com.google.android.gms.internal.mlkit_vision_face_bundled.zzk;
import com.google.android.gms.internal.mlkit_vision_face_bundled.zzl;
import com.google.android.gms.internal.mlkit_vision_face_bundled.zzq;
import com.google.android.gms.internal.mlkit_vision_face_bundled.zzsg;
import com.google.android.gms.internal.mlkit_vision_face_bundled.zzsp;
import com.google.android.gms.internal.mlkit_vision_face_bundled.zzsr;
import com.google.android.gms.internal.mlkit_vision_face_bundled.zzst;
import com.google.android.gms.internal.mlkit_vision_face_bundled.zzsv;
import com.google.android.gms.internal.mlkit_vision_face_bundled.zzsx;
import com.google.android.gms.internal.mlkit_vision_face_bundled.zzt;
import com.google.android.gms.internal.mlkit_vision_face_bundled.zztc;
import com.google.android.gms.internal.mlkit_vision_face_bundled.zzv;
import com.google.android.gms.internal.mlkit_vision_face_bundled.zzw;
import com.google.android.gms.internal.mlkit_vision_face_bundled.zzx;
import com.google.android.gms.internal.mlkit_vision_face_bundled.zzxm;
import com.google.android.gms.internal.mlkit_vision_face_bundled.zzxo;
import com.google.android.gms.internal.mlkit_vision_face_bundled.zzxy;
import com.google.android.gms.internal.mlkit_vision_face_bundled.zzxz;
import com.google.android.gms.internal.mlkit_vision_face_bundled.zzy;
import com.google.android.gms.internal.mlkit_vision_face_bundled.zzz;
import com.google.android.gms.vision.face.FaceDetectorV2Jni;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.mlkit:face-detection@@16.1.7 */
/* loaded from: classes3.dex */
final class zza extends zzsx {
    private static final GmsLogger zza = new GmsLogger("FaceDetector", "");
    private final Context zzb;
    private final zzst zzc;
    private final zzx zzd;
    private final FaceDetectorV2Jni zze;
    private final zzb zzf;
    private final zzsg zzg;
    private long zzh = -1;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zza(Context context, zzst zzstVar, FaceDetectorV2Jni faceDetectorV2Jni, zzb zzbVar) {
        this.zzb = context;
        this.zzc = zzstVar;
        int zzc = zzstVar.zzc();
        zzaf zza2 = zzag.zza();
        zza2.zzb("models");
        zzag zzagVar = (zzag) zza2.zzn();
        zzw zza3 = zzx.zza();
        zzy zza4 = zzz.zza();
        zza4.zzc(zzagVar);
        zza4.zzb(zzagVar);
        zza4.zzd(zzagVar);
        zza3.zzc(zza4);
        zzk zza5 = zzl.zza();
        zza5.zza(zzagVar);
        zza5.zzb(zzagVar);
        zza3.zza(zza5);
        zzac zza6 = zzad.zza();
        zza6.zzb(zzagVar);
        zza6.zzc(zzagVar);
        zza6.zzd(zzagVar);
        zza6.zza(zzagVar);
        zza3.zze(zza6);
        boolean z = false;
        boolean z2 = zzc == 2;
        zza3.zzg(z2);
        if (!z2 && zzstVar.zzf()) {
            z = true;
        }
        zza3.zzb(z);
        zza3.zzf(zzstVar.zza());
        zza3.zzh(true);
        if (z2) {
            zza3.zzk(4);
            zza3.zzj(4);
        } else {
            int zze = zzstVar.zze();
            if (zze == 1) {
                zza3.zzk(2);
            } else if (zze == 2) {
                zza3.zzk(3);
            }
            int zzd = zzstVar.zzd();
            if (zzd == 1) {
                zza3.zzj(2);
            } else if (zzd == 2) {
                zza3.zzj(3);
            }
            int zzb = zzstVar.zzb();
            if (zzb == 1) {
                zza3.zzi(2);
            } else if (zzb == 2) {
                zza3.zzi(3);
            }
        }
        this.zzd = (zzx) zza3.zzn();
        this.zze = faceDetectorV2Jni;
        this.zzf = zzbVar;
        this.zzg = zzsg.zza(context);
    }

    private final List zze(zzv zzvVar) {
        float f;
        float f2;
        float f3;
        ArrayList arrayList;
        ArrayList arrayList2;
        int i;
        int i2;
        char c;
        ArrayList arrayList3 = new ArrayList();
        for (zzxz zzxzVar : zzvVar.zzc().zze()) {
            int i3 = 1;
            int i4 = -1;
            if (this.zzd.zzk() == 3) {
                float f4 = -1.0f;
                float f5 = -1.0f;
                float f6 = -1.0f;
                for (zzxm zzxmVar : zzxzVar.zzn()) {
                    String zze = zzxmVar.zze();
                    int hashCode = zze.hashCode();
                    if (hashCode == -1940789646) {
                        if (zze.equals("left_eye_closed")) {
                            c = 1;
                        }
                        c = 65535;
                    } else if (hashCode != -1837755075) {
                        if (hashCode == 105428 && zze.equals("joy")) {
                            c = 0;
                        }
                        c = 65535;
                    } else {
                        if (zze.equals("right_eye_closed")) {
                            c = 2;
                        }
                        c = 65535;
                    }
                    if (c == 0) {
                        f6 = zzxmVar.zzb();
                    } else if (c == 1) {
                        f4 = 1.0f - zzxmVar.zzb();
                    } else if (c == 2) {
                        f5 = 1.0f - zzxmVar.zzb();
                    }
                }
                f = f4;
                f2 = f5;
                f3 = f6;
            } else {
                f = -1.0f;
                f2 = -1.0f;
                f3 = -1.0f;
            }
            int i5 = 9;
            int i6 = 4;
            if (this.zzd.zzl() == 3) {
                List<zzxy> zzo = zzxzVar.zzo();
                ArrayList arrayList4 = new ArrayList();
                for (zzxy zzxyVar : zzo) {
                    int zzg = zzxyVar.zzg() - 1;
                    if (zzg == 0) {
                        i2 = 4;
                    } else if (zzg == i3) {
                        i2 = 10;
                    } else if (zzg != i5) {
                        switch (zzg) {
                            case 11:
                                i2 = 0;
                                break;
                            case 12:
                                i2 = 5;
                                break;
                            case 13:
                                i2 = 11;
                                break;
                            default:
                                switch (zzg) {
                                    case 238:
                                        i2 = 1;
                                        break;
                                    case 239:
                                        i2 = 7;
                                        break;
                                    case PsExtractor.VIDEO_STREAM_MASK /* 240 */:
                                        i2 = 3;
                                        break;
                                    case 241:
                                        i2 = 9;
                                        break;
                                    case 242:
                                        i2 = 2;
                                        break;
                                    case 243:
                                        i2 = 8;
                                        break;
                                    default:
                                        zza.d("FaceDetector", "Unknown landmark type: ".concat(Integer.toString(zzg)));
                                        i2 = -1;
                                        break;
                                }
                        }
                    } else {
                        i2 = 6;
                    }
                    if (i2 >= 0) {
                        arrayList4.add(new zztc(i2, new PointF(zzxyVar.zzb(), zzxyVar.zzd())));
                    }
                    i5 = 9;
                    i3 = 1;
                }
                arrayList = arrayList4;
            } else {
                arrayList = new ArrayList();
            }
            if (this.zzd.zzl() == 4) {
                List<zzt> list = (List) zzxzVar.zzd(zzah.zza);
                ArrayList arrayList5 = new ArrayList();
                for (zzt zztVar : list) {
                    int zzd = zztVar.zzd() + i4;
                    switch (zzd) {
                        case 1:
                            i = 1;
                            break;
                        case 2:
                            i = 2;
                            break;
                        case 3:
                            i = 3;
                            break;
                        case 4:
                            i = i6;
                            break;
                        case 5:
                            i = 5;
                            break;
                        case 6:
                            i = 6;
                            break;
                        case 7:
                            i = 7;
                            break;
                        case 8:
                            i = 8;
                            break;
                        case 9:
                            i = 9;
                            break;
                        case 10:
                            i = 10;
                            break;
                        case 11:
                            i = 11;
                            break;
                        case 12:
                            i = 12;
                            break;
                        case 13:
                            i = 13;
                            break;
                        case 14:
                            i = 14;
                            break;
                        case 15:
                            i = 15;
                            break;
                        default:
                            zza.d("FaceDetector", "Unknown contour type: " + zzd);
                            i = i4;
                            break;
                    }
                    if (i != i4) {
                        ArrayList arrayList6 = new ArrayList();
                        for (zzq zzqVar : zztVar.zzc()) {
                            arrayList6.add(new PointF(zzqVar.zza(), zzqVar.zzb()));
                        }
                        arrayList5.add(new zzsr(i, arrayList6));
                        i6 = 4;
                        i4 = -1;
                    } else {
                        i6 = 4;
                    }
                }
                arrayList2 = arrayList5;
            } else {
                arrayList2 = new ArrayList();
            }
            zzxo zzk = zzxzVar.zzk();
            arrayList3.add(new zzsv((int) zzxzVar.zzj(), new Rect((int) zzk.zzb(), (int) zzk.zze(), (int) zzk.zzd(), (int) zzk.zzg()), zzxzVar.zzh(), zzxzVar.zzg(), zzxzVar.zzi(), f, f2, f3, zzxzVar.zzJ() ? zzxzVar.zze() : -1.0f, arrayList, arrayList2));
        }
        return arrayList3;
    }

    private static int zzf(int i) {
        if (i == 0) {
            return 1;
        }
        if (i == 1) {
            return 4;
        }
        if (i == 2) {
            return 3;
        }
        if (i == 3) {
            return 2;
        }
        throw new IllegalArgumentException("Unsupported rotation degree: " + i);
    }

    private final List zzg(ByteBuffer byteBuffer, zzsp zzspVar, int i) throws RemoteException {
        zzv zzb;
        zzg zza2 = zzh.zza();
        zza2.zzc(zzspVar.zzd());
        zza2.zza(zzspVar.zza());
        zza2.zze(zzf(zzspVar.zzc()));
        zza2.zzd(i);
        if (zzspVar.zze() > 0) {
            zza2.zzb(zzspVar.zze() * 1000);
        }
        zzh zzhVar = (zzh) zza2.zzn();
        if (byteBuffer.isDirect()) {
            zzb = this.zze.zzd(this.zzh, byteBuffer, zzhVar);
        } else if (!byteBuffer.hasArray() || byteBuffer.arrayOffset() != 0) {
            byte[] bArr = new byte[byteBuffer.remaining()];
            byteBuffer.get(bArr);
            zzb = this.zze.zzb(this.zzh, bArr, zzhVar);
        } else {
            zzb = this.zze.zzb(this.zzh, byteBuffer.array(), zzhVar);
        }
        return zzb != null ? zze(zzb) : new ArrayList();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzsy
    public final List zzb(IObjectWrapper iObjectWrapper, zzsp zzspVar) throws RemoteException {
        List zzg;
        zzv zzc;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long currentTimeMillis = System.currentTimeMillis();
        int zzb = zzspVar.zzb();
        if (zzb == -1) {
            zzg = zzg(com.google.android.gms.internal.mlkit_vision_face_bundled.zzd.zza((Bitmap) ObjectWrapper.unwrap(iObjectWrapper), true), zzspVar, 2);
        } else if (zzb == 17) {
            zzg = zzg((ByteBuffer) ObjectWrapper.unwrap(iObjectWrapper), zzspVar, 2);
        } else if (zzb == 35) {
            Image.Plane[] planes = ((Image) ObjectWrapper.unwrap(iObjectWrapper)).getPlanes();
            ByteBuffer buffer = planes[0].getBuffer();
            ByteBuffer buffer2 = planes[1].getBuffer();
            ByteBuffer buffer3 = planes[2].getBuffer();
            zzg zza2 = zzh.zza();
            zza2.zzc(zzspVar.zzd());
            zza2.zza(zzspVar.zza());
            zza2.zze(zzf(zzspVar.zzc()));
            if (zzspVar.zze() > 0) {
                zza2.zzb(zzspVar.zze() * 1000);
            }
            zzh zzhVar = (zzh) zza2.zzn();
            if (buffer.isDirect()) {
                zzc = this.zze.zze(this.zzh, buffer, buffer2, buffer3, planes[0].getPixelStride(), planes[1].getPixelStride(), planes[2].getPixelStride(), planes[0].getRowStride(), planes[1].getRowStride(), planes[2].getRowStride(), zzhVar);
            } else if (!buffer.hasArray() || buffer.arrayOffset() != 0) {
                byte[] bArr = new byte[buffer.remaining()];
                buffer.get(bArr);
                byte[] bArr2 = new byte[buffer2.remaining()];
                buffer.get(bArr);
                byte[] bArr3 = new byte[buffer3.remaining()];
                buffer.get(bArr);
                zzc = this.zze.zzc(this.zzh, bArr, bArr2, bArr3, planes[0].getPixelStride(), planes[1].getPixelStride(), planes[2].getPixelStride(), planes[0].getRowStride(), planes[1].getRowStride(), planes[2].getRowStride(), zzhVar);
            } else {
                zzc = this.zze.zzc(this.zzh, buffer.array(), buffer2.array(), buffer3.array(), planes[0].getPixelStride(), planes[1].getPixelStride(), planes[2].getPixelStride(), planes[0].getRowStride(), planes[1].getRowStride(), planes[2].getRowStride(), zzhVar);
            }
            zzg = zzc != null ? zze(zzc) : new ArrayList();
        } else if (zzb == 842094169) {
            zzg = zzg((ByteBuffer) ObjectWrapper.unwrap(iObjectWrapper), zzspVar, 7);
        } else {
            String str = "Unsupported image format " + zzspVar.zzb() + " at API " + Build.VERSION.SDK_INT;
            Log.e("FaceDetector", str);
            this.zzg.zzc(25503, 1, currentTimeMillis, System.currentTimeMillis());
            throw zze.zza(str);
        }
        List list = zzg;
        this.zzf.zza(this.zzc, zzspVar, list, SystemClock.elapsedRealtime() - elapsedRealtime);
        this.zzg.zzc(25503, 0, currentTimeMillis, System.currentTimeMillis());
        return list;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzsy
    public final void zzc() {
        this.zzh = this.zze.zza(this.zzd, this.zzb.getAssets());
        this.zzf.zzc(this.zzc);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzsy
    public final void zzd() {
        long j = this.zzh;
        if (j > 0) {
            this.zze.zzf(j);
            this.zzh = -1L;
        }
    }
}
