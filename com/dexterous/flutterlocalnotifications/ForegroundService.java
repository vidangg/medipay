package com.dexterous.flutterlocalnotifications;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class ForegroundService extends Service {
    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        ForegroundServiceStartParameter foregroundServiceStartParameter;
        Serializable serializableExtra;
        if (Build.VERSION.SDK_INT >= 33) {
            serializableExtra = intent.getSerializableExtra(ForegroundServiceStartParameter.EXTRA, ForegroundServiceStartParameter.class);
            foregroundServiceStartParameter = (ForegroundServiceStartParameter) serializableExtra;
        } else {
            foregroundServiceStartParameter = (ForegroundServiceStartParameter) intent.getSerializableExtra(ForegroundServiceStartParameter.EXTRA);
        }
        Notification createNotification = FlutterLocalNotificationsPlugin.createNotification(this, foregroundServiceStartParameter.notificationData);
        if (foregroundServiceStartParameter.foregroundServiceTypes != null && Build.VERSION.SDK_INT >= 29) {
            startForeground(foregroundServiceStartParameter.notificationData.id.intValue(), createNotification, orCombineFlags(foregroundServiceStartParameter.foregroundServiceTypes));
        } else {
            startForeground(foregroundServiceStartParameter.notificationData.id.intValue(), createNotification);
        }
        return foregroundServiceStartParameter.startMode;
    }

    private static int orCombineFlags(ArrayList<Integer> arrayList) {
        int intValue = arrayList.get(0).intValue();
        for (int i = 1; i < arrayList.size(); i++) {
            intValue |= arrayList.get(i).intValue();
        }
        return intValue;
    }
}
