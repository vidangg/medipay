package io.flutter.embedding.engine.plugins.activity;

/* loaded from: classes4.dex */
public interface ActivityAware {
    void onAttachedToActivity(ActivityPluginBinding activityPluginBinding);

    void onDetachedFromActivity();

    void onDetachedFromActivityForConfigChanges();

    void onReattachedToActivityForConfigChanges(ActivityPluginBinding activityPluginBinding);
}
