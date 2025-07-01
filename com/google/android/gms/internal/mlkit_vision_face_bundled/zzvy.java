package com.google.android.gms.internal.mlkit_vision_face_bundled;

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
/* compiled from: com.google.mlkit:face-detection@@16.1.7 */
/* loaded from: classes3.dex */
public final class zzvy {
    private static final char[] zza;

    static {
        char[] cArr = new char[80];
        zza = cArr;
        Arrays.fill(cArr, ' ');
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String zza(zzvw zzvwVar, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("# ");
        sb.append(str);
        zzd(zzvwVar, sb, 0);
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zzb(StringBuilder sb, int i, String str, Object obj) {
        if (obj instanceof List) {
            Iterator it = ((List) obj).iterator();
            while (it.hasNext()) {
                zzb(sb, i, str, it.next());
            }
            return;
        }
        if (obj instanceof Map) {
            Iterator it2 = ((Map) obj).entrySet().iterator();
            while (it2.hasNext()) {
                zzb(sb, i, str, (Map.Entry) it2.next());
            }
            return;
        }
        sb.append('\n');
        zzc(i, sb);
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
            sb.append(zzwt.zza(new zztt(((String) obj).getBytes(zzvc.zza))));
            sb.append(Typography.quote);
            return;
        }
        if (obj instanceof zztu) {
            sb.append(": \"");
            sb.append(zzwt.zza((zztu) obj));
            sb.append(Typography.quote);
            return;
        }
        if (obj instanceof zzuw) {
            sb.append(" {");
            zzd((zzuw) obj, sb, i + 2);
            sb.append(IOUtils.LINE_SEPARATOR_UNIX);
            zzc(i, sb);
            sb.append("}");
            return;
        }
        if (obj instanceof Map.Entry) {
            int i3 = i + 2;
            sb.append(" {");
            Map.Entry entry = (Map.Entry) obj;
            zzb(sb, i3, "key", entry.getKey());
            zzb(sb, i3, "value", entry.getValue());
            sb.append(IOUtils.LINE_SEPARATOR_UNIX);
            zzc(i, sb);
            sb.append("}");
            return;
        }
        sb.append(": ");
        sb.append(obj);
    }

    private static void zzc(int i, StringBuilder sb) {
        while (i > 0) {
            int i2 = 80;
            if (i <= 80) {
                i2 = i;
            }
            sb.append(zza, 0, i2);
            i -= i2;
        }
    }

    private static void zzd(zzvw zzvwVar, StringBuilder sb, int i) {
        int i2;
        boolean equals;
        Method method;
        Method method2;
        HashSet hashSet = new HashSet();
        HashMap hashMap = new HashMap();
        TreeMap treeMap = new TreeMap();
        Method[] declaredMethods = zzvwVar.getClass().getDeclaredMethods();
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
                            Object zzB = zzuw.zzB(method4, zzvwVar, new Object[0]);
                            if (method5 == null) {
                                if (zzB instanceof Boolean) {
                                    if (!((Boolean) zzB).booleanValue()) {
                                    }
                                    zzb(sb, i, substring, zzB);
                                } else if (zzB instanceof Integer) {
                                    if (((Integer) zzB).intValue() == 0) {
                                    }
                                    zzb(sb, i, substring, zzB);
                                } else if (zzB instanceof Float) {
                                    if (Float.floatToRawIntBits(((Float) zzB).floatValue()) == 0) {
                                    }
                                    zzb(sb, i, substring, zzB);
                                } else if (!(zzB instanceof Double)) {
                                    if (zzB instanceof String) {
                                        equals = zzB.equals("");
                                    } else if (zzB instanceof zztu) {
                                        equals = zzB.equals(zztu.zzb);
                                    } else if (zzB instanceof zzvw) {
                                        if (zzB == ((zzvw) zzB).zzq()) {
                                        }
                                        zzb(sb, i, substring, zzB);
                                    } else {
                                        if ((zzB instanceof Enum) && ((Enum) zzB).ordinal() == 0) {
                                        }
                                        zzb(sb, i, substring, zzB);
                                    }
                                    if (equals) {
                                    }
                                    zzb(sb, i, substring, zzB);
                                } else {
                                    if (Double.doubleToRawLongBits(((Double) zzB).doubleValue()) == 0) {
                                    }
                                    zzb(sb, i, substring, zzB);
                                }
                            } else {
                                if (!((Boolean) zzuw.zzB(method5, zzvwVar, new Object[0])).booleanValue()) {
                                }
                                zzb(sb, i, substring, zzB);
                            }
                        }
                    }
                } else {
                    zzb(sb, i, substring.substring(0, substring.length() - 3), zzuw.zzB(method, zzvwVar, new Object[0]));
                }
            } else {
                zzb(sb, i, substring.substring(0, substring.length() - 4), zzuw.zzB(method2, zzvwVar, new Object[0]));
            }
            i2 = 3;
        }
        if (zzvwVar instanceof zzus) {
            Iterator zzf = ((zzus) zzvwVar).zzb.zzf();
            while (zzf.hasNext()) {
                Map.Entry entry2 = (Map.Entry) zzf.next();
                zzb(sb, i, "[202056002]", entry2.getValue());
            }
        }
        zzww zzwwVar = ((zzuw) zzvwVar).zzc;
        if (zzwwVar != null) {
            zzwwVar.zzi(sb, i);
        }
    }
}
