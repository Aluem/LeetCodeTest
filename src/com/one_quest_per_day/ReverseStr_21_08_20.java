package com.one_quest_per_day;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//541. 反转字符串 II
public class ReverseStr_21_08_20 {
    public static void main(String[] args) {
        ReverseStr_21_08_20 reverseStr_21_08_20 = new ReverseStr_21_08_20();
        System.out.println(reverseStr_21_08_20.reverseStr("abcdefghijk", 2));

    }

    public String reverseStr(String s, int k) {
        int n = s.length();
        char[] arr = s.toCharArray();
        for (int i = 0; i < n; i += 2 * k) {
            reverse(arr, i, Math.min(i + k - 1, n - 1));
        }
        return new String(arr);
    }
    
    private void reverse(char[] arr, int l, int r) {
        while (l < r) {
            char temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            l++;
            r--;
        }
    }
}
