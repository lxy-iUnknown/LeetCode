package com.lxy.leetcode.util;

import java.lang.reflect.Array;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class RangeList extends AbstractList<Integer> implements RandomAccess {
    private final int start;
    private final int end;

    public RangeList(int start, int end) {
        if (end < start) {
            throw new IllegalArgumentException("Invalid range");
        }
        this.start = start;
        this.end = end;
    }

    private static void throwUnsupported() {
        throw new UnsupportedOperationException("Read-only list");
    }

    @Override
    public int size() {
        return end - start + 1;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        if (!(o instanceof Integer value)) {
            return false;
        }
        return value >= start && value <= end;
    }

    @Override
    public Object[] toArray() {
        var size = size();
        var array = new Integer[size];
        for (var i = 0; i < size; i++) {
            array[i] = start + i;
        }
        return array;
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> T[] toArray(T[] array) {
        var size = size();
        var length = array.length;
        if (length >= size) {
            // Fill remaining elements
            Arrays.fill(array, size, length, null);
        } else {
            array = (T[]) Array.newInstance(array.getClass().getComponentType(), size);
        }
        for (var i = 0; i < size; i++) {
            array[i] = (T) (Integer) (start + i);
        }
        return array;
    }

    @Override
    public boolean add(Integer integer) {
        throwUnsupported();
        return false;
    }

    @Override
    public boolean remove(Object o) {
        throwUnsupported();
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object e : c) {
            if (!contains(e)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends Integer> c) {
        throwUnsupported();
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends Integer> c) {
        throwUnsupported();
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throwUnsupported();
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throwUnsupported();
        return false;
    }

    @Override
    public void clear() {
        throwUnsupported();
    }

    @Override
    public Integer get(int index) {
        Objects.checkIndex(index, size());
        return start + index;
    }

    @Override
    public Integer set(int index, Integer element) {
        throwUnsupported();
        return 0;
    }

    @Override
    public void add(int index, Integer element) {
        throwUnsupported();
    }

    @Override
    public Integer remove(int index) {
        throwUnsupported();
        return 0;
    }

    @Override
    public int indexOf(Object o) {
        if (!(o instanceof Integer value)) {
            return -1;
        }
        if (value < start || value > end) {
            return -1;
        }
        return value - start;
    }

    @Override
    public int lastIndexOf(Object o) {
        return indexOf(o);
    }

    @Override
    public void replaceAll(UnaryOperator<Integer> operator) {
        throwUnsupported();
    }

    @Override
    public void sort(Comparator<? super Integer> c) {
        throwUnsupported();
    }

    @Override
    public void addFirst(Integer integer) {
        throwUnsupported();
    }

    @Override
    public void addLast(Integer integer) {
        throwUnsupported();
    }

    @Override
    public Integer getFirst() {
        return start;
    }

    @Override
    public Integer getLast() {
        return end;
    }

    @Override
    public Integer removeFirst() {
        throwUnsupported();
        return null;
    }

    @Override
    public Integer removeLast() {
        throwUnsupported();
        return null;
    }

    @Override
    public boolean removeIf(Predicate<? super Integer> filter) {
        throwUnsupported();
        return false;
    }

    @Override
    public void forEach(Consumer<? super Integer> action) {
        for (var i = start; i <= end; i++) {
            action.accept(i);
        }
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(start) * 17 + Integer.hashCode(end);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof List<?> list)) {
            return false;
        }
        var size = size();
        if (size != list.size()) {
            return false;
        }
        for (var i = 0; i < size; i++) {
            if (!get(i).equals(list.get(i))) {
                return false;
            }
        }
        return true;
    }
}
