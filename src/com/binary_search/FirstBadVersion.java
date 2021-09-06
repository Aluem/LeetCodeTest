package com.binary_search;

//278. 第一个错误的版本
public class FirstBadVersion extends VersionControl{
    public int firstBadVersion(int n) {
        int l = 1, h = n;
        while (l < h) {
            int mid = l + (h - l) / 2;
            if (isBadVersion(mid)) {
                h = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}

abstract class VersionControl {
    boolean isBadVersion(int version) {
        return false;
    }
}
