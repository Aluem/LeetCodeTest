package com.binary_search;

//744. 寻找比目标字母大的最小字母
public class NextGreatestLetter {
    public char nextGreatestLetter(char[] letters, char target) {
        int l = 0, h = letters.length - 1;
        while (l <= h) { //边界条件待处理
            int mid = l + (h - l) / 2;
            if (letters[mid] <= target) {
                l = mid + 1;
            } else {
                h = mid - 1;
            }
        }
        return l >= letters.length ? letters[0] : letters[l];
    }
}
