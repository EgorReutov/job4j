package ru.job4j.list;

import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SimpleQueueTest {

    SimpleQueue list;

    @Before
    public void setUp() {
        list = new SimpleQueue();
        list.push(1);
        list.push(2);
        list.push(3);
        list.push(4);
    }

    @Test
    public void testPushAndPoll() {
        assertThat(list.poll1(), is(1));
        assertThat(list.poll1(), is(2));
        assertThat(list.poll1(), is(3));
        assertThat(list.poll1(), is(4));
    }
}
