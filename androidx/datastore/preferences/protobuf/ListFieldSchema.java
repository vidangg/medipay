package androidx.datastore.preferences.protobuf;

import java.util.List;

@CheckReturnValue
/* loaded from: classes.dex */
interface ListFieldSchema {
    void makeImmutableListAt(Object msg, long offset);

    <L> void mergeListsAt(Object msg, Object otherMsg, long offset);

    <L> List<L> mutableListAt(Object msg, long offset);
}
