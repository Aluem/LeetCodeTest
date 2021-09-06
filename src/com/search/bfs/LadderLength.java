package com.search.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//127.最短单词路径
public class LadderLength {

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("hot");
        list.add("dot");
        list.add("dog");
        list.add("lot");
        list.add("log");
        list.add("cog");
        System.out.println(ladderLength("hit", "cog", list));
    }

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        boolean flag = false;
        for (String word : wordList) {
            if (word.equals(endWord)) {
                flag = true;
            }
        }
        if (!flag) {
            return 0;
        }
        int res = 1;
        boolean[] isVisit = new boolean[wordList.size()];
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        while (!queue.isEmpty()) {
            res++;
            int size = queue.size();
            while (size-- > 0) {
                String cur = queue.poll();
                for (int i = 0; i < wordList.size(); i++) {
                    int cnt = 0;
                    for (int j = 0; j < cur.length(); j++) {
                        if (wordList.get(i).charAt(j) != cur.charAt(j)) {
                            cnt++;
                        }
                    }
                    if (cnt == 1 && wordList.get(i).equals(endWord)) {
                        return res;
                    }
                    if (isVisit[i]) {
                        continue;
                    }
                    if (cnt == 1) {
                        isVisit[i] = true;
                        queue.offer(wordList.get(i));
                    }
                }
            }
        }
        return 0;
    }

//    //返回和当前字符串相差一个字符的单词
//    private static List<String> fulfil(String curWord, List<String> wordList) {
//        List<String> list = new LinkedList<>();
//        for (String word : wordList) {
//            int cnt = 0;
//            for (int i = 0; i < word.length(); i++) {
//                if (word.charAt(i) != curWord.charAt(i)) {
//                    cnt++;
//                }
//            }
//            if (cnt == 1) {
//                list.add(word);
//            }
//        }
//    }
}
