package org.apache.commons.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/* loaded from: classes4.dex */
public class FileSystemUtils {
    private static final int INIT_PROBLEM = -1;
    private static final FileSystemUtils INSTANCE = new FileSystemUtils();
    private static final int OS;
    private static final int OTHER = 0;
    private static final int POSIX_UNIX = 3;
    private static final int UNIX = 2;
    private static final int WINDOWS = 1;

    static {
        String property;
        int i = -1;
        try {
            property = System.getProperty("os.name");
        } catch (Exception unused) {
        }
        if (property == null) {
            throw new IOException("os.name not found");
        }
        String lowerCase = property.toLowerCase();
        if (lowerCase.indexOf("windows") != -1) {
            i = 1;
        } else {
            if (lowerCase.indexOf("linux") == -1 && lowerCase.indexOf("sun os") == -1 && lowerCase.indexOf("sunos") == -1 && lowerCase.indexOf("solaris") == -1 && lowerCase.indexOf("mpe/ix") == -1 && lowerCase.indexOf("freebsd") == -1 && lowerCase.indexOf("irix") == -1 && lowerCase.indexOf("digital unix") == -1 && lowerCase.indexOf("unix") == -1 && lowerCase.indexOf("mac os x") == -1) {
                if (lowerCase.indexOf("hp-ux") == -1 && lowerCase.indexOf("aix") == -1) {
                    i = 0;
                }
                i = 3;
            }
            i = 2;
        }
        OS = i;
    }

    public static long freeSpace(String str) throws IOException {
        return INSTANCE.freeSpaceOS(str, OS, false);
    }

    public static long freeSpaceKb(String str) throws IOException {
        return INSTANCE.freeSpaceOS(str, OS, true);
    }

    long freeSpaceOS(String str, int i, boolean z) throws IOException {
        if (str == null) {
            throw new IllegalArgumentException("Path must not be empty");
        }
        if (i == 0) {
            throw new IllegalStateException("Unsupported operating system");
        }
        if (i == 1) {
            long freeSpaceWindows = freeSpaceWindows(str);
            return z ? freeSpaceWindows / 1024 : freeSpaceWindows;
        }
        if (i == 2) {
            return freeSpaceUnix(str, z, false);
        }
        if (i == 3) {
            return freeSpaceUnix(str, z, true);
        }
        throw new IllegalStateException("Exception caught when determining operating system");
    }

    long freeSpaceWindows(String str) throws IOException {
        String normalize = FilenameUtils.normalize(str);
        if (normalize.length() > 2 && normalize.charAt(1) == ':') {
            normalize = normalize.substring(0, 2);
        }
        List performCommand = performCommand(new String[]{"cmd.exe", "/C", new StringBuffer("dir /-c ").append(normalize).toString()}, Integer.MAX_VALUE);
        for (int size = performCommand.size() - 1; size >= 0; size--) {
            String str2 = (String) performCommand.get(size);
            if (str2.length() > 0) {
                return parseDir(str2, normalize);
            }
        }
        throw new IOException(new StringBuffer("Command line 'dir /-c' did not return any info for path '").append(normalize).append("'").toString());
    }

    long parseDir(String str, String str2) throws IOException {
        int i;
        int i2;
        int i3;
        int length = str.length();
        while (true) {
            length--;
            i = 0;
            if (length < 0) {
                i2 = 0;
                break;
            }
            if (Character.isDigit(str.charAt(length))) {
                i2 = length + 1;
                break;
            }
        }
        while (true) {
            if (length < 0) {
                i3 = 0;
                break;
            }
            char charAt = str.charAt(length);
            if (!Character.isDigit(charAt) && charAt != ',' && charAt != '.') {
                i3 = length + 1;
                break;
            }
            length--;
        }
        if (length < 0) {
            throw new IOException(new StringBuffer("Command line 'dir /-c' did not return valid info for path '").append(str2).append("'").toString());
        }
        StringBuffer stringBuffer = new StringBuffer(str.substring(i3, i2));
        while (i < stringBuffer.length()) {
            if (stringBuffer.charAt(i) == ',' || stringBuffer.charAt(i) == '.') {
                stringBuffer.deleteCharAt(i);
                i--;
            }
            i++;
        }
        return parseBytes(stringBuffer.toString(), str2);
    }

    long freeSpaceUnix(String str, boolean z, boolean z2) throws IOException {
        String str2;
        if (str.length() == 0) {
            throw new IllegalArgumentException("Path must not be empty");
        }
        String normalize = FilenameUtils.normalize(str);
        if (!z) {
            str2 = "-";
        } else {
            str2 = "-k";
        }
        if (z2) {
            str2 = new StringBuffer().append(str2).append("P").toString();
        }
        List performCommand = performCommand(str2.length() > 1 ? new String[]{"df", str2, normalize} : new String[]{"df", normalize}, 3);
        if (performCommand.size() < 2) {
            throw new IOException(new StringBuffer("Command line 'df' did not return info as expected for path '").append(normalize).append("'- response was ").append(performCommand).toString());
        }
        StringTokenizer stringTokenizer = new StringTokenizer((String) performCommand.get(1), " ");
        if (stringTokenizer.countTokens() < 4) {
            if (stringTokenizer.countTokens() == 1 && performCommand.size() >= 3) {
                stringTokenizer = new StringTokenizer((String) performCommand.get(2), " ");
            } else {
                throw new IOException(new StringBuffer("Command line 'df' did not return data as expected for path '").append(normalize).append("'- check path is valid").toString());
            }
        } else {
            stringTokenizer.nextToken();
        }
        stringTokenizer.nextToken();
        stringTokenizer.nextToken();
        return parseBytes(stringTokenizer.nextToken(), normalize);
    }

    long parseBytes(String str, String str2) throws IOException {
        try {
            long parseLong = Long.parseLong(str);
            if (parseLong >= 0) {
                return parseLong;
            }
            throw new IOException(new StringBuffer("Command line 'df' did not find free space in response for path '").append(str2).append("'- check path is valid").toString());
        } catch (NumberFormatException unused) {
            throw new IOException(new StringBuffer("Command line 'df' did not return numeric data as expected for path '").append(str2).append("'- check path is valid").toString());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0110  */
    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v10, types: [java.io.BufferedReader, java.io.Reader] */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v12 */
    /* JADX WARN: Type inference failed for: r7v2, types: [java.io.Reader] */
    /* JADX WARN: Type inference failed for: r7v3 */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r7v5 */
    /* JADX WARN: Type inference failed for: r7v6 */
    /* JADX WARN: Type inference failed for: r7v7 */
    /* JADX WARN: Type inference failed for: r7v8 */
    /* JADX WARN: Type inference failed for: r7v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    List performCommand(String[] strArr, int i) throws IOException {
        Process process;
        OutputStream outputStream;
        InputStream inputStream;
        InputStream inputStream2;
        ?? r7;
        ?? r72;
        ArrayList arrayList = new ArrayList(20);
        InputStream inputStream3 = null;
        try {
            process = openProcess(strArr);
            try {
                inputStream = process.getInputStream();
            } catch (InterruptedException e) {
                e = e;
                inputStream = null;
                outputStream = null;
            } catch (Throwable th) {
                th = th;
                outputStream = null;
                inputStream2 = outputStream;
                r72 = inputStream2;
                IOUtils.closeQuietly(inputStream3);
                IOUtils.closeQuietly(outputStream);
                IOUtils.closeQuietly(inputStream2);
                IOUtils.closeQuietly((Reader) r72);
                if (process != null) {
                }
                throw th;
            }
        } catch (InterruptedException e2) {
            e = e2;
            inputStream = null;
            outputStream = null;
            inputStream2 = null;
            r7 = 0;
        } catch (Throwable th2) {
            th = th2;
            process = null;
            outputStream = null;
        }
        try {
            outputStream = process.getOutputStream();
            try {
                inputStream2 = process.getErrorStream();
                try {
                    r7 = new BufferedReader(new InputStreamReader(inputStream));
                    try {
                        for (String readLine = r7.readLine(); readLine != null && arrayList.size() < i; readLine = r7.readLine()) {
                            arrayList.add(readLine.toLowerCase().trim());
                        }
                        process.waitFor();
                        if (process.exitValue() != 0) {
                            throw new IOException(new StringBuffer().append("Command line returned OS error code '").append(process.exitValue()).append("' for command ").append(Arrays.asList(strArr)).toString());
                        }
                        if (arrayList.size() == 0) {
                            throw new IOException(new StringBuffer().append("Command line did not return any info for command ").append(Arrays.asList(strArr)).toString());
                        }
                        IOUtils.closeQuietly(inputStream);
                        IOUtils.closeQuietly(outputStream);
                        IOUtils.closeQuietly(inputStream2);
                        IOUtils.closeQuietly((Reader) r7);
                        if (process != null) {
                            process.destroy();
                        }
                        return arrayList;
                    } catch (InterruptedException e3) {
                        e = e3;
                        inputStream3 = process;
                        r7 = r7;
                        try {
                            throw new IOException(new StringBuffer().append("Command line threw an InterruptedException '").append(e.getMessage()).append("' for command ").append(Arrays.asList(strArr)).toString());
                        } catch (Throwable th3) {
                            th = th3;
                            process = inputStream3;
                            inputStream3 = inputStream;
                            r72 = r7;
                            IOUtils.closeQuietly(inputStream3);
                            IOUtils.closeQuietly(outputStream);
                            IOUtils.closeQuietly(inputStream2);
                            IOUtils.closeQuietly((Reader) r72);
                            if (process != null) {
                                process.destroy();
                            }
                            throw th;
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        inputStream3 = inputStream;
                        r72 = r7;
                        IOUtils.closeQuietly(inputStream3);
                        IOUtils.closeQuietly(outputStream);
                        IOUtils.closeQuietly(inputStream2);
                        IOUtils.closeQuietly((Reader) r72);
                        if (process != null) {
                        }
                        throw th;
                    }
                } catch (InterruptedException e4) {
                    e = e4;
                    r7 = 0;
                } catch (Throwable th5) {
                    th = th5;
                    r7 = 0;
                }
            } catch (InterruptedException e5) {
                e = e5;
                inputStream2 = null;
                r7 = inputStream2;
                inputStream3 = process;
                r7 = r7;
                throw new IOException(new StringBuffer().append("Command line threw an InterruptedException '").append(e.getMessage()).append("' for command ").append(Arrays.asList(strArr)).toString());
            } catch (Throwable th6) {
                th = th6;
                inputStream2 = null;
                r7 = inputStream2;
                inputStream3 = inputStream;
                r72 = r7;
                IOUtils.closeQuietly(inputStream3);
                IOUtils.closeQuietly(outputStream);
                IOUtils.closeQuietly(inputStream2);
                IOUtils.closeQuietly((Reader) r72);
                if (process != null) {
                }
                throw th;
            }
        } catch (InterruptedException e6) {
            e = e6;
            outputStream = null;
            inputStream2 = outputStream;
            r7 = inputStream2;
            inputStream3 = process;
            r7 = r7;
            throw new IOException(new StringBuffer().append("Command line threw an InterruptedException '").append(e.getMessage()).append("' for command ").append(Arrays.asList(strArr)).toString());
        } catch (Throwable th7) {
            th = th7;
            outputStream = null;
            inputStream2 = null;
        }
    }

    Process openProcess(String[] strArr) throws IOException {
        return Runtime.getRuntime().exec(strArr);
    }
}
