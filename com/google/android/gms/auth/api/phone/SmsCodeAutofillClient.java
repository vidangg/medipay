package com.google.android.gms.auth.api.phone;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.HasApiKey;
import com.google.android.gms.tasks.Task;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* compiled from: com.google.android.gms:play-services-auth-api-phone@@18.0.2 */
/* loaded from: classes3.dex */
public interface SmsCodeAutofillClient extends HasApiKey<Api.ApiOptions.NoOptions> {

    /* compiled from: com.google.android.gms:play-services-auth-api-phone@@18.0.2 */
    @Target({ElementType.TYPE_PARAMETER, ElementType.TYPE_USE})
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface PermissionState {
        public static final int DENIED = 2;
        public static final int GRANTED = 1;
        public static final int NONE = 0;
    }

    Task<Integer> checkPermissionState();

    Task<Boolean> hasOngoingSmsRequest(String str);

    Task<Void> startSmsCodeRetriever();
}
