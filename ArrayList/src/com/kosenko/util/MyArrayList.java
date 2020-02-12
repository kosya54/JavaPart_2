package com.kosenko.util;

import java.util.*;

public class MyArrayList<E> implements List<E> {
    private static final int DEFAULT_CAPACITY = 10;
    private E[] items;
    private int size;

    public MyArrayList() {
        //noinspection unchecked
        items = (E[]) new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    //TODO: Сделать проверку на максимальное число Int и отрицательное число
    public MyArrayList(int capacity) {
        //noinspection unchecked
        items = (E[]) new Object[capacity];
        size = capacity;
    }

    private void checkIndexesRange(int index) {
        if (index < 0) {
            throw new IndexOutOfBoundsException("Индекс не может быть меньше 0.");
        }

        if (index >= size) {
            throw new IndexOutOfBoundsException("Индекс выходит за границу " + this.getClass().getSimpleName());
        }
    }

    private void expandCapacity(int capacity) {
        E[] temp = items;
        //noinspection unchecked
        items = (E[]) new Object[temp.length + capacity];
        System.arraycopy(temp, 0, items, 0, temp.length);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public E get(int index) {
        checkIndexesRange(index);

        return items[index];
    }

    @Override
    public E set(int index, E element) {
        E oldValue = get(index);
        items[index] = element;

        return oldValue;
    }

    @Override
    public boolean add(E e) {
        if (size == items.length) {
            expandCapacity(DEFAULT_CAPACITY);
        }

        items[size] = e;
        ++size;

        return true;
    }

    @Override
    public void add(int index, E element) {
        if (index == size) {
            add(element);

            return;
        }

        if (size == items.length) {
            expandCapacity(DEFAULT_CAPACITY);
        }

        checkIndexesRange(index);

        if (size - index >= 0) {
            System.arraycopy(items, index, items, index + 1, size - index);
        }

        items[index] = element;
        ++size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        if (o == null) {
            for (E item : items) {
                if (item == null) {
                    return true;
                }
            }
        }

        for (E item : items) {
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

        int freeIndexes = items.length - size;
        if (freeIndexes < cArrayLength) {
            expandCapacity(cArrayLength - freeIndexes);
        }

        System.arraycopy(cArray, 0, items, size, cArrayLength);
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

        if (size == 0 && items.length >= cArrayLength) {
            addAll(c);

            return true;
        }

        if (items.length < (size + cArrayLength)) {
            int needIndexes = (size + cArrayLength) - items.length;
            expandCapacity(needIndexes);
        }

        System.arraycopy(items, index, items, index + cArrayLength, size - index);
        System.arraycopy(cArray, 0, items, index, cArrayLength);

        size += cArrayLength;

        return true;
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(items, size);
    }

    @Override
    public <T> T[] toArray(T[] a) {
        if (a.length < size) {
            throw new IndexOutOfBoundsException("Размер целевого массива меньше размера коллекции.");
        }

        //noinspection SuspiciousSystemArraycopy
        System.arraycopy(items, 0, a, 0, size);

        return a;
    }

    @Override
    public int indexOf(Object o) {
        if (o == null) {
            for (int i = 0; i < size; i++) {
                if (items[i] == null) {
                    return i;
                }
            }
        }

        for (int i = 0; i < size; i++) {
            if (items[i].equals(o)) {
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
                if (items[i] == null) {
                    index = i;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (items[i] != null && items[i].equals(o)) {
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

        if (index == size - 1) {
            --size;

            return true;
        }

        System.arraycopy(items, index + 1, items, index, size - index);
        --size;

        return true;
    }

    @Override
    public E remove(int index) {
        checkIndexesRange(index);

        if (index == size - 1) {
            --size;

            return items[size - 1];
        }

        E removable = items[index];
        System.arraycopy(items, index + 1, items, index, size - index);
        --size;

        return removable;
    }




    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }


    @Override
    public String toString() {
        int count = 0;
        for (E item : items) {
            if (item != null) {
                ++count;
            }
        }

        if (count > 0) {
            try {
                @SuppressWarnings("unchecked")
                E[] arrayItem = (E[]) new Object[count];
                int i = 0;
                for (E item : items) {
                    if (item != null) {
                        arrayItem[i] = item;
                        ++i;
                    }
                }

                return Arrays.toString(arrayItem);
            } catch (ClassCastException ex) {
                ex.printStackTrace();
            }
        }

        //noinspection unchecked
        return Arrays.toString((E[]) new Object[0]);
    }

    public String tempToString() {
        return Arrays.toString(items);
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
