package ru.job4j.generic;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;


public class SimpleArrayTest {
    SimpleArray array = new SimpleArray(5);

    @Test
    public void testAddAndGet() {
        array.add(2);
        array.add("test");
        array.add("testSecond");
        assertThat(array.get(0), is(2));
        assertThat(array.get(2), is("testSecond"));
    }

    @Test
    public void testSetAndDelete() {
        array.add(5);
        array.add(10);
        array.add(14);
        array.add("test2");
        array.set(1, "test");
        array.delete(0);
        assertThat(array.get(0), is("test"));
        assertThat(array.get(2), is("test2"));
    }
}
