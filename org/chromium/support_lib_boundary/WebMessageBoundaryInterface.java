package org.chromium.support_lib_boundary;

import java.lang.reflect.InvocationHandler;

/* loaded from: classes4.dex */
public interface WebMessageBoundaryInterface extends FeatureFlagHolderBoundaryInterface {
    @Deprecated
    String getData();

    InvocationHandler getMessagePayload();

    InvocationHandler[] getPorts();
}
