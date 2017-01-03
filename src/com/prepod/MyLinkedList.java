package com.prepod;

public class MyLinkedList {

    private int size;
    private Entry header;

    public MyLinkedList(){
        header = new Entry();
        header.next = header;
        header.previos = header;
    }

    public int size(){
        return size;
    }

    public void add(int value){
        Entry<Integer> newEntry = new Entry<>(value, header, header.previos);
        newEntry.value = value;
        newEntry.previos.next = newEntry;
        newEntry.next.previos = newEntry;
        size++;
    }

    private static class Entry<T>{

        T value;
        Entry<T> next;
        Entry<T> previos;

        Entry(){

        }

        Entry(T value, Entry<T> next, Entry<T> previos){
            this.value = value;
            this.next = next;
            this.previos = previos;
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public Entry<T> getNext() {
            return next;
        }

        public void setNext(Entry<T> next) {
            this.next = next;
        }

        public Entry<T> getPrevios() {
            return previos;
        }

        public void setPrevios(Entry<T> previos) {
            this.previos = previos;
        }
    }

}
