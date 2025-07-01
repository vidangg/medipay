package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.4.0 */
/* loaded from: classes3.dex */
public abstract class zzgk extends com.google.android.gms.internal.measurement.zzbn implements zzgl {
    public zzgk() {
        super("com.google.android.gms.measurement.internal.IMeasurementService");
    }

    @Override // com.google.android.gms.internal.measurement.zzbn
    protected final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        zzgr zzgrVar = null;
        zzgo zzgoVar = null;
        switch (i) {
            case 1:
                zzbh zzbhVar = (zzbh) com.google.android.gms.internal.measurement.zzbo.zza(parcel, zzbh.CREATOR);
                zzr zzrVar = (zzr) com.google.android.gms.internal.measurement.zzbo.zza(parcel, zzr.CREATOR);
                com.google.android.gms.internal.measurement.zzbo.zzc(parcel);
                zzp(zzbhVar, zzrVar);
                parcel2.writeNoException();
                return true;
            case 2:
                zzqb zzqbVar = (zzqb) com.google.android.gms.internal.measurement.zzbo.zza(parcel, zzqb.CREATOR);
                zzr zzrVar2 = (zzr) com.google.android.gms.internal.measurement.zzbo.zza(parcel, zzr.CREATOR);
                com.google.android.gms.internal.measurement.zzbo.zzc(parcel);
                zzB(zzqbVar, zzrVar2);
                parcel2.writeNoException();
                return true;
            case 3:
            case 8:
            case 22:
            case 23:
            case 28:
            default:
                return false;
            case 4:
                zzr zzrVar3 = (zzr) com.google.android.gms.internal.measurement.zzbo.zza(parcel, zzr.CREATOR);
                com.google.android.gms.internal.measurement.zzbo.zzc(parcel);
                zzn(zzrVar3);
                parcel2.writeNoException();
                return true;
            case 5:
                zzbh zzbhVar2 = (zzbh) com.google.android.gms.internal.measurement.zzbo.zza(parcel, zzbh.CREATOR);
                String readString = parcel.readString();
                String readString2 = parcel.readString();
                com.google.android.gms.internal.measurement.zzbo.zzc(parcel);
                zzq(zzbhVar2, readString, readString2);
                parcel2.writeNoException();
                return true;
            case 6:
                zzr zzrVar4 = (zzr) com.google.android.gms.internal.measurement.zzbo.zza(parcel, zzr.CREATOR);
                com.google.android.gms.internal.measurement.zzbo.zzc(parcel);
                zzz(zzrVar4);
                parcel2.writeNoException();
                return true;
            case 7:
                zzr zzrVar5 = (zzr) com.google.android.gms.internal.measurement.zzbo.zza(parcel, zzr.CREATOR);
                boolean zzf = com.google.android.gms.internal.measurement.zzbo.zzf(parcel);
                com.google.android.gms.internal.measurement.zzbo.zzc(parcel);
                List zzh = zzh(zzrVar5, zzf);
                parcel2.writeNoException();
                parcel2.writeTypedList(zzh);
                return true;
            case 9:
                zzbh zzbhVar3 = (zzbh) com.google.android.gms.internal.measurement.zzbo.zza(parcel, zzbh.CREATOR);
                String readString3 = parcel.readString();
                com.google.android.gms.internal.measurement.zzbo.zzc(parcel);
                byte[] zzD = zzD(zzbhVar3, readString3);
                parcel2.writeNoException();
                parcel2.writeByteArray(zzD);
                return true;
            case 10:
                long readLong = parcel.readLong();
                String readString4 = parcel.readString();
                String readString5 = parcel.readString();
                String readString6 = parcel.readString();
                com.google.android.gms.internal.measurement.zzbo.zzc(parcel);
                zzw(readLong, readString4, readString5, readString6);
                parcel2.writeNoException();
                return true;
            case 11:
                zzr zzrVar6 = (zzr) com.google.android.gms.internal.measurement.zzbo.zza(parcel, zzr.CREATOR);
                com.google.android.gms.internal.measurement.zzbo.zzc(parcel);
                String zzf2 = zzf(zzrVar6);
                parcel2.writeNoException();
                parcel2.writeString(zzf2);
                return true;
            case 12:
                zzai zzaiVar = (zzai) com.google.android.gms.internal.measurement.zzbo.zza(parcel, zzai.CREATOR);
                zzr zzrVar7 = (zzr) com.google.android.gms.internal.measurement.zzbo.zza(parcel, zzr.CREATOR);
                com.google.android.gms.internal.measurement.zzbo.zzc(parcel);
                zzt(zzaiVar, zzrVar7);
                parcel2.writeNoException();
                return true;
            case 13:
                zzai zzaiVar2 = (zzai) com.google.android.gms.internal.measurement.zzbo.zza(parcel, zzai.CREATOR);
                com.google.android.gms.internal.measurement.zzbo.zzc(parcel);
                zzu(zzaiVar2);
                parcel2.writeNoException();
                return true;
            case 14:
                String readString7 = parcel.readString();
                String readString8 = parcel.readString();
                boolean zzf3 = com.google.android.gms.internal.measurement.zzbo.zzf(parcel);
                zzr zzrVar8 = (zzr) com.google.android.gms.internal.measurement.zzbo.zza(parcel, zzr.CREATOR);
                com.google.android.gms.internal.measurement.zzbo.zzc(parcel);
                List zzk = zzk(readString7, readString8, zzf3, zzrVar8);
                parcel2.writeNoException();
                parcel2.writeTypedList(zzk);
                return true;
            case 15:
                String readString9 = parcel.readString();
                String readString10 = parcel.readString();
                String readString11 = parcel.readString();
                boolean zzf4 = com.google.android.gms.internal.measurement.zzbo.zzf(parcel);
                com.google.android.gms.internal.measurement.zzbo.zzc(parcel);
                List zzl = zzl(readString9, readString10, readString11, zzf4);
                parcel2.writeNoException();
                parcel2.writeTypedList(zzl);
                return true;
            case 16:
                String readString12 = parcel.readString();
                String readString13 = parcel.readString();
                zzr zzrVar9 = (zzr) com.google.android.gms.internal.measurement.zzbo.zza(parcel, zzr.CREATOR);
                com.google.android.gms.internal.measurement.zzbo.zzc(parcel);
                List zzi = zzi(readString12, readString13, zzrVar9);
                parcel2.writeNoException();
                parcel2.writeTypedList(zzi);
                return true;
            case 17:
                String readString14 = parcel.readString();
                String readString15 = parcel.readString();
                String readString16 = parcel.readString();
                com.google.android.gms.internal.measurement.zzbo.zzc(parcel);
                List zzj = zzj(readString14, readString15, readString16);
                parcel2.writeNoException();
                parcel2.writeTypedList(zzj);
                return true;
            case 18:
                zzr zzrVar10 = (zzr) com.google.android.gms.internal.measurement.zzbo.zza(parcel, zzr.CREATOR);
                com.google.android.gms.internal.measurement.zzbo.zzc(parcel);
                zzs(zzrVar10);
                parcel2.writeNoException();
                return true;
            case 19:
                Bundle bundle = (Bundle) com.google.android.gms.internal.measurement.zzbo.zza(parcel, Bundle.CREATOR);
                zzr zzrVar11 = (zzr) com.google.android.gms.internal.measurement.zzbo.zza(parcel, zzr.CREATOR);
                com.google.android.gms.internal.measurement.zzbo.zzc(parcel);
                zzx(bundle, zzrVar11);
                parcel2.writeNoException();
                return true;
            case 20:
                zzr zzrVar12 = (zzr) com.google.android.gms.internal.measurement.zzbo.zza(parcel, zzr.CREATOR);
                com.google.android.gms.internal.measurement.zzbo.zzc(parcel);
                zzv(zzrVar12);
                parcel2.writeNoException();
                return true;
            case 21:
                zzr zzrVar13 = (zzr) com.google.android.gms.internal.measurement.zzbo.zza(parcel, zzr.CREATOR);
                com.google.android.gms.internal.measurement.zzbo.zzc(parcel);
                zzap zze = zze(zzrVar13);
                parcel2.writeNoException();
                if (zze == null) {
                    parcel2.writeInt(0);
                } else {
                    parcel2.writeInt(1);
                    zze.writeToParcel(parcel2, 1);
                }
                return true;
            case 24:
                zzr zzrVar14 = (zzr) com.google.android.gms.internal.measurement.zzbo.zza(parcel, zzr.CREATOR);
                Bundle bundle2 = (Bundle) com.google.android.gms.internal.measurement.zzbo.zza(parcel, Bundle.CREATOR);
                com.google.android.gms.internal.measurement.zzbo.zzc(parcel);
                List zzg = zzg(zzrVar14, bundle2);
                parcel2.writeNoException();
                parcel2.writeTypedList(zzg);
                return true;
            case 25:
                zzr zzrVar15 = (zzr) com.google.android.gms.internal.measurement.zzbo.zza(parcel, zzr.CREATOR);
                com.google.android.gms.internal.measurement.zzbo.zzc(parcel);
                zzA(zzrVar15);
                parcel2.writeNoException();
                return true;
            case 26:
                zzr zzrVar16 = (zzr) com.google.android.gms.internal.measurement.zzbo.zza(parcel, zzr.CREATOR);
                com.google.android.gms.internal.measurement.zzbo.zzc(parcel);
                zzy(zzrVar16);
                parcel2.writeNoException();
                return true;
            case 27:
                zzr zzrVar17 = (zzr) com.google.android.gms.internal.measurement.zzbo.zza(parcel, zzr.CREATOR);
                com.google.android.gms.internal.measurement.zzbo.zzc(parcel);
                zzm(zzrVar17);
                parcel2.writeNoException();
                return true;
            case 29:
                zzr zzrVar18 = (zzr) com.google.android.gms.internal.measurement.zzbo.zza(parcel, zzr.CREATOR);
                zzpc zzpcVar = (zzpc) com.google.android.gms.internal.measurement.zzbo.zza(parcel, zzpc.CREATOR);
                IBinder readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder != null) {
                    IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.measurement.internal.IUploadBatchesCallback");
                    zzgrVar = queryLocalInterface instanceof zzgr ? (zzgr) queryLocalInterface : new zzgp(readStrongBinder);
                }
                com.google.android.gms.internal.measurement.zzbo.zzc(parcel);
                zzo(zzrVar18, zzpcVar, zzgrVar);
                parcel2.writeNoException();
                return true;
            case 30:
                zzr zzrVar19 = (zzr) com.google.android.gms.internal.measurement.zzbo.zza(parcel, zzr.CREATOR);
                zzag zzagVar = (zzag) com.google.android.gms.internal.measurement.zzbo.zza(parcel, zzag.CREATOR);
                com.google.android.gms.internal.measurement.zzbo.zzc(parcel);
                zzC(zzrVar19, zzagVar);
                parcel2.writeNoException();
                return true;
            case 31:
                zzr zzrVar20 = (zzr) com.google.android.gms.internal.measurement.zzbo.zza(parcel, zzr.CREATOR);
                Bundle bundle3 = (Bundle) com.google.android.gms.internal.measurement.zzbo.zza(parcel, Bundle.CREATOR);
                IBinder readStrongBinder2 = parcel.readStrongBinder();
                if (readStrongBinder2 != null) {
                    IInterface queryLocalInterface2 = readStrongBinder2.queryLocalInterface("com.google.android.gms.measurement.internal.ITriggerUrisCallback");
                    zzgoVar = queryLocalInterface2 instanceof zzgo ? (zzgo) queryLocalInterface2 : new zzgm(readStrongBinder2);
                }
                com.google.android.gms.internal.measurement.zzbo.zzc(parcel);
                zzr(zzrVar20, bundle3, zzgoVar);
                parcel2.writeNoException();
                return true;
        }
    }
}
