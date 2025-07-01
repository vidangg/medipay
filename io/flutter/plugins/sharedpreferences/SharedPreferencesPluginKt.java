package io.flutter.plugins.sharedpreferences;

import android.content.Context;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.datastore.core.DataStore;
import androidx.datastore.preferences.PreferenceDataStoreDelegateKt;
import androidx.datastore.preferences.core.Preferences;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;

/* compiled from: SharedPreferencesPlugin.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a*\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00012\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0014H\u0000\u001a\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0016\u001a\u00020\u0017H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"%\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007*\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000b¨\u0006\u0018"}, d2 = {"DOUBLE_PREFIX", "", "JSON_LIST_PREFIX", "LIST_PREFIX", "SHARED_PREFERENCES_NAME", "TAG", "sharedPreferencesDataStore", "Landroidx/datastore/core/DataStore;", "Landroidx/datastore/preferences/core/Preferences;", "Landroid/content/Context;", "getSharedPreferencesDataStore", "(Landroid/content/Context;)Landroidx/datastore/core/DataStore;", "sharedPreferencesDataStore$delegate", "Lkotlin/properties/ReadOnlyProperty;", "preferencesFilter", "", "key", "value", "", "allowList", "", "transformPref", "listEncoder", "Lio/flutter/plugins/sharedpreferences/SharedPreferencesListEncoder;", "shared_preferences_android_release"}, k = 2, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes4.dex */
public final class SharedPreferencesPluginKt {
    public static final String DOUBLE_PREFIX = "VGhpcyBpcyB0aGUgcHJlZml4IGZvciBEb3VibGUu";
    public static final String JSON_LIST_PREFIX = "VGhpcyBpcyB0aGUgcHJlZml4IGZvciBhIGxpc3Qu!";
    public static final String LIST_PREFIX = "VGhpcyBpcyB0aGUgcHJlZml4IGZvciBhIGxpc3Qu";
    public static final String TAG = "SharedPreferencesPlugin";
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(SharedPreferencesPluginKt.class, "sharedPreferencesDataStore", "getSharedPreferencesDataStore(Landroid/content/Context;)Landroidx/datastore/core/DataStore;", 1))};
    public static final String SHARED_PREFERENCES_NAME = "FlutterSharedPreferences";
    private static final ReadOnlyProperty sharedPreferencesDataStore$delegate = PreferenceDataStoreDelegateKt.preferencesDataStore$default(SHARED_PREFERENCES_NAME, null, null, null, 14, null);

    /* JADX INFO: Access modifiers changed from: private */
    public static final DataStore<Preferences> getSharedPreferencesDataStore(Context context) {
        return (DataStore) sharedPreferencesDataStore$delegate.getValue(context, $$delegatedProperties[0]);
    }

    public static final boolean preferencesFilter(String key, Object obj, Set<String> set) {
        Intrinsics.checkNotNullParameter(key, "key");
        if (set == null) {
            return (obj instanceof Boolean) || (obj instanceof Long) || (obj instanceof String) || (obj instanceof Double);
        }
        return set.contains(key);
    }

    public static final Object transformPref(Object obj, SharedPreferencesListEncoder listEncoder) {
        Intrinsics.checkNotNullParameter(listEncoder, "listEncoder");
        if (!(obj instanceof String)) {
            return obj;
        }
        String str = (String) obj;
        if (StringsKt.startsWith$default(str, LIST_PREFIX, false, 2, (Object) null)) {
            if (StringsKt.startsWith$default(str, JSON_LIST_PREFIX, false, 2, (Object) null)) {
                return obj;
            }
            String substring = str.substring(40);
            Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
            List<String> decode = listEncoder.decode(substring);
            Intrinsics.checkNotNull(decode);
            return decode;
        }
        if (!StringsKt.startsWith$default(str, DOUBLE_PREFIX, false, 2, (Object) null)) {
            return obj;
        }
        String substring2 = str.substring(40);
        Intrinsics.checkNotNullExpressionValue(substring2, "substring(...)");
        return Double.valueOf(Double.parseDouble(substring2));
    }
}
