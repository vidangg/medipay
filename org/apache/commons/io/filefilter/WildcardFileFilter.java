package org.apache.commons.io.filefilter;

import java.io.File;
import java.util.List;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOCase;

/* loaded from: classes4.dex */
public class WildcardFileFilter extends AbstractFileFilter {
    private IOCase caseSensitivity;
    private String[] wildcards;

    public WildcardFileFilter(String str) {
        this(str, (IOCase) null);
    }

    public WildcardFileFilter(String str, IOCase iOCase) {
        if (str == null) {
            throw new IllegalArgumentException("The wildcard must not be null");
        }
        this.wildcards = new String[]{str};
        this.caseSensitivity = iOCase == null ? IOCase.SENSITIVE : iOCase;
    }

    public WildcardFileFilter(String[] strArr) {
        this(strArr, (IOCase) null);
    }

    public WildcardFileFilter(String[] strArr, IOCase iOCase) {
        if (strArr == null) {
            throw new IllegalArgumentException("The wildcard array must not be null");
        }
        this.wildcards = strArr;
        this.caseSensitivity = iOCase == null ? IOCase.SENSITIVE : iOCase;
    }

    public WildcardFileFilter(List list) {
        this(list, (IOCase) null);
    }

    public WildcardFileFilter(List list, IOCase iOCase) {
        if (list == null) {
            throw new IllegalArgumentException("The wildcard list must not be null");
        }
        this.wildcards = (String[]) list.toArray(new String[list.size()]);
        this.caseSensitivity = iOCase == null ? IOCase.SENSITIVE : iOCase;
    }

    @Override // org.apache.commons.io.filefilter.AbstractFileFilter, org.apache.commons.io.filefilter.IOFileFilter, java.io.FilenameFilter
    public boolean accept(File file, String str) {
        int i = 0;
        while (true) {
            String[] strArr = this.wildcards;
            if (i >= strArr.length) {
                return false;
            }
            if (FilenameUtils.wildcardMatch(str, strArr[i], this.caseSensitivity)) {
                return true;
            }
            i++;
        }
    }

    @Override // org.apache.commons.io.filefilter.AbstractFileFilter, org.apache.commons.io.filefilter.IOFileFilter, java.io.FileFilter
    public boolean accept(File file) {
        String name = file.getName();
        int i = 0;
        while (true) {
            String[] strArr = this.wildcards;
            if (i >= strArr.length) {
                return false;
            }
            if (FilenameUtils.wildcardMatch(name, strArr[i], this.caseSensitivity)) {
                return true;
            }
            i++;
        }
    }
}
