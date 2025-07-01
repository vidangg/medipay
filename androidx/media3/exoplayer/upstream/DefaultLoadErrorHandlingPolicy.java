package androidx.media3.exoplayer.upstream;

import androidx.media3.common.C;
import androidx.media3.common.ParserException;
import androidx.media3.datasource.DataSourceException;
import androidx.media3.datasource.HttpDataSource;
import androidx.media3.exoplayer.DefaultLoadControl;
import androidx.media3.exoplayer.upstream.LoadErrorHandlingPolicy;
import androidx.media3.exoplayer.upstream.Loader;
import java.io.FileNotFoundException;
import java.io.IOException;

/* loaded from: classes3.dex */
public class DefaultLoadErrorHandlingPolicy implements LoadErrorHandlingPolicy {
    private static final int DEFAULT_BEHAVIOR_MIN_LOADABLE_RETRY_COUNT = -1;
    public static final long DEFAULT_LOCATION_EXCLUSION_MS = 300000;
    public static final int DEFAULT_MIN_LOADABLE_RETRY_COUNT = 3;
    public static final int DEFAULT_MIN_LOADABLE_RETRY_COUNT_PROGRESSIVE_LIVE = 6;

    @Deprecated
    public static final long DEFAULT_TRACK_BLACKLIST_MS = 60000;
    public static final long DEFAULT_TRACK_EXCLUSION_MS = 60000;
    private final int minimumLoadableRetryCount;

    public DefaultLoadErrorHandlingPolicy() {
        this(-1);
    }

    public DefaultLoadErrorHandlingPolicy(int i) {
        this.minimumLoadableRetryCount = i;
    }

    @Override // androidx.media3.exoplayer.upstream.LoadErrorHandlingPolicy
    public LoadErrorHandlingPolicy.FallbackSelection getFallbackSelectionFor(LoadErrorHandlingPolicy.FallbackOptions fallbackOptions, LoadErrorHandlingPolicy.LoadErrorInfo loadErrorInfo) {
        if (!isEligibleForFallback(loadErrorInfo.exception)) {
            return null;
        }
        if (fallbackOptions.isFallbackAvailable(1)) {
            return new LoadErrorHandlingPolicy.FallbackSelection(1, 300000L);
        }
        if (fallbackOptions.isFallbackAvailable(2)) {
            return new LoadErrorHandlingPolicy.FallbackSelection(2, 60000L);
        }
        return null;
    }

    @Override // androidx.media3.exoplayer.upstream.LoadErrorHandlingPolicy
    public long getRetryDelayMsFor(LoadErrorHandlingPolicy.LoadErrorInfo loadErrorInfo) {
        IOException iOException = loadErrorInfo.exception;
        return ((iOException instanceof ParserException) || (iOException instanceof FileNotFoundException) || (iOException instanceof HttpDataSource.CleartextNotPermittedException) || (iOException instanceof Loader.UnexpectedLoaderException) || DataSourceException.isCausedByPositionOutOfRange(iOException)) ? C.TIME_UNSET : Math.min((loadErrorInfo.errorCount - 1) * 1000, DefaultLoadControl.DEFAULT_BUFFER_FOR_PLAYBACK_AFTER_REBUFFER_MS);
    }

    @Override // androidx.media3.exoplayer.upstream.LoadErrorHandlingPolicy
    public int getMinimumLoadableRetryCount(int i) {
        int i2 = this.minimumLoadableRetryCount;
        return i2 == -1 ? i == 7 ? 6 : 3 : i2;
    }

    protected boolean isEligibleForFallback(IOException iOException) {
        if (!(iOException instanceof HttpDataSource.InvalidResponseCodeException)) {
            return false;
        }
        HttpDataSource.InvalidResponseCodeException invalidResponseCodeException = (HttpDataSource.InvalidResponseCodeException) iOException;
        return invalidResponseCodeException.responseCode == 403 || invalidResponseCodeException.responseCode == 404 || invalidResponseCodeException.responseCode == 410 || invalidResponseCodeException.responseCode == 416 || invalidResponseCodeException.responseCode == 500 || invalidResponseCodeException.responseCode == 503;
    }
}
