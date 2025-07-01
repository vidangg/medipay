package com.google.common.collect;

import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.NoSuchElementException;
import java.util.SortedSet;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
final class SortedMultisets {
    private SortedMultisets() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static class ElementSet<E> extends Multisets.ElementSet<E> implements SortedSet<E> {
        private final SortedMultiset<E> multiset;

        ElementSet(SortedMultiset<E> multiset) {
            this.multiset = multiset;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.Multisets.ElementSet
        public final SortedMultiset<E> multiset() {
            return this.multiset;
        }

        @Override // com.google.common.collect.Multisets.ElementSet, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<E> iterator() {
            return Multisets.elementIterator(multiset().entrySet().iterator());
        }

        @Override // java.util.SortedSet
        public Comparator<? super E> comparator() {
            return multiset().comparator();
        }

        @Override // java.util.SortedSet
        public SortedSet<E> subSet(@ParametricNullness E fromElement, @ParametricNullness E toElement) {
            return multiset().subMultiset(fromElement, BoundType.CLOSED, toElement, BoundType.OPEN).elementSet();
        }

        @Override // java.util.SortedSet
        public SortedSet<E> headSet(@ParametricNullness E toElement) {
            return multiset().headMultiset(toElement, BoundType.OPEN).elementSet();
        }

        @Override // java.util.SortedSet
        public SortedSet<E> tailSet(@ParametricNullness E fromElement) {
            return multiset().tailMultiset(fromElement, BoundType.CLOSED).elementSet();
        }

        @Override // java.util.SortedSet
        @ParametricNullness
        public E first() {
            return (E) SortedMultisets.getElementOrThrow(multiset().firstEntry());
        }

        @Override // java.util.SortedSet
        @ParametricNullness
        public E last() {
            return (E) SortedMultisets.getElementOrThrow(multiset().lastEntry());
        }
    }

    /* loaded from: classes4.dex */
    static class NavigableElementSet<E> extends ElementSet<E> implements NavigableSet<E> {
        /* JADX INFO: Access modifiers changed from: package-private */
        public NavigableElementSet(SortedMultiset<E> multiset) {
            super(multiset);
        }

        @Override // java.util.NavigableSet
        @CheckForNull
        public E lower(@ParametricNullness E e) {
            return (E) SortedMultisets.getElementOrNull(multiset().headMultiset(e, BoundType.OPEN).lastEntry());
        }

        @Override // java.util.NavigableSet
        @CheckForNull
        public E floor(@ParametricNullness E e) {
            return (E) SortedMultisets.getElementOrNull(multiset().headMultiset(e, BoundType.CLOSED).lastEntry());
        }

        @Override // java.util.NavigableSet
        @CheckForNull
        public E ceiling(@ParametricNullness E e) {
            return (E) SortedMultisets.getElementOrNull(multiset().tailMultiset(e, BoundType.CLOSED).firstEntry());
        }

        @Override // java.util.NavigableSet
        @CheckForNull
        public E higher(@ParametricNullness E e) {
            return (E) SortedMultisets.getElementOrNull(multiset().tailMultiset(e, BoundType.OPEN).firstEntry());
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> descendingSet() {
            return new NavigableElementSet(multiset().descendingMultiset());
        }

        @Override // java.util.NavigableSet
        public Iterator<E> descendingIterator() {
            return descendingSet().iterator();
        }

        @Override // java.util.NavigableSet
        @CheckForNull
        public E pollFirst() {
            return (E) SortedMultisets.getElementOrNull(multiset().pollFirstEntry());
        }

        @Override // java.util.NavigableSet
        @CheckForNull
        public E pollLast() {
            return (E) SortedMultisets.getElementOrNull(multiset().pollLastEntry());
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> subSet(@ParametricNullness E fromElement, boolean fromInclusive, @ParametricNullness E toElement, boolean toInclusive) {
            return new NavigableElementSet(multiset().subMultiset(fromElement, BoundType.forBoolean(fromInclusive), toElement, BoundType.forBoolean(toInclusive)));
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> headSet(@ParametricNullness E toElement, boolean inclusive) {
            return new NavigableElementSet(multiset().headMultiset(toElement, BoundType.forBoolean(inclusive)));
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> tailSet(@ParametricNullness E fromElement, boolean inclusive) {
            return new NavigableElementSet(multiset().tailMultiset(fromElement, BoundType.forBoolean(inclusive)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <E> E getElementOrThrow(@CheckForNull Multiset.Entry<E> entry) {
        if (entry == null) {
            throw new NoSuchElementException();
        }
        return entry.getElement();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @CheckForNull
    public static <E> E getElementOrNull(@CheckForNull Multiset.Entry<E> entry) {
        if (entry == null) {
            return null;
        }
        return entry.getElement();
    }
}
