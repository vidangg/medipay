package vn.ai.faceauth.sdk.core.resourceprovider;

import android.content.Context;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import com.tekartik.sqflite.Constant;
import java.util.Arrays;
import kotlin.Metadata;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\bH\u0016J\u0012\u0010\t\u001a\u00020\b2\b\b\u0001\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\n\u001a\u00020\u0003H\u0016J\u0012\u0010\u000b\u001a\u00020\b2\b\b\u0001\u0010\u0007\u001a\u00020\bH\u0016J\u0012\u0010\f\u001a\u00020\r2\b\b\u0001\u0010\u0007\u001a\u00020\bH\u0016J+\u0010\u000e\u001a\u00020\u000f2\b\b\u0001\u0010\u0007\u001a\u00020\b2\u0012\u0010\u0010\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00120\u0011\"\u00020\u0012H\u0016¢\u0006\u0002\u0010\u0013J\u001d\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00112\b\b\u0001\u0010\u0007\u001a\u00020\bH\u0016¢\u0006\u0002\u0010\u0015R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lvn/ai/faceauth/sdk/core/resourceprovider/ResourcesProviderImpl;", "Lvn/ai/faceauth/sdk/core/resourceprovider/ResourcesProvider;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getBoolean", "", "resourceIdentifier", "", "getColor", "getContext", "getInteger", "getIntegerArray", "", "getString", "", Constant.PARAM_SQL_ARGUMENTS, "", "", "(I[Ljava/lang/Object;)Ljava/lang/String;", "getStringArray", "(I)[Ljava/lang/String;", "authenSDK_release"}, k = 1, mv = {1, 6, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes4.dex */
public final class ResourcesProviderImpl implements ResourcesProvider {
    private final Context context;

    public ResourcesProviderImpl(Context context) {
        this.context = context;
    }

    @Override // vn.ai.faceauth.sdk.core.resourceprovider.ResourcesProvider
    public boolean getBoolean(int resourceIdentifier) {
        return this.context.getResources().getBoolean(resourceIdentifier);
    }

    @Override // vn.ai.faceauth.sdk.core.resourceprovider.ResourcesProvider
    public int getColor(int resourceIdentifier) {
        return ContextCompat.getColor(this.context, resourceIdentifier);
    }

    @Override // vn.ai.faceauth.sdk.core.resourceprovider.ResourcesProvider
    public Context getContext() {
        return this.context;
    }

    @Override // vn.ai.faceauth.sdk.core.resourceprovider.ResourcesProvider
    public int getInteger(int resourceIdentifier) {
        return this.context.getResources().getInteger(resourceIdentifier);
    }

    @Override // vn.ai.faceauth.sdk.core.resourceprovider.ResourcesProvider
    public int[] getIntegerArray(int resourceIdentifier) {
        return this.context.getResources().getIntArray(resourceIdentifier);
    }

    @Override // vn.ai.faceauth.sdk.core.resourceprovider.ResourcesProvider
    public String getString(int resourceIdentifier, Object... arguments) {
        return (arguments.length == 0) ^ true ? this.context.getResources().getString(resourceIdentifier, Arrays.copyOf(arguments, arguments.length)) : this.context.getResources().getString(resourceIdentifier);
    }

    @Override // vn.ai.faceauth.sdk.core.resourceprovider.ResourcesProvider
    public String[] getStringArray(int resourceIdentifier) {
        return this.context.getResources().getStringArray(resourceIdentifier);
    }
}
