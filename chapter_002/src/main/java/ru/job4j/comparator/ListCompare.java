package ru.job4j.comparator;

import java.util.Comparator;

public class ListCompare implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        int result = 0;
        int min = Math.min(left.length(), right.length());
        int index = 0;
        while (index < min) {
            if (left.charAt(index) != right.charAt(index)) {
                return left.charAt(index) - right.charAt(index);
            }
            index++;
        }
        return left.length() - right.length();
    }
}
