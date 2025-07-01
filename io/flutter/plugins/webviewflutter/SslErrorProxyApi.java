package io.flutter.plugins.webviewflutter;

import android.net.http.SslCertificate;
import android.net.http.SslError;

/* loaded from: classes4.dex */
class SslErrorProxyApi extends PigeonApiSslError {
    /* JADX INFO: Access modifiers changed from: package-private */
    public SslErrorProxyApi(ProxyApiRegistrar proxyApiRegistrar) {
        super(proxyApiRegistrar);
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiSslError
    public ProxyApiRegistrar getPigeonRegistrar() {
        return (ProxyApiRegistrar) super.getPigeonRegistrar();
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiSslError
    public SslCertificate certificate(SslError sslError) {
        return sslError.getCertificate();
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiSslError
    public String url(SslError sslError) {
        return sslError.getUrl();
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiSslError
    public SslErrorType getPrimaryError(SslError sslError) {
        int primaryError = sslError.getPrimaryError();
        if (primaryError == 0) {
            return SslErrorType.NOT_YET_VALID;
        }
        if (primaryError == 1) {
            return SslErrorType.EXPIRED;
        }
        if (primaryError == 2) {
            return SslErrorType.ID_MISMATCH;
        }
        if (primaryError == 3) {
            return SslErrorType.UNTRUSTED;
        }
        if (primaryError == 4) {
            return SslErrorType.DATE_INVALID;
        }
        if (primaryError == 5) {
            return SslErrorType.INVALID;
        }
        return SslErrorType.UNKNOWN;
    }

    /* renamed from: io.flutter.plugins.webviewflutter.SslErrorProxyApi$1, reason: invalid class name */
    /* loaded from: classes4.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$flutter$plugins$webviewflutter$SslErrorType;

        static {
            int[] iArr = new int[SslErrorType.values().length];
            $SwitchMap$io$flutter$plugins$webviewflutter$SslErrorType = iArr;
            try {
                iArr[SslErrorType.DATE_INVALID.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$flutter$plugins$webviewflutter$SslErrorType[SslErrorType.EXPIRED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$flutter$plugins$webviewflutter$SslErrorType[SslErrorType.ID_MISMATCH.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$io$flutter$plugins$webviewflutter$SslErrorType[SslErrorType.INVALID.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$io$flutter$plugins$webviewflutter$SslErrorType[SslErrorType.NOT_YET_VALID.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$io$flutter$plugins$webviewflutter$SslErrorType[SslErrorType.UNTRUSTED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$io$flutter$plugins$webviewflutter$SslErrorType[SslErrorType.UNKNOWN.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiSslError
    public boolean hasError(SslError sslError, SslErrorType sslErrorType) {
        int i;
        switch (AnonymousClass1.$SwitchMap$io$flutter$plugins$webviewflutter$SslErrorType[sslErrorType.ordinal()]) {
            case 1:
                i = 4;
                break;
            case 2:
                i = 1;
                break;
            case 3:
                i = 2;
                break;
            case 4:
                i = 5;
                break;
            case 5:
                i = 0;
                break;
            case 6:
                i = 3;
                break;
            case 7:
                throw getPigeonRegistrar().createUnknownEnumException(sslErrorType);
            default:
                i = -1;
                break;
        }
        return sslError.hasError(i);
    }
}
