package com.baseflow.permissionhandler;

import android.content.Context;
import com.baseflow.permissionhandler.AppSettingsManager;
import com.baseflow.permissionhandler.PermissionManager;
import com.baseflow.permissionhandler.ServiceManager;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes3.dex */
final class MethodCallHandlerImpl implements MethodChannel.MethodCallHandler {
    private final AppSettingsManager appSettingsManager;
    private final Context applicationContext;
    private final PermissionManager permissionManager;
    private final ServiceManager serviceManager;

    /* JADX INFO: Access modifiers changed from: package-private */
    public MethodCallHandlerImpl(Context context, AppSettingsManager appSettingsManager, PermissionManager permissionManager, ServiceManager serviceManager) {
        this.applicationContext = context;
        this.appSettingsManager = appSettingsManager;
        this.permissionManager = permissionManager;
        this.serviceManager = serviceManager;
    }

    @Override // io.flutter.plugin.common.MethodChannel.MethodCallHandler
    public void onMethodCall(MethodCall methodCall, final MethodChannel.Result result) {
        String str = methodCall.method;
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -1544053025:
                if (str.equals("checkServiceStatus")) {
                    c = 0;
                    break;
                }
                break;
            case -1017315255:
                if (str.equals("shouldShowRequestPermissionRationale")) {
                    c = 1;
                    break;
                }
                break;
            case -576207927:
                if (str.equals("checkPermissionStatus")) {
                    c = 2;
                    break;
                }
                break;
            case 347240634:
                if (str.equals("openAppSettings")) {
                    c = 3;
                    break;
                }
                break;
            case 1669188213:
                if (str.equals("requestPermissions")) {
                    c = 4;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                int parseInt = Integer.parseInt(methodCall.arguments.toString());
                ServiceManager serviceManager = this.serviceManager;
                Context context = this.applicationContext;
                Objects.requireNonNull(result);
                serviceManager.checkServiceStatus(parseInt, context, new ServiceManager.SuccessCallback() { // from class: com.baseflow.permissionhandler.MethodCallHandlerImpl$$ExternalSyntheticLambda0
                    @Override // com.baseflow.permissionhandler.ServiceManager.SuccessCallback
                    public final void onSuccess(int i) {
                        MethodChannel.Result.this.success(Integer.valueOf(i));
                    }
                }, new ErrorCallback() { // from class: com.baseflow.permissionhandler.MethodCallHandlerImpl$$ExternalSyntheticLambda1
                    @Override // com.baseflow.permissionhandler.ErrorCallback
                    public final void onError(String str2, String str3) {
                        MethodChannel.Result.this.error(str2, str3, null);
                    }
                });
                return;
            case 1:
                int parseInt2 = Integer.parseInt(methodCall.arguments.toString());
                PermissionManager permissionManager = this.permissionManager;
                Objects.requireNonNull(result);
                permissionManager.shouldShowRequestPermissionRationale(parseInt2, new PermissionManager.ShouldShowRequestPermissionRationaleSuccessCallback() { // from class: com.baseflow.permissionhandler.MethodCallHandlerImpl$$ExternalSyntheticLambda5
                    @Override // com.baseflow.permissionhandler.PermissionManager.ShouldShowRequestPermissionRationaleSuccessCallback
                    public final void onSuccess(boolean z) {
                        MethodChannel.Result.this.success(Boolean.valueOf(z));
                    }
                }, new ErrorCallback() { // from class: com.baseflow.permissionhandler.MethodCallHandlerImpl$$ExternalSyntheticLambda6
                    @Override // com.baseflow.permissionhandler.ErrorCallback
                    public final void onError(String str2, String str3) {
                        MethodChannel.Result.this.error(str2, str3, null);
                    }
                });
                return;
            case 2:
                int parseInt3 = Integer.parseInt(methodCall.arguments.toString());
                PermissionManager permissionManager2 = this.permissionManager;
                Objects.requireNonNull(result);
                permissionManager2.checkPermissionStatus(parseInt3, new PermissionManager.CheckPermissionsSuccessCallback() { // from class: com.baseflow.permissionhandler.MethodCallHandlerImpl$$ExternalSyntheticLambda2
                    @Override // com.baseflow.permissionhandler.PermissionManager.CheckPermissionsSuccessCallback
                    public final void onSuccess(int i) {
                        MethodChannel.Result.this.success(Integer.valueOf(i));
                    }
                });
                return;
            case 3:
                AppSettingsManager appSettingsManager = this.appSettingsManager;
                Context context2 = this.applicationContext;
                Objects.requireNonNull(result);
                appSettingsManager.openAppSettings(context2, new AppSettingsManager.OpenAppSettingsSuccessCallback() { // from class: com.baseflow.permissionhandler.MethodCallHandlerImpl$$ExternalSyntheticLambda7
                    @Override // com.baseflow.permissionhandler.AppSettingsManager.OpenAppSettingsSuccessCallback
                    public final void onSuccess(boolean z) {
                        MethodChannel.Result.this.success(Boolean.valueOf(z));
                    }
                }, new ErrorCallback() { // from class: com.baseflow.permissionhandler.MethodCallHandlerImpl$$ExternalSyntheticLambda8
                    @Override // com.baseflow.permissionhandler.ErrorCallback
                    public final void onError(String str2, String str3) {
                        MethodChannel.Result.this.error(str2, str3, null);
                    }
                });
                return;
            case 4:
                List<Integer> list = (List) methodCall.arguments();
                PermissionManager permissionManager3 = this.permissionManager;
                Objects.requireNonNull(result);
                permissionManager3.requestPermissions(list, new PermissionManager.RequestPermissionsSuccessCallback() { // from class: com.baseflow.permissionhandler.MethodCallHandlerImpl$$ExternalSyntheticLambda3
                    @Override // com.baseflow.permissionhandler.PermissionManager.RequestPermissionsSuccessCallback
                    public final void onSuccess(Map map) {
                        MethodChannel.Result.this.success(map);
                    }
                }, new ErrorCallback() { // from class: com.baseflow.permissionhandler.MethodCallHandlerImpl$$ExternalSyntheticLambda4
                    @Override // com.baseflow.permissionhandler.ErrorCallback
                    public final void onError(String str2, String str3) {
                        MethodChannel.Result.this.error(str2, str3, null);
                    }
                });
                return;
            default:
                result.notImplemented();
                return;
        }
    }
}
