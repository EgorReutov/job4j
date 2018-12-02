package ru.job4j.list;

class Node<T> {
    T value;
    Node<T> next;

    public boolean hasCycle(Node first) {
        boolean result = false;
        Node<T> indexI = first;
        Node<T> indexJ = first;
        while (indexJ.next != null) {
            indexI = indexI.next;
            indexJ = indexJ.next.next;
            if (indexI == indexJ) {
                result = true;
            }
        }
        return result;
    }
}
