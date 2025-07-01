package com.pichillilorenzo.flutter_inappwebview_android.types;

import android.print.PrintAttributes;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.google.firebase.messaging.Constants;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes4.dex */
public class MediaSizeExt {
    private int heightMils;
    private String id;
    private String label;
    private int widthMils;

    public MediaSizeExt(String str, String str2, int i, int i2) {
        this.id = str;
        this.label = str2;
        this.widthMils = i;
        this.heightMils = i2;
    }

    public static MediaSizeExt fromMap(Map<String, Object> map) {
        if (map == null) {
            return null;
        }
        return new MediaSizeExt((String) map.get(TtmlNode.ATTR_ID), (String) map.get(Constants.ScionAnalytics.PARAM_LABEL), ((Integer) map.get("widthMils")).intValue(), ((Integer) map.get("heightMils")).intValue());
    }

    public static MediaSizeExt fromMediaSize(PrintAttributes.MediaSize mediaSize) {
        if (mediaSize == null) {
            return null;
        }
        return new MediaSizeExt(mediaSize.getId(), null, mediaSize.getHeightMils(), mediaSize.getWidthMils());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        MediaSizeExt mediaSizeExt = (MediaSizeExt) obj;
        if (this.widthMils != mediaSizeExt.widthMils || this.heightMils != mediaSizeExt.heightMils || !this.id.equals(mediaSizeExt.id)) {
            return false;
        }
        String str = this.label;
        String str2 = mediaSizeExt.label;
        return str != null ? str.equals(str2) : str2 == null;
    }

    public int getHeightMils() {
        return this.heightMils;
    }

    public String getId() {
        return this.id;
    }

    public String getLabel() {
        return this.label;
    }

    public int getWidthMils() {
        return this.widthMils;
    }

    public int hashCode() {
        int hashCode = this.id.hashCode() * 31;
        String str = this.label;
        return ((((hashCode + (str != null ? str.hashCode() : 0)) * 31) + this.widthMils) * 31) + this.heightMils;
    }

    public void setHeightMils(int i) {
        this.heightMils = i;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setLabel(String str) {
        this.label = str;
    }

    public void setWidthMils(int i) {
        this.widthMils = i;
    }

    public Map<String, Object> toMap() {
        HashMap hashMap = new HashMap();
        hashMap.put(TtmlNode.ATTR_ID, this.id);
        hashMap.put(Constants.ScionAnalytics.PARAM_LABEL, this.label);
        hashMap.put("heightMils", Integer.valueOf(this.heightMils));
        hashMap.put("widthMils", Integer.valueOf(this.widthMils));
        return hashMap;
    }

    public PrintAttributes.MediaSize toMediaSize() {
        return new PrintAttributes.MediaSize(this.id, TypedValues.Custom.NAME, this.widthMils, this.heightMils);
    }

    public String toString() {
        return "MediaSizeExt{id='" + this.id + "', label='" + this.label + "', widthMils=" + this.widthMils + ", heightMils=" + this.heightMils + '}';
    }
}
