package org.apache.commons.io;

import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.zip.CRC32;
import java.util.zip.CheckedInputStream;
import java.util.zip.Checksum;
import org.apache.commons.io.filefilter.DirectoryFileFilter;
import org.apache.commons.io.filefilter.FalseFileFilter;
import org.apache.commons.io.filefilter.FileFilterUtils;
import org.apache.commons.io.filefilter.IOFileFilter;
import org.apache.commons.io.filefilter.SuffixFileFilter;
import org.apache.commons.io.filefilter.TrueFileFilter;
import org.apache.commons.io.output.NullOutputStream;

/* loaded from: classes4.dex */
public class FileUtils {
    public static final File[] EMPTY_FILE_ARRAY = new File[0];
    public static final long ONE_GB = 1073741824;
    public static final long ONE_KB = 1024;
    public static final long ONE_MB = 1048576;

    public static FileInputStream openInputStream(File file) throws IOException {
        if (file.exists()) {
            if (file.isDirectory()) {
                throw new IOException(new StringBuffer("File '").append(file).append("' exists but is a directory").toString());
            }
            if (!file.canRead()) {
                throw new IOException(new StringBuffer("File '").append(file).append("' cannot be read").toString());
            }
            return new FileInputStream(file);
        }
        throw new FileNotFoundException(new StringBuffer("File '").append(file).append("' does not exist").toString());
    }

    public static FileOutputStream openOutputStream(File file) throws IOException {
        if (file.exists()) {
            if (file.isDirectory()) {
                throw new IOException(new StringBuffer("File '").append(file).append("' exists but is a directory").toString());
            }
            if (!file.canWrite()) {
                throw new IOException(new StringBuffer("File '").append(file).append("' cannot be written to").toString());
            }
        } else {
            File parentFile = file.getParentFile();
            if (parentFile != null && !parentFile.exists() && !parentFile.mkdirs()) {
                throw new IOException(new StringBuffer("File '").append(file).append("' could not be created").toString());
            }
        }
        return new FileOutputStream(file);
    }

    public static String byteCountToDisplaySize(long j) {
        long j2 = j / ONE_GB;
        if (j2 > 0) {
            return new StringBuffer().append(String.valueOf(j2)).append(" GB").toString();
        }
        long j3 = j / 1048576;
        if (j3 > 0) {
            return new StringBuffer().append(String.valueOf(j3)).append(" MB").toString();
        }
        long j4 = j / 1024;
        if (j4 > 0) {
            return new StringBuffer().append(String.valueOf(j4)).append(" KB").toString();
        }
        return new StringBuffer().append(String.valueOf(j)).append(" bytes").toString();
    }

    public static void touch(File file) throws IOException {
        if (!file.exists()) {
            IOUtils.closeQuietly(openOutputStream(file));
        }
        if (!file.setLastModified(System.currentTimeMillis())) {
            throw new IOException(new StringBuffer("Unable to set the last modification time for ").append(file).toString());
        }
    }

    public static File[] convertFileCollectionToFileArray(Collection collection) {
        return (File[]) collection.toArray(new File[collection.size()]);
    }

    private static void innerListFiles(Collection collection, File file, IOFileFilter iOFileFilter) {
        File[] listFiles = file.listFiles((FileFilter) iOFileFilter);
        if (listFiles != null) {
            for (int i = 0; i < listFiles.length; i++) {
                if (listFiles[i].isDirectory()) {
                    innerListFiles(collection, listFiles[i], iOFileFilter);
                } else {
                    collection.add(listFiles[i]);
                }
            }
        }
    }

    public static Collection listFiles(File file, IOFileFilter iOFileFilter, IOFileFilter iOFileFilter2) {
        IOFileFilter andFileFilter;
        if (!file.isDirectory()) {
            throw new IllegalArgumentException("Parameter 'directory' is not a directory");
        }
        if (iOFileFilter == null) {
            throw new NullPointerException("Parameter 'fileFilter' is null");
        }
        IOFileFilter andFileFilter2 = FileFilterUtils.andFileFilter(iOFileFilter, FileFilterUtils.notFileFilter(DirectoryFileFilter.INSTANCE));
        if (iOFileFilter2 == null) {
            andFileFilter = FalseFileFilter.INSTANCE;
        } else {
            andFileFilter = FileFilterUtils.andFileFilter(iOFileFilter2, DirectoryFileFilter.INSTANCE);
        }
        LinkedList linkedList = new LinkedList();
        innerListFiles(linkedList, file, FileFilterUtils.orFileFilter(andFileFilter2, andFileFilter));
        return linkedList;
    }

    public static Iterator iterateFiles(File file, IOFileFilter iOFileFilter, IOFileFilter iOFileFilter2) {
        return listFiles(file, iOFileFilter, iOFileFilter2).iterator();
    }

    private static String[] toSuffixes(String[] strArr) {
        String[] strArr2 = new String[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            strArr2[i] = new StringBuffer(".").append(strArr[i]).toString();
        }
        return strArr2;
    }

    public static Collection listFiles(File file, String[] strArr, boolean z) {
        IOFileFilter suffixFileFilter;
        if (strArr == null) {
            suffixFileFilter = TrueFileFilter.INSTANCE;
        } else {
            suffixFileFilter = new SuffixFileFilter(toSuffixes(strArr));
        }
        return listFiles(file, suffixFileFilter, z ? TrueFileFilter.INSTANCE : FalseFileFilter.INSTANCE);
    }

    public static Iterator iterateFiles(File file, String[] strArr, boolean z) {
        return listFiles(file, strArr, z).iterator();
    }

    public static boolean contentEquals(File file, File file2) throws IOException {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2;
        boolean exists = file.exists();
        if (exists != file2.exists()) {
            return false;
        }
        if (!exists) {
            return true;
        }
        if (file.isDirectory() || file2.isDirectory()) {
            throw new IOException("Can't compare directories, only files");
        }
        if (file.length() != file2.length()) {
            return false;
        }
        if (file.getCanonicalFile().equals(file2.getCanonicalFile())) {
            return true;
        }
        FileInputStream fileInputStream3 = null;
        try {
            fileInputStream2 = new FileInputStream(file);
            try {
                fileInputStream = new FileInputStream(file2);
            } catch (Throwable th) {
                th = th;
                fileInputStream = null;
            }
        } catch (Throwable th2) {
            th = th2;
            fileInputStream = null;
        }
        try {
            boolean contentEquals = IOUtils.contentEquals(fileInputStream2, fileInputStream);
            IOUtils.closeQuietly(fileInputStream2);
            IOUtils.closeQuietly(fileInputStream);
            return contentEquals;
        } catch (Throwable th3) {
            th = th3;
            fileInputStream3 = fileInputStream2;
            IOUtils.closeQuietly(fileInputStream3);
            IOUtils.closeQuietly(fileInputStream);
            throw th;
        }
    }

    public static File toFile(URL url) {
        if (url == null || !url.getProtocol().equals("file")) {
            return null;
        }
        String replace = url.getFile().replace(IOUtils.DIR_SEPARATOR_UNIX, File.separatorChar);
        int i = 0;
        while (true) {
            i = replace.indexOf(37, i);
            if (i >= 0) {
                if (i + 2 < replace.length()) {
                    int i2 = i + 3;
                    replace = new StringBuffer().append(replace.substring(0, i)).append((char) Integer.parseInt(replace.substring(i + 1, i2), 16)).append(replace.substring(i2)).toString();
                }
            } else {
                return new File(replace);
            }
        }
    }

    public static File[] toFiles(URL[] urlArr) {
        if (urlArr == null || urlArr.length == 0) {
            return EMPTY_FILE_ARRAY;
        }
        File[] fileArr = new File[urlArr.length];
        for (int i = 0; i < urlArr.length; i++) {
            URL url = urlArr[i];
            if (url != null) {
                if (!url.getProtocol().equals("file")) {
                    throw new IllegalArgumentException(new StringBuffer("URL could not be converted to a File: ").append(url).toString());
                }
                fileArr[i] = toFile(url);
            }
        }
        return fileArr;
    }

    public static URL[] toURLs(File[] fileArr) throws IOException {
        int length = fileArr.length;
        URL[] urlArr = new URL[length];
        for (int i = 0; i < length; i++) {
            urlArr[i] = fileArr[i].toURL();
        }
        return urlArr;
    }

    public static void copyFileToDirectory(File file, File file2) throws IOException {
        copyFileToDirectory(file, file2, true);
    }

    public static void copyFileToDirectory(File file, File file2, boolean z) throws IOException {
        if (file2 == null) {
            throw new NullPointerException("Destination must not be null");
        }
        if (file2.exists() && !file2.isDirectory()) {
            throw new IllegalArgumentException(new StringBuffer("Destination '").append(file2).append("' is not a directory").toString());
        }
        copyFile(file, new File(file2, file.getName()), z);
    }

    public static void copyFile(File file, File file2) throws IOException {
        copyFile(file, file2, true);
    }

    public static void copyFile(File file, File file2, boolean z) throws IOException {
        if (file == null) {
            throw new NullPointerException("Source must not be null");
        }
        if (file2 == null) {
            throw new NullPointerException("Destination must not be null");
        }
        if (!file.exists()) {
            throw new FileNotFoundException(new StringBuffer("Source '").append(file).append("' does not exist").toString());
        }
        if (file.isDirectory()) {
            throw new IOException(new StringBuffer("Source '").append(file).append("' exists but is a directory").toString());
        }
        if (file.getCanonicalPath().equals(file2.getCanonicalPath())) {
            throw new IOException(new StringBuffer("Source '").append(file).append("' and destination '").append(file2).append("' are the same").toString());
        }
        if (file2.getParentFile() != null && !file2.getParentFile().exists() && !file2.getParentFile().mkdirs()) {
            throw new IOException(new StringBuffer("Destination '").append(file2).append("' directory cannot be created").toString());
        }
        if (file2.exists() && !file2.canWrite()) {
            throw new IOException(new StringBuffer("Destination '").append(file2).append("' exists but is read-only").toString());
        }
        doCopyFile(file, file2, z);
    }

    private static void doCopyFile(File file, File file2, boolean z) throws IOException {
        if (file2.exists() && file2.isDirectory()) {
            throw new IOException(new StringBuffer("Destination '").append(file2).append("' exists but is a directory").toString());
        }
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            try {
                IOUtils.copy(fileInputStream, fileOutputStream);
                IOUtils.closeQuietly(fileInputStream);
                if (file.length() != file2.length()) {
                    throw new IOException(new StringBuffer("Failed to copy full contents from '").append(file).append("' to '").append(file2).append("'").toString());
                }
                if (z) {
                    file2.setLastModified(file.lastModified());
                }
            } finally {
                IOUtils.closeQuietly(fileOutputStream);
            }
        } catch (Throwable th) {
            IOUtils.closeQuietly(fileInputStream);
            throw th;
        }
    }

    public static void copyDirectoryToDirectory(File file, File file2) throws IOException {
        if (file == null) {
            throw new NullPointerException("Source must not be null");
        }
        if (file.exists() && !file.isDirectory()) {
            throw new IllegalArgumentException(new StringBuffer("Source '").append(file2).append("' is not a directory").toString());
        }
        if (file2 == null) {
            throw new NullPointerException("Destination must not be null");
        }
        if (file2.exists() && !file2.isDirectory()) {
            throw new IllegalArgumentException(new StringBuffer("Destination '").append(file2).append("' is not a directory").toString());
        }
        copyDirectory(file, new File(file2, file.getName()), true);
    }

    public static void copyDirectory(File file, File file2) throws IOException {
        copyDirectory(file, file2, true);
    }

    public static void copyDirectory(File file, File file2, boolean z) throws IOException {
        if (file == null) {
            throw new NullPointerException("Source must not be null");
        }
        if (file2 == null) {
            throw new NullPointerException("Destination must not be null");
        }
        if (!file.exists()) {
            throw new FileNotFoundException(new StringBuffer("Source '").append(file).append("' does not exist").toString());
        }
        if (!file.isDirectory()) {
            throw new IOException(new StringBuffer("Source '").append(file).append("' exists but is not a directory").toString());
        }
        if (file.getCanonicalPath().equals(file2.getCanonicalPath())) {
            throw new IOException(new StringBuffer("Source '").append(file).append("' and destination '").append(file2).append("' are the same").toString());
        }
        doCopyDirectory(file, file2, z);
    }

    private static void doCopyDirectory(File file, File file2, boolean z) throws IOException {
        if (file2.exists()) {
            if (!file2.isDirectory()) {
                throw new IOException(new StringBuffer("Destination '").append(file2).append("' exists but is not a directory").toString());
            }
        } else {
            if (!file2.mkdirs()) {
                throw new IOException(new StringBuffer("Destination '").append(file2).append("' directory cannot be created").toString());
            }
            if (z) {
                file2.setLastModified(file.lastModified());
            }
        }
        if (!file2.canWrite()) {
            throw new IOException(new StringBuffer("Destination '").append(file2).append("' cannot be written to").toString());
        }
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            throw new IOException(new StringBuffer("Failed to list contents of ").append(file).toString());
        }
        for (int i = 0; i < listFiles.length; i++) {
            File file3 = new File(file2, listFiles[i].getName());
            if (listFiles[i].isDirectory()) {
                doCopyDirectory(listFiles[i], file3, z);
            } else {
                doCopyFile(listFiles[i], file3, z);
            }
        }
    }

    public static void copyURLToFile(URL url, File file) throws IOException {
        InputStream openStream = url.openStream();
        try {
            FileOutputStream openOutputStream = openOutputStream(file);
            try {
                IOUtils.copy(openStream, openOutputStream);
            } finally {
                IOUtils.closeQuietly(openOutputStream);
            }
        } finally {
            IOUtils.closeQuietly(openStream);
        }
    }

    public static void deleteDirectory(File file) throws IOException {
        if (file.exists()) {
            cleanDirectory(file);
            if (!file.delete()) {
                throw new IOException(new StringBuffer("Unable to delete directory ").append(file).append(".").toString());
            }
        }
    }

    public static void cleanDirectory(File file) throws IOException {
        if (!file.exists()) {
            throw new IllegalArgumentException(new StringBuffer().append(file).append(" does not exist").toString());
        }
        if (!file.isDirectory()) {
            throw new IllegalArgumentException(new StringBuffer().append(file).append(" is not a directory").toString());
        }
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            throw new IOException(new StringBuffer("Failed to list contents of ").append(file).toString());
        }
        IOException e = null;
        for (File file2 : listFiles) {
            try {
                forceDelete(file2);
            } catch (IOException e2) {
                e = e2;
            }
        }
        if (e != null) {
            throw e;
        }
    }

    public static boolean waitFor(File file, int i) {
        int i2 = 0;
        int i3 = 0;
        while (!file.exists()) {
            int i4 = i2 + 1;
            if (i2 >= 10) {
                int i5 = i3 + 1;
                if (i3 > i) {
                    return false;
                }
                i3 = i5;
                i2 = 0;
            } else {
                i2 = i4;
            }
            try {
                Thread.sleep(100L);
            } catch (InterruptedException unused) {
            } catch (Exception unused2) {
                return true;
            }
        }
        return true;
    }

    public static String readFileToString(File file, String str) throws IOException {
        FileInputStream fileInputStream;
        try {
            fileInputStream = openInputStream(file);
            try {
                String iOUtils = IOUtils.toString(fileInputStream, str);
                IOUtils.closeQuietly(fileInputStream);
                return iOUtils;
            } catch (Throwable th) {
                th = th;
                IOUtils.closeQuietly(fileInputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            fileInputStream = null;
        }
    }

    public static String readFileToString(File file) throws IOException {
        return readFileToString(file, null);
    }

    public static byte[] readFileToByteArray(File file) throws IOException {
        FileInputStream fileInputStream;
        try {
            fileInputStream = openInputStream(file);
            try {
                byte[] byteArray = IOUtils.toByteArray(fileInputStream);
                IOUtils.closeQuietly(fileInputStream);
                return byteArray;
            } catch (Throwable th) {
                th = th;
                IOUtils.closeQuietly(fileInputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            fileInputStream = null;
        }
    }

    public static List readLines(File file, String str) throws IOException {
        FileInputStream fileInputStream;
        try {
            fileInputStream = openInputStream(file);
            try {
                List readLines = IOUtils.readLines(fileInputStream, str);
                IOUtils.closeQuietly(fileInputStream);
                return readLines;
            } catch (Throwable th) {
                th = th;
                IOUtils.closeQuietly(fileInputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            fileInputStream = null;
        }
    }

    public static List readLines(File file) throws IOException {
        return readLines(file, null);
    }

    public static LineIterator lineIterator(File file, String str) throws IOException {
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = openInputStream(file);
            return IOUtils.lineIterator(fileInputStream, str);
        } catch (IOException e) {
            IOUtils.closeQuietly(fileInputStream);
            throw e;
        } catch (RuntimeException e2) {
            IOUtils.closeQuietly(fileInputStream);
            throw e2;
        }
    }

    public static LineIterator lineIterator(File file) throws IOException {
        return lineIterator(file, null);
    }

    public static void writeStringToFile(File file, String str, String str2) throws IOException {
        FileOutputStream fileOutputStream;
        try {
            fileOutputStream = openOutputStream(file);
            try {
                IOUtils.write(str, fileOutputStream, str2);
                IOUtils.closeQuietly(fileOutputStream);
            } catch (Throwable th) {
                th = th;
                IOUtils.closeQuietly(fileOutputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream = null;
        }
    }

    public static void writeStringToFile(File file, String str) throws IOException {
        writeStringToFile(file, str, null);
    }

    public static void writeByteArrayToFile(File file, byte[] bArr) throws IOException {
        FileOutputStream fileOutputStream;
        try {
            fileOutputStream = openOutputStream(file);
            try {
                fileOutputStream.write(bArr);
                IOUtils.closeQuietly(fileOutputStream);
            } catch (Throwable th) {
                th = th;
                IOUtils.closeQuietly(fileOutputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream = null;
        }
    }

    public static void writeLines(File file, String str, Collection collection) throws IOException {
        writeLines(file, str, collection, null);
    }

    public static void writeLines(File file, Collection collection) throws IOException {
        writeLines(file, null, collection, null);
    }

    public static void writeLines(File file, String str, Collection collection, String str2) throws IOException {
        FileOutputStream fileOutputStream;
        try {
            fileOutputStream = openOutputStream(file);
            try {
                IOUtils.writeLines(collection, str2, fileOutputStream, str);
                IOUtils.closeQuietly(fileOutputStream);
            } catch (Throwable th) {
                th = th;
                IOUtils.closeQuietly(fileOutputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream = null;
        }
    }

    public static void writeLines(File file, Collection collection, String str) throws IOException {
        writeLines(file, null, collection, str);
    }

    public static void forceDelete(File file) throws IOException {
        if (file.isDirectory()) {
            deleteDirectory(file);
        } else {
            if (!file.exists()) {
                throw new FileNotFoundException(new StringBuffer("File does not exist: ").append(file).toString());
            }
            if (!file.delete()) {
                throw new IOException(new StringBuffer("Unable to delete file: ").append(file).toString());
            }
        }
    }

    public static void forceDeleteOnExit(File file) throws IOException {
        if (file.isDirectory()) {
            deleteDirectoryOnExit(file);
        } else {
            file.deleteOnExit();
        }
    }

    private static void deleteDirectoryOnExit(File file) throws IOException {
        if (file.exists()) {
            cleanDirectoryOnExit(file);
            file.deleteOnExit();
        }
    }

    private static void cleanDirectoryOnExit(File file) throws IOException {
        if (!file.exists()) {
            throw new IllegalArgumentException(new StringBuffer().append(file).append(" does not exist").toString());
        }
        if (!file.isDirectory()) {
            throw new IllegalArgumentException(new StringBuffer().append(file).append(" is not a directory").toString());
        }
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            throw new IOException(new StringBuffer("Failed to list contents of ").append(file).toString());
        }
        IOException e = null;
        for (File file2 : listFiles) {
            try {
                forceDeleteOnExit(file2);
            } catch (IOException e2) {
                e = e2;
            }
        }
        if (e != null) {
            throw e;
        }
    }

    public static void forceMkdir(File file) throws IOException {
        if (file.exists()) {
            if (file.isFile()) {
                throw new IOException(new StringBuffer("File ").append(file).append(" exists and is not a directory. Unable to create directory.").toString());
            }
        } else if (!file.mkdirs()) {
            throw new IOException(new StringBuffer("Unable to create directory ").append(file).toString());
        }
    }

    public static long sizeOfDirectory(File file) {
        long length;
        if (!file.exists()) {
            throw new IllegalArgumentException(new StringBuffer().append(file).append(" does not exist").toString());
        }
        if (!file.isDirectory()) {
            throw new IllegalArgumentException(new StringBuffer().append(file).append(" is not a directory").toString());
        }
        File[] listFiles = file.listFiles();
        long j = 0;
        if (listFiles == null) {
            return 0L;
        }
        for (File file2 : listFiles) {
            if (file2.isDirectory()) {
                length = sizeOfDirectory(file2);
            } else {
                length = file2.length();
            }
            j += length;
        }
        return j;
    }

    public static boolean isFileNewer(File file, File file2) {
        if (file2 == null) {
            throw new IllegalArgumentException("No specified reference file");
        }
        if (!file2.exists()) {
            throw new IllegalArgumentException(new StringBuffer("The reference file '").append(file).append("' doesn't exist").toString());
        }
        return isFileNewer(file, file2.lastModified());
    }

    public static boolean isFileNewer(File file, Date date) {
        if (date == null) {
            throw new IllegalArgumentException("No specified date");
        }
        return isFileNewer(file, date.getTime());
    }

    public static boolean isFileNewer(File file, long j) {
        if (file != null) {
            return file.exists() && file.lastModified() > j;
        }
        throw new IllegalArgumentException("No specified file");
    }

    public static boolean isFileOlder(File file, File file2) {
        if (file2 == null) {
            throw new IllegalArgumentException("No specified reference file");
        }
        if (!file2.exists()) {
            throw new IllegalArgumentException(new StringBuffer("The reference file '").append(file).append("' doesn't exist").toString());
        }
        return isFileOlder(file, file2.lastModified());
    }

    public static boolean isFileOlder(File file, Date date) {
        if (date == null) {
            throw new IllegalArgumentException("No specified date");
        }
        return isFileOlder(file, date.getTime());
    }

    public static boolean isFileOlder(File file, long j) {
        if (file != null) {
            return file.exists() && file.lastModified() < j;
        }
        throw new IllegalArgumentException("No specified file");
    }

    public static long checksumCRC32(File file) throws IOException {
        CRC32 crc32 = new CRC32();
        checksum(file, crc32);
        return crc32.getValue();
    }

    public static Checksum checksum(File file, Checksum checksum) throws IOException {
        CheckedInputStream checkedInputStream;
        if (file.isDirectory()) {
            throw new IllegalArgumentException("Checksums can't be computed on directories");
        }
        CheckedInputStream checkedInputStream2 = null;
        try {
            checkedInputStream = new CheckedInputStream(new FileInputStream(file), checksum);
        } catch (Throwable th) {
            th = th;
        }
        try {
            IOUtils.copy(checkedInputStream, new NullOutputStream());
            IOUtils.closeQuietly(checkedInputStream);
            return checksum;
        } catch (Throwable th2) {
            th = th2;
            checkedInputStream2 = checkedInputStream;
            IOUtils.closeQuietly(checkedInputStream2);
            throw th;
        }
    }
}
