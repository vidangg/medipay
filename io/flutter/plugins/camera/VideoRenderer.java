package io.flutter.plugins.camera;

import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLExt;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.opengl.Matrix;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.SystemClock;
import android.util.Log;
import android.view.Surface;
import java.lang.Thread;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes4.dex */
public class VideoRenderer {
    static String TAG = "VideoRenderer";
    private static final String fragmentShaderCode = " #extension GL_OES_EGL_image_external : require\n            precision mediump float;\n\n            varying vec2 varUvs;\n            uniform samplerExternalOES texSampler;\n\n            void main()\n            {\n                vec4 c = texture2D(texSampler, varUvs);\n                gl_FragColor = vec4(c.r, c.g, c.b, c.a);\n            }";
    private static final String vertexShaderCode = "  precision highp float;\n            attribute vec3 vertexPosition;\n            attribute vec2 uvs;\n            varying vec2 varUvs;\n            uniform mat4 texMatrix;\n            uniform mat4 mvp;\n\n            void main()\n            {\n                varUvs = (texMatrix * vec4(uvs.x, uvs.y, 0, 1.0)).xy;\n                gl_Position = mvp * vec4(vertexPosition, 1.0);\n            }";
    EGLContext context;
    EGLDisplay display;
    private Surface inputSurface;
    SurfaceTexture inputSurfaceTexture;
    private final Surface outputSurface;
    private int program;
    final int recordingHeight;
    final int recordingWidth;
    EGLSurface surface;
    private HandlerThread surfaceTextureFrameAvailableHandler;
    private Thread thread;
    private final Thread.UncaughtExceptionHandler uncaughtExceptionHandler;
    private final int[] textureHandles = new int[1];
    private final float[] vertices = {-1.0f, -1.0f, 0.0f, 0.0f, 0.0f, -1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 1.0f, 1.0f, 1.0f, -1.0f, 0.0f, 1.0f, 0.0f};
    private final int[] indices = {2, 1, 0, 0, 3, 2};
    private int vertexHandle = 0;
    private final int[] bufferHandles = new int[2];
    private int uvsHandle = 0;
    private int texMatrixHandle = 0;
    private int mvpHandle = 0;
    final Object surfaceTextureAvailableFrameLock = new Object();
    Boolean surfaceTextureFrameAvailable = false;
    private int rotation = 0;
    private final Object lock = new Object();

    public Surface getInputSurface() throws InterruptedException {
        Surface surface;
        synchronized (this.lock) {
            while (true) {
                surface = this.inputSurface;
                if (surface == null) {
                    this.lock.wait();
                }
            }
        }
        return surface;
    }

    public VideoRenderer(Surface surface, int i, int i2, Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.outputSurface = surface;
        this.recordingHeight = i2;
        this.recordingWidth = i;
        this.uncaughtExceptionHandler = uncaughtExceptionHandler;
        startOpenGL();
        Log.d(TAG, "VideoRenderer setup complete");
    }

    public void close() {
        this.thread.interrupt();
        this.surfaceTextureFrameAvailableHandler.quitSafely();
        cleanupOpenGL();
        this.inputSurfaceTexture.release();
    }

    private void cleanupOpenGL() {
        GLES20.glDeleteBuffers(2, this.bufferHandles, 0);
        GLES20.glDeleteTextures(1, this.textureHandles, 0);
        EGL14.eglDestroyContext(this.display, this.context);
        EGL14.eglDestroySurface(this.display, this.surface);
        GLES20.glDeleteProgram(this.program);
    }

    void configureOpenGL() {
        int[] iArr;
        synchronized (this.lock) {
            EGLDisplay eglGetDisplay = EGL14.eglGetDisplay(0);
            this.display = eglGetDisplay;
            if (eglGetDisplay == EGL14.EGL_NO_DISPLAY) {
                throw new RuntimeException("eglDisplay == EGL14.EGL_NO_DISPLAY: " + GLUtils.getEGLErrorString(EGL14.eglGetError()));
            }
            int[] iArr2 = new int[2];
            if (!EGL14.eglInitialize(this.display, iArr2, 0, iArr2, 1)) {
                throw new RuntimeException("eglInitialize(): " + GLUtils.getEGLErrorString(EGL14.eglGetError()));
            }
            if (!EGL14.eglQueryString(this.display, 12373).contains("EGL_ANDROID_presentation_time")) {
                throw new RuntimeException("cannot configure OpenGL. missing EGL_ANDROID_presentation_time");
            }
            if (SdkCapabilityChecker.supportsEglRecordableAndroid()) {
                iArr = new int[]{12324, 8, 12323, 8, 12322, 8, 12321, 8, 12352, 4, 12610, 1, 12344};
            } else {
                iArr = new int[]{12324, 8, 12323, 8, 12322, 8, 12321, 8, 12352, 4, 12344};
            }
            int[] iArr3 = iArr;
            EGLConfig[] eGLConfigArr = new EGLConfig[1];
            if (!EGL14.eglChooseConfig(this.display, iArr3, 0, eGLConfigArr, 0, 1, new int[1], 0)) {
                throw new RuntimeException(GLUtils.getEGLErrorString(EGL14.eglGetError()));
            }
            int eglGetError = EGL14.eglGetError();
            if (eglGetError != 12288) {
                throw new RuntimeException(GLUtils.getEGLErrorString(eglGetError));
            }
            this.context = EGL14.eglCreateContext(this.display, eGLConfigArr[0], EGL14.EGL_NO_CONTEXT, new int[]{12440, 2, 12344}, 0);
            int eglGetError2 = EGL14.eglGetError();
            if (eglGetError2 != 12288) {
                throw new RuntimeException(GLUtils.getEGLErrorString(eglGetError2));
            }
            this.surface = EGL14.eglCreateWindowSurface(this.display, eGLConfigArr[0], this.outputSurface, new int[]{12344}, 0);
            int eglGetError3 = EGL14.eglGetError();
            if (eglGetError3 != 12288) {
                throw new RuntimeException(GLUtils.getEGLErrorString(eglGetError3));
            }
            EGLDisplay eGLDisplay = this.display;
            EGLSurface eGLSurface = this.surface;
            if (!EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, this.context)) {
                throw new RuntimeException("eglMakeCurrent(): " + GLUtils.getEGLErrorString(EGL14.eglGetError()));
            }
            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(this.vertices.length * 4);
            allocateDirect.order(ByteOrder.nativeOrder());
            allocateDirect.asFloatBuffer().put(this.vertices);
            allocateDirect.asFloatBuffer().position(0);
            ByteBuffer allocateDirect2 = ByteBuffer.allocateDirect(this.indices.length * 4);
            allocateDirect2.order(ByteOrder.nativeOrder());
            allocateDirect2.asIntBuffer().put(this.indices);
            allocateDirect2.position(0);
            int loadShader = loadShader(35633, vertexShaderCode);
            int loadShader2 = loadShader(35632, fragmentShaderCode);
            int glCreateProgram = GLES20.glCreateProgram();
            this.program = glCreateProgram;
            GLES20.glAttachShader(glCreateProgram, loadShader);
            GLES20.glAttachShader(this.program, loadShader2);
            GLES20.glLinkProgram(this.program);
            deleteShader(loadShader);
            deleteShader(loadShader2);
            this.vertexHandle = GLES20.glGetAttribLocation(this.program, "vertexPosition");
            this.uvsHandle = GLES20.glGetAttribLocation(this.program, "uvs");
            this.texMatrixHandle = GLES20.glGetUniformLocation(this.program, "texMatrix");
            this.mvpHandle = GLES20.glGetUniformLocation(this.program, "mvp");
            GLES20.glGenBuffers(2, this.bufferHandles, 0);
            GLES20.glBindBuffer(34962, this.bufferHandles[0]);
            GLES20.glBufferData(34962, this.vertices.length * 4, allocateDirect, 35048);
            GLES20.glBindBuffer(34963, this.bufferHandles[1]);
            GLES20.glBufferData(34963, this.indices.length * 4, allocateDirect2, 35048);
            GLES20.glGenTextures(1, this.textureHandles, 0);
            GLES20.glBindTexture(36197, this.textureHandles[0]);
            SurfaceTexture surfaceTexture = new SurfaceTexture(getTexId());
            this.inputSurfaceTexture = surfaceTexture;
            surfaceTexture.setDefaultBufferSize(this.recordingWidth, this.recordingHeight);
            HandlerThread handlerThread = new HandlerThread("FrameHandlerThread");
            this.surfaceTextureFrameAvailableHandler = handlerThread;
            handlerThread.start();
            this.inputSurface = new Surface(this.inputSurfaceTexture);
            this.inputSurfaceTexture.setOnFrameAvailableListener(new SurfaceTexture.OnFrameAvailableListener() { // from class: io.flutter.plugins.camera.VideoRenderer.1
                @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
                public void onFrameAvailable(SurfaceTexture surfaceTexture2) {
                    synchronized (VideoRenderer.this.surfaceTextureAvailableFrameLock) {
                        if (VideoRenderer.this.surfaceTextureFrameAvailable.booleanValue()) {
                            Log.w(VideoRenderer.TAG, "Frame available before processing other frames. dropping frames");
                        }
                        VideoRenderer.this.surfaceTextureFrameAvailable = true;
                        VideoRenderer.this.surfaceTextureAvailableFrameLock.notifyAll();
                    }
                }
            }, new Handler(this.surfaceTextureFrameAvailableHandler.getLooper()));
            this.lock.notifyAll();
        }
    }

    private void startOpenGL() {
        Log.d(TAG, "Starting OpenGL Thread");
        Thread thread = new Thread() { // from class: io.flutter.plugins.camera.VideoRenderer.2
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                VideoRenderer.this.configureOpenGL();
                while (!Thread.interrupted()) {
                    try {
                        synchronized (VideoRenderer.this.surfaceTextureAvailableFrameLock) {
                            while (!VideoRenderer.this.surfaceTextureFrameAvailable.booleanValue()) {
                                VideoRenderer.this.surfaceTextureAvailableFrameLock.wait(500L);
                            }
                            VideoRenderer.this.surfaceTextureFrameAvailable = false;
                        }
                        VideoRenderer.this.inputSurfaceTexture.updateTexImage();
                        float[] fArr = new float[16];
                        VideoRenderer.this.inputSurfaceTexture.getTransformMatrix(fArr);
                        VideoRenderer videoRenderer = VideoRenderer.this;
                        videoRenderer.draw(videoRenderer.recordingWidth, VideoRenderer.this.recordingHeight, fArr);
                    } catch (InterruptedException unused) {
                        Log.d(VideoRenderer.TAG, "thread interrupted while waiting for frames");
                        return;
                    }
                }
            }
        };
        this.thread = thread;
        thread.setUncaughtExceptionHandler(this.uncaughtExceptionHandler);
        this.thread.start();
    }

    public int getTexId() {
        return this.textureHandles[0];
    }

    public float[] moveMatrix() {
        float[] fArr = new float[16];
        Matrix.setIdentityM(fArr, 0);
        Matrix.rotateM(fArr, 0, this.rotation, 0.0f, 0.0f, 1.0f);
        return fArr;
    }

    public void setRotation(int i) {
        this.rotation = i;
    }

    private int loadShader(int i, String str) {
        int glCreateShader = GLES20.glCreateShader(i);
        GLES20.glShaderSource(glCreateShader, str);
        GLES20.glCompileShader(glCreateShader);
        return glCreateShader;
    }

    private void deleteShader(int i) {
        GLES20.glDeleteShader(i);
    }

    public void draw(int i, int i2, float[] fArr) {
        GLES20.glClear(16640);
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        GLES20.glViewport(0, 0, i, i2);
        GLES20.glUseProgram(this.program);
        GLES20.glUniformMatrix4fv(this.texMatrixHandle, 1, false, fArr, 0);
        GLES20.glUniformMatrix4fv(this.mvpHandle, 1, false, moveMatrix(), 0);
        GLES20.glBindBuffer(34962, this.bufferHandles[0]);
        GLES20.glBindBuffer(34963, this.bufferHandles[1]);
        GLES20.glEnableVertexAttribArray(this.vertexHandle);
        GLES20.glVertexAttribPointer(this.vertexHandle, 3, 5126, false, 20, 0);
        GLES20.glEnableVertexAttribArray(this.uvsHandle);
        GLES20.glVertexAttribPointer(this.uvsHandle, 2, 5126, false, 20, 12);
        GLES20.glDrawElements(4, 6, 5125, 0);
        EGLExt.eglPresentationTimeANDROID(this.display, this.surface, SystemClock.uptimeMillis() * 1000000);
        if (EGL14.eglSwapBuffers(this.display, this.surface)) {
            return;
        }
        Log.w(TAG, "eglSwapBuffers() " + GLUtils.getEGLErrorString(EGL14.eglGetError()));
    }
}
