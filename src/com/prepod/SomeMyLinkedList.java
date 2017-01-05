package com.prepod;

public class SomeMyLinkedList extends MyLinkedList<Object> {

    public boolean add(Object value){
        if (isValidObject(value)) return super.add(value);
        return false;
    }

    public boolean add(Object value, int index){
        if (isValidObject(value)) return super.add(value, index);
        return false;
    }

    public boolean remove(Object value){
        if (isValidObject(value)) return super.remove(value);
        return false;
    }

    public boolean containsValue(Object value){
       if (isValidObject(value)) return super.containsValue(value);
       return false;
    }

    public void print(int index){
        System.out.println(get(index));
    }

    public void printAll(){
        if (size() == 0) return;
        Object[] objects = getAll();
        int s = size();
        for (int i = 0; i < s; i ++){
            System.out.println(objects[i]);
        }
    }

    public boolean clear(){
        return super.clear();
    }

    private boolean isValidObject(Object value) {
        if ((value instanceof Integer) ||
                (value instanceof Float) ||
                (value instanceof String)) {
            return true;
        }
        return false;
    }

}
