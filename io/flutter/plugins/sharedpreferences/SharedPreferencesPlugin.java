package io.flutter.plugins.sharedpreferences;

import android.content.Context;
import android.util.Log;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.datastore.core.DataStore;
import androidx.datastore.preferences.core.Preferences;
import androidx.datastore.preferences.core.PreferencesKeys;
import androidx.datastore.preferences.core.PreferencesKt;
import androidx.exifinterface.media.ExifInterface;
import com.tekartik.sqflite.Constant;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugins.sharedpreferences.SharedPreferencesAsyncApi;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

/* compiled from: SharedPreferencesPlugin.kt */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\b\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0005¢\u0006\u0002\u0010\u0006J \u0010\u000b\u001a\u00020\f2\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J!\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u000fH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0015J,\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00180\u00172\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u001f\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016¢\u0006\u0002\u0010\u001bJ\u001f\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016¢\u0006\u0002\u0010\u001eJ\u001f\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016¢\u0006\u0002\u0010!J&\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J \u0010#\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e2\u0006\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J-\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00180\u00172\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010%J\u001a\u0010&\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u001a\u0010'\u001a\u0004\u0018\u00010(2\u0006\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u001f\u0010)\u001a\u0004\u0018\u00010\u00182\n\u0010\u0013\u001a\u0006\u0012\u0002\b\u00030*H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010+J\u0010\u0010,\u001a\u00020\f2\u0006\u0010-\u001a\u00020.H\u0016J\u0010\u0010/\u001a\u00020\f2\u0006\u0010-\u001a\u00020.H\u0016J\u001d\u00100\u001a\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030*\u0018\u000101H\u0082@ø\u0001\u0000¢\u0006\u0002\u00102J \u00103\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u001a2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J&\u00104\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u000f2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H\u0017J \u00105\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u001d2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J \u00106\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J \u00107\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020 2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J \u00108\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0018\u00109\u001a\u00020\f2\u0006\u0010:\u001a\u00020;2\u0006\u0010\t\u001a\u00020\nH\u0002R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006<"}, d2 = {"Lio/flutter/plugins/sharedpreferences/SharedPreferencesPlugin;", "Lio/flutter/embedding/engine/plugins/FlutterPlugin;", "Lio/flutter/plugins/sharedpreferences/SharedPreferencesAsyncApi;", "listEncoder", "Lio/flutter/plugins/sharedpreferences/SharedPreferencesListEncoder;", "(Lio/flutter/plugins/sharedpreferences/SharedPreferencesListEncoder;)V", "()V", "backend", "Lio/flutter/plugins/sharedpreferences/SharedPreferencesBackend;", "context", "Landroid/content/Context;", "clear", "", "allowList", "", "", Constant.METHOD_OPTIONS, "Lio/flutter/plugins/sharedpreferences/SharedPreferencesPigeonOptions;", "dataStoreSetString", "key", "value", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAll", "", "", "getBool", "", "(Ljava/lang/String;Lio/flutter/plugins/sharedpreferences/SharedPreferencesPigeonOptions;)Ljava/lang/Boolean;", "getDouble", "", "(Ljava/lang/String;Lio/flutter/plugins/sharedpreferences/SharedPreferencesPigeonOptions;)Ljava/lang/Double;", "getInt", "", "(Ljava/lang/String;Lio/flutter/plugins/sharedpreferences/SharedPreferencesPigeonOptions;)Ljava/lang/Long;", "getKeys", "getPlatformEncodedStringList", "getPrefs", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getString", "getStringList", "Lio/flutter/plugins/sharedpreferences/StringListResult;", "getValueByKey", "Landroidx/datastore/preferences/core/Preferences$Key;", "(Landroidx/datastore/preferences/core/Preferences$Key;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onAttachedToEngine", "binding", "Lio/flutter/embedding/engine/plugins/FlutterPlugin$FlutterPluginBinding;", "onDetachedFromEngine", "readAllKeys", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setBool", "setDeprecatedStringList", "setDouble", "setEncodedStringList", "setInt", "setString", "setUp", "messenger", "Lio/flutter/plugin/common/BinaryMessenger;", "shared_preferences_android_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes4.dex */
public final class SharedPreferencesPlugin implements FlutterPlugin, SharedPreferencesAsyncApi {
    private SharedPreferencesBackend backend;
    private Context context;
    private SharedPreferencesListEncoder listEncoder;

    public SharedPreferencesPlugin() {
        this.listEncoder = new ListEncoder();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SharedPreferencesPlugin(SharedPreferencesListEncoder listEncoder) {
        this();
        Intrinsics.checkNotNullParameter(listEncoder, "listEncoder");
        this.listEncoder = listEncoder;
    }

    private final void setUp(BinaryMessenger messenger, Context context) {
        this.context = context;
        try {
            SharedPreferencesAsyncApi.INSTANCE.setUp(messenger, this, "data_store");
            this.backend = new SharedPreferencesBackend(messenger, context, this.listEncoder);
        } catch (Exception e) {
            Log.e(SharedPreferencesPluginKt.TAG, "Received exception while setting up SharedPreferencesPlugin", e);
        }
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding binding) {
        Intrinsics.checkNotNullParameter(binding, "binding");
        BinaryMessenger binaryMessenger = binding.getBinaryMessenger();
        Intrinsics.checkNotNullExpressionValue(binaryMessenger, "getBinaryMessenger(...)");
        Context applicationContext = binding.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        setUp(binaryMessenger, applicationContext);
        new LegacySharedPreferencesPlugin().onAttachedToEngine(binding);
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding binding) {
        Intrinsics.checkNotNullParameter(binding, "binding");
        SharedPreferencesAsyncApi.Companion companion = SharedPreferencesAsyncApi.INSTANCE;
        BinaryMessenger binaryMessenger = binding.getBinaryMessenger();
        Intrinsics.checkNotNullExpressionValue(binaryMessenger, "getBinaryMessenger(...)");
        companion.setUp(binaryMessenger, null, "data_store");
        SharedPreferencesBackend sharedPreferencesBackend = this.backend;
        if (sharedPreferencesBackend != null) {
            sharedPreferencesBackend.tearDown();
        }
        this.backend = null;
    }

    @Override // io.flutter.plugins.sharedpreferences.SharedPreferencesAsyncApi
    public void setBool(String key, boolean value, SharedPreferencesPigeonOptions options) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(options, "options");
        BuildersKt__BuildersKt.runBlocking$default(null, new SharedPreferencesPlugin$setBool$1(key, this, value, null), 1, null);
    }

    @Override // io.flutter.plugins.sharedpreferences.SharedPreferencesAsyncApi
    public void setString(String key, String value, SharedPreferencesPigeonOptions options) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(options, "options");
        BuildersKt__BuildersKt.runBlocking$default(null, new SharedPreferencesPlugin$setString$1(this, key, value, null), 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object dataStoreSetString(String str, String str2, Continuation<? super Unit> continuation) {
        DataStore sharedPreferencesDataStore;
        Preferences.Key<String> stringKey = PreferencesKeys.stringKey(str);
        Context context = this.context;
        if (context == null) {
            Intrinsics.throwUninitializedPropertyAccessException("context");
            context = null;
        }
        sharedPreferencesDataStore = SharedPreferencesPluginKt.getSharedPreferencesDataStore(context);
        Object edit = PreferencesKt.edit(sharedPreferencesDataStore, new SharedPreferencesPlugin$dataStoreSetString$2(stringKey, str2, null), continuation);
        return edit == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? edit : Unit.INSTANCE;
    }

    @Override // io.flutter.plugins.sharedpreferences.SharedPreferencesAsyncApi
    public void setInt(String key, long value, SharedPreferencesPigeonOptions options) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(options, "options");
        BuildersKt__BuildersKt.runBlocking$default(null, new SharedPreferencesPlugin$setInt$1(key, this, value, null), 1, null);
    }

    @Override // io.flutter.plugins.sharedpreferences.SharedPreferencesAsyncApi
    public void setDouble(String key, double value, SharedPreferencesPigeonOptions options) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(options, "options");
        BuildersKt__BuildersKt.runBlocking$default(null, new SharedPreferencesPlugin$setDouble$1(key, this, value, null), 1, null);
    }

    @Override // io.flutter.plugins.sharedpreferences.SharedPreferencesAsyncApi
    public void setEncodedStringList(String key, String value, SharedPreferencesPigeonOptions options) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(options, "options");
        BuildersKt__BuildersKt.runBlocking$default(null, new SharedPreferencesPlugin$setEncodedStringList$1(this, key, value, null), 1, null);
    }

    @Override // io.flutter.plugins.sharedpreferences.SharedPreferencesAsyncApi
    @Deprecated(message = "This is just for testing, use `setEncodedStringList`")
    public void setDeprecatedStringList(String key, List<String> value, SharedPreferencesPigeonOptions options) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(options, "options");
        BuildersKt__BuildersKt.runBlocking$default(null, new SharedPreferencesPlugin$setDeprecatedStringList$1(this, key, SharedPreferencesPluginKt.LIST_PREFIX + this.listEncoder.encode(value), null), 1, null);
    }

    @Override // io.flutter.plugins.sharedpreferences.SharedPreferencesAsyncApi
    public void clear(List<String> allowList, SharedPreferencesPigeonOptions options) {
        Intrinsics.checkNotNullParameter(options, "options");
        BuildersKt__BuildersKt.runBlocking$default(null, new SharedPreferencesPlugin$clear$1(this, allowList, null), 1, null);
    }

    @Override // io.flutter.plugins.sharedpreferences.SharedPreferencesAsyncApi
    public Map<String, Object> getAll(List<String> allowList, SharedPreferencesPigeonOptions options) {
        Object runBlocking$default;
        Intrinsics.checkNotNullParameter(options, "options");
        runBlocking$default = BuildersKt__BuildersKt.runBlocking$default(null, new SharedPreferencesPlugin$getAll$1(this, allowList, null), 1, null);
        return (Map) runBlocking$default;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.flutter.plugins.sharedpreferences.SharedPreferencesAsyncApi
    public Long getInt(String key, SharedPreferencesPigeonOptions options) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(options, "options");
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        BuildersKt__BuildersKt.runBlocking$default(null, new SharedPreferencesPlugin$getInt$1(key, this, objectRef, null), 1, null);
        return (Long) objectRef.element;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.flutter.plugins.sharedpreferences.SharedPreferencesAsyncApi
    public Boolean getBool(String key, SharedPreferencesPigeonOptions options) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(options, "options");
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        BuildersKt__BuildersKt.runBlocking$default(null, new SharedPreferencesPlugin$getBool$1(key, this, objectRef, null), 1, null);
        return (Boolean) objectRef.element;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.flutter.plugins.sharedpreferences.SharedPreferencesAsyncApi
    public Double getDouble(String key, SharedPreferencesPigeonOptions options) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(options, "options");
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        BuildersKt__BuildersKt.runBlocking$default(null, new SharedPreferencesPlugin$getDouble$1(key, this, objectRef, null), 1, null);
        return (Double) objectRef.element;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.flutter.plugins.sharedpreferences.SharedPreferencesAsyncApi
    public String getString(String key, SharedPreferencesPigeonOptions options) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(options, "options");
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        BuildersKt__BuildersKt.runBlocking$default(null, new SharedPreferencesPlugin$getString$1(key, this, objectRef, null), 1, null);
        return (String) objectRef.element;
    }

    @Override // io.flutter.plugins.sharedpreferences.SharedPreferencesAsyncApi
    public StringListResult getStringList(String key, SharedPreferencesPigeonOptions options) {
        StringListResult stringListResult;
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(options, "options");
        String string = getString(key, options);
        if (string == null) {
            return null;
        }
        if (StringsKt.startsWith$default(string, SharedPreferencesPluginKt.JSON_LIST_PREFIX, false, 2, (Object) null)) {
            return new StringListResult(string, StringListLookupResultType.JSON_ENCODED);
        }
        if (StringsKt.startsWith$default(string, SharedPreferencesPluginKt.LIST_PREFIX, false, 2, (Object) null)) {
            stringListResult = new StringListResult(null, StringListLookupResultType.PLATFORM_ENCODED);
        } else {
            stringListResult = new StringListResult(null, StringListLookupResultType.UNEXPECTED_STRING);
        }
        return stringListResult;
    }

    @Override // io.flutter.plugins.sharedpreferences.SharedPreferencesAsyncApi
    public List<String> getPlatformEncodedStringList(String key, SharedPreferencesPigeonOptions options) {
        List list;
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(options, "options");
        String string = getString(key, options);
        if (string == null || StringsKt.startsWith$default(string, SharedPreferencesPluginKt.JSON_LIST_PREFIX, false, 2, (Object) null) || !StringsKt.startsWith$default(string, SharedPreferencesPluginKt.LIST_PREFIX, false, 2, (Object) null) || (list = (List) SharedPreferencesPluginKt.transformPref(string, this.listEncoder)) == null) {
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
        Object runBlocking$default;
        Intrinsics.checkNotNullParameter(options, "options");
        runBlocking$default = BuildersKt__BuildersKt.runBlocking$default(null, new SharedPreferencesPlugin$getKeys$prefs$1(this, allowList, null), 1, null);
        return CollectionsKt.toList(((Map) runBlocking$default).keySet());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x00a9 -> B:11:0x00ac). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object getPrefs(List<String> list, Continuation<? super Map<String, ? extends Object>> continuation) {
        SharedPreferencesPlugin$getPrefs$1 sharedPreferencesPlugin$getPrefs$1;
        int i;
        Set set;
        LinkedHashMap linkedHashMap;
        SharedPreferencesPlugin sharedPreferencesPlugin;
        Set set2;
        Set set3;
        SharedPreferencesPlugin sharedPreferencesPlugin2;
        Map map;
        Iterator it;
        Object transformPref;
        if (continuation instanceof SharedPreferencesPlugin$getPrefs$1) {
            sharedPreferencesPlugin$getPrefs$1 = (SharedPreferencesPlugin$getPrefs$1) continuation;
            if ((sharedPreferencesPlugin$getPrefs$1.label & Integer.MIN_VALUE) != 0) {
                sharedPreferencesPlugin$getPrefs$1.label -= Integer.MIN_VALUE;
                Object obj = sharedPreferencesPlugin$getPrefs$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = sharedPreferencesPlugin$getPrefs$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    set = list != null ? CollectionsKt.toSet(list) : null;
                    linkedHashMap = new LinkedHashMap();
                    sharedPreferencesPlugin$getPrefs$1.L$0 = this;
                    sharedPreferencesPlugin$getPrefs$1.L$1 = set;
                    sharedPreferencesPlugin$getPrefs$1.L$2 = linkedHashMap;
                    sharedPreferencesPlugin$getPrefs$1.label = 1;
                    obj = readAllKeys(sharedPreferencesPlugin$getPrefs$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    sharedPreferencesPlugin = this;
                } else if (i == 1) {
                    linkedHashMap = (Map) sharedPreferencesPlugin$getPrefs$1.L$2;
                    set = (Set) sharedPreferencesPlugin$getPrefs$1.L$1;
                    sharedPreferencesPlugin = (SharedPreferencesPlugin) sharedPreferencesPlugin$getPrefs$1.L$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    Preferences.Key<?> key = (Preferences.Key) sharedPreferencesPlugin$getPrefs$1.L$4;
                    it = (Iterator) sharedPreferencesPlugin$getPrefs$1.L$3;
                    map = (Map) sharedPreferencesPlugin$getPrefs$1.L$2;
                    set3 = (Set) sharedPreferencesPlugin$getPrefs$1.L$1;
                    sharedPreferencesPlugin2 = (SharedPreferencesPlugin) sharedPreferencesPlugin$getPrefs$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    if (SharedPreferencesPluginKt.preferencesFilter(key.toString(), obj, set3) && (transformPref = SharedPreferencesPluginKt.transformPref(obj, sharedPreferencesPlugin2.listEncoder)) != null) {
                        map.put(key.toString(), transformPref);
                    }
                    if (it.hasNext()) {
                        key = (Preferences.Key) it.next();
                        sharedPreferencesPlugin$getPrefs$1.L$0 = sharedPreferencesPlugin2;
                        sharedPreferencesPlugin$getPrefs$1.L$1 = set3;
                        sharedPreferencesPlugin$getPrefs$1.L$2 = map;
                        sharedPreferencesPlugin$getPrefs$1.L$3 = it;
                        sharedPreferencesPlugin$getPrefs$1.L$4 = key;
                        sharedPreferencesPlugin$getPrefs$1.label = 2;
                        obj = sharedPreferencesPlugin2.getValueByKey(key, sharedPreferencesPlugin$getPrefs$1);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        if (SharedPreferencesPluginKt.preferencesFilter(key.toString(), obj, set3)) {
                            map.put(key.toString(), transformPref);
                        }
                        if (it.hasNext()) {
                            return map;
                        }
                    }
                }
                set2 = (Set) obj;
                if (set2 != null) {
                    return linkedHashMap;
                }
                set3 = set;
                sharedPreferencesPlugin2 = sharedPreferencesPlugin;
                map = linkedHashMap;
                it = set2.iterator();
                if (it.hasNext()) {
                }
            }
        }
        sharedPreferencesPlugin$getPrefs$1 = new SharedPreferencesPlugin$getPrefs$1(this, continuation);
        Object obj2 = sharedPreferencesPlugin$getPrefs$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = sharedPreferencesPlugin$getPrefs$1.label;
        if (i != 0) {
        }
        set2 = (Set) obj2;
        if (set2 != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object readAllKeys(Continuation<? super Set<? extends Preferences.Key<?>>> continuation) {
        DataStore sharedPreferencesDataStore;
        Context context = this.context;
        if (context == null) {
            Intrinsics.throwUninitializedPropertyAccessException("context");
            context = null;
        }
        sharedPreferencesDataStore = SharedPreferencesPluginKt.getSharedPreferencesDataStore(context);
        final Flow data = sharedPreferencesDataStore.getData();
        return FlowKt.firstOrNull(new Flow<Set<? extends Preferences.Key<?>>>() { // from class: io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$readAllKeys$$inlined$map$1

            /* compiled from: Emitters.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
            /* renamed from: io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$readAllKeys$$inlined$map$1$2, reason: invalid class name */
            /* loaded from: classes4.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* compiled from: Emitters.kt */
                @Metadata(k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
                @DebugMetadata(c = "io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$readAllKeys$$inlined$map$1$2", f = "SharedPreferencesPlugin.kt", i = {}, l = {223}, m = "emit", n = {}, s = {})
                /* renamed from: io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$readAllKeys$$inlined$map$1$2$1, reason: invalid class name */
                /* loaded from: classes4.dex */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    Object L$0;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector) {
                    this.$this_unsafeFlow = flowCollector;
                }

                /* JADX WARN: Removed duplicated region for block: B:15:0x0032  */
                /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final Object emit(Object obj, Continuation continuation) {
                    AnonymousClass1 anonymousClass1;
                    int i;
                    if (continuation instanceof AnonymousClass1) {
                        anonymousClass1 = (AnonymousClass1) continuation;
                        if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                            anonymousClass1.label -= Integer.MIN_VALUE;
                            Object obj2 = anonymousClass1.result;
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            i = anonymousClass1.label;
                            if (i != 0) {
                                ResultKt.throwOnFailure(obj2);
                                FlowCollector flowCollector = this.$this_unsafeFlow;
                                Set<Preferences.Key<?>> keySet = ((Preferences) obj).asMap().keySet();
                                anonymousClass1.label = 1;
                                if (flowCollector.emit(keySet, anonymousClass1) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            } else {
                                if (i != 1) {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                ResultKt.throwOnFailure(obj2);
                            }
                            return Unit.INSTANCE;
                        }
                    }
                    anonymousClass1 = new AnonymousClass1(continuation);
                    Object obj22 = anonymousClass1.result;
                    Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = anonymousClass1.label;
                    if (i != 0) {
                    }
                    return Unit.INSTANCE;
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super Set<? extends Preferences.Key<?>>> flowCollector, Continuation continuation2) {
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector), continuation2);
                return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
            }
        }, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object getValueByKey(final Preferences.Key<?> key, Continuation<Object> continuation) {
        DataStore sharedPreferencesDataStore;
        Context context = this.context;
        if (context == null) {
            Intrinsics.throwUninitializedPropertyAccessException("context");
            context = null;
        }
        sharedPreferencesDataStore = SharedPreferencesPluginKt.getSharedPreferencesDataStore(context);
        final Flow data = sharedPreferencesDataStore.getData();
        return FlowKt.firstOrNull(new Flow<Object>() { // from class: io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$getValueByKey$$inlined$map$1

            /* compiled from: Emitters.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
            /* renamed from: io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$getValueByKey$$inlined$map$1$2, reason: invalid class name */
            /* loaded from: classes4.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ Preferences.Key $key$inlined;
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* compiled from: Emitters.kt */
                @Metadata(k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
                @DebugMetadata(c = "io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$getValueByKey$$inlined$map$1$2", f = "SharedPreferencesPlugin.kt", i = {}, l = {223}, m = "emit", n = {}, s = {})
                /* renamed from: io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$getValueByKey$$inlined$map$1$2$1, reason: invalid class name */
                /* loaded from: classes4.dex */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    Object L$0;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector, Preferences.Key key) {
                    this.$this_unsafeFlow = flowCollector;
                    this.$key$inlined = key;
                }

                /* JADX WARN: Multi-variable type inference failed */
                /* JADX WARN: Removed duplicated region for block: B:15:0x0032  */
                /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final Object emit(Object obj, Continuation continuation) {
                    AnonymousClass1 anonymousClass1;
                    int i;
                    if (continuation instanceof AnonymousClass1) {
                        anonymousClass1 = (AnonymousClass1) continuation;
                        if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                            anonymousClass1.label -= Integer.MIN_VALUE;
                            Object obj2 = anonymousClass1.result;
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            i = anonymousClass1.label;
                            if (i != 0) {
                                ResultKt.throwOnFailure(obj2);
                                FlowCollector flowCollector = this.$this_unsafeFlow;
                                Object obj3 = ((Preferences) obj).get(this.$key$inlined);
                                anonymousClass1.label = 1;
                                if (flowCollector.emit(obj3, anonymousClass1) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            } else {
                                if (i != 1) {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                ResultKt.throwOnFailure(obj2);
                            }
                            return Unit.INSTANCE;
                        }
                    }
                    anonymousClass1 = new AnonymousClass1(continuation);
                    Object obj22 = anonymousClass1.result;
                    Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = anonymousClass1.label;
                    if (i != 0) {
                    }
                    return Unit.INSTANCE;
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super Object> flowCollector, Continuation continuation2) {
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector, key), continuation2);
                return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
            }
        }, continuation);
    }
}
