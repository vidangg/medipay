package androidx.media3.common.audio;

import androidx.media3.common.audio.AudioProcessor;
import androidx.media3.common.util.Util;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class ToInt16PcmAudioProcessor extends BaseAudioProcessor {
    @Override // androidx.media3.common.audio.BaseAudioProcessor
    public AudioProcessor.AudioFormat onConfigure(AudioProcessor.AudioFormat audioFormat) throws AudioProcessor.UnhandledAudioFormatException {
        int i = audioFormat.encoding;
        if (i != 3 && i != 2 && i != 268435456 && i != 21 && i != 1342177280 && i != 22 && i != 1610612736 && i != 4) {
            throw new AudioProcessor.UnhandledAudioFormatException(audioFormat);
        }
        if (i != 2) {
            return new AudioProcessor.AudioFormat(audioFormat.sampleRate, audioFormat.channelCount, 2);
        }
        return AudioProcessor.AudioFormat.NOT_SET;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00e5 A[ADDED_TO_REGION, LOOP:6: B:42:0x00e5->B:43:0x00e7, LOOP_START, PHI: r0
      0x00e5: PHI (r0v1 int) = (r0v0 int), (r0v2 int) binds: [B:13:0x003f, B:43:0x00e7] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // androidx.media3.common.audio.AudioProcessor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void queueInput(ByteBuffer byteBuffer) {
        int i;
        int position = byteBuffer.position();
        int limit = byteBuffer.limit();
        int i2 = limit - position;
        int i3 = this.inputAudioFormat.encoding;
        if (i3 != 3) {
            if (i3 != 4) {
                if (i3 != 21) {
                    if (i3 != 22) {
                        if (i3 != 268435456) {
                            if (i3 != 1342177280) {
                                if (i3 != 1610612736) {
                                    throw new IllegalStateException();
                                }
                            }
                        }
                        ByteBuffer replaceOutputBuffer = replaceOutputBuffer(i2);
                        i = this.inputAudioFormat.encoding;
                        if (i == 3) {
                            while (position < limit) {
                                replaceOutputBuffer.put((byte) 0);
                                replaceOutputBuffer.put((byte) ((byteBuffer.get(position) & 255) - 128));
                                position++;
                            }
                        } else if (i == 4) {
                            while (position < limit) {
                                short constrainValue = (short) (Util.constrainValue(byteBuffer.getFloat(position), -1.0f, 1.0f) * 32767.0f);
                                replaceOutputBuffer.put((byte) (constrainValue & 255));
                                replaceOutputBuffer.put((byte) ((constrainValue >> 8) & 255));
                                position += 4;
                            }
                        } else if (i == 21) {
                            while (position < limit) {
                                replaceOutputBuffer.put(byteBuffer.get(position + 1));
                                replaceOutputBuffer.put(byteBuffer.get(position + 2));
                                position += 3;
                            }
                        } else if (i == 22) {
                            while (position < limit) {
                                replaceOutputBuffer.put(byteBuffer.get(position + 2));
                                replaceOutputBuffer.put(byteBuffer.get(position + 3));
                                position += 4;
                            }
                        } else if (i == 268435456) {
                            while (position < limit) {
                                replaceOutputBuffer.put(byteBuffer.get(position + 1));
                                replaceOutputBuffer.put(byteBuffer.get(position));
                                position += 2;
                            }
                        } else if (i == 1342177280) {
                            while (position < limit) {
                                replaceOutputBuffer.put(byteBuffer.get(position + 1));
                                replaceOutputBuffer.put(byteBuffer.get(position));
                                position += 3;
                            }
                        } else {
                            if (i != 1610612736) {
                                throw new IllegalStateException();
                            }
                            while (position < limit) {
                                replaceOutputBuffer.put(byteBuffer.get(position + 1));
                                replaceOutputBuffer.put(byteBuffer.get(position));
                                position += 4;
                            }
                        }
                        byteBuffer.position(byteBuffer.limit());
                        replaceOutputBuffer.flip();
                    }
                }
                i2 /= 3;
            }
            i2 /= 2;
            ByteBuffer replaceOutputBuffer2 = replaceOutputBuffer(i2);
            i = this.inputAudioFormat.encoding;
            if (i == 3) {
            }
            byteBuffer.position(byteBuffer.limit());
            replaceOutputBuffer2.flip();
        }
        i2 *= 2;
        ByteBuffer replaceOutputBuffer22 = replaceOutputBuffer(i2);
        i = this.inputAudioFormat.encoding;
        if (i == 3) {
        }
        byteBuffer.position(byteBuffer.limit());
        replaceOutputBuffer22.flip();
    }
}
