package ru.job4j.chess;


import ru.job4j.chess.firuges.Cell;

abstract class Figure {
    private final Cell position;

    protected Figure(Cell position) {
        this.position = position;
    }

    abstract Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException;

    abstract Figure copy(Cell dest);

}
