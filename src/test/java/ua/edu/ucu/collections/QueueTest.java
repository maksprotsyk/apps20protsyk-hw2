package ua.edu.ucu.collections;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class QueueTest {
    Queue empty;
    Queue notEmpty;
    Object notEmptyElem;

    @Before
    public void initStack() {
        empty = new Queue();
        notEmptyElem = 10;
        notEmpty = new Queue();
        notEmpty.enqueue(notEmptyElem);
    }


    @Test
    public void testPushEmpty() {
        empty.enqueue(3);
        assertEquals(empty.size(), 1);
        assertEquals(empty.peek(), 3);
    }

    @Test
    public void testPushNotEmpty() {
        notEmpty.enqueue(2);
        assertEquals(notEmpty.size(), 2);
        assertEquals(notEmpty.peek(), notEmptyElem);
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
        empty.dequeue();
    }

    @Test
    public void testPopNotEmpty() {
        assertEquals(notEmpty.dequeue(), notEmptyElem);
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
