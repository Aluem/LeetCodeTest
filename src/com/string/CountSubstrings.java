package com.string;

//647. 回文子串
public class CountSubstrings {
    public static void main(String[] args) {
        System.out.println(new CountSubstrings().countSubstrings("abc"));
    }

    int ans = 0;
    //中心扩展
    public int countSubstrings(String s) {
        int len = s.length();
        for (int i = 0; i < len; i++) {
            extendSubstrings(s, i, i); //奇数长度
            extendSubstrings(s, i, i + 1);//偶数长度
        }
        return ans;
    }

    private void extendSubstrings(String s, int start, int end) {
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            start--;
            end++;
            ans++;
        }
    }

    /*
        解题思路：
            暴力判断每个字串
     */
//    public int countSubstrings(String s) {
//        int cnt = 0;
//        int l = s.length();
//        int left, right;
//        for (int i = 0; i < l; i++) {
//            for (int j = i; j < l; j++) {
//                //判断当前字符串是否是回文串
//                boolean flag = true;
//                left = i; right = j;
//                while (left < right) {
//                    if (s.charAt(left++) != s.charAt(right--)) {
//                        flag = false;
//                        break;
//                    }
//               }
//                if (flag) {
//                    cnt++;
//                }
//            }
//        }
//        return cnt;
//    }
}
