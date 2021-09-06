package com.tree.recursion;

import com.tree.TreeNode;

//572. 另一个树的子树
public class IsSubtree {
    public static void main(String[] args) {
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeleft = new TreeNode(1);
        TreeNode treeright = new TreeNode(2);

        TreeNode treeNode42 = new TreeNode(4);
        TreeNode treeleft2 = new TreeNode(1);
        TreeNode treeright2 = new TreeNode(4);

        treeNode4.left = treeleft;
        treeNode4.right = treeright;

        treeNode42.left = treeleft2;
        treeNode42.right = treeright2;

        IsSubtree isSubtree = new IsSubtree();
        isSubtree.isSubtree(treeleft, treeleft2);
    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) {
            return false;
        }
       return isEquals(root, subRoot) || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    //判断两棵树是否相同
    private boolean isEquals(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) {
            return true;
        }
        if (root == null || subRoot == null || root.val != subRoot.val) {
            return false;
        }
        return isEquals(root.left, subRoot.left) && isEquals(root.right, subRoot.right);
    }
}
