package com.google.common.eventbus;

@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
public interface SubscriberExceptionHandler {
    void handleException(Throwable exception, SubscriberExceptionContext context);
}
