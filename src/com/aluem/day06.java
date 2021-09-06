package com.aluem;

import java.util.Arrays;

public class day06 {
    public static void main(String[] args) {
//        int[] numbers = {-2, -4, 7, 11, 15, 17, 21, 67};
        int[] numbers = {-1, 0};
//        int[] numbers = {2,3,4};
        day06 day06 = new day06();
        int[] ints = day06.twoSum(numbers, -1);
        System.out.println(Arrays.toString(ints));
    }

    /* 双指针 */
    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[] {-1, -1};
        int left = 0;
        int right = numbers.length - 1;
        int temp;
        while (left < right) {
            temp = numbers[left] + numbers[right];
            if (temp < target) {
                left++;
            } else if (temp > target) {
                right--;
            } else {
                res[0] = left + 1;
                res[1] = right + 1;
                return res;
            }
        }
        return res;
    }


    /*二分法*/
//    public int[] twoSum(int[] numbers, int target) {
//        int[] res = new int[2];
//        int left, mid;
//        int right = numbers.length - 1;
//        for (int i = 0; i < numbers.length; i++) {
//            left = i + 1;
//            while (left <= right) {
//                mid = left + (right - left) / 2;
//                if (numbers[mid] + numbers[i] == target) {
//                    res[0] = i + 1;
//                    res[1] = mid + 1;
//                    return res;
//                } else if (numbers[mid] + numbers[i]  < target) {
//                    left = mid + 1;
//                } else {
//                    right = mid - 1;
//                }
//            }
//        }
//        return res;
//    }

    /*暴力解法*/
//    public int[] twoSum(int[] numbers, int target) {
//        int[] res = new int[2];
//        for (int i = 0; i < numbers.length; i++) {
//            for (int j = i + 1; j < numbers.length; j++) {
//                if (numbers[i] + numbers[j] == target) {
//                    res[0] = i + 1;
//                    res[1] = j + 1;
//                    return res;
//                }
//            }
//        }
//        return res;
//    }
}