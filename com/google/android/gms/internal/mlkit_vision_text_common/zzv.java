package com.google.android.gms.internal.mlkit_vision_text_common;

import java.io.IOException;
import java.util.Iterator;
import java.util.Objects;
import javax.annotation.CheckForNull;
import org.apache.commons.io.IOUtils;

/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition-common@@19.1.0 */
/* loaded from: classes3.dex */
public final class zzv {
    private final String zza = IOUtils.LINE_SEPARATOR_UNIX;

    private zzv(String str) {
    }

    public static zzv zza(String str) {
        return new zzv(IOUtils.LINE_SEPARATOR_UNIX);
    }

    static final CharSequence zzc(@CheckForNull Object obj) {
        Objects.requireNonNull(obj);
        return obj instanceof CharSequence ? (CharSequence) obj : obj.toString();
    }

    public final String zzb(Iterable iterable) {
        Iterator it = iterable.iterator();
        StringBuilder sb = new StringBuilder();
        try {
            if (it.hasNext()) {
                sb.append(zzc(it.next()));
                while (it.hasNext()) {
                    sb.append((CharSequence) this.zza);
                    sb.append(zzc(it.next()));
                }
            }
            return sb.toString();
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }
}
