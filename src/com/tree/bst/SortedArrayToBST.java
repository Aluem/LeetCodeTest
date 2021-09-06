package com.tree.bst;

import com.tree.TreeNode;

//108. 将有序数组转换为二叉搜索树
public class SortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        return createBST(nums, 0, nums.length - 1);
    }

    private TreeNode createBST(int[] nums, int l, int r) {
        if (l > r) return null;
        int rootIndex = (l + r) / 2;
        TreeNode root = new TreeNode(nums[rootIndex]);
        root.left = createBST(nums, l, rootIndex - 1);
        root.right = createBST(nums, rootIndex + 1, r);
        return root;
    }


}
