package com.kosenko.util;

import java.lang.reflect.Array;
import java.util.*;

public class MyArrayList<E> implements List<E> {
    private E[] items;
    private int size;

    public MyArrayList() {
        //noinspection unchecked
        items = (E[]) new Object[10];
        size = 0;
    }

    public MyArrayList(int capacity) {
        //noinspection unchecked
        items = (E[]) new Object[capacity];
        size = capacity;
    }

    //Completed
    @Override
    public int size() {
        return size;
    }

    //TODO: Сделать проверку на существование индекса, а так же сейчас возвращает null, если в массиве 1 элемент и стоит не по переданному индексу
    @Override
    public E get(int index) {
        System.out.println("--->" + items[index]);
        return items[index];
    }

    //TODO: Сделать проверку на существование индекса
    @Override
    public E set(int index, E element) {
        E oldValue = get(index);
        items[index] = element;

        return oldValue;
    }

    //TODO: Переделать добавление, сейчас если изначальный массив состоит из null, элементы просто добавляются в конец
    @Override
    public boolean add(E e) {
        try {
            E[] temp = items;
            //noinspection unchecked
            items = (E[]) new Object[temp.length + 1];
            System.arraycopy(temp, 0, items, 0, temp.length);

            items[items.length - 1] = e;
            ++size;

            return true;
        } catch (ClassCastException ex) {
            ex.printStackTrace();
        }

        return false;
    }

    //TODO: Не работает
    @Override
    public void add(int index, E element) {
        try {
            E[] temp = items;
            //noinspection unchecked
            items = (E[]) new Object[temp.length + 1];
            System.arraycopy(temp, 0, items, 0, temp.length);

            for (int i = items.length - 1, j = items.length - 2; i >= index; i--, j--) {
                items[i] = items[j];
            }

            items[index] = element;
            ++size;
        } catch (ClassCastException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }


    @Override
    public boolean contains(Object o) {
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

        return Arrays.toString(new Array[0]);
    }

    public String tempToString() {
        return Arrays.toString(items);
    }
}
