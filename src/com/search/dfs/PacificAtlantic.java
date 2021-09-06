package com.search.dfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//417. 太平洋大西洋水流问题
public class PacificAtlantic {

    public static void main(String[] args) {
        int[][] heights = {
                {1, 2, 2, 3, 5},
                {3, 2, 3, 4, 4},
                {2, 4, 5, 3, 1},
                {6, 7, 1, 4, 5},
                {5, 1, 1, 2, 4}
        };
        PacificAtlantic pacificAtlantic = new PacificAtlantic();
        List<List<Integer>> lists = pacificAtlantic.pacificAtlantic(heights);
        System.out.println(lists);
    }

//    private int m, n;
//    private int[][] matrix;
//    private int[][] direction = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
//
//    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
//        List<List<Integer>> ret = new ArrayList<>();
//        if (matrix == null || matrix.length == 0) {
//            return ret;
//        }
//
//        m = matrix.length;
//        n = matrix[0].length;
//        this.matrix = matrix;
//        boolean[][] canReachP = new boolean[m][n];
//        boolean[][] canReachA = new boolean[m][n];
//
//        for (int i = 0; i < m; i++) {
//            dfs(i, 0, canReachP);
//            dfs(i, n - 1, canReachA);
//        }
//        for (int i = 0; i < n; i++) {
//            dfs(0, i, canReachP);
//            dfs(m - 1, i, canReachA);
//        }
//
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                if (canReachP[i][j] && canReachA[i][j]) {
//                    ret.add(Arrays.asList(i, j));
//                }
//            }
//        }
//
//        return ret;
//    }
//
//    private void dfs(int r, int c, boolean[][] canReach) {
//        if (canReach[r][c]) {
//            return;
//        }
//        canReach[r][c] = true;
//        for (int[] d : direction) {
//            int nextR = d[0] + r;
//            int nextC = d[1] + c;
//            if (nextR < 0 || nextR >= m || nextC < 0 || nextC >= n
//                    || matrix[r][c] > matrix[nextR][nextC]) {
//                continue;
//            }
//            dfs(nextR, nextC, canReach);
//        }
//    }


    private int m;
    private int n;
    private int[][] direction = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        m = heights.length;
        n = heights[0].length;
        //拷贝一个副本
        int[][] heightsBackup = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                heightsBackup[i][j] = heights[i][j];
            }
        }

        for (int i = 0; i < m; i++) {//遍历所有行
            //左边
            dfs(i, 0, heights);
            //右边
            dfs(i, n - 1, heightsBackup);
        }

        // 能够到达上边和下边的点
        for (int i = 0; i < n; i++) {
            //上边
            dfs(0, i, heights);
            //下边
            dfs(m - 1, i, heightsBackup);
        }

        List<List<Integer>> result = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (heights[i][j] == -1 && heightsBackup[i][j] == -1) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }
        return result;
    }

    public void dfs(int row, int col, int[][] heights) {
        if (heights[row][col] == -1) {
            return;
        }
        int curV = heights[row][col];
        heights[row][col] = -1;
        for (int[] d : direction) {
            int nextR = row + d[0];
            int nextC = col + d[1];
            if (nextR < 0 || nextR >= m || nextC < 0 || nextC >= n ||
                    heights[nextR][nextC] < curV) {
                continue;
            }
            dfs(nextR, nextC, heights);
        }
    }
}
