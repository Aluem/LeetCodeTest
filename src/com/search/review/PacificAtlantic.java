package com.search.review;

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

    private int m;
    private int n;
    private int[][] heights;
    private int[][] dir = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res = new LinkedList<>();
        if (heights == null || heights.length == 0) return res;
        m = heights.length;
        n = heights[0].length;
        this.heights = heights;
        boolean[][] pacLU = new boolean[m][n];//左上
        boolean[][] pacRU = new boolean[m][n];//右下
        //上边与下边
        for (int i = 0; i < n; i++) {
                dfs(0, i, pacLU);//上
                dfs(m - 1, i, pacRU);//下
        }

        //左边与右边
        for (int i = 0; i < m; i++) {
                dfs(i, 0, pacLU);//左
                dfs(i, n - 1, pacRU);//右
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacLU[i][j] && pacRU[i][j]) {
                    res.add(Arrays.asList(i, j));
                }
            }
        }

        return res;
    }

    //深度优先搜索，将大于边的元素设置为true
    public void dfs(int r, int c, boolean[][] pac) {
        if (pac[r][c]) {
            return;
        }
        pac[r][c] = true;
        for (int[] d : dir) {
            int nR = r + d[0];
            int nC = c + d[1];
            if (nR < 0 || nR >= m || nC < 0 || nC >= n || heights[r][c] > heights[nR][nC]) {
                continue;
            }
            dfs(nR, nC, pac);
        }
    }
}
