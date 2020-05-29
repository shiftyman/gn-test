package com.gn.test.concurrent;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedDeque;

public class Te {

    //https://leetcode-cn.com/problems/word-ladder/
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (beginWord.length() != endWord.length()) {
            return 0;
        }

        class Item {
            public String word;
            public int time;

            public Item(String word, int time) {
                this.word = word;
                this.time = time;
            }
        }
        Queue<Item> queue = new LinkedList<>();
        queue.add(new Item(beginWord, 1));
        int time = 0;
        for (Item wd = queue.poll(); wd != null; wd = queue.poll()) {
            for (int i = 0; i < wd.word.length(); i++) {
                for (int j = 0; j < wordList.size(); j++) {
                    String newWord = wd.word.substring(0,i) + wordList.get(j).charAt(i) + wd.word.substring(i+1);
                    if (endWord.equals(newWord)) {
                        return wd.time + 1;
                    }

                    if (wordList.contains(newWord)) {
                        System.out.println(++time);
                        queue.add(new Item(newWord, wd.time + 1));
                    }
                }
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList(new String[]{"hot", "dot", "dog", "lot", "log", "cog"});

        long t = System.nanoTime();
        System.out.println(ladderLength(beginWord, endWord, wordList));
        System.out.println(System.nanoTime() - t);
    }
}
