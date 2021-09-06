package com.arr;

//378. 有序矩阵中第 K 小的元素
public class KthSmallest {
    //二分法
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int left = matrix[0][0];
        int right = matrix[n - 1][n - 1];
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (check(matrix, mid, k)) { //mid
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    //左边的数量若>=k 则返回true 表示<=mid值的数超过k个
    public boolean check(int[][] matrix, int mid, int k) {
        int i = matrix.length - 1;
        int j = 0;
        int cnt = 0;
        while (i >= 0 && j < matrix.length) {
            if (matrix[i][j] <= mid) {
                cnt += i + 1;
                j++;
            } else {
                i--;
            }
        }
        return cnt >= k;
    }
}
