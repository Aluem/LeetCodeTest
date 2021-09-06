package com.aluem;

public class day09 {
    public static void main(String[] args) {
        day09 day09 = new day09();
//        boolean flag = day09.validPalindrome("abca");
//        boolean flag = day09.validPalindrome("eedede");
        boolean flag = day09.validPalindrome("cbbcc");
        System.out.println(flag);
    }

    /**
     * 当有两个字符不相同时尝试删除前面的和后面的，最后做出判断
     * 时间复杂度 O(2n) 空间复杂度O(1)
     * @param s
     * @return
     */
    public boolean validPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;

        while (i < j) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else { //遇到不对称的字符
                return validPalindrome(i, j-1, s) || validPalindrome(i+1, j, s);
            }
        }
        return true;
    }

    public boolean validPalindrome(int l, int r, String s) {
        while (l < r) {
            if (s.charAt(l) == s.charAt(r)) {
                l++;
                r--;
            } else { //遇到不对称的字符
                return false;
            }
        }
        return true;
    }

}
