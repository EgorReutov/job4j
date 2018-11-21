package ru.job4j.iterator;

import org.junit.Before;
import org.junit.Test;
import java.util.Iterator;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class IteratorEvenTest {
    private Iterator<Integer> itOne, itTwo;

    @Before
    public void setIt() {
        itOne = new IteratorEven(new int[] {1, 4, 6, 5});
        itTwo = new IteratorEven(new int[] {2, 3, 7, 10, 12});
    }

    @Test
    public void testFirstNoEvenOnlyNext() {
        assertThat(itOne.next(), is(4));
        assertThat(itOne.next(), is(6));
    }

    @Test
    public void testFirstEvenNextAndHasNext() {
        assertThat(itTwo.next(), is(2));
        assertThat(itTwo.next(), is(10));
        assertThat(itOne.hasNext(), is(true));
        assertThat(itTwo.next(), is(12));
    }

    @Test
    public void testFirstNoEvenHasNext() {
        assertThat(itOne.hasNext(), is(true));
        assertThat(itOne.hasNext(), is(true));
        assertThat(itOne.hasNext(), is(true));
    }
}
