package ru.job4j.banktransfers;

import java.util.*;

public class User {
    private String name;
    private String passport;

   /* public User(String name, String passport) {
        this.name = name;
        this.passport = passport;
    }*/

    public String getName() {
        return name;
    }

    public String getPassport() {
        return passport;
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
        return passport == user.passport
                && Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, passport);
    }
}
