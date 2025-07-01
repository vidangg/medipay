package com.google.android.gms.measurement.internal;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.4.0 */
/* loaded from: classes3.dex */
public final class zzlv implements Application.ActivityLifecycleCallbacks, zzlt {
    final /* synthetic */ zzlw zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzlv(zzlw zzlwVar) {
        this.zza = zzlwVar;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        zza(com.google.android.gms.internal.measurement.zzdj.zza(activity), bundle);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        zzb(com.google.android.gms.internal.measurement.zzdj.zza(activity));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        zzc(com.google.android.gms.internal.measurement.zzdj.zza(activity));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        zzd(com.google.android.gms.internal.measurement.zzdj.zza(activity));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        zze(com.google.android.gms.internal.measurement.zzdj.zza(activity), bundle);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0077  */
    @Override // com.google.android.gms.measurement.internal.zzlt
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zza(com.google.android.gms.internal.measurement.zzdj zzdjVar, Bundle bundle) {
        zzio zzioVar;
        zzlw zzlwVar;
        zzio zzioVar2;
        Intent intent;
        Uri uri;
        String stringExtra;
        String str;
        try {
            try {
                zzlwVar = this.zza;
                zzioVar2 = zzlwVar.zzu;
                zzioVar2.zzaW().zzj().zza("onActivityCreated");
                intent = zzdjVar.zzc;
            } catch (RuntimeException e) {
                this.zza.zzu.zzaW().zze().zzb("Throwable caught in onActivityCreated", e);
            }
            if (intent != null) {
                Uri data = intent.getData();
                if (data != null) {
                    if (!data.isHierarchical()) {
                    }
                    uri = data;
                    if (uri != null && uri.isHierarchical()) {
                        zzioVar2.zzw();
                        stringExtra = intent.getStringExtra("android.intent.extra.REFERRER_NAME");
                        if (!"android-app://com.google.android.googlequicksearchbox/https/www.google.com".equals(stringExtra) && !"https://www.google.com".equals(stringExtra) && !"android-app://com.google.appcrawler".equals(stringExtra)) {
                            str = "auto";
                            zzioVar2.zzaX().zzq(new zzlu(this, bundle != null, uri, str, uri.getQueryParameter("referrer")));
                            zzioVar = this.zza.zzu;
                            zzioVar.zzt().zzs(zzdjVar, bundle);
                        }
                        str = "gs";
                        zzioVar2.zzaX().zzq(new zzlu(this, bundle != null, uri, str, uri.getQueryParameter("referrer")));
                        zzioVar = this.zza.zzu;
                        zzioVar.zzt().zzs(zzdjVar, bundle);
                    }
                }
                Bundle extras = intent.getExtras();
                uri = null;
                if (extras != null) {
                    String string = extras.getString("com.android.vending.referral_url");
                    if (!TextUtils.isEmpty(string)) {
                        data = Uri.parse(string);
                        uri = data;
                    }
                }
                if (uri != null) {
                    zzioVar2.zzw();
                    stringExtra = intent.getStringExtra("android.intent.extra.REFERRER_NAME");
                    if (!"android-app://com.google.android.googlequicksearchbox/https/www.google.com".equals(stringExtra)) {
                        str = "auto";
                        zzioVar2.zzaX().zzq(new zzlu(this, bundle != null, uri, str, uri.getQueryParameter("referrer")));
                        zzioVar = this.zza.zzu;
                        zzioVar.zzt().zzs(zzdjVar, bundle);
                    }
                    str = "gs";
                    zzioVar2.zzaX().zzq(new zzlu(this, bundle != null, uri, str, uri.getQueryParameter("referrer")));
                    zzioVar = this.zza.zzu;
                    zzioVar.zzt().zzs(zzdjVar, bundle);
                }
            }
            zzioVar = zzlwVar.zzu;
            zzioVar.zzt().zzs(zzdjVar, bundle);
        } catch (Throwable th) {
            this.zza.zzu.zzt().zzs(zzdjVar, bundle);
            throw th;
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzlt
    public final void zzb(com.google.android.gms.internal.measurement.zzdj zzdjVar) {
        this.zza.zzu.zzt().zzt(zzdjVar);
    }

    @Override // com.google.android.gms.measurement.internal.zzlt
    public final void zzc(com.google.android.gms.internal.measurement.zzdj zzdjVar) {
        zzio zzioVar = this.zza.zzu;
        zzioVar.zzt().zzu(zzdjVar);
        zzop zzv = zzioVar.zzv();
        zzio zzioVar2 = zzv.zzu;
        zzioVar2.zzaX().zzq(new zzoi(zzv, zzioVar2.zzaU().elapsedRealtime()));
    }

    @Override // com.google.android.gms.measurement.internal.zzlt
    public final void zzd(com.google.android.gms.internal.measurement.zzdj zzdjVar) {
        zzio zzioVar = this.zza.zzu;
        zzop zzv = zzioVar.zzv();
        zzio zzioVar2 = zzv.zzu;
        zzioVar2.zzaX().zzq(new zzoh(zzv, zzioVar2.zzaU().elapsedRealtime()));
        zzioVar.zzt().zzv(zzdjVar);
    }

    @Override // com.google.android.gms.measurement.internal.zzlt
    public final void zze(com.google.android.gms.internal.measurement.zzdj zzdjVar, Bundle bundle) {
        this.zza.zzu.zzt().zzw(zzdjVar, bundle);
    }
}
