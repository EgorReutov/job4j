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

public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException {
        int wayX = Math.abs(source.x - dest.x);
        int wayY = Math.abs(source.y - dest.y);
        if (wayX != wayY || source.x == dest.x || source.y == dest.y) {
            throw new ImpossibleMoveException ("Нарушена логика фигуры - слон");
        }

        Cell[] result = new Cell[Math.abs(wayX)];
        int stepX = wayX > 0 ? -1 : 1;
        int stepY = wayY > 0 ? -1 : 1;
        for (int index = 0; index < result.length; index++) {
            int i = source.x + stepX * (index + 1);
            int j = source.y + stepY * (index + 1);
            result[index] = Cell.values()[i * 8 + j];
        }
        return result;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}

