package com.tekartik.sqflite;

import android.database.Cursor;
import android.util.Log;
import com.tekartik.sqflite.dev.Debug;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* loaded from: classes4.dex */
public class Utils {
    public static List<Object> cursorRowToList(Cursor cursor, int i) {
        String str;
        ArrayList arrayList = new ArrayList(i);
        for (int i2 = 0; i2 < i; i2++) {
            Object cursorValue = cursorValue(cursor, i2);
            if (Debug.EXTRA_LOGV) {
                if (cursorValue == null) {
                    str = null;
                } else if (cursorValue.getClass().isArray()) {
                    str = "array(" + cursorValue.getClass().getComponentType().getName() + ")";
                } else {
                    str = cursorValue.getClass().getName();
                }
                StringBuilder sb = new StringBuilder("column ");
                sb.append(i2);
                sb.append(" ");
                sb.append(cursor.getType(i2));
                sb.append(": ");
                sb.append(cursorValue);
                sb.append(str == null ? "" : " (" + str + ")");
                Log.d(Constant.TAG, sb.toString());
            }
            arrayList.add(cursorValue);
        }
        return arrayList;
    }

    public static Object cursorValue(Cursor cursor, int i) {
        int type = cursor.getType(i);
        if (type == 1) {
            return Long.valueOf(cursor.getLong(i));
        }
        if (type == 2) {
            return Double.valueOf(cursor.getDouble(i));
        }
        if (type == 3) {
            return cursor.getString(i);
        }
        if (type != 4) {
            return null;
        }
        return cursor.getBlob(i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Locale localeForLanguateTag(String str) {
        return localeForLanguageTag21(str);
    }

    static Locale localeForLanguageTag21(String str) {
        return Locale.forLanguageTag(str);
    }

    static Locale localeForLanguageTagPre21(String str) {
        String str2;
        String str3;
        String str4;
        String[] split = str.split("-");
        str2 = "";
        if (split.length > 0) {
            String str5 = split[0];
            if (split.length > 1) {
                str4 = split[1];
                str3 = split.length > 2 ? split[split.length - 1] : "";
            } else {
                str3 = "";
                str4 = str3;
            }
            str2 = str5;
        } else {
            str3 = "";
            str4 = str3;
        }
        return new Locale(str2, str4, str3);
    }
}
