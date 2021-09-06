package com.tree.recursion;

import com.tree.TreeNode;

//101. 对称二叉树
public class IsSymmetric {
    //是否为镜像树
    /* 如果root为空 则为镜像树
       如果root不为空，则判断左右子树是否镜像
            判断左右子树是否镜像的条件：
                遍历左右子树比较：左子树的左子节点 == 右子树的右子节点 && 左子树的右子节点 == 右子树的左子节点
     */

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return check(root.left, root.right);
    }

    private boolean check(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        }
        if (node1 == null || node2 == null || node1.val != node2.val) {
            return false;
        }
        //深度遍历检查是否满足镜像树条件
        return check(node1.left, node2.right) && check(node1.right, node2.left);
    }


}
