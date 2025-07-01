package com.google.mlkit.common.internal.model;

import com.google.mlkit.common.internal.model.ModelUtils;

/* compiled from: com.google.mlkit:common@@18.11.0 */
/* loaded from: classes4.dex */
final class AutoValue_ModelUtils_AutoMLManifest extends ModelUtils.AutoMLManifest {
    private final String zza;
    private final String zzb;
    private final String zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoValue_ModelUtils_AutoMLManifest(String str, String str2, String str3) {
        if (str == null) {
            throw new NullPointerException("Null modelType");
        }
        this.zza = str;
        if (str2 != null) {
            this.zzb = str2;
            if (str3 != null) {
                this.zzc = str3;
                return;
            }
            throw new NullPointerException("Null labelsFile");
        }
        throw new NullPointerException("Null modelFile");
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ModelUtils.AutoMLManifest) {
            ModelUtils.AutoMLManifest autoMLManifest = (ModelUtils.AutoMLManifest) obj;
            if (this.zza.equals(autoMLManifest.getModelType()) && this.zzb.equals(autoMLManifest.getModelFile()) && this.zzc.equals(autoMLManifest.getLabelsFile())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.mlkit.common.internal.model.ModelUtils.AutoMLManifest
    public String getLabelsFile() {
        return this.zzc;
    }

    @Override // com.google.mlkit.common.internal.model.ModelUtils.AutoMLManifest
    public String getModelFile() {
        return this.zzb;
    }

    @Override // com.google.mlkit.common.internal.model.ModelUtils.AutoMLManifest
    public String getModelType() {
        return this.zza;
    }

    public final int hashCode() {
        return ((((this.zza.hashCode() ^ 1000003) * 1000003) ^ this.zzb.hashCode()) * 1000003) ^ this.zzc.hashCode();
    }

    public final String toString() {
        return "AutoMLManifest{modelType=" + this.zza + ", modelFile=" + this.zzb + ", labelsFile=" + this.zzc + "}";
    }
}
