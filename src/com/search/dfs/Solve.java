package com.search.dfs;

import java.util.Arrays;

//130. 被围绕的区域
public class Solve {
    public static void main(String[] args) {
        char[][] board = {{'O', 'O', 'O', 'O', 'X', 'X'},
                          {'O', 'O', 'O', 'O', 'O', 'O'},
                          {'O', 'X', 'O', 'X', 'O', 'O'},
                          {'O', 'X', 'O', 'O', 'X', 'O'},
                          {'O', 'X', 'O', 'X', 'O', 'O'},
                          {'O', 'X', 'O', 'O', 'O', 'O'}};
        solve(board);
        for (int i = 0; i < board.length; i++) {
            System.out.println(Arrays.toString(board[i]));
        }
    }

    private static int m;
    private static int n;

    //对O进行判断
    public static void solve(char[][] board) {
        int[][] direction = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

        m = board.length;
        n = board[0].length;

        for (int i = 0; i < m; i++) {
            dfs(i, 0, board, direction);
            dfs(i, n - 1, board, direction);
        }

        for (int i = 0; i < n; i++) {
            dfs(0, i, board, direction);
            dfs(m - 1, i, board, direction);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'T') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }


    }

    public static void dfs(int row, int col, char[][] board, int[][] direction) {
        if (row < 0 || row >= m || col < 0 || col >= n || board[row][col] != 'O') {
            return;
        }
        board[row][col] = 'T';
        for (int[] d : direction) {
            dfs(row + d[0], col + d[1], board, direction);
        }
    }
}