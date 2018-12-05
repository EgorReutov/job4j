package ru.job4j.map;


import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleHashMap<K, V> implements Iterable<SimpleHashMap.Node> {
    private Node[] map;
    private int modCount;
    private int size;

    public SimpleHashMap(int size) {
        this.size = size;
        this.map = new Node[size];
        this.modCount = 0;
    }

    public boolean insert(K key, V value) {
        boolean result = false;
        int position = getPosition(key);
        if (position >= size) {
            this.size = this.size + position;
            Node[] tempArray = new Node[size];
            System.arraycopy(map, 0, tempArray,0, map.length);
            map = tempArray;
        }
        if (map[position] == null) {
            map[position] = new Node<>(key, value);
            this.modCount++;
            result = true;
        }
        return result;
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
            result = true;
        }
        return result;
    }

    public int getPosition(K key) {
        return Math.abs((31 * key.hashCode() % 10));
    }

    @Override
    public Iterator<Node> iterator() {
        return new Iterator<Node>() {
            int cursor = 0;
            int expectedModCount = 0;

            @Override
            public boolean hasNext() {
                boolean result = false;
                while (this.cursor < map.length) {
                    if (map[cursor] == null) {
                        cursor++;
                        continue;
                    }
                    if (map[cursor].getClass().equals(Node.class)) {
                        result = true;
                        break;
                    }
                }
                return result;
            }

            @Override
            public Node next() {
              /*  if (modCount != expectedModCount) {
                    throw new ConcurrentModificationException("cme");
                }*/
                if (!hasNext()) {
                    throw new NoSuchElementException("nee");
                }
                return map[this.cursor++];
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
