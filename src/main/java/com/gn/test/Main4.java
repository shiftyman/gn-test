package com.gn.test;

import java.util.Stack;

public class Main4 {

    public static void main(String[] args) {
        System.out.println(reverseWords("the sky is blue"));
    }

    public static String reverseWords(String s) {
        if (s == null || s.length() == 0) return s;

        Stack<Integer> stack = new Stack<>();
        int left = 0, right = s.length() - 1;
        while (left < s.length() && s.charAt(left) == ' ') {
            left++;
        }
        while (right > left && s.charAt(right) == ' ') {
            right--;
        }
        stack.push(left);

        while (left <= right) {
            while (left <= right && s.charAt(left) != ' ') {
                left++;
            }
            while (left <= right && s.charAt(left) == ' ') {
                left++;
            }
            stack.push(left);
        }

        int end = stack.pop();
        StringBuilder sb = new StringBuilder();
        while (stack.size() > 0) {
            int begin = stack.pop();
            sb.append(s, begin, end).append(" ");
            end = begin;
        }

        return sb.substring(0, sb.length() - 1);
    }
}
