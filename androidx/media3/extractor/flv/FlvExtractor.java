package androidx.media3.extractor.flv;

import androidx.media3.common.C;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.extractor.Extractor;
import androidx.media3.extractor.ExtractorInput;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.ExtractorsFactory;
import androidx.media3.extractor.IndexSeekMap;
import androidx.media3.extractor.PositionHolder;
import androidx.media3.extractor.SeekMap;
import androidx.recyclerview.widget.ItemTouchHelper;
import java.io.IOException;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* loaded from: classes3.dex */
public final class FlvExtractor implements Extractor {
    public static final ExtractorsFactory FACTORY = new ExtractorsFactory() { // from class: androidx.media3.extractor.flv.FlvExtractor$$ExternalSyntheticLambda0
        @Override // androidx.media3.extractor.ExtractorsFactory
        public final Extractor[] createExtractors() {
            return FlvExtractor.lambda$static$0();
        }
    };
    private static final int FLV_HEADER_SIZE = 9;
    private static final int FLV_TAG = 4607062;
    private static final int FLV_TAG_HEADER_SIZE = 11;
    private static final int STATE_READING_FLV_HEADER = 1;
    private static final int STATE_READING_TAG_DATA = 4;
    private static final int STATE_READING_TAG_HEADER = 3;
    private static final int STATE_SKIPPING_TO_TAG_HEADER = 2;
    private static final int TAG_TYPE_AUDIO = 8;
    private static final int TAG_TYPE_SCRIPT_DATA = 18;
    private static final int TAG_TYPE_VIDEO = 9;
    private AudioTagPayloadReader audioReader;
    private int bytesToNextTagHeader;
    private ExtractorOutput extractorOutput;
    private long mediaTagTimestampOffsetUs;
    private boolean outputFirstSample;
    private boolean outputSeekMap;
    private int tagDataSize;
    private long tagTimestampUs;
    private int tagType;
    private VideoTagPayloadReader videoReader;
    private final ParsableByteArray scratch = new ParsableByteArray(4);
    private final ParsableByteArray headerBuffer = new ParsableByteArray(9);
    private final ParsableByteArray tagHeaderBuffer = new ParsableByteArray(11);
    private final ParsableByteArray tagData = new ParsableByteArray();
    private final ScriptTagPayloadReader metadataReader = new ScriptTagPayloadReader();
    private int state = 1;

    @Override // androidx.media3.extractor.Extractor
    public void release() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Extractor[] lambda$static$0() {
        return new Extractor[]{new FlvExtractor()};
    }

    @Override // androidx.media3.extractor.Extractor
    public boolean sniff(ExtractorInput extractorInput) throws IOException {
        extractorInput.peekFully(this.scratch.getData(), 0, 3);
        this.scratch.setPosition(0);
        if (this.scratch.readUnsignedInt24() != FLV_TAG) {
            return false;
        }
        extractorInput.peekFully(this.scratch.getData(), 0, 2);
        this.scratch.setPosition(0);
        if ((this.scratch.readUnsignedShort() & ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION) != 0) {
            return false;
        }
        extractorInput.peekFully(this.scratch.getData(), 0, 4);
        this.scratch.setPosition(0);
        int readInt = this.scratch.readInt();
        extractorInput.resetPeekPosition();
        extractorInput.advancePeekPosition(readInt);
        extractorInput.peekFully(this.scratch.getData(), 0, 4);
        this.scratch.setPosition(0);
        return this.scratch.readInt() == 0;
    }

    @Override // androidx.media3.extractor.Extractor
    public void init(ExtractorOutput extractorOutput) {
        this.extractorOutput = extractorOutput;
    }

    @Override // androidx.media3.extractor.Extractor
    public void seek(long j, long j2) {
        if (j == 0) {
            this.state = 1;
            this.outputFirstSample = false;
        } else {
            this.state = 3;
        }
        this.bytesToNextTagHeader = 0;
    }

    @Override // androidx.media3.extractor.Extractor
    public int read(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException {
        Assertions.checkStateNotNull(this.extractorOutput);
        while (true) {
            int i = this.state;
            if (i != 1) {
                if (i == 2) {
                    skipToTagHeader(extractorInput);
                } else if (i != 3) {
                    if (i == 4) {
                        if (readTagData(extractorInput)) {
                            return 0;
                        }
                    } else {
                        throw new IllegalStateException();
                    }
                } else if (!readTagHeader(extractorInput)) {
                    return -1;
                }
            } else if (!readFlvHeader(extractorInput)) {
                return -1;
            }
        }
    }

    @RequiresNonNull({"extractorOutput"})
    private boolean readFlvHeader(ExtractorInput extractorInput) throws IOException {
        if (!extractorInput.readFully(this.headerBuffer.getData(), 0, 9, true)) {
            return false;
        }
        this.headerBuffer.setPosition(0);
        this.headerBuffer.skipBytes(4);
        int readUnsignedByte = this.headerBuffer.readUnsignedByte();
        boolean z = (readUnsignedByte & 4) != 0;
        boolean z2 = (readUnsignedByte & 1) != 0;
        if (z && this.audioReader == null) {
            this.audioReader = new AudioTagPayloadReader(this.extractorOutput.track(8, 1));
        }
        if (z2 && this.videoReader == null) {
            this.videoReader = new VideoTagPayloadReader(this.extractorOutput.track(9, 2));
        }
        this.extractorOutput.endTracks();
        this.bytesToNextTagHeader = this.headerBuffer.readInt() - 5;
        this.state = 2;
        return true;
    }

    private void skipToTagHeader(ExtractorInput extractorInput) throws IOException {
        extractorInput.skipFully(this.bytesToNextTagHeader);
        this.bytesToNextTagHeader = 0;
        this.state = 3;
    }

    private boolean readTagHeader(ExtractorInput extractorInput) throws IOException {
        if (!extractorInput.readFully(this.tagHeaderBuffer.getData(), 0, 11, true)) {
            return false;
        }
        this.tagHeaderBuffer.setPosition(0);
        this.tagType = this.tagHeaderBuffer.readUnsignedByte();
        this.tagDataSize = this.tagHeaderBuffer.readUnsignedInt24();
        this.tagTimestampUs = this.tagHeaderBuffer.readUnsignedInt24();
        this.tagTimestampUs = ((this.tagHeaderBuffer.readUnsignedByte() << 24) | this.tagTimestampUs) * 1000;
        this.tagHeaderBuffer.skipBytes(3);
        this.state = 4;
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x008b  */
    @RequiresNonNull({"extractorOutput"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean readTagData(ExtractorInput extractorInput) throws IOException {
        boolean z;
        boolean z2;
        long currentTimestampUs = getCurrentTimestampUs();
        int i = this.tagType;
        if (i == 8 && this.audioReader != null) {
            ensureReadyForMediaOutput();
            z = this.audioReader.consume(prepareTagData(extractorInput), currentTimestampUs);
        } else if (i == 9 && this.videoReader != null) {
            ensureReadyForMediaOutput();
            z = this.videoReader.consume(prepareTagData(extractorInput), currentTimestampUs);
        } else if (i == 18 && !this.outputSeekMap) {
            z = this.metadataReader.consume(prepareTagData(extractorInput), currentTimestampUs);
            long durationUs = this.metadataReader.getDurationUs();
            if (durationUs != C.TIME_UNSET) {
                this.extractorOutput.seekMap(new IndexSeekMap(this.metadataReader.getKeyFrameTagPositions(), this.metadataReader.getKeyFrameTimesUs(), durationUs));
                this.outputSeekMap = true;
            }
        } else {
            extractorInput.skipFully(this.tagDataSize);
            z = false;
            z2 = false;
            if (!this.outputFirstSample && z) {
                this.outputFirstSample = true;
                this.mediaTagTimestampOffsetUs = this.metadataReader.getDurationUs() != C.TIME_UNSET ? -this.tagTimestampUs : 0L;
            }
            this.bytesToNextTagHeader = 4;
            this.state = 2;
            return z2;
        }
        z2 = true;
        if (!this.outputFirstSample) {
            this.outputFirstSample = true;
            this.mediaTagTimestampOffsetUs = this.metadataReader.getDurationUs() != C.TIME_UNSET ? -this.tagTimestampUs : 0L;
        }
        this.bytesToNextTagHeader = 4;
        this.state = 2;
        return z2;
    }

    private ParsableByteArray prepareTagData(ExtractorInput extractorInput) throws IOException {
        if (this.tagDataSize > this.tagData.capacity()) {
            ParsableByteArray parsableByteArray = this.tagData;
            parsableByteArray.reset(new byte[Math.max(parsableByteArray.capacity() * 2, this.tagDataSize)], 0);
        } else {
            this.tagData.setPosition(0);
        }
        this.tagData.setLimit(this.tagDataSize);
        extractorInput.readFully(this.tagData.getData(), 0, this.tagDataSize);
        return this.tagData;
    }

    @RequiresNonNull({"extractorOutput"})
    private void ensureReadyForMediaOutput() {
        if (this.outputSeekMap) {
            return;
        }
        this.extractorOutput.seekMap(new SeekMap.Unseekable(C.TIME_UNSET));
        this.outputSeekMap = true;
    }

    private long getCurrentTimestampUs() {
        if (this.outputFirstSample) {
            return this.mediaTagTimestampOffsetUs + this.tagTimestampUs;
        }
        if (this.metadataReader.getDurationUs() == C.TIME_UNSET) {
            return 0L;
        }
        return this.tagTimestampUs;
    }
}
