package com.google.android.gms.vision.text;

import android.graphics.Point;
import android.graphics.Rect;
import android.util.SparseArray;
import androidx.media3.common.C;
import com.google.android.gms.internal.vision.zzab;
import com.google.android.gms.internal.vision.zzah;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.io.IOUtils;

/* compiled from: com.google.android.gms:play-services-vision@@20.1.3 */
/* loaded from: classes3.dex */
public class TextBlock implements Text {
    private zzah[] zza;
    private Point[] zzb;
    private List<Line> zzc;
    private String zzd;
    private Rect zze;

    /* JADX INFO: Access modifiers changed from: package-private */
    public TextBlock(SparseArray<zzah> sparseArray) {
        this.zza = new zzah[sparseArray.size()];
        int i = 0;
        while (true) {
            zzah[] zzahVarArr = this.zza;
            if (i >= zzahVarArr.length) {
                return;
            }
            zzahVarArr[i] = sparseArray.valueAt(i);
            i++;
        }
    }

    @Override // com.google.android.gms.vision.text.Text
    public String getLanguage() {
        String str = this.zzd;
        if (str != null) {
            return str;
        }
        HashMap hashMap = new HashMap();
        for (zzah zzahVar : this.zza) {
            hashMap.put(zzahVar.zzd, Integer.valueOf((hashMap.containsKey(zzahVar.zzd) ? ((Integer) hashMap.get(zzahVar.zzd)).intValue() : 0) + 1));
        }
        String str2 = (String) ((Map.Entry) Collections.max(hashMap.entrySet(), new zza(this))).getKey();
        this.zzd = str2;
        if (str2 == null || str2.isEmpty()) {
            this.zzd = C.LANGUAGE_UNDETERMINED;
        }
        return this.zzd;
    }

    @Override // com.google.android.gms.vision.text.Text
    public String getValue() {
        zzah[] zzahVarArr = this.zza;
        if (zzahVarArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(zzahVarArr[0].zzc);
        for (int i = 1; i < this.zza.length; i++) {
            sb.append(IOUtils.LINE_SEPARATOR_UNIX);
            sb.append(this.zza[i].zzc);
        }
        return sb.toString();
    }

    @Override // com.google.android.gms.vision.text.Text
    public Point[] getCornerPoints() {
        zzah[] zzahVarArr;
        TextBlock textBlock = this;
        if (textBlock.zzb == null) {
            int i = 0;
            if (textBlock.zza.length == 0) {
                textBlock.zzb = new Point[0];
            } else {
                int i2 = Integer.MIN_VALUE;
                int i3 = 0;
                int i4 = Integer.MAX_VALUE;
                int i5 = Integer.MAX_VALUE;
                int i6 = Integer.MIN_VALUE;
                while (true) {
                    zzahVarArr = textBlock.zza;
                    if (i3 >= zzahVarArr.length) {
                        break;
                    }
                    zzab zzabVar = zzahVarArr[i3].zzb;
                    zzab zzabVar2 = textBlock.zza[i].zzb;
                    int i7 = -zzabVar2.zza;
                    int i8 = -zzabVar2.zzb;
                    double sin = Math.sin(Math.toRadians(zzabVar2.zze));
                    double cos = Math.cos(Math.toRadians(zzabVar2.zze));
                    Point point = new Point(zzabVar.zza, zzabVar.zzb);
                    point.offset(i7, i8);
                    int i9 = (int) ((r8[0].x * cos) + (r8[0].y * sin));
                    int i10 = (int) (((-r8[0].x) * sin) + (r8[0].y * cos));
                    r8[0].x = i9;
                    r8[0].y = i10;
                    Point[] pointArr = {point, new Point(zzabVar.zzc + i9, i10), new Point(zzabVar.zzc + i9, zzabVar.zzd + i10), new Point(i9, i10 + zzabVar.zzd)};
                    i2 = i2;
                    for (int i11 = 0; i11 < 4; i11++) {
                        Point point2 = pointArr[i11];
                        i4 = Math.min(i4, point2.x);
                        i2 = Math.max(i2, point2.x);
                        i5 = Math.min(i5, point2.y);
                        i6 = Math.max(i6, point2.y);
                    }
                    i3++;
                    i = 0;
                    textBlock = this;
                }
                int i12 = i2;
                int i13 = i;
                zzab zzabVar3 = zzahVarArr[i13].zzb;
                int i14 = zzabVar3.zza;
                int i15 = zzabVar3.zzb;
                double sin2 = Math.sin(Math.toRadians(zzabVar3.zze));
                double cos2 = Math.cos(Math.toRadians(zzabVar3.zze));
                Point[] pointArr2 = {new Point(i4, i5), new Point(i12, i5), new Point(i12, i6), new Point(i4, i6)};
                while (i13 < 4) {
                    pointArr2[i13].x = (int) ((pointArr2[i13].x * cos2) - (pointArr2[i13].y * sin2));
                    pointArr2[i13].y = (int) ((pointArr2[i13].x * sin2) + (pointArr2[i13].y * cos2));
                    pointArr2[i13].offset(i14, i15);
                    i13++;
                }
                textBlock = this;
                textBlock.zzb = pointArr2;
            }
        }
        return textBlock.zzb;
    }

    @Override // com.google.android.gms.vision.text.Text
    public List<? extends Text> getComponents() {
        if (this.zza.length == 0) {
            return new ArrayList(0);
        }
        if (this.zzc == null) {
            this.zzc = new ArrayList(this.zza.length);
            for (zzah zzahVar : this.zza) {
                this.zzc.add(new Line(zzahVar));
            }
        }
        return this.zzc;
    }

    @Override // com.google.android.gms.vision.text.Text
    public Rect getBoundingBox() {
        if (this.zze == null) {
            this.zze = zzc.zza(this);
        }
        return this.zze;
    }
}
