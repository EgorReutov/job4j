package ru.job4j.tree;

import java.util.Optional;

public interface SimpleTree<E extends Comparable<E>> {
    boolean add(E parent, E child);

    Optional<Node<E>> findBy(E value);
}