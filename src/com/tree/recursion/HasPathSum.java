package com.tree.recursion;

import com.tree.TreeNode;

//112. 路径总和
public class HasPathSum {

//    public boolean hasPathSum(TreeNode root, int sum) {
//        if (root == null) {
//            return false;
//        }
//        Queue<TreeNode> queNode = new LinkedList<TreeNode>();
//        Queue<Integer> queVal = new LinkedList<Integer>();
//        queNode.offer(root);
//        queVal.offer(root.val);
//        while (!queNode.isEmpty()) { //队列不为空则继续循环
//            TreeNode now = queNode.poll(); //返回头节点
//            int temp = queVal.poll();
//            if (now.left == null && now.right == null) { //叶子节点
//                if (temp == sum) {
//                    return true;
//                }
//                continue;
//            }
//            if (now.left != null) {
//                queNode.offer(now.left);
//                queVal.offer(now.left.val + temp);
//            }
//            if (now.right != null) {
//                queNode.offer(now.right);
//                queVal.offer(now.right.val + temp);
//            }
//        }
//        return false;
//    }

    //==================================================================
//    int curSum = 0;
//
//    public boolean hasPathSum(TreeNode root, int targetSum) {
//        if (root == null) {
//            return false;
//        }
//        curSum = curSum + root.val;
//        if (root.left == null && root.right == null) {
//            return curSum == targetSum;
//        }
//        boolean b = hasPathSum(root.left, targetSum);
//        if (root.left != null) {
//            curSum = curSum - root.left.val; //回溯
//        }
//        boolean b2 = hasPathSum(root.right, targetSum);
//        if (root.right != null) {
//            curSum = curSum - root.right.val;
//        }
//        return b || b2;
//    }
    //==================================================================
    //减法
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return root.val == sum;
        }
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
}
