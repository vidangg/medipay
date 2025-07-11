package io.flutter.embedding.android;

import com.google.android.play.core.splitcompat.SplitCompatApplication;
import io.flutter.FlutterInjector;
import io.flutter.embedding.engine.deferredcomponents.PlayStoreDeferredComponentManager;

/* loaded from: classes4.dex */
public class FlutterPlayStoreSplitApplication extends SplitCompatApplication {
    /* JADX WARN: Multi-variable type inference failed */
    public void onCreate() {
        super.onCreate();
        FlutterInjector.setInstance(new FlutterInjector.Builder().setDeferredComponentManager(new PlayStoreDeferredComponentManager(this, null)).build());
    }
}
