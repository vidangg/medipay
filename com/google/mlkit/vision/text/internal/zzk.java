package com.google.mlkit.vision.text.internal;

import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.SparseArray;
import androidx.media3.common.C;
import com.google.android.gms.internal.mlkit_vision_text_common.zzbh;
import com.google.android.gms.internal.mlkit_vision_text_common.zzbk;
import com.google.android.gms.internal.mlkit_vision_text_common.zzbu;
import com.google.android.gms.internal.mlkit_vision_text_common.zzcp;
import com.google.android.gms.internal.mlkit_vision_text_common.zzu;
import com.google.android.gms.internal.mlkit_vision_text_common.zzv;
import com.google.android.gms.internal.mlkit_vision_text_common.zzy;
import com.google.mlkit.vision.text.Text;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.commons.io.IOUtils;

/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition-common@@19.1.0 */
/* loaded from: classes4.dex */
final class zzk {
    public static final /* synthetic */ int zzb = 0;
    static final zzv zza = zzv.zza(IOUtils.LINE_SEPARATOR_UNIX);
    private static final Comparator zzc = new Comparator() { // from class: com.google.mlkit.vision.text.internal.zzf
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            int i = zzk.zzb;
            return ((Integer) ((Map.Entry) obj).getValue()).compareTo((Integer) ((Map.Entry) obj2).getValue());
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public static Text zza(com.google.android.gms.internal.mlkit_vision_text_common.zzl[] zzlVarArr, final Matrix matrix) {
        SparseArray sparseArray = new SparseArray();
        int i = 0;
        for (com.google.android.gms.internal.mlkit_vision_text_common.zzl zzlVar : zzlVarArr) {
            SparseArray sparseArray2 = (SparseArray) sparseArray.get(zzlVar.zzj);
            if (sparseArray2 == null) {
                sparseArray2 = new SparseArray();
                sparseArray.append(zzlVar.zzj, sparseArray2);
            }
            sparseArray2.append(zzlVar.zzk, zzlVar);
        }
        zzbh zzbhVar = new zzbh();
        int i2 = 0;
        while (i2 < sparseArray.size()) {
            SparseArray sparseArray3 = (SparseArray) sparseArray.valueAt(i2);
            zzbh zzbhVar2 = new zzbh();
            for (int i3 = i; i3 < sparseArray3.size(); i3++) {
                zzbhVar2.zza((com.google.android.gms.internal.mlkit_vision_text_common.zzl) sparseArray3.valueAt(i3));
            }
            zzbk zzb2 = zzbhVar2.zzb();
            List zza2 = zzbu.zza(zzb2, new zzu() { // from class: com.google.mlkit.vision.text.internal.zzh
                @Override // com.google.android.gms.internal.mlkit_vision_text_common.zzu
                public final Object zza(Object obj) {
                    com.google.android.gms.internal.mlkit_vision_text_common.zzl zzlVar2 = (com.google.android.gms.internal.mlkit_vision_text_common.zzl) obj;
                    int i4 = zzk.zzb;
                    List zzb3 = zza.zzb(zzlVar2.zzb);
                    String str = zzy.zzb(zzlVar2.zze) ? "" : zzlVar2.zze;
                    Rect zza3 = zza.zza(zzb3);
                    String str2 = zzy.zzb(zzlVar2.zzg) ? C.LANGUAGE_UNDETERMINED : zzlVar2.zzg;
                    final Matrix matrix2 = matrix;
                    return new Text.Line(str, zza3, zzb3, str2, matrix2, zzbu.zza(Arrays.asList(zzlVar2.zza), new zzu() { // from class: com.google.mlkit.vision.text.internal.zzj
                        @Override // com.google.android.gms.internal.mlkit_vision_text_common.zzu
                        public final Object zza(Object obj2) {
                            com.google.android.gms.internal.mlkit_vision_text_common.zzr zzrVar = (com.google.android.gms.internal.mlkit_vision_text_common.zzr) obj2;
                            int i5 = zzk.zzb;
                            List zzb4 = zza.zzb(zzrVar.zzb);
                            return new Text.Element(zzy.zzb(zzrVar.zzd) ? "" : zzrVar.zzd, zza.zza(zzb4), zzb4, zzy.zzb(zzrVar.zzf) ? C.LANGUAGE_UNDETERMINED : zzrVar.zzf, matrix2, zzrVar.zze, zzrVar.zzb.zze, zzbk.zzh());
                        }
                    }), zzlVar2.zzf, zzlVar2.zzb.zze);
                }
            });
            com.google.android.gms.internal.mlkit_vision_text_common.zzf zzfVar = ((com.google.android.gms.internal.mlkit_vision_text_common.zzl) zzb2.get(i)).zzb;
            zzcp listIterator = zzb2.listIterator(i);
            int i4 = Integer.MIN_VALUE;
            int i5 = Integer.MAX_VALUE;
            int i6 = Integer.MAX_VALUE;
            int i7 = Integer.MIN_VALUE;
            while (listIterator.hasNext()) {
                com.google.android.gms.internal.mlkit_vision_text_common.zzf zzfVar2 = ((com.google.android.gms.internal.mlkit_vision_text_common.zzl) listIterator.next()).zzb;
                int i8 = -zzfVar.zza;
                int i9 = -zzfVar.zzb;
                List list = zza2;
                double sin = Math.sin(Math.toRadians(zzfVar.zze));
                zzcp zzcpVar = listIterator;
                double cos = Math.cos(Math.toRadians(zzfVar.zze));
                SparseArray sparseArray4 = sparseArray;
                int i10 = i2;
                zzbh zzbhVar3 = zzbhVar;
                Point point = new Point(zzfVar2.zza, zzfVar2.zzb);
                point.offset(i8, i9);
                int i11 = (int) ((r13[0].x * cos) + (r13[0].y * sin));
                r13[0].x = i11;
                int i12 = (int) (((-r13[0].x) * sin) + (r13[0].y * cos));
                r13[0].y = i12;
                Point[] pointArr = {point, new Point(zzfVar2.zzc + i11, i12), new Point(zzfVar2.zzc + i11, zzfVar2.zzd + i12), new Point(i11, i12 + zzfVar2.zzd)};
                i7 = i7;
                i4 = i4;
                for (int i13 = 0; i13 < 4; i13++) {
                    Point point2 = pointArr[i13];
                    i5 = Math.min(i5, point2.x);
                    i4 = Math.max(i4, point2.x);
                    i6 = Math.min(i6, point2.y);
                    i7 = Math.max(i7, point2.y);
                }
                zza2 = list;
                i = 0;
                listIterator = zzcpVar;
                sparseArray = sparseArray4;
                i2 = i10;
                zzbhVar = zzbhVar3;
            }
            zzbh zzbhVar4 = zzbhVar;
            SparseArray sparseArray5 = sparseArray;
            int i14 = i2;
            int i15 = i;
            int i16 = i4;
            int i17 = i7;
            List list2 = zza2;
            int i18 = zzfVar.zza;
            int i19 = zzfVar.zzb;
            double sin2 = Math.sin(Math.toRadians(zzfVar.zze));
            double cos2 = Math.cos(Math.toRadians(zzfVar.zze));
            Point[] pointArr2 = {new Point(i5, i6), new Point(i16, i6), new Point(i16, i17), new Point(i5, i17)};
            for (int i20 = i15; i20 < 4; i20++) {
                pointArr2[i20].x = (int) ((pointArr2[i20].x * cos2) - (pointArr2[i20].y * sin2));
                pointArr2[i20].y = (int) ((pointArr2[i20].x * sin2) + (pointArr2[i20].y * cos2));
                pointArr2[i20].offset(i18, i19);
            }
            List asList = Arrays.asList(pointArr2);
            zzbhVar4.zza(new Text.TextBlock(zza.zzb(zzbu.zza(list2, new zzu() { // from class: com.google.mlkit.vision.text.internal.zzi
                @Override // com.google.android.gms.internal.mlkit_vision_text_common.zzu
                public final Object zza(Object obj) {
                    return ((Text.Line) obj).getText();
                }
            })), zza.zza(asList), asList, zzb(list2), matrix, list2));
            i2 = i14 + 1;
            zzbhVar = zzbhVar4;
            sparseArray = sparseArray5;
            i = 0;
        }
        zzbk zzb3 = zzbhVar.zzb();
        return new Text(zza.zzb(zzbu.zza(zzb3, new zzu() { // from class: com.google.mlkit.vision.text.internal.zzg
            @Override // com.google.android.gms.internal.mlkit_vision_text_common.zzu
            public final Object zza(Object obj) {
                return ((Text.TextBlock) obj).getText();
            }
        })), zzb3);
    }

    private static String zzb(List list) {
        HashMap hashMap = new HashMap();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            String recognizedLanguage = ((Text.Line) it.next()).getRecognizedLanguage();
            hashMap.put(recognizedLanguage, Integer.valueOf((hashMap.containsKey(recognizedLanguage) ? ((Integer) hashMap.get(recognizedLanguage)).intValue() : 0) + 1));
        }
        Set entrySet = hashMap.entrySet();
        if (entrySet.isEmpty()) {
            return C.LANGUAGE_UNDETERMINED;
        }
        String str = (String) ((Map.Entry) Collections.max(entrySet, zzc)).getKey();
        return !zzy.zzb(str) ? str : C.LANGUAGE_UNDETERMINED;
    }
}
