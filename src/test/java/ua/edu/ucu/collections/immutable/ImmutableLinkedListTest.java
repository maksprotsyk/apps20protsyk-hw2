package ua.edu.ucu.collections.immutable;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
public class ImmutableLinkedListTest extends ImmutableArrayListTest {
    ImmutableLinkedList emptyLinked;
    ImmutableLinkedList notEmptyLinked;

    
    @Override
    @Before
    public void initArrays() {
        empty = new ImmutableLinkedList();
        notEmptyElem = 3;
        notEmpty = new ImmutableLinkedList(new Object[] {notEmptyElem});
        emptyLinked = new ImmutableLinkedList();
        notEmptyLinked = new ImmutableLinkedList(new Object[] {notEmptyElem});
    }

    @Test
    public void testGetLast(){
        ImmutableLinkedList testList = notEmptyLinked.addAll(new Object[] {1, 2, 3});
        assertEquals(testList.getLast(), 3);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testInvalidGetLast(){
        emptyLinked.getLast();
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testInvalidGetFirst(){
        emptyLinked.getFirst();
    }

    @Test
    public void testGetFirst(){
        ImmutableLinkedList testList = notEmptyLinked.addAll(new Object[] {1, 2, 3});
        assertEquals(notEmptyLinked.size(), 1);
        assertEquals(testList.getFirst(), notEmptyElem);
    }

    @Test
    public void testRemoveFirst(){
        ImmutableLinkedList testList = notEmptyLinked.removeFirst();
        assertEquals(notEmptyLinked.size(), 1);
        assertEquals(testList.size(), notEmpty.size() - 1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testInvalidRemoveFirst(){
        emptyLinked.removeFirst();
    }

    @Test
    public void testRemoveLast(){
        ImmutableLinkedList testList = notEmptyLinked.removeLast();
        assertEquals(notEmptyLinked.size(), 1);
        assertEquals(testList.size(), notEmpty.size() - 1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testInvalidRemoveLast(){
        emptyLinked.removeLast();
    }

    @Test
    public void testAddLastNotEmpty(){
        ImmutableLinkedList testList = notEmptyLinked.addLast(4);
        assertEquals(testList.get(notEmpty.size()), 4);
        assertEquals(testList.size(), notEmpty.size() + 1);
    }

    @Test
    public void testAddLastEmpty(){
        ImmutableLinkedList testList = emptyLinked.addLast(2);
        assertEquals(emptyLinked.size(), 0);
        assertEquals(testList.get(0), 2);
        assertEquals(testList.size(), 1);
    }

    @Test
    public void testAddFirstNotEmpty(){
        ImmutableLinkedList testList = notEmptyLinked.addFirst(4);
        assertEquals(notEmptyLinked.size(), 1);
        assertEquals(testList.get(0), 4);
        assertEquals(testList.size(), notEmptyLinked.size() + 1);
    }

    @Test
    public void testAddFirstEmpty(){
        ImmutableLinkedList testList = emptyLinked.addLast(2);
        assertEquals(emptyLinked.size(), 0);
        assertEquals(testList.get(0), 2);
        assertEquals(testList.size(), 1);
    }

    
}
