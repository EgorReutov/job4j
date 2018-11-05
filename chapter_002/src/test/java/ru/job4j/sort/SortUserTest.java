package ru.job4j.sort;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

import static java.util.Collections.sort;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SortUserTest {
 /*   @Test
    public void sortThreeUser() {
        SortUser sortUsers = new SortUser();
        List<User> usersNoSort = new ArrayList<>();
        usersNoSort.addAll(
                Arrays.asList(
                        new User("alina", 21),
                        new User("petr", 31),
                        new User("egor", 10)
                )
        );
        List<User> usersSort = new ArrayList<>();
        usersSort.addAll(sortUsers.sort(usersNoSort));
        List<User> expect = new ArrayList<>();
        expect.addAll(
                Arrays.asList(
                        new User("egor", 10),
                        new User("alina", 21),
                        new User("petr", 31)
                        )
        );
        assertThat(usersSort,is(expect));
    }
*/
    @Test
    public void sortThreeUser() {
        TreeSet<User> result = new TreeSet<>();
        TreeSet<User> expect = new TreeSet<>();
        List<User> list = new ArrayList<>();
        SortUser sortUser = new SortUser();
        User user1 = new User("egor", 21);
        User user2 = new User("petr", 31);
        User user3 = new User("alina", 10);
        list.add(user1);
        list.add(user2);
        list.add(user3);
        expect.add(user3);
        expect.add(user1);
        expect.add(user2);
        result.addAll(sortUser.sort(list));
        assertThat(result, is(expect));
    }
}
