package ru.job4j.list;

import java.util.Stack;

public class SimpleQueue<E> extends SimpleLinkedList<E> {

    public SimpleQueue() {
        super();
    }

    public E poll1() {
        return super.deleteLast();
    }

    public void push(E value) {
        super.add(value);
    }
}
