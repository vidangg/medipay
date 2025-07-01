package paua;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;

/* loaded from: classes4.dex */
public class eoqjgj implements DialogInterface.OnClickListener {
    private final Activity activity;

    public eoqjgj(Activity activity) {
        this.activity = activity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        Intent intent = new Intent(btj.tzend(398));
        intent.addFlags(335544320);
        this.activity.startActivity(intent);
    }
}
