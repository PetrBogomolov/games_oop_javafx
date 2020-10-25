package ru.job4j.chess.firuges.black;

import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell ps) {
        position = ps;
    }

    @Override
    public Cell position() {
        return position;
    }

    @Override
    public Cell[] way(Cell start,Cell dest) throws ImpossibleMoveException {
        if (!isDiagonal(start, dest)) {
            throw new ImpossibleMoveException(
                    String.format("Could not move by diagonal from %s to %s", start, dest)
            );
        }
        int size = Math.abs(dest.getX() - start.getX());
        Cell[] steps = new Cell[size];
        int deltaX = (dest.getX() - start.getX()) < 0 ? - 1 : 1;
        int deltaY = (dest.getY() - start.getY()) < 0 ? - 1 : 1;;
        int x = start.getX();
        int y = start.getY();
        for(int index = 0; index < size; index++) {
            x += deltaX;
            y += deltaY;
            steps[index] = Cell.findBy(x, y);
        }
        return steps;
    }

    public boolean isDiagonal(Cell start, Cell dest) {
        return Math.abs(dest.getX() - start.getX()) == Math.abs(dest.getY() - start.getY());
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
