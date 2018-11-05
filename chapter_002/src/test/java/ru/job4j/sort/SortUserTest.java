package ru.job4j.sort;

import org.junit.Test;

import java.util.*;

import static java.util.Collections.sort;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SortUserTest {
    @Test
    public void sortThreeUser1() {
        SortUser sortUsers = new SortUser();
        List<User> usersNoSort = new ArrayList<>();
        User alina = new User("alina", 21);
        User petr = new User("petr", 31);
        User egor = new User("egor", 10);
        usersNoSort.addAll(Arrays.asList(alina, petr, egor));
        Set<User> usersSort = new TreeSet<>();
        usersSort.addAll(sortUsers.sort(usersNoSort));
        Set<User> expect = new TreeSet<>();
        expect.addAll(Arrays.asList(egor, alina, petr));
        assertThat(usersSort,is(expect));
    }
}
