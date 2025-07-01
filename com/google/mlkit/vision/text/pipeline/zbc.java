package com.google.mlkit.vision.text.pipeline;

import com.google.mlkit.vision.text.pipeline.VkpTextRecognizerOptions;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes4.dex */
final class zbc extends VkpTextRecognizerOptions.Builder {
    private String zba;
    private String zbb;
    private String zbc;
    private boolean zbd;
    private byte zbe;

    @Override // com.google.mlkit.vision.text.pipeline.VkpTextRecognizerOptions.Builder
    public final VkpTextRecognizerOptions build() {
        String str;
        String str2;
        String str3;
        if (this.zbe != 1 || (str = this.zba) == null || (str2 = this.zbb) == null || (str3 = this.zbc) == null) {
            StringBuilder sb = new StringBuilder();
            if (this.zba == null) {
                sb.append(" configLabel");
            }
            if (this.zbb == null) {
                sb.append(" modelDir");
            }
            if (this.zbc == null) {
                sb.append(" languageHint");
            }
            if (this.zbe == 0) {
                sb.append(" enableLowLatencyInBackground");
            }
            throw new IllegalStateException("Missing required properties:".concat(sb.toString()));
        }
        return new zbe(str, str2, str3, this.zbd, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.mlkit.vision.text.pipeline.VkpTextRecognizerOptions.Builder
    public final VkpTextRecognizerOptions.Builder setConfigLabel(String str) {
        if (str == null) {
            throw new NullPointerException("Null configLabel");
        }
        this.zba = str;
        return this;
    }

    @Override // com.google.mlkit.vision.text.pipeline.VkpTextRecognizerOptions.Builder
    public final VkpTextRecognizerOptions.Builder setEnableLowLatencyInBackground(boolean z) {
        this.zbd = z;
        this.zbe = (byte) 1;
        return this;
    }

    @Override // com.google.mlkit.vision.text.pipeline.VkpTextRecognizerOptions.Builder
    public final VkpTextRecognizerOptions.Builder setLanguageHint(String str) {
        if (str == null) {
            throw new NullPointerException("Null languageHint");
        }
        this.zbc = str;
        return this;
    }

    @Override // com.google.mlkit.vision.text.pipeline.VkpTextRecognizerOptions.Builder
    public final VkpTextRecognizerOptions.Builder setModelDir(String str) {
        if (str == null) {
            throw new NullPointerException("Null modelDir");
        }
        this.zbb = str;
        return this;
    }
}
