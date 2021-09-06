package com.greedy;

//605. 种花问题
public class CanPlaceFlowers {

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        int m = flowerbed.length;
        int prev = -1;
        for (int i = 0; i < m; i++) {
            if (flowerbed[i] == 1) {
                if (prev < 0) {
                    count += i / 2;
                } else {
                    count += (i - prev - 2) / 2;
                }
                if (count >= n) return true;
                prev = i;
            }
        }
        //若全部是0
        if (prev < 0) {
            count += (m + 1) / 2;
        } else {
            //得到最后一个1
            count += (m - prev - 1) / 2;
        }
        return count >= n;
    }

//    public boolean canPlaceFlowers(int[] flowerbed, int n) {
//        int cnt = 0;
//
//        for (int i = 0; i < flowerbed.length && cnt < n; i++) {
//            if (flowerbed[i] == 0) {
//                if (i - 1 < 0 && i + 1 < flowerbed.length && flowerbed[i + 1] == 0) {
//                    flowerbed[i] = 1;
//                    cnt++;
//                } else
//                if (i - 1 < 0 && i + 1 >= flowerbed.length) {
//                    flowerbed[i] = 1;
//                    cnt++;
//                } else
//                if (i - 1 >= 0 && i + 1 < flowerbed.length && flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0) {
//                    flowerbed[i] = 1;
//                    cnt++;
//                } else
//                if (i - 1 >= 0 && i + 1 >= flowerbed.length && flowerbed[i - 1] == 0) {
//                    flowerbed[i] = 1;
//                    cnt++;
//                }
//            }
//        }
//        return cnt >= n;
//    }
}
