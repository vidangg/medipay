package androidx.media3.exoplayer.rtsp;

import androidx.media3.datasource.DataSource;
import androidx.media3.exoplayer.rtsp.RtspMessageChannel;
import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public interface RtpDataChannel extends DataSource {

    /* loaded from: classes.dex */
    public interface Factory {
        RtpDataChannel createAndOpenDataChannel(int i) throws IOException;

        default Factory createFallbackDataChannelFactory() {
            return null;
        }
    }

    RtspMessageChannel.InterleavedBinaryDataListener getInterleavedBinaryDataListener();

    int getLocalPort();

    String getTransport();

    boolean needsClosingOnLoadCompletion();
}
