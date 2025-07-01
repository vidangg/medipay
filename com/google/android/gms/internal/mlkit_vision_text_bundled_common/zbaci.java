package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.media3.extractor.ts.PsExtractor;

/* compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* loaded from: classes3.dex */
final class zbaci implements zbuj {
    static final zbuj zba = new zbaci();

    private zbaci() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuj
    public final boolean zba(int i) {
        if (i == 200 || i == 300 || i == 302 || i == 312 || i == 15000 || i == 304 || i == 305) {
            return true;
        }
        switch (i) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                return true;
            default:
                switch (i) {
                    case 9:
                    case 10:
                    case 11:
                    case 12:
                    case 13:
                        return true;
                    default:
                        switch (i) {
                            case 43:
                            case 44:
                            case 45:
                                return true;
                            default:
                                switch (i) {
                                    case 220:
                                    case 221:
                                    case 222:
                                    case 223:
                                    case 224:
                                    case 225:
                                    case 226:
                                    case 227:
                                        return true;
                                    default:
                                        switch (i) {
                                            case 238:
                                            case 239:
                                            case PsExtractor.VIDEO_STREAM_MASK /* 240 */:
                                            case 241:
                                            case 242:
                                            case 243:
                                                return true;
                                            default:
                                                switch (i) {
                                                    case 314:
                                                    case 315:
                                                    case TypedValues.AttributesType.TYPE_PATH_ROTATE /* 316 */:
                                                        return true;
                                                    default:
                                                        return false;
                                                }
                                        }
                                }
                        }
                }
        }
    }
}
