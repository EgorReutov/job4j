package ru.job4j.generic;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleArray<T> implements Iterable<T> {
    int index = 0;
    int size = 0;
    T[] array;

    public SimpleArray(int size) {
        this.array = (T[]) new Object[size];
    }

    public boolean add(T model) {
        if (index == array.length) {
            throw new UnsupportedOperationException();
        }
        array[index++] = model;
        return true;
    }

    public void set(int index, T model) {
        array[index] = model;
    }

    public T[] delete(int index) {
        int numMoved = array.length - index - 1;
        System.arraycopy(array, index + 1, array, index, numMoved);
        return array;
    }

    public T get(int index) {
        return this.array[index];
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            private int index = 0;

            @Override
            public boolean hasNext() {
                return index != SimpleArray.this.size;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return SimpleArray.this.get(this.index++);
            }
        };
    }
}
