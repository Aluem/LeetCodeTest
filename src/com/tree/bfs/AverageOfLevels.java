package com.tree.bfs;

import com.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageOfLevels {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode node9  = new TreeNode(9 );
        TreeNode node20 = new TreeNode(20);
        TreeNode node15 = new TreeNode(15);
        TreeNode node7  = new TreeNode(7 );
        root.left = node9;
        root.right = node20;
        node20.left = node15;
        node20.right = node7;

        System.out.println(new AverageOfLevels().averageOfLevels(root));
    }

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> averages = new ArrayList<Double>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            double sum = 0;
            int size = queue.size();
            for (int i = 0; i < size; i++) { //取出当前层的所有元素
                //存入下一层的所有元素
                TreeNode tmp = queue.poll();
                sum += tmp.val;
                if (tmp.left != null) {
                    queue.add(tmp.left);
                }
                if (tmp.right != null) {
                    queue.add(tmp.right);
                }
            }
            averages.add(sum / size);
        }
        return averages;
    }

//    public List<Double> averageOfLevels(TreeNode root) {
//        if (root == null) {
//            return null;
//        }
//        int currFloor = 0;//当前层个数
//        int nextFloor = 0; //下一层个数
//        double sum = 0.0;
//        //链表存放节点值
//        Queue<TreeNode> queue = new LinkedList();
//        queue.add(root);
//        currFloor = 1;
//        TreeNode tmp = null;
//        List<Double> list = new ArrayList<>();
//
//        do {
//            nextFloor = 0;
//            for (int i = 0; i < currFloor; i++) { //统计当前层总和
//                tmp = queue.poll();
//                sum += tmp.val;
//                //将左、右节点值入队
//                if (tmp.left != null) {
//                    queue.add(tmp.left);
//                    nextFloor++;
//                }
//                if (tmp.right != null) {
//                    queue.add(tmp.right);
//                    nextFloor++;
//                }
//            }
//            //求当前层平均值，并加入list
//            list.add(sum / currFloor);
//            //sum归零
//            sum = 0;
//            //将下一层的个数赋给当前层，计算下一层
//            currFloor = nextFloor;
//        } while (nextFloor != 0); //下一层没有元素时退出
//        return list;
//    }

    //bds
    public void bfs(TreeNode root) {
        //链表存放节点值
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        TreeNode tmp = null;
        while (queue.size() != 0) {
            tmp = queue.poll();
            //将左、右节点值入队
            if (tmp.left != null) {
                queue.add(tmp.left);
            }
            if (tmp.right != null) {
                queue.add(tmp.right);
            }
            System.out.print(tmp.val + " ");
        }
    }
}
