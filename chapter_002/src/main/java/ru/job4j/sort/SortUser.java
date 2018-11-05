package ru.job4j.sort;

import java.util.*;

public class SortUser {
    public Set<User> sort(List<User> list) {
        Set<User> result = new TreeSet<>(list);
        return result;
    }
}