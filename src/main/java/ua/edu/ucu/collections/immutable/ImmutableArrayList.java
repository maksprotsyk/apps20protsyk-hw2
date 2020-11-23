package ua.edu.ucu.collections.immutable;


import java.util.Arrays;


public class ImmutableArrayList implements ImmutableList {
    private final Object[] items;


    public ImmutableArrayList() {
        items = new Object[0];
    }

    private ImmutableArrayList(Object[] objects) {
        items = objects;
    }

    private Object[] join(int firstEnd, int secondStart, Object[] objects) {
        int length = firstEnd + items.length - secondStart + objects.length;
        Object[] newItems = new Object[length];
        System.arraycopy(items, 0, newItems, 0, firstEnd);
        System.arraycopy(objects, 0, newItems, firstEnd, objects.length);
        System.arraycopy(
                items,
                secondStart,
                newItems,
                objects.length + firstEnd,
                items.length - secondStart
        );
        return newItems;
    }

    private void validateIndex(int index)
            throws ArrayIndexOutOfBoundsException {
        if (index < 0 || index >= items.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public ImmutableArrayList add(Object e) {
        return new ImmutableArrayList(
                join(items.length, items.length, new Object[]{e})
        );
    }

    public ImmutableArrayList add(int index, Object e) {
        validateIndex(index);
        return new ImmutableArrayList(
                join(index, index, new Object[]{e}));
    }

    public ImmutableArrayList addAll(int index, Object[] c) {
        validateIndex(index);
        return new ImmutableArrayList(
                join(index, index, c));
    }

    public ImmutableArrayList addAll(Object[] c) {
        return new ImmutableArrayList(
                join(items.length, items.length, c)
        );
    }

    public Object get(int index) {
        validateIndex(index);
        return items[index];
    }
    public ImmutableArrayList remove(int index) {
        validateIndex(index);
        return new ImmutableArrayList(
                join(index, index+1, new Object[] {})
        );
    }

    public ImmutableArrayList set(int index, Object e) {
        validateIndex(index);
        return new ImmutableArrayList(
                join(index, index+1, new Object[] {e})
        );
    }

    public int indexOf(Object e) {
        return java.util.Arrays.asList(items).indexOf(e);
    }

    public int size() {
        return items.length;
    }

    public ImmutableArrayList clear() {
        return new ImmutableArrayList();
    }

    public boolean isEmpty() {
        return items.length == 0;
    }

    public Object[] toArray() {
        return Arrays.copyOf(items, items.length);
    }

    @Override
    public String toString() {
        return Arrays.toString(items);
    }

}
