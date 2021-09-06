package com.string;

//409. 最长回文串
public class LongestPalindrome {

    public static void main(String[] args) {
        System.out.println((int)'A');
        System.out.println((int)'z');
        System.out.println(longestPalindrome("aaaAaaaa"));
    }
    /*
        解题思路：
            找出每个字符的最大偶数
            判断每个字符的最大偶数和n 与 字符串长度l
                1.n == l 则最长回文串是n
                2.n < l  则最长回文串是n + 1
     */
    public static int longestPalindrome(String s) {
        int[] t = new int[58];
        int n = 0;
        int l = s.length();
        for (int i = 0; i < l; i++) {
                t[s.charAt(i) - 'A']++;
        }
        for (int i = 0; i < 58; i++) {
            t[i] = t[i] / 2 * 2;
            n += t[i];
        }
        if (n == l) return n;
        return n + 1;
    }
}
