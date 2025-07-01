package org.apache.commons.io.output;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

/* loaded from: classes4.dex */
public class LockableFileWriter extends Writer {
    private static final String LCK = ".lck";
    static /* synthetic */ Class class$org$apache$commons$io$output$LockableFileWriter;
    private final File lockFile;
    private final Writer out;

    public LockableFileWriter(String str) throws IOException {
        this(str, false, (String) null);
    }

    public LockableFileWriter(String str, boolean z) throws IOException {
        this(str, z, (String) null);
    }

    public LockableFileWriter(String str, boolean z, String str2) throws IOException {
        this(new File(str), z, str2);
    }

    public LockableFileWriter(File file) throws IOException {
        this(file, false, (String) null);
    }

    public LockableFileWriter(File file, boolean z) throws IOException {
        this(file, z, (String) null);
    }

    public LockableFileWriter(File file, boolean z, String str) throws IOException {
        this(file, null, z, str);
    }

    public LockableFileWriter(File file, String str) throws IOException {
        this(file, str, false, null);
    }

    public LockableFileWriter(File file, String str, boolean z, String str2) throws IOException {
        File absoluteFile = file.getAbsoluteFile();
        if (absoluteFile.getParentFile() != null) {
            FileUtils.forceMkdir(absoluteFile.getParentFile());
        }
        if (absoluteFile.isDirectory()) {
            throw new IOException("File specified is a directory");
        }
        File file2 = new File(str2 == null ? System.getProperty("java.io.tmpdir") : str2);
        FileUtils.forceMkdir(file2);
        testLockDir(file2);
        this.lockFile = new File(file2, new StringBuffer().append(absoluteFile.getName()).append(LCK).toString());
        createLock();
        this.out = initWriter(absoluteFile, str, z);
    }

    private void testLockDir(File file) throws IOException {
        if (!file.exists()) {
            throw new IOException(new StringBuffer("Could not find lockDir: ").append(file.getAbsolutePath()).toString());
        }
        if (!file.canWrite()) {
            throw new IOException(new StringBuffer("Could not write to lockDir: ").append(file.getAbsolutePath()).toString());
        }
    }

    static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError(e.getMessage());
        }
    }

    private void createLock() throws IOException {
        Class cls = class$org$apache$commons$io$output$LockableFileWriter;
        if (cls == null) {
            cls = class$("org.apache.commons.io.output.LockableFileWriter");
            class$org$apache$commons$io$output$LockableFileWriter = cls;
        }
        synchronized (cls) {
            if (!this.lockFile.createNewFile()) {
                throw new IOException(new StringBuffer("Can't write file, lock ").append(this.lockFile.getAbsolutePath()).append(" exists").toString());
            }
            this.lockFile.deleteOnExit();
        }
    }

    private Writer initWriter(File file, String str, boolean z) throws IOException {
        FileOutputStream fileOutputStream;
        OutputStreamWriter outputStreamWriter;
        boolean exists = file.exists();
        try {
            if (str == null) {
                outputStreamWriter = new FileWriter(file.getAbsolutePath(), z);
            } else {
                fileOutputStream = new FileOutputStream(file.getAbsolutePath(), z);
                try {
                    outputStreamWriter = new OutputStreamWriter(fileOutputStream, str);
                } catch (IOException e) {
                    e = e;
                    IOUtils.closeQuietly((Writer) null);
                    IOUtils.closeQuietly(fileOutputStream);
                    this.lockFile.delete();
                    if (!exists) {
                        file.delete();
                    }
                    throw e;
                } catch (RuntimeException e2) {
                    e = e2;
                    IOUtils.closeQuietly((Writer) null);
                    IOUtils.closeQuietly(fileOutputStream);
                    this.lockFile.delete();
                    if (!exists) {
                        file.delete();
                    }
                    throw e;
                }
            }
            return outputStreamWriter;
        } catch (IOException e3) {
            e = e3;
            fileOutputStream = null;
        } catch (RuntimeException e4) {
            e = e4;
            fileOutputStream = null;
        }
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        try {
            this.out.close();
        } finally {
            this.lockFile.delete();
        }
    }

    @Override // java.io.Writer
    public void write(int i) throws IOException {
        this.out.write(i);
    }

    @Override // java.io.Writer
    public void write(char[] cArr) throws IOException {
        this.out.write(cArr);
    }

    @Override // java.io.Writer
    public void write(char[] cArr, int i, int i2) throws IOException {
        this.out.write(cArr, i, i2);
    }

    @Override // java.io.Writer
    public void write(String str) throws IOException {
        this.out.write(str);
    }

    @Override // java.io.Writer
    public void write(String str, int i, int i2) throws IOException {
        this.out.write(str, i, i2);
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() throws IOException {
        this.out.flush();
    }
}
