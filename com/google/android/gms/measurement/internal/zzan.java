package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@22.4.0 */
/* loaded from: classes3.dex */
enum zzan {
    UNSET('0'),
    REMOTE_DEFAULT('1'),
    REMOTE_DELEGATION('2'),
    MANIFEST('3'),
    INITIALIZATION('4'),
    API('5'),
    CHILD_ACCOUNT('6'),
    TCF('7'),
    REMOTE_ENFORCED_DEFAULT('8'),
    FAILSAFE('9');

    private final char zzl;

    zzan(char c) {
        this.zzl = c;
    }

    public static zzan zzb(char c) {
        for (zzan zzanVar : values()) {
            if (zzanVar.zzl == c) {
                return zzanVar;
            }
        }
        return UNSET;
    }
}
