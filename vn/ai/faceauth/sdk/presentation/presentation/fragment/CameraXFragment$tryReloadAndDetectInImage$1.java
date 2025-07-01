package vn.ai.faceauth.sdk.presentation.presentation.fragment;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.mlkit.common.sdkinternal.OptionalModuleUtils;
import com.google.mlkit.vision.face.Face;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import paua.btj;
import vn.ai.faceauth.sdk.domain.model.PhotoResultDomain;
import vn.ai.faceauth.sdk.presentation.presentation.opencv.Point;
import vn.ai.faceauth.sdk.presentation.presentation.widgets.FaceImageProcessor;
import vn.ai.faceauth.sdk.presentation.presentation.widgets.OverlayView;

@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tH\u0016¨\u0006\n"}, d2 = {"vn/ai/faceauth/sdk/presentation/presentation/fragment/CameraXFragment$tryReloadAndDetectInImage$1", "Lvn/ai/faceauth/sdk/presentation/presentation/widgets/FaceImageProcessor;", "processBitmap", "", OptionalModuleUtils.FACE, "Lcom/google/mlkit/vision/face/Face;", "landmarkPoints", "Ljava/util/ArrayList;", "Lvn/ai/faceauth/sdk/presentation/presentation/opencv/Point;", "Lkotlin/collections/ArrayList;", "authenSDK_release"}, k = 1, mv = {1, 6, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes4.dex */
public final class CameraXFragment$tryReloadAndDetectInImage$1 implements FaceImageProcessor {
    final /* synthetic */ PhotoResultDomain $it;
    final /* synthetic */ CameraXFragment this$0;

    public CameraXFragment$tryReloadAndDetectInImage$1(CameraXFragment cameraXFragment, PhotoResultDomain photoResultDomain) {
        this.this$0 = cameraXFragment;
        this.$it = photoResultDomain;
    }

    @Override // vn.ai.faceauth.sdk.presentation.presentation.widgets.FaceImageProcessor
    public void processBitmap(Face face, ArrayList<Point> landmarkPoints) {
        String str;
        Bitmap faceAlignment;
        Bitmap scaleBitmapWithCanvas;
        Bitmap compressBitmap;
        String str2;
        String str3;
        OverlayView overlayView;
        String tzend = btj.tzend(528);
        String tzend2 = btj.tzend(529);
        String tzend3 = btj.tzend(530);
        String tzend4 = btj.tzend(531);
        if (face != null) {
            try {
                str = this.this$0.TAG;
                Log.e(str, tzend4 + this.this$0.getRawImage().size());
                if (this.this$0.getRawImage().size() == 1) {
                    overlayView = this.this$0.overlayView;
                    if (overlayView == null) {
                        Intrinsics.throwUninitializedPropertyAccessException(btj.tzend(532));
                        overlayView = null;
                    }
                    if (overlayView.isStep1()) {
                        return;
                    }
                }
                faceAlignment = this.this$0.faceAlignment(this.$it.getBitMap(), landmarkPoints);
                CameraXFragment cameraXFragment = this.this$0;
                scaleBitmapWithCanvas = cameraXFragment.scaleBitmapWithCanvas(this.$it.getBitMap(), 512, 512);
                compressBitmap = cameraXFragment.compressBitmap(scaleBitmapWithCanvas, Bitmap.CompressFormat.JPEG, 80);
                this.this$0.getMapDataUploadAPI().put(tzend3 + this.$it.getCreatedAt(), this.this$0.bitmapToBase64(compressBitmap));
                this.this$0.getMapDataUploadAPI().put(tzend2 + this.$it.getCreatedAt(), this.this$0.jsonObjectToBase64(face.getBoundingBox(), faceAlignment, landmarkPoints));
                str2 = this.this$0.TAG;
                Log.e(str2, tzend + this.$it.getCreatedAt());
                List<String> list = CollectionsKt.toList(this.this$0.getMapDataUploadAPI().keySet());
                CameraXFragment cameraXFragment2 = this.this$0;
                for (String str4 : list) {
                    str3 = cameraXFragment2.TAG;
                    Log.e(str3, btj.tzend(533) + str4 + btj.tzend(534) + cameraXFragment2.getMapDataUploadAPI().get(str4));
                }
                this.this$0.getRawImage().add(this.$it);
                Handler handler = new Handler(Looper.getMainLooper());
                final CameraXFragment cameraXFragment3 = this.this$0;
                handler.postDelayed(new Runnable() { // from class: vn.ai.faceauth.sdk.presentation.presentation.fragment.CameraXFragment$tryReloadAndDetectInImage$1$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        CameraXFragment.access$nextStep(CameraXFragment.this);
                    }
                }, 50L);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
