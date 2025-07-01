package paua;

import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;

/* loaded from: classes4.dex */
public class roipit extends ContentObserver {
    public roipit(Handler handler) {
        super(handler);
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z, Uri uri, int i) {
        btj.iybmfg();
    }
}
