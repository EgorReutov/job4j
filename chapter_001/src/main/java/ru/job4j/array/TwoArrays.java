package ru.job4j.array;

public class TwoArrays {
    public int[] first(int[] arrayOne, int[] arrayTwo) {
        int[] result = new int[arrayOne.length + arrayTwo.length];
        int i = 0, j = 0;
        for (int k = 0; k < result.length; k++) {

            if (i > arrayOne.length - 1) {
                int a = arrayTwo[j];
                result[k] = a;
                j++;
            } else if (j > arrayTwo.length - 1) {
                int a = arrayOne[i];
                result[k] = a;
                i++;
            } else if (arrayOne[i] < arrayTwo[j]) {
                int a = arrayOne[i];
                result[k] = a;
                i++;
            } else {
                int b = arrayTwo[j];
                result[k] = b;
                j++;
            }
        }
        return result;
    }
}

