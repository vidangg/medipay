package com.google.android.gms.flags;

import android.content.Context;
import com.google.android.gms.flags.Flag;
import java.util.ArrayList;
import java.util.Collection;

/* loaded from: classes3.dex */
public class FlagRegistry {
    private final Collection<Flag> zzg = new ArrayList();
    private final Collection<Flag.StringFlag> zzh = new ArrayList();
    private final Collection<Flag.StringFlag> zzi = new ArrayList();

    public final void zza(Flag flag) {
        this.zzg.add(flag);
    }

    public static void initialize(Context context) {
        Singletons.zzd().initialize(context);
    }
}
