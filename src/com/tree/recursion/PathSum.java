package com.tree.recursion;

import com.tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

//437. 路径总和 III
public class PathSum {
    int pathSum = 0;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        TreeNode right = new TreeNode(5);
        TreeNode node3 = new TreeNode(-3);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(2);
        TreeNode node6 = new TreeNode(11);
        TreeNode node7 = new TreeNode(3);
        TreeNode node8 = new TreeNode(-2);
        TreeNode node9 = new TreeNode(1);

        root.left = right;
        root.right = node3;
        right.left = node4;
        right.right = node5;
        node3.right = node6;
        node4.left = node7;
        node4.right = node8;
        node5.right = node9;

        int i = new PathSum().pathSum(root, 10);
        System.out.println(i);
    }
    public int pathSum(TreeNode root, int sum) {
        HashMap<Integer, Integer> prefixSumCount = new HashMap<>();
        prefixSumCount.put(0, 1); //target为0时的特殊情况
        int i = recursionPathSum(root, prefixSumCount, sum, 0);
        return i;
    }

    int count;

    private int recursionPathSum(TreeNode node, Map<Integer, Integer> prefixSumCount, int target, int currSum) {
        if (node == null) {
            return 0;
        }
        int res = 0;
        //当前节点前缀和
        currSum += node.val;
        //获取当前满足target值的路径数 特殊情况 target = 0
        res += prefixSumCount.getOrDefault(currSum - target, 0); // res  当前节点满足的个数
        //更新前缀和集合
        prefixSumCount.put(currSum, prefixSumCount.getOrDefault(currSum, 0) + 1);
        //递归左子树
        res += recursionPathSum(node.left, prefixSumCount, target, currSum); //res  当前节点加上左树共满足的个数
        //递归右子树
        res += recursionPathSum(node.right, prefixSumCount, target, currSum); //res 当前节点 左子树 右子树共满足的个数
        //回溯 清除当前路径的前缀和
        prefixSumCount.put(currSum, prefixSumCount.get(currSum) - 1);
        return res;
    }


//    private void recursionPathSum(TreeNode node, Map<Integer, Integer> prefixSumCount, int target, int currSum) {
//        if (node == null) {
//            return;
//        }
//        //当前节点前缀和
//        currSum += node.val;
//        //获取当前满足target值的路径数 特殊情况 target = 0
//        count += prefixSumCount.getOrDefault(currSum - target, 0);
//        //更新前缀和集合
//        prefixSumCount.put(currSum, prefixSumCount.getOrDefault(currSum, 0) + 1);
//        //递归左子树
//        recursionPathSum(node.left, prefixSumCount, target, currSum);
//        //递归右子树
//        recursionPathSum(node.right, prefixSumCount, target, currSum);
//        //回溯 清除当前路径的前缀和
//        prefixSumCount.put(currSum, prefixSumCount.get(currSum) - 1);
//    }

    //=================================================================
//    public int pathSum(TreeNode root, int sum) {
//        // key是前缀和, value是大小为key的前缀和出现的次数
//        Map<Integer, Integer> prefixSumCount = new HashMap<>();
//        // 前缀和为0的一条路径
//        prefixSumCount.put(0, 1);
//        // 前缀和的递归回溯思路
//        return recursionPathSum(root, prefixSumCount, sum, 0);
//    }
//
//    /**
//     * 前缀和的递归回溯思路
//     * 从当前节点反推到根节点(反推比较好理解，正向其实也只有一条)，有且仅有一条路径，因为这是一棵树
//     * 如果此前有和为currSum-target,而当前的和又为currSum,两者的差就肯定为target了
//     * 所以前缀和对于当前路径来说是唯一的，当前记录的前缀和，在回溯结束，回到本层时去除，保证其不影响其他分支的结果
//     * @param node 树节点
//     * @param prefixSumCount 前缀和Map
//     * @param target 目标值
//     * @param currSum 当前路径和
//     * @return 满足题意的解
//     */
//    private int recursionPathSum(TreeNode node, Map<Integer, Integer> prefixSumCount, int target, int currSum) {
//        // 1.递归终止条件
//        if (node == null) {
//            return 0;
//        }
//        // 2.本层要做的事情
//        int res = 0;
//        // 当前路径上的和
//        currSum += node.val;
//
//        //---核心代码
//        // 看看root到当前节点这条路上是否存在节点前缀和加目标值target为当前前缀和currSum的路径  有可能不只一条
//        res += prefixSumCount.getOrDefault(currSum - target, 0);
//        // 更新路径上当前节点前缀和的个数
//        prefixSumCount.put(currSum, prefixSumCount.getOrDefault(currSum, 0) + 1);
//        //---核心代码
//
//        // 3.进入下一层
//        res += recursionPathSum(node.left, prefixSumCount, target, currSum);
//        res += recursionPathSum(node.right, prefixSumCount, target, currSum);
//
//        // 4.回到本层，恢复状态，去除当前节点的前缀和数量
//        prefixSumCount.put(currSum, prefixSumCount.get(currSum) - 1);
//        return res;
//    }
//=================================================================
//    public int pathSum(TreeNode root, int sum) {
//        //1.查找当前节点是否有路径和与目标值相等
//        if (root == null) {
//            return 0;
//        }
//        //当前根节点的所有路径
//        hasPathSum(root, sum);
//        //2.左子树
//        pathSum(root.left, sum);
//        //3.右子树
//        pathSum(root.right, sum);
//        return pathSum;
//    }
//
//    public void hasPathSum(TreeNode root, int sum) {
//        //1.查找当前节点是否有路径和与目标值相等
//        if (root == null) {
//            return;
//        }
//
//        hasPathSum(root.left, sum - root.val);
//        if (root.val == sum) {
//            pathSum++;
//        }
//        hasPathSum(root.right, sum - root.val);
//
//    }
//
//    public static void prePrint(TreeNode root) {
//        if (root == null) return;
//        prePrint(root.left);
//        System.out.print(root.val + " ");
//        prePrint(root.right);
//    }


}
