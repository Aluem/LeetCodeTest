package com.search.dfs;

//547. 省份数量
public class FindCircleNum {
    public int findCircleNum(int[][] isConnected) {
        int cnt = 0;
        int[] isVisited = new int[isConnected.length];
        for (int cNum = 0; cNum < isConnected.length; cNum++) {
            if (isVisited[cNum] == 0) {//未访问过
                cnt++;
                dfs(cNum, isConnected, isVisited);
            }
        }
        return cnt;
    }

    private void dfs(int cNum, int[][] isConnected, int[] isVisited) {
        isVisited[cNum] = 1; //标记该城市已经访问过
        for (int col = 0; col < isConnected[0].length; col++) {
            if (isConnected[cNum][col] == 1 && isVisited[col] == 0) { //与当前城市连通
                isVisited[col] = 1; //标记为以访问
                dfs(col, isConnected, isVisited);
            }
        }
    }
}
