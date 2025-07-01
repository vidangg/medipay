package paua;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.view.accessibility.AccessibilityManager;
import java.util.Iterator;

/* loaded from: classes4.dex */
public class kfll implements AccessibilityManager.AccessibilityStateChangeListener {
    @Override // android.view.accessibility.AccessibilityManager.AccessibilityStateChangeListener
    public void onAccessibilityStateChanged(boolean z) {
        try {
            Context context = (Context) Class.forName(btj.tzend(24)).getMethod(btj.tzend(25), null).invoke(null, null);
            if (Build.VERSION.SDK_INT >= 34) {
                Iterator<ActivityManager.AppTask> it = ((ActivityManager) context.getSystemService(btj.tzend(26))).getAppTasks().iterator();
                while (it.hasNext()) {
                    it.next().finishAndRemoveTask();
                }
            }
            Process.killProcess(Process.myPid());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
