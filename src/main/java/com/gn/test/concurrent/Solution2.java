package com.gn.test.concurrent;

import javafx.util.Pair;

import java.util.*;

class Solution2 {
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {

        int L = beginWord.length();

        HashMap<String, ArrayList<String>> allComboDict = new HashMap<String, ArrayList<String>>();

        wordList.forEach(
                word -> {
                    for (int i = 0; i < L; i++) {
                        String newWord = word.substring(0, i) + '*' + word.substring(i + 1, L);
                        ArrayList<String> transformations =
                                allComboDict.getOrDefault(newWord, new ArrayList<String>());
                        transformations.add(word);
                        allComboDict.put(newWord, transformations);
                    }
                });

        class Item {
            public String word;
            public int time;

            public Item(String word, int time) {
                this.word = word;
                this.time = time;
            }
        }
        Queue<Item> Q = new LinkedList<>();
        Q.add(new Item(beginWord, 1));

        HashMap<String, Boolean> visited = new HashMap<String, Boolean>();
        visited.put(beginWord, true);

        int time = 0;
        while (!Q.isEmpty()) {
            Item node = Q.remove();
            String word = node.word;
            int level = node.time;
            for (int i = 0; i < L; i++) {

                String newWord = word.substring(0, i) + '*' + word.substring(i + 1, L);

                for (String adjacentWord : allComboDict.getOrDefault(newWord, new ArrayList<String>())) {
                    if (adjacentWord.equals(endWord)) {
                        return level + 1;
                    }
                    if (!visited.containsKey(adjacentWord)) {
                        visited.put(adjacentWord, true);
                        System.out.println(++time);
                        Q.add(new Item(adjacentWord, level + 1));
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