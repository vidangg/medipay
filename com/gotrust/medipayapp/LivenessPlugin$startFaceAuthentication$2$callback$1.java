package com.gotrust.medipayapp;

import android.app.Activity;
import android.os.Handler;
import android.util.Log;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tekartik.sqflite.Constant;
import io.flutter.plugin.common.MethodChannel;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import vn.ai.faceauth.sdk.presentation.navigation.AuthenticationID;
import vn.ai.faceauth.sdk.presentation.navigation.SDKCallback;

/* compiled from: LivenessPlugin.kt */
@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J8\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0007H\u0016¨\u0006\f"}, d2 = {"com/gotrust/medipayapp/LivenessPlugin$startFaceAuthentication$2$callback$1", "Lvn/ai/faceauth/sdk/presentation/navigation/SDKCallback;", "complete", "", Constant.PARAM_ERROR_CODE, "", "errorMessage", "", "firstFace", "lastFace", "signature", "encryptedFaceImages", "app_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes4.dex */
public final class LivenessPlugin$startFaceAuthentication$2$callback$1 implements SDKCallback {
    final /* synthetic */ LivenessPlugin this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public LivenessPlugin$startFaceAuthentication$2$callback$1(LivenessPlugin livenessPlugin) {
        this.this$0 = livenessPlugin;
    }

    @Override // vn.ai.faceauth.sdk.presentation.navigation.SDKCallback
    public void complete(final int code, final String errorMessage, final String firstFace, final String lastFace, final String signature, final String encryptedFaceImages) {
        ExecutorService executorService;
        Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
        Intrinsics.checkNotNullParameter(firstFace, "firstFace");
        Intrinsics.checkNotNullParameter(lastFace, "lastFace");
        Intrinsics.checkNotNullParameter(signature, "signature");
        Intrinsics.checkNotNullParameter(encryptedFaceImages, "encryptedFaceImages");
        Log.d("LivenessPlugin", "SDK callback received - Code: " + code);
        executorService = this.this$0.backgroundExecutor;
        final LivenessPlugin livenessPlugin = this.this$0;
        executorService.execute(new Runnable() { // from class: com.gotrust.medipayapp.LivenessPlugin$startFaceAuthentication$2$callback$1$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                LivenessPlugin$startFaceAuthentication$2$callback$1.complete$lambda$1(LivenessPlugin.this, firstFace, lastFace, code, errorMessage, signature, encryptedFaceImages);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void complete$lambda$1(final LivenessPlugin this$0, String firstFace, String lastFace, int i, String errorMessage, String signature, String encryptedFaceImages) {
        Handler handler;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(firstFace, "$firstFace");
        Intrinsics.checkNotNullParameter(lastFace, "$lastFace");
        Intrinsics.checkNotNullParameter(errorMessage, "$errorMessage");
        Intrinsics.checkNotNullParameter(signature, "$signature");
        Intrinsics.checkNotNullParameter(encryptedFaceImages, "$encryptedFaceImages");
        this$0.firstFaceB64 = firstFace;
        this$0.lastFaceB64 = lastFace;
        final Map mapOf = MapsKt.mapOf(TuplesKt.to(Constant.PARAM_ERROR_CODE, Integer.valueOf(i)), TuplesKt.to("errorMessage", errorMessage), TuplesKt.to("firstFace", firstFace), TuplesKt.to("lastFace", lastFace), TuplesKt.to("signature", signature), TuplesKt.to("encryptedFaceImages", encryptedFaceImages));
        handler = this$0.mainHandler;
        handler.post(new Runnable() { // from class: com.gotrust.medipayapp.LivenessPlugin$startFaceAuthentication$2$callback$1$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                LivenessPlugin$startFaceAuthentication$2$callback$1.complete$lambda$1$lambda$0(LivenessPlugin.this, mapOf);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void complete$lambda$1$lambda$0(LivenessPlugin this$0, Map response) {
        MethodChannel.Result result;
        Activity activity;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(response, "$response");
        Log.d("LivenessPlugin", "Sending result to Flutter");
        result = this$0.pendingResult;
        if (result != null) {
            result.success(response);
        }
        this$0.pendingResult = null;
        try {
            activity = this$0.activity;
            AuthenticationID.closeSDK(activity);
            Log.d("LivenessPlugin", "SDK closed successfully");
        } catch (Exception e) {
            Log.e("LivenessPlugin", "Failed to close SDK: " + e.getMessage());
        }
    }
}
