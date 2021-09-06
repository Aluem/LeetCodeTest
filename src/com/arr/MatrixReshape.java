package com.arr;

//566. 重塑矩阵
public class MatrixReshape {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int len =  mat.length * mat[0].length;
        //给定参数不合理
        if (r * c != len) return mat;
        //参数合理
        int[][] ans = new int[r][c];
        int i = 0;
        while (i < len) {
            ans[i/c][i%c] = mat[i/mat[0].length][i%mat[0].length];
            i++;
        }
        return ans;
    }
}
