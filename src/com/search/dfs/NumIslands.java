package com.search.dfs;

//200. 岛屿数量
public class NumIslands {
    public int numIslands(char[][] grid) {
        int cnt = 0;
        int[][] direction = {{0, -1}, {-1,0}, {0, 1}, {1, 0}};
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    cnt++;
                    dfs(i, j, grid, direction);
                }
            }
        }
        return cnt;
    }

    private void dfs(int row, int col, char[][] grid, int[][] direction) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length
                || grid[row][col] == '0') {
            return;
        }
        grid[row][col] = '0';
        for (int i = 0; i < 4; i++) {
            int nextRow = row + direction[i][0];
            int nextCol = col + direction[i][1];
            dfs(nextRow, nextCol, grid, direction);
        }
    }
}
