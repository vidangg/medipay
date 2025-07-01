package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.media3.exoplayer.upstream.CmcdData;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzqr;
import java.util.Arrays;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.4.0 */
/* loaded from: classes3.dex */
public final class zzho {
    final /* synthetic */ zzht zza;
    private final String zzb;
    private final Bundle zzc;
    private Bundle zzd;

    public zzho(zzht zzhtVar, String str, Bundle bundle) {
        this.zza = zzhtVar;
        Preconditions.checkNotEmpty(str);
        this.zzb = str;
        this.zzc = new Bundle();
    }

    public final void zzb(Bundle bundle) {
        Bundle bundle2;
        zzht zzhtVar;
        JSONObject jSONObject;
        zzio zzioVar;
        if (bundle == null) {
            bundle2 = new Bundle();
        } else {
            bundle2 = new Bundle(bundle);
        }
        zzht zzhtVar2 = this.zza;
        SharedPreferences.Editor edit = zzhtVar2.zzb().edit();
        if (bundle2.size() == 0) {
            edit.remove(this.zzb);
        } else {
            String str = this.zzb;
            JSONArray jSONArray = new JSONArray();
            for (String str2 : bundle2.keySet()) {
                Object obj = bundle2.get(str2);
                if (obj != null) {
                    try {
                        jSONObject = new JSONObject();
                        jSONObject.put("n", str2);
                        zzqr.zzb();
                        zzioVar = zzhtVar2.zzu;
                        zzhtVar = zzhtVar2;
                    } catch (JSONException e) {
                        e = e;
                        zzhtVar = zzhtVar2;
                    }
                    if (!zzioVar.zzf().zzx(null, zzgi.zzaW)) {
                        jSONObject.put("v", obj.toString());
                        if (obj instanceof String) {
                            jSONObject.put("t", CmcdData.Factory.STREAMING_FORMAT_SS);
                        } else if (obj instanceof Long) {
                            jSONObject.put("t", CmcdData.Factory.STREAM_TYPE_LIVE);
                        } else if (!(obj instanceof Double)) {
                            zzioVar.zzaW().zze().zzb("Cannot serialize bundle value to SharedPreferences. Type", obj.getClass());
                            zzhtVar2 = zzhtVar;
                        } else {
                            jSONObject.put("t", "d");
                        }
                        jSONArray.put(jSONObject);
                        zzhtVar2 = zzhtVar;
                    } else {
                        try {
                        } catch (JSONException e2) {
                            e = e2;
                            this.zza.zzu.zzaW().zze().zzb("Cannot serialize bundle value to SharedPreferences", e);
                            zzhtVar2 = zzhtVar;
                        }
                        if (obj instanceof String) {
                            jSONObject.put("v", obj.toString());
                            jSONObject.put("t", CmcdData.Factory.STREAMING_FORMAT_SS);
                        } else if (obj instanceof Long) {
                            jSONObject.put("v", obj.toString());
                            jSONObject.put("t", CmcdData.Factory.STREAM_TYPE_LIVE);
                        } else if (obj instanceof int[]) {
                            jSONObject.put("v", Arrays.toString((int[]) obj));
                            jSONObject.put("t", "ia");
                        } else if (obj instanceof long[]) {
                            jSONObject.put("v", Arrays.toString((long[]) obj));
                            jSONObject.put("t", "la");
                        } else if (!(obj instanceof Double)) {
                            zzioVar.zzaW().zze().zzb("Cannot serialize bundle value to SharedPreferences. Type", obj.getClass());
                            zzhtVar2 = zzhtVar;
                        } else {
                            jSONObject.put("v", obj.toString());
                            jSONObject.put("t", "d");
                        }
                        jSONArray.put(jSONObject);
                        zzhtVar2 = zzhtVar;
                    }
                }
            }
            edit.putString(str, jSONArray.toString());
        }
        edit.apply();
        this.zzd = bundle2;
    }

    public final Bundle zza() {
        char c;
        if (this.zzd == null) {
            zzht zzhtVar = this.zza;
            String string = zzhtVar.zzb().getString(this.zzb, null);
            if (string != null) {
                try {
                    Bundle bundle = new Bundle();
                    JSONArray jSONArray = new JSONArray(string);
                    for (int i = 0; i < jSONArray.length(); i++) {
                        try {
                            JSONObject jSONObject = jSONArray.getJSONObject(i);
                            String string2 = jSONObject.getString("n");
                            String string3 = jSONObject.getString("t");
                            int hashCode = string3.hashCode();
                            if (hashCode == 100) {
                                if (string3.equals("d")) {
                                    c = 1;
                                }
                                c = 65535;
                            } else if (hashCode == 108) {
                                if (string3.equals(CmcdData.Factory.STREAM_TYPE_LIVE)) {
                                    c = 2;
                                }
                                c = 65535;
                            } else if (hashCode == 115) {
                                if (string3.equals(CmcdData.Factory.STREAMING_FORMAT_SS)) {
                                    c = 0;
                                }
                                c = 65535;
                            } else if (hashCode != 3352) {
                                if (hashCode == 3445 && string3.equals("la")) {
                                    c = 4;
                                }
                                c = 65535;
                            } else {
                                if (string3.equals("ia")) {
                                    c = 3;
                                }
                                c = 65535;
                            }
                            if (c == 0) {
                                bundle.putString(string2, jSONObject.getString("v"));
                            } else if (c == 1) {
                                bundle.putDouble(string2, Double.parseDouble(jSONObject.getString("v")));
                            } else if (c == 2) {
                                bundle.putLong(string2, Long.parseLong(jSONObject.getString("v")));
                            } else if (c == 3) {
                                zzqr.zzb();
                                if (zzhtVar.zzu.zzf().zzx(null, zzgi.zzaW)) {
                                    JSONArray jSONArray2 = new JSONArray(jSONObject.getString("v"));
                                    int length = jSONArray2.length();
                                    int[] iArr = new int[length];
                                    for (int i2 = 0; i2 < length; i2++) {
                                        iArr[i2] = jSONArray2.optInt(i2);
                                    }
                                    bundle.putIntArray(string2, iArr);
                                }
                            } else if (c != 4) {
                                zzhtVar.zzu.zzaW().zze().zzb("Unrecognized persisted bundle type. Type", string3);
                            } else {
                                zzqr.zzb();
                                if (zzhtVar.zzu.zzf().zzx(null, zzgi.zzaW)) {
                                    JSONArray jSONArray3 = new JSONArray(jSONObject.getString("v"));
                                    int length2 = jSONArray3.length();
                                    long[] jArr = new long[length2];
                                    for (int i3 = 0; i3 < length2; i3++) {
                                        jArr[i3] = jSONArray3.optLong(i3);
                                    }
                                    bundle.putLongArray(string2, jArr);
                                }
                            }
                        } catch (NumberFormatException | JSONException unused) {
                            this.zza.zzu.zzaW().zze().zza("Error reading value from SharedPreferences. Value dropped");
                        }
                    }
                    this.zzd = bundle;
                } catch (JSONException unused2) {
                    this.zza.zzu.zzaW().zze().zza("Error loading bundle from SharedPreferences. Values will be lost");
                }
            }
            if (this.zzd == null) {
                this.zzd = this.zzc;
            }
        }
        return new Bundle((Bundle) Preconditions.checkNotNull(this.zzd));
    }
}
