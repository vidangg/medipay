package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import android.content.Context;
import android.location.Location;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import androidx.collection.SimpleArrayMap;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.internal.ConnectionCallbacks;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.ListenerHolders;
import com.google.android.gms.common.api.internal.OnConnectionFailedListener;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.GmsClient;
import com.google.android.gms.common.internal.ICancelToken;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.location.CurrentLocationRequest;
import com.google.android.gms.location.GeofencingRequest;
import com.google.android.gms.location.LastLocationRequest;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.tasks.CancellationToken;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnTokenCanceledListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-location@@21.0.1 */
/* loaded from: classes3.dex */
public final class zzda extends GmsClient {
    public static final /* synthetic */ int zze = 0;
    private final SimpleArrayMap zzf;
    private final SimpleArrayMap zzg;
    private final SimpleArrayMap zzh;

    public zzda(Context context, Looper looper, ClientSettings clientSettings, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 23, clientSettings, connectionCallbacks, onConnectionFailedListener);
        this.zzf = new SimpleArrayMap();
        this.zzg = new SimpleArrayMap();
        this.zzh = new SimpleArrayMap();
    }

    private final boolean zzE(Feature feature) {
        Feature feature2;
        Feature[] availableFeatures = getAvailableFeatures();
        if (availableFeatures == null) {
            return false;
        }
        int length = availableFeatures.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                feature2 = null;
                break;
            }
            feature2 = availableFeatures[i];
            if (feature.getName().equals(feature2.getName())) {
                break;
            }
            i++;
        }
        return feature2 != null && feature2.getVersion() >= feature.getVersion();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final /* synthetic */ IInterface createServiceInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        return queryLocalInterface instanceof zzo ? (zzo) queryLocalInterface : new zzn(iBinder);
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final Feature[] getApiFeatures() {
        return com.google.android.gms.location.zzm.zzl;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.Api.Client
    public final int getMinApkVersion() {
        return 11717000;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final String getServiceDescriptor() {
        return "com.google.android.gms.location.internal.IGoogleLocationManagerService";
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    protected final String getStartServiceAction() {
        return "com.google.android.location.internal.GoogleLocationManagerService.START";
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final void onConnectionSuspended(int i) {
        super.onConnectionSuspended(i);
        synchronized (this.zzf) {
            this.zzf.clear();
        }
        synchronized (this.zzg) {
            this.zzg.clear();
        }
        synchronized (this.zzh) {
            this.zzh.clear();
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final boolean usesClientTelemetry() {
        return true;
    }

    public final void zzA(boolean z, TaskCompletionSource taskCompletionSource) throws RemoteException {
        if (zzE(com.google.android.gms.location.zzm.zzg)) {
            ((zzo) getService()).zzx(z, new zzcl(this, null, taskCompletionSource));
        } else {
            ((zzo) getService()).zzw(z);
            taskCompletionSource.setResult(null);
        }
    }

    public final void zzB(ListenerHolder.ListenerKey listenerKey, boolean z, TaskCompletionSource taskCompletionSource) throws RemoteException {
        synchronized (this.zzg) {
            zzcw zzcwVar = (zzcw) this.zzg.remove(listenerKey);
            if (zzcwVar == null) {
                taskCompletionSource.setResult(Boolean.FALSE);
                return;
            }
            zzcwVar.zzh();
            if (z) {
                if (zzE(com.google.android.gms.location.zzm.zzj)) {
                    ((zzo) getService()).zzy(zzdb.zzb(null, zzcwVar, null, null), new zzcl(this, Boolean.TRUE, taskCompletionSource));
                } else {
                    ((zzo) getService()).zzz(new zzdf(2, null, null, zzcwVar, null, new zzcn(Boolean.TRUE, taskCompletionSource), null));
                }
            } else {
                taskCompletionSource.setResult(Boolean.TRUE);
            }
        }
    }

    public final void zzC(ListenerHolder.ListenerKey listenerKey, boolean z, TaskCompletionSource taskCompletionSource) throws RemoteException {
        synchronized (this.zzf) {
            zzcz zzczVar = (zzcz) this.zzf.remove(listenerKey);
            if (zzczVar == null) {
                taskCompletionSource.setResult(Boolean.FALSE);
                return;
            }
            zzczVar.zzg();
            if (z) {
                if (zzE(com.google.android.gms.location.zzm.zzj)) {
                    ((zzo) getService()).zzy(zzdb.zzc(null, zzczVar, null, null), new zzcl(this, Boolean.TRUE, taskCompletionSource));
                } else {
                    ((zzo) getService()).zzz(new zzdf(2, null, zzczVar, null, null, new zzcn(Boolean.TRUE, taskCompletionSource), null));
                }
            } else {
                taskCompletionSource.setResult(Boolean.TRUE);
            }
        }
    }

    public final void zzD(PendingIntent pendingIntent, TaskCompletionSource taskCompletionSource, Object obj) throws RemoteException {
        if (zzE(com.google.android.gms.location.zzm.zzj)) {
            ((zzo) getService()).zzy(zzdb.zza(pendingIntent, null, null), new zzcl(this, null, taskCompletionSource));
        } else {
            ((zzo) getService()).zzz(new zzdf(2, null, null, null, pendingIntent, new zzcn(null, taskCompletionSource), null));
        }
    }

    public final LocationAvailability zzp() throws RemoteException {
        return ((zzo) getService()).zzf(getContext().getPackageName());
    }

    public final void zzq(GeofencingRequest geofencingRequest, PendingIntent pendingIntent, TaskCompletionSource taskCompletionSource) throws RemoteException {
        Preconditions.checkNotNull(geofencingRequest, "geofencingRequest can't be null.");
        Preconditions.checkNotNull(pendingIntent, "PendingIntent must be specified.");
        ((zzo) getService()).zzg(geofencingRequest, pendingIntent, new zzci(taskCompletionSource));
    }

    public final void zzr(TaskCompletionSource taskCompletionSource) throws RemoteException {
        ((zzo) getService()).zzi(new zzcn(null, taskCompletionSource));
    }

    public final void zzs(CurrentLocationRequest currentLocationRequest, CancellationToken cancellationToken, final TaskCompletionSource taskCompletionSource) throws RemoteException {
        getContext();
        if (zzE(com.google.android.gms.location.zzm.zze)) {
            final ICancelToken zze2 = ((zzo) getService()).zze(currentLocationRequest, new zzcm(this, taskCompletionSource));
            if (cancellationToken != null) {
                cancellationToken.onCanceledRequested(new OnTokenCanceledListener() { // from class: com.google.android.gms.internal.location.zzcf
                    @Override // com.google.android.gms.tasks.OnTokenCanceledListener
                    public final void onCanceled() {
                        ICancelToken iCancelToken = ICancelToken.this;
                        int i = zzda.zze;
                        try {
                            iCancelToken.cancel();
                        } catch (RemoteException unused) {
                        }
                    }
                });
                return;
            }
            return;
        }
        ListenerHolder createListenerHolder = ListenerHolders.createListenerHolder(new zzcj(this, taskCompletionSource), zzdx.zza(), "GetCurrentLocation");
        final ListenerHolder.ListenerKey listenerKey = createListenerHolder.getListenerKey();
        listenerKey.getClass();
        zzck zzckVar = new zzck(this, createListenerHolder, taskCompletionSource);
        TaskCompletionSource taskCompletionSource2 = new TaskCompletionSource();
        LocationRequest.Builder builder = new LocationRequest.Builder(currentLocationRequest.getPriority(), 0L);
        builder.setMinUpdateIntervalMillis(0L);
        builder.setDurationMillis(currentLocationRequest.getDurationMillis());
        builder.setGranularity(currentLocationRequest.getGranularity());
        builder.setMaxUpdateAgeMillis(currentLocationRequest.getMaxUpdateAgeMillis());
        builder.zza(currentLocationRequest.zze());
        builder.zzc(currentLocationRequest.zza());
        builder.setWaitForAccurateLocation(true);
        builder.zzb(currentLocationRequest.zzd());
        builder.zzd(currentLocationRequest.zzb());
        zzu(zzckVar, builder.build(), taskCompletionSource2);
        taskCompletionSource2.getTask().addOnCompleteListener(new OnCompleteListener() { // from class: com.google.android.gms.internal.location.zzcg
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                TaskCompletionSource taskCompletionSource3 = TaskCompletionSource.this;
                int i = zzda.zze;
                if (task.isSuccessful()) {
                    return;
                }
                Exception exception = task.getException();
                exception.getClass();
                taskCompletionSource3.trySetException(exception);
            }
        });
        if (cancellationToken != null) {
            cancellationToken.onCanceledRequested(new OnTokenCanceledListener() { // from class: com.google.android.gms.internal.location.zzch
                @Override // com.google.android.gms.tasks.OnTokenCanceledListener
                public final void onCanceled() {
                    try {
                        zzda.this.zzB(listenerKey, true, new TaskCompletionSource());
                    } catch (RemoteException unused) {
                    }
                }
            });
        }
    }

    public final void zzt(LastLocationRequest lastLocationRequest, TaskCompletionSource taskCompletionSource) throws RemoteException {
        getContext();
        if (zzE(com.google.android.gms.location.zzm.zzf)) {
            ((zzo) getService()).zzj(lastLocationRequest, new zzcm(this, taskCompletionSource));
        } else {
            taskCompletionSource.setResult(((zzo) getService()).zzd());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0044 A[Catch: all -> 0x0082, TryCatch #0 {, blocks: (B:4:0x001a, B:8:0x0028, B:9:0x003b, B:11:0x0044, B:12:0x0080, B:16:0x0057, B:17:0x002e), top: B:3:0x001a }] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0057 A[Catch: all -> 0x0082, TryCatch #0 {, blocks: (B:4:0x001a, B:8:0x0028, B:9:0x003b, B:11:0x0044, B:12:0x0080, B:16:0x0057, B:17:0x002e), top: B:3:0x001a }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zzu(zzcs zzcsVar, LocationRequest locationRequest, TaskCompletionSource taskCompletionSource) throws RemoteException {
        zzcw zzcwVar;
        ListenerHolder zza = zzcsVar.zza();
        ListenerHolder.ListenerKey listenerKey = zza.getListenerKey();
        listenerKey.getClass();
        boolean zzE = zzE(com.google.android.gms.location.zzm.zzj);
        synchronized (this.zzg) {
            zzcw zzcwVar2 = (zzcw) this.zzg.get(listenerKey);
            if (zzcwVar2 != null && !zzE) {
                zzcwVar2.zzg(zza);
                zzcwVar = zzcwVar2;
                zzcwVar2 = null;
                getContext();
                String idString = listenerKey.toIdString();
                if (!zzE) {
                    ((zzo) getService()).zzk(zzdb.zzb(zzcwVar2, zzcwVar, null, idString), locationRequest, new zzcl(this, null, taskCompletionSource));
                } else {
                    zzo zzoVar = (zzo) getService();
                    LocationRequest.Builder builder = new LocationRequest.Builder(locationRequest);
                    builder.zzb(null);
                    zzoVar.zzz(new zzdf(1, zzdd.zza(null, builder.build()), null, zzcwVar, null, new zzcp(taskCompletionSource, zzcwVar), idString));
                }
            }
            zzcw zzcwVar3 = new zzcw(zzcsVar);
            this.zzg.put(listenerKey, zzcwVar3);
            zzcwVar = zzcwVar3;
            getContext();
            String idString2 = listenerKey.toIdString();
            if (!zzE) {
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0044 A[Catch: all -> 0x0082, TryCatch #0 {, blocks: (B:4:0x001a, B:8:0x0028, B:9:0x003b, B:11:0x0044, B:12:0x0080, B:16:0x0057, B:17:0x002e), top: B:3:0x001a }] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0057 A[Catch: all -> 0x0082, TryCatch #0 {, blocks: (B:4:0x001a, B:8:0x0028, B:9:0x003b, B:11:0x0044, B:12:0x0080, B:16:0x0057, B:17:0x002e), top: B:3:0x001a }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zzv(zzcs zzcsVar, LocationRequest locationRequest, TaskCompletionSource taskCompletionSource) throws RemoteException {
        zzcz zzczVar;
        ListenerHolder zza = zzcsVar.zza();
        ListenerHolder.ListenerKey listenerKey = zza.getListenerKey();
        listenerKey.getClass();
        boolean zzE = zzE(com.google.android.gms.location.zzm.zzj);
        synchronized (this.zzf) {
            zzcz zzczVar2 = (zzcz) this.zzf.get(listenerKey);
            if (zzczVar2 != null && !zzE) {
                zzczVar2.zzf(zza);
                zzczVar = zzczVar2;
                zzczVar2 = null;
                getContext();
                String idString = listenerKey.toIdString();
                if (!zzE) {
                    ((zzo) getService()).zzk(zzdb.zzc(zzczVar2, zzczVar, null, idString), locationRequest, new zzcl(this, null, taskCompletionSource));
                } else {
                    zzo zzoVar = (zzo) getService();
                    LocationRequest.Builder builder = new LocationRequest.Builder(locationRequest);
                    builder.zzb(null);
                    zzoVar.zzz(new zzdf(1, zzdd.zza(null, builder.build()), zzczVar, null, null, new zzco(taskCompletionSource, zzczVar), idString));
                }
            }
            zzcz zzczVar3 = new zzcz(zzcsVar);
            this.zzf.put(listenerKey, zzczVar3);
            zzczVar = zzczVar3;
            getContext();
            String idString2 = listenerKey.toIdString();
            if (!zzE) {
            }
        }
    }

    public final void zzw(PendingIntent pendingIntent, LocationRequest locationRequest, TaskCompletionSource taskCompletionSource) throws RemoteException {
        getContext();
        if (zzE(com.google.android.gms.location.zzm.zzj)) {
            ((zzo) getService()).zzk(zzdb.zza(pendingIntent, null, null), locationRequest, new zzcl(this, null, taskCompletionSource));
            return;
        }
        zzo zzoVar = (zzo) getService();
        LocationRequest.Builder builder = new LocationRequest.Builder(locationRequest);
        builder.zzb(null);
        zzoVar.zzz(new zzdf(1, zzdd.zza(null, builder.build()), null, null, pendingIntent, new zzcn(null, taskCompletionSource), "PendingIntent@" + pendingIntent.hashCode()));
    }

    public final void zzx(PendingIntent pendingIntent, TaskCompletionSource taskCompletionSource) throws RemoteException {
        Preconditions.checkNotNull(pendingIntent, "PendingIntent must be specified.");
        ((zzo) getService()).zzn(pendingIntent, new zzci(taskCompletionSource), getContext().getPackageName());
    }

    public final void zzy(List list, TaskCompletionSource taskCompletionSource) throws RemoteException {
        Preconditions.checkArgument((list == null || list.isEmpty()) ? false : true, "geofenceRequestIds can't be null nor empty.");
        ((zzo) getService()).zzo((String[]) list.toArray(new String[0]), new zzci(taskCompletionSource), getContext().getPackageName());
    }

    public final void zzz(Location location, TaskCompletionSource taskCompletionSource) throws RemoteException {
        if (zzE(com.google.android.gms.location.zzm.zzh)) {
            ((zzo) getService()).zzv(location, new zzcl(this, null, taskCompletionSource));
        } else {
            ((zzo) getService()).zzu(location);
            taskCompletionSource.setResult(null);
        }
    }
}
