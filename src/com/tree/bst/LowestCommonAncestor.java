package com.tree.bst;

import com.tree.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//235. 二叉搜索树的最近公共祖先
public class LowestCommonAncestor {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //两个目标值都小于当前节点，查找左子树
        if (p.val < root.val && q.val < root.val) root = lowestCommonAncestor(root.left, p, q);
        //两个目标值都大于当前节点，查找右子树
        if (p.val > root.val && q.val > root.val) root = lowestCommonAncestor(root.right, p, q);
        //都相等或者一个大于一个小于
        return root;
    }
    //=========================================================

//    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//        List<TreeNode> pathP = new ArrayList<>();
//        List<TreeNode> pathQ = new ArrayList<>();
//        findNodeVal(root, p, pathP);
//        findNodeVal(root, q, pathQ);
//        TreeNode ans = null;
//        //寻找list1 list2最后一个相同的值
//        for (int i = 0; i < pathP.size() && i < pathQ.size(); i++) {
//            if (pathP.get(i) == pathQ.get(i)) {
//                ans = pathP.get(i);
//            } else {
//                continue;
//            }
//        }
//        return ans;
//    }
//
//    //寻找一个节点，返回寻找经过的路径的倒序
//    public void findNodeVal(TreeNode root, TreeNode node, List<TreeNode> list) {
//        list.add(root);
//        //目标值等于当前节点值 停止寻找
//        if (node.val == root.val) return;
//        //目标值大于当前节点的值 向右找
//        if (node.val > root.val) findNodeVal(root.right, node, list);
//        //目标值小于当前节点的值 向左找
//        if (node.val < root.val) findNodeVal(root.left, node, list);
//    }
}
