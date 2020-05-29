package com.gn.test.leet;

import java.util.*;

public class Rectangle {

    public static void main(String[] args) {
        int[] x = new int[]{9,10,9,-7,-4,-8,2,-6};
        for (int i : maxSlidingWindow(x, 5)) {
            System.out.println(i);
        }
    }

    public static int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        stack.push(-1);
        for (int i = 0; i < heights.length; i++) {
            if (stack.peek() == -1 || heights[i] >= heights[stack.peek()]) {
                stack.push(i);
                continue;
            }
            maxArea = Math.max(heights[stack.pop()] * (i - stack.peek() - 1), maxArea);
            i --;
        }
        int right = 0;
        while (!stack.isEmpty() && stack.peek() != -1) {
            if (right == 0) right = stack.peek() + 1;
            maxArea = Math.max(heights[stack.pop()] * (right - stack.peek() - 1), maxArea);
        }

        return maxArea;
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (k == 0) return new int[0];

        int len = nums.length;
//        int blockNum = len % k == 0 ? len / k : len / k + 1;
        int[] left = new int[len], right = new int[len];

        for (int i = 0 ; i < len; i ++) {
            left[i] = i % k == 0 ? nums[i] : Math.max(left[i-1], nums[i]);
        }

        for (int j = len - 1; j >= 0; j--) {
            right[j] = (j == len - 1 || (j + 1) % k == 0) ? nums[j] : Math.max(right[j+1], nums[j]);
        }

        int[] res = new int[len - k + 1];
        for (int i = 0; i < res.length; i++) {
            int leftPos = i+k-1;
            while (leftPos >= len) leftPos--;
            res[i] = Math.max(right[i], left[leftPos]);
        }

        return res;
    }

    public int largestRectangleArea4(int[] heights) {
        return calculateArea(heights, 0, heights.length - 1);
    }

    public int calculateArea(int[] heights, int l, int r) {
        if (l > r) return 0;
        if (l == r) return heights[l];

        int min = Integer.MAX_VALUE, minPos = 0;
        for (int i = l; i <= r; i++) {
            if (heights[i] < min) {
                min = heights[i];
                minPos = i;
            }
        }

        int lmax = calculateArea(heights, l, minPos - 1);
        int rmax = calculateArea(heights, minPos + 1, r);
        int subMax = Math.max(lmax, rmax);
        return Math.max(subMax, min * (r - l + 1));
    }

    public int largestRectangleArea3(int[] heights) {
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = i;j < heights.length; j++) {
                min = Math.min(heights[j], min);
                maxArea = Math.max((j - i + 1) * min, maxArea);
            }
        }

        return maxArea;
    }

    public int largestRectangleArea2(int[] heights) {
        Stack<Integer> left = new Stack<>();
        Stack<Integer> right = new Stack<>();

        int min = 0, minPos = 0;
        for (int i = 0; i < heights.length; i++) {

        }
        return 0;
    }
}
