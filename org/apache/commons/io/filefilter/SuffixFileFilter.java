package org.apache.commons.io.filefilter;

import java.io.File;
import java.util.List;

/* loaded from: classes4.dex */
public class SuffixFileFilter extends AbstractFileFilter {
    private String[] suffixes;

    public SuffixFileFilter(String str) {
        if (str == null) {
            throw new IllegalArgumentException("The suffix must not be null");
        }
        this.suffixes = new String[]{str};
    }

    public SuffixFileFilter(String[] strArr) {
        if (strArr == null) {
            throw new IllegalArgumentException("The array of suffixes must not be null");
        }
        this.suffixes = strArr;
    }

    public SuffixFileFilter(List list) {
        if (list == null) {
            throw new IllegalArgumentException("The list of suffixes must not be null");
        }
        this.suffixes = (String[]) list.toArray(new String[list.size()]);
    }

    @Override // org.apache.commons.io.filefilter.AbstractFileFilter, org.apache.commons.io.filefilter.IOFileFilter, java.io.FileFilter
    public boolean accept(File file) {
        String name = file.getName();
        int i = 0;
        while (true) {
            String[] strArr = this.suffixes;
            if (i >= strArr.length) {
                return false;
            }
            if (name.endsWith(strArr[i])) {
                return true;
            }
            i++;
        }
    }

    @Override // org.apache.commons.io.filefilter.AbstractFileFilter, org.apache.commons.io.filefilter.IOFileFilter, java.io.FilenameFilter
    public boolean accept(File file, String str) {
        int i = 0;
        while (true) {
            String[] strArr = this.suffixes;
            if (i >= strArr.length) {
                return false;
            }
            if (str.endsWith(strArr[i])) {
                return true;
            }
            i++;
        }
    }
}
