package com.MyLinkedList;

public class MyLinkedList<T> {
    private ListItem<T> head;
    private int count;

    public MyLinkedList() {
    }

    //Получение размера списка
    public int size() {
        return count;
    }

    //Получение значение первого элемента
    public T getFirstItemData() {
        return head.getData();
    }

    //Получение значения по указанному индексу
    public T getItemDataByIndex(int index) {
        if (index < 0 || index >= count) {
            throw new IllegalArgumentException("Не верное значение индекса");
        }

        if (index == 0) {
            return getFirstItemData();
        }

        ListItem<T> nextLink = head;
        for (int i = 0; i < index; i++) {
            nextLink = nextLink.getNext();
        }
        return nextLink.getData();
    }

    //Изменение значения по указанному индексу пусть выдает старое значение
    public T replaceItemDataByIndex(int index, T data) {
        if (index < 0 || index >= count) {
            throw new IllegalArgumentException("Не верное значение индекса");
        }

        ListItem<T> nextLink = head;
        for (int i = 0; i < index; i++) {
            nextLink = nextLink.getNext();
        }

        T oldItemData = nextLink.getData();
        nextLink.setData(data);
        return oldItemData;
    }

    //Удаление элемента по индексу, пусть выдает значение элемента
    public T removeItemByIndex(int index) {
        if (index < 0 || index >= count) {
            throw new IllegalArgumentException("Не верное значение индекса");
        }

        if (index == 0) {
            return removeFirstItem();
        }

        ListItem<T> nextLink = head;
        ListItem<T> prevLink = null;
        for (int i = 0; i < index; i++) {
            prevLink = nextLink;
            nextLink = nextLink.getNext();
        }

        T removableItemData = nextLink.getData();
        prevLink.setNext(nextLink.getNext());

        --count;
        return removableItemData;
    }

    //Вставка элемента в начало
    public void addFirstItem(T data) {
        head = new ListItem<>(head, data);

        ++count;
    }

    //Вставка элемента по индексу
    public void addItemByIndex(int index, T data) {
        if (index < 0 || index >= count) {
            throw new IllegalArgumentException("Не верное значение индекса");
        }

        if (index == 0) {
            addFirstItem(data);
        } else {
            ListItem<T> nextLink = head;
            ListItem<T> prevLink = null;

            for (int i = 0; i < index; i++) {
                prevLink = nextLink;
                nextLink = nextLink.getNext();
            }

            ListItem<T> newItem = new ListItem<>(nextLink, data);
            prevLink.setNext(newItem);

            ++count;
        }
    }

    //Удаление узла по значению, пусть выдает true, если элемент был удален
    public boolean removeItemByData(T data) {
        for (ListItem<T> nextLink = head, prevLink = null; nextLink != null; prevLink = nextLink, nextLink = nextLink.getNext()) {
            if (data == head.getData()) {
                removeFirstItem();
                return true;
            }

            if (nextLink.getData() == data) {
                prevLink.setNext(nextLink.getNext());
                nextLink.setNext(null);

                --count;
                return true;
            }
        }
        return false;
    }

    //Удаление первого элемента, пусть выдает значение элемента
    public T removeFirstItem() {
        T removableItemData = head.getData();

        head = head.getNext();

        --count;

        return removableItemData;
    }

    //Разворот списка за линейное время

    //копирование списка

    //Временно
    public void printList() {
        ListItem<T> nextLink = head;

        while (nextLink != null) {
            System.out.println("Адрес: " + nextLink.getNext() + " Значение: " + nextLink.getData() + " Count: " + size());
            nextLink = nextLink.getNext();
        }
    }

    public void printLinks() {
        ListItem<T> p = head;
        System.out.println("Head: " + p);
        while (p != null) {
            System.out.println("Elem: " + p.getNext());
            p = p.getNext();
        }
    }

    private class ListItem<T> {
        private ListItem<T> next;
        private T data;

        ListItem(ListItem<T> next, T data) {
            this.next = next;
            this.data = data;
        }

        private ListItem<T> getNext() {
            return next;
        }

        private void setNext(ListItem<T> next) {
            this.next = next;
        }

        private T getData() {
            return data;
        }

        private void setData(T data) {
            this.data = data;
        }
    }
}
