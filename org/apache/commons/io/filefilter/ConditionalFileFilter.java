package org.apache.commons.io.filefilter;

import java.util.List;

/* loaded from: classes4.dex */
public interface ConditionalFileFilter {
    void addFileFilter(IOFileFilter iOFileFilter);

    List getFileFilters();

    boolean removeFileFilter(IOFileFilter iOFileFilter);

    void setFileFilters(List list);
}
