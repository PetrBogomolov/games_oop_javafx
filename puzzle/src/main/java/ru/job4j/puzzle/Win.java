package ru.job4j.puzzle;

public class Win {
    public static boolean check(int[][] board) {
        boolean result = false;
        for (int i = 0; i < board.length; i++) {
            int row = 0;
            int cell = 0;
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 1) {
                    row++;
                }
                if (board[j][i] == 1) {
                    cell++;
                }
                if (row == board.length || cell == board.length) {
                    result = true;
                    break;
                }
            }

        }
        return result;
    }
}
