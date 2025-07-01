package com.lyokone.location;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import com.tekartik.sqflite.Constant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.scheduling.WorkQueueKt;

/* compiled from: FlutterLocationService.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010\r\u001a\u00020\u000eJ\n\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0002J\u0010\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0005H\u0002J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0005H\u0002J\u0018\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0016\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u0018R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/lyokone/location/BackgroundNotification;", "", "context", "Landroid/content/Context;", "channelId", "", "notificationId", "", "(Landroid/content/Context;Ljava/lang/String;I)V", "builder", "Landroidx/core/app/NotificationCompat$Builder;", Constant.METHOD_OPTIONS, "Lcom/lyokone/location/NotificationOptions;", "build", "Landroid/app/Notification;", "buildBringToFrontIntent", "Landroid/app/PendingIntent;", "getDrawableId", "iconName", "updateChannel", "", "channelName", "updateNotification", "notify", "", "updateOptions", "isVisible", "location_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes4.dex */
public final class BackgroundNotification {
    private NotificationCompat.Builder builder;
    private final String channelId;
    private final Context context;
    private final int notificationId;
    private NotificationOptions options;

    public BackgroundNotification(Context context, String channelId, int i) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        this.context = context;
        this.channelId = channelId;
        this.notificationId = i;
        this.options = new NotificationOptions(null, null, null, null, null, null, false, WorkQueueKt.MASK, null);
        NotificationCompat.Builder priority = new NotificationCompat.Builder(context, channelId).setPriority(1);
        Intrinsics.checkNotNullExpressionValue(priority, "setPriority(...)");
        this.builder = priority;
        updateNotification(this.options, false);
    }

    private final int getDrawableId(String iconName) {
        return this.context.getResources().getIdentifier(iconName, "drawable", this.context.getPackageName());
    }

    private final PendingIntent buildBringToFrontIntent() {
        Intent intent;
        Intent launchIntentForPackage = this.context.getPackageManager().getLaunchIntentForPackage(this.context.getPackageName());
        Intent flags = (launchIntentForPackage == null || (intent = launchIntentForPackage.setPackage(null)) == null) ? null : intent.setFlags(270532608);
        if (flags != null) {
            return PendingIntent.getActivity(this.context, 0, flags, AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL);
        }
        return null;
    }

    private final void updateChannel(String channelName) {
        NotificationManagerCompat from = NotificationManagerCompat.from(this.context);
        Intrinsics.checkNotNullExpressionValue(from, "from(...)");
        NotificationChannel notificationChannel = new NotificationChannel(this.channelId, channelName, 0);
        notificationChannel.setLockscreenVisibility(0);
        from.createNotificationChannel(notificationChannel);
    }

    private final void updateNotification(NotificationOptions options, boolean notify) {
        NotificationCompat.Builder colorized;
        NotificationCompat.Builder contentIntent;
        int drawableId = getDrawableId(options.getIconName());
        if (drawableId == 0) {
            drawableId = getDrawableId(FlutterLocationServiceKt.kDefaultNotificationIconName);
        }
        NotificationCompat.Builder subText = this.builder.setContentTitle(options.getTitle()).setSmallIcon(drawableId).setContentText(options.getSubtitle()).setSubText(options.getDescription());
        Intrinsics.checkNotNullExpressionValue(subText, "setSubText(...)");
        this.builder = subText;
        if (options.getColor() != null) {
            colorized = this.builder.setColor(options.getColor().intValue()).setColorized(true);
            Intrinsics.checkNotNull(colorized);
        } else {
            colorized = this.builder.setColor(0).setColorized(false);
            Intrinsics.checkNotNull(colorized);
        }
        this.builder = colorized;
        if (options.getOnTapBringToFront()) {
            contentIntent = this.builder.setContentIntent(buildBringToFrontIntent());
            Intrinsics.checkNotNull(contentIntent);
        } else {
            contentIntent = this.builder.setContentIntent(null);
            Intrinsics.checkNotNull(contentIntent);
        }
        this.builder = contentIntent;
        if (notify) {
            NotificationManagerCompat from = NotificationManagerCompat.from(this.context);
            Intrinsics.checkNotNullExpressionValue(from, "from(...)");
            from.notify(this.notificationId, this.builder.build());
        }
    }

    public final void updateOptions(NotificationOptions options, boolean isVisible) {
        Intrinsics.checkNotNullParameter(options, "options");
        if (!Intrinsics.areEqual(options.getChannelName(), this.options.getChannelName())) {
            updateChannel(options.getChannelName());
        }
        updateNotification(options, isVisible);
        this.options = options;
    }

    public final Notification build() {
        updateChannel(this.options.getChannelName());
        Notification build = this.builder.build();
        Intrinsics.checkNotNullExpressionValue(build, "build(...)");
        return build;
    }
}
