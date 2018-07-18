package ru.job4j.array;

public class BubbleSort {

    public int[] sort(int[] array) {
        int temp = 0;
        for (int index = 0; index < array.length - 1; index++) {
            for (int j = 0; j < array.length - index - 1; j++) {
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        return array;
    }
}