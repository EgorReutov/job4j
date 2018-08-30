package ru.job4j.chess;

import ru.job4j.chess.firuges.Cell;

public class Board {
    Figure[] figures = new Figure[32];

    public void add(Figure figure) {

    }

    public  boolean move(Cell source, Cell dest) throws ImpossibleMoveException, OccupiedWayException, FigureNotFoundException {
        boolean result = false;
        return result;
    }
}
