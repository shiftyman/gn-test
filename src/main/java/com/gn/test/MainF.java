package com.gn.test;

import java.util.Stack;

public class MainF {

    public static void main(String[] args) {
        System.out.println(largestRectangleArea(new int[]{2,1,5,6,2,3}));
    }

    public static int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                maxArea = Math.max(heights[stack.pop()] * (i - (stack.size()>0 ? stack.peek()+1:0)), maxArea);
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            maxArea = Math.max(heights[stack.pop()] * (heights.length-(stack.size()>0 ? stack.peek()+1:0)), maxArea);
        }
        return maxArea;
    }


}