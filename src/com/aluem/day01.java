package com.aluem;

/**
 * author aluem
 * day 2021-03-27
 *
 * 搜索二维矩阵
 *      先对所有行进行二分查找，即matrix[0~m][0],定位到某一行，然后再对该行所有列进行二分查找，定位到目标值
 *
 */
public class day01 {
    public static void main(String[] args) {
       int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
//       for (int i = 0; i < matrix.length; i++) {
//           for (int j = 0; j < matrix[0].length; j++) {
//               boolean b = searchMatrix(matrix, matrix[i][j]);
//               System.out.println(b);
//           }
//       }

       for (int i = 0; i < 100; i++) {
           boolean b = searchMatrix(matrix, i);
           System.out.println("目标值为：" + i + "结果为：" + b);
       }

    }
    /**
     * 搜索二维矩阵
     * 思路：
     *      先对所有行进行二分查找，即matrix[0~m][0],定位到某一行，然后再对该行所有列进行二分查找，定位到目标值
     * @param matrix m x n矩阵
     * @param target 要查找的目标
     * @return 判断矩阵中是否存在目标，存在返回true，不存在返回false
     */
    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) {
            return false;
        }
        int smallIndex = 0; //行最小索引
        int bigIndex = matrix.length - 1; //行最大索引
        int medianValue = 0; //中间值
        //1.定位到某一行
        while (smallIndex <= bigIndex) {
            medianValue = (smallIndex + bigIndex) / 2;
            if (target == matrix[medianValue][0]) { //找到
                return true;
            } else if (target > matrix[medianValue][0]) { //目标值大于中间行的值，向下继续查找
                smallIndex = medianValue + 1;
            } else { //目标值小于中间行的值，向下继续查找
                bigIndex = medianValue - 1;
            }
        }

        //到此未返回true则证明未找到目标值，最后目标值只可能在当前行
        //2.从该行寻找目标值
        int left = 0;
        int right = matrix[0].length - 1;
        int mid  = 0;

        //若目标值比最小值小，会导致数组越界
        if (bigIndex < 0) {
            return false;
        }

        while (left <= right) {
            mid = (left + right) / 2;
            if (target == matrix[bigIndex][mid]) {
                return true;
            } else if (target > matrix[bigIndex][mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}
