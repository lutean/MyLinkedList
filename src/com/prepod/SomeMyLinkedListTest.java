package com.prepod;

import org.junit.Assert;
import org.junit.Test;

public class SomeMyLinkedListTest {


    @org.junit.Test
    public void testEmptyList() throws Exception {
        SomeMyLinkedList list = new SomeMyLinkedList();
        Assert.assertEquals(0, list.size());
    }

    @org.junit.Test
    public void testContainsValue() {
        SomeMyLinkedList list = new SomeMyLinkedList();
        list.add(1);
        list.add(4);
        list.add(5.0f);
        list.add(44.2f);
        list.add("word");
        list.add(2);
        Assert.assertEquals(true, list.containsValue(1));
        Assert.assertEquals(true, list.containsValue(5.0f));
        Assert.assertEquals(false, list.containsValue(3));
        Assert.assertEquals(false, list.containsValue("w"));
        Assert.assertEquals(true, list.containsValue("word"));
        Assert.assertEquals(true, list.containsValue(2));
        Assert.assertEquals(false, list.containsValue(null));
    }

    @org.junit.Test
    public void testGetValue() throws Exception {
        SomeMyLinkedList list = new SomeMyLinkedList();
        list.add(1);
        list.add(4);
        list.add(5.0f);
        list.add(44.2f);
        list.add("word");
        list.add(2);
        Assert.assertEquals(1, list.get(0));
        Assert.assertEquals(5.0f, list.get(2));
        Assert.assertEquals("word", list.get(4));
    }

    @org.junit.Test(expected = IndexOutOfBoundsException.class)
    public void testException() throws IndexOutOfBoundsException {
        SomeMyLinkedList list = new SomeMyLinkedList();
        list.add(1);
        list.add(4);
        list.get(3);
    }

    @org.junit.Test
    public void testAdd() throws Exception {
        SomeMyLinkedList list = new SomeMyLinkedList();
        Assert.assertEquals(true, list.add(1));
        Assert.assertEquals(true, list.add(4));
        Assert.assertEquals(true, list.add(11.0f));
        Assert.assertEquals(true, list.add(Float.MAX_VALUE));
        Assert.assertEquals(true, list.add(Float.MIN_VALUE));
        Assert.assertEquals(false, list.add(100L));
        Assert.assertEquals(false, list.add(1L));
        Assert.assertEquals(false, list.add('c'));
        Assert.assertEquals(false, list.add('c'));
        Assert.assertEquals(false, list.add(null));
    }

    @org.junit.Test(expected = IndexOutOfBoundsException.class)
    public void testAddAtIndex() throws IndexOutOfBoundsException {
        SomeMyLinkedList list = new SomeMyLinkedList();
        Assert.assertEquals(true, list.add(1,0));
        Assert.assertEquals(true, list.add(4, 1));
        Assert.assertEquals(true, list.add(11.0f));
        Assert.assertEquals(true, list.add(Float.MAX_VALUE));
        Assert.assertEquals(true, list.add(Float.MIN_VALUE));
        Assert.assertEquals(true, list.add(50, 4));
        list.add(50, 100);
    }

    @org.junit.Test
    public void remove() throws Exception {
        SomeMyLinkedList list = new SomeMyLinkedList();
        list.add(1);
        list.add(4);
        list.add(5.0f);
        list.add(44.2f);
        list.add("word");
        list.add(2);
        Assert.assertEquals(true, list.remove("word"));
        Assert.assertEquals(true, list.remove(44.2f));
        Assert.assertEquals(false, list.remove(20));
    }

    @org.junit.Test
    public void clear() throws Exception {
        SomeMyLinkedList list = new SomeMyLinkedList();
        list.add(1);
        list.add(4);
        list.add(5.0f);
        list.add(44.2f);
        list.add("word");
        list.add(2);
        Assert.assertEquals(true, list.clear());
        Assert.assertEquals(0, list.size());
    }

}