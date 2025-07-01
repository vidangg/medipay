package io.flutter.plugins.sharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.preference.PreferenceManager;
import com.tekartik.sqflite.Constant;
import io.flutter.plugin.common.BinaryMessenger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: SharedPreferencesPlugin.kt */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ \u0010\t\u001a\u00020\n2\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J,\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00140\u00132\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u001f\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016¢\u0006\u0002\u0010\u0018J\u001f\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u0017\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016¢\u0006\u0002\u0010\u001bJ\u001f\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u0017\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016¢\u0006\u0002\u0010\u001eJ&\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J \u0010 \u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f2\u0006\u0010\u0017\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u001a\u0010!\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0017\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u001a\u0010\"\u001a\u0004\u0018\u00010#2\u0006\u0010\u0017\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J \u0010$\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\r2\u0006\u0010%\u001a\u00020\u00162\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J&\u0010&\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\r2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0017J \u0010'\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\r2\u0006\u0010%\u001a\u00020\u001a2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J \u0010(\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\r2\u0006\u0010%\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J \u0010)\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\r2\u0006\u0010%\u001a\u00020\u001d2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J \u0010*\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\r2\u0006\u0010%\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0006\u0010+\u001a\u00020\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Lio/flutter/plugins/sharedpreferences/SharedPreferencesBackend;", "Lio/flutter/plugins/sharedpreferences/SharedPreferencesAsyncApi;", "messenger", "Lio/flutter/plugin/common/BinaryMessenger;", "context", "Landroid/content/Context;", "listEncoder", "Lio/flutter/plugins/sharedpreferences/SharedPreferencesListEncoder;", "(Lio/flutter/plugin/common/BinaryMessenger;Landroid/content/Context;Lio/flutter/plugins/sharedpreferences/SharedPreferencesListEncoder;)V", "clear", "", "allowList", "", "", Constant.METHOD_OPTIONS, "Lio/flutter/plugins/sharedpreferences/SharedPreferencesPigeonOptions;", "createSharedPreferences", "Landroid/content/SharedPreferences;", "getAll", "", "", "getBool", "", "key", "(Ljava/lang/String;Lio/flutter/plugins/sharedpreferences/SharedPreferencesPigeonOptions;)Ljava/lang/Boolean;", "getDouble", "", "(Ljava/lang/String;Lio/flutter/plugins/sharedpreferences/SharedPreferencesPigeonOptions;)Ljava/lang/Double;", "getInt", "", "(Ljava/lang/String;Lio/flutter/plugins/sharedpreferences/SharedPreferencesPigeonOptions;)Ljava/lang/Long;", "getKeys", "getPlatformEncodedStringList", "getString", "getStringList", "Lio/flutter/plugins/sharedpreferences/StringListResult;", "setBool", "value", "setDeprecatedStringList", "setDouble", "setEncodedStringList", "setInt", "setString", "tearDown", "shared_preferences_android_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes4.dex */
public final class SharedPreferencesBackend implements SharedPreferencesAsyncApi {
    private Context context;
    private SharedPreferencesListEncoder listEncoder;
    private BinaryMessenger messenger;

    public SharedPreferencesBackend(BinaryMessenger messenger, Context context, SharedPreferencesListEncoder listEncoder) {
        Intrinsics.checkNotNullParameter(messenger, "messenger");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(listEncoder, "listEncoder");
        this.messenger = messenger;
        this.context = context;
        this.listEncoder = listEncoder;
        try {
            SharedPreferencesAsyncApi.INSTANCE.setUp(this.messenger, this, "shared_preferences");
        } catch (Exception e) {
            Log.e(SharedPreferencesPluginKt.TAG, "Received exception while setting up SharedPreferencesBackend", e);
        }
    }

    public /* synthetic */ SharedPreferencesBackend(BinaryMessenger binaryMessenger, Context context, ListEncoder listEncoder, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(binaryMessenger, context, (i & 4) != 0 ? new ListEncoder() : listEncoder);
    }

    public final void tearDown() {
        SharedPreferencesAsyncApi.INSTANCE.setUp(this.messenger, null, "shared_preferences");
    }

    private final SharedPreferences createSharedPreferences(SharedPreferencesPigeonOptions options) {
        if (options.getFileName() == null) {
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.context);
            Intrinsics.checkNotNull(defaultSharedPreferences);
            return defaultSharedPreferences;
        }
        SharedPreferences sharedPreferences = this.context.getSharedPreferences(options.getFileName(), 0);
        Intrinsics.checkNotNull(sharedPreferences);
        return sharedPreferences;
    }

    @Override // io.flutter.plugins.sharedpreferences.SharedPreferencesAsyncApi
    public void setBool(String key, boolean value, SharedPreferencesPigeonOptions options) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(options, "options");
        createSharedPreferences(options).edit().putBoolean(key, value).apply();
    }

    @Override // io.flutter.plugins.sharedpreferences.SharedPreferencesAsyncApi
    public void setString(String key, String value, SharedPreferencesPigeonOptions options) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(options, "options");
        createSharedPreferences(options).edit().putString(key, value).apply();
    }

    @Override // io.flutter.plugins.sharedpreferences.SharedPreferencesAsyncApi
    public void setInt(String key, long value, SharedPreferencesPigeonOptions options) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(options, "options");
        createSharedPreferences(options).edit().putLong(key, value).apply();
    }

    @Override // io.flutter.plugins.sharedpreferences.SharedPreferencesAsyncApi
    public void setDouble(String key, double value, SharedPreferencesPigeonOptions options) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(options, "options");
        createSharedPreferences(options).edit().putString(key, SharedPreferencesPluginKt.DOUBLE_PREFIX + value).apply();
    }

    @Override // io.flutter.plugins.sharedpreferences.SharedPreferencesAsyncApi
    public void setEncodedStringList(String key, String value, SharedPreferencesPigeonOptions options) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(options, "options");
        createSharedPreferences(options).edit().putString(key, value).apply();
    }

    @Override // io.flutter.plugins.sharedpreferences.SharedPreferencesAsyncApi
    @Deprecated(message = "This is just for testing, use `setEncodedStringList`")
    public void setDeprecatedStringList(String key, List<String> value, SharedPreferencesPigeonOptions options) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(options, "options");
        createSharedPreferences(options).edit().putString(key, SharedPreferencesPluginKt.LIST_PREFIX + this.listEncoder.encode(value)).apply();
    }

    @Override // io.flutter.plugins.sharedpreferences.SharedPreferencesAsyncApi
    public void clear(List<String> allowList, SharedPreferencesPigeonOptions options) {
        Intrinsics.checkNotNullParameter(options, "options");
        SharedPreferences createSharedPreferences = createSharedPreferences(options);
        SharedPreferences.Editor edit = createSharedPreferences.edit();
        Intrinsics.checkNotNullExpressionValue(edit, "edit(...)");
        Map<String, ?> all = createSharedPreferences.getAll();
        Intrinsics.checkNotNullExpressionValue(all, "getAll(...)");
        ArrayList arrayList = new ArrayList();
        for (String str : all.keySet()) {
            if (SharedPreferencesPluginKt.preferencesFilter(str, all.get(str), allowList != null ? CollectionsKt.toSet(allowList) : null)) {
                arrayList.add(str);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            edit.remove((String) it.next());
        }
        edit.apply();
    }

    @Override // io.flutter.plugins.sharedpreferences.SharedPreferencesAsyncApi
    public Map<String, Object> getAll(List<String> allowList, SharedPreferencesPigeonOptions options) {
        Object value;
        Intrinsics.checkNotNullParameter(options, "options");
        Map<String, ?> all = createSharedPreferences(options).getAll();
        Intrinsics.checkNotNullExpressionValue(all, "getAll(...)");
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, ?> entry : all.entrySet()) {
            if (SharedPreferencesPluginKt.preferencesFilter(entry.getKey(), entry.getValue(), allowList != null ? CollectionsKt.toSet(allowList) : null) && (value = entry.getValue()) != null) {
                String key = entry.getKey();
                Object transformPref = SharedPreferencesPluginKt.transformPref(value, this.listEncoder);
                Intrinsics.checkNotNull(transformPref, "null cannot be cast to non-null type kotlin.Any");
                hashMap.put(key, transformPref);
            }
        }
        return hashMap;
    }

    @Override // io.flutter.plugins.sharedpreferences.SharedPreferencesAsyncApi
    public Long getInt(String key, SharedPreferencesPigeonOptions options) {
        long j;
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(options, "options");
        SharedPreferences createSharedPreferences = createSharedPreferences(options);
        if (!createSharedPreferences.contains(key)) {
            return null;
        }
        try {
            j = createSharedPreferences.getLong(key, 0L);
        } catch (ClassCastException unused) {
            j = createSharedPreferences.getInt(key, 0);
        }
        return Long.valueOf(j);
    }

    @Override // io.flutter.plugins.sharedpreferences.SharedPreferencesAsyncApi
    public Boolean getBool(String key, SharedPreferencesPigeonOptions options) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(options, "options");
        SharedPreferences createSharedPreferences = createSharedPreferences(options);
        if (createSharedPreferences.contains(key)) {
            return Boolean.valueOf(createSharedPreferences.getBoolean(key, true));
        }
        return null;
    }

    @Override // io.flutter.plugins.sharedpreferences.SharedPreferencesAsyncApi
    public Double getDouble(String key, SharedPreferencesPigeonOptions options) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(options, "options");
        SharedPreferences createSharedPreferences = createSharedPreferences(options);
        if (!createSharedPreferences.contains(key)) {
            return null;
        }
        Object transformPref = SharedPreferencesPluginKt.transformPref(createSharedPreferences.getString(key, ""), this.listEncoder);
        Intrinsics.checkNotNull(transformPref, "null cannot be cast to non-null type kotlin.Double");
        return (Double) transformPref;
    }

    @Override // io.flutter.plugins.sharedpreferences.SharedPreferencesAsyncApi
    public String getString(String key, SharedPreferencesPigeonOptions options) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(options, "options");
        SharedPreferences createSharedPreferences = createSharedPreferences(options);
        if (createSharedPreferences.contains(key)) {
            return createSharedPreferences.getString(key, "");
        }
        return null;
    }

    @Override // io.flutter.plugins.sharedpreferences.SharedPreferencesAsyncApi
    public StringListResult getStringList(String key, SharedPreferencesPigeonOptions options) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(options, "options");
        SharedPreferences createSharedPreferences = createSharedPreferences(options);
        if (!createSharedPreferences.contains(key)) {
            return null;
        }
        String string = createSharedPreferences.getString(key, "");
        Intrinsics.checkNotNull(string);
        if (StringsKt.startsWith$default(string, SharedPreferencesPluginKt.JSON_LIST_PREFIX, false, 2, (Object) null)) {
            return new StringListResult(string, StringListLookupResultType.JSON_ENCODED);
        }
        if (StringsKt.startsWith$default(string, SharedPreferencesPluginKt.LIST_PREFIX, false, 2, (Object) null)) {
            return new StringListResult(null, StringListLookupResultType.PLATFORM_ENCODED);
        }
        return new StringListResult(null, StringListLookupResultType.UNEXPECTED_STRING);
    }

    @Override // io.flutter.plugins.sharedpreferences.SharedPreferencesAsyncApi
    public List<String> getPlatformEncodedStringList(String key, SharedPreferencesPigeonOptions options) {
        List list;
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(options, "options");
        SharedPreferences createSharedPreferences = createSharedPreferences(options);
        if (!createSharedPreferences.contains(key)) {
            return null;
        }
        String string = createSharedPreferences.getString(key, "");
        Intrinsics.checkNotNull(string);
        if (!StringsKt.startsWith$default(string, SharedPreferencesPluginKt.LIST_PREFIX, false, 2, (Object) null) || StringsKt.startsWith$default(string, SharedPreferencesPluginKt.JSON_LIST_PREFIX, false, 2, (Object) null) || (list = (List) SharedPreferencesPluginKt.transformPref(createSharedPreferences.getString(key, ""), this.listEncoder)) == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (obj instanceof String) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    @Override // io.flutter.plugins.sharedpreferences.SharedPreferencesAsyncApi
    public List<String> getKeys(List<String> allowList, SharedPreferencesPigeonOptions options) {
        Intrinsics.checkNotNullParameter(options, "options");
        Map<String, ?> all = createSharedPreferences(options).getAll();
        Intrinsics.checkNotNullExpressionValue(all, "getAll(...)");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, ?> entry : all.entrySet()) {
            String key = entry.getKey();
            Intrinsics.checkNotNullExpressionValue(key, "<get-key>(...)");
            if (SharedPreferencesPluginKt.preferencesFilter(key, entry.getValue(), allowList != null ? CollectionsKt.toSet(allowList) : null)) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return CollectionsKt.toList(linkedHashMap.keySet());
    }
}
