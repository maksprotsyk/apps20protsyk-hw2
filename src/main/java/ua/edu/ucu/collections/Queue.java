package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;


public class Queue {
    private ImmutableLinkedList items;

    public Queue() {
        items = new ImmutableLinkedList();
    }

    public Object peek() {
        return items.getFirst();
    }

    public Object dequeue() {
        Object item = peek();
        items = items.removeLast();
        return item;

    }

    public void enqueue(Object item) {
        items = items.addLast(item);
    }

    public int size() {
        return items.size();
    }

    
}
