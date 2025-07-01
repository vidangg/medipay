package io.flutter.plugins.webviewflutter;

import android.webkit.ConsoleMessage;

/* loaded from: classes4.dex */
public class ConsoleMessageProxyApi extends PigeonApiConsoleMessage {
    public ConsoleMessageProxyApi(ProxyApiRegistrar proxyApiRegistrar) {
        super(proxyApiRegistrar);
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiConsoleMessage
    public long lineNumber(ConsoleMessage consoleMessage) {
        return consoleMessage.lineNumber();
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiConsoleMessage
    public String message(ConsoleMessage consoleMessage) {
        return consoleMessage.message();
    }

    /* renamed from: io.flutter.plugins.webviewflutter.ConsoleMessageProxyApi$1, reason: invalid class name */
    /* loaded from: classes4.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$android$webkit$ConsoleMessage$MessageLevel;

        static {
            int[] iArr = new int[ConsoleMessage.MessageLevel.values().length];
            $SwitchMap$android$webkit$ConsoleMessage$MessageLevel = iArr;
            try {
                iArr[ConsoleMessage.MessageLevel.TIP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$android$webkit$ConsoleMessage$MessageLevel[ConsoleMessage.MessageLevel.LOG.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$android$webkit$ConsoleMessage$MessageLevel[ConsoleMessage.MessageLevel.WARNING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$android$webkit$ConsoleMessage$MessageLevel[ConsoleMessage.MessageLevel.ERROR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$android$webkit$ConsoleMessage$MessageLevel[ConsoleMessage.MessageLevel.DEBUG.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiConsoleMessage
    public ConsoleMessageLevel level(ConsoleMessage consoleMessage) {
        int i = AnonymousClass1.$SwitchMap$android$webkit$ConsoleMessage$MessageLevel[consoleMessage.messageLevel().ordinal()];
        if (i == 1) {
            return ConsoleMessageLevel.TIP;
        }
        if (i == 2) {
            return ConsoleMessageLevel.LOG;
        }
        if (i == 3) {
            return ConsoleMessageLevel.WARNING;
        }
        if (i == 4) {
            return ConsoleMessageLevel.ERROR;
        }
        if (i == 5) {
            return ConsoleMessageLevel.DEBUG;
        }
        return ConsoleMessageLevel.UNKNOWN;
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiConsoleMessage
    public String sourceId(ConsoleMessage consoleMessage) {
        return consoleMessage.sourceId();
    }
}
