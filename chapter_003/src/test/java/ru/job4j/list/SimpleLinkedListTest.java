package ru.job4j.list;

import org.junit.Before;
import org.junit.Test;
import java.util.Iterator;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SimpleLinkedListTest {
    private SimpleLinkedList<Object> list = new SimpleLinkedList<>();

    @Before
    public void setUp() {
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
    }

    @Test
    public void testAddAndGet() {
        assertThat(list.get(0), is(5));
        assertThat(list.get(1), is(4));
        assertThat(list.get(2), is(3));
        assertThat(list.get(3), is(2));
        assertThat(list.get(4), is(1));
    }

    @Test
    public void testIterator() {
        Iterator<Object> iterator = list.iterator();
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(5));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(4));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(3));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(2));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(1));
        assertThat(iterator.hasNext(), is(false));
    }
}
