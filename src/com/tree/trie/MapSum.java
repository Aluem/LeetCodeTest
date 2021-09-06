package com.tree.trie;

//677. 键值映射
public class MapSum {

    private class Node {
        Node[] child = new Node[26];
        int value;
    }

    private Node root = new Node();

    /** Initialize your data structure here. */
    public MapSum() {

    }

    public void insert(String key, int val) {
        if (this.root == null) return;
        if (key.length() == 0) this.root.value = val;
        Node cur = this.root;
        for (int i = 0; i < key.length(); i++) {
            char ch = key.charAt(i);
            int index = ch - 'a';
            if (cur.child[index] == null) {
                cur.child[index] = new Node();
            }
            cur = cur.child[index];
        }
        cur.value = val;
    }

    public int sum(String prefix) {
        Node node = searchPrefix(prefix);
        return sum(prefix, node);
    }

    public int sum(String prefix, Node node) {
        int sum = 0;
        if (node == null) return 0;
        sum = node.value;
        for (int i = 0; i < node.child.length; i++) { //求所有子节点的和
            sum += sum(prefix, node.child[i]);
        }
        return sum;
    }

    private Node searchPrefix(String prefix) {
        Node cur = this.root;
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            int index = ch - 'a';
            if (cur.child[index] == null) {
                return null;
            }
            cur = cur.child[index];
        }
        return cur;
    }
}
