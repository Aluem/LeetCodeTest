package com.sort;

import java.util.*;

//出现频率最多的 k 个元素
public class TopKFrequentElements {
    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3,3,3,3,3,5,5,2,4,4,4,4,4,4,6,2,4,9};
        int k = 2;
        TopKFrequentElements topKFrequentElements = new TopKFrequentElements();
        int[] arr = topKFrequentElements.topKFrequent(nums, k);
        System.out.printf(Arrays.toString(arr));
    }

    public int[] topKFrequent(int[] nums, int k) {
        // 获取每个值出现的次数
        Map<Integer, Integer> frequencyForNum = new HashMap<>();
        for (int num : nums) {
            frequencyForNum.put(num, frequencyForNum.getOrDefault(num, 0) + 1);
        }
        //获取最大的出现次数
        int max = 0;
        for (Integer value : frequencyForNum.values()) {
            if (value > max) {
                max = value;
            }
        }
        // 出现次数为1的元素在桶1 创建桶
        List<Integer>[] buckets = new ArrayList[max + 1];
        for (int key : frequencyForNum.keySet()) {
            int frequency = frequencyForNum.get(key);
            if (buckets[frequency] == null) {
                buckets[frequency] = new ArrayList<>();
            }
            //在对应出现次数的桶上添加元素
            buckets[frequency].add(key);
        }

        int[] topK = new int[k];
        for (int i = max, top = k; i > 0 && top > 0; i--) {
            while (top > 0 && buckets[i] != null && buckets[i].size() > 0) {
                Integer r = buckets[i].remove(buckets[i].size() - 1);
                topK[top - 1] = r;
                top--;
            }
        }
        return topK;
    }

}
