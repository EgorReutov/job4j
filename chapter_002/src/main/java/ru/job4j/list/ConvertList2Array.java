package ru.job4j.list;

import java.util.List;

public class ConvertList2Array {
    public int[][] toArray(List<Integer> list, int rows) {
        int cells = list.size() / rows;

        if (list.size() % rows != 0) {
            cells++;
        }

        int[][] array = new int[rows][cells];
        int i = 0, j = 0;

        for (Integer k : list) {
            array[i][j++] = k;
            if (j == cells) {
                j = 0;
                i++;
            }
        }

        if (list.size() % rows != 0) {
            for (int a = 0; a != cells - j; a++) {
                array[cells - 1][j++] = 0;
            }
        }


        return array;
    }
}




