package paua;

import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/* loaded from: classes4.dex */
public class onepv implements Interceptor {
    public cmx srb;

    public onepv(cmx cmxVar) {
        this.srb = cmxVar;
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Request request = chain.request();
        this.srb.uzp(request.url().host());
        return chain.proceed(request);
    }
}
