package com.google.android.gms.internal.common;

import java.util.Objects;
import javax.annotation.CheckForNull;
import org.jspecify.annotations.NullMarked;

/* compiled from: com.google.android.gms:play-services-basement@@18.5.0 */
@NullMarked
/* loaded from: classes3.dex */
public final class zzt {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static final CharSequence zza(@CheckForNull Object obj, String str) {
        Objects.requireNonNull(obj);
        return obj instanceof CharSequence ? (CharSequence) obj : obj.toString();
    }
}
