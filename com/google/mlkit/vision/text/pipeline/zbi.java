package com.google.mlkit.vision.text.pipeline;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.media.Image;
import android.os.RemoteException;
import android.os.SystemClock;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbabj;
import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbbb;
import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbbe;
import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbiu;
import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbix;
import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbkf;
import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbki;
import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbku;
import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbkx;
import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zblc;
import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbnx;
import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zboe;
import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbog;
import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zboi;
import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbok;
import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zboo;
import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbpb;
import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbpf;
import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbpg;
import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbpi;
import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbpk;
import com.google.android.libraries.vision.visionkit.pipeline.AndroidAssetUtil;
import com.google.android.libraries.vision.visionkit.pipeline.alt.PipelineException;
import com.google.android.libraries.vision.visionkit.pipeline.zbbz;
import com.google.android.libraries.vision.visionkit.pipeline.zbca;
import com.google.android.libraries.vision.visionkit.pipeline.zbct;
import com.google.android.libraries.vision.visionkit.pipeline.zbcv;
import com.google.android.libraries.vision.visionkit.pipeline.zbcw;
import com.google.android.libraries.vision.visionkit.pipeline.zbcz;
import com.google.android.libraries.vision.visionkit.pipeline.zbdl;
import com.google.android.libraries.vision.visionkit.pipeline.zbdo;
import com.google.android.libraries.vision.visionkit.pipeline.zbfb;
import com.google.android.libraries.vision.visionkit.pipeline.zbfc;
import com.google.mlkit.common.MlKitException;
import com.google.mlkit.vision.common.internal.ImageConvertUtils;
import com.google.mlkit.vision.common.internal.ImageUtils;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes4.dex */
public final class zbi {
    zbh zba;
    boolean zbb;
    private final Context zbc;
    private final VkpTextRecognizerOptions zbd;
    private boolean zbe = true;

    private zbi(Context context, VkpTextRecognizerOptions vkpTextRecognizerOptions) {
        this.zbc = context;
        this.zbd = vkpTextRecognizerOptions;
    }

    public static zbi zba(Context context, VkpTextRecognizerOptions vkpTextRecognizerOptions) {
        return new zbi(context, vkpTextRecognizerOptions);
    }

    public final zbn zbb(IObjectWrapper iObjectWrapper, zbnx zbnxVar, boolean z) {
        zbki zbe;
        zbkx zbh;
        zbku zbkuVar;
        zbkx zbh2;
        zbku zbkuVar2;
        zbku zbkuVar3;
        zbo zbc = zbc();
        if (!zbc.zbd()) {
            return zbn.zbe(zbc);
        }
        try {
            int i = 3;
            int i2 = 1;
            if (zbnxVar.zbb() == -1) {
                Log.d("PipelineManager", "Start process bitmap");
                Bitmap bitmap = (Bitmap) Preconditions.checkNotNull((Bitmap) ObjectWrapper.unwrap(iObjectWrapper));
                if (bitmap.getConfig() != Bitmap.Config.ARGB_8888) {
                    Log.d("PipelineManager", "Input bitmap is not ARGB_8888 config. Converting it to ARGB_8888 from " + String.valueOf(bitmap.getConfig()));
                    bitmap = bitmap.copy(Bitmap.Config.ARGB_8888, bitmap.isMutable());
                }
                zbe = ((zbh) Preconditions.checkNotNull(this.zba)).zbi(SystemClock.elapsedRealtime() * 1000, bitmap, zbj.zbb(zbnxVar.zbc()));
            } else if (zbnxVar.zbb() == 35) {
                Log.d("PipelineManager", "Start process YUV");
                Image.Plane[] planes = ((Image) Preconditions.checkNotNull(ObjectWrapper.unwrap(iObjectWrapper))).getPlanes();
                zbe = ((zbh) Preconditions.checkNotNull(this.zba)).zbj(SystemClock.elapsedRealtime() * 1000, ((Image.Plane) Preconditions.checkNotNull(planes[0])).getBuffer(), ((Image.Plane) Preconditions.checkNotNull(planes[1])).getBuffer(), ((Image.Plane) Preconditions.checkNotNull(planes[2])).getBuffer(), zbnxVar.zbd(), zbnxVar.zba(), ((Image.Plane) Preconditions.checkNotNull(planes[0])).getRowStride(), ((Image.Plane) Preconditions.checkNotNull(planes[1])).getRowStride(), ((Image.Plane) Preconditions.checkNotNull(planes[1])).getPixelStride(), zbj.zbb(zbnxVar.zbc()));
            } else if (zbnxVar.zbb() == 17) {
                Log.d("PipelineManager", "Start process NV21");
                zbe = ((zbh) Preconditions.checkNotNull(this.zba)).zbe(zbj.zba(ImageConvertUtils.bufferWithBackingArray((ByteBuffer) Preconditions.checkNotNull((ByteBuffer) ObjectWrapper.unwrap(iObjectWrapper))), zbnxVar));
            } else if (zbnxVar.zbb() == 842094169) {
                Log.d("PipelineManager", "Start process YV12");
                zbe = ((zbh) Preconditions.checkNotNull(this.zba)).zbe(zbj.zba(ImageConvertUtils.yv12ToNv21Buffer((ByteBuffer) Preconditions.checkNotNull(ObjectWrapper.unwrap(iObjectWrapper)), true), zbnxVar));
            } else {
                throw new MlKitException("Unsupported image format: " + zbnxVar.zbb(), 3);
            }
            if (!zbe.zbc()) {
                return zbn.zbe(zbo.zbc(3, new RemoteException("VisionKit pipeline returns empty result.")));
            }
            Log.d("PipelineManager", "OCR process succeeded via visionkit pipeline.");
            zbcz zbczVar = (zbcz) zbe.zba();
            Matrix uprightRotationMatrix = ImageUtils.getInstance().getUprightRotationMatrix(zbnxVar.zbd(), zbnxVar.zba(), zbnxVar.zbc());
            boolean z2 = this.zbe;
            zbb zbbVar = new zbb(0, zbki.zbd());
            List<zbabj> zbf = zbczVar.zbe().zbf();
            HashMap hashMap = new HashMap();
            HashMap hashMap2 = new HashMap();
            HashMap hashMap3 = new HashMap();
            for (zbabj zbabjVar : zbf) {
                if (zbabjVar.zbI() == 6) {
                    zbpb zbb = zbf.zbb(zbabjVar.zbf());
                    List zbc2 = zbf.zbc(zbb);
                    zboo zbooVar = new zboo(zbabjVar.zbH(), zbf.zba(zbc2, uprightRotationMatrix), zbc2, zbabjVar.zbc(), zbb.zba());
                    Integer valueOf = Integer.valueOf(zbabjVar.zbe());
                    if (hashMap2.containsKey(valueOf)) {
                        zbkuVar3 = (zbku) hashMap2.get(valueOf);
                    } else {
                        zbku zbkuVar4 = new zbku();
                        hashMap2.put(valueOf, zbkuVar4);
                        zbkuVar3 = zbkuVar4;
                    }
                    ((zbku) Preconditions.checkNotNull(zbkuVar3)).zba(zbooVar);
                }
            }
            int i3 = 0;
            while (i3 < zbf.size()) {
                zbabj zbabjVar2 = (zbabj) zbf.get(i3);
                if (zbabjVar2.zbI() == i2) {
                    zbpb zbb2 = zbf.zbb(zbabjVar2.zbf());
                    List zbc3 = zbf.zbc(zbb2);
                    Integer valueOf2 = Integer.valueOf(i3);
                    if (hashMap2.containsKey(valueOf2)) {
                        zbh2 = ((zbku) Preconditions.checkNotNull((zbku) hashMap2.get(valueOf2))).zbb();
                    } else {
                        zbh2 = zbkx.zbh();
                    }
                    zbog zbogVar = new zbog(zbabjVar2.zbH(), zbf.zba(zbc3, uprightRotationMatrix), zbc3, zbg.zba(zbabjVar2.zbh().zbf()), zbabjVar2.zbc(), zbb2.zba(), (List) Preconditions.checkNotNull(zbh2));
                    Integer valueOf3 = Integer.valueOf(zbabjVar2.zbe());
                    if (hashMap.containsKey(valueOf3)) {
                        zbkuVar2 = (zbku) hashMap.get(valueOf3);
                    } else {
                        zbku zbkuVar5 = new zbku();
                        hashMap.put(valueOf3, zbkuVar5);
                        zbkuVar2 = zbkuVar5;
                    }
                    ((zbku) Preconditions.checkNotNull(zbkuVar2)).zba(zbogVar);
                }
                i3++;
                i2 = 1;
            }
            int i4 = 0;
            while (i4 < zbf.size()) {
                zbabj zbabjVar3 = (zbabj) zbf.get(i4);
                if (zbabjVar3.zbI() == i) {
                    zbpb zbb3 = zbf.zbb(zbabjVar3.zbf());
                    List zbc4 = zbf.zbc(zbb3);
                    Integer valueOf4 = Integer.valueOf(i4);
                    if (hashMap.containsKey(valueOf4)) {
                        zbh = ((zbku) Preconditions.checkNotNull((zbku) hashMap.get(valueOf4))).zbb();
                    } else {
                        zbh = zbkx.zbh();
                    }
                    zboi zboiVar = new zboi(zbabjVar3.zbH(), zbf.zba(zbc4, uprightRotationMatrix), zbc4, zbg.zba(zbabjVar3.zbh().zbf()), (List) Preconditions.checkNotNull(zbh), zbabjVar3.zbc(), zbb3.zba());
                    Integer valueOf5 = Integer.valueOf(zbabjVar3.zbe());
                    if (hashMap3.containsKey(valueOf5)) {
                        zbkuVar = (zbku) hashMap3.get(valueOf5);
                    } else {
                        zbku zbkuVar6 = new zbku();
                        hashMap3.put(Integer.valueOf(zbabjVar3.zbe()), zbkuVar6);
                        zbkuVar = zbkuVar6;
                    }
                    ((zbku) Preconditions.checkNotNull(zbkuVar)).zba(zboiVar);
                }
                i4++;
                i = 3;
            }
            zbku zbkuVar7 = new zbku();
            for (int i5 = 0; i5 < zbf.size(); i5++) {
                zbabj zbabjVar4 = (zbabj) zbf.get(i5);
                if (zbabjVar4.zbI() == 4) {
                    List zbc5 = zbf.zbc(zbf.zbb(zbabjVar4.zbf()));
                    zbkx zbh3 = zbkx.zbh();
                    Integer valueOf6 = Integer.valueOf(i5);
                    if (hashMap3.containsKey(valueOf6)) {
                        zbh3 = ((zbku) Preconditions.checkNotNull((zbku) hashMap3.get(valueOf6))).zbb();
                        hashMap3.remove(valueOf6);
                    }
                    zbkuVar7.zba(new zboe(zbm.zba.zbb(zblc.zba(zbh3, new zbkf() { // from class: com.google.mlkit.vision.text.pipeline.zbk
                        @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbkf
                        public final Object zba(Object obj) {
                            return ((zboi) obj).zbc();
                        }
                    })), zbf.zba(zbc5, uprightRotationMatrix), zbc5, zbg.zba(zbabjVar4.zbh().zbf()), (List) Preconditions.checkNotNull(zbh3)));
                }
            }
            Iterator it = hashMap3.values().iterator();
            while (it.hasNext()) {
                zbkx zbb4 = ((zbku) it.next()).zbb();
                int size = zbb4.size();
                int i6 = 0;
                while (i6 < size) {
                    zboi zboiVar2 = (zboi) zbb4.get(i6);
                    zbkuVar7.zba(new zboe(zboiVar2.zbc(), zboiVar2.zba(), zboiVar2.zbd(), zboiVar2.zbb(), zbkx.zbi(zboiVar2)));
                    i6++;
                    it = it;
                }
            }
            zbkx zbb5 = zbkuVar7.zbb();
            zba zbaVar = new zba(zbbVar, new zbok(zbm.zba.zbb(zblc.zba(zbb5, new zbkf() { // from class: com.google.mlkit.vision.text.pipeline.zbl
                @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbkf
                public final Object zba(Object obj) {
                    return ((zboe) obj).zba();
                }
            })), zbb5), zbkx.zbh(), z2);
            this.zbe = false;
            return zbaVar;
        } catch (MlKitException e) {
            return zbn.zbe(zbo.zbc(2, new RemoteException("Failed to process input image.".concat(String.valueOf(e.getMessage())))));
        }
    }

    public final zbo zbc() {
        if (this.zbb) {
            return new zbb(0, zbki.zbd());
        }
        if (this.zba == null) {
            if (!AndroidAssetUtil.zba(this.zbc)) {
                Log.d("PipelineManager", "Failed to initiate native asset manager.");
            }
            VkpTextRecognizerOptions vkpTextRecognizerOptions = this.zbd;
            String zba = vkpTextRecognizerOptions.zba();
            String zbc = vkpTextRecognizerOptions.zbc();
            String zbb = vkpTextRecognizerOptions.zbb();
            boolean zbd = vkpTextRecognizerOptions.zbd();
            zbbz zbc2 = zbca.zbc();
            int i = zbd ? 4 : 0;
            zbdl zba2 = zbdo.zba();
            zbbb zba3 = zbbe.zba();
            zba3.zbd(zbc);
            zba3.zba(zba);
            zba3.zbe(true);
            zba3.zbb(true);
            if (!zbb.isEmpty()) {
                zbpf zba4 = zbpg.zba();
                zbpi zba5 = zbpk.zba();
                zba5.zba(zbb);
                zba4.zba(zba5);
                zba3.zbc(zba4);
            }
            zba2.zbb(zba3);
            int zba6 = zbcv.zba(i);
            zbct zba7 = zbcw.zba();
            zba7.zba(zba6);
            zba2.zbc(zba7);
            zbiu zba8 = zbix.zba();
            zba8.zba("PassThroughCoarseClassifier");
            zba2.zba(zba8);
            zbc2.zba(zba2);
            zbfb zba9 = zbfc.zba();
            zba9.zba(2);
            zbc2.zbb(zba9);
            this.zba = new zbh((zbca) zbc2.zbk(), this.zbd.zba(), "mlkit_google_ocr_pipeline");
        }
        try {
            ((zbh) Preconditions.checkNotNull(this.zba)).zbg();
            this.zbb = true;
            return new zbb(0, zbki.zbd());
        } catch (PipelineException e) {
            return zbo.zbc(1, new RemoteException("Failed to initialize detector. ".concat((String) e.getRootCauseMessage().zbb(""))));
        }
    }

    public final void zbd() {
        zbh zbhVar = this.zba;
        if (zbhVar != null) {
            if (this.zbb) {
                zbhVar.zbh();
            }
            this.zba.zbf();
            this.zba = null;
        }
        this.zbb = false;
        this.zbe = true;
    }
}
