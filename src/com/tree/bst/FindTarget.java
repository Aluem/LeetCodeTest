package com.tree.bst;

import com.tree.TreeNode;

import java.util.HashSet;
import java.util.Set;

//653. 两数之和 IV - 输入 BST
public class FindTarget {
    Set<Integer> set = new HashSet<>();
    public boolean findTarget(TreeNode root, int k) {
        if (root == null) return false;
        if (set.contains(k - root.val)) {
            return true;
        }
        set.add(root.val);
        return findTarget(root.left, k) || findTarget(root.right, k);
    }
}
