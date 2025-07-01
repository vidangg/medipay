package fman.ge.smart_auth;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.util.Base64;
import android.util.Log;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.media3.common.C;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AppSignatueHelper.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0007J\u001a\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007H\u0002¨\u0006\f"}, d2 = {"Lfman/ge/smart_auth/AppSignatureHelper;", "Landroid/content/ContextWrapper;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getAppSignatures", "Ljava/util/ArrayList;", "", "hash", "packageName", "signature", "Companion", "smart_auth_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes4.dex */
public final class AppSignatureHelper extends ContextWrapper {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String HASH_TYPE = "SHA-256";
    private static final int NUM_BASE64_CHAR = 11;
    private static final int NUM_HASHED_BYTES = 9;
    private static final String TAG;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppSignatureHelper(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* compiled from: AppSignatueHelper.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lfman/ge/smart_auth/AppSignatureHelper$Companion;", "", "()V", "HASH_TYPE", "", "NUM_BASE64_CHAR", "", "NUM_HASHED_BYTES", "TAG", "getTAG", "()Ljava/lang/String;", "smart_auth_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String getTAG() {
            return AppSignatureHelper.TAG;
        }
    }

    static {
        Intrinsics.checkNotNullExpressionValue("AppSignatureHelper", "getSimpleName(...)");
        TAG = "AppSignatureHelper";
    }

    public final ArrayList<String> getAppSignatures() {
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            String packageName = getPackageName();
            Signature[] apkContentsSigners = getPackageManager().getPackageInfo(packageName, C.BUFFER_FLAG_FIRST_SAMPLE).signingInfo.getApkContentsSigners();
            Intrinsics.checkNotNull(apkContentsSigners);
            ArrayList arrayList2 = new ArrayList();
            for (Signature signature : apkContentsSigners) {
                Intrinsics.checkNotNull(packageName);
                String charsString = signature.toCharsString();
                Intrinsics.checkNotNullExpressionValue(charsString, "toCharsString(...)");
                String hash = hash(packageName, charsString);
                if (hash != null) {
                    arrayList2.add(hash);
                }
            }
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                arrayList.add((String) it.next());
            }
            ArrayList<String> arrayList3 = arrayList;
            return arrayList;
        } catch (PackageManager.NameNotFoundException e) {
            Log.e(TAG, "Unable to find package to obtain hash.", e);
            return new ArrayList<>();
        }
    }

    private final String hash(String packageName, String signature) {
        String str = packageName + ' ' + signature;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(HASH_TYPE);
            Charset UTF_8 = StandardCharsets.UTF_8;
            Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
            byte[] bytes = str.getBytes(UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            messageDigest.update(bytes);
            String encodeToString = Base64.encodeToString(Arrays.copyOfRange(messageDigest.digest(), 0, 9), 3);
            Intrinsics.checkNotNull(encodeToString);
            String substring = encodeToString.substring(0, 11);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            return substring;
        } catch (NoSuchAlgorithmException e) {
            Log.e(TAG, "hash:NoSuchAlgorithm", e);
            return null;
        }
    }
}
