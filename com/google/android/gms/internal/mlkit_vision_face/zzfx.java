package com.google.android.gms.internal.mlkit_vision_face;

import androidx.media3.exoplayer.rtsp.SessionDescription;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-mlkit-face-detection@@17.1.0 */
/* loaded from: classes3.dex */
final class zzfx implements ObjectEncoder {
    static final zzfx zza = new zzfx();
    private static final FieldDescriptor zzb;
    private static final FieldDescriptor zzc;

    static {
        FieldDescriptor.Builder builder = FieldDescriptor.builder(SessionDescription.ATTR_TYPE);
        zzcq zzcqVar = new zzcq();
        zzcqVar.zza(1);
        zzb = builder.withProperty(zzcqVar.zzb()).build();
        FieldDescriptor.Builder builder2 = FieldDescriptor.builder("dims");
        zzcq zzcqVar2 = new zzcq();
        zzcqVar2.zza(2);
        zzc = builder2.withProperty(zzcqVar2.zzb()).build();
    }

    private zzfx() {
    }

    @Override // com.google.firebase.encoders.Encoder
    public final /* bridge */ /* synthetic */ void encode(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
        throw null;
    }
}
