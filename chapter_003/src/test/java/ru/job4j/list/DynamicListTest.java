package ru.job4j.list;

import org.junit.Test;

import java.util.Iterator;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;


public class DynamicListTest {

    private DynamicList<Object> list = new DynamicList<>();

    @Test
    public void testAdd() {
        list.add(5);
        list.add(8);
        assertThat(list.get(1), is(8));
    }

    @Test
    public void testIterator() {
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        Iterator<Object> iterator = list.iterator();
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(1));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(2));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(3));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(4));
        assertThat(iterator.hasNext(), is(true));
        iterator.next();
        assertThat(iterator.hasNext(), is(false));

    }
}
