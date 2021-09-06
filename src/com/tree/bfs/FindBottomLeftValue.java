package com.tree.bfs;

import com.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

//513. 找树左下角的值
public class FindBottomLeftValue {

    /**
     * 从右往左bfs遍历
     * @param root
     * @return
     */
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            root = queue.poll();
            if (root.right != null) queue.add(root.right);
            if (root.left != null) queue.add(root.left);
        }
        return root.val;
    }

    /*
        遍历整棵树 找到最后一行的第一个元素
     */
//    public int findBottomLeftValue(TreeNode root) {
//        Queue<TreeNode> queue = new LinkedList<>();
//        int enLevelLeftVal = 0;
//        queue.add(root);
//        while (!queue.isEmpty()) {
//            int size = queue.size();
//            for (int i = 0; i < size; i++) {
//                TreeNode tmp = queue.poll();
//                if (i == 0) { //当前行最左边的值
//                    enLevelLeftVal = tmp.val;
//                }
//                if (tmp.left != null) {
//                    queue.add(tmp.left);
//                }
//                if (tmp.right != null) {
//                    queue.add(tmp.right);
//                }
//            }
//        }
//        return enLevelLeftVal;
//    }
}
