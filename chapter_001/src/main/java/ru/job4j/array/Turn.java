package ru.job4j.array;

public class Turn {
    public int[] turn(int[] array) {
        int temp = 0;
        for (int index = 0; index < array.length / 2; index++) {
            temp = array[index];
            array[index] = array[array.length - index - 1];
            array[array.length - index - 1] = temp;
        }
        return array;
    }
}