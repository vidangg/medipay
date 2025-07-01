package com.google.mlkit.vision.text.pipeline;

import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbaaj;
import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbpb;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes4.dex */
final class zbf {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static Rect zba(List list, Matrix matrix) {
        Iterator it = list.iterator();
        int i = Integer.MIN_VALUE;
        int i2 = Integer.MAX_VALUE;
        int i3 = Integer.MAX_VALUE;
        int i4 = Integer.MIN_VALUE;
        while (it.hasNext()) {
            Point point = (Point) it.next();
            i2 = Math.min(i2, point.x);
            i = Math.max(i, point.x);
            i3 = Math.min(i3, point.y);
            i4 = Math.max(i4, point.y);
        }
        RectF rectF = new RectF(i2, i3, i, i4);
        if (matrix != null) {
            matrix.mapRect(rectF);
        }
        Rect rect = new Rect();
        rectF.round(rect);
        return rect;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zbpb zbb(zbaaj zbaajVar) {
        if (zbaajVar.zbi()) {
            return zbaajVar.zbc().zbd();
        }
        if (zbaajVar.zbH()) {
            return zbaajVar.zbf().zbc();
        }
        return zbaajVar.zbe();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List zbc(zbpb zbpbVar) {
        double sin = Math.sin(Math.toRadians(zbpbVar.zba()));
        double cos = Math.cos(Math.toRadians(zbpbVar.zba()));
        Point[] pointArr = {new Point(zbpbVar.zbd(), zbpbVar.zbe()), new Point((int) (zbpbVar.zbd() + (zbpbVar.zbf() * cos)), (int) (zbpbVar.zbe() + (zbpbVar.zbf() * sin))), new Point((int) (r5.x - (zbpbVar.zbc() * sin)), (int) (pointArr[1].y + (zbpbVar.zbc() * cos))), new Point(pointArr[0].x + (pointArr[2].x - pointArr[1].x), pointArr[0].y + (pointArr[2].y - pointArr[1].y))};
        return Arrays.asList(pointArr);
    }
}
