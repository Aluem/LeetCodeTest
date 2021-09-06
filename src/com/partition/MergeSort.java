package com.partition;

import java.util.Arrays;

//归并排序
public class MergeSort {
    public static void main(String[] args) {
        int arr[] = { 8, 4, 5, 7, 1, 3, 6, 2 };
        mergeSort(arr, 0, arr.length - 1);
        System.out.println("归并排序后=" + Arrays.toString(arr));
    }

    public static void mergeSort(int[] arr, int left, int right) {
        if (left >= right) return;
        int mid = left + (right - left) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, mid, right);

    }

    public static void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int tmpL = left;
        int i = 0;
        int tmpMid = mid + 1;
        while (i < temp.length) {
            if (left > mid) {
                temp[i] = arr[tmpMid];
                tmpMid++;
            } else if (tmpMid > right) {
                temp[i] = arr[left];
                left++;
            } else { //int arr[] = { 8, 4, 5, 7, 1, 3, 6, 2 };
                if (arr[left] < arr[tmpMid]) {
                    temp[i] = arr[left];
                    left++;
                } else {
                    temp[i] = arr[tmpMid];
                    tmpMid++;
                }
            }
            i++;
        }
        for (int j = 0; j < temp.length; j++) {
            arr[tmpL + j] = temp[j] ;
        }
    }
}
