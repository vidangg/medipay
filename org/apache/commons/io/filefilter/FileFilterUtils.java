package org.apache.commons.io.filefilter;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.util.Date;

/* loaded from: classes4.dex */
public class FileFilterUtils {
    private static IOFileFilter cvsFilter;
    private static IOFileFilter svnFilter;

    public static IOFileFilter prefixFileFilter(String str) {
        return new PrefixFileFilter(str);
    }

    public static IOFileFilter suffixFileFilter(String str) {
        return new SuffixFileFilter(str);
    }

    public static IOFileFilter nameFileFilter(String str) {
        return new NameFileFilter(str);
    }

    public static IOFileFilter directoryFileFilter() {
        return DirectoryFileFilter.DIRECTORY;
    }

    public static IOFileFilter fileFileFilter() {
        return FileFileFilter.FILE;
    }

    public static IOFileFilter andFileFilter(IOFileFilter iOFileFilter, IOFileFilter iOFileFilter2) {
        return new AndFileFilter(iOFileFilter, iOFileFilter2);
    }

    public static IOFileFilter orFileFilter(IOFileFilter iOFileFilter, IOFileFilter iOFileFilter2) {
        return new OrFileFilter(iOFileFilter, iOFileFilter2);
    }

    public static IOFileFilter notFileFilter(IOFileFilter iOFileFilter) {
        return new NotFileFilter(iOFileFilter);
    }

    public static IOFileFilter trueFileFilter() {
        return TrueFileFilter.TRUE;
    }

    public static IOFileFilter falseFileFilter() {
        return FalseFileFilter.FALSE;
    }

    public static IOFileFilter asFileFilter(FileFilter fileFilter) {
        return new DelegateFileFilter(fileFilter);
    }

    public static IOFileFilter asFileFilter(FilenameFilter filenameFilter) {
        return new DelegateFileFilter(filenameFilter);
    }

    public static IOFileFilter ageFileFilter(long j) {
        return new AgeFileFilter(j);
    }

    public static IOFileFilter ageFileFilter(long j, boolean z) {
        return new AgeFileFilter(j, z);
    }

    public static IOFileFilter ageFileFilter(Date date) {
        return new AgeFileFilter(date);
    }

    public static IOFileFilter ageFileFilter(Date date, boolean z) {
        return new AgeFileFilter(date, z);
    }

    public static IOFileFilter ageFileFilter(File file) {
        return new AgeFileFilter(file);
    }

    public static IOFileFilter ageFileFilter(File file, boolean z) {
        return new AgeFileFilter(file, z);
    }

    public static IOFileFilter sizeFileFilter(long j) {
        return new SizeFileFilter(j);
    }

    public static IOFileFilter sizeFileFilter(long j, boolean z) {
        return new SizeFileFilter(j, z);
    }

    public static IOFileFilter sizeRangeFileFilter(long j, long j2) {
        return new AndFileFilter(new SizeFileFilter(j, true), new SizeFileFilter(j2 + 1, false));
    }

    public static IOFileFilter makeCVSAware(IOFileFilter iOFileFilter) {
        if (cvsFilter == null) {
            cvsFilter = notFileFilter(andFileFilter(directoryFileFilter(), nameFileFilter("CVS")));
        }
        if (iOFileFilter == null) {
            return cvsFilter;
        }
        return andFileFilter(iOFileFilter, cvsFilter);
    }

    public static IOFileFilter makeSVNAware(IOFileFilter iOFileFilter) {
        if (svnFilter == null) {
            svnFilter = notFileFilter(andFileFilter(directoryFileFilter(), nameFileFilter(".svn")));
        }
        if (iOFileFilter == null) {
            return svnFilter;
        }
        return andFileFilter(iOFileFilter, svnFilter);
    }

    public static IOFileFilter makeDirectoryOnly(IOFileFilter iOFileFilter) {
        if (iOFileFilter == null) {
            return DirectoryFileFilter.DIRECTORY;
        }
        return new AndFileFilter(DirectoryFileFilter.DIRECTORY, iOFileFilter);
    }

    public static IOFileFilter makeFileOnly(IOFileFilter iOFileFilter) {
        if (iOFileFilter == null) {
            return FileFileFilter.FILE;
        }
        return new AndFileFilter(FileFileFilter.FILE, iOFileFilter);
    }
}
