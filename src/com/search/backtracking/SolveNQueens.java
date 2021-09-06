package com.search.backtracking;

import java.util.*;

//51. N 皇后
public class SolveNQueens {
    public static void main(String[] args) {
        SolveNQueens solveNQueens = new SolveNQueens();
        List<List<String>> lists = solveNQueens.solveNQueens(4);
        System.out.println(lists);
    }

    private boolean[] rowUsed;
    private boolean[] colUsed;
    private boolean[] diaUsedF; //左上到右下斜线
    private boolean[] diaUsedS; //左上到右下斜线
    private List<List<String>> ans = new LinkedList<>();
    public List<List<String>> solveNQueens(int n) {
        rowUsed = new boolean[n];
        colUsed = new boolean[n];
        diaUsedF = new boolean[2 * n - 1];
        diaUsedS = new boolean[2 * n - 1];
        StringBuilder[] boards = new StringBuilder[n];
        for (int i = 0; i < boards.length; i++) {
            boards[i] = new StringBuilder();
            for (int j = 0; j < n; j++) {
                boards[i].append(".");
            }
        }
        backtracking(0, n, boards);
        return ans;
    }

    private void backtracking(int row, int n, StringBuilder[] sb) {
        if (row == n) {
            List<StringBuilder> list = Arrays.asList(sb);
            ArrayList<String> ansList = new ArrayList<>();
            for (int i = 0; i < list.size(); i++) {
                ansList.add(list.get(i).toString());
            }
            ans.add(ansList);
            return;
        }
        //循环当前行，遍历所有能放的位置
        for (int j = 0; j < n; j++) {
            if (colUsed[j] || diaUsedF[row + j] || diaUsedS[n - row + j - 1]) continue;
            sb[row].setCharAt(j, 'Q');
            // 设当前行、列、斜线为已使用
            rowUsed[row] = colUsed[j] = diaUsedF[row + j] = diaUsedS[n - row + j - 1] = true;
            backtracking(row + 1, n, sb);
            rowUsed[row] = colUsed[j] = diaUsedF[row + j] = diaUsedS[n - row + j - 1] = false;
            sb[row].setCharAt(j, '.');
        }
    }
}
