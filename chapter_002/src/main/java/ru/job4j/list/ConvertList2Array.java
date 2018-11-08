package ru.job4j.list;

import java.util.ArrayList;
import java.util.LinkedList;
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
            for (int a = 1; a != cells - j; a++) {
                array[cells - 1][j + a] = 0;
            }
        }
        return array;
    }

    public List<Integer> convert(List<int[]> list) {
        List<Integer> result = new ArrayList<>();
        for (int[] i : list) {
            for (int j : i) {
                result.add(j);
            }
        }
        return result;
    }
}




