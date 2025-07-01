package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.Multiset;
import com.google.common.primitives.Ints;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import javax.annotation.CheckForNull;

/* JADX INFO: Access modifiers changed from: package-private */
@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
public abstract class AbstractMapBasedMultiset<E> extends AbstractMultiset<E> implements Serializable {
    private static final long serialVersionUID = 0;
    transient ObjectCountHashMap<E> backingMap;
    transient long size;

    abstract ObjectCountHashMap<E> newBackingMap(int distinctElements);

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbstractMapBasedMultiset(int distinctElements) {
        this.backingMap = newBackingMap(distinctElements);
    }

    @Override // com.google.common.collect.Multiset
    public final int count(@CheckForNull Object element) {
        return this.backingMap.get(element);
    }

    @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    public final int add(@ParametricNullness E element, int occurrences) {
        if (occurrences == 0) {
            return count(element);
        }
        Preconditions.checkArgument(occurrences > 0, "occurrences cannot be negative: %s", occurrences);
        int indexOf = this.backingMap.indexOf(element);
        if (indexOf == -1) {
            this.backingMap.put(element, occurrences);
            this.size += occurrences;
            return 0;
        }
        int value = this.backingMap.getValue(indexOf);
        long j = occurrences;
        long j2 = value + j;
        Preconditions.checkArgument(j2 <= 2147483647L, "too many occurrences: %s", j2);
        this.backingMap.setValue(indexOf, (int) j2);
        this.size += j;
        return value;
    }

    @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    public final int remove(@CheckForNull Object element, int occurrences) {
        if (occurrences == 0) {
            return count(element);
        }
        Preconditions.checkArgument(occurrences > 0, "occurrences cannot be negative: %s", occurrences);
        int indexOf = this.backingMap.indexOf(element);
        if (indexOf == -1) {
            return 0;
        }
        int value = this.backingMap.getValue(indexOf);
        if (value > occurrences) {
            this.backingMap.setValue(indexOf, value - occurrences);
        } else {
            this.backingMap.removeEntry(indexOf);
            occurrences = value;
        }
        this.size -= occurrences;
        return value;
    }

    @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    public final int setCount(@ParametricNullness E element, int count) {
        CollectPreconditions.checkNonnegative(count, "count");
        ObjectCountHashMap<E> objectCountHashMap = this.backingMap;
        int remove = count == 0 ? objectCountHashMap.remove(element) : objectCountHashMap.put(element, count);
        this.size += count - remove;
        return remove;
    }

    @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    public final boolean setCount(@ParametricNullness E element, int oldCount, int newCount) {
        CollectPreconditions.checkNonnegative(oldCount, "oldCount");
        CollectPreconditions.checkNonnegative(newCount, "newCount");
        int indexOf = this.backingMap.indexOf(element);
        if (indexOf == -1) {
            if (oldCount != 0) {
                return false;
            }
            if (newCount > 0) {
                this.backingMap.put(element, newCount);
                this.size += newCount;
            }
            return true;
        }
        if (this.backingMap.getValue(indexOf) != oldCount) {
            return false;
        }
        if (newCount == 0) {
            this.backingMap.removeEntry(indexOf);
            this.size -= oldCount;
        } else {
            this.backingMap.setValue(indexOf, newCount);
            this.size += newCount - oldCount;
        }
        return true;
    }

    @Override // com.google.common.collect.AbstractMultiset, java.util.AbstractCollection, java.util.Collection
    public final void clear() {
        this.backingMap.clear();
        this.size = 0L;
    }

    /* loaded from: classes4.dex */
    abstract class Itr<T> implements Iterator<T> {
        int entryIndex;
        int expectedModCount;
        int toRemove = -1;

        @ParametricNullness
        abstract T result(int entryIndex);

        Itr() {
            this.entryIndex = AbstractMapBasedMultiset.this.backingMap.firstIndex();
            this.expectedModCount = AbstractMapBasedMultiset.this.backingMap.modCount;
        }

        private void checkForConcurrentModification() {
            if (AbstractMapBasedMultiset.this.backingMap.modCount != this.expectedModCount) {
                throw new ConcurrentModificationException();
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            checkForConcurrentModification();
            return this.entryIndex >= 0;
        }

        @Override // java.util.Iterator
        @ParametricNullness
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T result = result(this.entryIndex);
            this.toRemove = this.entryIndex;
            this.entryIndex = AbstractMapBasedMultiset.this.backingMap.nextIndex(this.entryIndex);
            return result;
        }

        @Override // java.util.Iterator
        public void remove() {
            checkForConcurrentModification();
            CollectPreconditions.checkRemove(this.toRemove != -1);
            AbstractMapBasedMultiset.this.size -= AbstractMapBasedMultiset.this.backingMap.removeEntry(this.toRemove);
            this.entryIndex = AbstractMapBasedMultiset.this.backingMap.nextIndexAfterRemove(this.entryIndex, this.toRemove);
            this.toRemove = -1;
            this.expectedModCount = AbstractMapBasedMultiset.this.backingMap.modCount;
        }
    }

    @Override // com.google.common.collect.AbstractMultiset
    final Iterator<E> elementIterator() {
        return new AbstractMapBasedMultiset<E>.Itr<E>() { // from class: com.google.common.collect.AbstractMapBasedMultiset.1
            @Override // com.google.common.collect.AbstractMapBasedMultiset.Itr
            @ParametricNullness
            E result(int entryIndex) {
                return AbstractMapBasedMultiset.this.backingMap.getKey(entryIndex);
            }
        };
    }

    @Override // com.google.common.collect.AbstractMultiset
    final Iterator<Multiset.Entry<E>> entryIterator() {
        return new AbstractMapBasedMultiset<E>.Itr<Multiset.Entry<E>>() { // from class: com.google.common.collect.AbstractMapBasedMultiset.2
            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // com.google.common.collect.AbstractMapBasedMultiset.Itr
            public Multiset.Entry<E> result(int entryIndex) {
                return AbstractMapBasedMultiset.this.backingMap.getEntry(entryIndex);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addTo(Multiset<? super E> multiset) {
        Preconditions.checkNotNull(multiset);
        int firstIndex = this.backingMap.firstIndex();
        while (firstIndex >= 0) {
            multiset.add(this.backingMap.getKey(firstIndex), this.backingMap.getValue(firstIndex));
            firstIndex = this.backingMap.nextIndex(firstIndex);
        }
    }

    @Override // com.google.common.collect.AbstractMultiset
    final int distinctElements() {
        return this.backingMap.size();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, com.google.common.collect.Multiset
    public final Iterator<E> iterator() {
        return Multisets.iteratorImpl(this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
    public final int size() {
        return Ints.saturatedCast(this.size);
    }

    private void writeObject(ObjectOutputStream stream) throws IOException {
        stream.defaultWriteObject();
        Serialization.writeMultiset(this, stream);
    }

    private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        stream.defaultReadObject();
        int readCount = Serialization.readCount(stream);
        this.backingMap = newBackingMap(3);
        Serialization.populateMultiset(this, stream, readCount);
    }
}
