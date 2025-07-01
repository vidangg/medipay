package com.google.common.collect;

import com.google.common.collect.Table;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
public abstract class ForwardingTable<R, C, V> extends ForwardingObject implements Table<R, C, V> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.collect.ForwardingObject
    public abstract Table<R, C, V> delegate();

    @Override // com.google.common.collect.Table
    public Set<Table.Cell<R, C, V>> cellSet() {
        return delegate().cellSet();
    }

    @Override // com.google.common.collect.Table
    public void clear() {
        delegate().clear();
    }

    @Override // com.google.common.collect.Table
    public Map<R, V> column(@ParametricNullness C columnKey) {
        return delegate().column(columnKey);
    }

    @Override // com.google.common.collect.Table
    public Set<C> columnKeySet() {
        return delegate().columnKeySet();
    }

    @Override // com.google.common.collect.Table
    public Map<C, Map<R, V>> columnMap() {
        return delegate().columnMap();
    }

    @Override // com.google.common.collect.Table
    public boolean contains(@CheckForNull Object rowKey, @CheckForNull Object columnKey) {
        return delegate().contains(rowKey, columnKey);
    }

    @Override // com.google.common.collect.Table
    public boolean containsColumn(@CheckForNull Object columnKey) {
        return delegate().containsColumn(columnKey);
    }

    @Override // com.google.common.collect.Table
    public boolean containsRow(@CheckForNull Object rowKey) {
        return delegate().containsRow(rowKey);
    }

    @Override // com.google.common.collect.Table
    public boolean containsValue(@CheckForNull Object value) {
        return delegate().containsValue(value);
    }

    @Override // com.google.common.collect.Table
    @CheckForNull
    public V get(@CheckForNull Object rowKey, @CheckForNull Object columnKey) {
        return delegate().get(rowKey, columnKey);
    }

    @Override // com.google.common.collect.Table
    public boolean isEmpty() {
        return delegate().isEmpty();
    }

    @Override // com.google.common.collect.Table
    @CheckForNull
    public V put(@ParametricNullness R rowKey, @ParametricNullness C columnKey, @ParametricNullness V value) {
        return delegate().put(rowKey, columnKey, value);
    }

    @Override // com.google.common.collect.Table
    public void putAll(Table<? extends R, ? extends C, ? extends V> table) {
        delegate().putAll(table);
    }

    @Override // com.google.common.collect.Table
    @CheckForNull
    public V remove(@CheckForNull Object rowKey, @CheckForNull Object columnKey) {
        return delegate().remove(rowKey, columnKey);
    }

    @Override // com.google.common.collect.Table
    public Map<C, V> row(@ParametricNullness R rowKey) {
        return delegate().row(rowKey);
    }

    @Override // com.google.common.collect.Table
    public Set<R> rowKeySet() {
        return delegate().rowKeySet();
    }

    @Override // com.google.common.collect.Table
    public Map<R, Map<C, V>> rowMap() {
        return delegate().rowMap();
    }

    @Override // com.google.common.collect.Table
    public int size() {
        return delegate().size();
    }

    @Override // com.google.common.collect.Table
    public Collection<V> values() {
        return delegate().values();
    }

    @Override // com.google.common.collect.Table
    public boolean equals(@CheckForNull Object obj) {
        return obj == this || delegate().equals(obj);
    }

    @Override // com.google.common.collect.Table
    public int hashCode() {
        return delegate().hashCode();
    }
}
