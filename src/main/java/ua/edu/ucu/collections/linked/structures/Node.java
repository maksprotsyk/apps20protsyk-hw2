package ua.edu.ucu.collections.linked.structures;

public class Node {
    private Object item;
    private Node next;
    private Node previous;

    public Node() {
    }

    public void setNext(Node node) {
        next = node;
    }

    public Node getNext() {
        return next;
    }

    public void setPrev(Node node) {
        previous = node;
    }

    public Node getPrev() {
        return previous;
    }

    public Object getItem() {
        return item;
    }

    public void setItem(Object newItem) {
        item = newItem;
    }
}
