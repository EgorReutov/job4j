package ru.job4j.chess.firuges.black;

import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

/**
 *
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class QeenBlack implements Figure {
    private final Cell position;

    public QeenBlack(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) {
        if ((source.x != dest.x || source.y != dest.y) && (Math.abs(source.x - dest.x) != Math.abs(source.y - dest.y)
                || source.x == dest.x || source.y == dest.y)) {
            throw new ImpossibleMoveException("Нарушена логика фигуры - королева");
        }
        return new Cell[] {dest};
    }

    @Override
    public Figure copy(Cell dest) {
        return new QeenBlack(dest);
    }
}
