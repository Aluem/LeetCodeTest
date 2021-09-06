package com.one_quest_per_day;

import java.util.HashSet;
import java.util.Set;

//345. 反转字符串中的元音字母
public class ReverseVowels_21_08_19 {
    public static void main(String[] args) {
        String s1 = new String("aaa");
        String s2 = new String("aaa");
        System.out.println(s1 == s2);           // false
        String s3 = s1.intern();
        String s4 = s2.intern();
        System.out.println(s3 == s1);

        String[] s = new String[3];
        s[2] = "aaa";
        String e = s[2];
        s[2] = null;
        System.out.println(e);
        System.out.println(s[2]);
    }
}
