package com.dynamic_programming.matrix_path;

//64. 最小路径和
public class MinPathSum {
    public int minPathSum(int[][] grid) {
        int preLeft = 0, preUp = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                preLeft = preUp = Integer.MAX_VALUE;
                if (i == 0 && j == 0) continue;
                if (i - 1 >= 0) {
                    preUp = grid[i - 1][j];
                }
                if (j - 1 >= 0) {
                    preLeft = grid[i][j - 1];
                }
                grid[i][j] += Math.min(preLeft, preUp);
            }
        }
        return grid[grid.length - 1][grid[0].length - 1];
    }
}
