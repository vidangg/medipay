package com.google.android.gms.dynamic;

import java.util.Iterator;
import java.util.LinkedList;

/* compiled from: com.google.android.gms:play-services-base@@18.4.0 */
/* loaded from: classes3.dex */
final class zaa implements OnDelegateCreatedListener {
    final /* synthetic */ DeferredLifecycleHelper zaa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zaa(DeferredLifecycleHelper deferredLifecycleHelper) {
        this.zaa = deferredLifecycleHelper;
    }

    @Override // com.google.android.gms.dynamic.OnDelegateCreatedListener
    public final void onDelegateCreated(LifecycleDelegate lifecycleDelegate) {
        LinkedList linkedList;
        LinkedList linkedList2;
        LifecycleDelegate lifecycleDelegate2;
        this.zaa.zaa = lifecycleDelegate;
        linkedList = this.zaa.zac;
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            zah zahVar = (zah) it.next();
            lifecycleDelegate2 = this.zaa.zaa;
            zahVar.zab(lifecycleDelegate2);
        }
        linkedList2 = this.zaa.zac;
        linkedList2.clear();
        this.zaa.zab = null;
    }
}
