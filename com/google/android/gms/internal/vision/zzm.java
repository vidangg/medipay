package com.google.android.gms.internal.vision;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.vision.barcode.Barcode;
import com.google.mlkit.common.sdkinternal.OptionalModuleUtils;
import java.nio.ByteBuffer;

/* compiled from: com.google.android.gms:play-services-vision@@20.1.3 */
/* loaded from: classes3.dex */
public final class zzm extends zzt<zzl> {
    private final zzk zza;

    public zzm(Context context, zzk zzkVar) {
        super(context, "BarcodeNativeHandle", OptionalModuleUtils.BARCODE);
        this.zza = zzkVar;
        zzd();
    }

    public final Barcode[] zza(ByteBuffer byteBuffer, zzs zzsVar) {
        if (!zzb()) {
            return new Barcode[0];
        }
        try {
            return ((zzl) Preconditions.checkNotNull(zzd())).zza(ObjectWrapper.wrap(byteBuffer), zzsVar);
        } catch (RemoteException e) {
            Log.e("BarcodeNativeHandle", "Error calling native barcode detector", e);
            return new Barcode[0];
        }
    }

    public final Barcode[] zza(Bitmap bitmap, zzs zzsVar) {
        if (!zzb()) {
            return new Barcode[0];
        }
        try {
            return ((zzl) Preconditions.checkNotNull(zzd())).zzb(ObjectWrapper.wrap(bitmap), zzsVar);
        } catch (RemoteException e) {
            Log.e("BarcodeNativeHandle", "Error calling native barcode detector", e);
            return new Barcode[0];
        }
    }

    @Override // com.google.android.gms.internal.vision.zzt
    protected final void zza() throws RemoteException {
        if (zzb()) {
            ((zzl) Preconditions.checkNotNull(zzd())).zza();
        }
    }

    @Override // com.google.android.gms.internal.vision.zzt
    protected final /* synthetic */ zzl zza(DynamiteModule dynamiteModule, Context context) throws RemoteException, DynamiteModule.LoadingException {
        zzn zzpVar;
        IBinder instantiate = dynamiteModule.instantiate("com.google.android.gms.vision.barcode.ChimeraNativeBarcodeDetectorCreator");
        if (instantiate == null) {
            zzpVar = null;
        } else {
            IInterface queryLocalInterface = instantiate.queryLocalInterface("com.google.android.gms.vision.barcode.internal.client.INativeBarcodeDetectorCreator");
            if (queryLocalInterface instanceof zzn) {
                zzpVar = (zzn) queryLocalInterface;
            } else {
                zzpVar = new zzp(instantiate);
            }
        }
        if (zzpVar == null) {
            return null;
        }
        return zzpVar.zza(ObjectWrapper.wrap(context), (zzk) Preconditions.checkNotNull(this.zza));
    }
}
