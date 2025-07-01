package paua;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.text.Html;

/* loaded from: classes4.dex */
public class kkbzp implements Html.ImageGetter {
    private final Activity activity;

    public kkbzp(Activity activity) {
        this.activity = activity;
    }

    @Override // android.text.Html.ImageGetter
    public Drawable getDrawable(String str) {
        try {
            Drawable applicationIcon = this.activity.getPackageManager().getApplicationIcon(str);
            applicationIcon.setBounds(0, 0, 70, 70);
            return applicationIcon;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }
}
