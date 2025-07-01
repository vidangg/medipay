package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import kotlin.text.Typography;
import org.apache.commons.io.IOUtils;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
public final class zbvo {
    private static final char[] zba;

    static {
        char[] cArr = new char[80];
        zba = cArr;
        Arrays.fill(cArr, ' ');
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String zba(zbvm zbvmVar, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("# ");
        sb.append(str);
        zbd(zbvmVar, sb, 0);
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zbb(StringBuilder sb, int i, String str, Object obj) {
        if (obj instanceof List) {
            Iterator it = ((List) obj).iterator();
            while (it.hasNext()) {
                zbb(sb, i, str, it.next());
            }
            return;
        }
        if (obj instanceof Map) {
            Iterator it2 = ((Map) obj).entrySet().iterator();
            while (it2.hasNext()) {
                zbb(sb, i, str, (Map.Entry) it2.next());
            }
            return;
        }
        sb.append('\n');
        zbc(i, sb);
        if (!str.isEmpty()) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(Character.toLowerCase(str.charAt(0)));
            for (int i2 = 1; i2 < str.length(); i2++) {
                char charAt = str.charAt(i2);
                if (Character.isUpperCase(charAt)) {
                    sb2.append("_");
                }
                sb2.append(Character.toLowerCase(charAt));
            }
            str = sb2.toString();
        }
        sb.append(str);
        if (obj instanceof String) {
            sb.append(": \"");
            sb.append(zbwj.zba(new zbtb(((String) obj).getBytes(zbuo.zba))));
            sb.append(Typography.quote);
            return;
        }
        if (obj instanceof zbtc) {
            sb.append(": \"");
            sb.append(zbwj.zba((zbtc) obj));
            sb.append(Typography.quote);
            return;
        }
        if (obj instanceof zbuf) {
            sb.append(" {");
            zbd((zbuf) obj, sb, i + 2);
            sb.append(IOUtils.LINE_SEPARATOR_UNIX);
            zbc(i, sb);
            sb.append("}");
            return;
        }
        if (obj instanceof Map.Entry) {
            int i3 = i + 2;
            sb.append(" {");
            Map.Entry entry = (Map.Entry) obj;
            zbb(sb, i3, "key", entry.getKey());
            zbb(sb, i3, "value", entry.getValue());
            sb.append(IOUtils.LINE_SEPARATOR_UNIX);
            zbc(i, sb);
            sb.append("}");
            return;
        }
        sb.append(": ");
        sb.append(obj);
    }

    private static void zbc(int i, StringBuilder sb) {
        while (i > 0) {
            int i2 = 80;
            if (i <= 80) {
                i2 = i;
            }
            sb.append(zba, 0, i2);
            i -= i2;
        }
    }

    private static void zbd(zbvm zbvmVar, StringBuilder sb, int i) {
        int i2;
        boolean equals;
        Method method;
        Method method2;
        HashSet hashSet = new HashSet();
        HashMap hashMap = new HashMap();
        TreeMap treeMap = new TreeMap();
        Method[] declaredMethods = zbvmVar.getClass().getDeclaredMethods();
        int length = declaredMethods.length;
        int i3 = 0;
        while (true) {
            i2 = 3;
            if (i3 >= length) {
                break;
            }
            Method method3 = declaredMethods[i3];
            if (!Modifier.isStatic(method3.getModifiers()) && method3.getName().length() >= 3) {
                if (method3.getName().startsWith("set")) {
                    hashSet.add(method3.getName());
                } else if (Modifier.isPublic(method3.getModifiers()) && method3.getParameterTypes().length == 0) {
                    if (method3.getName().startsWith("has")) {
                        hashMap.put(method3.getName(), method3);
                    } else if (method3.getName().startsWith("get")) {
                        treeMap.put(method3.getName(), method3);
                    }
                }
            }
            i3++;
        }
        for (Map.Entry entry : treeMap.entrySet()) {
            String substring = ((String) entry.getKey()).substring(i2);
            if (!substring.endsWith("List") || substring.endsWith("OrBuilderList") || substring.equals("List") || (method2 = (Method) entry.getValue()) == null || !method2.getReturnType().equals(List.class)) {
                if (!substring.endsWith("Map") || substring.equals("Map") || (method = (Method) entry.getValue()) == null || !method.getReturnType().equals(Map.class) || method.isAnnotationPresent(Deprecated.class) || !Modifier.isPublic(method.getModifiers())) {
                    if (hashSet.contains("set".concat(String.valueOf(substring))) && (!substring.endsWith("Bytes") || !treeMap.containsKey("get".concat(String.valueOf(substring.substring(0, substring.length() - 5)))))) {
                        Method method4 = (Method) entry.getValue();
                        Method method5 = (Method) hashMap.get("has".concat(String.valueOf(substring)));
                        if (method4 != null) {
                            Object zbz = zbuf.zbz(method4, zbvmVar, new Object[0]);
                            if (method5 == null) {
                                if (zbz instanceof Boolean) {
                                    if (!((Boolean) zbz).booleanValue()) {
                                    }
                                    zbb(sb, i, substring, zbz);
                                } else if (zbz instanceof Integer) {
                                    if (((Integer) zbz).intValue() == 0) {
                                    }
                                    zbb(sb, i, substring, zbz);
                                } else if (zbz instanceof Float) {
                                    if (Float.floatToRawIntBits(((Float) zbz).floatValue()) == 0) {
                                    }
                                    zbb(sb, i, substring, zbz);
                                } else if (!(zbz instanceof Double)) {
                                    if (zbz instanceof String) {
                                        equals = zbz.equals("");
                                    } else if (zbz instanceof zbtc) {
                                        equals = zbz.equals(zbtc.zbb);
                                    } else if (zbz instanceof zbvm) {
                                        if (zbz == ((zbvm) zbz).zbm()) {
                                        }
                                        zbb(sb, i, substring, zbz);
                                    } else {
                                        if ((zbz instanceof Enum) && ((Enum) zbz).ordinal() == 0) {
                                        }
                                        zbb(sb, i, substring, zbz);
                                    }
                                    if (equals) {
                                    }
                                    zbb(sb, i, substring, zbz);
                                } else {
                                    if (Double.doubleToRawLongBits(((Double) zbz).doubleValue()) == 0) {
                                    }
                                    zbb(sb, i, substring, zbz);
                                }
                            } else {
                                if (!((Boolean) zbuf.zbz(method5, zbvmVar, new Object[0])).booleanValue()) {
                                }
                                zbb(sb, i, substring, zbz);
                            }
                        }
                    }
                } else {
                    zbb(sb, i, substring.substring(0, substring.length() - 3), zbuf.zbz(method, zbvmVar, new Object[0]));
                }
            } else {
                zbb(sb, i, substring.substring(0, substring.length() - 4), zbuf.zbz(method2, zbvmVar, new Object[0]));
            }
            i2 = 3;
        }
        if (zbvmVar instanceof zbub) {
            Iterator zbg = ((zbub) zbvmVar).zbb.zbg();
            while (zbg.hasNext()) {
                Map.Entry entry2 = (Map.Entry) zbg.next();
                zbb(sb, i, "[32149011]", entry2.getValue());
            }
        }
        zbwm zbwmVar = ((zbuf) zbvmVar).zbc;
        if (zbwmVar != null) {
            zbwmVar.zbi(sb, i);
        }
    }
}
