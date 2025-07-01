package com.pichillilorenzo.flutter_inappwebview_android.types;

import android.webkit.WebResourceError;
import androidx.media3.exoplayer.rtsp.SessionDescription;
import androidx.webkit.WebResourceErrorCompat;
import androidx.webkit.WebViewFeature;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes4.dex */
public class WebResourceErrorExt {
    private String description;
    private int type;

    public WebResourceErrorExt(int i, String str) {
        this.type = i;
        this.description = str;
    }

    public static WebResourceErrorExt fromWebResourceError(WebResourceError webResourceError) {
        return new WebResourceErrorExt(webResourceError.getErrorCode(), webResourceError.getDescription().toString());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        WebResourceErrorExt webResourceErrorExt = (WebResourceErrorExt) obj;
        if (this.type != webResourceErrorExt.type) {
            return false;
        }
        return this.description.equals(webResourceErrorExt.description);
    }

    public String getDescription() {
        return this.description;
    }

    public int getType() {
        return this.type;
    }

    public int hashCode() {
        return (this.type * 31) + this.description.hashCode();
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public void setType(int i) {
        this.type = i;
    }

    public Map<String, Object> toMap() {
        HashMap hashMap = new HashMap();
        hashMap.put(SessionDescription.ATTR_TYPE, Integer.valueOf(getType()));
        hashMap.put("description", getDescription());
        return hashMap;
    }

    public String toString() {
        return "WebResourceErrorExt{type=" + this.type + ", description='" + this.description + "'}";
    }

    public static WebResourceErrorExt fromWebResourceError(WebResourceErrorCompat webResourceErrorCompat) {
        return new WebResourceErrorExt(WebViewFeature.isFeatureSupported("WEB_RESOURCE_ERROR_GET_CODE") ? webResourceErrorCompat.getErrorCode() : -1, WebViewFeature.isFeatureSupported("WEB_RESOURCE_ERROR_GET_DESCRIPTION") ? webResourceErrorCompat.getDescription().toString() : "");
    }
}
