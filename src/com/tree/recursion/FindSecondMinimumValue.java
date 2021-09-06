package com.tree.recursion;

import com.tree.TreeNode;

public class FindSecondMinimumValue {

    public int findSecondMinimumValue(TreeNode root) {
        //空节点和叶子节点作为根节点，没有第二小的值
        if (root == null || (root.left == null && root.right == null)) {
            return -1;
        }
        //不存在只有一个节点为null的情况 细节：有可能两边的节点都等于当前节点，需要递归两边
        int leftVal = root.left.val;
        int rightVal = root.right.val;
        //值相等节点树的第二小
        if (leftVal == root.val) leftVal = findSecondMinimumValue(root.left);
        if (rightVal == root.val) rightVal = findSecondMinimumValue(root.right);
        if (leftVal == -1 && rightVal != -1) return rightVal;
        if (leftVal != -1 && rightVal == -1) return leftVal;
        return Math.min(leftVal, rightVal); //两个都为-1 或 两个都不为-1
    }

    /*
        找树的第二小的节点 即找 与当前节点值相等的节点为根节点的树的第二小的值 与另外一个节点的值比较
        细节：有可能两边的节点都等于当前节点，需要递归两边
        root.val = min(root.left.val, root.right.val) 总成立。
     */
//    public int findSecondMinimumValue(TreeNode root) {
//        //空节点和叶子节点作为根节点，没有第二小的值
//        if (root == null || (root.left == null && root.right == null)) {
//            return -1;
//        }
//        //不存在只有一个节点为null的情况 细节：有可能两边的节点都等于当前节点，需要递归两边
//        if (root.left.val == root.val && root.right.val == root.val) {
//            //找到左树第二小的和右树第二小的，取小的
//            int secMinLeft = findSecondMinimumValue(root.left);
//            int secMinRight = findSecondMinimumValue(root.right);
//            if (secMinLeft == -1 && secMinRight != -1) {
//                return secMinRight;
//            }
//            if (secMinLeft != -1 && secMinRight == -1) {
//                return secMinLeft;
//            }
//            return Math.min(secMinLeft, secMinRight);
//        }
//        TreeNode sameValNode = root.left.val == root.val ? root.left : root.right;
//        TreeNode otherValNode = root.left.val == root.val ? root.right : root.left;
//        int secMini = findSecondMinimumValue(sameValNode);
//        if (secMini == -1 && otherValNode.val != root.val) {
//            return otherValNode.val;
//        }
//        return Math.min(secMini, otherValNode.val);
//    }
}
