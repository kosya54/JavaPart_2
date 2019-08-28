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

    private ListItem<T> getListItem(int index) {
        ListItem<T> nextLink = head;
        for (int i = 0; i < index; i++) {
            nextLink = nextLink.getNext();
        }
        return nextLink;
    }

    public void addFirstItem(T data) {
        head = new ListItem<>(head, data);

        ++count;
    }

    public void addByIndex(int index, T data) {
        if (index < 0 || index > count) {
            throw new IndexOutOfBoundsException("Не верное значение индекса");
        }

        if (index == 0) {
            addFirstItem(data);
        } else {
            ListItem<T> prevLink = getListItem(index - 1);
            ListItem<T> nextLink = prevLink.getNext();

            ListItem<T> newItem = new ListItem<>(nextLink, data);
            prevLink.setNext(newItem);

            ++count;
        }
    }

    public T removeByIndex(int index) {
        if (head == null) {
            throw new IllegalStateException("Список пуст.");
        }

        if (index < 0 || index >= count) {
            throw new IndexOutOfBoundsException("Не верное значение индекса");
        }

        if (index == 0) {
            return removeFirst();
        }

        ListItem<T> prevLink = getListItem(index - 1);
        ListItem<T> nextLink = prevLink.getNext();

        T removableItemData = nextLink.getData();
        prevLink.setNext(nextLink.getNext());

        --count;

        return removableItemData;
    }

    public MyLinkedList<T> copyMyLinkedList() {
        MyLinkedList<T> copyList = new MyLinkedList<>();

        int index = 0;
        ListItem<T> nextLink = head;
        while (nextLink != null) {
            copyList.addByIndex(index, nextLink.getData());
            nextLink = nextLink.getNext();
            ++index;
        }
        return copyList;
    }

    public int size() {
        return count;
    }

    public T getFirstData() {
        if (head == null) {
            throw new IllegalStateException("Список пуст.");
        }

        return head.getData();
    }

    public T getDataByIndex(int index) {
        if (head == null) {
            throw new IllegalStateException("Список пуст.");
        }

        if (index < 0 || index >= count) {
            throw new IndexOutOfBoundsException("Не верное значение индекса");
        }

        if (index == 0) {
            return getFirstData();
        }

        ListItem<T> nextLink = getListItem(index);

        return nextLink.getData();
    }

    public T replaceDataByIndex(int index, T data) {
        if (head == null) {
            throw new IllegalStateException("Список пуст.");
        }

        if (index < 0 || index >= count) {
            throw new IndexOutOfBoundsException("Не верное значение индекса");
        }

        ListItem<T> nextLink = getListItem(index);

        T oldItemData = nextLink.getData();
        nextLink.setData(data);

        return oldItemData;
    }

    public boolean removeByData(T data) {
        if (head == null) {
            throw new IllegalStateException("Список пуст.");
        }

        if (data.equals(head.getData())) {
            removeFirst();

            return true;
        }

        for (ListItem<T> nextLink = head, prevLink = null; nextLink != null; prevLink = nextLink, nextLink = nextLink.getNext()) {
            if (data.equals(nextLink.getData())) {
                if (prevLink != null) {
                    prevLink.setNext(nextLink.getNext());
                }
                nextLink.setNext(null);

                --count;

                return true;
            }
        }
        return false;
    }

    public T removeFirst() {
        if (head == null) {
            throw new IllegalStateException("Список пуст.");
        }

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