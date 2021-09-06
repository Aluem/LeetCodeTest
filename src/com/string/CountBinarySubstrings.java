package com.string;

import java.util.ArrayList;
import java.util.List;

public class CountBinarySubstrings {
    public static void main(String[] args) {
        System.out.println(new CountBinarySubstrings().countBinarySubstrings("00110011"));
    }

    //按字符分组
    public int countBinarySubstrings(String s) {
        int ans = 0;
        List<Integer> list = new ArrayList<>();
        int ptr = 0, n = s.length();
        while (ptr < n) {
            char c = s.charAt(ptr);
            int count = 0;
            while (ptr < n && s.charAt(ptr) == c) {
                ++ptr;
                ++count;
            }
            list.add(count);
        }
        for (int i = 0; i < list.size() - 1; i++) {
            ans += Math.min(list.get(i), list.get(i + 1));
        }
        return ans;
    }


    //暴力 超时
//    public int countBinarySubstrings(String s) {
//        int zeroCount = 0, oneCount = 0, ans = 0;
//        boolean zeroFlag = false, oneFlag = false;//判断是否是第一次遍历到目标值
//        for (int i = 0; i < s.length(); i++) {
//            int j = i;
//            while (j < s.length()) {
//                if (j > 0 && s.charAt(j) != s.charAt(j - 1) && oneFlag && zeroFlag) {
//                    break;
//                }
//                if (s.charAt(j) == '0') { //1 或者 0未访问过
//                    zeroCount++;
//                    zeroFlag = true;
//                }
//                if (s.charAt(j) == '1') {
//                    oneCount++;
//                    oneFlag = true;
//                }
//
//                if (zeroCount == oneCount) {
//                    ans++;
//                    break;
//                }
//                j++;
//            }
//            zeroCount = 0;
//            oneCount = 0;
//            zeroFlag = false;
//            oneFlag = false;
//        }
//        return ans;
//    }
}
