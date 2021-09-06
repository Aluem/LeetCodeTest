package com.tree.bst.bt;

import com.tree.TreeNode;

//236. 二叉树的最近公共祖先
public class LowestCommonAncestor {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //root是p或q的祖先
        if (root == null || root == p || root == q) return root;
        //求左树是否包含p或q 返回p或q
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        //求右树
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        //左树没有p和q
        if (left == null) return right;
        //右树没有p和q
        if (right == null) return left;
        //当 left 和 right 同时不为空 ：说明 p,q 分列在root 的 异侧 （分别在 左 / 右子树），因此 root 为最近公共祖先，返回 root ；
        return root;
    }


}
