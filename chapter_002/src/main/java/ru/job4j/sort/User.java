package ru.job4j.sort;

import java.util.Comparator;
import java.util.Objects;

public class User implements Comparable<User> {
    private Integer age;
    private String name;

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public Integer getAge() {
        return age;
    }

    @Override
    public int hashCode() {
        return this.age.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int compareTo(User o) {
        return this.age.compareTo(o.getAge());

    }

}
