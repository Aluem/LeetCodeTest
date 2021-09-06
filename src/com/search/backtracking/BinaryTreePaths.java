package com.search.backtracking;

import com.tree.TreeNode;

import java.util.LinkedList;
import java.util.List;

//257. 二叉树的所有路径
public class BinaryTreePaths {
    public static void main(String[] args) {


    }

    public List<String> binaryTreePaths(TreeNode root) {
        LinkedList<String> res = new LinkedList<>();
        dfs(root, "", res);
        return res;
    }

    public void dfs(TreeNode node, String str, List<String> list) {
        if (node == null) return;
        StringBuilder s = new StringBuilder(str);
        if (node.left == null && node.right == null) { //当前结点为叶子结点
            s.append("->").append(node.val);
            if (s.length() > 2) {
               s.delete(0, 2);
            }
            list.add(s.toString());
            return;
        }
        s.append("->").append(node.val);
        dfs(node.left, s.toString(), list);
        dfs(node.right, s.toString(), list);
    }
}
