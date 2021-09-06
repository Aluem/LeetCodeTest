package com.tree.recursion;

import com.tree.TreeNode;

//543.二叉树的直径
public class DiameterOfBinaryTree {
    public static void main(String[] args) {

    }

    int ans;
    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return ans;
    }
    public int depth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = depth(node.left); //左树深度
        int right = depth(node.right); //右树深度
        int depth = Math.max(left, right) + 1;//当前树深度
        ans = Math.max((left + right), ans);//最大路径

        return depth;
    }

//    public int diameterOfBinaryTree(TreeNode root) {
//        if (root == null) {
//            return 0;
//        }
//        //左儿子为根的树的深度
//        int left = maxDepth(root.left);
//        //右儿子为根的树的深度
//        int right = maxDepth(root.right);
//        //left + right 就是以root为根二叉树的直径
//
//        //返回当前树的直径、左子树的直径、右子树的直径的最大值
//        return Math.max((maxDepth(root.left) + maxDepth(root.right)), Math.max(diameterOfBinaryTree(root.left), diameterOfBinaryTree(root.right)));
//    }
//
//    public int maxDepth(TreeNode root) {
//        if (root == null) {
//            return 0;
//        }
//        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
//    }
}
