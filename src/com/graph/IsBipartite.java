package com.graph;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

//785. 判断二分图
public class IsBipartite {

    //==================bfs==================================
    private static final int UNCOLORED = 0;
    private static final int RED = 1;
    private static final int GREEN = 2;
    private int[] color;
    private boolean valid;

    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        valid = true;
        color = new int[n];
        Arrays.fill(color, UNCOLORED);
        Deque<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n && valid; i++) { //处理不连通
            if (color[i] == UNCOLORED) { //未访问过表示不与前面的结点连通
                queue.offer(i);
                color[i] = RED;
                while (!queue.isEmpty() && valid) { //使用队列辅助广度优先遍历
                    Integer node = queue.poll(); //弹出一个结点，访问其邻接结点
                    int cNei = color[node] == RED ? GREEN : RED; //要求邻接结点的颜色
                    for (Integer neighbor : graph[node]) {
                        //若邻接结点未上色，则上色,未上色表明未访问过，加入队列
                        if (color[neighbor] == UNCOLORED) {
                            color[neighbor] = cNei;
                            queue.offer(neighbor);
                        } else { //若已经上色，则必须为要求的颜色
                            if (color[neighbor] != cNei) {
                                valid = false;
                            }
                        }
                    }
                }
            }
        }
        return valid;
    }

    //==================dfs==================================

//    public static void main(String[] args) {
//        int[][] graph = new int[4][];
////        graph[0] = new int[] {1, 2, 3};
////        graph[1] = new int[] {0, 2};
////        graph[2] = new int[] {0, 1, 3};
////        graph[3] = new int[] {0, 2};
//
//        graph[0] = new int[] {1};
//        graph[1] = new int[] {0, 3};
//        graph[2] = new int[] {3};
//        graph[3] = new int[] {1, 2};
//
//        System.out.println(new IsBipartite().isBipartite(graph));
//    }
//
//    private static final int UNCOLORED = 0;
//    private static final int RED = 1;
//    private static final int GREEN = 2;
//    private int[] color;
//    private boolean valid;
//
//    public boolean isBipartite(int[][] graph) {
//        int n = graph.length;
//        valid = true;
//        color = new int[n];
//        Arrays.fill(color, UNCOLORED);
//        for (int i = 0; i < n && valid; ++i) {
//            if (color[i] == UNCOLORED) {
//                dfs(i, RED, graph);
//            }
//        }
//        return valid;
//    }
//
//    public void dfs(int node, int c, int[][] graph) {
//        color[node] = c;
//        int cNei = c == RED ? GREEN : RED; //邻接点的颜色
//        for (int neighbor : graph[node]) {
//            if (color[neighbor] == UNCOLORED) {
//                color[neighbor] = cNei;
//                dfs(neighbor, cNei, graph);
//            } else {
//                if (color[neighbor] == c) {
//                    valid = false;
//                }
//            }
//        }
//    }



    //===============错误==============================

//    private static final int UNCOLORED = 0;
//    private static final int RED = 1;
//    private static final int GREEN = 2;
//    private int[] color;
//    private boolean valid;
//
//    public boolean isBipartite(int[][] graph) {
//        //深度优先遍历
//        return dfs(graph);
//    }
//    public static void main(String[] args) {
//        int[][] graph = new int[5][];
////        graph[0] = new int[] {1, 2, 3};
////        graph[1] = new int[] {0, 2};
////        graph[2] = new int[] {0, 1, 3};
////        graph[3] = new int[] {0, 2};
//
//        graph[0] = new int[] {3,4};
//        graph[1] = new int[] {2,4};
//        graph[2] = new int[] {1,3,4};
//        graph[3] = new int[] {0,2,4};
//        graph[4] = new int[] {0,1,2,3};
//        new IsBipartite().dfs(graph);
//    }
//    private int[] isVisited;
//
//    /**
//     * @param index 节点下标
//     * @param graph 邻接矩阵
//     */
//    public boolean dfs(int index, int[][] graph) {
//        if (isVisited[index] != 1) {
//            System.out.println(index + " ");
//            isVisited[index] = 1;
//        }
//        boolean flag = true;
//        boolean flagOther = true;
//        for (int i = 0; i < graph[index].length; i++) { //当前结点可达结点
//            //如果相邻结点没有颜色，添加颜色
//            if (color[graph[index][i]] == UNCOLORED) {
//                color[graph[index][i]] = color[index] == GREEN ? RED : GREEN;
//            } else if (color[index] == color[graph[index][i]]) {//与相邻结点颜色一致
//                flag = false;
//            }
//            if (isVisited[graph[index][i]] != 1) {
//                flagOther = dfs(graph[index][i], graph);
//            }
//        }
//        return flag && flagOther;
//    }
//
//    public boolean dfs(int[][] graph) {
//        isVisited = new int[graph.length];
//        color = new int[graph.length];
//        for (int i = 0; i < graph.length; i++) {
//            isVisited[i] = 0;
//            color[i] = UNCOLORED;
//        }
//        boolean flag = true;
//        for (int i = 0; i < graph.length; i++) {
//            if (isVisited[i] != 1) {
//                color[i] = GREEN;
//                flag = dfs(i, graph);
//                if (!flag) {
//                    return false;
//                }
//            }
//        }
//        return true;
//    }



//=========================================================
    /*
        private int[] isVisited;


    public void dfs(int index, int[][] graph) {
        if (isVisited[index] != 1) {
            System.out.println(index + " ");
            isVisited[index] = 1;
        }
        for (int i = 0; i < graph[index].length; i++) { //当前结点可达结点
            if (isVisited[graph[index][i]] != 1) {
                dfs(graph[index][i], graph);
            }
        }
    }

    public void dfs(int[][] graph) {
        isVisited = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (isVisited[i] != 1) {
                dfs(i, graph);
            }
        }
    }
     */
}
