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
        final Node<E> tempFirst = first;
        final Node<E> newLink = new Node<>(null, element, tempFirst);
        this.first = newLink;
        if (tempFirst == null) {
            this.last = newLink;
        } else {
            tempFirst.previous = newLink;
        }
        this.size++;
        this.modCount++;
    }

    public E delete() {
        Node<E> result = this.first;
        if (this.first.next != null) {
            this.first = this.first.next;
            this.first.previous = null;
            size--;
            modCount++;
        } else {
            this.first = null;
            size--;
            modCount++;
        }
        return result.date;
    }

    public E deleteLast() {
        Node<E> result = this.last;
        if (this.last.previous != null) {
            this.last = this.last.previous;
            this.last.next = null;
            size--;
            modCount++;
         } else {
            this.last = null;
            size--;
            modCount++;
        }
        return result.date;
    }

    public E get(int index) {
        if (index > size) {
            throw new IndexOutOfBoundsException("Индекс находится вне размера контейнера");
        }
        Node<E> result = this.first;
        for (int i = 0; i < index; i++) {
            result = result.next;
        }
        return result.date;
    }

    public int getSize() {
        return this.size;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int expectedModCount = modCount;
            int counter = 0;

            @Override
            public boolean hasNext() {
                return counter < size;
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

        Node(Node<E> previous, E date, Node<E> next) {
            this.previous = previous;
            this.date = date;
            this.next = next;
        }
    }
}
