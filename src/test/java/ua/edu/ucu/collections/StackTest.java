package ua.edu.ucu.collections;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StackTest {
    Stack empty;
    Stack notEmpty;
    Object notEmptyElem;

    @Before
    public void initStack() {
        empty = new Stack();
        notEmptyElem = 10;
        notEmpty = new Stack();
        notEmpty.push(notEmptyElem);
    }


    @Test
    public void testPushEmpty() {
        empty.push(3);
        assertEquals(empty.size(), 1);
        assertEquals(empty.peek(), 3);
    }

    @Test
    public void testPushNotEmpty() {
        notEmpty.push(3);
        assertEquals(notEmpty.size(), 2);
        assertEquals(notEmpty.peek(), 3);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testPeekEmpty() {
        empty.peek();
    }

    @Test
    public void testPeekNotEmpty() {
        assertEquals(notEmpty.peek(), notEmptyElem);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testPopEmpty() {
        empty.pop();
    }

    @Test
    public void testPopNotEmpty() {
        assertEquals(notEmpty.pop(), notEmptyElem);
        assertEquals(notEmpty.size(), 0);
    }

    @Test
    public void testSizeEmpty() {
        assertEquals(empty.size(), 0);
    }

    @Test
    public void testSizeNotEmpty() {
        assertEquals(notEmpty.size(), 1);
    }
    
}
