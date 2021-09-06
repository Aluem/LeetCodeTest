package com.tree.trie;

//208. 实现 Trie (前缀树)
/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
public class Trie {

//    public static void main(String[] args) {
//        Trie trie = new Trie();
//        trie.insert("apple");
//        System.out.println(trie.getMaxPrefix("app"));
//
//        System.out.println(trie.search("apple"));
//
//        System.out.println(trie.search("app"));
//        System.out.println(trie.startsWith("app"));
//        trie.insert("app");
//        System.out.println(trie.search("app"));
//
//
//
////        Trie t = new Trie("t");
////        Trie a = new Trie("a");
////        Trie i = new Trie("i");
////        Trie te = new Trie("te");
////        Trie ted = new Trie("ted");
////        trie.tries['t' - 97] = t;
////        trie.tries['a' - 97] = a;
////        trie.tries['i' - 97] = i;
////        t.tries['e' - 97] = te;
////        te.tries['d' - 97] = ted;
//
////        System.out.println(trie.startsWith("a"));
////        System.out.println(trie.getMaxPrefix("1t1e11"));
////
////        System.out.println("tem".substring(0, 3));
////
////        System.out.println((int)'a');
//
////        System.out.println(te.tries[100 - 97]); //d
////
////        System.out.println(trie.startsWith("ted")); //true
////        System.out.println(trie.startsWith("teda"));  //false
////        trie.insert("teda");
////        System.out.println(trie.startsWith("teda")); //true
////        System.out.println(ted.tries[0]);
//
//    }
    // ========================官方解答======================================
    private Trie[] children;
    private boolean isEnd;

    public Trie() {
        children = new Trie[26];
        isEnd = false;
    }

    public void insert(String word) {
        Trie node = this;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            int index = ch - 'a';
            if (node.children[index] == null) {
                node.children[index] = new Trie();
            }
            node = node.children[index];
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        Trie node = searchPrefix(word);
        return node != null && node.isEnd;
    }

    public boolean startsWith(String prefix) {
        return searchPrefix(prefix) != null;
    }

    private Trie searchPrefix(String prefix) {
        Trie node = this;
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            int index = ch - 'a';
            if (node.children[index] == null) {
                return null;
            }
            node = node.children[index];
        }
        return node;
    }


    // ==============================================================
//    String word = null;
//    private Trie[] tries = null;
//    int isAdd = -1; //判断当前节点是否添加过
//
//    /**
//     * Initialize your data structure here.
//     */
//    public Trie() {
//        tries = new Trie[26];
//    }
//
//    public Trie(String word) {
//        this();
//        this.word = word;
//    }
//
//    /**
//     * Inserts a word into the trie.
//     */
//    public void insert(String word) {
//        Trie maxPrefix = getMaxPrefix(word);
//        if (word.equals(maxPrefix.word)) {
//            maxPrefix.isAdd = 1;
//            return; //已经存在
//        }
//        //从最大匹配前缀长度后面开始添加  已有的te   待添加的 word ： tema
//        int matchLength = 0;
//        if (maxPrefix.word != null) {
//            matchLength = maxPrefix.word.length();//已经匹配到的长度 2
//        }
//        Trie cur = maxPrefix;
//        for (int i = matchLength; i < word.length(); i++) { // matchLength:2  word.length():4 添加两个元素
//            char c = word.charAt(i);
//            cur.tries[c - 97] = new Trie(word.substring(0, i) + c);
//            cur = cur.tries[c - 97];
//        }
//        cur.isAdd = 1;
//    }
//
//    /**
//     * Returns if the word is in the trie.
//     */
//    public boolean search(String word) {
//        if (word == null) return true;
//        Trie maxPrefix = getMaxPrefix(word);
//        if (word.equals(maxPrefix.word) && maxPrefix.isAdd == 1) return true;
//        return false;
//    }
//
//    /**
//     * Returns if there is any word in the trie that starts with the given prefix.
//     */
//    public boolean startsWith(String prefix) {
//        if (prefix == null) return true;
//        Trie maxPrefix = getMaxPrefix(prefix);
//        return prefix.equals(maxPrefix.word);
//    }
//
//    //获取满足当前字符串的最长前缀节点
//    public Trie getMaxPrefix(String prefix) {
//        int index = 0;
//        Trie cur = this;
//        while (index < prefix.length() && cur.tries[prefix.charAt(index) - 97] != null) {//存在当前字符结尾的子节点
//            cur = cur.tries[prefix.charAt(index) - 97];//有当前前缀
//            index++;
//        }
//        return cur;
//    }
//
//    @Override
//    public String toString() {
//        return "Trie{" +
//                "word='" + word + "}";
//    }
}


/*
    public boolean startsWith(String prefix) {
        if (prefix == null) return true;
        Trie maxPrefix = getMaxPrefix(prefix);
        return prefix.equals(maxPrefix.word);
//        int index = 0;
//        Trie cur = this;
//        while (cur.tries.length != 0 && index < prefix.length()) {
//            boolean flag = false;
//            for (Trie trie : cur.tries) {
//                if (trie != null && prefix.substring(0, index + 1).equals(trie.word)) {
//                    cur = trie;//有当前前缀
//                    flag = true;
//                    break;
//                }
//            }
//            index++;
//            if (!flag) { //子节点没有当前前缀
//                return false;
//            }
//        }
//        return true;
    }
 */