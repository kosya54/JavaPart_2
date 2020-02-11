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

    private void expandCapacity() {
        E[] temp = items;
        //noinspection unchecked
        items = (E[]) new Object[temp.length + DEFAULT_CAPACITY];

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

    //TODO: Как быть если записано несколько null подряд?
    @Override
    public boolean add(E e) {
        boolean isAdded = false;

        if (size >= 0) {
            if (size == items.length) {
                expandCapacity();
            }

            for (int i = 0; i < items.length; i++) {
                if (items[i] == null) {
                    items[i] = e;
                    ++size;

                    isAdded = true;
                    break;
                }
            }
        }
        return isAdded;
    }

    @Override
    public void add(int index, E element) {
        if (index == size) {
            add(element);

            return;
        }

        checkIndexesRange(index);

        if (size == items.length) {
            expandCapacity();
        }

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
        for (E item : items) {
            if (item.equals(o)) {
                return true;
            }
        }

        return false;
    }


    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }


    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public E remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

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
}
