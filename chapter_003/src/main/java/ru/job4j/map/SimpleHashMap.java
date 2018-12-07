package ru.job4j.map;


import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static java.util.Objects.hash;

public class SimpleHashMap<K, V> implements Iterable<SimpleHashMap.Node> {
    private Node[] map;
    private int modCount;
    private int itemCounter;
    private int size;
    private int threshold;
    private double loadFactor;

    public SimpleHashMap() {
        this.size = 16;
        this.loadFactor = 0.75;
        this.threshold = (int) (this.size * loadFactor);
        this.map = new Node[this.size];
        this.modCount = 0;
    }


    public boolean insert(K key, V value) {
        boolean result = false;
        int index = getPosition(key);
        if (map[index] == null) {
            map[index] = new Node(key, value);
            modCount++;
            itemCounter++;
            if (this.itemCounter == threshold) {
                refresh();
            }
            result = true;
        }
        return result;
    }

    public void refresh() {
        modCount++;
        size = size * 2;
        this.threshold = (int) (this.size * loadFactor);
        Node<K, V>[] oldMap = this.map;
        this.map = new Node[this.size];
        for (Node<K, V> element : oldMap) {
            if (element != null) {
                this.map[getPosition(element.key)] = element;
            }
        }
    }

    public V get(K key) {
        int position = getPosition(key);
        Node<K, V> node = this.map[position];
        V result = null;
        if (node != null && map[position].key.hashCode() == key.hashCode() && map[position].key.equals(key)) {
            result = node.value;
        }
        return result;
    }

    public boolean delete(K key) {
        boolean result = false;
        int position = getPosition(key);
        if (map[position] != null && map[position].key.hashCode() == key.hashCode() && map[position].key.equals(key)) {
            map[position] = null;
            modCount++;
            itemCounter--;
            result = true;
        }
        return result;
    }

    public int getPosition(K key) {
        return key.hashCode() % size;
    }

    @Override
    public Iterator<Node> iterator() {
        return new Iterator<Node>() {
            private final int expectedModCount = modCount;
            private int position;
            private int innerCount;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return this.innerCount < itemCounter;
            }

            @Override
            public Node next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                while (map[position] == null) {
                    position++;
                }
                innerCount++;
                return map[position++];
            }
        };
    }

    static class Node<K, V> {
        final K key;
        V value;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
