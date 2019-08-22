package com.MyLinkedList;

public class MyLinkedList<T> {
    private ListItem<T> head;
    private int count;

    public MyLinkedList() {}
    
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
                nextLink = nextLink.next;
            }

            ListItem<T> newItem = new ListItem<>(nextLink, data);
            prevLink.setNext(newItem);

            ++count;
        }
    }
    
    //Копирование списка
    public MyLinkedList<T> copyMyLinkedList() {
        MyLinkedList<T> copyList = new MyLinkedList<>();
        
        for (ListItem<T> nextLink = head, prevLink = null; nextLink != null; prevLink = nextLink, nextLink = nextLink.next) {
            copyList.addFirstItem(nextLink.data);
        }
        
        copyList.reverseMyLinkedList();
        return copyList;
    }

    //Получение размера списка
    public int size() {
        return count;
    }

    //Получение значение первого элемента
    public T getFirstItemData() {
        return head.data;
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
            nextLink = nextLink.next;
        }
        return nextLink.data;
    }

    //Изменение значения по указанному индексу пусть выдает старое значение
    public T replaceItemDataByIndex(int index, T data) {
        if (index < 0 || index >= count) {
            throw new IllegalArgumentException("Не верное значение индекса");
        }

        ListItem<T> nextLink = head;
        for (int i = 0; i < index; i++) {
            nextLink = nextLink.next;
        }

        T oldItemData = nextLink.data;
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
            nextLink = nextLink.next;
        }

        T removableItemData = nextLink.data;
        prevLink.setNext(nextLink.next);

        --count;
        return removableItemData;
    }

    //Удаление узла по значению, пусть выдает true, если элемент был удален
    public boolean removeItemByData(T data) {
        for (ListItem<T> nextLink = head, prevLink = null; nextLink != null; prevLink = nextLink, nextLink = nextLink.next) {
            if (data == head.data) {
                removeFirstItem();
                return true;
            }

            if (nextLink.data == data) {
                prevLink.setNext(nextLink.next);
                nextLink.setNext(null);

                --count;
                return true;
            }
        }
        return false;
    }

    //Удаление первого элемента, пусть выдает значение элемента
    public T removeFirstItem() {
        T removableItemData = head.data;

        head = head.next;

        --count;

        return removableItemData;
    }

    //Разворот списка за линейное время
    public void reverseMyLinkedList() {
        ListItem<T> currentLink = head;
        ListItem<T> prevLink = null;
        ListItem<T> nextLink = null;
        
        while (currentLink != null) {
            nextLink = currentLink.next;
            currentLink.next = prevLink;
            prevLink = currentLink;
            currentLink = nextLink;
        }
        head = prevLink;
    }

    //Печать списка
    public void printList() {
        ListItem<T> nextLink = head;

        while (nextLink != null) {
            System.out.println("Адрес: " + nextLink.next + " Значение: " + nextLink.data + " Count: " + size());
            nextLink = nextLink.next;
        }
    }
}
