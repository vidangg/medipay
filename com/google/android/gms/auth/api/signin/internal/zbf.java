package com.google.android.gms.auth.api.signin.internal;

import android.os.RemoteException;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.api.Status;

/* compiled from: com.google.android.gms:play-services-auth@@21.2.0 */
/* loaded from: classes3.dex */
final class zbf extends zba {
    final /* synthetic */ zbg zba;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zbf(zbg zbgVar) {
        this.zba = zbgVar;
    }

    @Override // com.google.android.gms.auth.api.signin.internal.zba, com.google.android.gms.auth.api.signin.internal.zbr
    public final void zbd(GoogleSignInAccount googleSignInAccount, Status status) throws RemoteException {
        if (googleSignInAccount != null) {
            zbg zbgVar = this.zba;
            zbn.zbc(zbgVar.zba).zbe(zbgVar.zbb, googleSignInAccount);
        }
        this.zba.setResult((zbg) new GoogleSignInResult(googleSignInAccount, status));
    }
}
