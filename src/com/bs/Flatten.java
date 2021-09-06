package com.bs;

import com.tree.TreeNode;

import java.util.LinkedList;
import java.util.List;

//114. 二叉树展开为链表
public class Flatten {
    List<TreeNode> list = new LinkedList<>();
    public void flatten(TreeNode root) {
        preorder(root);
        for (int i = 1; i < list.size(); i++) {
            TreeNode pre = list.get(i - 1), cur = list.get(i);
            pre.right = cur;
            pre.left = null;
        }
    }

    private void preorder(TreeNode node) {
        if (node != null) {
            list.add(node);
            preorder(node.left);
            preorder(node.right);
        }
    }
}
