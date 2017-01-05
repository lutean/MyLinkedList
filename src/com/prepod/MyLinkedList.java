package com.prepod;

import com.sun.istack.internal.Nullable;

public class MyLinkedList<T> {

    private int size;
    private Entry<T> header;

    protected MyLinkedList(){
        header = new Entry<>();
        header.next = header;
        header.previos = header;
    }

    public int size(){
        return size;
    }

    protected boolean add(T value){
        return addEntry(value, header);
    }

    protected boolean add(T value, int index){
        return addEntry(value, index == size ? header : findEntry(index));
    }

    protected boolean remove(T value){
          Entry<T> entry = findEntry(value);
          if (entry != null) {
              entry.previos.next = entry.next;
              entry.next.previos = entry.previos;
              size--;
              return true;
          }
        return false;
    }

    @Nullable
    private Entry<T> findEntry(T value){
        if (value == null) return null;
        for(Entry<T> entry = header.next; entry.value != null; entry = entry.next) {
            if (value.equals(entry.value)) {
                return entry;
            }
        }
            return null;
    }

    protected T get(int index){
        return findEntry(index).value;
    }

    protected Object[] getAll(){
        if (size == 0) return null;
        Object[] all = new Object[size];
        int i = 0;
        for(Entry<T> entry = header.next; entry.value != null; entry = entry.next) {
            all[i] = entry.value;
            i++;
        }
        return all;
    }

    protected boolean containsValue(T value){
       if (findEntry(value) != null) {
           return true;
       }
       return false;
    }

    public boolean clear(){
        if (size == 0) return false;
        header.next = header;
        header.previos = header;
        size = 0;
        return true;
    }

    private boolean addEntry(T value, Entry<T> nextEntry){
        if (value == null) return false;
        Entry<T> newEntry = new Entry<>(value, nextEntry, nextEntry.previos);
        newEntry.value = value;
        newEntry.previos.next = newEntry;
        newEntry.next.previos = newEntry;
        size++;
        return true;
    }

    private Entry<T> findEntry(int index){
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        Entry<T> entry = header;
        if (index < (size >> 1)){
            for (int i = 0; i <= index; i++){
                entry = entry.next;
            }
        } else {
            for (int i = size; i > index; i--){
                entry = entry.previos;
            }
        }
        return entry;
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
    }

}
