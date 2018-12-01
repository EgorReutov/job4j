package ru.job4j.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class DynamicList<E> implements Iterable<E> {
    private int index = 0;
    private int modCount = 0;
    private E[] array = (E[]) new Object[5];

    public void add(E object) {
        if (index == array.length - 1) {
            reSize((array.length * 3) / 2 + 1);
        }
        modCount++;
        array[index++] = object;
    }

    public E get(int index) {
        return array[index];
    }

    private void reSize(int newSize) {
        E[] newArray = (E[]) new Object[newSize];
        System.arraycopy(array, 0, newArray, 0, index);
        array = newArray;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int expectedModCount = modCount;
            int counter = 0;

            @Override
            public boolean hasNext() {
                return counter < array.length;
            }

            @Override
            public E next() {
                if (modCount != expectedModCount) {
                    throw new ConcurrentModificationException();
                }

                if (counter >= array.length) {
                    throw new NoSuchElementException();
                }
                return array[counter++];
            }
        };
    }
}
