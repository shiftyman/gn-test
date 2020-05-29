package com.gn.test.leet;

import java.util.LinkedList;
import java.util.List;

class NQueue {
    public static void main(String[] args) {
        NQueue nQueue = new NQueue();
        List<List<String>> res = nQueue.solveNQueens(3);
        res.forEach((x->{
            x.forEach(s-> System.out.print(s));
        }));
    }

    private int[] col, pie, na;

    private List<List<String>> result;

    public List<List<String>> solveNQueens(int n) {
        result = new LinkedList<>();
        col = new int[n];
        pie = new int[2*n];
        na = new int[2*n];
        doSolve(0, n, new LinkedList<>());
        return result;
    }

    public void doSolve(int n, int max, LinkedList<String> solution) {
        // find one solution
        if (n >= max) {
            result.add((List<String>) solution.clone());
            return;
        }

        // 每一列放置queue
        for (int i = 0; i < max; i++) {
            if (col[i] == 1) {
                continue;
            }

            if (pie[i+n] == 1) {
                continue;
            }

            if (na[n-i+max] == 1) {
                continue;
            }

            col[i] = 1;
            pie[i+n] = 1;
            na[n-i+max] = 1;
            solution.add(generateRowString(i, max));
            doSolve(n+1, max, solution);
            // revert
            solution.remove(solution.size() - 1);
            col[i] = 0;
            pie[i+n] = 0;
            na[n-i+max] = 0;
        }
    }

    private String generateRowString(int pos, int max) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < max; i ++) {
            if (i == pos)
                sb.append("Q");
            else
                sb.append(".");
        }
        return sb.toString();
    }
}
