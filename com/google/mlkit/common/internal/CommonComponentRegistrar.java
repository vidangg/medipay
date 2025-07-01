package com.google.mlkit.common.internal;

import com.google.android.gms.internal.mlkit_common.zzaf;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Dependency;
import com.google.mlkit.common.model.CustomRemoteModel;
import com.google.mlkit.common.model.RemoteModelManager;
import com.google.mlkit.common.sdkinternal.Cleaner;
import com.google.mlkit.common.sdkinternal.CloseGuard;
import com.google.mlkit.common.sdkinternal.ExecutorSelector;
import com.google.mlkit.common.sdkinternal.MlKitContext;
import com.google.mlkit.common.sdkinternal.MlKitThreadPool;
import com.google.mlkit.common.sdkinternal.SharedPrefManager;
import com.google.mlkit.common.sdkinternal.model.ModelFileHelper;
import java.util.List;

/* compiled from: com.google.mlkit:common@@18.11.0 */
/* loaded from: classes4.dex */
public class CommonComponentRegistrar implements ComponentRegistrar {
    public static final /* synthetic */ int zza = 0;

    @Override // com.google.firebase.components.ComponentRegistrar
    public final List getComponents() {
        return zzaf.zzi(SharedPrefManager.COMPONENT, Component.builder(ModelFileHelper.class).add(Dependency.required((Class<?>) MlKitContext.class)).factory(new ComponentFactory() { // from class: com.google.mlkit.common.internal.zza
            @Override // com.google.firebase.components.ComponentFactory
            public final Object create(ComponentContainer componentContainer) {
                int i = CommonComponentRegistrar.zza;
                return new ModelFileHelper((MlKitContext) componentContainer.get(MlKitContext.class));
            }
        }).build(), Component.builder(MlKitThreadPool.class).factory(new ComponentFactory() { // from class: com.google.mlkit.common.internal.zzb
            @Override // com.google.firebase.components.ComponentFactory
            public final Object create(ComponentContainer componentContainer) {
                int i = CommonComponentRegistrar.zza;
                return new MlKitThreadPool();
            }
        }).build(), Component.builder(RemoteModelManager.class).add(Dependency.setOf((Class<?>) RemoteModelManager.RemoteModelManagerRegistration.class)).factory(new ComponentFactory() { // from class: com.google.mlkit.common.internal.zzc
            @Override // com.google.firebase.components.ComponentFactory
            public final Object create(ComponentContainer componentContainer) {
                int i = CommonComponentRegistrar.zza;
                return new RemoteModelManager(componentContainer.setOf(RemoteModelManager.RemoteModelManagerRegistration.class));
            }
        }).build(), Component.builder(ExecutorSelector.class).add(Dependency.requiredProvider((Class<?>) MlKitThreadPool.class)).factory(new ComponentFactory() { // from class: com.google.mlkit.common.internal.zzd
            @Override // com.google.firebase.components.ComponentFactory
            public final Object create(ComponentContainer componentContainer) {
                return new ExecutorSelector(componentContainer.getProvider(MlKitThreadPool.class));
            }
        }).build(), Component.builder(Cleaner.class).factory(new ComponentFactory() { // from class: com.google.mlkit.common.internal.zze
            @Override // com.google.firebase.components.ComponentFactory
            public final Object create(ComponentContainer componentContainer) {
                return Cleaner.create();
            }
        }).build(), Component.builder(CloseGuard.Factory.class).add(Dependency.required((Class<?>) Cleaner.class)).factory(new ComponentFactory() { // from class: com.google.mlkit.common.internal.zzf
            @Override // com.google.firebase.components.ComponentFactory
            public final Object create(ComponentContainer componentContainer) {
                return new CloseGuard.Factory((Cleaner) componentContainer.get(Cleaner.class));
            }
        }).build(), Component.builder(com.google.mlkit.common.internal.model.zzg.class).add(Dependency.required((Class<?>) MlKitContext.class)).factory(new ComponentFactory() { // from class: com.google.mlkit.common.internal.zzg
            @Override // com.google.firebase.components.ComponentFactory
            public final Object create(ComponentContainer componentContainer) {
                return new com.google.mlkit.common.internal.model.zzg((MlKitContext) componentContainer.get(MlKitContext.class));
            }
        }).build(), Component.intoSetBuilder(RemoteModelManager.RemoteModelManagerRegistration.class).add(Dependency.requiredProvider((Class<?>) com.google.mlkit.common.internal.model.zzg.class)).factory(new ComponentFactory() { // from class: com.google.mlkit.common.internal.zzh
            @Override // com.google.firebase.components.ComponentFactory
            public final Object create(ComponentContainer componentContainer) {
                return new RemoteModelManager.RemoteModelManagerRegistration(CustomRemoteModel.class, componentContainer.getProvider(com.google.mlkit.common.internal.model.zzg.class));
            }
        }).build());
    }
}
