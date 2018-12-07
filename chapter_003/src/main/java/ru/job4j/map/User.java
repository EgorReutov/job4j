package ru.job4j.map;

import java.util.*;

public class User {
    private String name;
    private int children;


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
    }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return children == user.children && Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + children;
        return result;
    }

    public User(String name, int children) {
        this.name = name;
        this.children = children;
    }
}
