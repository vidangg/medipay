package io.flutter.embedding.engine.loader;

import android.app.ActivityManager;
import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import com.google.firebase.messaging.Constants;
import io.flutter.FlutterInjector;
import io.flutter.Log;
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.embedding.engine.FlutterShellArgs;
import io.flutter.embedding.engine.loader.FlutterLoader;
import io.flutter.util.HandlerCompat;
import io.flutter.util.PathUtils;
import io.flutter.util.TraceSection;
import io.flutter.view.VsyncWaiter;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/* loaded from: classes4.dex */
public class FlutterLoader {
    static final String AOT_SHARED_LIBRARY_NAME = "aot-shared-library-name";
    static final String AOT_VMSERVICE_SHARED_LIBRARY_NAME = "aot-vmservice-shared-library-name";
    static final String AUTOMATICALLY_REGISTER_PLUGINS_KEY = "automatically-register-plugins";
    private static final String DEFAULT_KERNEL_BLOB = "kernel_blob.bin";
    private static final String DEFAULT_LIBRARY = "libflutter.so";
    private static final String DISABLE_MERGED_PLATFORM_UI_THREAD_KEY = "io.flutter.embedding.android.DisableMergedPlatformUIThread";
    private static final String ENABLE_IMPELLER_META_DATA_KEY = "io.flutter.embedding.android.EnableImpeller";
    private static final String ENABLE_SURFACE_CONTROL = "io.flutter.embedding.android.EnableSurfaceControl";
    private static final String ENABLE_VULKAN_VALIDATION_META_DATA_KEY = "io.flutter.embedding.android.EnableVulkanValidation";
    static final String FLUTTER_ASSETS_DIR_KEY = "flutter-assets-dir";
    private static final String IMPELLER_ANTIALIAS_LINES = "io.flutter.embedding.android.ImpellerAntialiasLines";
    private static final String IMPELLER_BACKEND_META_DATA_KEY = "io.flutter.embedding.android.ImpellerBackend";
    private static final String IMPELLER_LAZY_SHADER_MODE = "io.flutter.embedding.android.ImpellerLazyShaderInitialization";
    private static final String IMPELLER_OPENGL_GPU_TRACING_DATA_KEY = "io.flutter.embedding.android.EnableOpenGLGPUTracing";
    private static final String IMPELLER_VULKAN_GPU_TRACING_DATA_KEY = "io.flutter.embedding.android.EnableVulkanGPUTracing";
    static final String ISOLATE_SNAPSHOT_DATA_KEY = "isolate-snapshot-data";
    private static final String LEAK_VM_META_DATA_KEY = "io.flutter.embedding.android.LeakVM";
    private static final String OLD_GEN_HEAP_SIZE_META_DATA_KEY = "io.flutter.embedding.android.OldGenHeapSize";
    static final String SNAPSHOT_ASSET_PATH_KEY = "snapshot-asset-path";
    private static final String TAG = "FlutterLoader";
    private static final String VMSERVICE_SNAPSHOT_LIBRARY = "libvmservice_snapshot.so";
    static final String VM_SNAPSHOT_DATA_KEY = "vm-snapshot-data";
    private static FlutterLoader instance;
    private ExecutorService executorService;
    private FlutterApplicationInfo flutterApplicationInfo;
    private FlutterJNI flutterJNI;
    Future<InitResult> initResultFuture;
    private long initStartTimestampMillis;
    private boolean initialized;
    private Settings settings;

    /* JADX INFO: Access modifiers changed from: private */
    public ResourceExtractor initResources(Context context) {
        return null;
    }

    public FlutterLoader() {
        this(FlutterInjector.instance().getFlutterJNIFactory().provideFlutterJNI());
    }

    public FlutterLoader(FlutterJNI flutterJNI) {
        this(flutterJNI, FlutterInjector.instance().executorService());
    }

    public FlutterLoader(FlutterJNI flutterJNI, ExecutorService executorService) {
        this.initialized = false;
        this.flutterJNI = flutterJNI;
        this.executorService = executorService;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class InitResult {
        final String appStoragePath;
        final String dataDirPath;
        final String engineCachesPath;

        /* synthetic */ InitResult(String str, String str2, String str3, AnonymousClass1 anonymousClass1) {
            this(str, str2, str3);
        }

        private InitResult(String str, String str2, String str3) {
            this.appStoragePath = str;
            this.engineCachesPath = str2;
            this.dataDirPath = str3;
        }
    }

    public void startInitialization(Context context) {
        startInitialization(context, new Settings());
    }

    public void startInitialization(Context context, Settings settings) {
        if (this.settings != null) {
            return;
        }
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new IllegalStateException("startInitialization must be called on the main thread");
        }
        TraceSection scoped = TraceSection.scoped("FlutterLoader#startInitialization");
        try {
            Context applicationContext = context.getApplicationContext();
            this.settings = settings;
            this.initStartTimestampMillis = SystemClock.uptimeMillis();
            this.flutterApplicationInfo = ApplicationInfoLoader.load(applicationContext);
            VsyncWaiter.getInstance((DisplayManager) applicationContext.getSystemService(Constants.ScionAnalytics.MessageType.DISPLAY_NOTIFICATION), this.flutterJNI).init();
            this.initResultFuture = this.executorService.submit(new AnonymousClass1(applicationContext));
            if (scoped != null) {
                scoped.close();
            }
        } catch (Throwable th) {
            if (scoped != null) {
                try {
                    scoped.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: io.flutter.embedding.engine.loader.FlutterLoader$1, reason: invalid class name */
    /* loaded from: classes4.dex */
    public class AnonymousClass1 implements Callable<InitResult> {
        final /* synthetic */ Context val$appContext;

        AnonymousClass1(Context context) {
            this.val$appContext = context;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public InitResult call() {
            String str;
            TraceSection scoped = TraceSection.scoped("FlutterLoader initTask");
            try {
                ResourceExtractor initResources = FlutterLoader.this.initResources(this.val$appContext);
                try {
                    FlutterLoader.this.flutterJNI.loadLibrary(this.val$appContext);
                    FlutterLoader.this.flutterJNI.updateRefreshRate();
                    FlutterLoader.this.executorService.execute(new Runnable() { // from class: io.flutter.embedding.engine.loader.FlutterLoader$1$$ExternalSyntheticLambda0
                        @Override // java.lang.Runnable
                        public final void run() {
                            FlutterLoader.AnonymousClass1.this.m759lambda$call$0$ioflutterembeddingengineloaderFlutterLoader$1();
                        }
                    });
                    if (initResources != null) {
                        initResources.waitForCompletion();
                    }
                    InitResult initResult = new InitResult(PathUtils.getFilesDir(this.val$appContext), PathUtils.getCacheDirectory(this.val$appContext), PathUtils.getDataDirectory(this.val$appContext), null);
                    if (scoped != null) {
                        scoped.close();
                    }
                    return initResult;
                } catch (UnsatisfiedLinkError e) {
                    if (!e.toString().contains("couldn't find \"libflutter.so\"") && !e.toString().contains("dlopen failed: library \"libflutter.so\" not found")) {
                        throw e;
                    }
                    String property = System.getProperty("os.arch");
                    File file = new File(FlutterLoader.this.flutterApplicationInfo.nativeLibraryDir);
                    String[] list = file.list();
                    StringBuilder sb = new StringBuilder("Could not load libflutter.so this is possibly because the application is running on an architecture that Flutter Android does not support (e.g. x86) see https://docs.flutter.dev/deployment/android#what-are-the-supported-target-architectures for more detail.\nApp is using cpu architecture: ");
                    sb.append(property);
                    sb.append(", and the native libraries directory (with path ");
                    sb.append(file.getAbsolutePath());
                    sb.append(") ");
                    if (file.exists()) {
                        str = "contains the following files: " + Arrays.toString(list);
                    } else {
                        str = "does not exist.";
                    }
                    sb.append(str);
                    throw new UnsupportedOperationException(sb.toString(), e);
                }
            } catch (Throwable th) {
                if (scoped != null) {
                    try {
                        scoped.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: lambda$call$0$io-flutter-embedding-engine-loader-FlutterLoader$1, reason: not valid java name */
        public /* synthetic */ void m759lambda$call$0$ioflutterembeddingengineloaderFlutterLoader$1() {
            FlutterLoader.this.flutterJNI.prefetchDefaultFontManager();
        }
    }

    public void ensureInitializationComplete(Context context, String[] strArr) {
        TraceSection traceSection;
        if (this.initialized) {
            return;
        }
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new IllegalStateException("ensureInitializationComplete must be called on the main thread");
        }
        if (this.settings == null) {
            throw new IllegalStateException("ensureInitializationComplete must be called after startInitialization");
        }
        try {
            TraceSection scoped = TraceSection.scoped("FlutterLoader#ensureInitializationComplete");
            try {
                InitResult initResult = this.initResultFuture.get();
                ArrayList arrayList = new ArrayList();
                traceSection = scoped;
                try {
                    arrayList.add("--icu-symbol-prefix=_binary_icudtl_dat");
                    arrayList.add("--icu-native-lib-path=" + this.flutterApplicationInfo.nativeLibraryDir + File.separator + DEFAULT_LIBRARY);
                    if (strArr != null) {
                        Collections.addAll(arrayList, strArr);
                    }
                    arrayList.add("--aot-shared-library-name=" + this.flutterApplicationInfo.aotSharedLibraryName);
                    arrayList.add("--aot-shared-library-name=" + this.flutterApplicationInfo.nativeLibraryDir + File.separator + this.flutterApplicationInfo.aotSharedLibraryName);
                    StringBuilder sb = new StringBuilder("--cache-dir-path=");
                    sb.append(initResult.engineCachesPath);
                    arrayList.add(sb.toString());
                    if (this.flutterApplicationInfo.domainNetworkPolicy != null) {
                        arrayList.add("--domain-network-policy=" + this.flutterApplicationInfo.domainNetworkPolicy);
                    }
                    if (this.settings.getLogTag() != null) {
                        arrayList.add("--log-tag=" + this.settings.getLogTag());
                    }
                    Bundle bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
                    int i = bundle != null ? bundle.getInt(OLD_GEN_HEAP_SIZE_META_DATA_KEY) : 0;
                    if (i == 0) {
                        ((ActivityManager) context.getSystemService("activity")).getMemoryInfo(new ActivityManager.MemoryInfo());
                        i = (int) ((r11.totalMem / 1000000.0d) / 2.0d);
                    }
                    arrayList.add("--old-gen-heap-size=" + i);
                    DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
                    arrayList.add("--resource-cache-max-bytes-threshold=" + (displayMetrics.widthPixels * displayMetrics.heightPixels * 48));
                    arrayList.add("--prefetched-default-font-manager");
                    if (bundle != null) {
                        if (bundle.containsKey(ENABLE_IMPELLER_META_DATA_KEY)) {
                            if (bundle.getBoolean(ENABLE_IMPELLER_META_DATA_KEY)) {
                                arrayList.add(FlutterShellArgs.ARG_ENABLE_IMPELLER);
                            } else {
                                arrayList.add(FlutterShellArgs.ARG_DISABLE_IMPELLER);
                            }
                        }
                        if (bundle.getBoolean(ENABLE_VULKAN_VALIDATION_META_DATA_KEY, false)) {
                            arrayList.add(FlutterShellArgs.ARG_ENABLE_VULKAN_VALIDATION);
                        }
                        if (bundle.getBoolean(IMPELLER_OPENGL_GPU_TRACING_DATA_KEY, false)) {
                            arrayList.add("--enable-opengl-gpu-tracing");
                        }
                        if (bundle.getBoolean(IMPELLER_VULKAN_GPU_TRACING_DATA_KEY, false)) {
                            arrayList.add("--enable-vulkan-gpu-tracing");
                        }
                        if (bundle.containsKey(DISABLE_MERGED_PLATFORM_UI_THREAD_KEY) && bundle.getBoolean(DISABLE_MERGED_PLATFORM_UI_THREAD_KEY)) {
                            arrayList.add("--no-enable-merged-platform-ui-thread");
                        }
                        if (bundle.getBoolean(ENABLE_SURFACE_CONTROL, false)) {
                            arrayList.add("--enable-surface-control");
                        }
                        String string = bundle.getString(IMPELLER_BACKEND_META_DATA_KEY);
                        if (string != null) {
                            arrayList.add("--impeller-backend=" + string);
                        }
                        if (bundle.getBoolean(IMPELLER_LAZY_SHADER_MODE)) {
                            arrayList.add("--impeller-lazy-shader-mode");
                        }
                        if (bundle.getBoolean(IMPELLER_ANTIALIAS_LINES)) {
                            arrayList.add("--impeller-antialias-lines");
                        }
                    }
                    arrayList.add("--leak-vm=".concat(isLeakVM(bundle) ? "true" : "false"));
                    long uptimeMillis = SystemClock.uptimeMillis() - this.initStartTimestampMillis;
                    FlutterJNI flutterJNI = this.flutterJNI;
                    String[] strArr2 = (String[]) arrayList.toArray(new String[0]);
                    String str = initResult.appStoragePath;
                    String str2 = initResult.engineCachesPath;
                    int i2 = Build.VERSION.SDK_INT;
                    Integer.valueOf(i2).getClass();
                    flutterJNI.init(context, strArr2, null, str, str2, uptimeMillis, i2);
                    this.initialized = true;
                    if (traceSection != null) {
                        traceSection.close();
                    }
                } catch (Throwable th) {
                    th = th;
                    Throwable th2 = th;
                    if (traceSection == null) {
                        throw th2;
                    }
                    try {
                        traceSection.close();
                        throw th2;
                    } catch (Throwable th3) {
                        th2.addSuppressed(th3);
                        throw th2;
                    }
                }
            } catch (Throwable th4) {
                th = th4;
                traceSection = scoped;
            }
        } catch (Exception e) {
            Log.e(TAG, "Flutter initialization failed.", e);
            throw new RuntimeException(e);
        }
    }

    private static boolean isLeakVM(Bundle bundle) {
        if (bundle == null) {
            return true;
        }
        return bundle.getBoolean(LEAK_VM_META_DATA_KEY, true);
    }

    public void ensureInitializationCompleteAsync(final Context context, final String[] strArr, final Handler handler, final Runnable runnable) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new IllegalStateException("ensureInitializationComplete must be called on the main thread");
        }
        if (this.settings == null) {
            throw new IllegalStateException("ensureInitializationComplete must be called after startInitialization");
        }
        if (this.initialized) {
            handler.post(runnable);
        } else {
            this.executorService.execute(new Runnable() { // from class: io.flutter.embedding.engine.loader.FlutterLoader$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    FlutterLoader.this.m758xa15f5dc1(context, strArr, handler, runnable);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$ensureInitializationCompleteAsync$1$io-flutter-embedding-engine-loader-FlutterLoader, reason: not valid java name */
    public /* synthetic */ void m758xa15f5dc1(final Context context, final String[] strArr, final Handler handler, final Runnable runnable) {
        try {
            this.initResultFuture.get();
            HandlerCompat.createAsyncHandler(Looper.getMainLooper()).post(new Runnable() { // from class: io.flutter.embedding.engine.loader.FlutterLoader$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    FlutterLoader.this.m757xafb5b7a2(context, strArr, handler, runnable);
                }
            });
        } catch (Exception e) {
            Log.e(TAG, "Flutter initialization failed.", e);
            throw new RuntimeException(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$ensureInitializationCompleteAsync$0$io-flutter-embedding-engine-loader-FlutterLoader, reason: not valid java name */
    public /* synthetic */ void m757xafb5b7a2(Context context, String[] strArr, Handler handler, Runnable runnable) {
        ensureInitializationComplete(context.getApplicationContext(), strArr);
        handler.post(runnable);
    }

    public boolean initialized() {
        return this.initialized;
    }

    public String findAppBundlePath() {
        return this.flutterApplicationInfo.flutterAssetsDir;
    }

    public String getLookupKeyForAsset(String str) {
        return fullAssetPathFrom(str);
    }

    public String getLookupKeyForAsset(String str, String str2) {
        return getLookupKeyForAsset("packages" + File.separator + str2 + File.separator + str);
    }

    public boolean automaticallyRegisterPlugins() {
        return this.flutterApplicationInfo.automaticallyRegisterPlugins;
    }

    private String fullAssetPathFrom(String str) {
        return this.flutterApplicationInfo.flutterAssetsDir + File.separator + str;
    }

    /* loaded from: classes4.dex */
    public static class Settings {
        private String logTag;

        public String getLogTag() {
            return this.logTag;
        }

        public void setLogTag(String str) {
            this.logTag = str;
        }
    }
}
