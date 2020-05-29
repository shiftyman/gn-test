package com.gn.test;

public class Palindrome2 {

    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
    }

    public static String longestPalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }

        boolean[][] dp = new boolean[s.length()][s.length()];

        int length = 0, l = 0, r = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < s.length() - i; j++) {
                if (s.charAt(j) == s.charAt(j+i) && (i < 2 || dp[j+1][j+i-1])) {
                    dp[j][j+i] = true;
                    if (i > length) {
                        length = i;
                        l = j;
                        r= j + i;
                    }
                }
            }
        }

        return s.substring(l, r+1);
    }
}
