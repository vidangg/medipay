package com.google.common.base;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
/* loaded from: classes.dex */
public final class Splitter {
    private final int limit;
    private final boolean omitEmptyStrings;
    private final Strategy strategy;
    private final CharMatcher trimmer;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public interface Strategy {
        Iterator<String> iterator(Splitter splitter, CharSequence toSplit);
    }

    private Splitter(Strategy strategy) {
        this(strategy, false, CharMatcher.none(), Integer.MAX_VALUE);
    }

    private Splitter(Strategy strategy, boolean omitEmptyStrings, CharMatcher trimmer, int limit) {
        this.strategy = strategy;
        this.omitEmptyStrings = omitEmptyStrings;
        this.trimmer = trimmer;
        this.limit = limit;
    }

    public static Splitter on(char separator) {
        return on(CharMatcher.is(separator));
    }

    public static Splitter on(final CharMatcher separatorMatcher) {
        Preconditions.checkNotNull(separatorMatcher);
        return new Splitter(new Strategy() { // from class: com.google.common.base.Splitter.1
            @Override // com.google.common.base.Splitter.Strategy
            public SplittingIterator iterator(Splitter splitter, final CharSequence toSplit) {
                return new SplittingIterator(splitter, toSplit) { // from class: com.google.common.base.Splitter.1.1
                    @Override // com.google.common.base.Splitter.SplittingIterator
                    int separatorEnd(int separatorPosition) {
                        return separatorPosition + 1;
                    }

                    @Override // com.google.common.base.Splitter.SplittingIterator
                    int separatorStart(int start) {
                        return CharMatcher.this.indexIn(this.toSplit, start);
                    }
                };
            }
        });
    }

    public static Splitter on(final String separator) {
        Preconditions.checkArgument(separator.length() != 0, "The separator may not be the empty string.");
        if (separator.length() == 1) {
            return on(separator.charAt(0));
        }
        return new Splitter(new Strategy() { // from class: com.google.common.base.Splitter.2
            @Override // com.google.common.base.Splitter.Strategy
            public SplittingIterator iterator(Splitter splitter, CharSequence toSplit) {
                return new SplittingIterator(splitter, toSplit) { // from class: com.google.common.base.Splitter.2.1
                    /* JADX WARN: Code restructure failed: missing block: B:9:0x0026, code lost:
                    
                        r6 = r6 + 1;
                     */
                    @Override // com.google.common.base.Splitter.SplittingIterator
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public int separatorStart(int start) {
                        int length = separator.length();
                        int length2 = this.toSplit.length() - length;
                        while (start <= length2) {
                            for (int i = 0; i < length; i++) {
                                if (this.toSplit.charAt(i + start) != separator.charAt(i)) {
                                    break;
                                }
                            }
                            return start;
                        }
                        return -1;
                    }

                    @Override // com.google.common.base.Splitter.SplittingIterator
                    public int separatorEnd(int separatorPosition) {
                        return separatorPosition + separator.length();
                    }
                };
            }
        });
    }

    public static Splitter on(Pattern separatorPattern) {
        return onPatternInternal(new JdkPattern(separatorPattern));
    }

    static Splitter onPatternInternal(final CommonPattern separatorPattern) {
        Preconditions.checkArgument(!separatorPattern.matcher("").matches(), "The pattern may not match the empty string: %s", separatorPattern);
        return new Splitter(new Strategy() { // from class: com.google.common.base.Splitter.3
            @Override // com.google.common.base.Splitter.Strategy
            public SplittingIterator iterator(final Splitter splitter, CharSequence toSplit) {
                final CommonMatcher matcher = CommonPattern.this.matcher(toSplit);
                return new SplittingIterator(this, splitter, toSplit) { // from class: com.google.common.base.Splitter.3.1
                    @Override // com.google.common.base.Splitter.SplittingIterator
                    public int separatorStart(int start) {
                        if (matcher.find(start)) {
                            return matcher.start();
                        }
                        return -1;
                    }

                    @Override // com.google.common.base.Splitter.SplittingIterator
                    public int separatorEnd(int separatorPosition) {
                        return matcher.end();
                    }
                };
            }
        });
    }

    public static Splitter onPattern(String separatorPattern) {
        return onPatternInternal(Platform.compilePattern(separatorPattern));
    }

    public static Splitter fixedLength(final int length) {
        Preconditions.checkArgument(length > 0, "The length may not be less than 1");
        return new Splitter(new Strategy() { // from class: com.google.common.base.Splitter.4
            @Override // com.google.common.base.Splitter.Strategy
            public SplittingIterator iterator(final Splitter splitter, CharSequence toSplit) {
                return new SplittingIterator(splitter, toSplit) { // from class: com.google.common.base.Splitter.4.1
                    @Override // com.google.common.base.Splitter.SplittingIterator
                    public int separatorEnd(int separatorPosition) {
                        return separatorPosition;
                    }

                    @Override // com.google.common.base.Splitter.SplittingIterator
                    public int separatorStart(int start) {
                        int i = start + length;
                        if (i < this.toSplit.length()) {
                            return i;
                        }
                        return -1;
                    }
                };
            }
        });
    }

    public Splitter omitEmptyStrings() {
        return new Splitter(this.strategy, true, this.trimmer, this.limit);
    }

    public Splitter limit(int maxItems) {
        Preconditions.checkArgument(maxItems > 0, "must be greater than zero: %s", maxItems);
        return new Splitter(this.strategy, this.omitEmptyStrings, this.trimmer, maxItems);
    }

    public Splitter trimResults() {
        return trimResults(CharMatcher.whitespace());
    }

    public Splitter trimResults(CharMatcher trimmer) {
        Preconditions.checkNotNull(trimmer);
        return new Splitter(this.strategy, this.omitEmptyStrings, trimmer, this.limit);
    }

    public Iterable<String> split(final CharSequence sequence) {
        Preconditions.checkNotNull(sequence);
        return new Iterable<String>() { // from class: com.google.common.base.Splitter.5
            @Override // java.lang.Iterable
            public Iterator<String> iterator() {
                return Splitter.this.splittingIterator(sequence);
            }

            public String toString() {
                Joiner on = Joiner.on(", ");
                StringBuilder sb = new StringBuilder();
                sb.append('[');
                StringBuilder appendTo = on.appendTo(sb, (Iterable<? extends Object>) this);
                appendTo.append(']');
                return appendTo.toString();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Iterator<String> splittingIterator(CharSequence sequence) {
        return this.strategy.iterator(this, sequence);
    }

    public List<String> splitToList(CharSequence sequence) {
        Preconditions.checkNotNull(sequence);
        Iterator<String> splittingIterator = splittingIterator(sequence);
        ArrayList arrayList = new ArrayList();
        while (splittingIterator.hasNext()) {
            arrayList.add(splittingIterator.next());
        }
        return Collections.unmodifiableList(arrayList);
    }

    public MapSplitter withKeyValueSeparator(String separator) {
        return withKeyValueSeparator(on(separator));
    }

    public MapSplitter withKeyValueSeparator(char separator) {
        return withKeyValueSeparator(on(separator));
    }

    public MapSplitter withKeyValueSeparator(Splitter keyValueSplitter) {
        return new MapSplitter(keyValueSplitter);
    }

    /* loaded from: classes.dex */
    public static final class MapSplitter {
        private static final String INVALID_ENTRY_MESSAGE = "Chunk [%s] is not a valid entry";
        private final Splitter entrySplitter;
        private final Splitter outerSplitter;

        private MapSplitter(Splitter outerSplitter, Splitter entrySplitter) {
            this.outerSplitter = outerSplitter;
            this.entrySplitter = (Splitter) Preconditions.checkNotNull(entrySplitter);
        }

        public Map<String, String> split(CharSequence sequence) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (String str : this.outerSplitter.split(sequence)) {
                Iterator splittingIterator = this.entrySplitter.splittingIterator(str);
                Preconditions.checkArgument(splittingIterator.hasNext(), INVALID_ENTRY_MESSAGE, str);
                String str2 = (String) splittingIterator.next();
                Preconditions.checkArgument(!linkedHashMap.containsKey(str2), "Duplicate key [%s] found.", str2);
                Preconditions.checkArgument(splittingIterator.hasNext(), INVALID_ENTRY_MESSAGE, str);
                linkedHashMap.put(str2, (String) splittingIterator.next());
                Preconditions.checkArgument(!splittingIterator.hasNext(), INVALID_ENTRY_MESSAGE, str);
            }
            return Collections.unmodifiableMap(linkedHashMap);
        }
    }

    /* loaded from: classes.dex */
    private static abstract class SplittingIterator extends AbstractIterator<String> {
        int limit;
        int offset = 0;
        final boolean omitEmptyStrings;
        final CharSequence toSplit;
        final CharMatcher trimmer;

        abstract int separatorEnd(int separatorPosition);

        abstract int separatorStart(int start);

        protected SplittingIterator(Splitter splitter, CharSequence toSplit) {
            this.trimmer = splitter.trimmer;
            this.omitEmptyStrings = splitter.omitEmptyStrings;
            this.limit = splitter.limit;
            this.toSplit = toSplit;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.base.AbstractIterator
        @CheckForNull
        public String computeNext() {
            int separatorStart;
            int i = this.offset;
            while (true) {
                int i2 = this.offset;
                if (i2 != -1) {
                    separatorStart = separatorStart(i2);
                    if (separatorStart == -1) {
                        separatorStart = this.toSplit.length();
                        this.offset = -1;
                    } else {
                        this.offset = separatorEnd(separatorStart);
                    }
                    int i3 = this.offset;
                    if (i3 == i) {
                        int i4 = i3 + 1;
                        this.offset = i4;
                        if (i4 > this.toSplit.length()) {
                            this.offset = -1;
                        }
                    } else {
                        while (i < separatorStart && this.trimmer.matches(this.toSplit.charAt(i))) {
                            i++;
                        }
                        while (separatorStart > i && this.trimmer.matches(this.toSplit.charAt(separatorStart - 1))) {
                            separatorStart--;
                        }
                        if (!this.omitEmptyStrings || i != separatorStart) {
                            break;
                        }
                        i = this.offset;
                    }
                } else {
                    return endOfData();
                }
            }
            int i5 = this.limit;
            if (i5 == 1) {
                separatorStart = this.toSplit.length();
                this.offset = -1;
                while (separatorStart > i && this.trimmer.matches(this.toSplit.charAt(separatorStart - 1))) {
                    separatorStart--;
                }
            } else {
                this.limit = i5 - 1;
            }
            return this.toSplit.subSequence(i, separatorStart).toString();
        }
    }
}
