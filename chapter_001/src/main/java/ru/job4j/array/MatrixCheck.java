package ru.job4j.array;

public class MatrixCheck {
    public boolean mono(boolean[][] data) {
        boolean result = true;
        boolean temp = data[0][0];
        for (int index = 0; index < data.length - 1; index++) {
            if ((data[index][index] != temp) || (data[data.length - 1 - index][index] != temp)) {
                result = false;
                break;
            }
        }
        return result;
    }
}
