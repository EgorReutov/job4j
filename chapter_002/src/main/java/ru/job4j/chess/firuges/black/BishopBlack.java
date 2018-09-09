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
            throw new ImpossibleMoveException("Нарушена логика фигуры - слон");
        }

        Cell[] result = new Cell[Math.abs(wayX)];
        int stepX = Integer.compare(dest.x, source.x);
        int stepY = Integer.compare(dest.y, source.y);
        for (int index = 0; index != wayX; index++) {
            result[index] = Cell.find(source.x + stepX * (index + 1), source.y + stepY * (index + 1));
        }
        return result;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}

