package com.arr;

//769. 最多能完成排序的块
public class MaxChunksToSorted {

    public static void main(String[] args) {
        int[] arr = new int[] {1,0,2,3,4};
        System.out.println(maxChunksToSorted(arr));
    }

    /*
        val = index 则可以自己分一组，否则需要从当前位置向后找到属于自己的下标构成一组,且前面不能有比当前值大的元素
        否则将要找到最大值的对应下标组成一队
     */
    public static int maxChunksToSorted(int[] arr) {
        int ans = 0; //分组数目
        int i = 0;
        while (i < arr.length) {
            if (arr[i] == i) {
                ans++; //值和下标一致，可以独立分组
                i++;
                continue;
            }
            int tmpMax = arr[i];
            //在构建的过程中，不可能出现下标大于值的可能
            while (i < tmpMax) { //tmpMax=1  -> tmpMax = 3
                i++; // i = 4
                tmpMax = Math.max(tmpMax, arr[i]);
            }
            //i=3
            ans++;
            i++;
        }
        return ans;
    }
}
