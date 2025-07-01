package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

import java.io.IOException;
import java.util.Iterator;
import java.util.Objects;
import javax.annotation.CheckForNull;
import org.apache.commons.io.IOUtils;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
public final class zbkg {
    private final String zba = IOUtils.LINE_SEPARATOR_UNIX;

    private zbkg(String str) {
    }

    public static zbkg zba(String str) {
        return new zbkg(IOUtils.LINE_SEPARATOR_UNIX);
    }

    static final CharSequence zbc(@CheckForNull Object obj) {
        Objects.requireNonNull(obj);
        return obj instanceof CharSequence ? (CharSequence) obj : obj.toString();
    }

    public final String zbb(Iterable iterable) {
        Iterator it = iterable.iterator();
        StringBuilder sb = new StringBuilder();
        try {
            if (it.hasNext()) {
                sb.append(zbc(it.next()));
                while (it.hasNext()) {
                    sb.append((CharSequence) this.zba);
                    sb.append(zbc(it.next()));
                }
            }
            return sb.toString();
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }
}
