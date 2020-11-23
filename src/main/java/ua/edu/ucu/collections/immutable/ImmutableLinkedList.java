package ua.edu.ucu.collections.immutable;

import ua.edu.ucu.collections.iterators.LinkedListIterator;
import ua.edu.ucu.collections.linked_structures.Node;

import java.util.Arrays;

public class ImmutableLinkedList implements ImmutableList{
    final private Node head;
    final private Node tail;
    final private LinkedListIterator iterator;
    final private int size;

    public ImmutableLinkedList() {
        size = 0;
        head = new Node();
        tail = head;
        iterator = new LinkedListIterator(head);
    }

    public ImmutableLinkedList(Object[] initItems) {
        ImmutableLinkedList initList = new ImmutableLinkedList().addAll(initItems);
        head = initList.head;
        size = initList.size;
        tail = initList.tail;
        iterator = initList.iterator;

    }

    private ImmutableLinkedList(Node initHead, Node initTail, int initSize) {
        size = initSize;
        head = initHead;
        iterator = new LinkedListIterator(initHead);
        tail = initTail;

    }

    private void validateIndex(int index) throws ArrayIndexOutOfBoundsException {
        if (index < 0 || index >= size){
            throw new ArrayIndexOutOfBoundsException("Index out of range");
        }
    }

    private ImmutableLinkedList createJoined(int firstEnd, int secondStart, Object[] objects) {
        iterator.restart();
        int newSize = firstEnd + size - secondStart + objects.length;
        Node currNode = new Node();
        Node prevNode;
        Node newHead = currNode;
        for (int i = 0; i < firstEnd; i++){
            currNode.setItem(iterator.getNext());
            currNode.setNext(new Node());
            prevNode = currNode;
            currNode = currNode.getNext();
            currNode.setPrev(prevNode);
        }

        for (Object obj: objects){
            currNode.setItem(obj);
            currNode.setNext(new Node());
            prevNode = currNode;
            currNode = currNode.getNext();
            currNode.setPrev(prevNode);
        }

        iterator.restart();

        for (int i = 0; i < secondStart; i++){
            iterator.getNext();
        }


        while (iterator.hasMore()){
            currNode.setItem(iterator.getNext());
            currNode.setNext(new Node());
            prevNode = currNode;
            currNode = currNode.getNext();
            currNode.setPrev(prevNode);
        }

        if (newSize != 0){
            currNode = currNode.getPrev();
        }

        return new ImmutableLinkedList(newHead, currNode, newSize);
    }

    public ImmutableLinkedList add(Object e) {
        return createJoined(size, size, new Object[]{e});
    }

    public ImmutableLinkedList add(int index, Object e) {
        validateIndex(index);
        return createJoined(index, index, new Object[]{e});
    }

    public ImmutableLinkedList addAll(Object[] c) {
        return createJoined(size, size, c);
    }

    public ImmutableLinkedList addAll(int index, Object[] c) {
        validateIndex(index);
        return createJoined(index, index, c);
    }

    public Object get(int index) {
        iterator.restart();
        validateIndex(index);
        for (int i = 0; i < index; i++){
            iterator.getNext();
        }
        return iterator.getNext();
    }

    public ImmutableLinkedList remove(int index) {
        validateIndex(index);
        return createJoined(index, index+1, new Object[]{});
    }

    public ImmutableLinkedList set(int index, Object e) {
        validateIndex(index);
        return createJoined(index, index+1, new Object[]{e});
    }

    public int indexOf(Object e) {
        iterator.restart();
        for (int i = 0; i < size; i++){
            if (iterator.getNext() == e){
                return i;
            }
        }
        return -1;
    }

    public int size() {
        return size;
    }

    public ImmutableLinkedList clear() {
        return new ImmutableLinkedList();
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public Object[] toArray() {
        Object[] array = new Object[size];
        iterator.restart();
        for (int i = 0; i < size; i++){
            array[i] = iterator.getNext();
        }
        return array;
    }

    @Override
    public String toString() {
        return Arrays.toString(toArray());
    }

    public ImmutableLinkedList addFirst(Object e) {
        return createJoined(0, 0, new Object[] {e});
    }

    public ImmutableLinkedList addLast(Object e) {
        return createJoined(size, size, new Object[]{e});
    }

    public Object getLast() {
        if (isEmpty()){
            throw new IndexOutOfBoundsException("Getting element from empty list");
        }
        return tail.getItem();
    }

    public Object getFirst() {
        if (isEmpty()){
            throw new IndexOutOfBoundsException("Getting element from empty list");
        }
        return head.getItem();
    }

    public ImmutableLinkedList removeFirst() {
        if (isEmpty()){
            throw new IndexOutOfBoundsException("Removing element of empty list");
        }
        return createJoined(0, 1, new Object[]{});
    }

    public ImmutableLinkedList removeLast() {
        if (isEmpty()){
            throw new IndexOutOfBoundsException("Removing element of empty list");
        }
        return createJoined(size - 1, size, new Object[]{});
    }

}


