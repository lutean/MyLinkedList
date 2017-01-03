package com.prepod;

import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        list.add(0);
        list.add(1);
        list.add(10);
        list.add(7);

        list.remove(10);
        list.remove(7);
        list.remove(10);

    }
}
