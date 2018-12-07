package ru.job4j.map;


import org.junit.Before;
import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SimpleHashMapTest {
    private SimpleHashMap<User, String> map;
    private User petr;
    private User egor;
    private User roma;

    @Before
    public void setUp() {
        petr = new User("Petr", 1);
        egor = new User("Egor", 0);
        roma = new User("Roma", 2);

        map = new SimpleHashMap<>();
        map.insert(petr, "Test");
        map.insert(egor, "Test2");
        map.insert(roma, "Test");
    }

    @Test
    public void whenGetValue() {
        assertThat(map.get(petr), is("Test"));
    }

    @Test
    public void whenDeleteElement() {
        map.delete(egor);
        assertNull(map.get(egor));
    }

    @Test
    public void whenIteratorTest() {
        Iterator iterator = map.iterator();
        assertTrue(iterator.hasNext());
        iterator.next();
        iterator.next();
        iterator.next();
        assertFalse(iterator.hasNext());
    }

}
