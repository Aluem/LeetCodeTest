package com.arr;

//766. 托普利茨矩阵
public class IsToeplitzMatrix {

    public static void main(String[] args) {
        int[][] matrix = new int[][] {{1,2,3,4},{5,1,2,3},{9,5,1,2}};
        isToeplitzMatrix(matrix);
    }

    //如果矩阵存储在磁盘上，并且内存有限，以至于一次最多只能将矩阵的一行加载到内存中
    public static boolean isToeplitzMatrix(int[][] matrix) {
        int[] nums = matrix[0];
        for (int i = 1; i < matrix.length; i++) { // i 1 2
            for (int j = matrix[0].length - 1; j > 0; j--) {
                if (matrix[i][j] != nums[j - 1]) {
                    return false;
                }
                nums[j] = matrix[i][j];
            }
            nums[0] = matrix[i][0];
        }
        return true;
    }

    //========================================================
//    public boolean isToeplitzMatrix(int[][] matrix) {
//        int row = matrix.length - 1;
//        int col = 0;
//        for (int i = 0; i < matrix.length + matrix[0].length - 1; i++) {
//            if (row > 0) { // 遍历 20 10 00 01 02 03
//                row--;
//            } else {
//                col++;
//            }
//            int tempRow = row;
//            int tempCol = col;
//            while (tempRow + 1 < matrix.length && tempCol + 1 < matrix[0].length) {
//                if (matrix[tempRow][tempCol] != matrix[tempRow + 1][tempCol + 1]) {
//                    return false;
//                }
//                tempRow++;
//                tempCol++;
//            }
//        }
//        return true;
//    }
}
