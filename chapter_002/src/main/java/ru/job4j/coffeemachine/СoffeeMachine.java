package ru.job4j.coffeemachine;

import java.util.ArrayList;

public class СoffeeMachine {
    public ArrayList changes(int value, int price) {
        int money = value - price;
        ArrayList result = new ArrayList();
        int[] change = new int[]{10, 5, 2, 1};
        for (int coins : change) {
            while (money / coins > 0) {
                result.add(coins);
                money = money - coins;
            }
        }
        return result;
    }
}