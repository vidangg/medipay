package com.google.mlkit.vision.face.bundled.internal;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.PointF;
import android.graphics.Rect;
import android.media.Image;
import android.os.Build;
import android.os.RemoteException;
import android.util.Log;
import androidx.media3.extractor.ts.PsExtractor;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.mlkit_vision_face_bundled.zzac;
import com.google.android.gms.internal.mlkit_vision_face_bundled.zzad;
import com.google.android.gms.internal.mlkit_vision_face_bundled.zzaf;
import com.google.android.gms.internal.mlkit_vision_face_bundled.zzag;
import com.google.android.gms.internal.mlkit_vision_face_bundled.zzah;
import com.google.android.gms.internal.mlkit_vision_face_bundled.zzd;
import com.google.android.gms.internal.mlkit_vision_face_bundled.zzg;
import com.google.android.gms.internal.mlkit_vision_face_bundled.zzh;
import com.google.android.gms.internal.mlkit_vision_face_bundled.zzk;
import com.google.android.gms.internal.mlkit_vision_face_bundled.zzl;
import com.google.android.gms.internal.mlkit_vision_face_bundled.zzq;
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
/* loaded from: classes4.dex */
final class zza extends zzsx {
    private final Context zza;
    private final zzx zzb;
    private final FaceDetectorV2Jni zzc;
    private long zzd = -1;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zza(Context context, zzst zzstVar, FaceDetectorV2Jni faceDetectorV2Jni) {
        this.zza = context;
        int zzc = zzstVar.zzc();
        zzaf zza = zzag.zza();
        zza.zzb("models_bundled");
        zzag zzagVar = (zzag) zza.zzn();
        int zze = zzstVar.zze();
        zzy zza2 = zzz.zza();
        zzaf zza3 = zzag.zza();
        zza3.zzb("models_bundled");
        zza3.zza(zze == 2 ? "fssd_medium_8bit_v5.tflite" : "fssd_25_8bit_v2.tflite");
        zza2.zzc((zzag) zza3.zzn());
        zzaf zza4 = zzag.zza();
        zza4.zzb("models_bundled");
        zza4.zza(zze == 2 ? "fssd_medium_8bit_gray_v5.tflite" : "fssd_25_8bit_gray_v2.tflite");
        zza2.zzb((zzag) zza4.zzn());
        zzaf zza5 = zzag.zza();
        zza5.zzb("models_bundled");
        zza5.zza(zze == 2 ? "fssd_anchors_v5.pb" : "fssd_anchors_v2.pb");
        zza2.zza((zzag) zza5.zzn());
        zza2.zzd(zzagVar);
        zzz zzzVar = (zzz) zza2.zzn();
        zzw zza6 = zzx.zza();
        zza6.zzd(zzzVar);
        zzk zza7 = zzl.zza();
        zza7.zza(zzagVar);
        zza7.zzb(zzagVar);
        zza6.zza(zza7);
        zzac zza8 = zzad.zza();
        zza8.zzb(zzagVar);
        zza8.zzc(zzagVar);
        zza8.zzd(zzagVar);
        zza8.zza(zzagVar);
        zza6.zze(zza8);
        boolean z = false;
        boolean z2 = zzc == 2;
        zza6.zzg(z2);
        if (!z2 && zzstVar.zzf()) {
            z = true;
        }
        zza6.zzb(z);
        zza6.zzf(zzstVar.zza());
        zza6.zzh(true);
        if (z2) {
            zza6.zzk(4);
            zza6.zzj(4);
        } else {
            int zze2 = zzstVar.zze();
            if (zze2 == 1) {
                zza6.zzk(2);
            } else if (zze2 == 2) {
                zza6.zzk(3);
            }
            int zzd = zzstVar.zzd();
            if (zzd == 1) {
                zza6.zzj(2);
            } else if (zzd == 2) {
                zza6.zzj(3);
            }
            int zzb = zzstVar.zzb();
            if (zzb == 1) {
                zza6.zzi(2);
            } else if (zzb == 2) {
                zza6.zzi(3);
            }
        }
        this.zzb = (zzx) zza6.zzn();
        this.zzc = faceDetectorV2Jni;
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
            if (this.zzb.zzk() == 3) {
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
            if (this.zzb.zzl() == 3) {
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
                                        i2 = i3;
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
                                        Log.d("ThickFaceDetector", "Unknown landmark type: ".concat(Integer.toString(zzg)));
                                        i2 = -1;
                                        break;
                                }
                        }
                    } else {
                        i2 = 6;
                    }
                    if (i2 >= 0) {
                        arrayList4.add(new zztc(i2, new PointF(zzxyVar.zzb(), zzxyVar.zzd())));
                        i5 = 9;
                        i3 = 1;
                    } else {
                        i5 = 9;
                    }
                }
                arrayList = arrayList4;
            } else {
                arrayList = new ArrayList();
            }
            if (this.zzb.zzl() == 4) {
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
                            Log.d("ThickFaceDetector", "Unknown contour type: " + zzd);
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
        zzg zza = zzh.zza();
        zza.zzc(zzspVar.zzd());
        zza.zza(zzspVar.zza());
        zza.zze(zzf(zzspVar.zzc()));
        zza.zzd(i);
        if (zzspVar.zze() > 0) {
            zza.zzb(zzspVar.zze() * 1000);
        }
        zzh zzhVar = (zzh) zza.zzn();
        if (byteBuffer.isDirect()) {
            zzb = this.zzc.zzd(this.zzd, byteBuffer, zzhVar);
        } else if (!byteBuffer.hasArray() || byteBuffer.arrayOffset() != 0) {
            byte[] bArr = new byte[byteBuffer.remaining()];
            byteBuffer.get(bArr);
            zzb = this.zzc.zzb(this.zzd, bArr, zzhVar);
        } else {
            zzb = this.zzc.zzb(this.zzd, byteBuffer.array(), zzhVar);
        }
        return zzb != null ? zze(zzb) : new ArrayList();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzsy
    public final List zzb(IObjectWrapper iObjectWrapper, zzsp zzspVar) throws RemoteException {
        zzv zzc;
        int zzb = zzspVar.zzb();
        if (zzb == -1) {
            return zzg(zzd.zza((Bitmap) ObjectWrapper.unwrap(iObjectWrapper), true), zzspVar, 2);
        }
        if (zzb == 17) {
            return zzg((ByteBuffer) ObjectWrapper.unwrap(iObjectWrapper), zzspVar, 2);
        }
        if (zzb != 35) {
            if (zzb == 842094169) {
                return zzg((ByteBuffer) ObjectWrapper.unwrap(iObjectWrapper), zzspVar, 7);
            }
            String str = "Unsupported image format " + zzspVar.zzb() + " at API " + Build.VERSION.SDK_INT;
            Log.e("ThickFaceDetector", str);
            throw new RemoteException(str);
        }
        Image.Plane[] planes = ((Image) ObjectWrapper.unwrap(iObjectWrapper)).getPlanes();
        ByteBuffer buffer = planes[0].getBuffer();
        ByteBuffer buffer2 = planes[1].getBuffer();
        ByteBuffer buffer3 = planes[2].getBuffer();
        zzg zza = zzh.zza();
        zza.zzc(zzspVar.zzd());
        zza.zza(zzspVar.zza());
        zza.zze(zzf(zzspVar.zzc()));
        if (zzspVar.zze() > 0) {
            zza.zzb(zzspVar.zze() * 1000);
        }
        zzh zzhVar = (zzh) zza.zzn();
        if (buffer.isDirect()) {
            zzc = this.zzc.zze(this.zzd, buffer, buffer2, buffer3, planes[0].getPixelStride(), planes[1].getPixelStride(), planes[2].getPixelStride(), planes[0].getRowStride(), planes[1].getRowStride(), planes[2].getRowStride(), zzhVar);
        } else if (!buffer.hasArray() || buffer.arrayOffset() != 0) {
            byte[] bArr = new byte[buffer.remaining()];
            buffer.get(bArr);
            byte[] bArr2 = new byte[buffer2.remaining()];
            buffer.get(bArr);
            byte[] bArr3 = new byte[buffer3.remaining()];
            buffer.get(bArr);
            zzc = this.zzc.zzc(this.zzd, bArr, bArr2, bArr3, planes[0].getPixelStride(), planes[1].getPixelStride(), planes[2].getPixelStride(), planes[0].getRowStride(), planes[1].getRowStride(), planes[2].getRowStride(), zzhVar);
        } else {
            zzc = this.zzc.zzc(this.zzd, buffer.array(), buffer2.array(), buffer3.array(), planes[0].getPixelStride(), planes[1].getPixelStride(), planes[2].getPixelStride(), planes[0].getRowStride(), planes[1].getRowStride(), planes[2].getRowStride(), zzhVar);
        }
        return zzc != null ? zze(zzc) : new ArrayList();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzsy
    public final void zzc() {
        this.zzd = this.zzc.zza(this.zzb, this.zza.getAssets());
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzsy
    public final void zzd() {
        long j = this.zzd;
        if (j > 0) {
            this.zzc.zzf(j);
            this.zzd = -1L;
        }
    }
}
