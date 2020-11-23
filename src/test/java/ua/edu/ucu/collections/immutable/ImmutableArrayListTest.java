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
        assertEquals(0, empty.size());
    }

    @Test
    public void testInitNotEmpty(){
        assertEquals(1, notEmpty.size());
        assertEquals(notEmptyElem, notEmpty.get(0));
    }

    @Test
    public void testAddToEmpty(){
        Object elem = 2;
        ImmutableList newList = empty.add(elem);
        assertEquals(0, empty.size());
        assertEquals(1, newList.size());
        assertEquals(elem, newList.get(newList.size() - 1));
    }

    @Test
    public void testAddToNotEmpty(){
        Object elem = 2;
        ImmutableList newList = notEmpty.add(elem);
        assertEquals(1, notEmpty.size());
        assertEquals(2, newList.size());
        assertEquals(elem, newList.get(newList.size() - 1));
    }

    @Test
    public void testAddAtIndex(){
        Object elem = 2;
        ImmutableList newList = notEmpty.add(0, elem);
        assertEquals(1, notEmpty.size());
        assertEquals(2, newList.size());
        assertEquals(notEmptyElem, newList.get(newList.size() - 1));
        assertEquals(elem, newList.get(0));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testInvalidIndexAddPositive(){
        Object elem = 2;
        notEmpty.add( 10, elem);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testInvalidIndexAddNegative(){
        Object elem = 2;
        notEmpty.add( -1, elem);
    }

    @Test
    public void testAddAllToEmpty(){
        Object[] elems = new Object[] {2, 4};
        ImmutableList newList = empty.addAll(elems);
        assertEquals(0, empty.size());
        assertEquals(elems.length, newList.size());
        for (int i = 0; i < elems.length; i++){
            assertEquals(elems[i], newList.get(i));
        }

    }

    @Test
    public void testAddAllToNotEmpty(){
        Object[] elems = new Object[] {2, 4};
        ImmutableList newList = notEmpty.addAll(elems);
        assertEquals(1, notEmpty.size());
        assertEquals(elems.length + 1, newList.size());
        assertEquals(notEmptyElem, newList.get(0));
        for (int i = 0; i < elems.length; i++){
            assertEquals(elems[i], newList.get(i + 1));
        }
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testInvalidIndexAddAllPositive(){
        Object[] elems = new Object[] {2, 4};
        notEmpty.addAll(10, elems);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testInvalidIndexAddAllNegative(){
        Object[] elems = new Object[] {2, 4};
        notEmpty.addAll(-1, elems);
    }

    @Test
    public void testAddAllAtIndex(){
        Object[] elems = new Object[] {2, 4};
        ImmutableList newList = notEmpty.addAll(0, elems);
        assertEquals(1, notEmpty.size());
        assertEquals(elems.length + 1, newList.size());
        assertEquals(newList.get(newList.size() - 1), notEmptyElem);
        for (int i = 0; i < elems.length; i++){
            assertEquals(elems[i], newList.get(i));
        }

    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testInvalidGetPositive(){
        notEmpty.get(10);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testInvalidGetNegative(){
        notEmpty.get(-1);
    }

    @Test
    public void testGet(){
        assertEquals(notEmpty.get(0), notEmptyElem);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testInvalidRemovePositive(){
        notEmpty.remove(10);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testInvalidRemoveNegative(){
        notEmpty.remove(-1);
    }

    @Test
    public void testRemove(){
        ImmutableList newList = notEmpty.remove(0);
        assertEquals(1, notEmpty.size());
        assertEquals(0, newList.size());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testInvalidSetPositive(){
        notEmpty.set(10, 3);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testInvalidSetNegative(){
        notEmpty.set(-1, 3);
    }

    @Test
    public void testSet(){
        Object elem = 4;
        ImmutableList newList = notEmpty.set(0, elem);
        assertEquals(elem, newList.get(0));
        assertEquals(notEmptyElem, notEmpty.get(0));
    }

    @Test
    public void testIndexOfNotFound(){
        assertEquals(-1, empty.indexOf(3));
    }

    @Test
    public void testIndexOf(){
        assertEquals(1, notEmpty.add(100).indexOf(100));
    }

    @Test
    public void testSize(){
        Object[] elems = new Object[] {2, 4};
        ImmutableList newList = empty.addAll(elems);
        assertEquals(elems.length, newList.size());
        assertEquals(elems.length + 1, newList.add(2).size());
    }

    @Test
    public void testClear(){
        ImmutableList newList = notEmpty.clear();
        assertEquals(0, newList.size());
        assertEquals(1, notEmpty.size());
    }

    @Test
    public void testIsEmptyOnEmpty(){
        assertEquals(true, empty.isEmpty());
    }

    @Test
    public void testIsEmptyOnNotEmpty(){
        assertEquals(false, notEmpty.isEmpty());
    }

    @Test
    public void testToArrayEmpty(){
        assertArrayEquals(new Object[] {}, empty.toArray());
    }


    @Test
    public void testToArrayNotEmpty(){
        assertArrayEquals(new Object[] {notEmptyElem}, notEmpty.toArray());
    }

    @Test
    public void testToStringEmpty(){
        assertEquals("[]", empty.toString());
    }

    @Test
    public void testToStringNotEmpty(){
        assertEquals(Arrays.toString(new Object[]{notEmptyElem}), notEmpty.toString());
    }














}
