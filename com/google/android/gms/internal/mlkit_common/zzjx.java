package com.google.android.gms.internal.mlkit_common;

import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import java.io.IOException;

/* compiled from: com.google.mlkit:common@@18.11.0 */
/* loaded from: classes3.dex */
final class zzjx implements ObjectEncoder {
    static final zzjx zza = new zzjx();

    static {
        FieldDescriptor.Builder builder = FieldDescriptor.builder("durationMs");
        zzay zzayVar = new zzay();
        zzayVar.zza(1);
        builder.withProperty(zzayVar.zzb()).build();
        FieldDescriptor.Builder builder2 = FieldDescriptor.builder("handledErrors");
        zzay zzayVar2 = new zzay();
        zzayVar2.zza(2);
        builder2.withProperty(zzayVar2.zzb()).build();
        FieldDescriptor.Builder builder3 = FieldDescriptor.builder("partiallyHandledErrors");
        zzay zzayVar3 = new zzay();
        zzayVar3.zza(3);
        builder3.withProperty(zzayVar3.zzb()).build();
        FieldDescriptor.Builder builder4 = FieldDescriptor.builder("unhandledErrors");
        zzay zzayVar4 = new zzay();
        zzayVar4.zza(4);
        builder4.withProperty(zzayVar4.zzb()).build();
        FieldDescriptor.Builder builder5 = FieldDescriptor.builder("httpResponseCode");
        zzay zzayVar5 = new zzay();
        zzayVar5.zza(5);
        builder5.withProperty(zzayVar5.zzb()).build();
    }

    private zzjx() {
    }

    @Override // com.google.firebase.encoders.Encoder
    public final /* bridge */ /* synthetic */ void encode(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
        throw null;
    }
}
