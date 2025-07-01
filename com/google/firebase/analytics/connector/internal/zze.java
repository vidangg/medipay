package com.google.firebase.analytics.connector.internal;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.android.gms.measurement.internal.zzjy;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-measurement-api@@22.4.0 */
/* loaded from: classes4.dex */
public final class zze implements zza {
    final Set zza;
    private final AnalyticsConnector.AnalyticsConnectorListener zzb;
    private final AppMeasurementSdk zzc;
    private final zzd zzd;

    public zze(AppMeasurementSdk appMeasurementSdk, AnalyticsConnector.AnalyticsConnectorListener analyticsConnectorListener) {
        this.zzb = analyticsConnectorListener;
        this.zzc = appMeasurementSdk;
        zzd zzdVar = new zzd(this);
        this.zzd = zzdVar;
        appMeasurementSdk.registerOnMeasurementEventListener(zzdVar);
        this.zza = new HashSet();
    }

    @Override // com.google.firebase.analytics.connector.internal.zza
    public final AnalyticsConnector.AnalyticsConnectorListener zza() {
        return this.zzb;
    }

    @Override // com.google.firebase.analytics.connector.internal.zza
    public final void zzb(Set set) {
        Set set2 = this.zza;
        set2.clear();
        HashSet hashSet = new HashSet();
        Iterator it = set.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (hashSet.size() >= 50) {
                break;
            }
            int i = zzc.zza;
            if (str != null && str.length() != 0) {
                int codePointAt = str.codePointAt(0);
                if (!Character.isLetter(codePointAt)) {
                    if (codePointAt == 95) {
                        codePointAt = 95;
                    }
                }
                int length = str.length();
                int charCount = Character.charCount(codePointAt);
                while (true) {
                    if (charCount >= length) {
                        if (str.length() != 0) {
                            int codePointAt2 = str.codePointAt(0);
                            if (Character.isLetter(codePointAt2)) {
                                int length2 = str.length();
                                int charCount2 = Character.charCount(codePointAt2);
                                while (true) {
                                    if (charCount2 < length2) {
                                        int codePointAt3 = str.codePointAt(charCount2);
                                        if (codePointAt3 == 95 || Character.isLetterOrDigit(codePointAt3)) {
                                            charCount2 += Character.charCount(codePointAt3);
                                        }
                                    } else {
                                        String zzb = zzjy.zzb(str);
                                        if (zzb != null) {
                                            str = zzb;
                                        }
                                        Preconditions.checkNotNull(str);
                                        hashSet.add(str);
                                    }
                                }
                            }
                        }
                    } else {
                        int codePointAt4 = str.codePointAt(charCount);
                        if (codePointAt4 == 95 || Character.isLetterOrDigit(codePointAt4)) {
                            charCount += Character.charCount(codePointAt4);
                        }
                    }
                }
            }
        }
        set2.addAll(hashSet);
    }

    @Override // com.google.firebase.analytics.connector.internal.zza
    public final void zzc() {
        this.zza.clear();
    }
}
