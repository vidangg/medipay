package com.pichillilorenzo.flutter_inappwebview_android.types;

import androidx.media3.extractor.text.ttml.TtmlNode;
import com.pichillilorenzo.flutter_inappwebview_android.Util;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes4.dex */
public class InAppBrowserMenuItem {
    private Object icon;
    private String iconColor;
    private int id;
    private Integer order;
    private boolean showAsAction;
    private String title;

    public InAppBrowserMenuItem(int i, String str, Integer num, Object obj, String str2, boolean z) {
        this.id = i;
        this.title = str;
        this.order = num;
        this.icon = obj;
        this.iconColor = str2;
        this.showAsAction = z;
    }

    public static InAppBrowserMenuItem fromMap(Map<String, Object> map) {
        Object obj;
        AndroidResource androidResource = null;
        if (map == null) {
            return null;
        }
        int intValue = ((Integer) map.get(TtmlNode.ATTR_ID)).intValue();
        String str = (String) map.get("title");
        Integer num = (Integer) map.get("order");
        Object obj2 = map.get("icon");
        if (obj2 instanceof Map) {
            androidResource = AndroidResource.fromMap((Map) map.get("icon"));
        } else if (obj2 instanceof byte[]) {
            obj = obj2;
            return new InAppBrowserMenuItem(intValue, str, num, obj, (String) map.get("iconColor"), ((Boolean) Util.getOrDefault(map, "showAsAction", Boolean.FALSE)).booleanValue());
        }
        obj = androidResource;
        return new InAppBrowserMenuItem(intValue, str, num, obj, (String) map.get("iconColor"), ((Boolean) Util.getOrDefault(map, "showAsAction", Boolean.FALSE)).booleanValue());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        InAppBrowserMenuItem inAppBrowserMenuItem = (InAppBrowserMenuItem) obj;
        if (this.id == inAppBrowserMenuItem.id && this.showAsAction == inAppBrowserMenuItem.showAsAction && this.title.equals(inAppBrowserMenuItem.title) && Objects.equals(this.order, inAppBrowserMenuItem.order) && Objects.equals(this.icon, inAppBrowserMenuItem.icon)) {
            return Objects.equals(this.iconColor, inAppBrowserMenuItem.iconColor);
        }
        return false;
    }

    public Object getIcon() {
        return this.icon;
    }

    public String getIconColor() {
        return this.iconColor;
    }

    public int getId() {
        return this.id;
    }

    public Integer getOrder() {
        return this.order;
    }

    public String getTitle() {
        return this.title;
    }

    public int hashCode() {
        int hashCode = ((this.id * 31) + this.title.hashCode()) * 31;
        Integer num = this.order;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 31;
        Object obj = this.icon;
        int hashCode3 = (hashCode2 + (obj != null ? obj.hashCode() : 0)) * 31;
        String str = this.iconColor;
        return ((hashCode3 + (str != null ? str.hashCode() : 0)) * 31) + (this.showAsAction ? 1 : 0);
    }

    public boolean isShowAsAction() {
        return this.showAsAction;
    }

    public void setIcon(Object obj) {
        this.icon = obj;
    }

    public void setIconColor(String str) {
        this.iconColor = str;
    }

    public void setId(int i) {
        this.id = i;
    }

    public void setOrder(Integer num) {
        this.order = num;
    }

    public void setShowAsAction(boolean z) {
        this.showAsAction = z;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String toString() {
        return "InAppBrowserMenuItem{id=" + this.id + ", title='" + this.title + "', order=" + this.order + ", icon=" + this.icon + ", iconColor='" + this.iconColor + "', showAsAction=" + this.showAsAction + '}';
    }
}
