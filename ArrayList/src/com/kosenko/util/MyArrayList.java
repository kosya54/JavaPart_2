package com.kosenko.util;

import java.util.*;

public class MyArrayList<E> implements List<E> {
    private static final int DEFAULT_CAPACITY = 10;
    private E[] elementData;
    private int size;

    public MyArrayList() {
        //noinspection unchecked
        elementData = (E[]) new Object[DEFAULT_CAPACITY];
    }

    public MyArrayList(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Не верный размер коллекции.");
        }

        //noinspection unchecked
        elementData = (E[]) new Object[capacity];
    }

    private void checkIndexesRange(int index) {
        if (index < 0) {
            throw new IndexOutOfBoundsException("Индекс не может быть меньше 0.");
        }

        if (index >= size) {
            throw new IndexOutOfBoundsException("Индекс выходит за границу " + size);
        }
    }

    public void ensureCapacity(int capacity) {
        E[] temp = elementData;
        //noinspection unchecked
        elementData = (E[]) new Object[temp.length + capacity];
        System.arraycopy(temp, 0, elementData, 0, temp.length);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public E get(int index) {
        checkIndexesRange(index);

        return elementData[index];
    }

    @Override
    public E set(int index, E element) {
        E oldValue = get(index);
        elementData[index] = element;

        return oldValue;
    }

    @Override
    public boolean add(E e) {
        if (size == elementData.length) {
            ensureCapacity(DEFAULT_CAPACITY);
        }

        elementData[size] = e;
        ++size;

        return true;
    }

    @Override
    public void add(int index, E element) {
        if (index == size) {
            add(element);

            return;
        }

        if (size == elementData.length) {
            ensureCapacity(DEFAULT_CAPACITY);
        }

        checkIndexesRange(index);

        if (size - index >= 0) {
            System.arraycopy(elementData, index, elementData, index + 1, size - index);
        }

        elementData[index] = element;
        ++size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        if (o == null) {
            for (E item : elementData) {
                if (item == null) {
                    return true;
                }
            }
        }

        for (E item : elementData) {
            if (item != null && item.equals(o)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        if (c.size() > size) {
            return false;
        }

        for (Object collectionItem : c) {
            if (!contains(collectionItem)) {
                return false;
            }
        }

        return true;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        //noinspection unchecked
        E[] cArray = (E[]) c.toArray();

        int cArrayLength = cArray.length;
        if (cArrayLength == 0) {
            return false;
        }

        int freeIndexes = elementData.length - size;
        if (freeIndexes < cArrayLength) {
            ensureCapacity(cArrayLength - freeIndexes);
        }

        System.arraycopy(cArray, 0, elementData, size, cArrayLength);
        size += cArrayLength;

        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        //noinspection unchecked
        E[] cArray = (E[]) c.toArray();

        int cArrayLength = cArray.length;
        if (cArrayLength == 0) {
            return false;
        }

        if (index == size) {
            addAll(c);
        }

        checkIndexesRange(index);

        if (size == 0 && elementData.length >= cArrayLength) {
            addAll(c);

            return true;
        }

        if (elementData.length < (size + cArrayLength)) {
            int needIndexes = (size + cArrayLength) - elementData.length;
            ensureCapacity(needIndexes);
        }

        System.arraycopy(elementData, index, elementData, index + cArrayLength, size - index);
        System.arraycopy(cArray, 0, elementData, index, cArrayLength);

        size += cArrayLength;

        return true;
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(elementData, size);
    }

    @Override
    public <T> T[] toArray(T[] a) {
        if (a.length < size) {
            throw new IndexOutOfBoundsException("Размер целевого массива меньше размера коллекции.");
        }

        //noinspection SuspiciousSystemArraycopy
        System.arraycopy(elementData, 0, a, 0, size);

        return a;
    }

    @Override
    public int indexOf(Object o) {
        if (o == null) {
            for (int i = 0; i < size; i++) {
                if (elementData[i] == null) {
                    return i;
                }
            }
        }

        for (int i = 0; i < size; i++) {
            if (elementData[i] == null) {
                continue;
            }

            if (elementData[i].equals(o)) {
                return i;
            }
        }

        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        int index = -1;

        if (o == null) {
            for (int i = 0; i < size; i++) {
                if (elementData[i] == null) {
                    index = i;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (elementData[i] != null && elementData[i].equals(o)) {
                    index = i;
                }
            }
        }

        return index;
    }

    @Override
    public boolean remove(Object o) {
        int index = indexOf(o);
        if (index == -1) {
            return false;
        }

        if (size == elementData.length) {
            ensureCapacity(DEFAULT_CAPACITY);
        }

        System.arraycopy(elementData, index + 1, elementData, index, size - index);
        --size;

        return true;
    }

    @Override
    public E remove(int index) {
        checkIndexesRange(index);

        if (index == size - 1) {
            --size;

            return elementData[size - 1];
        }

        if (size == elementData.length) {
            ensureCapacity(DEFAULT_CAPACITY);
        }

        E removable = elementData[index];
        System.arraycopy(elementData, index + 1, elementData, index, size - index);
        --size;

        return removable;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        boolean isRemove = false;
        for (Object item : c) {
            if (contains(item)) {
                remove(item);
                isRemove = true;
            }
        }
        return isRemove;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            elementData[i] = null;
        }

        size = 0;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        boolean isRemoved = false;
        int i = 0;
        while (i < size) {
            if (!c.contains(elementData[i])) {
                remove(elementData[i]);
                isRemoved = true;

                --i;
            }
            ++i;
        }

        return isRemoved;
    }

    public void trimToSize() {
        //noinspection unchecked
        E[] temp = (E[]) new Object[size];

        System.arraycopy(elementData, 0, temp, 0, size);
        elementData = temp;
    }

    @Override
    public Iterator<E> iterator() {
        return new MyIterator();
    }

    private class MyIterator implements Iterator<E> {
        private int pointer;
        private int currentSize;
        private boolean isAfterHasNext;

        MyIterator() {
            pointer = 0;
            isAfterHasNext = false;
            currentSize = size;
        }

        @Override
        public boolean hasNext() {
            isAfterHasNext = true;

            return pointer < size;
        }

        @Override
        public E next() {
            if (!isAfterHasNext) {
                throw new UnsupportedOperationException("Next");
            }

            if (currentSize > size || currentSize < size) {
                throw new ConcurrentModificationException();
            }

            int i = pointer;
            if (i >= size) {
                throw new NoSuchElementException();
            }

            ++pointer;

            return elementData[i];
        }

        @Override
        public void remove() {
            if (!isAfterHasNext) {
                throw new UnsupportedOperationException("Remove");
            }

            System.arraycopy(elementData, 1, elementData, 0, size);
            --size;
        }
    }

    @Override
    public String toString() {
        trimToSize();

        return Arrays.toString(elementData);
    }

    //По условию задачи реализовывать не нужно.
    @Override
    public ListIterator<E> listIterator() {
        return null;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return null;
    }
}