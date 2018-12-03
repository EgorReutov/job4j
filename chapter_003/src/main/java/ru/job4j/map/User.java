package ru.job4j.map;

import java.util.*;

public class User {
    private String name;
    private int children;
    private Calendar birthday;

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + children;
        return result;
    }

    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

    public static void main(String[] args) {
        Calendar calendar = new GregorianCalendar(1997, 01, 9);
        User first = new User("Egor", 0, calendar);
        User second = new User("Egor", 0, calendar);
        Map<User, Object> map = new HashMap<>();

        map.put(first, "first");
        map.put(second, "second");
        System.out.println(map);
    }
}
