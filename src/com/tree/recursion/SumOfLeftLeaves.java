package com.tree.recursion;

import com.tree.TreeNode;

//404. 左叶子之和
public class SumOfLeftLeaves {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode n9 = new TreeNode(9);
        TreeNode n20 = new TreeNode(20);
        TreeNode n15 = new TreeNode(15);
        TreeNode n7 = new TreeNode(7);
        root.left = n9;
        root.right = n20;
        n20.left = n15;
        n20.right = n7;

//        int i = new SumOfLeftLeaves().sumOfLeftLeaves(root);
//        System.out.println(i);
    }


    public int sumOfLeftLeaves(TreeNode root) {
        return root != null ? dfs(root) : 0;
    }

    public int dfs(TreeNode node) {
        int ans = 0;
        if (node.left != null) {
            ans += isLeafNode(node.left) ? node.left.val : dfs(node.left);
        }
        if (node.right != null && !isLeafNode(node.right)) {
            ans += dfs(node.right);
        }
        return ans;
    }

    public boolean isLeafNode(TreeNode node) {
        return node.left == null && node.right == null;
    }

//    public int sumOfLeftLeaves(TreeNode root) {
//        if (root == null) {
//            return 0;
//        }
//        return recursionSumOfLeftLeaves(root, 0);
//    }
//
//    public int recursionSumOfLeftLeaves(TreeNode node, int sum) {
//        if (node == null) {
//            return sum;
//        }
//        if (node.left != null) {
//            if (node.left.left == null && node.left.right == null) {
//                sum += node.left.val;
//            }
//        }
//
//       sum = recursionSumOfLeftLeaves(node.left, sum);
//        sum = recursionSumOfLeftLeaves(node.right, sum);
//        return sum;
//    }
}
