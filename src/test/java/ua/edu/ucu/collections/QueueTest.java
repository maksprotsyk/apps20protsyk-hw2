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
        assertEquals(1, empty.size());
        assertEquals(3, empty.peek());
    }

    @Test
    public void testPushNotEmpty() {
        notEmpty.enqueue(2);
        assertEquals(2, notEmpty.size());
        assertEquals(notEmptyElem, notEmpty.peek());
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
        empty.dequeue();
    }

    @Test
    public void testPopNotEmpty() {
        assertEquals(notEmptyElem, notEmpty.dequeue());
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
