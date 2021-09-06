package com.string;

//9. 回文数
public class IsPalindrome {
    public static void main(String[] args) {
        System.out.println(12321 / 1 % 10);
        System.out.println(12321 / 10 % 10);
        System.out.println(12321 / 100 % 10);
        System.out.println(12321 / 1000 % 10);
        System.out.println(12321 / 10000 % 10);
        System.out.println(new IsPalindrome().isPalindrome(12121));
    }

    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        int reverse = 0;
        while (reverse < x) {
            reverse = reverse * 10 + x % 10;
            x = x / 10;
        }
        return x == reverse || x == reverse / 10;
    }

//    public boolean isPalindrome(int x) {
//        String s = x + "";
//        int l = 0; int r = s.length() - 1;
//        while (l < r) {
//            if (s.charAt(l++) != s.charAt(r--)) {
//                return false;
//            }
//        }
//        return true;
//    }
}
