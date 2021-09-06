package com.partition;

import com.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//95. 不同的二叉搜索树 II
public class GenerateTrees {
    public static void main(String[] args) {
        System.out.println(generateTrees(3));
    }

    public static List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new LinkedList<TreeNode>();
        }
        return generate(1, n);
    }



    //创建二叉搜索树
    public static List<TreeNode> generate(int start, int end) {
        List<TreeNode> allTrees = new ArrayList<>();
        if (start > end) {
            allTrees.add(null);
            return allTrees;
        }
        // 枚举可行根节点
        for (int i = start; i <= end ; i++) {
            List<TreeNode> leftTrees = generate(start, i - 1);// 获得所有可行的左子树集合
            List<TreeNode> rightTrees = generate(i + 1, end);//返回所有可行的右子树集合;

            // 从左子树集合中选出一棵左子树，从右子树集合中选出一棵右子树，拼接到根节点上
            for (TreeNode left : leftTrees) {
                for (TreeNode right : rightTrees) {
                    TreeNode currTree = new TreeNode(i);
                    currTree.left = left;
                    currTree.right = right;
                    allTrees.add(currTree);
                }
            }

        }

        return allTrees;
    }
}
