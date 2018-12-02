package ru.job4j.list;

import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SimpleStackTest {

    private SimpleStack list;

    @Before
    public void setUp() {
        list = new SimpleStack();
        list.push(1);
        list.push(2);
        list.push(3);
        list.push(4);
    }

    @Test
    public void testPush() {
        this.list.push(5);
        assertThat(list.getSize(), is(5));
    }

    @Test
    public void testPoll() {
        assertThat(list.poll(), is(4));
        assertThat(list.poll(), is(3));
        assertThat(list.getSize(), is(2));
        assertThat(list.poll(), is(2));
        assertThat(list.poll(), is(1));
        assertThat(list.getSize(), is(0));
    }
}
