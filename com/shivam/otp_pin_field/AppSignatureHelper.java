package com.shivam.otp_pin_field;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.pm.SigningInfo;
import android.util.Base64;
import android.util.Log;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.media3.common.C;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.Charsets;

/* compiled from: AppSignatureHelper.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\n8G¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u000e"}, d2 = {"Lcom/shivam/otp_pin_field/AppSignatureHelper;", "Landroid/content/ContextWrapper;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "appSignature", "", "getAppSignature", "()Ljava/lang/String;", "appSignatures", "Ljava/util/ArrayList;", "getAppSignatures", "()Ljava/util/ArrayList;", "Companion", "otp_pin_field_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes4.dex */
public final class AppSignatureHelper extends ContextWrapper {
    private static final String HASH_TYPE = "SHA-256";
    public static final int NUM_BASE64_CHAR = 11;
    public static final int NUM_HASHED_BYTES = 9;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = "Otp Pin Field AppSignatureHelper";

    public AppSignatureHelper(Context context) {
        super(context);
    }

    public final String getAppSignature() {
        ArrayList<String> appSignatures = getAppSignatures();
        if (!appSignatures.isEmpty()) {
            String str = appSignatures.get(0);
            Intrinsics.checkNotNull(str);
            return str;
        }
        return "NA";
    }

    public final ArrayList<String> getAppSignatures() {
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            String packageName = getPackageName();
            Intrinsics.checkNotNullExpressionValue(packageName, "getPackageName(...)");
            PackageManager packageManager = getPackageManager();
            Intrinsics.checkNotNullExpressionValue(packageManager, "getPackageManager(...)");
            SigningInfo signingInfo = packageManager.getPackageInfo(packageName, C.BUFFER_FLAG_FIRST_SAMPLE).signingInfo;
            Signature[] apkContentsSigners = signingInfo != null ? signingInfo.getApkContentsSigners() : null;
            if (apkContentsSigners != null) {
                for (Signature signature : apkContentsSigners) {
                    Companion companion = INSTANCE;
                    String charsString = signature.toCharsString();
                    Intrinsics.checkNotNullExpressionValue(charsString, "toCharsString(...)");
                    String hash = companion.hash(packageName, charsString);
                    if (hash != null) {
                        arrayList.add(hash);
                    }
                }
            } else {
                AppSignatureHelper appSignatureHelper = this;
                Log.e(TAG, "No signatures found for package: " + packageName);
            }
        } catch (PackageManager.NameNotFoundException e) {
            Log.e(TAG, "Unable to find package to obtain hash.", e);
        }
        return arrayList;
    }

    /* compiled from: AppSignatureHelper.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u000b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/shivam/otp_pin_field/AppSignatureHelper$Companion;", "", "()V", "HASH_TYPE", "", "NUM_BASE64_CHAR", "", "NUM_HASHED_BYTES", "TAG", "getTAG", "()Ljava/lang/String;", "hash", "packageName", "signature", "otp_pin_field_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
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

        /* JADX INFO: Access modifiers changed from: private */
        public final String hash(String packageName, String signature) {
            String str = packageName + " " + signature;
            try {
                MessageDigest messageDigest = MessageDigest.getInstance(AppSignatureHelper.HASH_TYPE);
                Intrinsics.checkNotNullExpressionValue(messageDigest, "getInstance(...)");
                byte[] bytes = str.getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
                messageDigest.update(bytes);
                byte[] digest = messageDigest.digest();
                Intrinsics.checkNotNullExpressionValue(digest, "digest(...)");
                String encodeToString = Base64.encodeToString(ArraysKt.copyOfRange(digest, 0, 9), 3);
                Intrinsics.checkNotNullExpressionValue(encodeToString, "encodeToString(...)");
                String substring = encodeToString.substring(0, 11);
                Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                String tag = getTAG();
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String format = String.format("pkg: %s -- hash: %s", Arrays.copyOf(new Object[]{packageName, substring}, 2));
                Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
                Log.d(tag, format);
                return substring;
            } catch (NoSuchAlgorithmException e) {
                Log.e(getTAG(), "hash:NoSuchAlgorithm", e);
                return null;
            }
        }
    }
}
