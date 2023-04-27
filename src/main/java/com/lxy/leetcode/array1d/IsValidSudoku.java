package com.lxy.leetcode.array1d;

/**
 * <a href="https://leetcode.cn/problems/valid-sudoku/">有效的数独</a>
 */
public class IsValidSudoku {

    private static boolean isValidRow(char[][] board, int row) {
        boolean[] counter = new boolean[9];
        for (int column = 0; column < 9; column++) {
            // '1' ~ '9' = 48 ~ 57
            // '.' = 46
            char value = (char) (board[row][column] - '1');
            if (value <= 8) {
                if (counter[value]) {
                    return false;
                } else {
                    counter[value] = true;
                }
            }
        }
        return true;
    }

    private static boolean isValidColumn(char[][] board, int column) {
        boolean[] counter = new boolean[9];
        for (int row = 0; row < 9; row++) {
            // '1' ~ '9' = 48 ~ 57
            // '.' = 46
            char value = (char) (board[row][column] - '1');
            if (value <= 8) {
                if (counter[value]) {
                    return false;
                } else {
                    counter[value] = true;
                }
            }
        }
        return true;
    }

    private static boolean isValidGrid(char[][] board, int startRow, int startColumn) {
        boolean[] counter = new boolean[9];
        for (int row = 0; row < 3; row++) {
            for (int column = 0; column < 3; column++) {
                // '1' ~ '9' = 48 ~ 57
                // '.' = 46
                char value = (char) (board[startRow + row][startColumn + column] - '1');
                if (value <= 8) {
                    if (counter[value]) {
                        return false;
                    } else {
                        counter[value] = true;
                    }
                }
            }
        }
        return true;
    }

    public static boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            if (!isValidRow(board, i)) {
                return false;
            }
        }
        for (int i = 0; i < 9; i++) {
            if (!isValidColumn(board, i)) {
                return false;
            }
        }
        for (int row = 0; row < 9; row += 3) {
            for (int column = 0; column < 9; column += 3) {
                if (!isValidGrid(board, row, column)) {
                    return false;
                }
            }
        }
        return true;
    }
}
