package androidx.media3.extractor;

import androidx.media3.common.C;
import androidx.media3.common.DataReader;
import androidx.media3.common.Format;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.ParsableByteArray;
import java.io.IOException;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* loaded from: classes3.dex */
public final class SingleSampleExtractor implements Extractor {
    private static final int FIXED_READ_LENGTH = 1024;
    public static final int IMAGE_TRACK_ID = 1024;
    private static final int STATE_ENDED = 2;
    private static final int STATE_READING = 1;
    private ExtractorOutput extractorOutput;
    private final int fileSignature;
    private final int fileSignatureLength;
    private final String sampleMimeType;
    private int size;
    private int state;
    private TrackOutput trackOutput;

    @Override // androidx.media3.extractor.Extractor
    public void release() {
    }

    public SingleSampleExtractor(int i, int i2, String str) {
        this.fileSignature = i;
        this.fileSignatureLength = i2;
        this.sampleMimeType = str;
    }

    @Override // androidx.media3.extractor.Extractor
    public boolean sniff(ExtractorInput extractorInput) throws IOException {
        Assertions.checkState((this.fileSignature == -1 || this.fileSignatureLength == -1) ? false : true);
        ParsableByteArray parsableByteArray = new ParsableByteArray(this.fileSignatureLength);
        extractorInput.peekFully(parsableByteArray.getData(), 0, this.fileSignatureLength);
        return parsableByteArray.readUnsignedShort() == this.fileSignature;
    }

    @Override // androidx.media3.extractor.Extractor
    public void init(ExtractorOutput extractorOutput) {
        this.extractorOutput = extractorOutput;
        outputImageTrackAndSeekMap(this.sampleMimeType);
    }

    @Override // androidx.media3.extractor.Extractor
    public int read(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException {
        int i = this.state;
        if (i == 1) {
            readSegment(extractorInput);
            return 0;
        }
        if (i == 2) {
            return -1;
        }
        throw new IllegalStateException();
    }

    @Override // androidx.media3.extractor.Extractor
    public void seek(long j, long j2) {
        if (j == 0 || this.state == 1) {
            this.state = 1;
            this.size = 0;
        }
    }

    private void readSegment(ExtractorInput extractorInput) throws IOException {
        int sampleData = ((TrackOutput) Assertions.checkNotNull(this.trackOutput)).sampleData((DataReader) extractorInput, 1024, true);
        if (sampleData == -1) {
            this.state = 2;
            this.trackOutput.sampleMetadata(0L, 1, this.size, 0, null);
            this.size = 0;
            return;
        }
        this.size += sampleData;
    }

    @RequiresNonNull({"this.extractorOutput"})
    private void outputImageTrackAndSeekMap(String str) {
        TrackOutput track = this.extractorOutput.track(1024, 4);
        this.trackOutput = track;
        track.format(new Format.Builder().setSampleMimeType(str).build());
        this.extractorOutput.endTracks();
        this.extractorOutput.seekMap(new SingleSampleSeekMap(C.TIME_UNSET));
        this.state = 1;
    }
}
