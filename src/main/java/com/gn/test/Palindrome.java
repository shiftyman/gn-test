package com.gn.test;

public class Palindrome {

    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
    }

    public static String longestPalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }

        int left = 0, right = 0, length = 0;
        for (int i = 0; i < s.length(); i++) {
            int len = Math.max(palidromeLen(s, i, i), palidromeLen(s, i, i+1));
            if (len > length) {
                left = i - (len - 1) / 2;
                right = i + len / 2;
                length = len;
            }
        }

        return s.substring(left, right+1);
    }

    public static int palidromeLen(String s, int left, int right) {
        for (; left >= 0 && right < s.length(); left--, right++) {
            if (s.charAt(left) != s.charAt(right)) {
                break;
            }
        }

        return right - left - 1;
    }
}
