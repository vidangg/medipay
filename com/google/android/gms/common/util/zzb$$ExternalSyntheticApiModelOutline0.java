package com.google.android.gms.common.util;

import android.app.ActivityOptions;
import android.content.res.loader.ResourcesLoader;
import android.media.ImageReader;
import android.os.Binder;
import android.view.Surface;
import android.view.SurfaceControl;
import android.view.WindowMetrics;
import android.webkit.WebViewRenderProcess;

/* compiled from: D8$$SyntheticClass */
/* loaded from: classes3.dex */
public final /* synthetic */ class zzb$$ExternalSyntheticApiModelOutline0 {
    public static /* bridge */ /* synthetic */ ActivityOptions m(ActivityOptions activityOptions, int i) {
        return activityOptions.setPendingIntentBackgroundActivityStartMode(i);
    }

    /* renamed from: m, reason: collision with other method in class */
    public static /* synthetic */ ResourcesLoader m639m() {
        return new ResourcesLoader();
    }

    public static /* synthetic */ ImageReader.Builder m(int i, int i2) {
        return new ImageReader.Builder(i, i2);
    }

    public static /* synthetic */ Binder m(String str) {
        return new Binder(str);
    }

    public static /* synthetic */ Surface m(SurfaceControl surfaceControl) {
        return new Surface(surfaceControl);
    }

    /* renamed from: m, reason: collision with other method in class */
    public static /* synthetic */ SurfaceControl.Builder m640m() {
        return new SurfaceControl.Builder();
    }

    /* renamed from: m, reason: collision with other method in class */
    public static /* synthetic */ SurfaceControl.Transaction m641m() {
        return new SurfaceControl.Transaction();
    }

    public static /* bridge */ /* synthetic */ SurfaceControl.Transaction m(Object obj) {
        return (SurfaceControl.Transaction) obj;
    }

    /* renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ WindowMetrics m643m(Object obj) {
        return (WindowMetrics) obj;
    }

    /* renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ WebViewRenderProcess m644m(Object obj) {
        return (WebViewRenderProcess) obj;
    }

    /* renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ Class m645m() {
        return WindowMetrics.class;
    }

    /* renamed from: m, reason: collision with other method in class */
    public static /* synthetic */ void m646m() {
    }

    public static /* synthetic */ void m$1() {
    }

    public static /* synthetic */ void m$2() {
    }
}
