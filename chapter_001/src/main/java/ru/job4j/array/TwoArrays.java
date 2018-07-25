package ru.job4j.array;

public class TwoArrays {
    public static int[] first (int[] arrayOne, int[] arrayTwo){
        int[] result = new int[arrayOne.length + arrayTwo.length];
        for (int index = 0; index <first(arrayOne, arrayTwo).length; index++) {
            if (arrayOne[index] < arrayTwo[index]) {
                result[index] = arrayOne[index];
                result[index + 1] = arrayTwo[index];
            } else {
                result[index] = arrayTwo[index];
                result[index + 1] = arrayOne[index];
            }
        }
        return result;
    }
}
