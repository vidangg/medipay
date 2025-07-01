package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import javax.annotation.CheckForNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
public final class zbkw extends zbkx {
    final transient int zba;
    final transient int zbb;
    final /* synthetic */ zbkx zbc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zbkw(zbkx zbkxVar, int i, int i2) {
        this.zbc = zbkxVar;
        this.zba = i;
        this.zbb = i2;
    }

    @Override // java.util.List
    public final Object get(int i) {
        zbkj.zba(i, this.zbb, FirebaseAnalytics.Param.INDEX);
        return this.zbc.get(i + this.zba);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zbb;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbkx, java.util.List
    public final /* bridge */ /* synthetic */ List subList(int i, int i2) {
        return subList(i, i2);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbkt
    final int zbb() {
        return this.zbc.zbc() + this.zba + this.zbb;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbkt
    public final int zbc() {
        return this.zbc.zbc() + this.zba;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbkt
    @CheckForNull
    public final Object[] zbe() {
        return this.zbc.zbe();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbkx
    /* renamed from: zbf */
    public final zbkx subList(int i, int i2) {
        zbkj.zbd(i, i2, this.zbb);
        int i3 = this.zba;
        return this.zbc.subList(i + i3, i2 + i3);
    }
}
