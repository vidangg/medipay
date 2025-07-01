package androidx.camera.core.impl;

import androidx.camera.core.impl.utils.ResolutionSelectorUtil;
import androidx.camera.core.resolutionselector.ResolutionSelector;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

/* loaded from: classes.dex */
public interface Config {

    /* loaded from: classes.dex */
    public interface OptionMatcher {
        boolean onOptionMatched(Option<?> option);
    }

    /* loaded from: classes.dex */
    public enum OptionPriority {
        ALWAYS_OVERRIDE,
        REQUIRED,
        OPTIONAL
    }

    boolean containsOption(Option<?> option);

    void findOptions(String str, OptionMatcher optionMatcher);

    OptionPriority getOptionPriority(Option<?> option);

    Set<OptionPriority> getPriorities(Option<?> option);

    Set<Option<?>> listOptions();

    <ValueT> ValueT retrieveOption(Option<ValueT> option);

    <ValueT> ValueT retrieveOption(Option<ValueT> option, ValueT valuet);

    <ValueT> ValueT retrieveOptionWithPriority(Option<ValueT> option, OptionPriority optionPriority);

    /* loaded from: classes.dex */
    public static abstract class Option<T> {
        public abstract String getId();

        public abstract Object getToken();

        public abstract Class<T> getValueClass();

        public static <T> Option<T> create(String str, Class<?> cls) {
            return create(str, cls, null);
        }

        public static <T> Option<T> create(String str, Class<?> cls, Object obj) {
            return new AutoValue_Config_Option(str, cls, obj);
        }
    }

    static boolean hasConflict(OptionPriority optionPriority, OptionPriority optionPriority2) {
        if (optionPriority == OptionPriority.ALWAYS_OVERRIDE && optionPriority2 == OptionPriority.ALWAYS_OVERRIDE) {
            return true;
        }
        return optionPriority == OptionPriority.REQUIRED && optionPriority2 == OptionPriority.REQUIRED;
    }

    static Config mergeConfigs(Config config, Config config2) {
        MutableOptionsBundle create;
        if (config == null && config2 == null) {
            return OptionsBundle.emptyBundle();
        }
        if (config2 != null) {
            create = MutableOptionsBundle.from(config2);
        } else {
            create = MutableOptionsBundle.create();
        }
        if (config != null) {
            Iterator<Option<?>> it = config.listOptions().iterator();
            while (it.hasNext()) {
                mergeOptionValue(create, config2, config, it.next());
            }
        }
        return OptionsBundle.from(create);
    }

    static void mergeOptionValue(MutableOptionsBundle mutableOptionsBundle, Config config, Config config2, Option<?> option) {
        if (Objects.equals(option, ImageOutputConfig.OPTION_RESOLUTION_SELECTOR)) {
            ResolutionSelector resolutionSelector = (ResolutionSelector) config2.retrieveOption(option, null);
            mutableOptionsBundle.insertOption(option, config2.getOptionPriority(option), ResolutionSelectorUtil.overrideResolutionSelectors((ResolutionSelector) config.retrieveOption(option, null), resolutionSelector));
            return;
        }
        mutableOptionsBundle.insertOption(option, config2.getOptionPriority(option), config2.retrieveOption(option));
    }
}
