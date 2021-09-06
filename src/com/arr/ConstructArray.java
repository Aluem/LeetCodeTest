package com.arr;

import java.util.Arrays;

//667. 优美的排列 II
public class ConstructArray {

    public static void main(String[] args) {
        System.out.println((int)'1');
//        System.out.println(Arrays.toString(constructArray(3, 2)));
    }

    public static int[] constructArray(int n, int k) {
        int[] res = new int[n];
        //1.由于x个数能够构造的最长差数为x-1，因此需要留下x个数进行构造，
        //  要构造的差数为k，因此需要留下k+1个数，此处填充 n - k - 1个数
        // n = 3   k = 2
        for (int i = 0; i < n - k - 1; i++) {
            res[i] = i + 1;
        }
        //2.首尾交互填充，即可从k+1个数中构造k个不同的差
        int left = n - k;
        int right = n;
        int j = 0;
        for (int i = n - k - 1; i < n; i++) {
            if (j % 2 == 0) {
                res[i] = left;
                left++;
            } else {
                res[i] = right;
                right--;
            }
            j++;
        }
        return res;
    }
}
