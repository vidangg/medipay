package org.apache.commons.io.filefilter;

import java.io.File;
import java.util.List;

/* loaded from: classes4.dex */
public class PrefixFileFilter extends AbstractFileFilter {
    private String[] prefixes;

    public PrefixFileFilter(String str) {
        if (str == null) {
            throw new IllegalArgumentException("The prefix must not be null");
        }
        this.prefixes = new String[]{str};
    }

    public PrefixFileFilter(String[] strArr) {
        if (strArr == null) {
            throw new IllegalArgumentException("The array of prefixes must not be null");
        }
        this.prefixes = strArr;
    }

    public PrefixFileFilter(List list) {
        if (list == null) {
            throw new IllegalArgumentException("The list of prefixes must not be null");
        }
        this.prefixes = (String[]) list.toArray(new String[list.size()]);
    }

    @Override // org.apache.commons.io.filefilter.AbstractFileFilter, org.apache.commons.io.filefilter.IOFileFilter, java.io.FileFilter
    public boolean accept(File file) {
        String name = file.getName();
        int i = 0;
        while (true) {
            String[] strArr = this.prefixes;
            if (i >= strArr.length) {
                return false;
            }
            if (name.startsWith(strArr[i])) {
                return true;
            }
            i++;
        }
    }

    @Override // org.apache.commons.io.filefilter.AbstractFileFilter, org.apache.commons.io.filefilter.IOFileFilter, java.io.FilenameFilter
    public boolean accept(File file, String str) {
        int i = 0;
        while (true) {
            String[] strArr = this.prefixes;
            if (i >= strArr.length) {
                return false;
            }
            if (str.startsWith(strArr[i])) {
                return true;
            }
            i++;
        }
    }
}
