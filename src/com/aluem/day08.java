package com.aluem;

public class day08 {

    public String reverseVowels(String s) {
        int l = 0;
        int r = s.length() - 1;
        char temp;
        char[] words = s.toCharArray();
        while (l < r) {
            //从左边开始寻找元音字母
            if (!isVowel(words[l])) {
                l++;
            }
            //从右边寻找元音字母
            if (!isVowel(words[r])) {
                r--;
            }
            if (isVowel(words[l]) && isVowel(words[r])) {
                //交换位置
                temp = words[l];
                words[l] = words[r];
                words[r] = temp;
                l++;
                r--;
            }

        }
        return new String(words);
    }

    /**
     * 判断是否是元音
     */
    public boolean isVowel(char w) {
        if (w == 'a' || w == 'e' || w == 'i' || w == 'o' || w == 'u' || w == 'A' || w == 'E' || w == 'I' || w == 'O' ||
                w == 'U') {
            return true;
        } else {
            return false;
        }
    }
}
