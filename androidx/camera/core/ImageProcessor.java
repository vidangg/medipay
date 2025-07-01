package androidx.camera.core;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes.dex */
public interface ImageProcessor {

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface OutputFormats {
    }

    /* loaded from: classes.dex */
    public interface Request {
        ImageProxy getInputImage();

        int getOutputFormat();
    }

    /* loaded from: classes.dex */
    public interface Response {
        ImageProxy getOutputImage();
    }

    Response process(Request request) throws ProcessingException;
}
