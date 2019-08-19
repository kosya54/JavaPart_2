package com.MyLinkedList;

class ListItem<T> {
    private T data;
    private ListItem<T> next;

/*    public ListItem() {

    }

    public ListItem(T data) {
        this.data = data;
    } */

    ListItem(T data, ListItem<T> next) {
        this.data = data;
        this.next = next;
    }

    T getData() {
        return data;
    }

    ListItem<T> getNext() {
        return next;
    }

    void setData(T data) {
        this.data = data;
    }

    void setNext(ListItem<T> next) {
        this.next = next;
    }
}