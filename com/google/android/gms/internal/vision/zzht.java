package com.google.android.gms.internal.vision;

import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Locale;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
/* loaded from: classes3.dex */
public abstract class zzht implements Serializable, Iterable<Byte> {
    public static final zzht zza = new zzid(zzjf.zzb);
    private static final zzhz zzb;
    private static final Comparator<zzht> zzd;
    private int zzc = 0;

    /* JADX INFO: Access modifiers changed from: private */
    public static int zzb(byte b) {
        return b & 255;
    }

    public abstract boolean equals(Object obj);

    public abstract byte zza(int i);

    public abstract int zza();

    protected abstract int zza(int i, int i2, int i3);

    public abstract zzht zza(int i, int i2);

    protected abstract String zza(Charset charset);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void zza(zzhq zzhqVar) throws IOException;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void zza(byte[] bArr, int i, int i2, int i3);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract byte zzb(int i);

    public abstract boolean zzc();

    public static zzht zza(byte[] bArr, int i, int i2) {
        zzb(i, i + i2, bArr.length);
        return new zzid(zzb.zza(bArr, i, i2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzht zza(byte[] bArr) {
        return new zzid(bArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzht zzb(byte[] bArr, int i, int i2) {
        return new zzhw(bArr, i, i2);
    }

    public static zzht zza(String str) {
        return new zzid(str.getBytes(zzjf.zza));
    }

    public final String zzb() {
        return zza() == 0 ? "" : zza(zzjf.zza);
    }

    public final int hashCode() {
        int i = this.zzc;
        if (i == 0) {
            int zza2 = zza();
            i = zza(zza2, 0, zza2);
            if (i == 0) {
                i = 1;
            }
            this.zzc = i;
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzib zzc(int i) {
        return new zzib(i, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int zzd() {
        return this.zzc;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzb(int i, int i2, int i3) {
        int i4 = i2 - i;
        if ((i | i2 | i4 | (i3 - i2)) >= 0) {
            return i4;
        }
        if (i < 0) {
            StringBuilder sb = new StringBuilder(32);
            sb.append("Beginning index: ");
            sb.append(i);
            sb.append(" < 0");
            throw new IndexOutOfBoundsException(sb.toString());
        }
        if (i2 < i) {
            StringBuilder sb2 = new StringBuilder(66);
            sb2.append("Beginning index larger than ending index: ");
            sb2.append(i);
            sb2.append(", ");
            sb2.append(i2);
            throw new IndexOutOfBoundsException(sb2.toString());
        }
        StringBuilder sb3 = new StringBuilder(37);
        sb3.append("End index: ");
        sb3.append(i2);
        sb3.append(" >= ");
        sb3.append(i3);
        throw new IndexOutOfBoundsException(sb3.toString());
    }

    public final String toString() {
        return String.format(Locale.ROOT, "<ByteString@%s size=%d contents=\"%s\">", Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(zza()), zza() <= 50 ? zzlq.zza(this) : String.valueOf(zzlq.zza(zza(0, 47))).concat("..."));
    }

    @Override // java.lang.Iterable
    public /* synthetic */ Iterator<Byte> iterator() {
        return new zzhs(this);
    }

    static {
        zzhs zzhsVar = null;
        zzb = zzhi.zza() ? new zzic(zzhsVar) : new zzhx(zzhsVar);
        zzd = new zzhv();
    }
}
