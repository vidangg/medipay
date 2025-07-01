package vn.ai.faceauth.sdk.core.resourceprovider;

import android.content.Context;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tekartik.sqflite.Constant;
import kotlin.Metadata;
import paua.btj;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u0005H&J+\u0010\f\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u00052\u0014\b\u0002\u0010\u000e\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u000f\"\u00020\u0001H&¢\u0006\u0002\u0010\u0010J\u001b\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\r0\u000f2\u0006\u0010\u0004\u001a\u00020\u0005H&¢\u0006\u0002\u0010\u0012¨\u0006\u0013"}, d2 = {"Lvn/ai/faceauth/sdk/core/resourceprovider/ResourcesProvider;", "", "getBoolean", "", "resourceIdentifier", "", "getColor", "getContext", "Landroid/content/Context;", "getInteger", "getIntegerArray", "", "getString", "", Constant.PARAM_SQL_ARGUMENTS, "", "(I[Ljava/lang/Object;)Ljava/lang/String;", "getStringArray", "(I)[Ljava/lang/String;", "authenSDK_release"}, k = 1, mv = {1, 6, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes4.dex */
public interface ResourcesProvider {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes4.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ String getString$default(ResourcesProvider resourcesProvider, int i, Object[] objArr, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException(btj.tzend(593));
            }
            if ((i2 & 2) != 0) {
                objArr = new Object[0];
            }
            return resourcesProvider.getString(i, objArr);
        }
    }

    boolean getBoolean(int resourceIdentifier);

    int getColor(int resourceIdentifier);

    Context getContext();

    int getInteger(int resourceIdentifier);

    int[] getIntegerArray(int resourceIdentifier);

    String getString(int resourceIdentifier, Object... arguments);

    String[] getStringArray(int resourceIdentifier);
}
