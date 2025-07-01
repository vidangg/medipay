package paua;

import android.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;

/* loaded from: classes4.dex */
public class shqb {
    public static void xxa(Activity activity, String str, String str2) {
        new AlertDialog.Builder(activity).setTitle(str).setMessage(str2).setPositiveButton(R.string.ok, (DialogInterface.OnClickListener) null).setCancelable(false).show();
    }
}
