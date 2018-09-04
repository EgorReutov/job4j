package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TwoArraysTest {
    @Test
    public void testOne() {
        TwoArrays one = new TwoArrays();
        int[] first = new int[]{5, 10, 12};
        int[] second = new int[]{8, 9, 11};
        int[] result = one.first(first, second);
        int[] expect = new int[]{5, 8, 9, 10, 11, 12};
        assertThat(result, is(expect));
    }

    @Test
    public void testTwo() {
        TwoArrays one = new TwoArrays();
        int[] first = new int[]{};
        int[] second = new int[]{8, 9, 11};
        int[] result = one.first(first, second);
        int[] expect = new int[]{8, 9, 11};
        assertThat(result, is(expect));
    }

    @Test
    public void testThree() {
        TwoArrays one = new TwoArrays();
        int[] first = new int[]{};
        int[] second = new int[]{};
        int[] result = one.first(first, second);
        int[] expect = new int[]{};
        assertThat(result, is(expect));
    }
}
