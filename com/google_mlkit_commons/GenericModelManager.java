package com.google_mlkit_commons;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.mlkit.common.model.DownloadConditions;
import com.google.mlkit.common.model.RemoteModel;
import com.google.mlkit.common.model.RemoteModelManager;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: classes4.dex */
public class GenericModelManager {
    private static final String CHECK = "check";
    private static final String DELETE = "delete";
    private static final String DOWNLOAD = "download";
    public RemoteModelManager remoteModelManager = RemoteModelManager.getInstance();
    private final ExecutorService executorService = Executors.newCachedThreadPool();

    public void manageModel(RemoteModel remoteModel, MethodCall methodCall, MethodChannel.Result result) {
        DownloadConditions build;
        String str = (String) methodCall.argument("task");
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -1335458389:
                if (str.equals(DELETE)) {
                    c = 0;
                    break;
                }
                break;
            case 94627080:
                if (str.equals(CHECK)) {
                    c = 1;
                    break;
                }
                break;
            case 1427818632:
                if (str.equals(DOWNLOAD)) {
                    c = 2;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                deleteModel(remoteModel, result);
                return;
            case 1:
                Boolean isModelDownloaded = isModelDownloaded(remoteModel);
                if (isModelDownloaded != null) {
                    result.success(isModelDownloaded);
                    return;
                } else {
                    result.error("error", null, null);
                    return;
                }
            case 2:
                if (((Boolean) methodCall.argument("wifi")).booleanValue()) {
                    build = new DownloadConditions.Builder().requireWifi().build();
                } else {
                    build = new DownloadConditions.Builder().build();
                }
                downloadModel(remoteModel, build, result);
                return;
            default:
                result.notImplemented();
                return;
        }
    }

    public void downloadModel(RemoteModel remoteModel, DownloadConditions downloadConditions, final MethodChannel.Result result) {
        if (isModelDownloaded(remoteModel).booleanValue()) {
            result.success(FirebaseAnalytics.Param.SUCCESS);
        } else {
            this.remoteModelManager.download(remoteModel, downloadConditions).addOnSuccessListener(new OnSuccessListener() { // from class: com.google_mlkit_commons.GenericModelManager$$ExternalSyntheticLambda0
                @Override // com.google.android.gms.tasks.OnSuccessListener
                public final void onSuccess(Object obj) {
                    MethodChannel.Result.this.success(FirebaseAnalytics.Param.SUCCESS);
                }
            }).addOnFailureListener(new OnFailureListener() { // from class: com.google_mlkit_commons.GenericModelManager$$ExternalSyntheticLambda1
                @Override // com.google.android.gms.tasks.OnFailureListener
                public final void onFailure(Exception exc) {
                    MethodChannel.Result.this.error("error", exc.toString(), null);
                }
            });
        }
    }

    public void deleteModel(RemoteModel remoteModel, final MethodChannel.Result result) {
        if (!isModelDownloaded(remoteModel).booleanValue()) {
            result.success(FirebaseAnalytics.Param.SUCCESS);
        } else {
            this.remoteModelManager.deleteDownloadedModel(remoteModel).addOnSuccessListener(new OnSuccessListener() { // from class: com.google_mlkit_commons.GenericModelManager$$ExternalSyntheticLambda2
                @Override // com.google.android.gms.tasks.OnSuccessListener
                public final void onSuccess(Object obj) {
                    MethodChannel.Result.this.success(FirebaseAnalytics.Param.SUCCESS);
                }
            }).addOnFailureListener(new OnFailureListener() { // from class: com.google_mlkit_commons.GenericModelManager$$ExternalSyntheticLambda3
                @Override // com.google.android.gms.tasks.OnFailureListener
                public final void onFailure(Exception exc) {
                    MethodChannel.Result.this.error("error", exc.toString(), null);
                }
            });
        }
    }

    public Boolean isModelDownloaded(RemoteModel remoteModel) {
        try {
            return (Boolean) this.executorService.submit(new IsModelDownloaded(this.remoteModelManager.isModelDownloaded(remoteModel))).get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
            return null;
        }
    }
}
