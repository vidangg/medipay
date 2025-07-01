package org.apache.commons.io.filefilter;

import java.io.File;
import java.util.List;
import org.apache.commons.io.FilenameUtils;

/* loaded from: classes4.dex */
public class WildcardFilter extends AbstractFileFilter {
    private String[] wildcards;

    public WildcardFilter(String str) {
        if (str == null) {
            throw new IllegalArgumentException("The wildcard must not be null");
        }
        this.wildcards = new String[]{str};
    }

    public WildcardFilter(String[] strArr) {
        if (strArr == null) {
            throw new IllegalArgumentException("The wildcard array must not be null");
        }
        this.wildcards = strArr;
    }

    public WildcardFilter(List list) {
        if (list == null) {
            throw new IllegalArgumentException("The wildcard list must not be null");
        }
        this.wildcards = (String[]) list.toArray(new String[list.size()]);
    }

    @Override // org.apache.commons.io.filefilter.AbstractFileFilter, org.apache.commons.io.filefilter.IOFileFilter, java.io.FilenameFilter
    public boolean accept(File file, String str) {
        if (file != null && new File(file, str).isDirectory()) {
            return false;
        }
        int i = 0;
        while (true) {
            String[] strArr = this.wildcards;
            if (i >= strArr.length) {
                return false;
            }
            if (FilenameUtils.wildcardMatch(str, strArr[i])) {
                return true;
            }
            i++;
        }
    }

    @Override // org.apache.commons.io.filefilter.AbstractFileFilter, org.apache.commons.io.filefilter.IOFileFilter, java.io.FileFilter
    public boolean accept(File file) {
        if (file.isDirectory()) {
            return false;
        }
        for (int i = 0; i < this.wildcards.length; i++) {
            if (FilenameUtils.wildcardMatch(file.getName(), this.wildcards[i])) {
                return true;
            }
        }
        return false;
    }
}
