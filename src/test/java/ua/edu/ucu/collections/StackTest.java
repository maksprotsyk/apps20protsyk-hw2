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
        assertEquals(1, empty.size());
        assertEquals(3, empty.peek());
    }

    @Test
    public void testPushNotEmpty() {
        notEmpty.push(3);
        assertEquals(2, notEmpty.size());
        assertEquals(3, notEmpty.peek());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testPeekEmpty() {
        empty.peek();
    }

    @Test
    public void testPeekNotEmpty() {
        assertEquals(notEmptyElem, notEmpty.peek());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testPopEmpty() {
        empty.pop();
    }

    @Test
    public void testPopNotEmpty() {
        assertEquals(notEmptyElem, notEmpty.pop());
        assertEquals(0, notEmpty.size());
    }

    @Test
    public void testSizeEmpty() {
        assertEquals(0, empty.size());
    }

    @Test
    public void testSizeNotEmpty() {
        assertEquals(1, notEmpty.size());
    }
    
}
