package com.search.dfs;

//695. 岛屿的最大面积
public class MaxAreaOfIsland {
//    private static int cnt = 0;
//
//    //1.dfs
//    public static int maxAreaOfIsland(int[][] grid) {
//        int res = 0;
//        //左、上、右、下
//        int[][] direction = {{0, -1}, {-1,0}, {0, 1}, {1, 0}};
//        for (int i = 0; i < grid.length; i++) {
//            for (int j = 0; j < grid[0].length; j++) {
//                //遇到岛屿时查看岛屿面积
//                cnt = 0;
//                if (grid[i][j] == 1) { //未访问过的岛屿
//                    //深度优先查找上下左右的岛屿
//                    dfs(i, j, direction, grid);
//                    res = Math.max(res, cnt);
//                }
//            }
//        }
//        return res;
//    }
//
//
//    private static void dfs(int row, int col, int[][] direction, int[][] grid) {
//        //当前岛屿面积
//        cnt++;
//        grid[row][col] = 0; //设置为已经访问
//        for (int i = 0; i < 4; i++) {
//            int[] point = direction[i];
//            int curRow = row + point[0];
//            int curCol = col + point[1];
//            if (curRow < 0 || curCol < 0 ||
//                    curRow >= grid.length ||
//                    curCol >= grid[0].length ||
//                    grid[curRow][curCol] == 0) {
//                continue;
//            }
//            dfs(curRow, curCol, direction, grid);
//        }
//    }

    public static void main(String[] args) {
        int[][] grid = {{0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                        {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                        {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}};
        System.out.println(maxAreaOfIsland(grid));
    }

    //1.dfs
    public static int maxAreaOfIsland(int[][] grid) {
        int res = 0;
        //左、上、右、下
        int[][] direction = {{0, -1}, {-1,0}, {0, 1}, {1, 0}};
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                //遇到岛屿时查看岛屿面积
                if (grid[i][j] == 1) { //未访问过的岛屿
                    //深度优先查找上下左右的岛屿
                    int area = dfs(i, j, direction, grid);
                    res = Math.max(res, area);
                }
            }
        }
        return res;
    }

    private static int dfs(int row, int col, int[][] direction, int[][] grid) {
        if (row < 0 || col < 0 ||
                row >= grid.length ||
                col >= grid[0].length ||
                grid[row][col] == 0) {
            return 0;
        }
        int cnt = 1;
        //当前岛屿面积
        grid[row][col] = 0; //设置为已经访问
        for (int i = 0; i < 4; i++) {
            int[] point = direction[i];
            int curRow = row + point[0];
            int curCol = col + point[1];
            cnt += dfs(curRow, curCol, direction, grid);
        }
        return cnt;
    }

//    private static int dfs(int row, int col, int[][] direction, int[][] grid) {
//        int cnt = 0;
//        //当前岛屿面积
//        grid[row][col] = 0; //设置为已经访问
//        for (int i = 0; i < 4; i++) {
//            int[] point = direction[i];
//            int curRow = row + point[0];
//            int curCol = col + point[1];
//            if (curRow < 0 || curCol < 0 ||
//                    curRow >= grid.length ||
//                    curCol >= grid[0].length ||
//                    grid[curRow][curCol] == 0) {
//                continue;
//            }
//            cnt += dfs(curRow, curCol, direction, grid) + 1;
//        }
//        return cnt;
//    }
}
