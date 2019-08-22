package com;

import com.MyLinkedList.*;

public class Main {
    public static void main(String[] args) {
        MyLinkedList<Integer> list1 = new MyLinkedList<>();
        
        int listLength = 10;
        for (int i = 0, j = 1; i < listLength; i++, j *= 3) {
            list1.addFirstItem(j);
        }
        
        list1.addItemByIndex();
        list1.size();
        list1.getFirstItemData();
        list1.getItemDataByIndex();
        list1.replaceItemDataByIndex();
        list1.removeItemByIndex();
        list1.removeItemByData();
        list1.removeFirstItem();
        list1.reverseMyLinkedList();
        list1.printList();
        
        MyLinkedList<Integer> list2 = list1.copyMyLinkedList();
        
                

    }
}
