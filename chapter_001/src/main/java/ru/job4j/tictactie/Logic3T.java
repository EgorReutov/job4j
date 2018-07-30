package ru.job4j.tictactie;

public class Logic3T {
    private final Figure3T[][] table;

    public Logic3T(Figure3T[][] table) {
        this.table = table;
    }

    public boolean isWinnerX() {
        boolean result = false;
        for (int index = 0; index < table.length - 1; index++) {
            if (table[index][index] == table[index + 1][index + 1]) {
                result = true;
                break;
            }
            if (table[table.length - 1 - index][index] == table[table.length - 2 - index][index + 1]) {
                result = true;
                break;
            }
            for (int i = 0; i < table.length; i++) {
                for (int j = 0; j < table.length; j++) {
                    if (table[i][j] == table[i][index + 1]){
                        result = true;
                        break;
                    }
                }
            }
        }
        return result;
    }

    public boolean isWinnerO() {
        boolean result = false;
        for (int index = 0; index < table.length - 1; index++) {
            if (table[index][index] == table[index + 1][index + 1]) {
                result = true;
                break;
            }
            if (table[table.length - 1 - index][index] == table[table.length - 2 - index][index + 1]) {
                result = true;
                break;
            }
            for (int i = 0; i < table.length; i++) {
                for (int j = 0; j < table.length; j++) {
                    if (table[i][j] == table[i][index + 1]){
                        result = true;
                        break;
                    }
                }
            }
        }
        return result;
    }

    public boolean hasGap() {
        boolean result = false;
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                if (table[i][j].hasMarkX() == table[i][j].hasMarkO()) {
                    return true;
                }
            }
        }
        return result;
    }
}