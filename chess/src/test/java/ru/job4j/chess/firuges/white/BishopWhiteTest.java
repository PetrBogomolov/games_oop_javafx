package ru.job4j.chess.firuges.white;

import org.junit.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import static org.junit.Assert.*;

public class BishopWhiteTest {

    @Test
    public void WhenPositionRight() {
        BishopWhite bishopWhite = new BishopWhite(Cell.C1);
        Cell actual = bishopWhite.position();
        Cell expected = Cell.C1;
        assertEquals(expected, actual);
    }

    @Test
    public void WhencCopyRight() {
        BishopWhite bishopWhite = new BishopWhite(Cell.C1);
        Cell actual = bishopWhite.copy(Cell.E3).position();
        Cell expected = Cell.E3;
        assertEquals(expected, actual);
    }

    @Test
    public void WhenWayRight() throws ImpossibleMoveException {
        BishopWhite bishopWhite = new BishopWhite(Cell.C1);
        Cell[] actual = bishopWhite.way(Cell.C1, Cell.G5);
        Cell[] expected = {Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        assertEquals(expected, actual);
    }

    @Test(expected = ImpossibleMoveException.class)
    public void WhenMoveNotDiagonalThen() throws ImpossibleMoveException {
        BishopWhite bishopWhite = new BishopWhite(Cell.C1);
        Cell[] expect = bishopWhite.way(Cell.C1, Cell.D1);
    }
}