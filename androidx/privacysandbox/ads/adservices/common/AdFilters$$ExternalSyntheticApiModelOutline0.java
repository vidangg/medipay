package androidx.privacysandbox.ads.adservices.common;

import android.adservices.adid.AdId;
import android.adservices.adid.AdIdManager;
import android.adservices.adselection.AdSelectionConfig;
import android.adservices.adselection.AdSelectionFromOutcomesConfig;
import android.adservices.adselection.AdSelectionManager;
import android.adservices.adselection.AdSelectionOutcome;
import android.adservices.adselection.GetAdSelectionDataOutcome;
import android.adservices.adselection.GetAdSelectionDataRequest;
import android.adservices.adselection.PersistAdSelectionResultRequest;
import android.adservices.adselection.ReportEventRequest;
import android.adservices.adselection.ReportImpressionRequest;
import android.adservices.adselection.UpdateAdCounterHistogramRequest;
import android.adservices.appsetid.AppSetId;
import android.adservices.appsetid.AppSetIdManager;
import android.adservices.common.AdData;
import android.adservices.common.AdFilters;
import android.adservices.common.FrequencyCapFilters;
import android.adservices.common.KeyedFrequencyCap;
import android.adservices.customaudience.CustomAudienceManager;
import android.adservices.customaudience.JoinCustomAudienceRequest;
import android.adservices.customaudience.LeaveCustomAudienceRequest;
import android.adservices.customaudience.TrustedBiddingData;
import java.time.Duration;

/* compiled from: D8$$SyntheticClass */
/* loaded from: classes3.dex */
public final /* synthetic */ class AdFilters$$ExternalSyntheticApiModelOutline0 {
    public static /* bridge */ /* synthetic */ AdId m(Object obj) {
        return (AdId) obj;
    }

    /* renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ AdIdManager m554m(Object obj) {
        return (AdIdManager) obj;
    }

    public static /* synthetic */ AdSelectionConfig.Builder m() {
        return new AdSelectionConfig.Builder();
    }

    /* renamed from: m, reason: collision with other method in class */
    public static /* synthetic */ AdSelectionFromOutcomesConfig.Builder m555m() {
        return new AdSelectionFromOutcomesConfig.Builder();
    }

    /* renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ AdSelectionManager m556m(Object obj) {
        return (AdSelectionManager) obj;
    }

    /* renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ AdSelectionOutcome m557m(Object obj) {
        return (AdSelectionOutcome) obj;
    }

    /* renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ GetAdSelectionDataOutcome m558m(Object obj) {
        return (GetAdSelectionDataOutcome) obj;
    }

    /* renamed from: m, reason: collision with other method in class */
    public static /* synthetic */ GetAdSelectionDataRequest.Builder m559m() {
        return new GetAdSelectionDataRequest.Builder();
    }

    /* renamed from: m, reason: collision with other method in class */
    public static /* synthetic */ PersistAdSelectionResultRequest.Builder m560m() {
        return new PersistAdSelectionResultRequest.Builder();
    }

    public static /* synthetic */ ReportEventRequest.Builder m(long j, String str, String str2, int i) {
        return new ReportEventRequest.Builder(j, str, str2, i);
    }

    public static /* synthetic */ ReportImpressionRequest m(long j) {
        return new ReportImpressionRequest(j);
    }

    public static /* synthetic */ ReportImpressionRequest m(long j, AdSelectionConfig adSelectionConfig) {
        return new ReportImpressionRequest(j, adSelectionConfig);
    }

    public static /* synthetic */ UpdateAdCounterHistogramRequest.Builder m(long j, int i, android.adservices.common.AdTechIdentifier adTechIdentifier) {
        return new UpdateAdCounterHistogramRequest.Builder(j, i, adTechIdentifier);
    }

    /* renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ AppSetId m561m(Object obj) {
        return (AppSetId) obj;
    }

    /* renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ AppSetIdManager m563m(Object obj) {
        return (AppSetIdManager) obj;
    }

    /* renamed from: m, reason: collision with other method in class */
    public static /* synthetic */ AdData.Builder m564m() {
        return new AdData.Builder();
    }

    /* renamed from: m, reason: collision with other method in class */
    public static /* synthetic */ AdFilters.Builder m565m() {
        return new AdFilters.Builder();
    }

    /* renamed from: m, reason: collision with other method in class */
    public static /* synthetic */ FrequencyCapFilters.Builder m567m() {
        return new FrequencyCapFilters.Builder();
    }

    public static /* synthetic */ KeyedFrequencyCap.Builder m(int i, int i2, Duration duration) {
        return new KeyedFrequencyCap.Builder(i, i2, duration);
    }

    /* renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ CustomAudienceManager m569m(Object obj) {
        return (CustomAudienceManager) obj;
    }

    /* renamed from: m, reason: collision with other method in class */
    public static /* synthetic */ JoinCustomAudienceRequest.Builder m570m() {
        return new JoinCustomAudienceRequest.Builder();
    }

    /* renamed from: m, reason: collision with other method in class */
    public static /* synthetic */ LeaveCustomAudienceRequest.Builder m571m() {
        return new LeaveCustomAudienceRequest.Builder();
    }

    /* renamed from: m, reason: collision with other method in class */
    public static /* synthetic */ TrustedBiddingData.Builder m572m() {
        return new TrustedBiddingData.Builder();
    }

    /* renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ Class m574m() {
        return AdSelectionManager.class;
    }

    /* renamed from: m, reason: collision with other method in class */
    public static /* synthetic */ void m576m() {
    }

    public static /* bridge */ /* synthetic */ Class m$1() {
        return AppSetIdManager.class;
    }

    /* renamed from: m$1, reason: collision with other method in class */
    public static /* synthetic */ void m579m$1() {
    }

    public static /* bridge */ /* synthetic */ Class m$2() {
        return CustomAudienceManager.class;
    }

    /* renamed from: m$2, reason: collision with other method in class */
    public static /* synthetic */ void m580m$2() {
    }

    public static /* synthetic */ void m$3() {
    }
}
