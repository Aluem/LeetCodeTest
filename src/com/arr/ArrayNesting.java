package com.arr;

//565. 数组嵌套
public class ArrayNesting {

    public static void main(String[] args) {
        int[] arr = new int[] {5,4,0,3,1,6,2};
        System.out.println(arrayNesting(arr));
    }

    //不适用额外空间
    public static int arrayNesting(int[] nums) {
        int maxCnt = 0;
        int cnt = 0;
        //nums 存放的数为 0 ~ n - 1
        for (int i = 0; i < nums.length; i++) { //i : 1 ~ n - 1
            int tmp = i;
            while (nums[tmp] != Integer.MAX_VALUE) {
                cnt++;
                int next = nums[tmp];
                nums[tmp] = Integer.MAX_VALUE;
                tmp = next;
            }
            maxCnt = Math.max(maxCnt, cnt);
            cnt = 0;
        }
        return maxCnt;
    }

    //=========================================================
    /*
        思路：用数组记录已经访问过的节点（下标）
     */
//    public static int arrayNesting(int[] nums) {
//        int maxCnt = 0;
//        int cnt = 0;
//        int[] visited = new int[nums.length];
//        //nums 存放的数为 0 ~ n - 1
//        for (int i = 0; i < nums.length; i++) { //i : 1 ~ n - 1
//            int tmp = i;
//            while (visited[tmp] != 1) {
//                cnt++;
//                visited[tmp] = 1;
//                tmp = nums[tmp];
//            }
//            maxCnt = Math.max(maxCnt, cnt);
//            cnt = 0;
//        }
//        return maxCnt;
//    }
}
