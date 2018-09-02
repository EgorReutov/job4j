package ru.job4j.chess.firuges.black;

import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

/**
 *
 * @author Egor Reutov (reutov9@yandex.ru)
 * @version 1.0
 * @since 30.08.2018
 */
public class PawnBlack implements Figure {
    private final Cell position;

    public PawnBlack(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException {
        Cell[] steps = new Cell[0];
        if (source.y == dest.y + 1 && source.x == dest.x) {
            steps = new Cell[] {dest};
        }
        return steps;
    }

    @Override
    public Figure copy(Cell dest) {
        return new PawnBlack(dest);
    }
}
