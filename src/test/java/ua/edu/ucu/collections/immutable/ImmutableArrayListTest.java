package ua.edu.ucu.collections.immutable;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class ImmutableArrayListTest {
    ImmutableList empty;
    ImmutableList notEmpty;
    Object notEmptyElem;

    
    @Before
    public void initArrays() {
        empty = new ImmutableArrayList();
        notEmptyElem = 3;
        notEmpty = (new ImmutableArrayList()).add(notEmptyElem);

    }

    @Test
    public void testInitEmpty(){
        assertEquals(empty.size(), 0);
    }

    @Test
    public void testInitNotEmpty(){
        assertEquals(notEmpty.size(), 1);
        assertEquals(notEmpty.get(0), notEmptyElem);
    }

    @Test
    public void testAddToEmpty(){
        Object elem = 2;
        ImmutableList newList = empty.add(elem);
        assertEquals(empty.size(), 0);
        assertEquals(newList.size(), 1);
        assertEquals(newList.get(newList.size() - 1), elem);
    }

    @Test
    public void testAddToNotEmpty(){
        Object elem = 2;
        ImmutableList newList = notEmpty.add(elem);
        assertEquals(notEmpty.size(), 1);
        assertEquals(newList.size(), 2 );
        assertEquals(newList.get(newList.size() - 1), elem);
    }

    @Test
    public void testAddAtIndex(){
        Object elem = 2;
        ImmutableList newList = notEmpty.add(0, elem);
        assertEquals(notEmpty.size(), 1);
        assertEquals(newList.size(), 2 );
        assertEquals(newList.get(newList.size() - 1), notEmptyElem);
        assertEquals(newList.get(0), elem);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testInvalidIndexAdd(){
        Object elem = 2;
        notEmpty.add( 10, elem);
    }

    @Test
    public void testAddAllToEmpty(){
        Object[] elems = new Object[] {2, 4};
        ImmutableList newList = empty.addAll(elems);
        assertEquals(empty.size(), 0);
        assertEquals(newList.size(), elems.length);
        for (int i = 0; i < elems.length; i++){
            assertEquals(newList.get(i), elems[i]);
        }

    }

    @Test
    public void testAddAllToNotEmpty(){
        Object[] elems = new Object[] {2, 4};
        ImmutableList newList = notEmpty.addAll(elems);
        assertEquals(notEmpty.size(), 1);
        assertEquals(newList.size(), elems.length + 1);
        assertEquals(newList.get(0), notEmptyElem);
        for (int i = 0; i < elems.length; i++){
            assertEquals(newList.get(i + 1), elems[i]);
        }

    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testInvalidIndexAddAll(){
        Object[] elems = new Object[] {2, 4};
        notEmpty.addAll(10, elems);
    }

    @Test
    public void testAddAllAtIndex(){
        Object[] elems = new Object[] {2, 4};
        ImmutableList newList = notEmpty.addAll(0, elems);
        assertEquals(notEmpty.size(), 1);
        assertEquals(newList.size(), elems.length + 1);
        assertEquals(newList.get(newList.size() - 1), notEmptyElem);
        for (int i = 0; i < elems.length; i++){
            assertEquals(newList.get(i), elems[i]);
        }

    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testInvalidGet(){
        notEmpty.get(10);
    }

    @Test
    public void testGet(){
        assertEquals(notEmpty.get(0), notEmptyElem);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testInvalidRemove(){
        notEmpty.remove(10);
    }

    @Test
    public void testRemove(){
        ImmutableList newList = notEmpty.remove(0);
        assertEquals(notEmpty.size(), 1);
        assertEquals(newList.size(), 0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testInvalidSet(){
        notEmpty.set(10, 3);
    }

    @Test
    public void testSet(){
        Object elem = 4;
        ImmutableList newList = notEmpty.set(0, elem);
        assertEquals(newList.get(0), elem);
        assertEquals(notEmpty.get(0), notEmptyElem);
    }

    @Test
    public void testIndexOfNotFound(){
        assertEquals(empty.indexOf(3), -1);
    }

    @Test
    public void testIndexOf(){
        assertEquals(notEmpty.indexOf(notEmptyElem), 0);
    }

    @Test
    public void testSize(){
        Object[] elems = new Object[] {2, 4};
        ImmutableList newList = empty.addAll(elems);
        assertEquals(newList.size(), elems.length);
        assertEquals(newList.add(2).size(), elems.length + 1);
    }

    @Test
    public void testClear(){
        ImmutableList newList = notEmpty.clear();
        assertEquals(newList.size(), 0);
        assertEquals(notEmpty.size(), 1);
    }

    @Test
    public void testIsEmptyOnEmpty(){
        assertEquals(empty.isEmpty(), true);
    }

    @Test
    public void testIsEmptyOnNotEmpty(){
        assertEquals(notEmpty.isEmpty(), false);
    }

    @Test
    public void testToArrayEmpty(){
        assertArrayEquals(empty.toArray(), new Object[] {});
    }


    @Test
    public void testToArrayNotEmpty(){
        assertArrayEquals(notEmpty.toArray(), new Object[] {notEmptyElem});
    }

    @Test
    public void testToStringEmpty(){
        assertEquals(empty.toString(), "[]");
    }

    @Test
    public void testToStringNotEmpty(){
        assertEquals(notEmpty.toString(), Arrays.toString(new Object[]{notEmptyElem}));
    }














}
