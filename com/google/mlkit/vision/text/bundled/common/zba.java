package com.google.mlkit.vision.text.bundled.common;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbf;
import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbnx;
import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbnz;
import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbok;
import com.google.mlkit.vision.text.pipeline.VkpTextRecognizerOptions;
import com.google.mlkit.vision.text.pipeline.zbi;
import com.google.mlkit.vision.text.pipeline.zbn;
import com.google.mlkit.vision.text.pipeline.zbo;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes4.dex */
final class zba extends zbnz {
    private final Context zba;
    private final String zbb;
    private final boolean zbc;
    private final String zbd;
    private final String zbe;
    private zbi zbf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zba(Context context, String str, String str2, String str3, boolean z) {
        this.zba = context;
        this.zbb = str;
        this.zbd = str2;
        this.zbe = str3;
        this.zbc = z;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zboa
    public final zbok zbb(IObjectWrapper iObjectWrapper, zbnx zbnxVar) throws RemoteException {
        zbi zbiVar = this.zbf;
        if (zbiVar == null) {
            throw new RemoteException("Process is started without initiation.");
        }
        zbn zbb = ((zbi) Preconditions.checkNotNull(zbiVar)).zbb(iObjectWrapper, zbnxVar, true);
        zbo zbc = zbb.zbc();
        if (zbc.zbd()) {
            return zbb.zbb();
        }
        throw ((RemoteException) zbc.zbb().zba());
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zboa
    public final void zbc() throws RemoteException {
        String str;
        if (this.zbf == null) {
            System.loadLibrary("mlkit_google_ocr_pipeline");
            String str2 = this.zbe;
            if (str2 == null || str2.isEmpty()) {
                str = "";
            } else {
                str = this.zbe;
            }
            String str3 = this.zbb;
            String str4 = this.zbd;
            boolean z = this.zbc;
            VkpTextRecognizerOptions.Builder builder = VkpTextRecognizerOptions.builder(str3, str4, str);
            builder.setEnableLowLatencyInBackground(z);
            zbi zba = zbi.zba(this.zba, builder.build());
            this.zbf = zba;
            zbo zbc = zba.zbc();
            if (!zbc.zbd()) {
                throw ((RemoteException) zbc.zbb().zba());
            }
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zboa
    public final void zbd() {
        zbi zbiVar = this.zbf;
        if (zbiVar != null) {
            zbiVar.zbd();
            this.zbf = null;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zboa
    public final zbf[] zbe(IObjectWrapper iObjectWrapper, zbnx zbnxVar) throws RemoteException {
        throw new RemoteException("#recognizeBitmap should not be triggered from text thick client.");
    }
}
