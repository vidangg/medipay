package com.google.android.odml.image;

/* compiled from: com.google.android.odml:image@@1.0.0-beta1 */
/* loaded from: classes3.dex */
final class zzc extends ImageProperties {
    private final int zza;
    private final int zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzc(int i, int i2, zza zzaVar) {
        this.zza = i;
        this.zzb = i2;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ImageProperties) {
            ImageProperties imageProperties = (ImageProperties) obj;
            if (this.zza == imageProperties.getImageFormat() && this.zzb == imageProperties.getStorageType()) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.odml.image.ImageProperties
    public final int getImageFormat() {
        return this.zza;
    }

    @Override // com.google.android.odml.image.ImageProperties
    public final int getStorageType() {
        return this.zzb;
    }

    public final int hashCode() {
        return ((this.zza ^ 1000003) * 1000003) ^ this.zzb;
    }

    public final String toString() {
        int i = this.zza;
        int i2 = this.zzb;
        StringBuilder sb = new StringBuilder(65);
        sb.append("ImageProperties{imageFormat=");
        sb.append(i);
        sb.append(", storageType=");
        sb.append(i2);
        sb.append("}");
        return sb.toString();
    }
}
