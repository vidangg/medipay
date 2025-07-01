package androidx.media3.extractor.mp4;

import android.util.Pair;
import androidx.media3.common.C;
import androidx.media3.common.ColorInfo;
import androidx.media3.common.DrmInitData;
import androidx.media3.common.Format;
import androidx.media3.common.Metadata;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.ParserException;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.CodecSpecificDataUtil;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.ParsableBitArray;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.Util;
import androidx.media3.container.MdtaMetadataEntry;
import androidx.media3.container.Mp4LocationData;
import androidx.media3.container.Mp4TimestampData;
import androidx.media3.exoplayer.Renderer;
import androidx.media3.extractor.AacUtil;
import androidx.media3.extractor.Ac3Util;
import androidx.media3.extractor.Ac4Util;
import androidx.media3.extractor.AvcConfig;
import androidx.media3.extractor.DolbyVisionConfig;
import androidx.media3.extractor.ExtractorUtil;
import androidx.media3.extractor.GaplessInfoHolder;
import androidx.media3.extractor.HevcConfig;
import androidx.media3.extractor.OpusUtil;
import androidx.media3.extractor.VorbisUtil;
import androidx.media3.extractor.mp4.Atom;
import androidx.media3.extractor.mp4.FixedSampleSizeRechunker;
import androidx.media3.extractor.ts.PsExtractor;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.primitives.Ints;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import kotlinx.coroutines.scheduling.WorkQueueKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class AtomParsers {
    private static final int MAX_GAPLESS_TRIM_SIZE_SAMPLES = 4;
    private static final String TAG = "AtomParsers";
    private static final int TYPE_clcp = 1668047728;
    private static final int TYPE_mdta = 1835299937;
    private static final int TYPE_meta = 1835365473;
    private static final int TYPE_nclc = 1852009571;
    private static final int TYPE_nclx = 1852009592;
    private static final int TYPE_sbtl = 1935832172;
    private static final int TYPE_soun = 1936684398;
    private static final int TYPE_subt = 1937072756;
    private static final int TYPE_text = 1952807028;
    private static final int TYPE_vide = 1986618469;
    private static final byte[] opusMagic = Util.getUtf8Bytes("OpusHead");

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public interface SampleSizeBox {
        int getFixedSampleSize();

        int getSampleCount();

        int readNextSampleSize();
    }

    private static boolean canTrimSamplesWithTimestampChange(int i) {
        return i != 1;
    }

    private static int getTrackTypeForHdlr(int i) {
        if (i == TYPE_soun) {
            return 1;
        }
        if (i == TYPE_vide) {
            return 2;
        }
        if (i == TYPE_text || i == TYPE_sbtl || i == TYPE_subt || i == TYPE_clcp) {
            return 3;
        }
        return i == 1835365473 ? 5 : -1;
    }

    public static List<TrackSampleTable> parseTraks(Atom.ContainerAtom containerAtom, GaplessInfoHolder gaplessInfoHolder, long j, DrmInitData drmInitData, boolean z, boolean z2, Function<Track, Track> function) throws ParserException {
        Track apply;
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < containerAtom.containerChildren.size(); i++) {
            Atom.ContainerAtom containerAtom2 = containerAtom.containerChildren.get(i);
            if (containerAtom2.type == 1953653099 && (apply = function.apply(parseTrak(containerAtom2, (Atom.LeafAtom) Assertions.checkNotNull(containerAtom.getLeafAtomOfType(Atom.TYPE_mvhd)), j, drmInitData, z, z2))) != null) {
                arrayList.add(parseStbl(apply, (Atom.ContainerAtom) Assertions.checkNotNull(((Atom.ContainerAtom) Assertions.checkNotNull(((Atom.ContainerAtom) Assertions.checkNotNull(containerAtom2.getContainerAtomOfType(Atom.TYPE_mdia))).getContainerAtomOfType(Atom.TYPE_minf))).getContainerAtomOfType(Atom.TYPE_stbl)), gaplessInfoHolder));
            }
        }
        return arrayList;
    }

    public static Metadata parseUdta(Atom.LeafAtom leafAtom) {
        ParsableByteArray parsableByteArray = leafAtom.data;
        parsableByteArray.setPosition(8);
        Metadata metadata = new Metadata(new Metadata.Entry[0]);
        while (parsableByteArray.bytesLeft() >= 8) {
            int position = parsableByteArray.getPosition();
            int readInt = parsableByteArray.readInt();
            int readInt2 = parsableByteArray.readInt();
            if (readInt2 == 1835365473) {
                parsableByteArray.setPosition(position);
                metadata = metadata.copyWithAppendedEntriesFrom(parseUdtaMeta(parsableByteArray, position + readInt));
            } else if (readInt2 == 1936553057) {
                parsableByteArray.setPosition(position);
                metadata = metadata.copyWithAppendedEntriesFrom(SmtaAtomUtil.parseSmta(parsableByteArray, position + readInt));
            } else if (readInt2 == -1451722374) {
                metadata = metadata.copyWithAppendedEntriesFrom(parseXyz(parsableByteArray));
            }
            parsableByteArray.setPosition(position + readInt);
        }
        return metadata;
    }

    public static Mp4TimestampData parseMvhd(ParsableByteArray parsableByteArray) {
        long readLong;
        long readLong2;
        parsableByteArray.setPosition(8);
        if (Atom.parseFullAtomVersion(parsableByteArray.readInt()) == 0) {
            readLong = parsableByteArray.readUnsignedInt();
            readLong2 = parsableByteArray.readUnsignedInt();
        } else {
            readLong = parsableByteArray.readLong();
            readLong2 = parsableByteArray.readLong();
        }
        return new Mp4TimestampData(readLong, readLong2, parsableByteArray.readUnsignedInt());
    }

    public static Metadata parseMdtaFromMeta(Atom.ContainerAtom containerAtom) {
        Atom.LeafAtom leafAtomOfType = containerAtom.getLeafAtomOfType(Atom.TYPE_hdlr);
        Atom.LeafAtom leafAtomOfType2 = containerAtom.getLeafAtomOfType(Atom.TYPE_keys);
        Atom.LeafAtom leafAtomOfType3 = containerAtom.getLeafAtomOfType(Atom.TYPE_ilst);
        if (leafAtomOfType == null || leafAtomOfType2 == null || leafAtomOfType3 == null || parseHdlr(leafAtomOfType.data) != TYPE_mdta) {
            return null;
        }
        ParsableByteArray parsableByteArray = leafAtomOfType2.data;
        parsableByteArray.setPosition(12);
        int readInt = parsableByteArray.readInt();
        String[] strArr = new String[readInt];
        for (int i = 0; i < readInt; i++) {
            int readInt2 = parsableByteArray.readInt();
            parsableByteArray.skipBytes(4);
            strArr[i] = parsableByteArray.readString(readInt2 - 8);
        }
        ParsableByteArray parsableByteArray2 = leafAtomOfType3.data;
        parsableByteArray2.setPosition(8);
        ArrayList arrayList = new ArrayList();
        while (parsableByteArray2.bytesLeft() > 8) {
            int position = parsableByteArray2.getPosition();
            int readInt3 = parsableByteArray2.readInt();
            int readInt4 = parsableByteArray2.readInt() - 1;
            if (readInt4 >= 0 && readInt4 < readInt) {
                MdtaMetadataEntry parseMdtaMetadataEntryFromIlst = MetadataUtil.parseMdtaMetadataEntryFromIlst(parsableByteArray2, position + readInt3, strArr[readInt4]);
                if (parseMdtaMetadataEntryFromIlst != null) {
                    arrayList.add(parseMdtaMetadataEntryFromIlst);
                }
            } else {
                Log.w(TAG, "Skipped metadata with unknown key index: " + readInt4);
            }
            parsableByteArray2.setPosition(position + readInt3);
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new Metadata(arrayList);
    }

    public static void maybeSkipRemainingMetaAtomHeaderBytes(ParsableByteArray parsableByteArray) {
        int position = parsableByteArray.getPosition();
        parsableByteArray.skipBytes(4);
        if (parsableByteArray.readInt() != 1751411826) {
            position += 4;
        }
        parsableByteArray.setPosition(position);
    }

    private static Track parseTrak(Atom.ContainerAtom containerAtom, Atom.LeafAtom leafAtom, long j, DrmInitData drmInitData, boolean z, boolean z2) throws ParserException {
        Atom.LeafAtom leafAtom2;
        long j2;
        long[] jArr;
        long[] jArr2;
        Atom.ContainerAtom containerAtomOfType;
        Pair<long[], long[]> parseEdts;
        Atom.ContainerAtom containerAtom2 = (Atom.ContainerAtom) Assertions.checkNotNull(containerAtom.getContainerAtomOfType(Atom.TYPE_mdia));
        int trackTypeForHdlr = getTrackTypeForHdlr(parseHdlr(((Atom.LeafAtom) Assertions.checkNotNull(containerAtom2.getLeafAtomOfType(Atom.TYPE_hdlr))).data));
        if (trackTypeForHdlr == -1) {
            return null;
        }
        TkhdData parseTkhd = parseTkhd(((Atom.LeafAtom) Assertions.checkNotNull(containerAtom.getLeafAtomOfType(Atom.TYPE_tkhd))).data);
        long j3 = C.TIME_UNSET;
        if (j == C.TIME_UNSET) {
            leafAtom2 = leafAtom;
            j2 = parseTkhd.duration;
        } else {
            leafAtom2 = leafAtom;
            j2 = j;
        }
        long j4 = parseMvhd(leafAtom2.data).timescale;
        if (j2 != C.TIME_UNSET) {
            j3 = Util.scaleLargeTimestamp(j2, 1000000L, j4);
        }
        long j5 = j3;
        Atom.ContainerAtom containerAtom3 = (Atom.ContainerAtom) Assertions.checkNotNull(((Atom.ContainerAtom) Assertions.checkNotNull(containerAtom2.getContainerAtomOfType(Atom.TYPE_minf))).getContainerAtomOfType(Atom.TYPE_stbl));
        Pair<Long, String> parseMdhd = parseMdhd(((Atom.LeafAtom) Assertions.checkNotNull(containerAtom2.getLeafAtomOfType(Atom.TYPE_mdhd))).data);
        Atom.LeafAtom leafAtomOfType = containerAtom3.getLeafAtomOfType(Atom.TYPE_stsd);
        if (leafAtomOfType == null) {
            throw ParserException.createForMalformedContainer("Malformed sample table (stbl) missing sample description (stsd)", null);
        }
        StsdData parseStsd = parseStsd(leafAtomOfType.data, parseTkhd.id, parseTkhd.rotationDegrees, (String) parseMdhd.second, drmInitData, z2);
        if (z || (containerAtomOfType = containerAtom.getContainerAtomOfType(Atom.TYPE_edts)) == null || (parseEdts = parseEdts(containerAtomOfType)) == null) {
            jArr = null;
            jArr2 = null;
        } else {
            long[] jArr3 = (long[]) parseEdts.first;
            jArr2 = (long[]) parseEdts.second;
            jArr = jArr3;
        }
        if (parseStsd.format == null) {
            return null;
        }
        return new Track(parseTkhd.id, trackTypeForHdlr, ((Long) parseMdhd.first).longValue(), j4, j5, parseStsd.format, parseStsd.requiredSampleTransformation, parseStsd.trackEncryptionBoxes, parseStsd.nalUnitLengthFieldLength, jArr, jArr2);
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0440  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0445  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x044c  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0452  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0458  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0468  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x045b  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0454  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x044f  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x0448  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x03b7  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x03b5  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x03d3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static TrackSampleTable parseStbl(Track track, Atom.ContainerAtom containerAtom, GaplessInfoHolder gaplessInfoHolder) throws ParserException {
        SampleSizeBox stz2SampleSizeBox;
        boolean z;
        int i;
        int i2;
        int i3;
        int i4;
        boolean z2;
        int i5;
        int i6;
        int i7;
        int i8;
        boolean z3;
        int i9;
        Track track2;
        int i10;
        long[] jArr;
        int[] iArr;
        int i11;
        long j;
        long[] jArr2;
        int[] iArr2;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        long[] jArr3;
        int[] iArr3;
        long j2;
        long[] jArr4;
        boolean z4;
        int i19;
        int i20;
        Atom.LeafAtom leafAtomOfType = containerAtom.getLeafAtomOfType(Atom.TYPE_stsz);
        if (leafAtomOfType != null) {
            stz2SampleSizeBox = new StszSampleSizeBox(leafAtomOfType, track.format);
        } else {
            Atom.LeafAtom leafAtomOfType2 = containerAtom.getLeafAtomOfType(Atom.TYPE_stz2);
            if (leafAtomOfType2 == null) {
                throw ParserException.createForMalformedContainer("Track has no sample table size information", null);
            }
            stz2SampleSizeBox = new Stz2SampleSizeBox(leafAtomOfType2);
        }
        int sampleCount = stz2SampleSizeBox.getSampleCount();
        if (sampleCount == 0) {
            return new TrackSampleTable(track, new long[0], new int[0], 0, new long[0], new int[0], 0L);
        }
        Atom.LeafAtom leafAtomOfType3 = containerAtom.getLeafAtomOfType(Atom.TYPE_stco);
        if (leafAtomOfType3 == null) {
            leafAtomOfType3 = (Atom.LeafAtom) Assertions.checkNotNull(containerAtom.getLeafAtomOfType(Atom.TYPE_co64));
            z = true;
        } else {
            z = false;
        }
        ParsableByteArray parsableByteArray = leafAtomOfType3.data;
        ParsableByteArray parsableByteArray2 = ((Atom.LeafAtom) Assertions.checkNotNull(containerAtom.getLeafAtomOfType(Atom.TYPE_stsc))).data;
        ParsableByteArray parsableByteArray3 = ((Atom.LeafAtom) Assertions.checkNotNull(containerAtom.getLeafAtomOfType(Atom.TYPE_stts))).data;
        Atom.LeafAtom leafAtomOfType4 = containerAtom.getLeafAtomOfType(Atom.TYPE_stss);
        ParsableByteArray parsableByteArray4 = leafAtomOfType4 != null ? leafAtomOfType4.data : null;
        Atom.LeafAtom leafAtomOfType5 = containerAtom.getLeafAtomOfType(Atom.TYPE_ctts);
        ParsableByteArray parsableByteArray5 = leafAtomOfType5 != null ? leafAtomOfType5.data : null;
        ChunkIterator chunkIterator = new ChunkIterator(parsableByteArray2, parsableByteArray, z);
        parsableByteArray3.setPosition(12);
        int readUnsignedIntToInt = parsableByteArray3.readUnsignedIntToInt() - 1;
        int readUnsignedIntToInt2 = parsableByteArray3.readUnsignedIntToInt();
        int readUnsignedIntToInt3 = parsableByteArray3.readUnsignedIntToInt();
        if (parsableByteArray5 != null) {
            parsableByteArray5.setPosition(12);
            i = parsableByteArray5.readUnsignedIntToInt();
        } else {
            i = 0;
        }
        if (parsableByteArray4 != null) {
            parsableByteArray4.setPosition(12);
            i3 = parsableByteArray4.readUnsignedIntToInt();
            if (i3 > 0) {
                i2 = parsableByteArray4.readUnsignedIntToInt() - 1;
            } else {
                i2 = -1;
                parsableByteArray4 = null;
            }
        } else {
            i2 = -1;
            i3 = 0;
        }
        int fixedSampleSize = stz2SampleSizeBox.getFixedSampleSize();
        String str = track.format.sampleMimeType;
        if (fixedSampleSize == -1 || !((MimeTypes.AUDIO_RAW.equals(str) || MimeTypes.AUDIO_MLAW.equals(str) || MimeTypes.AUDIO_ALAW.equals(str)) && readUnsignedIntToInt == 0 && i == 0 && i3 == 0)) {
            i4 = i3;
            z2 = false;
        } else {
            i4 = i3;
            z2 = true;
        }
        if (z2) {
            long[] jArr5 = new long[chunkIterator.length];
            int[] iArr4 = new int[chunkIterator.length];
            while (chunkIterator.moveNext()) {
                jArr5[chunkIterator.index] = chunkIterator.offset;
                iArr4[chunkIterator.index] = chunkIterator.numSamples;
            }
            FixedSampleSizeRechunker.Results rechunk = FixedSampleSizeRechunker.rechunk(fixedSampleSize, jArr5, iArr4, readUnsignedIntToInt3);
            long[] jArr6 = rechunk.offsets;
            int[] iArr5 = rechunk.sizes;
            int i21 = rechunk.maximumSize;
            long[] jArr7 = rechunk.timestamps;
            int[] iArr6 = rechunk.flags;
            long j3 = rechunk.duration;
            track2 = track;
            i10 = sampleCount;
            jArr = jArr6;
            iArr = iArr5;
            i11 = i21;
            iArr2 = iArr6;
            j = j3;
            jArr2 = jArr7;
        } else {
            long[] jArr8 = new long[sampleCount];
            int[] iArr7 = new int[sampleCount];
            long[] jArr9 = new long[sampleCount];
            int[] iArr8 = new int[sampleCount];
            int i22 = i2;
            int i23 = 0;
            int i24 = 0;
            int i25 = 0;
            int i26 = 0;
            int i27 = 0;
            long j4 = 0;
            long j5 = 0;
            int i28 = i;
            int i29 = readUnsignedIntToInt3;
            int i30 = readUnsignedIntToInt2;
            int i31 = readUnsignedIntToInt;
            int i32 = i4;
            while (true) {
                i5 = i31;
                if (i23 >= sampleCount) {
                    i6 = i30;
                    i7 = i25;
                    i8 = i26;
                    break;
                }
                long j6 = j5;
                int i33 = i26;
                boolean z5 = true;
                while (i33 == 0) {
                    z5 = chunkIterator.moveNext();
                    if (!z5) {
                        break;
                    }
                    int i34 = i30;
                    long j7 = chunkIterator.offset;
                    i33 = chunkIterator.numSamples;
                    j6 = j7;
                    i30 = i34;
                    i29 = i29;
                    sampleCount = sampleCount;
                }
                int i35 = sampleCount;
                i6 = i30;
                int i36 = i29;
                if (!z5) {
                    Log.w(TAG, "Unexpected end of chunk data");
                    jArr8 = Arrays.copyOf(jArr8, i23);
                    iArr7 = Arrays.copyOf(iArr7, i23);
                    jArr9 = Arrays.copyOf(jArr9, i23);
                    iArr8 = Arrays.copyOf(iArr8, i23);
                    sampleCount = i23;
                    i7 = i25;
                    i8 = i33;
                    break;
                }
                if (parsableByteArray5 != null) {
                    while (i27 == 0 && i28 > 0) {
                        i27 = parsableByteArray5.readUnsignedIntToInt();
                        i25 = parsableByteArray5.readInt();
                        i28--;
                    }
                    i27--;
                }
                int i37 = i25;
                jArr8[i23] = j6;
                int readNextSampleSize = stz2SampleSizeBox.readNextSampleSize();
                iArr7[i23] = readNextSampleSize;
                if (readNextSampleSize > i24) {
                    i24 = readNextSampleSize;
                }
                jArr9[i23] = j4 + i37;
                iArr8[i23] = parsableByteArray4 == null ? 1 : 0;
                if (i23 == i22) {
                    iArr8[i23] = 1;
                    i32--;
                    if (i32 > 0) {
                        i22 = ((ParsableByteArray) Assertions.checkNotNull(parsableByteArray4)).readUnsignedIntToInt() - 1;
                    }
                }
                int i38 = i22;
                j4 += i36;
                int i39 = i6 - 1;
                if (i39 != 0 || i5 <= 0) {
                    i12 = i36;
                    i13 = i5;
                } else {
                    i39 = parsableByteArray3.readUnsignedIntToInt();
                    i12 = parsableByteArray3.readInt();
                    i13 = i5 - 1;
                }
                int i40 = i39;
                long j8 = j6 + iArr7[i23];
                i26 = i33 - 1;
                i23++;
                j5 = j8;
                i22 = i38;
                i29 = i12;
                sampleCount = i35;
                i25 = i37;
                i31 = i13;
                i30 = i40;
            }
            long j9 = j4 + i7;
            if (parsableByteArray5 != null) {
                while (i28 > 0) {
                    if (parsableByteArray5.readUnsignedIntToInt() != 0) {
                        z3 = false;
                        break;
                    }
                    parsableByteArray5.readInt();
                    i28--;
                }
            }
            z3 = true;
            if (i32 == 0 && i6 == 0 && i8 == 0 && i5 == 0) {
                i9 = i27;
                if (i9 == 0 && z3) {
                    track2 = track;
                    i10 = sampleCount;
                    jArr = jArr8;
                    iArr = iArr7;
                    i11 = i24;
                    j = j9;
                    jArr2 = jArr9;
                    iArr2 = iArr8;
                }
            } else {
                i9 = i27;
            }
            StringBuilder sb = new StringBuilder("Inconsistent stbl box for track ");
            track2 = track;
            sb.append(track2.id);
            sb.append(": remainingSynchronizationSamples ");
            sb.append(i32);
            sb.append(", remainingSamplesAtTimestampDelta ");
            sb.append(i6);
            sb.append(", remainingSamplesInChunk ");
            sb.append(i8);
            sb.append(", remainingTimestampDeltaChanges ");
            sb.append(i5);
            sb.append(", remainingSamplesAtTimestampOffset ");
            sb.append(i9);
            sb.append(!z3 ? ", ctts invalid" : "");
            Log.w(TAG, sb.toString());
            i10 = sampleCount;
            jArr = jArr8;
            iArr = iArr7;
            i11 = i24;
            j = j9;
            jArr2 = jArr9;
            iArr2 = iArr8;
        }
        long scaleLargeTimestamp = Util.scaleLargeTimestamp(j, 1000000L, track2.timescale);
        if (track2.editListDurations == null) {
            Util.scaleLargeTimestampsInPlace(jArr2, 1000000L, track2.timescale);
            return new TrackSampleTable(track, jArr, iArr, i11, jArr2, iArr2, scaleLargeTimestamp);
        }
        if (track2.editListDurations.length == 1 && track2.type == 1 && jArr2.length >= 2) {
            long j10 = ((long[]) Assertions.checkNotNull(track2.editListMediaTimes))[0];
            long scaleLargeTimestamp2 = j10 + Util.scaleLargeTimestamp(track2.editListDurations[0], track2.timescale, track2.movieTimescale);
            i14 = i10;
            if (canApplyEditWithGaplessInfo(jArr2, j, j10, scaleLargeTimestamp2)) {
                long scaleLargeTimestamp3 = Util.scaleLargeTimestamp(j10 - jArr2[0], track2.format.sampleRate, track2.timescale);
                i15 = i11;
                long scaleLargeTimestamp4 = Util.scaleLargeTimestamp(j - scaleLargeTimestamp2, track2.format.sampleRate, track2.timescale);
                if ((scaleLargeTimestamp3 != 0 || scaleLargeTimestamp4 != 0) && scaleLargeTimestamp3 <= 2147483647L && scaleLargeTimestamp4 <= 2147483647L) {
                    gaplessInfoHolder.encoderDelay = (int) scaleLargeTimestamp3;
                    gaplessInfoHolder.encoderPadding = (int) scaleLargeTimestamp4;
                    Util.scaleLargeTimestampsInPlace(jArr2, 1000000L, track2.timescale);
                    return new TrackSampleTable(track, jArr, iArr, i15, jArr2, iArr2, Util.scaleLargeTimestamp(track2.editListDurations[0], 1000000L, track2.movieTimescale));
                }
                if (track2.editListDurations.length != 1 && track2.editListDurations[0] == 0) {
                    long j11 = ((long[]) Assertions.checkNotNull(track2.editListMediaTimes))[0];
                    for (int i41 = 0; i41 < jArr2.length; i41++) {
                        jArr2[i41] = Util.scaleLargeTimestamp(jArr2[i41] - j11, 1000000L, track2.timescale);
                    }
                    return new TrackSampleTable(track, jArr, iArr, i15, jArr2, iArr2, Util.scaleLargeTimestamp(j - j11, 1000000L, track2.timescale));
                }
                boolean z6 = track2.type != 1;
                int[] iArr9 = new int[track2.editListDurations.length];
                int[] iArr10 = new int[track2.editListDurations.length];
                long[] jArr10 = (long[]) Assertions.checkNotNull(track2.editListMediaTimes);
                i16 = 0;
                boolean z7 = false;
                int i42 = 0;
                int i43 = 0;
                while (i16 < track2.editListDurations.length) {
                    long[] jArr11 = jArr;
                    int[] iArr11 = iArr;
                    long j12 = jArr10[i16];
                    if (j12 != -1) {
                        int i44 = i43;
                        jArr4 = jArr11;
                        boolean z8 = z7;
                        int i45 = i42;
                        long scaleLargeTimestamp5 = Util.scaleLargeTimestamp(track2.editListDurations[i16], track2.timescale, track2.movieTimescale);
                        iArr9[i16] = Util.binarySearchFloor(jArr2, j12, true, true);
                        iArr10[i16] = Util.binarySearchCeil(jArr2, j12 + scaleLargeTimestamp5, z6, false);
                        while (true) {
                            i20 = iArr9[i16];
                            i19 = iArr10[i16];
                            if (i20 >= i19 || (iArr2[i20] & 1) != 0) {
                                break;
                            }
                            iArr9[i16] = i20 + 1;
                        }
                        i42 = i45 + (i19 - i20);
                        z4 = z8 | (i44 != i20);
                    } else {
                        jArr4 = jArr11;
                        z4 = z7;
                        i19 = i43;
                    }
                    i16++;
                    z7 = z4;
                    i43 = i19;
                    iArr = iArr11;
                    jArr = jArr4;
                }
                long[] jArr12 = jArr;
                int[] iArr12 = iArr;
                boolean z9 = z7;
                i17 = 0;
                boolean z10 = z9 | (i42 != i14);
                long[] jArr13 = !z10 ? new long[i42] : jArr12;
                int[] iArr13 = !z10 ? new int[i42] : iArr12;
                int i46 = !z10 ? 0 : i15;
                int[] iArr14 = !z10 ? new int[i42] : iArr2;
                long[] jArr14 = new long[i42];
                int i47 = i46;
                int i48 = 0;
                long j13 = 0;
                while (i17 < track2.editListDurations.length) {
                    long j14 = track2.editListMediaTimes[i17];
                    int i49 = iArr9[i17];
                    int[] iArr15 = iArr9;
                    int i50 = iArr10[i17];
                    int[] iArr16 = iArr10;
                    if (z10) {
                        int i51 = i50 - i49;
                        i18 = i17;
                        jArr3 = jArr12;
                        System.arraycopy(jArr3, i49, jArr13, i48, i51);
                        System.arraycopy(iArr12, i49, iArr13, i48, i51);
                        System.arraycopy(iArr2, i49, iArr14, i48, i51);
                    } else {
                        i18 = i17;
                        jArr3 = jArr12;
                    }
                    int i52 = i47;
                    while (i49 < i50) {
                        int i53 = i50;
                        int i54 = i52;
                        long scaleLargeTimestamp6 = Util.scaleLargeTimestamp(j13, 1000000L, track2.movieTimescale);
                        long[] jArr15 = jArr2;
                        int[] iArr17 = iArr2;
                        long scaleLargeTimestamp7 = Util.scaleLargeTimestamp(jArr2[i49] - j14, 1000000L, track2.timescale);
                        long[] jArr16 = jArr3;
                        if (canTrimSamplesWithTimestampChange(track2.type)) {
                            iArr3 = iArr14;
                            j2 = j13;
                            scaleLargeTimestamp7 = Math.max(0L, scaleLargeTimestamp7);
                        } else {
                            iArr3 = iArr14;
                            j2 = j13;
                        }
                        jArr14[i48] = scaleLargeTimestamp6 + scaleLargeTimestamp7;
                        if (z10) {
                            i52 = i54;
                            if (iArr13[i48] > i52) {
                                i52 = iArr12[i49];
                            }
                        } else {
                            i52 = i54;
                        }
                        i48++;
                        i49++;
                        i50 = i53;
                        iArr14 = iArr3;
                        jArr2 = jArr15;
                        iArr2 = iArr17;
                        jArr3 = jArr16;
                        j13 = j2;
                    }
                    i47 = i52;
                    iArr14 = iArr14;
                    j13 += track2.editListDurations[i18];
                    jArr2 = jArr2;
                    iArr2 = iArr2;
                    jArr12 = jArr3;
                    iArr10 = iArr16;
                    i17 = i18 + 1;
                    iArr9 = iArr15;
                }
                return new TrackSampleTable(track, jArr13, iArr13, i47, jArr14, iArr14, Util.scaleLargeTimestamp(j13, 1000000L, track2.movieTimescale));
            }
        } else {
            i14 = i10;
        }
        i15 = i11;
        if (track2.editListDurations.length != 1) {
        }
        if (track2.type != 1) {
        }
        int[] iArr92 = new int[track2.editListDurations.length];
        int[] iArr102 = new int[track2.editListDurations.length];
        long[] jArr102 = (long[]) Assertions.checkNotNull(track2.editListMediaTimes);
        i16 = 0;
        boolean z72 = false;
        int i422 = 0;
        int i432 = 0;
        while (i16 < track2.editListDurations.length) {
        }
        long[] jArr122 = jArr;
        int[] iArr122 = iArr;
        boolean z92 = z72;
        i17 = 0;
        boolean z102 = z92 | (i422 != i14);
        if (!z102) {
        }
        if (!z102) {
        }
        if (!z102) {
        }
        if (!z102) {
        }
        long[] jArr142 = new long[i422];
        int i472 = i46;
        int i482 = 0;
        long j132 = 0;
        while (i17 < track2.editListDurations.length) {
        }
        return new TrackSampleTable(track, jArr13, iArr13, i472, jArr142, iArr14, Util.scaleLargeTimestamp(j132, 1000000L, track2.movieTimescale));
    }

    private static Metadata parseUdtaMeta(ParsableByteArray parsableByteArray, int i) {
        parsableByteArray.skipBytes(8);
        maybeSkipRemainingMetaAtomHeaderBytes(parsableByteArray);
        while (parsableByteArray.getPosition() < i) {
            int position = parsableByteArray.getPosition();
            int readInt = parsableByteArray.readInt();
            if (parsableByteArray.readInt() == 1768715124) {
                parsableByteArray.setPosition(position);
                return parseIlst(parsableByteArray, position + readInt);
            }
            parsableByteArray.setPosition(position + readInt);
        }
        return null;
    }

    private static Metadata parseIlst(ParsableByteArray parsableByteArray, int i) {
        parsableByteArray.skipBytes(8);
        ArrayList arrayList = new ArrayList();
        while (parsableByteArray.getPosition() < i) {
            Metadata.Entry parseIlstElement = MetadataUtil.parseIlstElement(parsableByteArray);
            if (parseIlstElement != null) {
                arrayList.add(parseIlstElement);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new Metadata(arrayList);
    }

    private static Metadata parseXyz(ParsableByteArray parsableByteArray) {
        short readShort = parsableByteArray.readShort();
        parsableByteArray.skipBytes(2);
        String readString = parsableByteArray.readString(readShort);
        int max = Math.max(readString.lastIndexOf(43), readString.lastIndexOf(45));
        try {
            return new Metadata(new Mp4LocationData(Float.parseFloat(readString.substring(0, max)), Float.parseFloat(readString.substring(max, readString.length() - 1))));
        } catch (IndexOutOfBoundsException | NumberFormatException unused) {
            return null;
        }
    }

    private static TkhdData parseTkhd(ParsableByteArray parsableByteArray) {
        long j;
        parsableByteArray.setPosition(8);
        int parseFullAtomVersion = Atom.parseFullAtomVersion(parsableByteArray.readInt());
        parsableByteArray.skipBytes(parseFullAtomVersion == 0 ? 8 : 16);
        int readInt = parsableByteArray.readInt();
        parsableByteArray.skipBytes(4);
        int position = parsableByteArray.getPosition();
        int i = parseFullAtomVersion == 0 ? 4 : 8;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            j = C.TIME_UNSET;
            if (i3 < i) {
                if (parsableByteArray.getData()[position + i3] != -1) {
                    long readUnsignedInt = parseFullAtomVersion == 0 ? parsableByteArray.readUnsignedInt() : parsableByteArray.readUnsignedLongToLong();
                    if (readUnsignedInt != 0) {
                        j = readUnsignedInt;
                    }
                } else {
                    i3++;
                }
            } else {
                parsableByteArray.skipBytes(i);
                break;
            }
        }
        parsableByteArray.skipBytes(16);
        int readInt2 = parsableByteArray.readInt();
        int readInt3 = parsableByteArray.readInt();
        parsableByteArray.skipBytes(4);
        int readInt4 = parsableByteArray.readInt();
        int readInt5 = parsableByteArray.readInt();
        if (readInt2 == 0 && readInt3 == 65536 && readInt4 == -65536 && readInt5 == 0) {
            i2 = 90;
        } else if (readInt2 == 0 && readInt3 == -65536 && readInt4 == 65536 && readInt5 == 0) {
            i2 = 270;
        } else if (readInt2 == -65536 && readInt3 == 0 && readInt4 == 0 && readInt5 == -65536) {
            i2 = 180;
        }
        return new TkhdData(readInt, j, i2);
    }

    private static int parseHdlr(ParsableByteArray parsableByteArray) {
        parsableByteArray.setPosition(16);
        return parsableByteArray.readInt();
    }

    private static Pair<Long, String> parseMdhd(ParsableByteArray parsableByteArray) {
        parsableByteArray.setPosition(8);
        int parseFullAtomVersion = Atom.parseFullAtomVersion(parsableByteArray.readInt());
        parsableByteArray.skipBytes(parseFullAtomVersion == 0 ? 8 : 16);
        long readUnsignedInt = parsableByteArray.readUnsignedInt();
        parsableByteArray.skipBytes(parseFullAtomVersion == 0 ? 4 : 8);
        int readUnsignedShort = parsableByteArray.readUnsignedShort();
        return Pair.create(Long.valueOf(readUnsignedInt), "" + ((char) (((readUnsignedShort >> 10) & 31) + 96)) + ((char) (((readUnsignedShort >> 5) & 31) + 96)) + ((char) ((readUnsignedShort & 31) + 96)));
    }

    private static StsdData parseStsd(ParsableByteArray parsableByteArray, int i, int i2, String str, DrmInitData drmInitData, boolean z) throws ParserException {
        int i3;
        parsableByteArray.setPosition(12);
        int readInt = parsableByteArray.readInt();
        StsdData stsdData = new StsdData(readInt);
        for (int i4 = 0; i4 < readInt; i4++) {
            int position = parsableByteArray.getPosition();
            int readInt2 = parsableByteArray.readInt();
            ExtractorUtil.checkContainerInput(readInt2 > 0, "childAtomSize must be positive");
            int readInt3 = parsableByteArray.readInt();
            if (readInt3 == 1635148593 || readInt3 == 1635148595 || readInt3 == 1701733238 || readInt3 == 1831958048 || readInt3 == 1836070006 || readInt3 == 1752589105 || readInt3 == 1751479857 || readInt3 == 1932670515 || readInt3 == 1211250227 || readInt3 == 1987063864 || readInt3 == 1987063865 || readInt3 == 1635135537 || readInt3 == 1685479798 || readInt3 == 1685479729 || readInt3 == 1685481573 || readInt3 == 1685481521) {
                i3 = position;
                parseVideoSampleEntry(parsableByteArray, readInt3, i3, readInt2, i, i2, drmInitData, stsdData, i4);
            } else if (readInt3 == 1836069985 || readInt3 == 1701733217 || readInt3 == 1633889587 || readInt3 == 1700998451 || readInt3 == 1633889588 || readInt3 == 1835823201 || readInt3 == 1685353315 || readInt3 == 1685353317 || readInt3 == 1685353320 || readInt3 == 1685353324 || readInt3 == 1685353336 || readInt3 == 1935764850 || readInt3 == 1935767394 || readInt3 == 1819304813 || readInt3 == 1936684916 || readInt3 == 1953984371 || readInt3 == 778924082 || readInt3 == 778924083 || readInt3 == 1835557169 || readInt3 == 1835560241 || readInt3 == 1634492771 || readInt3 == 1634492791 || readInt3 == 1970037111 || readInt3 == 1332770163 || readInt3 == 1716281667) {
                i3 = position;
                parseAudioSampleEntry(parsableByteArray, readInt3, position, readInt2, i, str, z, drmInitData, stsdData, i4);
            } else {
                if (readInt3 == 1414810956 || readInt3 == 1954034535 || readInt3 == 2004251764 || readInt3 == 1937010800 || readInt3 == 1664495672) {
                    parseTextSampleEntry(parsableByteArray, readInt3, position, readInt2, i, str, stsdData);
                } else if (readInt3 == 1835365492) {
                    parseMetaDataSampleEntry(parsableByteArray, readInt3, position, i, stsdData);
                } else if (readInt3 == 1667329389) {
                    stsdData.format = new Format.Builder().setId(i).setSampleMimeType(MimeTypes.APPLICATION_CAMERA_MOTION).build();
                }
                i3 = position;
            }
            parsableByteArray.setPosition(i3 + readInt2);
        }
        return stsdData;
    }

    private static void parseTextSampleEntry(ParsableByteArray parsableByteArray, int i, int i2, int i3, int i4, String str, StsdData stsdData) {
        parsableByteArray.setPosition(i2 + 16);
        String str2 = MimeTypes.APPLICATION_TTML;
        ImmutableList immutableList = null;
        long j = Long.MAX_VALUE;
        if (i != 1414810956) {
            if (i == 1954034535) {
                int i5 = i3 - 16;
                byte[] bArr = new byte[i5];
                parsableByteArray.readBytes(bArr, 0, i5);
                immutableList = ImmutableList.of(bArr);
                str2 = MimeTypes.APPLICATION_TX3G;
            } else if (i == 2004251764) {
                str2 = MimeTypes.APPLICATION_MP4VTT;
            } else if (i == 1937010800) {
                j = 0;
            } else if (i == 1664495672) {
                stsdData.requiredSampleTransformation = 1;
                str2 = MimeTypes.APPLICATION_MP4CEA608;
            } else {
                throw new IllegalStateException();
            }
        }
        stsdData.format = new Format.Builder().setId(i4).setSampleMimeType(str2).setLanguage(str).setSubsampleOffsetUs(j).setInitializationData(immutableList).build();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static void parseVideoSampleEntry(ParsableByteArray parsableByteArray, int i, int i2, int i3, int i4, int i5, DrmInitData drmInitData, StsdData stsdData, int i6) throws ParserException {
        String str;
        DrmInitData drmInitData2;
        int i7;
        String str2;
        float f;
        int i8;
        int i9;
        int i10;
        int i11 = i2;
        int i12 = i3;
        DrmInitData drmInitData3 = drmInitData;
        StsdData stsdData2 = stsdData;
        parsableByteArray.setPosition(i11 + 16);
        parsableByteArray.skipBytes(16);
        int readUnsignedShort = parsableByteArray.readUnsignedShort();
        int readUnsignedShort2 = parsableByteArray.readUnsignedShort();
        parsableByteArray.skipBytes(50);
        int position = parsableByteArray.getPosition();
        int i13 = i;
        if (i13 == 1701733238) {
            Pair<Integer, TrackEncryptionBox> parseSampleEntryEncryptionData = parseSampleEntryEncryptionData(parsableByteArray, i11, i12);
            if (parseSampleEntryEncryptionData != null) {
                i13 = ((Integer) parseSampleEntryEncryptionData.first).intValue();
                drmInitData3 = drmInitData3 == null ? null : drmInitData3.copyWithSchemeType(((TrackEncryptionBox) parseSampleEntryEncryptionData.second).schemeType);
                stsdData2.trackEncryptionBoxes[i6] = (TrackEncryptionBox) parseSampleEntryEncryptionData.second;
            }
            parsableByteArray.setPosition(position);
        }
        String str3 = MimeTypes.VIDEO_H263;
        if (i13 != 1831958048) {
            str = i13 == 1211250227 ? MimeTypes.VIDEO_H263 : null;
        } else {
            str = MimeTypes.VIDEO_MPEG;
        }
        float f2 = 1.0f;
        int i14 = 8;
        int i15 = 8;
        List list = null;
        String str4 = null;
        byte[] bArr = null;
        int i16 = -1;
        int i17 = -1;
        int i18 = -1;
        int i19 = -1;
        int i20 = -1;
        ByteBuffer byteBuffer = null;
        EsdsData esdsData = null;
        boolean z = false;
        while (position - i11 < i12) {
            parsableByteArray.setPosition(position);
            int position2 = parsableByteArray.getPosition();
            int readInt = parsableByteArray.readInt();
            if (readInt == 0 && parsableByteArray.getPosition() - i11 == i12) {
                break;
            }
            ExtractorUtil.checkContainerInput(readInt > 0, "childAtomSize must be positive");
            int readInt2 = parsableByteArray.readInt();
            if (readInt2 == 1635148611) {
                ExtractorUtil.checkContainerInput(str == null, null);
                parsableByteArray.setPosition(position2 + 8);
                AvcConfig parse = AvcConfig.parse(parsableByteArray);
                List list2 = parse.initializationData;
                stsdData2.nalUnitLengthFieldLength = parse.nalUnitLengthFieldLength;
                if (!z) {
                    f2 = parse.pixelWidthHeightRatio;
                }
                String str5 = parse.codecs;
                int i21 = parse.maxNumReorderFrames;
                int i22 = parse.colorSpace;
                int i23 = parse.colorRange;
                int i24 = parse.colorTransfer;
                int i25 = parse.bitdepthLuma;
                drmInitData2 = drmInitData3;
                i7 = i13;
                str2 = str3;
                i17 = i21;
                i18 = i22;
                i19 = i23;
                i20 = i24;
                i15 = parse.bitdepthChroma;
                i14 = i25;
                list = list2;
                str = MimeTypes.VIDEO_H264;
                str4 = str5;
            } else if (readInt2 == 1752589123) {
                ExtractorUtil.checkContainerInput(str == null, null);
                parsableByteArray.setPosition(position2 + 8);
                HevcConfig parse2 = HevcConfig.parse(parsableByteArray);
                List list3 = parse2.initializationData;
                stsdData2.nalUnitLengthFieldLength = parse2.nalUnitLengthFieldLength;
                if (!z) {
                    f2 = parse2.pixelWidthHeightRatio;
                }
                int i26 = parse2.maxNumReorderPics;
                String str6 = parse2.codecs;
                int i27 = parse2.colorSpace;
                int i28 = parse2.colorRange;
                int i29 = parse2.colorTransfer;
                int i30 = parse2.bitdepthLuma;
                int i31 = parse2.bitdepthChroma;
                drmInitData2 = drmInitData3;
                i17 = i26;
                i7 = i13;
                str2 = str3;
                i18 = i27;
                i19 = i28;
                i20 = i29;
                str = MimeTypes.VIDEO_H265;
                i14 = i30;
                str4 = str6;
                list = list3;
                i15 = i31;
            } else {
                if (readInt2 == 1685480259 || readInt2 == 1685485123) {
                    drmInitData2 = drmInitData3;
                    i7 = i13;
                    str2 = str3;
                    f = f2;
                    i8 = i14;
                    i9 = i18;
                    i10 = i20;
                    DolbyVisionConfig parse3 = DolbyVisionConfig.parse(parsableByteArray);
                    if (parse3 != null) {
                        str4 = parse3.codecs;
                        str = MimeTypes.VIDEO_DOLBY_VISION;
                    }
                } else if (readInt2 == 1987076931) {
                    ExtractorUtil.checkContainerInput(str == null, null);
                    String str7 = i13 == 1987063864 ? MimeTypes.VIDEO_VP8 : MimeTypes.VIDEO_VP9;
                    parsableByteArray.setPosition(position2 + 12);
                    parsableByteArray.skipBytes(2);
                    int readUnsignedByte = parsableByteArray.readUnsignedByte();
                    int i32 = readUnsignedByte >> 4;
                    boolean z2 = (readUnsignedByte & 1) != 0;
                    int readUnsignedByte2 = parsableByteArray.readUnsignedByte();
                    int readUnsignedByte3 = parsableByteArray.readUnsignedByte();
                    i18 = ColorInfo.isoColorPrimariesToColorSpace(readUnsignedByte2);
                    i19 = z2 ? 1 : 2;
                    i20 = ColorInfo.isoTransferCharacteristicsToColorTransfer(readUnsignedByte3);
                    drmInitData2 = drmInitData3;
                    i14 = i32;
                    i15 = i14;
                    i7 = i13;
                    str2 = str3;
                    str = str7;
                } else if (readInt2 == 1635135811) {
                    int i33 = readInt - 8;
                    byte[] bArr2 = new byte[i33];
                    parsableByteArray.readBytes(bArr2, 0, i33);
                    list = ImmutableList.of(bArr2);
                    parsableByteArray.setPosition(position2 + 8);
                    ColorInfo parseAv1c = parseAv1c(parsableByteArray);
                    int i34 = parseAv1c.lumaBitdepth;
                    int i35 = parseAv1c.chromaBitdepth;
                    int i36 = parseAv1c.colorSpace;
                    int i37 = parseAv1c.colorRange;
                    i20 = parseAv1c.colorTransfer;
                    drmInitData2 = drmInitData3;
                    i7 = i13;
                    str2 = str3;
                    i18 = i36;
                    i19 = i37;
                    str = MimeTypes.VIDEO_AV1;
                    i14 = i34;
                    i15 = i35;
                } else if (readInt2 == 1668050025) {
                    if (byteBuffer == null) {
                        byteBuffer = allocateHdrStaticInfo();
                    }
                    ByteBuffer byteBuffer2 = byteBuffer;
                    byteBuffer2.position(21);
                    byteBuffer2.putShort(parsableByteArray.readShort());
                    byteBuffer2.putShort(parsableByteArray.readShort());
                    byteBuffer = byteBuffer2;
                    drmInitData2 = drmInitData3;
                    i7 = i13;
                    str2 = str3;
                } else if (readInt2 == 1835295606) {
                    if (byteBuffer == null) {
                        byteBuffer = allocateHdrStaticInfo();
                    }
                    ByteBuffer byteBuffer3 = byteBuffer;
                    short readShort = parsableByteArray.readShort();
                    short readShort2 = parsableByteArray.readShort();
                    short readShort3 = parsableByteArray.readShort();
                    i7 = i13;
                    short readShort4 = parsableByteArray.readShort();
                    str2 = str3;
                    short readShort5 = parsableByteArray.readShort();
                    short readShort6 = parsableByteArray.readShort();
                    int i38 = i14;
                    short readShort7 = parsableByteArray.readShort();
                    drmInitData2 = drmInitData3;
                    short readShort8 = parsableByteArray.readShort();
                    long readUnsignedInt = parsableByteArray.readUnsignedInt();
                    long readUnsignedInt2 = parsableByteArray.readUnsignedInt();
                    byteBuffer3.position(1);
                    byteBuffer3.putShort(readShort5);
                    byteBuffer3.putShort(readShort6);
                    byteBuffer3.putShort(readShort);
                    byteBuffer3.putShort(readShort2);
                    byteBuffer3.putShort(readShort3);
                    byteBuffer3.putShort(readShort4);
                    byteBuffer3.putShort(readShort7);
                    byteBuffer3.putShort(readShort8);
                    byteBuffer3.putShort((short) (readUnsignedInt / Renderer.DEFAULT_DURATION_TO_PROGRESS_US));
                    byteBuffer3.putShort((short) (readUnsignedInt2 / Renderer.DEFAULT_DURATION_TO_PROGRESS_US));
                    byteBuffer = byteBuffer3;
                    i14 = i38;
                    f2 = f2;
                } else {
                    drmInitData2 = drmInitData3;
                    i7 = i13;
                    str2 = str3;
                    f = f2;
                    i8 = i14;
                    if (readInt2 == 1681012275) {
                        ExtractorUtil.checkContainerInput(str == null, null);
                        str = str2;
                    } else if (readInt2 == 1702061171) {
                        ExtractorUtil.checkContainerInput(str == null, null);
                        esdsData = parseEsdsFromParent(parsableByteArray, position2);
                        String str8 = esdsData.mimeType;
                        byte[] bArr3 = esdsData.initializationData;
                        if (bArr3 != null) {
                            list = ImmutableList.of(bArr3);
                        }
                        str = str8;
                    } else if (readInt2 == 1885434736) {
                        f2 = parsePaspFromParent(parsableByteArray, position2);
                        i14 = i8;
                        z = true;
                    } else if (readInt2 == 1937126244) {
                        bArr = parseProjFromParent(parsableByteArray, position2, readInt);
                    } else if (readInt2 == 1936995172) {
                        int readUnsignedByte4 = parsableByteArray.readUnsignedByte();
                        parsableByteArray.skipBytes(3);
                        if (readUnsignedByte4 == 0) {
                            int readUnsignedByte5 = parsableByteArray.readUnsignedByte();
                            if (readUnsignedByte5 == 0) {
                                i16 = 0;
                            } else if (readUnsignedByte5 == 1) {
                                i16 = 1;
                            } else if (readUnsignedByte5 == 2) {
                                i16 = 2;
                            } else if (readUnsignedByte5 == 3) {
                                i16 = 3;
                            }
                        }
                    } else if (readInt2 == 1668246642) {
                        i9 = i18;
                        i10 = i20;
                        if (i9 == -1 && i10 == -1) {
                            int readInt3 = parsableByteArray.readInt();
                            if (readInt3 == TYPE_nclx || readInt3 == TYPE_nclc) {
                                int readUnsignedShort3 = parsableByteArray.readUnsignedShort();
                                int readUnsignedShort4 = parsableByteArray.readUnsignedShort();
                                parsableByteArray.skipBytes(2);
                                boolean z3 = readInt == 19 && (parsableByteArray.readUnsignedByte() & 128) != 0;
                                i18 = ColorInfo.isoColorPrimariesToColorSpace(readUnsignedShort3);
                                i19 = z3 ? 1 : 2;
                                i20 = ColorInfo.isoTransferCharacteristicsToColorTransfer(readUnsignedShort4);
                                i14 = i8;
                                f2 = f;
                            } else {
                                Log.w(TAG, "Unsupported color type: " + Atom.getAtomTypeString(readInt3));
                            }
                        }
                    } else {
                        i9 = i18;
                        i10 = i20;
                    }
                    i14 = i8;
                    f2 = f;
                }
                i18 = i9;
                i20 = i10;
                i14 = i8;
                f2 = f;
            }
            position += readInt;
            i11 = i2;
            i12 = i3;
            stsdData2 = stsdData;
            i13 = i7;
            str3 = str2;
            drmInitData3 = drmInitData2;
        }
        DrmInitData drmInitData4 = drmInitData3;
        float f3 = f2;
        int i39 = i14;
        int i40 = i18;
        int i41 = i20;
        if (str == null) {
            return;
        }
        Format.Builder colorInfo = new Format.Builder().setId(i4).setSampleMimeType(str).setCodecs(str4).setWidth(readUnsignedShort).setHeight(readUnsignedShort2).setPixelWidthHeightRatio(f3).setRotationDegrees(i5).setProjectionData(bArr).setStereoMode(i16).setInitializationData(list).setMaxNumReorderSamples(i17).setDrmInitData(drmInitData4).setColorInfo(new ColorInfo.Builder().setColorSpace(i40).setColorRange(i19).setColorTransfer(i41).setHdrStaticInfo(byteBuffer != null ? byteBuffer.array() : null).setLumaBitdepth(i39).setChromaBitdepth(i15).build());
        if (esdsData != null) {
            colorInfo.setAverageBitrate(Ints.saturatedCast(esdsData.bitrate)).setPeakBitrate(Ints.saturatedCast(esdsData.peakBitrate));
        }
        stsdData.format = colorInfo.build();
    }

    private static ColorInfo parseAv1c(ParsableByteArray parsableByteArray) {
        ColorInfo.Builder builder = new ColorInfo.Builder();
        ParsableBitArray parsableBitArray = new ParsableBitArray(parsableByteArray.getData());
        parsableBitArray.setPosition(parsableByteArray.getPosition() * 8);
        parsableBitArray.skipBytes(1);
        int readBits = parsableBitArray.readBits(3);
        parsableBitArray.skipBits(6);
        boolean readBit = parsableBitArray.readBit();
        boolean readBit2 = parsableBitArray.readBit();
        if (readBits == 2 && readBit) {
            builder.setLumaBitdepth(readBit2 ? 12 : 10);
            builder.setChromaBitdepth(readBit2 ? 12 : 10);
        } else if (readBits <= 2) {
            builder.setLumaBitdepth(readBit ? 10 : 8);
            builder.setChromaBitdepth(readBit ? 10 : 8);
        }
        parsableBitArray.skipBits(13);
        parsableBitArray.skipBit();
        int readBits2 = parsableBitArray.readBits(4);
        if (readBits2 != 1) {
            Log.i(TAG, "Unsupported obu_type: " + readBits2);
            return builder.build();
        }
        if (parsableBitArray.readBit()) {
            Log.i(TAG, "Unsupported obu_extension_flag");
            return builder.build();
        }
        boolean readBit3 = parsableBitArray.readBit();
        parsableBitArray.skipBit();
        if (readBit3 && parsableBitArray.readBits(8) > 127) {
            Log.i(TAG, "Excessive obu_size");
            return builder.build();
        }
        int readBits3 = parsableBitArray.readBits(3);
        parsableBitArray.skipBit();
        if (parsableBitArray.readBit()) {
            Log.i(TAG, "Unsupported reduced_still_picture_header");
            return builder.build();
        }
        if (parsableBitArray.readBit()) {
            Log.i(TAG, "Unsupported timing_info_present_flag");
            return builder.build();
        }
        if (parsableBitArray.readBit()) {
            Log.i(TAG, "Unsupported initial_display_delay_present_flag");
            return builder.build();
        }
        int readBits4 = parsableBitArray.readBits(5);
        boolean z = false;
        for (int i = 0; i <= readBits4; i++) {
            parsableBitArray.skipBits(12);
            if (parsableBitArray.readBits(5) > 7) {
                parsableBitArray.skipBit();
            }
        }
        int readBits5 = parsableBitArray.readBits(4);
        int readBits6 = parsableBitArray.readBits(4);
        parsableBitArray.skipBits(readBits5 + 1);
        parsableBitArray.skipBits(readBits6 + 1);
        if (parsableBitArray.readBit()) {
            parsableBitArray.skipBits(7);
        }
        parsableBitArray.skipBits(7);
        boolean readBit4 = parsableBitArray.readBit();
        if (readBit4) {
            parsableBitArray.skipBits(2);
        }
        if ((parsableBitArray.readBit() ? 2 : parsableBitArray.readBits(1)) > 0 && !parsableBitArray.readBit()) {
            parsableBitArray.skipBits(1);
        }
        if (readBit4) {
            parsableBitArray.skipBits(3);
        }
        parsableBitArray.skipBits(3);
        boolean readBit5 = parsableBitArray.readBit();
        if (readBits3 == 2 && readBit5) {
            parsableBitArray.skipBit();
        }
        if (readBits3 != 1 && parsableBitArray.readBit()) {
            z = true;
        }
        if (parsableBitArray.readBit()) {
            int readBits7 = parsableBitArray.readBits(8);
            int readBits8 = parsableBitArray.readBits(8);
            builder.setColorSpace(ColorInfo.isoColorPrimariesToColorSpace(readBits7)).setColorRange(((z || readBits7 != 1 || readBits8 != 13 || parsableBitArray.readBits(8) != 0) ? parsableBitArray.readBits(1) : 1) != 1 ? 2 : 1).setColorTransfer(ColorInfo.isoTransferCharacteristicsToColorTransfer(readBits8));
        }
        return builder.build();
    }

    private static ByteBuffer allocateHdrStaticInfo() {
        return ByteBuffer.allocate(25).order(ByteOrder.LITTLE_ENDIAN);
    }

    private static void parseMetaDataSampleEntry(ParsableByteArray parsableByteArray, int i, int i2, int i3, StsdData stsdData) {
        parsableByteArray.setPosition(i2 + 16);
        if (i == 1835365492) {
            parsableByteArray.readNullTerminatedString();
            String readNullTerminatedString = parsableByteArray.readNullTerminatedString();
            if (readNullTerminatedString != null) {
                stsdData.format = new Format.Builder().setId(i3).setSampleMimeType(readNullTerminatedString).build();
            }
        }
    }

    private static Pair<long[], long[]> parseEdts(Atom.ContainerAtom containerAtom) {
        Atom.LeafAtom leafAtomOfType = containerAtom.getLeafAtomOfType(Atom.TYPE_elst);
        if (leafAtomOfType == null) {
            return null;
        }
        ParsableByteArray parsableByteArray = leafAtomOfType.data;
        parsableByteArray.setPosition(8);
        int parseFullAtomVersion = Atom.parseFullAtomVersion(parsableByteArray.readInt());
        int readUnsignedIntToInt = parsableByteArray.readUnsignedIntToInt();
        long[] jArr = new long[readUnsignedIntToInt];
        long[] jArr2 = new long[readUnsignedIntToInt];
        for (int i = 0; i < readUnsignedIntToInt; i++) {
            jArr[i] = parseFullAtomVersion == 1 ? parsableByteArray.readUnsignedLongToLong() : parsableByteArray.readUnsignedInt();
            jArr2[i] = parseFullAtomVersion == 1 ? parsableByteArray.readLong() : parsableByteArray.readInt();
            if (parsableByteArray.readShort() != 1) {
                throw new IllegalArgumentException("Unsupported media rate.");
            }
            parsableByteArray.skipBytes(2);
        }
        return Pair.create(jArr, jArr2);
    }

    private static float parsePaspFromParent(ParsableByteArray parsableByteArray, int i) {
        parsableByteArray.setPosition(i + 8);
        return parsableByteArray.readUnsignedIntToInt() / parsableByteArray.readUnsignedIntToInt();
    }

    /* JADX WARN: Code restructure failed: missing block: B:170:0x014a, code lost:
    
        if (r10 == (-1)) goto L88;
     */
    /* JADX WARN: Removed duplicated region for block: B:129:0x040a A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:136:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x01b7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void parseAudioSampleEntry(ParsableByteArray parsableByteArray, int i, int i2, int i3, int i4, String str, boolean z, DrmInitData drmInitData, StsdData stsdData, int i5) throws ParserException {
        int i6;
        int readUnsignedShort;
        int readUnsignedFixedPoint1616;
        int readInt;
        int i7;
        String str2;
        String str3;
        int i8;
        String str4;
        char c;
        String format;
        ImmutableList of;
        int i9 = i2;
        int i10 = i3;
        DrmInitData drmInitData2 = drmInitData;
        parsableByteArray.setPosition(i9 + 16);
        if (z) {
            i6 = parsableByteArray.readUnsignedShort();
            parsableByteArray.skipBytes(6);
        } else {
            parsableByteArray.skipBytes(8);
            i6 = 0;
        }
        if (i6 == 0 || i6 == 1) {
            readUnsignedShort = parsableByteArray.readUnsignedShort();
            parsableByteArray.skipBytes(6);
            readUnsignedFixedPoint1616 = parsableByteArray.readUnsignedFixedPoint1616();
            parsableByteArray.setPosition(parsableByteArray.getPosition() - 4);
            readInt = parsableByteArray.readInt();
            if (i6 == 1) {
                parsableByteArray.skipBytes(16);
            }
            i7 = -1;
        } else {
            if (i6 != 2) {
                return;
            }
            parsableByteArray.skipBytes(16);
            readUnsignedFixedPoint1616 = (int) Math.round(parsableByteArray.readDouble());
            readUnsignedShort = parsableByteArray.readUnsignedIntToInt();
            parsableByteArray.skipBytes(4);
            int readUnsignedIntToInt = parsableByteArray.readUnsignedIntToInt();
            int readUnsignedIntToInt2 = parsableByteArray.readUnsignedIntToInt();
            boolean z2 = (readUnsignedIntToInt2 & 1) != 0;
            boolean z3 = (readUnsignedIntToInt2 & 2) != 0;
            if (!z2) {
                if (readUnsignedIntToInt == 8) {
                    i7 = 3;
                } else if (readUnsignedIntToInt == 16) {
                    i7 = z3 ? 268435456 : 2;
                } else if (readUnsignedIntToInt == 24) {
                    i7 = z3 ? C.ENCODING_PCM_24BIT_BIG_ENDIAN : 21;
                } else {
                    if (readUnsignedIntToInt == 32) {
                        i7 = z3 ? C.ENCODING_PCM_32BIT_BIG_ENDIAN : 22;
                    }
                    i7 = -1;
                }
                parsableByteArray.skipBytes(8);
                readInt = 0;
            } else {
                if (readUnsignedIntToInt == 32) {
                    i7 = 4;
                    parsableByteArray.skipBytes(8);
                    readInt = 0;
                }
                i7 = -1;
                parsableByteArray.skipBytes(8);
                readInt = 0;
            }
        }
        int position = parsableByteArray.getPosition();
        int i11 = i;
        if (i11 == 1701733217) {
            Pair<Integer, TrackEncryptionBox> parseSampleEntryEncryptionData = parseSampleEntryEncryptionData(parsableByteArray, i9, i10);
            if (parseSampleEntryEncryptionData != null) {
                i11 = ((Integer) parseSampleEntryEncryptionData.first).intValue();
                drmInitData2 = drmInitData2 == null ? null : drmInitData2.copyWithSchemeType(((TrackEncryptionBox) parseSampleEntryEncryptionData.second).schemeType);
                stsdData.trackEncryptionBoxes[i5] = (TrackEncryptionBox) parseSampleEntryEncryptionData.second;
            }
            parsableByteArray.setPosition(position);
        }
        String str5 = MimeTypes.AUDIO_MPEGH_MHM1;
        if (i11 == 1633889587) {
            str2 = MimeTypes.AUDIO_AC3;
        } else if (i11 == 1700998451) {
            str2 = MimeTypes.AUDIO_E_AC3;
        } else if (i11 == 1633889588) {
            str2 = MimeTypes.AUDIO_AC4;
        } else if (i11 == 1685353315) {
            str2 = MimeTypes.AUDIO_DTS;
        } else if (i11 == 1685353320 || i11 == 1685353324) {
            str2 = MimeTypes.AUDIO_DTS_HD;
        } else if (i11 == 1685353317) {
            str2 = MimeTypes.AUDIO_DTS_EXPRESS;
        } else if (i11 == 1685353336) {
            str2 = MimeTypes.AUDIO_DTS_X;
        } else if (i11 == 1935764850) {
            str2 = MimeTypes.AUDIO_AMR_NB;
        } else if (i11 == 1935767394) {
            str2 = MimeTypes.AUDIO_AMR_WB;
        } else {
            str3 = MimeTypes.AUDIO_RAW;
            if (i11 != 1936684916) {
                if (i11 == 1953984371) {
                    i8 = 268435456;
                } else if (i11 != 1819304813) {
                    if (i11 == 778924082 || i11 == 778924083) {
                        str2 = MimeTypes.AUDIO_MPEG;
                    } else if (i11 == 1835557169) {
                        str2 = MimeTypes.AUDIO_MPEGH_MHA1;
                    } else if (i11 == 1835560241) {
                        i8 = i7;
                        str3 = MimeTypes.AUDIO_MPEGH_MHM1;
                    } else if (i11 == 1634492771) {
                        str2 = MimeTypes.AUDIO_ALAC;
                    } else if (i11 == 1634492791) {
                        str2 = MimeTypes.AUDIO_ALAW;
                    } else if (i11 == 1970037111) {
                        str2 = MimeTypes.AUDIO_MLAW;
                    } else if (i11 == 1332770163) {
                        str2 = MimeTypes.AUDIO_OPUS;
                    } else if (i11 == 1716281667) {
                        str2 = MimeTypes.AUDIO_FLAC;
                    } else if (i11 == 1835823201) {
                        str2 = MimeTypes.AUDIO_TRUEHD;
                    } else {
                        i8 = i7;
                        str3 = null;
                    }
                }
                int i12 = i8;
                String str6 = str3;
                List<byte[]> list = null;
                String str7 = null;
                EsdsData esdsData = null;
                while (position - i9 < i10) {
                    parsableByteArray.setPosition(position);
                    int readInt2 = parsableByteArray.readInt();
                    ExtractorUtil.checkContainerInput(readInt2 > 0, "childAtomSize must be positive");
                    int readInt3 = parsableByteArray.readInt();
                    if (readInt3 == 1835557187) {
                        parsableByteArray.setPosition(position + 8);
                        parsableByteArray.skipBytes(1);
                        int readUnsignedByte = parsableByteArray.readUnsignedByte();
                        parsableByteArray.skipBytes(1);
                        if (Objects.equals(str6, str5)) {
                            format = String.format("mhm1.%02X", Integer.valueOf(readUnsignedByte));
                        } else {
                            format = String.format("mha1.%02X", Integer.valueOf(readUnsignedByte));
                        }
                        String str8 = format;
                        int readUnsignedShort2 = parsableByteArray.readUnsignedShort();
                        byte[] bArr = new byte[readUnsignedShort2];
                        parsableByteArray.readBytes(bArr, 0, readUnsignedShort2);
                        if (list == null) {
                            of = ImmutableList.of(bArr);
                        } else {
                            of = ImmutableList.of(bArr, list.get(0));
                        }
                        list = of;
                        str7 = str8;
                    } else {
                        if (readInt3 == 1835557200) {
                            parsableByteArray.setPosition(position + 8);
                            int readUnsignedByte2 = parsableByteArray.readUnsignedByte();
                            if (readUnsignedByte2 > 0) {
                                byte[] bArr2 = new byte[readUnsignedByte2];
                                str4 = str5;
                                parsableByteArray.readBytes(bArr2, 0, readUnsignedByte2);
                                if (list == null) {
                                    list = ImmutableList.of(bArr2);
                                } else {
                                    list = ImmutableList.of(list.get(0), bArr2);
                                }
                            }
                        } else {
                            str4 = str5;
                            if (readInt3 == 1702061171 || (z && readInt3 == 2002876005)) {
                                int findBoxPosition = readInt3 == 1702061171 ? position : findBoxPosition(parsableByteArray, Atom.TYPE_esds, position, readInt2);
                                if (findBoxPosition != -1) {
                                    esdsData = parseEsdsFromParent(parsableByteArray, findBoxPosition);
                                    str6 = esdsData.mimeType;
                                    byte[] bArr3 = esdsData.initializationData;
                                    if (bArr3 != null) {
                                        if (MimeTypes.AUDIO_VORBIS.equals(str6)) {
                                            list = VorbisUtil.parseVorbisCsdFromEsdsInitializationData(bArr3);
                                        } else {
                                            if (MimeTypes.AUDIO_AAC.equals(str6)) {
                                                AacUtil.Config parseAudioSpecificConfig = AacUtil.parseAudioSpecificConfig(bArr3);
                                                int i13 = parseAudioSpecificConfig.sampleRateHz;
                                                int i14 = parseAudioSpecificConfig.channelCount;
                                                str7 = parseAudioSpecificConfig.codecs;
                                                readUnsignedFixedPoint1616 = i13;
                                                readUnsignedShort = i14;
                                            }
                                            list = ImmutableList.of(bArr3);
                                        }
                                    }
                                }
                            } else {
                                if (readInt3 == 1684103987) {
                                    parsableByteArray.setPosition(position + 8);
                                    stsdData.format = Ac3Util.parseAc3AnnexFFormat(parsableByteArray, Integer.toString(i4), str, drmInitData2);
                                } else if (readInt3 == 1684366131) {
                                    parsableByteArray.setPosition(position + 8);
                                    stsdData.format = Ac3Util.parseEAc3AnnexFFormat(parsableByteArray, Integer.toString(i4), str, drmInitData2);
                                } else if (readInt3 == 1684103988) {
                                    parsableByteArray.setPosition(position + 8);
                                    stsdData.format = Ac4Util.parseAc4AnnexEFormat(parsableByteArray, Integer.toString(i4), str, drmInitData2);
                                } else if (readInt3 == 1684892784) {
                                    if (readInt <= 0) {
                                        throw ParserException.createForMalformedContainer("Invalid sample rate for Dolby TrueHD MLP stream: " + readInt, null);
                                    }
                                    readUnsignedFixedPoint1616 = readInt;
                                    readUnsignedShort = 2;
                                } else if (readInt3 == 1684305011 || readInt3 == 1969517683) {
                                    c = 24931;
                                    stsdData.format = new Format.Builder().setId(i4).setSampleMimeType(str6).setChannelCount(readUnsignedShort).setSampleRate(readUnsignedFixedPoint1616).setDrmInitData(drmInitData2).setLanguage(str).build();
                                } else if (readInt3 == 1682927731) {
                                    int i15 = readInt2 - 8;
                                    byte[] bArr4 = opusMagic;
                                    byte[] copyOf = Arrays.copyOf(bArr4, bArr4.length + i15);
                                    parsableByteArray.setPosition(position + 8);
                                    parsableByteArray.readBytes(copyOf, bArr4.length, i15);
                                    list = OpusUtil.buildInitializationData(copyOf);
                                } else if (readInt3 == 1684425825) {
                                    byte[] bArr5 = new byte[readInt2 - 8];
                                    bArr5[0] = 102;
                                    bArr5[1] = 76;
                                    bArr5[2] = 97;
                                    bArr5[3] = 67;
                                    parsableByteArray.setPosition(position + 12);
                                    parsableByteArray.readBytes(bArr5, 4, readInt2 - 12);
                                    list = ImmutableList.of(bArr5);
                                } else {
                                    c = 24931;
                                    if (readInt3 == 1634492771) {
                                        int i16 = readInt2 - 12;
                                        byte[] bArr6 = new byte[i16];
                                        parsableByteArray.setPosition(position + 12);
                                        parsableByteArray.readBytes(bArr6, 0, i16);
                                        Pair<Integer, Integer> parseAlacAudioSpecificConfig = CodecSpecificDataUtil.parseAlacAudioSpecificConfig(bArr6);
                                        int intValue = ((Integer) parseAlacAudioSpecificConfig.first).intValue();
                                        readUnsignedShort = ((Integer) parseAlacAudioSpecificConfig.second).intValue();
                                        list = ImmutableList.of(bArr6);
                                        readUnsignedFixedPoint1616 = intValue;
                                    }
                                }
                                c = 24931;
                            }
                            position += readInt2;
                            i9 = i2;
                            i10 = i3;
                            str5 = str4;
                        }
                        position += readInt2;
                        i9 = i2;
                        i10 = i3;
                        str5 = str4;
                    }
                    str4 = str5;
                    position += readInt2;
                    i9 = i2;
                    i10 = i3;
                    str5 = str4;
                }
                if (stsdData.format != null || str6 == null) {
                    return;
                }
                Format.Builder language = new Format.Builder().setId(i4).setSampleMimeType(str6).setCodecs(str7).setChannelCount(readUnsignedShort).setSampleRate(readUnsignedFixedPoint1616).setPcmEncoding(i12).setInitializationData(list).setDrmInitData(drmInitData2).setLanguage(str);
                if (esdsData != null) {
                    language.setAverageBitrate(Ints.saturatedCast(esdsData.bitrate)).setPeakBitrate(Ints.saturatedCast(esdsData.peakBitrate));
                }
                stsdData.format = language.build();
                return;
            }
            i8 = 2;
            int i122 = i8;
            String str62 = str3;
            List<byte[]> list2 = null;
            String str72 = null;
            EsdsData esdsData2 = null;
            while (position - i9 < i10) {
            }
            if (stsdData.format != null) {
                return;
            } else {
                return;
            }
        }
        str3 = str2;
        i8 = i7;
        int i1222 = i8;
        String str622 = str3;
        List<byte[]> list22 = null;
        String str722 = null;
        EsdsData esdsData22 = null;
        while (position - i9 < i10) {
        }
        if (stsdData.format != null) {
        }
    }

    private static int findBoxPosition(ParsableByteArray parsableByteArray, int i, int i2, int i3) throws ParserException {
        int position = parsableByteArray.getPosition();
        ExtractorUtil.checkContainerInput(position >= i2, null);
        while (position - i2 < i3) {
            parsableByteArray.setPosition(position);
            int readInt = parsableByteArray.readInt();
            ExtractorUtil.checkContainerInput(readInt > 0, "childAtomSize must be positive");
            if (parsableByteArray.readInt() == i) {
                return position;
            }
            position += readInt;
        }
        return -1;
    }

    private static EsdsData parseEsdsFromParent(ParsableByteArray parsableByteArray, int i) {
        parsableByteArray.setPosition(i + 12);
        parsableByteArray.skipBytes(1);
        parseExpandableClassSize(parsableByteArray);
        parsableByteArray.skipBytes(2);
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        if ((readUnsignedByte & 128) != 0) {
            parsableByteArray.skipBytes(2);
        }
        if ((readUnsignedByte & 64) != 0) {
            parsableByteArray.skipBytes(parsableByteArray.readUnsignedByte());
        }
        if ((readUnsignedByte & 32) != 0) {
            parsableByteArray.skipBytes(2);
        }
        parsableByteArray.skipBytes(1);
        parseExpandableClassSize(parsableByteArray);
        String mimeTypeFromMp4ObjectType = MimeTypes.getMimeTypeFromMp4ObjectType(parsableByteArray.readUnsignedByte());
        if (MimeTypes.AUDIO_MPEG.equals(mimeTypeFromMp4ObjectType) || MimeTypes.AUDIO_DTS.equals(mimeTypeFromMp4ObjectType) || MimeTypes.AUDIO_DTS_HD.equals(mimeTypeFromMp4ObjectType)) {
            return new EsdsData(mimeTypeFromMp4ObjectType, null, -1L, -1L);
        }
        parsableByteArray.skipBytes(4);
        long readUnsignedInt = parsableByteArray.readUnsignedInt();
        long readUnsignedInt2 = parsableByteArray.readUnsignedInt();
        parsableByteArray.skipBytes(1);
        int parseExpandableClassSize = parseExpandableClassSize(parsableByteArray);
        byte[] bArr = new byte[parseExpandableClassSize];
        parsableByteArray.readBytes(bArr, 0, parseExpandableClassSize);
        return new EsdsData(mimeTypeFromMp4ObjectType, bArr, readUnsignedInt2 > 0 ? readUnsignedInt2 : -1L, readUnsignedInt > 0 ? readUnsignedInt : -1L);
    }

    private static Pair<Integer, TrackEncryptionBox> parseSampleEntryEncryptionData(ParsableByteArray parsableByteArray, int i, int i2) throws ParserException {
        Pair<Integer, TrackEncryptionBox> parseCommonEncryptionSinfFromParent;
        int position = parsableByteArray.getPosition();
        while (position - i < i2) {
            parsableByteArray.setPosition(position);
            int readInt = parsableByteArray.readInt();
            ExtractorUtil.checkContainerInput(readInt > 0, "childAtomSize must be positive");
            if (parsableByteArray.readInt() == 1936289382 && (parseCommonEncryptionSinfFromParent = parseCommonEncryptionSinfFromParent(parsableByteArray, position, readInt)) != null) {
                return parseCommonEncryptionSinfFromParent;
            }
            position += readInt;
        }
        return null;
    }

    static Pair<Integer, TrackEncryptionBox> parseCommonEncryptionSinfFromParent(ParsableByteArray parsableByteArray, int i, int i2) throws ParserException {
        int i3 = i + 8;
        int i4 = -1;
        int i5 = 0;
        String str = null;
        Integer num = null;
        while (i3 - i < i2) {
            parsableByteArray.setPosition(i3);
            int readInt = parsableByteArray.readInt();
            int readInt2 = parsableByteArray.readInt();
            if (readInt2 == 1718775137) {
                num = Integer.valueOf(parsableByteArray.readInt());
            } else if (readInt2 == 1935894637) {
                parsableByteArray.skipBytes(4);
                str = parsableByteArray.readString(4);
            } else if (readInt2 == 1935894633) {
                i4 = i3;
                i5 = readInt;
            }
            i3 += readInt;
        }
        if (!C.CENC_TYPE_cenc.equals(str) && !C.CENC_TYPE_cbc1.equals(str) && !C.CENC_TYPE_cens.equals(str) && !C.CENC_TYPE_cbcs.equals(str)) {
            return null;
        }
        ExtractorUtil.checkContainerInput(num != null, "frma atom is mandatory");
        ExtractorUtil.checkContainerInput(i4 != -1, "schi atom is mandatory");
        TrackEncryptionBox parseSchiFromParent = parseSchiFromParent(parsableByteArray, i4, i5, str);
        ExtractorUtil.checkContainerInput(parseSchiFromParent != null, "tenc atom is mandatory");
        return Pair.create(num, (TrackEncryptionBox) Util.castNonNull(parseSchiFromParent));
    }

    private static TrackEncryptionBox parseSchiFromParent(ParsableByteArray parsableByteArray, int i, int i2, String str) {
        int i3;
        int i4;
        int i5 = i + 8;
        while (true) {
            byte[] bArr = null;
            if (i5 - i >= i2) {
                return null;
            }
            parsableByteArray.setPosition(i5);
            int readInt = parsableByteArray.readInt();
            if (parsableByteArray.readInt() == 1952804451) {
                int parseFullAtomVersion = Atom.parseFullAtomVersion(parsableByteArray.readInt());
                parsableByteArray.skipBytes(1);
                if (parseFullAtomVersion == 0) {
                    parsableByteArray.skipBytes(1);
                    i4 = 0;
                    i3 = 0;
                } else {
                    int readUnsignedByte = parsableByteArray.readUnsignedByte();
                    i3 = readUnsignedByte & 15;
                    i4 = (readUnsignedByte & PsExtractor.VIDEO_STREAM_MASK) >> 4;
                }
                boolean z = parsableByteArray.readUnsignedByte() == 1;
                int readUnsignedByte2 = parsableByteArray.readUnsignedByte();
                byte[] bArr2 = new byte[16];
                parsableByteArray.readBytes(bArr2, 0, 16);
                if (z && readUnsignedByte2 == 0) {
                    int readUnsignedByte3 = parsableByteArray.readUnsignedByte();
                    bArr = new byte[readUnsignedByte3];
                    parsableByteArray.readBytes(bArr, 0, readUnsignedByte3);
                }
                return new TrackEncryptionBox(z, str, readUnsignedByte2, bArr2, i4, i3, bArr);
            }
            i5 += readInt;
        }
    }

    private static byte[] parseProjFromParent(ParsableByteArray parsableByteArray, int i, int i2) {
        int i3 = i + 8;
        while (i3 - i < i2) {
            parsableByteArray.setPosition(i3);
            int readInt = parsableByteArray.readInt();
            if (parsableByteArray.readInt() == 1886547818) {
                return Arrays.copyOfRange(parsableByteArray.getData(), i3, readInt + i3);
            }
            i3 += readInt;
        }
        return null;
    }

    private static int parseExpandableClassSize(ParsableByteArray parsableByteArray) {
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        int i = readUnsignedByte & WorkQueueKt.MASK;
        while ((readUnsignedByte & 128) == 128) {
            readUnsignedByte = parsableByteArray.readUnsignedByte();
            i = (i << 7) | (readUnsignedByte & WorkQueueKt.MASK);
        }
        return i;
    }

    private static boolean canApplyEditWithGaplessInfo(long[] jArr, long j, long j2, long j3) {
        int length = jArr.length - 1;
        return jArr[0] <= j2 && j2 < jArr[Util.constrainValue(4, 0, length)] && jArr[Util.constrainValue(jArr.length - 4, 0, length)] < j3 && j3 <= j;
    }

    private AtomParsers() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static final class ChunkIterator {
        private final ParsableByteArray chunkOffsets;
        private final boolean chunkOffsetsAreLongs;
        public int index;
        public final int length;
        private int nextSamplesPerChunkChangeIndex;
        public int numSamples;
        public long offset;
        private int remainingSamplesPerChunkChanges;
        private final ParsableByteArray stsc;

        public ChunkIterator(ParsableByteArray parsableByteArray, ParsableByteArray parsableByteArray2, boolean z) throws ParserException {
            this.stsc = parsableByteArray;
            this.chunkOffsets = parsableByteArray2;
            this.chunkOffsetsAreLongs = z;
            parsableByteArray2.setPosition(12);
            this.length = parsableByteArray2.readUnsignedIntToInt();
            parsableByteArray.setPosition(12);
            this.remainingSamplesPerChunkChanges = parsableByteArray.readUnsignedIntToInt();
            ExtractorUtil.checkContainerInput(parsableByteArray.readInt() == 1, "first_chunk must be 1");
            this.index = -1;
        }

        public boolean moveNext() {
            long readUnsignedInt;
            int i = this.index + 1;
            this.index = i;
            if (i == this.length) {
                return false;
            }
            if (this.chunkOffsetsAreLongs) {
                readUnsignedInt = this.chunkOffsets.readUnsignedLongToLong();
            } else {
                readUnsignedInt = this.chunkOffsets.readUnsignedInt();
            }
            this.offset = readUnsignedInt;
            if (this.index == this.nextSamplesPerChunkChangeIndex) {
                this.numSamples = this.stsc.readUnsignedIntToInt();
                this.stsc.skipBytes(4);
                int i2 = this.remainingSamplesPerChunkChanges - 1;
                this.remainingSamplesPerChunkChanges = i2;
                this.nextSamplesPerChunkChangeIndex = i2 > 0 ? this.stsc.readUnsignedIntToInt() - 1 : -1;
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static final class TkhdData {
        private final long duration;
        private final int id;
        private final int rotationDegrees;

        public TkhdData(int i, long j, int i2) {
            this.id = i;
            this.duration = j;
            this.rotationDegrees = i2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static final class StsdData {
        public static final int STSD_HEADER_SIZE = 8;
        public Format format;
        public int nalUnitLengthFieldLength;
        public int requiredSampleTransformation = 0;
        public final TrackEncryptionBox[] trackEncryptionBoxes;

        public StsdData(int i) {
            this.trackEncryptionBoxes = new TrackEncryptionBox[i];
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static final class EsdsData {
        private final long bitrate;
        private final byte[] initializationData;
        private final String mimeType;
        private final long peakBitrate;

        public EsdsData(String str, byte[] bArr, long j, long j2) {
            this.mimeType = str;
            this.initializationData = bArr;
            this.bitrate = j;
            this.peakBitrate = j2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class StszSampleSizeBox implements SampleSizeBox {
        private final ParsableByteArray data;
        private final int fixedSampleSize;
        private final int sampleCount;

        public StszSampleSizeBox(Atom.LeafAtom leafAtom, Format format) {
            ParsableByteArray parsableByteArray = leafAtom.data;
            this.data = parsableByteArray;
            parsableByteArray.setPosition(12);
            int readUnsignedIntToInt = parsableByteArray.readUnsignedIntToInt();
            if (MimeTypes.AUDIO_RAW.equals(format.sampleMimeType)) {
                int pcmFrameSize = Util.getPcmFrameSize(format.pcmEncoding, format.channelCount);
                if (readUnsignedIntToInt == 0 || readUnsignedIntToInt % pcmFrameSize != 0) {
                    Log.w(AtomParsers.TAG, "Audio sample size mismatch. stsd sample size: " + pcmFrameSize + ", stsz sample size: " + readUnsignedIntToInt);
                    readUnsignedIntToInt = pcmFrameSize;
                }
            }
            this.fixedSampleSize = readUnsignedIntToInt == 0 ? -1 : readUnsignedIntToInt;
            this.sampleCount = parsableByteArray.readUnsignedIntToInt();
        }

        @Override // androidx.media3.extractor.mp4.AtomParsers.SampleSizeBox
        public int getSampleCount() {
            return this.sampleCount;
        }

        @Override // androidx.media3.extractor.mp4.AtomParsers.SampleSizeBox
        public int getFixedSampleSize() {
            return this.fixedSampleSize;
        }

        @Override // androidx.media3.extractor.mp4.AtomParsers.SampleSizeBox
        public int readNextSampleSize() {
            int i = this.fixedSampleSize;
            return i == -1 ? this.data.readUnsignedIntToInt() : i;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class Stz2SampleSizeBox implements SampleSizeBox {
        private int currentByte;
        private final ParsableByteArray data;
        private final int fieldSize;
        private final int sampleCount;
        private int sampleIndex;

        @Override // androidx.media3.extractor.mp4.AtomParsers.SampleSizeBox
        public int getFixedSampleSize() {
            return -1;
        }

        public Stz2SampleSizeBox(Atom.LeafAtom leafAtom) {
            ParsableByteArray parsableByteArray = leafAtom.data;
            this.data = parsableByteArray;
            parsableByteArray.setPosition(12);
            this.fieldSize = parsableByteArray.readUnsignedIntToInt() & 255;
            this.sampleCount = parsableByteArray.readUnsignedIntToInt();
        }

        @Override // androidx.media3.extractor.mp4.AtomParsers.SampleSizeBox
        public int getSampleCount() {
            return this.sampleCount;
        }

        @Override // androidx.media3.extractor.mp4.AtomParsers.SampleSizeBox
        public int readNextSampleSize() {
            int i = this.fieldSize;
            if (i == 8) {
                return this.data.readUnsignedByte();
            }
            if (i == 16) {
                return this.data.readUnsignedShort();
            }
            int i2 = this.sampleIndex;
            this.sampleIndex = i2 + 1;
            if (i2 % 2 == 0) {
                int readUnsignedByte = this.data.readUnsignedByte();
                this.currentByte = readUnsignedByte;
                return (readUnsignedByte & PsExtractor.VIDEO_STREAM_MASK) >> 4;
            }
            return this.currentByte & 15;
        }
    }
}
