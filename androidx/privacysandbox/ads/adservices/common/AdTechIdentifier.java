package androidx.privacysandbox.ads.adservices.common;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AdTechIdentifier.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\r\u0010\u0007\u001a\u00020\bH\u0001¢\u0006\u0002\b\tJ\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Landroidx/privacysandbox/ads/adservices/common/AdTechIdentifier;", "", "identifier", "", "(Ljava/lang/String;)V", "getIdentifier", "()Ljava/lang/String;", "convertToAdServices", "Landroid/adservices/common/AdTechIdentifier;", "convertToAdServices$ads_adservices_release", "equals", "", "other", "hashCode", "", "toString", "ads-adservices_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes3.dex */
public final class AdTechIdentifier {
    private final String identifier;

    public AdTechIdentifier(String identifier) {
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        this.identifier = identifier;
    }

    public final String getIdentifier() {
        return this.identifier;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof AdTechIdentifier) {
            return Intrinsics.areEqual(this.identifier, ((AdTechIdentifier) other).identifier);
        }
        return false;
    }

    public int hashCode() {
        return this.identifier.hashCode();
    }

    public String toString() {
        return String.valueOf(this.identifier);
    }

    public final android.adservices.common.AdTechIdentifier convertToAdServices$ads_adservices_release() {
        android.adservices.common.AdTechIdentifier fromString;
        fromString = android.adservices.common.AdTechIdentifier.fromString(this.identifier);
        Intrinsics.checkNotNullExpressionValue(fromString, "fromString(identifier)");
        return fromString;
    }
}
