package com.google.android.gms.internal.mlkit_vision_common;

import androidx.camera.video.AudioStats;
import com.google.firebase.encoders.EncodingException;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.google.firebase.encoders.ValueEncoder;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import kotlinx.coroutines.scheduling.WorkQueueKt;

/* compiled from: com.google.mlkit:vision-common@@17.3.0 */
/* loaded from: classes3.dex */
final class zzak implements ObjectEncoderContext {
    private static final Charset zza = Charset.forName("UTF-8");
    private static final FieldDescriptor zzb;
    private static final FieldDescriptor zzc;
    private static final ObjectEncoder zzd;
    private OutputStream zze;
    private final Map zzf;
    private final Map zzg;
    private final ObjectEncoder zzh;
    private final zzao zzi = new zzao(this);

    static {
        FieldDescriptor.Builder builder = FieldDescriptor.builder("key");
        zzae zzaeVar = new zzae();
        zzaeVar.zza(1);
        zzb = builder.withProperty(zzaeVar.zzb()).build();
        FieldDescriptor.Builder builder2 = FieldDescriptor.builder("value");
        zzae zzaeVar2 = new zzae();
        zzaeVar2.zza(2);
        zzc = builder2.withProperty(zzaeVar2.zzb()).build();
        zzd = new ObjectEncoder() { // from class: com.google.android.gms.internal.mlkit_vision_common.zzaj
            @Override // com.google.firebase.encoders.Encoder
            public final void encode(Object obj, ObjectEncoderContext objectEncoderContext) {
                zzak.zzg((Map.Entry) obj, objectEncoderContext);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzak(OutputStream outputStream, Map map, Map map2, ObjectEncoder objectEncoder) {
        this.zze = outputStream;
        this.zzf = map;
        this.zzg = map2;
        this.zzh = objectEncoder;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzg(Map.Entry entry, ObjectEncoderContext objectEncoderContext) throws IOException {
        objectEncoderContext.add(zzb, entry.getKey());
        objectEncoderContext.add(zzc, entry.getValue());
    }

    private static int zzh(FieldDescriptor fieldDescriptor) {
        zzai zzaiVar = (zzai) fieldDescriptor.getProperty(zzai.class);
        if (zzaiVar != null) {
            return zzaiVar.zza();
        }
        throw new EncodingException("Field has no @Protobuf config");
    }

    private final long zzi(ObjectEncoder objectEncoder, Object obj) throws IOException {
        zzaf zzafVar = new zzaf();
        try {
            OutputStream outputStream = this.zze;
            this.zze = zzafVar;
            try {
                objectEncoder.encode(obj, this);
                this.zze = outputStream;
                long zza2 = zzafVar.zza();
                zzafVar.close();
                return zza2;
            } catch (Throwable th) {
                this.zze = outputStream;
                throw th;
            }
        } catch (Throwable th2) {
            try {
                zzafVar.close();
            } catch (Throwable th3) {
                try {
                    Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class).invoke(th2, th3);
                } catch (Exception unused) {
                }
            }
            throw th2;
        }
    }

    private static zzai zzj(FieldDescriptor fieldDescriptor) {
        zzai zzaiVar = (zzai) fieldDescriptor.getProperty(zzai.class);
        if (zzaiVar != null) {
            return zzaiVar;
        }
        throw new EncodingException("Field has no @Protobuf config");
    }

    private final zzak zzk(ObjectEncoder objectEncoder, FieldDescriptor fieldDescriptor, Object obj, boolean z) throws IOException {
        long zzi = zzi(objectEncoder, obj);
        if (z && zzi == 0) {
            return this;
        }
        zzn((zzh(fieldDescriptor) << 3) | 2);
        zzo(zzi);
        objectEncoder.encode(obj, this);
        return this;
    }

    private final zzak zzl(ValueEncoder valueEncoder, FieldDescriptor fieldDescriptor, Object obj, boolean z) throws IOException {
        this.zzi.zza(fieldDescriptor, z);
        valueEncoder.encode(obj, this.zzi);
        return this;
    }

    private static ByteBuffer zzm(int i) {
        return ByteBuffer.allocate(i).order(ByteOrder.LITTLE_ENDIAN);
    }

    private final void zzn(int i) throws IOException {
        while ((i & (-128)) != 0) {
            this.zze.write((i & WorkQueueKt.MASK) | 128);
            i >>>= 7;
        }
        this.zze.write(i & WorkQueueKt.MASK);
    }

    private final void zzo(long j) throws IOException {
        while (((-128) & j) != 0) {
            this.zze.write((((int) j) & WorkQueueKt.MASK) | 128);
            j >>>= 7;
        }
        this.zze.write(((int) j) & WorkQueueKt.MASK);
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public final ObjectEncoderContext add(FieldDescriptor fieldDescriptor, double d) throws IOException {
        zza(fieldDescriptor, d, true);
        return this;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public final ObjectEncoderContext inline(Object obj) throws IOException {
        zzf(obj);
        return this;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public final ObjectEncoderContext nested(FieldDescriptor fieldDescriptor) throws IOException {
        throw new EncodingException("nested() is not implemented for protobuf encoding.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final ObjectEncoderContext zza(FieldDescriptor fieldDescriptor, double d, boolean z) throws IOException {
        if (z && d == AudioStats.AUDIO_AMPLITUDE_NONE) {
            return this;
        }
        zzn((zzh(fieldDescriptor) << 3) | 1);
        this.zze.write(zzm(8).putDouble(d).array());
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final ObjectEncoderContext zzb(FieldDescriptor fieldDescriptor, float f, boolean z) throws IOException {
        if (z && f == 0.0f) {
            return this;
        }
        zzn((zzh(fieldDescriptor) << 3) | 5);
        this.zze.write(zzm(4).putFloat(f).array());
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final ObjectEncoderContext zzc(FieldDescriptor fieldDescriptor, Object obj, boolean z) throws IOException {
        if (obj == null) {
            return this;
        }
        if (obj instanceof CharSequence) {
            CharSequence charSequence = (CharSequence) obj;
            if (z && charSequence.length() == 0) {
                return this;
            }
            zzn((zzh(fieldDescriptor) << 3) | 2);
            byte[] bytes = charSequence.toString().getBytes(zza);
            zzn(bytes.length);
            this.zze.write(bytes);
            return this;
        }
        if (obj instanceof Collection) {
            Iterator it = ((Collection) obj).iterator();
            while (it.hasNext()) {
                zzc(fieldDescriptor, it.next(), false);
            }
            return this;
        }
        if (obj instanceof Map) {
            Iterator it2 = ((Map) obj).entrySet().iterator();
            while (it2.hasNext()) {
                zzk(zzd, fieldDescriptor, (Map.Entry) it2.next(), false);
            }
            return this;
        }
        if (obj instanceof Double) {
            zza(fieldDescriptor, ((Double) obj).doubleValue(), z);
            return this;
        }
        if (obj instanceof Float) {
            zzb(fieldDescriptor, ((Float) obj).floatValue(), z);
            return this;
        }
        if (obj instanceof Number) {
            zze(fieldDescriptor, ((Number) obj).longValue(), z);
            return this;
        }
        if (obj instanceof Boolean) {
            zzd(fieldDescriptor, ((Boolean) obj).booleanValue() ? 1 : 0, z);
            return this;
        }
        if (obj instanceof byte[]) {
            byte[] bArr = (byte[]) obj;
            if (z && bArr.length == 0) {
                return this;
            }
            zzn((zzh(fieldDescriptor) << 3) | 2);
            zzn(bArr.length);
            this.zze.write(bArr);
            return this;
        }
        ObjectEncoder objectEncoder = (ObjectEncoder) this.zzf.get(obj.getClass());
        if (objectEncoder != null) {
            zzk(objectEncoder, fieldDescriptor, obj, z);
            return this;
        }
        ValueEncoder valueEncoder = (ValueEncoder) this.zzg.get(obj.getClass());
        if (valueEncoder != null) {
            zzl(valueEncoder, fieldDescriptor, obj, z);
            return this;
        }
        if (obj instanceof zzag) {
            zzd(fieldDescriptor, ((zzag) obj).zza(), true);
            return this;
        }
        if (obj instanceof Enum) {
            zzd(fieldDescriptor, ((Enum) obj).ordinal(), true);
            return this;
        }
        zzk(this.zzh, fieldDescriptor, obj, z);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzak zzd(FieldDescriptor fieldDescriptor, int i, boolean z) throws IOException {
        if (z && i == 0) {
            return this;
        }
        zzai zzj = zzj(fieldDescriptor);
        zzah zzahVar = zzah.DEFAULT;
        int ordinal = zzj.zzb().ordinal();
        if (ordinal == 0) {
            zzn(zzj.zza() << 3);
            zzn(i);
        } else if (ordinal == 1) {
            zzn(zzj.zza() << 3);
            zzn((i + i) ^ (i >> 31));
        } else if (ordinal == 2) {
            zzn((zzj.zza() << 3) | 5);
            this.zze.write(zzm(4).putInt(i).array());
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzak zze(FieldDescriptor fieldDescriptor, long j, boolean z) throws IOException {
        if (z && j == 0) {
            return this;
        }
        zzai zzj = zzj(fieldDescriptor);
        zzah zzahVar = zzah.DEFAULT;
        int ordinal = zzj.zzb().ordinal();
        if (ordinal == 0) {
            zzn(zzj.zza() << 3);
            zzo(j);
        } else if (ordinal == 1) {
            zzn(zzj.zza() << 3);
            zzo((j >> 63) ^ (j + j));
        } else if (ordinal == 2) {
            zzn((zzj.zza() << 3) | 1);
            this.zze.write(zzm(8).putLong(j).array());
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzak zzf(Object obj) throws IOException {
        if (obj == null) {
            return this;
        }
        ObjectEncoder objectEncoder = (ObjectEncoder) this.zzf.get(obj.getClass());
        if (objectEncoder != null) {
            objectEncoder.encode(obj, this);
            return this;
        }
        throw new EncodingException("No encoder for ".concat(String.valueOf(String.valueOf(obj.getClass()))));
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public final ObjectEncoderContext add(FieldDescriptor fieldDescriptor, float f) throws IOException {
        zzb(fieldDescriptor, f, true);
        return this;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public final ObjectEncoderContext nested(String str) throws IOException {
        return nested(FieldDescriptor.of(str));
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public final /* synthetic */ ObjectEncoderContext add(FieldDescriptor fieldDescriptor, int i) throws IOException {
        zzd(fieldDescriptor, i, true);
        return this;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public final /* synthetic */ ObjectEncoderContext add(FieldDescriptor fieldDescriptor, long j) throws IOException {
        zze(fieldDescriptor, j, true);
        return this;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public final ObjectEncoderContext add(FieldDescriptor fieldDescriptor, Object obj) throws IOException {
        zzc(fieldDescriptor, obj, true);
        return this;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public final /* synthetic */ ObjectEncoderContext add(FieldDescriptor fieldDescriptor, boolean z) throws IOException {
        zzd(fieldDescriptor, z ? 1 : 0, true);
        return this;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public final ObjectEncoderContext add(String str, double d) throws IOException {
        zza(FieldDescriptor.of(str), d, true);
        return this;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public final ObjectEncoderContext add(String str, int i) throws IOException {
        zzd(FieldDescriptor.of(str), i, true);
        return this;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public final ObjectEncoderContext add(String str, long j) throws IOException {
        zze(FieldDescriptor.of(str), j, true);
        return this;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public final ObjectEncoderContext add(String str, Object obj) throws IOException {
        zzc(FieldDescriptor.of(str), obj, true);
        return this;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public final ObjectEncoderContext add(String str, boolean z) throws IOException {
        zzd(FieldDescriptor.of(str), z ? 1 : 0, true);
        return this;
    }
}
