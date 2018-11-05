package ru.job4j.sort;

import java.util.Comparator;

public class User implements Comparable<User> {
    private Integer age;
    private String name;

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(User o) {
        return this.age.compareTo(o.age);
    }

}
