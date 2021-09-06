package com.search.bfs;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

//1091. 二进制矩阵中的最短路径
public class ShortestPathBinaryMatrix {
    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {0, 0, 0},
                {1, 1, 0},
                {1, 1, 0}
        };
        System.out.println(shortestPathBinaryMatrix(grid));
    }

    public static int shortestPathBinaryMatrix(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return -1;
        }
        if (grid[0][0] == 1) return -1;

        int[][] direction = {{1, -1}, {1, 0}, {1, 1}, {0, -1}, {0, 1}, {-1, -1}, {-1, 0}, {-1, 1}};
        int m = grid.length, n = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        grid[0][0] = 1;
        int path = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int[] cur = queue.poll();
                int x = cur[0];
                int y = cur[1];

                if (x == m-1 && y == n-1){    //
                    return path;
                }

                for (int[] d : direction) {
                    int x1 = x + d[0], y1 = y + d[1];

                    if (x1 < 0 || x1 >= m || y1 >= n || y1 < 0 || grid[x1][y1] == 1) {
                        continue;
                    }
                    grid[x1][y1] = 1; //标记已经访问
                    queue.add(new int[]{x1, y1});
                }
            }
            path++;
        }
        return -1;
    }

}
