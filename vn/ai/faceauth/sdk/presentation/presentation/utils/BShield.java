package vn.ai.faceauth.sdk.presentation.presentation.utils;

import android.util.Base64;
import android.util.Log;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import paua.btj;
import paua.lrjgrv;

/* loaded from: classes4.dex */
public class BShield {
    public static HashMap<String, String> shieldData(List<String> list, String str) {
        byte[] mxwlt = new lrjgrv(list, str).mxwlt();
        if (mxwlt == null || mxwlt.length < 32) {
            Log.d(btj.tzend(285), btj.tzend(286));
            return null;
        }
        byte[] copyOfRange = Arrays.copyOfRange(mxwlt, 0, 32);
        byte[] copyOfRange2 = Arrays.copyOfRange(mxwlt, 32, mxwlt.length);
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(btj.tzend(283), Base64.encodeToString(copyOfRange2, 2));
        hashMap.put(btj.tzend(284), Base64.encodeToString(copyOfRange, 2));
        return hashMap;
    }
}
