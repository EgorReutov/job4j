package ru.job4j.sort;

import java.util.*;

public class SortUser {
    public Set<User> sort(List<User> list) {
        Set<User> result = new TreeSet<>(list);
        return result;
    }

    public List<User> sortNameLength(List<User> list) {
        List<User> result = new ArrayList<>();
        Collections.sort(list, User.nameLengthComparator);
        result.addAll(list);
        return result;
    }

    public List<User> sortByAllFields(List<User> list) {
        list.sort(new Comparator<User>() {

            @Override
            public int compare(User o1, User o2) {
                int rsl = o1.getName().compareTo(o2.getName());
                return rsl != 0 ? rsl : Integer.compare(o1.getAge(), o2.getAge());
            }
        });
        return list;
    }

}