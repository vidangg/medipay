package com.google.android.gms.internal.location;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResponse;
import com.google.android.gms.location.SettingsClient;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-location@@21.0.1 */
/* loaded from: classes3.dex */
public final class zzce extends GoogleApi implements SettingsClient {
    public static final /* synthetic */ int zza = 0;

    public zzce(Activity activity) {
        super(activity, (Api<Api.ApiOptions.NoOptions>) zzbp.zzb, Api.ApiOptions.NO_OPTIONS, GoogleApi.Settings.DEFAULT_SETTINGS);
    }

    @Override // com.google.android.gms.location.SettingsClient
    public final Task<LocationSettingsResponse> checkLocationSettings(final LocationSettingsRequest locationSettingsRequest) {
        return doRead(TaskApiCall.builder().run(new RemoteCall() { // from class: com.google.android.gms.internal.location.zzcd
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) {
                LocationSettingsRequest locationSettingsRequest2 = LocationSettingsRequest.this;
                zzda zzdaVar = (zzda) obj;
                TaskCompletionSource taskCompletionSource = (TaskCompletionSource) obj2;
                boolean z = locationSettingsRequest2 != null;
                int i = zzce.zza;
                Preconditions.checkArgument(z, "locationSettingsRequest can't be null");
                ((zzo) zzdaVar.getService()).zzh(locationSettingsRequest2, new zzcq(taskCompletionSource), null);
            }
        }).setMethodKey(2426).build());
    }

    public zzce(Context context) {
        super(context, (Api<Api.ApiOptions.NoOptions>) zzbp.zzb, Api.ApiOptions.NO_OPTIONS, GoogleApi.Settings.DEFAULT_SETTINGS);
    }
}
