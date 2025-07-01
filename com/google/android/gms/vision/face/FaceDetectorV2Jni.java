package com.google.android.gms.vision.face;

import android.content.res.AssetManager;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.internal.mlkit_vision_face_bundled.zzah;
import com.google.android.gms.internal.mlkit_vision_face_bundled.zzh;
import com.google.android.gms.internal.mlkit_vision_face_bundled.zzuh;
import com.google.android.gms.internal.mlkit_vision_face_bundled.zzv;
import com.google.android.gms.internal.mlkit_vision_face_bundled.zzve;
import com.google.android.gms.internal.mlkit_vision_face_bundled.zzx;
import java.nio.ByteBuffer;

/* compiled from: com.google.mlkit:face-detection@@16.1.7 */
/* loaded from: classes3.dex */
public class FaceDetectorV2Jni {
    private final zzuh zza;

    public FaceDetectorV2Jni() {
        zzuh zza = zzuh.zza();
        this.zza = zza;
        zza.zzc(zzah.zza);
    }

    private native void closeDetectorJni(long j);

    private native byte[] detectFacesImageByteArrayJni(long j, byte[] bArr, byte[] bArr2);

    private native byte[] detectFacesImageByteArrayMultiPlanesJni(long j, byte[] bArr, byte[] bArr2, byte[] bArr3, int i, int i2, int i3, int i4, int i5, int i6, byte[] bArr4);

    private native byte[] detectFacesImageByteBufferJni(long j, ByteBuffer byteBuffer, byte[] bArr);

    private native byte[] detectFacesImageByteBufferMultiPlanesJni(long j, ByteBuffer byteBuffer, ByteBuffer byteBuffer2, ByteBuffer byteBuffer3, int i, int i2, int i3, int i4, int i5, int i6, byte[] bArr);

    private native long initDetectorJni(byte[] bArr, AssetManager assetManager);

    public final long zza(zzx zzxVar, AssetManager assetManager) {
        Log.v("FaceDetectorV2Jni", "initialize.start()");
        long initDetectorJni = initDetectorJni(zzxVar.zzr(), assetManager);
        Log.v("FaceDetectorV2Jni", "initialize.end()");
        return initDetectorJni;
    }

    public final zzv zzb(long j, byte[] bArr, zzh zzhVar) throws RemoteException {
        Log.v("FaceDetectorV2Jni", "detectFacesImageByteArray.start()");
        zzv zzvVar = null;
        try {
            byte[] detectFacesImageByteArrayJni = detectFacesImageByteArrayJni(j, bArr, zzhVar.zzr());
            if (detectFacesImageByteArrayJni != null && detectFacesImageByteArrayJni.length > 0) {
                zzvVar = zzv.zzb(detectFacesImageByteArrayJni, this.zza);
            }
        } catch (zzve e) {
            Log.e("FaceDetectorV2Jni", "detectFacesImageByteArray failed to parse result: ".concat(String.valueOf(e.getMessage())));
        }
        Log.v("FaceDetectorV2Jni", "detectFacesImageByteArray.end()");
        return zzvVar;
    }

    public final zzv zzc(long j, byte[] bArr, byte[] bArr2, byte[] bArr3, int i, int i2, int i3, int i4, int i5, int i6, zzh zzhVar) {
        byte[] detectFacesImageByteArrayMultiPlanesJni;
        Log.v("FaceDetectorV2Jni", "detectFacesImageByteArrayMultiPlanes.start()");
        zzv zzvVar = null;
        try {
            detectFacesImageByteArrayMultiPlanesJni = detectFacesImageByteArrayMultiPlanesJni(j, bArr, bArr2, bArr3, i, i2, i3, i4, i5, i6, zzhVar.zzr());
        } catch (zzve e) {
            e = e;
        }
        if (detectFacesImageByteArrayMultiPlanesJni != null) {
            if (detectFacesImageByteArrayMultiPlanesJni.length > 0) {
                try {
                    zzvVar = zzv.zzb(detectFacesImageByteArrayMultiPlanesJni, this.zza);
                } catch (zzve e2) {
                    e = e2;
                    Log.e("FaceDetectorV2Jni", "detectFacesImageByteArrayMultiPlanes failed to parse result: ".concat(String.valueOf(e.getMessage())));
                    Log.v("FaceDetectorV2Jni", "%s detectFacesImageByteArrayMultiPlanes.end()");
                    return zzvVar;
                }
                Log.v("FaceDetectorV2Jni", "%s detectFacesImageByteArrayMultiPlanes.end()");
                return zzvVar;
            }
        }
        Log.v("FaceDetectorV2Jni", "%s detectFacesImageByteArrayMultiPlanes.end()");
        return zzvVar;
    }

    public final zzv zzd(long j, ByteBuffer byteBuffer, zzh zzhVar) throws RemoteException {
        Log.v("FaceDetectorV2Jni", "detectFacesImageByteBuffer.start()");
        zzv zzvVar = null;
        try {
            byte[] detectFacesImageByteBufferJni = detectFacesImageByteBufferJni(j, byteBuffer, zzhVar.zzr());
            if (detectFacesImageByteBufferJni != null && detectFacesImageByteBufferJni.length > 0) {
                zzvVar = zzv.zzb(detectFacesImageByteBufferJni, this.zza);
            }
        } catch (zzve e) {
            Log.e("FaceDetectorV2Jni", "detectFacesImageByteBuffer failed to parse result: ".concat(String.valueOf(e.getMessage())));
        }
        Log.v("FaceDetectorV2Jni", "%s detectFacesImageByteBuffer.end()");
        return zzvVar;
    }

    public final zzv zze(long j, ByteBuffer byteBuffer, ByteBuffer byteBuffer2, ByteBuffer byteBuffer3, int i, int i2, int i3, int i4, int i5, int i6, zzh zzhVar) {
        byte[] detectFacesImageByteBufferMultiPlanesJni;
        Log.v("FaceDetectorV2Jni", "detectFacesImageByteBufferMultiPlanes.start()");
        zzv zzvVar = null;
        try {
            detectFacesImageByteBufferMultiPlanesJni = detectFacesImageByteBufferMultiPlanesJni(j, byteBuffer, byteBuffer2, byteBuffer3, i, i2, i3, i4, i5, i6, zzhVar.zzr());
        } catch (zzve e) {
            e = e;
        }
        if (detectFacesImageByteBufferMultiPlanesJni != null) {
            if (detectFacesImageByteBufferMultiPlanesJni.length > 0) {
                try {
                    zzvVar = zzv.zzb(detectFacesImageByteBufferMultiPlanesJni, this.zza);
                } catch (zzve e2) {
                    e = e2;
                    Log.e("FaceDetectorV2Jni", "detectFacesImageByteBufferMultiPlanes failed to parse result: ".concat(String.valueOf(e.getMessage())));
                    Log.v("FaceDetectorV2Jni", "detectFacesImageByteBuffer.end()");
                    return zzvVar;
                }
                Log.v("FaceDetectorV2Jni", "detectFacesImageByteBuffer.end()");
                return zzvVar;
            }
        }
        Log.v("FaceDetectorV2Jni", "detectFacesImageByteBuffer.end()");
        return zzvVar;
    }

    public final void zzf(long j) {
        Log.v("FaceDetectorV2Jni", "closeDetector.start()");
        closeDetectorJni(j);
        Log.v("FaceDetectorV2Jni", "closeDetector.end()");
    }
}
