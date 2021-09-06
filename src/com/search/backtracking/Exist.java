package com.search.backtracking;

//79. 单词搜索
public class Exist {

    public static void main(String[] args) {
        char[][] board = {{'A','B','C','E'},
                          {'S','F','C','S'},
                          {'A','D','E','E'}};
        boolean see = new Exist().exist(board, "SEE");
        System.out.println(see);
    }

    //左上右下
    private int[][] direction = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
    private int m;
    private int n;
    boolean ans = false;
    boolean[][] isVisited;

    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0) return false;
        if (word == null || word.length() == 0) return true;
        m = board.length;
        n = board[0].length;
        isVisited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0) && !ans) {
                    dfs(i, j, board, word, 0);
                }
            }
        }
        return ans;
    }

    public void dfs(int r, int c, char[][] board, String word, int p) {
        if (p == word.length()) {
            ans = true;
            return;
        }
        if (r < 0 || r >= m || c < 0 || c >= n || isVisited[r][c] || board[r][c] != word.charAt(p)) {
            return;
        }
        isVisited[r][c] = true;
        for (int[] d : direction) { //访问四周
            int nR = r + d[0];
            int nC = c + d[1];
            dfs(nR, nC, board, word, p + 1);
        }
        //四周都不行 回溯
        isVisited[r][c] = false;
    }
}
