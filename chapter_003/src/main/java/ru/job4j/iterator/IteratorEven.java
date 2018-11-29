package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class IteratorEven<E> implements Iterator {
    private final int[] array;
    private int indexForNext = -1;
    private int result = 0;

    public IteratorEven(int[] array) {
        this.array = array;
    }

    @Override
    public boolean hasNext() {
        for (int index = indexForNext + 1; index < array.length; index++) {
            if (array[index] % 2 == 0) {
                result = array[index];
                indexForNext = index;
                break;
            }
        }
        return result % 2 == 0;
    }

    @Override
    public Object next() {
        if (!this.hasNext()) {
            throw new NoSuchElementException();
        }
        return result;
    }
}
