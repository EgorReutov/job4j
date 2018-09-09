package ru.job4j.chess;

import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.BishopBlack;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BishopBlackTest {
    @Test
    public void whenWayTurnDiagonal() {
        BishopBlack testBishop = new BishopBlack(Cell.C1);
        Cell[] testTurn = testBishop.way(Cell.C1, Cell.G5);
        assertThat(testTurn.length, is(4));
        assertThat(testTurn, is(new Cell[]{Cell.D2, Cell.E3, Cell.F4, Cell.G5}));
    }
}