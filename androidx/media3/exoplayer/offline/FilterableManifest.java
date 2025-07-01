package androidx.media3.exoplayer.offline;

import androidx.media3.common.StreamKey;
import java.util.List;

/* loaded from: classes.dex */
public interface FilterableManifest<T> {
    T copy(List<StreamKey> list);
}
