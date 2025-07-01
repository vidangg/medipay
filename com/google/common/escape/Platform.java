package com.google.common.escape;

import java.util.Objects;

@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
final class Platform {
    private static final ThreadLocal<char[]> DEST_TL = new ThreadLocal<char[]>() { // from class: com.google.common.escape.Platform.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        public char[] initialValue() {
            return new char[1024];
        }
    };

    private Platform() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static char[] charBufferFromThreadLocal() {
        return (char[]) Objects.requireNonNull(DEST_TL.get());
    }
}
