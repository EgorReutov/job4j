package ru.job4j.Iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class IteratorForArray implements Iterator {
    private final int[][] array;
    int indexI = 0;
    int indexJ = 0;


    public IteratorForArray(int[][] array) {
        this.array = array;
    }

    @Override
    public boolean hasNext () {
        return indexJ != array.length;
    }

    @Override
    public Object next () {
        if (!this.hasNext()) {
            throw new NoSuchElementException();
        }
        int result = array[indexJ][indexI++];
        if (indexI == array[indexJ].length) {
            indexI = 0;
            indexJ++;
        }
        return result;
    }

}
