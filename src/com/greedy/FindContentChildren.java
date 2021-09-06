package com.greedy;

import java.util.Arrays;

//455. 分发饼干
public class FindContentChildren {

    public static void main(String[] args) {
        int[] g = new int[] {1, 2, 3};
        int[] s = new int[] {1, 1};

        System.out.println(findContentChildren(g, s));
    }

    public static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int count = 0;
        int numOfChildren = g.length, numOfCookies = s.length;
        for (int i = 0, j = 0; i < numOfChildren && j < numOfCookies; i++, j++) {
            while ( j < numOfCookies - 1 && g[i] > s[j] ) {
                j++;
            }
            if (j < numOfCookies) {
                count++;
            }
        }
        return count;
    }
}
