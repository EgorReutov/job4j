package ru.job4j.set;

import ru.job4j.list.DynamicList;

import java.util.Iterator;

public class SimpleSet<E> implements Iterable<E> {

    private DynamicList<E> array;

    public SimpleSet() {
        this.array = new DynamicList<>();
    }

    public boolean add(E data) {
        return !contains(data) ? array.add(data) : false;
    }

    public boolean contains(E data) {
        boolean result = false;
        for (E temp : this) {
            if (temp == null) {
                continue;
            } else if (temp.equals(data)) {
                result = true;
                break;
            }
        }
        return result;
    }

    @Override
    public Iterator<E> iterator() {
        return array.iterator();
    }
}
