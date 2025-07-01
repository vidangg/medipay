package io.flutter.embedding.engine.plugins.lifecycle;

import androidx.lifecycle.Lifecycle;
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;

/* loaded from: classes4.dex */
public class FlutterLifecycleAdapter {
    public static Lifecycle getActivityLifecycle(ActivityPluginBinding activityPluginBinding) {
        return ((HiddenLifecycleReference) activityPluginBinding.getLifecycle()).getLifecycle();
    }
}
