package com.aluem;

import java.util.Arrays;
import java.util.Random;

public class day13 {
    public static void main(String[] args) {
//        int[] nums = {3, 2, 1, 5, 6, 4, 4, 4};
//        int[] nums = {3,2,1,5,6,4};
        int[] nums = {3,2,3,1,2,4,5,5,6};
        int k  = 5;
        day13 day13 = new day13();
        day13.quickSort(nums, 0 , nums.length - 1);
        System.out.println("排序后：");
        System.out.println(Arrays.toString(nums));
        System.out.println("第" + k + "个最大的元素为：" + nums[k - 1]);

        System.out.println("方法二");
        System.out.println("第" + k + "个最大的元素为：" + day13.quickSelect(nums, 0, nums.length -1, k - 1));

        //==============================================================================================================
//        int length = 1000000;
////        int length = 10;
//        int[] arr = new int[length];
//        Random random = new Random();
//
//        day13 day13 = new day13();
//        for (int i = 0; i < length; i++) {
//            arr[i] = random.nextInt(10);
////            arr[i] = random.nextInt(10);
//        }
//        long startTime = System.currentTimeMillis();
//        day13.quickSort(arr, 0, arr.length - 1);
//        long endTime = System.currentTimeMillis();    //获取结束时间
//        System.out.println("总用时：" + (endTime - startTime) + "ms");
////        System.out.println(Arrays.toString(arr));
        //==============================================================================================================
//        int length = 10;
//        int[] arr = new int[length];
//        Random random = new Random();
//        day13 day13 = new day13();
//
//        for (int j = 0; j < 10; j++) {
//            for (int i = 0; i < length; i++) {
//                arr[i] = random.nextInt(10);
//            }
//            System.out.println("原始数组：" + Arrays.toString(arr));
//            day13.quickSort(arr, 0, arr.length - 1);
//            System.out.println("排序后：" + Arrays.toString(arr));
//            boolean flag = true;
//            for (int i = 0; i < length-1; i++) {
//                if (arr[i] < arr[i+1]) {
//                    flag = false;
//                }
//            }
//            System.out.println("排序正确性：" + flag);
//        }

    }

    /**
     * 找到第k个最大的元素 第一个数nums[length-1] 第二个数为nums[length-2]
     */
    public int findKthLargest(int[] nums, int k) {
        return nums[nums.length - k];
    }

    /**
     * 判断是否有序
     */
    public boolean isSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                return false;
            }
        }
        return true;
    }

    /**
     * 快速排序
     */
    public void quickSort(int[] nums, int l, int r) {
//        int temp;
//        int left = l;
//        int right = r;
//        if (l >= r) {
//            return;
//        }
//        int pivot = nums[(l + r) / 2];
//        while (l < r) {
//            while (nums[l] < pivot) {
//                l++;
//            }
//            while (nums[r] > pivot) {
//                r--;
//            }
//            if (l < r) {
//                temp = nums[l];
//                nums[l] = nums[r];
//                nums[r] = temp;
//            }
//            if (nums[l] == pivot && nums[r] == pivot && l != r) {
//                r--;
//            }
//        }
//        quickSort(nums, left, r - 1);
//        quickSort(nums, r + 1, right);

        //降序
        int temp;
        int left = l;
        int right = r;
        if (l >= r) {
            return;
        }
        int pivot = nums[(l + r) / 2];
        while (l < r) {
            while (nums[l] > pivot) {
                l++;
            }
            while (nums[r] < pivot) {
                r--;
            }
            if (l < r) {
                temp = nums[l];
                nums[l] = nums[r];
                nums[r] = temp;
            }
            if (nums[l] == pivot && nums[r] == pivot && l != r) {
                l++;
            }
        }
        quickSort(nums, left, r - 1);
        quickSort(nums, r + 1, right);
    }

    /**
     * 快速选择
     */
    public int quickSelect(int[] nums, int l, int r, int k) {
        int temp;
        int left = l;
        int right = r;

        int pivot = nums[(l + r) / 2];
        while (l < r) {
            while (nums[l] > pivot) {
                l++;
            }
            while (nums[r] < pivot) {
                r--;
            }
            if (l < r) {
                temp = nums[l];
                nums[l] = nums[r];
                nums[r] = temp;
            }
            if (nums[l] == pivot && nums[r] == pivot && l != r) {
                l++;
            }
        }

        if (k == r) {
            return nums[k];
        } else if (k < r) { //从左边排序查找
            return quickSelect(nums, left, r - 1, k);
        } else {
            return quickSelect(nums, r + 1, right, k);
        }
    }

}
