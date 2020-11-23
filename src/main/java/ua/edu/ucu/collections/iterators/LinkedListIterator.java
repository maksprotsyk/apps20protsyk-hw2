package ua.edu.ucu.collections.iterators;

import ua.edu.ucu.collections.linked.structures.Node;


public class LinkedListIterator implements Iterator {
    private Node head;
    private Node currNode;

    public LinkedListIterator(Node initHead) {
        currNode = initHead;
        head = initHead;

    }

    public boolean hasMore() {
        return currNode.getItem() != null;
    }

    public void restart() {
        currNode = head;
    }

    public Object getNext() {
        Object item = currNode.getItem();
        currNode = currNode.getNext();
        return item;
    }

}
