package com.MyLinkedList;

public class MyLinkedList<T> {
    private ListItem<T> head;
    private int count;

    public MyLinkedList() {
    }

    private static class ListItem<T> {
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

    public void addFirstItem(T data) {
        head = new ListItem<>(head, data);

        ++count;
    }

    public void addByIndex(int index, T data) {
        if (index < 0 || index >= count) {
            throw new IndexOutOfBoundsException("Не верное значение индекса");
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

    public MyLinkedList<T> copyMyLinkedList() {
        MyLinkedList<T> copyList = new MyLinkedList<>();

        for (ListItem<T> nextLink = head; nextLink != null; nextLink = nextLink.getNext()) {
            copyList.addFirstItem(nextLink.getData());
        }

        copyList.reverseMyLinkedList();
        
        return copyList;
    }

    public int size() {
        return count;
    }

    public T getFirstData() {
        return head.getData();
    }

    public T getDataByIndex(int index) {
        if (index < 0 || index >= count) {
            throw new IndexOutOfBoundsException("Не верное значение индекса");
        }

        if (index == 0) {
            return getFirstData();
        }

        ListItem<T> nextLink = head;
        for (int i = 0; i < index; i++) {
            nextLink = nextLink.getNext();
        }
        return nextLink.getData();
    }

    public T replaceDataByIndex(int index, T data) {
        if (index < 0 || index >= count) {
            throw new IndexOutOfBoundsException("Не верное значение индекса");
        }

        ListItem<T> nextLink = head;
        for (int i = 0; i < index; i++) {
            nextLink = nextLink.getNext();
        }

        T oldItemData = nextLink.getData();
        nextLink.setData(data);

        return oldItemData;
    }

    public T removeByIndex(int index) {
        if (index < 0 || index >= count) {
            throw new IndexOutOfBoundsException("Не верное значение индекса");
        }

        if (index == 0) {
            return removeFirst();
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

    public boolean removeByData(T data) {
        for (ListItem<T> nextLink = head, prevLink = null; nextLink != null; prevLink = nextLink, nextLink = nextLink.getNext()) {
            if (data.equals(head.getData())) {
                removeFirst();
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

    public T removeFirst() {
        T removableItemData = head.getData();

        head = head.getNext();

        --count;

        return removableItemData;
    }

    public void reverseMyLinkedList() {
        ListItem<T> currentLink = head;
        ListItem<T> prevLink = null;
        ListItem<T> nextLink;

        while (currentLink != null) {
            nextLink = currentLink.getNext();
            currentLink.next = prevLink;
            prevLink = currentLink;
            currentLink = nextLink;
        }
        head = prevLink;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        ListItem<T> nextLink = head;

        stringBuilder.append("[ ");
        int i = 0;
        while (nextLink != null) {
            if (i == size() - 1) {
                stringBuilder.append(nextLink.getData());
            } else {
                stringBuilder.append(nextLink.getData()).append(", ");
            }
            nextLink = nextLink.getNext();
            ++i;
        }
        stringBuilder.append(" ]");

        return stringBuilder.toString();
    }
}
