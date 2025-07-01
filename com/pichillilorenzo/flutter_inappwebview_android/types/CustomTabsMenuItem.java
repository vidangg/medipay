package com.pichillilorenzo.flutter_inappwebview_android.types;

import androidx.media3.extractor.text.ttml.TtmlNode;
import com.google.firebase.messaging.Constants;
import java.util.Map;

/* loaded from: classes4.dex */
public class CustomTabsMenuItem {
    private int id;
    private String label;

    public CustomTabsMenuItem(int i, String str) {
        this.id = i;
        this.label = str;
    }

    public static CustomTabsMenuItem fromMap(Map<String, Object> map) {
        if (map == null) {
            return null;
        }
        return new CustomTabsMenuItem(((Integer) map.get(TtmlNode.ATTR_ID)).intValue(), (String) map.get(Constants.ScionAnalytics.PARAM_LABEL));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        CustomTabsMenuItem customTabsMenuItem = (CustomTabsMenuItem) obj;
        if (this.id != customTabsMenuItem.id) {
            return false;
        }
        return this.label.equals(customTabsMenuItem.label);
    }

    public int getId() {
        return this.id;
    }

    public String getLabel() {
        return this.label;
    }

    public int hashCode() {
        return (this.id * 31) + this.label.hashCode();
    }

    public void setId(int i) {
        this.id = i;
    }

    public void setLabel(String str) {
        this.label = str;
    }

    public String toString() {
        return "CustomTabsMenuItem{id=" + this.id + ", label='" + this.label + "'}";
    }
}
