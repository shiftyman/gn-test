package com.gn.test;

import java.util.Arrays;

public class MainX {

    public static void main(String[] args) {
        int[] manager = new int[]{-1, 0, 0, 1};
        int[] inform = new int[]{1, 10, 0, 0};
        System.out.println(numOfMinutes2(0, manager, inform));
    }

    static class Node implements Comparable<Node> {
        private int index;
        private int parentIndex;

        public Node(int index, int parentIndex) {
            this.index = index;
            this.parentIndex = parentIndex;
        }

        @Override
        public int compareTo(Node o) {
            return parentIndex <= o.index ? 1 : -1;
        }
    }

    public static int numOfMinutes(int[] manager, int[] informTime){
        Node[] node = new Node[manager.length];
        for (int i = 0; i < manager.length; i++) {
            node[i] = new Node(i, manager[i]);
        }
        Arrays.sort(node);

        int[] min = new int[manager.length+1];
        int max = 0;
        for (int i = 0; i < manager.length; i++) {
            min[i+1] = informTime[node[i].index] + min[manager[i]+1];
            max = Math.max(min[i+1], max);
        }

        return max;
    }

    public static int numOfMinutes2(int headId, int[] manager, int[] informTime){
        return dfs(headId, informTime[headId], manager, informTime);
    }

    public static int dfs(int headId, int maxSum, int[] manager, int[] informTime){
        int maxMin = maxSum;
        for (int i = 0; i < manager.length; i++) {
            if (manager[i] == headId) {
                maxMin = Math.max(maxMin, dfs(i, maxSum + informTime[i], manager, informTime));
            }
        }
        return maxMin;
    }


}
