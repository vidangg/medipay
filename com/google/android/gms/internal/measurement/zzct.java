package com.google.android.gms.internal.measurement;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-base@@22.4.0 */
/* loaded from: classes3.dex */
public final class zzct extends zzbm implements zzcv {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzct(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.api.internal.IAppMeasurementDynamiteService");
    }

    @Override // com.google.android.gms.internal.measurement.zzcv
    public final void beginAdUnitExposure(String str, long j) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeLong(j);
        zzc(23, zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcv
    public final void clearConditionalUserProperty(String str, String str2, Bundle bundle) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        zzbo.zzd(zza, bundle);
        zzc(9, zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcv
    public final void clearMeasurementEnabled(long j) throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.internal.measurement.zzcv
    public final void endAdUnitExposure(String str, long j) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeLong(j);
        zzc(24, zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcv
    public final void generateEventId(zzcy zzcyVar) throws RemoteException {
        Parcel zza = zza();
        zzbo.zze(zza, zzcyVar);
        zzc(22, zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcv
    public final void getAppInstanceId(zzcy zzcyVar) throws RemoteException {
        Parcel zza = zza();
        zzbo.zze(zza, zzcyVar);
        zzc(20, zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcv
    public final void getCachedAppInstanceId(zzcy zzcyVar) throws RemoteException {
        Parcel zza = zza();
        zzbo.zze(zza, zzcyVar);
        zzc(19, zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcv
    public final void getConditionalUserProperties(String str, String str2, zzcy zzcyVar) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        zzbo.zze(zza, zzcyVar);
        zzc(10, zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcv
    public final void getCurrentScreenClass(zzcy zzcyVar) throws RemoteException {
        Parcel zza = zza();
        zzbo.zze(zza, zzcyVar);
        zzc(17, zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcv
    public final void getCurrentScreenName(zzcy zzcyVar) throws RemoteException {
        Parcel zza = zza();
        zzbo.zze(zza, zzcyVar);
        zzc(16, zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcv
    public final void getGmpAppId(zzcy zzcyVar) throws RemoteException {
        Parcel zza = zza();
        zzbo.zze(zza, zzcyVar);
        zzc(21, zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcv
    public final void getMaxUserProperties(String str, zzcy zzcyVar) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzbo.zze(zza, zzcyVar);
        zzc(6, zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcv
    public final void getSessionId(zzcy zzcyVar) throws RemoteException {
        Parcel zza = zza();
        zzbo.zze(zza, zzcyVar);
        zzc(46, zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcv
    public final void getTestFlag(zzcy zzcyVar, int i) throws RemoteException {
        Parcel zza = zza();
        zzbo.zze(zza, zzcyVar);
        zza.writeInt(i);
        zzc(38, zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcv
    public final void getUserProperties(String str, String str2, boolean z, zzcy zzcyVar) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        int i = zzbo.zza;
        zza.writeInt(z ? 1 : 0);
        zzbo.zze(zza, zzcyVar);
        zzc(5, zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcv
    public final void initForTests(Map map) throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.internal.measurement.zzcv
    public final void initialize(IObjectWrapper iObjectWrapper, zzdh zzdhVar, long j) throws RemoteException {
        Parcel zza = zza();
        zzbo.zze(zza, iObjectWrapper);
        zzbo.zzd(zza, zzdhVar);
        zza.writeLong(j);
        zzc(1, zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcv
    public final void isDataCollectionEnabled(zzcy zzcyVar) throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.internal.measurement.zzcv
    public final void logEvent(String str, String str2, Bundle bundle, boolean z, boolean z2, long j) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        zzbo.zzd(zza, bundle);
        zza.writeInt(z ? 1 : 0);
        zza.writeInt(z2 ? 1 : 0);
        zza.writeLong(j);
        zzc(2, zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcv
    public final void logEventAndBundle(String str, String str2, Bundle bundle, zzcy zzcyVar, long j) throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.internal.measurement.zzcv
    public final void logHealthData(int i, String str, IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) throws RemoteException {
        Parcel zza = zza();
        zza.writeInt(5);
        zza.writeString(str);
        zzbo.zze(zza, iObjectWrapper);
        zzbo.zze(zza, iObjectWrapper2);
        zzbo.zze(zza, iObjectWrapper3);
        zzc(33, zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcv
    public final void onActivityCreated(IObjectWrapper iObjectWrapper, Bundle bundle, long j) throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.internal.measurement.zzcv
    public final void onActivityCreatedByScionActivityInfo(zzdj zzdjVar, Bundle bundle, long j) throws RemoteException {
        Parcel zza = zza();
        zzbo.zzd(zza, zzdjVar);
        zzbo.zzd(zza, bundle);
        zza.writeLong(j);
        zzc(53, zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcv
    public final void onActivityDestroyed(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.internal.measurement.zzcv
    public final void onActivityDestroyedByScionActivityInfo(zzdj zzdjVar, long j) throws RemoteException {
        Parcel zza = zza();
        zzbo.zzd(zza, zzdjVar);
        zza.writeLong(j);
        zzc(54, zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcv
    public final void onActivityPaused(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.internal.measurement.zzcv
    public final void onActivityPausedByScionActivityInfo(zzdj zzdjVar, long j) throws RemoteException {
        Parcel zza = zza();
        zzbo.zzd(zza, zzdjVar);
        zza.writeLong(j);
        zzc(55, zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcv
    public final void onActivityResumed(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.internal.measurement.zzcv
    public final void onActivityResumedByScionActivityInfo(zzdj zzdjVar, long j) throws RemoteException {
        Parcel zza = zza();
        zzbo.zzd(zza, zzdjVar);
        zza.writeLong(j);
        zzc(56, zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcv
    public final void onActivitySaveInstanceState(IObjectWrapper iObjectWrapper, zzcy zzcyVar, long j) throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.internal.measurement.zzcv
    public final void onActivitySaveInstanceStateByScionActivityInfo(zzdj zzdjVar, zzcy zzcyVar, long j) throws RemoteException {
        Parcel zza = zza();
        zzbo.zzd(zza, zzdjVar);
        zzbo.zze(zza, zzcyVar);
        zza.writeLong(j);
        zzc(57, zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcv
    public final void onActivityStarted(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.internal.measurement.zzcv
    public final void onActivityStartedByScionActivityInfo(zzdj zzdjVar, long j) throws RemoteException {
        Parcel zza = zza();
        zzbo.zzd(zza, zzdjVar);
        zza.writeLong(j);
        zzc(51, zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcv
    public final void onActivityStopped(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.internal.measurement.zzcv
    public final void onActivityStoppedByScionActivityInfo(zzdj zzdjVar, long j) throws RemoteException {
        Parcel zza = zza();
        zzbo.zzd(zza, zzdjVar);
        zza.writeLong(j);
        zzc(52, zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcv
    public final void performAction(Bundle bundle, zzcy zzcyVar, long j) throws RemoteException {
        Parcel zza = zza();
        zzbo.zzd(zza, bundle);
        zzbo.zze(zza, zzcyVar);
        zza.writeLong(j);
        zzc(32, zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcv
    public final void registerOnMeasurementEventListener(zzde zzdeVar) throws RemoteException {
        Parcel zza = zza();
        zzbo.zze(zza, zzdeVar);
        zzc(35, zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcv
    public final void resetAnalyticsData(long j) throws RemoteException {
        Parcel zza = zza();
        zza.writeLong(j);
        zzc(12, zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcv
    public final void retrieveAndUploadBatches(zzdb zzdbVar) throws RemoteException {
        Parcel zza = zza();
        zzbo.zze(zza, zzdbVar);
        zzc(58, zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcv
    public final void setConditionalUserProperty(Bundle bundle, long j) throws RemoteException {
        Parcel zza = zza();
        zzbo.zzd(zza, bundle);
        zza.writeLong(j);
        zzc(8, zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcv
    public final void setConsent(Bundle bundle, long j) throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.internal.measurement.zzcv
    public final void setConsentThirdParty(Bundle bundle, long j) throws RemoteException {
        Parcel zza = zza();
        zzbo.zzd(zza, bundle);
        zza.writeLong(j);
        zzc(45, zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcv
    public final void setCurrentScreen(IObjectWrapper iObjectWrapper, String str, String str2, long j) throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.internal.measurement.zzcv
    public final void setCurrentScreenByScionActivityInfo(zzdj zzdjVar, String str, String str2, long j) throws RemoteException {
        Parcel zza = zza();
        zzbo.zzd(zza, zzdjVar);
        zza.writeString(str);
        zza.writeString(str2);
        zza.writeLong(j);
        zzc(50, zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcv
    public final void setDataCollectionEnabled(boolean z) throws RemoteException {
        Parcel zza = zza();
        int i = zzbo.zza;
        zza.writeInt(z ? 1 : 0);
        zzc(39, zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcv
    public final void setDefaultEventParameters(Bundle bundle) throws RemoteException {
        Parcel zza = zza();
        zzbo.zzd(zza, bundle);
        zzc(42, zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcv
    public final void setEventInterceptor(zzde zzdeVar) throws RemoteException {
        Parcel zza = zza();
        zzbo.zze(zza, zzdeVar);
        zzc(34, zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcv
    public final void setInstanceIdProvider(zzdg zzdgVar) throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.internal.measurement.zzcv
    public final void setMeasurementEnabled(boolean z, long j) throws RemoteException {
        Parcel zza = zza();
        int i = zzbo.zza;
        zza.writeInt(z ? 1 : 0);
        zza.writeLong(j);
        zzc(11, zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcv
    public final void setMinimumSessionDuration(long j) throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.internal.measurement.zzcv
    public final void setSessionTimeoutDuration(long j) throws RemoteException {
        Parcel zza = zza();
        zza.writeLong(j);
        zzc(14, zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcv
    public final void setSgtmDebugInfo(Intent intent) throws RemoteException {
        Parcel zza = zza();
        zzbo.zzd(zza, intent);
        zzc(48, zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcv
    public final void setUserId(String str, long j) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeLong(j);
        zzc(7, zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcv
    public final void setUserProperty(String str, String str2, IObjectWrapper iObjectWrapper, boolean z, long j) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        zzbo.zze(zza, iObjectWrapper);
        zza.writeInt(z ? 1 : 0);
        zza.writeLong(j);
        zzc(4, zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcv
    public final void unregisterOnMeasurementEventListener(zzde zzdeVar) throws RemoteException {
        Parcel zza = zza();
        zzbo.zze(zza, zzdeVar);
        zzc(36, zza);
    }
}
