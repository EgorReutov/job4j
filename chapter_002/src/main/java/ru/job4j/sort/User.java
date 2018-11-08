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

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(age, user.age)
                && Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, name);
    }

    public static Comparator<User> nameLengthComparator = new Comparator<User>() {

        @Override
        public int compare(User o1, User o2) {
            return o1.getName().length() - o2.getName().length();
        }
    };

    public static Comparator<User> nameAndAgeComporator = new Comparator<User>() {

        @Override
        public int compare(User o1, User o2) {

            return o1.getAge() - o2.getAge();
        }
    };

    @Override
    public int compareTo(User o) {
        return this.age.compareTo(o.age);
    }
}


