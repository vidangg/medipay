package paua;

import android.app.ActivityManager;
import android.content.Context;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Process;
import com.google.mlkit.common.MlKitException;
import java.util.Iterator;

/* loaded from: classes4.dex */
public class tzalr extends ContentObserver {
    public tzalr(Handler handler) {
        super(handler);
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z, Uri uri, int i) {
        try {
            Context context = (Context) Class.forName(btj.tzend(MlKitException.CODE_SCANNER_APP_NAME_UNAVAILABLE)).getMethod(btj.tzend(MlKitException.CODE_SCANNER_TASK_IN_PROGRESS), null).invoke(null, null);
            if (Build.VERSION.SDK_INT >= 34) {
                Iterator<ActivityManager.AppTask> it = ((ActivityManager) context.getSystemService(btj.tzend(MlKitException.CODE_SCANNER_PIPELINE_INITIALIZATION_ERROR))).getAppTasks().iterator();
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
