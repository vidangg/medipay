package com.google.common.hash;

import java.nio.Buffer;

@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
final class Java8Compatibility {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void clear(Buffer b) {
        b.clear();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void flip(Buffer b) {
        b.flip();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void limit(Buffer b, int limit) {
        b.limit(limit);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void position(Buffer b, int position) {
        b.position(position);
    }

    private Java8Compatibility() {
    }
}
