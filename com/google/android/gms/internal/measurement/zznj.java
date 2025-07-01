package com.google.android.gms.internal.measurement;

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
/* compiled from: com.google.android.gms:play-services-measurement-base@@22.4.0 */
/* loaded from: classes3.dex */
public final class zznj {
    private static final char[] zza;

    static {
        char[] cArr = new char[80];
        zza = cArr;
        Arrays.fill(cArr, ' ');
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String zza(zznh zznhVar, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("# ");
        sb.append(str);
        zzd(zznhVar, sb, 0);
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
            zzld zzldVar = zzld.zzb;
            sb.append(zzoc.zza(new zzlb(((String) obj).getBytes(zzmk.zza))));
            sb.append(Typography.quote);
            return;
        }
        if (obj instanceof zzld) {
            sb.append(": \"");
            sb.append(zzoc.zza((zzld) obj));
            sb.append(Typography.quote);
            return;
        }
        if (obj instanceof zzmd) {
            sb.append(" {");
            zzd((zzmd) obj, sb, i + 2);
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

    private static void zzd(zznh zznhVar, StringBuilder sb, int i) {
        int i2;
        boolean equals;
        Method method;
        Method method2;
        HashSet hashSet = new HashSet();
        HashMap hashMap = new HashMap();
        TreeMap treeMap = new TreeMap();
        Method[] declaredMethods = zznhVar.getClass().getDeclaredMethods();
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
                            Object zzcp = zzmd.zzcp(method4, zznhVar, new Object[0]);
                            if (method5 == null) {
                                if (zzcp instanceof Boolean) {
                                    if (!((Boolean) zzcp).booleanValue()) {
                                    }
                                    zzb(sb, i, substring, zzcp);
                                } else if (zzcp instanceof Integer) {
                                    if (((Integer) zzcp).intValue() == 0) {
                                    }
                                    zzb(sb, i, substring, zzcp);
                                } else if (zzcp instanceof Float) {
                                    if (Float.floatToRawIntBits(((Float) zzcp).floatValue()) == 0) {
                                    }
                                    zzb(sb, i, substring, zzcp);
                                } else if (!(zzcp instanceof Double)) {
                                    if (zzcp instanceof String) {
                                        equals = zzcp.equals("");
                                    } else if (zzcp instanceof zzld) {
                                        equals = zzcp.equals(zzld.zzb);
                                    } else if (zzcp instanceof zznh) {
                                        if (zzcp == ((zznh) zzcp).zzcC()) {
                                        }
                                        zzb(sb, i, substring, zzcp);
                                    } else {
                                        if ((zzcp instanceof Enum) && ((Enum) zzcp).ordinal() == 0) {
                                        }
                                        zzb(sb, i, substring, zzcp);
                                    }
                                    if (equals) {
                                    }
                                    zzb(sb, i, substring, zzcp);
                                } else {
                                    if (Double.doubleToRawLongBits(((Double) zzcp).doubleValue()) == 0) {
                                    }
                                    zzb(sb, i, substring, zzcp);
                                }
                            } else {
                                if (!((Boolean) zzmd.zzcp(method5, zznhVar, new Object[0])).booleanValue()) {
                                }
                                zzb(sb, i, substring, zzcp);
                            }
                        }
                    }
                } else {
                    zzb(sb, i, substring.substring(0, substring.length() - 3), zzmd.zzcp(method, zznhVar, new Object[0]));
                }
            } else {
                zzb(sb, i, substring.substring(0, substring.length() - 4), zzmd.zzcp(method2, zznhVar, new Object[0]));
            }
            i2 = 3;
        }
        if (zznhVar instanceof zzma) {
            Iterator zze = ((zzma) zznhVar).zzb.zze();
            if (zze.hasNext()) {
                throw null;
            }
        }
        zzof zzofVar = ((zzmd) zznhVar).zzc;
        if (zzofVar != null) {
            zzofVar.zzi(sb, i);
        }
    }
}
