package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;
import ua.edu.ucu.collections.immutable.ImmutableList;

public class Stack {
    private ImmutableLinkedList items;

    public Stack() {
        items = new ImmutableLinkedList();
    }

    public Object peek() {
        return items.getLast();
    }

    public Object pop() {
        Object item = peek();
        items = items.removeLast();
        return item;

    }

    public void push(Object item) {
        items = items.addLast(item);
    }

    public int size(){
        return items.size();
    }

    
}
