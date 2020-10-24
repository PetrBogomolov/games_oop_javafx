package ru.job4j.chess;

import org.junit.Before;
import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.white.BishopWhite;
import ru.job4j.chess.firuges.white.PawnWhite;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class LogicTest {
    Logic logic;

    @Before
    public void setup() {
        logic = new Logic();
    }

    @Test
    public void WhenMoveSuccessfully()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        logic.add(new BishopWhite(Cell.C1));
        assertThat(logic.move(Cell.C1, Cell.H6), is(true));
    }

    @Test(expected = OccupiedCellException.class)
    public void WhenCellOccupiedThenOccupiedCellException()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
       logic.add(new BishopWhite(Cell.C1));
       logic.add(new PawnWhite(Cell.F4));
       logic.move(Cell.C1, Cell.H6);
    }

    @Test(expected = FigureNotFoundException.class)
    public void WhenNotFigureThenFigureNotFoundException()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        logic.move(Cell.C1, Cell.H6);
    }

    @Test(expected = ImpossibleMoveException.class)
    public void WhenWrongMoveThenImpossibleMoveException()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        logic.add(new BishopWhite(Cell.C1));
        logic.move(Cell.C1, Cell.D3);
    }
}