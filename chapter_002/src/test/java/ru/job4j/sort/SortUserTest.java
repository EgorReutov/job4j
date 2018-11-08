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
        User ivan = new User("ivan", 25);
        usersNoSort.addAll(Arrays.asList(alina, petr, egor));
        Set<User> usersSort = new TreeSet<>();
        usersSort.addAll(sortUsers.sort(usersNoSort));
        Set<User> expect = new TreeSet<>();
        expect.addAll(Arrays.asList(egor, alina, petr));
        assertThat(usersSort,is(expect));
    }

    @Test
    public void sortByLengthName() {
        SortUser sortUsers = new SortUser();
        List<User> usersNoSort = new ArrayList<>();
        User alina = new User("alina", 21);
        User petr = new User("petr", 31);
        User yan = new User("yan", 10);
        User ivan = new User("ivan", 25);
        User vladimir = new User("vladimir", 25);
        usersNoSort.addAll(Arrays.asList(vladimir, yan, alina, petr, ivan));
        List<User> usersSort = new ArrayList<>();
        usersSort.addAll(sortUsers.sortNameLength(usersNoSort));
        List<User> expect = new ArrayList<>();
        expect.add(0, yan);
        expect.add(1, petr);
        expect.add(2, ivan);
        expect.add(3, alina);
        expect.add(4, vladimir);
        assertThat(usersSort, is(expect));
    }

    @Test
    public void sortByAge() {
        SortUser sortUsers = new SortUser();
        List<User> usersNoSort = new ArrayList<>();
        User alina = new User("alina", 21);
        User alinaSecond = new User("alina" , 15);
        User petr = new User("petr", 31);
        User yan = new User("yan", 10);
        User ivan = new User("ivan", 25);
        User vladimir = new User("vladimir", 25);
        usersNoSort.addAll(Arrays.asList(vladimir, yan, alina, petr, ivan, alinaSecond));
        List<User> usersSort = new ArrayList<>();
        usersSort.addAll(sortUsers.sortByAllFields(usersNoSort));
        List<User> expect = new ArrayList<>();
        expect.add(0, alinaSecond);
        expect.add(1 , alina);
        expect.add(2, ivan);
        expect.add(3, petr);
        expect.add(4, vladimir);
        expect.add(5, yan);
        assertThat(usersSort, is(expect));
    }


}
