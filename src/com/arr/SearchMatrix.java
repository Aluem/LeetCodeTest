package com.arr;

import java.util.ArrayList;
import java.util.List;

//240. 搜索二维矩阵 II
public class SearchMatrix {
    /*
    方法二：二分法搜索
    矩阵已经排过序，就需要使用二分法搜索以加快我们的算法。

    算法：
    首先，我们确保矩阵不为空。那么，如果我们迭代矩阵对角线，从当前元素对列和行搜索，我们可以保持从当前 (row,col) 对开始的行和列为已排序。
     因此，我们总是可以二分搜索这些行和列切片。我们以如下逻辑的方式进行 : 在对角线上迭代，二分搜索行和列，直到对角线的迭代元素用完为止（意味着我们可以返回 false ）
     或者找到目标（意味着我们可以返回 true ）。binary search 函数的工作原理和普通的二分搜索一样,但需要同时搜索二维数组的行和列。

     */
    public static void main(String[] args) {
//        System.out.println(new SearchMatrix().binarySearch(new int[]{1, 3, 7, 9, 15}, 0, 4, 18));
    }



    //官方：方法四
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length - 1;
        int col = 0;
        while (row >= 0 && col < matrix[0].length) {
            if (matrix[row][col] == target) return true;
            if (matrix[row][col] > target) {
                row--;
            } else if (matrix[row][col] < target) {
                col++;
            }
        }
        return false;
    }

    //行二分查找+列二分查找
    /*
        统计满足一下需求的行
            第0列比待查找值小
            最后一列比待查找值大
        然后二分查找所有满足的行
     */
//    public boolean searchMatrix(int[][] matrix, int target) {
//        int colLength = matrix[0].length;
//        //遍历所有列，查找满足需求的列,并存入arraylist
//        List<Integer> list = new ArrayList<>();
//        for (int i = 0; i < matrix.length; i++) {
//            if (matrix[i][0] <= target && matrix[i][colLength - 1] >= target) {
//                list.add(i);
//            }
//        }
//        //对每个满足的链表进行二分查找
//        for (Integer i : list) {
//            boolean b = binarySearch(matrix[i], 0, colLength - 1, target);
//            if (b) return true;
//        }
//        return false;
//    }
//
//    public boolean binarySearch(int[] arr, int l, int r, int target) {
//        if (l > r) return false;
//        int medianVal = l + (r - l) / 2;
//        if (arr[medianVal] == target) {
//            return  true;
//        } else if (target < arr[medianVal]) {
//            return binarySearch(arr, l, medianVal - 1, target);
//        } else {
//            return binarySearch(arr, medianVal + 1, r, target);
//        }
//    }
}
