package ru.job4j.set;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class SimpleSetTest {

    private SimpleSet set;

    @Test
    public void testAddToSet() {
        set = new SimpleSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        assertFalse(set.add(2));
        assertTrue(set.add(5));
    }
}
