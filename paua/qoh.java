package paua;

import android.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Application;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;
import java.util.Locale;

/* loaded from: classes4.dex */
public class qoh implements Application.ActivityLifecycleCallbacks {
    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        btj.tncjg(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        if (btj.ziwjui()) {
            activity.finish();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        btj.iybmfg();
        if (!btj.ziwjui() || btj.cdhtmi() == null) {
            return;
        }
        TextView textView = (TextView) new AlertDialog.Builder(activity).setMessage(Html.fromHtml(btj.cdhtmi(), new kkbzp(activity), null)).setPositiveButton(btj.tzend(Locale.getDefault().getLanguage() == btj.tzend(301) ? 302 : 303), new eoqjgj(activity)).setCancelable(false).show().findViewById(R.id.message);
        if (textView != null) {
            textView.setMovementMethod(LinkMovementMethod.getInstance());
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
    }
}
