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
        assertEquals(3, testList.getLast());
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
        assertEquals(1, notEmptyLinked.size());
        assertEquals(notEmptyElem, testList.getFirst());
    }

    @Test
    public void testRemoveFirst(){
        ImmutableLinkedList testList = notEmptyLinked.removeFirst();
        assertEquals(1, notEmptyLinked.size());
        assertEquals(notEmpty.size() - 1, testList.size());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testInvalidRemoveFirst(){
        emptyLinked.removeFirst();
    }

    @Test
    public void testRemoveLast(){
        ImmutableLinkedList testList = notEmptyLinked.removeLast();
        assertEquals(1, notEmptyLinked.size());
        assertEquals(notEmpty.size() - 1, testList.size());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testInvalidRemoveLast(){
        emptyLinked.removeLast();
    }

    @Test
    public void testAddLastNotEmpty(){
        ImmutableLinkedList testList = notEmptyLinked.addLast(4);
        assertEquals(4, testList.get(notEmpty.size()));
        assertEquals(notEmpty.size() + 1, testList.size());
    }

    @Test
    public void testAddLastEmpty(){
        ImmutableLinkedList testList = emptyLinked.addLast(2);
        assertEquals(0, emptyLinked.size());
        assertEquals(2, testList.get(0));
        assertEquals(1, testList.size());
    }

    @Test
    public void testAddFirstNotEmpty(){
        ImmutableLinkedList testList = notEmptyLinked.addFirst(4);
        assertEquals(1, notEmptyLinked.size());
        assertEquals(4, testList.get(0));
        assertEquals(notEmptyLinked.size() + 1, testList.size());
    }

    @Test
    public void testAddFirstEmpty(){
        ImmutableLinkedList testList = emptyLinked.addLast(2);
        assertEquals(0, emptyLinked.size());
        assertEquals(2, testList.get(0));
        assertEquals(1, testList.size());
    }

    
}
