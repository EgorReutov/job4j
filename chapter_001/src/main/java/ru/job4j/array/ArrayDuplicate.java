package ru.job4j.array;

import java.util.Arrays;

public class ArrayDuplicate {
    public String[] remove(String[] array) {
        int temp = array.length;
        for (int i = 0; i < temp; i++) {
            for (int j = i + 1; j < temp; j++) {
                if (array[i].equals(array[j])) {
                    array[j] = array[temp - 1];
                    temp--;
                    j--;
                }
            }
        }
        return Arrays.copyOf(array, temp);
    }
}
