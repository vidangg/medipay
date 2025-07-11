package io.flutter.embedding.android;

import android.R;
import android.content.Context;
import android.graphics.Matrix;
import android.util.TypedValue;
import android.view.InputDevice;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import androidx.camera.video.AudioStats;
import io.flutter.embedding.engine.renderer.FlutterRenderer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes4.dex */
public class AndroidTouchProcessor {
    static final int BYTES_PER_FIELD = 8;
    static final int DEFAULT_HORIZONTAL_SCROLL_FACTOR = 48;
    static final int DEFAULT_VERTICAL_SCROLL_FACTOR = 48;
    private static final Matrix IDENTITY_TRANSFORM = new Matrix();
    private static final int IMPLICIT_VIEW_ID = 0;
    static final int POINTER_DATA_FIELD_COUNT = 36;
    private static final int POINTER_DATA_FLAG_BATCHED = 1;
    private static final String TAG = "AndroidTouchProcessor";
    private int cachedVerticalScrollFactor;
    private final FlutterRenderer renderer;
    private final boolean trackMotionEvents;
    private final Map<Integer, float[]> ongoingPans = new HashMap();
    private final MotionEventTracker motionEventTracker = MotionEventTracker.getInstance();

    /* loaded from: classes4.dex */
    public @interface PointerChange {
        public static final int ADD = 1;
        public static final int CANCEL = 0;
        public static final int DOWN = 4;
        public static final int HOVER = 3;
        public static final int MOVE = 5;
        public static final int PAN_ZOOM_END = 9;
        public static final int PAN_ZOOM_START = 7;
        public static final int PAN_ZOOM_UPDATE = 8;
        public static final int REMOVE = 2;
        public static final int UP = 6;
    }

    /* loaded from: classes4.dex */
    public @interface PointerDeviceKind {
        public static final int INVERTED_STYLUS = 3;
        public static final int MOUSE = 1;
        public static final int STYLUS = 2;
        public static final int TOUCH = 0;
        public static final int TRACKPAD = 4;
        public static final int UNKNOWN = 5;
    }

    /* loaded from: classes4.dex */
    public @interface PointerSignalKind {
        public static final int NONE = 0;
        public static final int SCALE = 3;
        public static final int SCROLL = 1;
        public static final int SCROLL_INERTIA_CANCEL = 2;
        public static final int UNKNOWN = 4;
    }

    private int getPointerChangeForAction(int i) {
        if (i == 0) {
            return 4;
        }
        if (i == 1) {
            return 6;
        }
        if (i == 5) {
            return 4;
        }
        if (i == 6) {
            return 6;
        }
        if (i == 2) {
            return 5;
        }
        if (i == 7) {
            return 3;
        }
        if (i == 3) {
            return 0;
        }
        return i == 8 ? 3 : -1;
    }

    private int getPointerChangeForPanZoom(int i) {
        if (i == 4) {
            return 7;
        }
        if (i == 5) {
            return 8;
        }
        return (i == 6 || i == 0) ? 9 : -1;
    }

    private int getPointerDeviceTypeForToolType(int i) {
        if (i == 1) {
            return 0;
        }
        if (i == 2) {
            return 2;
        }
        if (i != 3) {
            return i != 4 ? 5 : 3;
        }
        return 1;
    }

    public AndroidTouchProcessor(FlutterRenderer flutterRenderer, boolean z) {
        this.renderer = flutterRenderer;
        this.trackMotionEvents = z;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return onTouchEvent(motionEvent, IDENTITY_TRANSFORM);
    }

    public boolean onTouchEvent(MotionEvent motionEvent, Matrix matrix) {
        int actionMasked = motionEvent.getActionMasked();
        int pointerChangeForAction = getPointerChangeForAction(motionEvent.getActionMasked());
        boolean z = actionMasked == 0 || actionMasked == 5;
        boolean z2 = !z && (actionMasked == 1 || actionMasked == 6);
        int i = (z2 && getPointerDeviceTypeForToolType(motionEvent.getToolType(motionEvent.getActionIndex())) == 0) ? 1 : 0;
        int pointerCount = motionEvent.getPointerCount();
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect((pointerCount + i) * 288);
        allocateDirect.order(ByteOrder.LITTLE_ENDIAN);
        if (z) {
            addPointerForIndex(motionEvent, motionEvent.getActionIndex(), pointerChangeForAction, 0, matrix, allocateDirect);
        } else if (z2) {
            for (int i2 = 0; i2 < pointerCount; i2++) {
                if (i2 != motionEvent.getActionIndex() && motionEvent.getToolType(i2) == 1) {
                    addPointerForIndex(motionEvent, i2, 5, 1, matrix, allocateDirect);
                }
            }
            addPointerForIndex(motionEvent, motionEvent.getActionIndex(), pointerChangeForAction, 0, matrix, allocateDirect);
            if (i != 0) {
                addPointerForIndex(motionEvent, motionEvent.getActionIndex(), 2, 0, matrix, allocateDirect);
            }
        } else {
            for (int i3 = 0; i3 < pointerCount; i3++) {
                addPointerForIndex(motionEvent, i3, pointerChangeForAction, 0, matrix, allocateDirect);
            }
        }
        if (allocateDirect.position() % 288 != 0) {
            throw new AssertionError("Packet position is not on field boundary");
        }
        this.renderer.dispatchPointerDataPacket(allocateDirect, allocateDirect.position());
        return true;
    }

    public boolean onGenericMotionEvent(MotionEvent motionEvent, Context context) {
        boolean isFromSource = motionEvent.isFromSource(2);
        boolean z = motionEvent.getActionMasked() == 7 || motionEvent.getActionMasked() == 8;
        if (!isFromSource || !z) {
            return false;
        }
        int pointerChangeForAction = getPointerChangeForAction(motionEvent.getActionMasked());
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(motionEvent.getPointerCount() * 288);
        allocateDirect.order(ByteOrder.LITTLE_ENDIAN);
        addPointerForIndex(motionEvent, motionEvent.getActionIndex(), pointerChangeForAction, 0, IDENTITY_TRANSFORM, allocateDirect, context);
        if (allocateDirect.position() % 288 != 0) {
            throw new AssertionError("Packet position is not on field boundary.");
        }
        this.renderer.dispatchPointerDataPacket(allocateDirect, allocateDirect.position());
        return true;
    }

    private void addPointerForIndex(MotionEvent motionEvent, int i, int i2, int i3, Matrix matrix, ByteBuffer byteBuffer) {
        addPointerForIndex(motionEvent, i, i2, i3, matrix, byteBuffer, null);
    }

    private void addPointerForIndex(MotionEvent motionEvent, int i, int i2, int i3, Matrix matrix, ByteBuffer byteBuffer, Context context) {
        float[] fArr;
        long j;
        int i4;
        double d;
        double d2;
        double d3;
        int i5;
        double d4;
        double d5;
        double d6;
        InputDevice.MotionRange motionRange;
        int i6 = -1;
        if (i2 == -1) {
            return;
        }
        int pointerId = motionEvent.getPointerId(i);
        int pointerDeviceTypeForToolType = getPointerDeviceTypeForToolType(motionEvent.getToolType(i));
        float[] fArr2 = {motionEvent.getX(i), motionEvent.getY(i)};
        matrix.mapPoints(fArr2);
        if (pointerDeviceTypeForToolType == 1) {
            j = motionEvent.getButtonState() & 31;
            if (j == 0 && motionEvent.getSource() == 8194 && i2 == 4) {
                fArr = fArr2;
                this.ongoingPans.put(Integer.valueOf(pointerId), fArr);
            } else {
                fArr = fArr2;
            }
        } else {
            fArr = fArr2;
            j = pointerDeviceTypeForToolType == 2 ? (motionEvent.getButtonState() >> 4) & 15 : 0L;
        }
        boolean containsKey = this.ongoingPans.containsKey(Integer.valueOf(pointerId));
        if (containsKey) {
            int pointerChangeForPanZoom = getPointerChangeForPanZoom(i2);
            if (pointerChangeForPanZoom == -1) {
                return;
            } else {
                i6 = pointerChangeForPanZoom;
            }
        }
        long id = this.trackMotionEvents ? this.motionEventTracker.track(motionEvent).getId() : 0L;
        int i7 = motionEvent.getActionMasked() == 8 ? 1 : 0;
        int i8 = i6;
        long eventTime = motionEvent.getEventTime() * 1000;
        byteBuffer.putLong(id);
        byteBuffer.putLong(eventTime);
        if (containsKey) {
            i4 = i8;
            byteBuffer.putLong(i4);
            byteBuffer.putLong(4L);
        } else {
            i4 = i8;
            byteBuffer.putLong(i2);
            byteBuffer.putLong(pointerDeviceTypeForToolType);
        }
        byteBuffer.putLong(i7);
        byteBuffer.putLong(pointerId);
        byteBuffer.putLong(0L);
        if (containsKey) {
            float[] fArr3 = this.ongoingPans.get(Integer.valueOf(pointerId));
            byteBuffer.putDouble(fArr3[0]);
            byteBuffer.putDouble(fArr3[1]);
        } else {
            byteBuffer.putDouble(fArr[0]);
            byteBuffer.putDouble(fArr[1]);
        }
        byteBuffer.putDouble(AudioStats.AUDIO_AMPLITUDE_NONE);
        byteBuffer.putDouble(AudioStats.AUDIO_AMPLITUDE_NONE);
        byteBuffer.putLong(j);
        byteBuffer.putLong(0L);
        byteBuffer.putLong(0L);
        byteBuffer.putDouble(motionEvent.getPressure(i));
        if (motionEvent.getDevice() == null || (motionRange = motionEvent.getDevice().getMotionRange(2)) == null) {
            d = AudioStats.AUDIO_AMPLITUDE_NONE;
            d2 = 1.0d;
        } else {
            d = motionRange.getMin();
            d2 = motionRange.getMax();
        }
        byteBuffer.putDouble(d);
        byteBuffer.putDouble(d2);
        if (pointerDeviceTypeForToolType == 2) {
            byteBuffer.putDouble(motionEvent.getAxisValue(24, i));
            d3 = AudioStats.AUDIO_AMPLITUDE_NONE;
            byteBuffer.putDouble(AudioStats.AUDIO_AMPLITUDE_NONE);
        } else {
            d3 = AudioStats.AUDIO_AMPLITUDE_NONE;
            byteBuffer.putDouble(AudioStats.AUDIO_AMPLITUDE_NONE);
            byteBuffer.putDouble(AudioStats.AUDIO_AMPLITUDE_NONE);
        }
        byteBuffer.putDouble(motionEvent.getSize(i));
        byteBuffer.putDouble(motionEvent.getToolMajor(i));
        byteBuffer.putDouble(motionEvent.getToolMinor(i));
        byteBuffer.putDouble(d3);
        byteBuffer.putDouble(d3);
        byteBuffer.putDouble(motionEvent.getAxisValue(8, i));
        if (pointerDeviceTypeForToolType == 2) {
            byteBuffer.putDouble(motionEvent.getAxisValue(25, i));
        } else {
            byteBuffer.putDouble(d3);
        }
        byteBuffer.putLong(i3);
        if (i7 == 1) {
            if (context != null) {
                d5 = getHorizontalScrollFactor(context);
                d6 = getVerticalScrollFactor(context);
            } else {
                d5 = 48.0d;
                d6 = 48.0d;
            }
            i5 = i4;
            byteBuffer.putDouble(d5 * (-motionEvent.getAxisValue(10, i)));
            byteBuffer.putDouble(d6 * (-motionEvent.getAxisValue(9, i)));
        } else {
            i5 = i4;
            byteBuffer.putDouble(AudioStats.AUDIO_AMPLITUDE_NONE);
            byteBuffer.putDouble(AudioStats.AUDIO_AMPLITUDE_NONE);
        }
        if (containsKey) {
            float[] fArr4 = this.ongoingPans.get(Integer.valueOf(pointerId));
            byteBuffer.putDouble(fArr[0] - fArr4[0]);
            byteBuffer.putDouble(fArr[1] - fArr4[1]);
            d4 = AudioStats.AUDIO_AMPLITUDE_NONE;
        } else {
            d4 = AudioStats.AUDIO_AMPLITUDE_NONE;
            byteBuffer.putDouble(AudioStats.AUDIO_AMPLITUDE_NONE);
            byteBuffer.putDouble(AudioStats.AUDIO_AMPLITUDE_NONE);
        }
        byteBuffer.putDouble(d4);
        byteBuffer.putDouble(d4);
        byteBuffer.putDouble(1.0d);
        byteBuffer.putDouble(d4);
        byteBuffer.putLong(0L);
        if (containsKey && i5 == 9) {
            this.ongoingPans.remove(Integer.valueOf(pointerId));
        }
    }

    private float getHorizontalScrollFactor(Context context) {
        return ViewConfiguration.get(context).getScaledHorizontalScrollFactor();
    }

    private float getVerticalScrollFactor(Context context) {
        return getVerticalScrollFactorAbove26(context);
    }

    private float getVerticalScrollFactorAbove26(Context context) {
        return ViewConfiguration.get(context).getScaledVerticalScrollFactor();
    }

    private int getVerticalScrollFactorPre26(Context context) {
        if (this.cachedVerticalScrollFactor == 0) {
            TypedValue typedValue = new TypedValue();
            if (!context.getTheme().resolveAttribute(R.attr.listPreferredItemHeight, typedValue, true)) {
                return 48;
            }
            this.cachedVerticalScrollFactor = (int) typedValue.getDimension(context.getResources().getDisplayMetrics());
        }
        return this.cachedVerticalScrollFactor;
    }
}
