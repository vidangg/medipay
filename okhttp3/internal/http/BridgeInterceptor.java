package okhttp3.internal.http;

import java.io.IOException;
import java.util.List;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.internal.Util;
import okhttp3.internal.Version;
import okio.GzipSource;
import okio.Okio;

/* loaded from: classes4.dex */
public final class BridgeInterceptor implements Interceptor {
    private final CookieJar cookieJar;

    public BridgeInterceptor(CookieJar cookieJar) {
        this.cookieJar = cookieJar;
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Request request = chain.request();
        Request.Builder newBuilder = request.newBuilder();
        RequestBody body = request.body();
        if (body != null) {
            MediaType contentType = body.contentType();
            if (contentType != null) {
                newBuilder.header("Content-Type", contentType.toString());
            }
            long contentLength = body.contentLength();
            if (contentLength == -1) {
                newBuilder.header(com.google.common.net.HttpHeaders.TRANSFER_ENCODING, "chunked");
                newBuilder.removeHeader("Content-Length");
            } else {
                newBuilder.header("Content-Length", Long.toString(contentLength));
                newBuilder.removeHeader(com.google.common.net.HttpHeaders.TRANSFER_ENCODING);
            }
        }
        boolean z = false;
        if (request.header(com.google.common.net.HttpHeaders.HOST) == null) {
            newBuilder.header(com.google.common.net.HttpHeaders.HOST, Util.hostHeader(request.url(), false));
        }
        if (request.header("Connection") == null) {
            newBuilder.header("Connection", com.google.common.net.HttpHeaders.KEEP_ALIVE);
        }
        if (request.header(com.google.common.net.HttpHeaders.ACCEPT_ENCODING) == null && request.header("Range") == null) {
            newBuilder.header(com.google.common.net.HttpHeaders.ACCEPT_ENCODING, "gzip");
            z = true;
        }
        List<Cookie> loadForRequest = this.cookieJar.loadForRequest(request.url());
        if (!loadForRequest.isEmpty()) {
            newBuilder.header(com.google.common.net.HttpHeaders.COOKIE, cookieHeader(loadForRequest));
        }
        if (request.header("User-Agent") == null) {
            newBuilder.header("User-Agent", Version.userAgent());
        }
        Response proceed = chain.proceed(newBuilder.build());
        HttpHeaders.receiveHeaders(this.cookieJar, request.url(), proceed.headers());
        Response.Builder request2 = proceed.newBuilder().request(request);
        if (z && "gzip".equalsIgnoreCase(proceed.header("Content-Encoding")) && HttpHeaders.hasBody(proceed)) {
            GzipSource gzipSource = new GzipSource(proceed.body().source());
            request2.headers(proceed.headers().newBuilder().removeAll("Content-Encoding").removeAll("Content-Length").build());
            request2.body(new RealResponseBody(proceed.header("Content-Type"), -1L, Okio.buffer(gzipSource)));
        }
        return request2.build();
    }

    private String cookieHeader(List<Cookie> list) {
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                sb.append("; ");
            }
            Cookie cookie = list.get(i);
            sb.append(cookie.name());
            sb.append('=');
            sb.append(cookie.value());
        }
        return sb.toString();
    }
}
