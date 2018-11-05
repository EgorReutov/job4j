package ru.job4j.sort;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SortUserTest {
    @Test
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
        sortUsers.sort(usersNoSort);
        List<User> expect = new ArrayList<>();
        expect.addAll(
                Arrays.asList(
                        new User("egor", 10),
                        new User("alina", 21),
                        new User("petr", 31)
                        )
        );
        assertThat(sortUsers,is(expect));
    }
}
