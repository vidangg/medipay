package io.flutter.plugins.sharedpreferences;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.media3.exoplayer.rtsp.SessionDescription;
import androidx.media3.extractor.ts.TsExtractor;
import io.flutter.plugin.common.StandardMessageCodec;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MessagesAsync.g.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0005\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0012\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0014J\u001a\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0004H\u0014¨\u0006\u000e"}, d2 = {"Lio/flutter/plugins/sharedpreferences/MessagesAsyncPigeonCodec;", "Lio/flutter/plugin/common/StandardMessageCodec;", "()V", "readValueOfType", "", SessionDescription.ATTR_TYPE, "", "buffer", "Ljava/nio/ByteBuffer;", "writeValue", "", "stream", "Ljava/io/ByteArrayOutputStream;", "value", "shared_preferences_android_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes4.dex */
class MessagesAsyncPigeonCodec extends StandardMessageCodec {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.flutter.plugin.common.StandardMessageCodec
    public Object readValueOfType(byte type, ByteBuffer buffer) {
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        if (type == -127) {
            Long l = (Long) readValue(buffer);
            if (l != null) {
                return StringListLookupResultType.INSTANCE.ofRaw((int) l.longValue());
            }
            return null;
        }
        if (type == -126) {
            Object readValue = readValue(buffer);
            List<? extends Object> list = readValue instanceof List ? (List) readValue : null;
            if (list != null) {
                return SharedPreferencesPigeonOptions.INSTANCE.fromList(list);
            }
            return null;
        }
        if (type == -125) {
            Object readValue2 = readValue(buffer);
            List<? extends Object> list2 = readValue2 instanceof List ? (List) readValue2 : null;
            if (list2 != null) {
                return StringListResult.INSTANCE.fromList(list2);
            }
            return null;
        }
        return super.readValueOfType(type, buffer);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.flutter.plugin.common.StandardMessageCodec
    public void writeValue(ByteArrayOutputStream stream, Object value) {
        Intrinsics.checkNotNullParameter(stream, "stream");
        if (value instanceof StringListLookupResultType) {
            stream.write(TsExtractor.TS_STREAM_TYPE_AC3);
            writeValue(stream, Integer.valueOf(((StringListLookupResultType) value).getRaw()));
        } else if (value instanceof SharedPreferencesPigeonOptions) {
            stream.write(TsExtractor.TS_STREAM_TYPE_HDMV_DTS);
            writeValue(stream, ((SharedPreferencesPigeonOptions) value).toList());
        } else if (value instanceof StringListResult) {
            stream.write(131);
            writeValue(stream, ((StringListResult) value).toList());
        } else {
            super.writeValue(stream, value);
        }
    }
}
