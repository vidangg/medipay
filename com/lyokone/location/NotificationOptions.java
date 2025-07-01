package com.lyokone.location;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.scheduling.WorkQueueKt;

/* compiled from: FlutterLocationService.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001a\b\u0086\b\u0018\u00002\u00020\u0001BQ\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0010J\t\u0010\u001e\u001a\u00020\u000bHÆ\u0003JZ\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001¢\u0006\u0002\u0010 J\u0013\u0010!\u001a\u00020\u000b2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020\tHÖ\u0001J\t\u0010$\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000e¨\u0006%"}, d2 = {"Lcom/lyokone/location/NotificationOptions;", "", "channelName", "", "title", "iconName", "subtitle", "description", "color", "", "onTapBringToFront", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Z)V", "getChannelName", "()Ljava/lang/String;", "getColor", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getDescription", "getIconName", "getOnTapBringToFront", "()Z", "getSubtitle", "getTitle", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Z)Lcom/lyokone/location/NotificationOptions;", "equals", "other", "hashCode", "toString", "location_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes4.dex */
public final /* data */ class NotificationOptions {
    private final String channelName;
    private final Integer color;
    private final String description;
    private final String iconName;
    private final boolean onTapBringToFront;
    private final String subtitle;
    private final String title;

    public NotificationOptions() {
        this(null, null, null, null, null, null, false, WorkQueueKt.MASK, null);
    }

    public static /* synthetic */ NotificationOptions copy$default(NotificationOptions notificationOptions, String str, String str2, String str3, String str4, String str5, Integer num, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = notificationOptions.channelName;
        }
        if ((i & 2) != 0) {
            str2 = notificationOptions.title;
        }
        String str6 = str2;
        if ((i & 4) != 0) {
            str3 = notificationOptions.iconName;
        }
        String str7 = str3;
        if ((i & 8) != 0) {
            str4 = notificationOptions.subtitle;
        }
        String str8 = str4;
        if ((i & 16) != 0) {
            str5 = notificationOptions.description;
        }
        String str9 = str5;
        if ((i & 32) != 0) {
            num = notificationOptions.color;
        }
        Integer num2 = num;
        if ((i & 64) != 0) {
            z = notificationOptions.onTapBringToFront;
        }
        return notificationOptions.copy(str, str6, str7, str8, str9, num2, z);
    }

    /* renamed from: component1, reason: from getter */
    public final String getChannelName() {
        return this.channelName;
    }

    /* renamed from: component2, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* renamed from: component3, reason: from getter */
    public final String getIconName() {
        return this.iconName;
    }

    /* renamed from: component4, reason: from getter */
    public final String getSubtitle() {
        return this.subtitle;
    }

    /* renamed from: component5, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* renamed from: component6, reason: from getter */
    public final Integer getColor() {
        return this.color;
    }

    /* renamed from: component7, reason: from getter */
    public final boolean getOnTapBringToFront() {
        return this.onTapBringToFront;
    }

    public final NotificationOptions copy(String channelName, String title, String iconName, String subtitle, String description, Integer color, boolean onTapBringToFront) {
        Intrinsics.checkNotNullParameter(channelName, "channelName");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(iconName, "iconName");
        return new NotificationOptions(channelName, title, iconName, subtitle, description, color, onTapBringToFront);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof NotificationOptions)) {
            return false;
        }
        NotificationOptions notificationOptions = (NotificationOptions) other;
        return Intrinsics.areEqual(this.channelName, notificationOptions.channelName) && Intrinsics.areEqual(this.title, notificationOptions.title) && Intrinsics.areEqual(this.iconName, notificationOptions.iconName) && Intrinsics.areEqual(this.subtitle, notificationOptions.subtitle) && Intrinsics.areEqual(this.description, notificationOptions.description) && Intrinsics.areEqual(this.color, notificationOptions.color) && this.onTapBringToFront == notificationOptions.onTapBringToFront;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((((this.channelName.hashCode() * 31) + this.title.hashCode()) * 31) + this.iconName.hashCode()) * 31;
        String str = this.subtitle;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.description;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Integer num = this.color;
        int hashCode4 = (hashCode3 + (num != null ? num.hashCode() : 0)) * 31;
        boolean z = this.onTapBringToFront;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        return hashCode4 + i;
    }

    public String toString() {
        return "NotificationOptions(channelName=" + this.channelName + ", title=" + this.title + ", iconName=" + this.iconName + ", subtitle=" + this.subtitle + ", description=" + this.description + ", color=" + this.color + ", onTapBringToFront=" + this.onTapBringToFront + ')';
    }

    public NotificationOptions(String channelName, String title, String iconName, String str, String str2, Integer num, boolean z) {
        Intrinsics.checkNotNullParameter(channelName, "channelName");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(iconName, "iconName");
        this.channelName = channelName;
        this.title = title;
        this.iconName = iconName;
        this.subtitle = str;
        this.description = str2;
        this.color = num;
        this.onTapBringToFront = z;
    }

    public /* synthetic */ NotificationOptions(String str, String str2, String str3, String str4, String str5, Integer num, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? FlutterLocationServiceKt.kDefaultChannelName : str, (i & 2) != 0 ? FlutterLocationServiceKt.kDefaultNotificationTitle : str2, (i & 4) != 0 ? FlutterLocationServiceKt.kDefaultNotificationIconName : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5, (i & 32) != 0 ? null : num, (i & 64) != 0 ? false : z);
    }

    public final String getChannelName() {
        return this.channelName;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getIconName() {
        return this.iconName;
    }

    public final String getSubtitle() {
        return this.subtitle;
    }

    public final String getDescription() {
        return this.description;
    }

    public final Integer getColor() {
        return this.color;
    }

    public final boolean getOnTapBringToFront() {
        return this.onTapBringToFront;
    }
}
