package androidx.media3.common.util;

import android.app.Notification;
import android.app.Service;
import android.graphics.Region;
import android.media.metrics.LogSessionId;
import android.media.metrics.NetworkEvent;
import android.media.metrics.PlaybackErrorEvent;
import android.media.metrics.PlaybackMetrics;
import android.net.http.HttpEngine;
import android.net.http.NetworkException;
import android.net.http.UrlResponseInfo;
import android.util.SparseArray;
import android.view.WindowInsetsController;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.contentcapture.ContentCaptureSession;
import java.util.Map;

/* compiled from: D8$$SyntheticClass */
/* loaded from: classes.dex */
public final /* synthetic */ class Util$$ExternalSyntheticApiModelOutline0 {
    public static /* bridge */ /* synthetic */ int m(SparseArray sparseArray) {
        return sparseArray.contentHashCode();
    }

    public static /* bridge */ /* synthetic */ int m(AccessibilityNodeInfo.TouchDelegateInfo touchDelegateInfo) {
        return touchDelegateInfo.getRegionCount();
    }

    public static /* bridge */ /* synthetic */ Region m(AccessibilityNodeInfo.TouchDelegateInfo touchDelegateInfo, int i) {
        return touchDelegateInfo.getRegionAt(i);
    }

    /* renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ LogSessionId m384m() {
        return LogSessionId.LOG_SESSION_ID_NONE;
    }

    /* renamed from: m, reason: collision with other method in class */
    public static /* synthetic */ NetworkEvent.Builder m385m() {
        return new NetworkEvent.Builder();
    }

    /* renamed from: m, reason: collision with other method in class */
    public static /* synthetic */ PlaybackErrorEvent.Builder m386m() {
        return new PlaybackErrorEvent.Builder();
    }

    /* renamed from: m, reason: collision with other method in class */
    public static /* synthetic */ PlaybackMetrics.Builder m387m() {
        return new PlaybackMetrics.Builder();
    }

    public static /* bridge */ /* synthetic */ PlaybackMetrics.Builder m(Object obj) {
        return (PlaybackMetrics.Builder) obj;
    }

    /* renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ HttpEngine m389m(Object obj) {
        return (HttpEngine) obj;
    }

    /* renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ NetworkException m390m(Object obj) {
        return (NetworkException) obj;
    }

    /* renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ UrlResponseInfo m391m(Object obj) {
        return (UrlResponseInfo) obj;
    }

    /* renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ WindowInsetsController.OnControllableInsetsChangedListener m393m(Object obj) {
        return (WindowInsetsController.OnControllableInsetsChangedListener) obj;
    }

    /* renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ AccessibilityNodeInfo.AccessibilityAction m394m() {
        return AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_UP;
    }

    public static /* bridge */ /* synthetic */ AccessibilityNodeInfo.TouchDelegateInfo m(AccessibilityNodeInfo accessibilityNodeInfo) {
        return accessibilityNodeInfo.getTouchDelegateInfo();
    }

    public static /* synthetic */ AccessibilityNodeInfo.TouchDelegateInfo m(Map map) {
        return new AccessibilityNodeInfo.TouchDelegateInfo(map);
    }

    public static /* bridge */ /* synthetic */ AccessibilityNodeInfo m(AccessibilityNodeInfo.TouchDelegateInfo touchDelegateInfo, Region region) {
        return touchDelegateInfo.getTargetForRegion(region);
    }

    /* renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ ContentCaptureSession m395m(Object obj) {
        return (ContentCaptureSession) obj;
    }

    public static /* bridge */ /* synthetic */ void m(Service service, int i, Notification notification, int i2) {
        service.startForeground(i, notification, i2);
    }

    public static /* bridge */ /* synthetic */ void m(AccessibilityNodeInfo accessibilityNodeInfo, AccessibilityNodeInfo.TouchDelegateInfo touchDelegateInfo) {
        accessibilityNodeInfo.setTouchDelegateInfo(touchDelegateInfo);
    }

    public static /* bridge */ /* synthetic */ void m(AccessibilityNodeInfo accessibilityNodeInfo, boolean z) {
        accessibilityNodeInfo.setTextEntryKey(z);
    }

    public static /* bridge */ /* synthetic */ boolean m(SparseArray sparseArray, SparseArray sparseArray2) {
        return sparseArray.contentEquals(sparseArray2);
    }

    /* renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ boolean m399m(AccessibilityNodeInfo accessibilityNodeInfo) {
        return accessibilityNodeInfo.isTextEntryKey();
    }

    /* renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ boolean m400m(Object obj) {
        return obj instanceof NetworkException;
    }

    /* renamed from: m$1, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ AccessibilityNodeInfo.AccessibilityAction m401m$1() {
        return AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_DOWN;
    }

    /* renamed from: m$2, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ AccessibilityNodeInfo.AccessibilityAction m402m$2() {
        return AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_LEFT;
    }

    /* renamed from: m$3, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ AccessibilityNodeInfo.AccessibilityAction m403m$3() {
        return AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_RIGHT;
    }

    /* renamed from: m$4, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ AccessibilityNodeInfo.AccessibilityAction m404m$4() {
        return AccessibilityNodeInfo.AccessibilityAction.ACTION_PRESS_AND_HOLD;
    }

    /* renamed from: m$5, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ AccessibilityNodeInfo.AccessibilityAction m405m$5() {
        return AccessibilityNodeInfo.AccessibilityAction.ACTION_IME_ENTER;
    }

    /* renamed from: m$6, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ AccessibilityNodeInfo.AccessibilityAction m406m$6() {
        return AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_START;
    }

    /* renamed from: m$7, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ AccessibilityNodeInfo.AccessibilityAction m407m$7() {
        return AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_DROP;
    }

    public static /* bridge */ /* synthetic */ AccessibilityNodeInfo.AccessibilityAction m$8() {
        return AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_CANCEL;
    }

    public static /* bridge */ /* synthetic */ AccessibilityNodeInfo.AccessibilityAction m$9() {
        return AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_TEXT_SUGGESTIONS;
    }
}
