package ru.job4j.chess.firuges.white;

import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

/**
 *
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class BishopWhite implements Figure {
    private final Cell position;

    public BishopWhite(final Cell ps) {
        position = ps;
    }

    @Override
    public Cell position() {
        return position;
    }

    @Override
    public Cell[] way(Cell start, Cell dest) throws ImpossibleMoveException {
        if (!isDiagonal(start, dest)) {
            throw new ImpossibleMoveException(
                    String.format("Could not move by diagonal from %s to %s", start, dest)
            );
        }
        int size = Math.abs(dest.getX() - start.getX());
        Cell[] steps = new Cell[size];
        int deltaX = (dest.getX() - start.getX()) < 0 ? - 1 : 1;
        int deltaY = (dest.getY() - start.getY()) < 0 ? - 1 : 1;;
        for(int index = 0; index < Math.abs(dest.getX() - start.getX()); index++) {
            steps[index] = Cell.findBy(start.getX() + (index + 1) * deltaX, start.getY() + (index + 1) * deltaY);
        }
        return steps;
    }

    public boolean isDiagonal(Cell start, Cell dest) {
        boolean result = false;
        if (Math.abs(dest.getX() - start.getX()) == Math.abs(dest.getY() - start.getY())) {
            result = true;
        }
        return result;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopWhite(dest);
    }
}
