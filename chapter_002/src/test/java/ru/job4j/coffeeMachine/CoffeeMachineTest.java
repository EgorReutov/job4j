package ru.job4j.coffeeMachine;

import org.junit.Test;

import ru.job4j.coffeemachine.СoffeeMachine;
import java.util.ArrayList;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CoffeeMachineTest {

    @Test
    public void testTwoCoinsFirst() {
        СoffeeMachine one = new СoffeeMachine();
        ArrayList result = one.changes(50, 35);
        ArrayList expect = new ArrayList();
        expect.add(10);
        expect.add(5);
        assertThat(result, is(expect));
    }

    @Test
    public void testTwoCoinsSecond() {
        СoffeeMachine one = new СoffeeMachine();
        ArrayList result = one.changes(50, 47);
        ArrayList expect = new ArrayList();
        expect.add(2);
        expect.add(1);
        assertThat(result, is(expect));
    }

    @Test
    public void testThreeCoins() {
        СoffeeMachine one = new СoffeeMachine();
        ArrayList result = one.changes(60, 35);
        ArrayList expect = new ArrayList();
        expect.add(10);
        expect.add(10);
        expect.add(5);
        assertThat(result, is(expect));
    }

    @Test
    public void testFourCoins() {
        СoffeeMachine one = new СoffeeMachine();
        ArrayList result = one.changes(50, 32);
        ArrayList expect = new ArrayList();
        expect.add(10);
        expect.add(5);
        expect.add(2);
        expect.add(1);
        assertThat(result, is(expect));
    }

}
