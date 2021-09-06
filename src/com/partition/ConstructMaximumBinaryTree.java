package com.partition;

import com.tree.TreeNode;

import java.util.Arrays;

//654. 最大二叉树
/*
    给定一个不含重复元素的整数数组 nums 。一个以此数组直接递归构建的 最大二叉树 定义如下：

    二叉树的根是数组 nums 中的最大元素。
    左子树是通过数组中 最大值左边部分 递归构造出的最大二叉树。
    右子树是通过数组中 最大值右边部分 递归构造出的最大二叉树。
    返回有给定数组 nums 构建的 最大二叉树 。
 */
public class ConstructMaximumBinaryTree {
    public static void main(String[] args) {
        int[] nums = new int[] {1,4,5,2,7,9,3};
        int maxIndex = getMaxIndex(nums, 2, 6);
        System.out.println(nums[maxIndex]);
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return constructMaximumBinaryTree(nums, 0, nums.length - 1);
    }

    //构造最大二叉树
    public TreeNode constructMaximumBinaryTree(int[] nums, int start, int end) {
        //base case
        if (start > end) {
            return null;
        }
        //1.获取当前数组的头
        int maxIdx = getMaxIndex(nums, start, end);
        //2.分
        // 构造当前头左边的最大二叉树
        TreeNode leftTree = constructMaximumBinaryTree(nums, start, maxIdx - 1);
        // 构造当前头右边的最大二叉树
        TreeNode rightTree = constructMaximumBinaryTree(nums, maxIdx + 1, end);
        //3.治
        TreeNode head = new TreeNode(nums[maxIdx]);
        head.left = leftTree;
        head.right = rightTree;
        return head;
    }

    //获取数组中最大值的下标
    private static int getMaxIndex(int[] nums, int start, int end) {
        int idx = start;
        for (int i = start + 1; i <= end; i++) {
            if (nums[i] > nums[idx])
                idx = i;
        }
        return idx;
    }
}
