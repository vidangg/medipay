package io.flutter.plugins.webviewflutter;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.media3.exoplayer.rtsp.SessionDescription;
import androidx.media3.extractor.ts.TsExtractor;
import io.flutter.plugin.common.StandardMessageCodec;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AndroidWebkitLibrary.g.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0005\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0012\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0014J\u001a\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0004H\u0014¨\u0006\u000e"}, d2 = {"Lio/flutter/plugins/webviewflutter/AndroidWebkitLibraryPigeonCodec;", "Lio/flutter/plugin/common/StandardMessageCodec;", "()V", "readValueOfType", "", SessionDescription.ATTR_TYPE, "", "buffer", "Ljava/nio/ByteBuffer;", "writeValue", "", "stream", "Ljava/io/ByteArrayOutputStream;", "value", "webview_flutter_android_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes4.dex */
public class AndroidWebkitLibraryPigeonCodec extends StandardMessageCodec {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.flutter.plugin.common.StandardMessageCodec
    public Object readValueOfType(byte type, ByteBuffer buffer) {
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        if (type == -127) {
            Long l = (Long) readValue(buffer);
            if (l == null) {
                return null;
            }
            return FileChooserMode.INSTANCE.ofRaw((int) l.longValue());
        }
        if (type == -126) {
            Long l2 = (Long) readValue(buffer);
            if (l2 == null) {
                return null;
            }
            return ConsoleMessageLevel.INSTANCE.ofRaw((int) l2.longValue());
        }
        if (type == -125) {
            Long l3 = (Long) readValue(buffer);
            if (l3 == null) {
                return null;
            }
            return OverScrollMode.INSTANCE.ofRaw((int) l3.longValue());
        }
        if (type == -124) {
            Long l4 = (Long) readValue(buffer);
            if (l4 == null) {
                return null;
            }
            return SslErrorType.INSTANCE.ofRaw((int) l4.longValue());
        }
        return super.readValueOfType(type, buffer);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.flutter.plugin.common.StandardMessageCodec
    public void writeValue(ByteArrayOutputStream stream, Object value) {
        Intrinsics.checkNotNullParameter(stream, "stream");
        if (value instanceof FileChooserMode) {
            stream.write(TsExtractor.TS_STREAM_TYPE_AC3);
            writeValue(stream, Integer.valueOf(((FileChooserMode) value).getRaw()));
            return;
        }
        if (value instanceof ConsoleMessageLevel) {
            stream.write(TsExtractor.TS_STREAM_TYPE_HDMV_DTS);
            writeValue(stream, Integer.valueOf(((ConsoleMessageLevel) value).getRaw()));
        } else if (value instanceof OverScrollMode) {
            stream.write(131);
            writeValue(stream, Integer.valueOf(((OverScrollMode) value).getRaw()));
        } else if (value instanceof SslErrorType) {
            stream.write(132);
            writeValue(stream, Integer.valueOf(((SslErrorType) value).getRaw()));
        } else {
            super.writeValue(stream, value);
        }
    }
}
