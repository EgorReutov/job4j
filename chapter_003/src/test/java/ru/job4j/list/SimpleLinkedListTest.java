package ru.job4j.list;

import org.junit.Before;
import org.junit.Test;
import java.util.Iterator;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SimpleLinkedListTest {
    private SimpleLinkedList<Object> list = new SimpleLinkedList<>();

  /*  @Before
    public void setUp() {
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
    }*/

    @Test
    public void testAddAndGet() {
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        assertThat(list.get(1), is(2));
    }

    /*@Test
    public void testIterator() {
        Iterator<Object> iterator = list.iterator();
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(1));
    }*/
}
