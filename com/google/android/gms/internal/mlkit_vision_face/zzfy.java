package com.google.android.gms.internal.mlkit_vision_face;

import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.tekartik.sqflite.Constant;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-mlkit-face-detection@@17.1.0 */
/* loaded from: classes3.dex */
final class zzfy implements ObjectEncoder {
    static final zzfy zza = new zzfy();
    private static final FieldDescriptor zzb;
    private static final FieldDescriptor zzc;
    private static final FieldDescriptor zzd;
    private static final FieldDescriptor zze;
    private static final FieldDescriptor zzf;

    static {
        FieldDescriptor.Builder builder = FieldDescriptor.builder("inferenceCommonLogEvent");
        zzcq zzcqVar = new zzcq();
        zzcqVar.zza(1);
        zzb = builder.withProperty(zzcqVar.zzb()).build();
        FieldDescriptor.Builder builder2 = FieldDescriptor.builder(Constant.METHOD_OPTIONS);
        zzcq zzcqVar2 = new zzcq();
        zzcqVar2.zza(2);
        zzc = builder2.withProperty(zzcqVar2.zzb()).build();
        FieldDescriptor.Builder builder3 = FieldDescriptor.builder("inputsFormats");
        zzcq zzcqVar3 = new zzcq();
        zzcqVar3.zza(3);
        zzd = builder3.withProperty(zzcqVar3.zzb()).build();
        FieldDescriptor.Builder builder4 = FieldDescriptor.builder("outputFormats");
        zzcq zzcqVar4 = new zzcq();
        zzcqVar4.zza(4);
        zze = builder4.withProperty(zzcqVar4.zzb()).build();
        FieldDescriptor.Builder builder5 = FieldDescriptor.builder("modelInitializationMs");
        zzcq zzcqVar5 = new zzcq();
        zzcqVar5.zza(5);
        zzf = builder5.withProperty(zzcqVar5.zzb()).build();
    }

    private zzfy() {
    }

    @Override // com.google.firebase.encoders.Encoder
    public final /* bridge */ /* synthetic */ void encode(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
        throw null;
    }
}
