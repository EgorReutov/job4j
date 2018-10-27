package ru.job4j.coffeemachine;

import java.util.ArrayList;

public class СoffeeMachine {
    public ArrayList changes(int value, int price) {
        int money = value - price;
        ArrayList result = new ArrayList();
        int[] change = new int[]{10, 5, 2, 1};

        while (money / change[0] > 0) {
            result.add(change[0]);
            money = money - 10;
        }

        while (money / change[1] > 0) {
            result.add(change[1]);
            money = money - 5;
        }

        while (money / change[2] > 0) {
            result.add(change[2]);
            money = money - 2;
        }

        while (money == 1) {
            result.add(change[3]);
            money = money - 1;
        }
        return result;
    }
}