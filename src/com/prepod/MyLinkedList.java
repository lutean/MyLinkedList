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

    public void add(Integer value){
        Entry<Integer> newEntry = new Entry<>(value, header, header.previos);
        newEntry.value = value;
        newEntry.previos.next = newEntry;
        newEntry.next.previos = newEntry;
        size++;
    }

    public Integer remove(Integer value){
      if (value != null){
          for(Entry<Integer> e = header.next; e.value != null; e = e.next){
              if (value.equals(e.value)){
                  Integer result = e.value;
                  e.previos.next = e.next;
                  e.next.previos = e.previos;
                  size--;
                  return result;
              }
          }
      }
        return null;
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
