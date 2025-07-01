package com.google.android.gms.internal.clearcut;

import androidx.webkit.ProxyConfig;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import kotlin.text.Typography;
import org.apache.commons.io.IOUtils;

/* loaded from: classes3.dex */
public final class zzga {
    public static <T extends zzfz> String zza(T t) {
        if (t == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        try {
            zza(null, t, new StringBuffer(), stringBuffer);
            return stringBuffer.toString();
        } catch (IllegalAccessException e) {
            String valueOf = String.valueOf(e.getMessage());
            return valueOf.length() != 0 ? "Error printing proto: ".concat(valueOf) : new String("Error printing proto: ");
        } catch (InvocationTargetException e2) {
            String valueOf2 = String.valueOf(e2.getMessage());
            return valueOf2.length() != 0 ? "Error printing proto: ".concat(valueOf2) : new String("Error printing proto: ");
        }
    }

    private static void zza(String str, Object obj, StringBuffer stringBuffer, StringBuffer stringBuffer2) throws IllegalAccessException, InvocationTargetException {
        if (obj != null) {
            int i = 0;
            if (!(obj instanceof zzfz)) {
                stringBuffer2.append(stringBuffer).append(zzl(str)).append(": ");
                if (obj instanceof String) {
                    String str2 = (String) obj;
                    if (!str2.startsWith(ProxyConfig.MATCH_HTTP) && str2.length() > 200) {
                        str2 = String.valueOf(str2.substring(0, 200)).concat("[...]");
                    }
                    int length = str2.length();
                    StringBuilder sb = new StringBuilder(length);
                    while (i < length) {
                        char charAt = str2.charAt(i);
                        if (charAt < ' ' || charAt > '~' || charAt == '\"' || charAt == '\'') {
                            sb.append(String.format("\\u%04x", Integer.valueOf(charAt)));
                        } else {
                            sb.append(charAt);
                        }
                        i++;
                    }
                    stringBuffer2.append("\"").append(sb.toString()).append("\"");
                } else if (obj instanceof byte[]) {
                    byte[] bArr = (byte[]) obj;
                    if (bArr == null) {
                        stringBuffer2.append("\"\"");
                    } else {
                        stringBuffer2.append(Typography.quote);
                        while (i < bArr.length) {
                            int i2 = bArr[i] & 255;
                            if (i2 == 92 || i2 == 34) {
                                stringBuffer2.append(IOUtils.DIR_SEPARATOR_WINDOWS).append((char) i2);
                            } else if (i2 < 32 || i2 >= 127) {
                                stringBuffer2.append(String.format("\\%03o", Integer.valueOf(i2)));
                            } else {
                                stringBuffer2.append((char) i2);
                            }
                            i++;
                        }
                        stringBuffer2.append(Typography.quote);
                    }
                } else {
                    stringBuffer2.append(obj);
                }
                stringBuffer2.append(IOUtils.LINE_SEPARATOR_UNIX);
                return;
            }
            int length2 = stringBuffer.length();
            if (str != null) {
                stringBuffer2.append(stringBuffer).append(zzl(str)).append(" <\n");
                stringBuffer.append("  ");
            }
            Class<?> cls = obj.getClass();
            for (Field field : cls.getFields()) {
                int modifiers = field.getModifiers();
                String name = field.getName();
                if (!"cachedSize".equals(name) && (modifiers & 1) == 1 && (modifiers & 8) != 8 && !name.startsWith("_") && !name.endsWith("_")) {
                    Class<?> type = field.getType();
                    Object obj2 = field.get(obj);
                    if (!type.isArray() || type.getComponentType() == Byte.TYPE) {
                        zza(name, obj2, stringBuffer, stringBuffer2);
                    } else {
                        int length3 = obj2 == null ? 0 : Array.getLength(obj2);
                        for (int i3 = 0; i3 < length3; i3++) {
                            zza(name, Array.get(obj2, i3), stringBuffer, stringBuffer2);
                        }
                    }
                }
            }
            Method[] methods = cls.getMethods();
            int length4 = methods.length;
            while (i < length4) {
                String name2 = methods[i].getName();
                if (name2.startsWith("set")) {
                    String substring = name2.substring(3);
                    try {
                        String valueOf = String.valueOf(substring);
                        if (((Boolean) cls.getMethod(valueOf.length() != 0 ? "has".concat(valueOf) : new String("has"), null).invoke(obj, null)).booleanValue()) {
                            String valueOf2 = String.valueOf(substring);
                            zza(substring, cls.getMethod(valueOf2.length() != 0 ? "get".concat(valueOf2) : new String("get"), null).invoke(obj, null), stringBuffer, stringBuffer2);
                        }
                    } catch (NoSuchMethodException unused) {
                    }
                }
                i++;
            }
            if (str != null) {
                stringBuffer.setLength(length2);
                stringBuffer2.append(stringBuffer).append(">\n");
            }
        }
    }

    private static String zzl(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (i == 0) {
                charAt = Character.toLowerCase(charAt);
            } else if (Character.isUpperCase(charAt)) {
                stringBuffer.append('_').append(Character.toLowerCase(charAt));
            }
            stringBuffer.append(charAt);
        }
        return stringBuffer.toString();
    }
}
