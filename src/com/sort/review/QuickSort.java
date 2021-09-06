package com.sort.review;

import java.util.Arrays;
import java.util.Date;
import java.util.Random;

//快速排序
public class QuickSort {
    public static void main(String[] args) {
//        int length = 10;
//        int[] arr = new int[length];
//        Random random = new Random();
//
//        for (int j = 0; j < 10; j++) {
//            for (int i = 0; i < length; i++) {
//                arr[i] = random.nextInt(10);
//            }
//            System.out.println("原始数组：" + Arrays.toString(arr));
//
//            quickSort(arr);
//            System.out.println("排序后：" + Arrays.toString(arr));
//        }

        int length = 20000000;
        int[] arr = new int[length];
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            arr[i] = random.nextInt(99999);
        }

//        System.out.println("原始数组：" + Arrays.toString(arr));



        System.out.println(new Date());
//         System.out.println(Arrays.toString(arr));
//        int[] arr = new int[] {6, 1, 2, 7, 9, 3, 4, 5 ,10, 8};
//        int[] arr = new int[] {17, 91, 63, 38, 79, 45, 87, 49, 7, 45};
//        int[] arr = new int[] {17, 91, 63, 38, 79};
        //{17, 7, 63, 38, 79, 45, 87, 49, 91, 45};
        quickSort( arr);
//        System.out.println("排序后：" + Arrays.toString(arr));
        System.out.println(new Date());

    }


    public static void quickSort(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
    }

    public static void quickSort(int[] nums, int L, int R) {
        if (L < R) {
            int partition = partition(nums, L, R);
            quickSort(nums, L,partition);
            quickSort(nums, partition + 1, R);
        }
    }

    //排序，并获取标准值位置
    public static int partition(int[] nums, int l, int r) {
        int left = l, right = r;
        int pivot = nums[l];
        int pivotIndex = 0;
        while (left < right) {
            while (left < r && nums[left] <= pivot) {
                left++;
            }
            while (right > l && nums[right] >= pivot) {
                right--;
            }
            if (left < right && nums[left] != nums[right]) {
                swap(nums, left, right);
            }
            pivotIndex = Math.min(left, right);
            swap(nums, l, pivotIndex);
        }
        return pivotIndex;
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}
