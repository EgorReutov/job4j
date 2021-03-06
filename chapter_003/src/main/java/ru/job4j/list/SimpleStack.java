package ru.job4j.list;

public class SimpleStack<E> extends SimpleLinkedList<E> {

    public SimpleStack() {
        super();
    }

    public E poll() {
        return super.delete();
    }

    public void push(E value) {
        super.add(value);
    }
}
