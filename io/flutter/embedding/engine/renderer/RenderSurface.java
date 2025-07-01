package io.flutter.embedding.engine.renderer;

/* loaded from: classes4.dex */
public interface RenderSurface {
    void attachToRenderer(FlutterRenderer flutterRenderer);

    void detachFromRenderer();

    FlutterRenderer getAttachedRenderer();

    void pause();

    void resume();
}
