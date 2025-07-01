package com.google.android.gms.internal.clearcut;

import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public interface zzef<T> {
    boolean equals(T t, T t2);

    int hashCode(T t);

    T newInstance();

    void zza(T t, zzfr zzfrVar) throws IOException;

    void zza(T t, byte[] bArr, int i, int i2, zzay zzayVar) throws IOException;

    void zzc(T t);

    void zzc(T t, T t2);

    int zzm(T t);

    boolean zzo(T t);
}
