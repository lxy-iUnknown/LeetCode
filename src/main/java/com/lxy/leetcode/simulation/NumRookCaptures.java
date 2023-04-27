package com.lxy.leetcode.simulation;

/**
 * <a href="https://leetcode.cn/problems/available-captures-for-rook/">可以被一步捕获的棋子数</a>
 */
public class NumRookCaptures {
    private static final int BOARD_SIZE = 8;

    private static int searchLeftward(char[] rookRows, int rookColumn, int count) {
        int column = rookColumn;
        exit:
        while (column >= 0) {
            switch (rookRows[column]) {
                case 'p' -> {
                    count++;
                    break exit;
                }
                case 'B' -> {
                    break exit;
                }
                default -> column--;
            }
        }
        return count;
    }

    private static int searchRightward(char[] rookRows, int rookColumn, int count) {
        int column = rookColumn;
        exit:
        while (column < BOARD_SIZE) {
            switch (rookRows[column]) {
                case 'p' -> {
                    count++;
                    break exit;
                }
                case 'B' -> {
                    break exit;
                }
                default -> column++;
            }
        }
        return count;
    }

    private static int searchUpward(char[][] board, int rookRow, int rookColumn, int count) {
        int row = rookRow;
        exit:
        while (row >= 0) {
            switch (board[row][rookColumn]) {
                case 'p' -> {
                    count++;
                    break exit;
                }
                case 'B' -> {
                    break exit;
                }
                default -> row--;
            }
        }
        return count;
    }

    private static int searchDownward(char[][] board, int rookRow, int rookColumn, int count) {
        int row = rookRow;
        exit:
        while (row < BOARD_SIZE) {
            switch (board[row][rookColumn]) {
                case 'p' -> {
                    count++;
                    break exit;
                }
                case 'B' -> {
                    break exit;
                }
                default -> row++;
            }
        }
        return count;
    }

    private static int search(char[][] board, int row, int column,
                              int deltaX, int deltaY, int count) {
        for (int step = 0; ; step++) {
            int newRow = row + deltaX * step;
            int newColumn = column + deltaY * step;
            if (newRow < 0 || newRow >= BOARD_SIZE ||
                    newColumn < 0 || newColumn >= BOARD_SIZE ||
                    board[newRow][newColumn] == 'B') {
                break;
            } else if (board[newRow][newColumn] == 'p') {
                count++;
                break;
            }
        }
        return count;
    }
    public static int numRookCaptures(char[][] board) {
        int count = 0;
        int row, column = -1;
        // Find rook position
        outer:
        for (row = 0; row < BOARD_SIZE; row++) {
            for (column = 0; column < BOARD_SIZE; column++) {
                if (board[row][column] == 'R') {
                    break outer;
                }
            }
        }
        // Search in four directions
        char[] rookRow = board[row];
        count = searchLeftward(rookRow, column, count);
        count = searchRightward(rookRow, column, count);
        count = searchUpward(board, row, column, count);
        count = searchDownward(board, row, column, count);
        return count;
    }

    // 把四个方向上的代码统一起来，便于扩展
    public static int numRookCapturesExtension(char[][] board) {
        int count = 0;
        int row, column = -1;
        // Find rook position
        outer:
        for (row = 0; row < BOARD_SIZE; row++) {
            for (column = 0; column < BOARD_SIZE; column++) {
                if (board[row][column] == 'R') {
                    break outer;
                }
            }
        }
        // Search upward
        count = search(board, row, column, 0, -1, count);
        // Search downward
        count = search(board, row, column, 0, 1, count);
        // Search leftward
        count = search(board, row, column, -1, 0, count);
        // Search rightward
        count = search(board, row, column, 1, 0, count);
        return count;
    }
}
