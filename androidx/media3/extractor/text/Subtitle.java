package androidx.media3.extractor.text;

import androidx.media3.common.text.Cue;
import java.util.List;

/* loaded from: classes3.dex */
public interface Subtitle {
    List<Cue> getCues(long j);

    long getEventTime(int i);

    int getEventTimeCount();

    int getNextEventTimeIndex(long j);
}
