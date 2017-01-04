package com.prepod;

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
        if (value == null) return false;
            Entry<T> newEntry = new Entry<>(value, header, header.previos);
            newEntry.value = value;
            newEntry.previos.next = newEntry;
            newEntry.next.previos = newEntry;
            size++;
            return true;
    }

    protected boolean add(T value, int index){
        if (value == null) return false;
        Entry<T> nextEntry = index == size ? header : findEntry(index);
        Entry<T> newEntry = new Entry<>(value, nextEntry, nextEntry.previos);
        newEntry.value = value;
        newEntry.previos.next = newEntry;
        newEntry.next.previos = newEntry;
        size++;
        return true;
    }

    protected boolean remove(T value){
      if (value == null) return false;
          for(Entry<T> entry = header.next; entry.value != null; entry = entry.next){
              if (value.equals(entry.value)){
                  entry.previos.next = entry.next;
                  entry.next.previos = entry.previos;
                  size--;
                  return true;
              }
          }
        return false;
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
        if (value == null) return false;
        for(Entry<T> entry = header.next; entry.value != null; entry = entry.next) {
            if (value.equals(entry.value)) {
                return true;
            }
        }
        return false;
    }

    public boolean clear(){
        if (size == 0) return false;
        for (Entry<T> temp = header; temp != null; ) {
            Entry<T> next = temp.next;
            temp.value = null;
            temp.next = null;
            temp.previos = null;
            temp = next;
        }
        size = 0;
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
