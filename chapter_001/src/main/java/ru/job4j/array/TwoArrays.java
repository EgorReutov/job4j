package ru.job4j.array;

public class TwoArrays {
    public int[] first(int[] arrayOne, int[] arrayTwo) {
        int[] result = new int[arrayOne.length + arrayTwo.length];
        int i = 0, j = 0;
        for (int k = 0; k < result.length; k++) {

            if (i > arrayOne.length - 1) {
                result[k] = arrayTwo[j++];
            } else if (j > arrayTwo.length - 1) {
                result[k] = arrayOne[i++];
            } else if (arrayOne[i] < arrayTwo[j]) {
                result[k] = arrayOne[i++];
            } else {
                result[k] = arrayTwo[j++];
            }
        }
        return result;
    }
}

