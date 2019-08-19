package com.MyLinkedList;

public class MyLinkedList<T> {
    private ListItem<T> head;
    private int count;

    public MyLinkedList() {
    }

    //Получение размера списка +
    public int size() {
        return count;
    }

    //Получение значения первого элемента +
    public T getFirstItemData() {
        return head.getData();
    }

    //Получение значения по указанному индексу +
    public T getByIndex(int index) {
        if (index <= 0 || index > count) {
            throw new IndexOutOfBoundsException("Не верное значение индекса.");
        }

        ListItem<T> receivedItem= head;
        for (int i = 1; i < index; i++) {
            receivedItem = receivedItem.getNext();
        }
        return receivedItem.getData();
    }

    //Изменение значения по индексу пусть выдает старое значение +
    public T replaceByIndex(int index, T data) {
        if (index <= 0 || index > count) {
            throw new IndexOutOfBoundsException("Не верное значение индекса.");
        }

        ListItem<T> replaceableItem = head;
        for (int i = 1; i < index; i++) {
            replaceableItem = replaceableItem.getNext();
        }

        T oldItemData = replaceableItem.getData();
        replaceableItem.setData(data);

        return oldItemData;
    }

    //Удаление элемента по индексу, пусть выдает значение элемента

    //Вставка элемента в начало +
    public void addFirst(T data) {
        head = new ListItem<>(data, head);
        ++count;
    }

    //Вставка элемента по индексу +
    public void addByIndex(int index, T data) {
        if (index <= 0 || index > count) {
            throw new IndexOutOfBoundsException("Не верное значение индекса.");
        }

        if (index == 1) {
            addFirst(data);
        } else {
            ListItem<T> link = head;
            ListItem<T> prev = null;

            for (int i = 1; i < index; i++) {
                prev = link;
                link = link.getNext();
            }

            ListItem<T> newItem = new ListItem<>(data, link);
            prev.setNext(newItem);
            ++count;
        }
    }

    //удаление узла по значению, пусть выдает true, если элемент был удален

    //Удаление первого элемента, пусть выдет значение элемента
    public T removeFirst() {
        T removedItemData = head.getData();
        head = head.getNext();
        --count;

        return removedItemData;
    }

    //Разворот списка за линейное время

    //Копирование списка

/*    public void printLinks() {
        ListItem<T> p = head;

        System.out.println("Head: " + p);
        while (p != null) {
            System.out.println("Elem: " + p.getNext());
            p = p.getNext();
        }
    } */

    public void printList() {
        ListItem<T> item = head;

        System.out.print("[ ");
        int count = 1;
        while (item != null) {
            if (count == size()) {
                System.out.print(item.getData());
            } else {
                System.out.print(item.getData() + ", ");
            }
            item = item.getNext();
            ++count;
        }
        System.out.println(" ]");
    }
}