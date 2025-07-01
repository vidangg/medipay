package com.pichillilorenzo.flutter_inappwebview_android.credential_database;

import android.content.Context;
import android.webkit.WebViewDatabase;
import com.pichillilorenzo.flutter_inappwebview_android.InAppWebViewFlutterPlugin;
import com.pichillilorenzo.flutter_inappwebview_android.credential_database.URLCredentialContract;
import com.pichillilorenzo.flutter_inappwebview_android.credential_database.URLProtectionSpaceContract;
import com.pichillilorenzo.flutter_inappwebview_android.types.ChannelDelegateImpl;
import com.pichillilorenzo.flutter_inappwebview_android.types.URLCredential;
import com.pichillilorenzo.flutter_inappwebview_android.types.URLProtectionSpace;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: classes4.dex */
public class CredentialDatabaseHandler extends ChannelDelegateImpl {
    protected static final String LOG_TAG = "CredentialDatabaseHandler";
    public static final String METHOD_CHANNEL_NAME = "com.pichillilorenzo/flutter_inappwebview_credential_database";
    public static CredentialDatabase credentialDatabase;
    public InAppWebViewFlutterPlugin plugin;

    public CredentialDatabaseHandler(InAppWebViewFlutterPlugin inAppWebViewFlutterPlugin) {
        super(new MethodChannel(inAppWebViewFlutterPlugin.messenger, METHOD_CHANNEL_NAME));
        this.plugin = inAppWebViewFlutterPlugin;
    }

    public static void init(InAppWebViewFlutterPlugin inAppWebViewFlutterPlugin) {
        if (credentialDatabase == null) {
            credentialDatabase = CredentialDatabase.getInstance(inAppWebViewFlutterPlugin.applicationContext);
        }
    }

    @Override // com.pichillilorenzo.flutter_inappwebview_android.types.ChannelDelegateImpl, com.pichillilorenzo.flutter_inappwebview_android.types.Disposable
    public void dispose() {
        super.dispose();
        this.plugin = null;
        credentialDatabase = null;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:25:0x0065. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v12, types: [java.lang.Boolean] */
    /* JADX WARN: Type inference failed for: r14v13, types: [java.lang.Boolean] */
    /* JADX WARN: Type inference failed for: r14v17, types: [java.util.List, java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r14v5 */
    @Override // com.pichillilorenzo.flutter_inappwebview_android.types.ChannelDelegateImpl, io.flutter.plugin.common.MethodChannel.MethodCallHandler
    public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        Context context;
        Object obj;
        InAppWebViewFlutterPlugin inAppWebViewFlutterPlugin = this.plugin;
        if (inAppWebViewFlutterPlugin != null) {
            init(inAppWebViewFlutterPlugin);
        }
        String str = methodCall.method;
        str.hashCode();
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -1851697792:
                if (str.equals("clearAllAuthCredentials")) {
                    c = 0;
                    break;
                }
                break;
            case -410271914:
                if (str.equals("getHttpAuthCredentials")) {
                    c = 1;
                    break;
                }
                break;
            case 589173355:
                if (str.equals("removeHttpAuthCredential")) {
                    c = 2;
                    break;
                }
                break;
            case 998955721:
                if (str.equals("setHttpAuthCredential")) {
                    c = 3;
                    break;
                }
                break;
            case 1084504936:
                if (str.equals("removeHttpAuthCredentials")) {
                    c = 4;
                    break;
                }
                break;
            case 1930845769:
                if (str.equals("getAllAuthCredentials")) {
                    c = 5;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                CredentialDatabase credentialDatabase2 = credentialDatabase;
                if (credentialDatabase2 != null) {
                    credentialDatabase2.clearAllAuthCredentials();
                    InAppWebViewFlutterPlugin inAppWebViewFlutterPlugin2 = this.plugin;
                    if (inAppWebViewFlutterPlugin2 != null && (context = inAppWebViewFlutterPlugin2.applicationContext) != null) {
                        WebViewDatabase.getInstance(context).clearHttpAuthUsernamePassword();
                    }
                    obj = Boolean.TRUE;
                    result.success(obj);
                    return;
                }
                obj = Boolean.FALSE;
                result.success(obj);
                return;
            case 1:
                ArrayList arrayList = new ArrayList();
                if (credentialDatabase != null) {
                    Iterator<URLCredential> it = credentialDatabase.getHttpAuthCredentials((String) methodCall.argument(URLProtectionSpaceContract.FeedEntry.COLUMN_NAME_HOST), (String) methodCall.argument(URLProtectionSpaceContract.FeedEntry.COLUMN_NAME_PROTOCOL), (String) methodCall.argument(URLProtectionSpaceContract.FeedEntry.COLUMN_NAME_REALM), (Integer) methodCall.argument(URLProtectionSpaceContract.FeedEntry.COLUMN_NAME_PORT)).iterator();
                    while (it.hasNext()) {
                        arrayList.add(it.next().toMap());
                    }
                }
                obj = arrayList;
                result.success(obj);
                return;
            case 2:
                if (credentialDatabase != null) {
                    credentialDatabase.removeHttpAuthCredential((String) methodCall.argument(URLProtectionSpaceContract.FeedEntry.COLUMN_NAME_HOST), (String) methodCall.argument(URLProtectionSpaceContract.FeedEntry.COLUMN_NAME_PROTOCOL), (String) methodCall.argument(URLProtectionSpaceContract.FeedEntry.COLUMN_NAME_REALM), (Integer) methodCall.argument(URLProtectionSpaceContract.FeedEntry.COLUMN_NAME_PORT), (String) methodCall.argument(URLCredentialContract.FeedEntry.COLUMN_NAME_USERNAME), (String) methodCall.argument(URLCredentialContract.FeedEntry.COLUMN_NAME_PASSWORD));
                    obj = Boolean.TRUE;
                    result.success(obj);
                    return;
                }
                obj = Boolean.FALSE;
                result.success(obj);
                return;
            case 3:
                if (credentialDatabase != null) {
                    credentialDatabase.setHttpAuthCredential((String) methodCall.argument(URLProtectionSpaceContract.FeedEntry.COLUMN_NAME_HOST), (String) methodCall.argument(URLProtectionSpaceContract.FeedEntry.COLUMN_NAME_PROTOCOL), (String) methodCall.argument(URLProtectionSpaceContract.FeedEntry.COLUMN_NAME_REALM), (Integer) methodCall.argument(URLProtectionSpaceContract.FeedEntry.COLUMN_NAME_PORT), (String) methodCall.argument(URLCredentialContract.FeedEntry.COLUMN_NAME_USERNAME), (String) methodCall.argument(URLCredentialContract.FeedEntry.COLUMN_NAME_PASSWORD));
                    obj = Boolean.TRUE;
                    result.success(obj);
                    return;
                }
                obj = Boolean.FALSE;
                result.success(obj);
                return;
            case 4:
                if (credentialDatabase != null) {
                    credentialDatabase.removeHttpAuthCredentials((String) methodCall.argument(URLProtectionSpaceContract.FeedEntry.COLUMN_NAME_HOST), (String) methodCall.argument(URLProtectionSpaceContract.FeedEntry.COLUMN_NAME_PROTOCOL), (String) methodCall.argument(URLProtectionSpaceContract.FeedEntry.COLUMN_NAME_REALM), (Integer) methodCall.argument(URLProtectionSpaceContract.FeedEntry.COLUMN_NAME_PORT));
                    obj = Boolean.TRUE;
                    result.success(obj);
                    return;
                }
                obj = Boolean.FALSE;
                result.success(obj);
                return;
            case 5:
                obj = new ArrayList();
                CredentialDatabase credentialDatabase3 = credentialDatabase;
                if (credentialDatabase3 != null) {
                    for (URLProtectionSpace uRLProtectionSpace : credentialDatabase3.protectionSpaceDao.getAll()) {
                        ArrayList arrayList2 = new ArrayList();
                        Iterator<URLCredential> it2 = credentialDatabase.credentialDao.getAllByProtectionSpaceId(uRLProtectionSpace.getId()).iterator();
                        while (it2.hasNext()) {
                            arrayList2.add(it2.next().toMap());
                        }
                        HashMap hashMap = new HashMap();
                        hashMap.put("protectionSpace", uRLProtectionSpace.toMap());
                        hashMap.put("credentials", arrayList2);
                        obj.add(hashMap);
                    }
                }
                result.success(obj);
                return;
            default:
                result.notImplemented();
                return;
        }
    }
}
