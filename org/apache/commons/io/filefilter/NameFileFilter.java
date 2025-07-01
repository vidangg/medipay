package org.apache.commons.io.filefilter;

import java.io.File;
import java.util.List;
import org.apache.commons.io.IOCase;

/* loaded from: classes4.dex */
public class NameFileFilter extends AbstractFileFilter {
    private IOCase caseSensitivity;
    private String[] names;

    public NameFileFilter(String str) {
        this(str, (IOCase) null);
    }

    public NameFileFilter(String str, IOCase iOCase) {
        if (str == null) {
            throw new IllegalArgumentException("The wildcard must not be null");
        }
        this.names = new String[]{str};
        this.caseSensitivity = iOCase == null ? IOCase.SENSITIVE : iOCase;
    }

    public NameFileFilter(String[] strArr) {
        this(strArr, (IOCase) null);
    }

    public NameFileFilter(String[] strArr, IOCase iOCase) {
        if (strArr == null) {
            throw new IllegalArgumentException("The array of names must not be null");
        }
        this.names = strArr;
        this.caseSensitivity = iOCase == null ? IOCase.SENSITIVE : iOCase;
    }

    public NameFileFilter(List list) {
        this(list, (IOCase) null);
    }

    public NameFileFilter(List list, IOCase iOCase) {
        if (list == null) {
            throw new IllegalArgumentException("The list of names must not be null");
        }
        this.names = (String[]) list.toArray(new String[list.size()]);
        this.caseSensitivity = iOCase == null ? IOCase.SENSITIVE : iOCase;
    }

    @Override // org.apache.commons.io.filefilter.AbstractFileFilter, org.apache.commons.io.filefilter.IOFileFilter, java.io.FileFilter
    public boolean accept(File file) {
        String name = file.getName();
        int i = 0;
        while (true) {
            String[] strArr = this.names;
            if (i >= strArr.length) {
                return false;
            }
            if (this.caseSensitivity.checkEquals(name, strArr[i])) {
                return true;
            }
            i++;
        }
    }

    @Override // org.apache.commons.io.filefilter.AbstractFileFilter, org.apache.commons.io.filefilter.IOFileFilter, java.io.FilenameFilter
    public boolean accept(File file, String str) {
        int i = 0;
        while (true) {
            String[] strArr = this.names;
            if (i >= strArr.length) {
                return false;
            }
            if (this.caseSensitivity.checkEquals(str, strArr[i])) {
                return true;
            }
            i++;
        }
    }
}
