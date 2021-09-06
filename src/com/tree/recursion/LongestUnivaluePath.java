package com.tree.recursion;

import com.tree.TreeNode;

//687. 最长同值路径
/*
    求树的最长同值路径
        需要求左树、右树的最长同值路径（求左右树根节点的最长同值路径）
        得到左右树最长同值路径，判断左树的最长、右树的最长、与当前根节点左右延申长度，返回最大值
 */
public class LongestUnivaluePath {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);

        TreeNode node2 = new TreeNode(1);

        TreeNode node3 = new TreeNode(1);
        TreeNode node4 = new TreeNode(1);

        TreeNode node5 = new TreeNode(1);
        TreeNode node6 = new TreeNode(1);
        TreeNode node7 = new TreeNode(1);
        root.right = node2;
        node2.left = node3;
        node2.right = node4;
        node3.left = node5;
        node3.right = node6;
        node4.left = node7;

        int i = new LongestUnivaluePath().longestUnivaluePath(root);
        System.out.println(i);
    }


    int ans = 0;
    public int longestUnivaluePath(TreeNode root) {
        arrowLength(root);
        return ans;
    }

    //求根节点同值左右延申的最长同值路径
    /*
        1.求根节点左节点左右延申的最长同值路径
        2.求根节点右节点左右延申的最长同值路径
        3.根节点最长同值路径 = 哪个节点的值与根节点相同 就加个哪个节点的最长同值路径的一个箭头（左右都有的情况需要去除一边）
     */
    private int arrowLength(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = arrowLength(node.left); //1.求根节点左节点左右延申的最长同值路径
        int right = arrowLength(node.right); //2.求根节点右节点左右延申的最长同值路径
        int leftArrow = 0, rightArrow = 0;  //3.根节点最长同值路径 = 哪个节点的值与根节点相同 就加个哪个节点的最长同值路径的一个箭头（左右都有的情况需要去除一边）
        if (node.left != null && node.left.val == node.val) {
            leftArrow = left + 1;
        }
        if (node.right != null && node.right.val == node.val) {
            rightArrow = right + 1;
        }
        //当前节点的最大同值路径与ans比较
        ans = Math.max(leftArrow + rightArrow, ans);
        //返回当前节点最长同值路径 要排除点当前节点，否则有可能为两条箭头
        return Math.max(leftArrow, rightArrow);
    }
}
