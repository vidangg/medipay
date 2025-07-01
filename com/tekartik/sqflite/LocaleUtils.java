package com.tekartik.sqflite;

import java.util.Locale;

/* loaded from: classes4.dex */
public class LocaleUtils {
    static Locale localeForLanguateTag(String str) {
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
