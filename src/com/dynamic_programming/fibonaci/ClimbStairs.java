package com.dynamic_programming.fibonaci;

//70. 爬楼梯
public class ClimbStairs {

    public static void main(String[] args) {
        ClimbStairs climbStairs = new ClimbStairs();
        int recursion = climbStairs.climbStairs(3);
        System.out.println(recursion);
    }

    public int climbStairs(int n) {
        int[] d = new int[n + 1];
        d[0] = 1;
        for (int i = 1; i <= n; i++) {
            int cnt = 0;
            if (i - 1 >= 0) { //i==1 cnt=d[0]=1 d[1]=1   i==2 cnt=d[1]=1 cnt+=d[0]=2 d[2]=2
                // i==3 cnt=d[2]=2 cnt+=d[1]=3 d[3]=3    i == 3
                cnt = d[i - 1];
            }
            if (i - 2 >= 0) {
                cnt += d[i - 2];
            }
            d[i] = cnt;
        }
        return d[n];
    }
}
