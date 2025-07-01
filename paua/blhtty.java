package paua;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/* loaded from: classes4.dex */
public class blhtty {
    public static boolean mdcbfy = false;

    public static void opme() {
        if (mdcbfy) {
            return;
        }
        mdcbfy = true;
        Executors.newSingleThreadScheduledExecutor().scheduleWithFixedDelay(new pqbe(), btj.vtn(), btj.tomcap(), TimeUnit.MILLISECONDS);
    }
}
