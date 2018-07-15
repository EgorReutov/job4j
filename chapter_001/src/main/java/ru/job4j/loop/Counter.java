package ru.job4j.loop;

public class Counter {
    public static int add(int start, int finish) {
        int result = 0;
        if (start % 2 != 0) {
            start++;
        }

        for (int index = start; index <= finish; index += 2) {
            result += index;
        }
        return result;
    }
}