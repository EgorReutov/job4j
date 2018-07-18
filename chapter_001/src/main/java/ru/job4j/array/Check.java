package ru.job4j.array;

public class Check {
    public boolean mono(boolean[] data) {
        boolean result = false;
        for (int index = 0; index < data.length - 1; index++) {
            result = data[1] == data[index + 1];
        }
        return result;
    }
}