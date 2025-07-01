package androidx.media3.extractor.text;

import androidx.media3.common.C;
import androidx.media3.common.Format;
import androidx.media3.common.util.Consumer;
import com.google.common.collect.ImmutableList;
import java.util.Objects;

/* loaded from: classes3.dex */
public interface SubtitleParser {

    /* loaded from: classes3.dex */
    public interface Factory {
        public static final Factory UNSUPPORTED = new Factory() { // from class: androidx.media3.extractor.text.SubtitleParser.Factory.1
            @Override // androidx.media3.extractor.text.SubtitleParser.Factory
            public int getCueReplacementBehavior(Format format) {
                return 1;
            }

            @Override // androidx.media3.extractor.text.SubtitleParser.Factory
            public boolean supportsFormat(Format format) {
                return false;
            }

            @Override // androidx.media3.extractor.text.SubtitleParser.Factory
            public SubtitleParser create(Format format) {
                throw new IllegalStateException("This SubtitleParser.Factory doesn't support any formats.");
            }
        };

        SubtitleParser create(Format format);

        int getCueReplacementBehavior(Format format);

        boolean supportsFormat(Format format);
    }

    int getCueReplacementBehavior();

    void parse(byte[] bArr, int i, int i2, OutputOptions outputOptions, Consumer<CuesWithTiming> consumer);

    default void reset() {
    }

    /* loaded from: classes3.dex */
    public static class OutputOptions {
        private static final OutputOptions ALL = new OutputOptions(C.TIME_UNSET, false);
        public final boolean outputAllCues;
        public final long startTimeUs;

        private OutputOptions(long j, boolean z) {
            this.startTimeUs = j;
            this.outputAllCues = z;
        }

        public static OutputOptions allCues() {
            return ALL;
        }

        public static OutputOptions onlyCuesAfter(long j) {
            return new OutputOptions(j, false);
        }

        public static OutputOptions cuesAfterThenRemainingCuesBefore(long j) {
            return new OutputOptions(j, true);
        }
    }

    default void parse(byte[] bArr, OutputOptions outputOptions, Consumer<CuesWithTiming> consumer) {
        parse(bArr, 0, bArr.length, outputOptions, consumer);
    }

    default Subtitle parseToLegacySubtitle(byte[] bArr, int i, int i2) {
        final ImmutableList.Builder builder = ImmutableList.builder();
        OutputOptions outputOptions = OutputOptions.ALL;
        Objects.requireNonNull(builder);
        parse(bArr, i, i2, outputOptions, new Consumer() { // from class: androidx.media3.extractor.text.SubtitleParser$$ExternalSyntheticLambda0
            @Override // androidx.media3.common.util.Consumer
            public final void accept(Object obj) {
                ImmutableList.Builder.this.add((ImmutableList.Builder) ((CuesWithTiming) obj));
            }
        });
        return new CuesWithTimingSubtitle(builder.build());
    }
}
