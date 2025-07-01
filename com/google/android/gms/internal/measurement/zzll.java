package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement-base@@22.4.0 */
/* loaded from: classes3.dex */
final class zzll implements zzor {
    private final zzlk zza;

    private zzll(zzlk zzlkVar) {
        byte[] bArr = zzmk.zzb;
        this.zza = zzlkVar;
        zzlkVar.zza = this;
    }

    public static zzll zza(zzlk zzlkVar) {
        zzll zzllVar = zzlkVar.zza;
        return zzllVar != null ? zzllVar : new zzll(zzlkVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzor
    public final void zzB(int i, int i2) throws IOException {
        this.zza.zzs(i, (i2 >> 31) ^ (i2 + i2));
    }

    @Override // com.google.android.gms.internal.measurement.zzor
    public final void zzD(int i, long j) throws IOException {
        this.zza.zzu(i, (j >> 63) ^ (j + j));
    }

    @Override // com.google.android.gms.internal.measurement.zzor
    @Deprecated
    public final void zzF(int i) throws IOException {
        this.zza.zzr(i, 3);
    }

    @Override // com.google.android.gms.internal.measurement.zzor
    public final void zzG(int i, String str) throws IOException {
        this.zza.zzp(i, str);
    }

    @Override // com.google.android.gms.internal.measurement.zzor
    public final void zzI(int i, int i2) throws IOException {
        this.zza.zzs(i, i2);
    }

    @Override // com.google.android.gms.internal.measurement.zzor
    public final void zzK(int i, long j) throws IOException {
        this.zza.zzu(i, j);
    }

    @Override // com.google.android.gms.internal.measurement.zzor
    public final void zzb(int i, boolean z) throws IOException {
        this.zza.zzd(i, z);
    }

    @Override // com.google.android.gms.internal.measurement.zzor
    public final void zzd(int i, zzld zzldVar) throws IOException {
        this.zza.zze(i, zzldVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzor
    public final void zze(int i, List list) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            this.zza.zze(i, (zzld) list.get(i2));
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzor
    public final void zzf(int i, double d) throws IOException {
        this.zza.zzh(i, Double.doubleToRawLongBits(d));
    }

    @Override // com.google.android.gms.internal.measurement.zzor
    @Deprecated
    public final void zzh(int i) throws IOException {
        this.zza.zzr(i, 4);
    }

    @Override // com.google.android.gms.internal.measurement.zzor
    public final void zzi(int i, int i2) throws IOException {
        this.zza.zzj(i, i2);
    }

    @Override // com.google.android.gms.internal.measurement.zzor
    public final void zzk(int i, int i2) throws IOException {
        this.zza.zzf(i, i2);
    }

    @Override // com.google.android.gms.internal.measurement.zzor
    public final void zzm(int i, long j) throws IOException {
        this.zza.zzh(i, j);
    }

    @Override // com.google.android.gms.internal.measurement.zzor
    public final void zzo(int i, float f) throws IOException {
        this.zza.zzf(i, Float.floatToRawIntBits(f));
    }

    @Override // com.google.android.gms.internal.measurement.zzor
    public final void zzq(int i, Object obj, zzns zznsVar) throws IOException {
        zzlk zzlkVar = this.zza;
        zzlkVar.zzr(i, 3);
        zznsVar.zzi((zznh) obj, zzlkVar.zza);
        zzlkVar.zzr(i, 4);
    }

    @Override // com.google.android.gms.internal.measurement.zzor
    public final void zzr(int i, int i2) throws IOException {
        this.zza.zzj(i, i2);
    }

    @Override // com.google.android.gms.internal.measurement.zzor
    public final void zzt(int i, long j) throws IOException {
        this.zza.zzu(i, j);
    }

    @Override // com.google.android.gms.internal.measurement.zzor
    public final void zzv(int i, Object obj, zzns zznsVar) throws IOException {
        this.zza.zzm(i, (zznh) obj, zznsVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzor
    public final void zzw(int i, Object obj) throws IOException {
        if (obj instanceof zzld) {
            this.zza.zzo(i, (zzld) obj);
        } else {
            this.zza.zzn(i, (zznh) obj);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzor
    public final void zzx(int i, int i2) throws IOException {
        this.zza.zzf(i, i2);
    }

    @Override // com.google.android.gms.internal.measurement.zzor
    public final void zzz(int i, long j) throws IOException {
        this.zza.zzh(i, j);
    }

    @Override // com.google.android.gms.internal.measurement.zzor
    public final void zzH(int i, List list) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzmt)) {
            while (i2 < list.size()) {
                this.zza.zzp(i, (String) list.get(i2));
                i2++;
            }
            return;
        }
        zzmt zzmtVar = (zzmt) list;
        while (i2 < list.size()) {
            Object zzc = zzmtVar.zzc();
            if (zzc instanceof String) {
                this.zza.zzp(i, (String) zzc);
            } else {
                this.zza.zze(i, (zzld) zzc);
            }
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzor
    public final void zzJ(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzme)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzs(i, ((Integer) list.get(i2)).intValue());
                    i2++;
                }
                return;
            }
            zzlk zzlkVar = this.zza;
            zzlkVar.zzr(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzlk.zzz(((Integer) list.get(i4)).intValue());
            }
            zzlkVar.zzt(i3);
            while (i2 < list.size()) {
                zzlkVar.zzt(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        zzme zzmeVar = (zzme) list;
        if (!z) {
            while (i2 < zzmeVar.size()) {
                this.zza.zzs(i, zzmeVar.zze(i2));
                i2++;
            }
            return;
        }
        zzlk zzlkVar2 = this.zza;
        zzlkVar2.zzr(i, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < zzmeVar.size(); i6++) {
            i5 += zzlk.zzz(zzmeVar.zze(i6));
        }
        zzlkVar2.zzt(i5);
        while (i2 < zzmeVar.size()) {
            zzlkVar2.zzt(zzmeVar.zze(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzor
    public final void zzL(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzmw)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzu(i, ((Long) list.get(i2)).longValue());
                    i2++;
                }
                return;
            }
            zzlk zzlkVar = this.zza;
            zzlkVar.zzr(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzlk.zzA(((Long) list.get(i4)).longValue());
            }
            zzlkVar.zzt(i3);
            while (i2 < list.size()) {
                zzlkVar.zzv(((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        zzmw zzmwVar = (zzmw) list;
        if (!z) {
            while (i2 < zzmwVar.size()) {
                this.zza.zzu(i, zzmwVar.zza(i2));
                i2++;
            }
            return;
        }
        zzlk zzlkVar2 = this.zza;
        zzlkVar2.zzr(i, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < zzmwVar.size(); i6++) {
            i5 += zzlk.zzA(zzmwVar.zza(i6));
        }
        zzlkVar2.zzt(i5);
        while (i2 < zzmwVar.size()) {
            zzlkVar2.zzv(zzmwVar.zza(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzor
    public final void zzl(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzme)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzf(i, ((Integer) list.get(i2)).intValue());
                    i2++;
                }
                return;
            }
            zzlk zzlkVar = this.zza;
            zzlkVar.zzr(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                ((Integer) list.get(i4)).intValue();
                i3 += 4;
            }
            zzlkVar.zzt(i3);
            while (i2 < list.size()) {
                zzlkVar.zzg(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        zzme zzmeVar = (zzme) list;
        if (!z) {
            while (i2 < zzmeVar.size()) {
                this.zza.zzf(i, zzmeVar.zze(i2));
                i2++;
            }
            return;
        }
        zzlk zzlkVar2 = this.zza;
        zzlkVar2.zzr(i, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < zzmeVar.size(); i6++) {
            zzmeVar.zze(i6);
            i5 += 4;
        }
        zzlkVar2.zzt(i5);
        while (i2 < zzmeVar.size()) {
            zzlkVar2.zzg(zzmeVar.zze(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzor
    public final void zzn(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzmw)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzh(i, ((Long) list.get(i2)).longValue());
                    i2++;
                }
                return;
            }
            zzlk zzlkVar = this.zza;
            zzlkVar.zzr(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                ((Long) list.get(i4)).longValue();
                i3 += 8;
            }
            zzlkVar.zzt(i3);
            while (i2 < list.size()) {
                zzlkVar.zzi(((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        zzmw zzmwVar = (zzmw) list;
        if (!z) {
            while (i2 < zzmwVar.size()) {
                this.zza.zzh(i, zzmwVar.zza(i2));
                i2++;
            }
            return;
        }
        zzlk zzlkVar2 = this.zza;
        zzlkVar2.zzr(i, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < zzmwVar.size(); i6++) {
            zzmwVar.zza(i6);
            i5 += 8;
        }
        zzlkVar2.zzt(i5);
        while (i2 < zzmwVar.size()) {
            zzlkVar2.zzi(zzmwVar.zza(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzor
    public final void zzc(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzku)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzd(i, ((Boolean) list.get(i2)).booleanValue());
                    i2++;
                }
                return;
            }
            zzlk zzlkVar = this.zza;
            zzlkVar.zzr(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                ((Boolean) list.get(i4)).booleanValue();
                i3++;
            }
            zzlkVar.zzt(i3);
            while (i2 < list.size()) {
                zzlkVar.zzb(((Boolean) list.get(i2)).booleanValue() ? (byte) 1 : (byte) 0);
                i2++;
            }
            return;
        }
        zzku zzkuVar = (zzku) list;
        if (!z) {
            while (i2 < zzkuVar.size()) {
                this.zza.zzd(i, zzkuVar.zzf(i2));
                i2++;
            }
            return;
        }
        zzlk zzlkVar2 = this.zza;
        zzlkVar2.zzr(i, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < zzkuVar.size(); i6++) {
            zzkuVar.zzf(i6);
            i5++;
        }
        zzlkVar2.zzt(i5);
        while (i2 < zzkuVar.size()) {
            zzlkVar2.zzb(zzkuVar.zzf(i2) ? (byte) 1 : (byte) 0);
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzor
    public final void zzs(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzme)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzj(i, ((Integer) list.get(i2)).intValue());
                    i2++;
                }
                return;
            }
            zzlk zzlkVar = this.zza;
            zzlkVar.zzr(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzlk.zzA(((Integer) list.get(i4)).intValue());
            }
            zzlkVar.zzt(i3);
            while (i2 < list.size()) {
                zzlkVar.zzk(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        zzme zzmeVar = (zzme) list;
        if (!z) {
            while (i2 < zzmeVar.size()) {
                this.zza.zzj(i, zzmeVar.zze(i2));
                i2++;
            }
            return;
        }
        zzlk zzlkVar2 = this.zza;
        zzlkVar2.zzr(i, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < zzmeVar.size(); i6++) {
            i5 += zzlk.zzA(zzmeVar.zze(i6));
        }
        zzlkVar2.zzt(i5);
        while (i2 < zzmeVar.size()) {
            zzlkVar2.zzk(zzmeVar.zze(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzor
    public final void zzA(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzmw)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzh(i, ((Long) list.get(i2)).longValue());
                    i2++;
                }
                return;
            }
            zzlk zzlkVar = this.zza;
            zzlkVar.zzr(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                ((Long) list.get(i4)).longValue();
                i3 += 8;
            }
            zzlkVar.zzt(i3);
            while (i2 < list.size()) {
                zzlkVar.zzi(((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        zzmw zzmwVar = (zzmw) list;
        if (!z) {
            while (i2 < zzmwVar.size()) {
                this.zza.zzh(i, zzmwVar.zza(i2));
                i2++;
            }
            return;
        }
        zzlk zzlkVar2 = this.zza;
        zzlkVar2.zzr(i, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < zzmwVar.size(); i6++) {
            zzmwVar.zza(i6);
            i5 += 8;
        }
        zzlkVar2.zzt(i5);
        while (i2 < zzmwVar.size()) {
            zzlkVar2.zzi(zzmwVar.zza(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzor
    public final void zzg(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzlm)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzh(i, Double.doubleToRawLongBits(((Double) list.get(i2)).doubleValue()));
                    i2++;
                }
                return;
            }
            zzlk zzlkVar = this.zza;
            zzlkVar.zzr(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                ((Double) list.get(i4)).doubleValue();
                i3 += 8;
            }
            zzlkVar.zzt(i3);
            while (i2 < list.size()) {
                zzlkVar.zzi(Double.doubleToRawLongBits(((Double) list.get(i2)).doubleValue()));
                i2++;
            }
            return;
        }
        zzlm zzlmVar = (zzlm) list;
        if (!z) {
            while (i2 < zzlmVar.size()) {
                this.zza.zzh(i, Double.doubleToRawLongBits(zzlmVar.zze(i2)));
                i2++;
            }
            return;
        }
        zzlk zzlkVar2 = this.zza;
        zzlkVar2.zzr(i, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < zzlmVar.size(); i6++) {
            zzlmVar.zze(i6);
            i5 += 8;
        }
        zzlkVar2.zzt(i5);
        while (i2 < zzlmVar.size()) {
            zzlkVar2.zzi(Double.doubleToRawLongBits(zzlmVar.zze(i2)));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzor
    public final void zzp(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzlw)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzf(i, Float.floatToRawIntBits(((Float) list.get(i2)).floatValue()));
                    i2++;
                }
                return;
            }
            zzlk zzlkVar = this.zza;
            zzlkVar.zzr(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                ((Float) list.get(i4)).floatValue();
                i3 += 4;
            }
            zzlkVar.zzt(i3);
            while (i2 < list.size()) {
                zzlkVar.zzg(Float.floatToRawIntBits(((Float) list.get(i2)).floatValue()));
                i2++;
            }
            return;
        }
        zzlw zzlwVar = (zzlw) list;
        if (!z) {
            while (i2 < zzlwVar.size()) {
                this.zza.zzf(i, Float.floatToRawIntBits(zzlwVar.zze(i2)));
                i2++;
            }
            return;
        }
        zzlk zzlkVar2 = this.zza;
        zzlkVar2.zzr(i, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < zzlwVar.size(); i6++) {
            zzlwVar.zze(i6);
            i5 += 4;
        }
        zzlkVar2.zzt(i5);
        while (i2 < zzlwVar.size()) {
            zzlkVar2.zzg(Float.floatToRawIntBits(zzlwVar.zze(i2)));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzor
    public final void zzy(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzme)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzf(i, ((Integer) list.get(i2)).intValue());
                    i2++;
                }
                return;
            }
            zzlk zzlkVar = this.zza;
            zzlkVar.zzr(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                ((Integer) list.get(i4)).intValue();
                i3 += 4;
            }
            zzlkVar.zzt(i3);
            while (i2 < list.size()) {
                zzlkVar.zzg(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        zzme zzmeVar = (zzme) list;
        if (!z) {
            while (i2 < zzmeVar.size()) {
                this.zza.zzf(i, zzmeVar.zze(i2));
                i2++;
            }
            return;
        }
        zzlk zzlkVar2 = this.zza;
        zzlkVar2.zzr(i, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < zzmeVar.size(); i6++) {
            zzmeVar.zze(i6);
            i5 += 4;
        }
        zzlkVar2.zzt(i5);
        while (i2 < zzmeVar.size()) {
            zzlkVar2.zzg(zzmeVar.zze(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzor
    public final void zzC(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzme)) {
            if (!z) {
                while (i2 < list.size()) {
                    zzlk zzlkVar = this.zza;
                    int intValue = ((Integer) list.get(i2)).intValue();
                    zzlkVar.zzs(i, (intValue >> 31) ^ (intValue + intValue));
                    i2++;
                }
                return;
            }
            zzlk zzlkVar2 = this.zza;
            zzlkVar2.zzr(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                int intValue2 = ((Integer) list.get(i4)).intValue();
                i3 += zzlk.zzz((intValue2 >> 31) ^ (intValue2 + intValue2));
            }
            zzlkVar2.zzt(i3);
            while (i2 < list.size()) {
                int intValue3 = ((Integer) list.get(i2)).intValue();
                zzlkVar2.zzt((intValue3 >> 31) ^ (intValue3 + intValue3));
                i2++;
            }
            return;
        }
        zzme zzmeVar = (zzme) list;
        if (!z) {
            while (i2 < zzmeVar.size()) {
                zzlk zzlkVar3 = this.zza;
                int zze = zzmeVar.zze(i2);
                zzlkVar3.zzs(i, (zze >> 31) ^ (zze + zze));
                i2++;
            }
            return;
        }
        zzlk zzlkVar4 = this.zza;
        zzlkVar4.zzr(i, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < zzmeVar.size(); i6++) {
            int zze2 = zzmeVar.zze(i6);
            i5 += zzlk.zzz((zze2 >> 31) ^ (zze2 + zze2));
        }
        zzlkVar4.zzt(i5);
        while (i2 < zzmeVar.size()) {
            int zze3 = zzmeVar.zze(i2);
            zzlkVar4.zzt((zze3 >> 31) ^ (zze3 + zze3));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzor
    public final void zzE(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzmw)) {
            if (!z) {
                while (i2 < list.size()) {
                    zzlk zzlkVar = this.zza;
                    long longValue = ((Long) list.get(i2)).longValue();
                    zzlkVar.zzu(i, (longValue >> 63) ^ (longValue + longValue));
                    i2++;
                }
                return;
            }
            zzlk zzlkVar2 = this.zza;
            zzlkVar2.zzr(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                long longValue2 = ((Long) list.get(i4)).longValue();
                i3 += zzlk.zzA((longValue2 >> 63) ^ (longValue2 + longValue2));
            }
            zzlkVar2.zzt(i3);
            while (i2 < list.size()) {
                long longValue3 = ((Long) list.get(i2)).longValue();
                zzlkVar2.zzv((longValue3 >> 63) ^ (longValue3 + longValue3));
                i2++;
            }
            return;
        }
        zzmw zzmwVar = (zzmw) list;
        if (!z) {
            while (i2 < zzmwVar.size()) {
                zzlk zzlkVar3 = this.zza;
                long zza = zzmwVar.zza(i2);
                zzlkVar3.zzu(i, (zza >> 63) ^ (zza + zza));
                i2++;
            }
            return;
        }
        zzlk zzlkVar4 = this.zza;
        zzlkVar4.zzr(i, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < zzmwVar.size(); i6++) {
            long zza2 = zzmwVar.zza(i6);
            i5 += zzlk.zzA((zza2 >> 63) ^ (zza2 + zza2));
        }
        zzlkVar4.zzt(i5);
        while (i2 < zzmwVar.size()) {
            long zza3 = zzmwVar.zza(i2);
            zzlkVar4.zzv((zza3 >> 63) ^ (zza3 + zza3));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzor
    public final void zzj(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzme)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzj(i, ((Integer) list.get(i2)).intValue());
                    i2++;
                }
                return;
            }
            zzlk zzlkVar = this.zza;
            zzlkVar.zzr(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzlk.zzA(((Integer) list.get(i4)).intValue());
            }
            zzlkVar.zzt(i3);
            while (i2 < list.size()) {
                zzlkVar.zzk(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        zzme zzmeVar = (zzme) list;
        if (!z) {
            while (i2 < zzmeVar.size()) {
                this.zza.zzj(i, zzmeVar.zze(i2));
                i2++;
            }
            return;
        }
        zzlk zzlkVar2 = this.zza;
        zzlkVar2.zzr(i, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < zzmeVar.size(); i6++) {
            i5 += zzlk.zzA(zzmeVar.zze(i6));
        }
        zzlkVar2.zzt(i5);
        while (i2 < zzmeVar.size()) {
            zzlkVar2.zzk(zzmeVar.zze(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzor
    public final void zzu(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzmw)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzu(i, ((Long) list.get(i2)).longValue());
                    i2++;
                }
                return;
            }
            zzlk zzlkVar = this.zza;
            zzlkVar.zzr(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzlk.zzA(((Long) list.get(i4)).longValue());
            }
            zzlkVar.zzt(i3);
            while (i2 < list.size()) {
                zzlkVar.zzv(((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        zzmw zzmwVar = (zzmw) list;
        if (!z) {
            while (i2 < zzmwVar.size()) {
                this.zza.zzu(i, zzmwVar.zza(i2));
                i2++;
            }
            return;
        }
        zzlk zzlkVar2 = this.zza;
        zzlkVar2.zzr(i, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < zzmwVar.size(); i6++) {
            i5 += zzlk.zzA(zzmwVar.zza(i6));
        }
        zzlkVar2.zzt(i5);
        while (i2 < zzmwVar.size()) {
            zzlkVar2.zzv(zzmwVar.zza(i2));
            i2++;
        }
    }
}
