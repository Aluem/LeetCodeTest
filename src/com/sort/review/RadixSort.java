package com.sort.review;

import java.util.Arrays;

public class RadixSort {

    public static void main(String[] args) {
        int arr[] = { 53, 3, 542, 748, 14, 214 };
        radixSort(arr);
        System.out.println("基数排序后 " + Arrays.toString(arr));

        System.out.println("123".substring(0, 1));
    }

    //桶排序
    public static void radixSort(int[] arr) {
        //获取到数组的最大元素
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[0]) {
                max = arr[i];
            }
        }
        //获取最大元素最高位数
        int length = (max + "").length();
        //定义一个二维数组表示十个桶
        int[][] bucket = new int[10][arr.length];
        //定义一个数组记录每个桶的元素个数
        int[] bucketElementCounts = new int[10];
        //桶排序
        for (int i = 0, n = 1; i < length; i++) {
            //遍历数组,将元素放入桶中
            for (int j = 0; j < arr.length; j++) {
                //获取到对应的数 （个位数、十位数...） 154
                int a = arr[j] / n % 10;
                //放到对应的桶中
                bucket[a][bucketElementCounts[a]] = arr[j];
                //对应的桶元素个数增加
                bucketElementCounts[a]++;
            }
            //将每个桶的元素按序放回数组
            int index = 0;
            for (int j = 0; j < 10; j++) { //第几个桶
                for (int k = 0; k < bucketElementCounts[j]; k++) { //第几个元素
                    arr[index++] = bucket[j][k];
                }
                //重置当前桶的元素个数
                bucketElementCounts[j] = 0;
            }
            //位数上升
            n = n * 10;
        }
    }
}
