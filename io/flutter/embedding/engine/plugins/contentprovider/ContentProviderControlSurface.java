package io.flutter.embedding.engine.plugins.contentprovider;

import android.content.ContentProvider;
import androidx.lifecycle.Lifecycle;

/* loaded from: classes4.dex */
public interface ContentProviderControlSurface {
    void attachToContentProvider(ContentProvider contentProvider, Lifecycle lifecycle);

    void detachFromContentProvider();
}
