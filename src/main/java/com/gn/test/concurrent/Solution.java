package com.gn.test.concurrent;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

class Solution {
    public int minMutation(String start, String end, String[] bank) {
        Set<String> bankSet = new HashSet<>(Arrays.asList(bank));
        if (start.length() != end.length() || !bankSet.contains(end)) {
            return -1;
        }

        char[] mus = new char[]{'A','C','G','T'};
        Set<String> front = new HashSet<>();
        Set<String> tail = new HashSet<>();
        front.add(start);
        tail.add(end);

        Set<String> visited = new HashSet<>();
        int level = 0;
        while (front.size() > 0 && tail.size() > 0) {
            if (front.size() > tail.size()) {
                Set<String> tmp = front;
                front = tail;
                tail = tmp;
            }

            Set<String> newLevel = new HashSet<>();
            for (String mu : front) {
                char[] chars = mu.toCharArray();
                for (int i = 0; i < chars.length; i++) {
                    for (char c : mus) {
                        char tmp = chars[i];
                        chars[i] = c;
                        String newMu = new String(chars);
                        chars[i] = tmp;

                        if (!bankSet.contains(newMu)) {
                            continue;
                        }

                        if (tail.contains(newMu)) {
                            return level + 1;
                        }

                        if (!visited.contains(newMu)) {
                            visited.add(newMu);
                            newLevel.add(newMu);
                        }
                    }
                }

            }

            front = newLevel;
            level++;
        }

        return -1;
    }

    public static void main(String[] args) {

    }
}