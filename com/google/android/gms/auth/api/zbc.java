package com.google.android.gms.auth.api;

/* compiled from: com.google.android.gms:play-services-auth@@21.2.0 */
@Deprecated
/* loaded from: classes3.dex */
public final class zbc {
    protected Boolean zba;
    protected String zbb;

    public zbc() {
        this.zba = false;
    }

    public final zbc zba(String str) {
        this.zbb = str;
        return this;
    }

    public zbc(zbd zbdVar) {
        boolean z;
        String str;
        this.zba = false;
        zbd.zbb(zbdVar);
        z = zbdVar.zbc;
        this.zba = Boolean.valueOf(z);
        str = zbdVar.zbd;
        this.zbb = str;
    }
}
