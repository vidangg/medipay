package com.llfbandit.app_links;

import android.content.Intent;
import android.os.Parcel;
import android.util.Log;
import org.microg.safeparcel.SafeParcelReader;

/* loaded from: classes4.dex */
public class AppLinksHelper {
    private static final String FIREBASE_DYNAMIC_LINKS_DATA = "com.google.firebase.dynamiclinks.DYNAMIC_LINK_DATA";
    private static final String TAG = "com.llfbandit.app_links";

    public static String getDeepLinkFromIntent(Intent intent) {
        String shortDeepLink = getShortDeepLink(intent);
        if (shortDeepLink != null) {
            Log.d(TAG, "handleIntent: (Data) (short deep link)" + shortDeepLink);
            return shortDeepLink;
        }
        return getUrl(intent);
    }

    private static String getShortDeepLink(Intent intent) {
        byte[] byteArrayExtra = intent.getByteArrayExtra(FIREBASE_DYNAMIC_LINKS_DATA);
        if (byteArrayExtra == null || byteArrayExtra.length == 0) {
            return null;
        }
        Parcel obtain = Parcel.obtain();
        obtain.unmarshall(byteArrayExtra, 0, byteArrayExtra.length);
        obtain.setDataPosition(0);
        return SafeParcelReader.readString(obtain, obtain.readInt());
    }

    private static String getUrl(Intent intent) {
        String action = intent.getAction();
        if ("android.intent.action.SEND".equals(action) || "android.intent.action.SEND_MULTIPLE".equals(action) || "android.intent.action.SENDTO".equals(action)) {
            return null;
        }
        String dataString = intent.getDataString();
        if (dataString != null) {
            Log.d(TAG, "Handled intent: action: " + action + " / data: " + dataString);
        }
        return dataString;
    }
}
