package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TwoArraysTest {
    @Test
    public void TestOne() {
        TwoArrays one = new TwoArrays();
        int[] One = new int[]{5, 10, 12};
        int[] Two = new int[]{8, 9, 11};
        int[] result = one.first(One, Two);
        int[] expect = new int[]{5, 8, 9, 10, 11, 12};
        assertThat(result, is(expect));
    }

}
