package ru.job4j.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleLinkedList<E>  implements Iterable<E> {
    private Node<E> first;
    private Node<E> last;
    private int size = 0;
    private int modCount = 0;

    public void add(E element) {
        Node<E> newLink = new Node<>(element);
        newLink.next = this.first;
        if (size == 1) {
            this.last = this.first;
        }
        if (size > 0) {
            this.first.previous = newLink;
        }
        this.first = newLink;
        this.size++;
        this.modCount++;
    }

    public E get(int index) {
        Node<E> result = this.first;
        for (int i = 0; i < index; i++) {
            result = result.next;
        }
        return result.date;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int expectedModCount = modCount;
            int counter = 0;

            @Override
            public boolean hasNext() {
                return counter != size;
            }

            @Override
            public E next() {
                if (modCount != expectedModCount) {
                    throw new ConcurrentModificationException();
                }
                if (counter >= size) {
                    throw new NoSuchElementException();
                }
                return get(counter++);
            }
        };
    }

    private static class Node<E> {

        E date;
        Node<E> next;
        Node<E> previous;

        Node(E date) {
            this.date = date;
        }
    }
}
